package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class AFf1iSDK {
    public long getCurrencyIso4217Code;
    public final AFc1oSDK getMonetizationNetwork;
    public long getRevenue;
    public AFi1wSDK getMediationNetwork = null;
    public AFi1wSDK AFAdRevenueData = getCurrencyIso4217Code();

    public AFf1iSDK(AFc1oSDK aFc1oSDK) {
        this.getMonetizationNetwork = aFc1oSDK;
        this.getCurrencyIso4217Code = aFc1oSDK.getCurrencyIso4217Code("af_rc_timestamp", 0L);
        this.getRevenue = aFc1oSDK.getCurrencyIso4217Code("af_rc_max_age", 0L);
    }

    private AFi1wSDK getCurrencyIso4217Code() {
        String monetizationNetwork = this.getMonetizationNetwork.getMonetizationNetwork("af_remote_config", null);
        if (monetizationNetwork == null) {
            AFLogger.INSTANCE.d(AFg1cSDK.REMOTE_CONTROL, "No configuration found in cache");
            return null;
        }
        try {
            return new AFi1wSDK(new String(Base64.decode(monetizationNetwork, 2), Charset.defaultCharset()));
        } catch (Exception e) {
            AFLogger.INSTANCE.e(AFg1cSDK.REMOTE_CONTROL, "Error reading malformed configuration from cache, requires fetching from remote again", e, true);
            return null;
        }
    }
}
