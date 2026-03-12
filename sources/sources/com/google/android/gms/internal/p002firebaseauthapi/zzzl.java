package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.primitives.SignedBytes;
import java.security.InvalidKeyException;
import java.util.Arrays;
import okio.Utf8;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzl  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzzl {
    public static byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] copyOf = Arrays.copyOf(bArr, 32);
        copyOf[0] = (byte) (copyOf[0] & 248);
        byte b = (byte) (copyOf[31] & Byte.MAX_VALUE);
        copyOf[31] = b;
        copyOf[31] = (byte) (b | SignedBytes.MAX_POWER_OF_TWO);
        zzmq.zza(jArr, copyOf, bArr2);
        return zzmw.zzc(jArr);
    }

    public static byte[] zza() {
        byte[] zza = zzpp.zza(32);
        zza[0] = (byte) (zza[0] | 7);
        byte b = (byte) (zza[31] & Utf8.REPLACEMENT_BYTE);
        zza[31] = b;
        zza[31] = (byte) (b | 128);
        return zza;
    }

    public static byte[] zza(byte[] bArr) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        byte[] bArr2 = new byte[32];
        bArr2[0] = 9;
        return zza(bArr, bArr2);
    }
}
