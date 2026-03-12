package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdr;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzky  reason: invalid package */
/* loaded from: classes2.dex */
final class zzky implements zzla {
    private final int zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzla
    public final int zza() {
        return this.zza;
    }

    public zzky(zzdr zzdrVar) throws GeneralSecurityException {
        if (zzdrVar.zzb() != 12) {
            throw new GeneralSecurityException("invalid IV size");
        }
        if (zzdrVar.zzd() != 16) {
            throw new GeneralSecurityException("invalid tag size");
        }
        if (zzdrVar.zzf() != zzdr.zza.zzc) {
            throw new GeneralSecurityException("invalid variant");
        }
        this.zza = zzdrVar.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzla
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (bArr.length != this.zza) {
            throw new GeneralSecurityException("invalid key size");
        }
        SecretKey zzb = zzgl.zzb(bArr);
        int i2 = i + 12;
        if (bArr2.length < i2 + 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec zza = zzgl.zza(bArr2, i, 12);
        Cipher zza2 = zzgl.zza();
        zza2.init(2, zzb, zza);
        return zza2.doFinal(bArr2, i2, (bArr2.length - i) - 12);
    }
}
