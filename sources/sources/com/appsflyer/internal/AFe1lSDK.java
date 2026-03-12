package com.appsflyer.internal;

import android.net.TrafficStats;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class AFe1lSDK<Result> implements Comparable<AFe1lSDK<?>>, Callable<AFe1uSDK> {
    private static final AtomicInteger component4 = new AtomicInteger();
    public AFe1uSDK AFAdRevenueData;
    private final int areAllFieldsValid;
    private final String component1;
    private long component2;
    private Throwable component3;
    public final AFe1mSDK getCurrencyIso4217Code;
    public final Set<AFe1mSDK> getMediationNetwork;
    public volatile int getMonetizationNetwork;
    public final Set<AFe1mSDK> getRevenue;
    private boolean toString;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean AFAdRevenueData();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long getCurrencyIso4217Code();

    protected abstract AFe1uSDK getMediationNetwork() throws Exception;

    protected void getMediationNetwork(Throwable th) {
    }

    public void getRevenue() {
    }

    public AFe1lSDK(AFe1mSDK aFe1mSDK, AFe1mSDK[] aFe1mSDKArr, String str) {
        HashSet hashSet = new HashSet();
        this.getMediationNetwork = hashSet;
        this.getRevenue = new HashSet();
        int incrementAndGet = component4.incrementAndGet();
        this.areAllFieldsValid = incrementAndGet;
        this.toString = false;
        this.getMonetizationNetwork = 0;
        this.getCurrencyIso4217Code = aFe1mSDK;
        Collections.addAll(hashSet, aFe1mSDKArr);
        if (str != null) {
            this.component1 = str;
        } else {
            this.component1 = String.valueOf(incrementAndGet);
        }
    }

    public void getMonetizationNetwork() {
        this.toString = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean component4() {
        return this.toString;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: component3 */
    public final AFe1uSDK call() throws Exception {
        TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
        this.AFAdRevenueData = null;
        this.component3 = null;
        long currentTimeMillis = System.currentTimeMillis();
        this.getMonetizationNetwork++;
        try {
            AFe1uSDK mediationNetwork = getMediationNetwork();
            this.AFAdRevenueData = mediationNetwork;
            return mediationNetwork;
        } finally {
        }
    }

    public final Throwable component1() {
        return this.component3;
    }

    @Override // java.lang.Comparable
    /* renamed from: getRevenue */
    public final int compareTo(AFe1lSDK<?> aFe1lSDK) {
        int i = this.getCurrencyIso4217Code.unregisterClient - aFe1lSDK.getCurrencyIso4217Code.unregisterClient;
        if (i == 0) {
            if (this.component1.equals(aFe1lSDK.component1)) {
                return 0;
            }
            return this.areAllFieldsValid - aFe1lSDK.areAllFieldsValid;
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFe1lSDK aFe1lSDK = (AFe1lSDK) obj;
        if (this.getCurrencyIso4217Code != aFe1lSDK.getCurrencyIso4217Code) {
            return false;
        }
        return this.component1.equals(aFe1lSDK.component1);
    }

    public final int hashCode() {
        return (this.getCurrencyIso4217Code.hashCode() * 31) + this.component1.hashCode();
    }

    public String toString() {
        String obj = new StringBuilder().append(this.getCurrencyIso4217Code).append("-").append(this.component1).toString();
        return !String.valueOf(this.areAllFieldsValid).equals(this.component1) ? new StringBuilder().append(obj).append("-").append(this.areAllFieldsValid).toString() : obj;
    }
}
