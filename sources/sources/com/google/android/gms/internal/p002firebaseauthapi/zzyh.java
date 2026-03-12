package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjq;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyh  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzyh implements zzbm {
    static final zzmv<zzyl, zzjq.zza> zza = zzmv.zza().zza(zzyl.NIST_P256, zzjq.zza.zza).zza(zzyl.NIST_P384, zzjq.zza.zzb).zza(zzyl.NIST_P521, zzjq.zza.zzc).zza();
    static final zzmv<zzyk, zzjq.zzc> zzb = zzmv.zza().zza(zzyk.UNCOMPRESSED, zzjq.zzc.zzb).zza(zzyk.COMPRESSED, zzjq.zzc.zza).zza(zzyk.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzjq.zzc.zzc).zza();

    public static zzbm zza(zzjs zzjsVar) throws GeneralSecurityException {
        byte[] byteArray = zzjsVar.zze().getAffineX().toByteArray();
        byte[] byteArray2 = zzjsVar.zze().getAffineY().toByteArray();
        ECParameterSpec zza2 = zzyi.zza(zza.zza((zzmv<zzyl, zzjq.zza>) zzjsVar.zzb().zzd()));
        ECPoint eCPoint = new ECPoint(new BigInteger(1, byteArray), new BigInteger(1, byteArray2));
        zzmt.zza(eCPoint, zza2.getCurve());
        ECPublicKey eCPublicKey = (ECPublicKey) zzym.zze.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint, zza2));
        byte[] bArr = new byte[0];
        if (zzjsVar.zzb().zzh() != null) {
            bArr = zzjsVar.zzb().zzh().zzb();
        }
        return new zzyh(eCPublicKey, bArr, zza(zzjsVar.zzb().zze()), zzb.zza((zzmv<zzyk, zzjq.zzc>) zzjsVar.zzb().zzf()), zzkw.zza(zzjsVar.zzb()), zzjsVar.zzc().zzb());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String zza(zzjq.zzd zzdVar) throws GeneralSecurityException {
        if (zzdVar.equals(zzjq.zzd.zza)) {
            return "HmacSha1";
        }
        if (zzdVar.equals(zzjq.zzd.zzb)) {
            return "HmacSha224";
        }
        if (zzdVar.equals(zzjq.zzd.zzc)) {
            return "HmacSha256";
        }
        if (zzdVar.equals(zzjq.zzd.zzd)) {
            return "HmacSha384";
        }
        if (zzdVar.equals(zzjq.zzd.zze)) {
            return "HmacSha512";
        }
        throw new GeneralSecurityException("hash unsupported for EciesAeadHkdf: " + String.valueOf(zzdVar));
    }

    private zzyh(ECPublicKey eCPublicKey, byte[] bArr, String str, zzyk zzykVar, zzla zzlaVar, byte[] bArr2) throws GeneralSecurityException {
        zzmt.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        new zzyj(eCPublicKey);
    }
}
