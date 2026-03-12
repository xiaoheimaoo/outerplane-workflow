package com.appsflyer.internal;

import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class AFe1xSDK<Body> implements ResponseNetwork<Body> {
    public final AFd1aSDK AFAdRevenueData;
    final Map<String, List<String>> getCurrencyIso4217Code;
    final int getMediationNetwork;
    final boolean getMonetizationNetwork;
    private final Body getRevenue;

    public AFe1xSDK(Body body, int i, boolean z, Map<String, List<String>> map, AFd1aSDK aFd1aSDK) {
        this.getRevenue = body;
        this.getMediationNetwork = i;
        this.getMonetizationNetwork = z;
        this.getCurrencyIso4217Code = new HashMap(map);
        this.AFAdRevenueData = aFd1aSDK;
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    public Body getBody() {
        return this.getRevenue;
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    public int getStatusCode() {
        return this.getMediationNetwork;
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    public boolean isSuccessful() {
        return this.getMonetizationNetwork;
    }

    @Override // com.appsflyer.internal.components.network.http.ResponseNetwork
    public List<String> getHeaderField(String str) {
        for (String str2 : this.getCurrencyIso4217Code.keySet()) {
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return this.getCurrencyIso4217Code.get(str2);
            }
        }
        return null;
    }

    public final String getMediationNetwork(String str) {
        List<String> headerField = getHeaderField(str);
        if (headerField == null || headerField.isEmpty()) {
            return null;
        }
        Iterator<String> it = headerField.iterator();
        StringBuilder sb = new StringBuilder(it.next());
        while (it.hasNext()) {
            sb.append(", ").append(it.next());
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFe1xSDK aFe1xSDK = (AFe1xSDK) obj;
        if (this.getMediationNetwork == aFe1xSDK.getMediationNetwork && this.getMonetizationNetwork == aFe1xSDK.getMonetizationNetwork && this.getRevenue.equals(aFe1xSDK.getRevenue) && this.getCurrencyIso4217Code.equals(aFe1xSDK.getCurrencyIso4217Code)) {
            return this.AFAdRevenueData.equals(aFe1xSDK.AFAdRevenueData);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.getRevenue.hashCode() * 31) + this.getMediationNetwork) * 31) + (this.getMonetizationNetwork ? 1 : 0)) * 31) + this.getCurrencyIso4217Code.hashCode()) * 31) + this.AFAdRevenueData.hashCode();
    }
}
