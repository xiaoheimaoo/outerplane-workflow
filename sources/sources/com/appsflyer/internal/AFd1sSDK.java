package com.appsflyer.internal;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFd1sSDK {
    public static boolean getCurrencyIso4217Code(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        int mediationNetwork = AFk1zSDK.getMediationNetwork(str);
        int mediationNetwork2 = AFk1zSDK.getMediationNetwork(str2);
        Pair<Integer, Integer> currencyIso4217Code = AFd1rSDK.getCurrencyIso4217Code(str2);
        Pair<Integer, Integer> monetizationNetwork = AFd1rSDK.getMonetizationNetwork(str2);
        return (mediationNetwork2 == -1 || currencyIso4217Code != null) ? monetizationNetwork != null ? monetizationNetwork.getFirst().intValue() <= mediationNetwork && mediationNetwork <= monetizationNetwork.getSecond().intValue() : currencyIso4217Code != null && currencyIso4217Code.getFirst().intValue() <= mediationNetwork && mediationNetwork <= currencyIso4217Code.getSecond().intValue() : mediationNetwork2 == mediationNetwork;
    }
}
