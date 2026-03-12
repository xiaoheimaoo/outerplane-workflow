package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqk  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzqk implements zzpk<zzqh, zzqh> {
    private static final zzqk zza = new zzqk();

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzqh> zza() {
        return zzqh.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final Class<zzqh> zzb() {
        return zzqh.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpk
    public final /* synthetic */ zzqh zza(zzpg<zzqh> zzpgVar) throws GeneralSecurityException {
        if (zzpgVar == null) {
            throw new GeneralSecurityException("primitive set must be non-null");
        }
        if (zzpgVar.zzb() == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        for (List<zzpi<zzqh>> list : zzpgVar.zzd()) {
            for (zzpi<zzqh> zzpiVar : list) {
                zzpiVar.zzd();
            }
        }
        return new zzqj(zzpgVar);
    }

    private zzqk() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc() throws GeneralSecurityException {
        zzon.zza().zza(zza);
    }
}
