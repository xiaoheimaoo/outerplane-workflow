package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzew;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzex  reason: invalid package */
/* loaded from: classes2.dex */
public class zzex extends zzcp {
    private final zzew zza;
    private final zzzn zzb;
    @Nullable
    private final Integer zzc;

    public static zzex zza(zzew zzewVar, @Nullable Integer num) throws GeneralSecurityException {
        zzzn zzb;
        if (zzewVar.zzc() == zzew.zzc.zzb) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzb = zzor.zza;
        } else if (zzewVar.zzc() != zzew.zzc.zza) {
            throw new GeneralSecurityException("Unknown Variant: " + String.valueOf(zzewVar.zzc()));
        } else if (num == null) {
            throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
        } else {
            zzb = zzor.zzb(num.intValue());
        }
        return new zzex(zzewVar, zzb, num);
    }

    public final zzew zzb() {
        return this.zza;
    }

    public final zzzn zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    public final Integer zza() {
        return this.zzc;
    }

    private zzex(zzew zzewVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzewVar;
        this.zzb = zzznVar;
        this.zzc = num;
    }
}
