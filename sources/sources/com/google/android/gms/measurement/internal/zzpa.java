package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzpa implements Callable<String> {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzou zzb;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        if (!this.zzb.zzb((String) Preconditions.checkNotNull(this.zza.zza)).zzh() || !zzjj.zzb(this.zza.zzt).zzh()) {
            this.zzb.zzj().zzq().zza("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        zzh zza = this.zzb.zza(this.zza);
        if (zza == null) {
            this.zzb.zzj().zzr().zza("App info was null when attempting to get app instance id");
            return null;
        }
        return zza.zzad();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpa(zzou zzouVar, zzp zzpVar) {
        this.zza = zzpVar;
        this.zzb = zzouVar;
    }
}
