package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public abstract class zzfy extends com.google.android.gms.internal.measurement.zzbx implements zzfz {
    public zzfy() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzgf zzgfVar = null;
        zzga zzgaVar = null;
        switch (i) {
            case 1:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza((zzbl) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbl.CREATOR), (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza((zzpm) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzpm.CREATOR), (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzd((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza((zzbl) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbl.CREATOR), readString, readString2);
                parcel2.writeNoException();
                return true;
            case 6:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzh((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                boolean zzc = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzpm> zza = zza((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR), zzc);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 9:
                String readString3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                byte[] zza2 = zza((zzbl) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbl.CREATOR), readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                return true;
            case 11:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                String zzb = zzb((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzb);
                return true;
            case 12:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza((zzag) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzag.CREATOR), (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza((zzag) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzag.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzpm> zza3 = zza(parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzbw.zzc(parcel), (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza3);
                return true;
            case 15:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                boolean zzc2 = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzpm> zza4 = zza(readString7, readString8, readString9, zzc2);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza4);
                return true;
            case 16:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzag> zza5 = zza(parcel.readString(), parcel.readString(), (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza5);
                return true;
            case 17:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzag> zza6 = zza(readString10, readString11, readString12);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza6);
                return true;
            case 18:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zze((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 19:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza((Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR), (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 20:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzf((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 21:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzap zza7 = zza((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel2, zza7);
                return true;
            case 24:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzog> zza8 = zza((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR), (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza8);
                return true;
            case 25:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzi((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 26:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzg((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 27:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzc((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 29:
                zzp zzpVar = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                zzop zzopVar = (zzop) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzop.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    if (queryLocalInterface instanceof zzgf) {
                        zzgfVar = (zzgf) queryLocalInterface;
                    } else {
                        zzgfVar = new zzgh(readStrongBinder);
                    }
                }
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzpVar, zzopVar, zzgfVar);
                parcel2.writeNoException();
                return true;
            case 30:
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza((zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR), (zzae) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzae.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                zzp zzpVar2 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    if (queryLocalInterface2 instanceof zzga) {
                        zzgaVar = (zzga) queryLocalInterface2;
                    } else {
                        zzgaVar = new zzgc(readStrongBinder2);
                    }
                }
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzpVar2, bundle, zzgaVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
