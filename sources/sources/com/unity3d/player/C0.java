package com.unity3d.player;
/* loaded from: classes3.dex */
final class C0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents;
        this.a.setupUnityToBePaused();
        this.a.windowFocusChanged(false);
        iUnityPlayerLifecycleEvents = this.a.m_UnityPlayerLifecycleEvents;
        iUnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
    }
}
