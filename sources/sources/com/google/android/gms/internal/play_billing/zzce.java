package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import javax.annotation.CheckForNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public abstract class zzce implements Comparable, Serializable {
    final Comparable zza = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzce(Comparable comparable) {
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzce) {
            try {
                if (compareTo((zzce) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract int hashCode();

    @Override // java.lang.Comparable
    /* renamed from: zza */
    public int compareTo(zzce zzceVar) {
        zzcd zzcdVar;
        zzcb zzcbVar;
        zzcdVar = zzcd.zzb;
        if (zzceVar != zzcdVar) {
            zzcbVar = zzcb.zzb;
            if (zzceVar == zzcbVar) {
                return -1;
            }
            Comparable comparable = zzceVar.zza;
            int i = zzdh.zzc;
            int compareTo = "".compareTo("");
            return compareTo != 0 ? compareTo : Boolean.compare(this instanceof zzcc, zzceVar instanceof zzcc);
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(StringBuilder sb);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzd(StringBuilder sb);
}
