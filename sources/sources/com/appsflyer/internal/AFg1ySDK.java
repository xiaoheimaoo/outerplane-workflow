package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFg1ySDK {
    final int AFAdRevenueData;
    final int getCurrencyIso4217Code;
    final String getMediationNetwork;
    final int getMonetizationNetwork;
    final int getRevenue;

    public AFg1ySDK(int i, int i2, int i3, int i4, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getCurrencyIso4217Code = i;
        this.AFAdRevenueData = i2;
        this.getMonetizationNetwork = i3;
        this.getRevenue = i4;
        this.getMediationNetwork = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AFg1ySDK) {
            AFg1ySDK aFg1ySDK = (AFg1ySDK) obj;
            return this.getCurrencyIso4217Code == aFg1ySDK.getCurrencyIso4217Code && this.AFAdRevenueData == aFg1ySDK.AFAdRevenueData && this.getMonetizationNetwork == aFg1ySDK.getMonetizationNetwork && this.getRevenue == aFg1ySDK.getRevenue && Intrinsics.areEqual(this.getMediationNetwork, aFg1ySDK.getMediationNetwork);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((Integer.hashCode(this.getCurrencyIso4217Code) * 31) + Integer.hashCode(this.AFAdRevenueData)) * 31) + Integer.hashCode(this.getMonetizationNetwork)) * 31) + Integer.hashCode(this.getRevenue)) * 31) + this.getMediationNetwork.hashCode();
    }

    public final String toString() {
        int i = this.getCurrencyIso4217Code;
        int i2 = this.AFAdRevenueData;
        int i3 = this.getMonetizationNetwork;
        int i4 = this.getRevenue;
        return "CmpTcfData(policyVersion=" + i + ", gdprApplies=" + i2 + ", cmpSdkId=" + i3 + ", cmpSdkVersion=" + i4 + ", tcString=" + this.getMediationNetwork + ")";
    }
}
