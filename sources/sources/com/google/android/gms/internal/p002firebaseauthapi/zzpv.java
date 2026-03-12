package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpv  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzpv {
    private final Class<? extends zzpq> zza;
    private final zzzn zzb;

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        return simpleName + ", object identifier: " + String.valueOf(this.zzb);
    }

    private zzpv(Class<? extends zzpq> cls, zzzn zzznVar) {
        this.zza = cls;
        this.zzb = zzznVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzpv) {
            zzpv zzpvVar = (zzpv) obj;
            return zzpvVar.zza.equals(this.zza) && zzpvVar.zzb.equals(this.zzb);
        }
        return false;
    }
}
