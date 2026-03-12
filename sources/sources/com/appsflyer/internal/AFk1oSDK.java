package com.appsflyer.internal;
/* loaded from: classes.dex */
public class AFk1oSDK {
    public static void AFAdRevenueData(byte[] bArr, byte b, long j) {
        for (int i = 0; i < bArr.length; i++) {
            if (((1 << i) & j) != 0) {
                bArr[i] = (byte) (bArr[i] ^ b);
            }
        }
    }
}
