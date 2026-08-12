package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.0.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcs implements zzap {
    static final /* synthetic */ zzcs zza = new zzcs();

    private /* synthetic */ zzcs() {
    }

    @Override // com.google.android.gms.internal.games_v2.zzap
    public final /* synthetic */ Task zza(GoogleApi googleApi) {
        return googleApi.doWrite(TaskApiCall.builder().run(zzct.zza).setMethodKey(6753).setFeatures(com.google.android.gms.games.zzd.zzj).build());
    }
}
