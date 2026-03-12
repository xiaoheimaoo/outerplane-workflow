package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class T implements Runnable {
    final /* synthetic */ U a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(U u) {
        this.a = u;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S s = this.a.d;
        s.a(s.b(), true);
    }
}
