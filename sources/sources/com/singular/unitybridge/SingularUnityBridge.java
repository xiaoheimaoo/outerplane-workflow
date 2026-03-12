package com.singular.unitybridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.appsflyer.AppsFlyerProperties;
import com.helpshift.util.ConfigValues;
import com.singular.sdk.DeferredDeepLinkHandler;
import com.singular.sdk.SDIDAccessorHandler;
import com.singular.sdk.ShortLinkHandler;
import com.singular.sdk.Singular;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.SingularDeviceAttributionHandler;
import com.singular.sdk.SingularLinkHandler;
import com.singular.sdk.SingularLinkParams;
import com.singular.sdk.internal.Constants;
import com.unity3d.player.UnityPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SingularUnityBridge {
    private static final String SINGULAR_SDK_UNITY_OBJECT_NAME = "SingularSDKObject";
    static SingularConfig config = null;
    static int currentIntentHash = 0;
    private static final String logTag = "SINGULAR_UNITY";

    public static void onNewIntent(final Intent intent) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.1
            @Override // java.lang.Runnable
            public void run() {
                if (SingularUnityBridge.config == null || intent.hashCode() == SingularUnityBridge.currentIntentHash) {
                    return;
                }
                SingularUnityBridge.currentIntentHash = intent.hashCode();
                Intent intent2 = intent;
                if (intent2 == null || intent2.getData() == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
                    return;
                }
                SingularUnityBridge.config.withSingularLink(intent, SingularUnityBridge.config.linkCallback, SingularUnityBridge.config.shortlinkTimeoutSec);
                Singular.init(UnityPlayer.currentActivity.getApplicationContext(), SingularUnityBridge.config);
            }
        });
    }

    public static void init(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("apiKey", null);
            String optString2 = jSONObject.optString("secret", null);
            if (optString != null && optString2 != null) {
                Context applicationContext = UnityPlayer.currentActivity.getApplicationContext();
                SingularConfig singularConfig = new SingularConfig(optString, optString2);
                String optString3 = jSONObject.optString("facebookAppId", null);
                if (!TextUtils.isEmpty(optString3)) {
                    singularConfig.withFacebookAppId(optString3);
                }
                String optString4 = jSONObject.optString(Constants.PREF_CSI_REFERRER_KEY, null);
                if (!TextUtils.isEmpty(optString4)) {
                    singularConfig.withOpenURI(Uri.parse(optString4));
                }
                if (jSONObject.optBoolean("enableDeferredDeepLinks", false)) {
                    singularConfig.withDDLHandler(new DeferredDeepLinkHandler() { // from class: com.singular.unitybridge.SingularUnityBridge.2
                        @Override // com.singular.sdk.DeferredDeepLinkHandler
                        public void handleLink(final String str2) {
                            UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    String str3 = str2;
                                    if (str3 == null) {
                                        UnityPlayer.UnitySendMessage(SingularUnityBridge.SINGULAR_SDK_UNITY_OBJECT_NAME, "DeepLinkHandler", "");
                                    } else {
                                        UnityPlayer.UnitySendMessage(SingularUnityBridge.SINGULAR_SDK_UNITY_OBJECT_NAME, "DeepLinkHandler", str3);
                                    }
                                }
                            });
                        }
                    });
                    long optLong = jSONObject.optLong("ddlTimeoutSec", 0L);
                    if (optLong > 0) {
                        singularConfig.withDDLTimeoutInSec(optLong);
                    }
                }
                SingularLinkHandler singularLinkHandler = new SingularLinkHandler() { // from class: com.singular.unitybridge.SingularUnityBridge.3
                    @Override // com.singular.sdk.SingularLinkHandler
                    public void onResolved(final SingularLinkParams singularLinkParams) {
                        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("deeplink", singularLinkParams.getDeeplink());
                                    jSONObject2.put("passthrough", singularLinkParams.getPassthrough());
                                    jSONObject2.put("is_deferred", singularLinkParams.isDeferred());
                                    if (singularLinkParams.getUrlParameters() != null) {
                                        jSONObject2.putOpt("url_parameters", new JSONObject(singularLinkParams.getUrlParameters()));
                                    }
                                } catch (JSONException e) {
                                    Log.d(SingularUnityBridge.logTag, "Unable to create json object with error:" + e.getMessage());
                                }
                                UnityPlayer.UnitySendMessage(SingularUnityBridge.SINGULAR_SDK_UNITY_OBJECT_NAME, "SingularLinkHandlerResolved", jSONObject2.toString());
                            }
                        });
                    }
                };
                Intent intent = UnityPlayer.currentActivity.getIntent();
                currentIntentHash = intent.hashCode();
                long optLong2 = jSONObject.optLong("shortlinkResolveTimeout", 0L);
                if (optLong2 > 0) {
                    singularConfig.withSingularLink(intent, singularLinkHandler, optLong2);
                } else {
                    singularConfig.withSingularLink(intent, singularLinkHandler);
                }
                if (jSONObject.optBoolean(ConfigValues.ENABLE_LOGGING, false)) {
                    singularConfig.withLoggingEnabled();
                }
                int optInt = jSONObject.optInt("logLevel", -1);
                if (optInt >= 0) {
                    singularConfig.withLogLevel(optInt);
                }
                String optString5 = jSONObject.optString("fcmDeviceToken", null);
                if (optString5 != null) {
                    singularConfig.withFCMDeviceToken(optString5);
                }
                long optLong3 = jSONObject.optLong("sessionTimeoutSec", 0L);
                if (optLong3 > 0) {
                    singularConfig.withSessionTimeoutInSec(optLong3);
                }
                String optString6 = jSONObject.optString("customUserId", null);
                if (optString6 != null) {
                    singularConfig.withCustomUserId(optString6);
                }
                String optString7 = jSONObject.optString(Constants.DeviceIdentifierKeyspaceKeys.IMEI_KEYSPACE_KEY, null);
                if (optString7 != null) {
                    singularConfig.withIMEI(optString7);
                }
                if (jSONObject.optBoolean(AppsFlyerProperties.COLLECT_OAID, false)) {
                    singularConfig.withOAIDCollection();
                }
                if (jSONObject.has("limitDataSharing")) {
                    singularConfig.withLimitDataSharing(jSONObject.optBoolean("limitDataSharing"));
                }
                singularConfig.limitedIdentifiresEnabled = Boolean.valueOf(jSONObject.optBoolean("limitedIdentifiersEnabled", false));
                JSONObject optJSONObject = jSONObject.optJSONObject("globalProperties");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        JSONObject jSONObject2 = optJSONObject.getJSONObject(keys.next());
                        String optString8 = jSONObject2.optString("Key", "");
                        if (optString8 != null && !optString8.trim().equals("")) {
                            singularConfig.withGlobalProperty(optString8, jSONObject2.optString("Value", ""), jSONObject2.optBoolean("OverrideExisting", false));
                        }
                    }
                }
                singularConfig.withCustomSdid(jSONObject.optString("customSdid", null), new SDIDAccessorHandler() { // from class: com.singular.unitybridge.SingularUnityBridge.4
                    @Override // com.singular.sdk.SDIDAccessorHandler
                    public void didSetSdid(final String str2) {
                        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                UnityPlayer.UnitySendMessage(SingularUnityBridge.SINGULAR_SDK_UNITY_OBJECT_NAME, "SingularDidSetSdid", str2);
                            }
                        });
                    }

                    @Override // com.singular.sdk.SDIDAccessorHandler
                    public void sdidReceived(final String str2) {
                        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.4.2
                            @Override // java.lang.Runnable
                            public void run() {
                                UnityPlayer.UnitySendMessage(SingularUnityBridge.SINGULAR_SDK_UNITY_OBJECT_NAME, "SingularSdidReceived", str2);
                            }
                        });
                    }
                });
                config = singularConfig;
                singularConfig.withSingularDeviceAttribution(new SingularDeviceAttributionHandler() { // from class: com.singular.unitybridge.SingularUnityBridge.5
                    @Override // com.singular.sdk.SingularDeviceAttributionHandler
                    public void onDeviceAttributionInfoReceived(Map<String, Object> map) {
                        UnityPlayer.UnitySendMessage(SingularUnityBridge.SINGULAR_SDK_UNITY_OBJECT_NAME, "SingularDeviceAttributionCallback", new JSONObject(map).toString());
                    }
                });
                Singular.init(applicationContext, singularConfig);
            }
        } catch (Throwable th) {
            Log.d(logTag, th.getMessage());
        }
    }

    public static void createReferrerShortLink(String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str4);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        Singular.createReferrerShortLink(str, str2, str3, jSONObject, new ShortLinkHandler() { // from class: com.singular.unitybridge.SingularUnityBridge.6
            @Override // com.singular.sdk.ShortLinkHandler
            public void onSuccess(final String str5) {
                UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("data", str5);
                            jSONObject2.put("error", (Object) null);
                        } catch (JSONException e2) {
                            Log.d(SingularUnityBridge.logTag, "Unable to create json object with error:" + e2.getMessage());
                        }
                        UnityPlayer.UnitySendMessage(SingularUnityBridge.SINGULAR_SDK_UNITY_OBJECT_NAME, "ShortLinkResolved", jSONObject2.toString());
                    }
                });
            }

            @Override // com.singular.sdk.ShortLinkHandler
            public void onError(String str5) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("data", (Object) null);
                    jSONObject2.put("error", str5);
                } catch (JSONException e2) {
                    Log.d(SingularUnityBridge.logTag, "Unable to create json object with error:" + e2.getMessage());
                }
                UnityPlayer.UnitySendMessage(SingularUnityBridge.SINGULAR_SDK_UNITY_OBJECT_NAME, "ShortLinkResolved", jSONObject2.toString());
            }
        });
    }

    public static void revenueWithAttributes(String str, String str2, String str3) {
        try {
            Singular.revenue(str, Double.parseDouble(str2), jsonStringToMap(str3));
        } catch (Exception e) {
            Log.d(logTag, "Unable to send revenue event with error:" + e.getMessage());
        }
    }

    public static void customRevenueWithAttributes(String str, String str2, String str3, String str4) {
        try {
            Singular.customRevenue(str, str2, Double.parseDouble(str3), jsonStringToMap(str4));
        } catch (Exception e) {
            Log.d(logTag, "Unable to send custom revenue event with error:" + e.getMessage());
        }
    }

    private static Map<String, Object> jsonStringToMap(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        } catch (Exception e) {
            Log.d(logTag, "Unable to transform json string to Map with error:" + e.getMessage());
        }
        return hashMap;
    }
}
