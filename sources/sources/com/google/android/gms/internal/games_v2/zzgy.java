package com.google.android.gms.internal.games_v2;

import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
public final class zzgy extends zzgu {
    private final transient zzgt zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgy(zzgt zzgtVar, Object[] objArr, int i, int i2) {
        this.zza = zzgtVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgm, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu, com.google.android.gms.internal.games_v2.zzgm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu, com.google.android.gms.internal.games_v2.zzgm
    public final zzhd zza() {
        return zzf().listIterator(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.games_v2.zzgm
    public final int zze(Object[] objArr, int i) {
        return zzf().zze(objArr, 0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgu
    final zzgq zzg() {
        return new zzgx(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object[] zzh() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zzi() {
        return this.zzc;
    }
}
