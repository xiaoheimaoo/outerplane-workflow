package com.unity3d.player;

import android.telephony.PhoneStateListener;
/* loaded from: classes3.dex */
final class R0 extends PhoneStateListener {
    final /* synthetic */ UnityPlayer a;

    private R0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i, String str) {
        UnityPlayer.m473$$Nest$mnativeMuteMasterAudio(this.a, i == 1);
    }
}
