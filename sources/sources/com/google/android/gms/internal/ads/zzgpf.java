package com.google.android.gms.internal.ads;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
final class zzgpf {
    private final Class zza;
    private final zzgxq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgpf(Class cls, zzgxq zzgxqVar, zzgpe zzgpeVar) {
        this.zza = cls;
        this.zzb = zzgxqVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgpf) {
            zzgpf zzgpfVar = (zzgpf) obj;
            return zzgpfVar.zza.equals(this.zza) && zzgpfVar.zzb.equals(this.zzb);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        zzgxq zzgxqVar = this.zzb;
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(zzgxqVar);
        return simpleName + ", object identifier: " + valueOf;
    }
}
