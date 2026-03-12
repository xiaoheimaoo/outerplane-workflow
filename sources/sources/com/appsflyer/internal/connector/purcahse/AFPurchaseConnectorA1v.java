package com.appsflyer.internal.connector.purcahse;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFPurchaseConnectorA1v implements Application.ActivityLifecycleCallbacks {
    private boolean InAppPurchaseEvent;
    private final ScheduledExecutorService getOneTimePurchaseOfferDetails;
    private final AFPurchaseConnectorA1y getPackageName;
    private long getQuantity;
    private boolean toJsonMap;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(bundle, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    public AFPurchaseConnectorA1v(AFPurchaseConnectorA1y aFPurchaseConnectorA1y, ScheduledExecutorService scheduledExecutorService) {
        Intrinsics.checkNotNullParameter(aFPurchaseConnectorA1y, "");
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "");
        this.getPackageName = aFPurchaseConnectorA1y;
        this.getOneTimePurchaseOfferDetails = scheduledExecutorService;
        this.getQuantity = 500L;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        if (!this.InAppPurchaseEvent) {
            try {
                this.getPackageName.toJsonMap();
            } catch (Exception e) {
                AFLogger.afErrorLog("Listener thrown an exception: ", e, true);
            }
        }
        this.toJsonMap = false;
        this.InAppPurchaseEvent = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.toJsonMap = true;
        try {
            this.getOneTimePurchaseOfferDetails.schedule(new Runnable() { // from class: com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1v$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AFPurchaseConnectorA1v.getQuantity(AFPurchaseConnectorA1v.this);
                }
            }, this.getQuantity, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            AFLogger.afErrorLog("Background task failed with a throwable: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getQuantity(AFPurchaseConnectorA1v aFPurchaseConnectorA1v) {
        Intrinsics.checkNotNullParameter(aFPurchaseConnectorA1v, "");
        if (aFPurchaseConnectorA1v.InAppPurchaseEvent && aFPurchaseConnectorA1v.toJsonMap) {
            aFPurchaseConnectorA1v.InAppPurchaseEvent = false;
        }
    }
}
