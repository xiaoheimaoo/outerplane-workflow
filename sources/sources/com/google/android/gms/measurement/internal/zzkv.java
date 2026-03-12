package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzkv implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzju zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkv(zzju zzjuVar, AtomicReference atomicReference, boolean z) {
        this.zza = atomicReference;
        this.zzb = z;
        this.zzc = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzq().zza(this.zza, this.zzb);
    }
}
