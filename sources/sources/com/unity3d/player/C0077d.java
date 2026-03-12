package com.unity3d.player;

import android.window.OnBackInvokedCallback;
/* renamed from: com.unity3d.player.d  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C0077d implements OnBackInvokedCallback {
    final /* synthetic */ com.unity3d.player.a.c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0077d(com.unity3d.player.a.c cVar) {
        this.a = cVar;
    }

    public final void onBackInvoked() {
        Runnable runnable = ((B) this.a).a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
