package com.appsflyer.internal;

import com.appsflyer.PurchaseHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public interface AFc1bSDK {
    AFe1qSDK AFAdRevenueData();

    AFe1ySDK AFInAppEventParameterName();

    AFc1uSDK AFInAppEventType();

    AFf1cSDK AFKeystoreWrapper();

    AFj1rSDK AFLogger();

    AFb1aSDK afDebugLog();

    AFg1aSDK afErrorLog();

    AFa1hSDK afErrorLogForExcManagerOnly();

    AFc1eSDK afInfoLog();

    AFh1qSDK afLogForce();

    AFb1bSDK afRDLog();

    AFd1xSDK afWarnLog();

    PurchaseHandler areAllFieldsValid();

    AFf1lSDK component1();

    AFc1oSDK component2();

    AFh1tSDK component3();

    AFg1rSDK component4();

    AFj1pSDK copy();

    AFe1nSDK copydefault();

    AFi1kSDK d();

    AFi1lSDK e();

    AFd1mSDK equals();

    AFf1gSDK force();

    AFc1pSDK getCurrencyIso4217Code();

    ExecutorService getMediationNetwork();

    ScheduledExecutorService getMonetizationNetwork();

    AFd1lSDK getRevenue();

    AFa1rSDK i();

    AFc1gSDK registerClient();

    AFa1bSDK unregisterClient();

    AFi1jSDK v();

    AFi1sSDK w();
}
