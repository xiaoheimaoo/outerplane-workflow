package com.helpshift.util;

import com.helpshift.concurrency.HSThreadingService;
import com.helpshift.log.HSLogger;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class ConsumeOnceListener<T> {
    private static final String TAG = "ConsumeOnceListener";
    private final AtomicBoolean isUpdateConsumed = new AtomicBoolean(false);
    private final HSThreadingService threadingService;

    public abstract void consume(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public ConsumeOnceListener(HSThreadingService hSThreadingService) {
        this.threadingService = hSThreadingService;
    }

    public void emit(final T t) {
        final int hashCode = hashCode();
        if (!this.isUpdateConsumed.get()) {
            this.isUpdateConsumed.set(true);
            this.threadingService.runOnUIThread(new Runnable() { // from class: com.helpshift.util.ConsumeOnceListener.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    HSLogger.d(ConsumeOnceListener.TAG, "Executing consume of event in callback: " + hashCode);
                    ConsumeOnceListener.this.consume(t);
                }
            });
            return;
        }
        HSLogger.d(TAG, "Skipping consume of event in callback: " + hashCode);
    }
}
