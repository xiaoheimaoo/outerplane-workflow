package com.appsflyer.internal;

import com.appsflyer.PurchaseHandler;
import java.util.Map;
/* loaded from: classes.dex */
public final class AFe1bSDK extends AFe1hSDK {
    public AFe1bSDK(Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, AFc1bSDK aFc1bSDK) {
        super(AFe1mSDK.PURCHASE_VALIDATE, new AFe1mSDK[]{AFe1mSDK.RC_CDN, AFe1mSDK.FETCH_ADVERTISING_ID}, aFc1bSDK, map, purchaseValidationCallback);
        this.getRevenue.add(AFe1mSDK.CONVERSION);
    }

    @Override // com.appsflyer.internal.AFe1gSDK
    public final AFd1jSDK<String> getMediationNetwork(Map<String, Object> map, String str, String str2) {
        return ((AFe1eSDK) this).component1.getRevenue(map, str, str2);
    }
}
