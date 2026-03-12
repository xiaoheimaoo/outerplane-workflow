package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpu  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzpu {
    private final Class<?> zza;
    private final Class<? extends zzpq> zzb;

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        return simpleName + " with serialization type: " + this.zzb.getSimpleName();
    }

    private zzpu(Class<?> cls, Class<? extends zzpq> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzpu) {
            zzpu zzpuVar = (zzpu) obj;
            return zzpuVar.zza.equals(this.zza) && zzpuVar.zzb.equals(this.zzb);
        }
        return false;
    }
}
