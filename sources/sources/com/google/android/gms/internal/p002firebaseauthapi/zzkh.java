package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkh  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzkh {
    private static final zzmz zza = zzb();

    public static zzbf zza() throws GeneralSecurityException {
        if (zzij.zzb()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant HybridConfigurationV0 in FIPS mode");
        }
        return zza;
    }

    private static zzmz zzb() {
        try {
            zzpf zza2 = zzpc.zza();
            zzkp.zza(zza2);
            zza2.zza(zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkg
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
                public final Object zza(zzbo zzboVar) {
                    return zzyh.zza((zzjs) zzboVar);
                }
            }, zzjs.class, zzbm.class));
            zza2.zza(zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkj
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
                public final Object zza(zzbo zzboVar) {
                    return zzlm.zza((zzkf) zzboVar);
                }
            }, zzkf.class, zzbm.class));
            zzkk.zza(zza2);
            zza2.zza(zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzki
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
                public final Object zza(zzbo zzboVar) {
                    return zzye.zza((zzjt) zzboVar);
                }
            }, zzjt.class, zzbj.class));
            zza2.zza(zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkl
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
                public final Object zza(zzbo zzboVar) {
                    return zzln.zza((zzjx) zzboVar);
                }
            }, zzjx.class, zzbj.class));
            return zzmz.zza(zza2.zza());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
