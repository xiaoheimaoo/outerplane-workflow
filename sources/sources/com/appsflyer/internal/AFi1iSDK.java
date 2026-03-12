package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFi1iSDK {
    public final long getCurrencyIso4217Code;
    public final String getMediationNetwork;
    public final String getMonetizationNetwork;
    public final long getRevenue;

    public AFi1iSDK(long j, long j2, String str, String str2) {
        this.getRevenue = j;
        this.getCurrencyIso4217Code = j2;
        this.getMonetizationNetwork = str;
        this.getMediationNetwork = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AFi1iSDK) {
            AFi1iSDK aFi1iSDK = (AFi1iSDK) obj;
            return this.getRevenue == aFi1iSDK.getRevenue && this.getCurrencyIso4217Code == aFi1iSDK.getCurrencyIso4217Code && Intrinsics.areEqual(this.getMonetizationNetwork, aFi1iSDK.getMonetizationNetwork) && Intrinsics.areEqual(this.getMediationNetwork, aFi1iSDK.getMediationNetwork);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((Long.hashCode(this.getRevenue) * 31) + Long.hashCode(this.getCurrencyIso4217Code)) * 31;
        String str = this.getMonetizationNetwork;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.getMediationNetwork;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        long j = this.getRevenue;
        long j2 = this.getCurrencyIso4217Code;
        String str = this.getMonetizationNetwork;
        return "PlayIntegrityApiData(piaTimestamp=" + j + ", ttrMillis=" + j2 + ", piaToken=" + str + ", errorCode=" + this.getMediationNetwork + ")";
    }
}
