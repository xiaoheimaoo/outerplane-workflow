package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.FriendsResolutionRequiredException;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.playergameevent.PlayerGameEvent;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.internal.games_v2.zzfy;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public final class zzai extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private final com.google.android.gms.internal.games_v2.zzac zzf;
    private final String zzg;
    private PlayerEntity zzh;
    private final zzap zzi;
    private boolean zzj;
    private final long zzk;
    private final zzaq zzl;
    private final com.google.android.gms.games.zzi zzm;

    public zzai(Context context, Looper looper, ClientSettings clientSettings, com.google.android.gms.games.zzi zziVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzaq zzaqVar) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzf = new zzj(this);
        this.zzj = false;
        this.zzg = clientSettings.getRealClientPackageName();
        this.zzl = (zzaq) Preconditions.checkNotNull(zzaqVar);
        zzap zzb = zzap.zzb(this, clientSettings.getGravityForPopups());
        this.zzi = zzb;
        this.zzk = hashCode();
        this.zzm = zziVar;
        if (clientSettings.getViewForPopups() != null || (context instanceof Activity)) {
            zzb.zzf(clientSettings.getViewForPopups());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzac(RemoteException remoteException) {
        zzfy.zzf("GamesGmsClientImpl", "service died", remoteException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzad(SecurityException securityException) {
        zzfy.zzh("GamesGmsClientImpl", "Is player signed out?", securityException);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzh = null;
        super.connect(connectionProgressReportCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        return queryLocalInterface instanceof zzao ? (zzao) queryLocalInterface : new zzan(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        this.zzj = false;
        if (isConnected()) {
            try {
                this.zzf.zzb();
                ((zzao) getService()).zzd(this.zzk);
            } catch (RemoteException unused) {
                zzfy.zze("GamesGmsClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.games.zzd.zzm;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getConnectionHint() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", false);
        com.google.android.gms.games.zzi zziVar = this.zzm;
        boolean z = zziVar.zzb;
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", true);
        int i = zziVar.zzc;
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", 17);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", false);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", zziVar.zze);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", null);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", zziVar.zzg);
        bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", false);
        bundle.putBoolean("com.google.android.gms.games.key.skipPgaCheck", false);
        bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", false);
        bundle.putString("com.google.android.gms.games.key.realClientPackageName", null);
        int i2 = zziVar.zzl;
        bundle.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        bundle.putString("com.google.android.gms.games.key.gameRunToken", zziVar.zzm);
        bundle.putBoolean("com.google.android.gms.games.key.isGmsCoreUiInitiatedRequest", false);
        bundle.putString(ServiceSpecificExtraArgs.GamesExtraArgs.GAME_PACKAGE_NAME, this.zzg);
        bundle.putString(ServiceSpecificExtraArgs.GamesExtraArgs.DESIRED_LOCALE, locale);
        bundle.putParcelable(ServiceSpecificExtraArgs.GamesExtraArgs.WINDOW_TOKEN, new BinderWrapper(this.zzi.zzd()));
        if (!bundle.containsKey("com.google.android.gms.games.key.API_VERSION")) {
            bundle.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        }
        bundle.putBundle(ServiceSpecificExtraArgs.GamesExtraArgs.SIGNIN_OPTIONS, SignInClientImpl.createBundleFromClientSettings(getClientSettings()));
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.api.Api.Client
    public final Set getScopesForConnectionlessNonSignIn() {
        return getScopes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* bridge */ /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        zzao zzaoVar = (zzao) iInterface;
        super.onConnectedLocked(zzaoVar);
        if (this.zzj) {
            this.zzi.zzg();
            this.zzj = false;
        }
        try {
            zzaoVar.zzM(new zzk(new com.google.android.gms.internal.games_v2.zzaf(this.zzi.zze())), this.zzk);
        } catch (RemoteException e) {
            zzac(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzj = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0) {
            i = 0;
            if (bundle != null) {
                bundle.setClassLoader(zzai.class.getClassLoader());
                this.zzj = bundle.getBoolean("show_welcome_popup");
                this.zzh = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
                GameEntity gameEntity = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
            }
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        try {
            zzl zzlVar = new zzl(signOutCallbacks);
            this.zzf.zzb();
            try {
                ((zzao) getService()).zze(new zzm(zzlVar));
            } catch (SecurityException unused) {
                zzlVar.setFailedResult(GamesClientStatusCodes.zza(4));
            }
        } catch (RemoteException unused2) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresAccount() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return !this.zzm.zzn.zzc();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(TaskCompletionSource taskCompletionSource, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        try {
            ((zzao) getService()).zzl(new zzz(this, taskCompletionSource), leaderboardScoreBuffer.zza().zza(), i, i2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzB(TaskCompletionSource taskCompletionSource, String str, long j, String str2) throws RemoteException {
        try {
            ((zzao) getService()).zzs(new zzag(taskCompletionSource), str, j, str2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzC(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzao) getService()).zzp(new zzp(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzH(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzao) getService()).zzH(new zzt(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzI(TaskCompletionSource taskCompletionSource, boolean z, String... strArr) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzao) getService()).zzI(new zzt(taskCompletionSource), z, strArr);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzJ(String str, int i) {
        this.zzf.zzc(str, i);
    }

    public final void zzK(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzao) getService()).zzO(new zzac(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzL(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzao) getService()).zzA(new zzab(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzM(TaskCompletionSource taskCompletionSource, String str, boolean z, int i) throws RemoteException {
        try {
            ((zzao) getService()).zzL(new zzah(taskCompletionSource), str, z, i);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzN(TaskCompletionSource taskCompletionSource, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter zza = snapshotMetadataChange.zza();
        if (zza != null) {
            zza.setTempDir(getContext().getCacheDir());
        }
        Contents zza2 = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzao) getService()).zzB(new zzq(taskCompletionSource), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zza2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzO(TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzao) getService()).zzD(new zzr(taskCompletionSource), str);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzP(TaskCompletionSource taskCompletionSource, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        Preconditions.checkState(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter zza = snapshotMetadataChange.zza();
        if (zza != null) {
            zza.setTempDir(getContext().getCacheDir());
        }
        Contents zza2 = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzao) getService()).zzE(new zzah(taskCompletionSource), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zza2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzQ(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            if (this.zzm.zzn.zzb() && this.zzl.zzb()) {
                return;
            }
            try {
                ((zzao) getService()).zzf(iBinder, bundle);
                this.zzl.zzc();
            } catch (RemoteException e) {
                zzac(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzR() {
        if (isConnected()) {
            try {
                ((zzao) getService()).zzg();
            } catch (RemoteException e) {
                zzac(e);
            }
        }
    }

    public final void zzS(TaskCompletionSource taskCompletionSource, String str, boolean z) throws RemoteException {
        ((zzao) getService()).zzS(new zzv(taskCompletionSource), str, z);
    }

    public final void zzT(TaskCompletionSource taskCompletionSource, String str, boolean z, List list) throws RemoteException {
        ((zzao) getService()).zzT(new zzw(taskCompletionSource), str, z, list);
    }

    public final void zzU(PlayerGameEvent playerGameEvent) throws RemoteException {
        try {
            ((zzao) getService()).zzU(playerGameEvent);
        } catch (SecurityException e) {
            zzad(e);
        }
    }

    public final void zzV(TaskCompletionSource taskCompletionSource, PlayerGameEvent playerGameEvent) throws RemoteException {
        try {
            ((zzao) getService()).zzX(new zzs(taskCompletionSource), playerGameEvent);
        } catch (SecurityException e) {
            zzad(e);
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzW(List list) throws RemoteException {
        try {
            ((zzao) getService()).zzV(list);
        } catch (SecurityException e) {
            zzad(e);
        }
    }

    public final void zzX(TaskCompletionSource taskCompletionSource, List list) throws RemoteException {
        try {
            ((zzao) getService()).zzY(new zzs(taskCompletionSource), list);
        } catch (SecurityException e) {
            zzad(e);
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzY() throws RemoteException {
        try {
            ((zzao) getService()).zzW();
        } catch (SecurityException e) {
            zzad(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzZ(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.trySetException(FriendsResolutionRequiredException.zza(GamesClientStatusCodes.zzb(GamesClientStatusCodes.CONSENT_REQUIRED, ((zzao) getService()).zzQ())));
        } catch (RemoteException e) {
            taskCompletionSource.trySetException(e);
        }
    }

    public final void zzq(zzf zzfVar) {
        zzfVar.zzc(this.zzi);
    }

    public final Player zzr() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzh == null) {
                PlayerBuffer playerBuffer = new PlayerBuffer(((zzao) getService()).zzi());
                if (playerBuffer.getCount() > 0) {
                    PlayerEntity playerEntity = new PlayerEntity(playerBuffer.get(0));
                    PlayerEntity playerEntity2 = playerEntity;
                    this.zzh = playerEntity;
                }
                playerBuffer.release();
            }
        }
        return this.zzh;
    }

    public final void zzs(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzao) getService()).zzK(new zzae(taskCompletionSource), null, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzt(TaskCompletionSource taskCompletionSource, String str, boolean z) throws RemoteException {
        try {
            ((zzao) getService()).zzK(new zzae(taskCompletionSource), str, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzu(TaskCompletionSource taskCompletionSource, String str, int i, boolean z, boolean z2) throws RemoteException {
        if (!str.equals("played_with") && !str.equals("friends_all")) {
            throw new IllegalArgumentException("Invalid player collection: ".concat(str));
        }
        try {
            ((zzao) getService()).zzy(new zzad(this, taskCompletionSource), str, i, z, z2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzv(TaskCompletionSource taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzao) getService()).zzq(new zzaa(taskCompletionSource), z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzw(TaskCompletionSource taskCompletionSource, String str, boolean z) throws RemoteException {
        try {
            ((zzao) getService()).zzr(new zzx(taskCompletionSource), str, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzx(TaskCompletionSource taskCompletionSource, String str, int i, int i2) throws RemoteException {
        try {
            ((zzao) getService()).zzu(new zzy(this, taskCompletionSource), null, str, i, i2);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzy(TaskCompletionSource taskCompletionSource, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzao) getService()).zzj(new zzz(this, taskCompletionSource), str, i, i2, i3, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzz(TaskCompletionSource taskCompletionSource, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzao) getService()).zzk(new zzz(this, taskCompletionSource), str, i, i2, i3, z);
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzD(TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        zzo zzoVar = taskCompletionSource == null ? null : new zzo(taskCompletionSource);
        try {
            zzap zzapVar = this.zzi;
            ((zzao) getService()).zzm(zzoVar, str, zzapVar.zzd(), zzapVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzE(TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        zzo zzoVar = taskCompletionSource == null ? null : new zzo(taskCompletionSource);
        try {
            zzap zzapVar = this.zzi;
            ((zzao) getService()).zzn(zzoVar, str, zzapVar.zzd(), zzapVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzF(TaskCompletionSource taskCompletionSource, String str, int i) throws RemoteException {
        zzn zznVar = taskCompletionSource == null ? null : new zzn(taskCompletionSource);
        try {
            zzao zzaoVar = (zzao) getService();
            zzap zzapVar = this.zzi;
            zzaoVar.zzo(zznVar, str, i, zzapVar.zzd(), zzapVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }

    public final void zzG(TaskCompletionSource taskCompletionSource, String str, int i) throws RemoteException {
        zzn zznVar = taskCompletionSource == null ? null : new zzn(taskCompletionSource);
        try {
            zzao zzaoVar = (zzao) getService();
            zzap zzapVar = this.zzi;
            zzaoVar.zzt(zznVar, str, i, zzapVar.zzd(), zzapVar.zzc());
        } catch (SecurityException e) {
            GamesStatusUtils.zza(taskCompletionSource, e);
        }
    }
}
