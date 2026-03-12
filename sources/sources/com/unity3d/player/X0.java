package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class X0 implements Runnable {
    final /* synthetic */ a1 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X0(a1 a1Var) {
        this.a = a1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.destroyPlayer();
        this.a.a(3);
    }
}
