package com.appsflyer.internal;
/* loaded from: classes.dex */
public final class AFk1gSDK {
    public int getCurrencyIso4217Code;
    public int getMediationNetwork;

    public static char[] getCurrencyIso4217Code(long j, char[] cArr, int i) {
        int length = cArr.length;
        char[] cArr2 = new char[length];
        int i2 = 0;
        int i3 = 4;
        for (int i4 = 0; i4 < cArr.length; i4++) {
            if (((j >>> i4) & 1) == i && i2 < 4) {
                cArr2[i2] = cArr[i4];
            } else if (i3 < length) {
                cArr2[i3] = cArr[i4];
                i3++;
            } else {
                cArr2[i2] = cArr[i4];
            }
            i2++;
        }
        return cArr2;
    }
}
