package com.appsflyer.internal;

import androidx.core.app.NotificationCompat;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFh1tSDK {
    public final AFc1oSDK getCurrencyIso4217Code;
    public final AFc1pSDK getMediationNetwork;
    public long hashCode;
    public final Map<String, Object> getMonetizationNetwork = new ConcurrentHashMap();
    public final Map<String, Object> getRevenue = new ConcurrentHashMap();
    public final Map<String, Object> AFAdRevenueData = new ConcurrentHashMap();
    public long component2 = 0;
    public long component3 = 0;
    public final long[] component4 = new long[2];
    public final long[] component1 = new long[2];
    public final long[] areAllFieldsValid = new long[2];
    public long copydefault = 0;
    public long toString = 0;

    public AFh1tSDK(AFc1oSDK aFc1oSDK, AFc1pSDK aFc1pSDK) {
        this.getCurrencyIso4217Code = aFc1oSDK;
        this.getMediationNetwork = aFc1pSDK;
    }

    public final void getMonetizationNetwork() {
        this.component3 = System.currentTimeMillis();
        if (getCurrencyIso4217Code()) {
            long j = this.component2;
            if (j != 0) {
                this.getMonetizationNetwork.put("init_to_fg", Long.valueOf(this.component3 - j));
                this.getCurrencyIso4217Code.AFAdRevenueData("first_launch", new JSONObject(this.getMonetizationNetwork).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: init ts is missing");
        }
    }

    public final void getRevenue(AFh1uSDK aFh1uSDK) {
        if (getCurrencyIso4217Code()) {
            this.getMonetizationNetwork.put("start_with", aFh1uSDK.toString());
            this.getCurrencyIso4217Code.AFAdRevenueData("first_launch", new JSONObject(this.getMonetizationNetwork).toString());
        }
    }

    public final void getMonetizationNetwork(DeepLinkResult deepLinkResult, long j) {
        this.getRevenue.put(NotificationCompat.CATEGORY_STATUS, deepLinkResult.getStatus().toString());
        this.getRevenue.put("timeout_value", Long.valueOf(j));
    }

    public final void getMonetizationNetwork(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.toString;
        if (j != 0) {
            this.AFAdRevenueData.put("net", Long.valueOf(currentTimeMillis - j));
        } else {
            AFLogger.afInfoLog("Metrics: gcdStart ts is missing");
        }
        this.AFAdRevenueData.put("retries", Integer.valueOf(i));
        this.getCurrencyIso4217Code.AFAdRevenueData("gcd", new JSONObject(this.AFAdRevenueData).toString());
    }

    public final Map<String, Object> AFAdRevenueData(String str) {
        Map<String, Object> emptyMap = Collections.emptyMap();
        String monetizationNetwork = this.getCurrencyIso4217Code.getMonetizationNetwork(str, null);
        if (monetizationNetwork != null) {
            try {
                return AFg1hSDK.getMonetizationNetwork(new JSONObject(monetizationNetwork));
            } catch (Exception e) {
                AFLogger.afErrorLog("Error while parsing cached json data", e, true);
                return emptyMap;
            }
        }
        return emptyMap;
    }

    public final boolean getCurrencyIso4217Code() {
        return this.getMediationNetwork.getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0) == 0;
    }

    public final boolean getRevenue() {
        return this.getMediationNetwork.getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0) == 1;
    }
}
