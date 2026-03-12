package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import android.view.Surface;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.s  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0107s extends CameraCaptureSession.StateCallback {
    final /* synthetic */ C0115w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0107s(C0115w c0115w) {
        this.a = c0115w;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        AbstractC0121z.Log(6, "Camera2: CaptureSession configuration failed.");
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        CameraDevice cameraDevice;
        Object obj;
        StringBuilder append;
        CameraDevice cameraDevice2;
        CaptureRequest.Builder builder;
        Surface surface;
        CaptureRequest.Builder builder2;
        Range range;
        C0115w c0115w = this.a;
        cameraDevice = c0115w.b;
        if (cameraDevice == null) {
            return;
        }
        obj = c0115w.s;
        synchronized (obj) {
            C0115w c0115w2 = this.a;
            c0115w2.r = cameraCaptureSession;
            try {
                try {
                    cameraDevice2 = c0115w2.b;
                    c0115w2.q = cameraDevice2.createCaptureRequest(1);
                    C0115w c0115w3 = this.a;
                    builder = c0115w3.q;
                    surface = c0115w3.v;
                    builder.addTarget(surface);
                    C0115w c0115w4 = this.a;
                    builder2 = c0115w4.q;
                    CaptureRequest.Key key = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
                    range = c0115w4.n;
                    builder2.set(key, range);
                    this.a.g();
                } catch (IllegalStateException e) {
                    append = new StringBuilder("Camera2: IllegalStateException ").append(e);
                    AbstractC0121z.Log(6, append.toString());
                }
            } catch (CameraAccessException e2) {
                append = new StringBuilder("Camera2: CameraAccessException ").append(e2);
                AbstractC0121z.Log(6, append.toString());
            }
        }
    }
}
