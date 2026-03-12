package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyg  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzyg {
    private ECPrivateKey zza;

    public zzyg(ECPrivateKey eCPrivateKey) {
        this.zza = eCPrivateKey;
    }

    public final byte[] zza(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i, zzyk zzykVar) throws GeneralSecurityException {
        int i2 = 1;
        byte[] zza = zzyc.zza(bArr, zzyi.zza(this.zza, zzyi.zza(this.zza.getParams(), zzykVar, bArr)));
        Mac zza2 = zzym.zzb.zza(str);
        if (i > zza2.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (bArr2 == null || bArr2.length == 0) {
            zza2.init(new SecretKeySpec(new byte[zza2.getMacLength()], str));
        } else {
            zza2.init(new SecretKeySpec(bArr2, str));
        }
        byte[] doFinal = zza2.doFinal(zza);
        byte[] bArr4 = new byte[i];
        zza2.init(new SecretKeySpec(doFinal, str));
        byte[] bArr5 = new byte[0];
        int i3 = 0;
        while (true) {
            zza2.update(bArr5);
            zza2.update(bArr3);
            zza2.update((byte) i2);
            bArr5 = zza2.doFinal();
            if (bArr5.length + i3 < i) {
                System.arraycopy(bArr5, 0, bArr4, i3, bArr5.length);
                i3 += bArr5.length;
                i2++;
            } else {
                System.arraycopy(bArr5, 0, bArr4, i3, i - i3);
                return bArr4;
            }
        }
    }
}
