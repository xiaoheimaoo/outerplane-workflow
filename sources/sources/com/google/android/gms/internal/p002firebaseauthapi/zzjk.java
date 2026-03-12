package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjk  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzjk implements zzbk {
    private final zzbk zza;
    private final zzxd zzb;
    private final byte[] zzc;

    public static zzbk zza(zznn zznnVar) throws GeneralSecurityException {
        byte[] zzb;
        zzpn zza = zznnVar.zza(zzbl.zza());
        zzpr.zza();
        zzbk zzbkVar = (zzbk) zzpr.zza((zzwb) ((zzakg) zzwb.zza().zza(zza.zzf()).zza(zza.zzd()).zza(zza.zza()).zze()), zzbk.class);
        zzxd zzc = zza.zzc();
        int i = zzjj.zza[zzc.ordinal()];
        if (i == 1) {
            zzb = zzor.zza.zzb();
        } else if (i == 2 || i == 3) {
            zzb = zzor.zza(zznnVar.zza().intValue()).zzb();
        } else if (i == 4) {
            zzb = zzor.zzb(zznnVar.zza().intValue()).zzb();
        } else {
            throw new GeneralSecurityException("unknown output prefix type " + zzc.zza());
        }
        return new zzjk(zzbkVar, zzc, zzb);
    }

    private zzjk(zzbk zzbkVar, zzxd zzxdVar, byte[] bArr) {
        this.zza = zzbkVar;
        this.zzb = zzxdVar;
        this.zzc = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbk
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (this.zzb == zzxd.RAW) {
            return this.zza.zza(bArr, bArr2);
        }
        if (!zzpy.zza(this.zzc, bArr)) {
            throw new GeneralSecurityException("wrong prefix");
        }
        return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
    }
}
