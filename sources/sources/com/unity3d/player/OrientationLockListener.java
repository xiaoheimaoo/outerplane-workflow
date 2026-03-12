package com.unity3d.player;

import android.content.Context;
import android.provider.Settings;
/* loaded from: classes3.dex */
public class OrientationLockListener implements InterfaceC0078d0 {
    private C0082f0 a;
    private Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OrientationLockListener(Context context) {
        this.b = context;
        this.a = new C0082f0(context);
        nativeUpdateOrientationLockState(Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0));
        this.a.a(this);
    }

    public final void a() {
        this.a.a();
        this.a = null;
    }

    public final void b() {
        nativeUpdateOrientationLockState(Settings.System.getInt(this.b.getContentResolver(), "accelerometer_rotation", 0));
    }

    public final native void nativeUpdateOrientationLockState(int i);
}
