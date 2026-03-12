package com.appsflyer.internal;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class AFb1rSDK {
    public final Map<String, Object> getRevenue = new HashMap();
    public Map<String, Object> getCurrencyIso4217Code = new HashMap();

    public final void getMonetizationNetwork(Map<String, Object> map) {
        if (!this.getRevenue.isEmpty()) {
            map.put("partner_data", this.getRevenue);
        }
        if (this.getCurrencyIso4217Code.isEmpty()) {
            return;
        }
        AFa1uSDK.getMonetizationNetwork(map).put("partner_data", this.getCurrencyIso4217Code);
        this.getCurrencyIso4217Code = new HashMap();
    }
}
