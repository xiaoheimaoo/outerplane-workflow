package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.2.0 */
/* loaded from: classes2.dex */
final class zzft extends zzed.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzdm zzd;
    private final /* synthetic */ zzed.zzc zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzft(zzed.zzc zzcVar, Activity activity, zzdm zzdmVar) {
        super(zzed.this);
        this.zzc = activity;
        this.zzd = zzdmVar;
        this.zze = zzcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzed.zzb
    final void zza() throws RemoteException {
        zzdl zzdlVar;
        zzdlVar = zzed.this.zzj;
        ((zzdl) Preconditions.checkNotNull(zzdlVar)).onActivitySaveInstanceStateByScionActivityInfo(zzeb.zza(this.zzc), this.zzd, this.zzb);
    }
}
