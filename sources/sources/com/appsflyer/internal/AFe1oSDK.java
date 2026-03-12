package com.appsflyer.internal;

import java.util.TimerTask;
/* loaded from: classes.dex */
public final class AFe1oSDK extends TimerTask {
    private final Thread getMediationNetwork;

    public AFe1oSDK(Thread thread) {
        this.getMediationNetwork = thread;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.getMediationNetwork.interrupt();
    }
}
