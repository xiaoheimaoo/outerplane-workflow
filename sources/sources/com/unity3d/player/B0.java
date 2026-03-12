package com.unity3d.player;
/* loaded from: classes3.dex */
final class B0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
        r1 = (r0 = r2.a).mActivity;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r2 = this;
            com.unity3d.player.UnityPlayer r0 = r2.a
            boolean r0 = com.unity3d.player.UnityPlayer.m471$$Nest$mnativeIsAutorotationOn(r0)
            if (r0 == 0) goto L17
            com.unity3d.player.UnityPlayer r0 = r2.a
            android.app.Activity r1 = com.unity3d.player.UnityPlayer.m453$$Nest$fgetmActivity(r0)
            if (r1 == 0) goto L17
            int r0 = com.unity3d.player.UnityPlayer.m456$$Nest$fgetmInitialScreenOrientation(r0)
            r1.setRequestedOrientation(r0)
        L17:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.B0.run():void");
    }
}
