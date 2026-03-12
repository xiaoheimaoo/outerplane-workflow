package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzju;
import java.security.GeneralSecurityException;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkf  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzkf extends zzkv {
    private final zzju zza;
    private final zzzn zzb;
    private final zzzn zzc;
    @Nullable
    private final Integer zzd;

    public final zzju zzb() {
        return this.zza;
    }

    public static zzkf zza(zzju zzjuVar, zzzn zzznVar, @Nullable Integer num) throws GeneralSecurityException {
        zzzn zzb;
        EllipticCurve curve;
        zzju.zzf zzf = zzjuVar.zzf();
        if (!zzf.equals(zzju.zzf.zzc) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzf) + " variant.");
        }
        if (zzf.equals(zzju.zzf.zzc) && num != null) {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
        zzju.zzd zze = zzjuVar.zze();
        int zza = zzznVar.zza();
        String str = "Encoded public key byte length for " + String.valueOf(zze) + " must be %d, not " + zza;
        boolean z = false;
        if (zze == zzju.zzd.zza) {
            if (zza != 65) {
                throw new GeneralSecurityException(String.format(str, 65));
            }
        } else if (zze == zzju.zzd.zzb) {
            if (zza != 97) {
                throw new GeneralSecurityException(String.format(str, 97));
            }
        } else if (zze == zzju.zzd.zzc) {
            if (zza != 133) {
                throw new GeneralSecurityException(String.format(str, 133));
            }
        } else if (zze != zzju.zzd.zzd) {
            throw new GeneralSecurityException("Unable to validate public key length for " + String.valueOf(zze));
        } else {
            if (zza != 32) {
                throw new GeneralSecurityException(String.format(str, 32));
            }
        }
        if (zze == zzju.zzd.zza || zze == zzju.zzd.zzb || zze == zzju.zzd.zzc) {
            z = true;
        }
        if (z) {
            if (zze == zzju.zzd.zza) {
                curve = zzmt.zza.getCurve();
            } else if (zze == zzju.zzd.zzb) {
                curve = zzmt.zzb.getCurve();
            } else if (zze == zzju.zzd.zzc) {
                curve = zzmt.zzc.getCurve();
            } else {
                throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zze));
            }
            zzmt.zza(zzyi.zza(curve, zzyk.UNCOMPRESSED, zzznVar.zzb()), curve);
        }
        zzju.zzf zzf2 = zzjuVar.zzf();
        if (zzf2 == zzju.zzf.zzc) {
            zzb = zzor.zza;
        } else if (num == null) {
            throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant " + String.valueOf(zzf2));
        } else {
            if (zzf2 == zzju.zzf.zzb) {
                zzb = zzor.zza(num.intValue());
            } else if (zzf2 == zzju.zzf.zza) {
                zzb = zzor.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown HpkeParameters.Variant: " + String.valueOf(zzf2));
            }
        }
        return new zzkf(zzjuVar, zzznVar, zzb, num);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkv
    public final zzzn zzc() {
        return this.zzc;
    }

    public final zzzn zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    @Nullable
    public final Integer zza() {
        return this.zzd;
    }

    private zzkf(zzju zzjuVar, zzzn zzznVar, zzzn zzznVar2, @Nullable Integer num) {
        this.zza = zzjuVar;
        this.zzb = zzznVar;
        this.zzc = zzznVar2;
        this.zzd = num;
    }
}
