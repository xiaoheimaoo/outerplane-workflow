package com.google.android.gms.internal.games_v2;

import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
final class zzgz extends zzgu {
    private final transient zzgt zza;
    private final transient zzgq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgz(zzgt zzgtVar, zzgq zzgqVar) {
        this.zza = zzgtVar;
        this.zzb = zzgqVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgm, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu, com.google.android.gms.internal.games_v2.zzgm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu, com.google.android.gms.internal.games_v2.zzgm
    public final zzhd zza() {
        return this.zzb.listIterator(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.games_v2.zzgm
    public final int zze(Object[] objArr, int i) {
        return this.zzb.zze(objArr, 0);
    }
}
