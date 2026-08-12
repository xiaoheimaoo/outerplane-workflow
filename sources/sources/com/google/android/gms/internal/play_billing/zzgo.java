package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
public final class zzgo<T> implements zzgv<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzho.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgl zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzhh zzl;
    private final zzev zzm;

    private zzgo(int[] iArr, Object[] objArr, int i, int i2, zzgl zzglVar, boolean z, int[] iArr2, int i3, int i4, zzgq zzgqVar, zzfy zzfyVar, zzhh zzhhVar, zzev zzevVar, zzgg zzggVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzevVar != null && (zzglVar instanceof zzff)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzhhVar;
        this.zzm = zzevVar;
        this.zzg = zzglVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzs = zzs(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzs);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgv zzv = zzv(i);
            if (!zzI(obj, i)) {
                if (!zzL(object)) {
                    unsafe.putObject(obj, zzs, object);
                } else {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, zzs, zze);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzs);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, zzs, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzs = zzs(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzs);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzgv zzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (!zzL(object)) {
                    unsafe.putObject(obj, zzs, object);
                } else {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, zzs, zze);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzs);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, zzs, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int zzp = zzp(i);
        long j = 1048575 & zzp;
        if (j == 1048575) {
            return;
        }
        zzho.zzq(obj, j, (1 << (zzp >>> 20)) | zzho.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzho.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int zzp = zzp(i);
        long j = zzp & 1048575;
        if (j != 1048575) {
            return (zzho.zzc(obj, j) & (1 << (zzp >>> 20))) != 0;
        }
        int zzs = zzs(i);
        long j2 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzho.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzho.zzb(obj, j2)) != 0;
            case 2:
                return zzho.zzd(obj, j2) != 0;
            case 3:
                return zzho.zzd(obj, j2) != 0;
            case 4:
                return zzho.zzc(obj, j2) != 0;
            case 5:
                return zzho.zzd(obj, j2) != 0;
            case 6:
                return zzho.zzc(obj, j2) != 0;
            case 7:
                return zzho.zzw(obj, j2);
            case 8:
                Object zzf = zzho.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                } else if (zzf instanceof zzei) {
                    return !zzei.zzb.equals(zzf);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzho.zzf(obj, j2) != null;
            case 10:
                return !zzei.zzb.equals(zzho.zzf(obj, j2));
            case 11:
                return zzho.zzc(obj, j2) != 0;
            case 12:
                return zzho.zzc(obj, j2) != 0;
            case 13:
                return zzho.zzc(obj, j2) != 0;
            case 14:
                return zzho.zzd(obj, j2) != 0;
            case 15:
                return zzho.zzc(obj, j2) != 0;
            case 16:
                return zzho.zzd(obj, j2) != 0;
            case 17:
                return zzho.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzgv zzgvVar) {
        return zzgvVar.zzk(zzho.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzfi) {
            return ((zzfi) obj).zzz();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzho.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzho.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhu zzhuVar) throws IOException {
        if (obj instanceof String) {
            zzhuVar.zzG(i, (String) obj);
        } else {
            zzhuVar.zzd(i, (zzei) obj);
        }
    }

    static zzhi zzd(Object obj) {
        zzfi zzfiVar = (zzfi) obj;
        zzhi zzhiVar = zzfiVar.zzc;
        if (zzhiVar == zzhi.zzc()) {
            zzhi zzf = zzhi.zzf();
            zzfiVar.zzc = zzf;
            return zzf;
        }
        return zzhiVar;
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
    public static com.google.android.gms.internal.play_billing.zzgo zzl(java.lang.Class r34, com.google.android.gms.internal.play_billing.zzgi r35, com.google.android.gms.internal.play_billing.zzgq r36, com.google.android.gms.internal.play_billing.zzfy r37, com.google.android.gms.internal.play_billing.zzhh r38, com.google.android.gms.internal.play_billing.zzev r39, com.google.android.gms.internal.play_billing.zzgg r40) {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzgi, com.google.android.gms.internal.play_billing.zzgq, com.google.android.gms.internal.play_billing.zzfy, com.google.android.gms.internal.play_billing.zzhh, com.google.android.gms.internal.play_billing.zzev, com.google.android.gms.internal.play_billing.zzgg):com.google.android.gms.internal.play_billing.zzgo");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzho.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzho.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzho.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzho.zzf(obj, j)).longValue();
    }

    private final zzfl zzu(int i) {
        int i2 = i / 3;
        return (zzfl) this.zzd[i2 + i2 + 1];
    }

    private final zzgv zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgv zzgvVar = (zzgv) objArr[i3];
        if (zzgvVar != null) {
            return zzgvVar;
        }
        zzgv zzb2 = zzgs.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzgv zzv = zzv(i);
        int zzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzgv zzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v263, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54, types: [int] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31, types: [int] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v47, types: [int] */
    /* JADX WARN: Type inference failed for: r3v50 */
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
    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final int zza(Object obj) {
        int i;
        boolean z;
        int i2;
        int zzC;
        int zzC2;
        int zzC3;
        int zzD;
        int zzC4;
        int zzC5;
        int zzd;
        int zzC6;
        int zzg;
        int size;
        int zzC7;
        int zzC8;
        int zzC9;
        int i3;
        int zze;
        int zzC10;
        int zzC11;
        int i4;
        Unsafe unsafe = zzb;
        boolean z2 = false;
        int i5 = 1048575;
        boolean z3 = false;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1048575;
        while (true) {
            int[] iArr = this.zzc;
            if (i6 < iArr.length) {
                int zzs = zzs(i6);
                int zzr = zzr(zzs);
                int i9 = iArr[i6];
                int i10 = iArr[i6 + 2];
                int i11 = i10 & i5;
                if (zzr <= 17) {
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
                int i12 = zzs & i5;
                if (zzr >= zzfa.DOUBLE_LIST_PACKED.zza()) {
                    zzfa.SINT64_LIST_PACKED.zza();
                }
                long j = i12;
                switch (zzr) {
                    case 0:
                        if (zzJ(obj, i6, i, z, i2)) {
                            zzC = zzep.zzC(i9 << 3);
                            i3 = zzC + 8;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzJ(obj, i6, i, z, i2)) {
                            zzC2 = zzep.zzC(i9 << 3);
                            i3 = zzC2 + 4;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzJ(obj, i6, i, z, i2)) {
                            long j2 = unsafe.getLong(obj, j);
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzD(j2);
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzJ(obj, i6, i, z, i2)) {
                            long j3 = unsafe.getLong(obj, j);
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzD(j3);
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzJ(obj, i6, i, z, i2)) {
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzD(unsafe.getInt(obj, j));
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzJ(obj, i6, i, z, i2)) {
                            zzC = zzep.zzC(i9 << 3);
                            i3 = zzC + 8;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzJ(obj, i6, i, z, i2)) {
                            zzC2 = zzep.zzC(i9 << 3);
                            i3 = zzC2 + 4;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzJ(obj, i6, i, z, i2)) {
                            zzC4 = zzep.zzC(i9 << 3);
                            i3 = zzC4 + 1;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (!zzJ(obj, i6, i, z, i2)) {
                            break;
                        } else {
                            int i13 = i9 << 3;
                            Object object = unsafe.getObject(obj, j);
                            if (object instanceof zzei) {
                                zzC5 = zzep.zzC(i13);
                                zzd = ((zzei) object).zzd();
                                zzC6 = zzep.zzC(zzd);
                                i3 = zzC5 + zzC6 + zzd;
                                i7 += i3;
                                break;
                            } else {
                                zzC3 = zzep.zzC(i13);
                                zzD = zzep.zzB((String) object);
                                i3 = zzC3 + zzD;
                                i7 += i3;
                            }
                        }
                    case 9:
                        if (zzJ(obj, i6, i, z, i2)) {
                            i3 = zzgx.zzh(i9, unsafe.getObject(obj, j), zzv(i6));
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzJ(obj, i6, i, z, i2)) {
                            zzC5 = zzep.zzC(i9 << 3);
                            zzd = ((zzei) unsafe.getObject(obj, j)).zzd();
                            zzC6 = zzep.zzC(zzd);
                            i3 = zzC5 + zzC6 + zzd;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzJ(obj, i6, i, z, i2)) {
                            int i14 = unsafe.getInt(obj, j);
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzC(i14);
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzJ(obj, i6, i, z, i2)) {
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzD(unsafe.getInt(obj, j));
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzJ(obj, i6, i, z, i2)) {
                            zzC2 = zzep.zzC(i9 << 3);
                            i3 = zzC2 + 4;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzJ(obj, i6, i, z, i2)) {
                            zzC = zzep.zzC(i9 << 3);
                            i3 = zzC + 8;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzJ(obj, i6, i, z, i2)) {
                            int i15 = unsafe.getInt(obj, j);
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzC((i15 >> 31) ^ (i15 + i15));
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzJ(obj, i6, i, z, i2)) {
                            long j4 = unsafe.getLong(obj, j);
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzD((j4 >> 63) ^ (j4 + j4));
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzJ(obj, i6, i, z, i2)) {
                            i3 = zzep.zzy(i9, (zzgl) unsafe.getObject(obj, j), zzv(i6));
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i3 = zzgx.zzd(i9, (List) unsafe.getObject(obj, j), z2);
                        i7 += i3;
                        break;
                    case 19:
                        i3 = zzgx.zzb(i9, (List) unsafe.getObject(obj, j), z2);
                        i7 += i3;
                        break;
                    case 20:
                        List list = (List) unsafe.getObject(obj, j);
                        int i16 = zzgx.zza;
                        if (list.size() != 0) {
                            zzg = zzgx.zzg(list) + (list.size() * zzep.zzC(i9 << 3));
                            i7 += zzg;
                            break;
                        }
                        zzg = z2;
                        i7 += zzg;
                    case 21:
                        List list2 = (List) unsafe.getObject(obj, j);
                        int i17 = zzgx.zza;
                        size = list2.size();
                        if (size != 0) {
                            zzC3 = zzgx.zzl(list2);
                            zzC7 = zzep.zzC(i9 << 3);
                            zzD = size * zzC7;
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        }
                        i3 = z2;
                        i7 += i3;
                    case 22:
                        List list3 = (List) unsafe.getObject(obj, j);
                        int i18 = zzgx.zza;
                        size = list3.size();
                        if (size != 0) {
                            zzC3 = zzgx.zzf(list3);
                            zzC7 = zzep.zzC(i9 << 3);
                            zzD = size * zzC7;
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        }
                        i3 = z2;
                        i7 += i3;
                    case 23:
                        i3 = zzgx.zzd(i9, (List) unsafe.getObject(obj, j), z2);
                        i7 += i3;
                        break;
                    case 24:
                        i3 = zzgx.zzb(i9, (List) unsafe.getObject(obj, j), z2);
                        i7 += i3;
                        break;
                    case 25:
                        int i19 = zzgx.zza;
                        int size2 = ((List) unsafe.getObject(obj, j)).size();
                        if (size2 != 0) {
                            i3 = size2 * (zzep.zzC(i9 << 3) + 1);
                            i7 += i3;
                            break;
                        }
                        i3 = z2;
                        i7 += i3;
                    case 26:
                        ?? r0 = (List) unsafe.getObject(obj, j);
                        int i20 = zzgx.zza;
                        int size3 = r0.size();
                        if (size3 != 0) {
                            zzg = zzep.zzC(i9 << 3) * size3;
                            if (r0 instanceof zzfx) {
                                zzfx zzfxVar = (zzfx) r0;
                                for (int i21 = z2; i21 < size3; i21++) {
                                    Object zza2 = zzfxVar.zza();
                                    if (zza2 instanceof zzei) {
                                        int zzd2 = ((zzei) zza2).zzd();
                                        zzg += zzep.zzC(zzd2) + zzd2;
                                    } else {
                                        zzg += zzep.zzB((String) zza2);
                                    }
                                }
                            } else {
                                for (int i22 = z2; i22 < size3; i22++) {
                                    Object obj2 = r0.get(i22);
                                    if (obj2 instanceof zzei) {
                                        int zzd3 = ((zzei) obj2).zzd();
                                        zzg += zzep.zzC(zzd3) + zzd3;
                                    } else {
                                        zzg += zzep.zzB((String) obj2);
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
                        zzgv zzv = zzv(i6);
                        int i23 = zzgx.zza;
                        int size4 = r02.size();
                        if (size4 == 0) {
                            zzC8 = z2;
                        } else {
                            zzC8 = zzep.zzC(i9 << 3) * size4;
                            for (int i24 = z2; i24 < size4; i24++) {
                                Object obj3 = r02.get(i24);
                                if (obj3 instanceof zzfw) {
                                    int zza3 = ((zzfw) obj3).zza();
                                    zzC8 += zzep.zzC(zza3) + zza3;
                                } else {
                                    zzC8 += zzep.zzA((zzgl) obj3, zzv);
                                }
                            }
                        }
                        i7 += zzC8;
                        break;
                    case 28:
                        ?? r03 = (List) unsafe.getObject(obj, j);
                        int i25 = zzgx.zza;
                        int size5 = r03.size();
                        if (size5 == 0) {
                            zzC9 = z2;
                        } else {
                            zzC9 = size5 * zzep.zzC(i9 << 3);
                            for (int i26 = z2; i26 < r03.size(); i26++) {
                                int zzd4 = ((zzei) r03.get(i26)).zzd();
                                zzC9 += zzep.zzC(zzd4) + zzd4;
                            }
                        }
                        i7 += zzC9;
                        break;
                    case 29:
                        List list4 = (List) unsafe.getObject(obj, j);
                        int i27 = zzgx.zza;
                        size = list4.size();
                        if (size != 0) {
                            zzC3 = zzgx.zzk(list4);
                            zzC7 = zzep.zzC(i9 << 3);
                            zzD = size * zzC7;
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        }
                        i3 = z2;
                        i7 += i3;
                    case 30:
                        List list5 = (List) unsafe.getObject(obj, j);
                        int i28 = zzgx.zza;
                        size = list5.size();
                        if (size != 0) {
                            zzC3 = zzgx.zza(list5);
                            zzC7 = zzep.zzC(i9 << 3);
                            zzD = size * zzC7;
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        }
                        i3 = z2;
                        i7 += i3;
                    case 31:
                        i3 = zzgx.zzb(i9, (List) unsafe.getObject(obj, j), z2);
                        i7 += i3;
                        break;
                    case 32:
                        i3 = zzgx.zzd(i9, (List) unsafe.getObject(obj, j), z2);
                        i7 += i3;
                        break;
                    case 33:
                        List list6 = (List) unsafe.getObject(obj, j);
                        int i29 = zzgx.zza;
                        size = list6.size();
                        if (size != 0) {
                            zzC3 = zzgx.zzi(list6);
                            zzC7 = zzep.zzC(i9 << 3);
                            zzD = size * zzC7;
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        }
                        i3 = z2;
                        i7 += i3;
                    case 34:
                        List list7 = (List) unsafe.getObject(obj, j);
                        int i30 = zzgx.zza;
                        size = list7.size();
                        if (size != 0) {
                            zzC3 = zzgx.zzj(list7);
                            zzC7 = zzep.zzC(i9 << 3);
                            zzD = size * zzC7;
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        }
                        i3 = z2;
                        i7 += i3;
                    case 35:
                        zze = zzgx.zze((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zze = zzgx.zzc((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zze = zzgx.zzg((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zze = zzgx.zzl((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zze = zzgx.zzf((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zze = zzgx.zze((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zze = zzgx.zzc((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int i31 = zzgx.zza;
                        zze = ((List) unsafe.getObject(obj, j)).size();
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zze = zzgx.zzk((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zze = zzgx.zza((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zze = zzgx.zzc((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zze = zzgx.zze((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zze = zzgx.zzi((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        zze = zzgx.zzj((List) unsafe.getObject(obj, j));
                        if (zze > 0) {
                            zzC10 = zzep.zzC(i9 << 3);
                            zzC11 = zzep.zzC(zze);
                            zzC9 = zzC10 + zzC11 + zze;
                            i7 += zzC9;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        ?? r04 = (List) unsafe.getObject(obj, j);
                        zzgv zzv2 = zzv(i6);
                        int i32 = zzgx.zza;
                        int size6 = r04.size();
                        if (size6 == 0) {
                            i4 = z2;
                        } else {
                            boolean z4 = z2;
                            i4 = z4;
                            for (int i33 = z4; i33 < size6; i33++) {
                                i4 += zzep.zzy(i9, (zzgl) r04.get(i33), zzv2);
                            }
                        }
                        i7 += i4;
                        break;
                    case 50:
                        zzgf zzgfVar = (zzgf) unsafe.getObject(obj, j);
                        zzge zzgeVar = (zzge) zzw(i6);
                        if (zzgfVar.isEmpty()) {
                            continue;
                        } else {
                            Iterator it = zzgfVar.entrySet().iterator();
                            if (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                entry.getKey();
                                entry.getValue();
                                throw null;
                            }
                            break;
                        }
                    case 51:
                        if (zzM(obj, i9, i6)) {
                            zzC = zzep.zzC(i9 << 3);
                            i3 = zzC + 8;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzM(obj, i9, i6)) {
                            zzC2 = zzep.zzC(i9 << 3);
                            i3 = zzC2 + 4;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzM(obj, i9, i6)) {
                            long zzt = zzt(obj, j);
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzD(zzt);
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzM(obj, i9, i6)) {
                            long zzt2 = zzt(obj, j);
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzD(zzt2);
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzM(obj, i9, i6)) {
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzD(zzo(obj, j));
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzM(obj, i9, i6)) {
                            zzC = zzep.zzC(i9 << 3);
                            i3 = zzC + 8;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzM(obj, i9, i6)) {
                            zzC2 = zzep.zzC(i9 << 3);
                            i3 = zzC2 + 4;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzM(obj, i9, i6)) {
                            zzC4 = zzep.zzC(i9 << 3);
                            i3 = zzC4 + 1;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (!zzM(obj, i9, i6)) {
                            break;
                        } else {
                            int i34 = i9 << 3;
                            Object object2 = unsafe.getObject(obj, j);
                            if (object2 instanceof zzei) {
                                zzC5 = zzep.zzC(i34);
                                zzd = ((zzei) object2).zzd();
                                zzC6 = zzep.zzC(zzd);
                                i3 = zzC5 + zzC6 + zzd;
                                i7 += i3;
                                break;
                            } else {
                                zzC3 = zzep.zzC(i34);
                                zzD = zzep.zzB((String) object2);
                                i3 = zzC3 + zzD;
                                i7 += i3;
                            }
                        }
                    case 60:
                        if (zzM(obj, i9, i6)) {
                            i3 = zzgx.zzh(i9, unsafe.getObject(obj, j), zzv(i6));
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzM(obj, i9, i6)) {
                            zzC5 = zzep.zzC(i9 << 3);
                            zzd = ((zzei) unsafe.getObject(obj, j)).zzd();
                            zzC6 = zzep.zzC(zzd);
                            i3 = zzC5 + zzC6 + zzd;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzM(obj, i9, i6)) {
                            int zzo = zzo(obj, j);
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzC(zzo);
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzM(obj, i9, i6)) {
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzD(zzo(obj, j));
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzM(obj, i9, i6)) {
                            zzC2 = zzep.zzC(i9 << 3);
                            i3 = zzC2 + 4;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzM(obj, i9, i6)) {
                            zzC = zzep.zzC(i9 << 3);
                            i3 = zzC + 8;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzM(obj, i9, i6)) {
                            int zzo2 = zzo(obj, j);
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzC((zzo2 >> 31) ^ (zzo2 + zzo2));
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzM(obj, i9, i6)) {
                            long zzt3 = zzt(obj, j);
                            zzC3 = zzep.zzC(i9 << 3);
                            zzD = zzep.zzD((zzt3 >> 63) ^ (zzt3 + zzt3));
                            i3 = zzC3 + zzD;
                            i7 += i3;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzM(obj, i9, i6)) {
                            i3 = zzep.zzy(i9, (zzgl) unsafe.getObject(obj, j), zzv(i6));
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
            } else {
                int zza4 = i7 + ((zzfi) obj).zzc.zza();
                if (this.zzh) {
                    zzhd zzhdVar = ((zzff) obj).zzb.zza;
                    int zzc = zzhdVar.zzc();
                    int i35 = 0;
                    for (int i36 = 0; i36 < zzc; i36++) {
                        Map.Entry zzg2 = zzhdVar.zzg(i36);
                        i35 += zzez.zzc((zzey) ((zzgz) zzg2).zza(), zzg2.getValue());
                    }
                    for (Map.Entry entry2 : zzhdVar.zzd()) {
                        i35 += zzez.zzc((zzey) entry2.getKey(), entry2.getValue());
                    }
                    return zza4 + i35;
                }
                return zza4;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 < iArr.length) {
                int zzs = zzs(i3);
                int i5 = 1048575 & zzs;
                int zzr = zzr(zzs);
                int i6 = iArr[i3];
                long j = i5;
                int i7 = 37;
                switch (zzr) {
                    case 0:
                        i = i4 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzho.zza(obj, j));
                        byte[] bArr = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 1:
                        i = i4 * 53;
                        floatToIntBits = Float.floatToIntBits(zzho.zzb(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 2:
                        i = i4 * 53;
                        doubleToLongBits = zzho.zzd(obj, j);
                        byte[] bArr2 = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 3:
                        i = i4 * 53;
                        doubleToLongBits = zzho.zzd(obj, j);
                        byte[] bArr3 = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 4:
                        i = i4 * 53;
                        floatToIntBits = zzho.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 5:
                        i = i4 * 53;
                        doubleToLongBits = zzho.zzd(obj, j);
                        byte[] bArr4 = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 6:
                        i = i4 * 53;
                        floatToIntBits = zzho.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 7:
                        i = i4 * 53;
                        floatToIntBits = zzfo.zza(zzho.zzw(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 8:
                        i = i4 * 53;
                        floatToIntBits = ((String) zzho.zzf(obj, j)).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 9:
                        i2 = i4 * 53;
                        Object zzf = zzho.zzf(obj, j);
                        if (zzf != null) {
                            i7 = zzf.hashCode();
                        }
                        i4 = i2 + i7;
                        break;
                    case 10:
                        i = i4 * 53;
                        floatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 11:
                        i = i4 * 53;
                        floatToIntBits = zzho.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 12:
                        i = i4 * 53;
                        floatToIntBits = zzho.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 13:
                        i = i4 * 53;
                        floatToIntBits = zzho.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 14:
                        i = i4 * 53;
                        doubleToLongBits = zzho.zzd(obj, j);
                        byte[] bArr5 = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 15:
                        i = i4 * 53;
                        floatToIntBits = zzho.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 16:
                        i = i4 * 53;
                        doubleToLongBits = zzho.zzd(obj, j);
                        byte[] bArr6 = zzfo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 17:
                        i2 = i4 * 53;
                        Object zzf2 = zzho.zzf(obj, j);
                        if (zzf2 != null) {
                            i7 = zzf2.hashCode();
                        }
                        i4 = i2 + i7;
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
                        i = i4 * 53;
                        floatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 50:
                        i = i4 * 53;
                        floatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 51:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                            byte[] bArr7 = zzfo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 52:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = Float.floatToIntBits(zzn(obj, j));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 53:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr8 = zzfo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 54:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr9 = zzfo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 55:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 56:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr10 = zzfo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 57:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 58:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzfo.zza(zzN(obj, j));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 59:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = ((String) zzho.zzf(obj, j)).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 60:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzho.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 61:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzho.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 62:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 63:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 64:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 65:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr11 = zzfo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 66:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 67:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr12 = zzfo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 68:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzho.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                }
                i3 += 3;
            } else {
                int hashCode = (i4 * 53) + ((zzfi) obj).zzc.hashCode();
                return this.zzh ? (hashCode * 53) + ((zzff) obj).zzb.zza.hashCode() : hashCode;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:526:0x0d3e, code lost:
        if (r6 == 1048575) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:527:0x0d40, code lost:
        r11.putInt(r7, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:528:0x0d44, code lost:
        r2 = r8.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:530:0x0d48, code lost:
        if (r2 >= r8.zzk) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:531:0x0d4a, code lost:
        r3 = r8.zzi;
        r5 = r8.zzc;
        r3 = r3[r2];
        r5 = r5[r3];
        r5 = com.google.android.gms.internal.play_billing.zzho.zzf(r7, r8.zzs(r3) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:532:0x0d5c, code lost:
        if (r5 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:535:0x0d63, code lost:
        if (r8.zzu(r3) != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:536:0x0d65, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:537:0x0d6c, code lost:
        r5 = (com.google.android.gms.internal.play_billing.zzgf) r5;
        r0 = (com.google.android.gms.internal.play_billing.zzge) r8.zzw(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:538:0x0d74, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:540:0x0d77, code lost:
        if (r9 != 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:542:0x0d7b, code lost:
        if (r1 != r37) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:545:0x0d83, code lost:
        throw new com.google.android.gms.internal.play_billing.zzfq("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x0d86, code lost:
        if (r1 > r37) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:0x0d88, code lost:
        if (r4 != r9) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:549:0x0d8a, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:551:0x0d90, code lost:
        throw new com.google.android.gms.internal.play_billing.zzfq("Failed to parse the message.");
     */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0cea  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:208:0x0584 -> B:209:0x0585). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:243:0x0646 -> B:244:0x0647). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.play_billing.zzdw r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzdw):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final Object zze() {
        return ((zzfi) this.zzg).zzo();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzfi) {
                zzfi zzfiVar = (zzfi) obj;
                zzfiVar.zzx(Integer.MAX_VALUE);
                zzfiVar.zza = 0;
                zzfiVar.zzv();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j = i2;
                if (zzr != 9) {
                    if (zzr != 60 && zzr != 68) {
                        switch (zzr) {
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
                                ((zzfn) zzho.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzgf) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, iArr[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                }
                if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zzb(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i < iArr.length) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                int i3 = iArr[i];
                long j = i2;
                switch (zzr) {
                    case 0:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzo(obj, j, zzho.zza(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 1:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzp(obj, j, zzho.zzb(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 2:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzr(obj, j, zzho.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 3:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzr(obj, j, zzho.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 4:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzq(obj, j, zzho.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 5:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzr(obj, j, zzho.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 6:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzq(obj, j, zzho.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 7:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzm(obj, j, zzho.zzw(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 8:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzs(obj, j, zzho.zzf(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 9:
                        zzB(obj, obj2, i);
                        break;
                    case 10:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzs(obj, j, zzho.zzf(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 11:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzq(obj, j, zzho.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 12:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzq(obj, j, zzho.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 13:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzq(obj, j, zzho.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 14:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzr(obj, j, zzho.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 15:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzq(obj, j, zzho.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 16:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzho.zzr(obj, j, zzho.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 17:
                        zzB(obj, obj2, i);
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
                        zzfn zzfnVar = (zzfn) zzho.zzf(obj, j);
                        zzfn zzfnVar2 = (zzfn) zzho.zzf(obj2, j);
                        int size = zzfnVar.size();
                        int size2 = zzfnVar2.size();
                        if (size > 0 && size2 > 0) {
                            if (!zzfnVar.zzc()) {
                                zzfnVar = zzfnVar.zzd(size2 + size);
                            }
                            zzfnVar.addAll(zzfnVar2);
                        }
                        if (size > 0) {
                            zzfnVar2 = zzfnVar;
                        }
                        zzho.zzs(obj, j, zzfnVar2);
                        break;
                    case 50:
                        int i4 = zzgx.zza;
                        zzho.zzs(obj, j, zzgg.zza(zzho.zzf(obj, j), zzho.zzf(obj2, j)));
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
                        if (!zzM(obj2, i3, i)) {
                            break;
                        } else {
                            zzho.zzs(obj, j, zzho.zzf(obj2, j));
                            zzE(obj, i3, i);
                            break;
                        }
                    case 60:
                        zzC(obj, obj2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zzM(obj2, i3, i)) {
                            break;
                        } else {
                            zzho.zzs(obj, j, zzho.zzf(obj2, j));
                            zzE(obj, i3, i);
                            break;
                        }
                    case 68:
                        zzC(obj, obj2, i);
                        break;
                }
                i += 3;
            } else {
                zzgx.zzp(this.zzl, obj, obj2);
                if (this.zzh) {
                    zzgx.zzo(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzdw zzdwVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzdwVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x05bf  */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.lang.Object r20, com.google.android.gms.internal.play_billing.zzhu r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzi(java.lang.Object, com.google.android.gms.internal.play_billing.zzhu):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            long j = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i) && Double.doubleToLongBits(zzho.zza(obj, j)) == Double.doubleToLongBits(zzho.zza(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzho.zzb(obj, j)) == Float.floatToIntBits(zzho.zzb(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i) && zzho.zzd(obj, j) == zzho.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i) && zzho.zzd(obj, j) == zzho.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i) && zzho.zzd(obj, j) == zzho.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i) && zzho.zzw(obj, j) == zzho.zzw(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i) && zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i) && zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i) && zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i) && zzho.zzd(obj, j) == zzho.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i) && zzho.zzc(obj, j) == zzho.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i) && zzho.zzd(obj, j) == zzho.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i) && zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
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
                    zzE = zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j));
                    break;
                case 50:
                    zzE = zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j));
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
                    long zzp = zzp(i) & 1048575;
                    if (zzho.zzc(obj, zzp) == zzho.zzc(obj2, zzp) && zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzE) {
                return false;
            }
        }
        if (((zzfi) obj).zzc.equals(((zzfi) obj2).zzc)) {
            if (this.zzh) {
                return ((zzff) obj).zzb.equals(((zzff) obj2).zzb);
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i6 = iArr[i4];
            int i7 = iArr2[i6];
            int zzs = zzs(i6);
            int i8 = iArr2[i6 + 2];
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
            if ((268435456 & zzs) != 0 && !zzJ(obj, i6, i, i2, i10)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, i7, i6) && !zzK(obj, zzs, zzv(i6))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zzgf) zzho.zzf(obj, zzs & 1048575)).isEmpty()) {
                            zzge zzgeVar = (zzge) zzw(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzho.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgv zzv = zzv(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzv.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzJ(obj, i6, i, i2, i10) && !zzK(obj, zzs, zzv(i6))) {
                return false;
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        return !this.zzh || ((zzff) obj).zzb.zzi();
    }
}
