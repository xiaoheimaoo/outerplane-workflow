package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzwb;
import java.security.GeneralSecurityException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznk  reason: invalid package */
/* loaded from: classes2.dex */
public final class zznk<P> extends zznl<P> implements zzci<P> {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzci
    public final zzwb zzc(zzaiw zzaiwVar) throws GeneralSecurityException {
        zzbo zza = zzom.zza().zza((zzom) zzpn.zza(this.zza, zzaiwVar, this.zzb, zzxd.RAW, null), zzbl.zza());
        if (!(zza instanceof zzcf)) {
            throw new GeneralSecurityException("Key not private key");
        }
        zzpn zzpnVar = (zzpn) zzom.zza().zza(((zzcf) zza).zzb(), zzpn.class, zzbl.zza());
        return (zzwb) ((zzakg) zzwb.zza().zza(zzpnVar.zzf()).zza(zzpnVar.zzd()).zza(zzpnVar.zza()).zze());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zznk(String str, Class<P> cls, zzalw<? extends zzaln> zzalwVar) {
        super(str, cls, zzwb.zza.ASYMMETRIC_PRIVATE, zzalwVar);
    }
}
