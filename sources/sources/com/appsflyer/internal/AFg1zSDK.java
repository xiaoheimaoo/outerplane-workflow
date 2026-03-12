package com.appsflyer.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFg1zSDK implements AFf1bSDK {
    private final Context getMediationNetwork;
    private final AppsFlyerProperties getRevenue;

    public AFg1zSDK(Context context, AppsFlyerProperties appsFlyerProperties) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(appsFlyerProperties, "");
        this.getMediationNetwork = context;
        this.getRevenue = appsFlyerProperties;
    }

    @Override // com.appsflyer.internal.AFf1bSDK
    public final AFg1ySDK getCurrencyIso4217Code() {
        String string;
        if (Boolean.parseBoolean(this.getRevenue.getString(AppsFlyerProperties.ENABLE_TCF_DATA_COLLECTION))) {
            try {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.getMediationNetwork);
                int i = defaultSharedPreferences.getInt("IABTCF_gdprApplies", -1);
                int i2 = defaultSharedPreferences.getInt("IABTCF_CmpSdkID", -1);
                int i3 = defaultSharedPreferences.getInt("IABTCF_PolicyVersion", -1);
                int i4 = defaultSharedPreferences.getInt("IABTCF_CmpSdkVersion", -1);
                String str = "";
                if (i == 1 && (string = defaultSharedPreferences.getString("IABTCF_TCString", "")) != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    str = string;
                }
                return new AFg1ySDK(i3, i, i2, i4, str);
            } catch (Exception e) {
                AFh1ySDK.e$default(AFLogger.INSTANCE, AFg1cSDK.DMA, "TCF data collection exception", e, false, false, false, false, 120, null);
                return null;
            }
        }
        return null;
    }
}
