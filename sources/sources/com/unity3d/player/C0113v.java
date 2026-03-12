package com.unity3d.player;

import android.graphics.SurfaceTexture;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.v  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0113v implements SurfaceTexture.OnFrameAvailableListener {
    final /* synthetic */ C0115w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0113v(C0115w c0115w) {
        this.a = c0115w;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        com.unity3d.player.a.b bVar;
        bVar = this.a.a;
        ((Camera2Wrapper) bVar).a(surfaceTexture);
    }
}
