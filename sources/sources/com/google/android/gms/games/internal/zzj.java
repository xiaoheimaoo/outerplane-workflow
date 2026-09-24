package com.google.android.gms.games.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public final class zzj extends com.google.android.gms.internal.games_v2.zzac {
    final /* synthetic */ zzai zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(zzai zzaiVar) {
        Objects.requireNonNull(zzaiVar);
        this.zza = zzaiVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzac
    public final com.google.android.gms.internal.games_v2.zzab zza() {
        return new zzu(this.zza);
    }
}
