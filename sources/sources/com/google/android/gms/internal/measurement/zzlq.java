package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzlq<T> implements zzme<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmz.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlm zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzlu zzn;
    private final zzkw zzo;
    private final zzmu<?, ?> zzp;
    private final zzjv<?> zzq;
    private final zzlj zzr;

    private static <T> double zza(T t, long j) {
        return ((Double) zzmz.zze(t, j)).doubleValue();
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> float zzb(T t, long j) {
        return ((Float) zzmz.zze(t, j)).floatValue();
    }

    private static int zza(byte[] bArr, int i, int i2, zzng zzngVar, Class<?> cls, zzit zzitVar) throws IOException {
        switch (zzlt.zza[zzngVar.ordinal()]) {
            case 1:
                int zzd = zziu.zzd(bArr, i, zzitVar);
                zzitVar.zzc = Boolean.valueOf(zzitVar.zzb != 0);
                return zzd;
            case 2:
                return zziu.zza(bArr, i, zzitVar);
            case 3:
                zzitVar.zzc = Double.valueOf(zziu.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzitVar.zzc = Integer.valueOf(zziu.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzitVar.zzc = Long.valueOf(zziu.zzd(bArr, i));
                return i + 8;
            case 8:
                zzitVar.zzc = Float.valueOf(zziu.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zzc = zziu.zzc(bArr, i, zzitVar);
                zzitVar.zzc = Integer.valueOf(zzitVar.zza);
                return zzc;
            case 12:
            case 13:
                int zzd2 = zziu.zzd(bArr, i, zzitVar);
                zzitVar.zzc = Long.valueOf(zzitVar.zzb);
                return zzd2;
            case 14:
                return zziu.zza(zzma.zza().zza((Class) cls), bArr, i, i2, zzitVar);
            case 15:
                int zzc2 = zziu.zzc(bArr, i, zzitVar);
                zzitVar.zzc = Integer.valueOf(zzjk.zze(zzitVar.zza));
                return zzc2;
            case 16:
                int zzd3 = zziu.zzd(bArr, i, zzitVar);
                zzitVar.zzc = Long.valueOf(zzjk.zza(zzitVar.zzb));
                return zzd3;
            case 17:
                return zziu.zzb(bArr, i, zzitVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v19 */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final int zza(T t) {
        int i;
        int i2;
        int i3;
        boolean z;
        int zza2;
        int zza3;
        int zzd;
        int zzd2;
        int zzf;
        int zzg;
        Unsafe unsafe = zzb;
        ?? r9 = 0;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1048575;
        while (i6 < this.zzc.length) {
            int zzc = zzc(i6);
            int i9 = (267386880 & zzc) >>> 20;
            int[] iArr = this.zzc;
            int i10 = iArr[i6];
            int i11 = iArr[i6 + 2];
            int i12 = i11 & i4;
            if (i9 <= 17) {
                if (i12 != i8) {
                    i5 = i12 == i4 ? r9 : unsafe.getInt(t, i12);
                    i8 = i12;
                }
                i = i8;
                i2 = i5;
                i3 = 1 << (i11 >>> 20);
            } else {
                i = i8;
                i2 = i5;
                i3 = r9;
            }
            long j = zzc & i4;
            if (i9 >= zzkb.DOUBLE_LIST_PACKED.zza()) {
                zzkb.SINT64_LIST_PACKED.zza();
            }
            int i13 = i3;
            switch (i9) {
                case 0:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza2 = zzjn.zza(i10, 0.0d);
                        i7 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza2 = zzjn.zza(i10, 0.0f);
                        i7 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza2 = zzjn.zzb(i10, unsafe.getLong(t, j));
                        i7 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza2 = zzjn.zze(i10, unsafe.getLong(t, j));
                        i7 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza2 = zzjn.zzc(i10, unsafe.getInt(t, j));
                        i7 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    z = r9;
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza2 = zzjn.zza(i10, 0L);
                        i7 += zza2;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        z = false;
                        zza2 = zzjn.zzb(i10, 0);
                        i7 += zza2;
                        break;
                    }
                    z = false;
                    break;
                case 7:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza3 = zzjn.zza(i10, true);
                        i7 += zza3;
                    }
                    z = false;
                    break;
                case 8:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zziy) {
                            zza3 = zzjn.zza(i10, (zziy) object);
                        } else {
                            zza3 = zzjn.zza(i10, (String) object);
                        }
                        i7 += zza3;
                    }
                    z = false;
                    break;
                case 9:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza3 = zzmg.zza(i10, unsafe.getObject(t, j), zze(i6));
                        i7 += zza3;
                    }
                    z = false;
                    break;
                case 10:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza3 = zzjn.zza(i10, (zziy) unsafe.getObject(t, j));
                        i7 += zza3;
                    }
                    z = false;
                    break;
                case 11:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza3 = zzjn.zzf(i10, unsafe.getInt(t, j));
                        i7 += zza3;
                    }
                    z = false;
                    break;
                case 12:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza3 = zzjn.zza(i10, unsafe.getInt(t, j));
                        i7 += zza3;
                    }
                    z = false;
                    break;
                case 13:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        i7 += zzjn.zzd(i10, 0);
                    }
                    z = false;
                    break;
                case 14:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza3 = zzjn.zzc(i10, 0L);
                        i7 += zza3;
                    }
                    z = false;
                    break;
                case 15:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza3 = zzjn.zze(i10, unsafe.getInt(t, j));
                        i7 += zza3;
                    }
                    z = false;
                    break;
                case 16:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza3 = zzjn.zzd(i10, unsafe.getLong(t, j));
                        i7 += zza3;
                    }
                    z = false;
                    break;
                case 17:
                    if (zza((zzlq<T>) t, i6, i, i2, i13)) {
                        zza3 = zzjn.zza(i10, (zzlm) unsafe.getObject(t, j), zze(i6));
                        i7 += zza3;
                    }
                    z = false;
                    break;
                case 18:
                    zzd = zzmg.zzd(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 19:
                    zzd = zzmg.zzc(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 20:
                    zzd = zzmg.zzf(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 21:
                    zzd = zzmg.zzj(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 22:
                    zzd = zzmg.zze(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 23:
                    zzd = zzmg.zzd(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 24:
                    zzd = zzmg.zzc(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 25:
                    zzd = zzmg.zza(i10, (List) unsafe.getObject(t, j), (boolean) r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 26:
                    zzd = zzmg.zzb(i10, (List) unsafe.getObject(t, j));
                    i7 += zzd;
                    z = r9;
                    break;
                case 27:
                    zzd = zzmg.zzb(i10, (List) unsafe.getObject(t, j), zze(i6));
                    i7 += zzd;
                    z = r9;
                    break;
                case 28:
                    zzd = zzmg.zza(i10, (List) unsafe.getObject(t, j));
                    i7 += zzd;
                    z = r9;
                    break;
                case 29:
                    zzd = zzmg.zzi(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 30:
                    zzd = zzmg.zzb(i10, (List) unsafe.getObject(t, j), (boolean) r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 31:
                    zzd = zzmg.zzc(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 32:
                    zzd = zzmg.zzd(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 33:
                    zzd = zzmg.zzg(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 34:
                    zzd = zzmg.zzh(i10, (List) unsafe.getObject(t, j), r9);
                    i7 += zzd;
                    z = r9;
                    break;
                case 35:
                    zzd2 = zzmg.zzd((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 36:
                    zzd2 = zzmg.zzc((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 37:
                    zzd2 = zzmg.zzf((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 38:
                    zzd2 = zzmg.zzj((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 39:
                    zzd2 = zzmg.zze((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 40:
                    zzd2 = zzmg.zzd((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 41:
                    zzd2 = zzmg.zzc((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 42:
                    zzd2 = zzmg.zza((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 43:
                    zzd2 = zzmg.zzi((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 44:
                    zzd2 = zzmg.zzb((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 45:
                    zzd2 = zzmg.zzc((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 46:
                    zzd2 = zzmg.zzd((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 47:
                    zzd2 = zzmg.zzg((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 48:
                    zzd2 = zzmg.zzh((List) unsafe.getObject(t, j));
                    if (zzd2 > 0) {
                        zzf = zzjn.zzf(i10);
                        zzg = zzjn.zzg(zzd2);
                        i7 += zzf + zzg + zzd2;
                    }
                    z = r9;
                    break;
                case 49:
                    zzd = zzmg.zza(i10, (List<zzlm>) unsafe.getObject(t, j), (zzme<?>) zze(i6));
                    i7 += zzd;
                    z = r9;
                    break;
                case 50:
                    zzd = this.zzr.zza(i10, unsafe.getObject(t, j), zzf(i6));
                    i7 += zzd;
                    z = r9;
                    break;
                case 51:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zza(i10, 0.0d);
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 52:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zza(i10, 0.0f);
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 53:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zzb(i10, zzd(t, j));
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 54:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zze(i10, zzd(t, j));
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 55:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zzc(i10, zzc(t, j));
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 56:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zza(i10, 0L);
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 57:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zzb(i10, (int) r9);
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 58:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zza(i10, true);
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 59:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zziy) {
                            zzd = zzjn.zza(i10, (zziy) object2);
                        } else {
                            zzd = zzjn.zza(i10, (String) object2);
                        }
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 60:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzmg.zza(i10, unsafe.getObject(t, j), zze(i6));
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 61:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zza(i10, (zziy) unsafe.getObject(t, j));
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 62:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zzf(i10, zzc(t, j));
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 63:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zza(i10, zzc(t, j));
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 64:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zzd(i10, (int) r9);
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 65:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zzc(i10, 0L);
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 66:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zze(i10, zzc(t, j));
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 67:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zzd(i10, zzd(t, j));
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                case 68:
                    if (zzc((zzlq<T>) t, i10, i6)) {
                        zzd = zzjn.zza(i10, (zzlm) unsafe.getObject(t, j), zze(i6));
                        i7 += zzd;
                    }
                    z = r9;
                    break;
                default:
                    z = r9;
                    break;
            }
            i6 += 3;
            i8 = i;
            r9 = z;
            i5 = i2;
            i4 = 1048575;
        }
        int i14 = r9;
        zzmu<?, ?> zzmuVar = this.zzp;
        int zza4 = i7 + zzmuVar.zza((zzmu<?, ?>) zzmuVar.zzd(t));
        if (this.zzh) {
            zzjw<?> zza5 = this.zzq.zza(t);
            int zzb2 = zza5.zza.zzb();
            for (int i15 = i14; i15 < zzb2; i15++) {
                Map.Entry<?, Object> zza6 = zza5.zza.zza(i15);
                i14 += zzjw.zza((zzjy) zza6.getKey(), zza6.getValue());
            }
            for (Map.Entry<?, Object> entry : zza5.zza.zzc()) {
                i14 += zzjw.zza((zzjy) entry.getKey(), entry.getValue());
            }
            return zza4 + i14;
        }
        return zza4;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final int zzb(T t) {
        int i;
        int zza2;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int zzc = zzc(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & zzc;
            int i5 = 37;
            switch ((zzc & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    zza2 = zzkj.zza(Double.doubleToLongBits(zzmz.zza(t, j)));
                    i2 = i + zza2;
                    break;
                case 1:
                    i = i2 * 53;
                    zza2 = Float.floatToIntBits(zzmz.zzb(t, j));
                    i2 = i + zza2;
                    break;
                case 2:
                    i = i2 * 53;
                    zza2 = zzkj.zza(zzmz.zzd(t, j));
                    i2 = i + zza2;
                    break;
                case 3:
                    i = i2 * 53;
                    zza2 = zzkj.zza(zzmz.zzd(t, j));
                    i2 = i + zza2;
                    break;
                case 4:
                    i = i2 * 53;
                    zza2 = zzmz.zzc(t, j);
                    i2 = i + zza2;
                    break;
                case 5:
                    i = i2 * 53;
                    zza2 = zzkj.zza(zzmz.zzd(t, j));
                    i2 = i + zza2;
                    break;
                case 6:
                    i = i2 * 53;
                    zza2 = zzmz.zzc(t, j);
                    i2 = i + zza2;
                    break;
                case 7:
                    i = i2 * 53;
                    zza2 = zzkj.zza(zzmz.zzh(t, j));
                    i2 = i + zza2;
                    break;
                case 8:
                    i = i2 * 53;
                    zza2 = ((String) zzmz.zze(t, j)).hashCode();
                    i2 = i + zza2;
                    break;
                case 9:
                    Object zze = zzmz.zze(t, j);
                    if (zze != null) {
                        i5 = zze.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    zza2 = zzmz.zze(t, j).hashCode();
                    i2 = i + zza2;
                    break;
                case 11:
                    i = i2 * 53;
                    zza2 = zzmz.zzc(t, j);
                    i2 = i + zza2;
                    break;
                case 12:
                    i = i2 * 53;
                    zza2 = zzmz.zzc(t, j);
                    i2 = i + zza2;
                    break;
                case 13:
                    i = i2 * 53;
                    zza2 = zzmz.zzc(t, j);
                    i2 = i + zza2;
                    break;
                case 14:
                    i = i2 * 53;
                    zza2 = zzkj.zza(zzmz.zzd(t, j));
                    i2 = i + zza2;
                    break;
                case 15:
                    i = i2 * 53;
                    zza2 = zzmz.zzc(t, j);
                    i2 = i + zza2;
                    break;
                case 16:
                    i = i2 * 53;
                    zza2 = zzkj.zza(zzmz.zzd(t, j));
                    i2 = i + zza2;
                    break;
                case 17:
                    Object zze2 = zzmz.zze(t, j);
                    if (zze2 != null) {
                        i5 = zze2.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
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
                    i = i2 * 53;
                    zza2 = zzmz.zze(t, j).hashCode();
                    i2 = i + zza2;
                    break;
                case 50:
                    i = i2 * 53;
                    zza2 = zzmz.zze(t, j).hashCode();
                    i2 = i + zza2;
                    break;
                case 51:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzkj.zza(Double.doubleToLongBits(zza(t, j)));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = Float.floatToIntBits(zzb(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzkj.zza(zzd(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzkj.zza(zzd(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzc(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzkj.zza(zzd(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzc(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzkj.zza(zze(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = ((String) zzmz.zze(t, j)).hashCode();
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzmz.zze(t, j).hashCode();
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzmz.zze(t, j).hashCode();
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzc(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzc(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzc(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzkj.zza(zzd(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzc(t, j);
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzkj.zza(zzd(t, j));
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzc((zzlq<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zza2 = zzmz.zze(t, j).hashCode();
                        i2 = i + zza2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.zzp.zzd(t).hashCode();
        return this.zzh ? (hashCode * 53) + this.zzq.zza(t).hashCode() : hashCode;
    }

    private static <T> int zzc(T t, long j) {
        return ((Integer) zzmz.zze(t, j)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x0a7d, code lost:
        throw com.google.android.gms.internal.measurement.zzkp.zzi();
     */
    /* JADX WARN: Code restructure failed: missing block: B:530:0x0d4a, code lost:
        if (r13 == 1048575) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:531:0x0d4c, code lost:
        r28.putInt(r15, r13, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:532:0x0d52, code lost:
        r6 = r11.zzl;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:534:0x0d59, code lost:
        if (r6 >= r11.zzm) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:535:0x0d5b, code lost:
        r3 = (com.google.android.gms.internal.measurement.zzmx) zza((java.lang.Object) r32, r11.zzk[r6], (int) r3, (com.google.android.gms.internal.measurement.zzmu<UT, int>) r11.zzp, (java.lang.Object) r32);
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:536:0x0d71, code lost:
        if (r3 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:537:0x0d73, code lost:
        r11.zzp.zzb((java.lang.Object) r15, (T) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:538:0x0d78, code lost:
        if (r8 != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:540:0x0d7c, code lost:
        if (r7 != r35) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:543:0x0d83, code lost:
        throw com.google.android.gms.internal.measurement.zzkp.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:545:0x0d86, code lost:
        if (r7 > r35) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:546:0x0d88, code lost:
        if (r10 != r8) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x0d8a, code lost:
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:549:0x0d8f, code lost:
        throw com.google.android.gms.internal.measurement.zzkp.zzg();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:191:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x064c  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x069a  */
    /* JADX WARN: Type inference failed for: r1v59, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:189:0x05a4 -> B:190:0x05a5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:222:0x0649 -> B:223:0x064a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:242:0x0697 -> B:243:0x0698). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(T r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.measurement.zzit r37) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzit):int");
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
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

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzd(T t, long j) {
        return ((Long) zzmz.zze(t, j)).longValue();
    }

    private final zzkl zzd(int i) {
        return (zzkl) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x039e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> com.google.android.gms.internal.measurement.zzlq<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.zzlk r34, com.google.android.gms.internal.measurement.zzlu r35, com.google.android.gms.internal.measurement.zzkw r36, com.google.android.gms.internal.measurement.zzmu<?, ?> r37, com.google.android.gms.internal.measurement.zzjv<?> r38, com.google.android.gms.internal.measurement.zzlj r39) {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzlk, com.google.android.gms.internal.measurement.zzlu, com.google.android.gms.internal.measurement.zzkw, com.google.android.gms.internal.measurement.zzmu, com.google.android.gms.internal.measurement.zzjv, com.google.android.gms.internal.measurement.zzlj):com.google.android.gms.internal.measurement.zzlq");
    }

    private final zzme zze(int i) {
        int i2 = (i / 3) << 1;
        zzme zzmeVar = (zzme) this.zzd[i2];
        if (zzmeVar != null) {
            return zzmeVar;
        }
        zzme<T> zza2 = zzma.zza().zza((Class) ((Class) this.zzd[i2 + 1]));
        this.zzd[i2] = zza2;
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmx zzc(Object obj) {
        zzkg zzkgVar = (zzkg) obj;
        zzmx zzmxVar = zzkgVar.zzb;
        if (zzmxVar == zzmx.zzc()) {
            zzmx zzd = zzmx.zzd();
            zzkgVar.zzb = zzd;
            return zzd;
        }
        return zzmxVar;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzmu<UT, UB> zzmuVar, Object obj2) {
        zzkl zzd;
        int i2 = this.zzc[i];
        Object zze = zzmz.zze(obj, zzc(i) & 1048575);
        return (zze == null || (zzd = zzd(i)) == null) ? ub : (UB) zza(i, i2, this.zzr.zze(zze), zzd, (zzkl) ub, (zzmu<UT, zzkl>) zzmuVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzkl zzklVar, UB ub, zzmu<UT, UB> zzmuVar, Object obj) {
        zzlh<?, ?> zza2 = this.zzr.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzklVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmuVar.zzc(obj);
                }
                zzjd zzc = zziy.zzc(zzle.zza(zza2, next.getKey(), next.getValue()));
                try {
                    zzle.zza(zzc.zzb(), zza2, next.getKey(), next.getValue());
                    zzmuVar.zza((zzmu<UT, UB>) ub, i2, zzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i) {
        zzme zze = zze(i);
        long zzc = zzc(i) & 1048575;
        if (!zzc((zzlq<T>) t, i)) {
            return zze.zza();
        }
        Object object = zzb.getObject(t, zzc);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze.zza();
        if (object != null) {
            zze.zza(zza2, object);
        }
        return zza2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i, int i2) {
        zzme zze = zze(i2);
        if (!zzc((zzlq<T>) t, i, i2)) {
            return zze.zza();
        }
        Object object = zzb.getObject(t, zzc(i2) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze.zza();
        if (object != null) {
            zze.zza(zza2, object);
        }
        return zza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
        Field[] declaredFields;
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            for (Field field : cls.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private zzlq(int[] iArr, Object[] objArr, int i, int i2, zzlm zzlmVar, boolean z, int[] iArr2, int i3, int i4, zzlu zzluVar, zzkw zzkwVar, zzmu<?, ?> zzmuVar, zzjv<?> zzjvVar, zzlj zzljVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzlmVar instanceof zzkg;
        this.zzh = zzjvVar != null && zzjvVar.zza(zzlmVar);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = zzluVar;
        this.zzo = zzkwVar;
        this.zzp = zzmuVar;
        this.zzq = zzjvVar;
        this.zzg = zzlmVar;
        this.zzr = zzljVar;
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zzd(T t) {
        if (zzg(t)) {
            if (t instanceof zzkg) {
                zzkg zzkgVar = (zzkg) t;
                zzkgVar.zzc(Integer.MAX_VALUE);
                zzkgVar.zza = 0;
                zzkgVar.zzcp();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzc = zzc(i);
                long j = 1048575 & zzc;
                int i2 = (zzc & 267386880) >>> 20;
                if (i2 != 9) {
                    if (i2 == 60 || i2 == 68) {
                        if (zzc((zzlq<T>) t, this.zzc[i], i)) {
                            zze(i).zzd(zzb.getObject(t, j));
                        }
                    } else {
                        switch (i2) {
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
                                this.zzo.zzb(t, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t, j);
                                if (object != null) {
                                    unsafe.putObject(t, j, this.zzr.zzc(object));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                }
                if (zzc((zzlq<T>) t, i)) {
                    zze(i).zzd(zzb.getObject(t, j));
                }
            }
            this.zzp.zzf(t);
            if (this.zzh) {
                this.zzq.zzc(t);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t, T t2) {
        zzf(t);
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzc = zzc(i);
            long j = 1048575 & zzc;
            int i2 = this.zzc[i];
            switch ((zzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza(t, j, zzmz.zza(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzb(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzd(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzd(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzd(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zzc(t, j, zzmz.zzh(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza(t, j, zzmz.zze(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza(t, j, zzmz.zze(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzd(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzc(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzc((zzlq<T>) t2, i)) {
                        zzmz.zza((Object) t, j, zzmz.zzd(t2, j));
                        zzb((zzlq<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t, t2, i);
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
                    this.zzo.zza(t, t2, j);
                    break;
                case 50:
                    zzmg.zza(this.zzr, t, t2, j);
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
                    if (zzc((zzlq<T>) t2, i2, i)) {
                        zzmz.zza(t, j, zzmz.zze(t2, j));
                        zzb((zzlq<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzc((zzlq<T>) t2, i2, i)) {
                        zzmz.zza(t, j, zzmz.zze(t2, j));
                        zzb((zzlq<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzmg.zza(this.zzp, t, t2);
        if (this.zzh) {
            zzmg.zza(this.zzq, t, t2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0625 A[Catch: all -> 0x0297, TryCatch #3 {all -> 0x0297, blocks: (B:153:0x05f6, B:163:0x0620, B:165:0x0625, B:166:0x062a, B:50:0x00cc, B:51:0x00de, B:52:0x00f0, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:57:0x012e, B:60:0x0135, B:61:0x013b, B:62:0x0148, B:63:0x0159, B:64:0x0166, B:65:0x0177, B:67:0x0182, B:68:0x0193, B:69:0x01a4, B:70:0x01b5, B:71:0x01c6, B:72:0x01d7, B:73:0x01e8, B:74:0x01f9, B:75:0x020b, B:77:0x021b, B:81:0x023c, B:78:0x0225, B:80:0x022d, B:82:0x024d, B:83:0x025f, B:84:0x026d, B:85:0x027b, B:86:0x0289), top: B:195:0x05f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x065b A[LOOP:3: B:181:0x0657->B:183:0x065b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0630 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.measurement.zzmf] */
    @Override // com.google.android.gms.internal.measurement.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r18, com.google.android.gms.internal.measurement.zzmf r19, com.google.android.gms.internal.measurement.zzjt r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzmf, com.google.android.gms.internal.measurement.zzjt):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t, byte[] bArr, int i, int i2, zzit zzitVar) throws IOException {
        zza((zzlq<T>) t, bArr, i, i2, 0, zzitVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t, T t2, int i) {
        if (zzc((zzlq<T>) t2, i)) {
            long zzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, zzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzme zze = zze(i);
            if (!zzc((zzlq<T>) t, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, zzc, object);
                } else {
                    Object zza2 = zze.zza();
                    zze.zza(zza2, object);
                    unsafe.putObject(t, zzc, zza2);
                }
                zzb((zzlq<T>) t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, zzc);
            if (!zzg(object2)) {
                Object zza3 = zze.zza();
                zze.zza(zza3, object2);
                unsafe.putObject(t, zzc, zza3);
                object2 = zza3;
            }
            zze.zza(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc((zzlq<T>) t2, i2, i)) {
            long zzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, zzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzme zze = zze(i);
            if (!zzc((zzlq<T>) t, i2, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, zzc, object);
                } else {
                    Object zza2 = zze.zza();
                    zze.zza(zza2, object);
                    unsafe.putObject(t, zzc, zza2);
                }
                zzb((zzlq<T>) t, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(t, zzc);
            if (!zzg(object2)) {
                Object zza3 = zze.zza();
                zze.zza(zza3, object2);
                unsafe.putObject(t, zzc, zza3);
                object2 = zza3;
            }
            zze.zza(object2, object);
        }
    }

    private final void zza(Object obj, int i, zzmf zzmfVar) throws IOException {
        if (zzg(i)) {
            zzmz.zza(obj, i & 1048575, zzmfVar.zzr());
        } else if (this.zzi) {
            zzmz.zza(obj, i & 1048575, zzmfVar.zzq());
        } else {
            zzmz.zza(obj, i & 1048575, zzmfVar.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int zzb2 = zzb(i);
        long j = 1048575 & zzb2;
        if (j == 1048575) {
            return;
        }
        zzmz.zza((Object) t, j, (1 << (zzb2 >>> 20)) | zzmz.zzc(t, j));
    }

    private final void zzb(T t, int i, int i2) {
        zzmz.zza((Object) t, zzb(i2) & 1048575, i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, zzc(i) & 1048575, obj);
        zzb((zzlq<T>) t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, zzc(i2) & 1048575, obj);
        zzb((zzlq<T>) t, i, i2);
    }

    private final <K, V> void zza(zznl zznlVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zznlVar.zza(i, this.zzr.zza(zzf(i2)), this.zzr.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zznl zznlVar) throws IOException {
        if (obj instanceof String) {
            zznlVar.zza(i, (String) obj);
        } else {
            zznlVar.zza(i, (zziy) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0b8e  */
    @Override // com.google.android.gms.internal.measurement.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r24, com.google.android.gms.internal.measurement.zznl r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zza(java.lang.Object, com.google.android.gms.internal.measurement.zznl):void");
    }

    private static <UT, UB> void zza(zzmu<UT, UB> zzmuVar, T t, zznl zznlVar) throws IOException {
        zzmuVar.zzb((zzmu<UT, UB>) zzmuVar.zzd(t), zznlVar);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc((zzlq<T>) t, i) == zzc((zzlq<T>) t2, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzmz.zza(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzmz.zza(r11, r6))) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzmg.zza(com.google.android.gms.internal.measurement.zzmz.zze(r10, r6), com.google.android.gms.internal.measurement.zzmz.zze(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (com.google.android.gms.internal.measurement.zzmg.zza(com.google.android.gms.internal.measurement.zzmz.zze(r10, r6), com.google.android.gms.internal.measurement.zzmz.zze(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzd(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzd(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00da, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
        if (com.google.android.gms.internal.measurement.zzmg.zza(com.google.android.gms.internal.measurement.zzmz.zze(r10, r6), com.google.android.gms.internal.measurement.zzmz.zze(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
        if (com.google.android.gms.internal.measurement.zzmg.zza(com.google.android.gms.internal.measurement.zzmz.zze(r10, r6), com.google.android.gms.internal.measurement.zzmz.zze(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011c, code lost:
        if (com.google.android.gms.internal.measurement.zzmg.zza(com.google.android.gms.internal.measurement.zzmz.zze(r10, r6), com.google.android.gms.internal.measurement.zzmz.zze(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012e, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzh(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzh(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0140, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0154, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzd(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0165, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzc(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0178, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzd(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018b, code lost:
        if (com.google.android.gms.internal.measurement.zzmz.zzd(r10, r6) == com.google.android.gms.internal.measurement.zzmz.zzd(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzmz.zzb(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzmz.zzb(r11, r6))) goto L85;
     */
    @Override // com.google.android.gms.internal.measurement.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzb(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlq.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    private final boolean zzc(T t, int i) {
        int zzb2 = zzb(i);
        long j = zzb2 & 1048575;
        if (j != 1048575) {
            return (zzmz.zzc(t, j) & (1 << (zzb2 >>> 20))) != 0;
        }
        int zzc = zzc(i);
        long j2 = zzc & 1048575;
        switch ((zzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzmz.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmz.zzb(t, j2)) != 0;
            case 2:
                return zzmz.zzd(t, j2) != 0;
            case 3:
                return zzmz.zzd(t, j2) != 0;
            case 4:
                return zzmz.zzc(t, j2) != 0;
            case 5:
                return zzmz.zzd(t, j2) != 0;
            case 6:
                return zzmz.zzc(t, j2) != 0;
            case 7:
                return zzmz.zzh(t, j2);
            case 8:
                Object zze = zzmz.zze(t, j2);
                if (zze instanceof String) {
                    return !((String) zze).isEmpty();
                } else if (zze instanceof zziy) {
                    return !zziy.zza.equals(zze);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzmz.zze(t, j2) != null;
            case 10:
                return !zziy.zza.equals(zzmz.zze(t, j2));
            case 11:
                return zzmz.zzc(t, j2) != 0;
            case 12:
                return zzmz.zzc(t, j2) != 0;
            case 13:
                return zzmz.zzc(t, j2) != 0;
            case 14:
                return zzmz.zzd(t, j2) != 0;
            case 15:
                return zzmz.zzc(t, j2) != 0;
            case 16:
                return zzmz.zzd(t, j2) != 0;
            case 17:
                return zzmz.zze(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc((zzlq<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzme] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzme] */
    @Override // com.google.android.gms.internal.measurement.zzme
    public final boolean zze(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zzl) {
                return !this.zzh || this.zzq.zza(t).zzg();
            }
            int i6 = this.zzk[i5];
            int i7 = this.zzc[i6];
            int zzc = zzc(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                i = i3;
                i2 = i4;
            }
            if (((268435456 & zzc) != 0) && !zza((zzlq<T>) t, i6, i, i2, i10)) {
                return false;
            }
            int i11 = (267386880 & zzc) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (zza((zzlq<T>) t, i6, i, i2, i10) && !zza((Object) t, zzc, zze(i6))) {
                    return false;
                }
            } else {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zzc((zzlq<T>) t, i7, i6) && !zza((Object) t, zzc, zze(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzd = this.zzr.zzd(zzmz.zze(t, zzc & 1048575));
                            if (!zzd.isEmpty()) {
                                if (this.zzr.zza(zzf(i6)).zzc.zzb() == zznj.MESSAGE) {
                                    Iterator<?> it = zzd.values().iterator();
                                    zzme<T> zzmeVar = 0;
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzmeVar == null) {
                                            zzmeVar = zzma.zza().zza((Class) next.getClass());
                                        }
                                        boolean zze = zzmeVar.zze(next);
                                        zzmeVar = zzmeVar;
                                        if (!zze) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzmz.zze(t, zzc & 1048575);
                if (!list.isEmpty()) {
                    ?? zze2 = zze(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zze2.zze(list.get(i12))) {
                            z = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzme zzmeVar) {
        return zzmeVar.zze(zzmz.zze(obj, i & 1048575));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzkg) {
            return ((zzkg) obj).zzcq();
        }
        return true;
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzmz.zzc(t, (long) (zzb(i2) & 1048575)) == i;
    }

    private static <T> boolean zze(T t, long j) {
        return ((Boolean) zzmz.zze(t, j)).booleanValue();
    }
}
