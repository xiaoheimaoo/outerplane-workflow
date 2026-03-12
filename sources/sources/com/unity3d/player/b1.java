package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b1 implements Runnable {
    final /* synthetic */ c1 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(c1 c1Var) {
        this.a = c1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a1 a1Var;
        UnityPlayer unityPlayer;
        UnityPlayer unityPlayer2;
        a1 a1Var2;
        h1 h1Var;
        i1 i1Var = this.a.a.h;
        a1Var = i1Var.f;
        if (a1Var != null) {
            unityPlayer2 = i1Var.a;
            unityPlayer2.removeViewFromPlayer(a1Var);
            i1Var.i = false;
            a1Var2 = i1Var.f;
            a1Var2.destroyPlayer();
            i1Var.f = null;
            h1Var = i1Var.c;
            if (h1Var != null) {
                ((A0) h1Var).a();
            }
        }
        unityPlayer = this.a.a.h.a;
        unityPlayer.onResume();
    }
}
