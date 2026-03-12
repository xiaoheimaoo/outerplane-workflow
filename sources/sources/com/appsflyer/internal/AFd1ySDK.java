package com.appsflyer.internal;

import android.os.Build;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFd1xSDK;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.common.net.HttpHeaders;
import com.helpshift.util.ConfigValues;
import com.singular.sdk.internal.Constants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFd1ySDK implements AFd1xSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long copy = -1417917781629150226L;
    private static int copydefault = 1;
    private static int equals;
    private final Lazy AFAdRevenueData;
    private final Lazy areAllFieldsValid;
    private final String component1;
    private final Lazy component2;
    private final Lazy component3;
    private AFd1xSDK.AFa1ySDK component4;
    private final Lazy getCurrencyIso4217Code;
    private final Lazy getMediationNetwork;
    private final Lazy getMonetizationNetwork;
    private AFc1bSDK getRevenue;

    public static /* synthetic */ Object getRevenue(Object[] objArr, int i, int i2, int i3) {
        int i4 = (i * (-464)) + (i2 * (-929));
        int i5 = ~i;
        int i6 = i2 | i3;
        int i7 = i4 + (((~i6) | i5) * (-465)) + ((i2 | (~(i3 | i5))) * 930) + ((i5 | i6) * 465);
        if (i7 == 1) {
            final AFd1ySDK aFd1ySDK = (AFd1ySDK) objArr[0];
            int i8 = equals + 57;
            copydefault = i8 % 128;
            int i9 = i8 % 2;
            aFd1ySDK.component4 = (AFd1xSDK.AFa1ySDK) objArr[1];
            ((ExecutorService) getRevenue(new Object[]{aFd1ySDK}, -1221964614, 1221964616, System.identityHashCode(aFd1ySDK))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1ySDK$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AFd1ySDK.getMediationNetwork(AFd1ySDK.this);
                }
            });
            int i10 = equals + 61;
            copydefault = i10 % 128;
            int i11 = i10 % 2;
            return null;
        } else if (i7 != 2) {
            if (i7 != 3) {
                if (i7 == 4) {
                    return getCurrencyIso4217Code(objArr);
                }
                int i12 = copydefault + 47;
                equals = i12 % 128;
                int i13 = i12 % 2;
                Map mapOf = MapsKt.mapOf(TuplesKt.to("deviceInfo", (Map) objArr[0]), TuplesKt.to("excs", AFd1tSDK.AFAdRevenueData((List) objArr[1])));
                int i14 = equals + 11;
                copydefault = i14 % 128;
                int i15 = i14 % 2;
                return mapOf;
            }
            return AFAdRevenueData(objArr);
        } else {
            return getMediationNetwork(objArr);
        }
    }

    public AFd1ySDK(AFc1bSDK aFc1bSDK) {
        Intrinsics.checkNotNullParameter(aFc1bSDK, "");
        this.getRevenue = aFc1bSDK;
        this.getCurrencyIso4217Code = LazyKt.lazy(new Function0<AFf1lSDK>() { // from class: com.appsflyer.internal.AFd1ySDK.1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: getCurrencyIso4217Code */
            public final AFf1lSDK invoke() {
                AFf1lSDK component1 = AFd1ySDK.getMonetizationNetwork(AFd1ySDK.this).component1();
                Intrinsics.checkNotNullExpressionValue(component1, "");
                return component1;
            }

            {
                super(0);
            }
        });
        this.getMediationNetwork = LazyKt.lazy(new Function0<AFc1pSDK>() { // from class: com.appsflyer.internal.AFd1ySDK.5
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: getMonetizationNetwork */
            public final AFc1pSDK invoke() {
                AFc1pSDK currencyIso4217Code = AFd1ySDK.getMonetizationNetwork(AFd1ySDK.this).getCurrencyIso4217Code();
                Intrinsics.checkNotNullExpressionValue(currencyIso4217Code, "");
                return currencyIso4217Code;
            }

            {
                super(0);
            }
        });
        this.getMonetizationNetwork = LazyKt.lazy(new Function0<AFc1oSDK>() { // from class: com.appsflyer.internal.AFd1ySDK.3
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: getMonetizationNetwork */
            public final AFc1oSDK invoke() {
                AFc1oSDK component2 = AFd1ySDK.getMonetizationNetwork(AFd1ySDK.this).component2();
                Intrinsics.checkNotNullExpressionValue(component2, "");
                return component2;
            }

            {
                super(0);
            }
        });
        this.AFAdRevenueData = LazyKt.lazy(new Function0<AFf1cSDK>() { // from class: com.appsflyer.internal.AFd1ySDK.9
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: AFAdRevenueData */
            public final AFf1cSDK invoke() {
                AFf1cSDK AFKeystoreWrapper = AFd1ySDK.getMonetizationNetwork(AFd1ySDK.this).AFKeystoreWrapper();
                Intrinsics.checkNotNullExpressionValue(AFKeystoreWrapper, "");
                return AFKeystoreWrapper;
            }

            {
                super(0);
            }
        });
        this.component2 = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.appsflyer.internal.AFd1ySDK.2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: getCurrencyIso4217Code */
            public final ExecutorService invoke() {
                ExecutorService mediationNetwork = AFd1ySDK.getMonetizationNetwork(AFd1ySDK.this).getMediationNetwork();
                Intrinsics.checkNotNullExpressionValue(mediationNetwork, "");
                return mediationNetwork;
            }

            {
                super(0);
            }
        });
        this.component1 = "6.17.3";
        this.areAllFieldsValid = LazyKt.lazy(new Function0<AFd1uSDK>() { // from class: com.appsflyer.internal.AFd1ySDK.4
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: getMediationNetwork */
            public final AFd1uSDK invoke() {
                AFc1gSDK registerClient = AFd1ySDK.getMonetizationNetwork(AFd1ySDK.this).registerClient();
                Intrinsics.checkNotNullExpressionValue(registerClient, "");
                return new AFd1uSDK(registerClient);
            }

            {
                super(0);
            }
        });
        this.component3 = LazyKt.lazy(new Function0<AFd1vSDK>() { // from class: com.appsflyer.internal.AFd1ySDK.6
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: AFAdRevenueData */
            public final AFd1vSDK invoke() {
                return new AFd1vSDK(AFd1ySDK.this.AFAdRevenueData());
            }

            {
                super(0);
            }
        });
    }

    public static final /* synthetic */ AFc1bSDK getMonetizationNetwork(AFd1ySDK aFd1ySDK) {
        int i = copydefault;
        int i2 = i + 19;
        equals = i2 % 128;
        int i3 = i2 % 2;
        AFc1bSDK aFc1bSDK = aFd1ySDK.getRevenue;
        int i4 = i + 97;
        equals = i4 % 128;
        int i5 = i4 % 2;
        return aFc1bSDK;
    }

    private final AFf1lSDK getMediationNetwork() {
        AFf1lSDK aFf1lSDK;
        int i = copydefault + 121;
        equals = i % 128;
        if ((i % 2 != 0 ? 'J' : (char) 26) != 26) {
            aFf1lSDK = (AFf1lSDK) this.getCurrencyIso4217Code.getValue();
            int i2 = 71 / 0;
        } else {
            aFf1lSDK = (AFf1lSDK) this.getCurrencyIso4217Code.getValue();
        }
        int i3 = copydefault + 31;
        equals = i3 % 128;
        int i4 = i3 % 2;
        return aFf1lSDK;
    }

    private final AFc1pSDK getMonetizationNetwork() {
        AFc1pSDK aFc1pSDK;
        int i = copydefault + 49;
        equals = i % 128;
        if ((i % 2 != 0 ? 'A' : (char) 28) != 28) {
            aFc1pSDK = (AFc1pSDK) this.getMediationNetwork.getValue();
            int i2 = 51 / 0;
        } else {
            aFc1pSDK = (AFc1pSDK) this.getMediationNetwork.getValue();
        }
        int i3 = equals + 63;
        copydefault = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return aFc1pSDK;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private final AFc1oSDK component3() {
        int i = copydefault + 97;
        equals = i % 128;
        int i2 = i % 2;
        AFc1oSDK aFc1oSDK = (AFc1oSDK) this.getMonetizationNetwork.getValue();
        int i3 = equals + 29;
        copydefault = i3 % 128;
        int i4 = i3 % 2;
        return aFc1oSDK;
    }

    private final AFf1cSDK component1() {
        int i = copydefault + 17;
        equals = i % 128;
        int i2 = i % 2;
        AFf1cSDK aFf1cSDK = (AFf1cSDK) this.AFAdRevenueData.getValue();
        int i3 = copydefault + 113;
        equals = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return aFf1cSDK;
        }
        throw null;
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        int i = copydefault + 39;
        equals = i % 128;
        int i2 = i % 2;
        ExecutorService executorService = (ExecutorService) ((AFd1ySDK) objArr[0]).component2.getValue();
        int i3 = copydefault + 45;
        equals = i3 % 128;
        if (i3 % 2 == 0) {
            return executorService;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private final AFh1aSDK areAllFieldsValid() {
        int i = copydefault + 53;
        equals = i % 128;
        if (!(i % 2 == 0)) {
            AFi1wSDK aFi1wSDK = getMediationNetwork().AFAdRevenueData.AFAdRevenueData;
            throw null;
        }
        AFi1wSDK aFi1wSDK2 = getMediationNetwork().AFAdRevenueData.AFAdRevenueData;
        if (aFi1wSDK2 != null) {
            AFi1zSDK aFi1zSDK = aFi1wSDK2.getMonetizationNetwork;
            if ((aFi1zSDK != null ? '/' : '>') != '>') {
                int i2 = copydefault + 37;
                equals = i2 % 128;
                int i3 = i2 % 2;
                return aFi1zSDK.getCurrencyIso4217Code;
            }
        }
        int i4 = copydefault + 79;
        equals = i4 % 128;
        if (i4 % 2 == 0) {
            return null;
        }
        throw null;
    }

    public final AFd1zSDK AFAdRevenueData() {
        int i = copydefault + 119;
        equals = i % 128;
        int i2 = i % 2;
        AFd1zSDK aFd1zSDK = (AFd1zSDK) this.areAllFieldsValid.getValue();
        int i3 = equals + 95;
        copydefault = i3 % 128;
        if ((i3 % 2 == 0 ? 'S' : 'H') == 'H') {
            return aFd1zSDK;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private AFd1wSDK component2() {
        int i = equals + 29;
        copydefault = i % 128;
        if ((i % 2 == 0 ? (char) 25 : '_') == '_') {
            return (AFd1wSDK) this.component3.getValue();
        }
        AFd1wSDK aFd1wSDK = (AFd1wSDK) this.component3.getValue();
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMediationNetwork(AFd1ySDK aFd1ySDK, Throwable th, String str) {
        int i = equals + 67;
        copydefault = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(aFd1ySDK, "");
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        AFh1aSDK areAllFieldsValid = aFd1ySDK.areAllFieldsValid();
        if ((areAllFieldsValid != null ? 'B' : '8') == 'B' && aFd1ySDK.getMonetizationNetwork(areAllFieldsValid) ? false : true) {
            return;
        }
        int i3 = equals + 33;
        copydefault = i3 % 128;
        int i4 = i3 % 2;
        aFd1ySDK.AFAdRevenueData().getRevenue(th, str);
    }

    private static /* synthetic */ Object AFAdRevenueData(Object[] objArr) {
        final AFd1ySDK aFd1ySDK = (AFd1ySDK) objArr[0];
        final Throwable th = (Throwable) objArr[1];
        final String str = (String) objArr[2];
        int i = equals + 121;
        copydefault = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? (char) 31 : ')') == ')') {
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str, "");
            ((ExecutorService) getRevenue(new Object[]{aFd1ySDK}, -1221964614, 1221964616, System.identityHashCode(aFd1ySDK))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1ySDK$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AFd1ySDK.getMediationNetwork(AFd1ySDK.this, th, str);
                }
            });
            return null;
        }
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        ((ExecutorService) getRevenue(new Object[]{aFd1ySDK}, -1221964614, 1221964616, System.identityHashCode(aFd1ySDK))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1ySDK$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AFd1ySDK.getMediationNetwork(AFd1ySDK.this, th, str);
            }
        });
        obj.hashCode();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMediationNetwork(AFd1ySDK aFd1ySDK) {
        int i = copydefault + 121;
        equals = i % 128;
        if ((i % 2 != 0 ? 'Y' : ',') != 'Y') {
            Intrinsics.checkNotNullParameter(aFd1ySDK, "");
            aFd1ySDK.equals();
            return;
        }
        Intrinsics.checkNotNullParameter(aFd1ySDK, "");
        aFd1ySDK.equals();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r11 = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r11, int r12, java.lang.Object[] r13) {
        /*
            if (r11 == 0) goto L10
            int r0 = com.appsflyer.internal.AFd1ySDK.$10
            int r0 = r0 + 37
            int r1 = r0 % 128
            com.appsflyer.internal.AFd1ySDK.$11 = r1
            int r0 = r0 % 2
            char[] r11 = r11.toCharArray()
        L10:
            char[] r11 = (char[]) r11
            com.appsflyer.internal.AFk1lSDK r0 = new com.appsflyer.internal.AFk1lSDK
            r0.<init>()
            r0.getMonetizationNetwork = r12
            int r12 = r11.length
            long[] r1 = new long[r12]
            r2 = 0
            r0.getRevenue = r2
        L1f:
            int r3 = r0.getRevenue
            int r4 = r11.length
            r5 = 58
            if (r3 >= r4) goto L29
            r3 = 68
            goto L2a
        L29:
            r3 = r5
        L2a:
            r4 = 1
            if (r3 == r5) goto L57
            int r3 = com.appsflyer.internal.AFd1ySDK.$10
            int r3 = r3 + 29
            int r5 = r3 % 128
            com.appsflyer.internal.AFd1ySDK.$11 = r5
            int r3 = r3 % 2
            int r3 = r0.getRevenue
            int r5 = r0.getRevenue
            char r5 = r11[r5]
            long r5 = (long) r5
            int r7 = r0.getRevenue
            long r7 = (long) r7
            int r9 = r0.getMonetizationNetwork
            long r9 = (long) r9
            long r7 = r7 * r9
            long r5 = r5 ^ r7
            long r7 = com.appsflyer.internal.AFd1ySDK.copy
            r9 = -2523060390901184290(0xdcfc49f1357a08de, double:-8.421958473976257E139)
            long r7 = r7 ^ r9
            long r5 = r5 ^ r7
            r1[r3] = r5
            int r3 = r0.getRevenue
            int r3 = r3 + r4
            r0.getRevenue = r3
            goto L1f
        L57:
            char[] r12 = new char[r12]
            r0.getRevenue = r2
        L5b:
            int r3 = r0.getRevenue
            int r5 = r11.length
            r6 = 63
            if (r3 >= r5) goto L65
            r3 = 9
            goto L66
        L65:
            r3 = r6
        L66:
            if (r3 == r6) goto L82
            int r3 = com.appsflyer.internal.AFd1ySDK.$10
            int r3 = r3 + 77
            int r5 = r3 % 128
            com.appsflyer.internal.AFd1ySDK.$11 = r5
            int r3 = r3 % 2
            int r3 = r0.getRevenue
            int r5 = r0.getRevenue
            r5 = r1[r5]
            int r5 = (int) r5
            char r5 = (char) r5
            r12[r3] = r5
            int r3 = r0.getRevenue
            int r3 = r3 + r4
            r0.getRevenue = r3
            goto L5b
        L82:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r12)
            int r12 = com.appsflyer.internal.AFd1ySDK.$11
            int r12 = r12 + 87
            int r0 = r12 % 128
            com.appsflyer.internal.AFd1ySDK.$10 = r0
            int r12 = r12 % 2
            if (r12 == 0) goto L94
            goto L95
        L94:
            r4 = r2
        L95:
            if (r4 != 0) goto L9a
            r13[r2] = r11
            return
        L9a:
            r11 = 0
            throw r11     // Catch: java.lang.Throwable -> L9c
        L9c:
            r11 = move-exception
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1ySDK.a(java.lang.String, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCurrencyIso4217Code(AFd1ySDK aFd1ySDK) {
        int i = copydefault + 119;
        equals = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(aFd1ySDK, "");
        aFd1ySDK.copy();
        int i3 = copydefault + 11;
        equals = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // com.appsflyer.internal.AFd1xSDK
    public final void getCurrencyIso4217Code() {
        int i = copydefault + 51;
        equals = i % 128;
        if ((i % 2 != 0 ? (char) 19 : (char) 21) != 19) {
            ((ExecutorService) getRevenue(new Object[]{this}, -1221964614, 1221964616, System.identityHashCode(this))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1ySDK$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AFd1ySDK.getCurrencyIso4217Code(AFd1ySDK.this);
                }
            });
            int i2 = copydefault + 113;
            equals = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        ((ExecutorService) getRevenue(new Object[]{this}, -1221964614, 1221964616, System.identityHashCode(this))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1ySDK$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AFd1ySDK.getCurrencyIso4217Code(AFd1ySDK.this);
            }
        });
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRevenue(AFd1ySDK aFd1ySDK) {
        int i = equals + 85;
        copydefault = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(aFd1ySDK, "");
            aFd1ySDK.copydefault();
            return;
        }
        Intrinsics.checkNotNullParameter(aFd1ySDK, "");
        aFd1ySDK.copydefault();
        throw null;
    }

    @Override // com.appsflyer.internal.AFd1xSDK
    public final void getRevenue() {
        int i = equals + 41;
        copydefault = i % 128;
        if ((i % 2 == 0 ? '4' : (char) 16) != 16) {
            ((ExecutorService) getRevenue(new Object[]{this}, -1221964614, 1221964616, System.identityHashCode(this))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1ySDK$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AFd1ySDK.getRevenue(AFd1ySDK.this);
                }
            });
            int i2 = 23 / 0;
        } else {
            ((ExecutorService) getRevenue(new Object[]{this}, -1221964614, 1221964616, System.identityHashCode(this))).execute(new Runnable() { // from class: com.appsflyer.internal.AFd1ySDK$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AFd1ySDK.getRevenue(AFd1ySDK.this);
                }
            });
        }
        int i3 = copydefault + 121;
        equals = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void copy() {
        String mediationNetwork;
        int i = equals + 101;
        copydefault = i % 128;
        if ((i % 2 == 0 ? (char) 15 : 'G') != 'G') {
            areAllFieldsValid();
            throw null;
        }
        AFh1aSDK areAllFieldsValid = areAllFieldsValid();
        if ((areAllFieldsValid != null ? '4' : 'M') != 'M') {
            if (!AFAdRevenueData(areAllFieldsValid)) {
                AFh1ySDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "skipping", false, 4, null);
                return;
            }
            int i2 = equals + 23;
            copydefault = i2 % 128;
            if (i2 % 2 == 0) {
                mediationNetwork = component1().getMediationNetwork();
                int i3 = 66 / 0;
                if (mediationNetwork == null) {
                    return;
                }
            } else {
                mediationNetwork = component1().getMediationNetwork();
                if (mediationNetwork == null) {
                    return;
                }
            }
            String jSONObject = new JSONObject((Map) getRevenue(new Object[]{getCurrencyIso4217Code(areAllFieldsValid), AFAdRevenueData().getMediationNetwork()}, -1519321264, 1519321264, (int) System.currentTimeMillis())).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "");
            Intrinsics.checkNotNullExpressionValue(mediationNetwork, "");
            getRevenue(new Object[]{this, jSONObject, mediationNetwork}, -1047452469, 1047452473, System.identityHashCode(this));
        }
    }

    private final synchronized void copydefault() {
        boolean z;
        AFh1aSDK areAllFieldsValid = areAllFieldsValid();
        if (areAllFieldsValid != null) {
            if (areAllFieldsValid.getRevenue != -1) {
                if ((component3().getCurrencyIso4217Code("af_send_exc_to_server_window", -1L) == -1 ? Typography.greater : 'D') != 'D') {
                    getMediationNetwork(areAllFieldsValid);
                }
            } else {
                int i = copydefault + 109;
                equals = i % 128;
                int i2 = i % 2;
                component3().getCurrencyIso4217Code("af_send_exc_to_server_window");
            }
            z = getMonetizationNetwork(areAllFieldsValid);
        } else {
            z = false;
        }
        AFd1xSDK.AFa1ySDK aFa1ySDK = this.component4;
        if ((aFa1ySDK != null ? 'N' : '\\') != '\\') {
            int i3 = equals + 67;
            copydefault = i3 % 128;
            if ((i3 % 2 == 0 ? 'O' : (char) 31) != 'O') {
                aFa1ySDK.onConfigurationChanged(z);
            } else {
                aFa1ySDK.onConfigurationChanged(z);
                throw null;
            }
        }
    }

    private final void getMediationNetwork(AFh1aSDK aFh1aSDK) {
        int i;
        long currentTimeMillis;
        int i2 = equals + 93;
        copydefault = i2 % 128;
        if (!(i2 % 2 == 0)) {
            i = aFh1aSDK.getCurrencyIso4217Code;
            currentTimeMillis = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(aFh1aSDK.getRevenue);
        } else {
            i = aFh1aSDK.getCurrencyIso4217Code;
            currentTimeMillis = System.currentTimeMillis() ^ TimeUnit.DAYS.toMillis(aFh1aSDK.getRevenue);
        }
        AFc1oSDK component3 = component3();
        component3.getRevenue("af_send_exc_to_server_window", currentTimeMillis);
        component3.getRevenue("af_send_exc_min", i);
    }

    private final Map<String, String> getCurrencyIso4217Code(AFh1aSDK aFh1aSDK) {
        Object[] objArr = new Object[1];
        a("퍒䪹\ue0a7ắ뒸", (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 39419, objArr);
        Map<String, String> mapOf = MapsKt.mapOf(TuplesKt.to(((String) objArr[0]).intern(), Build.BRAND), TuplesKt.to("model", Build.MODEL), TuplesKt.to("app_id", getMonetizationNetwork().getRevenue.getRevenue.getPackageName()), TuplesKt.to("p_ex", new AFa1ySDK().getMediationNetwork()), TuplesKt.to(ConfigValues.SOURCE_API, String.valueOf(Build.VERSION.SDK_INT)), TuplesKt.to(Constants.RequestParamsKeys.SDK_VERSION_KEY, this.component1), TuplesKt.to("uid", AFb1jSDK.getRevenue(getMonetizationNetwork().getMonetizationNetwork)), TuplesKt.to("exc_config", aFh1aSDK.getMonetizationNetwork()));
        int i = equals + 109;
        copydefault = i % 128;
        int i2 = i % 2;
        return mapOf;
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        String str = (String) objArr[1];
        int i = copydefault + 41;
        equals = i % 128;
        int i2 = i % 2;
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        ((AFd1ySDK) objArr[0]).component2().getRevenue(bytes, MapsKt.mapOf(TuplesKt.to(HttpHeaders.AUTHORIZATION, AFj1bSDK.getRevenue(str, (String) objArr[2]))), CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
        int i3 = copydefault + 37;
        equals = i3 % 128;
        if ((i3 % 2 != 0 ? '/' : 'c') != '/') {
            return null;
        }
        throw null;
    }

    private final boolean AFAdRevenueData(AFh1aSDK aFh1aSDK) {
        long currentTimeMillis = System.currentTimeMillis();
        long currencyIso4217Code = component3().getCurrencyIso4217Code("af_send_exc_to_server_window", -1L);
        if ((aFh1aSDK.getMediationNetwork < TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis) ? (char) 23 : 'Q') != 23 && currencyIso4217Code != -1) {
            int i = copydefault + 51;
            equals = i % 128;
            if (i % 2 != 0) {
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            if (!(currencyIso4217Code < currentTimeMillis)) {
                int mediationNetwork = component3().getMediationNetwork("af_send_exc_min", -1);
                if (mediationNetwork != -1) {
                    if (!(AFAdRevenueData().AFAdRevenueData() < mediationNetwork)) {
                        return getRevenue(aFh1aSDK);
                    }
                }
                int i2 = copydefault + 103;
                equals = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    int i3 = 15 / 0;
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    private final boolean getMonetizationNetwork(AFh1aSDK aFh1aSDK) {
        int i = copydefault + 105;
        equals = i % 128;
        Object obj = null;
        if (i % 2 == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long currencyIso4217Code = component3().getCurrencyIso4217Code("af_send_exc_to_server_window", -1L);
            if (aFh1aSDK.getMediationNetwork >= TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis)) {
                if ((currencyIso4217Code != -1 ? 'L' : '#') != '#') {
                    if (!(currencyIso4217Code < currentTimeMillis)) {
                        return getRevenue(aFh1aSDK);
                    }
                }
                return false;
            }
            int i2 = equals + 123;
            copydefault = i2 % 128;
            if (i2 % 2 != 0) {
                return false;
            }
            obj.hashCode();
            throw null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        component3().getCurrencyIso4217Code("af_send_exc_to_server_window", -1L);
        long j = aFh1aSDK.getMediationNetwork;
        TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis2);
        obj.hashCode();
        throw null;
    }

    private final boolean getRevenue(AFh1aSDK aFh1aSDK) {
        new AFd1sSDK();
        String str = this.component1;
        String str2 = aFh1aSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        boolean currencyIso4217Code = AFd1sSDK.getCurrencyIso4217Code(str, str2);
        int i = equals + 23;
        copydefault = i % 128;
        if (i % 2 != 0) {
            return currencyIso4217Code;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0192, code lost:
        if ((r0.intValue() == -1) != true) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00af, code lost:
        if (r5 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c1, code lost:
        if (r5 != null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ca, code lost:
        if (r5 != null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00cc, code lost:
        r5 = kotlin.text.StringsKt.toIntOrNull(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d0, code lost:
        if (r5 == null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d2, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d4, code lost:
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d5, code lost:
        if (r8 == true) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d8, code lost:
        r5 = r5.intValue();
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0171 A[Catch: all -> 0x0222, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:9:0x0015, B:11:0x001b, B:13:0x0020, B:15:0x002e, B:18:0x004f, B:20:0x0055, B:25:0x0060, B:93:0x0147, B:98:0x0152, B:100:0x0156, B:102:0x015c, B:104:0x0162, B:106:0x0166, B:108:0x0171, B:114:0x017b, B:120:0x0189, B:132:0x01ac, B:137:0x0207, B:139:0x020b, B:141:0x0211, B:142:0x0215, B:134:0x01ca, B:135:0x01e6, B:130:0x019c, B:32:0x0079, B:34:0x007d, B:36:0x0091, B:38:0x009c, B:43:0x00b1, B:45:0x00bb, B:54:0x00cc, B:60:0x00d8, B:62:0x00de, B:77:0x0115, B:79:0x0123, B:81:0x0129, B:87:0x0138, B:89:0x013e, B:91:0x0141, B:68:0x00f5, B:70:0x00fb, B:75:0x0106, B:52:0x00c6, B:41:0x00a7, B:136:0x01f7, B:147:0x021c, B:148:0x021f, B:47:0x00c0, B:110:0x0177), top: B:154:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x017b A[Catch: all -> 0x0222, TryCatch #2 {, blocks: (B:3:0x0001, B:9:0x0015, B:11:0x001b, B:13:0x0020, B:15:0x002e, B:18:0x004f, B:20:0x0055, B:25:0x0060, B:93:0x0147, B:98:0x0152, B:100:0x0156, B:102:0x015c, B:104:0x0162, B:106:0x0166, B:108:0x0171, B:114:0x017b, B:120:0x0189, B:132:0x01ac, B:137:0x0207, B:139:0x020b, B:141:0x0211, B:142:0x0215, B:134:0x01ca, B:135:0x01e6, B:130:0x019c, B:32:0x0079, B:34:0x007d, B:36:0x0091, B:38:0x009c, B:43:0x00b1, B:45:0x00bb, B:54:0x00cc, B:60:0x00d8, B:62:0x00de, B:77:0x0115, B:79:0x0123, B:81:0x0129, B:87:0x0138, B:89:0x013e, B:91:0x0141, B:68:0x00f5, B:70:0x00fb, B:75:0x0106, B:52:0x00c6, B:41:0x00a7, B:136:0x01f7, B:147:0x021c, B:148:0x021f, B:47:0x00c0, B:110:0x0177), top: B:154:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0189 A[Catch: all -> 0x0222, TryCatch #2 {, blocks: (B:3:0x0001, B:9:0x0015, B:11:0x001b, B:13:0x0020, B:15:0x002e, B:18:0x004f, B:20:0x0055, B:25:0x0060, B:93:0x0147, B:98:0x0152, B:100:0x0156, B:102:0x015c, B:104:0x0162, B:106:0x0166, B:108:0x0171, B:114:0x017b, B:120:0x0189, B:132:0x01ac, B:137:0x0207, B:139:0x020b, B:141:0x0211, B:142:0x0215, B:134:0x01ca, B:135:0x01e6, B:130:0x019c, B:32:0x0079, B:34:0x007d, B:36:0x0091, B:38:0x009c, B:43:0x00b1, B:45:0x00bb, B:54:0x00cc, B:60:0x00d8, B:62:0x00de, B:77:0x0115, B:79:0x0123, B:81:0x0129, B:87:0x0138, B:89:0x013e, B:91:0x0141, B:68:0x00f5, B:70:0x00fb, B:75:0x0106, B:52:0x00c6, B:41:0x00a7, B:136:0x01f7, B:147:0x021c, B:148:0x021f, B:47:0x00c0, B:110:0x0177), top: B:154:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019c A[Catch: all -> 0x0222, TryCatch #2 {, blocks: (B:3:0x0001, B:9:0x0015, B:11:0x001b, B:13:0x0020, B:15:0x002e, B:18:0x004f, B:20:0x0055, B:25:0x0060, B:93:0x0147, B:98:0x0152, B:100:0x0156, B:102:0x015c, B:104:0x0162, B:106:0x0166, B:108:0x0171, B:114:0x017b, B:120:0x0189, B:132:0x01ac, B:137:0x0207, B:139:0x020b, B:141:0x0211, B:142:0x0215, B:134:0x01ca, B:135:0x01e6, B:130:0x019c, B:32:0x0079, B:34:0x007d, B:36:0x0091, B:38:0x009c, B:43:0x00b1, B:45:0x00bb, B:54:0x00cc, B:60:0x00d8, B:62:0x00de, B:77:0x0115, B:79:0x0123, B:81:0x0129, B:87:0x0138, B:89:0x013e, B:91:0x0141, B:68:0x00f5, B:70:0x00fb, B:75:0x0106, B:52:0x00c6, B:41:0x00a7, B:136:0x01f7, B:147:0x021c, B:148:0x021f, B:47:0x00c0, B:110:0x0177), top: B:154:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ac A[Catch: all -> 0x0222, TryCatch #2 {, blocks: (B:3:0x0001, B:9:0x0015, B:11:0x001b, B:13:0x0020, B:15:0x002e, B:18:0x004f, B:20:0x0055, B:25:0x0060, B:93:0x0147, B:98:0x0152, B:100:0x0156, B:102:0x015c, B:104:0x0162, B:106:0x0166, B:108:0x0171, B:114:0x017b, B:120:0x0189, B:132:0x01ac, B:137:0x0207, B:139:0x020b, B:141:0x0211, B:142:0x0215, B:134:0x01ca, B:135:0x01e6, B:130:0x019c, B:32:0x0079, B:34:0x007d, B:36:0x0091, B:38:0x009c, B:43:0x00b1, B:45:0x00bb, B:54:0x00cc, B:60:0x00d8, B:62:0x00de, B:77:0x0115, B:79:0x0123, B:81:0x0129, B:87:0x0138, B:89:0x013e, B:91:0x0141, B:68:0x00f5, B:70:0x00fb, B:75:0x0106, B:52:0x00c6, B:41:0x00a7, B:136:0x01f7, B:147:0x021c, B:148:0x021f, B:47:0x00c0, B:110:0x0177), top: B:154:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0138 A[Catch: all -> 0x0222, TryCatch #2 {, blocks: (B:3:0x0001, B:9:0x0015, B:11:0x001b, B:13:0x0020, B:15:0x002e, B:18:0x004f, B:20:0x0055, B:25:0x0060, B:93:0x0147, B:98:0x0152, B:100:0x0156, B:102:0x015c, B:104:0x0162, B:106:0x0166, B:108:0x0171, B:114:0x017b, B:120:0x0189, B:132:0x01ac, B:137:0x0207, B:139:0x020b, B:141:0x0211, B:142:0x0215, B:134:0x01ca, B:135:0x01e6, B:130:0x019c, B:32:0x0079, B:34:0x007d, B:36:0x0091, B:38:0x009c, B:43:0x00b1, B:45:0x00bb, B:54:0x00cc, B:60:0x00d8, B:62:0x00de, B:77:0x0115, B:79:0x0123, B:81:0x0129, B:87:0x0138, B:89:0x013e, B:91:0x0141, B:68:0x00f5, B:70:0x00fb, B:75:0x0106, B:52:0x00c6, B:41:0x00a7, B:136:0x01f7, B:147:0x021c, B:148:0x021f, B:47:0x00c0, B:110:0x0177), top: B:154:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final synchronized void equals() {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1ySDK.equals():void");
    }

    private final void AFAdRevenueData(String str, String str2) {
        getRevenue(new Object[]{this, str, str2}, -1047452469, 1047452473, System.identityHashCode(this));
    }

    private static Map<String, Object> getRevenue(Map<String, ? extends Object> map, List<AFc1cSDK> list) {
        return (Map) getRevenue(new Object[]{map, list}, -1519321264, 1519321264, (int) System.currentTimeMillis());
    }

    @Override // com.appsflyer.internal.AFd1xSDK
    public final void getMediationNetwork(AFd1xSDK.AFa1ySDK aFa1ySDK) {
        getRevenue(new Object[]{this, aFa1ySDK}, -704073125, 704073126, System.identityHashCode(this));
    }

    @Override // com.appsflyer.internal.AFd1xSDK
    public final void getRevenue(Throwable th, String str) {
        getRevenue(new Object[]{this, th, str}, 1146782962, -1146782959, System.identityHashCode(this));
    }

    private final ExecutorService component4() {
        return (ExecutorService) getRevenue(new Object[]{this}, -1221964614, 1221964616, System.identityHashCode(this));
    }
}
