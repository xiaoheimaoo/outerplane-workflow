package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzny  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzny {
    public static final zznv zza = new zzoa();

    public static <P> zznu zza(zzpg<P> zzpgVar) {
        zzbq zzbqVar;
        zznx zznxVar = new zznx();
        zznxVar.zza(zzpgVar.zza());
        for (List<zzpi<P>> list : zzpgVar.zzd()) {
            for (zzpi<P> zzpiVar : list) {
                int i = zzob.zza[zzpiVar.zzb().ordinal()];
                if (i == 1) {
                    zzbqVar = zzbq.zza;
                } else if (i == 2) {
                    zzbqVar = zzbq.zzb;
                } else if (i == 3) {
                    zzbqVar = zzbq.zzc;
                } else {
                    throw new IllegalStateException("Unknown key status");
                }
                int zza2 = zzpiVar.zza();
                String zze = zzpiVar.zze();
                if (zze.startsWith("type.googleapis.com/google.crypto.")) {
                    zze = zze.substring(34);
                }
                zznxVar.zza(zzbqVar, zza2, zze, zzpiVar.zzc().name());
            }
        }
        if (zzpgVar.zzb() != null) {
            zznxVar.zza(zzpgVar.zzb().zza());
        }
        try {
            return zznxVar.zza();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
