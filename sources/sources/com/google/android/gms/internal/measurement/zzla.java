package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzla implements zzmh {
    private static final zzln zza = new zzld();
    private final zzln zzb;

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final <T> zzme<T> zza(Class<T> cls) {
        zzmg.zza((Class<?>) cls);
        zzlk zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            return zzls.zza(zzmg.zza(), zzjx.zza(), zza2.zza());
        }
        return zzlq.zza(cls, zza2, zzlw.zza(), zzky.zza(), zzmg.zza(), zzlc.zza[zza2.zzb().ordinal()] != 1 ? zzjx.zza() : null, zzll.zza());
    }

    public zzla() {
        this(new zzlf(zzke.zza(), zza));
    }

    private zzla(zzln zzlnVar) {
        this.zzb = (zzln) zzkj.zza(zzlnVar, "messageInfoFactory");
    }
}
