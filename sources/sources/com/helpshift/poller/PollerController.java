package com.helpshift.poller;

import com.helpshift.log.HSLogger;
import com.helpshift.user.UserManager;
import com.helpshift.util.SafeWrappedRunnable;
import com.helpshift.util.Utils;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class PollerController {
    private static final String TAG = "PolerCntlr";
    private final ExponentialBackoff exponentialBackoff;
    private boolean isRunning;
    private final FetchNotificationUpdate pollFunction;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
    private boolean shouldStop;
    private final UserManager userManager;

    public PollerController(FetchNotificationUpdate fetchNotificationUpdate, UserManager userManager, ExponentialBackoff exponentialBackoff, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.pollFunction = fetchNotificationUpdate;
        this.userManager = userManager;
        this.exponentialBackoff = exponentialBackoff;
        this.scheduledThreadPoolExecutor = scheduledThreadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        this.shouldStop = false;
        if (this.isRunning) {
            return;
        }
        scheduleNextPoll(0);
        this.isRunning = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        this.shouldStop = true;
        this.isRunning = false;
        this.exponentialBackoff.reset();
        try {
            this.scheduledThreadPoolExecutor.getQueue().clear();
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in clearing the polling queue.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleNextPoll(int i) {
        if (this.shouldStop || !this.userManager.shouldPoll() || i == -1) {
            HSLogger.d(TAG, "Stopping poller, shouldPoll is false or STOP_POLLING received.");
            return;
        }
        this.exponentialBackoff.reconcileIntervals(this.userManager.getPollingBaseInterval(), this.userManager.getPollingMaxInterval());
        int nextInterval = this.exponentialBackoff.nextInterval(i);
        if (nextInterval == -1) {
            HSLogger.d(TAG, "Stopping poller, request failed");
            return;
        }
        HSLogger.d(TAG, "Scheduling next poll with interval: " + nextInterval);
        try {
            this.scheduledThreadPoolExecutor.schedule(new SafeWrappedRunnable(new Runnable() { // from class: com.helpshift.poller.PollerController.1
                @Override // java.lang.Runnable
                public void run() {
                    PollerController.this.scheduleNextPoll(PollerController.this.pollFunction.execute(Utils.ORIGIN_POLLER, PollerController.this.userManager.getHashForActiveUser()));
                }
            }), nextInterval, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in scheduling next poll", e);
        }
    }
}
