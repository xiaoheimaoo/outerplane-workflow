package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzmd implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzlz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmd(zzlz zzlzVar, long j) {
        this.zza = j;
        this.zzb = zzlzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().zza(this.zza);
        this.zzb.zza = null;
    }
}
