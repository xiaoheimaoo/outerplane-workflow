package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class i1 {
    private UnityPlayer a;
    private h1 c;
    private Context b = null;
    private final Semaphore d = new Semaphore(0);
    private final ReentrantLock e = new ReentrantLock();
    private a1 f = null;
    private int g = 2;
    private boolean h = false;
    private boolean i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: -$$Nest$fgetd  reason: not valid java name */
    public static /* bridge */ /* synthetic */ Semaphore m499$$Nest$fgetd(i1 i1Var) {
        return i1Var.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: -$$Nest$fgete  reason: not valid java name */
    public static /* bridge */ /* synthetic */ ReentrantLock m500$$Nest$fgete(i1 i1Var) {
        return i1Var.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: -$$Nest$fgeti  reason: not valid java name */
    public static /* bridge */ /* synthetic */ boolean m502$$Nest$fgeti(i1 i1Var) {
        return i1Var.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: -$$Nest$fputg  reason: not valid java name */
    public static /* bridge */ /* synthetic */ void m504$$Nest$fputg(i1 i1Var, int i) {
        i1Var.g = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i1(UnityPlayer unityPlayer) {
        this.a = null;
        this.a = unityPlayer;
    }

    public final void a() {
        this.e.lock();
        a1 a1Var = this.f;
        if (a1Var != null) {
            a1Var.updateVideoLayout();
        }
        this.e.unlock();
    }

    public final boolean a(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, h1 h1Var) {
        this.e.lock();
        this.c = h1Var;
        this.b = context;
        this.d.drainPermits();
        this.g = 2;
        runOnUiThread(new d1(this, str, i, i2, i3, z, j, j2));
        boolean z2 = false;
        try {
            this.e.unlock();
            this.d.acquire();
            this.e.lock();
            if (this.g != 2) {
                z2 = true;
            }
        } catch (InterruptedException unused) {
        }
        runOnUiThread(new e1(this));
        runOnUiThread((!z2 || this.g == 3) ? new g1(this) : new f1(this));
        this.e.unlock();
        return z2;
    }

    public final void b() {
        this.e.lock();
        a1 a1Var = this.f;
        if (a1Var != null) {
            if (this.g == 0) {
                a1Var.cancelOnPrepare();
            } else if (this.i) {
                boolean a = a1Var.a();
                this.h = a;
                if (!a) {
                    this.f.pause();
                }
            }
        }
        this.e.unlock();
    }

    public final void c() {
        this.e.lock();
        a1 a1Var = this.f;
        if (a1Var != null && this.i && !this.h) {
            a1Var.start();
        }
        this.e.unlock();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnUiThread(Runnable runnable) {
        Context context = this.b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            AbstractC0121z.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}
