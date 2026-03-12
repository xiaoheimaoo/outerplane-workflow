package com.helpshift.poller;

import com.helpshift.chat.HSEventProxy;
import com.helpshift.log.HSLogger;
import com.helpshift.network.AuthenticationFailureNetwork;
import com.helpshift.network.GETNetwork;
import com.helpshift.network.HSNetwork;
import com.helpshift.network.HSRequestData;
import com.helpshift.network.HSResponse;
import com.helpshift.network.HTTPTransport;
import com.helpshift.network.RetryNetworkWithNewToken;
import com.helpshift.network.exception.HSRootApiException;
import com.helpshift.network.exception.NetworkException;
import com.helpshift.notification.CoreNotificationManager;
import com.helpshift.platform.Device;
import com.helpshift.storage.HSGenericDataManager;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.user.UserConstants;
import com.helpshift.user.UserManager;
import com.helpshift.user.UserWithIdentity;
import com.helpshift.util.Utils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FetchNotificationUpdate {
    private static final String TAG = "ftchNotif";
    private final Device device;
    private final HSGenericDataManager genericDataManager;
    private final HSEventProxy hsEventProxy;
    private final HTTPTransport httpTransport;
    private final CoreNotificationManager notificationManager;
    private final HSPersistentStorage persistentStorage;
    private final UserManager userManager;

    public FetchNotificationUpdate(Device device, HSPersistentStorage hSPersistentStorage, HSGenericDataManager hSGenericDataManager, UserManager userManager, CoreNotificationManager coreNotificationManager, HTTPTransport hTTPTransport, HSEventProxy hSEventProxy) {
        this.device = device;
        this.persistentStorage = hSPersistentStorage;
        this.genericDataManager = hSGenericDataManager;
        this.userManager = userManager;
        this.notificationManager = coreNotificationManager;
        this.httpTransport = hTTPTransport;
        this.hsEventProxy = hSEventProxy;
    }

    public synchronized int execute(String str, String str2) {
        HSLogger.d(TAG, "Fetching notification count from network.");
        Map<String, String> networkHeaders = this.genericDataManager.getNetworkHeaders();
        String pollingRoute = this.genericDataManager.getPollingRoute();
        Map<String, String> activeUserDataForNetworkCall = this.userManager.getActiveUserDataForNetworkCall();
        if (isValidNetworkRequest(networkHeaders, pollingRoute, activeUserDataForNetworkCall)) {
            prepareRequestBody(activeUserDataForNetworkCall, this.userManager, this.device, this.persistentStorage, str);
            try {
                return handleResponse(createNetwork(this.httpTransport, pollingRoute, this.userManager).makeRequest(new HSRequestData(networkHeaders, activeUserDataForNetworkCall)), this.userManager, this.notificationManager, this.genericDataManager, str2);
            } catch (Exception e) {
                handleException(e, this.userManager);
                return -1;
            }
        }
        return -1;
    }

    private boolean isValidNetworkRequest(Map<String, String> map, String str, Map<String, String> map2) {
        if (Utils.isEmpty(map) || Utils.isEmpty(str)) {
            HSLogger.d(TAG, "Skipping notification count fetch. Invalid params for network call.");
            return false;
        }
        Utils.removeEmptyKeyValues(map2);
        if (this.userManager.isUserDataNeededForNetworkCall() && Utils.isEmpty(map2)) {
            HSLogger.d(TAG, "Skipping notification count fetch. Empty body params for network call.");
            return false;
        } else if (this.userManager.isUserDataValidForNetworkCall()) {
            return true;
        } else {
            HSLogger.e(TAG, "UserId/Email not valid, skipping fetch notification api call.");
            return false;
        }
    }

    private void prepareRequestBody(Map<String, String> map, UserManager userManager, Device device, HSPersistentStorage hSPersistentStorage, String str) {
        long pollerCursor = userManager.getPollerCursor();
        if (pollerCursor != 0) {
            map.put(UserConstants.POLLING_CURSOR, String.valueOf(pollerCursor));
        }
        map.put("did", device.getDeviceId());
        map.put("platform-id", hSPersistentStorage.getPlatformId());
        map.put("origin", str);
    }

    private HSNetwork createNetwork(HTTPTransport hTTPTransport, String str, UserManager userManager) {
        return new RetryNetworkWithNewToken(new AuthenticationFailureNetwork(new GETNetwork(hTTPTransport, str)), userManager, hTTPTransport, userManager.getCurrentUser() instanceof UserWithIdentity, userManager.getTokenDataForRotation());
    }

    private int handleResponse(HSResponse hSResponse, UserManager userManager, CoreNotificationManager coreNotificationManager, HSGenericDataManager hSGenericDataManager, String str) throws JSONException {
        int status = hSResponse.getStatus();
        if (hSResponse.isNetworkCallSuccess()) {
            JSONObject jSONObject = new JSONObject(hSResponse.getResponseString());
            int optInt = jSONObject.optInt("uc", 0);
            updateUserPollingSettings(jSONObject, userManager);
            if (optInt > 0) {
                int unreadNotificationCount = userManager.getUnreadNotificationCount() + optInt;
                userManager.updateUnreadCountBy(optInt);
                if (!userManager.isPushTokenSynced()) {
                    coreNotificationManager.showNotification(hSGenericDataManager.getNotificationStringForCount(unreadNotificationCount), false);
                }
            }
            userManager.setPollerCursor(jSONObject.optLong("c", 0L));
            userManager.removeUserFromErrorList(str);
        } else if (status == 404) {
            userManager.addUserInErrorList(str);
        }
        return status;
    }

    private void updateUserPollingSettings(JSONObject jSONObject, UserManager userManager) {
        int optInt = jSONObject.optInt("bpi", 5000);
        int optInt2 = jSONObject.optInt("mpi", 60000);
        int optInt3 = jSONObject.optInt("afi", 60000);
        int optInt4 = jSONObject.optInt("iafi", Utils.FALLBACK_PASSIVE_REMOTE_FETCH_INTERVAL);
        boolean optBoolean = jSONObject.optBoolean("cp", false);
        userManager.setPollingBaseInterval(optInt);
        userManager.setPollingMaxInterval(optInt2);
        userManager.setShouldPollFlag(optBoolean);
        userManager.setActiveUnreadCountFetchInterval(optInt3);
        userManager.setPassiveUnreadCountFetchInterval(optInt4);
    }

    private void handleException(Exception exc, UserManager userManager) {
        if (exc instanceof HSRootApiException) {
            handleNetworkException((HSRootApiException) exc, userManager);
        } else {
            HSLogger.e(TAG, "Error in poller request", exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.helpshift.poller.FetchNotificationUpdate$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$helpshift$network$exception$NetworkException;

        static {
            int[] iArr = new int[NetworkException.values().length];
            $SwitchMap$com$helpshift$network$exception$NetworkException = iArr;
            try {
                iArr[NetworkException.SESSION_EXPIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$helpshift$network$exception$NetworkException[NetworkException.IDENTITY_FEATURE_NOT_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$helpshift$network$exception$NetworkException[NetworkException.INVALID_AUTH_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$helpshift$network$exception$NetworkException[NetworkException.AUTH_TOKEN_NOT_PROVIDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void handleNetworkException(HSRootApiException hSRootApiException, UserManager userManager) {
        int i = AnonymousClass1.$SwitchMap$com$helpshift$network$exception$NetworkException[((NetworkException) hSRootApiException.exceptionType).ordinal()];
        if (i == 1 || i == 2) {
            userManager.logoutUserForNetworkException(hSRootApiException.exceptionType);
        } else if (i == 3) {
            this.hsEventProxy.sendAuthFailureEvent(AuthenticationFailureNetwork.REASON_INVALID_AUTH_TOKEN);
        } else if (i == 4) {
            this.hsEventProxy.sendAuthFailureEvent(AuthenticationFailureNetwork.REASON_AUTH_TOKEN_NOT_PROVIDED);
        } else {
            HSLogger.e(TAG, "HSRootApiException in poller request", hSRootApiException);
        }
    }
}
