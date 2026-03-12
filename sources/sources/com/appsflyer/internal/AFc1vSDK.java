package com.appsflyer.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFc1vSDK {
    final List<AFe1mSDK> AFAdRevenueData;
    final String getCurrencyIso4217Code;
    final int getMediationNetwork;

    /* JADX WARN: Multi-variable type inference failed */
    public AFc1vSDK(String str, List<? extends AFe1mSDK> list, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.getCurrencyIso4217Code = str;
        this.AFAdRevenueData = list;
        this.getMediationNetwork = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AFc1vSDK) {
            AFc1vSDK aFc1vSDK = (AFc1vSDK) obj;
            return Intrinsics.areEqual(this.getCurrencyIso4217Code, aFc1vSDK.getCurrencyIso4217Code) && Intrinsics.areEqual(this.AFAdRevenueData, aFc1vSDK.AFAdRevenueData) && this.getMediationNetwork == aFc1vSDK.getMediationNetwork;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.getCurrencyIso4217Code.hashCode() * 31) + this.AFAdRevenueData.hashCode()) * 31) + Integer.hashCode(this.getMediationNetwork);
    }

    public final String toString() {
        String str = this.getCurrencyIso4217Code;
        List<AFe1mSDK> list = this.AFAdRevenueData;
        return "StorageConfigTypeEntry(cacheDirName=" + str + ", eventTypes=" + list + ", maxCapacity=" + this.getMediationNetwork + ")";
    }
}
