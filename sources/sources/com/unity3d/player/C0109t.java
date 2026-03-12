package com.unity3d.player;

import android.hardware.camera2.CameraDevice;
import java.util.concurrent.Semaphore;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.t  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0109t extends CameraDevice.StateCallback {
    final /* synthetic */ C0115w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0109t(C0115w c0115w) {
        this.a = c0115w;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        Semaphore semaphore;
        semaphore = C0115w.D;
        semaphore.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        Semaphore semaphore;
        AbstractC0121z.Log(5, "Camera2: CameraDevice disconnected.");
        this.a.a(cameraDevice);
        semaphore = C0115w.D;
        semaphore.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        Semaphore semaphore;
        AbstractC0121z.Log(6, "Camera2: Error opeining CameraDevice " + i);
        this.a.a(cameraDevice);
        semaphore = C0115w.D;
        semaphore.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        Semaphore semaphore;
        this.a.b = cameraDevice;
        semaphore = C0115w.D;
        semaphore.release();
    }
}
