package com.unity3d.player;

import android.view.KeyEvent;
import android.widget.TextView;
/* loaded from: classes3.dex */
final class Q implements TextView.OnEditorActionListener {
    final /* synthetic */ S a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(S s) {
        this.a = s;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            S s = this.a;
            s.a(s.b(), false);
        }
        return false;
    }
}
