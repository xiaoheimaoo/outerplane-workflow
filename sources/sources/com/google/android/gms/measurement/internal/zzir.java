package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
final class zzir implements Runnable {
    private final /* synthetic */ zzag zza;
    private final /* synthetic */ zzig zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzir(zzig zzigVar, zzag zzagVar) {
        this.zza = zzagVar;
        this.zzb = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzou zzouVar;
        zzou zzouVar2;
        zzou zzouVar3;
        zzouVar = this.zzb.zza;
        zzouVar.zzs();
        if (this.zza.zzc.zza() == null) {
            zzouVar3 = this.zzb.zza;
            zzouVar3.zza(this.zza);
            return;
        }
        zzouVar2 = this.zzb.zza;
        zzouVar2.zzb(this.zza);
    }
}
