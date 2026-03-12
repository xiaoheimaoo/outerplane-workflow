package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzgh extends com.google.android.gms.internal.measurement.zzbu implements zzgf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.measurement.internal.zzgf
    public final void zza(zzor zzorVar) throws RemoteException {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzorVar);
        zzc(2, b_);
    }
}
