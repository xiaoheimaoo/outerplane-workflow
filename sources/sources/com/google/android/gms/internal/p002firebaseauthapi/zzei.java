package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzij;
import com.google.android.gms.internal.p002firebaseauthapi.zzwb;
import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzei  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzei {
    private static final zzoy<zzen, zzbe> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeh
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            zzbe zza2;
            zza2 = zzhs.zza(zzcb.zza(r1.zzb().zzc()).zza(r1.zzb().zzc()), ((zzen) zzboVar).zzc());
            return zza2;
        }
    }, zzen.class, zzbe.class);
    private static final zzbn<zzbe> zzb = zznl.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzbe.class, zzwb.zza.REMOTE, zzwr.zze());
    private static final zzoe<zzep> zzc = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzek
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            zzen zza2;
            zza2 = zzen.zza((zzep) zzcgVar, num);
            return zza2;
        }
    };

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
        }
        zzer.zza();
        zzon.zza().zza(zza);
        zzoc.zza().zza(zzc, zzep.class);
        zzna.zza().zza((zzbn) zzb, true);
    }
}
