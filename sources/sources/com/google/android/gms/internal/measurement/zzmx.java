package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzmx {
    private static final zzmx zza = new zzmx(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public final int zza() {
        int zze;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                zze = zzjn.zze(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                zze = zzjn.zza(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 2) {
                zze = zzjn.zza(i5, (zziy) this.zzd[i3]);
            } else if (i6 == 3) {
                zze = (zzjn.zzf(i5) << 1) + ((zzmx) this.zzd[i3]).zza();
            } else if (i6 == 5) {
                zze = zzjn.zzb(i5, ((Integer) this.zzd[i3]).intValue());
            } else {
                throw new IllegalStateException(zzkp.zza());
            }
            i2 += zze;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzjn.zzb(this.zzc[i3] >>> 3, (zziy) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public static zzmx zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzmx zza(zzmx zzmxVar) {
        if (zzmxVar.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzmxVar.zzb;
        zza(i);
        System.arraycopy(zzmxVar.zzc, 0, this.zzc, this.zzb, zzmxVar.zzb);
        System.arraycopy(zzmxVar.zzd, 0, this.zzd, this.zzb, zzmxVar.zzb);
        this.zzb = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmx zza(zzmx zzmxVar, zzmx zzmxVar2) {
        int i = zzmxVar.zzb + zzmxVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzmxVar.zzc, i);
        System.arraycopy(zzmxVar2.zzc, 0, copyOf, zzmxVar.zzb, zzmxVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzmxVar.zzd, i);
        System.arraycopy(zzmxVar2.zzd, 0, copyOf2, zzmxVar.zzb, zzmxVar2.zzb);
        return new zzmx(i, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmx zzd() {
        return new zzmx();
    }

    private zzmx() {
        this(0, new int[8], new Object[8], true);
    }

    private zzmx(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    private final void zza(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzlr.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zznl zznlVar) throws IOException {
        if (zznlVar.zza() == 2) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zznlVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zznlVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zznl zznlVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zznlVar.zzb(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zznlVar.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zznlVar.zza(i2, (zziy) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zznlVar.zzb(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzkp.zza());
        } else if (zznlVar.zza() == 1) {
            zznlVar.zzb(i2);
            ((zzmx) obj).zzb(zznlVar);
            zznlVar.zza(i2);
        } else {
            zznlVar.zza(i2);
            ((zzmx) obj).zzb(zznlVar);
            zznlVar.zzb(i2);
        }
    }

    public final void zzb(zznl zznlVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zznlVar.zza() == 1) {
            for (int i = 0; i < this.zzb; i++) {
                zza(this.zzc[i], this.zzd[i], zznlVar);
            }
            return;
        }
        for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
            zza(this.zzc[i2], this.zzd[i2], zznlVar);
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzmx)) {
            zzmx zzmxVar = (zzmx) obj;
            int i = this.zzb;
            if (i == zzmxVar.zzb) {
                int[] iArr = this.zzc;
                int[] iArr2 = zzmxVar.zzc;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        z = true;
                        break;
                    } else if (iArr[i2] != iArr2[i2]) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzmxVar.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= i3) {
                            z2 = true;
                            break;
                        } else if (!objArr[i4].equals(objArr2[i4])) {
                            z2 = false;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (z2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
