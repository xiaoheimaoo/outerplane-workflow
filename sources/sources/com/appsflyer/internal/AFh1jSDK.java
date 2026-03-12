package com.appsflyer.internal;

import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class AFh1jSDK {
    public Map<String, Object> AFAdRevenueData;
    public String areAllFieldsValid;
    public int component1;
    public String component2;
    public String component3;
    public String component4;
    private final boolean copy;
    public Map<String, Object> getCurrencyIso4217Code;
    public String getMediationNetwork;
    public AppsFlyerRequestListener getMonetizationNetwork;
    public String getRevenue;
    private byte[] hashCode;

    public boolean areAllFieldsValid() {
        return true;
    }

    public boolean component1() {
        return true;
    }

    public boolean component3() {
        return false;
    }

    public abstract AFe1mSDK getCurrencyIso4217Code();

    public boolean getMonetizationNetwork() {
        return true;
    }

    public AFh1jSDK() {
        this(null, null, null);
    }

    public AFh1jSDK(String str, String str2, Boolean bool) {
        this.getCurrencyIso4217Code = new HashMap();
        this.component4 = str;
        this.component3 = str2;
        this.copy = bool != null ? bool.booleanValue() : true;
    }

    public final boolean getMediationNetwork() {
        return this.component4 == null && this.getRevenue == null;
    }

    public final AFh1jSDK getMonetizationNetwork(Map<String, ?> map) {
        synchronized (map) {
            this.getCurrencyIso4217Code.putAll(map);
        }
        return this;
    }

    public final AFh1jSDK getMonetizationNetwork(String str, Object obj) {
        synchronized (this.getCurrencyIso4217Code) {
            this.getCurrencyIso4217Code.put(str, obj);
        }
        return this;
    }

    public final AFh1jSDK getMonetizationNetwork(int i) {
        this.component1 = i;
        synchronized (this.getCurrencyIso4217Code) {
            if (this.getCurrencyIso4217Code.containsKey("counter")) {
                this.getCurrencyIso4217Code.put("counter", Integer.toString(i));
            }
            if (this.getCurrencyIso4217Code.containsKey("launch_counter")) {
                this.getCurrencyIso4217Code.put("launch_counter", Integer.toString(i));
            }
        }
        return this;
    }

    public final AFh1jSDK getMonetizationNetwork(byte[] bArr) {
        this.hashCode = bArr;
        return this;
    }

    public final byte[] AFAdRevenueData() {
        return this.hashCode;
    }

    public final boolean getRevenue() {
        return this.copy;
    }

    public static boolean getCurrencyIso4217Code(double d) {
        if (d < 0.0d || d >= 1.0d) {
            return false;
        }
        if (d == 0.0d) {
            return true;
        }
        int i = (int) (1.0d / d);
        int i2 = i + 1;
        if (i2 > 0) {
            return ((int) ((Math.random() * ((double) (i2 - 1))) + 1.0d)) != i;
        }
        throw new IllegalArgumentException("Unsupported max value");
    }
}
