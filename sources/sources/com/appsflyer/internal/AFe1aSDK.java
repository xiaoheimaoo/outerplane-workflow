package com.appsflyer.internal;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFe1rSDK;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u001c\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0015\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\u0017\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010(R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010%\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010,"}, d2 = {"Lcom/appsflyer/internal/AFe1aSDK;", "Lcom/appsflyer/internal/AFe1lSDK;", "", "Lcom/appsflyer/internal/AFe1rSDK;", "p0", "Ljava/util/concurrent/Executor;", "p1", "Lcom/appsflyer/internal/AFc1pSDK;", "p2", "Lcom/appsflyer/internal/AFc1gSDK;", "p3", "Lcom/appsflyer/internal/AFg1rSDK;", "p4", "Lcom/appsflyer/internal/AFf1cSDK;", "p5", "Lkotlin/Function1;", "Lcom/appsflyer/internal/AFe1uSDK;", "p6", "<init>", "(Lcom/appsflyer/internal/AFe1rSDK;Ljava/util/concurrent/Executor;Lcom/appsflyer/internal/AFc1pSDK;Lcom/appsflyer/internal/AFc1gSDK;Lcom/appsflyer/internal/AFg1rSDK;Lcom/appsflyer/internal/AFf1cSDK;Lkotlin/jvm/functions/Function1;)V", "", "getCurrencyIso4217Code", "()J", "getMediationNetwork", "()Lcom/appsflyer/internal/AFe1uSDK;", "getRevenue", "()V", "", "AFAdRevenueData", "()Z", "component3", "Ljava/util/concurrent/Executor;", "getMonetizationNetwork", "component4", "Lcom/appsflyer/internal/AFc1gSDK;", "areAllFieldsValid", "Lcom/appsflyer/internal/AFe1rSDK;", "component2", "Lcom/appsflyer/internal/AFg1rSDK;", "component1", "Lcom/appsflyer/internal/AFc1pSDK;", "toString", "Lkotlin/jvm/functions/Function1;", "copy", "Lcom/appsflyer/internal/AFf1cSDK;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AFe1aSDK extends AFe1lSDK<Unit> {
    public AFe1rSDK areAllFieldsValid;
    public AFc1pSDK component1;
    public AFg1rSDK component2;
    public Executor component3;
    public AFc1gSDK component4;
    public AFf1cSDK copy;
    public Function1<AFe1uSDK, Unit> toString;

    @Override // com.appsflyer.internal.AFe1lSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1lSDK
    public final long getCurrencyIso4217Code() {
        return 20000L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AFe1aSDK(AFe1rSDK aFe1rSDK, Executor executor, AFc1pSDK aFc1pSDK, AFc1gSDK aFc1gSDK, AFg1rSDK aFg1rSDK, AFf1cSDK aFf1cSDK, Function1<? super AFe1uSDK, Unit> function1) {
        super(AFe1mSDK.REGISTER_TRIGGER, new AFe1mSDK[]{AFe1mSDK.RC_CDN, AFe1mSDK.FETCH_ADVERTISING_ID}, null);
        Intrinsics.checkNotNullParameter(aFe1rSDK, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
        Intrinsics.checkNotNullParameter(aFg1rSDK, "");
        Intrinsics.checkNotNullParameter(aFf1cSDK, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.areAllFieldsValid = aFe1rSDK;
        this.component3 = executor;
        this.component1 = aFc1pSDK;
        this.component4 = aFc1gSDK;
        this.component2 = aFg1rSDK;
        this.copy = aFf1cSDK;
        this.toString = function1;
        if (aFe1rSDK instanceof AFe1rSDK.AFa1uSDK) {
            this.getMediationNetwork.add(AFe1mSDK.CONVERSION);
        }
        if (this.areAllFieldsValid instanceof AFe1rSDK.AFa1tSDK) {
            this.getRevenue.add(AFe1mSDK.CONVERSION);
        }
        if (this.areAllFieldsValid instanceof AFe1rSDK.AFa1ySDK) {
            this.getRevenue.add(AFe1mSDK.INAPP);
        }
    }

    @Override // com.appsflyer.internal.AFe1lSDK
    public final void getRevenue() {
        super.getRevenue();
        AFe1uSDK aFe1uSDK = this.AFAdRevenueData;
        if (aFe1uSDK != null) {
            this.toString.invoke(aFe1uSDK);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.appsflyer.internal.AFe1uSDK, T] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.appsflyer.internal.AFe1uSDK, T] */
    @Override // com.appsflyer.internal.AFe1lSDK
    public final AFe1uSDK getMediationNetwork() {
        MeasurementManager measurementManager;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = AFe1uSDK.FAILURE;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            Context context = this.component4.getRevenue;
            if (context != null && (measurementManager = (MeasurementManager) context.getSystemService(MeasurementManager.class)) != null) {
                new AFj1eSDK(this.component1, null, 2, null);
                Uri.Builder buildUpon = Uri.parse(AFj1eSDK.AFAdRevenueData()).buildUpon();
                String component4 = this.component1.component4();
                if (component4 == null) {
                    component4 = "";
                }
                Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("event_name", this.areAllFieldsValid.getMediationNetwork), TuplesKt.to("app_id", this.component1.getRevenue.getRevenue.getPackageName()), TuplesKt.to("app_version", this.component1.n_().versionName), TuplesKt.to("sdk_version", AFc1pSDK.getCurrencyIso4217Code()), TuplesKt.to("api_version", AFc1pSDK.AFAdRevenueData()), TuplesKt.to("timestamp", String.valueOf(this.component2.getCurrencyIso4217Code())), TuplesKt.to("request_id", AFc1pSDK.getMonetizationNetwork()), TuplesKt.to("gaid", component4));
                String revenue = AFb1jSDK.getRevenue(this.component1.getMonetizationNetwork);
                if (revenue != null) {
                    mutableMapOf.put("appsflyer_id", revenue);
                }
                Long AFAdRevenueData = this.component2.AFAdRevenueData();
                if (AFAdRevenueData != null) {
                    mutableMapOf.put("install_time", String.valueOf(AFAdRevenueData.longValue()));
                }
                AFe1rSDK aFe1rSDK = this.areAllFieldsValid;
                if (aFe1rSDK instanceof AFe1rSDK.AFa1ySDK) {
                    Float f = ((AFe1rSDK.AFa1ySDK) aFe1rSDK).getCurrencyIso4217Code;
                    if (f != null) {
                        mutableMapOf.put("event_revenue", String.valueOf(f.floatValue()));
                    }
                    Integer num = ((AFe1rSDK.AFa1ySDK) this.areAllFieldsValid).getRevenue;
                    if (num != null) {
                        mutableMapOf.put("event_count", String.valueOf(num.intValue()));
                    }
                }
                for (Map.Entry entry : mutableMapOf.entrySet()) {
                    buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
                }
                Uri build = buildUpon.build();
                Intrinsics.checkNotNullExpressionValue(build, "");
                measurementManager.registerTrigger(build, this.component3, new AFa1zSDK(objectRef, countDownLatch, this));
            }
            countDownLatch.await(4L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            objectRef.element = AFe1uSDK.TIMEOUT;
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.PRIVACY_SANDBOX, "Error occurred: " + th.getMessage(), th, false, false, false, true);
        }
        return (AFe1uSDK) objectRef.element;
    }

    /* loaded from: classes.dex */
    public static final class AFa1zSDK implements OutcomeReceiver<Object, Exception> {
        private /* synthetic */ Ref.ObjectRef<AFe1uSDK> getCurrencyIso4217Code;
        private /* synthetic */ AFe1aSDK getMediationNetwork;
        private /* synthetic */ CountDownLatch getMonetizationNetwork;

        AFa1zSDK(Ref.ObjectRef<AFe1uSDK> objectRef, CountDownLatch countDownLatch, AFe1aSDK aFe1aSDK) {
            this.getCurrencyIso4217Code = objectRef;
            this.getMonetizationNetwork = countDownLatch;
            this.getMediationNetwork = aFe1aSDK;
        }

        @Override // android.os.OutcomeReceiver
        public final /* synthetic */ void onError(Exception exc) {
            Exception exc2 = exc;
            Intrinsics.checkNotNullParameter(exc2, "");
            AFe1aSDK.AFAdRevenueData(exc2);
            this.getMonetizationNetwork.countDown();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.appsflyer.internal.AFe1uSDK, T] */
        @Override // android.os.OutcomeReceiver
        public final void onResult(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "");
            this.getCurrencyIso4217Code.element = AFe1uSDK.SUCCESS;
            AFLogger.INSTANCE.d(AFg1cSDK.PRIVACY_SANDBOX, "Privacy Sandbox trigger has been registered successfully. ", true);
            this.getMonetizationNetwork.countDown();
        }
    }

    public static final /* synthetic */ void AFAdRevenueData(Throwable th) {
        AFLogger.INSTANCE.e(AFg1cSDK.PRIVACY_SANDBOX, "Error occurred: " + th.getMessage(), th, false, false, false, true);
    }
}
