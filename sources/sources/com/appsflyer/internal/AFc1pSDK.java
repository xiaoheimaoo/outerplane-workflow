package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import java.util.UUID;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class AFc1pSDK {
    private static String getCurrencyIso4217Code = "356";
    public final AFc1eSDK AFAdRevenueData;
    private final Executor areAllFieldsValid;
    private PackageInfo component3;
    public final AFc1oSDK getMonetizationNetwork;
    public final AFc1gSDK getRevenue;
    private Bundle component2 = null;
    public String getMediationNetwork = "";

    public static String getCurrencyIso4217Code() {
        return "6.17.3";
    }

    public AFc1pSDK(AFc1gSDK aFc1gSDK, AFc1oSDK aFc1oSDK, AFc1eSDK aFc1eSDK, Executor executor) {
        this.getRevenue = aFc1gSDK;
        this.getMonetizationNetwork = aFc1oSDK;
        this.AFAdRevenueData = aFc1eSDK;
        this.areAllFieldsValid = executor;
    }

    public final PackageInfo n_() {
        if (this.component3 == null) {
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    this.component3 = this.getRevenue.getRevenue.getPackageManager().getPackageInfo(this.getRevenue.getRevenue.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
                } else {
                    this.component3 = this.getRevenue.getRevenue.getPackageManager().getPackageInfo(this.getRevenue.getRevenue.getPackageName(), 0);
                }
            } catch (PackageManager.NameNotFoundException e) {
                AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Exception while trying fo get PackageInfo", e, false, false, true, false);
            }
        }
        return this.component3;
    }

    public static String AFAdRevenueData() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String getMonetizationNetwork() {
        return UUID.randomUUID().toString();
    }

    public static String getRevenue() {
        return AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
    }

    public final boolean component1() {
        return !this.AFAdRevenueData.getRevenue();
    }

    public final String getMonetizationNetwork(String str) {
        Object obj;
        try {
            if (this.component2 == null) {
                this.component2 = ((PackageItemInfo) this.getRevenue.getRevenue.getPackageManager().getApplicationInfo(this.getRevenue.getRevenue.getPackageName(), 128)).metaData;
            }
            Bundle bundle = this.component2;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable th) {
            AFLogger.afErrorLog(new StringBuilder("Could not load manifest metadata!").append(th.getMessage()).toString(), th);
            return null;
        }
    }

    public final boolean getRevenue(String str) {
        String monetizationNetwork = getMonetizationNetwork(str);
        if (monetizationNetwork != null) {
            return Boolean.parseBoolean(monetizationNetwork);
        }
        return false;
    }

    public static String component2() {
        return new StringBuilder("version: 6.17.3 (build ").append(getCurrencyIso4217Code).append(")").toString();
    }

    public final String areAllFieldsValid() {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CHANNEL);
        if (string == null) {
            string = getMonetizationNetwork("CHANNEL");
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }

    public final String getRevenue(Context context) {
        try {
            return new AFb1iSDK(context, this.areAllFieldsValid).getMonetizationNetwork();
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.PUBLIC_API, "Exception while collecting facebook's attribution ID. ", th, true, false, false);
            return null;
        }
    }

    public final String component4() {
        AFh1pSDK aFh1pSDK = this.AFAdRevenueData.component2;
        AFb1mSDK aFb1mSDK = aFh1pSDK != null ? new AFb1mSDK(aFh1pSDK.getRevenue, aFh1pSDK.getMonetizationNetwork) : null;
        if (aFb1mSDK != null) {
            return aFb1mSDK.getCurrencyIso4217Code;
        }
        return null;
    }

    public final String getMediationNetwork(String str) {
        try {
            int identifier = this.getRevenue.getRevenue.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, this.getRevenue.getRevenue.getPackageName());
            if (identifier != 0) {
                return this.getRevenue.getRevenue.getString(identifier);
            }
            return null;
        } catch (Resources.NotFoundException e) {
            AFLogger.afErrorLog(new StringBuilder("Could not load string resource!").append(e.getMessage()).toString(), e);
            return null;
        }
    }

    public final boolean getMediationNetwork(Context context) {
        try {
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.INSTANCE.e(AFg1cSDK.PUBLIC_API, "Could not check if app is pre installed", e);
        }
        return (this.getRevenue.getRevenue.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0;
    }
}
