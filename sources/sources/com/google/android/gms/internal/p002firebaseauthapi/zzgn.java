package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdr;
import com.google.android.gms.internal.p002firebaseauthapi.zzwb;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgn  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzgn {
    private static final zzzn zza;
    private static final zzou<zzdr, zzpm> zzb;
    private static final zzoq<zzpm> zzc;
    private static final zznh<zzdm, zzpn> zzd;
    private static final zznd<zzpn> zze;

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdm zzb(zzpn zzpnVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (!zzpnVar.zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            zzth zza2 = zzth.zza(zzpnVar.zzd(), zzajv.zza());
            if (zza2.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzdm.zzb().zza(zzdr.zze().zzb(zza2.zzd().zzb()).zza(12).zzc(16).zza(zza(zzpnVar.zzc())).zza()).zza(zzzo.zza(zza2.zzd().zzd(), zzcm.zza(zzcmVar))).zza(zzpnVar.zze()).zza();
        } catch (zzakm unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    private static zzdr.zza zza(zzxd zzxdVar) throws GeneralSecurityException {
        int i = zzgu.zza[zzxdVar.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                return zzdr.zza.zzb;
            }
            if (i == 4) {
                return zzdr.zza.zzc;
            }
            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxdVar.zza());
        }
        return zzdr.zza.zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdr zzb(zzpm zzpmVar) throws GeneralSecurityException {
        if (!zzpmVar.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: " + zzpmVar.zza().zzf());
        }
        try {
            zztk zza2 = zztk.zza(zzpmVar.zza().zze(), zzajv.zza());
            if (zza2.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            return zzdr.zze().zzb(zza2.zza()).zza(12).zzc(16).zza(zza(zzpmVar.zza().zzd())).zza();
        } catch (zzakm e) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzpn zza(zzdm zzdmVar, zzcm zzcmVar) {
        zzb(zzdmVar.zzc());
        return zzpn.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzth) ((zzakg) zzth.zzb().zza(zzaiw.zza(zzdmVar.zze().zza(zzcm.zza(zzcmVar)))).zze())).zzj(), zzwb.zza.SYMMETRIC, zza(zzdmVar.zzc().zzf()), zzdmVar.zza());
    }

    public static /* synthetic */ zzpm zza(zzdr zzdrVar) {
        zzb(zzdrVar);
        return zzpm.zzb((zzwf) ((zzakg) zzwf.zza().zza("type.googleapis.com/google.crypto.tink.AesGcmKey").zza(((zztk) ((zzakg) zztk.zzc().zza(zzdrVar.zzc()).zze())).zzj()).zza(zza(zzdrVar.zzf())).zze()));
    }

    private static zzxd zza(zzdr.zza zzaVar) throws GeneralSecurityException {
        if (zzdr.zza.zza.equals(zzaVar)) {
            return zzxd.TINK;
        }
        if (zzdr.zza.zzb.equals(zzaVar)) {
            return zzxd.CRUNCHY;
        }
        if (zzdr.zza.zzc.equals(zzaVar)) {
            return zzxd.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzaVar));
    }

    static {
        zzzn zzb2 = zzpy.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zza = zzb2;
        zzb = zzou.zza(new zzow() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgq
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzow
            public final zzpq zza(zzcg zzcgVar) {
                return zzgn.zza((zzdr) zzcgVar);
            }
        }, zzdr.class, zzpm.class);
        zzc = zzoq.zza(new zzos() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgp
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzos
            public final zzcg zza(zzpq zzpqVar) {
                zzdr zzb3;
                zzb3 = zzgn.zzb((zzpm) zzpqVar);
                return zzb3;
            }
        }, zzb2, zzpm.class);
        zzd = zznh.zza(new zznj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgs
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznj
            public final zzpq zza(zzbo zzboVar, zzcm zzcmVar) {
                return zzgn.zza((zzdm) zzboVar, zzcmVar);
            }
        }, zzdm.class, zzpn.class);
        zze = zznd.zza(new zznf() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgr
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zznf
            public final zzbo zza(zzpq zzpqVar, zzcm zzcmVar) {
                zzdm zzb3;
                zzb3 = zzgn.zzb((zzpn) zzpqVar, zzcmVar);
                return zzb3;
            }
        }, zzb2, zzpn.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzom zza2 = zzom.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }

    private static void zzb(zzdr zzdrVar) throws GeneralSecurityException {
        if (zzdrVar.zzd() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports serialization of AES GCM keys with tag size equal to 16 bytes.", Integer.valueOf(zzdrVar.zzd())));
        }
        if (zzdrVar.zzb() != 12) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d. Currently Tink only supports serialization of AES GCM keys with IV size equal to 12 bytes.", Integer.valueOf(zzdrVar.zzb())));
        }
    }
}
