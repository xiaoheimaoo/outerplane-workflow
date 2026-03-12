package com.helpshift.lifecycle;

import com.helpshift.core.HSContext;
import com.helpshift.user.UserManager;
/* loaded from: classes3.dex */
public class HSAppLifeCycleEventsHandler {
    public void onAppForeground() {
        HSContext.getInstance().getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.lifecycle.HSAppLifeCycleEventsHandler.1
            @Override // java.lang.Runnable
            public void run() {
                HSContext hSContext = HSContext.getInstance();
                hSContext.getAnalyticsEventDM().sendAppLaunchEvent();
                hSContext.getAnalyticsEventDM().sendFailedEvents();
                hSContext.sendMigrationFailureLogs();
                UserManager userManager = hSContext.getUserManager();
                if (!userManager.retryPushTokenSync() && !hSContext.isWebchatUIOpen()) {
                    hSContext.getConversationPoller().startPoller();
                }
                userManager.scanRefreshTokenExpiry();
                userManager.collectAndStoreSDKCollectibleAttributes();
                userManager.triggerIdentityAttributeSync();
                userManager.startIdentityDataSyncPoller("app_foreground");
            }
        });
    }

    public void onAppBackground() {
        final HSContext hSContext = HSContext.getInstance();
        hSContext.getHsThreadingService().runSerial(new Runnable() { // from class: com.helpshift.lifecycle.HSAppLifeCycleEventsHandler.2
            @Override // java.lang.Runnable
            public void run() {
                hSContext.getConversationPoller().stopPoller();
                hSContext.getUserManager().stopIdentityDataSyncPoller("app_background");
            }
        });
    }
}
