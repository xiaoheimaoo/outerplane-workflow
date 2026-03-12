package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.Map;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class AFg1iSDK extends AFe1lSDK<Void> {
    private final AFe1xSDK<String> component2;
    private final Throwable component3;
    private final AFc1oSDK component4;

    @Override // com.appsflyer.internal.AFe1lSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1lSDK
    public final long getCurrencyIso4217Code() {
        return 1000L;
    }

    public AFg1iSDK(AFf1rSDK aFf1rSDK, AFc1oSDK aFc1oSDK) {
        super(AFe1mSDK.GCDSDK, new AFe1mSDK[]{AFe1mSDK.RC_CDN}, "GCD-CHECK");
        this.component3 = aFf1rSDK.component1();
        this.component2 = ((AFe1eSDK) aFf1rSDK).component3;
        this.component4 = aFc1oSDK;
    }

    @Override // com.appsflyer.internal.AFe1lSDK
    public final AFe1uSDK getMediationNetwork() throws Exception {
        AFLogger.afDebugLog("[GCD-A01] Loading conversion data. Counter: ".concat(String.valueOf(this.component4.getMediationNetwork("appsFlyerCount", 0))));
        long currencyIso4217Code = this.component4.getCurrencyIso4217Code("appsflyerConversionDataCacheExpiration", 0L);
        if (currencyIso4217Code != 0 && System.currentTimeMillis() - currencyIso4217Code > 5184000000L) {
            AFLogger.afDebugLog("[GCD-E02] Cached conversion data expired");
            this.component4.getCurrencyIso4217Code("sixtyDayConversionData", true);
            this.component4.AFAdRevenueData("attributionId", null);
            this.component4.getRevenue("appsflyerConversionDataCacheExpiration", 0L);
        }
        Map<String, Object> areAllFieldsValid = areAllFieldsValid();
        if (areAllFieldsValid != null) {
            try {
                if (!areAllFieldsValid.containsKey("is_first_launch")) {
                    areAllFieldsValid.put("is_first_launch", Boolean.FALSE);
                }
                AFg1pSDK.getMonetizationNetwork(areAllFieldsValid);
            } catch (Exception e) {
                AFLogger.afErrorLog(new StringBuilder("[GCD] Error executing conversion data callback: ").append(e.getLocalizedMessage()).toString(), e);
            }
            return AFe1uSDK.SUCCESS;
        }
        try {
        } catch (Exception e2) {
            AFLogger.afErrorLog(new StringBuilder("[GCD] Error executing conversion data callback: ").append(e2.getLocalizedMessage()).toString(), e2);
        }
        if (this.component3 != null) {
            AFg1pSDK.getRevenue(new StringBuilder("Launch exception: ").append(this.component3.getMessage()).toString());
            return AFe1uSDK.SUCCESS;
        }
        AFe1xSDK<String> aFe1xSDK = this.component2;
        if (aFe1xSDK != null && !aFe1xSDK.isSuccessful()) {
            AFg1pSDK.getRevenue(new StringBuilder("Launch status code: ").append(this.component2.getStatusCode()).toString());
            return AFe1uSDK.SUCCESS;
        }
        return AFe1uSDK.FAILURE;
    }

    private Map<String, Object> areAllFieldsValid() {
        String monetizationNetwork = this.component4.getMonetizationNetwork("attributionId", null);
        if (monetizationNetwork == null) {
            return null;
        }
        try {
            new AFd1iSDK();
            return AFd1iSDK.getRevenue(monetizationNetwork);
        } catch (JSONException e) {
            AFLogger.afErrorLog(new StringBuilder("[GCD] Failed to parse GCD response: ").append(e.getMessage()).toString(), e);
            return null;
        }
    }
}
