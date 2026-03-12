package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzoy {
    public static final /* synthetic */ int zza = 0;
    private static final zzpl zzb;

    static {
        int i = zzos.zza;
        zzb = new zzpn();
    }

    public static void zzA(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzA(i, list, z);
    }

    public static void zzB(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzC(i, list, z);
    }

    public static void zzC(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzE(i, list, z);
    }

    public static void zzD(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzJ(i, list, z);
    }

    public static void zzE(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzL(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            i = 0;
            while (i2 < size) {
                i += zzln.zzB(zzneVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzln.zzB(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzln.zzA(i << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzln.zzA(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            i = 0;
            while (i2 < size) {
                i += zzln.zzB(zzneVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzln.zzB(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            i = 0;
            while (i2 < size) {
                i += zzln.zzB(zznxVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzln.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, Object obj, zzow zzowVar) {
        int i2 = i << 3;
        if (obj instanceof zznt) {
            int zzA = zzln.zzA(i2);
            int zza2 = ((zznt) obj).zza();
            return zzA + zzln.zzA(zza2) + zza2;
        }
        return zzln.zzA(i2) + zzln.zzy((zzoi) obj, zzowVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            i = 0;
            while (i2 < size) {
                int zze = zzneVar.zze(i2);
                i += zzln.zzA((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i += zzln.zzA((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            i = 0;
            while (i2 < size) {
                long zze = zznxVar.zze(i2);
                i += zzln.zzB((zze >> 63) ^ (zze + zze));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i += zzln.zzB((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzneVar = (zzne) list;
            i = 0;
            while (i2 < size) {
                i += zzln.zzA(zzneVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzln.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zznx) {
            zznx zznxVar = (zznx) list;
            i = 0;
            while (i2 < size) {
                i += zzln.zzB(zznxVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzln.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzpl zzm() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzn(Object obj, int i, List list, zznh zznhVar, Object obj2, zzpl zzplVar) {
        if (zznhVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zznhVar.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzo(obj, i, intValue, obj2, zzplVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zznhVar.zza(intValue2)) {
                    obj2 = zzo(obj, i, intValue2, obj2, zzplVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzo(Object obj, int i, int i2, Object obj2, zzpl zzplVar) {
        if (obj2 == null) {
            obj2 = zzplVar.zza(obj);
        }
        zzplVar.zzh(obj2, i, i2);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzp(zzmp zzmpVar, Object obj, Object obj2) {
        zzmt zzmtVar = ((zzna) obj2).zzb;
        if (zzmtVar.zza.isEmpty()) {
            return;
        }
        ((zzna) obj).zzi().zzh(zzmtVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzq(zzpl zzplVar, Object obj, Object obj2) {
        zznd zzndVar = (zznd) obj;
        zzpm zzpmVar = zzndVar.zzc;
        zzpm zzpmVar2 = ((zznd) obj2).zzc;
        if (!zzpm.zzc().equals(zzpmVar2)) {
            if (zzpm.zzc().equals(zzpmVar)) {
                zzpmVar = zzpm.zze(zzpmVar, zzpmVar2);
            } else {
                zzpmVar.zzd(zzpmVar2);
            }
        }
        zzndVar.zzc = zzpmVar;
    }

    public static void zzr(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzg(i, list, z);
    }

    public static void zzt(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzj(i, list, z);
    }

    public static void zzu(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzl(i, list, z);
    }

    public static void zzv(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzn(i, list, z);
    }

    public static void zzw(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzp(i, list, z);
    }

    public static void zzx(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzs(i, list, z);
    }

    public static void zzy(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzu(i, list, z);
    }

    public static void zzz(int i, List list, zzpy zzpyVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzpyVar.zzy(i, list, z);
    }
}
