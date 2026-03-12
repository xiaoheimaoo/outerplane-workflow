package com.google.android.recaptcha.internal;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzhb implements zzgx {
    public static final zzhb zza = new zzhb();

    private zzhb() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        if (zzueVarArr.length == 2) {
            Class<?> zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 == null) {
                throw new zzce(4, 5, null);
            }
            Class<?> cls = zza2 instanceof Class ? zza2 : zza2.getClass();
            Object zza3 = zzgdVar.zzc().zza(zzueVarArr[1]);
            if (true != (zza3 instanceof String)) {
                zza3 = null;
            }
            String str = (String) zza3;
            if (str != null) {
                try {
                    zzgdVar.zzc().zze(i, cls.getField(zzgdVar.zzh().zza(str)));
                    return;
                } catch (Exception e) {
                    throw new zzce(6, 10, e);
                }
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 3, null);
    }
}
