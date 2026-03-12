package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzald implements zzakr {
    private static final byte[] zza = {0, 7, 8, Ascii.SI};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzakw zzg;
    private final zzakv zzh;
    private final zzalc zzi;
    private Bitmap zzj;

    public zzald(List list) {
        zzfp zzfpVar = new zzfp((byte[]) list.get(0));
        int zzq = zzfpVar.zzq();
        int zzq2 = zzfpVar.zzq();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzakw(719, 575, 0, 719, 0, 575);
        this.zzh = new zzakv(0, zzg(), zzh(), zzi());
        this.zzi = new zzalc(zzq, zzq2);
    }

    private static int zzb(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static zzakv zzc(zzfo zzfoVar, int i) {
        int zzd;
        int i2;
        int zzd2;
        int zzd3;
        int i3 = 8;
        int zzd4 = zzfoVar.zzd(8);
        zzfoVar.zzm(8);
        int[] zzg = zzg();
        int[] zzh = zzh();
        int[] zzi = zzi();
        int i4 = i - 2;
        while (i4 > 0) {
            int zzd5 = zzfoVar.zzd(i3);
            int zzd6 = zzfoVar.zzd(i3);
            int i5 = i4 - 2;
            int[] iArr = (zzd6 & 128) != 0 ? zzg : (zzd6 & 64) != 0 ? zzh : zzi;
            if ((zzd6 & 1) != 0) {
                zzd2 = zzfoVar.zzd(i3);
                zzd3 = zzfoVar.zzd(i3);
                zzd = zzfoVar.zzd(i3);
                i2 = zzfoVar.zzd(i3);
                i4 = i5 - 4;
            } else {
                int zzd7 = zzfoVar.zzd(2) << 6;
                i4 = i5 - 2;
                zzd = zzfoVar.zzd(4) << 4;
                i2 = zzd7;
                zzd2 = zzfoVar.zzd(6) << 2;
                zzd3 = zzfoVar.zzd(4) << 4;
            }
            if (zzd2 == 0) {
                i2 = 255;
            }
            if (zzd2 == 0) {
                zzd = 0;
            }
            if (zzd2 == 0) {
                zzd3 = 0;
            }
            double d = zzd2;
            double d2 = zzd3 - 128;
            double d3 = zzd - 128;
            iArr[zzd5] = zzb((byte) (255 - (i2 & 255)), Math.max(0, Math.min((int) (d + (1.402d * d2)), 255)), Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)), Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255)));
            zzd4 = zzd4;
            i3 = 8;
        }
        return new zzakv(zzd4, zzg, zzh, zzi);
    }

    private static zzakx zzd(zzfo zzfoVar) {
        int zzd = zzfoVar.zzd(16);
        zzfoVar.zzm(4);
        int zzd2 = zzfoVar.zzd(2);
        boolean zzo = zzfoVar.zzo();
        zzfoVar.zzm(1);
        byte[] bArr = zzfy.zzf;
        byte[] bArr2 = zzfy.zzf;
        if (zzd2 == 1) {
            zzfoVar.zzm(zzfoVar.zzd(8) * 16);
        } else if (zzd2 == 0) {
            int zzd3 = zzfoVar.zzd(16);
            int zzd4 = zzfoVar.zzd(16);
            if (zzd3 > 0) {
                bArr = new byte[zzd3];
                zzfoVar.zzh(bArr, 0, zzd3);
            }
            if (zzd4 > 0) {
                bArr2 = new byte[zzd4];
                zzfoVar.zzh(bArr2, 0, zzd4);
            } else {
                bArr2 = bArr;
            }
        }
        return new zzakx(zzd, zzo, bArr, bArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01ef A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0228 A[LOOP:3: B:88:0x0172->B:119:0x0228, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0222 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0181  */
    /* JADX WARN: Type inference failed for: r2v28 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zze(byte[] r24, int[] r25, int r26, int r27, int r28, android.graphics.Paint r29, android.graphics.Canvas r30) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzald.zze(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] zzf(int i, int i2, zzfo zzfoVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) zzfoVar.zzd(i2);
        }
        return bArr;
    }

    private static int[] zzg() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] zzh() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            int i2 = i & 4;
            int i3 = i & 2;
            int i4 = i & 1;
            if (i < 8) {
                iArr[i] = zzb(255, 1 != i4 ? 0 : 255, i3 != 0 ? 255 : 0, i2 != 0 ? 255 : 0);
            } else {
                int i5 = WorkQueueKt.MASK;
                int i6 = 1 != i4 ? 0 : 127;
                int i7 = i3 != 0 ? 127 : 0;
                if (i2 == 0) {
                    i5 = 0;
                }
                iArr[i] = zzb(255, i6, i7, i5);
            }
        }
        return iArr;
    }

    private static int[] zzi() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = zzb(63, 1 != (i & 1) ? 0 : 255, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i2 = i & ModuleDescriptor.MODULE_VERSION;
                if (i2 == 0) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 8) {
                    iArr[i] = zzb(WorkQueueKt.MASK, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 128) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 43) + WorkQueueKt.MASK + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + WorkQueueKt.MASK + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + WorkQueueKt.MASK + ((i & 64) == 0 ? 0 : 85));
                } else if (i2 == 136) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 43) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i, int i2, zzakq zzakqVar, zzep zzepVar) {
        zzakj zzakjVar;
        char c;
        char c2;
        int i3;
        SparseArray sparseArray;
        int i4;
        SparseArray sparseArray2;
        int[] iArr;
        zzala zzalaVar;
        int i5;
        int zzd;
        int zzd2;
        int i6;
        int i7;
        int i8;
        int i9;
        zzfo zzfoVar = new zzfo(bArr, i + i2);
        zzfoVar.zzk(i);
        while (zzfoVar.zza() >= 48 && zzfoVar.zzd(8) == 15) {
            zzalc zzalcVar = this.zzi;
            int zzd3 = zzfoVar.zzd(8);
            int zzd4 = zzfoVar.zzd(16);
            int zzd5 = zzfoVar.zzd(16);
            int zzb2 = zzfoVar.zzb() + zzd5;
            if (zzd5 * 8 > zzfoVar.zza()) {
                zzff.zzf("DvbParser", "Data field length exceeds limit");
                zzfoVar.zzm(zzfoVar.zza());
            } else {
                switch (zzd3) {
                    case 16:
                        if (zzd4 == zzalcVar.zza) {
                            zzaky zzakyVar = zzalcVar.zzi;
                            int zzd6 = zzfoVar.zzd(8);
                            int zzd7 = zzfoVar.zzd(4);
                            int zzd8 = zzfoVar.zzd(2);
                            zzfoVar.zzm(2);
                            SparseArray sparseArray3 = new SparseArray();
                            for (int i10 = zzd5 - 2; i10 > 0; i10 -= 6) {
                                int zzd9 = zzfoVar.zzd(8);
                                zzfoVar.zzm(8);
                                sparseArray3.put(zzd9, new zzakz(zzfoVar.zzd(16), zzfoVar.zzd(16)));
                            }
                            zzaky zzakyVar2 = new zzaky(zzd6, zzd7, zzd8, sparseArray3);
                            if (zzakyVar2.zzb != 0) {
                                zzalcVar.zzi = zzakyVar2;
                                zzalcVar.zzc.clear();
                                zzalcVar.zzd.clear();
                                zzalcVar.zze.clear();
                                break;
                            } else if (zzakyVar != null) {
                                if (zzakyVar.zza != zzakyVar2.zza) {
                                    zzalcVar.zzi = zzakyVar2;
                                    break;
                                }
                            }
                        }
                        break;
                    case 17:
                        zzaky zzakyVar3 = zzalcVar.zzi;
                        if (zzd4 == zzalcVar.zza && zzakyVar3 != null) {
                            int zzd10 = zzfoVar.zzd(8);
                            zzfoVar.zzm(4);
                            boolean zzo = zzfoVar.zzo();
                            zzfoVar.zzm(3);
                            int zzd11 = zzfoVar.zzd(16);
                            int zzd12 = zzfoVar.zzd(16);
                            int zzd13 = zzfoVar.zzd(3);
                            int zzd14 = zzfoVar.zzd(3);
                            zzfoVar.zzm(2);
                            int zzd15 = zzfoVar.zzd(8);
                            int zzd16 = zzfoVar.zzd(8);
                            int zzd17 = zzfoVar.zzd(4);
                            int zzd18 = zzfoVar.zzd(2);
                            zzfoVar.zzm(2);
                            int i11 = zzd5 - 10;
                            SparseArray sparseArray4 = new SparseArray();
                            while (i11 > 0) {
                                int zzd19 = zzfoVar.zzd(16);
                                int zzd20 = zzfoVar.zzd(2);
                                int zzd21 = zzfoVar.zzd(2);
                                int zzd22 = zzfoVar.zzd(12);
                                zzfoVar.zzm(4);
                                int zzd23 = zzfoVar.zzd(12);
                                i11 -= 6;
                                if (zzd20 != 1) {
                                    if (zzd20 == 2) {
                                        zzd20 = 2;
                                    } else {
                                        i5 = zzd20;
                                        zzd = 0;
                                        zzd2 = 0;
                                        sparseArray4.put(zzd19, new zzalb(i5, zzd21, zzd22, zzd23, zzd, zzd2));
                                    }
                                }
                                i11 -= 2;
                                i5 = zzd20;
                                zzd = zzfoVar.zzd(8);
                                zzd2 = zzfoVar.zzd(8);
                                sparseArray4.put(zzd19, new zzalb(i5, zzd21, zzd22, zzd23, zzd, zzd2));
                            }
                            zzala zzalaVar2 = new zzala(zzd10, zzo, zzd11, zzd12, zzd13, zzd14, zzd15, zzd16, zzd17, zzd18, sparseArray4);
                            if (zzakyVar3.zzb == 0 && (zzalaVar = (zzala) zzalcVar.zzc.get(zzalaVar2.zza)) != null) {
                                int i12 = 0;
                                while (true) {
                                    SparseArray sparseArray5 = zzalaVar.zzj;
                                    if (i12 < sparseArray5.size()) {
                                        zzalaVar2.zzj.put(sparseArray5.keyAt(i12), (zzalb) sparseArray5.valueAt(i12));
                                        i12++;
                                    }
                                }
                            }
                            zzalcVar.zzc.put(zzalaVar2.zza, zzalaVar2);
                            break;
                        }
                        break;
                    case 18:
                        if (zzd4 == zzalcVar.zza) {
                            zzakv zzc2 = zzc(zzfoVar, zzd5);
                            zzalcVar.zzd.put(zzc2.zza, zzc2);
                            break;
                        } else if (zzd4 == zzalcVar.zzb) {
                            zzakv zzc3 = zzc(zzfoVar, zzd5);
                            zzalcVar.zzf.put(zzc3.zza, zzc3);
                            break;
                        }
                        break;
                    case 19:
                        if (zzd4 == zzalcVar.zza) {
                            zzakx zzd24 = zzd(zzfoVar);
                            zzalcVar.zze.put(zzd24.zza, zzd24);
                            break;
                        } else if (zzd4 == zzalcVar.zzb) {
                            zzakx zzd25 = zzd(zzfoVar);
                            zzalcVar.zzg.put(zzd25.zza, zzd25);
                            break;
                        }
                        break;
                    case 20:
                        if (zzd4 == zzalcVar.zza) {
                            zzfoVar.zzm(4);
                            boolean zzo2 = zzfoVar.zzo();
                            zzfoVar.zzm(3);
                            int zzd26 = zzfoVar.zzd(16);
                            int zzd27 = zzfoVar.zzd(16);
                            if (zzo2) {
                                int zzd28 = zzfoVar.zzd(16);
                                i6 = zzfoVar.zzd(16);
                                i9 = zzfoVar.zzd(16);
                                i7 = zzfoVar.zzd(16);
                                i8 = zzd28;
                            } else {
                                i6 = zzd26;
                                i7 = zzd27;
                                i8 = 0;
                                i9 = 0;
                            }
                            zzalcVar.zzh = new zzakw(zzd26, zzd27, i8, i6, i9, i7);
                            break;
                        }
                        break;
                }
                zzfoVar.zzn(zzb2 - zzfoVar.zzb());
            }
        }
        zzalc zzalcVar2 = this.zzi;
        zzaky zzakyVar4 = zzalcVar2.zzi;
        if (zzakyVar4 == null) {
            zzakjVar = new zzakj(zzgaa.zzl(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzakw zzakwVar = zzalcVar2.zzh;
            if (zzakwVar == null) {
                zzakwVar = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzakwVar.zza + 1 != bitmap.getWidth() || zzakwVar.zzb + 1 != this.zzj.getHeight()) {
                Bitmap createBitmap = Bitmap.createBitmap(zzakwVar.zza + 1, zzakwVar.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = createBitmap;
                this.zzf.setBitmap(createBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray6 = zzakyVar4.zzc;
            int i13 = 0;
            while (i13 < sparseArray6.size()) {
                this.zzf.save();
                zzakz zzakzVar = (zzakz) sparseArray6.valueAt(i13);
                zzala zzalaVar3 = (zzala) this.zzi.zzc.get(sparseArray6.keyAt(i13));
                int i14 = zzakzVar.zza + zzakwVar.zzc;
                int i15 = zzakzVar.zzb + zzakwVar.zze;
                this.zzf.clipRect(i14, i15, Math.min(zzalaVar3.zzc + i14, zzakwVar.zzd), Math.min(zzalaVar3.zzd + i15, zzakwVar.zzf));
                zzakv zzakvVar = (zzakv) this.zzi.zzd.get(zzalaVar3.zzf);
                if (zzakvVar == null) {
                    zzakvVar = (zzakv) this.zzi.zzf.get(zzalaVar3.zzf);
                    if (zzakvVar == null) {
                        zzakvVar = this.zzh;
                    }
                }
                SparseArray sparseArray7 = zzalaVar3.zzj;
                int i16 = 0;
                while (i16 < sparseArray7.size()) {
                    int keyAt = sparseArray7.keyAt(i16);
                    zzalb zzalbVar = (zzalb) sparseArray7.valueAt(i16);
                    zzakx zzakxVar = (zzakx) this.zzi.zze.get(keyAt);
                    if (zzakxVar == null) {
                        zzakxVar = (zzakx) this.zzi.zzg.get(keyAt);
                    }
                    if (zzakxVar != null) {
                        Paint paint = zzakxVar.zzb ? null : this.zzd;
                        int i17 = zzalaVar3.zze;
                        int i18 = zzalbVar.zza + i14;
                        int i19 = zzalbVar.zzb + i15;
                        sparseArray = sparseArray6;
                        Canvas canvas = this.zzf;
                        sparseArray2 = sparseArray7;
                        if (i17 == 3) {
                            iArr = zzakvVar.zzd;
                        } else if (i17 == 2) {
                            iArr = zzakvVar.zzc;
                        } else {
                            iArr = zzakvVar.zzb;
                        }
                        i4 = i13;
                        int[] iArr2 = iArr;
                        Paint paint2 = paint;
                        zze(zzakxVar.zzc, iArr2, i17, i18, i19, paint2, canvas);
                        zze(zzakxVar.zzd, iArr2, i17, i18, i19 + 1, paint2, canvas);
                    } else {
                        sparseArray = sparseArray6;
                        i4 = i13;
                        sparseArray2 = sparseArray7;
                    }
                    i16++;
                    sparseArray6 = sparseArray;
                    sparseArray7 = sparseArray2;
                    i13 = i4;
                }
                SparseArray sparseArray8 = sparseArray6;
                int i20 = i13;
                float f = i15;
                float f2 = i14;
                if (zzalaVar3.zzb) {
                    int i21 = zzalaVar3.zze;
                    c = 3;
                    if (i21 == 3) {
                        i3 = zzakvVar.zzd[zzalaVar3.zzg];
                        c2 = 2;
                    } else {
                        c2 = 2;
                        if (i21 == 2) {
                            i3 = zzakvVar.zzc[zzalaVar3.zzh];
                        } else {
                            i3 = zzakvVar.zzb[zzalaVar3.zzi];
                        }
                    }
                    this.zze.setColor(i3);
                    this.zzf.drawRect(f2, f, zzalaVar3.zzc + i14, zzalaVar3.zzd + i15, this.zze);
                } else {
                    c = 3;
                    c2 = 2;
                }
                zzea zzeaVar = new zzea();
                zzeaVar.zzc(Bitmap.createBitmap(this.zzj, i14, i15, zzalaVar3.zzc, zzalaVar3.zzd));
                zzeaVar.zzh(f2 / zzakwVar.zza);
                zzeaVar.zzi(0);
                zzeaVar.zze(f / zzakwVar.zzb, 0);
                zzeaVar.zzf(0);
                zzeaVar.zzk(zzalaVar3.zzc / zzakwVar.zza);
                zzeaVar.zzd(zzalaVar3.zzd / zzakwVar.zzb);
                arrayList.add(zzeaVar.zzp());
                this.zzf.drawColor(0, PorterDuff.Mode.CLEAR);
                this.zzf.restore();
                i13 = i20 + 1;
                sparseArray6 = sparseArray8;
            }
            zzakjVar = new zzakj(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzepVar.zza(zzakjVar);
    }
}
