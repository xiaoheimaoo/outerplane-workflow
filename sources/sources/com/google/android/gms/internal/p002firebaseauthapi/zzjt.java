package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjq;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjt  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzjt extends zzks {
    private final zzjs zza;
    @Nullable
    private final zzzm zzb;
    @Nullable
    private final zzzo zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzks, com.google.android.gms.internal.p002firebaseauthapi.zzcf
    public final /* synthetic */ zzbo zzb() {
        return (zzjs) zzb();
    }

    public final zzjq zzc() {
        return this.zza.zzb();
    }

    public static zzjt zza(zzjs zzjsVar, zzzo zzzoVar) throws GeneralSecurityException {
        if (zzjsVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        }
        if (zzjsVar.zzd() != null) {
            if (zzzoVar == null) {
                throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
            }
            byte[] zza = zzzoVar.zza(zzbl.zza());
            byte[] zzb = zzjsVar.zzd().zzb();
            if (zza.length != 32) {
                throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
            }
            if (!Arrays.equals(zzzl.zza(zza), zzb)) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
            return new zzjt(zzjsVar, null, zzzoVar);
        }
        throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
    }

    public static zzjt zza(zzjs zzjsVar, zzzm zzzmVar) throws GeneralSecurityException {
        if (zzjsVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        }
        if (zzjsVar.zze() != null) {
            if (zzzmVar == null) {
                throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
            }
            BigInteger zza = zzzmVar.zza(zzbl.zza());
            ECPoint zze = zzjsVar.zze();
            zzjq.zza zzd = zzjsVar.zzb().zzd();
            BigInteger order = zza(zzd).getOrder();
            if (zza.signum() <= 0 || zza.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private value");
            }
            if (!zzmt.zza(zza, zza(zzd)).equals(zze)) {
                throw new GeneralSecurityException("Invalid private value");
            }
            return new zzjt(zzjsVar, zzzmVar, null);
        }
        throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzks
    public final /* synthetic */ zzkv zzd() {
        return this.zza;
    }

    @Nullable
    public final zzzm zze() {
        return this.zzb;
    }

    @Nullable
    public final zzzo zzf() {
        return this.zzc;
    }

    private static ECParameterSpec zza(zzjq.zza zzaVar) {
        if (zzaVar == zzjq.zza.zza) {
            return zzmt.zza;
        }
        if (zzaVar == zzjq.zza.zzb) {
            return zzmt.zzb;
        }
        if (zzaVar == zzjq.zza.zzc) {
            return zzmt.zzc;
        }
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzaVar));
    }

    private zzjt(zzjs zzjsVar, @Nullable zzzm zzzmVar, @Nullable zzzo zzzoVar) {
        this.zza = zzjsVar;
        this.zzb = zzzmVar;
        this.zzc = zzzoVar;
    }
}
