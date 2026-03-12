package com.helpshift.util.network.connectivity;

import android.content.Context;
/* loaded from: classes3.dex */
public class HSAndroidConnectivityManagerProvider {
    public HSAndroidConnectivityManager getOSConnectivityManager(Context context) {
        return new HSOnAndAboveNConnectivityManager(context);
    }
}
