package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhm  reason: invalid package */
/* loaded from: classes2.dex */
abstract class zzhm {
    int[] zza;
    private final int zzb;

    abstract int zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteBuffer zza(byte[] bArr, int i) {
        int[] zza = zza(zzhh.zza(bArr), i);
        int[] iArr = (int[]) zza.clone();
        zzhh.zza(iArr);
        for (int i2 = 0; i2 < zza.length; i2++) {
            zza[i2] = zza[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zza, 0, 16);
        return order;
    }

    abstract int[] zza(int[] iArr, int i);

    public zzhm(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = zzhh.zza(bArr);
        this.zzb = i;
    }

    public void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        zza(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
    }

    private final void zza(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length != zza()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza());
        }
        int remaining = byteBuffer2.remaining();
        int i = (remaining / 64) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer zza = zza(bArr, this.zzb + i2);
            if (i2 == i - 1) {
                zzyc.zza(byteBuffer, byteBuffer2, zza, remaining % 64);
            } else {
                zzyc.zza(byteBuffer, byteBuffer2, zza, 64);
            }
        }
    }

    public byte[] zza(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        zza(bArr, allocate, byteBuffer);
        return allocate.array();
    }
}
