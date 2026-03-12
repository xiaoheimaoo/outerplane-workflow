package com.helpshift.poller;

import com.helpshift.log.HSLogger;
import com.helpshift.user.UserManager;
/* loaded from: classes3.dex */
public class ConversationPoller {
    private static final String TAG = "ConvPolr";
    private final PollerController pollerController;
    private final UserManager userManager;

    public ConversationPoller(PollerController pollerController, UserManager userManager) {
        this.pollerController = pollerController;
        this.userManager = userManager;
    }

    public synchronized void startPoller() {
        boolean shouldPoll = this.userManager.shouldPoll();
        boolean isPushTokenSynced = this.userManager.isPushTokenSynced();
        if (shouldPoll && !isPushTokenSynced) {
            HSLogger.d(TAG, "Starting poller.");
            this.pollerController.start();
            return;
        }
        HSLogger.d(TAG, "Not starting poller, shouldPoll: " + shouldPoll + ",  push synced: " + isPushTokenSynced);
    }

    public synchronized void stopPoller() {
        HSLogger.d(TAG, "Stopping poller.");
        this.pollerController.stop();
    }
}
