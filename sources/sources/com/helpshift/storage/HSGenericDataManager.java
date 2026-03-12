package com.helpshift.storage;

import com.helpshift.log.HSLogger;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HSGenericDataManager {
    private static final String ENABLE_LOGGING = "enableLogging";
    private static final String FALLBACK_NOTIFICATION_STRING = "You have new messages";
    private static final String NETWORK_HEADERS = "network_headers";
    private static final String NOTIFICATION_CONTENT = "notification_content";
    private static final String POLLING_ROUTE = "polling_route";
    private static final String PUSH_TOKEN_SYNC_ROUTE = "push_token_sync_route";
    private static final String TAG = "genricDataMngr";
    private static final String USER_DATA_KEY_MAPPING = "user_data_key_mapping";
    private HSPersistentStorage persistentStorage;

    public HSGenericDataManager(HSPersistentStorage hSPersistentStorage) {
        this.persistentStorage = hSPersistentStorage;
    }

    public void saveGenericSdkData(String str) {
        if (Utils.isEmpty(str) || !JsonUtils.isValidJsonString(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            savePollingRoute(extractString(POLLING_ROUTE, jSONObject));
            savePushTokenRoute(extractString(PUSH_TOKEN_SYNC_ROUTE, jSONObject));
            saveNetworkHeaders(extractJsonObject(NETWORK_HEADERS, jSONObject));
            saveNotificationContent(extractJsonObject(NOTIFICATION_CONTENT, jSONObject));
            saveUserDataKeyMapping(extractJsonObject(USER_DATA_KEY_MAPPING, jSONObject));
            saveEnableLoggingData(extractJsonObject("enableLogging", jSONObject));
        } catch (Exception e) {
            HSLogger.e(TAG, "Unable to parse the generic sdk data", e);
        }
    }

    private void saveEnableLoggingData(JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.put("startTime", System.currentTimeMillis());
            this.persistentStorage.setEnableLoggingViaWebchat(jSONObject.toString());
        }
    }

    private void saveUserDataKeyMapping(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.persistentStorage.storeUserDataKeyMapping(jSONObject.toString());
        }
    }

    private void saveNotificationContent(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.persistentStorage.storeNotificationContent(jSONObject.toString());
        }
    }

    private void saveNetworkHeaders(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.persistentStorage.storeNetworkHeaders(jSONObject.toString());
        }
    }

    private void savePushTokenRoute(String str) {
        if (Utils.isNotEmpty(str)) {
            this.persistentStorage.storePushTokenRoute(str);
        }
    }

    private void savePollingRoute(String str) {
        if (Utils.isNotEmpty(str)) {
            this.persistentStorage.storePollingRoute(str);
        }
    }

    private String extractString(String str, JSONObject jSONObject) {
        try {
            return jSONObject.has(str) ? jSONObject.getString(str) : "";
        } catch (JSONException e) {
            HSLogger.e(TAG, "Error in reading the json value for key " + str, e);
            return "";
        }
    }

    private JSONObject extractJsonObject(String str, JSONObject jSONObject) {
        try {
            if (jSONObject.has(str)) {
                return jSONObject.getJSONObject(str);
            }
            return null;
        } catch (JSONException e) {
            HSLogger.e(TAG, "Error in reading the json value for key " + str, e);
            return null;
        }
    }

    public Map<String, String> getNetworkHeaders() {
        return JsonUtils.jsonStringToStringMap(this.persistentStorage.getNetworkHeaders());
    }

    public String getPollingRoute() {
        return this.persistentStorage.getPollingRoute();
    }

    public String getPushTokenSyncRoute() {
        return this.persistentStorage.getPushTokenSyncRoute();
    }

    public Map<String, String> getUserDataKeyMapping() {
        return JsonUtils.jsonStringToStringMap(this.persistentStorage.getUserDataKeyMapping());
    }

    public String getNotificationStringForCount(int i) {
        if (i > 1) {
            return getNotificationString(i, "plural_message");
        }
        return getNotificationString(i, "single_message");
    }

    private String getNotificationString(int i, String str) {
        JSONObject notificationContent = getNotificationContent();
        if (notificationContent == null) {
            return FALLBACK_NOTIFICATION_STRING;
        }
        try {
            return notificationContent.getString(str).replace(notificationContent.getString("placeholder"), String.valueOf(i));
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in constructing unread count string", e);
            return FALLBACK_NOTIFICATION_STRING;
        }
    }

    private JSONObject getNotificationContent() {
        String notificationContent = this.persistentStorage.getNotificationContent();
        if (Utils.isEmpty(notificationContent)) {
            return null;
        }
        try {
            return new JSONObject(notificationContent);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in reading unread count notification content", e);
            return null;
        }
    }
}
