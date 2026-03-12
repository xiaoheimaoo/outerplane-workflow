package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
final class zzio implements Callable<List<zzpo>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzig zzb;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzpo> call() throws Exception {
        zzou zzouVar;
        zzou zzouVar2;
        zzouVar = this.zzb.zza;
        zzouVar.zzs();
        zzouVar2 = this.zzb.zza;
        return zzouVar2.zzf().zzk(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzio(zzig zzigVar, String str) {
        this.zza = str;
        this.zzb = zzigVar;
    }
}
