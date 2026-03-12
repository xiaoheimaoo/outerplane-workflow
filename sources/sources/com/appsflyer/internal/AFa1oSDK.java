package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFa1oSDK {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject AFAdRevenueData(String str) {
        JSONObject monetizationNetwork = AFg1hSDK.getMonetizationNetwork(str);
        if (monetizationNetwork != null) {
            try {
                if (monetizationNetwork.has("ol_id")) {
                    String optString = monetizationNetwork.optString("ol_scheme", null);
                    String optString2 = monetizationNetwork.optString("ol_domain", null);
                    String optString3 = monetizationNetwork.optString("ol_ver", null);
                    if (optString != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_SCHEME, optString);
                    }
                    if (optString2 != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_DOMAIN, optString2);
                    }
                    if (optString3 != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_VERSION, optString3);
                    }
                }
            } catch (Throwable th) {
                AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, new StringBuilder("Error in handleResponse: ").append(th.getMessage()).toString(), th, false, false, true);
                AFa1uSDK monetizationNetwork2 = AFa1uSDK.getMonetizationNetwork();
                ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{monetizationNetwork2}, 389316487, -389316474, System.identityHashCode(monetizationNetwork2))).equals().getMediationNetwork();
                AFa1uSDK monetizationNetwork3 = AFa1uSDK.getMonetizationNetwork();
                ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{monetizationNetwork3}, 389316487, -389316474, System.identityHashCode(monetizationNetwork3))).equals().AFAdRevenueData();
            }
        }
        return monetizationNetwork;
    }
}
