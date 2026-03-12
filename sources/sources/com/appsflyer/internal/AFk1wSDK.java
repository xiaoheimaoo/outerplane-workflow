package com.appsflyer.internal;

import com.appsflyer.AppsFlyerLib;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFk1wSDK implements AFk1ySDK {
    @Override // com.appsflyer.internal.AFk1ySDK
    public final String getCurrencyIso4217Code(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String format = String.format(str, AppsFlyerLib.getInstance().getHostPrefix(), AFa1uSDK.getMonetizationNetwork().getHostName());
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }
}
