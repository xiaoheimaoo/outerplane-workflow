package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
final class zznm implements Runnable {
    private final /* synthetic */ zznj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznm(zznj zznjVar) {
        this.zza = zznjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza.zzb = null;
        this.zza.zza.zzaq();
    }
}
