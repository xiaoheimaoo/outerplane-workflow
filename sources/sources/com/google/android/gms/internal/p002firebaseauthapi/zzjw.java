package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzju;
import com.google.android.gms.internal.p002firebaseauthapi.zzwb;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjw  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzjw {
    private static final zzzn zza;
    private static final zzzn zzb;
    private static final zzou<zzju, zzpm> zzc;
    private static final zzoq<zzpm> zzd;
    private static final zznh<zzkf, zzpn> zze;
    private static final zznd<zzpn> zzf;
    private static final zznh<zzjx, zzpn> zzg;
    private static final zznd<zzpn> zzh;
    private static final zzmv<zzxd, zzju.zzf> zzi;
    private static final zzmv<zzvm, zzju.zzd> zzj;
    private static final zzmv<zzvn, zzju.zze> zzk;
    private static final zzmv<zzvk, zzju.zza> zzl;

    private static zzju zza(zzxd zzxdVar, zzvs zzvsVar) throws GeneralSecurityException {
        return zzju.zzc().zza(zzi.zza((zzmv<zzxd, zzju.zzf>) zzxdVar)).zza(zzj.zza((zzmv<zzvm, zzju.zzd>) zzvsVar.zzc())).zza(zzk.zza((zzmv<zzvn, zzju.zze>) zzvsVar.zzb())).zza(zzl.zza((zzmv<zzvk, zzju.zza>) zzvsVar.zza())).zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzju zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            return zza(zzpmVar.zza().zzd(), zzvp.zza(zzpmVar.zza().zze(), zzajv.zza()).zzc());
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing HpkeParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzjx zzc(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePrivateKey: " + zzpnVar.zzf());
        }
        try {
            zzvv zza2 = zzvv.zza(zzpnVar.zzd(), zzajv.zza());
            if (zza2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzvy zzd2 = zza2.zzd();
            if (zzd2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzju zza3 = zza(zzpnVar.zzc(), zzd2.zzb());
            return zzjx.zza(zzkf.zza(zza3, zza(zza3.zze(), zzd2.zzf().zzd()), zzpnVar.zze()), zzzo.zza(zzmo.zza(zzmo.zza(zza2.zze().zzd()), zzlu.zza(zza3.zze())), zzcm.zza(zzcmVar)));
        } catch (zzakm unused) {
            throw new GeneralSecurityException("Parsing HpkePrivateKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzkf zzd(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePublicKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePublicKey: " + zzpnVar.zzf());
        }
        try {
            zzvy zza2 = zzvy.zza(zzpnVar.zzd(), zzajv.zza());
            if (zza2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzju zza3 = zza(zzpnVar.zzc(), zza2.zzb());
            return zzkf.zza(zza3, zza(zza3.zze(), zza2.zzf().zzd()), zzpnVar.zze());
        } catch (zzakm unused) {
            throw new GeneralSecurityException("Parsing HpkePublicKey failed");
        }
    }

    private static zzvs zzb(zzju zzjuVar) throws GeneralSecurityException {
        return (zzvs) ((zzakg) zzvs.zzd().zza(zzj.zza((zzmv<zzvm, zzju.zzd>) zzjuVar.zze())).zza(zzk.zza((zzmv<zzvn, zzju.zze>) zzjuVar.zzd())).zza(zzl.zza((zzmv<zzvk, zzju.zza>) zzjuVar.zzb())).zze());
    }

    private static zzvy zza(zzkf zzkfVar) throws GeneralSecurityException {
        return (zzvy) ((zzakg) zzvy.zzc().zza(0).zza(zzb(zzkfVar.zzb())).zza(zzaiw.zza(zzkfVar.zzd().zzb())).zze());
    }

    private static zzzn zza(zzju.zzd zzdVar, byte[] bArr) throws GeneralSecurityException {
        return zzzn.zza(zzmo.zza(zzmo.zza(bArr), zzlu.zzb(zzdVar)));
    }

    static {
        zzzn zzb2 = zzpy.zzb("type.googleapis.com/google.crypto.tink.HpkePrivateKey");
        zza = zzb2;
        zzzn zzb3 = zzpy.zzb("type.googleapis.com/google.crypto.tink.HpkePublicKey");
        zzb = zzb3;
        zzc = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjz
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                zzpm zzb4;
                zzb4 = zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey").zza(((zzvp) ((zzakg) zzvp.zza().zza(zzjw.zzb(r1)).zze())).zzj()).zza(zzjw.zzi.zza((zzmv<zzxd, zzju.zzf>) ((zzju) zzcgVar).zzf())).zze()));
                return zzb4;
            }
        }, zzju.class, zzpm.class);
        zzd = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjy
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                zzju zzb4;
                zzb4 = zzjw.zzb((zzpm) zzpqVar);
                return zzb4;
            }
        }, zzb2, zzpm.class);
        zze = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkb
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzpn zza2;
                zza2 = zzpn.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey", zzjw.zza(r1).zzj(), zzwb.zza.ASYMMETRIC_PUBLIC, zzjw.zzi.zza((zzmv<zzxd, zzju.zzf>) r1.zzb().zzf()), ((zzkf) zzboVar).zza());
                return zza2;
            }
        }, zzkf.class, zzpn.class);
        zzf = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzka
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                zzkf zzd2;
                zzd2 = zzjw.zzd((zzpn) zzpqVar, zzcmVar);
                return zzd2;
            }
        }, zzb3, zzpn.class);
        zzg = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkd
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                zzpn zza2;
                zza2 = zzpn.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", ((zzvv) ((zzakg) zzvv.zzb().zza(0).zza(zzjw.zza((zzkf) ((zzkv) r1.zzb()))).zza(zzaiw.zza(r1.zze().zza(zzcm.zza(zzcmVar)))).zze())).zzj(), zzwb.zza.ASYMMETRIC_PRIVATE, zzjw.zzi.zza((zzmv<zzxd, zzju.zzf>) r1.zzc().zzf()), ((zzjx) zzboVar).zza());
                return zza2;
            }
        }, zzjx.class, zzpn.class);
        zzh = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkc
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                zzjx zzc2;
                zzc2 = zzjw.zzc((zzpn) zzpqVar, zzcmVar);
                return zzc2;
            }
        }, zzb2, zzpn.class);
        zzi = zzmv.zza().zza(zzxd.RAW, zzju.zzf.zzc).zza(zzxd.TINK, zzju.zzf.zza).zza(zzxd.LEGACY, zzju.zzf.zzb).zza(zzxd.CRUNCHY, zzju.zzf.zzb).zza();
        zzj = zzmv.zza().zza(zzvm.DHKEM_P256_HKDF_SHA256, zzju.zzd.zza).zza(zzvm.DHKEM_P384_HKDF_SHA384, zzju.zzd.zzb).zza(zzvm.DHKEM_P521_HKDF_SHA512, zzju.zzd.zzc).zza(zzvm.DHKEM_X25519_HKDF_SHA256, zzju.zzd.zzd).zza();
        zzk = zzmv.zza().zza(zzvn.HKDF_SHA256, zzju.zze.zza).zza(zzvn.HKDF_SHA384, zzju.zze.zzb).zza(zzvn.HKDF_SHA512, zzju.zze.zzc).zza();
        zzl = zzmv.zza().zza(zzvk.AES_128_GCM, zzju.zza.zza).zza(zzvk.AES_256_GCM, zzju.zza.zzb).zza(zzvk.CHACHA20_POLY1305, zzju.zza.zzc).zza();
    }

    public static void zza() throws GeneralSecurityException {
        zzom zza2 = zzom.zza();
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
        zza2.zza(zzh);
    }
}
