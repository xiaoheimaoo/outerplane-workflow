package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFj1qSDK;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public final class AFj1rSDK {
    public final CopyOnWriteArrayList<AFj1qSDK> getCurrencyIso4217Code = new CopyOnWriteArrayList<>();
    public final AFc1bSDK getMonetizationNetwork;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void getMonetizationNetwork() {
    }

    public AFj1rSDK(AFc1bSDK aFc1bSDK) {
        this.getMonetizationNetwork = aFc1bSDK;
    }

    public final void AFAdRevenueData(final Context context, final Runnable runnable, final AFc1bSDK aFc1bSDK) {
        aFc1bSDK.getMediationNetwork().execute(new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AFj1rSDK.this.getRevenue(context, runnable, aFc1bSDK);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getRevenue(Context context, Runnable runnable, AFc1bSDK aFc1bSDK) {
        List<ResolveInfo> queryIntentContentProviders = context.getPackageManager().queryIntentContentProviders(new Intent("com.appsflyer.referrer.INSTALL_PROVIDER"), 0);
        if (queryIntentContentProviders == null || queryIntentContentProviders.isEmpty()) {
            return;
        }
        ArrayList<AFj1qSDK> arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentContentProviders) {
            ProviderInfo providerInfo = resolveInfo.providerInfo;
            if (providerInfo != null) {
                arrayList.add(new AFj1sSDK(providerInfo, runnable, aFc1bSDK));
            } else {
                AFLogger.INSTANCE.w(AFg1cSDK.PREINSTALL, "com.appsflyer.referrer.INSTALL_PROVIDER Action is set for non ContentProvider component");
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.getCurrencyIso4217Code.addAll(arrayList);
        AFLogger.INSTANCE.d(AFg1cSDK.PREINSTALL, new StringBuilder("Detected ").append(arrayList.size()).append(" valid preinstall provider(s)").toString());
        for (AFj1qSDK aFj1qSDK : arrayList) {
            aFj1qSDK.getCurrencyIso4217Code(aFc1bSDK.registerClient().getRevenue);
        }
    }

    public final void getMediationNetwork(final Runnable runnable) {
        this.getCurrencyIso4217Code.add(new AFj1wSDK(this.getMonetizationNetwork.getCurrencyIso4217Code(), this.getMonetizationNetwork.getMediationNetwork(), AFj1xSDK.FACEBOOK, runnable, new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AFj1rSDK.this.component4(runnable);
            }
        }));
    }

    public final AFi1bSDK getMonetizationNetwork(final Runnable runnable) {
        return new AFi1bSDK(new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AFj1rSDK.this.getCurrencyIso4217Code(runnable);
            }
        }, this.getMonetizationNetwork.getMediationNetwork(), this.getMonetizationNetwork.getCurrencyIso4217Code());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getCurrencyIso4217Code(final Runnable runnable) {
        this.getMonetizationNetwork.getMediationNetwork().execute(new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AFj1rSDK.this.getRevenue(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getRevenue(Runnable runnable) {
        try {
            if (AFAdRevenueData(new AFh1kSDK())) {
                runnable.run();
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
        }
    }

    public final boolean AFAdRevenueData(AFh1jSDK aFh1jSDK) {
        int mediationNetwork = this.getMonetizationNetwork.getCurrencyIso4217Code().getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0);
        return (!this.getMonetizationNetwork.component2().getMediationNetwork(AppsFlyerProperties.NEW_REFERRER_SENT, false) && mediationNetwork == 1) || (mediationNetwork == 1 && !(aFh1jSDK instanceof AFh1kSDK));
    }

    public final Runnable getRevenue(final AFi1bSDK aFi1bSDK, final Runnable runnable) {
        return new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                AFj1rSDK.this.getMediationNetwork(aFi1bSDK, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getMediationNetwork(AFi1bSDK aFi1bSDK, Runnable runnable) {
        AFc1oSDK component2 = this.getMonetizationNetwork.component2();
        int mediationNetwork = this.getMonetizationNetwork.getCurrencyIso4217Code().getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0);
        boolean mediationNetwork2 = component2.getMediationNetwork(AppsFlyerProperties.NEW_REFERRER_SENT, false);
        boolean z = aFi1bSDK.areAllFieldsValid == AFj1qSDK.AFa1vSDK.NOT_STARTED;
        if (mediationNetwork == 1) {
            if (z || mediationNetwork2) {
                runnable.run();
            }
        }
    }

    public final boolean getMediationNetwork() {
        return this.getMonetizationNetwork.getCurrencyIso4217Code().getRevenue("AF_PREINSTALL_DISABLED");
    }

    public final boolean getRevenue() {
        Iterator<AFj1qSDK> it = this.getCurrencyIso4217Code.iterator();
        while (it.hasNext()) {
            if (it.next().areAllFieldsValid == AFj1qSDK.AFa1vSDK.STARTED) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AFAdRevenueData(Runnable runnable) {
        AFj1wSDK aFj1wSDK = new AFj1wSDK(this.getMonetizationNetwork.getCurrencyIso4217Code(), this.getMonetizationNetwork.getMediationNetwork(), AFj1xSDK.FACEBOOK_LITE, runnable, new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AFj1rSDK.getMonetizationNetwork();
            }
        });
        this.getCurrencyIso4217Code.add(aFj1wSDK);
        aFj1wSDK.getCurrencyIso4217Code(this.getMonetizationNetwork.registerClient().getRevenue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void component4(final Runnable runnable) {
        AFj1wSDK aFj1wSDK = new AFj1wSDK(this.getMonetizationNetwork.getCurrencyIso4217Code(), this.getMonetizationNetwork.getMediationNetwork(), AFj1xSDK.INSTAGRAM, runnable, new Runnable() { // from class: com.appsflyer.internal.AFj1rSDK$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AFj1rSDK.this.AFAdRevenueData(runnable);
            }
        });
        this.getCurrencyIso4217Code.add(aFj1wSDK);
        aFj1wSDK.getCurrencyIso4217Code(this.getMonetizationNetwork.registerClient().getRevenue);
    }
}
