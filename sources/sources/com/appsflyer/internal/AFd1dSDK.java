package com.appsflyer.internal;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class AFd1dSDK {
    final Map<String, String> AFAdRevenueData;
    private final boolean areAllFieldsValid;
    private boolean component1;
    private final boolean component2;
    public int component3;
    private final byte[] component4;
    public boolean getCurrencyIso4217Code;
    public boolean getMediationNetwork;
    final String getMonetizationNetwork;
    public final String getRevenue;

    public AFd1dSDK(String str, byte[] bArr, String str2, Map<String, String> map, boolean z) {
        this(str, bArr, str2, map, z, (byte) 0);
    }

    private AFd1dSDK(String str, byte[] bArr, String str2, Map<String, String> map, boolean z, byte b) {
        this.component1 = true;
        this.getMediationNetwork = false;
        this.getCurrencyIso4217Code = true;
        this.component3 = -1;
        this.getRevenue = str;
        this.component4 = bArr;
        this.getMonetizationNetwork = str2;
        this.AFAdRevenueData = map;
        this.areAllFieldsValid = z;
        this.component2 = true;
    }

    public AFd1dSDK(String str, String str2) {
        this(str, null, str2, new HashMap(), false);
    }

    public final byte[] getMediationNetwork() {
        return this.component4;
    }

    public final boolean getRevenue() {
        return this.areAllFieldsValid;
    }

    public final boolean getMonetizationNetwork() {
        return this.component1;
    }

    public final boolean getCurrencyIso4217Code() {
        return this.getMediationNetwork;
    }

    public final boolean AFAdRevenueData() {
        return this.component2;
    }

    public final boolean component2() {
        return this.getCurrencyIso4217Code;
    }
}
