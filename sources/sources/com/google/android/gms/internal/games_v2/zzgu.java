package com.google.android.gms.internal.games_v2;

import java.io.Serializable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes2.dex */
public abstract class zzgu implements Comparable, Serializable {
    final Comparable zza = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgu(Comparable comparable) {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgu) {
            try {
                if (compareTo((zzgu) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract int hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(StringBuilder sb);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(StringBuilder sb);

    @Override // java.lang.Comparable
    /* renamed from: zzc */
    public int compareTo(zzgu zzguVar) {
        zzgt zzgtVar;
        zzgr zzgrVar;
        zzgtVar = zzgt.zzb;
        if (zzguVar != zzgtVar) {
            zzgrVar = zzgr.zzb;
            if (zzguVar == zzgrVar) {
                return -1;
            }
            Comparable comparable = zzguVar.zza;
            int i = zzhw.zzc;
            int compareTo = "".compareTo("");
            return compareTo != 0 ? compareTo : Boolean.compare(this instanceof zzgs, zzguVar instanceof zzgs);
        }
        return 1;
    }
}
