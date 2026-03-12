package com.helpshift.util;

import com.google.android.gms.ads.AdError;
import com.helpshift.log.HSLogger;
import com.helpshift.platform.Device;
import com.singular.sdk.internal.Constants;
import java.io.Closeable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class Utils {
    public static final int FALLBACK_ACTIVE_REMOTE_FETCH_INTERVAL = 60000;
    public static final int FALLBACK_BASE_POLLING_INTERVAL = 5000;
    public static final int FALLBACK_MAX_POLLING_INTERVAL = 60000;
    public static final int FALLBACK_PASSIVE_REMOTE_FETCH_INTERVAL = 300000;
    public static final String ORIGIN_LOGIN_WITH_ANONYMOUS_USER = "sdkx_login_with_anonymous_user";
    public static final String ORIGIN_LOGIN_WITH_USER = "sdkx_login_with_user";
    public static final String ORIGIN_POLLER = "sdkx_polling";
    public static final String ORIGIN_REGISTER_PUSH_TOKEN = "sdkx_register_push_token";
    public static final String ORIGIN_REQUEST_UNREAD_COUNT = "sdkx_request_unread_message_count";
    public static final String SDK_WILL_RESPECT_PREVIOUSLY_LOGGED_IN_USER = ". SDK will respect previously logged in user.";
    private static final String TAG = "Utils";
    public static final long TIME_24HRS_MILLIS = 86400000;
    public static final long TIME_7DAYS_MILLIS = 604800000;
    private static ScheduledExecutorService scheduledExecutorService;

    public static void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService2) {
        scheduledExecutorService = scheduledExecutorService2;
    }

    public static <K, V> V getOrDefault(Map<K, V> map, K k, V v) {
        V v2;
        return (isEmpty(map) || (v2 = map.get(k)) == null) ? v : v2;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !isEmpty(map);
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map == null || map.isEmpty();
    }

    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean isEmpty(Set<T> set) {
        return set == null || set.size() == 0;
    }

    public static <T> boolean isNotEmpty(List<T> list) {
        return !isEmpty(list);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static String join(CharSequence charSequence, Iterable<String> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : iterable) {
            if (z) {
                z = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static boolean isToday(long j) {
        return j / TIME_24HRS_MILLIS == System.currentTimeMillis() / TIME_24HRS_MILLIS;
    }

    public static boolean isInvalidUserId(String str) {
        String trim = isEmpty(str) ? "" : str.trim();
        return isEmpty(trim) || "null".equalsIgnoreCase(trim) || AdError.UNDEFINED_DOMAIN.equalsIgnoreCase(trim) || "unknown".equalsIgnoreCase(trim) || "nil".equalsIgnoreCase(trim);
    }

    public static boolean checkValidEmail(String str) {
        if (isEmpty(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf(64);
        int lastIndexOf2 = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf2 == -1 || lastIndexOf2 <= lastIndexOf + 1) ? false : true;
    }

    public static void removeEmptyKeyValues(Map<String, String> map) {
        HashSet<String> hashSet = new HashSet();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (isEmpty(entry.getValue())) {
                hashSet.add(entry.getKey());
            }
        }
        for (String str : hashSet) {
            map.remove(str);
        }
    }

    public static <K, V> void removeNullValues(Map<K, V> map) {
        try {
            ArrayList<Object> arrayList = new ArrayList();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (entry.getValue() == null) {
                    arrayList.add(entry.getKey());
                }
            }
            for (Object obj : arrayList) {
                map.remove(obj);
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in removing null values", e);
        }
    }

    public static boolean validateUserIdEmailForLogin(String str, String str2) {
        if (isEmpty(str) && isEmpty(str2)) {
            HSLogger.e(TAG, "Error logging in the user: userId and userEmail both are empty. userId: " + str + " userEmail: " + str2 + SDK_WILL_RESPECT_PREVIOUSLY_LOGGED_IN_USER);
            return false;
        } else if (isNotEmpty(str) && isInvalidUserId(str)) {
            HSLogger.e(TAG, "Invalid userId: " + str + SDK_WILL_RESPECT_PREVIOUSLY_LOGGED_IN_USER);
            return false;
        } else if (!isNotEmpty(str2) || checkValidEmail(str2)) {
            return true;
        } else {
            HSLogger.e(TAG, "Invalid user email: " + str2 + SDK_WILL_RESPECT_PREVIOUSLY_LOGGED_IN_USER);
            return false;
        }
    }

    public static String prettyFormatHashMap(Map<String, Object> map, int i) {
        if (isEmpty(map)) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        try {
            String indentation = getIndentation(i);
            sb.append(indentation).append("{\n");
            int size = map.entrySet().size();
            int i2 = 0;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                sb.append(indentation).append("  \"").append(entry.getKey()).append("\": ");
                sb.append(formatValue(value, i + 1));
                i2++;
                if (i2 < size) {
                    sb.append(",");
                }
                sb.append("\n");
            }
            sb.append(indentation).append("}");
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in formatting hashmap", e);
        }
        return sb.toString();
    }

    private static String formatValue(Object obj, int i) {
        if (obj == null) {
            return "null (Type: null)";
        }
        if (obj instanceof Map) {
            return "(Type: Map)" + prettyFormatHashMap((Map) obj, i);
        } else if (obj instanceof List) {
            return "(Type: List) " + prettyFormatList((List) obj, i);
        } else if (obj instanceof String) {
            return "\"" + obj + "\" (Type: String)";
        } else {
            return obj + " (Type: " + obj.getClass().getSimpleName() + ")";
        }
    }

    private static String prettyFormatList(List<Object> list, int i) {
        if (list.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[\n");
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 > 0) {
                sb.append(",\n");
            }
            sb.append(getIndentation(i)).append("  ").append(formatValue(list.get(i2), i));
        }
        sb.append("\n").append(getIndentation(i - 1)).append("]");
        return sb.toString();
    }

    private static String getIndentation(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    public static String getMaskedString(String str) {
        if (str == null) {
            return "**null**";
        }
        int length = str.length();
        int ceil = (int) Math.ceil(length * 0.25d);
        String substring = str.substring(0, ceil);
        return substring + "**" + length + "**" + str.substring(length - ceil, length);
    }

    public static String getSHAHash(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(str.getBytes(Constants.ENCODING));
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%02x", Byte.valueOf(digest[i])));
            }
            return sb.toString();
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in getting SHA hash", e);
            return "";
        }
    }

    public static String getSignatureFromJwtToken(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\\.");
        return split.length != 3 ? "" : split[2];
    }

    public static String getPayloadFromJwtToken(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\\.");
        return split.length != 3 ? "" : split[1];
    }

    public static boolean isJWTValid(String str, Device device) {
        if (isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\.");
        return split.length == 3 && !isEmpty(device.decodeBase64(split[1]));
    }

    public static JSONObject getJsonObjectFromJwt(Device device, String str) {
        try {
            return new JSONObject(device.decodeBase64(getPayloadFromJwtToken(str)));
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in decoding JWT", e);
            return null;
        }
    }

    public static Map<String, String> getStringMapFromObjectMap(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                JSONObject value = entry.getValue();
                if (value != null) {
                    if (value instanceof List) {
                        value = new JSONArray((Collection) ((List) value));
                    }
                    if (value instanceof Map) {
                        value = new JSONObject((Map) value);
                    }
                    hashMap.put(key, String.valueOf(value));
                }
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in converting object map to string map", e);
        }
        return hashMap;
    }

    public static void executeWithDelay(Runnable runnable, long j) {
        try {
            scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error scheduling task with delay", e);
            runnable.run();
        }
    }

    public static <K, V> Map<K, V> getDeepCopy(Map<K, V> map) {
        HashMap hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        try {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                K key = entry.getKey();
                V value = entry.getValue();
                if (value instanceof Map) {
                    hashMap.put(key, new HashMap((Map) value));
                } else if (value instanceof List) {
                    hashMap.put(key, new ArrayList((List) value));
                } else {
                    hashMap.put(key, value);
                }
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in copying map", e);
        }
        return hashMap;
    }

    private Utils() {
    }
}
