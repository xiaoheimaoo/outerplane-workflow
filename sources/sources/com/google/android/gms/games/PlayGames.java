package com.google.android.gms.games;

import android.app.Activity;
import com.google.android.gms.internal.games_v2.zzaq;
import com.google.android.gms.internal.games_v2.zzay;
import com.google.android.gms.internal.games_v2.zzbw;
import com.google.android.gms.internal.games_v2.zzcj;
import com.google.android.gms.internal.games_v2.zzcq;
import com.google.android.gms.internal.games_v2.zzdb;
import com.google.android.gms.internal.games_v2.zzdg;
import com.google.android.gms.internal.games_v2.zzeb;
import com.google.android.gms.internal.games_v2.zzee;
import com.google.android.gms.internal.games_v2.zzex;
import com.google.android.gms.internal.games_v2.zzfc;
import com.google.android.gms.internal.games_v2.zzfv;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
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
        return new zzdb(zzaq.zza(zzbw.zzc()));
    }

    public static GamesSignInClient getGamesSignInClient(Activity activity) {
        zzbw.zzb();
        return new zzdg(zzay.zza(zzbw.zzc()), zzaq.zza(zzbw.zzc()));
    }

    public static LeaderboardsClient getLeaderboardsClient(Activity activity) {
        zzbw.zzb();
        return new zzeb(zzaq.zza(zzbw.zzc()));
    }

    public static PlayerStatsClient getPlayerStatsClient(Activity activity) {
        zzbw.zzb();
        return new zzee(zzaq.zza(zzbw.zzc()));
    }

    public static PlayersClient getPlayersClient(Activity activity) {
        zzbw.zzb();
        return new zzex(zzaq.zza(zzbw.zzc()));
    }

    public static RecallClient getRecallClient(Activity activity) {
        zzbw.zzb();
        return new zzfc(activity, zzay.zza(zzbw.zzc()));
    }

    public static SnapshotsClient getSnapshotsClient(Activity activity) {
        zzbw.zzb();
        return new zzfv(zzaq.zza(zzbw.zzc()));
    }
}
