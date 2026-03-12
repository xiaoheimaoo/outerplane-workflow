package com.unity3d.player;

import android.content.Context;
import java.util.concurrent.Semaphore;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class d1 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ boolean e;
    final /* synthetic */ long f;
    final /* synthetic */ long g;
    final /* synthetic */ i1 h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d1(i1 i1Var, String str, int i, int i2, int i3, boolean z, long j, long j2) {
        this.h = i1Var;
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = j;
        this.g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a1 a1Var;
        Context context;
        UnityPlayer unityPlayer;
        a1 a1Var2;
        UnityPlayer unityPlayer2;
        UnityPlayer unityPlayer3;
        a1 a1Var3;
        Semaphore semaphore;
        i1 i1Var = this.h;
        a1Var = i1Var.f;
        if (a1Var != null) {
            AbstractC0121z.Log(5, "Video already playing");
            i1 i1Var2 = this.h;
            i1Var2.g = 2;
            semaphore = i1Var2.d;
            semaphore.release();
            return;
        }
        i1 i1Var3 = this.h;
        context = i1Var3.b;
        unityPlayer = i1Var3.a;
        i1Var.f = new a1(context, unityPlayer, this.a, this.b, this.c, this.d, this.e, this.f, this.g, new c1(this));
        i1 i1Var4 = this.h;
        a1Var2 = i1Var4.f;
        if (a1Var2 != null) {
            unityPlayer2 = i1Var4.a;
            unityPlayer2.bringToFront();
            i1 i1Var5 = this.h;
            unityPlayer3 = i1Var5.a;
            a1Var3 = i1Var5.f;
            unityPlayer3.addView(a1Var3);
        }
    }
}
