package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.appsflyer.AFLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFg1xSDK {
    private final String AFAdRevenueData;
    private final Map<String, Object> getMediationNetwork;
    private final PackageManager getMonetizationNetwork;

    public AFg1xSDK(AFc1gSDK aFc1gSDK, AFc1pSDK aFc1pSDK) {
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        this.getMediationNetwork = new LinkedHashMap();
        Context context = aFc1gSDK.getRevenue;
        this.getMonetizationNetwork = context != null ? context.getPackageManager() : null;
        String packageName = aFc1pSDK.getRevenue.getRevenue.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        this.AFAdRevenueData = packageName;
    }

    public final Map<String, Object> getCurrencyIso4217Code() {
        String installerPackageName;
        if (this.getMediationNetwork.isEmpty()) {
            try {
                PackageManager packageManager = this.getMonetizationNetwork;
                if (packageManager != null && (installerPackageName = packageManager.getInstallerPackageName(this.AFAdRevenueData)) != null) {
                    this.getMediationNetwork.put("installer_package", installerPackageName);
                }
            } catch (Exception e) {
                AFLogger.afErrorLog("Exception while getting the app's installer package. ", e);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                this.getMediationNetwork.put("install_source_info", AFAdRevenueData());
            }
        }
        return this.getMediationNetwork;
    }

    private final Map<String, Object> AFAdRevenueData() {
        InstallSourceInfo installSourceInfo;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            String str = this.AFAdRevenueData;
            PackageManager packageManager = this.getMonetizationNetwork;
            if (packageManager == null || (installSourceInfo = packageManager.getInstallSourceInfo(str)) == null) {
                return linkedHashMap;
            }
            Intrinsics.checkNotNullExpressionValue(installSourceInfo, "");
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            String initiatingPackageName = installSourceInfo.getInitiatingPackageName();
            if (initiatingPackageName != null) {
                linkedHashMap2.put("initiating_package", initiatingPackageName);
            }
            String installingPackageName = installSourceInfo.getInstallingPackageName();
            if (installingPackageName != null) {
                linkedHashMap2.put("installing_package", installingPackageName);
            }
            String originatingPackageName = installSourceInfo.getOriginatingPackageName();
            if (originatingPackageName != null) {
                linkedHashMap2.put("originating_package", originatingPackageName);
            }
            return linkedHashMap2;
        } catch (Throwable th) {
            AFh1ySDK.e$default(AFLogger.INSTANCE, AFg1cSDK.DEVICE_DATA, "Failed to get the app install source info", th, true, false, true, true, 16, null);
            return linkedHashMap;
        }
    }
}
