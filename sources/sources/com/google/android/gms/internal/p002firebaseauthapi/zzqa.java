package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqf;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqa  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzqa extends zzqv {
    private final zzqf zza;
    private final zzzo zzb;
    private final zzzn zzc;
    @Nullable
    private final Integer zzd;

    public static zza zzb() {
        return new zza();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqa$zza */
    /* loaded from: classes2.dex */
    public static class zza {
        @Nullable
        private zzqf zza;
        @Nullable
        private zzzo zzb;
        @Nullable
        private Integer zzc;

        public final zza zza(zzzo zzzoVar) throws GeneralSecurityException {
            this.zzb = zzzoVar;
            return this;
        }

        public final zza zza(@Nullable Integer num) {
            this.zzc = num;
            return this;
        }

        public final zza zza(zzqf zzqfVar) {
            this.zza = zzqfVar;
            return this;
        }

        public final zzqa zza() throws GeneralSecurityException {
            zzzn zza;
            zzqf zzqfVar = this.zza;
            if (zzqfVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzqfVar.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zze() == zzqf.zza.zzd) {
                zza = zzor.zza;
            } else if (this.zza.zze() == zzqf.zza.zzc || this.zza.zze() == zzqf.zza.zzb) {
                zza = zzor.zza(this.zzc.intValue());
            } else if (this.zza.zze() == zzqf.zza.zza) {
                zza = zzor.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + String.valueOf(this.zza.zze()));
            }
            return new zzqa(this.zza, this.zzb, zza, this.zzc);
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }
    }

    public final zzqf zzc() {
        return this.zza;
    }

    public final zzzn zzd() {
        return this.zzc;
    }

    public final zzzo zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    @Nullable
    public final Integer zza() {
        return this.zzd;
    }

    private zzqa(zzqf zzqfVar, zzzo zzzoVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzqfVar;
        this.zzb = zzzoVar;
        this.zzc = zzznVar;
        this.zzd = num;
    }
}
