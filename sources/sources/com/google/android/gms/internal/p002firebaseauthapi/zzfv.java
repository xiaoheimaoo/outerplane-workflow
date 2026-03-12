package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfy;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfv  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzfv extends zzcp {
    private final zzfy zza;
    private final zzzo zzb;
    private final zzzn zzc;
    @Nullable
    private final Integer zzd;

    public static zzfv zza(zzfy.zza zzaVar, zzzo zzzoVar, @Nullable Integer num) throws GeneralSecurityException {
        zzzn zzb;
        if (zzaVar != zzfy.zza.zzc && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zzaVar) + " the value of idRequirement must be non-null");
        } else if (zzaVar == zzfy.zza.zzc && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else {
            if (zzzoVar.zza() != 32) {
                throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzzoVar.zza());
            }
            zzfy zza = zzfy.zza(zzaVar);
            if (zza.zzb() == zzfy.zza.zzc) {
                zzb = zzor.zza;
            } else if (zza.zzb() == zzfy.zza.zzb) {
                zzb = zzor.zza(num.intValue());
            } else if (zza.zzb() == zzfy.zza.zza) {
                zzb = zzor.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zza.zzb()));
            }
            return new zzfv(zza, zzzoVar, zzb, num);
        }
    }

    public final zzfy zzb() {
        return this.zza;
    }

    public final zzzn zzc() {
        return this.zzc;
    }

    public final zzzo zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    @Nullable
    public final Integer zza() {
        return this.zzd;
    }

    private zzfv(zzfy zzfyVar, zzzo zzzoVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzfyVar;
        this.zzb = zzzoVar;
        this.zzc = zzznVar;
        this.zzd = num;
    }
}
