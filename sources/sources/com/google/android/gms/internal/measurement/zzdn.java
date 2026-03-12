package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzdn extends zzbu implements zzdl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeLong(j);
        zzb(23, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, bundle);
        zzb(9, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void clearMeasurementEnabled(long j) throws RemoteException {
        Parcel b_ = b_();
        b_.writeLong(j);
        zzb(43, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeLong(j);
        zzb(24, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void generateEventId(zzdq zzdqVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(22, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getAppInstanceId(zzdq zzdqVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(20, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getCachedAppInstanceId(zzdq zzdqVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(19, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getConditionalUserProperties(String str, String str2, zzdq zzdqVar) throws RemoteException {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, zzdqVar);
        zzb(10, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getCurrentScreenClass(zzdq zzdqVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(17, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getCurrentScreenName(zzdq zzdqVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(16, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getGmpAppId(zzdq zzdqVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(21, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getMaxUserProperties(String str, zzdq zzdqVar) throws RemoteException {
        Parcel b_ = b_();
        b_.writeString(str);
        zzbw.zza(b_, zzdqVar);
        zzb(6, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getSessionId(zzdq zzdqVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(46, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getTestFlag(zzdq zzdqVar, int i) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        b_.writeInt(i);
        zzb(38, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getUserProperties(String str, String str2, boolean z, zzdq zzdqVar) throws RemoteException {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, z);
        zzbw.zza(b_, zzdqVar);
        zzb(5, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void initForTests(Map map) throws RemoteException {
        Parcel b_ = b_();
        b_.writeMap(map);
        zzb(37, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void initialize(IObjectWrapper iObjectWrapper, zzdz zzdzVar, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, iObjectWrapper);
        zzbw.zza(b_, zzdzVar);
        b_.writeLong(j);
        zzb(1, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void isDataCollectionEnabled(zzdq zzdqVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(40, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, bundle);
        zzbw.zza(b_, z);
        zzbw.zza(b_, z2);
        b_.writeLong(j);
        zzb(2, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzdq zzdqVar, long j) throws RemoteException {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, bundle);
        zzbw.zza(b_, zzdqVar);
        b_.writeLong(j);
        zzb(3, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel b_ = b_();
        b_.writeInt(i);
        b_.writeString(str);
        zzbw.zza(b_, iObjectWrapper);
        zzbw.zza(b_, iObjectWrapper2);
        zzbw.zza(b_, iObjectWrapper3);
        zzb(33, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, iObjectWrapper);
        zzbw.zza(b_, bundle);
        b_.writeLong(j);
        zzb(27, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityCreatedByScionActivityInfo(zzeb zzebVar, Bundle bundle, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        zzbw.zza(b_, bundle);
        b_.writeLong(j);
        zzb(53, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, iObjectWrapper);
        b_.writeLong(j);
        zzb(28, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityDestroyedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeLong(j);
        zzb(54, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, iObjectWrapper);
        b_.writeLong(j);
        zzb(29, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityPausedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeLong(j);
        zzb(55, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, iObjectWrapper);
        b_.writeLong(j);
        zzb(30, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityResumedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeLong(j);
        zzb(56, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzdq zzdqVar, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, iObjectWrapper);
        zzbw.zza(b_, zzdqVar);
        b_.writeLong(j);
        zzb(31, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzeb zzebVar, zzdq zzdqVar, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        zzbw.zza(b_, zzdqVar);
        b_.writeLong(j);
        zzb(57, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, iObjectWrapper);
        b_.writeLong(j);
        zzb(25, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityStartedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeLong(j);
        zzb(51, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, iObjectWrapper);
        b_.writeLong(j);
        zzb(26, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityStoppedByScionActivityInfo(zzeb zzebVar, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeLong(j);
        zzb(52, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void performAction(Bundle bundle, zzdq zzdqVar, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, bundle);
        zzbw.zza(b_, zzdqVar);
        b_.writeLong(j);
        zzb(32, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void registerOnMeasurementEventListener(zzdw zzdwVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdwVar);
        zzb(35, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel b_ = b_();
        b_.writeLong(j);
        zzb(12, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void retrieveAndUploadBatches(zzdr zzdrVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdrVar);
        zzb(58, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, bundle);
        b_.writeLong(j);
        zzb(8, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, bundle);
        b_.writeLong(j);
        zzb(44, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, bundle);
        b_.writeLong(j);
        zzb(45, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, iObjectWrapper);
        b_.writeString(str);
        b_.writeString(str2);
        b_.writeLong(j);
        zzb(15, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setCurrentScreenByScionActivityInfo(zzeb zzebVar, String str, String str2, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeString(str);
        b_.writeString(str2);
        b_.writeLong(j);
        zzb(50, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, z);
        zzb(39, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, bundle);
        zzb(42, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setEventInterceptor(zzdw zzdwVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdwVar);
        zzb(34, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setInstanceIdProvider(zzdx zzdxVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdxVar);
        zzb(18, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, z);
        b_.writeLong(j);
        zzb(11, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        Parcel b_ = b_();
        b_.writeLong(j);
        zzb(13, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel b_ = b_();
        b_.writeLong(j);
        zzb(14, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setSgtmDebugInfo(Intent intent) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, intent);
        zzb(48, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeLong(j);
        zzb(7, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, iObjectWrapper);
        zzbw.zza(b_, z);
        b_.writeLong(j);
        zzb(4, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void unregisterOnMeasurementEventListener(zzdw zzdwVar) throws RemoteException {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdwVar);
        zzb(36, b_);
    }
}
