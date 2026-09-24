package com.google.android.gms.internal.games_v2;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
public abstract class zzgu extends zzgm implements Set {
    private transient zzgq zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzhc.zza(this);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zza */
    public abstract zzhd iterator();

    public final zzgq zzf() {
        zzgq zzgqVar = this.zza;
        if (zzgqVar == null) {
            zzgq zzg = zzg();
            this.zza = zzg;
            return zzg;
        }
        return zzgqVar;
    }

    zzgq zzg() {
        Object[] array = toArray();
        return zzgq.zzj(array, array.length);
    }
}
