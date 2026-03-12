package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFe1wSDK {
    final String AFAdRevenueData;
    final String getRevenue;

    public AFe1wSDK(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.AFAdRevenueData = str;
        this.getRevenue = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AFe1wSDK) {
            AFe1wSDK aFe1wSDK = (AFe1wSDK) obj;
            return Intrinsics.areEqual(this.AFAdRevenueData, aFe1wSDK.AFAdRevenueData) && Intrinsics.areEqual(this.getRevenue, aFe1wSDK.getRevenue);
        }
        return false;
    }

    public final int hashCode() {
        return (this.AFAdRevenueData.hashCode() * 31) + this.getRevenue.hashCode();
    }

    public final String toString() {
        String str = this.AFAdRevenueData;
        return "HostConfig(prefix=" + str + ", host=" + this.getRevenue + ")";
    }
}
