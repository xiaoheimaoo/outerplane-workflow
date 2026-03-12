package com.unity3d.player;
/* renamed from: com.unity3d.player.n0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC0098n0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0098n0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0088i0 c0088i0;
        c0088i0 = this.a.mGlView;
        if (c0088i0 != null) {
            c0088i0.b();
        }
    }
}
