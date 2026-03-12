package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznp  reason: invalid package */
/* loaded from: classes2.dex */
public final class zznp extends zzcg {
    private final zzpm zza;

    public final int hashCode() {
        return Objects.hash(this.zza.zza(), this.zza.zzb());
    }

    public final zzpm zzb() {
        return this.zza;
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.zza.zza().zzf();
        int i = zzno.zza[this.zza.zza().zzd().ordinal()];
        objArr[1] = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK";
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }

    public zznp(zzpm zzpmVar) {
        this.zza = zzpmVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zznp) {
            zzpm zzpmVar = ((zznp) obj).zza;
            return this.zza.zza().zzd().equals(zzpmVar.zza().zzd()) && this.zza.zza().zzf().equals(zzpmVar.zza().zzf()) && this.zza.zza().zze().equals(zzpmVar.zza().zze());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcg
    public final boolean zza() {
        return this.zza.zza().zzd() != zzxd.RAW;
    }
}
