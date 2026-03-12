package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFj1qSDK;
import com.helpshift.HelpshiftEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFf1wSDK extends AFe1eSDK<AFa1mSDK> {
    private int AFInAppEventParameterName;
    private int AFInAppEventType;
    private final CountDownLatch AFKeystoreWrapper;
    private int AFLogger;
    private final AFa1pSDK areAllFieldsValid;
    private final AFj1rSDK copy;
    private final AFa1rSDK copydefault;
    private final AFh1tSDK equals;
    private final AFc1eSDK hashCode;
    private final List<AFj1qSDK> registerClient;
    private final AFc1pSDK toString;

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final boolean a_() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    public final /* bridge */ /* synthetic */ AppsFlyerRequestListener areAllFieldsValid() {
        return null;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final boolean copydefault() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFf1wSDK(AFa1pSDK aFa1pSDK, AFc1bSDK aFc1bSDK) {
        super(AFe1mSDK.DLSDK, new AFe1mSDK[]{AFe1mSDK.RC_CDN, AFe1mSDK.FETCH_ADVERTISING_ID}, aFc1bSDK, "DdlSdk");
        AFj1qSDK[] aFj1qSDKArr;
        Intrinsics.checkNotNullParameter(aFa1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1bSDK, "");
        this.areAllFieldsValid = aFa1pSDK;
        this.AFKeystoreWrapper = new CountDownLatch(1);
        this.registerClient = new ArrayList();
        AFc1pSDK currencyIso4217Code = aFc1bSDK.getCurrencyIso4217Code();
        Intrinsics.checkNotNullExpressionValue(currencyIso4217Code, "");
        this.toString = currencyIso4217Code;
        AFc1eSDK afInfoLog = aFc1bSDK.afInfoLog();
        Intrinsics.checkNotNullExpressionValue(afInfoLog, "");
        this.hashCode = afInfoLog;
        AFa1rSDK i = aFc1bSDK.i();
        Intrinsics.checkNotNullExpressionValue(i, "");
        this.copydefault = i;
        AFh1tSDK component3 = aFc1bSDK.component3();
        Intrinsics.checkNotNullExpressionValue(component3, "");
        this.equals = component3;
        AFj1rSDK AFLogger = aFc1bSDK.AFLogger();
        Intrinsics.checkNotNullExpressionValue(AFLogger, "");
        this.copy = AFLogger;
        AFj1qSDK[] aFj1qSDKArr2 = (AFj1qSDK[]) AFLogger.getCurrencyIso4217Code.toArray(new AFj1qSDK[0]);
        Intrinsics.checkNotNullExpressionValue(aFj1qSDKArr2, "");
        ArrayList arrayList = new ArrayList();
        for (AFj1qSDK aFj1qSDK : aFj1qSDKArr2) {
            AFj1qSDK aFj1qSDK2 = aFj1qSDK;
            if ((aFj1qSDK2 == null || aFj1qSDK2.areAllFieldsValid == AFj1qSDK.AFa1vSDK.NOT_STARTED) ? false : true) {
                arrayList.add(aFj1qSDK);
            }
        }
        ArrayList<AFj1qSDK> arrayList2 = arrayList;
        this.AFLogger = arrayList2.size();
        for (final AFj1qSDK aFj1qSDK3 : arrayList2) {
            AFj1qSDK.AFa1vSDK aFa1vSDK = aFj1qSDK3.areAllFieldsValid;
            int i2 = aFa1vSDK == null ? -1 : AFa1ySDK.getMonetizationNetwork[aFa1vSDK.ordinal()];
            if (i2 == 1) {
                AFh1ySDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, aFj1qSDK3.AFAdRevenueData.get("source") + " referrer collected earlier", false, 4, null);
                Intrinsics.checkNotNullExpressionValue(aFj1qSDK3, "");
                getMonetizationNetwork(aFj1qSDK3);
            } else if (i2 == 2) {
                aFj1qSDK3.addObserver(new Observer() { // from class: com.appsflyer.internal.AFf1wSDK$$ExternalSyntheticLambda0
                    @Override // java.util.Observer
                    public final void update(Observable observable, Object obj) {
                        AFf1wSDK.getRevenue(AFj1qSDK.this, this, observable, obj);
                    }
                });
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bf A[Catch: Exception -> 0x0167, TryCatch #1 {Exception -> 0x0167, blocks: (B:4:0x0011, B:8:0x001d, B:10:0x002e, B:13:0x0072, B:17:0x0080, B:19:0x008b, B:21:0x0095, B:22:0x00bf, B:24:0x00d1, B:25:0x00e8, B:27:0x00ec, B:29:0x00f2, B:31:0x00f8, B:33:0x011b, B:35:0x0131, B:37:0x0137, B:39:0x014d, B:34:0x012c, B:41:0x0152, B:11:0x0045, B:12:0x005e), top: B:60:0x0011 }] */
    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.appsflyer.internal.AFe1uSDK getMediationNetwork() {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1wSDK.getMediationNetwork():com.appsflyer.internal.AFe1uSDK");
    }

    private final void getMonetizationNetwork(AFj1qSDK aFj1qSDK) {
        if (AFAdRevenueData(aFj1qSDK)) {
            this.registerClient.add(aFj1qSDK);
            this.AFKeystoreWrapper.countDown();
            AFh1ySDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, "Added non-organic " + aFj1qSDK.getClass().getSimpleName(), false, 4, null);
            return;
        }
        int i = this.AFInAppEventParameterName + 1;
        this.AFInAppEventParameterName = i;
        if (i == this.AFLogger) {
            this.AFKeystoreWrapper.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRevenue(AFj1qSDK aFj1qSDK, AFf1wSDK aFf1wSDK, Observable observable, Object obj) {
        Intrinsics.checkNotNullParameter(aFf1wSDK, "");
        AFh1ySDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, aFj1qSDK.AFAdRevenueData.get("source") + " referrer collected via observer", false, 4, null);
        Intrinsics.checkNotNull(observable, "");
        aFf1wSDK.getMonetizationNetwork((AFj1qSDK) observable);
    }

    private final boolean copy() {
        Object obj = this.areAllFieldsValid.getCurrencyIso4217Code.get("referrers");
        List list = obj instanceof List ? (List) obj : null;
        return (list != null ? list.size() : 0) < this.AFLogger && !this.areAllFieldsValid.getCurrencyIso4217Code.containsKey("referrers");
    }

    private static boolean AFAdRevenueData(AFj1qSDK aFj1qSDK) {
        Object obj = aFj1qSDK.AFAdRevenueData.get("click_ts");
        Long l = obj instanceof Long ? (Long) obj : null;
        if (l != null) {
            if (System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(l.longValue()) < TimeUnit.DAYS.toMillis(1L)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final long getCurrencyIso4217Code() {
        return this.copydefault.component2;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x015f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0115 A[SYNTHETIC] */
    @Override // com.appsflyer.internal.AFe1eSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final com.appsflyer.internal.AFd1jSDK<com.appsflyer.internal.AFa1mSDK> getRevenue(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1wSDK.getRevenue(java.lang.String):com.appsflyer.internal.AFd1jSDK");
    }

    private static Map<String, String> getCurrencyIso4217Code(AFb1mSDK aFb1mSDK) {
        String str;
        if (aFb1mSDK == null || (str = aFb1mSDK.getCurrencyIso4217Code) == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(str, "");
        Boolean bool = aFb1mSDK.getRevenue;
        if (bool == null || !bool.booleanValue()) {
            return MapsKt.mapOf(TuplesKt.to(HelpshiftEvent.DATA_MESSAGE_TYPE, "unhashed"), TuplesKt.to("value", str));
        }
        return null;
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class AFa1ySDK {
        public static final /* synthetic */ int[] AFAdRevenueData;
        public static final /* synthetic */ int[] getMonetizationNetwork;

        static {
            int[] iArr = new int[AFe1uSDK.values().length];
            try {
                iArr[AFe1uSDK.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AFe1uSDK.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            AFAdRevenueData = iArr;
            int[] iArr2 = new int[AFj1qSDK.AFa1vSDK.values().length];
            try {
                iArr2[AFj1qSDK.AFa1vSDK.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[AFj1qSDK.AFa1vSDK.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            getMonetizationNetwork = iArr2;
        }
    }
}
