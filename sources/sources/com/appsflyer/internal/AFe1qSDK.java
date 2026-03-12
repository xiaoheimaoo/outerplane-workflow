package com.appsflyer.internal;

import com.appsflyer.internal.AFe1nSDK;
import com.appsflyer.internal.AFe1rSDK;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFe1qSDK {
    public final AFc1gSDK AFAdRevenueData;
    private final AFf1cSDK component2;
    private final AFe1nSDK component4;
    private final AFc1pSDK getCurrencyIso4217Code;
    private final ExecutorService getMediationNetwork;
    private final AFg1rSDK getMonetizationNetwork;
    public final AFc1oSDK getRevenue;

    public AFe1qSDK(AFc1oSDK aFc1oSDK, AFc1gSDK aFc1gSDK, AFc1pSDK aFc1pSDK, ExecutorService executorService, AFg1rSDK aFg1rSDK, AFf1cSDK aFf1cSDK, AFe1nSDK aFe1nSDK) {
        Intrinsics.checkNotNullParameter(aFc1oSDK, "");
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(executorService, "");
        Intrinsics.checkNotNullParameter(aFg1rSDK, "");
        Intrinsics.checkNotNullParameter(aFf1cSDK, "");
        Intrinsics.checkNotNullParameter(aFe1nSDK, "");
        this.getRevenue = aFc1oSDK;
        this.AFAdRevenueData = aFc1gSDK;
        this.getCurrencyIso4217Code = aFc1pSDK;
        this.getMediationNetwork = executorService;
        this.getMonetizationNetwork = aFg1rSDK;
        this.component2 = aFf1cSDK;
        this.component4 = aFe1nSDK;
    }

    public final void AFAdRevenueData() {
        if (this.getRevenue.getMediationNetwork("didSendRevenueTriggerOnLastBackground", true) || !AFj1iSDK.AFAdRevenueData(this.AFAdRevenueData.getRevenue)) {
            return;
        }
        AFAdRevenueData(AFe1rSDK.AFa1tSDK.INSTANCE, new Function1<AFe1uSDK, Unit>() { // from class: com.appsflyer.internal.AFe1qSDK.5
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(AFe1uSDK aFe1uSDK) {
                getMonetizationNetwork(aFe1uSDK);
                return Unit.INSTANCE;
            }

            public final void getMonetizationNetwork(AFe1uSDK aFe1uSDK) {
                Intrinsics.checkNotNullParameter(aFe1uSDK, "");
                if (aFe1uSDK == AFe1uSDK.SUCCESS) {
                    AFe1qSDK.this.getRevenue.getCurrencyIso4217Code("didSendRevenueTriggerOnLastBackground", true);
                }
            }

            {
                super(1);
            }
        });
    }

    public final void AFAdRevenueData(AFe1rSDK aFe1rSDK, Function1<? super AFe1uSDK, Unit> function1) {
        Intrinsics.checkNotNullParameter(aFe1rSDK, "");
        Intrinsics.checkNotNullParameter(function1, "");
        AFe1aSDK aFe1aSDK = new AFe1aSDK(aFe1rSDK, this.getMediationNetwork, this.getCurrencyIso4217Code, this.AFAdRevenueData, this.getMonetizationNetwork, this.component2, function1);
        AFe1nSDK aFe1nSDK = this.component4;
        aFe1nSDK.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFe1aSDK));
    }
}
