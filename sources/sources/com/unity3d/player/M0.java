package com.unity3d.player;
/* loaded from: classes3.dex */
final class M0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        C0088i0 c0088i0;
        C0088i0 c0088i02;
        C0088i0 c0088i03;
        UnityPlayer unityPlayer = this.a;
        z = unityPlayer.mMainDisplayOverride;
        if (z) {
            c0088i03 = unityPlayer.mGlView;
            unityPlayer.removeView(c0088i03);
            return;
        }
        c0088i0 = unityPlayer.mGlView;
        if (c0088i0.getParent() != null) {
            AbstractC0121z.Log(5, "Couldn't add view, because it's already assigned to another parent");
            return;
        }
        UnityPlayer unityPlayer2 = this.a;
        c0088i02 = unityPlayer2.mGlView;
        unityPlayer2.addView(c0088i02);
    }
}
