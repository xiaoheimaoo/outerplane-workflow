package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzfh extends zzed.zzb {
    private final /* synthetic */ zzdm zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ zzed zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfh(zzed zzedVar, zzdm zzdmVar, int i) {
        super(zzedVar);
        this.zzc = zzdmVar;
        this.zzd = i;
        this.zze = zzedVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    protected final void zzb() {
        this.zzc.zza((Bundle) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        zzdl zzdlVar;
        zzdlVar = this.zze.zzj;
        ((zzdl) Preconditions.checkNotNull(zzdlVar)).getTestFlag(this.zzc, this.zzd);
    }
}
