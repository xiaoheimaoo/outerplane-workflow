package com.appsflyer.internal;
/* loaded from: classes.dex */
public final class AFh1eSDK extends AFh1jSDK {
    @Override // com.appsflyer.internal.AFh1jSDK
    public final boolean component3() {
        return true;
    }

    @Override // com.appsflyer.internal.AFh1jSDK
    public final AFe1mSDK getCurrencyIso4217Code() {
        if (this.component1 == 1) {
            return AFe1mSDK.CONVERSION;
        }
        return AFe1mSDK.LAUNCH;
    }
}
