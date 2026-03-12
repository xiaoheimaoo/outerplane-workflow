package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfy;
import com.google.android.gms.internal.p002firebaseauthapi.zzij;
import com.google.android.gms.internal.p002firebaseauthapi.zzwb;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfu  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzfu {
    private static final zzoy<zzfv, zzbe> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfx
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzfu.zza((zzfv) zzboVar);
        }
    }, zzfv.class, zzbe.class);
    private static final zzbn<zzbe> zzb = zznl.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzbe.class, zzwb.zza.SYMMETRIC, zzxo.zze());
    private static final zzog<zzfy> zzc = new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfw
    };
    private static final zzoe<zzfy> zzd = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfz
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzfu.zza((zzfy) zzcgVar, num);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public static /* synthetic */ zzbe zza(zzfv zzfvVar) {
        if (zzic.zza()) {
            return zzic.zza(zzfvVar);
        }
        return zzzk.zza(zzfvVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfv zza(zzfy zzfyVar, @Nullable Integer num) throws GeneralSecurityException {
        return zzfv.zza(zzfyVar.zzb(), zzzo.zza(32), num);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
        }
        zzib.zza();
        zzon.zza().zza(zza);
        zzok zza2 = zzok.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", zzfy.zza(zzfy.zza.zza));
        hashMap.put("XCHACHA20_POLY1305_RAW", zzfy.zza(zzfy.zza.zzc));
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzoc.zza().zza(zzd, zzfy.class);
        zzoh.zza().zza(zzc, zzfy.class);
        zzna.zza().zza((zzbn) zzb, true);
    }
}
