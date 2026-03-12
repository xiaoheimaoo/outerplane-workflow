package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzgv {
    private static zzgy zza;

    public static synchronized zzgy zza() {
        zzgy zzgyVar;
        synchronized (zzgv.class) {
            if (zza == null) {
                zza(new zzgx());
            }
            zzgyVar = zza;
        }
        return zzgyVar;
    }

    private static synchronized void zza(zzgy zzgyVar) {
        synchronized (zzgv.class) {
            if (zza != null) {
                throw new IllegalStateException("init() already called");
            }
            zza = zzgyVar;
        }
    }
}
