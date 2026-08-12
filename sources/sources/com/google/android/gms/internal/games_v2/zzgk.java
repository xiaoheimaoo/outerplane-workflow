package com.google.android.gms.internal.games_v2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games-v2@@22.0.0 */
/* loaded from: classes2.dex */
public final class zzgk extends zzgd {
    private final zzgm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgk(zzgm zzgmVar, int i) {
        super(zzgmVar.size(), i);
        this.zza = zzgmVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgd
    final Object zza(int i) {
        return this.zza.get(i);
    }
}
