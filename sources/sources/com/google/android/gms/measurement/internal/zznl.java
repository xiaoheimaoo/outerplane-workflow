package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
final class zznl implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zznj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznl(zznj zznjVar, ComponentName componentName) {
        this.zza = componentName;
        this.zzb = zznjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzme.zza(this.zzb.zza, this.zza);
    }
}
