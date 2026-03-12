package com.helpshift.migrator;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.helpshift.migrator.database.HSLegacySupportKeyValueStore;
import com.helpshift.migrator.database.HSNativeSDKUserDBHelper;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.user.UserConstants;
import com.helpshift.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NativeToSdkxMigrator {
    private static final String TAG = "Helpshift_Migrator";
    private static final String USER_ID = "userId";
    private final String DID_KEY;
    private final String FAILED_KEY;
    private final String LEGACY_ID_KEY;
    private final String PUSH_TOKEN_KEY;
    private final String SDK_LANG_KEY;
    private final String SUCCESS_KEY;
    private final String USER_DATA_KEY;
    private int attempts;
    private final Context context;
    private final StringBuilder failureLogBuilder;
    private final Map<String, String> failureMap;
    private final MigrationLogger migrationLogger;
    private HSNativeSDKUserDBHelper nativeSDKUserDBHelper;
    private final HSPersistentStorage persistentStorage;
    private final SharedPreferences preferences;
    private HSLegacySupportKeyValueStore supportKVStoreDBHelper;

    public NativeToSdkxMigrator(Context context, HSPersistentStorage hSPersistentStorage) {
        HashMap hashMap = new HashMap();
        this.failureMap = hashMap;
        this.SUCCESS_KEY = "Success";
        this.FAILED_KEY = "Failed";
        this.DID_KEY = "DeviceId : ";
        this.SDK_LANG_KEY = "SDK Language : ";
        this.PUSH_TOKEN_KEY = "Push Token : ";
        this.USER_DATA_KEY = "User Data : ";
        this.LEGACY_ID_KEY = "Legacy Analytics Id : ";
        this.attempts = 0;
        this.context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(MigratorSharedPrefConstants.MIGRATION_SHARED_PREF, 0);
        this.preferences = sharedPreferences;
        this.persistentStorage = hSPersistentStorage;
        this.migrationLogger = new MigrationLogger(sharedPreferences);
        this.failureLogBuilder = new StringBuilder("Migration Result: ");
        hashMap.put("DeviceId : ", "Failed");
        hashMap.put("SDK Language : ", "Failed");
        hashMap.put("Push Token : ", "Failed");
        hashMap.put("Legacy Analytics Id : ", "Failed");
        hashMap.put("User Data : ", "Failed");
    }

    public synchronized void migrate() {
        String str;
        String str2;
        int i;
        try {
        } catch (Exception e) {
            this.migrationLogger.e(TAG, "Migration failed with exception", e);
            try {
                HSLegacySupportKeyValueStore hSLegacySupportKeyValueStore = this.supportKVStoreDBHelper;
                if (hSLegacySupportKeyValueStore != null) {
                    hSLegacySupportKeyValueStore.close();
                }
                HSNativeSDKUserDBHelper hSNativeSDKUserDBHelper = this.nativeSDKUserDBHelper;
                if (hSNativeSDKUserDBHelper != null) {
                    hSNativeSDKUserDBHelper.close();
                }
            } catch (Exception e2) {
                e = e2;
                str = TAG;
                str2 = "Error closing DB instance";
                Log.e(str, str2, e);
            }
        }
        if (!shouldMigrate()) {
            this.migrationLogger.d(TAG, "Migration not required, skipping");
            try {
                HSLegacySupportKeyValueStore hSLegacySupportKeyValueStore2 = this.supportKVStoreDBHelper;
                if (hSLegacySupportKeyValueStore2 != null) {
                    hSLegacySupportKeyValueStore2.close();
                }
                HSNativeSDKUserDBHelper hSNativeSDKUserDBHelper2 = this.nativeSDKUserDBHelper;
                if (hSNativeSDKUserDBHelper2 != null) {
                    hSNativeSDKUserDBHelper2.close();
                }
            } catch (Exception e3) {
                Log.e(TAG, "Error closing DB instance", e3);
            }
            return;
        }
        this.supportKVStoreDBHelper = new HSLegacySupportKeyValueStore(this.context);
        this.nativeSDKUserDBHelper = new HSNativeSDKUserDBHelper(this.context);
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            i = 1;
            if (i2 >= 3) {
                break;
            }
            this.attempts++;
            z = migrateKVStoreData();
            z2 = migrateUserData();
            logMessageOnStep("User data migration", z2);
            updateFailuresMap("User Data : ", z2);
            z3 = migrateLegacyAnalyticsEventIds();
            logMessageOnStep("Legacy analytics event ID data migration", z3);
            updateFailuresMap("Legacy Analytics Id : ", z3);
            if (z && z2 && z3) {
                break;
            }
            i2++;
            this.migrationLogger.e(TAG, "Native SDK to SDK X migration failed! Attempt : " + i2);
        }
        if (!z || !z2 || !z3) {
            i = -1;
        }
        addNativeSDKVersionLog(i);
        storeFailureLog(i);
        this.preferences.edit().putInt(MigratorSharedPrefConstants.MIGRATION_STATE_KEY, i).commit();
        try {
            HSLegacySupportKeyValueStore hSLegacySupportKeyValueStore3 = this.supportKVStoreDBHelper;
            if (hSLegacySupportKeyValueStore3 != null) {
                hSLegacySupportKeyValueStore3.close();
            }
            HSNativeSDKUserDBHelper hSNativeSDKUserDBHelper3 = this.nativeSDKUserDBHelper;
            if (hSNativeSDKUserDBHelper3 != null) {
                hSNativeSDKUserDBHelper3.close();
            }
        } catch (Exception e4) {
            e = e4;
            str = TAG;
            str2 = "Error closing DB instance";
            Log.e(str, str2, e);
        }
    }

    private void storeFailureLog(int i) {
        if (i != -1) {
            return;
        }
        this.failureLogBuilder.append(" Attempts: ").append(this.attempts).append(" , ");
        this.failureLogBuilder.append("DeviceId : ").append(this.failureMap.get("DeviceId : ")).append(" , ");
        this.failureLogBuilder.append("User Data : ").append(this.failureMap.get("User Data : ")).append(" , ");
        this.failureLogBuilder.append("Push Token : ").append(this.failureMap.get("Push Token : ")).append(" , ");
        this.failureLogBuilder.append("SDK Language : ").append(this.failureMap.get("SDK Language : ")).append(" , ");
        this.failureLogBuilder.append("Legacy Analytics Id : ").append(this.failureMap.get("Legacy Analytics Id : "));
        try {
            JSONObject jSONObject = new JSONObject();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            jSONObject.put("dt", simpleDateFormat.format(new Date()));
            jSONObject.put("l", "ERROR");
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, this.failureLogBuilder.toString());
            jSONObject.put("src", "sdkx.android.10.4.0");
            this.preferences.edit().putString(MigratorSharedPrefConstants.FAILURE_LOG_KEY, jSONObject.toString()).commit();
        } catch (Exception unused) {
            Log.e(TAG, "Error storing failure log.");
        }
    }

    private void addNativeSDKVersionLog(int i) {
        try {
            String str = "Native SDK version: " + this.context.getSharedPreferences("HSJsonData", 0).getString("libraryVersion", "unknown") + " to SDK X version: 10.4.0";
            if (i == -1) {
                this.migrationLogger.e(TAG, str);
                this.migrationLogger.e(TAG, " Migration failed!");
            } else {
                this.migrationLogger.d(TAG, str);
                this.migrationLogger.d(TAG, "Migration success!");
            }
        } catch (Exception e) {
            this.migrationLogger.e(TAG, "Error fetching SDK info for logging", e);
        }
    }

    private boolean shouldMigrate() {
        return databaseExists(HSLegacySupportKeyValueStore.KV_STORE_DB_NAME) && this.preferences.getInt(MigratorSharedPrefConstants.MIGRATION_STATE_KEY, 0) == 0;
    }

    private void logMessageOnStep(String str, boolean z) {
        String str2 = z ? " : Success" : " : Failed";
        if (!z) {
            this.migrationLogger.e(TAG, str + str2);
        } else {
            this.migrationLogger.d(TAG, str + str2);
        }
    }

    private void updateFailuresMap(String str, boolean z) {
        if (z) {
            this.failureMap.put(str, "Success");
        }
    }

    private boolean migrateKVStoreData() {
        boolean migrateDeviceId = migrateDeviceId();
        logMessageOnStep("DeviceId migration", migrateDeviceId);
        updateFailuresMap("DeviceId : ", migrateDeviceId);
        migratePushToken();
        logMessageOnStep("Push token migration", true);
        updateFailuresMap("Push Token : ", true);
        migrateSDKLanguage();
        logMessageOnStep("SDK language migration", true);
        updateFailuresMap("SDK Language : ", true);
        return migrateDeviceId;
    }

    private void migrateSDKLanguage() {
        if (Utils.isNotEmpty(this.persistentStorage.getLanguage())) {
            return;
        }
        Object readStringFromKVDB = readStringFromKVDB("sdkLanguage");
        this.persistentStorage.setLanguage(readStringFromKVDB instanceof String ? (String) readStringFromKVDB : "");
    }

    private void migratePushToken() {
        if (Utils.isNotEmpty(this.persistentStorage.getCurrentPushToken())) {
            return;
        }
        Object readStringFromKVDB = readStringFromKVDB("key_push_token");
        this.persistentStorage.setCurrentPushToken(readStringFromKVDB instanceof String ? (String) readStringFromKVDB : "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
        if (r1 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r1 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r0.length() <= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
        r6.persistentStorage.putString(com.helpshift.storage.HSPersistentStorage.LEGACY_ANALYTICS_EVENTS_IDS, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean migrateLegacyAnalyticsEventIds() {
        /*
            r6 = this;
            java.lang.String r0 = "__hs_db_helpshift_users"
            boolean r0 = r6.databaseExists(r0)
            if (r0 != 0) goto La
            r0 = 0
            return r0
        La:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = 0
            com.helpshift.migrator.database.HSNativeSDKUserDBHelper r2 = r6.nativeSDKUserDBHelper     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            java.lang.String r3 = "SELECT * FROM legacy_analytics_event_id_table"
            android.database.Cursor r1 = r2.rawQuery(r3, r1)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
        L1c:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            if (r2 == 0) goto L3a
            java.lang.String r2 = "identifier"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            java.lang.String r3 = "analytics_event_id"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            goto L1c
        L3a:
            if (r1 == 0) goto L4e
            goto L4b
        L3d:
            r0 = move-exception
            goto L61
        L3f:
            r2 = move-exception
            com.helpshift.migrator.MigrationLogger r3 = r6.migrationLogger     // Catch: java.lang.Throwable -> L3d
            java.lang.String r4 = "Helpshift_Migrator"
            java.lang.String r5 = "Error reading legacy analytics event id."
            r3.e(r4, r5, r2)     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L4e
        L4b:
            r1.close()
        L4e:
            int r1 = r0.length()
            if (r1 <= 0) goto L5f
            com.helpshift.storage.HSPersistentStorage r1 = r6.persistentStorage
            java.lang.String r2 = "legacy_event_ids"
            java.lang.String r0 = r0.toString()
            r1.putString(r2, r0)
        L5f:
            r0 = 1
            return r0
        L61:
            if (r1 == 0) goto L66
            r1.close()
        L66:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.migrator.NativeToSdkxMigrator.migrateLegacyAnalyticsEventIds():boolean");
    }

    private boolean migrateDeviceId() {
        if (Utils.isNotEmpty(this.persistentStorage.getHsDeviceId())) {
            return true;
        }
        Object readStringFromKVDB = readStringFromKVDB("key_support_device_id");
        if (readStringFromKVDB == null) {
            return false;
        }
        this.persistentStorage.setHsDeviceId((String) readStringFromKVDB);
        return true;
    }

    private boolean databaseExists(String str) {
        return new File(this.context.getDatabasePath(str).getAbsolutePath()).exists();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r3 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
        if (r3 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        r3.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object readStringFromKVDB(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "Failed to read the native db or DB does not exist. Key : "
            r1 = 0
            com.helpshift.migrator.database.HSLegacySupportKeyValueStore r2 = r11.supportKVStoreDBHelper     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            java.lang.String r6 = "key=?"
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r4 = 0
            r7[r4] = r12     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            java.lang.String r4 = "key_value_store"
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L4d
            if (r4 == 0) goto L29
            byte[] r2 = r3.getBlob(r2)     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L4d
            java.lang.Object r1 = r11.toObject(r2)     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L4d
        L29:
            if (r3 == 0) goto L4c
        L2b:
            r3.close()
            goto L4c
        L2f:
            r2 = move-exception
            goto L35
        L31:
            r12 = move-exception
            goto L4f
        L33:
            r2 = move-exception
            r3 = r1
        L35:
            com.helpshift.migrator.MigrationLogger r4 = r11.migrationLogger     // Catch: java.lang.Throwable -> L4d
            java.lang.String r5 = "Helpshift_Migrator"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L4d
            java.lang.StringBuilder r12 = r6.append(r12)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L4d
            r4.e(r5, r12, r2)     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L4c
            goto L2b
        L4c:
            return r1
        L4d:
            r12 = move-exception
            r1 = r3
        L4f:
            if (r1 == 0) goto L54
            r1.close()
        L54:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.migrator.NativeToSdkxMigrator.readStringFromKVDB(java.lang.String):java.lang.Object");
    }

    private boolean migrateUserData() {
        if (databaseExists(HSNativeSDKUserDBHelper.USER_DB_NAME)) {
            ArrayList<Map> arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = this.nativeSDKUserDBHelper.getReadableDatabase().rawQuery("SELECT * FROM user_table", null);
                    while (cursor.moveToNext()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("anon", String.valueOf(cursor.getInt(cursor.getColumnIndex("anonymous"))));
                        hashMap.put(USER_ID, cursor.getString(cursor.getColumnIndex("identifier")));
                        hashMap.put("userName", cursor.getString(cursor.getColumnIndex("name")));
                        hashMap.put("userEmail", cursor.getString(cursor.getColumnIndex("email")));
                        hashMap.put("userAuthToken", cursor.getString(cursor.getColumnIndex("auth_token")));
                        hashMap.put("isActive", String.valueOf(cursor.getInt(cursor.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))));
                        arrayList.add(hashMap);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    for (Map map : arrayList) {
                        try {
                            boolean equals = "1".equals(map.remove("anon"));
                            boolean equals2 = "1".equals(map.remove("isActive"));
                            if (equals) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(USER_ID, map.get(USER_ID));
                                this.persistentStorage.storeAnonymousUserIdMap(jSONObject.toString());
                            } else if (equals2) {
                                this.persistentStorage.setActiveUser(new JSONObject(map).toString());
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(UserConstants.USER_TYPE, 0);
                                this.persistentStorage.putString(UserConstants.ACTIVE_USER_DATA, jSONObject2.toString());
                            }
                        } catch (Exception e) {
                            this.migrationLogger.e(TAG, "Error setting user data in SDK X migration", e);
                            return false;
                        }
                    }
                    return true;
                } catch (Exception e2) {
                    this.migrationLogger.e(TAG, "Error getting user data from native SDK", e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return false;
    }

    private Object toObject(byte[] bArr) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ObjectInputStream objectInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    Object readObject = objectInputStream.readObject();
                    Utils.closeQuietly(byteArrayInputStream);
                    Utils.closeQuietly(objectInputStream);
                    return readObject;
                } catch (Throwable th2) {
                    th = th2;
                    Utils.closeQuietly(byteArrayInputStream);
                    Utils.closeQuietly(objectInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            objectInputStream = null;
        }
    }

    public String getMigrationErrorLogs() {
        int i;
        if (!this.preferences.getBoolean(MigratorSharedPrefConstants.MIGRATION_LOG_SYNCED_WEBCHAT, false) && (i = this.preferences.getInt(MigratorSharedPrefConstants.MIGRATION_STATE_KEY, 0)) != 1 && i != 0) {
            try {
                String string = this.preferences.getString(MigrationLogger.ERROR_LOG_ARRAY_KEY, "");
                if (Utils.isEmpty(string)) {
                    string = "[]";
                }
                JSONArray jSONArray = new JSONArray(string);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MigratorSharedPrefConstants.MIGRATION_STATE_KEY, "FAILED");
                jSONObject.put("did", this.persistentStorage.getHsDeviceId());
                jSONObject.put("logs", jSONArray);
                return jSONObject.toString();
            } catch (Exception unused) {
                Log.e(TAG, "Error getting error logs for migration");
            }
        }
        return "";
    }

    public void setErrorLogsSyncedWithWebchat(boolean z) {
        this.preferences.edit().putBoolean(MigratorSharedPrefConstants.MIGRATION_LOG_SYNCED_WEBCHAT, z).commit();
    }
}
