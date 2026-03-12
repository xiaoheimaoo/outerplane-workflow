package com.appsflyer.internal;

import com.appsflyer.AFInAppEventType;
/* loaded from: classes.dex */
public final class AFh1bSDK extends AFh1fSDK {
    public AFh1bSDK() {
        super(AFInAppEventType.PURCHASE, Boolean.TRUE);
    }

    @Override // com.appsflyer.internal.AFh1jSDK
    public final AFe1mSDK getCurrencyIso4217Code() {
        return AFe1mSDK.PURCHASE_VALIDATE;
    }
}
