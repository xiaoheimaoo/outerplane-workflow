package com.helpshift.migrator;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.helpshift.concurrency.HSThreadingService;
import com.helpshift.log.HSLogger;
import com.helpshift.network.HSRequestData;
import com.helpshift.network.HSResponse;
import com.helpshift.network.HTTPTransport;
import com.helpshift.network.NetworkUtils;
import com.helpshift.network.POSTNetwork;
import com.helpshift.platform.Device;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import com.unity.androidnotifications.UnityNotificationManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MigrationFailureLogProvider {
    private static final String TAG = "MgrFailLog";
    private final Device device;
    private final HSThreadingService hsThreadingService;
    private final HTTPTransport httpTransport;
    private AtomicBoolean inProgress = new AtomicBoolean(false);
    private final HSPersistentStorage persistentStorage;
    private final SharedPreferences preferences;

    public MigrationFailureLogProvider(Context context, HTTPTransport hTTPTransport, HSPersistentStorage hSPersistentStorage, Device device, HSThreadingService hSThreadingService) {
        this.preferences = context.getSharedPreferences(MigratorSharedPrefConstants.MIGRATION_SHARED_PREF, 0);
        this.httpTransport = hTTPTransport;
        this.persistentStorage = hSPersistentStorage;
        this.device = device;
        this.hsThreadingService = hSThreadingService;
    }

    public void sendMigrationFailureLogs() {
        if (shouldSkipMigrationFailureLogSync()) {
            return;
        }
        this.inProgress = this.hsThreadingService.getNetworkService().submit(new Runnable() { // from class: com.helpshift.migrator.MigrationFailureLogProvider.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!MigrationFailureLogProvider.this.inProgress.get()) {
                        String string = MigrationFailureLogProvider.this.preferences.getString(MigratorSharedPrefConstants.FAILURE_LOG_KEY, "");
                        if (Utils.isEmpty(string)) {
                            Log.d(MigrationFailureLogProvider.TAG, "Migration failure logs are empty. Skipping.");
                            return;
                        }
                        MigrationFailureLogProvider.this.sendFailureLogsRequest(MigrationFailureLogProvider.this.prepareRequestBody(new JSONArray().put(new JSONObject(string)), MigrationFailureLogProvider.this.collectMetaData()));
                        return;
                    }
                    Log.d(MigrationFailureLogProvider.TAG, "Migration failure log sync already in progress. Skipping.");
                } catch (Exception e) {
                    HSLogger.e(MigrationFailureLogProvider.TAG, "Migration failure logs sync failed", e);
                }
            }
        });
    }

    private boolean shouldSkipMigrationFailureLogSync() {
        int i = this.preferences.getInt(MigratorSharedPrefConstants.MIGRATION_STATE_KEY, 0);
        if (i == 1 || i == 0) {
            return true;
        }
        return this.preferences.getBoolean(MigratorSharedPrefConstants.FAILURE_LOG_SYNCED, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray collectMetaData() throws JSONException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(jsonify("domain", this.persistentStorage.getDomain() + "." + this.persistentStorage.getHost()));
        arrayList.add(jsonify("dm", this.device.getDeviceModel()));
        arrayList.add(jsonify("did", this.device.getDeviceId()));
        arrayList.add(jsonify("os", this.device.getOSVersion()));
        String appName = this.device.getAppName();
        if (!Utils.isEmpty(appName)) {
            arrayList.add(jsonify("an", appName));
        }
        String appVersion = this.device.getAppVersion();
        if (!Utils.isEmpty(appVersion)) {
            arrayList.add(jsonify("av", appVersion));
        }
        return JsonUtils.jsonArrayFromList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> prepareRequestBody(JSONArray jSONArray, JSONArray jSONArray2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(UnityNotificationManager.KEY_ID, UUID.randomUUID().toString());
        hashMap.put("v", "1");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        hashMap.put("ctime", simpleDateFormat.format(new Date()));
        hashMap.put("src", "sdkx.android.10.4.0");
        hashMap.put("logs", jSONArray.toString());
        hashMap.put("md", jSONArray2.toString());
        hashMap.put("platform-id", this.persistentStorage.getPlatformId());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFailureLogsRequest(HashMap<String, String> hashMap) {
        HSResponse makeRequest = new POSTNetwork(this.httpTransport, NetworkUtils.getCrashLogsRoute(this.persistentStorage)).makeRequest(new HSRequestData(NetworkUtils.buildHeaderMap(this.device, this.persistentStorage.getPlatformId()), hashMap));
        if (makeRequest.getStatus() < 200 || makeRequest.getStatus() >= 300) {
            return;
        }
        this.preferences.edit().putBoolean(MigratorSharedPrefConstants.FAILURE_LOG_SYNCED, true).apply();
        this.preferences.edit().putString(MigratorSharedPrefConstants.FAILURE_LOG_KEY, "").commit();
    }

    private JSONObject jsonify(String str, String str2) throws JSONException {
        return new JSONObject().put(str, str2);
    }
}
