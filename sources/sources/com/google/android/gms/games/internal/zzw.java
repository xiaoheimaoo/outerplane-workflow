package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.gamessignin.AuthResponse;
import com.google.android.gms.games.gamessignin.AuthScope;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public final class zzw extends zza {
    private final TaskCompletionSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzak
    public final void zzs(Status status, String str, List list) {
        if (!status.isSuccess()) {
            TaskCompletionSource taskCompletionSource = this.zza;
            int i = zzai.zze;
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(status));
            return;
        }
        this.zza.trySetResult(new AuthResponse(str, AuthScope.zza(list)));
    }
}
