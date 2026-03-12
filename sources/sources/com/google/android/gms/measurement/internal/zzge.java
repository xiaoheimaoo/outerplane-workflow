package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public abstract class zzge extends com.google.android.gms.internal.measurement.zzbx implements zzgf {
    public zzge() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
            zza((zzor) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzor.CREATOR));
            return true;
        }
        return false;
    }
}
