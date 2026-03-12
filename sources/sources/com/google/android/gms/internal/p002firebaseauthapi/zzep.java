package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzep  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzep extends zzcr {
    private final String zza;
    private final zza zzb;

    public final int hashCode() {
        return Objects.hash(zzep.class, this.zza, this.zzb);
    }

    public final zza zzb() {
        return this.zzb;
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzep$zza */
    /* loaded from: classes2.dex */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("NO_PREFIX");
        private final String zzc;

        public final String toString() {
            return this.zzc;
        }

        private zza(String str) {
            this.zzc = str;
        }
    }

    public static zzep zza(String str, zza zzaVar) {
        return new zzep(str, zzaVar);
    }

    public final String zzc() {
        return this.zza;
    }

    public final String toString() {
        String str = this.zza;
        return "LegacyKmsAead Parameters (keyUri: " + str + ", variant: " + String.valueOf(this.zzb) + ")";
    }

    private zzep(String str, zza zzaVar) {
        this.zza = str;
        this.zzb = zzaVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzep) {
            zzep zzepVar = (zzep) obj;
            return zzepVar.zza.equals(this.zza) && zzepVar.zzb.equals(this.zzb);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcg
    public final boolean zza() {
        return this.zzb != zza.zzb;
    }
}
