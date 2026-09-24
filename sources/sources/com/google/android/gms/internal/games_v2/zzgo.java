package com.google.android.gms.internal.games_v2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
public final class zzgo extends zzgh {
    private final zzgq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgo(zzgq zzgqVar, int i) {
        super(zzgqVar.size(), i);
        this.zza = zzgqVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgh
    final Object zza(int i) {
        return this.zza.get(i);
    }
}
