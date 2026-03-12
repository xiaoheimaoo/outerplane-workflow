package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlz  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzlz implements zzbm {
    public static zzbm zza(zznn zznnVar) throws GeneralSecurityException {
        byte[] zzb;
        zzpn zza = zznnVar.zza(zzbl.zza());
        zzbm zzbmVar = (zzbm) zzcj.zza((zzwb) ((zzakg) zzwb.zza().zza(zza.zzf()).zza(zza.zzd()).zza(zza.zza()).zze()), zzbm.class);
        zzxd zzc = zza.zzc();
        int i = zzly.zza[zzc.ordinal()];
        if (i == 1) {
            zzb = zzor.zza.zzb();
        } else if (i == 2 || i == 3) {
            zzb = zzor.zza(zznnVar.zza().intValue()).zzb();
        } else if (i == 4) {
            zzb = zzor.zzb(zznnVar.zza().intValue()).zzb();
        } else {
            throw new GeneralSecurityException("unknown output prefix type " + String.valueOf(zzc));
        }
        return new zzlz(zzbmVar, zzb);
    }

    private zzlz(zzbm zzbmVar, byte[] bArr) {
    }
}
