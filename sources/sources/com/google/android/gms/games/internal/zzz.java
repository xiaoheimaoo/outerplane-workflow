package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public final class zzz extends zza {
    final /* synthetic */ zzai zza;
    private final TaskCompletionSource zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(zzai zzaiVar, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(zzaiVar);
        this.zza = zzaiVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzak
    public final void zzf(DataHolder dataHolder, DataHolder dataHolder2) {
        int statusCode = dataHolder2.getStatusCode();
        if (statusCode == 10003) {
            this.zza.zzZ(this.zzb);
            dataHolder.close();
            dataHolder2.close();
            return;
        }
        boolean z = statusCode == 3;
        if (statusCode == 0 || z) {
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                Leaderboard freeze = leaderboardBuffer.getCount() > 0 ? leaderboardBuffer.get(0).freeze() : null;
                leaderboardBuffer.close();
                this.zzb.trySetResult(new AnnotatedData(new LeaderboardsClient.LeaderboardScores(freeze, new LeaderboardScoreBuffer(dataHolder2)), z));
                return;
            } catch (Throwable th) {
                try {
                    leaderboardBuffer.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        GamesStatusUtils.zzb(this.zzb, statusCode);
        dataHolder.close();
        dataHolder2.close();
    }
}
