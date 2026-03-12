package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import com.google.common.base.Ascii;
import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public final class zziu {
    private static volatile int zza = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzit zzitVar) throws zzkp {
        int zzc = zzc(bArr, i, zzitVar);
        int i2 = zzitVar.zza;
        if (i2 < 0) {
            throw zzkp.zzf();
        }
        if (i2 <= bArr.length - zzc) {
            if (i2 == 0) {
                zzitVar.zzc = zziy.zza;
                return zzc;
            }
            zzitVar.zzc = zziy.zza(bArr, zzc, i2);
            return zzc + i2;
        }
        throw zzkp.zzi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzlm zzlmVar, zzmu<zzmx, zzmx> zzmuVar, zzit zzitVar) throws IOException {
        if (zzitVar.zzd.zza(zzlmVar, i >>> 3) == null) {
            return zza(i, bArr, i2, i3, zzlq.zzc(obj), zzitVar);
        }
        zzkg.zzb zzbVar = (zzkg.zzb) obj;
        zzbVar.zza();
        zzjw<zzkg.zze> zzjwVar = zzbVar.zzc;
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static <T> int zza(zzme<T> zzmeVar, byte[] bArr, int i, int i2, int i3, zzit zzitVar) throws IOException {
        T zza2 = zzmeVar.zza();
        int zza3 = zza(zza2, zzmeVar, bArr, i, i2, i3, zzitVar);
        zzmeVar.zzd(zza2);
        zzitVar.zzc = zza2;
        return zza3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzme<?> zzmeVar, int i, byte[] bArr, int i2, int i3, zzkm<Object> zzkmVar, zzit zzitVar) throws IOException {
        int i4 = (i & (-8)) | 4;
        int zza2 = zza(zzmeVar, bArr, i2, i3, i4, zzitVar);
        zzkmVar.add(zzitVar.zzc);
        while (zza2 < i3) {
            int zzc = zzc(bArr, zza2, zzitVar);
            if (i != zzitVar.zza) {
                break;
            }
            zza2 = zza(zzmeVar, bArr, zzc, i3, i4, zzitVar);
            zzkmVar.add(zzitVar.zzc);
        }
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> int zza(zzme<T> zzmeVar, byte[] bArr, int i, int i2, zzit zzitVar) throws IOException {
        T zza2 = zzmeVar.zza();
        int zza3 = zza(zza2, zzmeVar, bArr, i, i2, zzitVar);
        zzmeVar.zzd(zza2);
        zzitVar.zzc = zza2;
        return zza3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzme<?> zzmeVar, int i, byte[] bArr, int i2, int i3, zzkm<?> zzkmVar, zzit zzitVar) throws IOException {
        int zza2 = zza(zzmeVar, bArr, i2, i3, zzitVar);
        zzkmVar.add(zzitVar.zzc);
        while (zza2 < i3) {
            int zzc = zzc(bArr, zza2, zzitVar);
            if (i != zzitVar.zza) {
                break;
            }
            zza2 = zza(zzmeVar, bArr, zzc, i3, zzitVar);
            zzkmVar.add(zzitVar.zzc);
        }
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzkm<?> zzkmVar, zzit zzitVar) throws IOException {
        zzkh zzkhVar = (zzkh) zzkmVar;
        int zzc = zzc(bArr, i, zzitVar);
        int i2 = zzitVar.zza + zzc;
        while (zzc < i2) {
            zzc = zzc(bArr, zzc, zzitVar);
            zzkhVar.zzd(zzitVar.zza);
        }
        if (zzc == i2) {
            return zzc;
        }
        throw zzkp.zzi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i, zzit zzitVar) throws zzkp {
        int zzc = zzc(bArr, i, zzitVar);
        int i2 = zzitVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzitVar.zzc = "";
                return zzc;
            }
            zzitVar.zzc = zzna.zzb(bArr, zzc, i2);
            return zzc + i2;
        }
        throw zzkp.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzmx zzmxVar, zzit zzitVar) throws zzkp {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzd = zzd(bArr, i2, zzitVar);
                zzmxVar.zza(i, Long.valueOf(zzitVar.zzb));
                return zzd;
            } else if (i4 == 1) {
                zzmxVar.zza(i, Long.valueOf(zzd(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzc = zzc(bArr, i2, zzitVar);
                int i5 = zzitVar.zza;
                if (i5 < 0) {
                    throw zzkp.zzf();
                }
                if (i5 <= bArr.length - zzc) {
                    if (i5 == 0) {
                        zzmxVar.zza(i, zziy.zza);
                    } else {
                        zzmxVar.zza(i, zziy.zza(bArr, zzc, i5));
                    }
                    return zzc + i5;
                }
                throw zzkp.zzi();
            } else if (i4 != 3) {
                if (i4 == 5) {
                    zzmxVar.zza(i, Integer.valueOf(zzc(bArr, i2)));
                    return i2 + 4;
                }
                throw zzkp.zzc();
            } else {
                zzmx zzd2 = zzmx.zzd();
                int i6 = (i & (-8)) | 4;
                zzitVar.zze++;
                zza(zzitVar.zze);
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzc2 = zzc(bArr, i2, zzitVar);
                    int i8 = zzitVar.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zzc2;
                        break;
                    }
                    int zza2 = zza(i7, bArr, zzc2, i3, zzd2, zzitVar);
                    i7 = i8;
                    i2 = zza2;
                }
                zzitVar.zze--;
                if (i2 > i3 || i7 != i6) {
                    throw zzkp.zzg();
                }
                zzmxVar.zza(i, zzd2);
                return i2;
            }
        }
        throw zzkp.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i, zzit zzitVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzitVar.zza = b;
            return i2;
        }
        return zza(b, bArr, i2, zzitVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, zzit zzitVar) {
        int i3 = i & WorkQueueKt.MASK;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzitVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzitVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzitVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzitVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzitVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzkm<?> zzkmVar, zzit zzitVar) {
        zzkh zzkhVar = (zzkh) zzkmVar;
        int zzc = zzc(bArr, i2, zzitVar);
        zzkhVar.zzd(zzitVar.zza);
        while (zzc < i3) {
            int zzc2 = zzc(bArr, zzc, zzitVar);
            if (i != zzitVar.zza) {
                break;
            }
            zzc = zzc(bArr, zzc2, zzitVar);
            zzkhVar.zzd(zzitVar.zza);
        }
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i, zzit zzitVar) {
        byte b;
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzitVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (b & Byte.MAX_VALUE) << i4;
            b2 = bArr[i3];
            i3 = i5;
        }
        zzitVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> int zza(Object obj, zzme<T> zzmeVar, byte[] bArr, int i, int i2, int i3, zzit zzitVar) throws IOException {
        zzitVar.zze++;
        zza(zzitVar.zze);
        int zza2 = ((zzlq) zzmeVar).zza((zzlq) obj, bArr, i, i2, i3, zzitVar);
        zzitVar.zze--;
        zzitVar.zzc = obj;
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> int zza(Object obj, zzme<T> zzmeVar, byte[] bArr, int i, int i2, zzit zzitVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zza(i4, bArr, i3, zzitVar);
            i4 = zzitVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzkp.zzi();
        }
        zzitVar.zze++;
        zza(zzitVar.zze);
        int i6 = i4 + i5;
        zzmeVar.zza(obj, bArr, i5, i6, zzitVar);
        zzitVar.zze--;
        zzitVar.zzc = obj;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzit zzitVar) throws zzkp {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 5) {
                                return i2 + 4;
                            }
                            throw zzkp.zzc();
                        }
                        int i5 = (i & (-8)) | 4;
                        int i6 = 0;
                        while (i2 < i3) {
                            i2 = zzc(bArr, i2, zzitVar);
                            i6 = zzitVar.zza;
                            if (i6 == i5) {
                                break;
                            }
                            i2 = zza(i6, bArr, i2, i3, zzitVar);
                        }
                        if (i2 > i3 || i6 != i5) {
                            throw zzkp.zzg();
                        }
                        return i2;
                    }
                    return zzc(bArr, i2, zzitVar) + zzitVar.zza;
                }
                return i2 + 8;
            }
            return zzd(bArr, i2, zzitVar);
        }
        throw zzkp.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzd(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private static void zza(int i) throws zzkp {
        if (i >= zza) {
            throw zzkp.zzh();
        }
    }
}
