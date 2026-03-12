package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFh1vSDK implements AFg1aSDK {
    private AFh1zSDK AFAdRevenueData;
    private AFh1wSDK getCurrencyIso4217Code;
    private final AFc1bSDK getMonetizationNetwork;
    private AFg1eSDK getRevenue;

    public AFh1vSDK(AFc1bSDK aFc1bSDK) {
        Intrinsics.checkNotNullParameter(aFc1bSDK, "");
        this.getMonetizationNetwork = aFc1bSDK;
    }

    @Override // com.appsflyer.internal.AFg1aSDK
    public final void getMonetizationNetwork() {
        AFh1zSDK aFh1zSDK = this.AFAdRevenueData;
        if (aFh1zSDK != null) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFh1ySDK.v$default(aFLogger, AFg1cSDK.EXCEPTION_MANAGER, "Releasing Exception Manager Client", false, 4, null);
            aFLogger.unregisterClient(aFh1zSDK);
            this.AFAdRevenueData = null;
        }
    }

    @Override // com.appsflyer.internal.AFg1aSDK
    public final void AFAdRevenueData() {
        AFh1wSDK aFh1wSDK = this.getCurrencyIso4217Code;
        if (aFh1wSDK != null) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFh1ySDK.v$default(aFLogger, AFg1cSDK.RD, "Releasing Proxy Manager Client", false, 4, null);
            aFLogger.unregisterClient(aFh1wSDK);
            this.getCurrencyIso4217Code = null;
        }
    }

    @Override // com.appsflyer.internal.AFg1aSDK
    public final void getRevenue() {
        AFg1eSDK aFg1eSDK = this.getRevenue;
        if (aFg1eSDK != null) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFh1ySDK.v$default(aFLogger, AFg1cSDK.RD, "Releasing Proxy Manager Client", false, 4, null);
            aFLogger.unregisterClient(aFg1eSDK);
            this.getRevenue = null;
        }
    }

    @Override // com.appsflyer.internal.AFg1aSDK
    public final void areAllFieldsValid() {
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFh1ySDK[] aFh1ySDKArr = new AFh1ySDK[1];
        if (this.getRevenue == null) {
            this.getRevenue = new AFg1eSDK();
        }
        AFg1eSDK aFg1eSDK = this.getRevenue;
        Intrinsics.checkNotNull(aFg1eSDK);
        aFh1ySDKArr[0] = aFg1eSDK;
        aFLogger.registerClient(aFh1ySDKArr);
    }

    @Override // com.appsflyer.internal.AFg1aSDK
    public final void getMediationNetwork() {
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFh1ySDK[] aFh1ySDKArr = new AFh1ySDK[1];
        if (this.getCurrencyIso4217Code == null) {
            this.getCurrencyIso4217Code = new AFh1wSDK(this.getMonetizationNetwork);
        }
        AFh1wSDK aFh1wSDK = this.getCurrencyIso4217Code;
        Intrinsics.checkNotNull(aFh1wSDK);
        aFh1ySDKArr[0] = aFh1wSDK;
        aFLogger.registerClient(aFh1ySDKArr);
    }

    @Override // com.appsflyer.internal.AFg1aSDK
    public final void getCurrencyIso4217Code() {
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFh1ySDK[] aFh1ySDKArr = new AFh1ySDK[1];
        if (this.AFAdRevenueData == null) {
            this.AFAdRevenueData = new AFh1zSDK(this.getMonetizationNetwork);
        }
        AFh1zSDK aFh1zSDK = this.AFAdRevenueData;
        Intrinsics.checkNotNull(aFh1zSDK);
        aFh1ySDKArr[0] = aFh1zSDK;
        aFLogger.registerClient(aFh1ySDKArr);
    }
}
