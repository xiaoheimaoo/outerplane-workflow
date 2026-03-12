package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:integrity@@1.3.0 */
/* loaded from: classes2.dex */
public final class bg extends bm {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ long c;
    final /* synthetic */ TaskCompletionSource d;
    final /* synthetic */ bn e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bn bnVar, TaskCompletionSource taskCompletionSource, int i, String str, long j, long j2, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.e = bnVar;
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = taskCompletionSource2;
    }

    @Override // com.google.android.play.integrity.internal.t
    protected final void b() {
        com.google.android.play.integrity.internal.s sVar;
        if (!bn.k(this.e)) {
            try {
                bn bnVar = this.e;
                ((com.google.android.play.integrity.internal.i) bnVar.a.e()).d(bn.a(bnVar, this.a, this.b, this.c, 0), new bk(this.e, this.d, this.b));
                return;
            } catch (RemoteException e) {
                bn bnVar2 = this.e;
                String str = this.a;
                sVar = bnVar2.b;
                sVar.c(e, "requestExpressIntegrityToken(%s, %s)", str, Long.valueOf(this.b));
                this.d.trySetException(new StandardIntegrityException(-100, e));
                return;
            }
        }
        super.a(new StandardIntegrityException(-2, null));
    }
}
