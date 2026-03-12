package com.helpshift.user;

import com.helpshift.HelpshiftEvent;
import com.helpshift.chat.HSEventProxy;
import com.helpshift.log.HSLogger;
import com.helpshift.platform.Device;
import com.helpshift.user.error.InvalidDataErrorReason;
import com.helpshift.user.error.UserLoginFailureReason;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import com.helpshift.util.ValuePair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IdentityValidationUtil {
    private static final String TAG = "IdentityValidationUtils";

    private IdentityValidationUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addUserIdentities(BaseUser baseUser, Device device, String str, HSEventProxy hSEventProxy) {
        if ((baseUser instanceof AnonymousUserWithIdentity) || !(baseUser instanceof UserWithIdentity)) {
            HSLogger.d(TAG, "API call not allowed for user type other than Identity user");
        } else if (!Utils.isJWTValid(str, device)) {
            HSLogger.d(TAG, "Bad identity token.Can't add user identities");
            hSEventProxy.sendEvent("identityTokenInvalid", null);
        } else {
            UserWithIdentity userWithIdentity = (UserWithIdentity) baseUser;
            if (Utils.getSignatureFromJwtToken(str).equals(userWithIdentity.getSignature())) {
                HSLogger.d(TAG, "Skipping call since current user has same identities");
                return;
            }
            JSONObject jsonObjectFromJwt = Utils.getJsonObjectFromJwt(device, str);
            if (JsonUtils.isEmpty(jsonObjectFromJwt)) {
                HSLogger.d(TAG, "Empty json object in token");
                hSEventProxy.sendEvent("identityTokenInvalid", null);
            } else if (jsonObjectFromJwt.optLong("iat", 0L) == 0) {
                HSLogger.d(TAG, "iat is mandatory in token");
                hSEventProxy.sendEvent("iatIsMandatory", null);
            } else if (userWithIdentity.getUnSyncIdentitiesList().size() > 1000) {
                HSLogger.d(TAG, "UnSync storage limit for identities exceeded");
            } else if (!validateAddIdentitiesData(jsonObjectFromJwt, hSEventProxy)) {
                HSLogger.d(TAG, "Invalid Data.Failing addUserIdentities call");
            } else {
                userWithIdentity.addUnSyncIdentities(str);
            }
        }
    }

    private static boolean validateAddIdentitiesData(JSONObject jSONObject, HSEventProxy hSEventProxy) {
        List<InternalIdentity> identitiesFromTokenJsonObject = getIdentitiesFromTokenJsonObject(jSONObject);
        if (Utils.isEmpty(identitiesFromTokenJsonObject)) {
            HSLogger.d(TAG, "Identity data is empty or invalid");
            hSEventProxy.sendEvent("identityTokenInvalid", null);
            return false;
        } else if (identitiesFromTokenJsonObject.size() > 100) {
            HSLogger.d(TAG, "Identity data exceeds limit");
            hSEventProxy.sendEvent(HelpshiftEvent.IDENTITY_DATA_LIMIT_EXCEEDED, null);
            return false;
        } else {
            ArrayList arrayList = new ArrayList(validateIdentityList(identitiesFromTokenJsonObject));
            if (arrayList.isEmpty()) {
                return true;
            }
            HSLogger.d(TAG, "Identity data contains invalid data");
            IdentityAttributesUtil.sendUserIdentityAttributeFailureEvent(HelpshiftEvent.IDENTITY_DATA_INVALID, arrayList, hSEventProxy);
            return false;
        }
    }

    private static List<ValuePair<String, String>> validateIdentityList(List<InternalIdentity> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            InternalIdentity internalIdentity = list.get(i);
            String validateIdentity = validateIdentity(internalIdentity);
            if (!Utils.isEmpty(validateIdentity)) {
                arrayList.add(ValuePair.from(internalIdentity.identityKey, validateIdentity));
            }
        }
        return arrayList;
    }

    private static String validateIdentity(InternalIdentity internalIdentity) {
        return (Utils.isEmpty(internalIdentity.identityKey) || Utils.isEmpty(internalIdentity.identityValue)) ? InvalidDataErrorReason.EMPTY_DATA : internalIdentity.identityKey.length() > 1000 ? InvalidDataErrorReason.EXCEEDED_KEY_LENGTH_LIMIT : internalIdentity.identityValue.length() > 10000 ? InvalidDataErrorReason.EXCEEDED_VALUE_LENGTH_LIMIT : validateIdentityMetaDataMap(internalIdentity.metaData);
    }

    private static String validateIdentityMetaDataMap(Map<String, String> map) {
        if (map.size() > 100) {
            return InvalidDataErrorReason.META_DATA_EXCEEDED_COUNT_LIMIT;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            if (Utils.isEmpty(key) || value == null) {
                return InvalidDataErrorReason.METADATA_EMPTY_KEY_OR_VALUE;
            }
            if (key.length() > 1000) {
                return InvalidDataErrorReason.META_DATA_EXCEEDED_KEY_LENGTH_LIMIT;
            }
            if (value.length() > 10000) {
                return InvalidDataErrorReason.META_DATA_EXCEEDED_VALUE_LENGTH_LIMIT;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ValuePair<String, Map<String, String>> validateIdentitiesForLogin(List<InternalIdentity> list, boolean z) {
        if (list == null) {
            HSLogger.d(TAG, "Identity data is empty or contains null entries");
            return ValuePair.from(UserLoginFailureReason.IDENTITIES_DATA_INVALID, null);
        } else if (list.size() > 100) {
            HSLogger.d(TAG, "Identity data exceeded limit");
            return ValuePair.from(UserLoginFailureReason.IDENTITIES_SIZE_LIMIT_EXCEEDED, null);
        } else {
            List<ValuePair<String, String>> validateIdentityList = validateIdentityList(list);
            if (!validateIdentityList.isEmpty()) {
                return ValuePair.from(UserLoginFailureReason.IDENTITIES_DATA_INVALID, getErrorMapFromValuePair(validateIdentityList));
            }
            if (list.isEmpty() || z || isUidOrEmailPresent(list)) {
                return null;
            }
            return ValuePair.from(UserLoginFailureReason.UID_OR_EMAIL_IS_MANDATORY, null);
        }
    }

    private static Map<String, String> getErrorMapFromValuePair(List<ValuePair<String, String>> list) {
        HashMap hashMap = new HashMap();
        for (ValuePair<String, String> valuePair : list) {
            hashMap.put(valuePair.first, valuePair.second);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ValuePair<String, Map<String, String>> validateLoginConfig(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        map.remove(null);
        map.remove("");
        if (map.size() > 100) {
            HSLogger.d(TAG, "Login Config exceeded limit");
            return ValuePair.from(UserLoginFailureReason.LOGIN_CONFIG_SIZE_LIMIT_EXCEEDED, null);
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (value == null) {
                arrayList.add(ValuePair.from(key, InvalidDataErrorReason.EMPTY_DATA));
            } else if (key.length() > 1000) {
                arrayList.add(ValuePair.from(key, InvalidDataErrorReason.EXCEEDED_KEY_LENGTH_LIMIT));
            } else if (!(value instanceof Number) && !(value instanceof Boolean) && !(value instanceof String)) {
                arrayList.add(ValuePair.from(key, InvalidDataErrorReason.INVALID_VALUE_TYPE));
            } else if ((value instanceof String) && ((String) value).length() > 10000) {
                arrayList.add(ValuePair.from(key, InvalidDataErrorReason.EXCEEDED_VALUE_LENGTH_LIMIT));
            }
        }
        if (Utils.isEmpty(arrayList)) {
            return null;
        }
        return ValuePair.from(UserLoginFailureReason.LOGIN_CONFIG_INVALID, getErrorMapFromValuePair(arrayList));
    }

    private static boolean isUidOrEmailPresent(List<InternalIdentity> list) {
        return list.isEmpty() || InternalIdentityUtils.isIdentifierPresent(list, "uid") || InternalIdentityUtils.isIdentifierPresent(list, "email");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<InternalIdentity> getIdentitiesFromTokenJsonObject(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("identities");
            return JsonUtils.isEmpty(optJSONArray) ? arrayList : InternalIdentityUtils.getIdentityFromJsonArrayString(optJSONArray.toString());
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in getting identities fromm  JWT json object", e);
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isNewIdentityUserSame(Map<String, Object> map, Map<String, Object> map2) {
        boolean booleanValue = ((Boolean) Utils.getOrDefault(map2, UserConstants.FULL_PRIVACY_ENABLED, false)).booleanValue();
        boolean booleanValue2 = ((Boolean) Utils.getOrDefault(map, UserConstants.FULL_PRIVACY_ENABLED, false)).booleanValue();
        String str = (String) Utils.getOrDefault(map2, UserWithIdentity.IDENTITIES_SIGNATURE, "");
        String str2 = (String) Utils.getOrDefault(map, UserWithIdentity.IDENTITIES_SIGNATURE, "");
        String str3 = (String) Utils.getOrDefault(map2, UserWithIdentity.IDENTITIES_HASH_LIST, "");
        String str4 = (String) Utils.getOrDefault(map, UserWithIdentity.IDENTITIES_HASH_LIST, "");
        if (booleanValue == booleanValue2 && str.equals(str2)) {
            List listFromJsonArrayString = JsonUtils.listFromJsonArrayString(str3);
            for (String str5 : JsonUtils.listFromJsonArrayString(str4)) {
                if (!listFromJsonArrayString.contains(str5)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
