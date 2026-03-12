package com.appsflyer.internal;
/* loaded from: classes.dex */
public final class AFk1dSDK {
    public int AFAdRevenueData;
    public int getCurrencyIso4217Code;
    public int getMonetizationNetwork;

    public static void AFAdRevenueData(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }

    public static int getCurrencyIso4217Code(int i) {
        AFk1tSDK aFk1tSDK = AFk1tSDK.getMediationNetwork;
        return ((aFk1tSDK.getMonetizationNetwork[0][(i >>> 24) & 255] + aFk1tSDK.getMonetizationNetwork[1][(i >>> 16) & 255]) ^ aFk1tSDK.getMonetizationNetwork[2][(i >>> 8) & 255]) + aFk1tSDK.getMonetizationNetwork[3][i & 255];
    }
}
