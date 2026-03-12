package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzgi implements zzgx {
    public static final zzgi zza = new zzgi();

    private zzgi() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        if (zzueVarArr.length != 3) {
            throw new zzce(4, 3, null);
        }
        Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
        if (true != (zza2 instanceof Object)) {
            zza2 = null;
        }
        if (zza2 == null) {
            throw new zzce(4, 5, null);
        }
        Object zza3 = zzgdVar.zzc().zza(zzueVarArr[1]);
        if (true != (zza3 instanceof Integer)) {
            zza3 = null;
        }
        Integer num = (Integer) zza3;
        if (num != null) {
            int intValue = num.intValue();
            Object zza4 = zzgdVar.zzc().zza(zzueVarArr[2]);
            if (true != (zza4 instanceof Object)) {
                zza4 = null;
            }
            if (zza4 != null) {
                try {
                    Array.set(zza2, intValue, zza4);
                    return;
                } catch (Exception e) {
                    if (!(e instanceof ArrayIndexOutOfBoundsException)) {
                        throw new zzce(4, 25, e);
                    }
                    throw new zzce(4, 22, e);
                }
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 5, null);
    }
}
