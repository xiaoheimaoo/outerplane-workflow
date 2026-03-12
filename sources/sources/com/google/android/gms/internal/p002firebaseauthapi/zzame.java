package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzame  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzame {
    private static final zzamv<?, ?> zza = new zzamx();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzajo.zza(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<zzaiw> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzg = size * zzajo.zzg(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzg += zzajo.zza(list.get(i2));
        }
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzajo.zzg(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakj) {
            zzakj zzakjVar = (zzakj) list;
            i = 0;
            while (i2 < size) {
                i += zzajo.zza(zzakjVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzajo.zza(list.get(i2).intValue());
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
        return size * zzajo.zzb(i, 0);
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
        return size * zzajo.zza(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<zzaln> list, zzamc<?> zzamcVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzajo.zza(i, list.get(i3), zzamcVar);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzajo.zzg(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakj) {
            zzakj zzakjVar = (zzakj) list;
            i = 0;
            while (i2 < size) {
                i += zzajo.zzc(zzakjVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzajo.zzc(list.get(i2).intValue());
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
        return zzf(list) + (list.size() * zzajo.zzg(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaky) {
            zzaky zzakyVar = (zzaky) list;
            i = 0;
            while (i2 < size) {
                i += zzajo.zzb(zzakyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzajo.zzb(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, Object obj, zzamc<?> zzamcVar) {
        if (obj instanceof zzakv) {
            return zzajo.zzb(i, (zzakv) obj);
        }
        return zzajo.zzb(i, (zzaln) obj, zzamcVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<?> list, zzamc<?> zzamcVar) {
        int zza2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzg = zzajo.zzg(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzakv) {
                zza2 = zzajo.zza((zzakv) obj);
            } else {
                zza2 = zzajo.zza((zzaln) obj, zzamcVar);
            }
            zzg += zza2;
        }
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzajo.zzg(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakj) {
            zzakj zzakjVar = (zzakj) list;
            i = 0;
            while (i2 < size) {
                i += zzajo.zzf(zzakjVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzajo.zzf(list.get(i2).intValue());
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
        return zzh(list) + (size * zzajo.zzg(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaky) {
            zzaky zzakyVar = (zzaky) list;
            i = 0;
            while (i2 < size) {
                i += zzajo.zzd(zzakyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzajo.zzd(list.get(i2).longValue());
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
        int zzg = zzajo.zzg(i) * size;
        if (list instanceof zzaku) {
            zzaku zzakuVar = (zzaku) list;
            while (i2 < size) {
                Object zza4 = zzakuVar.zza(i2);
                if (zza4 instanceof zzaiw) {
                    zza3 = zzajo.zza((zzaiw) zza4);
                } else {
                    zza3 = zzajo.zza((String) zza4);
                }
                zzg += zza3;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzaiw) {
                    zza2 = zzajo.zza((zzaiw) obj);
                } else {
                    zza2 = zzajo.zza((String) obj);
                }
                zzg += zza2;
                i2++;
            }
        }
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzajo.zzg(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakj) {
            zzakj zzakjVar = (zzakj) list;
            i = 0;
            while (i2 < size) {
                i += zzajo.zzh(zzakjVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzajo.zzh(list.get(i2).intValue());
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
        return zzj(list) + (size * zzajo.zzg(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaky) {
            zzaky zzakyVar = (zzaky) list;
            i = 0;
            while (i2 < size) {
                i += zzajo.zze(zzakyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzajo.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzamv<?, ?> zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(Object obj, int i, List<Integer> list, zzakk zzakkVar, UB ub, zzamv<UT, UB> zzamvVar) {
        if (zzakkVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzakkVar.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(obj, i, intValue, ub, zzamvVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzakkVar.zza(intValue2)) {
                    ub = (UB) zza(obj, i, intValue2, ub, zzamvVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(Object obj, int i, int i2, UB ub, zzamv<UT, UB> zzamvVar) {
        if (ub == null) {
            ub = zzamvVar.zzc(obj);
        }
        zzamvVar.zzb(ub, i, i2);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzaka<FT>> void zza(zzajx<FT> zzajxVar, T t, T t2) {
        zzajy<FT> zza2 = zzajxVar.zza(t2);
        if (zza2.zza.isEmpty()) {
            return;
        }
        zzajxVar.zzb(t).zza(zza2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zza(zzalg zzalgVar, T t, T t2, long j) {
        zzana.zza(t, j, zzalgVar.zza(zzana.zze(t, j), zzana.zze(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zza(zzamv<UT, UB> zzamvVar, T t, T t2) {
        zzamvVar.zzc(t, zzamvVar.zza(zzamvVar.zzd(t), zzamvVar.zzd(t2)));
    }

    public static void zza(Class<?> cls) {
        zzakg.class.isAssignableFrom(cls);
    }

    public static void zza(int i, List<Boolean> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zza(i, list, z);
    }

    public static void zza(int i, List<zzaiw> list, zzanm zzanmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zza(i, list);
    }

    public static void zzb(int i, List<Double> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzb(i, list, z);
    }

    public static void zzc(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zze(i, list, z);
    }

    public static void zzf(int i, List<Float> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzf(i, list, z);
    }

    public static void zza(int i, List<?> list, zzanm zzanmVar, zzamc<?> zzamcVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zza(i, list, (zzamc) zzamcVar);
    }

    public static void zzg(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzg(i, list, z);
    }

    public static void zzh(int i, List<Long> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzh(i, list, z);
    }

    public static void zzb(int i, List<?> list, zzanm zzanmVar, zzamc<?> zzamcVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzb(i, list, (zzamc) zzamcVar);
    }

    public static void zzi(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzi(i, list, z);
    }

    public static void zzj(int i, List<Long> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzj(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzk(i, list, z);
    }

    public static void zzl(int i, List<Long> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzl(i, list, z);
    }

    public static void zzb(int i, List<String> list, zzanm zzanmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzb(i, list);
    }

    public static void zzm(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzm(i, list, z);
    }

    public static void zzn(int i, List<Long> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzn(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
