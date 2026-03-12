package com.helpshift;

import com.helpshift.log.ILogger;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.storage.ISharedPreferencesStore;
import com.helpshift.util.FileUtil;
import com.helpshift.util.Utils;
import java.io.File;
/* loaded from: classes3.dex */
public class HSInstallCredsChangeManager {
    public static final String HS_CREDS_PREFS_FILE_NAME = "__hs_install_creds_store";
    private static final String HS_INSTALL_CREDS_HASH = "hs_sdkx_install_creds_hash";
    private static final String TAG = "HSCredsChangeManager";

    private HSInstallCredsChangeManager() {
    }

    public static void changeInstallCredentials(String str, String str2, ISharedPreferencesStore iSharedPreferencesStore, ISharedPreferencesStore iSharedPreferencesStore2, ISharedPreferencesStore iSharedPreferencesStore3, ISharedPreferencesStore iSharedPreferencesStore4, File file, File file2, ILogger iLogger) {
        try {
            String platformIdDomainHash = getPlatformIdDomainHash(str, str2);
            String string = iSharedPreferencesStore.getString(HS_INSTALL_CREDS_HASH);
            if (Utils.isEmpty(string)) {
                iLogger.d(TAG, "No stored credentials found, Saving current Credentials in storage, Continue install call");
                iSharedPreferencesStore.putString(HS_INSTALL_CREDS_HASH, platformIdDomainHash);
            } else if (platformIdDomainHash.equals(string)) {
                iLogger.d(TAG, "Current Credentials matches with stored credentials, Continue install call");
            } else {
                iLogger.w(TAG, "Credentials Changed, Deleting old SDK data");
                String extractDeviceId = extractDeviceId(iSharedPreferencesStore2);
                clearSDKData(file, file2, iSharedPreferencesStore2, iSharedPreferencesStore3, iSharedPreferencesStore4, iLogger);
                iSharedPreferencesStore.putString(HS_INSTALL_CREDS_HASH, platformIdDomainHash);
                iLogger.d(TAG, "New credentials updated in storage");
                restoreDeviceId(iSharedPreferencesStore2, extractDeviceId, iLogger);
            }
        } catch (Exception e) {
            iLogger.e(TAG, "Failed to update install credentials", e);
        }
    }

    private static void clearSDKData(File file, File file2, ISharedPreferencesStore iSharedPreferencesStore, ISharedPreferencesStore iSharedPreferencesStore2, ISharedPreferencesStore iSharedPreferencesStore3, ILogger iLogger) {
        clearSDKSharedPreferences(iSharedPreferencesStore, iSharedPreferencesStore2, iSharedPreferencesStore3, iLogger);
        deleteHelpshiftCachedDirectory(file, iLogger);
        deleteHelpshiftDebugLogs(file2, iLogger);
    }

    private static void deleteHelpshiftDebugLogs(File file, ILogger iLogger) {
        iLogger.w(TAG, "Deleting Helpshift debug logs");
        FileUtil.deleteDir(new File(file, "helpshift").getAbsolutePath());
    }

    private static void deleteHelpshiftCachedDirectory(File file, ILogger iLogger) {
        iLogger.w(TAG, "Deleting Helpshift cache directory");
        FileUtil.deleteDir(new File(file, "helpshift").getAbsolutePath());
    }

    private static void clearSDKSharedPreferences(ISharedPreferencesStore iSharedPreferencesStore, ISharedPreferencesStore iSharedPreferencesStore2, ISharedPreferencesStore iSharedPreferencesStore3, ILogger iLogger) {
        iLogger.w(TAG, "Deleting SDK Shared Preferences store");
        iSharedPreferencesStore.clear();
        iSharedPreferencesStore2.clear();
        iSharedPreferencesStore3.clear();
    }

    private static String extractDeviceId(ISharedPreferencesStore iSharedPreferencesStore) {
        return iSharedPreferencesStore.getString(HSPersistentStorage.HS_DEVICE_ID);
    }

    private static void restoreDeviceId(ISharedPreferencesStore iSharedPreferencesStore, String str, ILogger iLogger) {
        if (Utils.isNotEmpty(str)) {
            iLogger.w(TAG, "Restored device_id in storage");
            iSharedPreferencesStore.putString(HSPersistentStorage.HS_DEVICE_ID, str);
            return;
        }
        iLogger.e(TAG, "Device_id empty, Failed to restore device_id in storage");
    }

    private static String getPlatformIdDomainHash(String str, String str2) {
        return Utils.getSHAHash(str + "|" + str2);
    }
}
