package com.appsflyer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public interface AFg1sSDK {
    AFa1uSDK AFAdRevenueData(Context context);

    /* loaded from: classes.dex */
    public static final class AFa1uSDK {
        final String AFAdRevenueData;
        final float getRevenue;

        public AFa1uSDK(float f, String str) {
            this.getRevenue = f;
            this.AFAdRevenueData = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AFa1uSDK) {
                AFa1uSDK aFa1uSDK = (AFa1uSDK) obj;
                return Float.compare(this.getRevenue, aFa1uSDK.getRevenue) == 0 && Intrinsics.areEqual(this.AFAdRevenueData, aFa1uSDK.AFAdRevenueData);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = Float.hashCode(this.getRevenue) * 31;
            String str = this.AFAdRevenueData;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            float f = this.getRevenue;
            return "BatteryData(level=" + f + ", charging=" + this.AFAdRevenueData + ")";
        }
    }
}
