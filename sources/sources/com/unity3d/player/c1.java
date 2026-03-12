package com.unity3d.player;
/* loaded from: classes3.dex */
final class c1 implements Y0 {
    final /* synthetic */ d1 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c1(d1 d1Var) {
        this.a = d1Var;
    }

    public final void a(int i) {
        i1.m500$$Nest$fgete(this.a.h).lock();
        i1 i1Var = this.a.h;
        i1.m504$$Nest$fputg(i1Var, i);
        if (i == 3 && i1.m502$$Nest$fgeti(i1Var)) {
            i1Var.runOnUiThread(new b1(this));
        }
        if (i != 0) {
            i1.m499$$Nest$fgetd(this.a.h).release();
        }
        i1.m500$$Nest$fgete(this.a.h).unlock();
    }
}
