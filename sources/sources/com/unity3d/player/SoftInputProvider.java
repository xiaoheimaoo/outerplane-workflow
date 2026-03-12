package com.unity3d.player;
/* loaded from: classes3.dex */
abstract class SoftInputProvider {
    public static int a() {
        int[] b;
        int nativeGetSoftInputType = nativeGetSoftInputType();
        for (int i : com.unity3d.player.a.a.b(3)) {
            if (com.unity3d.player.a.d.a(i) == nativeGetSoftInputType) {
                return i;
            }
        }
        return 1;
    }

    private static final native int nativeGetSoftInputType();
}
