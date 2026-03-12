package com.helpshift.util;
/* loaded from: classes3.dex */
public class SdkURLs {
    public static String AWS_CACHE_URLS_CONFIG = "https://webchat.helpshift.com/latest/android/android-mapping.json";
    public static String AWS_WEBCHAT_JS = "https://webchat.helpshift.com/latest/android/webChat.js";
    private static final String CACHE_URLS_CONFIG_PATH = "/latest/android/android-mapping.json";
    public static String HC_CACHE_URLS_CONFIG = "https://d2duuy9yo5pldo.cloudfront.net/hc-android-mapping.json";
    private static final String HC_CACHE_URLS_CONFIG_PATH = "/hc-android-mapping.json";
    private static final String HELPCENTER_HOST = "https://d2duuy9yo5pldo.cloudfront.net";
    public static String HELPCENTER_MIDDLEWARE_JS = "https://d2duuy9yo5pldo.cloudfront.net/android/helpcenter.js";
    private static final String HELPCENTER_MIDDLEWARE_JS_PATH = "/android/helpcenter.js";
    private static final String HTTPS_PREFIX = "https://";
    private static final String WEBCHAT_HOST = "https://webchat.helpshift.com";
    private static final String WEBCHAT_JS_PATH = "/latest/android/webChat.js";

    private SdkURLs() {
    }

    public static void updateHosts(String str, String str2) {
        if (!Utils.isEmpty(str)) {
            AWS_WEBCHAT_JS = HTTPS_PREFIX + str + WEBCHAT_JS_PATH;
            AWS_CACHE_URLS_CONFIG = HTTPS_PREFIX + str + CACHE_URLS_CONFIG_PATH;
        }
        if (Utils.isEmpty(str2)) {
            return;
        }
        HELPCENTER_MIDDLEWARE_JS = HTTPS_PREFIX + str2 + HELPCENTER_MIDDLEWARE_JS_PATH;
        HC_CACHE_URLS_CONFIG = HTTPS_PREFIX + str2 + HC_CACHE_URLS_CONFIG_PATH;
    }
}
