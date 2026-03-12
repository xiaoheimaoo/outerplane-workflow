package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\u000b8GX\u0087\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8GX\u0087\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013"}, d2 = {"Lcom/appsflyer/internal/AFf1hSDK;", "", "Lcom/appsflyer/internal/AFc1pSDK;", "p0", "Lcom/appsflyer/internal/AFf1iSDK;", "p1", "<init>", "(Lcom/appsflyer/internal/AFc1pSDK;Lcom/appsflyer/internal/AFf1iSDK;)V", "", "getMonetizationNetwork", "()J", "", "getRevenue", "()Z", "Lcom/appsflyer/internal/AFc1pSDK;", "getCurrencyIso4217Code", "getMediationNetwork", "Lkotlin/Lazy;", "AFAdRevenueData", "Lcom/appsflyer/internal/AFf1iSDK;", "AFa1zSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AFf1hSDK {
    private final AFf1iSDK getCurrencyIso4217Code;
    private final Lazy getMediationNetwork;
    private final Lazy getMonetizationNetwork;
    private final AFc1pSDK getRevenue;
    public static final AFa1zSDK AFa1zSDK = new AFa1zSDK(null);
    private static final long AFAdRevenueData = TimeUnit.HOURS.toSeconds(24);

    public AFf1hSDK(AFc1pSDK aFc1pSDK, AFf1iSDK aFf1iSDK) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFf1iSDK, "");
        this.getRevenue = aFc1pSDK;
        this.getCurrencyIso4217Code = aFf1iSDK;
        this.getMediationNetwork = LazyKt.lazy(new Function0<Boolean>() { // from class: com.appsflyer.internal.AFf1hSDK.2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: getMediationNetwork */
            public final Boolean invoke() {
                return Boolean.valueOf(Boolean.parseBoolean(AFf1hSDK.this.getRevenue.getMonetizationNetwork("com.appsflyer.rc.sandbox")));
            }

            {
                super(0);
            }
        });
        this.getMonetizationNetwork = LazyKt.lazy(new Function0<Boolean>() { // from class: com.appsflyer.internal.AFf1hSDK.1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: AFAdRevenueData */
            public final Boolean invoke() {
                return Boolean.valueOf(Boolean.parseBoolean(AFf1hSDK.this.getRevenue.getMonetizationNetwork("com.appsflyer.rc.staging")));
            }

            {
                super(0);
            }
        });
    }

    public final boolean getCurrencyIso4217Code() {
        return ((Boolean) this.getMediationNetwork.getValue()).booleanValue();
    }

    public final boolean AFAdRevenueData() {
        return ((Boolean) this.getMonetizationNetwork.getValue()).booleanValue();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/appsflyer/internal/AFf1hSDK$AFa1zSDK;", "", "<init>", "()V", "", "AFAdRevenueData", "J", "getMonetizationNetwork"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AFa1zSDK {
        private AFa1zSDK() {
        }

        public /* synthetic */ AFa1zSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final long getMonetizationNetwork() {
        Object m539constructorimpl;
        String monetizationNetwork = this.getRevenue.getMonetizationNetwork("com.appsflyer.rc.cache.max-age-fallback");
        if (monetizationNetwork != null) {
            try {
                Result.Companion companion = Result.Companion;
                AFf1hSDK aFf1hSDK = this;
                m539constructorimpl = Result.m539constructorimpl(Long.valueOf(Long.parseLong(monetizationNetwork)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m539constructorimpl = Result.m539constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m542exceptionOrNullimpl = Result.m542exceptionOrNullimpl(m539constructorimpl);
            if (m542exceptionOrNullimpl != null) {
                AFLogger.afErrorLog("Can't read maxAgeFallback from Manifest: " + m542exceptionOrNullimpl.getMessage(), m542exceptionOrNullimpl);
                m539constructorimpl = Long.valueOf(AFAdRevenueData);
            }
            return ((Number) m539constructorimpl).longValue();
        }
        return AFAdRevenueData;
    }

    public final boolean getRevenue() {
        AFi1ySDK aFi1ySDK;
        AFi1wSDK aFi1wSDK = this.getCurrencyIso4217Code.AFAdRevenueData;
        if (aFi1wSDK == null) {
            AFh1ySDK.i$default(AFLogger.INSTANCE, AFg1cSDK.REMOTE_CONTROL, "active config is missing - fetching from CDN", false, 4, null);
            return true;
        }
        AFi1zSDK aFi1zSDK = aFi1wSDK.getMonetizationNetwork;
        return ((aFi1zSDK == null || (aFi1ySDK = aFi1zSDK.getMediationNetwork) == null) ? false : aFi1ySDK.getMonetizationNetwork()) || System.currentTimeMillis() - this.getCurrencyIso4217Code.getCurrencyIso4217Code > TimeUnit.SECONDS.toMillis(this.getCurrencyIso4217Code.getRevenue);
    }
}
