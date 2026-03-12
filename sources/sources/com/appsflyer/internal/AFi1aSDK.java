package com.appsflyer.internal;

import com.appsflyer.AFLogger;
/* loaded from: classes.dex */
public abstract class AFi1aSDK extends AFj1qSDK {
    private AFc1pSDK getRevenue;

    public AFi1aSDK(String str, String str2, AFc1pSDK aFc1pSDK, Runnable runnable) {
        super(str, str2, runnable);
        this.getRevenue = aFc1pSDK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getMediationNetwork() {
        if (this.getRevenue.getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0) > 0) {
            AFLogger.afRDLog("Install referrer will not load, the counter > 1, ");
            return false;
        }
        return true;
    }
}
