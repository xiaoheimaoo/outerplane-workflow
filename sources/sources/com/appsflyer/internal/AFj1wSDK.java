package com.appsflyer.internal;

import android.content.Context;
import com.singular.sdk.internal.Constants;
import java.util.concurrent.ExecutorService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFj1wSDK extends AFi1aSDK {
    private final AFj1xSDK component2;
    private final Runnable component3;
    private final AFc1pSDK getMediationNetwork;
    private final ExecutorService getRevenue;
    private String toString;

    @Override // com.appsflyer.internal.AFj1qSDK
    public final void getCurrencyIso4217Code(final Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        if (!getMonetizationNetwork(context)) {
            this.component3.run();
        } else {
            this.getRevenue.execute(new Runnable() { // from class: com.appsflyer.internal.AFj1wSDK$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AFj1wSDK.getCurrencyIso4217Code(AFj1wSDK.this, context);
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ba, code lost:
        if (r0 == null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean getMonetizationNetwork(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1wSDK.getMonetizationNetwork(android.content.Context):boolean");
    }

    private final boolean AFAdRevenueData(Context context) {
        int i = AFa1vSDK.getRevenue[this.component2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return component2(context);
                }
                throw new NoWhenBranchMatchedException();
            }
            return getMediationNetwork(context);
        }
        return getRevenue(context);
    }

    private static boolean getRevenue(Context context) {
        return context.getPackageManager().resolveContentProvider(Constants.FACEBOOK_CONTENT_URI_STRING, 0) != null;
    }

    private static boolean getMediationNetwork(Context context) {
        return context.getPackageManager().resolveContentProvider(Constants.INSTAGRAM_CONTENT_URI_STRING, 0) != null;
    }

    private static boolean component2(Context context) {
        return context.getPackageManager().resolveContentProvider("com.facebook.lite.provider.InstallReferrerProvider", 0) != null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AFj1wSDK(com.appsflyer.internal.AFc1pSDK r3, java.util.concurrent.ExecutorService r4, com.appsflyer.internal.AFj1xSDK r5, java.lang.Runnable r6, java.lang.Runnable r7) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int[] r0 = com.appsflyer.internal.AFj1tSDK.AFa1zSDK.AFAdRevenueData
            int r1 = r5.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L2e
            r1 = 2
            if (r0 == r1) goto L2b
            r1 = 3
            if (r0 != r1) goto L25
            java.lang.String r0 = "facebook_lite"
            goto L30
        L25:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L2b:
            java.lang.String r0 = "instagram"
            goto L30
        L2e:
            java.lang.String r0 = "facebook"
        L30:
            java.lang.String r1 = "app"
            r2.<init>(r1, r0, r3, r6)
            r2.getMediationNetwork = r3
            r2.getRevenue = r4
            r2.component2 = r5
            r2.component3 = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1wSDK.<init>(com.appsflyer.internal.AFc1pSDK, java.util.concurrent.ExecutorService, com.appsflyer.internal.AFj1xSDK, java.lang.Runnable, java.lang.Runnable):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0244, code lost:
        if (r9 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x025b, code lost:
        if (r9 != null) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0115 A[Catch: all -> 0x0267, TRY_LEAVE, TryCatch #2 {all -> 0x0267, blocks: (B:9:0x004c, B:11:0x0052, B:26:0x0115, B:12:0x0078, B:13:0x008d, B:14:0x0092, B:15:0x0093, B:17:0x0099, B:18:0x00be, B:19:0x00d2, B:21:0x00d8, B:22:0x00fd), top: B:101:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02a5 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void getCurrencyIso4217Code(com.appsflyer.internal.AFj1wSDK r30, android.content.Context r31) {
        /*
            Method dump skipped, instructions count: 709
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1wSDK.getCurrencyIso4217Code(com.appsflyer.internal.AFj1wSDK, android.content.Context):void");
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class AFa1vSDK {
        public static final /* synthetic */ int[] getRevenue;

        static {
            int[] iArr = new int[AFj1xSDK.values().length];
            try {
                iArr[AFj1xSDK.FACEBOOK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AFj1xSDK.INSTAGRAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AFj1xSDK.FACEBOOK_LITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            getRevenue = iArr;
        }
    }
}
