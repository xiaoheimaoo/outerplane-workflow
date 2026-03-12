package com.helpshift.network;

import com.google.common.net.HttpHeaders;
import com.helpshift.network.HSRequest;
import com.helpshift.network.exception.HSRootApiException;
import com.helpshift.network.exception.NetworkException;
import com.helpshift.platform.Device;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.user.UserConstants;
import com.helpshift.user.UserWithIdentity;
import com.helpshift.util.Utils;
import com.singular.sdk.internal.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class NetworkUtils {
    private static final String API_VERSION_HEADER = "application/vnd+hsapi-v2+json";
    private static final String CRASH_LOG_PATH = "/sdkx/crash-log";
    private static final String EVENTS_PATH = "/events/v1/";
    private static final String HTTPS_API_PREFIX = "https://api.";
    private static final String IDENTITIES_PATH = "/identity";
    private static final String LOGOUT = "/logout";
    private static final String ROTATE_TOKEN = "/rotate-tokens";
    public static final String SOURCE = "android";
    private static final String WEBSDK_PATH = "/websdk/";
    public static final String X_HS_ACCESS_TOKEN = "x-hs-access-token";

    private NetworkUtils() {
    }

    public static String getAnalyticsAPIRoute(HSPersistentStorage hSPersistentStorage) {
        return HTTPS_API_PREFIX + hSPersistentStorage.getHost() + EVENTS_PATH + hSPersistentStorage.getDomain() + WEBSDK_PATH;
    }

    public static String getCrashLogsRoute(HSPersistentStorage hSPersistentStorage) {
        return HTTPS_API_PREFIX + hSPersistentStorage.getHost() + EVENTS_PATH + hSPersistentStorage.getDomain() + CRASH_LOG_PATH;
    }

    public static String getLoginWithIdentityRoute(HSPersistentStorage hSPersistentStorage) {
        return HTTPS_API_PREFIX + hSPersistentStorage.getHost() + WEBSDK_PATH + hSPersistentStorage.getDomain() + IDENTITIES_PATH;
    }

    public static String getSyncIdentitiesRoute(HSPersistentStorage hSPersistentStorage) {
        return HTTPS_API_PREFIX + hSPersistentStorage.getHost() + WEBSDK_PATH + hSPersistentStorage.getDomain() + IDENTITIES_PATH;
    }

    public static String getRotateTokenRoute(HSPersistentStorage hSPersistentStorage) {
        return HTTPS_API_PREFIX + hSPersistentStorage.getHost() + WEBSDK_PATH + hSPersistentStorage.getDomain() + ROTATE_TOKEN;
    }

    public static String getLogoutRoute(HSPersistentStorage hSPersistentStorage) {
        return HTTPS_API_PREFIX + hSPersistentStorage.getHost() + WEBSDK_PATH + hSPersistentStorage.getDomain() + LOGOUT;
    }

    public static Map<String, String> buildHeaderMap(Device device, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.AUTHORIZATION, "Basic " + device.encodeBase64(str + ":"));
        hashMap.put(HttpHeaders.ACCEPT, API_VERSION_HEADER);
        return hashMap;
    }

    public static String getBodyForPostMethod(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                arrayList.add(URLEncoder.encode(entry.getKey(), Constants.ENCODING) + "=" + URLEncoder.encode(entry.getValue(), Constants.ENCODING));
            } catch (UnsupportedEncodingException e) {
                throw HSRootApiException.wrap(e, NetworkException.UNSUPPORTED_ENCODING_EXCEPTION);
            }
        }
        return Utils.join("&", arrayList);
    }

    public static Map<String, String> cleanDataForNetworkBody(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                hashMap.put(key, value);
            }
        }
        return hashMap;
    }

    public static HSRequest getRequestBodyForRotatingToken(HSPersistentStorage hSPersistentStorage, Device device, Map<String, String> map) {
        return new HSRequest(HSRequest.Method.POST, getRotateTokenRoute(hSPersistentStorage), buildHeaderMap(device, hSPersistentStorage.getPlatformId()), getBodyForPostMethod(cleanDataForNetworkBody(map)), 5000);
    }

    public static HSRequestData getRequestDataForLogout(HSPersistentStorage hSPersistentStorage, UserWithIdentity userWithIdentity, Device device) {
        String currentPushToken = hSPersistentStorage.getCurrentPushToken();
        String refreshToken = userWithIdentity.getRefreshToken();
        String accessToken = userWithIdentity.getAccessToken();
        String platformId = hSPersistentStorage.getPlatformId();
        String deviceId = device.getDeviceId();
        Map<String, String> buildHeaderMap = buildHeaderMap(device, platformId);
        buildHeaderMap.put(X_HS_ACCESS_TOKEN, accessToken);
        HashMap hashMap = new HashMap();
        hashMap.put("did", deviceId);
        hashMap.put("push_token", currentPushToken);
        hashMap.put(UserConstants.REFRESH_TOKEN, refreshToken);
        return new HSRequestData(buildHeaderMap, hashMap);
    }
}
