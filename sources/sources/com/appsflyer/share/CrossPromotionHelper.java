package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFa1uSDK;
import com.appsflyer.internal.AFc1bSDK;
import com.appsflyer.internal.AFe1cSDK;
import com.appsflyer.internal.AFe1nSDK;
import com.appsflyer.internal.AFg1cSDK;
import com.appsflyer.internal.AFk1sSDK;
import com.appsflyer.internal.AFk1uSDK;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class CrossPromotionHelper {
    private static String AFAdRevenueData = "https://%simpression.%s";

    public static void logAndOpenStore(Context context, String str, String str2) {
        logAndOpenStore(context, str, str2, null);
    }

    public static void logAndOpenStore(Context context, String str, String str2, Map<String, String> map) {
        LinkGenerator AFAdRevenueData2 = AFAdRevenueData(context, str, str2, map, String.format(AFk1uSDK.getMediationNetwork, AppsFlyerLib.getInstance().getHostPrefix(), AFa1uSDK.getMonetizationNetwork().getHostName()));
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.INSTANCE.i(AFg1cSDK.CROSS_PROMOTION, "CustomerUserId not set, track And Open Store is disabled", true);
        } else if (AppsFlyerLib.getInstance().isStopped()) {
            AFLogger.INSTANCE.i(AFg1cSDK.CROSS_PROMOTION, "SDK is stopped, track And Open Store is disabled", true);
        } else {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("af_campaign", str2);
            AppsFlyerLib.getInstance().logEvent(context, "af_cross_promotion", map);
            getMediationNetwork(AFAdRevenueData2.generateLink(), context, new AFk1sSDK(context));
        }
    }

    public static void logCrossPromoteImpression(Context context, String str, String str2) {
        logCrossPromoteImpression(context, str, str2, null);
    }

    public static void logCrossPromoteImpression(Context context, String str, String str2, Map<String, String> map) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.INSTANCE.i(AFg1cSDK.CROSS_PROMOTION, "CustomerUserId not set, Promote Impression is disabled", true);
        } else if (AppsFlyerLib.getInstance().isStopped()) {
            AFLogger.INSTANCE.i(AFg1cSDK.CROSS_PROMOTION, "SDK is stopped, Promote Impression is disabled", true);
        } else {
            getMediationNetwork(AFAdRevenueData(context, str, str2, map, String.format(AFAdRevenueData, AppsFlyerLib.getInstance().getHostPrefix(), AFa1uSDK.getMonetizationNetwork().getHostName())).generateLink(), context, null);
        }
    }

    private static void getMediationNetwork(String str, Context context, AFk1sSDK aFk1sSDK) {
        AFa1uSDK monetizationNetwork = AFa1uSDK.getMonetizationNetwork();
        monetizationNetwork.getMediationNetwork(context);
        AFc1bSDK aFc1bSDK = (AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{monetizationNetwork}, 389316487, -389316474, System.identityHashCode(monetizationNetwork));
        AFe1cSDK aFe1cSDK = new AFe1cSDK(aFc1bSDK, str, aFk1sSDK);
        AFe1nSDK copydefault = aFc1bSDK.copydefault();
        copydefault.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFe1cSDK));
    }

    private static LinkGenerator AFAdRevenueData(Context context, String str, String str2, Map<String, String> map, String str3) {
        LinkGenerator linkGenerator = new LinkGenerator("af_cross_promotion");
        linkGenerator.getMonetizationNetwork = str3;
        linkGenerator.AFAdRevenueData = str;
        linkGenerator.addParameter("af_siteid", context.getPackageName());
        if (str2 != null) {
            linkGenerator.setCampaign(str2);
        }
        if (map != null) {
            linkGenerator.addParameters(map);
        }
        return linkGenerator;
    }

    public static void setUrl(Map<String, String> map) {
        char c;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            int hashCode = key.hashCode();
            if (hashCode != 96801) {
                if (hashCode == 120623625 && key.equals("impression")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (key.equals("app")) {
                    c = 0;
                }
                c = 65535;
            }
            if (c == 0) {
                AFk1uSDK.getMediationNetwork = value;
            } else if (c == 1) {
                AFAdRevenueData = value;
            }
        }
    }
}
