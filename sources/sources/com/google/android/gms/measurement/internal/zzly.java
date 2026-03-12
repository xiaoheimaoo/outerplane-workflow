package com.google.android.gms.measurement.internal;

import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzly implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzlw zzb;
    private final /* synthetic */ zzlw zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzlz zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzly(zzlz zzlzVar, Bundle bundle, zzlw zzlwVar, zzlw zzlwVar2, long j) {
        this.zza = bundle;
        this.zzb = zzlwVar;
        this.zzc = zzlwVar2;
        this.zzd = j;
        this.zze = zzlzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz.zza(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
