package com.helpshift.util;

import com.helpshift.log.HSLogger;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class SafeWrappedRunnable implements Runnable {
    private static final String TAG = "SfeWrpRnnble";
    public final AtomicBoolean inProgress = new AtomicBoolean(false);
    private final Runnable runnable;

    public SafeWrappedRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                this.inProgress.compareAndSet(false, true);
                this.runnable.run();
            } catch (Exception e) {
                HSLogger.e(TAG, "Error running operation", e);
            }
        } finally {
            this.inProgress.compareAndSet(true, false);
        }
    }
}
