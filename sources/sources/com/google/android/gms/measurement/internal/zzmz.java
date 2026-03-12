package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzmz implements Runnable {
    private final /* synthetic */ zzlw zza;
    private final /* synthetic */ zzme zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmz(zzme zzmeVar, zzlw zzlwVar) {
        this.zza = zzlwVar;
        this.zzb = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        zzfzVar = this.zzb.zzb;
        if (zzfzVar == null) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzlw zzlwVar = this.zza;
            if (zzlwVar == null) {
                zzfzVar.zza(0L, (String) null, (String) null, this.zzb.zza().getPackageName());
            } else {
                zzfzVar.zza(zzlwVar.zzc, this.zza.zza, this.zza.zzb, this.zzb.zza().getPackageName());
            }
            this.zzb.zzar();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to the service", e);
        }
    }
}
