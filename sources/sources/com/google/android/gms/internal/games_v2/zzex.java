package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
public final class zzex implements PlayersClient {
    private final zzaq zza;

    public zzex(zzaq zzaqVar) {
        this.zza = zzaqVar;
    }

    private final Task zza(final String str, final int i, final boolean z) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzes
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final int i2 = i;
                final boolean z2 = z;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzev
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzai) obj).zzu((TaskCompletionSource) obj2, str2, i2, false, z2);
                    }
                }).setMethodKey(6715).build());
            }
        });
    }

    private final Task zzb(final String str, final int i) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzet
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final int i2 = i;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzeu
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzai) obj).zzu((TaskCompletionSource) obj2, str2, i2, true, false);
                    }
                }).setMethodKey(6716).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<Intent> getCompareProfileIntent(final Player player) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzeq
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final Player player2 = Player.this;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzeh
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        PlayerEntity playerEntity = new PlayerEntity(Player.this);
                        Intent zzN = ((com.google.android.gms.games.internal.zzao) ((com.google.android.gms.games.internal.zzai) obj).getService()).zzN(playerEntity);
                        zzN.setExtrasClassLoader(playerEntity.getClass().getClassLoader());
                        ((TaskCompletionSource) obj2).trySetResult(zzN);
                    }
                }).setMethodKey(6713).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<Intent> getCompareProfileIntentWithAlternativeNameHints(String str, String str2, String str3) {
        return this.zza.zzb(new zzep(str, str2, str3));
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<Player> getCurrentPlayer() {
        return this.zza.zzb(zzef.zza);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<String> getCurrentPlayerId() {
        return this.zza.zzb(zzew.zza);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<Intent> getPlayerSearchIntent() {
        return this.zza.zzb(zzer.zza);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<PlayerBuffer>> loadFriends(int i, boolean z) {
        return zza("friends_all", i, z);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<PlayerBuffer>> loadMoreFriends(int i) {
        return zzb("friends_all", i);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<PlayerBuffer>> loadMoreRecentlyPlayedWithPlayers(int i) {
        return zzb("played_with", i);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<Player>> loadPlayer(String str) {
        return this.zza.zzb(new zzeo(str, false));
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<PlayerBuffer>> loadRecentlyPlayedWithPlayers(int i, boolean z) {
        return zza("played_with", i, z);
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<Intent> getCompareProfileIntent(String str) {
        return this.zza.zzb(new zzep(str, null, null));
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<Player>> getCurrentPlayer(final boolean z) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzen
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final boolean z2 = z;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzek
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzai) obj).zzs((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6710).build());
            }
        });
    }

    @Override // com.google.android.gms.games.PlayersClient
    public final Task<AnnotatedData<Player>> loadPlayer(String str, boolean z) {
        return this.zza.zzb(new zzeo(str, z));
    }
}
