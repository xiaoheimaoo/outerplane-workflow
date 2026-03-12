package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:integrity@@1.3.0 */
/* loaded from: classes2.dex */
public final class bt {
    private final bn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bn bnVar) {
        this.a = bnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(long j, long j2, int i, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.a.d(standardIntegrityTokenRequest.a(), j, j2, 0);
    }
}
