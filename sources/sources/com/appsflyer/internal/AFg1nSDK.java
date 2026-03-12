package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public final class AFg1nSDK extends AFe1eSDK<Map<String, Object>> {
    private static final List<String> areAllFieldsValid = Arrays.asList("googleplay", "playstore", "googleplaystore");
    private final AFc1pSDK copy;
    private final AFh1tSDK copydefault;
    private final AFc1oSDK equals;
    private Map<String, Object> hashCode;
    private String registerClient;
    private final AFd1lSDK toString;

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    public final AppsFlyerRequestListener areAllFieldsValid() {
        return null;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    public final boolean copydefault() {
        return false;
    }

    public AFg1nSDK(AFc1bSDK aFc1bSDK) {
        super(AFe1mSDK.GCDSDK, new AFe1mSDK[]{AFe1mSDK.RC_CDN}, aFc1bSDK, "GCD-FETCH");
        this.toString = aFc1bSDK.getRevenue();
        this.equals = aFc1bSDK.component2();
        this.copydefault = aFc1bSDK.component3();
        this.copy = aFc1bSDK.getCurrencyIso4217Code();
        this.getRevenue.add(AFe1mSDK.CONVERSION);
        this.getRevenue.add(AFe1mSDK.LAUNCH);
    }

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final void getRevenue() {
        super.getRevenue();
        Map<String, Object> map = this.hashCode;
        String str = this.registerClient;
        if (map != null) {
            AFg1pSDK.getMonetizationNetwork(map);
        } else if (str != null && !str.isEmpty()) {
            AFg1pSDK.getRevenue(str);
        } else {
            AFg1pSDK.getRevenue("Unknown error");
        }
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    public final AFd1jSDK<Map<String, Object>> getRevenue(String str) {
        String str2;
        String currencyIso4217Code = AFa1uSDK.getCurrencyIso4217Code(this.equals, this.copy.areAllFieldsValid());
        if (currencyIso4217Code != null && !currencyIso4217Code.trim().isEmpty()) {
            if (!areAllFieldsValid.contains(currencyIso4217Code.toLowerCase(Locale.getDefault()))) {
                str2 = "-".concat(String.valueOf(currencyIso4217Code));
                AFd1lSDK aFd1lSDK = this.toString;
                AFd1jSDK<Map<String, Object>> aFd1jSDK = (AFd1jSDK) AFd1lSDK.getRevenue(new Object[]{aFd1lSDK, str2, str}, 2067226218, -2067226217, System.identityHashCode(aFd1lSDK));
                AFLogger.afInfoLog(new StringBuilder("[GCD-B01] URL: ").append(aFd1jSDK.getRevenue.getRevenue).toString());
                return aFd1jSDK;
            }
            AFLogger.afWarnLog(String.format("[GCD] AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", currencyIso4217Code));
        }
        str2 = "";
        AFd1lSDK aFd1lSDK2 = this.toString;
        AFd1jSDK<Map<String, Object>> aFd1jSDK2 = (AFd1jSDK) AFd1lSDK.getRevenue(new Object[]{aFd1lSDK2, str2, str}, 2067226218, -2067226217, System.identityHashCode(aFd1lSDK2));
        AFLogger.afInfoLog(new StringBuilder("[GCD-B01] URL: ").append(aFd1jSDK2.getRevenue.getRevenue).toString());
        return aFd1jSDK2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d A[Catch: all -> 0x0106, Exception -> 0x0108, AFe1pSDK -> 0x0138, TryCatch #1 {AFe1pSDK -> 0x0138, blocks: (B:12:0x0025, B:15:0x002f, B:22:0x003f, B:30:0x0052, B:33:0x0069, B:35:0x007d, B:37:0x0097, B:39:0x009d, B:40:0x00a8, B:42:0x00ae, B:44:0x00b4, B:45:0x00cb, B:46:0x00dc, B:48:0x00fb, B:49:0x0100), top: B:68:0x0025, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae A[Catch: all -> 0x0106, Exception -> 0x0108, AFe1pSDK -> 0x0138, TryCatch #1 {AFe1pSDK -> 0x0138, blocks: (B:12:0x0025, B:15:0x002f, B:22:0x003f, B:30:0x0052, B:33:0x0069, B:35:0x007d, B:37:0x0097, B:39:0x009d, B:40:0x00a8, B:42:0x00ae, B:44:0x00b4, B:45:0x00cb, B:46:0x00dc, B:48:0x00fb, B:49:0x0100), top: B:68:0x0025, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fb A[Catch: all -> 0x0106, Exception -> 0x0108, AFe1pSDK -> 0x0138, TryCatch #1 {AFe1pSDK -> 0x0138, blocks: (B:12:0x0025, B:15:0x002f, B:22:0x003f, B:30:0x0052, B:33:0x0069, B:35:0x007d, B:37:0x0097, B:39:0x009d, B:40:0x00a8, B:42:0x00ae, B:44:0x00b4, B:45:0x00cb, B:46:0x00dc, B:48:0x00fb, B:49:0x0100), top: B:68:0x0025, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0052 A[SYNTHETIC] */
    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.appsflyer.internal.AFe1uSDK getMediationNetwork() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFg1nSDK.getMediationNetwork():com.appsflyer.internal.AFe1uSDK");
    }
}
