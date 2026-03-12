package com.unity3d.player;

import android.app.Activity;
import android.os.SystemClock;
import android.view.KeyEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class H0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        Activity activity2;
        long uptimeMillis = SystemClock.uptimeMillis();
        KeyEvent keyEvent = new KeyEvent(uptimeMillis, uptimeMillis, 0, 4, 1, 0, -1, 0, 0, 257);
        KeyEvent keyEvent2 = new KeyEvent(uptimeMillis, uptimeMillis + 1, 1, 4, 1, 0, -1, 0, 0, 257);
        activity = this.a.mActivity;
        activity.dispatchKeyEvent(keyEvent);
        activity2 = this.a.mActivity;
        activity2.dispatchKeyEvent(keyEvent2);
    }
}
