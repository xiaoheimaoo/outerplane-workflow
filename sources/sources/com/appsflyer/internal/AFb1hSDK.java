package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFb1hSDK implements AFb1bSDK {
    private final AFf1cSDK AFAdRevenueData;
    private final AFc1eSDK getMonetizationNetwork;
    private final AFc1gSDK getRevenue;

    public AFb1hSDK(AFc1eSDK aFc1eSDK, AFc1gSDK aFc1gSDK, AFf1cSDK aFf1cSDK) {
        Intrinsics.checkNotNullParameter(aFc1eSDK, "");
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
        Intrinsics.checkNotNullParameter(aFf1cSDK, "");
        this.getMonetizationNetwork = aFc1eSDK;
        this.getRevenue = aFc1gSDK;
        this.AFAdRevenueData = aFf1cSDK;
    }

    @Override // com.appsflyer.internal.AFb1bSDK
    public final void getRevenue() {
        Context context = this.getRevenue.getRevenue;
        if (context != null) {
            try {
                Intrinsics.checkNotNullExpressionValue(AppSet.getClient(context).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appsflyer.internal.AFb1hSDK$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        AFb1hSDK.getMediationNetwork(AFb1hSDK.this, (AppSetIdInfo) obj);
                    }
                }), "");
            } catch (Throwable th) {
                AFh1ySDK.e$default(AFLogger.INSTANCE, AFg1cSDK.APP_SET_ID, "Error while trying to  fetch App set ID", th, false, false, false, false, 120, null);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMediationNetwork(AFb1hSDK aFb1hSDK, AppSetIdInfo appSetIdInfo) {
        Intrinsics.checkNotNullParameter(aFb1hSDK, "");
        AFc1eSDK aFc1eSDK = aFb1hSDK.getMonetizationNetwork;
        int scope = appSetIdInfo.getScope();
        String id = appSetIdInfo.getId();
        Intrinsics.checkNotNullExpressionValue(id, "");
        aFc1eSDK.equals = new AFb1gSDK(scope, id);
    }

    @Override // com.appsflyer.internal.AFb1bSDK
    public final boolean getMonetizationNetwork() {
        return !this.AFAdRevenueData.getMonetizationNetwork() && !this.getMonetizationNetwork.getMediationNetwork() && AFj1iSDK.getRevenue(this.getRevenue.getRevenue) && AFj1iSDK.getMonetizationNetwork(this.getRevenue.getRevenue);
    }
}
