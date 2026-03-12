package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzwl;
import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbx  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzbx {
    private final zzwl.zzb zza;

    public final synchronized zzbs zza() throws GeneralSecurityException {
        return zzbs.zza((zzwl) ((zzakg) this.zza.zze()));
    }

    public static zzbx zza(zzbs zzbsVar) {
        return new zzbx(zzbsVar.zzb().zzn());
    }

    private zzbx(zzwl.zzb zzbVar) {
        this.zza = zzbVar;
    }
}
