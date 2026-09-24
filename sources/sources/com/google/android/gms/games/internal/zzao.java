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
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public interface zzao extends IInterface {
    void zzA(zzak zzakVar, boolean z) throws RemoteException;

    void zzB(zzak zzakVar, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException;

    void zzC(Contents contents) throws RemoteException;

    void zzD(zzak zzakVar, String str) throws RemoteException;

    void zzE(zzak zzakVar, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException;

    int zzF() throws RemoteException;

    int zzG() throws RemoteException;

    void zzH(zzak zzakVar, boolean z) throws RemoteException;

    void zzI(zzak zzakVar, boolean z, String[] strArr) throws RemoteException;

    void zzJ(String str, int i) throws RemoteException;

    void zzK(zzak zzakVar, String str, boolean z) throws RemoteException;

    void zzL(zzak zzakVar, String str, boolean z, int i) throws RemoteException;

    void zzM(zzam zzamVar, long j) throws RemoteException;

    Intent zzN(PlayerEntity playerEntity) throws RemoteException;

    void zzO(zzak zzakVar, boolean z) throws RemoteException;

    Intent zzP(String str, int i, int i2) throws RemoteException;

    PendingIntent zzQ() throws RemoteException;

    Intent zzR(String str, String str2, String str3) throws RemoteException;

    void zzS(zzak zzakVar, String str, boolean z) throws RemoteException;

    void zzT(zzak zzakVar, String str, boolean z, List list) throws RemoteException;

    void zzU(PlayerGameEvent playerGameEvent) throws RemoteException;

    void zzV(List list) throws RemoteException;

    void zzW() throws RemoteException;

    void zzX(zzak zzakVar, PlayerGameEvent playerGameEvent) throws RemoteException;

    void zzY(zzak zzakVar, List list) throws RemoteException;

    void zzd(long j) throws RemoteException;

    void zze(zzak zzakVar) throws RemoteException;

    void zzf(IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzg() throws RemoteException;

    String zzh() throws RemoteException;

    DataHolder zzi() throws RemoteException;

    void zzj(zzak zzakVar, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void zzk(zzak zzakVar, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void zzl(zzak zzakVar, Bundle bundle, int i, int i2) throws RemoteException;

    void zzm(zzak zzakVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzn(zzak zzakVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzo(zzak zzakVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzp(zzak zzakVar, boolean z) throws RemoteException;

    void zzq(zzak zzakVar, boolean z) throws RemoteException;

    void zzr(zzak zzakVar, String str, boolean z) throws RemoteException;

    void zzs(zzak zzakVar, String str, long j, String str2) throws RemoteException;

    void zzt(zzak zzakVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzu(zzak zzakVar, String str, String str2, int i, int i2) throws RemoteException;

    Intent zzv() throws RemoteException;

    Intent zzw() throws RemoteException;

    Intent zzx() throws RemoteException;

    void zzy(zzak zzakVar, String str, int i, boolean z, boolean z2) throws RemoteException;

    Intent zzz(String str, boolean z, boolean z2, int i) throws RemoteException;
}
