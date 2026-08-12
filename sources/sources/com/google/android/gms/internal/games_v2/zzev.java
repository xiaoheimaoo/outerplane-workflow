package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.RecallAccess;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.0.0 */
/* loaded from: classes2.dex */
final class zzev extends zzfs {
    final /* synthetic */ TaskCompletionSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzev(zzey zzeyVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzeyVar);
    }

    @Override // com.google.android.gms.internal.games_v2.zzfs, com.google.android.gms.internal.games_v2.zzai
    public final void zzb(zzam zzamVar) {
        this.zza.setResult(RecallAccess.zza(zzamVar));
    }

    @Override // com.google.android.gms.internal.games_v2.zzfs, com.google.android.gms.internal.games_v2.zzai
    public final void zzc(Status status) {
        this.zza.setException(new ApiException(status));
    }
}
