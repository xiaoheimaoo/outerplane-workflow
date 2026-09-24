package com.google.android.gms.games;

import com.google.android.gms.games.playergameevent.PlayerGameEvent;
import com.google.android.gms.tasks.Task;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public interface GameStatsClient {
    void recordEvent(PlayerGameEvent playerGameEvent);

    Task<Void> recordEventImmediate(PlayerGameEvent playerGameEvent);

    void recordEvents(List<PlayerGameEvent> list);

    Task<Void> recordEventsImmediate(List<PlayerGameEvent> list);

    void requestEventsUpload();
}
