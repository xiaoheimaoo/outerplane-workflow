package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.0.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzdm implements RemoteCall {
    static final /* synthetic */ zzdm zza = new zzdm();

    private /* synthetic */ zzdm() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzan) ((com.google.android.gms.games.internal.zzah) obj).getService()).zzv());
    }
}
