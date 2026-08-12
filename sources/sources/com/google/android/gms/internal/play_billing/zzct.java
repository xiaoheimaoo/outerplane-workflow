package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
final class zzct implements Runnable {
    final Future zza;
    final zzcs zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzct(Future future, zzcs zzcsVar) {
        this.zza = future;
        this.zzb = zzcsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable zza;
        Future future = this.zza;
        if (!(future instanceof zzdf) || (zza = zzdg.zza((zzdf) future)) == null) {
            try {
                boolean z = false;
                if (future.isDone()) {
                    while (true) {
                        try {
                            obj = future.get();
                            break;
                        } catch (InterruptedException unused) {
                            z = true;
                        } catch (Throwable th) {
                            if (z) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    this.zzb.zzb(obj);
                    return;
                }
                throw new IllegalStateException(zzbj.zza("Future was expected to be done: %s", future));
            } catch (ExecutionException e) {
                this.zzb.zza(e.getCause());
                return;
            } catch (Throwable th2) {
                this.zzb.zza(th2);
                return;
            }
        }
        this.zzb.zza(zza);
    }

    public final String toString() {
        zzbc zza = zzbe.zza(this);
        zza.zza(this.zzb);
        return zza.toString();
    }
}
