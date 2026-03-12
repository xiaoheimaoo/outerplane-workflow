package com.appsflyer.internal;
/* loaded from: classes.dex */
public final class AFg1uSDK extends AFh1jSDK {
    @Override // com.appsflyer.internal.AFh1jSDK
    public final boolean getMonetizationNetwork() {
        return false;
    }

    public AFg1uSDK() {
        super("Register", null, Boolean.FALSE);
    }

    @Override // com.appsflyer.internal.AFh1jSDK
    public final AFe1mSDK getCurrencyIso4217Code() {
        return AFe1mSDK.REGISTER;
    }
}
