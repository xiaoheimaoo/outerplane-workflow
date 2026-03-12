package com.helpshift.storage;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class SharedPreferencesStore implements ISharedPreferencesStore {
    private final SharedPreferences preferences;

    public SharedPreferencesStore(Context context, String str, int i) {
        this.preferences = context.getSharedPreferences(str, i);
    }

    @Override // com.helpshift.storage.ISharedPreferencesStore
    public String getString(String str) {
        return this.preferences.getString(str, "");
    }

    @Override // com.helpshift.storage.ISharedPreferencesStore
    public void putString(String str, String str2) {
        SharedPreferences.Editor edit = this.preferences.edit();
        edit.putString(str, str2);
        if (edit.commit()) {
            return;
        }
        edit.commit();
    }

    @Override // com.helpshift.storage.ISharedPreferencesStore
    public void remove(String str) {
        SharedPreferences.Editor edit = this.preferences.edit();
        edit.remove(str);
        if (edit.commit()) {
            return;
        }
        edit.commit();
    }

    @Override // com.helpshift.storage.ISharedPreferencesStore
    public void putLong(String str, long j) {
        SharedPreferences.Editor edit = this.preferences.edit();
        edit.putLong(str, j);
        if (edit.commit()) {
            return;
        }
        edit.commit();
    }

    @Override // com.helpshift.storage.ISharedPreferencesStore
    public long getLong(String str) {
        return this.preferences.getLong(str, 0L);
    }

    @Override // com.helpshift.storage.ISharedPreferencesStore
    public void putInt(String str, int i) {
        SharedPreferences.Editor edit = this.preferences.edit();
        edit.putInt(str, i);
        if (edit.commit()) {
            return;
        }
        edit.commit();
    }

    @Override // com.helpshift.storage.ISharedPreferencesStore
    public int getInt(String str) {
        return this.preferences.getInt(str, 0);
    }

    @Override // com.helpshift.storage.ISharedPreferencesStore
    public void putBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = this.preferences.edit();
        edit.putBoolean(str, z);
        if (edit.commit()) {
            return;
        }
        edit.commit();
    }

    @Override // com.helpshift.storage.ISharedPreferencesStore
    public boolean getBoolean(String str) {
        return this.preferences.getBoolean(str, false);
    }

    @Override // com.helpshift.storage.ISharedPreferencesStore
    public void clear() {
        this.preferences.edit().clear().commit();
    }
}
