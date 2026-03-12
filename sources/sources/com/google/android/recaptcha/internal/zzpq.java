package com.google.android.recaptcha.internal;

import sun.misc.Unsafe;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
final class zzpq extends zzpr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpq(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zzc(Object obj, long j, boolean z) {
        if (zzps.zzb) {
            zzps.zzD(obj, j, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzps.zzE(obj, j, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zzd(Object obj, long j, byte b) {
        if (zzps.zzb) {
            zzps.zzD(obj, j, b);
        } else {
            zzps.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final boolean zzg(Object obj, long j) {
        if (zzps.zzb) {
            return zzps.zzt(obj, j);
        }
        return zzps.zzu(obj, j);
    }
}
