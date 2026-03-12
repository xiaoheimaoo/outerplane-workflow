package com.appsflyer.internal;

import java.util.Map;
/* loaded from: classes.dex */
public interface AFg1rSDK {
    Long AFAdRevenueData();

    void AFAdRevenueData(AFh1jSDK aFh1jSDK);

    long getCurrencyIso4217Code();

    void getCurrencyIso4217Code(AFh1jSDK aFh1jSDK);

    void getCurrencyIso4217Code(Map<String, Object> map);

    void getCurrencyIso4217Code(Map<String, Object> map, int i, int i2);

    void getMediationNetwork(AFh1jSDK aFh1jSDK);

    void getMediationNetwork(Map<String, Object> map);

    void getMonetizationNetwork(AFh1jSDK aFh1jSDK);

    void getMonetizationNetwork(Map<String, Object> map);

    void getMonetizationNetwork(Map<String, Object> map, AFe1mSDK aFe1mSDK);

    void getRevenue(AFh1jSDK aFh1jSDK);

    void getRevenue(Map<String, Object> map);
}
