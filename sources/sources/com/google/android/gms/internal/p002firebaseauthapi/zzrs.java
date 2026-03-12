package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqs;
import com.google.android.gms.internal.p002firebaseauthapi.zzwb;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrs  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzrs {
    private static final zzzn zza;
    private static final zzmv<zzxd, zzqs.zzc> zzb;
    private static final zzmv<zzvc, zzqs.zza> zzc;
    private static final zzou<zzqs, zzpm> zzd;
    private static final zzoq<zzpm> zze;
    private static final zznh<zzql, zzpn> zzf;
    private static final zznd<zzpn> zzg;

    /* JADX INFO: Access modifiers changed from: private */
    public static zzql zzb(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzvb zza2 = zzvb.zza(zzpnVar.zzd(), zzajv.zza());
            if (zza2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzql.zzb().zza(zzqs.zzd().zza(zza2.zzf().zzb()).zzb(zza2.zze().zza()).zza(zzc.zza((zzmv<zzvc, zzqs.zza>) zza2.zze().zzb())).zza(zzb.zza((zzmv<zzxd, zzqs.zzc>) zzpnVar.zzc())).zza()).zza(zzzo.zza(zza2.zzf().zzd(), zzcm.zza(zzcmVar))).zza(zzpnVar.zze()).zza();
        } catch (zzakm | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzqs zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            zzve zza2 = zzve.zza(zzpmVar.zza().zze(), zzajv.zza());
            if (zza2.zzb() != 0) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zza2.zzb());
            }
            return zzqs.zzd().zza(zza2.zza()).zzb(zza2.zzf().zza()).zza(zzc.zza((zzmv<zzvc, zzqs.zza>) zza2.zzf().zzb())).zza(zzb.zza((zzmv<zzxd, zzqs.zzc>) zzpmVar.zza().zzd())).zza();
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    private static zzvh zzb(zzqs zzqsVar) throws GeneralSecurityException {
        return (zzvh) ((zzakg) zzvh.zzc().zza(zzqsVar.zzb()).zza(zzc.zza((zzmv<zzvc, zzqs.zza>) zzqsVar.zze())).zze());
    }

    static {
        zzzn zzb2 = zzpy.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zza = zzb2;
        zzb = zzmv.zza().zza(zzxd.RAW, zzqs.zzc.zzd).zza(zzxd.TINK, zzqs.zzc.zza).zza(zzxd.LEGACY, zzqs.zzc.zzc).zza(zzxd.CRUNCHY, zzqs.zzc.zzb).zza();
        zzc = zzmv.zza().zza(zzvc.SHA1, zzqs.zza.zza).zza(zzvc.SHA224, zzqs.zza.zzb).zza(zzvc.SHA256, zzqs.zza.zzc).zza(zzvc.SHA384, zzqs.zza.zzd).zza(zzvc.SHA512, zzqs.zza.zze).zza();
        zzd = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrr
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                zzpm zzb3;
                zzb3 = zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.HmacKey").zza(((zzve) ((zzakg) zzve.zzc().zza(zzrs.zzb(r1)).zza(r1.zzc()).zze())).zzj()).zza(zzrs.zzb.zza((zzmv<zzxd, zzqs.zzc>) ((zzqs) zzcgVar).zzf())).zze()));
                return zzb3;
            }
        }, zzqs.class, zzpm.class);
        zze = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzru
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                zzqs zzb3;
                zzb3 = zzrs.zzb((zzpm) zzpqVar);
                return zzb3;
            }
        }, zzb2, zzpm.class);
        zzf = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrt
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzpn zza2;
                zza2 = zzpn.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzvb) ((zzakg) zzvb.zzb().zza(zzrs.zzb(r1.zzc())).zza(zzaiw.zza(r1.zze().zza(zzcm.zza(zzcmVar)))).zze())).zzj(), zzwb.zza.SYMMETRIC, zzrs.zzb.zza((zzmv<zzxd, zzqs.zzc>) r1.zzc().zzf()), ((zzql) zzboVar).zza());
                return zza2;
            }
        }, zzql.class, zzpn.class);
        zzg = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrw
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                zzql zzb3;
                zzb3 = zzrs.zzb((zzpn) zzpqVar, zzcmVar);
                return zzb3;
            }
        }, zzb2, zzpn.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzom zza2 = zzom.zza();
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
    }
}
