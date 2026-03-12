package com.google.android.play.core.integrity;

import android.content.Context;
/* compiled from: com.google.android.play:integrity@@1.3.0 */
/* loaded from: classes2.dex */
final class ax {
    private static aw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized aw a(Context context) {
        aw awVar;
        synchronized (ax.class) {
            if (a == null) {
                u uVar = new u(null);
                uVar.a(com.google.android.play.integrity.internal.ag.a(context));
                a = uVar.b();
            }
            awVar = a;
        }
        return awVar;
    }
}
