package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzfh extends zzee implements RunnableFuture {
    @CheckForNull
    private volatile zzes zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfh(Callable callable) {
        this.zzc = new zzfg(this, callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfh zzr(Runnable runnable, Object obj) {
        return new zzfh(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzes zzesVar = this.zzc;
        if (zzesVar != null) {
            zzesVar.run();
        }
        this.zzc = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.play_billing.zzdy
    @CheckForNull
    public final String zzg() {
        zzes zzesVar = this.zzc;
        if (zzesVar != null) {
            String obj = zzesVar.toString();
            return "task=[" + obj + "]";
        }
        return super.zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdy
    protected final void zzm() {
        zzes zzesVar;
        if (zzq() && (zzesVar = this.zzc) != null) {
            zzesVar.zze();
        }
        this.zzc = null;
    }
}
