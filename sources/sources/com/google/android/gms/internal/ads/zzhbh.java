package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzhbh<T> implements zzhby<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhcz.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhbe zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhas zzm;
    private final zzhcp zzn;
    private final zzgzg zzo;
    private final zzhbj zzp;
    private final zzhaz zzq;

    private zzhbh(int[] iArr, Object[] objArr, int i, int i2, zzhbe zzhbeVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzhbj zzhbjVar, zzhas zzhasVar, zzhcp zzhcpVar, zzgzg zzgzgVar, zzhaz zzhazVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhbeVar instanceof zzgzu;
        boolean z2 = false;
        if (zzgzgVar != null && zzgzgVar.zzh(zzhbeVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i4;
        this.zzl = i5;
        this.zzp = zzhbjVar;
        this.zzm = zzhasVar;
        this.zzn = zzhcpVar;
        this.zzo = zzgzgVar;
        this.zzg = zzhbeVar;
        this.zzq = zzhazVar;
    }

    private final Object zzA(Object obj, int i) {
        zzhby zzx = zzx(i);
        int zzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzhby zzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i2) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzu = zzu(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzu);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhby zzx = zzx(i);
            if (!zzN(obj, i)) {
                if (!zzQ(object)) {
                    unsafe.putObject(obj, zzu, object);
                } else {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, zzu, zze);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzu);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, zzu, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzR(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzu = zzu(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzu);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhby zzx = zzx(i);
            if (!zzR(obj, i2, i)) {
                if (!zzQ(object)) {
                    unsafe.putObject(obj, zzu, object);
                } else {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, zzu, zze);
                }
                zzI(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzu);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, zzu, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i, zzhbq zzhbqVar) throws IOException {
        long j = i & 1048575;
        if (zzM(i)) {
            zzhcz.zzv(obj, j, zzhbqVar.zzs());
        } else if (!this.zzi) {
            zzhcz.zzv(obj, j, zzhbqVar.zzp());
        } else {
            zzhcz.zzv(obj, j, zzhbqVar.zzr());
        }
    }

    private final void zzH(Object obj, int i) {
        int zzr = zzr(i);
        long j = 1048575 & zzr;
        if (j == 1048575) {
            return;
        }
        zzhcz.zzt(obj, j, (1 << (zzr >>> 20)) | zzhcz.zzd(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzhcz.zzt(obj, zzr(i2) & 1048575, i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzu(i) & 1048575, obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzu(i2) & 1048575, obj2);
        zzI(obj, i, i2);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int zzr = zzr(i);
        long j = zzr & 1048575;
        if (j != 1048575) {
            return (zzhcz.zzd(obj, j) & (1 << (zzr >>> 20))) != 0;
        }
        int zzu = zzu(i);
        long j2 = zzu & 1048575;
        switch (zzt(zzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzhcz.zzb(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhcz.zzc(obj, j2)) != 0;
            case 2:
                return zzhcz.zzf(obj, j2) != 0;
            case 3:
                return zzhcz.zzf(obj, j2) != 0;
            case 4:
                return zzhcz.zzd(obj, j2) != 0;
            case 5:
                return zzhcz.zzf(obj, j2) != 0;
            case 6:
                return zzhcz.zzd(obj, j2) != 0;
            case 7:
                return zzhcz.zzz(obj, j2);
            case 8:
                Object zzh = zzhcz.zzh(obj, j2);
                if (zzh instanceof String) {
                    return !((String) zzh).isEmpty();
                } else if (zzh instanceof zzgyl) {
                    return !zzgyl.zzb.equals(zzh);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzhcz.zzh(obj, j2) != null;
            case 10:
                return !zzgyl.zzb.equals(zzhcz.zzh(obj, j2));
            case 11:
                return zzhcz.zzd(obj, j2) != 0;
            case 12:
                return zzhcz.zzd(obj, j2) != 0;
            case 13:
                return zzhcz.zzd(obj, j2) != 0;
            case 14:
                return zzhcz.zzf(obj, j2) != 0;
            case 15:
                return zzhcz.zzd(obj, j2) != 0;
            case 16:
                return zzhcz.zzf(obj, j2) != 0;
            case 17:
                return zzhcz.zzh(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzN(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzhby zzhbyVar) {
        return zzhbyVar.zzk(zzhcz.zzh(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgzu) {
            return ((zzgzu) obj).zzaY();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzhcz.zzd(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzhcz.zzh(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzgzb zzgzbVar) throws IOException {
        if (obj instanceof String) {
            zzgzbVar.zzF(i, (String) obj);
        } else {
            zzgzbVar.zzd(i, (zzgyl) obj);
        }
    }

    static zzhcq zzd(Object obj) {
        zzgzu zzgzuVar = (zzgzu) obj;
        zzhcq zzhcqVar = zzgzuVar.zzc;
        if (zzhcqVar == zzhcq.zzc()) {
            zzhcq zzf = zzhcq.zzf();
            zzgzuVar.zzc = zzf;
            return zzf;
        }
        return zzhcqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzhbh zzl(java.lang.Class r33, com.google.android.gms.internal.ads.zzhbb r34, com.google.android.gms.internal.ads.zzhbj r35, com.google.android.gms.internal.ads.zzhas r36, com.google.android.gms.internal.ads.zzhcp r37, com.google.android.gms.internal.ads.zzgzg r38, com.google.android.gms.internal.ads.zzhaz r39) {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhbh.zzl(java.lang.Class, com.google.android.gms.internal.ads.zzhbb, com.google.android.gms.internal.ads.zzhbj, com.google.android.gms.internal.ads.zzhas, com.google.android.gms.internal.ads.zzhcp, com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzhaz):com.google.android.gms.internal.ads.zzhbh");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzhcz.zzh(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzhcz.zzh(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzhcz.zzh(obj, j)).intValue();
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzhcz.zzh(obj, j)).longValue();
    }

    private final zzgzy zzw(int i) {
        int i2 = i / 3;
        return (zzgzy) this.zzd[i2 + i2 + 1];
    }

    private final zzhby zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhby zzhbyVar = (zzhby) objArr[i3];
        if (zzhbyVar != null) {
            return zzhbyVar;
        }
        zzhby zzb2 = zzhbn.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzhcp zzhcpVar, Object obj3) {
        int i2 = this.zzc[i];
        Object zzh = zzhcz.zzh(obj, zzu(i) & 1048575);
        if (zzh == null || zzw(i) == null) {
            return obj2;
        }
        zzhay zzhayVar = (zzhay) zzh;
        zzhax zzhaxVar = (zzhax) zzz(i);
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v108, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v109, types: [com.google.android.gms.internal.ads.zzham] */
    /* JADX WARN: Type inference failed for: r0v111, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v113, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v130 */
    /* JADX WARN: Type inference failed for: r0v178, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v255, types: [int] */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49, types: [int] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v42, types: [int] */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v10, types: [int] */
    /* JADX WARN: Type inference failed for: r4v11, types: [int] */
    /* JADX WARN: Type inference failed for: r4v12, types: [int] */
    /* JADX WARN: Type inference failed for: r4v13, types: [int] */
    /* JADX WARN: Type inference failed for: r4v14, types: [int] */
    /* JADX WARN: Type inference failed for: r4v15, types: [int] */
    /* JADX WARN: Type inference failed for: r4v16, types: [int] */
    /* JADX WARN: Type inference failed for: r4v17, types: [int] */
    /* JADX WARN: Type inference failed for: r4v18, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35, types: [int] */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v6, types: [int] */
    /* JADX WARN: Type inference failed for: r4v7, types: [int] */
    /* JADX WARN: Type inference failed for: r4v8, types: [int] */
    /* JADX WARN: Type inference failed for: r4v9, types: [int] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.ads.zzhby
    public final int zza(Object obj) {
        int i;
        boolean z;
        int i2;
        int zzz;
        int zzz2;
        int zzz3;
        int zzA;
        int zzz4;
        int zzz5;
        int zzd;
        int zzz6;
        int zzg;
        int size;
        int zzz7;
        int zzz8;
        int zzz9;
        int i3;
        int zze;
        int zzz10;
        int zzz11;
        int i4;
        Unsafe unsafe = zzb;
        boolean z2 = false;
        int i5 = 1048575;
        boolean z3 = false;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1048575;
        while (i6 < this.zzc.length) {
            int zzu = zzu(i6);
            int zzt = zzt(zzu);
            int[] iArr = this.zzc;
            int i9 = iArr[i6];
            int i10 = iArr[i6 + 2];
            int i11 = i10 & i5;
            if (zzt <= 17) {
                if (i11 != i8) {
                    z3 = i11 == i5 ? z2 : unsafe.getInt(obj, i11);
                    i8 = i11;
                }
                i = i8;
                z = z3;
                i2 = 1 << (i10 >>> 20);
            } else {
                i = i8;
                z = z3;
                i2 = z2;
            }
            int i12 = zzu & i5;
            if (zzt >= zzgzl.DOUBLE_LIST_PACKED.zza()) {
                zzgzl.SINT64_LIST_PACKED.zza();
            }
            long j = i12;
            switch (zzt) {
                case 0:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzz = zzgza.zzz(i9 << 3);
                        i3 = zzz + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzz2 = zzgza.zzz(i9 << 3);
                        i3 = zzz2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(obj, i6, i, z, i2)) {
                        long j2 = unsafe.getLong(obj, j);
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzA(j2);
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(obj, i6, i, z, i2)) {
                        long j3 = unsafe.getLong(obj, j);
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzA(j3);
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzA(unsafe.getInt(obj, j));
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzz = zzgza.zzz(i9 << 3);
                        i3 = zzz + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzz2 = zzgza.zzz(i9 << 3);
                        i3 = zzz2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzz4 = zzgza.zzz(i9 << 3);
                        i3 = zzz4 + 1;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzO(obj, i6, i, z, i2)) {
                        break;
                    } else {
                        int i13 = i9 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzgyl) {
                            zzz5 = zzgza.zzz(i13);
                            zzd = ((zzgyl) object).zzd();
                            zzz6 = zzgza.zzz(zzd);
                            i3 = zzz5 + zzz6 + zzd;
                            i7 += i3;
                            break;
                        } else {
                            zzz3 = zzgza.zzz(i13);
                            zzA = zzgza.zzy((String) object);
                            i3 = zzz3 + zzA;
                            i7 += i3;
                        }
                    }
                case 9:
                    if (zzO(obj, i6, i, z, i2)) {
                        i3 = zzhca.zzh(i9, unsafe.getObject(obj, j), zzx(i6));
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzz5 = zzgza.zzz(i9 << 3);
                        zzd = ((zzgyl) unsafe.getObject(obj, j)).zzd();
                        zzz6 = zzgza.zzz(zzd);
                        i3 = zzz5 + zzz6 + zzd;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(obj, i6, i, z, i2)) {
                        int i14 = unsafe.getInt(obj, j);
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzz(i14);
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzA(unsafe.getInt(obj, j));
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzz2 = zzgza.zzz(i9 << 3);
                        i3 = zzz2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzz = zzgza.zzz(i9 << 3);
                        i3 = zzz + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(obj, i6, i, z, i2)) {
                        int i15 = unsafe.getInt(obj, j);
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzz((i15 >> 31) ^ (i15 + i15));
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(obj, i6, i, z, i2)) {
                        long j4 = unsafe.getLong(obj, j);
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzA((j4 >> 63) ^ (j4 + j4));
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzO(obj, i6, i, z, i2)) {
                        i3 = zzgza.zzw(i9, (zzhbe) unsafe.getObject(obj, j), zzx(i6));
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i3 = zzhca.zzd(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 19:
                    i3 = zzhca.zzb(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i16 = zzhca.zza;
                    if (list.size() != 0) {
                        zzg = zzhca.zzg(list) + (list.size() * zzgza.zzz(i9 << 3));
                        i7 += zzg;
                        break;
                    }
                    zzg = z2;
                    i7 += zzg;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i17 = zzhca.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzz3 = zzhca.zzl(list2);
                        zzz7 = zzgza.zzz(i9 << 3);
                        zzA = size * zzz7;
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i18 = zzhca.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzz3 = zzhca.zzf(list3);
                        zzz7 = zzgza.zzz(i9 << 3);
                        zzA = size * zzz7;
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 23:
                    i3 = zzhca.zzd(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 24:
                    i3 = zzhca.zzb(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 25:
                    int i19 = zzhca.zza;
                    int size2 = ((List) unsafe.getObject(obj, j)).size();
                    if (size2 != 0) {
                        i3 = size2 * (zzgza.zzz(i9 << 3) + 1);
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i20 = zzhca.zza;
                    int size3 = r0.size();
                    if (size3 != 0) {
                        zzg = zzgza.zzz(i9 << 3) * size3;
                        if (r0 instanceof zzham) {
                            ?? r02 = (zzham) r0;
                            for (int i21 = z2; i21 < size3; i21++) {
                                Object zzf = r02.zzf(i21);
                                if (zzf instanceof zzgyl) {
                                    int zzd2 = ((zzgyl) zzf).zzd();
                                    zzg += zzgza.zzz(zzd2) + zzd2;
                                } else {
                                    zzg += zzgza.zzy((String) zzf);
                                }
                            }
                        } else {
                            for (int i22 = z2; i22 < size3; i22++) {
                                Object obj2 = r0.get(i22);
                                if (obj2 instanceof zzgyl) {
                                    int zzd3 = ((zzgyl) obj2).zzd();
                                    zzg += zzgza.zzz(zzd3) + zzd3;
                                } else {
                                    zzg += zzgza.zzy((String) obj2);
                                }
                            }
                        }
                        i7 += zzg;
                        break;
                    }
                    zzg = z2;
                    i7 += zzg;
                case 27:
                    ?? r03 = (List) unsafe.getObject(obj, j);
                    zzhby zzx = zzx(i6);
                    int i23 = zzhca.zza;
                    int size4 = r03.size();
                    if (size4 == 0) {
                        zzz8 = z2;
                    } else {
                        zzz8 = zzgza.zzz(i9 << 3) * size4;
                        for (int i24 = z2; i24 < size4; i24++) {
                            Object obj3 = r03.get(i24);
                            if (obj3 instanceof zzhak) {
                                int zza2 = ((zzhak) obj3).zza();
                                zzz8 += zzgza.zzz(zza2) + zza2;
                            } else {
                                zzz8 += zzgza.zzx((zzhbe) obj3, zzx);
                            }
                        }
                    }
                    i7 += zzz8;
                    break;
                case 28:
                    ?? r04 = (List) unsafe.getObject(obj, j);
                    int i25 = zzhca.zza;
                    int size5 = r04.size();
                    if (size5 == 0) {
                        zzz9 = z2;
                    } else {
                        zzz9 = size5 * zzgza.zzz(i9 << 3);
                        for (int i26 = z2; i26 < r04.size(); i26++) {
                            int zzd4 = ((zzgyl) r04.get(i26)).zzd();
                            zzz9 += zzgza.zzz(zzd4) + zzd4;
                        }
                    }
                    i7 += zzz9;
                    break;
                case 29:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i27 = zzhca.zza;
                    size = list4.size();
                    if (size != 0) {
                        zzz3 = zzhca.zzk(list4);
                        zzz7 = zzgza.zzz(i9 << 3);
                        zzA = size * zzz7;
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 30:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i28 = zzhca.zza;
                    size = list5.size();
                    if (size != 0) {
                        zzz3 = zzhca.zza(list5);
                        zzz7 = zzgza.zzz(i9 << 3);
                        zzA = size * zzz7;
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 31:
                    i3 = zzhca.zzb(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 32:
                    i3 = zzhca.zzd(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 33:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i29 = zzhca.zza;
                    size = list6.size();
                    if (size != 0) {
                        zzz3 = zzhca.zzi(list6);
                        zzz7 = zzgza.zzz(i9 << 3);
                        zzA = size * zzz7;
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 34:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i30 = zzhca.zza;
                    size = list7.size();
                    if (size != 0) {
                        zzz3 = zzhca.zzj(list7);
                        zzz7 = zzgza.zzz(i9 << 3);
                        zzA = size * zzz7;
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 35:
                    zze = zzhca.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zze = zzhca.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zze = zzhca.zzg((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zze = zzhca.zzl((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zze = zzhca.zzf((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zze = zzhca.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zze = zzhca.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    int i31 = zzhca.zza;
                    zze = ((List) unsafe.getObject(obj, j)).size();
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zze = zzhca.zzk((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zze = zzhca.zza((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zze = zzhca.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zze = zzhca.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zze = zzhca.zzi((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zze = zzhca.zzj((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzz10 = zzgza.zzz(i9 << 3);
                        zzz11 = zzgza.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i7 += zzz9;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    ?? r05 = (List) unsafe.getObject(obj, j);
                    zzhby zzx2 = zzx(i6);
                    int i32 = zzhca.zza;
                    int size6 = r05.size();
                    if (size6 == 0) {
                        i4 = z2;
                    } else {
                        boolean z4 = z2;
                        i4 = z4;
                        for (int i33 = z4; i33 < size6; i33++) {
                            i4 += zzgza.zzw(i9, (zzhbe) r05.get(i33), zzx2);
                        }
                    }
                    i7 += i4;
                    break;
                case 50:
                    zzhay zzhayVar = (zzhay) unsafe.getObject(obj, j);
                    zzhax zzhaxVar = (zzhax) zzz(i6);
                    if (zzhayVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzhayVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                        break;
                    }
                case 51:
                    if (zzR(obj, i9, i6)) {
                        zzz = zzgza.zzz(i9 << 3);
                        i3 = zzz + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i9, i6)) {
                        zzz2 = zzgza.zzz(i9 << 3);
                        i3 = zzz2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i9, i6)) {
                        long zzv = zzv(obj, j);
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzA(zzv);
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i9, i6)) {
                        long zzv2 = zzv(obj, j);
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzA(zzv2);
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i9, i6)) {
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzA(zzp(obj, j));
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i9, i6)) {
                        zzz = zzgza.zzz(i9 << 3);
                        i3 = zzz + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i9, i6)) {
                        zzz2 = zzgza.zzz(i9 << 3);
                        i3 = zzz2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i9, i6)) {
                        zzz4 = zzgza.zzz(i9 << 3);
                        i3 = zzz4 + 1;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzR(obj, i9, i6)) {
                        break;
                    } else {
                        int i34 = i9 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzgyl) {
                            zzz5 = zzgza.zzz(i34);
                            zzd = ((zzgyl) object2).zzd();
                            zzz6 = zzgza.zzz(zzd);
                            i3 = zzz5 + zzz6 + zzd;
                            i7 += i3;
                            break;
                        } else {
                            zzz3 = zzgza.zzz(i34);
                            zzA = zzgza.zzy((String) object2);
                            i3 = zzz3 + zzA;
                            i7 += i3;
                        }
                    }
                case 60:
                    if (zzR(obj, i9, i6)) {
                        i3 = zzhca.zzh(i9, unsafe.getObject(obj, j), zzx(i6));
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i9, i6)) {
                        zzz5 = zzgza.zzz(i9 << 3);
                        zzd = ((zzgyl) unsafe.getObject(obj, j)).zzd();
                        zzz6 = zzgza.zzz(zzd);
                        i3 = zzz5 + zzz6 + zzd;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i9, i6)) {
                        int zzp = zzp(obj, j);
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzz(zzp);
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i9, i6)) {
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzA(zzp(obj, j));
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i9, i6)) {
                        zzz2 = zzgza.zzz(i9 << 3);
                        i3 = zzz2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i9, i6)) {
                        zzz = zzgza.zzz(i9 << 3);
                        i3 = zzz + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i9, i6)) {
                        int zzp2 = zzp(obj, j);
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzz((zzp2 >> 31) ^ (zzp2 + zzp2));
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i9, i6)) {
                        long zzv3 = zzv(obj, j);
                        zzz3 = zzgza.zzz(i9 << 3);
                        zzA = zzgza.zzA((zzv3 >> 63) ^ (zzv3 + zzv3));
                        i3 = zzz3 + zzA;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i9, i6)) {
                        i3 = zzgza.zzw(i9, (zzhbe) unsafe.getObject(obj, j), zzx(i6));
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
            }
            i6 += 3;
            i8 = i;
            z3 = z;
            z2 = false;
            i5 = 1048575;
        }
        zzhcp zzhcpVar = this.zzn;
        int zza3 = i7 + zzhcpVar.zza(zzhcpVar.zzd(obj));
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        return zza3;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int zzu = zzu(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & zzu;
            int zzt = zzt(zzu);
            int i6 = iArr[i4];
            long j = i5;
            int i7 = 37;
            switch (zzt) {
                case 0:
                    i = i3 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzhcz.zzb(obj, j));
                    byte[] bArr = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    floatToIntBits = Float.floatToIntBits(zzhcz.zzc(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    doubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr2 = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    doubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr3 = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    doubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr4 = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    floatToIntBits = zzhae.zza(zzhcz.zzz(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    floatToIntBits = ((String) zzhcz.zzh(obj, j)).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object zzh = zzhcz.zzh(obj, j);
                    if (zzh != null) {
                        i7 = zzh.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 10:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    doubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr5 = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    doubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr6 = zzhae.zzd;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object zzh2 = zzhcz.zzh(obj, j);
                    if (zzh2 != null) {
                        i7 = zzh2.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 51:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = Float.floatToIntBits(zzo(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr8 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr9 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr10 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhae.zza(zzS(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = ((String) zzhcz.zzh(obj, j)).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr11 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzp(obj, j);
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = zzv(obj, j);
                        byte[] bArr12 = zzhae.zzd;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzhcz.zzh(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzn.zzd(obj).hashCode();
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        return hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x0b68, code lost:
        if (r5 == r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0b6a, code lost:
        r14.putInt(r7, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x0b6e, code lost:
        r11 = r12.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:488:0x0b73, code lost:
        if (r11 >= r12.zzl) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:489:0x0b75, code lost:
        zzy(r34, r12.zzj[r11], null, r12.zzn, r34);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:490:0x0b88, code lost:
        if (r9 != 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:491:0x0b8a, code lost:
        if (r6 != r10) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:0x0b91, code lost:
        throw com.google.android.gms.internal.ads.zzhag.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:495:0x0b92, code lost:
        if (r6 > r10) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x0b94, code lost:
        if (r8 != r9) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x0b96, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:0x0b9b, code lost:
        throw com.google.android.gms.internal.ads.zzhag.zzg();
     */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x05b4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:189:0x04c1 -> B:190:0x04c2). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:222:0x0561 -> B:223:0x0562). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:242:0x05b1 -> B:243:0x05b2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.ads.zzgxx r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3116
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhbh.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzgxx):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final Object zze() {
        return ((zzgzu) this.zzg).zzaD();
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzgzu) {
                zzgzu zzgzuVar = (zzgzu) obj;
                zzgzuVar.zzaV(Integer.MAX_VALUE);
                zzgzuVar.zza = 0;
                zzgzuVar.zzaT();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzu = zzu(i);
                int i2 = 1048575 & zzu;
                int zzt = zzt(zzu);
                long j = i2;
                if (zzt != 9) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj, this.zzc[i], i)) {
                            zzx(i).zzf(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzt) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzm.zzb(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzhay) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                }
                if (zzN(obj, i)) {
                    zzx(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zze(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzu = zzu(i);
            int i2 = 1048575 & zzu;
            int[] iArr = this.zzc;
            int zzt = zzt(zzu);
            int i3 = iArr[i];
            long j = i2;
            switch (zzt) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzhcz.zzr(obj, j, zzhcz.zzb(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzN(obj2, i)) {
                        zzhcz.zzs(obj, j, zzhcz.zzc(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzN(obj2, i)) {
                        zzhcz.zzp(obj, j, zzhcz.zzz(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzN(obj2, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzE(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzc(obj, obj2, j);
                    break;
                case 50:
                    int i4 = zzhca.zza;
                    zzhcz.zzv(obj, j, zzhaz.zzb(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzR(obj2, i3, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzI(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzF(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i3, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzI(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
        }
        zzhca.zzq(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x0611 A[Catch: all -> 0x0606, TryCatch #4 {all -> 0x0606, blocks: (B:148:0x05e5, B:159:0x060c, B:161:0x0611, B:162:0x0616), top: B:189:0x05e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0649 A[LOOP:2: B:177:0x0645->B:179:0x0649, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x061c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhby
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(java.lang.Object r18, com.google.android.gms.internal.ads.zzhbq r19, com.google.android.gms.internal.ads.zzgzf r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhbh.zzh(java.lang.Object, com.google.android.gms.internal.ads.zzhbq, com.google.android.gms.internal.ads.zzgzf):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgxx zzgxxVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzgxxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzs;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzu = zzu(i);
            long j = zzu & 1048575;
            switch (zzt(zzu)) {
                case 0:
                    if (zzL(obj, obj2, i) && Double.doubleToLongBits(zzhcz.zzb(obj, j)) == Double.doubleToLongBits(zzhcz.zzb(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzL(obj, obj2, i) && Float.floatToIntBits(zzhcz.zzc(obj, j)) == Float.floatToIntBits(zzhcz.zzc(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzL(obj, obj2, i) && zzhcz.zzf(obj, j) == zzhcz.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzL(obj, obj2, i) && zzhcz.zzf(obj, j) == zzhcz.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzL(obj, obj2, i) && zzhcz.zzd(obj, j) == zzhcz.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzL(obj, obj2, i) && zzhcz.zzf(obj, j) == zzhcz.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzL(obj, obj2, i) && zzhcz.zzd(obj, j) == zzhcz.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzL(obj, obj2, i) && zzhcz.zzz(obj, j) == zzhcz.zzz(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzL(obj, obj2, i) && zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzL(obj, obj2, i) && zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzL(obj, obj2, i) && zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzL(obj, obj2, i) && zzhcz.zzd(obj, j) == zzhcz.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzL(obj, obj2, i) && zzhcz.zzd(obj, j) == zzhcz.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzL(obj, obj2, i) && zzhcz.zzd(obj, j) == zzhcz.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzL(obj, obj2, i) && zzhcz.zzf(obj, j) == zzhcz.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzL(obj, obj2, i) && zzhcz.zzd(obj, j) == zzhcz.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzL(obj, obj2, i) && zzhcz.zzf(obj, j) == zzhcz.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzL(obj, obj2, i) && zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzs = zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j));
                    break;
                case 50:
                    zzs = zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzr = zzr(i) & 1048575;
                    if (zzhcz.zzd(obj, zzr) == zzhcz.zzd(obj2, zzr) && zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzs) {
                return false;
            }
        }
        if (this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            if (this.zzh) {
                this.zzo.zza(obj);
                this.zzo.zza(obj2);
                throw null;
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i6 = iArr[i4];
            int i7 = iArr2[i6];
            int zzu = zzu(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i3 = zzb.getInt(obj, i9);
                }
                i2 = i3;
                i = i9;
            } else {
                i = i5;
                i2 = i3;
            }
            if ((268435456 & zzu) != 0 && !zzO(obj, i6, i, i2, i10)) {
                return false;
            }
            int zzt = zzt(zzu);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj, i7, i6) && !zzP(obj, zzu, zzx(i6))) {
                            return false;
                        }
                    } else if (zzt != 49) {
                        if (zzt == 50 && !((zzhay) zzhcz.zzh(obj, zzu & 1048575)).isEmpty()) {
                            zzhax zzhaxVar = (zzhax) zzz(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzhcz.zzh(obj, zzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzhby zzx = zzx(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzx.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzO(obj, i6, i, i2, i10) && !zzP(obj, zzu, zzx(i6))) {
                return false;
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzm(Object obj, zzgzb zzgzbVar) throws IOException {
        int i;
        int i2;
        int i3;
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < iArr.length) {
            int zzu = zzu(i7);
            int[] iArr2 = this.zzc;
            int zzt = zzt(zzu);
            int i8 = iArr2[i7];
            if (zzt <= 17) {
                int i9 = iArr2[i7 + 2];
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = i5;
                i2 = i6;
                i3 = 1 << (i9 >>> 20);
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            long j = zzu & i4;
            switch (zzt) {
                case 0:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzf(i8, zzhcz.zzb(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzo(i8, zzhcz.zzc(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzt(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzJ(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzr(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzm(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzk(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzb(i8, zzhcz.zzz(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzT(i8, unsafe.getObject(obj, j), zzgzbVar);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzd(i8, (zzgyl) unsafe.getObject(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzH(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzi(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzw(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzy(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzA(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzC(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzhca.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 19:
                    zzhca.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 20:
                    zzhca.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 21:
                    zzhca.zzG(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 22:
                    zzhca.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 23:
                    zzhca.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 24:
                    zzhca.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 25:
                    zzhca.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 26:
                    int i11 = this.zzc[i7];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zzhca.zza;
                    if (list != null && !list.isEmpty()) {
                        zzgzbVar.zzG(i11, list);
                        break;
                    }
                    break;
                case 27:
                    int i13 = this.zzc[i7];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzhby zzx = zzx(i7);
                    int i14 = zzhca.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            zzgzbVar.zzv(i13, list2.get(i15), zzx);
                        }
                        break;
                    }
                    break;
                case 28:
                    int i16 = this.zzc[i7];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zzhca.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzgzbVar.zze(i16, list3);
                        break;
                    }
                    break;
                case 29:
                    zzhca.zzF(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 30:
                    zzhca.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 31:
                    zzhca.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 32:
                    zzhca.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 33:
                    zzhca.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 34:
                    zzhca.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 35:
                    zzhca.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 36:
                    zzhca.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 37:
                    zzhca.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 38:
                    zzhca.zzG(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 39:
                    zzhca.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 40:
                    zzhca.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 41:
                    zzhca.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 42:
                    zzhca.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 43:
                    zzhca.zzF(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 44:
                    zzhca.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 45:
                    zzhca.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 46:
                    zzhca.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 47:
                    zzhca.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 48:
                    zzhca.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 49:
                    int i18 = this.zzc[i7];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzhby zzx2 = zzx(i7);
                    int i19 = zzhca.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            zzgzbVar.zzq(i18, list4.get(i20), zzx2);
                        }
                        break;
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        zzhax zzhaxVar = (zzhax) zzz(i7);
                        throw null;
                    }
                    break;
                case 51:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzf(i8, zzn(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzo(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzt(i8, zzv(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzJ(i8, zzv(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzr(i8, zzp(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzm(i8, zzv(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzk(i8, zzp(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzb(i8, zzS(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzR(obj, i8, i7)) {
                        zzT(i8, unsafe.getObject(obj, j), zzgzbVar);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzd(i8, (zzgyl) unsafe.getObject(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzH(i8, zzp(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzi(i8, zzp(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzw(i8, zzp(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzy(i8, zzv(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzA(i8, zzp(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzC(i8, zzv(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                        break;
                    } else {
                        break;
                    }
            }
            i7 += 3;
            i5 = i;
            i6 = i2;
            i4 = 1048575;
        }
        zzhcp zzhcpVar = this.zzn;
        zzhcpVar.zzr(zzhcpVar.zzd(obj), zzgzbVar);
    }
}
