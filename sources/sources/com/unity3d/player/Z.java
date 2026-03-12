package com.unity3d.player;

import android.view.ViewTreeObserver;
/* loaded from: classes3.dex */
final class Z implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ C0076c0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(C0076c0 c0076c0) {
        this.a = c0076c0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.reportSoftInputArea();
        this.a.h.b();
    }
}
