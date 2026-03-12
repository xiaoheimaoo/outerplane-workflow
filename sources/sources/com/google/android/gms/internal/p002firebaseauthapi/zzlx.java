package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlx  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzlx implements zzbj {
    private final zzbj zza;
    private final byte[] zzb;

    public static zzbj zza(zznn zznnVar) throws GeneralSecurityException {
        byte[] zzb;
        zzpn zza = zznnVar.zza(zzbl.zza());
        zzbj zzbjVar = (zzbj) zzcj.zza((zzwb) ((zzakg) zzwb.zza().zza(zza.zzf()).zza(zza.zzd()).zza(zza.zza()).zze()), zzbj.class);
        zzxd zzc = zza.zzc();
        int i = zzlw.zza[zzc.ordinal()];
        if (i == 1) {
            zzb = zzor.zza.zzb();
        } else if (i == 2 || i == 3) {
            zzb = zzor.zza(zznnVar.zza().intValue()).zzb();
        } else if (i == 4) {
            zzb = zzor.zzb(zznnVar.zza().intValue()).zzb();
        } else {
            throw new GeneralSecurityException("unknown output prefix type " + String.valueOf(zzc));
        }
        return new zzlx(zzbjVar, zzb);
    }

    private zzlx(zzbj zzbjVar, byte[] bArr) {
        this.zza = zzbjVar;
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbj
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (!zzpy.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        return this.zza.zza(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
    }
}
