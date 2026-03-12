package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
/* loaded from: classes.dex */
public enum AFh1uSDK {
    application,
    activity,
    other;

    public static AFh1uSDK getRevenue(Context context) {
        if (context instanceof Activity) {
            return activity;
        }
        if (context instanceof Application) {
            return application;
        }
        return other;
    }
}
