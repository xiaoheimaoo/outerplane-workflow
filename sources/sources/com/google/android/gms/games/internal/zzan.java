package com.google.android.gms.games.internal;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.playergameevent.PlayerGameEvent;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.0.0 */
/* loaded from: classes.dex */
public interface zzan extends IInterface {
    void zzA(zzaj zzajVar, boolean z) throws RemoteException;

    void zzB(zzaj zzajVar, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException;

    void zzC(Contents contents) throws RemoteException;

    void zzD(zzaj zzajVar, String str) throws RemoteException;

    void zzE(zzaj zzajVar, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException;

    int zzF() throws RemoteException;

    int zzG() throws RemoteException;

    void zzH(zzaj zzajVar, boolean z) throws RemoteException;

    void zzI(zzaj zzajVar, boolean z, String[] strArr) throws RemoteException;

    void zzJ(String str, int i) throws RemoteException;

    void zzK(zzaj zzajVar, String str, boolean z) throws RemoteException;

    void zzL(zzaj zzajVar, String str, boolean z, int i) throws RemoteException;

    void zzM(zzal zzalVar, long j) throws RemoteException;

    Intent zzN(PlayerEntity playerEntity) throws RemoteException;

    void zzO(zzaj zzajVar, boolean z) throws RemoteException;

    Intent zzP(String str, int i, int i2) throws RemoteException;

    PendingIntent zzQ() throws RemoteException;

    Intent zzR(String str, String str2, String str3) throws RemoteException;

    void zzS(zzaj zzajVar, String str, boolean z) throws RemoteException;

    void zzT(zzaj zzajVar, String str, boolean z, List list) throws RemoteException;

    void zzU(PlayerGameEvent playerGameEvent) throws RemoteException;

    void zzV(List list) throws RemoteException;

    void zzW() throws RemoteException;

    void zzd(long j) throws RemoteException;

    void zze(zzaj zzajVar) throws RemoteException;

    void zzf(IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzg() throws RemoteException;

    String zzh() throws RemoteException;

    DataHolder zzi() throws RemoteException;

    void zzj(zzaj zzajVar, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void zzk(zzaj zzajVar, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void zzl(zzaj zzajVar, Bundle bundle, int i, int i2) throws RemoteException;

    void zzm(zzaj zzajVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzn(zzaj zzajVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzo(zzaj zzajVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzp(zzaj zzajVar, boolean z) throws RemoteException;

    void zzq(zzaj zzajVar, boolean z) throws RemoteException;

    void zzr(zzaj zzajVar, String str, boolean z) throws RemoteException;

    void zzs(zzaj zzajVar, String str, long j, String str2) throws RemoteException;

    void zzt(zzaj zzajVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzu(zzaj zzajVar, String str, String str2, int i, int i2) throws RemoteException;

    Intent zzv() throws RemoteException;

    Intent zzw() throws RemoteException;

    Intent zzx() throws RemoteException;

    void zzy(zzaj zzajVar, String str, int i, boolean z, boolean z2) throws RemoteException;

    Intent zzz(String str, boolean z, boolean z2, int i) throws RemoteException;
}
