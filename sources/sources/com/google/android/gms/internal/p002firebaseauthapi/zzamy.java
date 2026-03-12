package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamy  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzamy {
    private static final zzamy zza = new zzamy(0, new int[0], new Object[0], false);
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
                zze = zzajo.zze(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                zze = zzajo.zza(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 2) {
                zze = zzajo.zza(i5, (zzaiw) this.zzd[i3]);
            } else if (i6 == 3) {
                zze = (zzajo.zzg(i5) << 1) + ((zzamy) this.zzd[i3]).zza();
            } else if (i6 == 5) {
                zze = zzajo.zzb(i5, ((Integer) this.zzd[i3]).intValue());
            } else {
                throw new IllegalStateException(zzakm.zza());
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
            i2 += zzajo.zzb(this.zzc[i3] >>> 3, (zzaiw) this.zzd[i3]);
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

    public static zzamy zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzamy zza(zzamy zzamyVar) {
        if (zzamyVar.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzamyVar.zzb;
        zza(i);
        System.arraycopy(zzamyVar.zzc, 0, this.zzc, this.zzb, zzamyVar.zzb);
        System.arraycopy(zzamyVar.zzd, 0, this.zzd, this.zzb, zzamyVar.zzb);
        this.zzb = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzamy zza(zzamy zzamyVar, zzamy zzamyVar2) {
        int i = zzamyVar.zzb + zzamyVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzamyVar.zzc, i);
        System.arraycopy(zzamyVar2.zzc, 0, copyOf, zzamyVar.zzb, zzamyVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzamyVar.zzd, i);
        System.arraycopy(zzamyVar2.zzd, 0, copyOf2, zzamyVar.zzb, zzamyVar2.zzb);
        return new zzamy(i, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzamy zzd() {
        return new zzamy();
    }

    private zzamy() {
        this(0, new int[8], new Object[8], true);
    }

    private zzamy(int i, int[] iArr, Object[] objArr, boolean z) {
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
            zzalo.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
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
    public final void zza(zzanm zzanmVar) throws IOException {
        if (zzanmVar.zza() == 2) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzanmVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzanmVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zzanm zzanmVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzanmVar.zzb(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzanmVar.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzanmVar.zza(i2, (zzaiw) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzanmVar.zzb(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzakm.zza());
        } else if (zzanmVar.zza() == 1) {
            zzanmVar.zzb(i2);
            ((zzamy) obj).zzb(zzanmVar);
            zzanmVar.zza(i2);
        } else {
            zzanmVar.zza(i2);
            ((zzamy) obj).zzb(zzanmVar);
            zzanmVar.zzb(i2);
        }
    }

    public final void zzb(zzanm zzanmVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zzanmVar.zza() == 1) {
            for (int i = 0; i < this.zzb; i++) {
                zza(this.zzc[i], this.zzd[i], zzanmVar);
            }
            return;
        }
        for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
            zza(this.zzc[i2], this.zzd[i2], zzanmVar);
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzamy)) {
            zzamy zzamyVar = (zzamy) obj;
            int i = this.zzb;
            if (i == zzamyVar.zzb) {
                int[] iArr = this.zzc;
                int[] iArr2 = zzamyVar.zzc;
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
                    Object[] objArr2 = zzamyVar.zzd;
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
