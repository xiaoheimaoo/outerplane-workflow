package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes.dex */
public final class zzu extends zza {
    private final TaskCompletionSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzr(Status status, String str) {
        if (!status.isSuccess()) {
            TaskCompletionSource taskCompletionSource = this.zza;
            int i = zzah.zze;
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(status));
            return;
        }
        this.zza.setResult(str);
    }
}
