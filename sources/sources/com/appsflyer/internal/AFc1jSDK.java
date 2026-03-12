package com.appsflyer.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFc1jSDK {
    private static final Lazy getMonetizationNetwork = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.appsflyer.internal.AFc1jSDK.4
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: getMonetizationNetwork */
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor();
        }
    });

    public static final ExecutorService AFAdRevenueData() {
        AFc1kSDK aFc1kSDK = new AFc1kSDK(1, 4, 30L, TimeUnit.SECONDS, new SynchronousQueue(), null, 32, null);
        aFc1kSDK.allowCoreThreadTimeOut(true);
        return aFc1kSDK;
    }

    public static final ScheduledExecutorService getMonetizationNetwork() {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
        Intrinsics.checkNotNullExpressionValue(newScheduledThreadPool, "");
        return newScheduledThreadPool;
    }

    public static final ScheduledExecutorService getMediationNetwork() {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "");
        return newSingleThreadScheduledExecutor;
    }

    public static final ExecutorService getCurrencyIso4217Code() {
        Object value = getMonetizationNetwork.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        return (ExecutorService) value;
    }
}
