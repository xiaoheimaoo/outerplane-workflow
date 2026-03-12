package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
final class zziw implements Callable<List<zzag>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzig zzd;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzag> call() throws Exception {
        zzou zzouVar;
        zzou zzouVar2;
        zzouVar = this.zzd.zza;
        zzouVar.zzs();
        zzouVar2 = this.zzd.zza;
        return zzouVar2.zzf().zza(this.zza, this.zzb, this.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziw(zzig zzigVar, String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzigVar;
    }
}
