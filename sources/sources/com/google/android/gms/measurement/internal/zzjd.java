package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
final class zzjd implements Callable<List<zzog>> {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzig zzc;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzog> call() throws Exception {
        zzou zzouVar;
        zzou zzouVar2;
        zzouVar = this.zzc.zza;
        zzouVar.zzs();
        zzouVar2 = this.zzc.zza;
        return zzouVar2.zza(this.zza, this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjd(zzig zzigVar, zzp zzpVar, Bundle bundle) {
        this.zza = zzpVar;
        this.zzb = bundle;
        this.zzc = zzigVar;
    }
}
