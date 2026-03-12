package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e1 implements Runnable {
    final /* synthetic */ i1 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(i1 i1Var) {
        this.a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer;
        unityPlayer = this.a.a;
        unityPlayer.onPause();
    }
}
