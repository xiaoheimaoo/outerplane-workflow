package com.unity3d.player;
/* loaded from: classes3.dex */
final class I0 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            AbstractC0075c.a();
        } catch (Exception e) {
            AbstractC0121z.Log(6, "Exception when hiding Activity Indicator " + e);
        }
    }
}
