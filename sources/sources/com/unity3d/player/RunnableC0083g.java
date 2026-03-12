package com.unity3d.player;

import java.util.Set;
/* renamed from: com.unity3d.player.g  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC0083g implements Runnable {
    private Set a;
    private String b;
    private int c;
    private long d;
    private long e;
    private int f;
    private int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0083g(Set set, String str, int i, long j, long j2, int i2, int i3) {
        this.a = set;
        this.b = str;
        this.c = i;
        this.d = j;
        this.e = j2;
        this.f = i2;
        this.g = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback : this.a) {
            iAssetPackManagerDownloadStatusCallback.onStatusUpdate(this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }
}
