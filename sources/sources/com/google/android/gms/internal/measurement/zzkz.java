package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
final class zzkz implements zzkw {
    private static <E> zzkm<E> zzc(Object obj, long j) {
        return (zzkm) zzmz.zze(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzkw
    public final <L> List<L> zza(Object obj, long j) {
        zzkm zzc = zzc(obj, j);
        if (zzc.zzc()) {
            return zzc;
        }
        int size = zzc.size();
        zzkm zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzmz.zza(obj, j, zza);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzkw
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.measurement.zzkm] */
    @Override // com.google.android.gms.internal.measurement.zzkw
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzkm<E> zzc = zzc(obj, j);
        zzkm<E> zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzkm<E> zzkmVar = zzc;
        zzkmVar = zzc;
        if (size > 0 && size2 > 0) {
            boolean zzc3 = zzc.zzc();
            zzkm<E> zzkmVar2 = zzc;
            if (!zzc3) {
                zzkmVar2 = zzc.zza(size2 + size);
            }
            zzkmVar2.addAll(zzc2);
            zzkmVar = zzkmVar2;
        }
        if (size > 0) {
            zzc2 = zzkmVar;
        }
        zzmz.zza(obj, j, zzc2);
    }
}
