package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.0.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzct implements RemoteCall {
    static final /* synthetic */ zzct zza = new zzct();

    private /* synthetic */ zzct() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        ((com.google.android.gms.games.internal.zzah) obj).zzaa();
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
