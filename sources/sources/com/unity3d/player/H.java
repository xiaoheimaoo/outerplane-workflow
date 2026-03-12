package com.unity3d.player;
/* loaded from: classes3.dex */
final class H implements Runnable {
    final /* synthetic */ String[] a;
    final /* synthetic */ PermissionFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(PermissionFragment permissionFragment, String[] strArr) {
        this.b = permissionFragment;
        this.a = strArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.reportAllDenied(this.a);
    }
}
