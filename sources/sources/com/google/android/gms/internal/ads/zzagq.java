package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzagq {
    public static final zzago zza = new zzago() { // from class: com.google.android.gms.internal.ads.zzagn
    };

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.google.android.gms.internal.ads.zzby zza(byte[] r11, int r12, com.google.android.gms.internal.ads.zzago r13, com.google.android.gms.internal.ads.zzafr r14) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagq.zza(byte[], int, com.google.android.gms.internal.ads.zzago, com.google.android.gms.internal.ads.zzafr):com.google.android.gms.internal.ads.zzby");
    }

    private static int zzb(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i, int i2) {
        int zzd = zzd(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return zzd;
        }
        while (true) {
            int length = bArr.length;
            if (zzd >= length - 1) {
                return length;
            }
            int i3 = zzd + 1;
            if ((zzd - i) % 2 == 0 && bArr[i3] == 0) {
                return zzd;
            }
            zzd = zzd(bArr, i3);
        }
    }

    private static int zzd(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int zze(zzfp zzfpVar, int i) {
        byte[] zzM = zzfpVar.zzM();
        int zzd = zzfpVar.zzd();
        int i2 = zzd;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= zzd + i) {
                return i;
            }
            if ((zzM[i2] & 255) == 255 && zzM[i3] == 0) {
                System.arraycopy(zzM, i2 + 2, zzM, i3, (i - (i2 - zzd)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:79|(2:81|(1:87)(1:86))|88|89|(2:91|(10:293|99|100|(3:138|139|(2:153|(5:(5:232|(2:234|(2:236|(5:240|241|(1:243)|244|245))(1:259))(1:260)|249|250|251)(12:184|(1:186)(1:231)|187|(10:189|190|191|192|193|194|195|196|197|198)|212|213|(4:216|(3:218|219|220)(1:222)|221|214)|223|224|(1:226)(1:230)|227|228)|120|54|(0)|57)(13:160|(1:162)|163|(1:165)|166|(4:169|(3:171|172|173)(1:175)|174|167)|176|177|119|120|54|(0)|57))(2:147|(5:149|64|54|(0)|57)(3:150|151|152)))(7:107|108|(3:110|(1:112)|113)(4:123|124|125|(1:127))|114|115|116|117)|118|119|120|54|(0)|57)(2:94|(12:278|279|280|281|282|283|284|285|66|54|(0)|57)(1:97)))(1:294)|98|99|100|(14:102|138|139|(1:141)|153|(1:155)|(1:179)|232|(0)(0)|249|250|251|120|54)(14:267|138|139|(0)|153|(0)|(0)|232|(0)(0)|249|250|251|120|54)|(0)|57) */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x039e, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x039f, code lost:
        r8 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x03a3, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x03a5, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x03a6, code lost:
        r8 = r36;
     */
    /* JADX WARN: Removed duplicated region for block: B:191:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x05ba  */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v58 */
    /* JADX WARN: Type inference failed for: r8v59 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzagr zzf(int r35, com.google.android.gms.internal.ads.zzfp r36, boolean r37, int r38, com.google.android.gms.internal.ads.zzago r39) {
        /*
            Method dump skipped, instructions count: 1518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagq.zzf(int, com.google.android.gms.internal.ads.zzfp, boolean, int, com.google.android.gms.internal.ads.zzago):com.google.android.gms.internal.ads.zzagr");
    }

    private static zzgaa zzg(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return zzgaa.zzm("");
        }
        zzfzx zzfzxVar = new zzfzx();
        int zzc = zzc(bArr, i2, i);
        while (i2 < zzc) {
            zzfzxVar.zzf(new String(bArr, i2, zzc - i2, zzj(i)));
            i2 = zzb(i) + zzc;
            zzc = zzc(bArr, i2, i);
        }
        zzgaa zzi = zzfzxVar.zzi();
        return zzi.isEmpty() ? zzgaa.zzm("") : zzi;
    }

    private static String zzh(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    private static String zzi(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
        r4 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean zzk(com.google.android.gms.internal.ads.zzfp r21, int r22, int r23, boolean r24) {
        /*
            r1 = r21
            r0 = r22
            int r2 = r21.zzd()
        L8:
            int r3 = r21.zzb()     // Catch: java.lang.Throwable -> La8
            r4 = 1
            r5 = r23
            if (r3 < r5) goto La4
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L22
            int r7 = r21.zzg()     // Catch: java.lang.Throwable -> La8
            long r8 = r21.zzu()     // Catch: java.lang.Throwable -> La8
            int r10 = r21.zzq()     // Catch: java.lang.Throwable -> La8
            goto L2c
        L22:
            int r7 = r21.zzo()     // Catch: java.lang.Throwable -> La8
            int r8 = r21.zzo()     // Catch: java.lang.Throwable -> La8
            long r8 = (long) r8     // Catch: java.lang.Throwable -> La8
            r10 = r6
        L2c:
            r11 = 0
            if (r7 != 0) goto L38
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L38
            if (r10 != 0) goto L38
            goto La4
        L38:
            r7 = 4
            if (r0 != r7) goto L68
            if (r24 != 0) goto L68
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L48
        L45:
            r4 = r6
            goto La4
        L48:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            r17 = 16
            long r17 = r8 >> r17
            r19 = 24
            long r8 = r8 >> r19
            long r15 = r15 & r11
            long r11 = r17 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 14
            long r11 = r11 << r15
            long r11 = r11 | r13
            r13 = 21
            long r8 = r8 << r13
            long r8 = r8 | r11
        L68:
            if (r0 != r7) goto L78
            r3 = r10 & 64
            if (r3 == 0) goto L6f
            goto L70
        L6f:
            r4 = r6
        L70:
            r3 = r10 & 1
            r20 = r4
            r4 = r3
            r3 = r20
            goto L8a
        L78:
            if (r0 != r3) goto L88
            r3 = r10 & 32
            if (r3 == 0) goto L80
            r3 = r4
            goto L81
        L80:
            r3 = r6
        L81:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L86
            goto L8a
        L86:
            r4 = r6
            goto L8a
        L88:
            r3 = r6
            r4 = r3
        L8a:
            if (r4 == 0) goto L8e
            int r3 = r3 + 4
        L8e:
            long r3 = (long) r3     // Catch: java.lang.Throwable -> La8
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L94
            goto L45
        L94:
            int r3 = r21.zzb()     // Catch: java.lang.Throwable -> La8
            long r3 = (long) r3     // Catch: java.lang.Throwable -> La8
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto L9e
            goto L45
        L9e:
            int r3 = (int) r8     // Catch: java.lang.Throwable -> La8
            r1.zzL(r3)     // Catch: java.lang.Throwable -> La8
            goto L8
        La4:
            r1.zzK(r2)
            return r4
        La8:
            r0 = move-exception
            r1.zzK(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagq.zzk(com.google.android.gms.internal.ads.zzfp, int, int, boolean):boolean");
    }

    private static byte[] zzl(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return zzfy.zzf;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    private static Charset zzj(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return zzfwq.zzc;
                }
                return zzfwq.zzb;
            }
            return zzfwq.zzd;
        }
        return zzfwq.zzf;
    }
}
