package com.unity3d.player;

import android.content.DialogInterface;
/* renamed from: com.unity3d.player.a0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class DialogInterface$OnCancelListenerC0072a0 implements DialogInterface.OnCancelListener {
    final /* synthetic */ C0076c0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnCancelListenerC0072a0(C0076c0 c0076c0) {
        this.a = c0076c0;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        F f = this.a.f;
        if (f != null) {
            ((C0094l0) f).a();
        }
    }
}
