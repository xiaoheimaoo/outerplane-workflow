package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes.dex */
public final class AFf1tSDK extends AFe1eSDK<String> {
    private final AFh1gSDK areAllFieldsValid;

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final boolean copydefault() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final AFd1jSDK<String> getRevenue(String str) {
        String encodeToString = Base64.encodeToString(this.areAllFieldsValid.AFAdRevenueData(), 2);
        AFLogger.afInfoLog("cached data: ".concat(String.valueOf(encodeToString)));
        this.component4.getMonetizationNetwork(this.areAllFieldsValid.component3, encodeToString);
        return ((AFe1eSDK) this).component1.getRevenue(this.areAllFieldsValid);
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final AppsFlyerRequestListener areAllFieldsValid() {
        return this.areAllFieldsValid.getMonetizationNetwork;
    }

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final boolean AFAdRevenueData() {
        return super.AFAdRevenueData() || copy() || equals();
    }

    private boolean copy() {
        AFe1mSDK aFe1mSDK;
        AFh1gSDK aFh1gSDK = this.areAllFieldsValid;
        if (aFh1gSDK.toString != null) {
            aFe1mSDK = aFh1gSDK.toString;
        } else {
            aFe1mSDK = AFe1mSDK.CACHED_EVENT;
        }
        return aFe1mSDK == AFe1mSDK.ARS_VALIDATE && ((AFe1eSDK) this).component3 != null && ((AFe1eSDK) this).component3.getStatusCode() == 424;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AFf1tSDK(com.appsflyer.internal.AFh1gSDK r8, com.appsflyer.internal.AFc1bSDK r9) {
        /*
            r7 = this;
            com.appsflyer.internal.AFe1mSDK r0 = r8.toString
            if (r0 == 0) goto L7
            com.appsflyer.internal.AFe1mSDK r0 = r8.toString
            goto L9
        L7:
            com.appsflyer.internal.AFe1mSDK r0 = com.appsflyer.internal.AFe1mSDK.CACHED_EVENT
        L9:
            r2 = r0
            r0 = 1
            com.appsflyer.internal.AFe1mSDK[] r3 = new com.appsflyer.internal.AFe1mSDK[r0]
            r0 = 0
            com.appsflyer.internal.AFe1mSDK r1 = com.appsflyer.internal.AFe1mSDK.RC_CDN
            r3[r0] = r1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r8.getRevenue
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "-"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = getMediationNetwork(r8)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r6 = r8.getRevenue
            r1 = r7
            r4 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r7.areAllFieldsValid = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1tSDK.<init>(com.appsflyer.internal.AFh1gSDK, com.appsflyer.internal.AFc1bSDK):void");
    }

    private static String getMediationNetwork(AFh1gSDK aFh1gSDK) {
        try {
            return new URL(aFh1gSDK.component3).getHost();
        } catch (MalformedURLException unused) {
            return "";
        }
    }

    private boolean equals() {
        ResponseNetwork responseNetwork = ((AFe1eSDK) this).component3;
        return (this.AFAdRevenueData == AFe1uSDK.FAILURE && responseNetwork != null && responseNetwork.getStatusCode() / 500 == 1) && (this.getCurrencyIso4217Code == AFe1mSDK.CONVERSION || this.getCurrencyIso4217Code == AFe1mSDK.ATTR);
    }
}
