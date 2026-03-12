package com.unity3d.player;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class C {
    protected Runnable b;
    protected com.unity3d.player.a.c a = null;
    protected boolean c = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public C(Runnable runnable) {
        this.b = runnable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerOnBackPressedCallback() {
        if (this.a != null) {
            return;
        }
        this.a = new B(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unregisterOnBackPressedCallback() {
        this.a = null;
    }
}
