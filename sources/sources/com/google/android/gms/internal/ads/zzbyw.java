package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public abstract class zzbyw extends zzayh implements zzbyx {
    public zzbyw() {
        super("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzayi.zzc(parcel);
            zzf((ParcelFileDescriptor) zzayi.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zzayi.zzc(parcel);
            zze((com.google.android.gms.ads.internal.util.zzbb) zzayi.zza(parcel, com.google.android.gms.ads.internal.util.zzbb.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
