package com.unity3d.player;

import android.content.Context;
import android.view.OrientationEventListener;
/* loaded from: classes3.dex */
final class D0 extends OrientationEventListener {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D0(UnityPlayer unityPlayer, Context context, int i) {
        super(context, i);
        this.a = unityPlayer;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        int i2;
        UnityPlayer unityPlayer = this.a;
        U0 u0 = unityPlayer.m_MainThread;
        i2 = unityPlayer.mNaturalOrientation;
        u0.f = i2;
        u0.g = i;
        u0.a(S0.j);
    }
}
