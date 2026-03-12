package com.google.android.gms.measurement.internal;

import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzmb implements Runnable {
    private final /* synthetic */ zzlw zza;
    private final /* synthetic */ zzlw zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzlz zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmb(zzlz zzlzVar, zzlw zzlwVar, zzlw zzlwVar2, long j, boolean z) {
        this.zza = zzlwVar;
        this.zzb = zzlwVar2;
        this.zzc = j;
        this.zzd = z;
        this.zze = zzlzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
