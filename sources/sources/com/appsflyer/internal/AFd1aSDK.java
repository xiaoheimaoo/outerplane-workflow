package com.appsflyer.internal;
/* loaded from: classes.dex */
public class AFd1aSDK {
    public final long getRevenue;

    public AFd1aSDK(long j) {
        this.getRevenue = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.getRevenue == ((AFd1aSDK) obj).getRevenue;
    }

    public int hashCode() {
        long j = this.getRevenue;
        return (int) (j ^ (j >>> 32));
    }
}
