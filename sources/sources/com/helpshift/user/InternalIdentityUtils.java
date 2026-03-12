package com.helpshift.user;

import com.helpshift.log.HSLogger;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class InternalIdentityUtils {
    static final String IDENTITY_KEY = "identifier";
    static final String IDENTITY_META_DATA = "metadata";
    static final String IDENTITY_VALUE = "value";
    private static String TAG = "InternalIdentityUtils";

    private InternalIdentityUtils() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<InternalIdentity> getIdentityFromJsonArrayString(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = !Utils.isEmpty(str) ? new JSONArray(str) : new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (!validateIdentityObject(optJSONObject)) {
                    HSLogger.d(TAG, "identity object is invalid");
                    return arrayList;
                }
                String str2 = (String) optJSONObject.remove(IDENTITY_KEY);
                String str3 = (String) optJSONObject.remove("value");
                JSONObject jSONObject = (JSONObject) optJSONObject.remove(IDENTITY_META_DATA);
                arrayList.add(new InternalIdentity(str2, str3, JsonUtils.jsonStringToStringMap(jSONObject != null ? jSONObject.toString() : "")));
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in getting identity from Json Array String", e);
        }
        return arrayList;
    }

    private static boolean validateIdentityObject(JSONObject jSONObject) {
        int length;
        if (!JsonUtils.isEmpty(jSONObject) && hasRequiredIdentityFields(jSONObject) && (length = jSONObject.length()) < 4) {
            if ((length != 3 || jSONObject.has(IDENTITY_META_DATA)) && areValidIdentityKeyValue(jSONObject)) {
                return isValidMetaData(jSONObject);
            }
            return false;
        }
        return false;
    }

    private static boolean hasRequiredIdentityFields(JSONObject jSONObject) {
        return jSONObject.has(IDENTITY_KEY) && jSONObject.has("value");
    }

    private static boolean areValidIdentityKeyValue(JSONObject jSONObject) {
        return (jSONObject.opt(IDENTITY_KEY) instanceof String) && (jSONObject.opt("value") instanceof String);
    }

    private static boolean isValidMetaData(JSONObject jSONObject) {
        if (jSONObject.has(IDENTITY_META_DATA)) {
            Object opt = jSONObject.opt(IDENTITY_META_DATA);
            if (opt instanceof JSONObject) {
                return isValidMetaDataEntries((JSONObject) opt);
            }
            return false;
        }
        return true;
    }

    private static boolean isValidMetaDataEntries(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            if (!(jSONObject.opt(keys.next()) instanceof String)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIdentifierPresent(List<InternalIdentity> list, String str) {
        if (Utils.isEmpty(list)) {
            return false;
        }
        for (InternalIdentity internalIdentity : list) {
            if (str.equals(internalIdentity.identityKey)) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> getFlattenedIdentity(InternalIdentity internalIdentity) {
        HashMap hashMap = new HashMap();
        hashMap.put(internalIdentity.identityKey, internalIdentity.identityValue);
        hashMap.putAll(internalIdentity.metaData);
        return hashMap;
    }

    public static JSONArray getHashForIdentities(List<InternalIdentity> list) {
        ArrayList arrayList = new ArrayList();
        for (InternalIdentity internalIdentity : list) {
            arrayList.add(String.valueOf(getFlattenedIdentity(internalIdentity).hashCode()));
        }
        return JsonUtils.jsonArrayFromList(arrayList);
    }
}
