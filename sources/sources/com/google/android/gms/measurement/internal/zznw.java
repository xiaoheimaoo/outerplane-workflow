package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
final class zznw implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zznx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznw(zznx zznxVar, long j) {
        this.zza = j;
        this.zzb = zznxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznx.zzb(this.zzb, this.zza);
    }
}
