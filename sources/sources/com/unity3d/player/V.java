package com.unity3d.player;
/* loaded from: classes3.dex */
final class V implements Runnable {
    final /* synthetic */ X a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(X x) {
        this.a = x;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c.requestFocus();
        this.a.f();
    }
}
