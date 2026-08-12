package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
public final class zzdx {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzdw zzdwVar) throws zzfq {
        int zzi = zzi(bArr, i, zzdwVar);
        int i2 = zzdwVar.zza;
        if (i2 < 0) {
            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 <= bArr.length - zzi) {
            if (i2 == 0) {
                zzdwVar.zzc = zzei.zzb;
                return zzi;
            }
            zzdwVar.zzc = zzei.zzj(bArr, zzi, i2);
            return zzi + i2;
        }
        throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << 24) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzgv zzgvVar, byte[] bArr, int i, int i2, int i3, zzdw zzdwVar) throws IOException {
        Object zze = zzgvVar.zze();
        int zzm = zzm(zze, zzgvVar, bArr, i, i2, i3, zzdwVar);
        zzgvVar.zzf(zze);
        zzdwVar.zzc = zze;
        return zzm;
    }

    static int zzd(zzgv zzgvVar, byte[] bArr, int i, int i2, zzdw zzdwVar) throws IOException {
        Object zze = zzgvVar.zze();
        int zzn = zzn(zze, zzgvVar, bArr, i, i2, zzdwVar);
        zzgvVar.zzf(zze);
        zzdwVar.zzc = zze;
        return zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzgv zzgvVar, int i, byte[] bArr, int i2, int i3, zzfn zzfnVar, zzdw zzdwVar) throws IOException {
        int zzd = zzd(zzgvVar, bArr, i2, i3, zzdwVar);
        zzfnVar.add(zzdwVar.zzc);
        while (zzd < i3) {
            int zzi = zzi(bArr, zzd, zzdwVar);
            if (i != zzdwVar.zza) {
                break;
            }
            zzd = zzd(zzgvVar, bArr, zzi, i3, zzdwVar);
            zzfnVar.add(zzdwVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzfn zzfnVar, zzdw zzdwVar) throws IOException {
        zzfj zzfjVar = (zzfj) zzfnVar;
        int zzi = zzi(bArr, i, zzdwVar);
        int i2 = zzdwVar.zza + zzi;
        while (zzi < i2) {
            zzi = zzi(bArr, zzi, zzdwVar);
            zzfjVar.zzg(zzdwVar.zza);
        }
        if (zzi == i2) {
            return zzi;
        }
        throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i, zzdw zzdwVar) throws zzfq {
        int zzi = zzi(bArr, i, zzdwVar);
        int i2 = zzdwVar.zza;
        if (i2 >= 0) {
            if (i2 == 0) {
                zzdwVar.zzc = "";
                return zzi;
            }
            int i3 = zzhr.zza;
            int length = bArr.length;
            if ((((length - zzi) - i2) | zzi | i2) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(zzi), Integer.valueOf(i2)));
            }
            int i4 = zzi + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (zzi < i4) {
                byte b = bArr[zzi];
                if (!zzhp.zzd(b)) {
                    break;
                }
                zzi++;
                cArr[i5] = (char) b;
                i5++;
            }
            while (zzi < i4) {
                int i6 = zzi + 1;
                byte b2 = bArr[zzi];
                if (zzhp.zzd(b2)) {
                    int i7 = i5 + 1;
                    cArr[i5] = (char) b2;
                    zzi = i6;
                    while (true) {
                        i5 = i7;
                        if (zzi < i4) {
                            byte b3 = bArr[zzi];
                            if (zzhp.zzd(b3)) {
                                zzi++;
                                i7 = i5 + 1;
                                cArr[i5] = (char) b3;
                            }
                        }
                    }
                } else if (b2 < -32) {
                    if (i6 < i4) {
                        zzhp.zzc(b2, bArr[i6], cArr, i5);
                        i5++;
                        zzi = i6 + 1;
                    } else {
                        throw new zzfq("Protocol message had invalid UTF-8.");
                    }
                } else if (b2 < -16) {
                    if (i6 < i4 - 1) {
                        int i8 = i6 + 1;
                        zzhp.zzb(b2, bArr[i6], bArr[i8], cArr, i5);
                        i5++;
                        zzi = i8 + 1;
                    } else {
                        throw new zzfq("Protocol message had invalid UTF-8.");
                    }
                } else if (i6 < i4 - 2) {
                    int i9 = i6 + 1;
                    byte b4 = bArr[i6];
                    int i10 = i9 + 1;
                    zzhp.zza(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                    i5 += 2;
                    zzi = i10 + 1;
                } else {
                    throw new zzfq("Protocol message had invalid UTF-8.");
                }
            }
            zzdwVar.zzc = new String(cArr, 0, i5);
            return i4;
        }
        throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(byte[] bArr, int i, zzdw zzdwVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzdwVar.zza = b;
            return i2;
        }
        return zzj(b, bArr, i2, zzdwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i, byte[] bArr, int i2, zzdw zzdwVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & WorkQueueKt.MASK;
        if (b >= 0) {
            zzdwVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzdwVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdwVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdwVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdwVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i, byte[] bArr, int i2, int i3, zzfn zzfnVar, zzdw zzdwVar) {
        zzfj zzfjVar = (zzfj) zzfnVar;
        int zzi = zzi(bArr, i2, zzdwVar);
        zzfjVar.zzg(zzdwVar.zza);
        while (zzi < i3) {
            int zzi2 = zzi(bArr, zzi, zzdwVar);
            if (i != zzdwVar.zza) {
                break;
            }
            zzi = zzi(bArr, zzi2, zzdwVar);
            zzfjVar.zzg(zzdwVar.zza);
        }
        return zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(byte[] bArr, int i, zzdw zzdwVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzdwVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= (b2 & Byte.MAX_VALUE) << i4;
            i3 = i5;
            b = b2;
        }
        zzdwVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(Object obj, zzgv zzgvVar, byte[] bArr, int i, int i2, int i3, zzdw zzdwVar) throws IOException {
        zzgo zzgoVar = (zzgo) zzgvVar;
        int i4 = zzdwVar.zze + 1;
        zzdwVar.zze = i4;
        zzp(i4);
        int zzc = zzgoVar.zzc(obj, bArr, i, i2, i3, zzdwVar);
        zzdwVar.zze--;
        zzdwVar.zzc = obj;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(Object obj, zzgv zzgvVar, byte[] bArr, int i, int i2, zzdw zzdwVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzj(i4, bArr, i3, zzdwVar);
            i4 = zzdwVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = zzdwVar.zze + 1;
        zzdwVar.zze = i6;
        zzp(i6);
        int i7 = i4 + i5;
        zzgvVar.zzh(obj, bArr, i5, i7, zzdwVar);
        zzdwVar.zze--;
        zzdwVar.zzc = obj;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzo(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    private static void zzp(int i) throws zzfq {
        if (i >= zzb) {
            throw new zzfq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, byte[] bArr, int i2, int i3, zzhi zzhiVar, zzdw zzdwVar) throws zzfq {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzl = zzl(bArr, i2, zzdwVar);
                zzhiVar.zzj(i, Long.valueOf(zzdwVar.zzb));
                return zzl;
            } else if (i4 == 1) {
                zzhiVar.zzj(i, Long.valueOf(zzo(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzi = zzi(bArr, i2, zzdwVar);
                int i5 = zzdwVar.zza;
                if (i5 < 0) {
                    throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                if (i5 <= bArr.length - zzi) {
                    if (i5 == 0) {
                        zzhiVar.zzj(i, zzei.zzb);
                    } else {
                        zzhiVar.zzj(i, zzei.zzj(bArr, zzi, i5));
                    }
                    return zzi + i5;
                }
                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            } else if (i4 != 3) {
                if (i4 != 5) {
                    throw new zzfq("Protocol message contained an invalid tag (zero).");
                }
                zzhiVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                int i6 = (i & (-8)) | 4;
                zzhi zzf = zzhi.zzf();
                int i7 = zzdwVar.zze + 1;
                zzdwVar.zze = i7;
                zzp(i7);
                int i8 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzi2 = zzi(bArr, i2, zzdwVar);
                    i8 = zzdwVar.zza;
                    if (i8 == i6) {
                        i2 = zzi2;
                        break;
                    }
                    i2 = zzh(i8, bArr, zzi2, i3, zzf, zzdwVar);
                }
                zzdwVar.zze--;
                if (i2 > i3 || i8 != i6) {
                    throw new zzfq("Failed to parse the message.");
                }
                zzhiVar.zzj(i, zzf);
                return i2;
            }
        }
        throw new zzfq("Protocol message contained an invalid tag (zero).");
    }
}
