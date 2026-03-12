package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.f0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0082f0 {
    private Context a;
    private C0080e0 b;

    public C0082f0(Context context) {
        this.a = context;
    }

    public final void a() {
        if (this.b != null) {
            this.a.getContentResolver().unregisterContentObserver(this.b);
            this.b = null;
        }
    }

    public final void a(InterfaceC0078d0 interfaceC0078d0) {
        this.b = new C0080e0(new Handler(Looper.getMainLooper()), interfaceC0078d0);
        this.a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.b);
    }
}
