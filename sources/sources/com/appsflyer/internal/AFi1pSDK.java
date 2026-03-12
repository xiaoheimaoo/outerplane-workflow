package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H%¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00128\u0005@\u0004X\u0085\f¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015"}, d2 = {"Lcom/appsflyer/internal/AFi1pSDK;", "", "Landroid/content/Context;", "p0", "<init>", "(Landroid/content/Context;)V", "", "getCurrencyIso4217Code", "()Ljava/lang/String;", "Lcom/appsflyer/internal/AFi1tSDK;", "AFAdRevenueData", "()Lcom/appsflyer/internal/AFi1tSDK;", "Landroid/net/NetworkInfo;", "", "v_", "(Landroid/net/NetworkInfo;)Z", "getRevenue", "()Z", "Landroid/net/ConnectivityManager;", "Landroid/net/ConnectivityManager;", "Landroid/telephony/TelephonyManager;", "Landroid/telephony/TelephonyManager;", "AFa1ySDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AFi1pSDK {
    public static final AFa1ySDK AFa1ySDK = new AFa1ySDK(null);
    ConnectivityManager AFAdRevenueData;
    private final TelephonyManager getCurrencyIso4217Code;

    protected abstract String getCurrencyIso4217Code();

    public abstract boolean getRevenue();

    public AFi1pSDK(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        Object systemService = context.getSystemService("connectivity");
        this.AFAdRevenueData = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        Object systemService2 = context.getSystemService("phone");
        this.getCurrencyIso4217Code = systemService2 instanceof TelephonyManager ? (TelephonyManager) systemService2 : null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean v_(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            return networkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001e A[Catch: all -> 0x0028, TryCatch #1 {all -> 0x0028, blocks: (B:6:0x0009, B:8:0x0012, B:14:0x001e), top: B:28:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.appsflyer.internal.AFi1tSDK AFAdRevenueData() {
        /*
            r6 = this;
            r0 = 0
            android.telephony.TelephonyManager r1 = r6.getCurrencyIso4217Code     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L2e
            java.lang.String r2 = r1.getSimOperatorName()     // Catch: java.lang.Throwable -> L30
            java.lang.String r0 = r1.getNetworkOperatorName()     // Catch: java.lang.Throwable -> L28
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L1b
            int r3 = r3.length()     // Catch: java.lang.Throwable -> L28
            if (r3 != 0) goto L19
            goto L1b
        L19:
            r3 = 0
            goto L1c
        L1b:
            r3 = 1
        L1c:
            if (r3 == 0) goto L3a
            int r1 = r1.getPhoneType()     // Catch: java.lang.Throwable -> L28
            r3 = 2
            if (r1 != r3) goto L3a
            java.lang.String r0 = "CDMA"
            goto L3a
        L28:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r2
            r2 = r5
            goto L33
        L2e:
            r2 = r0
            goto L3a
        L30:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L33:
            java.lang.String r3 = "Exception while collecting network info. "
            com.appsflyer.AFLogger.afErrorLog(r3, r2)
            r2 = r0
            r0 = r1
        L3a:
            com.appsflyer.internal.AFi1tSDK r1 = new com.appsflyer.internal.AFi1tSDK
            java.lang.String r3 = r6.getCurrencyIso4217Code()
            boolean r4 = r6.getRevenue()
            r1.<init>(r3, r0, r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFi1pSDK.AFAdRevenueData():com.appsflyer.internal.AFi1tSDK");
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/appsflyer/internal/AFi1pSDK$AFa1ySDK;", "", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AFa1ySDK {
        private AFa1ySDK() {
        }

        public /* synthetic */ AFa1ySDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
