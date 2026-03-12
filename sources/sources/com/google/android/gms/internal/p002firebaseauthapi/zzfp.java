package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfp  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzfp {
    private static final zzoe<zzft> zza = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfs
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            zzfq zza2;
            zza2 = zzfq.zza((zzft) zzcgVar, zzzo.zza(32), num);
            return zza2;
        }
    };
    private static final zzoy<zzfq, zzbe> zzb = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfr
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzht.zza((zzfq) zzboVar);
        }
    }, zzfq.class, zzbe.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        zzhw.zza();
        zzok zza2 = zzok.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("XAES_256_GCM_192_BIT_NONCE", zzfg.zzg);
        hashMap.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzfg.zzh);
        hashMap.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzfg.zzi);
        hashMap.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzfg.zzj);
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzon.zza().zza(zzb);
        zzoc.zza().zza(zza, zzft.class);
    }
}
