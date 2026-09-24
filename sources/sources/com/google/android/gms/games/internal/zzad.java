package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public final class zzad extends zza {
    final /* synthetic */ zzai zza;
    private final TaskCompletionSource zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzai zzaiVar, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(zzaiVar);
        this.zza = zzaiVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzak
    public final void zzh(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode == 10003) {
            this.zza.zzZ(this.zzb);
            dataHolder.close();
            return;
        }
        boolean z = statusCode == 3;
        if (statusCode == 0 || z) {
            this.zzb.trySetResult(new AnnotatedData(new PlayerBuffer(dataHolder), z));
            return;
        }
        GamesStatusUtils.zzb(this.zzb, statusCode);
        dataHolder.close();
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzak
    public final void zzi(DataHolder dataHolder) {
        zzh(dataHolder);
    }
}
