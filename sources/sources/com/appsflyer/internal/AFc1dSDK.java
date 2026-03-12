package com.appsflyer.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
/* loaded from: classes.dex */
public final class AFc1dSDK implements AFc1bSDK {
    private static final int getCurrencyIso4217Code = (int) TimeUnit.SECONDS.toMillis(30);
    private ScheduledExecutorService AFAdRevenueData;
    private AFc1uSDK AFInAppEventParameterName;
    private AFj1rSDK AFInAppEventType;
    private AFf1cSDK AFKeystoreWrapper;
    private AFe1ySDK AFLogger;
    private AFh1qSDK AFPurchaseDetails;
    private AFa1rSDK afDebugLog;
    private AFg1vSDK afErrorLog;
    private AFi1kSDK afInfoLog;
    private AFf1gSDK afLogForce;
    private AFi1jSDK afRDLog;
    private AFg1aSDK afVerboseLog;
    private AFe1qSDK afWarnLog;
    private PurchaseHandler areAllFieldsValid;
    private AFc1qSDK component1;
    private AFc1pSDK component2;
    private AFf1lSDK component3;
    private AFd1kSDK component4;
    private AFj1pSDK copy;
    private AFg1rSDK copydefault;
    private AFi1sSDK d;
    private AFj1eSDK e;
    private AFd1mSDK equals;
    private AFa1hSDK force;
    private AFc1eSDK getLevel;
    private ExecutorService getMediationNetwork;
    private ExecutorService getRevenue;
    private AFe1nSDK hashCode;
    private AFg1sSDK i;
    private AFd1ySDK registerClient;
    private AFh1tSDK toString;
    private AFi1lSDK unregisterClient;
    private AFa1bSDK v;
    private AFg1xSDK values;
    private AFb1aSDK w;
    private String afErrorLogForExcManagerOnly = null;
    public final AFc1gSDK getMonetizationNetwork = new AFc1gSDK();

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFe1qSDK AFAdRevenueData() {
        if (this.afWarnLog == null) {
            this.afWarnLog = new AFe1qSDK(component2(), registerClient(), getCurrencyIso4217Code(), getMediationNetwork(), component4(), AFKeystoreWrapper(), copydefault());
        }
        return this.afWarnLog;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFd1lSDK getRevenue() {
        return new AFd1lSDK(afVerboseLog(), getCurrencyIso4217Code(), AppsFlyerProperties.getInstance(), AFInAppEventParameterName(), AFPurchaseType());
    }

    private synchronized AFd1kSDK afVerboseLog() {
        if (this.component4 == null) {
            this.component4 = new AFd1kSDK(new AFd1fSDK(getCurrencyIso4217Code), getMediationNetwork());
        }
        return this.component4;
    }

    private String AFLoggerLogLevel() {
        if (this.afErrorLogForExcManagerOnly == null) {
            this.afErrorLogForExcManagerOnly = new com.appsflyer.internal.AFa1ySDK().getMediationNetwork();
        }
        return this.afErrorLogForExcManagerOnly;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized ExecutorService getMediationNetwork() {
        if (this.getRevenue == null) {
            this.getRevenue = AFc1jSDK.AFAdRevenueData();
        }
        return this.getRevenue;
    }

    private synchronized ExecutorService valueOf() {
        if (this.getMediationNetwork == null) {
            this.getMediationNetwork = AFc1jSDK.getCurrencyIso4217Code();
        }
        return this.getMediationNetwork;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized ScheduledExecutorService getMonetizationNetwork() {
        if (this.AFAdRevenueData == null) {
            this.AFAdRevenueData = AFc1jSDK.getMonetizationNetwork();
        }
        return this.AFAdRevenueData;
    }

    private synchronized ScheduledExecutorService getLevel() {
        if (this.AFAdRevenueData == null) {
            this.AFAdRevenueData = AFc1jSDK.getMediationNetwork();
        }
        return this.AFAdRevenueData;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFc1pSDK getCurrencyIso4217Code() {
        if (this.component2 == null) {
            AFc1gSDK registerClient = registerClient();
            AFc1oSDK component2 = component2();
            if (this.getLevel == null) {
                this.getLevel = new AFc1eSDK();
            }
            this.component2 = new AFc1pSDK(registerClient, component2, this.getLevel, getMediationNetwork());
        }
        return this.component2;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFc1oSDK component2() {
        if (this.component1 == null) {
            this.component1 = new AFc1qSDK(new AFc1hSDK(new Function0() { // from class: com.appsflyer.internal.AFc1dSDK$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    SharedPreferences o_;
                    o_ = AFc1dSDK.this.o_();
                    return o_;
                }
            }));
        }
        return this.component1;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized PurchaseHandler areAllFieldsValid() {
        if (this.areAllFieldsValid == null) {
            this.areAllFieldsValid = new PurchaseHandler(this);
        }
        return this.areAllFieldsValid;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFf1lSDK component1() {
        if (this.component3 == null) {
            AFf1iSDK aFf1iSDK = new AFf1iSDK(component2());
            this.component3 = new AFf1lSDK(new AFf1qSDK(), getCurrencyIso4217Code(), AFKeystoreWrapper(), aFf1iSDK, new AFd1lSDK(afVerboseLog(), getCurrencyIso4217Code(), AppsFlyerProperties.getInstance(), AFInAppEventParameterName(), AFPurchaseType()), new AFf1hSDK(getCurrencyIso4217Code(), aFf1iSDK), copydefault());
        }
        return this.component3;
    }

    private synchronized AFg1xSDK AFPurchaseDetails() {
        if (this.values == null) {
            this.values = new AFg1xSDK(registerClient(), getCurrencyIso4217Code());
        }
        return this.values;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFh1tSDK component3() {
        if (this.toString == null) {
            this.toString = new AFh1tSDK(component2(), getCurrencyIso4217Code());
        }
        return this.toString;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFg1rSDK component4() {
        if (this.copydefault == null) {
            String AFLoggerLogLevel = AFLoggerLogLevel();
            Context context = this.getMonetizationNetwork.getRevenue;
            if (context == null) {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
            if (this.unregisterClient == null) {
                this.unregisterClient = new AFi1gSDK();
            }
            AFi1lSDK aFi1lSDK = this.unregisterClient;
            if (this.i == null) {
                this.i = new AFg1wSDK();
            }
            AFg1sSDK aFg1sSDK = this.i;
            if (this.copy == null) {
                Context context2 = this.getMonetizationNetwork.getRevenue;
                if (context2 != null) {
                    this.copy = new AFj1oSDK(context2, valueOf());
                } else {
                    throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                }
            }
            AFj1pSDK aFj1pSDK = this.copy;
            if (this.afErrorLog == null) {
                this.afErrorLog = new AFg1oSDK();
            }
            AFg1vSDK aFg1vSDK = this.afErrorLog;
            AFh1tSDK component3 = component3();
            AFc1oSDK component2 = component2();
            AFc1pSDK currencyIso4217Code = getCurrencyIso4217Code();
            if (this.d == null) {
                Context context3 = this.getMonetizationNetwork.getRevenue;
                if (context3 != null) {
                    this.d = new AFi1sSDK(context3);
                } else {
                    throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                }
            }
            AFi1sSDK aFi1sSDK = this.d;
            AFf1cSDK AFKeystoreWrapper = AFKeystoreWrapper();
            AFc1gSDK registerClient = registerClient();
            AFg1xSDK AFPurchaseDetails = AFPurchaseDetails();
            if (this.getLevel == null) {
                this.getLevel = new AFc1eSDK();
            }
            this.copydefault = new AFg1qSDK(AFLoggerLogLevel, context, aFi1lSDK, aFg1sSDK, aFj1pSDK, aFg1vSDK, component3, component2, currencyIso4217Code, aFi1sSDK, AFKeystoreWrapper, registerClient, AFPurchaseDetails, this.getLevel);
        }
        return this.copydefault;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFj1pSDK copy() {
        if (this.copy == null) {
            Context context = this.getMonetizationNetwork.getRevenue;
            if (context != null) {
                this.copy = new AFj1oSDK(context, valueOf());
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.copy;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFe1nSDK copydefault() {
        if (this.hashCode == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 6, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>() { // from class: com.appsflyer.internal.AFc1dSDK.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
                /* renamed from: AFAdRevenueData */
                public boolean offer(Runnable runnable) {
                    if (isEmpty()) {
                        return super.offer(runnable);
                    }
                    return false;
                }
            }, new AFa1ySDK());
            threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.appsflyer.internal.AFc1dSDK$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.RejectedExecutionHandler
                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                    AFc1dSDK.getCurrencyIso4217Code(runnable, threadPoolExecutor2);
                }
            });
            this.hashCode = new AFe1nSDK(threadPoolExecutor);
        }
        return this.hashCode;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFd1mSDK equals() {
        if (this.equals == null) {
            this.equals = new AFd1nSDK(this);
        }
        return this.equals;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFj1rSDK AFLogger() {
        if (this.AFInAppEventType == null) {
            this.AFInAppEventType = new AFj1rSDK(this);
        }
        return this.AFInAppEventType;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFf1cSDK AFKeystoreWrapper() {
        if (this.AFKeystoreWrapper == null) {
            this.AFKeystoreWrapper = new AFf1cSDK(registerClient(), new AFf1eSDK());
        }
        return this.AFKeystoreWrapper;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFc1gSDK registerClient() {
        return this.getMonetizationNetwork;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFc1uSDK AFInAppEventType() {
        if (this.AFInAppEventParameterName == null) {
            this.AFInAppEventParameterName = new AFc1rSDK(registerClient(), component2());
        }
        return this.AFInAppEventParameterName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.appsflyer.internal.AFc1bSDK
    /* renamed from: values */
    public synchronized AFd1ySDK afWarnLog() {
        if (this.registerClient == null) {
            this.registerClient = new AFd1ySDK(this);
        }
        return this.registerClient;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFe1ySDK AFInAppEventParameterName() {
        if (this.AFLogger == null) {
            this.AFLogger = new AFe1ySDK(getCurrencyIso4217Code(), component2());
        }
        return this.AFLogger;
    }

    private synchronized AFj1eSDK AFPurchaseType() {
        if (this.e == null) {
            this.e = new AFj1eSDK(getCurrencyIso4217Code());
        }
        return this.e;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFi1lSDK e() {
        if (this.unregisterClient == null) {
            this.unregisterClient = new AFi1gSDK();
        }
        return this.unregisterClient;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFa1rSDK i() {
        if (this.afDebugLog == null) {
            this.afDebugLog = new AFa1rSDK(this);
        }
        return this.afDebugLog;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final synchronized AFa1bSDK unregisterClient() {
        if (this.v == null) {
            this.v = new AFa1aSDK(registerClient());
        }
        return this.v;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFi1sSDK w() {
        if (this.d == null) {
            Context context = this.getMonetizationNetwork.getRevenue;
            if (context != null) {
                this.d = new AFi1sSDK(context);
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.d;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFi1kSDK d() {
        if (this.afInfoLog == null) {
            this.afInfoLog = new AFi1nSDK();
        }
        return this.afInfoLog;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFc1eSDK afInfoLog() {
        if (this.getLevel == null) {
            this.getLevel = new AFc1eSDK();
        }
        return this.getLevel;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFb1aSDK afDebugLog() {
        if (this.w == null) {
            ScheduledExecutorService level = getLevel();
            AFa1rSDK i = i();
            if (this.afInfoLog == null) {
                this.afInfoLog = new AFi1nSDK();
            }
            this.w = new AFb1cSDK(level, i, this.afInfoLog);
        }
        return this.w;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFg1aSDK afErrorLog() {
        if (this.afVerboseLog == null) {
            this.afVerboseLog = new AFh1vSDK(this);
        }
        return this.afVerboseLog;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFf1gSDK force() {
        if (this.afLogForce == null) {
            Context context = this.getMonetizationNetwork.getRevenue;
            if (context != null) {
                AFg1zSDK aFg1zSDK = new AFg1zSDK(context, AppsFlyerProperties.getInstance());
                if (this.getLevel == null) {
                    this.getLevel = new AFc1eSDK();
                }
                this.afLogForce = new AFf1fSDK(aFg1zSDK, this.getLevel, AppsFlyerProperties.getInstance());
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.afLogForce;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFi1jSDK v() {
        try {
            if (this.afRDLog == null) {
                Object[] objArr = {getCurrencyIso4217Code(), registerClient(), AFKeystoreWrapper()};
                Object obj = AFi1hSDK.d.get(-737518627);
                if (obj == null) {
                    obj = ((Class) AFi1hSDK.getCurrencyIso4217Code((char) (ViewConfiguration.getKeyRepeatDelay() >> 16), 36 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), TextUtils.getCapsMode("", 0, 0))).getDeclaredConstructor(AFc1pSDK.class, AFc1gSDK.class, AFf1cSDK.class);
                    AFi1hSDK.d.put(-737518627, obj);
                }
                this.afRDLog = (AFi1jSDK) ((Constructor) obj).newInstance(objArr);
            }
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.PLAY_INTEGRITY_API, th.getMessage() != null ? th.getMessage() : "", th, false, false);
        }
        return this.afRDLog;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFa1hSDK afErrorLogForExcManagerOnly() {
        if (this.force == null) {
            this.force = new AFa1lSDK(component2());
        }
        return this.force;
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFb1bSDK afRDLog() {
        if (this.getLevel == null) {
            this.getLevel = new AFc1eSDK();
        }
        return new AFb1hSDK(this.getLevel, registerClient(), AFKeystoreWrapper());
    }

    @Override // com.appsflyer.internal.AFc1bSDK
    public final AFh1qSDK afLogForce() {
        if (AFh1sSDK.getMonetizationNetwork() && this.AFPurchaseDetails == null) {
            this.AFPurchaseDetails = new AFh1oSDK(getCurrencyIso4217Code(), AFLogger());
        }
        return this.AFPurchaseDetails;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void getCurrencyIso4217Code(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.getQueue().put(runnable);
        } catch (InterruptedException e) {
            AFLogger.afErrorLogForExcManagerOnly("could not create executor for queue", e);
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AFa1ySDK implements ThreadFactory {
        private static final AtomicInteger getRevenue = new AtomicInteger();
        private final AtomicInteger getMediationNetwork = new AtomicInteger();

        public AFa1ySDK() {
            getRevenue.incrementAndGet();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            int i = getRevenue.get();
            return new Thread(runnable, new StringBuilder("queue-").append(i).append("-").append(this.getMediationNetwork.incrementAndGet()).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SharedPreferences o_() {
        Context context = this.getMonetizationNetwork.getRevenue;
        if (context != null) {
            return AFa1uSDK.d_(context);
        }
        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
    }
}
