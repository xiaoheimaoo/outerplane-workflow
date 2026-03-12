package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public abstract class zzdo extends zzbx implements zzdl {
    public static zzdl asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof zzdl) {
            return (zzdl) queryLocalInterface;
        }
        return new zzdn(iBinder);
    }

    public zzdo() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzdq zzdsVar;
        zzdq zzdqVar;
        zzdq zzdqVar2 = null;
        zzdr zzdrVar = null;
        zzdq zzdqVar3 = null;
        zzdq zzdqVar4 = null;
        zzdq zzdqVar5 = null;
        zzdq zzdqVar6 = null;
        zzdw zzdwVar = null;
        zzdw zzdwVar2 = null;
        zzdw zzdwVar3 = null;
        zzdq zzdqVar7 = null;
        zzdq zzdqVar8 = null;
        zzdq zzdqVar9 = null;
        zzdq zzdqVar10 = null;
        zzdq zzdqVar11 = null;
        zzdq zzdqVar12 = null;
        zzdx zzdxVar = null;
        zzdq zzdqVar13 = null;
        zzdq zzdqVar14 = null;
        zzdq zzdqVar15 = null;
        zzdq zzdqVar16 = null;
        switch (i) {
            case 1:
                long readLong = parcel.readLong();
                zzbw.zzb(parcel);
                initialize(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzdz) zzbw.zza(parcel, zzdz.CREATOR), readLong);
                break;
            case 2:
                boolean zzc = zzbw.zzc(parcel);
                boolean zzc2 = zzbw.zzc(parcel);
                long readLong2 = parcel.readLong();
                zzbw.zzb(parcel);
                logEvent(parcel.readString(), parcel.readString(), (Bundle) zzbw.zza(parcel, Bundle.CREATOR), zzc, zzc2, readLong2);
                break;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzdqVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface instanceof zzdq) {
                        zzdsVar = (zzdq) queryLocalInterface;
                    } else {
                        zzdsVar = new zzds(readStrongBinder);
                    }
                    zzdqVar = zzdsVar;
                }
                long readLong3 = parcel.readLong();
                zzbw.zzb(parcel);
                logEventAndBundle(readString, readString2, bundle, zzdqVar, readLong3);
                break;
            case 4:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zzc3 = zzbw.zzc(parcel);
                long readLong4 = parcel.readLong();
                zzbw.zzb(parcel);
                setUserProperty(readString3, readString4, asInterface, zzc3, readLong4);
                break;
            case 5:
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                boolean zzc4 = zzbw.zzc(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface2 instanceof zzdq) {
                        zzdqVar2 = (zzdq) queryLocalInterface2;
                    } else {
                        zzdqVar2 = new zzds(readStrongBinder2);
                    }
                }
                zzbw.zzb(parcel);
                getUserProperties(readString5, readString6, zzc4, zzdqVar2);
                break;
            case 6:
                String readString7 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface3 instanceof zzdq) {
                        zzdqVar16 = (zzdq) queryLocalInterface3;
                    } else {
                        zzdqVar16 = new zzds(readStrongBinder3);
                    }
                }
                zzbw.zzb(parcel);
                getMaxUserProperties(readString7, zzdqVar16);
                break;
            case 7:
                String readString8 = parcel.readString();
                long readLong5 = parcel.readLong();
                zzbw.zzb(parcel);
                setUserId(readString8, readLong5);
                break;
            case 8:
                long readLong6 = parcel.readLong();
                zzbw.zzb(parcel);
                setConditionalUserProperty((Bundle) zzbw.zza(parcel, Bundle.CREATOR), readLong6);
                break;
            case 9:
                zzbw.zzb(parcel);
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) zzbw.zza(parcel, Bundle.CREATOR));
                break;
            case 10:
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface4 instanceof zzdq) {
                        zzdqVar15 = (zzdq) queryLocalInterface4;
                    } else {
                        zzdqVar15 = new zzds(readStrongBinder4);
                    }
                }
                zzbw.zzb(parcel);
                getConditionalUserProperties(readString9, readString10, zzdqVar15);
                break;
            case 11:
                boolean zzc5 = zzbw.zzc(parcel);
                long readLong7 = parcel.readLong();
                zzbw.zzb(parcel);
                setMeasurementEnabled(zzc5, readLong7);
                break;
            case 12:
                long readLong8 = parcel.readLong();
                zzbw.zzb(parcel);
                resetAnalyticsData(readLong8);
                break;
            case 13:
                long readLong9 = parcel.readLong();
                zzbw.zzb(parcel);
                setMinimumSessionDuration(readLong9);
                break;
            case 14:
                long readLong10 = parcel.readLong();
                zzbw.zzb(parcel);
                setSessionTimeoutDuration(readLong10);
                break;
            case 15:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                long readLong11 = parcel.readLong();
                zzbw.zzb(parcel);
                setCurrentScreen(asInterface2, readString11, readString12, readLong11);
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface5 instanceof zzdq) {
                        zzdqVar14 = (zzdq) queryLocalInterface5;
                    } else {
                        zzdqVar14 = new zzds(readStrongBinder5);
                    }
                }
                zzbw.zzb(parcel);
                getCurrentScreenName(zzdqVar14);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface6 instanceof zzdq) {
                        zzdqVar13 = (zzdq) queryLocalInterface6;
                    } else {
                        zzdqVar13 = new zzds(readStrongBinder6);
                    }
                }
                zzbw.zzb(parcel);
                getCurrentScreenClass(zzdqVar13);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (queryLocalInterface7 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface7;
                    } else {
                        zzdxVar = new zzea(readStrongBinder7);
                    }
                }
                zzbw.zzb(parcel);
                setInstanceIdProvider(zzdxVar);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface8 instanceof zzdq) {
                        zzdqVar12 = (zzdq) queryLocalInterface8;
                    } else {
                        zzdqVar12 = new zzds(readStrongBinder8);
                    }
                }
                zzbw.zzb(parcel);
                getCachedAppInstanceId(zzdqVar12);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface9 instanceof zzdq) {
                        zzdqVar11 = (zzdq) queryLocalInterface9;
                    } else {
                        zzdqVar11 = new zzds(readStrongBinder9);
                    }
                }
                zzbw.zzb(parcel);
                getAppInstanceId(zzdqVar11);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface10 instanceof zzdq) {
                        zzdqVar10 = (zzdq) queryLocalInterface10;
                    } else {
                        zzdqVar10 = new zzds(readStrongBinder10);
                    }
                }
                zzbw.zzb(parcel);
                getGmpAppId(zzdqVar10);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface11 instanceof zzdq) {
                        zzdqVar9 = (zzdq) queryLocalInterface11;
                    } else {
                        zzdqVar9 = new zzds(readStrongBinder11);
                    }
                }
                zzbw.zzb(parcel);
                generateEventId(zzdqVar9);
                break;
            case 23:
                String readString13 = parcel.readString();
                long readLong12 = parcel.readLong();
                zzbw.zzb(parcel);
                beginAdUnitExposure(readString13, readLong12);
                break;
            case 24:
                String readString14 = parcel.readString();
                long readLong13 = parcel.readLong();
                zzbw.zzb(parcel);
                endAdUnitExposure(readString14, readLong13);
                break;
            case 25:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong14 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStarted(asInterface3, readLong14);
                break;
            case 26:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong15 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStopped(asInterface4, readLong15);
                break;
            case 27:
                long readLong16 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityCreated(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (Bundle) zzbw.zza(parcel, Bundle.CREATOR), readLong16);
                break;
            case 28:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong17 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityDestroyed(asInterface5, readLong17);
                break;
            case 29:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong18 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityPaused(asInterface6, readLong18);
                break;
            case 30:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong19 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityResumed(asInterface7, readLong19);
                break;
            case 31:
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface12 instanceof zzdq) {
                        zzdqVar8 = (zzdq) queryLocalInterface12;
                    } else {
                        zzdqVar8 = new zzds(readStrongBinder12);
                    }
                }
                long readLong20 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivitySaveInstanceState(asInterface8, zzdqVar8, readLong20);
                break;
            case 32:
                Bundle bundle2 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface13 instanceof zzdq) {
                        zzdqVar7 = (zzdq) queryLocalInterface13;
                    } else {
                        zzdqVar7 = new zzds(readStrongBinder13);
                    }
                }
                long readLong21 = parcel.readLong();
                zzbw.zzb(parcel);
                performAction(bundle2, zzdqVar7, readLong21);
                break;
            case 33:
                int readInt = parcel.readInt();
                String readString15 = parcel.readString();
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbw.zzb(parcel);
                logHealthData(readInt, readString15, asInterface9, asInterface10, asInterface11);
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface14 instanceof zzdw) {
                        zzdwVar3 = (zzdw) queryLocalInterface14;
                    } else {
                        zzdwVar3 = new zzdy(readStrongBinder14);
                    }
                }
                zzbw.zzb(parcel);
                setEventInterceptor(zzdwVar3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface15 instanceof zzdw) {
                        zzdwVar2 = (zzdw) queryLocalInterface15;
                    } else {
                        zzdwVar2 = new zzdy(readStrongBinder15);
                    }
                }
                zzbw.zzb(parcel);
                registerOnMeasurementEventListener(zzdwVar2);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface16 instanceof zzdw) {
                        zzdwVar = (zzdw) queryLocalInterface16;
                    } else {
                        zzdwVar = new zzdy(readStrongBinder16);
                    }
                }
                zzbw.zzb(parcel);
                unregisterOnMeasurementEventListener(zzdwVar);
                break;
            case 37:
                HashMap zza = zzbw.zza(parcel);
                zzbw.zzb(parcel);
                initForTests(zza);
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface17 instanceof zzdq) {
                        zzdqVar6 = (zzdq) queryLocalInterface17;
                    } else {
                        zzdqVar6 = new zzds(readStrongBinder17);
                    }
                }
                int readInt2 = parcel.readInt();
                zzbw.zzb(parcel);
                getTestFlag(zzdqVar6, readInt2);
                break;
            case 39:
                boolean zzc6 = zzbw.zzc(parcel);
                zzbw.zzb(parcel);
                setDataCollectionEnabled(zzc6);
                break;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface18 instanceof zzdq) {
                        zzdqVar5 = (zzdq) queryLocalInterface18;
                    } else {
                        zzdqVar5 = new zzds(readStrongBinder18);
                    }
                }
                zzbw.zzb(parcel);
                isDataCollectionEnabled(zzdqVar5);
                break;
            case 41:
            case 47:
            case 49:
            default:
                return false;
            case 42:
                zzbw.zzb(parcel);
                setDefaultEventParameters((Bundle) zzbw.zza(parcel, Bundle.CREATOR));
                break;
            case 43:
                long readLong22 = parcel.readLong();
                zzbw.zzb(parcel);
                clearMeasurementEnabled(readLong22);
                break;
            case 44:
                long readLong23 = parcel.readLong();
                zzbw.zzb(parcel);
                setConsent((Bundle) zzbw.zza(parcel, Bundle.CREATOR), readLong23);
                break;
            case 45:
                long readLong24 = parcel.readLong();
                zzbw.zzb(parcel);
                setConsentThirdParty((Bundle) zzbw.zza(parcel, Bundle.CREATOR), readLong24);
                break;
            case 46:
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface19 instanceof zzdq) {
                        zzdqVar4 = (zzdq) queryLocalInterface19;
                    } else {
                        zzdqVar4 = new zzds(readStrongBinder19);
                    }
                }
                zzbw.zzb(parcel);
                getSessionId(zzdqVar4);
                break;
            case 48:
                zzbw.zzb(parcel);
                setSgtmDebugInfo((Intent) zzbw.zza(parcel, Intent.CREATOR));
                break;
            case 50:
                String readString16 = parcel.readString();
                String readString17 = parcel.readString();
                long readLong25 = parcel.readLong();
                zzbw.zzb(parcel);
                setCurrentScreenByScionActivityInfo((zzeb) zzbw.zza(parcel, zzeb.CREATOR), readString16, readString17, readLong25);
                break;
            case 51:
                long readLong26 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStartedByScionActivityInfo((zzeb) zzbw.zza(parcel, zzeb.CREATOR), readLong26);
                break;
            case 52:
                long readLong27 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStoppedByScionActivityInfo((zzeb) zzbw.zza(parcel, zzeb.CREATOR), readLong27);
                break;
            case 53:
                long readLong28 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityCreatedByScionActivityInfo((zzeb) zzbw.zza(parcel, zzeb.CREATOR), (Bundle) zzbw.zza(parcel, Bundle.CREATOR), readLong28);
                break;
            case 54:
                long readLong29 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityDestroyedByScionActivityInfo((zzeb) zzbw.zza(parcel, zzeb.CREATOR), readLong29);
                break;
            case 55:
                long readLong30 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityPausedByScionActivityInfo((zzeb) zzbw.zza(parcel, zzeb.CREATOR), readLong30);
                break;
            case 56:
                long readLong31 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityResumedByScionActivityInfo((zzeb) zzbw.zza(parcel, zzeb.CREATOR), readLong31);
                break;
            case 57:
                zzeb zzebVar = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface20 instanceof zzdq) {
                        zzdqVar3 = (zzdq) queryLocalInterface20;
                    } else {
                        zzdqVar3 = new zzds(readStrongBinder20);
                    }
                }
                long readLong32 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(zzebVar, zzdqVar3, readLong32);
                break;
            case 58:
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    if (queryLocalInterface21 instanceof zzdr) {
                        zzdrVar = (zzdr) queryLocalInterface21;
                    } else {
                        zzdrVar = new zzdt(readStrongBinder21);
                    }
                }
                zzbw.zzb(parcel);
                retrieveAndUploadBatches(zzdrVar);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
