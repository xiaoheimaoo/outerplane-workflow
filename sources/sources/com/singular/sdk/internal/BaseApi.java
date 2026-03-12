package com.singular.sdk.internal;

import com.singular.sdk.internal.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class BaseApi extends SingularMap implements Api {
    static final String TIMESTAMP_KEY = "__TIMESTAMP__";
    static final String TYPE_KEY = "__TYPE__";
    private static final SingularLog logger = SingularLog.getLogger("BaseApi");

    public BaseApi(String str, long j) {
        put(TYPE_KEY, str);
        put(TIMESTAMP_KEY, String.valueOf(j));
    }

    Map<String, String> getParams() {
        HashMap hashMap = new HashMap(this);
        hashMap.remove(TYPE_KEY);
        hashMap.remove(TIMESTAMP_KEY);
        return hashMap;
    }

    public boolean isAdmonEvent() {
        try {
            String str = (String) get(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY);
            if (str != null) {
                return new JSONObject(str).getBoolean(Constants.ADMON_IS_ADMON_REVENUE);
            }
            return false;
        } catch (Throwable th) {
            logger.debug("Not an admon event: " + th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addParams(Map<String, String> map) {
        if (map == null) {
            return;
        }
        putAll(map);
    }

    public String getType() {
        return (String) get(TYPE_KEY);
    }

    public long getTimestamp() {
        String str = (String) get(TIMESTAMP_KEY);
        if (Utils.isEmptyOrNull(str)) {
            return -1L;
        }
        return Long.parseLong(str);
    }

    public String getUrl() {
        return "https://sdk-api-v1.singular.net/api/v1" + getPath();
    }

    public boolean makeRequest(SingularInstance singularInstance) throws IOException {
        tryMigrateEventToSdid(singularInstance);
        return SingularRequestHandler.makeRequest(singularInstance, getUrl(), getParams(), getTimestamp(), getOnApiCallback());
    }

    private void tryMigrateEventToSdid(SingularInstance singularInstance) {
        try {
            if (!getParams().containsKey(Constants.RequestParamsKeys.SESSION_ID_KEY)) {
                logger.debug("BaseApi: no 's' param in api");
            } else if (Long.parseLong(getParams().get(Constants.RequestParamsKeys.SESSION_ID_KEY)) >= singularInstance.getSessionId()) {
                if (getParams().get(Constants.RequestParamsKeys.IDENTIFIER_KEYSPACE_KEY).equalsIgnoreCase("sdid")) {
                    logger.debug("BaseApi: not migrated, this api already has k=SDID");
                    return;
                }
                if (DeviceIDManager.getInstance().getActualSdid(ConfigManager.getInstance(), singularInstance.getContext()) != null) {
                    putAll(new SingularParamsBase().withDeviceInfo(singularInstance));
                    logger.debug("BaseApi: migrated api to k=SDID");
                }
            }
        } catch (Throwable unused) {
            logger.error("BaseApi: failed to migrate event to SDID");
        }
    }

    public String toJsonAsString() {
        return new JSONObject(this).toString();
    }

    public static BaseApi from(String str) throws IOException, NullPointerException {
        if (str == null) {
            throw new NullPointerException("api string cannot be null");
        }
        Map<String, String> fromString = fromString(str);
        String str2 = fromString.get(TYPE_KEY);
        String str3 = fromString.get(TIMESTAMP_KEY);
        long parseLong = !Utils.isEmptyOrNull(str3) ? Long.parseLong(str3) : -1L;
        int andIncrementRetryCountForKey = Utils.getAndIncrementRetryCountForKey(SingularInstance.getInstance().getContext(), str3);
        if (andIncrementRetryCountForKey > 3) {
            fromString.put(Constants.RETRY_COUNT, String.valueOf(andIncrementRetryCountForKey));
        }
        if (Constants.API_TYPE_CONFIG.equalsIgnoreCase(str2)) {
            ApiConfig apiConfig = new ApiConfig(parseLong);
            apiConfig.addParams(fromString);
            return apiConfig;
        } else if (Constants.API_TYPE_EVENT.equalsIgnoreCase(str2)) {
            ApiSubmitEvent apiSubmitEvent = new ApiSubmitEvent(parseLong);
            apiSubmitEvent.addParams(fromString);
            return apiSubmitEvent;
        } else if (Constants.API_TYPE_SESSION_START.equalsIgnoreCase(str2)) {
            ApiStartSession apiStartSession = new ApiStartSession(parseLong);
            apiStartSession.addParams(fromString);
            return apiStartSession;
        } else if (Constants.API_TYPE_GDPR_CONSENT.equalsIgnoreCase(str2)) {
            ApiGDPRConsent apiGDPRConsent = new ApiGDPRConsent(parseLong);
            apiGDPRConsent.addParams(fromString);
            return apiGDPRConsent;
        } else if (Constants.API_TYPE_GDPR_UNDER_13.equalsIgnoreCase(str2)) {
            ApiGDPRUnder13 apiGDPRUnder13 = new ApiGDPRUnder13(parseLong);
            apiGDPRUnder13.addParams(fromString);
            return apiGDPRUnder13;
        } else if (Constants.API_TYPE_CUSTOM_USER_ID.equalsIgnoreCase(str2)) {
            ApiCustomUserId apiCustomUserId = new ApiCustomUserId(parseLong);
            apiCustomUserId.addParams(fromString);
            return apiCustomUserId;
        } else {
            throw new InvalidPropertiesFormatException(String.format("Unknown type = %s", str2));
        }
    }

    private static Map<String, String> fromString(String str) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, (String) jSONObject.get(next));
            }
            return hashMap;
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }
}
