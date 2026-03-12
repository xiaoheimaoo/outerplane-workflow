package com.helpshift.lifecycle;

import com.helpshift.log.HSLogger;
/* loaded from: classes3.dex */
public abstract class BaseLifeCycleTracker {
    private static final String TAG = "LifecycleTkr";
    private final HSAppLifeCycleEventsHandler hsAppLifeCycleEventsHandler;

    public abstract void onManualAppBackgroundAPI();

    public abstract void onManualAppForegroundAPI();

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseLifeCycleTracker(HSAppLifeCycleEventsHandler hSAppLifeCycleEventsHandler) {
        this.hsAppLifeCycleEventsHandler = hSAppLifeCycleEventsHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyAppForeground() {
        HSLogger.d(TAG, "App is in foreground");
        this.hsAppLifeCycleEventsHandler.onAppForeground();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyAppBackground() {
        HSLogger.d(TAG, "App is in background");
        this.hsAppLifeCycleEventsHandler.onAppBackground();
    }
}
