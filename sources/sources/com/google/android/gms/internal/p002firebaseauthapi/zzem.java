package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzij;
import com.google.android.gms.internal.p002firebaseauthapi.zzwb;
import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzem  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzem {
    private static final zzbn<zzbe> zza = zznl.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzbe.class, zzwb.zza.SYMMETRIC, zzwx.zze());
    private static final zzoe<zzew> zzb = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzel
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            zzex zza2;
            zza2 = zzex.zza((zzew) zzcgVar, num);
            return zza2;
        }
    };
    private static final zzoy<zzex, zzbe> zzc = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeo
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzem.zza((zzex) zzboVar);
        }
    }, zzex.class, zzbe.class);

    public static /* synthetic */ zzbe zza(zzex zzexVar) {
        String zzd = zzexVar.zzb().zzd();
        return zzhs.zza(zzej.zza(zzexVar.zzb().zzb(), zzcb.zza(zzd).zza(zzd)), zzexVar.zzc());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
        }
        zzfa.zza();
        zzoc.zza().zza(zzb, zzew.class);
        zzon.zza().zza(zzc);
        zzna.zza().zza((zzbn) zza, true);
    }
}
