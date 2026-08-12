package com.google.android.gms.games;

import android.app.Activity;
import com.google.android.gms.internal.games_v2.zzaq;
import com.google.android.gms.internal.games_v2.zzay;
import com.google.android.gms.internal.games_v2.zzbw;
import com.google.android.gms.internal.games_v2.zzcj;
import com.google.android.gms.internal.games_v2.zzcq;
import com.google.android.gms.internal.games_v2.zzcx;
import com.google.android.gms.internal.games_v2.zzdc;
import com.google.android.gms.internal.games_v2.zzdx;
import com.google.android.gms.internal.games_v2.zzea;
import com.google.android.gms.internal.games_v2.zzet;
import com.google.android.gms.internal.games_v2.zzey;
import com.google.android.gms.internal.games_v2.zzfr;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.0.0 */
/* loaded from: classes.dex */
public final class PlayGames {
    private PlayGames() {
    }

    public static AchievementsClient getAchievementsClient(Activity activity) {
        zzbw.zzb();
        return new zzcj(zzaq.zza(zzbw.zzc()));
    }

    public static EventsClient getEventsClient(Activity activity) {
        zzbw.zzb();
        return new zzcq(zzaq.zza(zzbw.zzc()));
    }

    public static GameStatsClient getGameStatsClient(Activity activity) {
        zzbw.zzb();
        return new zzcx(zzaq.zza(zzbw.zzc()));
    }

    public static GamesSignInClient getGamesSignInClient(Activity activity) {
        zzbw.zzb();
        return new zzdc(zzay.zza(zzbw.zzc()), zzaq.zza(zzbw.zzc()));
    }

    public static LeaderboardsClient getLeaderboardsClient(Activity activity) {
        zzbw.zzb();
        return new zzdx(zzaq.zza(zzbw.zzc()));
    }

    public static PlayerStatsClient getPlayerStatsClient(Activity activity) {
        zzbw.zzb();
        return new zzea(zzaq.zza(zzbw.zzc()));
    }

    public static PlayersClient getPlayersClient(Activity activity) {
        zzbw.zzb();
        return new zzet(zzaq.zza(zzbw.zzc()));
    }

    public static RecallClient getRecallClient(Activity activity) {
        zzbw.zzb();
        return new zzey(activity, zzay.zza(zzbw.zzc()));
    }

    public static SnapshotsClient getSnapshotsClient(Activity activity) {
        zzbw.zzb();
        return new zzfr(zzaq.zza(zzbw.zzc()));
    }
}
