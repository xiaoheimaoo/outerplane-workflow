package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
/* compiled from: com.google.android.ump:user-messaging-platform@@2.2.0 */
/* loaded from: classes2.dex */
public final class zzbv implements zzdn {
    private final zzdr zza;
    private final zzdr zzb;
    private final zzdr zzc;

    public zzbv(zzdr zzdrVar, zzdr zzdrVar2, zzdr zzdrVar3) {
        this.zza = zzdrVar;
        this.zzb = zzdrVar2;
        this.zzc = zzdrVar3;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdr
    /* renamed from: zzb */
    public final zzbu zza() {
        Handler handler = zzcr.zza;
        zzdp.zza(handler);
        return new zzbu((zzbw) this.zza.zza(), handler, ((zzcb) this.zzc).zza());
    }
}
