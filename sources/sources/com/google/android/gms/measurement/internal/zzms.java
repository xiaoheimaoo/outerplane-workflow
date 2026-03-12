package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzms implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ zzme zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzms(zzme zzmeVar, AtomicReference atomicReference, zzp zzpVar) {
        this.zza = atomicReference;
        this.zzb = zzpVar;
        this.zzc = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        synchronized (this.zza) {
            try {
            } catch (RemoteException e) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id", e);
                this.zza.notify();
            }
            if (!this.zzc.zzk().zzp().zzh()) {
                this.zzc.zzj().zzw().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzm().zzb((String) null);
                this.zzc.zzk().zze.zza(null);
                this.zza.set(null);
                this.zza.notify();
                return;
            }
            zzfzVar = this.zzc.zzb;
            if (zzfzVar == null) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id");
                this.zza.notify();
                return;
            }
            Preconditions.checkNotNull(this.zzb);
            this.zza.set(zzfzVar.zzb(this.zzb));
            String str = (String) this.zza.get();
            if (str != null) {
                this.zzc.zzm().zzb(str);
                this.zzc.zzk().zze.zza(str);
            }
            this.zzc.zzar();
            this.zza.notify();
        }
    }
}
