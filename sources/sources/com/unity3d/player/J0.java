package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class J0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.unity3d.player.a.f fVar;
        UnityPlayer unityPlayer = this.a;
        fVar = unityPlayer.m_SplashScreen;
        unityPlayer.removeView(fVar);
        this.a.m_SplashScreen = null;
    }
}
