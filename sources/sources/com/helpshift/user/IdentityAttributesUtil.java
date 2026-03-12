package com.helpshift.user;

import com.helpshift.HelpshiftEvent;
import com.helpshift.chat.HSEventProxy;
import com.helpshift.log.HSLogger;
import com.helpshift.platform.Device;
import com.helpshift.user.error.InvalidDataErrorReason;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import com.helpshift.util.ValuePair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class IdentityAttributesUtil {
    public static final int MAX_ENTRIES_IDENTITY = 100;
    public static final int MAX_LENGTH_IN_MAP_ATTRIBUTE = 100000;
    public static final int MAX_LENGTH_PER_KEY = 1000;
    public static final int MAX_LENGTH_PER_VALUE = 10000;
    public static final int MAX_UNSYNC_STORAGE_LIMIT = 1000;
    private static final String TAG = "IdentityAttributesManager";
    private static final String ATTRIBUTE_APP_VERSION = "app_version";
    private static final String ATTRIBUTE_SDK_VERSION = "sdk_version";
    private static final String ATTRIBUTE_OS_VERSION = "os_version";
    private static final String ATTRIBUTE_DEVICE_MODEL = "device_model";
    public static final List<String> sdkCollectibleAttributeKeys = new ArrayList(Arrays.asList(ATTRIBUTE_APP_VERSION, ATTRIBUTE_SDK_VERSION, ATTRIBUTE_OS_VERSION, ATTRIBUTE_DEVICE_MODEL));

    private IdentityAttributesUtil() {
    }

    public static void updateMasterAttributes(BaseUser baseUser, Map<String, Object> map, HSEventProxy hSEventProxy) {
        if (!(baseUser instanceof UserWithIdentity)) {
            HSLogger.d(TAG, "Can't update master attributes. Invalid user type");
            return;
        }
        UserWithIdentity userWithIdentity = (UserWithIdentity) baseUser;
        HashMap hashMap = new HashMap(map);
        hashMap.remove("");
        hashMap.remove(null);
        castPrimitiveValuesToString(hashMap);
        Utils.removeNullValues(hashMap);
        if (hashMap.isEmpty()) {
            HSLogger.d(TAG, "Can't update master attributes. Received empty data");
        } else if (hashMap.size() > 100) {
            HSLogger.d(TAG, "Can't update master attributes. Received max entries");
            hSEventProxy.sendEvent(HelpshiftEvent.MASTER_ATTRIBUTES_LIMIT_EXCEEDED, null);
        } else {
            List<ValuePair<String, String>> validateMasterOrAppAttributes = validateMasterOrAppAttributes(hashMap);
            if (validateMasterOrAppAttributes.size() > 0) {
                sendUserIdentityAttributeFailureEvent(HelpshiftEvent.MASTER_ATTRIBUTES_VALIDATION_FAILED, validateMasterOrAppAttributes, hSEventProxy);
            } else if (userWithIdentity.getUnsyncedMasterAttributes().size() > 1000) {
                HSLogger.d(TAG, "UnSync storage limit for master attributes exceeded");
            } else {
                userWithIdentity.addUnsyncedMasterAttributes(hashMap);
            }
        }
    }

    public static void updateAppAttributes(BaseUser baseUser, Map<String, Object> map, HSEventProxy hSEventProxy) {
        if (!(baseUser instanceof UserWithIdentity)) {
            HSLogger.d(TAG, "Can't update app attributes. Invalid user type");
            return;
        }
        UserWithIdentity userWithIdentity = (UserWithIdentity) baseUser;
        HashMap hashMap = new HashMap(map);
        hashMap.remove("");
        hashMap.remove(null);
        castPrimitiveValuesToString(hashMap);
        Utils.removeNullValues(hashMap);
        if (hashMap.isEmpty()) {
            HSLogger.d(TAG, "Can't update app attributes. Received empty data");
        } else if (hashMap.size() > 100) {
            HSLogger.d(TAG, "Can't update app attributes. Received max entries");
            hSEventProxy.sendEvent(HelpshiftEvent.APP_ATTRIBUTES_LIMIT_EXCEEDED, null);
        } else {
            List<ValuePair<String, String>> validateMasterOrAppAttributes = validateMasterOrAppAttributes(hashMap);
            if (validateMasterOrAppAttributes.size() > 0) {
                HSLogger.d(TAG, "Can't update app attributes. Validation failed");
                sendUserIdentityAttributeFailureEvent(HelpshiftEvent.APP_ATTRIBUTES_VALIDATION_FAILED, validateMasterOrAppAttributes, hSEventProxy);
            } else if (userWithIdentity.getUnsyncAppAttributes().size() > 1000) {
                HSLogger.d(TAG, "UnSync storage limit for app attributes exceeded");
            } else {
                userWithIdentity.removeExistingAppAttributes(hashMap, sdkCollectibleAttributeKeys);
                if (hashMap.isEmpty()) {
                    return;
                }
                userWithIdentity.addUnsyncedAppAttributes(hashMap);
            }
        }
    }

    static List<ValuePair<String, String>> validateMasterOrAppAttributes(Map<String, Object> map) {
        cleanDataMap(map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key.length() > 1000) {
                arrayList.add(ValuePair.from(key, InvalidDataErrorReason.EXCEEDED_KEY_LENGTH_LIMIT));
            } else {
                String validateValueByType = validateValueByType(value);
                if (Utils.isNotEmpty(validateValueByType)) {
                    arrayList.add(ValuePair.from(key, validateValueByType));
                }
            }
        }
        return arrayList;
    }

    private static void cleanDataMap(Map<String, Object> map) {
        map.remove("");
        map.remove(null);
    }

    private static String validateValueByType(Object obj) {
        if (obj instanceof String) {
            return validateStringValue((String) obj);
        }
        if (obj instanceof List) {
            return validateListInAttributes(obj);
        }
        if (obj instanceof Map) {
            return validateMapInAttributes(obj);
        }
        return null;
    }

    private static String validateStringValue(String str) {
        if (str.length() > 10000) {
            return InvalidDataErrorReason.EXCEEDED_VALUE_LENGTH_LIMIT;
        }
        return null;
    }

    static void castPrimitiveValuesToString(Map<String, Object> map) {
        if (Utils.isEmpty(map)) {
            return;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof Map) {
                        for (Map.Entry entry2 : ((Map) value).entrySet()) {
                            entry2.setValue(String.valueOf(entry2.getValue()));
                        }
                    } else if (!(value instanceof List)) {
                        entry.setValue(String.valueOf(value));
                    }
                }
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Error transforming map values to a string.", e);
        }
    }

    private static String validateMapInAttributes(Object obj) {
        try {
            Map map = (Map) obj;
            if (map.size() > 100) {
                return InvalidDataErrorReason.EXCEEDED_COUNT_LIMIT;
            }
            map.remove("");
            map.remove(null);
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (((String) entry.getKey()).length() > 1000) {
                    return InvalidDataErrorReason.EXCEEDED_KEY_LENGTH_LIMIT;
                }
                if ((value instanceof String) && ((String) value).length() > 100000) {
                    return InvalidDataErrorReason.EXCEEDED_VALUE_LENGTH_LIMIT;
                }
                if (!(value instanceof String) && !(value instanceof Boolean) && !(value instanceof Number)) {
                    return InvalidDataErrorReason.INVALID_VALUE_TYPE;
                }
            }
            return "";
        } catch (Exception e) {
            HSLogger.e(TAG, "Incorrect type of Map in attributes", e);
            return InvalidDataErrorReason.INVALID_VALUE_TYPE;
        }
    }

    private static String validateListInAttributes(Object obj) {
        try {
            List<String> list = (List) obj;
            if (list.size() > 100) {
                return InvalidDataErrorReason.EXCEEDED_COUNT_LIMIT;
            }
            list.removeAll(Arrays.asList("", null));
            for (String str : list) {
                if (str.length() > 10000) {
                    return InvalidDataErrorReason.EXCEEDED_VALUE_LENGTH_LIMIT;
                }
            }
            return "";
        } catch (Exception e) {
            HSLogger.e(TAG, "Incorrect type of List in attributes", e);
            return InvalidDataErrorReason.INVALID_VALUE_TYPE;
        }
    }

    public static void sendUserIdentityAttributeFailureEvent(String str, List<ValuePair<String, String>> list, HSEventProxy hSEventProxy) {
        if (Utils.isEmpty(str)) {
            return;
        }
        if (Utils.isEmpty(list)) {
            list = new ArrayList<>();
        }
        HashMap hashMap = new HashMap();
        for (ValuePair<String, String> valuePair : list) {
            hashMap.put(valuePair.first, valuePair.second);
        }
        hSEventProxy.sendEvent(str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<ValuePair<String, String>> getValuePairsFromArray(JSONArray jSONArray, String str) {
        ArrayList arrayList = new ArrayList();
        if (JsonUtils.isEmpty(jSONArray)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(ValuePair.from(jSONArray.getString(i), str));
            } catch (Exception e) {
                HSLogger.e(TAG, "Error converting json array to list of valuepairs", e);
            }
        }
        return arrayList;
    }

    public static void collectAndStoreSDKCollectibleAttributes(BaseUser baseUser, Device device, HSEventProxy hSEventProxy) {
        if (baseUser instanceof UserWithIdentity) {
            HashMap hashMap = new HashMap();
            hashMap.put(ATTRIBUTE_APP_VERSION, device.getAppVersion());
            hashMap.put(ATTRIBUTE_SDK_VERSION, device.getSDKVersion());
            hashMap.put(ATTRIBUTE_OS_VERSION, device.getOSVersion());
            hashMap.put(ATTRIBUTE_DEVICE_MODEL, device.getDeviceModel());
            updateAppAttributes(baseUser, hashMap, hSEventProxy);
        }
    }
}
