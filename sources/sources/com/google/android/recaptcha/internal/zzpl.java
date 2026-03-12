package com.google.android.recaptcha.internal;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public abstract class zzpl {
    private static volatile int zza = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object zza(Object obj);

    abstract Object zzb();

    abstract Object zzc(Object obj);

    abstract void zzd(Object obj, int i, int i2);

    abstract void zze(Object obj, int i, long j);

    abstract void zzf(Object obj, int i, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzg(Object obj, int i, zzle zzleVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzh(Object obj, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzi(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzj(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzk(Object obj, zzov zzovVar, int i) throws IOException {
        int zzd = zzovVar.zzd();
        int i2 = zzd >>> 3;
        int i3 = zzd & 7;
        if (i3 == 0) {
            zzh(obj, i2, zzovVar.zzl());
            return true;
        } else if (i3 == 1) {
            zze(obj, i2, zzovVar.zzk());
            return true;
        } else if (i3 == 2) {
            zzg(obj, i2, zzovVar.zzp());
            return true;
        } else if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    throw new zznm("Protocol message tag had invalid wire type.");
                }
                zzd(obj, i2, zzovVar.zzf());
                return true;
            }
            return false;
        } else {
            Object zzb = zzb();
            int i4 = i2 << 3;
            int i5 = i + 1;
            if (i5 >= zza) {
                throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            while (zzovVar.zzc() != Integer.MAX_VALUE && zzk(zzb, zzovVar, i5)) {
            }
            if ((i4 | 4) != zzovVar.zzd()) {
                throw new zznn("Protocol message end-group tag did not match expected tag.");
            }
            zzf(obj, i2, zzc(zzb));
            return true;
        }
    }
}
