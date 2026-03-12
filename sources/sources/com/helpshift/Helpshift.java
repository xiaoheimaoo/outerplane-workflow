package com.helpshift;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.util.Base64;
import com.helpshift.activities.HSMainActivity;
import com.helpshift.core.AndroidDevice;
import com.helpshift.core.HSContext;
import com.helpshift.exception.HSUncaughtExceptionHandler;
import com.helpshift.lifecycle.HSAppLifeCycleController;
import com.helpshift.log.HSLogger;
import com.helpshift.log.InternalHelpshiftLogger;
import com.helpshift.log.LogCollector;
import com.helpshift.log.PreInstallLogger;
import com.helpshift.proactive.HelpshiftProactiveAPIConfigCollector;
import com.helpshift.proactive.ProactiveConfigMerge;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.storage.SharedPreferencesStore;
import com.helpshift.user.UserManager;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.ConfigValues;
import com.helpshift.util.HSTimer;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.SchemaUtil;
import com.helpshift.util.SdkURLs;
import com.helpshift.util.Utils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class Helpshift {
    private static final String TAG = "Helpshift";
    private static HelpshiftProactiveAPIConfigCollector proactiveLocalConfigCollector;

    public static String getSDKVersion() {
        return AndroidDevice.LITE_SDK_VERSION;
    }

    static /* synthetic */ Map access$100() {
        return getProactiveLocalConfig();
    }

    private Helpshift() {
    }

    public static void setHelpshiftEventsListener(final HelpshiftEventsListener helpshiftEventsListener) {
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "setHelpshiftEventsListener() is called: " + helpshiftEventsListener);
            HSContext.getInstance().getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.1
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.getInstance().getHsEventProxy().setHelpshiftEventsListener(HelpshiftEventsListener.this);
                }
            });
        }
    }

    public static void setHelpshiftProactiveConfigCollector(final HelpshiftProactiveAPIConfigCollector helpshiftProactiveAPIConfigCollector) {
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "setHelpshiftProactiveConfigCollector() is called.");
            HSContext.getInstance().getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.2
                @Override // java.lang.Runnable
                public void run() {
                    HelpshiftProactiveAPIConfigCollector unused = Helpshift.proactiveLocalConfigCollector = HelpshiftProactiveAPIConfigCollector.this;
                }
            });
        }
    }

    public static synchronized void install(final Application application, String str, String str2, final Map<String, Object> map) throws HelpshiftInstallException, UnsupportedOSVersionException {
        synchronized (Helpshift.class) {
            if (HSContext.installCallSuccessful.get()) {
                HSLogger.d(TAG, "Helpshift is already initialized !");
                return;
            }
            SchemaUtil.validateInstallCredentials(str2, str);
            final String trim = str2.trim();
            final String trim2 = str.trim();
            final Map<String, Object> sanitizeConfig = HSInstallHelper.sanitizeConfig(map);
            Object obj = sanitizeConfig.get("isForChina");
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                SdkURLs.updateHosts("webchat.hsftcn.cn", "media.hsftcn.cn");
            }
            final boolean isApplicationInDebugMode = ApplicationUtil.isApplicationInDebugMode(application);
            HSInstallCredsChangeManager.changeInstallCredentials(trim2, trim, new SharedPreferencesStore(application, HSInstallCredsChangeManager.HS_CREDS_PREFS_FILE_NAME, 0), new SharedPreferencesStore(application, HSPersistentStorage.FILE_NAME, 0), new SharedPreferencesStore(application, HSPersistentStorage.CHAT_RESOURCE_CACHE_SHARED_PREF_NAME, 0), new SharedPreferencesStore(application, HSPersistentStorage.HC_RESOURCE_CACHE_SHARED_PREF_NAME, 0), application.getCacheDir(), application.getFilesDir(), new PreInstallLogger(isApplicationInDebugMode));
            HSContext.initInstance(application);
            final HSContext hSContext = HSContext.getInstance();
            hSContext.getHsThreadingService().runSync(new Runnable() { // from class: com.helpshift.Helpshift.3
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getNativeToSdkxMigrator().migrate();
                    HSContext.this.initialiseComponents(application);
                    HSInstallHelper.setupLifecycleListeners(application, sanitizeConfig);
                }
            });
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.4
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getConfigManager().saveInstallKeys(trim2, trim);
                    Object obj2 = sanitizeConfig.get(ConfigValues.ENABLE_LOGGING);
                    boolean z = true;
                    boolean z2 = (obj2 instanceof Boolean) && ((Boolean) obj2).booleanValue();
                    boolean enableLoggingViaWebchat = !z2 ? HSContext.this.getPersistentStorage().getEnableLoggingViaWebchat() : false;
                    if (!z2 && !enableLoggingViaWebchat) {
                        z = false;
                    }
                    HSContext.this.setSDKLoggingEnabled(z);
                    InternalHelpshiftLogger internalHelpshiftLogger = new InternalHelpshiftLogger(z);
                    if (isApplicationInDebugMode && z) {
                        internalHelpshiftLogger.setLogCollector(new LogCollector(application, LogCollector.getLogFileName(), Looper.getMainLooper().getThread().getId()));
                        HSUncaughtExceptionHandler.init();
                        HSContext.this.getNotificationManager().showDebugLogNotification();
                    }
                    HSLogger.initLogger(internalHelpshiftLogger);
                    HSLogger.d(Helpshift.TAG, "Install called: Domain : " + trim + ", Config: " + map + " SDK X Version: " + HSContext.this.getDevice().getSDKVersion());
                    HSInstallHelper.setNotificationConfigValues(application, HSContext.this.getNotificationManager(), sanitizeConfig);
                    HSContext.this.getWebchatAnalyticsManager().setAnalyticsEventsData(sanitizeConfig);
                    HSInstallHelper.setEnableInAppNotification(sanitizeConfig, HSContext.this.getPersistentStorage());
                    HSInstallHelper.setScreenOrientation(sanitizeConfig, HSContext.this.getPersistentStorage());
                    HSContext.this.getHelpcenterCacheEvictionManager().deleteOlderHelpcenterCachedFiles();
                    HSContext.this.getUserManager().generateAndSaveAnonymousUserIdIfNeeded();
                    if (HSPluginEventBridge.shouldCallFirstForegroundEvent()) {
                        HSAppLifeCycleController.getInstance().onAppForeground();
                    }
                }
            });
            HSContext.installCallSuccessful.compareAndSet(false, true);
        }
    }

    public static void handleProactiveLink(final String str) {
        if (Utils.isEmpty(str) || !HSContext.verifyInstall()) {
            return;
        }
        HSLogger.d(TAG, "handleProactiveLink is called with: " + str);
        final HSContext hSContext = HSContext.getInstance();
        hSContext.getHsThreadingService().runOnUIThread(new Runnable() { // from class: com.helpshift.Helpshift.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Uri parse = Uri.parse(str);
                    if (!"helpshift.com".equals(parse.getHost())) {
                        HSLogger.e(Helpshift.TAG, "Incorrect host for proactive link, skipping!");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(new String(Base64.decode(parse.getQueryParameter("payload"), 0)));
                    String optString = jSONObject.optString("action");
                    if (Utils.isEmpty(optString)) {
                        HSLogger.e(Helpshift.TAG, "No action found in proactive link, skipping!");
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("chatConfig");
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("meta");
                    JSONObject jSONObject2 = new JSONObject();
                    if (!"chat".equals(optString)) {
                        jSONObject2 = jSONObject.optJSONObject("hcConfig");
                    }
                    Map access$100 = Helpshift.access$100();
                    Helpshift.saveLocalConfig(access$100);
                    JSONObject jSONObject3 = new JSONObject(access$100);
                    boolean isEmpty = JsonUtils.isEmpty(optJSONObject);
                    HSLogger.d(Helpshift.TAG, "Is proactive config empty? " + isEmpty);
                    if (!isEmpty) {
                        jSONObject3 = ProactiveConfigMerge.mergeProactiveConfig(jSONObject3, optJSONObject);
                    }
                    if (!JsonUtils.isEmpty(optJSONObject2)) {
                        jSONObject3.put("outboundSupportMeta", optJSONObject2);
                    }
                    Map<String, Object> parseConfigDictionary = JsonUtils.parseConfigDictionary(jSONObject3.toString());
                    Context context = hSContext.context;
                    HSLogger.d(Helpshift.TAG, "Starting SDK with proactive support action : " + optString);
                    Helpshift.processProactiveAction(context, optString, jSONObject2, parseConfigDictionary);
                } catch (Exception unused) {
                    HSLogger.e(Helpshift.TAG, "Error handling proactive link : " + str);
                }
            }
        });
    }

    private static Map<String, Object> getProactiveLocalConfig() {
        HelpshiftProactiveAPIConfigCollector helpshiftProactiveAPIConfigCollector = proactiveLocalConfigCollector;
        if (helpshiftProactiveAPIConfigCollector != null) {
            Map<String, Object> aPIConfig = helpshiftProactiveAPIConfigCollector.getAPIConfig();
            HSLogger.d(TAG, "Collected local config for proactive: " + aPIConfig);
            return aPIConfig != null ? aPIConfig : new HashMap();
        }
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processProactiveAction(Context context, String str, JSONObject jSONObject, Map<String, Object> map) {
        HSLogger.d(TAG, "Starting SDK with proactive support action: " + str);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1224669617:
                if (str.equals("hc-app")) {
                    c = 0;
                    break;
                }
                break;
            case -1224665276:
                if (str.equals("hc-faq")) {
                    c = 1;
                    break;
                }
                break;
            case 3052376:
                if (str.equals("chat")) {
                    c = 2;
                    break;
                }
                break;
            case 1280394259:
                if (str.equals("hc-section")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                showFAQsInternal(context, map, true);
                return;
            case 1:
                if (JsonUtils.isEmpty(jSONObject)) {
                    return;
                }
                showSingleFAQInternal(context, jSONObject.optString("faqId", ""), map, true);
                return;
            case 2:
                showConversationInternal(context, map, true);
                return;
            case 3:
                if (JsonUtils.isEmpty(jSONObject)) {
                    return;
                }
                showFAQSectionInternal(context, jSONObject.optString("faqSectionId", ""), map, true);
                return;
            default:
                return;
        }
    }

    public static void showConversation(Activity activity, Map<String, Object> map) {
        if (HSContext.verifyInstall()) {
            HSTimer.setStartTime(ConfigValues.SOURCE_API);
            showConversationInternal(activity, map, false);
        }
    }

    private static void showConversationInternal(final Context context, final Map<String, Object> map, final boolean z) {
        HSLogger.d(TAG, "showConversation is called with config: " + map + " \n Is proactive? " + z);
        HSContext hSContext = HSContext.getInstance();
        hSContext.getUserManager().triggerIdentityAttributeSync();
        hSContext.getHsThreadingService().runOnUIThread(new Runnable() { // from class: com.helpshift.Helpshift.6
            @Override // java.lang.Runnable
            public void run() {
                Helpshift.saveConfig(map);
                Intent intent = new Intent(context, HSMainActivity.class);
                intent.putExtra(ConfigValues.SERVICE_MODE_KEY, ConfigValues.WEBCHAT_SERVICE);
                intent.putExtra("source", ConfigValues.SOURCE_API);
                if (z) {
                    intent.putExtra("source", ConfigValues.SOURCE_PROACTIVE);
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
            }
        });
    }

    public static void showFAQs(Activity activity, Map<String, Object> map) {
        if (HSContext.verifyInstall()) {
            showFAQsInternal(activity, map, false);
        }
    }

    private static void showFAQsInternal(final Context context, final Map<String, Object> map, final boolean z) {
        HSLogger.d(TAG, "showFAQs is called with config: " + map + " \n Is proactive? " + z);
        HSContext hSContext = HSContext.getInstance();
        hSContext.getUserManager().triggerIdentityAttributeSync();
        hSContext.getHsThreadingService().runOnUIThread(new Runnable() { // from class: com.helpshift.Helpshift.7
            @Override // java.lang.Runnable
            public void run() {
                Helpshift.saveConfig(map);
                Intent intent = new Intent(context, HSMainActivity.class);
                intent.putExtra(ConfigValues.SERVICE_MODE_KEY, ConfigValues.HELP_CENTER_SERVICE);
                intent.putExtra(ConfigValues.HELPCENTER_MODE_KEY, ConfigValues.HELPCENTER_MODE_APP_MAIN_PAGE);
                intent.putExtra("source", ConfigValues.SOURCE_API);
                if (z) {
                    intent.putExtra("source", ConfigValues.SOURCE_PROACTIVE);
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
            }
        });
    }

    public static void showFAQSection(Activity activity, String str, Map<String, Object> map) {
        if (HSContext.verifyInstall()) {
            showFAQSectionInternal(activity, str, map, false);
        }
    }

    private static void showFAQSectionInternal(final Context context, final String str, final Map<String, Object> map, final boolean z) {
        HSLogger.d(TAG, "showFAQSection is called with sectionId" + str + " & config: " + map + " \n Is proactive? : " + z);
        if (Utils.isEmpty(str)) {
            HSLogger.e(TAG, "Invalid FAQ Section ID. Ignoring call to showFAQSection API.");
            return;
        }
        HSContext hSContext = HSContext.getInstance();
        hSContext.getUserManager().triggerIdentityAttributeSync();
        hSContext.getHsThreadingService().runOnUIThread(new Runnable() { // from class: com.helpshift.Helpshift.8
            @Override // java.lang.Runnable
            public void run() {
                Helpshift.saveConfig(map);
                Intent intent = new Intent(context, HSMainActivity.class);
                intent.putExtra(ConfigValues.SERVICE_MODE_KEY, ConfigValues.HELP_CENTER_SERVICE);
                intent.putExtra(ConfigValues.HELPCENTER_MODE_KEY, ConfigValues.HELPCENTER_MODE_FAQ_SECTION);
                intent.putExtra(ConfigValues.FAQ_SECTION_ID_KEY, str);
                intent.putExtra("source", ConfigValues.SOURCE_API);
                if (z) {
                    intent.putExtra("source", ConfigValues.SOURCE_PROACTIVE);
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
            }
        });
    }

    public static void showSingleFAQ(Activity activity, String str, Map<String, Object> map) {
        if (HSContext.verifyInstall()) {
            showSingleFAQInternal(activity, str, map, false);
        }
    }

    private static void showSingleFAQInternal(final Context context, final String str, final Map<String, Object> map, final boolean z) {
        HSLogger.d(TAG, "showSingleFAQ() is called with publishId" + str + " & config: " + map + " \n Is proactive? : " + z);
        if (Utils.isEmpty(str)) {
            HSLogger.e(TAG, "Invalid FAQ ID. Ignoring call to showSingleFAQ API.");
            return;
        }
        HSContext hSContext = HSContext.getInstance();
        hSContext.getUserManager().triggerIdentityAttributeSync();
        hSContext.getHsThreadingService().runOnUIThread(new Runnable() { // from class: com.helpshift.Helpshift.9
            @Override // java.lang.Runnable
            public void run() {
                Helpshift.saveConfig(map);
                Intent intent = new Intent(context, HSMainActivity.class);
                intent.putExtra(ConfigValues.SERVICE_MODE_KEY, ConfigValues.HELP_CENTER_SERVICE);
                intent.putExtra(ConfigValues.HELPCENTER_MODE_KEY, ConfigValues.HELPCENTER_MODE_SINGLE_FAQ);
                intent.putExtra(ConfigValues.SINGLE_FAQ_PUBLISH_ID_KEY, str);
                intent.putExtra("source", ConfigValues.SOURCE_API);
                if (z) {
                    intent.putExtra("source", ConfigValues.SOURCE_PROACTIVE);
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
            }
        });
    }

    public static void leaveBreadCrumb(final String str) {
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "leaveBreadCrumb() is called with action: " + str);
            if (Utils.isEmpty(str)) {
                return;
            }
            final HSContext hSContext = HSContext.getInstance();
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.10
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getConfigManager().pushBreadCrumb(str);
                }
            });
        }
    }

    public static void clearBreadCrumbs() {
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "Clearing Breadcrumbs");
            final HSContext hSContext = HSContext.getInstance();
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.11
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getConfigManager().clearBreadCrumbs();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveLocalConfig(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        HSContext.getInstance().getConfigManager().saveLocalProactiveConfig(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveConfig(Map<String, Object> map) {
        HSContext hSContext = HSContext.getInstance();
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        if (hashMap.containsKey(ConfigValues.OLD_CUSTOM_ISSUE_FIELDS) && !hashMap.containsKey(ConfigValues.CUSTOM_ISSUE_FIELDS)) {
            hashMap.put(ConfigValues.CUSTOM_ISSUE_FIELDS, hashMap.remove(ConfigValues.OLD_CUSTOM_ISSUE_FIELDS));
        }
        hashMap.put(ConfigValues.ENABLE_LOGGING, Boolean.valueOf(hSContext.isSDKLoggingEnabled()));
        hSContext.getConfigManager().saveConfig(hashMap);
    }

    public static void loginWithIdentity(final String str, Map<String, Object> map, final HelpshiftUserLoginEventsListener helpshiftUserLoginEventsListener) {
        final HSContext hSContext = HSContext.getInstance();
        if (HSContext.verifyInstall()) {
            final HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            HSLogger.d(TAG, "Logging in the User with identity: " + str + " , loginConfig " + hashMap);
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.12
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getUserManager().loginWithIdentity(str, hashMap, helpshiftUserLoginEventsListener);
                }
            });
        }
    }

    public static void addUserIdentities(final String str) {
        final HSContext hSContext = HSContext.getInstance();
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "addUserIdentities() is called with " + str);
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.13
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getUserManager().addUserIdentities(str);
                }
            });
        }
    }

    public static void updateMasterAttributes(Map<String, Object> map) {
        final HSContext hSContext = HSContext.getInstance();
        if (HSContext.verifyInstall()) {
            final HashMap hashMap = new HashMap();
            if (Utils.isNotEmpty(map)) {
                hashMap.putAll(Utils.getDeepCopy(map));
            }
            HSLogger.d(TAG, "updateMasterAttributes() is called with " + hashMap);
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.14
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getUserManager().updateMasterAttributes(hashMap);
                }
            });
        }
    }

    public static void updateAppAttributes(Map<String, Object> map) {
        final HSContext hSContext = HSContext.getInstance();
        if (HSContext.verifyInstall()) {
            final HashMap hashMap = new HashMap();
            if (Utils.isNotEmpty(map)) {
                hashMap.putAll(Utils.getDeepCopy(map));
            }
            HSLogger.d(TAG, "updateAppAttributes() is called with " + hashMap);
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.15
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getUserManager().updateAppAttributes(hashMap);
                }
            });
        }
    }

    public static boolean login(Map<String, String> map) {
        final HSContext hSContext = HSContext.getInstance();
        if (Utils.isEmpty(map) || !HSContext.verifyInstall()) {
            return false;
        }
        if (hSContext.getUserManager().isLoginCallInProgress()) {
            HSLogger.d(TAG, UserManager.LOGIN_CALL_ALREADY_IN_PROGRESS);
            return false;
        }
        final HashMap hashMap = new HashMap(map);
        if (!Utils.validateUserIdEmailForLogin((String) hashMap.get("userId"), (String) hashMap.get("userEmail"))) {
            HSLogger.e(TAG, "userId/userEmail validation failed, skipping login.");
            return false;
        }
        Utils.removeEmptyKeyValues(hashMap);
        HSLogger.d(TAG, "Logging in the user: " + hashMap);
        hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.16
            @Override // java.lang.Runnable
            public void run() {
                HSContext.this.getUserManager().login(hashMap);
            }
        });
        return true;
    }

    public static void logout() {
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "Logging out the user");
            final HSContext hSContext = HSContext.getInstance();
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.17
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getUserManager().logout(true);
                }
            });
        }
    }

    public static void setLanguage(final String str) {
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "setLanguage() is called for language - " + str);
            final HSContext hSContext = HSContext.getInstance();
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.18
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getConfigManager().saveLanguage(str);
                }
            });
        }
    }

    public static void registerPushToken(final String str) {
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "Registering push token, token is empty?- " + Utils.isEmpty(str));
            final HSContext hSContext = HSContext.getInstance();
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.19
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getUserManager().registerPushToken(str);
                }
            });
        }
    }

    public static void handlePush(final Map<String, String> map) {
        if (!HSContext.verifyInstall() || map == null || map.size() == 0) {
            return;
        }
        HSLogger.d(TAG, "handlePush() is called.");
        final HSContext hSContext = HSContext.getInstance();
        hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.20
            @Override // java.lang.Runnable
            public void run() {
                if (!HSContext.this.isWebchatUIOpen()) {
                    HSContext.this.getUserManager().updatePushUnreadCountBy(1);
                }
                HSContext.this.getNotificationManager().showNotification((String) map.get("alert"), true);
            }
        });
    }

    @Deprecated
    public static void clearAnonymousUserOnLogin() {
        HSLogger.d(TAG, "Deprecated clearAnonymousUserOnLogin() is called.");
        clearAnonymousUserOnLogin(true);
    }

    public static void clearAnonymousUserOnLogin(final boolean z) {
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "clearAnonymousUserOnLogin() with param " + z + " is called.");
            final HSContext hSContext = HSContext.getInstance();
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.21
                @Override // java.lang.Runnable
                public void run() {
                    HSContext.this.getUserManager().saveClearAnonymousUserOnLoginConfig(z);
                }
            });
        }
    }

    public static void requestUnreadMessageCount(final boolean z) {
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "requestUnreadMessageCount is called with shouldFetchFromServer = " + z);
            final HSContext hSContext = HSContext.getInstance();
            hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.22
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        hSContext.getRequestUnreadMessageCountHandler().handleRemoteRequest(hSContext.getUserManager().getHashForActiveUser());
                    } else {
                        hSContext.getRequestUnreadMessageCountHandler().handleLocalCacheRequest();
                    }
                }
            });
        }
    }

    public static void onAppForeground() {
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "onAppForeground() is called for Manual App lifecycle tracking");
            HSContext.getInstance().getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.23
                @Override // java.lang.Runnable
                public void run() {
                    HSAppLifeCycleController.getInstance().onManualAppForegroundAPI();
                }
            });
        }
    }

    public static void onAppBackground() {
        if (HSContext.verifyInstall()) {
            HSLogger.d(TAG, "onAppBackground() is called for Manual App lifecycle tracking");
            HSContext.getInstance().getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.24
                @Override // java.lang.Runnable
                public void run() {
                    HSAppLifeCycleController.getInstance().onManualAppBackgroundAPI();
                }
            });
        }
    }

    public static void addUserTrail(final String str) {
        if (!HSContext.verifyInstall() || Utils.isEmpty(str)) {
            return;
        }
        HSLogger.d(TAG, "addUserTrail() is called for User tracking for clients");
        final HSContext hSContext = HSContext.getInstance();
        hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.Helpshift.25
            @Override // java.lang.Runnable
            public void run() {
                HSContext.this.getConfigManager().addUserTrail(str);
            }
        });
    }

    public static void closeSession() {
        HSLogger.d(TAG, "closeSession: called");
        if (HSContext.verifyInstall()) {
            HSContext.getInstance().closeHSActivities();
        }
    }
}
