package com.helpshift.core;

import android.app.LocaleManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.log.HSLogger;
import com.helpshift.platform.Device;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.Utils;
import com.helpshift.util.ValuePair;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes3.dex */
public class AndroidDevice implements Device {
    public static final String LITE_SDK_VERSION = "10.4.0";
    private static final String OS_TYPE = "android";
    private static final String TAG = "Device";
    private final Context context;
    private HSPersistentStorage persistentStorage;

    @Override // com.helpshift.platform.Device
    public String getOsType() {
        return "android";
    }

    @Override // com.helpshift.platform.Device
    public String getSDKVersion() {
        return LITE_SDK_VERSION;
    }

    public AndroidDevice(Context context, HSPersistentStorage hSPersistentStorage) {
        this.context = context;
        this.persistentStorage = hSPersistentStorage;
    }

    @Override // com.helpshift.platform.Device
    public String getAppVersion() {
        try {
            return this.context.getPackageManager().getPackageInfo(getAppIdentifier(), 0).versionName;
        } catch (Exception e) {
            HSLogger.d(TAG, "Error getting app version", e);
            return null;
        }
    }

    @Override // com.helpshift.platform.Device
    public String getAppName() {
        String str;
        try {
            str = this.context.getPackageManager().getApplicationLabel(this.context.getApplicationInfo()).toString();
        } catch (Exception e) {
            HSLogger.d(TAG, "Error getting application name", e);
            str = null;
        }
        return str == null ? "Support" : str;
    }

    @Override // com.helpshift.platform.Device
    public String getAppIdentifier() {
        return this.context.getPackageName();
    }

    @Override // com.helpshift.platform.Device
    public String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // com.helpshift.platform.Device
    public String getBatteryLevel() {
        Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return "";
        }
        return ((int) ((registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) / registerReceiver.getIntExtra("scale", -1)) * 100.0f)) + "%";
    }

    @Override // com.helpshift.platform.Device
    public String getBatteryStatus() {
        Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return "Not charging";
        }
        int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        return intExtra == 2 || intExtra == 5 ? "Charging" : "Not charging";
    }

    @Override // com.helpshift.platform.Device
    public ValuePair<String, String> getDiskSpace() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return new ValuePair<>((Math.round(((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1.073741824E9d) * 100.0d) / 100.0d) + " GB", (Math.round(((statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / 1.073741824E9d) * 100.0d) / 100.0d) + " GB");
    }

    @Override // com.helpshift.platform.Device
    public String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.helpshift.platform.Device
    public String getCarrierName() {
        TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
        return telephonyManager == null ? "" : telephonyManager.getNetworkOperatorName();
    }

    @Override // com.helpshift.platform.Device
    public String getNetworkType() {
        NetworkInfo activeNetworkInfo;
        String str = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                str = activeNetworkInfo.getTypeName();
            }
        } catch (SecurityException unused) {
        }
        return str == null ? "Unknown" : str;
    }

    @Override // com.helpshift.platform.Device
    public String getCountryCode() {
        TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
        return telephonyManager == null ? "" : telephonyManager.getSimCountryIso();
    }

    @Override // com.helpshift.platform.Device
    public String getRom() {
        return System.getProperty("os.version") + ":" + Build.FINGERPRINT;
    }

    @Override // com.helpshift.platform.Device
    public String getLanguage() {
        String languageTag;
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                LocaleList applicationLocales = ((LocaleManager) this.context.getSystemService(LocaleManager.class)).getApplicationLocales();
                if (ApplicationUtil.isLocalListEmpty(applicationLocales)) {
                    languageTag = applicationLocales.get(0).toLanguageTag();
                } else {
                    languageTag = Locale.getDefault().toLanguageTag();
                }
            } else {
                languageTag = Locale.getDefault().toLanguageTag();
            }
            return languageTag;
        } catch (Exception e) {
            HSLogger.e(TAG, "Error getting app language", e);
            return "unknown";
        }
    }

    @Override // com.helpshift.platform.Device
    public boolean isOnline() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            HSLogger.e(TAG, "Exception while getting system connectivity service", e);
            return false;
        }
    }

    @Override // com.helpshift.platform.Device
    public String encodeBase64(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    @Override // com.helpshift.platform.Device
    public String getDeviceId() {
        String hsDeviceId = this.persistentStorage.getHsDeviceId();
        if (Utils.isEmpty(hsDeviceId)) {
            String uuid = UUID.randomUUID().toString();
            this.persistentStorage.setHsDeviceId(uuid);
            return uuid;
        }
        return hsDeviceId;
    }

    @Override // com.helpshift.platform.Device
    public String decodeBase64(String str) {
        try {
            return new String(Base64.decode(str, 8));
        } catch (Exception e) {
            HSLogger.d(TAG, "Error in decoding string", e);
            return "";
        }
    }
}
