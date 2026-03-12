package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzel extends zzed.zzb {
    private final /* synthetic */ Boolean zzc;
    private final /* synthetic */ zzed zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzel(zzed zzedVar, Boolean bool) {
        super(zzedVar);
        this.zzc = bool;
        this.zzd = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        zzdl zzdlVar;
        zzdl zzdlVar2;
        if (this.zzc != null) {
            zzdlVar2 = this.zzd.zzj;
            ((zzdl) Preconditions.checkNotNull(zzdlVar2)).setMeasurementEnabled(this.zzc.booleanValue(), this.zza);
            return;
        }
        zzdlVar = this.zzd.zzj;
        ((zzdl) Preconditions.checkNotNull(zzdlVar)).clearMeasurementEnabled(this.zza);
    }
}
