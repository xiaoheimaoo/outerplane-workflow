package com.unity3d.player;

import android.util.Log;
/* renamed from: com.unity3d.player.z  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC0121z {
    protected static boolean a = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void Log(int i, String str) {
        if (a) {
            return;
        }
        if (i == 6) {
            Log.e("Unity", str);
        }
        if (i == 5) {
            Log.w("Unity", str);
        }
    }
}
