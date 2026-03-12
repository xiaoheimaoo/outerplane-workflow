package com.helpshift.concurrency;

import com.helpshift.log.HSLogger;
import com.helpshift.util.SafeWrappedRunnable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class HSWorkerThreader implements HSThreader {
    private static final String TAG = "HSThreader";
    private final ExecutorService executorService;

    public HSWorkerThreader(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override // com.helpshift.concurrency.HSThreader
    public AtomicBoolean submit(Runnable runnable) {
        try {
            SafeWrappedRunnable safeWrappedRunnable = new SafeWrappedRunnable(runnable);
            this.executorService.submit(safeWrappedRunnable);
            return safeWrappedRunnable.inProgress;
        } catch (Exception e) {
            HSLogger.e(TAG, "Error while submitting request.", e);
            return new AtomicBoolean(false);
        }
    }
}
