package com.google.android.gms.internal.p002firebaseauthapi;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaju  reason: invalid package */
/* loaded from: classes2.dex */
final class zzaju {
    private final Object zza;
    private final int zzb;

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaju(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaju) {
            zzaju zzajuVar = (zzaju) obj;
            return this.zza == zzajuVar.zza && this.zzb == zzajuVar.zzb;
        }
        return false;
    }
}
