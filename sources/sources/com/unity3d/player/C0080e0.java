package com.unity3d.player;

import android.database.ContentObserver;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.e0  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0080e0 extends ContentObserver {
    private InterfaceC0078d0 a;

    public C0080e0(Handler handler, InterfaceC0078d0 interfaceC0078d0) {
        super(handler);
        this.a = interfaceC0078d0;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        InterfaceC0078d0 interfaceC0078d0 = this.a;
        if (interfaceC0078d0 != null) {
            ((OrientationLockListener) interfaceC0078d0).b();
        }
    }
}
