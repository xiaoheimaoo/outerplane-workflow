package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaep  reason: invalid package */
/* loaded from: classes2.dex */
public class zzaep {
    zzado zza;
    Executor zzb;

    public final <ResultT> Task<ResultT> zza(final zzaer<ResultT> zzaerVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzaes
            @Override // java.lang.Runnable
            public final void run() {
                zzaerVar.zza(taskCompletionSource, zzaep.this.zza);
            }
        });
        return taskCompletionSource.getTask();
    }
}
