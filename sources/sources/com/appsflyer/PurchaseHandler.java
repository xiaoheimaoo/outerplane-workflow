package com.appsflyer;

import com.appsflyer.internal.AFc1bSDK;
import com.appsflyer.internal.AFc1pSDK;
import com.appsflyer.internal.AFe1nSDK;
import com.appsflyer.internal.AFj1bSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.Map;
/* loaded from: classes.dex */
public final class PurchaseHandler {
    public final AFc1bSDK AFAdRevenueData;
    public final AFe1nSDK getCurrencyIso4217Code;
    private final AFc1pSDK getMonetizationNetwork;

    /* loaded from: classes.dex */
    public interface PurchaseValidationCallback {
        void onFailure(Throwable th);

        void onResponse(ResponseNetwork<String> responseNetwork);
    }

    public PurchaseHandler(AFc1bSDK aFc1bSDK) {
        this.AFAdRevenueData = aFc1bSDK;
        this.getMonetizationNetwork = aFc1bSDK.getCurrencyIso4217Code();
        this.getCurrencyIso4217Code = aFc1bSDK.copydefault();
    }

    public final boolean getMonetizationNetwork(Map<String, Object> map, PurchaseValidationCallback purchaseValidationCallback, String... strArr) {
        boolean AFAdRevenueData = AFj1bSDK.AFAdRevenueData(map, strArr, this.getMonetizationNetwork);
        if (!AFAdRevenueData && purchaseValidationCallback != null) {
            purchaseValidationCallback.onFailure(new IllegalArgumentException("Invalid Request Data"));
        }
        return AFAdRevenueData;
    }
}
