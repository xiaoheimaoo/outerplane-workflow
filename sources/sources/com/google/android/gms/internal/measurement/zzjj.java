package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzjj extends zzjk {
    private final byte[] zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    private final byte zzw() throws IOException {
        int i = this.zzg;
        if (i == this.zze) {
            throw zzkp.zzi();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzz());
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzx());
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzc() {
        return this.zzg - this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zza(int i) throws zzkp {
        if (i < 0) {
            throw zzkp.zzf();
        }
        int zzc = i + zzc();
        if (zzc < 0) {
            throw zzkp.zzg();
        }
        int i2 = this.zzj;
        if (zzc > i2) {
            throw zzkp.zzi();
        }
        this.zzj = zzc;
        zzab();
        return i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzd() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zze() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzf() throws IOException {
        return zzy();
    }

    private final int zzx() throws IOException {
        int i = this.zzg;
        if (this.zze - i < 4) {
            throw zzkp.zzi();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r2[r3] >= 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzy() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzg
            int r1 = r5.zze
            if (r1 == r0) goto L6b
            byte[] r2 = r5.zzd
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.zzg = r3
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
            r5.zzg = r1
            return r0
        L6b:
            long r0 = r5.zzm()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjj.zzy():int");
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzg() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzh() throws IOException {
        return zze(zzy());
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzi() throws IOException {
        if (zzt()) {
            this.zzi = 0;
            return 0;
        }
        int zzy = zzy();
        this.zzi = zzy;
        if ((zzy >>> 3) != 0) {
            return zzy;
        }
        throw zzkp.zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final int zzj() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final long zzk() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final long zzl() throws IOException {
        return zzaa();
    }

    private final long zzz() throws IOException {
        int i = this.zzg;
        if (this.zze - i < 8) {
            throw zzkp.zzi();
        }
        byte[] bArr = this.zzd;
        this.zzg = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
        if (r2[r0] >= 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zzaa() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 189
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjj.zzaa():long");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjk
    public final long zzm() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzw = zzw();
            j |= (zzw & Byte.MAX_VALUE) << i;
            if ((zzw & 128) == 0) {
                return j;
            }
        }
        throw zzkp.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final long zzn() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final long zzo() throws IOException {
        return zza(zzaa());
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final long zzp() throws IOException {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final zziy zzq() throws IOException {
        byte[] bArr;
        int zzy = zzy();
        if (zzy > 0) {
            int i = this.zze;
            int i2 = this.zzg;
            if (zzy <= i - i2) {
                zziy zza = zziy.zza(this.zzd, i2, zzy);
                this.zzg += zzy;
                return zza;
            }
        }
        if (zzy == 0) {
            return zziy.zza;
        }
        if (zzy > 0) {
            int i3 = this.zze;
            int i4 = this.zzg;
            if (zzy <= i3 - i4) {
                int i5 = zzy + i4;
                this.zzg = i5;
                bArr = Arrays.copyOfRange(this.zzd, i4, i5);
                return zziy.zzb(bArr);
            }
        }
        if (zzy <= 0) {
            if (zzy == 0) {
                bArr = zzkj.zzb;
                return zziy.zzb(bArr);
            }
            throw zzkp.zzf();
        }
        throw zzkp.zzi();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final String zzr() throws IOException {
        int zzy = zzy();
        if (zzy > 0 && zzy <= this.zze - this.zzg) {
            String str = new String(this.zzd, this.zzg, zzy, zzkj.zza);
            this.zzg += zzy;
            return str;
        } else if (zzy == 0) {
            return "";
        } else {
            if (zzy < 0) {
                throw zzkp.zzf();
            }
            throw zzkp.zzi();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final String zzs() throws IOException {
        int zzy = zzy();
        if (zzy > 0) {
            int i = this.zze;
            int i2 = this.zzg;
            if (zzy <= i - i2) {
                String zzb = zzna.zzb(this.zzd, i2, zzy);
                this.zzg += zzy;
                return zzb;
            }
        }
        if (zzy == 0) {
            return "";
        }
        if (zzy <= 0) {
            throw zzkp.zzf();
        }
        throw zzkp.zzi();
    }

    private zzjj(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzj = Integer.MAX_VALUE;
        this.zzd = bArr;
        this.zze = i2 + i;
        this.zzg = i;
        this.zzh = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final void zzb(int i) throws zzkp {
        if (this.zzi != i) {
            throw zzkp.zzb();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final void zzc(int i) {
        this.zzj = i;
        zzab();
    }

    private final void zzab() {
        int i = this.zze + this.zzf;
        this.zze = i;
        int i2 = i - this.zzh;
        int i3 = this.zzj;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzf = i4;
            this.zze = i - i4;
            return;
        }
        this.zzf = 0;
    }

    private final void zzf(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zze;
            int i3 = this.zzg;
            if (i <= i2 - i3) {
                this.zzg = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzkp.zzf();
        }
        throw zzkp.zzi();
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zzt() throws IOException {
        return this.zzg == this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zzu() throws IOException {
        return zzaa() != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zzd(int i) throws IOException {
        boolean zzd;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zze - this.zzg >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzd;
                    int i4 = this.zzg;
                    this.zzg = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzkp.zze();
            }
            while (i3 < 10) {
                if (zzw() < 0) {
                    i3++;
                }
            }
            throw zzkp.zze();
            return true;
        } else if (i2 == 1) {
            zzf(8);
            return true;
        } else if (i2 == 2) {
            zzf(zzy());
            return true;
        } else if (i2 != 3) {
            if (i2 == 4) {
                if (this.zzb == 0) {
                    zzb(0);
                }
                return false;
            } else if (i2 == 5) {
                zzf(4);
                return true;
            } else {
                throw zzkp.zza();
            }
        } else {
            do {
                int zzi = zzi();
                if (zzi == 0) {
                    break;
                }
                zzv();
                this.zzb++;
                zzd = zzd(zzi);
                this.zzb--;
            } while (zzd);
            zzb(((i >>> 3) << 3) | 4);
            return true;
        }
    }
}
