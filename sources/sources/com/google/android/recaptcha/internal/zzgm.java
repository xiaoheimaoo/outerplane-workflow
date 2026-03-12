package com.google.android.recaptcha.internal;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzgm implements zzgx {
    public static final zzgm zza = new zzgm();

    private zzgm() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        boolean z = true;
        if (zzueVarArr.length != 1) {
            throw new zzce(4, 3, null);
        }
        Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
        if (true != (zza2 instanceof Object)) {
            zza2 = null;
        }
        if (zza2 != null) {
            try {
                try {
                    if (zza2 instanceof String) {
                        zza2 = zzgdVar.zzh().zza((String) zza2);
                    }
                    zzge zzc = zzgdVar.zzc();
                    try {
                        zzgc.zza(zza2);
                    } catch (zzce e) {
                        if (e.zzb() != 8 && e.zzb() != 6) {
                            if (e.zzb() != 47) {
                                throw e;
                            }
                        }
                        z = false;
                    }
                    zzc.zze(i, Boolean.valueOf(z));
                    return;
                } catch (zzce e2) {
                    throw e2;
                }
            } catch (Exception e3) {
                throw new zzce(6, 8, e3);
            }
        }
        throw new zzce(4, 5, null);
    }
}
