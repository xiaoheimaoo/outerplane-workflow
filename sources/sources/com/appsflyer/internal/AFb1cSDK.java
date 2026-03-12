package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.appsflyer.internal.AFb1aSDK;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFb1cSDK implements AFb1aSDK {
    private final ScheduledExecutorService AFAdRevenueData;
    private final AFi1kSDK getCurrencyIso4217Code;
    private final AFa1rSDK getMonetizationNetwork;
    private AFb1lSDK getRevenue;

    public AFb1cSDK(ScheduledExecutorService scheduledExecutorService, AFa1rSDK aFa1rSDK, AFi1kSDK aFi1kSDK) {
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "");
        Intrinsics.checkNotNullParameter(aFa1rSDK, "");
        Intrinsics.checkNotNullParameter(aFi1kSDK, "");
        this.AFAdRevenueData = scheduledExecutorService;
        this.getMonetizationNetwork = aFa1rSDK;
        this.getCurrencyIso4217Code = aFi1kSDK;
    }

    @Override // com.appsflyer.internal.AFb1aSDK
    public final void getCurrencyIso4217Code(Context context, AFb1aSDK.AFa1ySDK aFa1ySDK) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(aFa1ySDK, "");
        Intrinsics.checkNotNullParameter(context, "");
        if (this.getRevenue != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "");
            ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this.getRevenue);
        }
        this.getRevenue = null;
        AFb1lSDK aFb1lSDK = new AFb1lSDK(this.AFAdRevenueData, this.getMonetizationNetwork, this.getCurrencyIso4217Code, aFa1ySDK);
        this.getRevenue = aFb1lSDK;
        if (context instanceof Activity) {
            aFb1lSDK.onActivityResumed((Activity) context);
        }
        Application O_ = AFj1iSDK.O_(context);
        if (O_ != null) {
            O_.registerActivityLifecycleCallbacks(this.getRevenue);
        }
    }

    @Override // com.appsflyer.internal.AFb1aSDK
    public final boolean getCurrencyIso4217Code() {
        return this.getRevenue != null;
    }

    @Override // com.appsflyer.internal.AFb1aSDK
    public final void getMonetizationNetwork() {
        AFb1aSDK.AFa1ySDK aFa1ySDK;
        AFb1lSDK aFb1lSDK = this.getRevenue;
        if (aFb1lSDK == null || (aFa1ySDK = aFb1lSDK.getRevenue) == null) {
            return;
        }
        aFa1ySDK.getMediationNetwork();
    }
}
