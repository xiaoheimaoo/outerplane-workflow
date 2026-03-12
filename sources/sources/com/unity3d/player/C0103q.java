package com.unity3d.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.q  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0103q {
    private final Context a;
    private final AudioManager b;
    private C0099o c;

    public C0103q(Context context) {
        this.a = context;
        this.b = (AudioManager) context.getSystemService("audio");
    }

    public final void a() {
        if (this.c != null) {
            this.a.getContentResolver().unregisterContentObserver(this.c);
            this.c = null;
        }
    }

    public final void a(InterfaceC0101p interfaceC0101p) {
        this.c = new C0099o(new Handler(Looper.getMainLooper()), this.b, interfaceC0101p);
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.c);
    }
}
