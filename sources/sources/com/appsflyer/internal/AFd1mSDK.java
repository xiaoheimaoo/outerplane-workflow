package com.appsflyer.internal;

import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public interface AFd1mSDK {
    void AFAdRevenueData();

    boolean areAllFieldsValid();

    void getCurrencyIso4217Code(String str, String... strArr);

    boolean getCurrencyIso4217Code();

    void getMediationNetwork();

    void getMonetizationNetwork();

    void getMonetizationNetwork(String str, int i, String str2);

    void getMonetizationNetwork(String str, String str2);

    void getMonetizationNetwork(Throwable th);

    void getRevenue();

    void getRevenue(String str, String str2);

    void q_(String str, PackageManager packageManager);
}
