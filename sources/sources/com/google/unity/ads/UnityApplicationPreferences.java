package com.google.unity.ads;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/* loaded from: classes3.dex */
public final class UnityApplicationPreferences {
    private final SharedPreferences defaultSharedPreferences;

    public UnityApplicationPreferences(final Activity activity) {
        this.defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    public void setInt(String key, int value) {
        SharedPreferences.Editor edit = this.defaultSharedPreferences.edit();
        edit.putInt(key, value);
        edit.apply();
    }

    public void setString(String key, String value) {
        SharedPreferences.Editor edit = this.defaultSharedPreferences.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public int getInt(String key) {
        return this.defaultSharedPreferences.getInt(key, 0);
    }

    public String getString(String key) {
        return this.defaultSharedPreferences.getString(key, null);
    }
}
