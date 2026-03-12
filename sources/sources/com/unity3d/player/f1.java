package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f1 implements Runnable {
    final /* synthetic */ i1 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f1(i1 i1Var) {
        this.a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a1 a1Var;
        UnityPlayer unityPlayer;
        a1 a1Var2;
        i1 i1Var = this.a;
        a1Var = i1Var.f;
        if (a1Var != null) {
            unityPlayer = i1Var.a;
            unityPlayer.addViewToPlayer(a1Var, true);
            i1 i1Var2 = this.a;
            i1Var2.i = true;
            a1Var2 = i1Var2.f;
            a1Var2.requestFocus();
        }
    }
}
