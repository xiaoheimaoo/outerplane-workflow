package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzlj implements Runnable {
    private final /* synthetic */ zzjj zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzju zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlj(zzju zzjuVar, zzjj zzjjVar, long j, boolean z) {
        this.zza = zzjjVar;
        this.zzb = j;
        this.zzc = z;
        this.zzd = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza(this.zza);
        zzju.zza(this.zzd, this.zza, this.zzb, true, this.zzc);
    }
}
