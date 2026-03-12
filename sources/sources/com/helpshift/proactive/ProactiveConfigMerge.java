package com.helpshift.proactive;

import com.helpshift.log.HSLogger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ProactiveConfigMerge {
    private static final String TAG = "ProactivConfigMerge";

    public static JSONObject mergeProactiveConfig(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (!jSONObject2.has(next)) {
                    jSONObject2.put(next, obj);
                } else {
                    Object obj2 = jSONObject2.get(next);
                    if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
                        jSONObject2.put(next, mergeJsonArrays((JSONArray) obj, (JSONArray) obj2));
                    } else if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                        jSONObject2.put(next, mergeJsonObjects((JSONObject) obj, (JSONObject) obj2));
                    }
                }
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Proactive Config merge failed", e);
        }
        return jSONObject2;
    }

    private static JSONArray mergeJsonArrays(JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray2.length(); i++) {
            hashSet.add(jSONArray2.get(i));
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            hashSet.add(jSONArray.get(i2));
        }
        return new JSONArray((Collection) hashSet);
    }

    private static JSONObject mergeJsonObjects(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.has(next)) {
                jSONObject2.put(next, jSONObject.get(next));
            }
        }
        return jSONObject2;
    }

    private ProactiveConfigMerge() {
    }
}
