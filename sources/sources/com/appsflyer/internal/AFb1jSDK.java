package com.appsflyer.internal;

import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lcom/appsflyer/internal/AFb1jSDK;", "", "<init>", "()V", "Lcom/appsflyer/internal/AFc1oSDK;", "p0", "", "getRevenue", "(Lcom/appsflyer/internal/AFc1oSDK;)Ljava/lang/String;", "p1", "", "getCurrencyIso4217Code", "(Ljava/lang/String;Lcom/appsflyer/internal/AFc1oSDK;)V", "getMediationNetwork", "Ljava/lang/String;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AFb1jSDK {
    public static final AFb1jSDK INSTANCE = new AFb1jSDK();
    private static String getMediationNetwork;

    private AFb1jSDK() {
    }

    @JvmStatic
    public static final synchronized void getCurrencyIso4217Code(String str, AFc1oSDK aFc1oSDK) {
        synchronized (AFb1jSDK.class) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(aFc1oSDK, "");
            getMediationNetwork = str;
            aFc1oSDK.getCurrencyIso4217Code("CUSTOM_INSTALL_ID_APPLIED", true);
            aFc1oSDK.AFAdRevenueData("AF_INSTALLATION", str);
        }
    }

    @JvmStatic
    public static final synchronized String getRevenue(AFc1oSDK aFc1oSDK) {
        String str;
        synchronized (AFb1jSDK.class) {
            Intrinsics.checkNotNullParameter(aFc1oSDK, "");
            if (getMediationNetwork == null) {
                String monetizationNetwork = aFc1oSDK.getMonetizationNetwork("AF_INSTALLATION", null);
                if (monetizationNetwork == null) {
                    monetizationNetwork = System.currentTimeMillis() + "-" + Math.abs(new SecureRandom().nextLong());
                    aFc1oSDK.AFAdRevenueData("AF_INSTALLATION", monetizationNetwork);
                }
                getMediationNetwork = monetizationNetwork;
            }
            str = getMediationNetwork;
            Intrinsics.checkNotNull(str);
        }
        return str;
    }
}
