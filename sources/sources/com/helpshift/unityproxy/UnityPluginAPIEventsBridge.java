package com.helpshift.unityproxy;

import android.app.PendingIntent;
import android.content.Context;
import com.helpshift.HSPluginEventBridge;
import com.helpshift.unityproxy.utils.IntentProvider;
import com.unity3d.player.UnityPlayer;
/* loaded from: classes3.dex */
public class UnityPluginAPIEventsBridge implements HSPluginEventBridge.PluginEventsAPI {
    @Override // com.helpshift.HSPluginEventBridge.PluginEventsAPI
    public PendingIntent getPendingIntentForNotification(Context context, PendingIntent pendingIntent) {
        return IntentProvider.wrapPendingIntentWithUnityDelegateActivity(context, pendingIntent);
    }

    @Override // com.helpshift.HSPluginEventBridge.PluginEventsAPI
    public boolean shouldCallFirstForegroundEvent() {
        return UnityPlayer.currentActivity != null;
    }
}
