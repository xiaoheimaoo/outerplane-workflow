package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpe  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzpe {
    private final Class<?> zza;
    private final Class<?> zzb;

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        return simpleName + " with primitive type: " + this.zzb.getSimpleName();
    }

    private zzpe(Class<?> cls, Class<?> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzpe) {
            zzpe zzpeVar = (zzpe) obj;
            return zzpeVar.zza.equals(this.zza) && zzpeVar.zzb.equals(this.zzb);
        }
        return false;
    }
}
