package com.appsflyer.internal;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFh1aSDK {
    public final String AFAdRevenueData;
    public final int getCurrencyIso4217Code;
    public final long getMediationNetwork;
    public final int getRevenue;

    public AFh1aSDK(String str, int i, int i2, long j) {
        this.AFAdRevenueData = str;
        this.getCurrencyIso4217Code = i;
        this.getRevenue = i2;
        this.getMediationNetwork = j;
    }

    public final String getMonetizationNetwork() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_ver", this.AFAdRevenueData);
            jSONObject.put("min", this.getCurrencyIso4217Code);
            jSONObject.put("expire", this.getRevenue);
            jSONObject.put("ttl", this.getMediationNetwork);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final int hashCode() {
        String str = this.AFAdRevenueData;
        return ((((((str != null ? str.hashCode() : 0) * 31) + this.getCurrencyIso4217Code) * 31) + this.getRevenue) * 31) + ((int) this.getMediationNetwork);
    }

    public final boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AFh1aSDK aFh1aSDK = (AFh1aSDK) obj;
            if (this.getCurrencyIso4217Code == aFh1aSDK.getCurrencyIso4217Code && this.getRevenue == aFh1aSDK.getRevenue && this.getMediationNetwork == aFh1aSDK.getMediationNetwork && (str = this.AFAdRevenueData) != null && str.equals(aFh1aSDK.AFAdRevenueData)) {
                return true;
            }
        }
        return false;
    }
}
