package com.appsflyer.internal;

import android.content.Intent;
import android.net.Uri;
/* loaded from: classes.dex */
public final class AFb1tSDK {
    public static Uri k_(Intent intent) {
        if (intent == null) {
            return null;
        }
        AFj1kSDK aFj1kSDK = new AFj1kSDK(intent);
        Uri uri = (Uri) aFj1kSDK.H_("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String currencyIso4217Code = aFj1kSDK.getCurrencyIso4217Code("android.intent.extra.REFERRER_NAME");
        if (currencyIso4217Code != null) {
            return Uri.parse(currencyIso4217Code);
        }
        return null;
    }
}
