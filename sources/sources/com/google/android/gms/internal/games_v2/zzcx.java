package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.GameStatsClient;
import com.google.android.gms.games.playergameevent.PlayerGameEvent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.0.0 */
/* loaded from: classes2.dex */
public final class zzcx implements GameStatsClient {
    private final zzaq zza;

    public zzcx(zzaq zzaqVar) {
        this.zza = zzaqVar;
    }

    @Override // com.google.android.gms.games.GameStatsClient
    public final void recordEvent(final PlayerGameEvent playerGameEvent) {
        Preconditions.checkNotNull(playerGameEvent, "event must not be null");
        this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzcw
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final PlayerGameEvent playerGameEvent2 = PlayerGameEvent.this;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcv
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzY(PlayerGameEvent.this);
                        ((TaskCompletionSource) obj2).setResult(null);
                    }
                }).setMethodKey(6751).setFeatures(com.google.android.gms.games.zzd.zzj).build());
            }
        });
    }

    @Override // com.google.android.gms.games.GameStatsClient
    public final void recordEvents(final List<PlayerGameEvent> list) {
        Preconditions.checkNotNull(list, "events must not be null");
        this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzcr
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final List list2 = list;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcu
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzZ(list2);
                        ((TaskCompletionSource) obj2).setResult(null);
                    }
                }).setMethodKey(6752).setFeatures(com.google.android.gms.games.zzd.zzj).build());
            }
        });
    }

    @Override // com.google.android.gms.games.GameStatsClient
    public final void requestEventsUpload() {
        this.zza.zzb(zzcs.zza);
    }
}
