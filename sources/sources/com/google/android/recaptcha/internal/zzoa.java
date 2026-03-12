package com.google.android.recaptcha.internal;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
final class zzoa implements zzox {
    private static final zzog zza = new zzny();
    private final zzog zzb;

    public zzoa() {
        zzog zzogVar = zza;
        int i = zzos.zza;
        zznz zznzVar = new zznz(zzmw.zza(), zzogVar);
        byte[] bArr = zznl.zzb;
        this.zzb = zznzVar;
    }

    @Override // com.google.android.recaptcha.internal.zzox
    public final zzow zza(Class cls) {
        int i = zzoy.zza;
        if (!zznd.class.isAssignableFrom(cls)) {
            int i2 = zzos.zza;
        }
        zzof zzb = this.zzb.zzb(cls);
        if (!zzb.zzb()) {
            int i3 = zzos.zza;
            return zzol.zzm(cls, zzb, zzop.zza(), zznw.zza(), zzoy.zzm(), zzb.zzc() + (-1) != 1 ? zzmr.zza() : null, zzoe.zza());
        }
        int i4 = zzos.zza;
        return zzom.zzc(zzoy.zzm(), zzmr.zza(), zzb.zza());
    }
}
