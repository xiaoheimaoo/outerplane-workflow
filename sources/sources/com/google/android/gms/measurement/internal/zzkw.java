package com.google.android.gms.measurement.internal;

import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzkw implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkw(zzju zzjuVar, Bundle bundle) {
        this.zza = bundle;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzju.zzc(this.zzb, this.zza);
    }
}
