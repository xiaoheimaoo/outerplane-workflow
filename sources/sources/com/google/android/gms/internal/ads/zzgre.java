package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzgre implements zzggy {
    private static final zzgre zza = new zzgre();
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgrb
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzggc zzggcVar) {
            return zzgrt.zza((zzgno) zzggcVar);
        }
    }, zzgno.class, zzggp.class);

    zzgre() {
    }

    public static void zzd() throws GeneralSecurityException {
        zzghb.zzf(zza);
        zzgob.zza().zze(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzggy
    public final Class zza() {
        return zzggp.class;
    }

    @Override // com.google.android.gms.internal.ads.zzggy
    public final Class zzb() {
        return zzggp.class;
    }

    @Override // com.google.android.gms.internal.ads.zzggy
    public final /* bridge */ /* synthetic */ Object zzc(zzggx zzggxVar) throws GeneralSecurityException {
        for (List<zzggt> list : zzggxVar.zzd()) {
            for (zzggt zzggtVar : list) {
                if (zzggtVar.zzb() instanceof zzgqz) {
                    zzgqz zzgqzVar = (zzgqz) zzggtVar.zzb();
                    zzgxq zzb2 = zzgxq.zzb(zzggtVar.zzg());
                    if (!zzb2.equals(zzgqzVar.zzc())) {
                        String valueOf = String.valueOf(zzgqzVar.zzb());
                        String obj = zzgqzVar.zzc().toString();
                        String obj2 = zzb2.toString();
                        throw new GeneralSecurityException("Mac Key with parameters " + valueOf + " has wrong output prefix (" + obj + ") instead of (" + obj2 + ")");
                    }
                }
            }
        }
        return new zzgrd(zzggxVar, null);
    }
}
