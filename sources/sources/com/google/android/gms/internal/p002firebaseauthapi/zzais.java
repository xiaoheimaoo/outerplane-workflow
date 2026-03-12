package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
import com.google.common.base.Ascii;
import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzais  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzais {
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
    public static int zza(byte[] bArr, int i, zzaiv zzaivVar) throws zzakm {
        int zzc = zzc(bArr, i, zzaivVar);
        int i2 = zzaivVar.zza;
        if (i2 < 0) {
            throw zzakm.zzf();
        }
        if (i2 <= bArr.length - zzc) {
            if (i2 == 0) {
                zzaivVar.zzc = zzaiw.zza;
                return zzc;
            }
            zzaivVar.zzc = zzaiw.zza(bArr, zzc, i2);
            return zzc + i2;
        }
        throw zzakm.zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzaln zzalnVar, zzamv<zzamy, zzamy> zzamvVar, zzaiv zzaivVar) throws IOException {
        if (zzaivVar.zzd.zza(zzalnVar, i >>> 3) == null) {
            return zza(i, bArr, i2, i3, zzalr.zzc(obj), zzaivVar);
        }
        zzakg.zzd zzdVar = (zzakg.zzd) obj;
        zzdVar.zza();
        zzajy<zzakg.zzc> zzajyVar = zzdVar.zzc;
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static <T> int zza(zzamc<T> zzamcVar, byte[] bArr, int i, int i2, int i3, zzaiv zzaivVar) throws IOException {
        T zza2 = zzamcVar.zza();
        int zza3 = zza(zza2, zzamcVar, bArr, i, i2, i3, zzaivVar);
        zzamcVar.zzd(zza2);
        zzaivVar.zzc = zza2;
        return zza3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzamc<?> zzamcVar, int i, byte[] bArr, int i2, int i3, zzakn<Object> zzaknVar, zzaiv zzaivVar) throws IOException {
        int i4 = (i & (-8)) | 4;
        int zza2 = zza(zzamcVar, bArr, i2, i3, i4, zzaivVar);
        zzaknVar.add(zzaivVar.zzc);
        while (zza2 < i3) {
            int zzc = zzc(bArr, zza2, zzaivVar);
            if (i != zzaivVar.zza) {
                break;
            }
            zza2 = zza(zzamcVar, bArr, zzc, i3, i4, zzaivVar);
            zzaknVar.add(zzaivVar.zzc);
        }
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> int zza(zzamc<T> zzamcVar, byte[] bArr, int i, int i2, zzaiv zzaivVar) throws IOException {
        T zza2 = zzamcVar.zza();
        int zza3 = zza(zza2, zzamcVar, bArr, i, i2, zzaivVar);
        zzamcVar.zzd(zza2);
        zzaivVar.zzc = zza2;
        return zza3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzamc<?> zzamcVar, int i, byte[] bArr, int i2, int i3, zzakn<?> zzaknVar, zzaiv zzaivVar) throws IOException {
        int zza2 = zza(zzamcVar, bArr, i2, i3, zzaivVar);
        zzaknVar.add(zzaivVar.zzc);
        while (zza2 < i3) {
            int zzc = zzc(bArr, zza2, zzaivVar);
            if (i != zzaivVar.zza) {
                break;
            }
            zza2 = zza(zzamcVar, bArr, zzc, i3, zzaivVar);
            zzaknVar.add(zzaivVar.zzc);
        }
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzakn<?> zzaknVar, zzaiv zzaivVar) throws IOException {
        zzakj zzakjVar = (zzakj) zzaknVar;
        int zzc = zzc(bArr, i, zzaivVar);
        int i2 = zzaivVar.zza + zzc;
        while (zzc < i2) {
            zzc = zzc(bArr, zzc, zzaivVar);
            zzakjVar.zzc(zzaivVar.zza);
        }
        if (zzc == i2) {
            return zzc;
        }
        throw zzakm.zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i, zzaiv zzaivVar) throws zzakm {
        int zzc = zzc(bArr, i, zzaivVar);
        int i2 = zzaivVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzaivVar.zzc = "";
                return zzc;
            }
            zzaivVar.zzc = zzanb.zzb(bArr, zzc, i2);
            return zzc + i2;
        }
        throw zzakm.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzamy zzamyVar, zzaiv zzaivVar) throws zzakm {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzd = zzd(bArr, i2, zzaivVar);
                zzamyVar.zza(i, Long.valueOf(zzaivVar.zzb));
                return zzd;
            } else if (i4 == 1) {
                zzamyVar.zza(i, Long.valueOf(zzd(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzc = zzc(bArr, i2, zzaivVar);
                int i5 = zzaivVar.zza;
                if (i5 < 0) {
                    throw zzakm.zzf();
                }
                if (i5 <= bArr.length - zzc) {
                    if (i5 == 0) {
                        zzamyVar.zza(i, zzaiw.zza);
                    } else {
                        zzamyVar.zza(i, zzaiw.zza(bArr, zzc, i5));
                    }
                    return zzc + i5;
                }
                throw zzakm.zzj();
            } else if (i4 != 3) {
                if (i4 == 5) {
                    zzamyVar.zza(i, Integer.valueOf(zzc(bArr, i2)));
                    return i2 + 4;
                }
                throw zzakm.zzc();
            } else {
                zzamy zzd2 = zzamy.zzd();
                int i6 = (i & (-8)) | 4;
                zzaivVar.zze++;
                zza(zzaivVar.zze);
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzc2 = zzc(bArr, i2, zzaivVar);
                    int i8 = zzaivVar.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zzc2;
                        break;
                    }
                    int zza2 = zza(i7, bArr, zzc2, i3, zzd2, zzaivVar);
                    i7 = i8;
                    i2 = zza2;
                }
                zzaivVar.zze--;
                if (i2 > i3 || i7 != i6) {
                    throw zzakm.zzg();
                }
                zzamyVar.zza(i, zzd2);
                return i2;
            }
        }
        throw zzakm.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i, zzaiv zzaivVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzaivVar.zza = b;
            return i2;
        }
        return zza(b, bArr, i2, zzaivVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, zzaiv zzaivVar) {
        int i3 = i & WorkQueueKt.MASK;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzaivVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzaivVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzaivVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzaivVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzaivVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzakn<?> zzaknVar, zzaiv zzaivVar) {
        zzakj zzakjVar = (zzakj) zzaknVar;
        int zzc = zzc(bArr, i2, zzaivVar);
        zzakjVar.zzc(zzaivVar.zza);
        while (zzc < i3) {
            int zzc2 = zzc(bArr, zzc, zzaivVar);
            if (i != zzaivVar.zza) {
                break;
            }
            zzc = zzc(bArr, zzc2, zzaivVar);
            zzakjVar.zzc(zzaivVar.zza);
        }
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i, zzaiv zzaivVar) {
        byte b;
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzaivVar.zzb = j;
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
        zzaivVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> int zza(Object obj, zzamc<T> zzamcVar, byte[] bArr, int i, int i2, int i3, zzaiv zzaivVar) throws IOException {
        zzaivVar.zze++;
        zza(zzaivVar.zze);
        int zza2 = ((zzalr) zzamcVar).zza((zzalr) obj, bArr, i, i2, i3, zzaivVar);
        zzaivVar.zze--;
        zzaivVar.zzc = obj;
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> int zza(Object obj, zzamc<T> zzamcVar, byte[] bArr, int i, int i2, zzaiv zzaivVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zza(i4, bArr, i3, zzaivVar);
            i4 = zzaivVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzakm.zzj();
        }
        zzaivVar.zze++;
        zza(zzaivVar.zze);
        int i6 = i4 + i5;
        zzamcVar.zza(obj, bArr, i5, i6, zzaivVar);
        zzaivVar.zze--;
        zzaivVar.zzc = obj;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzaiv zzaivVar) throws zzakm {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 5) {
                                return i2 + 4;
                            }
                            throw zzakm.zzc();
                        }
                        int i5 = (i & (-8)) | 4;
                        int i6 = 0;
                        while (i2 < i3) {
                            i2 = zzc(bArr, i2, zzaivVar);
                            i6 = zzaivVar.zza;
                            if (i6 == i5) {
                                break;
                            }
                            i2 = zza(i6, bArr, i2, i3, zzaivVar);
                        }
                        if (i2 > i3 || i6 != i5) {
                            throw zzakm.zzg();
                        }
                        return i2;
                    }
                    return zzc(bArr, i2, zzaivVar) + zzaivVar.zza;
                }
                return i2 + 8;
            }
            return zzd(bArr, i2, zzaivVar);
        }
        throw zzakm.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzd(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private static void zza(int i) throws zzakm {
        if (i >= zza) {
            throw zzakm.zzh();
        }
    }
}
