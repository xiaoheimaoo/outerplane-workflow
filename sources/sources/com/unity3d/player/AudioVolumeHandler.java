package com.unity3d.player;

import android.content.Context;
/* loaded from: classes3.dex */
public class AudioVolumeHandler implements InterfaceC0101p {
    private C0103q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioVolumeHandler(Context context) {
        C0103q c0103q = new C0103q(context);
        this.a = c0103q;
        c0103q.a(this);
    }

    public final void a() {
        this.a.a();
        this.a = null;
    }

    @Override // com.unity3d.player.InterfaceC0101p
    public final native void onAudioVolumeChanged(int i);
}
