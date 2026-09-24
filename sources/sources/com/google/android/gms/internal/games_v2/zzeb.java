package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
public final class zzeb implements LeaderboardsClient {
    private final zzaq zza;

    public zzeb(zzaq zzaqVar) {
        this.zza = zzaqVar;
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<Intent> getAllLeaderboardsIntent() {
        return this.zza.zzb(zzea.zza);
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<Intent> getLeaderboardIntent(String str) {
        return getLeaderboardIntent(str, -1, -1);
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardScore>> loadCurrentPlayerLeaderboardScore(final String str, final int i, final int i2) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzdt
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdm
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzai) obj).zzx((TaskCompletionSource) obj2, str2, i3, i4);
                    }
                }).setMethodKey(6703).build());
            }
        });
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<Leaderboard>> loadLeaderboardMetadata(final String str, final boolean z) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzds
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final boolean z2 = z;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdn
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzai) obj).zzw((TaskCompletionSource) obj2, str2, z2);
                    }
                }).setMethodKey(6702).build());
            }
        });
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadMoreScores(final LeaderboardScoreBuffer leaderboardScoreBuffer, final int i, final int i2) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzdw
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final LeaderboardScoreBuffer leaderboardScoreBuffer2 = LeaderboardScoreBuffer.this;
                final int i3 = i;
                final int i4 = i2;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdj
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzai) obj).zzA((TaskCompletionSource) obj2, LeaderboardScoreBuffer.this, i3, i4);
                    }
                }).setMethodKey(6706).build());
            }
        });
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadPlayerCenteredScores(String str, int i, int i2, int i3) {
        return this.zza.zzb(new zzdv(str, i, i2, i3, false));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadTopScores(String str, int i, int i2, int i3) {
        return this.zza.zzb(new zzdu(str, i, i2, i3, false));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final void submitScore(String str, long j) {
        this.zza.zzb(new zzdx(str, j));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<ScoreSubmissionData> submitScoreImmediate(String str, long j) {
        return this.zza.zzb(new zzdx(str, j));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<Intent> getLeaderboardIntent(String str, int i) {
        return getLeaderboardIntent(str, i, -1);
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardBuffer>> loadLeaderboardMetadata(final boolean z) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzdr
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final boolean z2 = z;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdo
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzai) obj).zzv((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6702).build());
            }
        });
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadPlayerCenteredScores(String str, int i, int i2, int i3, boolean z) {
        return this.zza.zzb(new zzdv(str, i, i2, i3, z));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadTopScores(String str, int i, int i2, int i3, boolean z) {
        return this.zza.zzb(new zzdu(str, i, i2, i3, z));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final void submitScore(String str, long j, String str2) {
        this.zza.zzb(new zzdy(str, j, str2));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<ScoreSubmissionData> submitScoreImmediate(String str, long j, String str2) {
        return this.zza.zzb(new zzdy(str, j, str2));
    }

    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<Intent> getLeaderboardIntent(final String str, final int i, final int i2) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzdh
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdp
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).trySetResult(((com.google.android.gms.games.internal.zzao) ((com.google.android.gms.games.internal.zzai) obj).getService()).zzP(str2, i3, i4));
                    }
                }).setMethodKey(6701).build());
            }
        });
    }
}
