package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcu implements zzap {
    static final /* synthetic */ zzcu zza = new zzcu();

    private /* synthetic */ zzcu() {
    }

    @Override // com.google.android.gms.internal.games_v2.zzap
    public final /* synthetic */ Task zza(GoogleApi googleApi) {
        return googleApi.doWrite(TaskApiCall.builder().run(zzcv.zza).setMethodKey(6753).setFeatures(com.google.android.gms.games.zzd.zzj).build());
    }
}
