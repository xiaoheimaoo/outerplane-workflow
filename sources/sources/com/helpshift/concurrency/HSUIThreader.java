package com.helpshift.concurrency;

import android.os.Handler;
import android.os.Looper;
import com.helpshift.log.HSLogger;
import com.helpshift.util.SafeWrappedRunnable;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class HSUIThreader implements HSThreader {
    private static final String TAG = "HSUIThreader";

    @Override // com.helpshift.concurrency.HSThreader
    public AtomicBoolean submit(Runnable runnable) {
        try {
            SafeWrappedRunnable safeWrappedRunnable = new SafeWrappedRunnable(runnable);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                safeWrappedRunnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(safeWrappedRunnable);
            }
            return safeWrappedRunnable.inProgress;
        } catch (Exception e) {
            HSLogger.e(TAG, "Error executing task in UI threader", e);
            return new AtomicBoolean(false);
        }
    }
}
