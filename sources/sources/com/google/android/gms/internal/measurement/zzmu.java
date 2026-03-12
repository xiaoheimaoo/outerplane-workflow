package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
abstract class zzmu<T, B> {
    private static volatile int zza = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(T t);

    abstract B zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zza(T t, T t2);

    abstract void zza(B b, int i, int i2);

    abstract void zza(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zziy zziyVar);

    abstract void zza(B b, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(T t, zznl zznlVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zza(zzmf zzmfVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzb(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(T t, zznl zznlVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(Object obj, B b);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzc(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzd(Object obj);

    abstract T zze(B b);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzf(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(B b, zzmf zzmfVar, int i) throws IOException {
        int zzd = zzmfVar.zzd();
        int i2 = zzd >>> 3;
        int i3 = zzd & 7;
        if (i3 == 0) {
            zzb(b, i2, zzmfVar.zzl());
            return true;
        } else if (i3 == 1) {
            zza((zzmu<T, B>) b, i2, zzmfVar.zzk());
            return true;
        } else if (i3 == 2) {
            zza((zzmu<T, B>) b, i2, zzmfVar.zzp());
            return true;
        } else if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                throw zzkp.zzb();
            } else if (i3 == 5) {
                zza((zzmu<T, B>) b, i2, zzmfVar.zzf());
                return true;
            } else {
                throw zzkp.zza();
            }
        } else {
            B zza2 = zza();
            int i4 = 4 | (i2 << 3);
            int i5 = i + 1;
            if (i5 >= zza) {
                throw zzkp.zzh();
            }
            while (zzmfVar.zzc() != Integer.MAX_VALUE && zza((zzmu<T, B>) zza2, zzmfVar, i5)) {
            }
            if (i4 != zzmfVar.zzd()) {
                throw zzkp.zzb();
            }
            zza((zzmu<T, B>) b, i2, (int) zze(zza2));
            return true;
        }
    }
}
