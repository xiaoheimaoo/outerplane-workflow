package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzbx {
    public static final Deferred zza(Task task) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        task.addOnCompleteListener(zzbv.zza, new OnCompleteListener() { // from class: com.google.android.recaptcha.internal.zzbu
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                CompletableDeferred completableDeferred = CompletableDeferred.this;
                Exception exception = task2.getException();
                if (exception == null) {
                    if (task2.isCanceled()) {
                        Job.DefaultImpls.cancel$default((Job) completableDeferred, (CancellationException) null, 1, (Object) null);
                        return;
                    } else {
                        completableDeferred.complete(task2.getResult());
                        return;
                    }
                }
                completableDeferred.completeExceptionally(exception);
            }
        });
        return new zzbw(CompletableDeferred$default);
    }
}
