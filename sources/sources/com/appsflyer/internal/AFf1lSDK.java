package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFe1nSDK;
/* loaded from: classes.dex */
public final class AFf1lSDK implements AFe1sSDK {
    public final AFf1iSDK AFAdRevenueData;
    private final AFf1hSDK areAllFieldsValid;
    private final AFd1lSDK component1;
    private final AFe1nSDK component2;
    private AFi1vSDK component3;
    private AFf1oSDK component4;
    private final Object getCurrencyIso4217Code = new Object();
    private final AFf1qSDK getMediationNetwork;
    private final AFf1cSDK getMonetizationNetwork;
    private final AFc1pSDK getRevenue;

    public AFf1lSDK(AFf1qSDK aFf1qSDK, AFc1pSDK aFc1pSDK, AFf1cSDK aFf1cSDK, AFf1iSDK aFf1iSDK, AFd1lSDK aFd1lSDK, AFf1hSDK aFf1hSDK, AFe1nSDK aFe1nSDK) {
        this.getMediationNetwork = aFf1qSDK;
        this.getRevenue = aFc1pSDK;
        this.getMonetizationNetwork = aFf1cSDK;
        this.AFAdRevenueData = aFf1iSDK;
        this.component1 = aFd1lSDK;
        this.areAllFieldsValid = aFf1hSDK;
        this.component2 = aFe1nSDK;
        aFe1nSDK.getMonetizationNetwork.add(this);
    }

    public final void getRevenue(AFf1nSDK aFf1nSDK) {
        AFf1mSDK aFf1mSDK = new AFf1mSDK(this.getMediationNetwork, this.getRevenue, this.getMonetizationNetwork, this.AFAdRevenueData, this.component1, this.areAllFieldsValid, "v1", aFf1nSDK);
        AFe1nSDK aFe1nSDK = this.component2;
        aFe1nSDK.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFf1mSDK));
    }

    public final AFi1vSDK getRevenue() {
        AFi1vSDK aFi1vSDK;
        synchronized (this.getCurrencyIso4217Code) {
            aFi1vSDK = this.component3;
            this.component3 = null;
        }
        return aFi1vSDK;
    }

    private void getMonetizationNetwork(AFf1oSDK aFf1oSDK, AFf1nSDK aFf1nSDK) {
        synchronized (this.getCurrencyIso4217Code) {
            this.component4 = aFf1oSDK;
        }
        if (aFf1nSDK != null) {
            aFf1nSDK.onRemoteConfigUpdateFinished(aFf1oSDK);
        }
    }

    @Override // com.appsflyer.internal.AFe1sSDK
    public final void getMonetizationNetwork(AFe1lSDK<?> aFe1lSDK, AFe1uSDK aFe1uSDK) {
        if (aFe1lSDK instanceof AFf1mSDK) {
            AFf1mSDK aFf1mSDK = (AFf1mSDK) aFe1lSDK;
            AFf1oSDK aFf1oSDK = aFf1mSDK.component2;
            if (aFf1oSDK == null) {
                AFLogger.INSTANCE.w(AFg1cSDK.REMOTE_CONTROL, "update RC returned null result, something went wrong!");
                aFf1oSDK = AFf1oSDK.FAILURE;
            }
            if (aFf1oSDK != AFf1oSDK.USE_CACHED) {
                AFi1vSDK aFi1vSDK = aFf1mSDK.component3;
                synchronized (this.getCurrencyIso4217Code) {
                    this.component3 = aFi1vSDK;
                }
            }
            getMonetizationNetwork(aFf1oSDK, aFf1mSDK.component1);
        }
    }

    @Override // com.appsflyer.internal.AFe1sSDK
    public final void getMediationNetwork(AFe1lSDK<?> aFe1lSDK) {
        if (aFe1lSDK instanceof AFf1mSDK) {
            AFf1mSDK aFf1mSDK = (AFf1mSDK) aFe1lSDK;
            synchronized (this.getCurrencyIso4217Code) {
                this.component3 = null;
            }
            getMonetizationNetwork(AFf1oSDK.FAILURE, aFf1mSDK.component1);
        }
    }
}
