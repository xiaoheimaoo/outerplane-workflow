package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzju;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzln  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzln implements zzbj {
    private static final byte[] zza = new byte[0];
    private final zzlr zzb;
    private final zzlo zzc;
    private final zzlp zzd;
    private final zzll zze;
    private final int zzf;
    private final byte[] zzg;

    public static zzbj zza(zzjx zzjxVar) throws GeneralSecurityException {
        int i;
        zzju zzc = zzjxVar.zzc();
        zzlo zza2 = zzlm.zza(zzc.zze());
        zzlp zza3 = zzlm.zza(zzc.zzd());
        zzll zza4 = zzlm.zza(zzc.zzb());
        zzju.zzd zze = zzc.zze();
        if (zze.equals(zzju.zzd.zzd)) {
            i = 32;
        } else if (zze.equals(zzju.zzd.zza)) {
            i = 65;
        } else if (zze.equals(zzju.zzd.zzb)) {
            i = 97;
        } else if (!zze.equals(zzju.zzd.zzc)) {
            throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
        } else {
            i = 133;
        }
        int i2 = i;
        zzju.zzd zze2 = zzjxVar.zzc().zze();
        if (!zze2.equals(zzju.zzd.zzd) && !zze2.equals(zzju.zzd.zza) && !zze2.equals(zzju.zzd.zzb) && !zze2.equals(zzju.zzd.zzc)) {
            throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
        }
        return new zzln(new zzlr(zzzn.zza(zzjxVar.zze().zza(zzbl.zza())), ((zzkf) ((zzkv) zzjxVar.zzb())).zzd()), zza2, zza3, zza4, i2, zzjxVar.zzg());
    }

    private zzln(zzlr zzlrVar, zzlo zzloVar, zzlp zzlpVar, zzll zzllVar, int i, zzzn zzznVar) {
        this.zzb = zzlrVar;
        this.zzc = zzloVar;
        this.zzd = zzlpVar;
        this.zze = zzllVar;
        this.zzf = i;
        this.zzg = zzznVar.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbj
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzg;
        int length = bArr3.length + this.zzf;
        if (bArr.length < length) {
            throw new GeneralSecurityException("Ciphertext is too short.");
        }
        if (!zzpy.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzlk.zza(Arrays.copyOfRange(bArr, this.zzg.length, length), this.zzb, this.zzc, this.zzd, this.zze, bArr2).zza(bArr, length, zza);
    }
}
