package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaha  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzaha {
    private final String zza;
    private final zzaih zzb;

    public final zzaih zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public zzaha(String str, zzaih zzaihVar) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = (zzaih) Preconditions.checkNotNull(zzaihVar);
    }
}
