package com.unity3d.player;
/* loaded from: classes3.dex */
final class E0 implements Runnable {
    final /* synthetic */ float a;
    final /* synthetic */ UnityPlayer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E0(UnityPlayer unityPlayer, float f) {
        this.b = unityPlayer;
        this.a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0088i0 c0088i0;
        c0088i0 = this.b.mGlView;
        c0088i0.a(this.a);
    }
}
