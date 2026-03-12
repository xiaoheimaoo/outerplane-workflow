package com.unity3d.player;

import android.content.DialogInterface;
/* loaded from: classes3.dex */
final class Y implements DialogInterface.OnDismissListener {
    final /* synthetic */ C0076c0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(C0076c0 c0076c0) {
        this.a = c0076c0;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.invokeOnClose();
    }
}
