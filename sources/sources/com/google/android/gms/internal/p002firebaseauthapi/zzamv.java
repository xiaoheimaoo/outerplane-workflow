package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamv  reason: invalid package */
/* loaded from: classes2.dex */
abstract class zzamv<T, B> {
    private static volatile int zza = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(T t);

    abstract B zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zza(T t, T t2);

    abstract void zza(B b, int i, int i2);

    abstract void zza(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zzaiw zzaiwVar);

    abstract void zza(B b, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(T t, zzanm zzanmVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zza(zzamd zzamdVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzb(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(T t, zzanm zzanmVar) throws IOException;

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
    public final boolean zza(B b, zzamd zzamdVar, int i) throws IOException {
        int zzd = zzamdVar.zzd();
        int i2 = zzd >>> 3;
        int i3 = zzd & 7;
        if (i3 == 0) {
            zzb(b, i2, zzamdVar.zzl());
            return true;
        } else if (i3 == 1) {
            zza((zzamv<T, B>) b, i2, zzamdVar.zzk());
            return true;
        } else if (i3 == 2) {
            zza((zzamv<T, B>) b, i2, zzamdVar.zzp());
            return true;
        } else if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                throw zzakm.zzb();
            } else if (i3 == 5) {
                zza((zzamv<T, B>) b, i2, zzamdVar.zzf());
                return true;
            } else {
                throw zzakm.zza();
            }
        } else {
            B zza2 = zza();
            int i4 = 4 | (i2 << 3);
            int i5 = i + 1;
            if (i5 >= zza) {
                throw zzakm.zzh();
            }
            while (zzamdVar.zzc() != Integer.MAX_VALUE && zza((zzamv<T, B>) zza2, zzamdVar, i5)) {
            }
            if (i4 != zzamdVar.zzd()) {
                throw zzakm.zzb();
            }
            zza((zzamv<T, B>) b, i2, (int) zze(zza2));
            return true;
        }
    }
}
