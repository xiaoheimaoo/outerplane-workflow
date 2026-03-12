package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzds extends zzbu implements zzdq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzds(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzdq
    public final void zza(Bundle bundle) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, bundle);
        zzb(1, b_);
    }
}
