package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFb1gSDK {
    public final String getCurrencyIso4217Code;
    public final int getRevenue;

    public AFb1gSDK(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getRevenue = i;
        this.getCurrencyIso4217Code = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AFb1gSDK) {
            AFb1gSDK aFb1gSDK = (AFb1gSDK) obj;
            return this.getRevenue == aFb1gSDK.getRevenue && Intrinsics.areEqual(this.getCurrencyIso4217Code, aFb1gSDK.getCurrencyIso4217Code);
        }
        return false;
    }

    public final int hashCode() {
        return (Integer.hashCode(this.getRevenue) * 31) + this.getCurrencyIso4217Code.hashCode();
    }

    public final String toString() {
        int i = this.getRevenue;
        return "AppSetIdModel(scope=" + i + ", id=" + this.getCurrencyIso4217Code + ")";
    }
}
