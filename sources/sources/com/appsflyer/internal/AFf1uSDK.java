package com.appsflyer.internal;

import com.appsflyer.attribution.AppsFlyerRequestListener;
/* loaded from: classes.dex */
public class AFf1uSDK extends AFe1eSDK<String> {
    private static final AFe1mSDK[] AFLogger = {AFe1mSDK.DLSDK, AFe1mSDK.ONELINK, AFe1mSDK.REGISTER};
    private final AFf1gSDK AFInAppEventType;
    protected final AFc1oSDK areAllFieldsValid;
    protected final AFg1rSDK copy;
    private final AFe1ySDK copydefault;
    private final AFf1lSDK equals;
    private final AFc1pSDK hashCode;
    private final AFc1gSDK registerClient;
    private final AFh1jSDK toString;

    @Override // com.appsflyer.internal.AFe1eSDK
    protected boolean copydefault() {
        return true;
    }

    public AFf1uSDK(AFh1jSDK aFh1jSDK, AFc1bSDK aFc1bSDK) {
        this(aFh1jSDK, aFc1bSDK, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFf1uSDK(AFh1jSDK aFh1jSDK, AFc1bSDK aFc1bSDK, String str) {
        super(aFh1jSDK.getCurrencyIso4217Code(), new AFe1mSDK[]{AFe1mSDK.RC_CDN, AFe1mSDK.FETCH_ADVERTISING_ID}, aFc1bSDK, str);
        this.toString = aFh1jSDK;
        this.copydefault = aFc1bSDK.AFInAppEventParameterName();
        this.areAllFieldsValid = aFc1bSDK.component2();
        this.equals = aFc1bSDK.component1();
        this.registerClient = aFc1bSDK.registerClient();
        this.hashCode = aFc1bSDK.getCurrencyIso4217Code();
        this.copy = aFc1bSDK.component4();
        this.AFInAppEventType = aFc1bSDK.force();
        for (AFe1mSDK aFe1mSDK : AFLogger) {
            if (this.getCurrencyIso4217Code == aFe1mSDK) {
                return;
            }
        }
        int i = this.toString.component1;
        AFe1mSDK aFe1mSDK2 = this.getCurrencyIso4217Code;
        if (i <= 0) {
            if (aFe1mSDK2 != AFe1mSDK.CONVERSION) {
                this.getMediationNetwork.add(AFe1mSDK.CONVERSION);
                return;
            }
            return;
        }
        this.getRevenue.add(AFe1mSDK.CONVERSION);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098 A[Catch: all -> 0x00ef, TryCatch #10 {all -> 0x00ef, blocks: (B:34:0x0083, B:38:0x00ca, B:37:0x0098), top: B:89:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6 A[Catch: all -> 0x00e3, Exception -> 0x00e6, NullPointerException -> 0x00ea, TRY_ENTER, TryCatch #11 {NullPointerException -> 0x00ea, Exception -> 0x00e6, all -> 0x00e3, blocks: (B:42:0x00d6, B:43:0x00dd, B:44:0x00e2), top: B:96:0x00d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dd A[Catch: all -> 0x00e3, Exception -> 0x00e6, NullPointerException -> 0x00ea, TryCatch #11 {NullPointerException -> 0x00ea, Exception -> 0x00e6, all -> 0x00e3, blocks: (B:42:0x00d6, B:43:0x00dd, B:44:0x00e2), top: B:96:0x00d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x015d  */
    @Override // com.appsflyer.internal.AFe1eSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final com.appsflyer.internal.AFd1jSDK<java.lang.String> getRevenue(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1uSDK.getRevenue(java.lang.String):com.appsflyer.internal.AFd1jSDK");
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final AppsFlyerRequestListener areAllFieldsValid() {
        return this.toString.getMonetizationNetwork;
    }

    protected void getRevenue(AFh1jSDK aFh1jSDK) {
        this.copy.getCurrencyIso4217Code(aFh1jSDK.getCurrencyIso4217Code);
    }

    protected void getCurrencyIso4217Code(AFh1jSDK aFh1jSDK) {
        this.copy.getCurrencyIso4217Code(aFh1jSDK);
    }

    protected void getMonetizationNetwork(AFh1jSDK aFh1jSDK) {
        this.copy.getMonetizationNetwork(aFh1jSDK);
    }

    protected void AFAdRevenueData(AFh1jSDK aFh1jSDK) {
        this.copy.getMediationNetwork(aFh1jSDK);
    }

    protected void areAllFieldsValid(AFh1jSDK aFh1jSDK) {
        this.copy.AFAdRevenueData(aFh1jSDK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e9, code lost:
        r4.put("prefix", r5.getRevenue);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c A[Catch: all -> 0x0116, TryCatch #1 {all -> 0x0116, blocks: (B:7:0x001e, B:9:0x0026, B:11:0x0059, B:12:0x005e, B:14:0x0064, B:15:0x006d, B:17:0x0077, B:22:0x0083, B:25:0x008b, B:26:0x0096, B:28:0x009c, B:30:0x00b6, B:32:0x00bb, B:34:0x00d0, B:35:0x00d9, B:37:0x00df, B:42:0x00e9, B:43:0x00f0, B:31:0x00b9, B:44:0x00f3, B:46:0x00fd, B:47:0x010a, B:2:0x0000), top: B:52:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd A[Catch: all -> 0x0116, TryCatch #1 {all -> 0x0116, blocks: (B:7:0x001e, B:9:0x0026, B:11:0x0059, B:12:0x005e, B:14:0x0064, B:15:0x006d, B:17:0x0077, B:22:0x0083, B:25:0x008b, B:26:0x0096, B:28:0x009c, B:30:0x00b6, B:32:0x00bb, B:34:0x00d0, B:35:0x00d9, B:37:0x00df, B:42:0x00e9, B:43:0x00f0, B:31:0x00b9, B:44:0x00f3, B:46:0x00fd, B:47:0x010a, B:2:0x0000), top: B:52:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getMediationNetwork(com.appsflyer.internal.AFh1jSDK r9) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1uSDK.getMediationNetwork(com.appsflyer.internal.AFh1jSDK):void");
    }
}
