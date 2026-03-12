package com.unity3d.player;
/* renamed from: com.unity3d.player.p0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C0102p0 implements G {
    final /* synthetic */ RunnableC0104q0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0102p0(RunnableC0104q0 runnableC0104q0) {
        this.a = runnableC0104q0;
    }

    public final void a() {
        RunnableC0104q0 runnableC0104q0 = this.a;
        runnableC0104q0.a = true;
        if (runnableC0104q0.b) {
            runnableC0104q0.c.release();
        }
    }
}
