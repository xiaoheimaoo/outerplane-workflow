package com.helpshift.user;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.HelpshiftEvent;
import com.helpshift.HelpshiftUserLoginEventsListener;
import com.helpshift.chat.HSEventProxy;
import com.helpshift.concurrency.HSThreadingService;
import com.helpshift.log.HSLogger;
import com.helpshift.network.HSNetwork;
import com.helpshift.network.HSRequest;
import com.helpshift.network.HSRequestData;
import com.helpshift.network.HSResponse;
import com.helpshift.network.HTTPTransport;
import com.helpshift.network.NetworkUtils;
import com.helpshift.network.POSTNetwork;
import com.helpshift.network.PUTNetwork;
import com.helpshift.network.RetryNetworkWithNewToken;
import com.helpshift.network.UserManagerProxy;
import com.helpshift.network.exception.HSRootApiException;
import com.helpshift.network.exception.NetworkException;
import com.helpshift.notification.CoreNotificationManager;
import com.helpshift.notification.HSPushTokenManager;
import com.helpshift.platform.Device;
import com.helpshift.poller.ConversationPoller;
import com.helpshift.poller.FetchNotificationUpdate;
import com.helpshift.poller.SimplePoller;
import com.helpshift.storage.HSGenericDataManager;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.user.error.InvalidDataErrorReason;
import com.helpshift.user.error.UserLoginFailureReason;
import com.helpshift.user_lifecyle.UserLifecycleListener;
import com.helpshift.util.ConsumeOnceListener;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import com.helpshift.util.ValuePair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UserManager implements UserManagerProxy {
    public static final String APP_ATTRIBUTES = "app_attributes";
    public static final String ERROR = "error";
    public static final String LOGIN_CALL_ALREADY_IN_PROGRESS = "login call already in progress";
    private static final String TAG = "UsrMngr";
    private static final Set<String> usersNotFound = new HashSet();
    private final AnonymousUser anonymousUser;
    private ConversationPoller conversationPoller;
    private final Device device;
    private FetchNotificationUpdate fetchNotificationUpdate;
    private final HSGenericDataManager genericDataManager;
    private final HSEventProxy hsEventProxy;
    private final HSThreadingService hsThreadingService;
    private final HTTPTransport httpTransport;
    private SimplePoller identityDataSyncPoller;
    private final CoreNotificationManager notificationManager;
    private final HSPersistentStorage persistentStorage;
    private final HSPushTokenManager pushTokenManager;
    private final Map<String, WeakReference<UserLifecycleListener>> userLifecycleListeners = new HashMap();
    private AtomicBoolean isLoginCallInProgress = new AtomicBoolean(false);
    private AtomicBoolean dataSyncCallProgress = new AtomicBoolean(false);
    private final AtomicBoolean loginOnSessionExpiryMarker = new AtomicBoolean(false);
    protected BaseUser currentUser = initiateLoggedInUser();

    public UserManager(HSPersistentStorage hSPersistentStorage, HSPushTokenManager hSPushTokenManager, HSGenericDataManager hSGenericDataManager, HSThreadingService hSThreadingService, CoreNotificationManager coreNotificationManager, HTTPTransport hTTPTransport, Device device, HSEventProxy hSEventProxy) {
        this.persistentStorage = hSPersistentStorage;
        this.genericDataManager = hSGenericDataManager;
        this.pushTokenManager = hSPushTokenManager;
        this.hsThreadingService = hSThreadingService;
        this.notificationManager = coreNotificationManager;
        this.httpTransport = hTTPTransport;
        this.device = device;
        this.hsEventProxy = hSEventProxy;
        this.anonymousUser = new AnonymousUser(hSPersistentStorage);
    }

    private BaseUser initiateLoggedInUser() {
        AnonymousUser anonymousUser = new AnonymousUser(this.persistentStorage);
        try {
            if (Utils.isEmpty(this.persistentStorage.getActiveUser())) {
                return anonymousUser;
            }
            String string = this.persistentStorage.getString(UserConstants.ACTIVE_USER_DATA);
            return (Utils.isNotEmpty(string) && JsonUtils.isValidJsonString(string)) ? getUserFromType(new JSONObject(string).optInt(UserConstants.USER_TYPE, 0)) : anonymousUser;
        } catch (Exception e) {
            HSLogger.e(TAG, "Error initializing user", e);
            return anonymousUser;
        }
    }

    public BaseUser getCurrentUser() {
        return this.currentUser;
    }

    public void setConversationPoller(ConversationPoller conversationPoller) {
        this.conversationPoller = conversationPoller;
    }

    public void setIdentityDataSyncPoller(SimplePoller simplePoller) {
        this.identityDataSyncPoller = simplePoller;
        startIdentityDataSyncPoller("user_init");
    }

    public void setFetchNotificationUpdateFunction(FetchNotificationUpdate fetchNotificationUpdate) {
        this.fetchNotificationUpdate = fetchNotificationUpdate;
    }

    private void sendLoginEventToUserLifecycle() {
        for (Map.Entry<String, WeakReference<UserLifecycleListener>> entry : this.userLifecycleListeners.entrySet()) {
            if (entry.getValue().get() != null) {
                entry.getValue().get().onUserDidLogin();
            }
        }
    }

    private void sendLogoutEventToUserLifecycle() {
        for (Map.Entry<String, WeakReference<UserLifecycleListener>> entry : this.userLifecycleListeners.entrySet()) {
            if (entry.getValue().get() != null) {
                entry.getValue().get().onUserDidLogout();
            }
        }
    }

    public boolean retryPushTokenSync() {
        if (isPushTokenSynced() || !shouldPoll() || Utils.isEmpty(this.persistentStorage.getCurrentPushToken())) {
            return false;
        }
        this.pushTokenManager.registerPushTokenWithBackend(this, this.persistentStorage.getCurrentPushToken(), getActiveUserDataForNetworkCall(), new UpdatePushSyncStatus(this));
        return true;
    }

    public void registerPushToken(final String str) {
        if (Utils.isEmpty(str) || !shouldSyncPushToken(str)) {
            return;
        }
        boolean z = Utils.isNotEmpty(str) && !str.equals(this.persistentStorage.getCurrentPushToken());
        this.pushTokenManager.savePushToken(str);
        setPushTokenSynced(false);
        Map<String, String> userLoginInfo = this.currentUser.getUserLoginInfo();
        if (!(isUserDataNeededForNetworkCall() && Utils.isEmpty(userLoginInfo)) && z && shouldPoll()) {
            this.hsThreadingService.getNetworkService().submit(new Runnable() { // from class: com.helpshift.user.UserManager.1
                @Override // java.lang.Runnable
                public void run() {
                    FetchNotificationUpdate fetchNotificationUpdate = UserManager.this.fetchNotificationUpdate;
                    UserManager userManager = UserManager.this;
                    fetchNotificationUpdate.execute(Utils.ORIGIN_REGISTER_PUSH_TOKEN, userManager.getHashForUser(userManager.currentUser));
                    if (UserManager.this.shouldPoll()) {
                        HSPushTokenManager hSPushTokenManager = UserManager.this.pushTokenManager;
                        UserManager userManager2 = UserManager.this;
                        hSPushTokenManager.registerPushTokenWithBackend(userManager2, str, userManager2.getActiveUserDataForNetworkCall(), new UpdatePushSyncStatus(UserManager.this));
                    }
                }
            });
        }
    }

    private void clearAnonymousUserOnLogin() {
        if (getClearAnonymousUserOnLoginFlag()) {
            this.anonymousUser.removeAnonymousUser();
            generateAndSaveAnonymousUserIdIfNeeded();
            this.persistentStorage.retainAnonUidForIdentityUser("");
        }
    }

    public void removeAnonymousUser() {
        this.anonymousUser.removeAnonymousUser();
    }

    private BaseUser getUserFromType(int i) {
        if (i == 0) {
            return new OldLoginUser(this.persistentStorage);
        }
        if (i == 1) {
            return new UserWithIdentity(this.persistentStorage);
        }
        if (i == 2) {
            return new AnonymousUserWithIdentity(this.persistentStorage);
        }
        return new AnonymousUser(this.persistentStorage);
    }

    void onNewLoginSuccess(Map<String, String> map, Map<String, Object> map2, boolean z, boolean z2) {
        this.conversationPoller.stopPoller();
        stopIdentityDataSyncPoller("new_login");
        if (isPushTokenSynced()) {
            deregisterPushTokenOrLogout(this.currentUser instanceof UserWithIdentity);
        }
        boolean z3 = this.currentUser instanceof AnonymousUserWithIdentity;
        int intValue = ((Integer) map2.get(UserConstants.USER_TYPE)).intValue();
        this.currentUser = getUserFromType(intValue);
        this.persistentStorage.shouldAllowUserSessionExpiryAlerts(intValue == 1 || intValue == 2);
        boolean z4 = this.currentUser instanceof AnonymousUserWithIdentity;
        if (!z3 || !z4) {
            clearAnonymousUserOnLogin();
        }
        this.persistentStorage.retainAnonUidForIdentityUser((String) Utils.getOrDefault(map, AnonymousUserWithIdentity.ANONYMOUS_USER_WITH_IDENTITY_ID, ""));
        if (!z || !z2) {
            cleanUpActiveUser(this.currentUser);
        }
        collectAndStoreSDKCollectibleAttributes();
        this.persistentStorage.setActiveUser(new JSONObject(map).toString());
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            this.currentUser.setUserDataValues(entry.getKey(), entry.getValue());
        }
        startIdentityDataSyncPoller(FirebaseAnalytics.Event.LOGIN);
        sendLoginEventToUserLifecycle();
        this.loginOnSessionExpiryMarker.set(true);
        startNotificationUpdatesSync(this.currentUser, Utils.ORIGIN_LOGIN_WITH_USER);
    }

    private void logoutUserWithBackend() {
        BaseUser baseUser = this.currentUser;
        if (baseUser instanceof UserWithIdentity) {
            try {
                final HSRequestData requestDataForLogout = NetworkUtils.getRequestDataForLogout(this.persistentStorage, (UserWithIdentity) baseUser, this.device);
                final POSTNetwork pOSTNetwork = new POSTNetwork(this.httpTransport, NetworkUtils.getLogoutRoute(this.persistentStorage));
                this.hsThreadingService.getNetworkService().submit(new Runnable() { // from class: com.helpshift.user.UserManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            pOSTNetwork.makeRequest(requestDataForLogout);
                        } catch (Exception e) {
                            HSLogger.e(UserManager.TAG, "Netowrk Error in logging out user", e);
                        }
                    }
                });
            } catch (Exception e) {
                HSLogger.e(TAG, "Error in logging out user", e);
            }
        }
    }

    private void deregisterPushTokenOrLogout(boolean z) {
        if (!z) {
            this.pushTokenManager.deregisterPushTokenForUser(this, getActiveUserDataForNetworkCall(), new UpdatePushSyncStatus(this));
        } else if (isPushTokenSynced()) {
            logoutUserWithBackend();
        }
    }

    public synchronized void startIdentityDataSyncPoller(String str) {
        if (!(this.currentUser instanceof UserWithIdentity)) {
            HSLogger.d(TAG, "User is not of identity type, not starting polling for data: source: " + str);
            return;
        }
        if (this.identityDataSyncPoller != null) {
            HSLogger.d(TAG, "Starting identity data sync poller: " + str);
            this.identityDataSyncPoller.start();
        }
    }

    public synchronized void stopIdentityDataSyncPoller(String str) {
        if (this.identityDataSyncPoller != null) {
            HSLogger.d(TAG, "Stopping identity data sync poller: " + str);
            this.identityDataSyncPoller.stop();
        }
    }

    public boolean scheduleAttributeDataSyncPoller() {
        if (!(this.currentUser instanceof UserWithIdentity)) {
            HSLogger.d(TAG, "User is not of identity type, not polling for data");
            return false;
        }
        triggerIdentityAttributeSync();
        return true;
    }

    public void scanRefreshTokenExpiry() {
        if ((this.currentUser instanceof AnonymousUser) && this.persistentStorage.isUserSessionExpiryAlertsAllowed()) {
            this.hsEventProxy.sendEvent(HelpshiftEvent.USER_SESSION_EXPIRED, null);
        } else if ((this.currentUser instanceof UserWithIdentity) && isRefreshTokenInExpiryAlertPeriod()) {
            this.hsEventProxy.sendEvent(HelpshiftEvent.REFRESH_USER_CREDENTIALS, null);
        }
    }

    boolean isRefreshTokenInExpiryAlertPeriod() {
        return (System.currentTimeMillis() / 1000) - ((Number) this.currentUser.getUserDataValue(UserConstants.REFRESH_TOKEN_START_TIME_SECONDS, 0)).longValue() > ((Number) this.currentUser.getUserDataValue(UserConstants.REFRESH_TOKEN_TTL, 0)).longValue() - UserConstants.REFRESH_TOKEN_EXPIRY_ALERT_PERIOD_SECONDS;
    }

    private void requestLoginWithIdentity(final Map<String, String> map, final Map<String, Object> map2, final Map<String, Object> map3, final boolean z, final boolean z2, final HelpshiftUserLoginEventsListener helpshiftUserLoginEventsListener) {
        if (this.isLoginCallInProgress.get()) {
            HSLogger.d(TAG, "Login already in progress");
            helpshiftUserLoginEventsListener.onLoginFailure(UserLoginFailureReason.LOGIN_IN_PROGRESS, null);
            return;
        }
        String platformId = this.persistentStorage.getPlatformId();
        String deviceId = this.device.getDeviceId();
        Map<String, String> buildHeaderMap = NetworkUtils.buildHeaderMap(this.device, platformId);
        HashMap hashMap = new HashMap(Utils.getStringMapFromObjectMap(map2));
        hashMap.put("did", deviceId);
        final HSRequestData hSRequestData = new HSRequestData(buildHeaderMap, hashMap);
        final POSTNetwork pOSTNetwork = new POSTNetwork(this.httpTransport, NetworkUtils.getLoginWithIdentityRoute(this.persistentStorage));
        this.isLoginCallInProgress = this.hsThreadingService.getNetworkService().submit(new Runnable() { // from class: com.helpshift.user.UserManager.3
            @Override // java.lang.Runnable
            public void run() {
                UserManager.this.handleLoginNetworkCall(hSRequestData, pOSTNetwork, map2, map, map3, z, z2, helpshiftUserLoginEventsListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoginNetworkCall(HSRequestData hSRequestData, HSNetwork hSNetwork, Map<String, Object> map, Map<String, String> map2, Map<String, Object> map3, boolean z, boolean z2, HelpshiftUserLoginEventsListener helpshiftUserLoginEventsListener) {
        try {
            HSLogger.d(TAG, "Triggering network call to login identity user: " + map);
            HSResponse makeRequest = hSNetwork.makeRequest(hSRequestData);
            JSONObject jSONObject = new JSONObject(makeRequest.getResponseString());
            int status = makeRequest.getStatus();
            if (makeRequest.isNetworkCallSuccess()) {
                handleSuccessfulLoginResponse(jSONObject, map2, map3, z, z2, helpshiftUserLoginEventsListener);
                return;
            }
            try {
                handleErrorResponse(status, jSONObject, helpshiftUserLoginEventsListener);
            } catch (Exception e) {
                e = e;
                HSLogger.e(TAG, "Requesting identity login failed", e);
                helpshiftUserLoginEventsListener.onLoginFailure(UserLoginFailureReason.UNKNOWN_ERROR, null);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void handleSuccessfulLoginResponse(JSONObject jSONObject, Map<String, String> map, Map<String, Object> map2, boolean z, boolean z2, HelpshiftUserLoginEventsListener helpshiftUserLoginEventsListener) {
        map2.put(UserConstants.ACCESS_TOKEN, jSONObject.optString(UserConstants.ACCESS_TOKEN, ""));
        map2.put(UserConstants.REFRESH_TOKEN, jSONObject.optString(UserConstants.REFRESH_TOKEN, ""));
        map2.put(UserConstants.REFRESH_TOKEN_TTL, Long.valueOf(jSONObject.optLong(UserConstants.REFRESH_TOKEN_TTL, 0L)));
        map2.put(UserConstants.REFRESH_TOKEN_START_TIME_SECONDS, Long.valueOf(System.currentTimeMillis() / 1000));
        onNewLoginSuccess(map, map2, z, z2);
        helpshiftUserLoginEventsListener.onLoginSuccess();
    }

    private void handleErrorResponse(int i, JSONObject jSONObject, HelpshiftUserLoginEventsListener helpshiftUserLoginEventsListener) {
        if (i == 400) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (!JsonUtils.isEmpty(optJSONObject)) {
                handleSpecificErrorCases(optJSONObject, helpshiftUserLoginEventsListener);
                return;
            }
            HSLogger.e(TAG, "Login Network call failed due to invalid data");
            helpshiftUserLoginEventsListener.onLoginFailure(UserLoginFailureReason.NETWORK_ERROR, null);
        } else if (i == 403) {
            HSLogger.e(TAG, "Login Network call failed since identity feature is not enabled");
            helpshiftUserLoginEventsListener.onLoginFailure("identityFeatureNotEnabled", null);
        } else {
            HSLogger.e(TAG, "Login Network call failed with code " + i);
            helpshiftUserLoginEventsListener.onLoginFailure(UserLoginFailureReason.NETWORK_ERROR, null);
        }
    }

    private void handleSpecificErrorCases(JSONObject jSONObject, HelpshiftUserLoginEventsListener helpshiftUserLoginEventsListener) {
        JSONArray optJSONArray = jSONObject.optJSONArray("invalid-identities");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("invalid-identity-tokens");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("missing-fields");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("invalid-fields");
        if (!JsonUtils.isEmpty(optJSONArray3) || !JsonUtils.isEmpty(optJSONArray4)) {
            HSLogger.e(TAG, "Unknown error in network response");
            helpshiftUserLoginEventsListener.onLoginFailure(UserLoginFailureReason.NETWORK_ERROR, null);
        } else if (!JsonUtils.isEmpty(optJSONArray2)) {
            HSLogger.e(TAG, "Login Network call failed due to invalid identity token");
            helpshiftUserLoginEventsListener.onLoginFailure("identityTokenInvalid", null);
        } else if (!JsonUtils.isEmpty(optJSONArray)) {
            List<String> listFromJsonArrayString = JsonUtils.listFromJsonArrayString(optJSONArray.toString());
            HashMap hashMap = new HashMap();
            for (String str : listFromJsonArrayString) {
                hashMap.put(str, InvalidDataErrorReason.INVALID_DATA);
            }
            HSLogger.e(TAG, "Login Network call failed since identities are invalid");
            helpshiftUserLoginEventsListener.onLoginFailure(UserLoginFailureReason.IDENTITIES_DATA_INVALID, hashMap);
        } else {
            helpshiftUserLoginEventsListener.onLoginFailure(UserLoginFailureReason.NETWORK_ERROR, null);
        }
    }

    public void loginWithIdentity(String str, Map<String, Object> map, HelpshiftUserLoginEventsListener helpshiftUserLoginEventsListener) {
        InternalUserLoginEventListener internalUserLoginEventListener = new InternalUserLoginEventListener(this.hsThreadingService, helpshiftUserLoginEventsListener);
        if (!str.isEmpty() && !Utils.isJWTValid(str, this.device)) {
            internalUserLoginEventListener.onLoginFailure("identityTokenInvalid", null);
            return;
        }
        List<InternalIdentity> arrayList = new ArrayList<>();
        boolean isFullPrivacyEnabled = isFullPrivacyEnabled(map);
        if (!Utils.isEmpty(str)) {
            JSONObject jsonObjectFromJwt = Utils.getJsonObjectFromJwt(this.device, str);
            if (JsonUtils.isEmpty(jsonObjectFromJwt)) {
                HSLogger.d(TAG, "Empty json object in token");
                internalUserLoginEventListener.onLoginFailure("identityTokenInvalid", null);
                return;
            } else if (jsonObjectFromJwt.optLong("iat", 0L) == 0) {
                HSLogger.d(TAG, "iat is mandatory in token");
                internalUserLoginEventListener.onLoginFailure("iatIsMandatory", null);
                return;
            } else {
                arrayList = IdentityValidationUtil.getIdentitiesFromTokenJsonObject(jsonObjectFromJwt);
                ValuePair<String, Map<String, String>> validateIdentitiesForLogin = IdentityValidationUtil.validateIdentitiesForLogin(arrayList, isFullPrivacyEnabled);
                if (validateIdentitiesForLogin != null) {
                    HSLogger.d(TAG, "Validation failed for identities " + validateIdentitiesForLogin.first);
                    internalUserLoginEventListener.onLoginFailure(validateIdentitiesForLogin.first, validateIdentitiesForLogin.second);
                    return;
                }
            }
        }
        ValuePair<String, Map<String, String>> validateLoginConfig = IdentityValidationUtil.validateLoginConfig(map);
        if (validateLoginConfig != null) {
            HSLogger.d(TAG, "Validation failed for login config " + validateLoginConfig.first);
            internalUserLoginEventListener.onLoginFailure(validateLoginConfig.first, validateLoginConfig.second);
            return;
        }
        if (!map.containsKey(UserConstants.FULL_PRIVACY_ENABLED)) {
            map.put(UserConstants.FULL_PRIVACY_ENABLED, false);
        }
        Map<String, String> activeUserDataFromIdentities = getActiveUserDataFromIdentities(arrayList, str);
        Map<String, Object> userDataFromLoginConfig = getUserDataFromLoginConfig(map, str);
        Map<String, Object> userDataForComparison = getUserDataForComparison(activeUserDataFromIdentities, map);
        boolean isRefreshTokenInExpiryAlertPeriod = isRefreshTokenInExpiryAlertPeriod();
        boolean isUserSame = this.currentUser.isUserSame(userDataForComparison);
        if ((this.currentUser instanceof UserWithIdentity) && !isRefreshTokenInExpiryAlertPeriod && isUserSame) {
            internalUserLoginEventListener.onLoginSuccess();
            return;
        }
        if (shouldGenerateAnonIdForUserWithIdentity(str, isFullPrivacyEnabled, arrayList)) {
            activeUserDataFromIdentities.put(AnonymousUserWithIdentity.ANONYMOUS_USER_WITH_IDENTITY_ID, generateAndAddAnonIdInActiveUserMap(userDataForComparison, isUserSame, ((Integer) Utils.getOrDefault(userDataFromLoginConfig, UserConstants.USER_TYPE, -1)).intValue()));
        }
        requestLoginWithIdentity(activeUserDataFromIdentities, getNetworkConfigFromLoginConfigAndIdentityJwt(activeUserDataFromIdentities, map, str), userDataFromLoginConfig, isRefreshTokenInExpiryAlertPeriod, isUserSame, internalUserLoginEventListener);
    }

    private boolean isFullPrivacyEnabled(Map<String, Object> map) {
        try {
            return ((Boolean) Utils.getOrDefault(map, UserConstants.FULL_PRIVACY_ENABLED, false)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    private Map<String, String> getActiveUserDataFromIdentities(List<InternalIdentity> list, String str) {
        HashMap hashMap = new HashMap();
        if (!Utils.isEmpty(list)) {
            hashMap.put(UserWithIdentity.IDENTITIES_HASH_LIST, InternalIdentityUtils.getHashForIdentities(list).toString());
            hashMap.put(UserWithIdentity.IDENTITIES_SIGNATURE, Utils.getSignatureFromJwtToken(str));
        }
        return hashMap;
    }

    private boolean shouldGenerateAnonIdForUserWithIdentity(String str, boolean z, List<InternalIdentity> list) {
        if (Utils.isEmpty(str)) {
            return true;
        }
        return z && !InternalIdentityUtils.isIdentifierPresent(list, "uid");
    }

    private String generateAndAddAnonIdInActiveUserMap(Map<String, Object> map, boolean z, int i) {
        String retainedAnonUidForIdentityUser = this.persistentStorage.getRetainedAnonUidForIdentityUser();
        return (Utils.isEmpty(retainedAnonUidForIdentityUser) || (!z && !isNewUserSameBeforeExpiry(map, i))) ? generateAnonymousUserId() : retainedAnonUidForIdentityUser;
    }

    public boolean isNewUserSameBeforeExpiry(Map<String, Object> map, int i) {
        Map<String, Object> jsonStringToMap = JsonUtils.jsonStringToMap(this.persistentStorage.getLastLoggedOutUser());
        if ((this.currentUser instanceof AnonymousUser) && !jsonStringToMap.isEmpty()) {
            if (((Integer) Utils.getOrDefault(jsonStringToMap, UserConstants.USER_TYPE, -1)).intValue() == i) {
                return IdentityValidationUtil.isNewIdentityUserSame(map, jsonStringToMap);
            }
            return false;
        }
        return false;
    }

    private Map<String, Object> getUserDataForComparison(Map<String, String> map, Map<String, Object> map2) {
        HashMap hashMap = new HashMap();
        hashMap.put(UserConstants.FULL_PRIVACY_ENABLED, Utils.getOrDefault(map2, UserConstants.FULL_PRIVACY_ENABLED, false));
        hashMap.put(UserWithIdentity.IDENTITIES_HASH_LIST, Utils.getOrDefault(map, UserWithIdentity.IDENTITIES_HASH_LIST, ""));
        hashMap.put(UserWithIdentity.IDENTITIES_SIGNATURE, Utils.getOrDefault(map, UserWithIdentity.IDENTITIES_SIGNATURE, ""));
        return hashMap;
    }

    private Map<String, Object> getUserDataFromLoginConfig(Map<String, Object> map, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(UserConstants.USER_TYPE, Integer.valueOf(Utils.isEmpty(str) ? 2 : 1));
        hashMap.put(UserConstants.USER_LOGIN_CONFIG, new JSONObject(map).toString());
        return hashMap;
    }

    private Map<String, Object> getNetworkConfigFromLoginConfigAndIdentityJwt(Map<String, String> map, Map<String, Object> map2, String str) {
        HashMap hashMap = new HashMap(map2);
        if (Utils.isEmpty(str)) {
            str = "";
        }
        hashMap.put(UserWithIdentity.IDENTITY_TOKEN, str);
        String str2 = (String) Utils.getOrDefault(map, AnonymousUserWithIdentity.ANONYMOUS_USER_WITH_IDENTITY_ID, "");
        if (Utils.isNotEmpty(str2)) {
            hashMap.put(AnonymousUserWithIdentity.ANONYMOUS_USER_WITH_IDENTITY_ID, str2);
        }
        return hashMap;
    }

    public void login(Map<String, String> map) {
        HashMap hashMap = new HashMap(map);
        if (Utils.isEmpty(hashMap)) {
            HSLogger.e(TAG, "Empty data for user login");
            return;
        }
        BaseUser baseUser = this.currentUser;
        if ((baseUser instanceof OldLoginUser) && baseUser.isUserSame(hashMap)) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(UserConstants.USER_TYPE, 0);
        onNewLoginSuccess(map, hashMap2, false, false);
    }

    public void logout(boolean z) {
        if (this.currentUser instanceof AnonymousUser) {
            return;
        }
        if (z) {
            this.persistentStorage.retainAnonUidForIdentityUser("");
        }
        saveLoggedOutUser(z);
        this.persistentStorage.shouldAllowUserSessionExpiryAlerts(!z);
        stopIdentityDataSyncPoller("logout");
        this.conversationPoller.stopPoller();
        deregisterPushTokenOrLogout(this.currentUser instanceof UserWithIdentity);
        cleanUpActiveUser(this.currentUser);
        this.currentUser = this.anonymousUser;
        sendLogoutEventToUserLifecycle();
        startNotificationUpdatesSync(this.currentUser, Utils.ORIGIN_LOGIN_WITH_ANONYMOUS_USER);
    }

    private void saveLoggedOutUser(boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (z) {
            this.persistentStorage.saveLoggedOutUser(jSONObject.toString());
            return;
        }
        jSONObject.put(UserConstants.USER_TYPE, this.currentUser.getUserDataValue(UserConstants.USER_TYPE, -1));
        jSONObject.put(UserConstants.FULL_PRIVACY_ENABLED, isFullPrivacyEnabled(JsonUtils.jsonStringToMap((String) this.currentUser.getUserDataValue(UserConstants.USER_LOGIN_CONFIG, ""))));
        Map<String, String> userLoginInfo = this.currentUser.getUserLoginInfo();
        jSONObject.put(UserWithIdentity.IDENTITIES_HASH_LIST, Utils.getOrDefault(userLoginInfo, UserWithIdentity.IDENTITIES_HASH_LIST, ""));
        jSONObject.put(UserWithIdentity.IDENTITIES_SIGNATURE, Utils.getOrDefault(userLoginInfo, UserWithIdentity.IDENTITIES_SIGNATURE, ""));
        this.persistentStorage.saveLoggedOutUser(jSONObject.toString());
    }

    public void sessionExpiryLogoutWhenSDKIsOpen() {
        HSLogger.d(TAG, "session expired when SDK is open " + isRefreshTokenInExpiryAlertPeriod());
        this.loginOnSessionExpiryMarker.set(false);
        this.hsEventProxy.sendEvent(HelpshiftEvent.USER_SESSION_EXPIRED, null);
        Utils.executeWithDelay(new Runnable() { // from class: com.helpshift.user.UserManager.4
            @Override // java.lang.Runnable
            public void run() {
                if (!UserManager.this.loginOnSessionExpiryMarker.get() && !UserManager.this.isLoginCallInProgress.get()) {
                    HSLogger.d(UserManager.TAG, "logging out user, since it doesn't re-login");
                    UserManager.this.logout(false);
                    return;
                }
                HSLogger.d(UserManager.TAG, "Not logging out. User relogined");
            }
        }, 5000L);
    }

    public void addUserIdentities(String str) {
        if (this.isLoginCallInProgress.get()) {
            HSLogger.d(TAG, LOGIN_CALL_ALREADY_IN_PROGRESS);
        } else {
            IdentityValidationUtil.addUserIdentities(this.currentUser, this.device, str, this.hsEventProxy);
        }
    }

    public void updateMasterAttributes(Map<String, Object> map) {
        if (this.isLoginCallInProgress.get()) {
            HSLogger.d(TAG, LOGIN_CALL_ALREADY_IN_PROGRESS);
        } else {
            IdentityAttributesUtil.updateMasterAttributes(this.currentUser, map, this.hsEventProxy);
        }
    }

    public void updateAppAttributes(Map<String, Object> map) {
        if (this.isLoginCallInProgress.get()) {
            HSLogger.d(TAG, LOGIN_CALL_ALREADY_IN_PROGRESS);
        } else {
            IdentityAttributesUtil.updateAppAttributes(this.currentUser, map, this.hsEventProxy);
        }
    }

    public void collectAndStoreSDKCollectibleAttributes() {
        IdentityAttributesUtil.collectAndStoreSDKCollectibleAttributes(this.currentUser, this.device, this.hsEventProxy);
    }

    public synchronized void triggerIdentityAttributeSync() {
        BaseUser baseUser = this.currentUser;
        if (baseUser instanceof UserWithIdentity) {
            UserWithIdentity userWithIdentity = (UserWithIdentity) baseUser;
            List<String> unSyncIdentitiesList = userWithIdentity.getUnSyncIdentitiesList();
            Map<String, Object> unsyncedMasterAttributes = userWithIdentity.getUnsyncedMasterAttributes();
            Map<String, Object> unsyncAppAttributes = userWithIdentity.getUnsyncAppAttributes();
            if (Utils.isEmpty(unSyncIdentitiesList) && Utils.isEmpty(unsyncAppAttributes) && Utils.isEmpty(unsyncedMasterAttributes)) {
                return;
            }
            syncUnSyncIdentitiesAndAttributes(unSyncIdentitiesList, unsyncedMasterAttributes, unsyncAppAttributes);
        }
    }

    public void delayForDataSync(final WeakReference<ConsumeOnceListener<Boolean>> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (!this.dataSyncCallProgress.get() && weakReference.get() != null) {
            weakReference.get().emit(true);
            return;
        }
        HSLogger.d(TAG, "Scheduling delay to listen for data attribute sync: callback " + weakReference.hashCode());
        Utils.executeWithDelay(new Runnable() { // from class: com.helpshift.user.UserManager.5
            @Override // java.lang.Runnable
            public void run() {
                if (weakReference.get() != null) {
                    ((ConsumeOnceListener) weakReference.get()).emit(true);
                }
            }
        }, 300L);
    }

    private void syncUnSyncIdentitiesAndAttributes(List<String> list, Map<String, Object> map, Map<String, Object> map2) {
        if (this.isLoginCallInProgress.get()) {
            HSLogger.d(TAG, "Identity login already in progress. Skipping sync attributes call.");
        } else if (this.dataSyncCallProgress.get()) {
            HSLogger.d(TAG, "Identity/attribute sync already in progress. Skipping repeated call.");
        } else {
            final UserWithIdentity userWithIdentity = (UserWithIdentity) this.currentUser;
            final Map<String, String> buildUnsyncedDataMap = buildUnsyncedDataMap(list, map, map2);
            if (buildUnsyncedDataMap.isEmpty()) {
                return;
            }
            String platformId = this.persistentStorage.getPlatformId();
            String deviceId = this.device.getDeviceId();
            Map<String, String> buildHeaderMap = NetworkUtils.buildHeaderMap(this.device, platformId);
            Map<String, String> activeUserDataForNetworkCall = getActiveUserDataForNetworkCall(new HashMap());
            activeUserDataForNetworkCall.put("did", deviceId);
            activeUserDataForNetworkCall.putAll(buildUnsyncedDataMap);
            final HSRequestData hSRequestData = new HSRequestData(buildHeaderMap, activeUserDataForNetworkCall);
            final RetryNetworkWithNewToken retryNetworkWithNewToken = new RetryNetworkWithNewToken(new PUTNetwork(this.httpTransport, NetworkUtils.getSyncIdentitiesRoute(this.persistentStorage)), this, this.httpTransport, true, userWithIdentity.getDataForTokenRotation());
            this.dataSyncCallProgress = this.hsThreadingService.getNetworkService().submit(new Runnable() { // from class: com.helpshift.user.UserManager.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HSLogger.d(UserManager.TAG, "Triggering network call to sync identities and attributes.");
                        UserManager.this.handleNetworkResponse(retryNetworkWithNewToken.makeRequest(hSRequestData), userWithIdentity, buildUnsyncedDataMap);
                    } catch (Exception e) {
                        UserManager.this.handleSyncError(e);
                    }
                }
            });
        }
    }

    private Map<String, String> buildUnsyncedDataMap(List<String> list, Map<String, Object> map, Map<String, Object> map2) {
        HashMap hashMap = new HashMap();
        try {
            JSONArray jsonArrayFromList = JsonUtils.jsonArrayFromList(list);
            String str = "";
            String mapToJsonString = Utils.isEmpty(map) ? "" : JsonUtils.mapToJsonString(map);
            if (!Utils.isEmpty(map2)) {
                str = JsonUtils.mapToJsonString(map2);
            }
            if (!JsonUtils.isEmpty(jsonArrayFromList)) {
                hashMap.put("identity_tokens", jsonArrayFromList.toString());
            }
            if (Utils.isNotEmpty(mapToJsonString)) {
                hashMap.put("core_attributes", mapToJsonString);
            }
            if (Utils.isNotEmpty(str)) {
                hashMap.put(APP_ATTRIBUTES, str);
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in getting unSync data for active user.", e);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNetworkResponse(HSResponse hSResponse, UserWithIdentity userWithIdentity, Map<String, String> map) throws JSONException {
        if (hSResponse.isNetworkCallSuccess()) {
            if (hSResponse.getStatus() == 206) {
                handlePartialUpdate(hSResponse, userWithIdentity);
            }
            userWithIdentity.updateSyncedAppAttributes(map.get(APP_ATTRIBUTES), IdentityAttributesUtil.sdkCollectibleAttributeKeys);
            userWithIdentity.clearUnSyncAttributesAndIdentities();
            return;
        }
        HSLogger.e(TAG, "Error syncing identity and attributes in network call. Code " + hSResponse.getStatus());
    }

    private void handlePartialUpdate(HSResponse hSResponse, UserWithIdentity userWithIdentity) throws JSONException {
        JSONObject optJSONObject = new JSONObject(hSResponse.getResponseString()).optJSONObject("error");
        checkAndHandleInvalidFields(optJSONObject, "invalid-identity-tokens", "identityTokenInvalid");
        checkAndHandleInvalidFields(optJSONObject, "invalid-identities", HelpshiftEvent.IDENTITY_DATA_SYNC_FAILED);
        checkAndHandleInvalidFields(optJSONObject, "invalid-core-attributes", HelpshiftEvent.MASTER_ATTRIBUTES_SYNC_FAILED);
        checkAndHandleInvalidFields(optJSONObject, "invalid-app-attributes", HelpshiftEvent.APP_ATTRIBUTES_SYNC_FAILED);
        HSLogger.e(TAG, "Partial updates in syncing identity and attributes, status: " + hSResponse.getStatus());
    }

    private void checkAndHandleInvalidFields(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (JsonUtils.isEmpty(jSONObject.optJSONArray(str))) {
            return;
        }
        HSLogger.e(TAG, "Syncing failed because of invalid " + str);
        if (str2.equals("identityTokenInvalid")) {
            sendEventForInvalidResponse(str2, null);
        } else {
            sendEventForInvalidResponse(str2, jSONObject.optJSONArray(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSyncError(Exception exc) {
        if (exc instanceof HSRootApiException) {
            HSRootApiException hSRootApiException = (HSRootApiException) exc;
            if (hSRootApiException.exceptionType == NetworkException.SESSION_EXPIRED || hSRootApiException.exceptionType == NetworkException.IDENTITY_FEATURE_NOT_ENABLED) {
                logoutUserForNetworkException(hSRootApiException.exceptionType);
            }
        }
        HSLogger.e(TAG, "Error syncing identity and attributes", exc);
    }

    private void sendEventForInvalidResponse(String str, JSONArray jSONArray) {
        if (jSONArray == null) {
            this.hsEventProxy.sendEvent(str, null);
        } else if (JsonUtils.isEmpty(jSONArray)) {
        } else {
            IdentityAttributesUtil.sendUserIdentityAttributeFailureEvent(str, IdentityAttributesUtil.getValuePairsFromArray(jSONArray, InvalidDataErrorReason.INVALID_DATA), this.hsEventProxy);
        }
    }

    private void cleanUpActiveUser(BaseUser baseUser) {
        baseUser.cleanupUser();
        this.notificationManager.cancelNotifications();
        usersNotFound.clear();
    }

    public void saveClearAnonymousUserOnLoginConfig(boolean z) {
        this.persistentStorage.setClearAnonymousUser(z);
    }

    private boolean getClearAnonymousUserOnLoginFlag() {
        return this.persistentStorage.isClearAnonymousUser();
    }

    public Map<String, String> getActiveUserDataForNetworkCall() {
        return this.currentUser.getUserDataForNetworkCall(this.genericDataManager.getUserDataKeyMapping());
    }

    public boolean isUserDataNeededForNetworkCall() {
        return this.currentUser.isUserDataNeededForNetworkCall();
    }

    public Map<String, String> getActiveUserDataForNetworkCall(Map<String, String> map) {
        return this.currentUser.getUserDataForNetworkCall(map);
    }

    public Map<String, String> getTokenDataForRotation() {
        return this.currentUser.getDataForTokenRotation();
    }

    protected String generateAnonymousUserId() {
        return "hsft_anon_" + System.currentTimeMillis() + "-" + UUID.randomUUID().toString().replace("-", "").substring(0, 15);
    }

    public void generateAndSaveAnonymousUserIdIfNeeded() {
        if (!this.anonymousUser.userDataExists()) {
            HSLogger.d(TAG, "Existing anon user details not found. Generating new anon user ID");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("userId", generateAnonymousUserId());
                this.anonymousUser.saveAnonUserData(jSONObject);
                return;
            } catch (Exception unused) {
                HSLogger.d(TAG, "Error in saving the anonymous local user id");
                return;
            }
        }
        HSLogger.d(TAG, "Existing anon user details found. Not generating new anon user ID");
    }

    public void addUserLifecycleListener(String str, UserLifecycleListener userLifecycleListener) {
        this.userLifecycleListeners.put(str, new WeakReference<>(userLifecycleListener));
    }

    public void removeUserLifeCycleListener(String str) {
        this.userLifecycleListeners.remove(str);
    }

    private void startNotificationUpdatesSync(final BaseUser baseUser, final String str) {
        this.hsThreadingService.getNetworkService().submit(new Runnable() { // from class: com.helpshift.user.UserManager.7
            @Override // java.lang.Runnable
            public void run() {
                UserManager.this.fetchNotificationUpdate.execute(str, UserManager.this.getHashForUser(baseUser));
                if (UserManager.this.shouldPoll()) {
                    String currentPushToken = UserManager.this.persistentStorage.getCurrentPushToken();
                    if (Utils.isEmpty(currentPushToken)) {
                        UserManager.this.conversationPoller.startPoller();
                        return;
                    }
                    HSPushTokenManager hSPushTokenManager = UserManager.this.pushTokenManager;
                    UserManager userManager = UserManager.this;
                    hSPushTokenManager.registerPushTokenWithBackend(userManager, currentPushToken, userManager.getActiveUserDataForNetworkCall(), new UpdatePushSyncStatus(UserManager.this));
                }
            }
        });
    }

    private boolean shouldSyncPushToken(String str) {
        String currentPushToken = this.persistentStorage.getCurrentPushToken();
        return (!Utils.isEmpty(currentPushToken) && currentPushToken.equals(str) && isPushTokenSynced()) ? false : true;
    }

    public Boolean isRequestUnreadMessageCountAllowed(String str) {
        return Boolean.valueOf(!usersNotFound.contains(str));
    }

    public void removeUserFromErrorList(String str) {
        usersNotFound.remove(str);
    }

    public void addUserInErrorList(String str) {
        usersNotFound.add(str);
    }

    public boolean isUserDataValidForNetworkCall() {
        return this.currentUser.isUserDataValidForNetworkCall();
    }

    public String getHashForActiveUser() {
        return getHashForUser(this.currentUser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getHashForUser(BaseUser baseUser) {
        StringBuilder sb = new StringBuilder();
        TreeMap treeMap = new TreeMap(baseUser.getUserLoginInfo());
        if (Utils.isEmpty(treeMap)) {
            return "";
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append((String) entry.getValue());
        }
        return sb.toString();
    }

    public void setShouldPollFlag(boolean z) {
        this.currentUser.setUserDataValues(UserConstants.SHOULD_POLL, Boolean.valueOf(z));
    }

    public void setPollerCursor(long j) {
        this.currentUser.setUserDataValues(UserConstants.POLLING_CURSOR, Long.valueOf(j));
    }

    public void setPollingBaseInterval(int i) {
        this.currentUser.setUserDataValues(UserConstants.BASE_POLLING_INTERVAL, Integer.valueOf(i));
    }

    public void setPollingMaxInterval(int i) {
        this.currentUser.setUserDataValues(UserConstants.MAX_POLLING_INTERVAL, Integer.valueOf(i));
    }

    public void setActiveUnreadCountFetchInterval(int i) {
        this.currentUser.setUserDataValues(UserConstants.ACTIVE_UNREAD_COUNT_FETCH_INTERVAL, Integer.valueOf(i));
    }

    public void setPassiveUnreadCountFetchInterval(int i) {
        this.currentUser.setUserDataValues(UserConstants.PASSIVE_UNREAD_COUNT_FETCH_INTERVAL, Integer.valueOf(i));
    }

    public void updateUnreadCountBy(int i) {
        this.currentUser.setUserDataValues(UserConstants.UNREAD_COUNT, Integer.valueOf(getUnreadNotificationCount() + i));
    }

    public void markAllMessagesAsRead() {
        this.currentUser.setUserDataValues(UserConstants.UNREAD_COUNT, 0);
    }

    public void setPushTokenSynced(boolean z) {
        this.currentUser.setUserDataValues(UserConstants.PUSH_TOKEN_SYNCED, Boolean.valueOf(z));
    }

    public boolean shouldPoll() {
        return ((Boolean) this.currentUser.getUserDataValue(UserConstants.SHOULD_POLL, false)).booleanValue();
    }

    public int getActiveRemoteFetchInterval() {
        return ((Integer) this.currentUser.getUserDataValue(UserConstants.ACTIVE_UNREAD_COUNT_FETCH_INTERVAL, 60000)).intValue();
    }

    public int getPassiveRemoteFetchInterval() {
        return ((Integer) this.currentUser.getUserDataValue(UserConstants.PASSIVE_UNREAD_COUNT_FETCH_INTERVAL, Integer.valueOf((int) Utils.FALLBACK_PASSIVE_REMOTE_FETCH_INTERVAL))).intValue();
    }

    public long getPollerCursor() {
        return Long.valueOf(this.currentUser.getUserDataValue(UserConstants.POLLING_CURSOR, 0) + "").longValue();
    }

    public int getPollingMaxInterval() {
        return ((Integer) this.currentUser.getUserDataValue(UserConstants.MAX_POLLING_INTERVAL, 60000)).intValue();
    }

    public int getPollingBaseInterval() {
        return ((Integer) this.currentUser.getUserDataValue(UserConstants.BASE_POLLING_INTERVAL, 5000)).intValue();
    }

    public int getUnreadNotificationCount() {
        return ((Integer) this.currentUser.getUserDataValue(UserConstants.UNREAD_COUNT, 0)).intValue();
    }

    public int getPushUnreadNotificationCount() {
        return ((Integer) this.currentUser.getUserDataValue(UserConstants.PUSH_UNREAD_COUNT, 0)).intValue();
    }

    public void updatePushUnreadCountBy(int i) {
        this.currentUser.setUserDataValues(UserConstants.PUSH_UNREAD_COUNT, Integer.valueOf(getPushUnreadNotificationCount() + i));
    }

    public void markAllPushMessagesAsRead() {
        this.currentUser.setUserDataValues(UserConstants.PUSH_UNREAD_COUNT, 0);
    }

    public boolean isPushTokenSynced() {
        return ((Boolean) this.currentUser.getUserDataValue(UserConstants.PUSH_TOKEN_SYNCED, false)).booleanValue();
    }

    public boolean isLoginCallInProgress() {
        return this.isLoginCallInProgress.get();
    }

    public void setShowChatIconInHelpcenter(boolean z) {
        this.currentUser.setUserDataValues(UserConstants.SHOW_CHAT_ICON_IN_HELPCENTER, Boolean.valueOf(z));
    }

    public boolean shouldShowChatIconInHelpcenter() {
        return ((Boolean) this.currentUser.getUserDataValue(UserConstants.SHOW_CHAT_ICON_IN_HELPCENTER, false)).booleanValue();
    }

    @Override // com.helpshift.network.UserManagerProxy
    public HSRequest getRequestBodyForRotatingToken(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(UserConstants.REFRESH_TOKEN, str);
        hashMap.put("source", "android");
        return NetworkUtils.getRequestBodyForRotatingToken(this.persistentStorage, this.device, hashMap);
    }

    @Override // com.helpshift.network.UserManagerProxy
    public void updateNewTokensInStorage(String str, String str2, long j) {
        BaseUser baseUser = this.currentUser;
        if (baseUser instanceof UserWithIdentity) {
            UserWithIdentity userWithIdentity = (UserWithIdentity) baseUser;
            userWithIdentity.setAccessToken(str);
            userWithIdentity.setRefreshToken(str2);
            if (j != 0) {
                userWithIdentity.setRefreshTokenExpiry(j);
            }
        }
    }

    @Override // com.helpshift.network.UserManagerProxy
    public void logoutUserForNetworkException(HSRootApiException.ExceptionType exceptionType) {
        logout(false);
        this.hsEventProxy.sendEvent(exceptionType == NetworkException.IDENTITY_FEATURE_NOT_ENABLED ? "identityFeatureNotEnabled" : HelpshiftEvent.USER_SESSION_EXPIRED, null);
    }
}
