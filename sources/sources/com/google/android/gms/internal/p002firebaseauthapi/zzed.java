package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzeg;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzed  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzed extends zzcp {
    private final zzeg zza;
    private final zzzo zzb;
    private final zzzn zzc;
    @Nullable
    private final Integer zzd;

    public static zzed zza(zzeg.zza zzaVar, zzzo zzzoVar, @Nullable Integer num) throws GeneralSecurityException {
        zzzn zzb;
        if (zzaVar != zzeg.zza.zzc && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zzaVar) + " the value of idRequirement must be non-null");
        } else if (zzaVar == zzeg.zza.zzc && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else {
            if (zzzoVar.zza() != 32) {
                throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzzoVar.zza());
            }
            zzeg zza = zzeg.zza(zzaVar);
            if (zza.zzb() == zzeg.zza.zzc) {
                zzb = zzor.zza;
            } else if (zza.zzb() == zzeg.zza.zzb) {
                zzb = zzor.zza(num.intValue());
            } else if (zza.zzb() == zzeg.zza.zza) {
                zzb = zzor.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zza.zzb()));
            }
            return new zzed(zza, zzzoVar, zzb, num);
        }
    }

    public final zzeg zzb() {
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

    private zzed(zzeg zzegVar, zzzo zzzoVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzegVar;
        this.zzb = zzzoVar;
        this.zzc = zzznVar;
        this.zzd = num;
    }
}
