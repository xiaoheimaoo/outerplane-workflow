package com.helpshift.util;

import com.helpshift.log.HSLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsonUtils {
    private static final String TAG = "JsonUtils";

    private JsonUtils() {
    }

    public static boolean isEmpty(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static boolean isEmpty(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static Map<String, Object> jsonStringToMap(String str) {
        if (Utils.isEmpty(str) || !isValidJsonString(str)) {
            return new HashMap();
        }
        try {
            return toMap(new JSONObject(str));
        } catch (JSONException e) {
            HSLogger.e(TAG, "Error in creating map from string json", e);
            return new HashMap();
        }
    }

    public static <K, V> String mapToJsonString(Map<K, V> map) {
        return map != null ? new JSONObject(map).toString() : "";
    }

    public static Map<String, String> jsonStringToStringMap(String str) {
        if (Utils.isEmpty(str) || !isValidJsonString(str)) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in creating map from string json", e);
            return new HashMap();
        }
    }

    public static Map<String, Object> parseConfigDictionary(String str) throws JSONException {
        return toMap(new JSONObject(str));
    }

    public static HashMap<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, fromJson(jSONObject.get(next)));
        }
        return hashMap;
    }

    public static List<Object> toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(fromJson(jSONArray.get(i)));
        }
        return arrayList;
    }

    private static Object fromJson(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return toMap((JSONObject) obj);
        }
        return obj instanceof JSONArray ? toList((JSONArray) obj) : obj;
    }

    public static JSONArray listOfMapToJSONArray(List<Map<String, String>> list) {
        if (list == null || list.size() == 0) {
            return new JSONArray();
        }
        return new JSONArray((Collection) list);
    }

    public static boolean isValidJsonString(String str) {
        try {
            try {
                new JSONObject(str);
                return true;
            } catch (Exception unused) {
                return false;
            }
        } catch (Exception unused2) {
            new JSONArray(str);
            return true;
        }
    }

    public static <T> List<T> listFromJsonArrayString(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            return Utils.isEmpty(str) ? arrayList : (List<T>) toList(new JSONArray(str));
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in getting list for JsonArray string", e);
            return arrayList;
        }
    }

    public static <T> JSONArray jsonArrayFromList(List<T> list) {
        try {
            return new JSONArray((Collection) list);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in getting json array from list", e);
            return new JSONArray();
        }
    }
}
