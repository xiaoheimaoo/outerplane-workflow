package com.appsflyer.internal;

import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class AFk1sSDK {
    public final WeakReference<Context> AFAdRevenueData;
    public String getMonetizationNetwork;

    public AFk1sSDK(Context context) {
        this.AFAdRevenueData = new WeakReference<>(context);
    }
}
