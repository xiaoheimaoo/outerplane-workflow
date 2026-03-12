package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajk  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzajk extends zzaji {
    private final InputStream zzd;
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    private final byte zzy() throws IOException {
        if (this.zzh == this.zzf) {
            zzg(1);
        }
        byte[] bArr = this.zze;
        int i = this.zzh;
        this.zzh = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzab());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzz());
    }

    private static int zza(InputStream inputStream) throws IOException {
        try {
            return inputStream.available();
        } catch (zzakm e) {
            e.zzk();
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final int zzc() {
        return this.zzj + this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final int zzb(int i) throws zzakm {
        if (i < 0) {
            throw zzakm.zzf();
        }
        int i2 = i + this.zzj + this.zzh;
        if (i2 < 0) {
            throw zzakm.zzg();
        }
        int i3 = this.zzk;
        if (i2 > i3) {
            throw zzakm.zzj();
        }
        this.zzk = i2;
        zzad();
        return i3;
    }

    private static int zza(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        try {
            return inputStream.read(bArr, i, i2);
        } catch (zzakm e) {
            e.zzk();
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final int zzd() throws IOException {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final int zze() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final int zzf() throws IOException {
        return zzaa();
    }

    private final int zzz() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 4) {
            zzg(4);
            i = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r2[r3] >= 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzaa() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzh
            int r1 = r5.zzf
            if (r1 == r0) goto L6b
            byte[] r2 = r5.zze
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.zzh = r3
            return r0
        L11:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6b
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L22
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L68
        L22:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L2f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2d:
            r1 = r3
            goto L68
        L2f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L68
        L3d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6b
        L68:
            r5.zzh = r1
            return r0
        L6b:
            long r0 = r5.zzm()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzajk.zzaa():int");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final int zzg() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final int zzh() throws IOException {
        return zza(zzaa());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final int zzi() throws IOException {
        if (zzw()) {
            this.zzi = 0;
            return 0;
        }
        int zzaa = zzaa();
        this.zzi = zzaa;
        if ((zzaa >>> 3) != 0) {
            return zzaa;
        }
        throw zzakm.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final int zzj() throws IOException {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final long zzk() throws IOException {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final long zzl() throws IOException {
        return zzac();
    }

    private final long zzab() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 8) {
            zzg(8);
            i = this.zzh;
        }
        byte[] bArr = this.zze;
        this.zzh = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
        if (r2[r0] >= 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zzac() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 189
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzajk.zzac():long");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final long zzm() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzy = zzy();
            j |= (zzy & Byte.MAX_VALUE) << i;
            if ((zzy & 128) == 0) {
                return j;
            }
        }
        throw zzakm.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final long zzn() throws IOException {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final long zzo() throws IOException {
        return zza(zzac());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final long zzp() throws IOException {
        return zzac();
    }

    private static long zza(InputStream inputStream, long j) throws IOException {
        try {
            return inputStream.skip(j);
        } catch (zzakm e) {
            e.zzk();
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final zzaiw zzq() throws IOException {
        int zzaa = zzaa();
        int i = this.zzf;
        int i2 = this.zzh;
        if (zzaa <= i - i2 && zzaa > 0) {
            zzaiw zza = zzaiw.zza(this.zze, i2, zzaa);
            this.zzh += zzaa;
            return zza;
        } else if (zzaa == 0) {
            return zzaiw.zza;
        } else {
            if (zzaa < 0) {
                throw zzakm.zzf();
            }
            byte[] zzj = zzj(zzaa);
            if (zzj != null) {
                return zzaiw.zza(zzj);
            }
            int i3 = this.zzh;
            int i4 = this.zzf;
            int i5 = i4 - i3;
            this.zzj += i4;
            this.zzh = 0;
            this.zzf = 0;
            List<byte[]> zzf = zzf(zzaa - i5);
            byte[] bArr = new byte[zzaa];
            System.arraycopy(this.zze, i3, bArr, 0, i5);
            for (byte[] bArr2 : zzf) {
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return zzaiw.zzb(bArr);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final String zzr() throws IOException {
        int zzaa = zzaa();
        if (zzaa > 0 && zzaa <= this.zzf - this.zzh) {
            String str = new String(this.zze, this.zzh, zzaa, zzaki.zza);
            this.zzh += zzaa;
            return str;
        } else if (zzaa == 0) {
            return "";
        } else {
            if (zzaa < 0) {
                throw zzakm.zzf();
            }
            if (zzaa <= this.zzf) {
                zzg(zzaa);
                String str2 = new String(this.zze, this.zzh, zzaa, zzaki.zza);
                this.zzh += zzaa;
                return str2;
            }
            return new String(zza(zzaa, false), zzaki.zza);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final String zzs() throws IOException {
        byte[] zza;
        int zzaa = zzaa();
        int i = this.zzh;
        int i2 = this.zzf;
        if (zzaa <= i2 - i && zzaa > 0) {
            zza = this.zze;
            this.zzh = i + zzaa;
        } else if (zzaa == 0) {
            return "";
        } else {
            if (zzaa < 0) {
                throw zzakm.zzf();
            }
            i = 0;
            if (zzaa <= i2) {
                zzg(zzaa);
                zza = this.zze;
                this.zzh = zzaa;
            } else {
                zza = zza(zzaa, false);
            }
        }
        return zzanb.zzb(zza, i, zzaa);
    }

    private final List<byte[]> zzf(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zzd.read(bArr, i2, min - i2);
                if (read == -1) {
                    throw zzakm.zzj();
                }
                this.zzj += read;
                i2 += read;
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private zzajk(InputStream inputStream, int i) {
        super();
        this.zzk = Integer.MAX_VALUE;
        zzaki.zza(inputStream, "input");
        this.zzd = inputStream;
        this.zze = new byte[4096];
        this.zzf = 0;
        this.zzh = 0;
        this.zzj = 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final void zzc(int i) throws zzakm {
        if (this.zzi != i) {
            throw zzakm.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final void zzd(int i) {
        this.zzk = i;
        zzad();
    }

    private final void zzad() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = this.zzj + i;
        int i3 = this.zzk;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzg = i4;
            this.zzf = i - i4;
            return;
        }
        this.zzg = 0;
    }

    private final void zzg(int i) throws IOException {
        if (zzi(i)) {
            return;
        }
        if (i > (this.zzb - this.zzj) - this.zzh) {
            throw zzakm.zzi();
        }
        throw zzakm.zzj();
    }

    private final void zzh(int i) throws IOException {
        int i2 = this.zzf;
        int i3 = this.zzh;
        if (i <= i2 - i3 && i >= 0) {
            this.zzh = i3 + i;
        } else if (i < 0) {
            throw zzakm.zzf();
        } else {
            int i4 = this.zzj;
            int i5 = i4 + i3 + i;
            int i6 = this.zzk;
            if (i5 > i6) {
                zzh((i6 - i4) - i3);
                throw zzakm.zzj();
            }
            this.zzj = i4 + i3;
            int i7 = i2 - i3;
            this.zzf = 0;
            this.zzh = 0;
            while (i7 < i) {
                try {
                    long j = i - i7;
                    long zza = zza(this.zzd, j);
                    int i8 = (zza > 0L ? 1 : (zza == 0L ? 0 : -1));
                    if (i8 >= 0 && zza <= j) {
                        if (i8 == 0) {
                            break;
                        }
                        i7 += (int) zza;
                    } else {
                        throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#skip returned invalid result: " + zza + "\nThe InputStream implementation is buggy.");
                    }
                } finally {
                    this.zzj += i7;
                    zzad();
                }
            }
            if (i7 >= i) {
                return;
            }
            int i9 = this.zzf;
            int i10 = i9 - this.zzh;
            this.zzh = i9;
            zzg(1);
            while (true) {
                int i11 = i - i10;
                int i12 = this.zzf;
                if (i11 > i12) {
                    i10 += i12;
                    this.zzh = i12;
                    zzg(1);
                } else {
                    this.zzh = i11;
                    return;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final boolean zzw() throws IOException {
        return this.zzh == this.zzf && !zzi(1);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final boolean zzx() throws IOException {
        return zzac() != 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaji
    public final boolean zze(int i) throws IOException {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzf - this.zzh >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zze;
                    int i4 = this.zzh;
                    this.zzh = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzakm.zze();
            }
            while (i3 < 10) {
                if (zzy() < 0) {
                    i3++;
                }
            }
            throw zzakm.zze();
            return true;
        } else if (i2 == 1) {
            zzh(8);
            return true;
        } else if (i2 == 2) {
            zzh(zzaa());
            return true;
        } else if (i2 == 3) {
            zzv();
            zzc(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            zzu();
            return false;
        } else if (i2 == 5) {
            zzh(4);
            return true;
        } else {
            throw zzakm.zza();
        }
    }

    private final boolean zzi(int i) throws IOException {
        while (this.zzh + i > this.zzf) {
            int i2 = this.zzb;
            int i3 = this.zzj;
            int i4 = this.zzh;
            if (i > (i2 - i3) - i4 || i3 + i4 + i > this.zzk) {
                return false;
            }
            if (i4 > 0) {
                int i5 = this.zzf;
                if (i5 > i4) {
                    byte[] bArr = this.zze;
                    System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                }
                this.zzj += i4;
                this.zzf -= i4;
                this.zzh = 0;
            }
            InputStream inputStream = this.zzd;
            byte[] bArr2 = this.zze;
            int i6 = this.zzf;
            int zza = zza(inputStream, bArr2, i6, Math.min(bArr2.length - i6, (this.zzb - this.zzj) - this.zzf));
            if (zza == 0 || zza < -1 || zza > this.zze.length) {
                throw new IllegalStateException(String.valueOf(this.zzd.getClass()) + "#read(byte[]) returned invalid result: " + zza + "\nThe InputStream implementation is buggy.");
            } else if (zza <= 0) {
                return false;
            } else {
                this.zzf += zza;
                zzad();
                if (this.zzf >= i) {
                    return true;
                }
            }
        }
        throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
    }

    private final byte[] zza(int i, boolean z) throws IOException {
        byte[] zzj = zzj(i);
        if (zzj != null) {
            return zzj;
        }
        int i2 = this.zzh;
        int i3 = this.zzf;
        int i4 = i3 - i2;
        this.zzj += i3;
        this.zzh = 0;
        this.zzf = 0;
        List<byte[]> zzf = zzf(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zze, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzf) {
            System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
            i4 += bArr2.length;
        }
        return bArr;
    }

    private final byte[] zzj(int i) throws IOException {
        if (i == 0) {
            return zzaki.zzb;
        }
        if (i < 0) {
            throw zzakm.zzf();
        }
        int i2 = this.zzj + this.zzh + i;
        if (i2 - this.zzb > 0) {
            throw zzakm.zzi();
        }
        int i3 = this.zzk;
        if (i2 > i3) {
            zzh((i3 - this.zzj) - this.zzh);
            throw zzakm.zzj();
        }
        int i4 = this.zzf - this.zzh;
        int i5 = i - i4;
        if (i5 < 4096 || i5 <= zza(this.zzd)) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.zze, this.zzh, bArr, 0, i4);
            this.zzj += this.zzf;
            this.zzh = 0;
            this.zzf = 0;
            while (i4 < i) {
                int zza = zza(this.zzd, bArr, i4, i - i4);
                if (zza == -1) {
                    throw zzakm.zzj();
                }
                this.zzj += zza;
                i4 += zza;
            }
            return bArr;
        }
        return null;
    }
}
