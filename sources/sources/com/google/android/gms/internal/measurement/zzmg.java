package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzmg {
    private static final zzmu<?, ?> zza = new zzmw();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjn.zza(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<zziy> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzf = size * zzjn.zzf(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzf += zzjn.zza(list.get(i2));
        }
        return zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzjn.zzf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            i = 0;
            while (i2 < size) {
                i += zzjn.zza(zzkhVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzjn.zza(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjn.zzb(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjn.zza(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<zzlm> list, zzme<?> zzmeVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzjn.zza(i, list.get(i3), zzmeVar);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjn.zzf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            i = 0;
            while (i2 < size) {
                i += zzjn.zzc(zzkhVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzjn.zzc(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzjn.zzf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            i = 0;
            while (i2 < size) {
                i += zzjn.zzb(zzlbVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzjn.zzb(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, Object obj, zzme<?> zzmeVar) {
        if (obj instanceof zzku) {
            return zzjn.zzb(i, (zzku) obj);
        }
        return zzjn.zzb(i, (zzlm) obj, zzmeVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<?> list, zzme<?> zzmeVar) {
        int zza2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzf = zzjn.zzf(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzku) {
                zza2 = zzjn.zza((zzku) obj);
            } else {
                zza2 = zzjn.zza((zzlm) obj, zzmeVar);
            }
            zzf += zza2;
        }
        return zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzjn.zzf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            i = 0;
            while (i2 < size) {
                i += zzjn.zze(zzkhVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzjn.zze(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzjn.zzf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            i = 0;
            while (i2 < size) {
                i += zzjn.zzd(zzlbVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzjn.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<?> list) {
        int zza2;
        int zza3;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzf = zzjn.zzf(i) * size;
        if (list instanceof zzkx) {
            zzkx zzkxVar = (zzkx) list;
            while (i2 < size) {
                Object zza4 = zzkxVar.zza(i2);
                if (zza4 instanceof zziy) {
                    zza3 = zzjn.zza((zziy) zza4);
                } else {
                    zza3 = zzjn.zza((String) zza4);
                }
                zzf += zza3;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zziy) {
                    zza2 = zzjn.zza((zziy) obj);
                } else {
                    zza2 = zzjn.zza((String) obj);
                }
                zzf += zza2;
                i2++;
            }
        }
        return zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzjn.zzf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            i = 0;
            while (i2 < size) {
                i += zzjn.zzg(zzkhVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzjn.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzjn.zzf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            i = 0;
            while (i2 < size) {
                i += zzjn.zze(zzlbVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzjn.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzmu<?, ?> zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(Object obj, int i, List<Integer> list, zzkl zzklVar, UB ub, zzmu<UT, UB> zzmuVar) {
        if (zzklVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzklVar.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(obj, i, intValue, ub, zzmuVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzklVar.zza(intValue2)) {
                    ub = (UB) zza(obj, i, intValue2, ub, zzmuVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(Object obj, int i, int i2, UB ub, zzmu<UT, UB> zzmuVar) {
        if (ub == null) {
            ub = zzmuVar.zzc(obj);
        }
        zzmuVar.zzb(ub, i, i2);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzjy<FT>> void zza(zzjv<FT> zzjvVar, T t, T t2) {
        zzjw<FT> zza2 = zzjvVar.zza(t2);
        if (zza2.zza.isEmpty()) {
            return;
        }
        zzjvVar.zzb(t).zza(zza2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zza(zzlj zzljVar, T t, T t2, long j) {
        zzmz.zza(t, j, zzljVar.zza(zzmz.zze(t, j), zzmz.zze(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zza(zzmu<UT, UB> zzmuVar, T t, T t2) {
        zzmuVar.zzc(t, zzmuVar.zza(zzmuVar.zzd(t), zzmuVar.zzd(t2)));
    }

    public static void zza(Class<?> cls) {
        zzkg.class.isAssignableFrom(cls);
    }

    public static void zza(int i, List<Boolean> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zza(i, list, z);
    }

    public static void zza(int i, List<zziy> list, zznl zznlVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zza(i, list);
    }

    public static void zzb(int i, List<Double> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzb(i, list, z);
    }

    public static void zzc(int i, List<Integer> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Integer> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zze(i, list, z);
    }

    public static void zzf(int i, List<Float> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzf(i, list, z);
    }

    public static void zza(int i, List<?> list, zznl zznlVar, zzme<?> zzmeVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zza(i, list, (zzme) zzmeVar);
    }

    public static void zzg(int i, List<Integer> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzg(i, list, z);
    }

    public static void zzh(int i, List<Long> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzh(i, list, z);
    }

    public static void zzb(int i, List<?> list, zznl zznlVar, zzme<?> zzmeVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzb(i, list, (zzme) zzmeVar);
    }

    public static void zzi(int i, List<Integer> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzi(i, list, z);
    }

    public static void zzj(int i, List<Long> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzj(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzk(i, list, z);
    }

    public static void zzl(int i, List<Long> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzl(i, list, z);
    }

    public static void zzb(int i, List<String> list, zznl zznlVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzb(i, list);
    }

    public static void zzm(int i, List<Integer> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzm(i, list, z);
    }

    public static void zzn(int i, List<Long> list, zznl zznlVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznlVar.zzn(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
