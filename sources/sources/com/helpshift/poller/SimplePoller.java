package com.helpshift.poller;

import com.helpshift.log.HSLogger;
import com.helpshift.util.SafeWrappedRunnable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SimplePoller {
    private static final String TAG = "SimplePoller";
    private boolean isRunning;
    private final PollFunction pollFunction;
    private final String pollerName;
    private final long pollingInterval;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
    private boolean shouldStop;

    public SimplePoller(PollFunction pollFunction, long j, String str, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.scheduledThreadPoolExecutor = scheduledThreadPoolExecutor;
        this.pollingInterval = j;
        this.pollFunction = pollFunction;
        this.pollerName = str;
    }

    public void start() {
        this.shouldStop = false;
        if (!this.isRunning) {
            HSLogger.d(TAG, "Starting poller: " + this.pollerName);
            scheduleNextPoll();
            this.isRunning = true;
            return;
        }
        HSLogger.d(TAG, "Poller already running, skipping start again: " + this.pollerName);
    }

    public void stop() {
        HSLogger.d(TAG, "Stopping poller: " + this.pollerName);
        this.shouldStop = true;
        this.isRunning = false;
        try {
            this.scheduledThreadPoolExecutor.getQueue().clear();
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in clearing the polling queue.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleNextPoll() {
        if (this.shouldStop) {
            HSLogger.d(TAG, "Stop signalled, stopping poller: " + this.pollerName);
            return;
        }
        HSLogger.d(TAG, "Scheduling next poll: " + this.pollerName);
        try {
            this.scheduledThreadPoolExecutor.schedule(new SafeWrappedRunnable(new Runnable() { // from class: com.helpshift.poller.SimplePoller.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SimplePoller.this.pollFunction.execute()) {
                        SimplePoller.this.scheduleNextPoll();
                        return;
                    }
                    SimplePoller.this.isRunning = false;
                    SimplePoller.this.shouldStop = true;
                }
            }), this.pollingInterval, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in scheduling next poll: " + this.pollerName, e);
        }
    }
}
