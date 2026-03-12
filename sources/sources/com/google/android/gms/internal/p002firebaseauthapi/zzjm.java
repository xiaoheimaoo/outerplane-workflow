package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdc;
import com.google.android.gms.internal.p002firebaseauthapi.zzdr;
import com.google.android.gms.internal.p002firebaseauthapi.zzij;
import com.google.android.gms.internal.p002firebaseauthapi.zzjq;
import com.google.android.gms.internal.p002firebaseauthapi.zzwb;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.HashMap;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjm  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzjm {
    private static final zzoy<zzjt, zzbj> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjl
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzye.zza((zzjt) zzboVar);
        }
    }, zzjt.class, zzbj.class);
    private static final zzoy<zzjs, zzbm> zzb = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjo
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzyh.zza((zzjs) zzboVar);
        }
    }, zzjs.class, zzbm.class);
    private static final zzci<zzbj> zzc = zznl.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzbj.class, zzun.zzf());
    private static final zzbn<zzbm> zzd = zznl.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzbm.class, zzwb.zza.ASYMMETRIC_PUBLIC, zzuq.zzh());
    private static final zzoe<zzjq> zze = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjn
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzjm.zza((zzjq) zzcgVar, num);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public static /* synthetic */ zzjt zza(zzjq zzjqVar, Integer num) {
        ECParameterSpec eCParameterSpec;
        zzjq.zza zzd2 = zzjqVar.zzd();
        if (zzd2 == zzjq.zza.zza) {
            eCParameterSpec = zzmt.zza;
        } else if (zzd2 == zzjq.zza.zzb) {
            eCParameterSpec = zzmt.zzb;
        } else if (zzd2 == zzjq.zza.zzc) {
            eCParameterSpec = zzmt.zzc;
        } else {
            throw new GeneralSecurityException("Unsupported curve type: " + String.valueOf(zzd2));
        }
        KeyPair zza2 = zzyi.zza(eCParameterSpec);
        return zzjt.zza(zzjs.zza(zzjqVar, ((ECPublicKey) zza2.getPublic()).getW(), num), zzzm.zza(((ECPrivateKey) zza2.getPrivate()).getS(), zzbl.zza()));
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering ECIES Hybrid Encryption is not supported in FIPS mode");
        }
        zzld.zza();
        zzok zza2 = zzok.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzjq.zzc().zza(zzjq.zza.zza).zza(zzjq.zzd.zzc).zza(zzjq.zzc.zzb).zza(zzjq.zze.zza).zza(zzdr.zze().zza(12).zzb(16).zzc(16).zza(zzdr.zza.zzc).zza()).zza());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzjq.zzc().zza(zzjq.zza.zza).zza(zzjq.zzd.zzc).zza(zzjq.zzc.zzb).zza(zzjq.zze.zzc).zza(zzdr.zze().zza(12).zzb(16).zzc(16).zza(zzdr.zza.zzc).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzjq.zzc().zza(zzjq.zza.zza).zza(zzjq.zzd.zzc).zza(zzjq.zzc.zza).zza(zzjq.zze.zza).zza(zzdr.zze().zza(12).zzb(16).zzc(16).zza(zzdr.zza.zzc).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzjq.zzc().zza(zzjq.zza.zza).zza(zzjq.zzd.zzc).zza(zzjq.zzc.zza).zza(zzjq.zze.zzc).zza(zzdr.zze().zza(12).zzb(16).zzc(16).zza(zzdr.zza.zzc).zza()).zza());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzjq.zzc().zza(zzjq.zza.zza).zza(zzjq.zzd.zzc).zza(zzjq.zzc.zza).zza(zzjq.zze.zzc).zza(zzdr.zze().zza(12).zzb(16).zzc(16).zza(zzdr.zza.zzc).zza()).zza());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzjq.zzc().zza(zzjq.zza.zza).zza(zzjq.zzd.zzc).zza(zzjq.zzc.zzb).zza(zzjq.zze.zza).zza(zzdc.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdc.zza.zzc).zza(zzdc.zzc.zzc).zza()).zza());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzjq.zzc().zza(zzjq.zza.zza).zza(zzjq.zzd.zzc).zza(zzjq.zzc.zzb).zza(zzjq.zze.zzc).zza(zzdc.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdc.zza.zzc).zza(zzdc.zzc.zzc).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzjq.zzc().zza(zzjq.zza.zza).zza(zzjq.zzd.zzc).zza(zzjq.zzc.zza).zza(zzjq.zze.zza).zza(zzdc.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdc.zza.zzc).zza(zzdc.zzc.zzc).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzjq.zzc().zza(zzjq.zza.zza).zza(zzjq.zzd.zzc).zza(zzjq.zzc.zza).zza(zzjq.zze.zzc).zza(zzdc.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdc.zza.zzc).zza(zzdc.zzc.zzc).zza()).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzon.zza().zza(zza);
        zzon.zza().zza(zzb);
        zzoc.zza().zza(zze, zzjq.class);
        zzna.zza().zza((zzbn) zzc, true);
        zzna.zza().zza((zzbn) zzd, false);
    }
}
