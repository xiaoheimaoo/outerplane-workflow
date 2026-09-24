package com.google.android.gms.internal.games_v2;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
final class zzgx extends zzgq {
    final /* synthetic */ zzgy zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgx(zzgy zzgyVar) {
        Objects.requireNonNull(zzgyVar);
        this.zza = zzgyVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzgy zzgyVar = this.zza;
        zzgd.zza(i, zzgyVar.zzi(), FirebaseAnalytics.Param.INDEX);
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(zzgyVar.zzh()[i2]), Objects.requireNonNull(zzgyVar.zzh()[i2 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzi();
    }
}
