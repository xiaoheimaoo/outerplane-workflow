package com.unity3d.player;
/* renamed from: com.unity3d.player.i  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC0087i implements Runnable {
    private IAssetPackManagerMobileDataConfirmationCallback a;
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0087i(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback, boolean z) {
        this.a = iAssetPackManagerMobileDataConfirmationCallback;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onMobileDataConfirmationResult(this.b);
    }
}
