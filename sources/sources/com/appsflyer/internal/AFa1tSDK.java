package com.appsflyer.internal;

import com.appsflyer.internal.AFe1nSDK;
import com.appsflyer.internal.AFe1rSDK;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFa1tSDK implements Runnable {
    private final AFh1jSDK AFAdRevenueData;
    private final Map<String, Object> getMonetizationNetwork;
    private final AFc1bSDK getRevenue;

    public AFa1tSDK(AFc1bSDK aFc1bSDK, AFh1jSDK aFh1jSDK, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(aFc1bSDK, "");
        Intrinsics.checkNotNullParameter(aFh1jSDK, "");
        this.getRevenue = aFc1bSDK;
        this.AFAdRevenueData = aFh1jSDK;
        this.getMonetizationNetwork = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AFf1sSDK aFf1uSDK;
        if (this.AFAdRevenueData.getMediationNetwork()) {
            AFf1rSDK aFf1rSDK = new AFf1rSDK(this.AFAdRevenueData, this.getRevenue);
            aFf1rSDK.hashCode = this.getMonetizationNetwork;
            aFf1uSDK = aFf1rSDK;
        } else if (this.AFAdRevenueData instanceof AFh1nSDK) {
            aFf1uSDK = new AFf1sSDK((AFh1nSDK) this.AFAdRevenueData, this.getRevenue);
        } else {
            aFf1uSDK = new AFf1uSDK(this.AFAdRevenueData, this.getRevenue);
        }
        AFe1nSDK copydefault = this.getRevenue.copydefault();
        copydefault.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFf1uSDK));
        this.getRevenue.AFInAppEventParameterName();
        if (AFe1ySDK.getRevenue()) {
            AFe1qSDK AFAdRevenueData = this.getRevenue.AFAdRevenueData();
            AFh1jSDK aFh1jSDK = this.AFAdRevenueData;
            Intrinsics.checkNotNullParameter(aFh1jSDK, "");
            if (AFj1iSDK.AFAdRevenueData(AFAdRevenueData.AFAdRevenueData.getRevenue)) {
                AFe1rSDK.AFa1vSDK aFa1vSDK = AFe1rSDK.AFa1vSDK;
                AFe1rSDK monetizationNetwork = AFe1rSDK.AFa1vSDK.getMonetizationNetwork(aFh1jSDK);
                if (monetizationNetwork == null) {
                    return;
                }
                AFAdRevenueData.AFAdRevenueData(monetizationNetwork, new Function1<AFe1uSDK, Unit>() { // from class: com.appsflyer.internal.AFe1qSDK.1
                    public final void getRevenue(AFe1uSDK aFe1uSDK) {
                        Intrinsics.checkNotNullParameter(aFe1uSDK, "");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(AFe1uSDK aFe1uSDK) {
                        getRevenue(aFe1uSDK);
                        return Unit.INSTANCE;
                    }
                });
            }
        }
    }
}
