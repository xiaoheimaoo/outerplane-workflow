package com.helpshift.unityproxy.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class HelpshiftUnityStorage {
    public static final String DOMAIN_NAME = "domainName";
    public static final String INSTALL_CONFIG = "installConfig";
    public static final String PLATFORM_ID = "platformId";
    private static HelpshiftUnityStorage storage;
    private final SharedPreferences sharedPreferences;

    private HelpshiftUnityStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences("__helpshift_sdkx_unity_prefs", 0);
    }

    public static synchronized HelpshiftUnityStorage getInstance(Context context) {
        HelpshiftUnityStorage helpshiftUnityStorage;
        synchronized (HelpshiftUnityStorage.class) {
            if (storage == null) {
                storage = new HelpshiftUnityStorage(context);
            }
            helpshiftUnityStorage = storage;
        }
        return helpshiftUnityStorage;
    }

    public void put(String str, String str2) {
        if (Utils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public String getString(String str) {
        return Utils.isEmpty(str) ? "" : this.sharedPreferences.getString(str, "");
    }

    public void putJsonStringOfMap(String str, String str2) {
        if (Utils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public HashMap<String, Object> getMap(String str) {
        if (Utils.isEmpty(str)) {
            return new HashMap<>();
        }
        String string = this.sharedPreferences.getString(str, "");
        if (Utils.isEmpty(string)) {
            return new HashMap<>();
        }
        return new HashMap<>(JsonUtils.jsonStringToMap(string));
    }
}
