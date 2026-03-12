package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzol<T> implements zzow<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzps.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzoi zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzpl zzm;
    private final zzmp zzn;

    private zzol(int[] iArr, Object[] objArr, int i, int i2, zzoi zzoiVar, boolean z, int[] iArr2, int i3, int i4, zzoo zzooVar, zznv zznvVar, zzpl zzplVar, zzmp zzmpVar, zzod zzodVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzoiVar instanceof zznd;
        boolean z2 = false;
        if (zzmpVar != null && (zzoiVar instanceof zzna)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzplVar;
        this.zzn = zzmpVar;
        this.zzg = zzoiVar;
    }

    private final Object zzA(Object obj, int i) {
        zzow zzx = zzx(i);
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
        zzow zzx = zzx(i2);
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
            zzow zzx = zzx(i);
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
            zzow zzx = zzx(i);
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

    private final void zzG(Object obj, int i, zzov zzovVar) throws IOException {
        long j = i & 1048575;
        if (zzM(i)) {
            zzps.zzs(obj, j, zzovVar.zzs());
        } else if (!this.zzi) {
            zzps.zzs(obj, j, zzovVar.zzp());
        } else {
            zzps.zzs(obj, j, zzovVar.zzr());
        }
    }

    private final void zzH(Object obj, int i) {
        int zzr = zzr(i);
        long j = 1048575 & zzr;
        if (j == 1048575) {
            return;
        }
        zzps.zzq(obj, j, (1 << (zzr >>> 20)) | zzps.zzc(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzps.zzq(obj, zzr(i2) & 1048575, i);
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
            return (zzps.zzc(obj, j) & (1 << (zzr >>> 20))) != 0;
        }
        int zzu = zzu(i);
        long j2 = zzu & 1048575;
        switch (zzt(zzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzps.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzps.zzb(obj, j2)) != 0;
            case 2:
                return zzps.zzd(obj, j2) != 0;
            case 3:
                return zzps.zzd(obj, j2) != 0;
            case 4:
                return zzps.zzc(obj, j2) != 0;
            case 5:
                return zzps.zzd(obj, j2) != 0;
            case 6:
                return zzps.zzc(obj, j2) != 0;
            case 7:
                return zzps.zzw(obj, j2);
            case 8:
                Object zzf = zzps.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                } else if (zzf instanceof zzle) {
                    return !zzle.zzb.equals(zzf);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzps.zzf(obj, j2) != null;
            case 10:
                return !zzle.zzb.equals(zzps.zzf(obj, j2));
            case 11:
                return zzps.zzc(obj, j2) != 0;
            case 12:
                return zzps.zzc(obj, j2) != 0;
            case 13:
                return zzps.zzc(obj, j2) != 0;
            case 14:
                return zzps.zzd(obj, j2) != 0;
            case 15:
                return zzps.zzc(obj, j2) != 0;
            case 16:
                return zzps.zzd(obj, j2) != 0;
            case 17:
                return zzps.zzf(obj, j2) != null;
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

    private static boolean zzP(Object obj, int i, zzow zzowVar) {
        return zzowVar.zzl(zzps.zzf(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zznd) {
            return ((zznd) obj).zzL();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzps.zzc(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzps.zzf(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzpy zzpyVar) throws IOException {
        if (obj instanceof String) {
            zzpyVar.zzG(i, (String) obj);
        } else {
            zzpyVar.zzd(i, (zzle) obj);
        }
    }

    static zzpm zzd(Object obj) {
        zznd zzndVar = (zznd) obj;
        zzpm zzpmVar = zzndVar.zzc;
        if (zzpmVar == zzpm.zzc()) {
            zzpm zzf = zzpm.zzf();
            zzndVar.zzc = zzf;
            return zzf;
        }
        return zzpmVar;
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
    public static com.google.android.recaptcha.internal.zzol zzm(java.lang.Class r34, com.google.android.recaptcha.internal.zzof r35, com.google.android.recaptcha.internal.zzoo r36, com.google.android.recaptcha.internal.zznv r37, com.google.android.recaptcha.internal.zzpl r38, com.google.android.recaptcha.internal.zzmp r39, com.google.android.recaptcha.internal.zzod r40) {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzol.zzm(java.lang.Class, com.google.android.recaptcha.internal.zzof, com.google.android.recaptcha.internal.zzoo, com.google.android.recaptcha.internal.zznv, com.google.android.recaptcha.internal.zzpl, com.google.android.recaptcha.internal.zzmp, com.google.android.recaptcha.internal.zzod):com.google.android.recaptcha.internal.zzol");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzps.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzps.zzf(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzps.zzf(obj, j)).intValue();
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
        return ((Long) zzps.zzf(obj, j)).longValue();
    }

    private final zznh zzw(int i) {
        int i2 = i / 3;
        return (zznh) this.zzd[i2 + i2 + 1];
    }

    private final zzow zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzow zzowVar = (zzow) objArr[i3];
        if (zzowVar != null) {
            return zzowVar;
        }
        zzow zzb2 = zzos.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzpl zzplVar, Object obj3) {
        int i2 = this.zzc[i];
        Object zzf = zzps.zzf(obj, zzu(i) & 1048575);
        if (zzf == null || zzw(i) == null) {
            return obj2;
        }
        zzoc zzocVar = (zzoc) zzf;
        zzob zzobVar = (zzob) zzz(i);
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v263, types: [int] */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [int] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v46, types: [int] */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r4v10, types: [int] */
    /* JADX WARN: Type inference failed for: r4v11, types: [int] */
    /* JADX WARN: Type inference failed for: r4v12, types: [int] */
    /* JADX WARN: Type inference failed for: r4v13, types: [int] */
    /* JADX WARN: Type inference failed for: r4v14, types: [int] */
    /* JADX WARN: Type inference failed for: r4v15, types: [int] */
    /* JADX WARN: Type inference failed for: r4v16, types: [int] */
    /* JADX WARN: Type inference failed for: r4v17, types: [int] */
    /* JADX WARN: Type inference failed for: r4v18, types: [int] */
    /* JADX WARN: Type inference failed for: r4v19, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v6, types: [int] */
    /* JADX WARN: Type inference failed for: r4v7, types: [int] */
    /* JADX WARN: Type inference failed for: r4v8, types: [int] */
    /* JADX WARN: Type inference failed for: r4v9, types: [int] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.recaptcha.internal.zzow
    public final int zza(Object obj) {
        int i;
        boolean z;
        int i2;
        int zzA;
        int zzA2;
        int zzA3;
        int zzB;
        int zzA4;
        int zzA5;
        int zzd;
        int zzA6;
        int zzg;
        int size;
        int zzA7;
        int zzA8;
        int zzA9;
        int i3;
        int zze;
        int zzA10;
        int zzA11;
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
            if (zzt >= zzmu.DOUBLE_LIST_PACKED.zza()) {
                zzmu.SINT64_LIST_PACKED.zza();
            }
            long j = i12;
            switch (zzt) {
                case 0:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzA = zzln.zzA(i9 << 3);
                        i3 = zzA + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzA2 = zzln.zzA(i9 << 3);
                        i3 = zzA2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzO(obj, i6, i, z, i2)) {
                        long j2 = unsafe.getLong(obj, j);
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzB(j2);
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzO(obj, i6, i, z, i2)) {
                        long j3 = unsafe.getLong(obj, j);
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzB(j3);
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzB(unsafe.getInt(obj, j));
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzA = zzln.zzA(i9 << 3);
                        i3 = zzA + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzA2 = zzln.zzA(i9 << 3);
                        i3 = zzA2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzA4 = zzln.zzA(i9 << 3);
                        i3 = zzA4 + 1;
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
                        if (object instanceof zzle) {
                            zzA5 = zzln.zzA(i13);
                            zzd = ((zzle) object).zzd();
                            zzA6 = zzln.zzA(zzd);
                            i3 = zzA5 + zzA6 + zzd;
                            i7 += i3;
                            break;
                        } else {
                            zzA3 = zzln.zzA(i13);
                            zzB = zzln.zzz((String) object);
                            i3 = zzA3 + zzB;
                            i7 += i3;
                        }
                    }
                case 9:
                    if (zzO(obj, i6, i, z, i2)) {
                        i3 = zzoy.zzh(i9, unsafe.getObject(obj, j), zzx(i6));
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzA5 = zzln.zzA(i9 << 3);
                        zzd = ((zzle) unsafe.getObject(obj, j)).zzd();
                        zzA6 = zzln.zzA(zzd);
                        i3 = zzA5 + zzA6 + zzd;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzO(obj, i6, i, z, i2)) {
                        int i14 = unsafe.getInt(obj, j);
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzA(i14);
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzB(unsafe.getInt(obj, j));
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzA2 = zzln.zzA(i9 << 3);
                        i3 = zzA2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzO(obj, i6, i, z, i2)) {
                        zzA = zzln.zzA(i9 << 3);
                        i3 = zzA + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzO(obj, i6, i, z, i2)) {
                        int i15 = unsafe.getInt(obj, j);
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzA((i15 >> 31) ^ (i15 + i15));
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzO(obj, i6, i, z, i2)) {
                        long j4 = unsafe.getLong(obj, j);
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzB((j4 >> 63) ^ (j4 + j4));
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzO(obj, i6, i, z, i2)) {
                        i3 = zzln.zzw(i9, (zzoi) unsafe.getObject(obj, j), zzx(i6));
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i3 = zzoy.zzd(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 19:
                    i3 = zzoy.zzb(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i16 = zzoy.zza;
                    if (list.size() != 0) {
                        zzg = zzoy.zzg(list) + (list.size() * zzln.zzA(i9 << 3));
                        i7 += zzg;
                        break;
                    }
                    zzg = z2;
                    i7 += zzg;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i17 = zzoy.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzA3 = zzoy.zzl(list2);
                        zzA7 = zzln.zzA(i9 << 3);
                        zzB = size * zzA7;
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i18 = zzoy.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzA3 = zzoy.zzf(list3);
                        zzA7 = zzln.zzA(i9 << 3);
                        zzB = size * zzA7;
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 23:
                    i3 = zzoy.zzd(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 24:
                    i3 = zzoy.zzb(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 25:
                    int i19 = zzoy.zza;
                    int size2 = ((List) unsafe.getObject(obj, j)).size();
                    if (size2 != 0) {
                        i3 = size2 * (zzln.zzA(i9 << 3) + 1);
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i20 = zzoy.zza;
                    int size3 = r0.size();
                    if (size3 != 0) {
                        zzg = zzln.zzA(i9 << 3) * size3;
                        if (r0 instanceof zznu) {
                            zznu zznuVar = (zznu) r0;
                            for (int i21 = z2; i21 < size3; i21++) {
                                Object zzc = zznuVar.zzc();
                                if (zzc instanceof zzle) {
                                    int zzd2 = ((zzle) zzc).zzd();
                                    zzg += zzln.zzA(zzd2) + zzd2;
                                } else {
                                    zzg += zzln.zzz((String) zzc);
                                }
                            }
                        } else {
                            for (int i22 = z2; i22 < size3; i22++) {
                                Object obj2 = r0.get(i22);
                                if (obj2 instanceof zzle) {
                                    int zzd3 = ((zzle) obj2).zzd();
                                    zzg += zzln.zzA(zzd3) + zzd3;
                                } else {
                                    zzg += zzln.zzz((String) obj2);
                                }
                            }
                        }
                        i7 += zzg;
                        break;
                    }
                    zzg = z2;
                    i7 += zzg;
                case 27:
                    ?? r02 = (List) unsafe.getObject(obj, j);
                    zzow zzx = zzx(i6);
                    int i23 = zzoy.zza;
                    int size4 = r02.size();
                    if (size4 == 0) {
                        zzA8 = z2;
                    } else {
                        zzA8 = zzln.zzA(i9 << 3) * size4;
                        for (int i24 = z2; i24 < size4; i24++) {
                            Object obj3 = r02.get(i24);
                            if (obj3 instanceof zznt) {
                                int zza2 = ((zznt) obj3).zza();
                                zzA8 += zzln.zzA(zza2) + zza2;
                            } else {
                                zzA8 += zzln.zzy((zzoi) obj3, zzx);
                            }
                        }
                    }
                    i7 += zzA8;
                    break;
                case 28:
                    ?? r03 = (List) unsafe.getObject(obj, j);
                    int i25 = zzoy.zza;
                    int size5 = r03.size();
                    if (size5 == 0) {
                        zzA9 = z2;
                    } else {
                        zzA9 = size5 * zzln.zzA(i9 << 3);
                        for (int i26 = z2; i26 < r03.size(); i26++) {
                            int zzd4 = ((zzle) r03.get(i26)).zzd();
                            zzA9 += zzln.zzA(zzd4) + zzd4;
                        }
                    }
                    i7 += zzA9;
                    break;
                case 29:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i27 = zzoy.zza;
                    size = list4.size();
                    if (size != 0) {
                        zzA3 = zzoy.zzk(list4);
                        zzA7 = zzln.zzA(i9 << 3);
                        zzB = size * zzA7;
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 30:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i28 = zzoy.zza;
                    size = list5.size();
                    if (size != 0) {
                        zzA3 = zzoy.zza(list5);
                        zzA7 = zzln.zzA(i9 << 3);
                        zzB = size * zzA7;
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 31:
                    i3 = zzoy.zzb(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 32:
                    i3 = zzoy.zzd(i9, (List) unsafe.getObject(obj, j), z2);
                    i7 += i3;
                    break;
                case 33:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i29 = zzoy.zza;
                    size = list6.size();
                    if (size != 0) {
                        zzA3 = zzoy.zzi(list6);
                        zzA7 = zzln.zzA(i9 << 3);
                        zzB = size * zzA7;
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 34:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i30 = zzoy.zza;
                    size = list7.size();
                    if (size != 0) {
                        zzA3 = zzoy.zzj(list7);
                        zzA7 = zzln.zzA(i9 << 3);
                        zzB = size * zzA7;
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    }
                    i3 = z2;
                    i7 += i3;
                case 35:
                    zze = zzoy.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zze = zzoy.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    zze = zzoy.zzg((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    zze = zzoy.zzl((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    zze = zzoy.zzf((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zze = zzoy.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zze = zzoy.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    int i31 = zzoy.zza;
                    zze = ((List) unsafe.getObject(obj, j)).size();
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    zze = zzoy.zzk((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    zze = zzoy.zza((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zze = zzoy.zzc((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zze = zzoy.zze((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    zze = zzoy.zzi((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    zze = zzoy.zzj((List) unsafe.getObject(obj, j));
                    if (zze > 0) {
                        zzA10 = zzln.zzA(i9 << 3);
                        zzA11 = zzln.zzA(zze);
                        zzA9 = zzA10 + zzA11 + zze;
                        i7 += zzA9;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    ?? r04 = (List) unsafe.getObject(obj, j);
                    zzow zzx2 = zzx(i6);
                    int i32 = zzoy.zza;
                    int size6 = r04.size();
                    if (size6 == 0) {
                        i4 = z2;
                    } else {
                        boolean z4 = z2;
                        i4 = z4;
                        for (int i33 = z4; i33 < size6; i33++) {
                            i4 += zzln.zzw(i9, (zzoi) r04.get(i33), zzx2);
                        }
                    }
                    i7 += i4;
                    break;
                case 50:
                    zzoc zzocVar = (zzoc) unsafe.getObject(obj, j);
                    zzob zzobVar = (zzob) zzz(i6);
                    if (zzocVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzocVar.entrySet().iterator();
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
                        zzA = zzln.zzA(i9 << 3);
                        i3 = zzA + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i9, i6)) {
                        zzA2 = zzln.zzA(i9 << 3);
                        i3 = zzA2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i9, i6)) {
                        long zzv = zzv(obj, j);
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzB(zzv);
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i9, i6)) {
                        long zzv2 = zzv(obj, j);
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzB(zzv2);
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i9, i6)) {
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzB(zzp(obj, j));
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i9, i6)) {
                        zzA = zzln.zzA(i9 << 3);
                        i3 = zzA + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i9, i6)) {
                        zzA2 = zzln.zzA(i9 << 3);
                        i3 = zzA2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i9, i6)) {
                        zzA4 = zzln.zzA(i9 << 3);
                        i3 = zzA4 + 1;
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
                        if (object2 instanceof zzle) {
                            zzA5 = zzln.zzA(i34);
                            zzd = ((zzle) object2).zzd();
                            zzA6 = zzln.zzA(zzd);
                            i3 = zzA5 + zzA6 + zzd;
                            i7 += i3;
                            break;
                        } else {
                            zzA3 = zzln.zzA(i34);
                            zzB = zzln.zzz((String) object2);
                            i3 = zzA3 + zzB;
                            i7 += i3;
                        }
                    }
                case 60:
                    if (zzR(obj, i9, i6)) {
                        i3 = zzoy.zzh(i9, unsafe.getObject(obj, j), zzx(i6));
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i9, i6)) {
                        zzA5 = zzln.zzA(i9 << 3);
                        zzd = ((zzle) unsafe.getObject(obj, j)).zzd();
                        zzA6 = zzln.zzA(zzd);
                        i3 = zzA5 + zzA6 + zzd;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i9, i6)) {
                        int zzp = zzp(obj, j);
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzA(zzp);
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i9, i6)) {
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzB(zzp(obj, j));
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i9, i6)) {
                        zzA2 = zzln.zzA(i9 << 3);
                        i3 = zzA2 + 4;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i9, i6)) {
                        zzA = zzln.zzA(i9 << 3);
                        i3 = zzA + 8;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i9, i6)) {
                        int zzp2 = zzp(obj, j);
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzA((zzp2 >> 31) ^ (zzp2 + zzp2));
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i9, i6)) {
                        long zzv3 = zzv(obj, j);
                        zzA3 = zzln.zzA(i9 << 3);
                        zzB = zzln.zzB((zzv3 >> 63) ^ (zzv3 + zzv3));
                        i3 = zzA3 + zzB;
                        i7 += i3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i9, i6)) {
                        i3 = zzln.zzw(i9, (zzoi) unsafe.getObject(obj, j), zzx(i6));
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
        int zza3 = i7 + ((zznd) obj).zzc.zza();
        if (this.zzh) {
            zzmt zzmtVar = ((zzna) obj).zzb;
            int zzc2 = zzmtVar.zza.zzc();
            int i35 = 0;
            for (int i36 = 0; i36 < zzc2; i36++) {
                Map.Entry zzg2 = zzmtVar.zza.zzg(i36);
                i35 += zzmt.zza((zzms) ((zzpa) zzg2).zza(), zzg2.getValue());
            }
            for (Map.Entry entry2 : zzmtVar.zza.zzd()) {
                i35 += zzmt.zza((zzms) entry2.getKey(), entry2.getValue());
            }
            return zza3 + i35;
        }
        return zza3;
    }

    @Override // com.google.android.recaptcha.internal.zzow
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
                    doubleToLongBits = Double.doubleToLongBits(zzps.zza(obj, j));
                    byte[] bArr = zznl.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    floatToIntBits = Float.floatToIntBits(zzps.zzb(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    doubleToLongBits = zzps.zzd(obj, j);
                    byte[] bArr2 = zznl.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    doubleToLongBits = zzps.zzd(obj, j);
                    byte[] bArr3 = zznl.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    floatToIntBits = zzps.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    doubleToLongBits = zzps.zzd(obj, j);
                    byte[] bArr4 = zznl.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    floatToIntBits = zzps.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    floatToIntBits = zznl.zza(zzps.zzw(obj, j));
                    i3 = i + floatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    floatToIntBits = ((String) zzps.zzf(obj, j)).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object zzf = zzps.zzf(obj, j);
                    if (zzf != null) {
                        i7 = zzf.hashCode();
                    }
                    i3 = i2 + i7;
                    break;
                case 10:
                    i = i3 * 53;
                    floatToIntBits = zzps.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    floatToIntBits = zzps.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    floatToIntBits = zzps.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    floatToIntBits = zzps.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    doubleToLongBits = zzps.zzd(obj, j);
                    byte[] bArr5 = zznl.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    floatToIntBits = zzps.zzc(obj, j);
                    i3 = i + floatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    doubleToLongBits = zzps.zzd(obj, j);
                    byte[] bArr6 = zznl.zzb;
                    floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    i3 = i + floatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object zzf2 = zzps.zzf(obj, j);
                    if (zzf2 != null) {
                        i7 = zzf2.hashCode();
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
                    floatToIntBits = zzps.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    floatToIntBits = zzps.zzf(obj, j).hashCode();
                    i3 = i + floatToIntBits;
                    break;
                case 51:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zznl.zzb;
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
                        byte[] bArr8 = zznl.zzb;
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
                        byte[] bArr9 = zznl.zzb;
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
                        byte[] bArr10 = zznl.zzb;
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
                        floatToIntBits = zznl.zza(zzS(obj, j));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = ((String) zzps.zzf(obj, j)).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzps.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzps.zzf(obj, j).hashCode();
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
                        byte[] bArr11 = zznl.zzb;
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
                        byte[] bArr12 = zznl.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        floatToIntBits = zzps.zzf(obj, j).hashCode();
                        i3 = i + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + ((zznd) obj).zzc.hashCode();
        return this.zzh ? (hashCode * 53) + ((zzna) obj).zzb.zza.hashCode() : hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:537:0x0d38, code lost:
        if (r5 == 1048575) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:538:0x0d3a, code lost:
        r31.putInt(r34, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:539:0x0d40, code lost:
        r11 = r13.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:541:0x0d46, code lost:
        if (r11 >= r13.zzl) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:542:0x0d48, code lost:
        zzy(r34, r13.zzj[r11], null, r13.zzm, r34);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:0x0d60, code lost:
        if (r10 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:545:0x0d62, code lost:
        if (r6 != r12) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:0x0d6a, code lost:
        throw new com.google.android.recaptcha.internal.zznn("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:549:0x0d6b, code lost:
        if (r6 > r12) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x0d6d, code lost:
        if (r9 != r10) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:551:0x0d6f, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:553:0x0d75, code lost:
        throw new com.google.android.recaptcha.internal.zznn("Failed to parse the message.");
     */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0657  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:188:0x054f -> B:189:0x0550). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:222:0x05fb -> B:223:0x05fc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:243:0x0654 -> B:244:0x0655). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.recaptcha.internal.zzkt r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzol.zzc(java.lang.Object, byte[], int, int, int, com.google.android.recaptcha.internal.zzkt):int");
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final Object zze() {
        return ((zznd) this.zzg).zzv();
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zznd) {
                zznd zzndVar = (zznd) obj;
                zzndVar.zzJ(Integer.MAX_VALUE);
                zzndVar.zza = 0;
                zzndVar.zzH();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzu = zzu(i);
                int i2 = 1048575 & zzu;
                int zzt = zzt(zzu);
                long j = i2;
                if (zzt != 9) {
                    if (zzt != 60 && zzt != 68) {
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
                                ((zznk) zzps.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzoc) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzR(obj, this.zzc[i], i)) {
                        zzx(i).zzf(zzb.getObject(obj, j));
                    }
                }
                if (zzN(obj, i)) {
                    zzx(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzi(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    @Override // com.google.android.recaptcha.internal.zzow
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
                        zzps.zzo(obj, j, zzps.zza(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzN(obj2, i)) {
                        zzps.zzp(obj, j, zzps.zzb(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j, zzps.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j, zzps.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j, zzps.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzN(obj2, i)) {
                        zzps.zzm(obj, j, zzps.zzw(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzN(obj2, i)) {
                        zzps.zzs(obj, j, zzps.zzf(obj2, j));
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
                        zzps.zzs(obj, j, zzps.zzf(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j, zzps.zzd(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j, zzps.zzd(obj2, j));
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
                    zznk zznkVar = (zznk) zzps.zzf(obj, j);
                    zznk zznkVar2 = (zznk) zzps.zzf(obj2, j);
                    int size = zznkVar.size();
                    int size2 = zznkVar2.size();
                    if (size > 0 && size2 > 0) {
                        if (!zznkVar.zzc()) {
                            zznkVar = zznkVar.zzd(size2 + size);
                        }
                        zznkVar.addAll(zznkVar2);
                    }
                    if (size > 0) {
                        zznkVar2 = zznkVar;
                    }
                    zzps.zzs(obj, j, zznkVar2);
                    break;
                case 50:
                    int i4 = zzoy.zza;
                    zzps.zzs(obj, j, zzod.zzb(zzps.zzf(obj, j), zzps.zzf(obj2, j)));
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
                        zzps.zzs(obj, j, zzps.zzf(obj2, j));
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
                        zzps.zzs(obj, j, zzps.zzf(obj2, j));
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
        zzoy.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzoy.zzp(this.zzn, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x015d  */
    @Override // com.google.android.recaptcha.internal.zzow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(java.lang.Object r12, com.google.android.recaptcha.internal.zzov r13, com.google.android.recaptcha.internal.zzmo r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzol.zzh(java.lang.Object, com.google.android.recaptcha.internal.zzov, com.google.android.recaptcha.internal.zzmo):void");
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzkt zzktVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzktVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x06ca  */
    @Override // com.google.android.recaptcha.internal.zzow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(java.lang.Object r24, com.google.android.recaptcha.internal.zzpy r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1914
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzol.zzj(java.lang.Object, com.google.android.recaptcha.internal.zzpy):void");
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzk(Object obj, Object obj2) {
        boolean zzF;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzu = zzu(i);
            long j = zzu & 1048575;
            switch (zzt(zzu)) {
                case 0:
                    if (zzL(obj, obj2, i) && Double.doubleToLongBits(zzps.zza(obj, j)) == Double.doubleToLongBits(zzps.zza(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzL(obj, obj2, i) && Float.floatToIntBits(zzps.zzb(obj, j)) == Float.floatToIntBits(zzps.zzb(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzL(obj, obj2, i) && zzps.zzd(obj, j) == zzps.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzL(obj, obj2, i) && zzps.zzd(obj, j) == zzps.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzL(obj, obj2, i) && zzps.zzc(obj, j) == zzps.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzL(obj, obj2, i) && zzps.zzd(obj, j) == zzps.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzL(obj, obj2, i) && zzps.zzc(obj, j) == zzps.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzL(obj, obj2, i) && zzps.zzw(obj, j) == zzps.zzw(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzL(obj, obj2, i) && zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzL(obj, obj2, i) && zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzL(obj, obj2, i) && zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzL(obj, obj2, i) && zzps.zzc(obj, j) == zzps.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzL(obj, obj2, i) && zzps.zzc(obj, j) == zzps.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzL(obj, obj2, i) && zzps.zzc(obj, j) == zzps.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzL(obj, obj2, i) && zzps.zzd(obj, j) == zzps.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzL(obj, obj2, i) && zzps.zzc(obj, j) == zzps.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzL(obj, obj2, i) && zzps.zzd(obj, j) == zzps.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzL(obj, obj2, i) && zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j))) {
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
                    zzF = zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j));
                    break;
                case 50:
                    zzF = zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j));
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
                    if (zzps.zzc(obj, zzr) == zzps.zzc(obj2, zzr) && zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzF) {
                return false;
            }
        }
        if (((zznd) obj).zzc.equals(((zznd) obj2).zzc)) {
            if (this.zzh) {
                return ((zzna) obj).zzb.equals(((zzna) obj2).zzb);
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzl(Object obj) {
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
                        if (zzt == 50 && !((zzoc) zzps.zzf(obj, zzu & 1048575)).isEmpty()) {
                            zzob zzobVar = (zzob) zzz(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzps.zzf(obj, zzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzow zzx = zzx(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzx.zzl(list.get(i11))) {
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
        return !this.zzh || ((zzna) obj).zzb.zzk();
    }
}
