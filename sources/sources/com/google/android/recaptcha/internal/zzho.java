package com.google.android.recaptcha.internal;

import java.lang.reflect.Field;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzho implements zzgx {
    public static final zzho zza = new zzho();

    private zzho() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        if (zzueVarArr.length == 2) {
            Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != (zza2 instanceof Field)) {
                zza2 = null;
            }
            Field field = (Field) zza2;
            if (field == null) {
                throw new zzce(4, 5, null);
            }
            try {
                field.set(null, zzgdVar.zzc().zza(zzueVarArr[1]));
                return;
            } catch (Exception e) {
                throw new zzce(6, 11, e);
            }
        }
        throw new zzce(4, 3, null);
    }
}
