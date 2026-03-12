package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmw  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzmw {
    private static final int[] zza = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzb = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzc = {67108863, 33554431};
    private static final int[] zzd = {26, 25};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        zzb(jArr3, jArr2);
        zzb(jArr12, jArr3);
        zzb(jArr11, jArr12);
        zza(jArr4, jArr11, jArr2);
        zza(jArr5, jArr4, jArr3);
        zzb(jArr11, jArr5);
        zza(jArr6, jArr11, jArr4);
        zzb(jArr11, jArr6);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zza(jArr7, jArr11, jArr6);
        zzb(jArr11, jArr7);
        zzb(jArr12, jArr11);
        for (int i = 2; i < 10; i += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr8, jArr12, jArr7);
        zzb(jArr11, jArr8);
        zzb(jArr12, jArr11);
        for (int i2 = 2; i2 < 20; i2 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr8);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        for (int i3 = 2; i3 < 10; i3 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr9, jArr11, jArr7);
        zzb(jArr11, jArr9);
        zzb(jArr12, jArr11);
        for (int i4 = 2; i4 < 50; i4 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr10, jArr12, jArr9);
        zzb(jArr12, jArr10);
        zzb(jArr11, jArr12);
        for (int i5 = 2; i5 < 100; i5 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr12, jArr11, jArr10);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        for (int i6 = 2; i6 < 50; i6 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr9);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zza(jArr, jArr12, jArr5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        zzb(jArr4, jArr2, jArr3);
        zze(jArr4, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr[0] = jArr2[0] * jArr3[0];
        long j = jArr2[0];
        long j2 = jArr2[1];
        long j3 = jArr3[0];
        jArr[1] = (jArr3[1] * j) + (j2 * j3);
        long j4 = jArr2[1];
        long j5 = jArr3[1];
        jArr[2] = (j4 * 2 * j5) + (jArr3[2] * j) + (jArr2[2] * j3);
        long j6 = jArr3[2];
        long j7 = jArr2[2];
        jArr[3] = (j4 * j6) + (j7 * j5) + (jArr3[3] * j) + (jArr2[3] * j3);
        long j8 = jArr3[3];
        long j9 = jArr2[3];
        jArr[4] = (j7 * j6) + (((j4 * j8) + (j9 * j5)) * 2) + (jArr3[4] * j) + (jArr2[4] * j3);
        long j10 = jArr3[4];
        long j11 = jArr2[4];
        jArr[5] = (j7 * j8) + (j9 * j6) + (j4 * j10) + (j11 * j5) + (jArr3[5] * j) + (jArr2[5] * j3);
        long j12 = jArr3[5];
        long j13 = jArr2[5];
        jArr[6] = (((j9 * j8) + (j4 * j12) + (j13 * j5)) * 2) + (j7 * j10) + (j11 * j6) + (jArr3[6] * j) + (jArr2[6] * j3);
        long j14 = jArr3[6];
        long j15 = jArr2[6];
        jArr[7] = (j9 * j10) + (j11 * j8) + (j7 * j12) + (j13 * j6) + (j4 * j14) + (j15 * j5) + (jArr3[7] * j) + (jArr2[7] * j3);
        long j16 = jArr3[7];
        long j17 = jArr2[7];
        jArr[8] = (j11 * j10) + (((j9 * j12) + (j13 * j8) + (j4 * j16) + (j17 * j5)) * 2) + (j7 * j14) + (j15 * j6) + (jArr3[8] * j) + (jArr2[8] * j3);
        long j18 = jArr3[8];
        long j19 = jArr2[8];
        jArr[9] = (j11 * j12) + (j13 * j10) + (j9 * j14) + (j15 * j8) + (j7 * j16) + (j17 * j6) + (j4 * j18) + (j19 * j5) + (j * jArr3[9]) + (jArr2[9] * j3);
        long j20 = jArr3[9];
        long j21 = jArr2[9];
        jArr[10] = (((j13 * j12) + (j9 * j16) + (j17 * j8) + (j4 * j20) + (j5 * j21)) * 2) + (j11 * j14) + (j15 * j10) + (j7 * j18) + (j19 * j6);
        jArr[11] = (j13 * j14) + (j15 * j12) + (j11 * j16) + (j17 * j10) + (j9 * j18) + (j19 * j8) + (j7 * j20) + (j6 * j21);
        jArr[12] = (j15 * j14) + (((j13 * j16) + (j17 * j12) + (j9 * j20) + (j8 * j21)) * 2) + (j11 * j18) + (j19 * j10);
        jArr[13] = (j15 * j16) + (j17 * j14) + (j13 * j18) + (j19 * j12) + (j11 * j20) + (j10 * j21);
        jArr[14] = (((j17 * j16) + (j13 * j20) + (j12 * j21)) * 2) + (j15 * j18) + (j19 * j14);
        jArr[15] = (j17 * j18) + (j19 * j16) + (j15 * j20) + (j14 * j21);
        jArr[16] = (j19 * j18) + (((j17 * j20) + (j16 * j21)) * 2);
        jArr[17] = (j19 * j20) + (j18 * j21);
        jArr[18] = j21 * 2 * j20;
    }

    private static void zze(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        zzb(jArr);
        zza(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(long[] jArr) {
        jArr[10] = 0;
        int i = 0;
        while (i < 10) {
            long j = jArr[i];
            long j2 = j / 67108864;
            jArr[i] = j - (j2 << 26);
            int i2 = i + 1;
            long j3 = jArr[i2] + j2;
            jArr[i2] = j3;
            long j4 = j3 / 33554432;
            jArr[i2] = j3 - (j4 << 25);
            i += 2;
            jArr[i] = jArr[i] + j4;
        }
        long j5 = jArr[0];
        long j6 = jArr[10];
        long j7 = j5 + (j6 << 4);
        jArr[0] = j7;
        long j8 = j7 + (j6 << 1);
        jArr[0] = j8;
        long j9 = j8 + j6;
        jArr[0] = j9;
        jArr[10] = 0;
        long j10 = j9 / 67108864;
        jArr[0] = j9 - (j10 << 26);
        jArr[1] = jArr[1] + j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(long[] jArr) {
        long j = jArr[8];
        long j2 = jArr[18];
        long j3 = j + (j2 << 4);
        jArr[8] = j3;
        long j4 = j3 + (j2 << 1);
        jArr[8] = j4;
        jArr[8] = j4 + j2;
        long j5 = jArr[7];
        long j6 = jArr[17];
        long j7 = j5 + (j6 << 4);
        jArr[7] = j7;
        long j8 = j7 + (j6 << 1);
        jArr[7] = j8;
        jArr[7] = j8 + j6;
        long j9 = jArr[6];
        long j10 = jArr[16];
        long j11 = j9 + (j10 << 4);
        jArr[6] = j11;
        long j12 = j11 + (j10 << 1);
        jArr[6] = j12;
        jArr[6] = j12 + j10;
        long j13 = jArr[5];
        long j14 = jArr[15];
        long j15 = j13 + (j14 << 4);
        jArr[5] = j15;
        long j16 = j15 + (j14 << 1);
        jArr[5] = j16;
        jArr[5] = j16 + j14;
        long j17 = jArr[4];
        long j18 = jArr[14];
        long j19 = j17 + (j18 << 4);
        jArr[4] = j19;
        long j20 = j19 + (j18 << 1);
        jArr[4] = j20;
        jArr[4] = j20 + j18;
        long j21 = jArr[3];
        long j22 = jArr[13];
        long j23 = j21 + (j22 << 4);
        jArr[3] = j23;
        long j24 = j23 + (j22 << 1);
        jArr[3] = j24;
        jArr[3] = j24 + j22;
        long j25 = jArr[2];
        long j26 = jArr[12];
        long j27 = j25 + (j26 << 4);
        jArr[2] = j27;
        long j28 = j27 + (j26 << 1);
        jArr[2] = j28;
        jArr[2] = j28 + j26;
        long j29 = jArr[1];
        long j30 = jArr[11];
        long j31 = j29 + (j30 << 4);
        jArr[1] = j31;
        long j32 = j31 + (j30 << 1);
        jArr[1] = j32;
        jArr[1] = j32 + j30;
        long j33 = jArr[0];
        long j34 = jArr[10];
        long j35 = j33 + (j34 << 4);
        jArr[0] = j35;
        long j36 = j35 + (j34 << 1);
        jArr[0] = j36;
        jArr[0] = j36 + j34;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(long[] jArr, long[] jArr2, long j) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] * j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(long[] jArr, long[] jArr2) {
        long j = jArr2[0];
        long j2 = jArr2[0];
        long j3 = jArr2[1];
        long j4 = jArr2[2];
        long j5 = jArr2[3];
        long j6 = jArr2[4];
        long j7 = jArr2[5];
        long j8 = jArr2[6];
        long j9 = (j4 * j8) + (jArr2[8] * j2);
        long j10 = jArr2[7];
        long j11 = jArr2[8];
        long j12 = jArr2[9];
        zze(new long[]{j * j, j2 * 2 * jArr2[1], ((j3 * j3) + (jArr2[2] * j2)) * 2, ((j3 * j4) + (jArr2[3] * j2)) * 2, (j4 * j4) + (j3 * 4 * j5) + (j2 * 2 * jArr2[4]), ((j4 * j5) + (j3 * j6) + (jArr2[5] * j2)) * 2, ((j5 * j5) + (j4 * j6) + (jArr2[6] * j2) + (j3 * 2 * j7)) * 2, ((j5 * j6) + (j4 * j7) + (j3 * j8) + (jArr2[7] * j2)) * 2, (j6 * j6) + ((j9 + (((j3 * j10) + (j5 * j7)) * 2)) * 2), ((j6 * j7) + (j5 * j8) + (j4 * j10) + (j3 * j11) + (j2 * jArr2[9])) * 2, ((j7 * j7) + (j6 * j8) + (j4 * j11) + (((j5 * j10) + (j3 * j12)) * 2)) * 2, ((j7 * j8) + (j6 * j10) + (j5 * j11) + (j4 * j12)) * 2, (j8 * j8) + (((j6 * j11) + (((j7 * j10) + (j5 * j12)) * 2)) * 2), ((j8 * j10) + (j7 * j11) + (j6 * j12)) * 2, ((j10 * j10) + (j8 * j11) + (j7 * 2 * j12)) * 2, ((j10 * j11) + (j8 * j12)) * 2, (j11 * j11) + (j10 * 4 * j12), j11 * 2 * j12, 2 * j12 * j12}, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc(long[] jArr, long[] jArr2) {
        zzc(jArr, jArr2, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] - jArr3[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd(long[] jArr, long[] jArr2) {
        zzd(jArr, jArr, jArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] + jArr3[i];
        }
    }

    public static byte[] zzc(long[] jArr) {
        int i;
        int i2;
        long j;
        int i3;
        int i4;
        int i5;
        long j2;
        int i6;
        int i7;
        int i8;
        long[] copyOf = Arrays.copyOf(jArr, 10);
        int i9 = 0;
        while (true) {
            if (i9 >= 2) {
                break;
            }
            int i10 = 0;
            while (i10 < 9) {
                long j3 = copyOf[i10];
                copyOf[i10] = j3 + (i8 << i7);
                i10++;
                copyOf[i10] = copyOf[i10] - (-((int) (((j3 >> 31) & j3) >> zzd[i10 & 1])));
            }
            long j4 = copyOf[9];
            copyOf[9] = j4 + (i6 << 25);
            copyOf[0] = copyOf[0] - ((-((int) (((j4 >> 31) & j4) >> 25))) * 19);
            i9++;
        }
        long j5 = copyOf[0];
        copyOf[0] = j5 + (i2 << 26);
        copyOf[1] = copyOf[1] - (-((int) (((j5 >> 31) & j5) >> 26)));
        int i11 = 0;
        for (i = 2; i11 < i; i = 2) {
            int i12 = 0;
            while (i12 < 9) {
                int i13 = i12 & 1;
                copyOf[i12] = copyOf[i12] & zzc[i13];
                i12++;
                copyOf[i12] = copyOf[i12] + ((int) (j2 >> zzd[i13]));
            }
            i11++;
        }
        copyOf[9] = copyOf[9] & 33554431;
        long j6 = copyOf[0] + (((int) (j >> 25)) * 19);
        copyOf[0] = j6;
        int i14 = ~((((int) j6) - 67108845) >> 31);
        for (int i15 = 1; i15 < 10; i15++) {
            int i16 = ~(((int) copyOf[i15]) ^ zzc[i15 & 1]);
            int i17 = i16 & (i16 << 16);
            int i18 = i17 & (i17 << 8);
            int i19 = i18 & (i18 << 4);
            int i20 = i19 & (i19 << 2);
            i14 &= (i20 & (i20 << 1)) >> 31;
        }
        copyOf[0] = copyOf[0] - (67108845 & i14);
        long j7 = 33554431 & i14;
        copyOf[1] = copyOf[1] - j7;
        for (int i21 = 2; i21 < 10; i21 += 2) {
            copyOf[i21] = copyOf[i21] - (67108863 & i14);
            int i22 = i21 + 1;
            copyOf[i22] = copyOf[i22] - j7;
        }
        for (int i23 = 0; i23 < 10; i23++) {
            copyOf[i23] = copyOf[i23] << zzb[i23];
        }
        byte[] bArr = new byte[32];
        for (int i24 = 0; i24 < 10; i24++) {
            int i25 = zza[i24];
            long j8 = copyOf[i24];
            bArr[i25] = (byte) (bArr[i25] | (j8 & 255));
            bArr[i25 + 1] = (byte) (bArr[i3] | ((j8 >> 8) & 255));
            bArr[i25 + 2] = (byte) (bArr[i4] | ((j8 >> 16) & 255));
            bArr[i25 + 3] = (byte) (bArr[i5] | ((j8 >> 24) & 255));
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long[] zza(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i = 0; i < 10; i++) {
            int i2 = zza[i];
            jArr[i] = (((((bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8)) | ((bArr[i2 + 2] & 255) << 16)) | ((bArr[i2 + 3] & 255) << 24)) >> zzb[i]) & zzc[i & 1];
        }
        return jArr;
    }
}
