package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzkk implements FutureCallback<Object> {
    private final /* synthetic */ zzog zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkk(zzju zzjuVar, zzog zzogVar) {
        this.zza = zzogVar;
        this.zzb = zzjuVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        int i;
        int i2;
        int i3;
        int i4;
        this.zzb.zzv();
        this.zzb.zzh = false;
        int zza = (this.zzb.zze().zza(zzbn.zzct) ? zzju.zza(this.zzb, th) : 2) - 1;
        if (zza == 0) {
            this.zzb.zzj().zzr().zza("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzgo.zza(this.zzb.zzg().zzaf()), zzgo.zza(th.toString()));
            this.zzb.zzi = 1;
            this.zzb.zzan().add(this.zza);
        } else if (zza != 1) {
            if (zza != 2) {
                return;
            }
            this.zzb.zzj().zzg().zza("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzgo.zza(this.zzb.zzg().zzaf()), th);
            zza();
            this.zzb.zzi = 1;
            this.zzb.zzav();
        } else {
            this.zzb.zzan().add(this.zza);
            i = this.zzb.zzi;
            if (i > zzbn.zzbq.zza(null).intValue()) {
                this.zzb.zzi = 1;
                this.zzb.zzj().zzr().zza("registerTriggerAsync failed. May try later. App ID, throwable", zzgo.zza(this.zzb.zzg().zzaf()), zzgo.zza(th.toString()));
                return;
            }
            zzgq zzr = this.zzb.zzj().zzr();
            Object zza2 = zzgo.zza(this.zzb.zzg().zzaf());
            i2 = this.zzb.zzi;
            zzr.zza("registerTriggerAsync failed. App ID, delay in seconds, throwable", zza2, zzgo.zza(String.valueOf(i2)), zzgo.zza(th.toString()));
            zzju zzjuVar = this.zzb;
            i3 = zzjuVar.zzi;
            zzju.zzb(zzjuVar, i3);
            zzju zzjuVar2 = this.zzb;
            i4 = zzjuVar2.zzi;
            zzjuVar2.zzi = i4 << 1;
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        this.zzb.zzv();
        zza();
        this.zzb.zzh = false;
        this.zzb.zzi = 1;
        this.zzb.zzj().zzc().zza("Successfully registered trigger URI", this.zza.zza);
        this.zzb.zzav();
    }

    private final void zza() {
        SparseArray<Long> zzm = this.zzb.zzk().zzm();
        zzm.put(this.zza.zzc, Long.valueOf(this.zza.zzb));
        zzha zzk = this.zzb.zzk();
        if (zzm == null) {
            zzk.zzi.zza(null);
            return;
        }
        int[] iArr = new int[zzm.size()];
        long[] jArr = new long[zzm.size()];
        for (int i = 0; i < zzm.size(); i++) {
            iArr[i] = zzm.keyAt(i);
            jArr[i] = zzm.valueAt(i).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzk.zzi.zza(bundle);
    }
}
