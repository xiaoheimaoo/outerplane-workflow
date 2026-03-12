package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzft;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfq  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzfq extends zzcp {
    private final zzft zza;
    private final zzzo zzb;
    private final zzzn zzc;
    @Nullable
    private final Integer zzd;

    public static zzfq zza(zzft zzftVar, zzzo zzzoVar, @Nullable Integer num) throws GeneralSecurityException {
        zzzn zzb;
        if (zzftVar.zzc() != zzft.zza.zzb && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zzftVar.zzc()) + " the value of idRequirement must be non-null");
        } else if (zzftVar.zzc() == zzft.zza.zzb && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else {
            if (zzzoVar.zza() != 32) {
                throw new GeneralSecurityException("XAesGcmKey key must be constructed with key of length 32 bytes, not " + zzzoVar.zza());
            }
            if (zzftVar.zzc() == zzft.zza.zzb) {
                zzb = zzor.zza;
            } else if (zzftVar.zzc() == zzft.zza.zza) {
                zzb = zzor.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zzftVar.zzc()));
            }
            return new zzfq(zzftVar, zzzoVar, zzb, num);
        }
    }

    public final zzft zzb() {
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

    private zzfq(zzft zzftVar, zzzo zzzoVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzftVar;
        this.zzb = zzzoVar;
        this.zzc = zzznVar;
        this.zzd = num;
    }
}
