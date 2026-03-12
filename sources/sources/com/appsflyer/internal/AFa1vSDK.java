package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFe1nSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFa1vSDK implements Runnable {
    private final WeakReference<Context> AFAdRevenueData;
    private final Map<String, String> component1;
    private final String component3;
    private final String component4;
    final String getCurrencyIso4217Code;
    private final String getMediationNetwork;
    final String getMonetizationNetwork;
    final String getRevenue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AFa1vSDK(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.AFAdRevenueData = new WeakReference<>(context);
        this.getMediationNetwork = str;
        this.component3 = str2;
        this.getMonetizationNetwork = str4;
        this.getCurrencyIso4217Code = str5;
        this.getRevenue = str6;
        this.component1 = map;
        this.component4 = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.getMediationNetwork;
        if (str == null || str.length() == 0 || AppsFlyerLib.getInstance().isStopped()) {
            return;
        }
        try {
            Context context = this.AFAdRevenueData.get();
            if (context == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("public-key", this.component3);
            hashMap.put("sig-data", this.getMonetizationNetwork);
            hashMap.put(InAppPurchaseMetaData.KEY_SIGNATURE, this.component4);
            Object hashMap2 = new HashMap(hashMap);
            Object obj = this.component1;
            AFa1uSDK monetizationNetwork = AFa1uSDK.getMonetizationNetwork();
            String monetizationNetwork2 = ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{monetizationNetwork}, 389316487, -389316474, System.identityHashCode(monetizationNetwork))).component2().getMonetizationNetwork("referrer", "");
            AFh1bSDK aFh1bSDK = new AFh1bSDK();
            aFh1bSDK.areAllFieldsValid = monetizationNetwork2;
            AFh1bSDK aFh1bSDK2 = aFh1bSDK;
            AFa1uSDK monetizationNetwork3 = AFa1uSDK.getMonetizationNetwork();
            Map<String, Object> revenue = monetizationNetwork3.getRevenue(aFh1bSDK);
            revenue.put("price", this.getCurrencyIso4217Code);
            revenue.put("currency", this.getRevenue);
            revenue.put("receipt_data", hashMap2);
            if (obj != null) {
                revenue.put("extra_prms", obj);
            }
            revenue.putAll(((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{monetizationNetwork3}, 389316487, -389316474, System.identityHashCode(monetizationNetwork3))).AFKeystoreWrapper().getRevenue());
            aFh1bSDK.getMonetizationNetwork(revenue);
            getCurrencyIso4217Code(context, aFh1bSDK);
            hashMap.put("dev_key", this.getMediationNetwork);
            hashMap.put("app_id", context.getPackageName());
            hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
            AFa1uSDK monetizationNetwork4 = AFa1uSDK.getMonetizationNetwork();
            AFh1pSDK aFh1pSDK = ((AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{monetizationNetwork4}, 389316487, -389316474, System.identityHashCode(monetizationNetwork4))).getCurrencyIso4217Code().AFAdRevenueData.component2;
            AFb1mSDK aFb1mSDK = aFh1pSDK != null ? new AFb1mSDK(aFh1pSDK.getRevenue, aFh1pSDK.getMonetizationNetwork) : null;
            String str2 = aFb1mSDK != null ? aFb1mSDK.getCurrencyIso4217Code : null;
            if (str2 != null) {
                hashMap.put("advertiserId", str2);
            }
            AFh1dSDK aFh1dSDK = (AFh1dSDK) new AFh1dSDK().getMonetizationNetwork(hashMap);
            final AFf1uSDK currencyIso4217Code = getCurrencyIso4217Code(context, aFh1dSDK);
            aFh1dSDK.getMonetizationNetwork = new AppsFlyerRequestListener() { // from class: com.appsflyer.internal.AFa1vSDK.3
                @Override // com.appsflyer.attribution.AppsFlyerRequestListener
                public final void onSuccess() {
                    try {
                        JSONObject jSONObject = new JSONObject((String) ((AFe1eSDK) currencyIso4217Code).component3.getBody());
                        AFLogger.afInfoLog("Validate response ok: ".concat(String.valueOf(jSONObject)));
                        AFa1vSDK.AFAdRevenueData(jSONObject.optBoolean("result"), AFa1vSDK.this.getMonetizationNetwork, AFa1vSDK.this.getCurrencyIso4217Code, AFa1vSDK.this.getRevenue, jSONObject.toString());
                    } catch (Exception e) {
                        AFLogger.afErrorLog("Failed Validate request: ".concat(String.valueOf(e)), e);
                        AFa1vSDK.AFAdRevenueData(false, AFa1vSDK.this.getMonetizationNetwork, AFa1vSDK.this.getCurrencyIso4217Code, AFa1vSDK.this.getRevenue, e.getMessage());
                    }
                }

                @Override // com.appsflyer.attribution.AppsFlyerRequestListener
                public final void onError(int i, String str3) {
                    ResponseNetwork responseNetwork;
                    if (i == 50 && (responseNetwork = ((AFe1eSDK) currencyIso4217Code).component3) != null) {
                        str3 = responseNetwork.toString();
                    }
                    AFa1vSDK.AFAdRevenueData(false, AFa1vSDK.this.getMonetizationNetwork, AFa1vSDK.this.getCurrencyIso4217Code, AFa1vSDK.this.getRevenue, str3);
                }
            };
        } catch (Throwable th) {
            if (AFa1uSDK.getCurrencyIso4217Code != null) {
                AFLogger.afErrorLog("Failed Validate request + ex", th);
                AFAdRevenueData(false, this.getMonetizationNetwork, this.getCurrencyIso4217Code, this.getRevenue, th.getMessage());
            }
            AFLogger.afErrorLog(th.getMessage(), th);
        }
    }

    private static AFf1uSDK getCurrencyIso4217Code(Context context, AFh1fSDK aFh1fSDK) {
        AFa1uSDK.getMonetizationNetwork().getMediationNetwork(context);
        AFa1uSDK monetizationNetwork = AFa1uSDK.getMonetizationNetwork();
        AFc1bSDK aFc1bSDK = (AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{monetizationNetwork}, 389316487, -389316474, System.identityHashCode(monetizationNetwork));
        aFh1fSDK.getMonetizationNetwork(aFc1bSDK.getCurrencyIso4217Code().getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0));
        AFf1uSDK aFf1uSDK = new AFf1uSDK(aFh1fSDK, aFc1bSDK);
        AFe1nSDK copydefault = aFc1bSDK.copydefault();
        copydefault.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFf1uSDK));
        return aFf1uSDK;
    }

    static void AFAdRevenueData(boolean z, String str, String str2, String str3, String str4) {
        if (AFa1uSDK.getCurrencyIso4217Code != null) {
            AFLogger.afDebugLog(new StringBuilder("Validate callback parameters: ").append(str).append(" ").append(str2).append(" ").append(str3).toString());
            if (z) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AFa1uSDK.getCurrencyIso4217Code.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AFa1uSDK.getCurrencyIso4217Code;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }
}
