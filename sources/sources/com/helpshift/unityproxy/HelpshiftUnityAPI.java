package com.helpshift.unityproxy;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.util.Log;
import com.helpshift.HSPluginEventBridge;
import com.helpshift.Helpshift;
import com.helpshift.HelpshiftAuthenticationFailureReason;
import com.helpshift.HelpshiftEventsListener;
import com.helpshift.HelpshiftUserLoginEventsListener;
import com.helpshift.UnsupportedOSVersionException;
import com.helpshift.log.HSLogger;
import com.helpshift.proactive.HelpshiftProactiveAPIConfigCollector;
import com.helpshift.unityproxy.storage.HelpshiftUnityStorage;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class HelpshiftUnityAPI {
    public static String TAG = "Helpshift_UnityAPI";
    private static HelpshiftEventDelegate helpshiftEventDelegate;
    private static HelpshiftProactiveConfigEventDelegate helpshiftProactiveConfigEventDelegate;
    private static final Map<String, Object> proactiveLocalConfigMap = new HashMap();
    private static final HelpshiftProactiveAPIConfigCollector helpshiftProactiveAPIConfigCollectorCallback = new HelpshiftProactiveAPIConfigCollector() { // from class: com.helpshift.unityproxy.HelpshiftUnityAPI.1
        @Override // com.helpshift.proactive.HelpshiftProactiveAPIConfigCollector
        public Map<String, Object> getAPIConfig() {
            if (HelpshiftUnityAPI.helpshiftProactiveConfigEventDelegate != null) {
                HelpshiftUnityAPI.proactiveLocalConfigMap.clear();
                HelpshiftUnityAPI.proactiveLocalConfigMap.putAll(HelpshiftUnityAPI.getSanitisedApiConfig(HelpshiftUnityAPI.helpshiftProactiveConfigEventDelegate.getApiConfigString()));
            }
            return HelpshiftUnityAPI.proactiveLocalConfigMap;
        }
    };

    private HelpshiftUnityAPI() {
    }

    public static void installWithCachedValues(Application application, String str, String str2, Map<String, Object> map) {
        try {
            Helpshift.install(application, str, str2, map);
        } catch (UnsupportedOSVersionException unused) {
            Log.e(TAG, "install() called on the OS version: " + Build.VERSION.SDK_INT + " is not supported");
        }
    }

    public static void install(Application application, String str, String str2, Map<String, Object> map) {
        install(application, str, str2, JsonUtils.mapToJsonString(map));
    }

    public static void install(Application application, String str, String str2, String str3) {
        HSPluginEventBridge.setPluginEventsAPI(new UnityPluginAPIEventsBridge());
        HelpshiftUnityStorage helpshiftUnityStorage = HelpshiftUnityStorage.getInstance(application);
        helpshiftUnityStorage.putJsonStringOfMap(HelpshiftUnityStorage.INSTALL_CONFIG, str3);
        helpshiftUnityStorage.put(HelpshiftUnityStorage.DOMAIN_NAME, str2);
        helpshiftUnityStorage.put(HelpshiftUnityStorage.PLATFORM_ID, str);
        try {
            Helpshift.install(application, str, str2, JsonUtils.jsonStringToMap(str3));
            Helpshift.setHelpshiftProactiveConfigCollector(helpshiftProactiveAPIConfigCollectorCallback);
        } catch (UnsupportedOSVersionException unused) {
            Log.e(TAG, "install() called on the OS version: " + Build.VERSION.SDK_INT + " is not supported");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> getSanitisedApiConfig(String str) {
        if (Utils.isEmpty(str)) {
            return new HashMap();
        }
        try {
            return JsonUtils.parseConfigDictionary(str);
        } catch (JSONException e) {
            Log.e(TAG, "Error in parsing the Config from Unity", e);
            return new HashMap();
        }
    }

    public static void addUserTrail(String str) {
        Helpshift.addUserTrail(str);
    }

    public static void loginWithIdentity(String str, String str2, final HelpshiftLoginEventDelegate helpshiftLoginEventDelegate) {
        Helpshift.loginWithIdentity(str, getSanitisedApiConfig(str2), new HelpshiftUserLoginEventsListener() { // from class: com.helpshift.unityproxy.HelpshiftUnityAPI.2
            @Override // com.helpshift.HelpshiftUserLoginEventsListener
            public void onLoginSuccess() {
                HelpshiftLoginEventDelegate helpshiftLoginEventDelegate2 = HelpshiftLoginEventDelegate.this;
                if (helpshiftLoginEventDelegate2 != null) {
                    helpshiftLoginEventDelegate2.onLoginSuccess();
                }
            }

            @Override // com.helpshift.HelpshiftUserLoginEventsListener
            public void onLoginFailure(String str3, Map<String, String> map) {
                if (HelpshiftLoginEventDelegate.this != null) {
                    HelpshiftLoginEventDelegate.this.onLoginFailure(str3, Utils.isEmpty(map) ? "{}" : JsonUtils.mapToJsonString(map));
                }
            }
        });
    }

    public static void addUserIdentities(String str) {
        Helpshift.addUserIdentities(str);
    }

    public static void updateAppAttributes(String str) {
        Helpshift.updateAppAttributes(getSanitisedApiConfig(str));
    }

    public static void updateMasterAttributes(String str) {
        Helpshift.updateMasterAttributes(getSanitisedApiConfig(str));
    }

    public static void showConversationUnity(Activity activity, String str) {
        Helpshift.showConversation(activity, getSanitisedApiConfig(str));
    }

    public static void showFAQsUnity(Activity activity, String str) {
        Helpshift.showFAQs(activity, getSanitisedApiConfig(str));
    }

    public static void showSingleFAQUnity(Activity activity, String str, String str2) {
        Helpshift.showSingleFAQ(activity, str, getSanitisedApiConfig(str2));
    }

    public static void showFAQSectionUnity(Activity activity, String str, String str2) {
        Helpshift.showFAQSection(activity, str, getSanitisedApiConfig(str2));
    }

    public static void requestUnreadMessageCountUnity(boolean z) {
        Helpshift.requestUnreadMessageCount(z);
    }

    public static void setLanguage(String str) {
        Helpshift.setLanguage(str);
    }

    public static void leaveBreadCrumb(String str) {
        Helpshift.leaveBreadCrumb(str);
    }

    public static void clearBreadCrumbs() {
        Helpshift.clearBreadCrumbs();
    }

    public static boolean login(String str) {
        if (JsonUtils.isValidJsonString(str)) {
            return Helpshift.login(JsonUtils.jsonStringToStringMap(str));
        }
        return false;
    }

    public static void logout() {
        Helpshift.logout();
    }

    @Deprecated
    public static void clearAnonymousUserOnLogin() {
        Helpshift.clearAnonymousUserOnLogin();
    }

    public static void clearAnonymousUserOnLogin(boolean z) {
        Helpshift.clearAnonymousUserOnLogin(z);
    }

    public static void registerPushToken(String str) {
        if (Utils.isNotEmpty(str)) {
            Helpshift.registerPushToken(str);
        }
    }

    public static void handlePush(String str) {
        if (Utils.isEmpty(str) || !JsonUtils.isValidJsonString(str)) {
            return;
        }
        Helpshift.handlePush(JsonUtils.jsonStringToStringMap(str));
    }

    public static void handleProactiveLink(String str) {
        Helpshift.handleProactiveLink(str);
    }

    public static void closeSession() {
        Helpshift.closeSession();
    }

    public static void setHelpshiftEventsListener(HelpshiftEventDelegate helpshiftEventDelegate2) {
        if (helpshiftEventDelegate2 == null) {
            return;
        }
        helpshiftEventDelegate = helpshiftEventDelegate2;
        Helpshift.setHelpshiftEventsListener(new HelpshiftEventsListener() { // from class: com.helpshift.unityproxy.HelpshiftUnityAPI.3
            @Override // com.helpshift.HelpshiftEventsListener
            public void onEventOccurred(String str, Map<String, Object> map) {
                if (HelpshiftUnityAPI.helpshiftEventDelegate != null) {
                    HelpshiftUnityAPI.helpshiftEventDelegate.onEventOccurred(str, JsonUtils.mapToJsonString(map));
                }
            }

            @Override // com.helpshift.HelpshiftEventsListener
            public void onUserAuthenticationFailure(HelpshiftAuthenticationFailureReason helpshiftAuthenticationFailureReason) {
                if (HelpshiftUnityAPI.helpshiftEventDelegate != null) {
                    HelpshiftUnityAPI.helpshiftEventDelegate.onUserAuthenticationFailure(helpshiftAuthenticationFailureReason.ordinal());
                }
            }
        });
    }

    public static void setHelpshiftProactiveEventsListener(HelpshiftProactiveConfigEventDelegate helpshiftProactiveConfigEventDelegate2) {
        HSLogger.d(TAG, "Event delegate registered for proactive config");
        helpshiftProactiveConfigEventDelegate = helpshiftProactiveConfigEventDelegate2;
    }
}
