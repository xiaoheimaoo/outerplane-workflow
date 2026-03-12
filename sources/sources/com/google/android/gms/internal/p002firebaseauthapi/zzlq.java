package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzij;
import com.google.android.gms.internal.p002firebaseauthapi.zzju;
import com.google.android.gms.internal.p002firebaseauthapi.zzwb;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlq  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzlq {
    private static final zzoy<zzjx, zzbj> zza = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlt
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzln.zza((zzjx) zzboVar);
        }
    }, zzjx.class, zzbj.class);
    private static final zzoy<zzkf, zzbm> zzb = zzoy.zza(new zzpa() { // from class: com.google.android.gms.internal.firebase-auth-api.zzls
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpa
        public final Object zza(zzbo zzboVar) {
            return zzlm.zza((zzkf) zzboVar);
        }
    }, zzkf.class, zzbm.class);
    private static final zzci<zzbj> zzc = zznl.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", zzbj.class, zzvv.zzf());
    private static final zzbn<zzbm> zzd = zznl.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey", zzbm.class, zzwb.zza.ASYMMETRIC_PUBLIC, zzvy.zzg());
    private static final zzoe<zzju> zze = new zzoe() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlv
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoe
        public final zzbo zza(zzcg zzcgVar, Integer num) {
            return zzlq.zza((zzju) zzcgVar, num);
        }
    };

    public static /* synthetic */ zzjx zza(zzju zzjuVar, Integer num) {
        byte[] bArr;
        zzzn zza2;
        zzzo zza3;
        if (zzjuVar.zze().equals(zzju.zzd.zzd)) {
            byte[] zza4 = zzzl.zza();
            zza3 = zzzo.zza(zza4, zzbl.zza());
            zza2 = zzzn.zza(zzzl.zza(zza4));
        } else if (zzjuVar.zze().equals(zzju.zzd.zza) || zzjuVar.zze().equals(zzju.zzd.zzb) || zzjuVar.zze().equals(zzju.zzd.zzc)) {
            zzyl zzc2 = zzlu.zzc(zzjuVar.zze());
            KeyPair zza5 = zzyi.zza(zzyi.zza(zzc2));
            zzyk zzykVar = zzyk.UNCOMPRESSED;
            ECPoint w = ((ECPublicKey) zza5.getPublic()).getW();
            EllipticCurve curve = zzyi.zza(zzc2).getCurve();
            zzmt.zza(w, curve);
            int zza6 = zzyi.zza(curve);
            int ordinal = zzykVar.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    int i = zza6 + 1;
                    bArr = new byte[i];
                    byte[] zza7 = zzmo.zza(w.getAffineX());
                    System.arraycopy(zza7, 0, bArr, i - zza7.length, zza7.length);
                    bArr[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                } else if (ordinal == 2) {
                    int i2 = zza6 * 2;
                    bArr = new byte[i2];
                    byte[] zza8 = zzmo.zza(w.getAffineX());
                    if (zza8.length > zza6) {
                        zza8 = Arrays.copyOfRange(zza8, zza8.length - zza6, zza8.length);
                    }
                    byte[] zza9 = zzmo.zza(w.getAffineY());
                    if (zza9.length > zza6) {
                        zza9 = Arrays.copyOfRange(zza9, zza9.length - zza6, zza9.length);
                    }
                    System.arraycopy(zza9, 0, bArr, i2 - zza9.length, zza9.length);
                    System.arraycopy(zza8, 0, bArr, zza6 - zza8.length, zza8.length);
                } else {
                    throw new GeneralSecurityException("invalid format:" + String.valueOf(zzykVar));
                }
            } else {
                int i3 = (zza6 * 2) + 1;
                bArr = new byte[i3];
                byte[] zza10 = zzmo.zza(w.getAffineX());
                byte[] zza11 = zzmo.zza(w.getAffineY());
                System.arraycopy(zza11, 0, bArr, i3 - zza11.length, zza11.length);
                System.arraycopy(zza10, 0, bArr, (zza6 + 1) - zza10.length, zza10.length);
                bArr[0] = 4;
            }
            zza2 = zzzn.zza(bArr);
            zza3 = zzzo.zza(zzmo.zza(((ECPrivateKey) zza5.getPrivate()).getS(), zzlu.zza(zzjuVar.zze())), zzbl.zza());
        } else {
            throw new GeneralSecurityException("Unknown KEM ID");
        }
        return zzjx.zza(zzkf.zza(zzjuVar, zza2, num), zza3);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzij.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering HPKE Hybrid Encryption is not supported in FIPS mode");
        }
        zzjw.zza();
        zzok zza2 = zzok.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zza).zza());
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zza).zza());
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zzb).zza());
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zzb).zza());
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zzc).zza());
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzd).zza(zzju.zze.zza).zza(zzju.zza.zzc).zza());
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zza).zza(zzju.zze.zza).zza(zzju.zza.zza).zza());
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zza).zza(zzju.zze.zza).zza(zzju.zza.zza).zza());
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zza).zza(zzju.zze.zza).zza(zzju.zza.zzb).zza());
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zza).zza(zzju.zze.zza).zza(zzju.zza.zzb).zza());
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzb).zza(zzju.zze.zzb).zza(zzju.zza.zza).zza());
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzb).zza(zzju.zze.zzb).zza(zzju.zza.zza).zza());
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzb).zza(zzju.zze.zzb).zza(zzju.zza.zzb).zza());
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzb).zza(zzju.zze.zzb).zza(zzju.zza.zzb).zza());
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzc).zza(zzju.zze.zzc).zza(zzju.zza.zza).zza());
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzc).zza(zzju.zze.zzc).zza(zzju.zza.zza).zza());
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzju.zzc().zza(zzju.zzf.zza).zza(zzju.zzd.zzc).zza(zzju.zze.zzc).zza(zzju.zza.zzb).zza());
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzju.zzc().zza(zzju.zzf.zzc).zza(zzju.zzd.zzc).zza(zzju.zze.zzc).zza(zzju.zza.zzb).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzon.zza().zza(zza);
        zzon.zza().zza(zzb);
        zzoc.zza().zza(zze, zzju.class);
        zzna.zza().zza((zzbn) zzc, true);
        zzna.zza().zza((zzbn) zzd, false);
    }
}
