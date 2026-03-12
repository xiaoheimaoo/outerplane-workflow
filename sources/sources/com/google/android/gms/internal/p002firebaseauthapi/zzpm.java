package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpm  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzpm implements zzpq {
    private final zzzn zza;
    private final zzwf zzb;

    public static zzpm zza(zzwf zzwfVar) throws GeneralSecurityException {
        return new zzpm(zzwfVar, zzpy.zza(zzwfVar.zzf()));
    }

    public static zzpm zzb(zzwf zzwfVar) {
        return new zzpm(zzwfVar, zzpy.zzb(zzwfVar.zzf()));
    }

    public final zzwf zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpq
    public final zzzn zzb() {
        return this.zza;
    }

    private zzpm(zzwf zzwfVar, zzzn zzznVar) {
        this.zzb = zzwfVar;
        this.zza = zzznVar;
    }
}
