package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayList;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzhq implements zzgx {
    public static final zzhq zza = new zzhq();

    private zzhq() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        Integer num;
        if (zzueVarArr.length == 2) {
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
            Integer num2 = (Integer) zza3;
            if (num2 != null) {
                int intValue = num2.intValue();
                if (zza2 instanceof Integer) {
                    num = Integer.valueOf(((Number) zza2).intValue() - intValue);
                } else if (zza2 instanceof int[]) {
                    int[] iArr = (int[]) zza2;
                    ArrayList arrayList = new ArrayList(iArr.length);
                    for (int i2 : iArr) {
                        arrayList.add(Integer.valueOf(i2 - intValue));
                    }
                    num = (Serializable) arrayList.toArray(new Integer[0]);
                } else {
                    throw new zzce(4, 5, null);
                }
                zzgdVar.zzc().zze(i, num);
                return;
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 3, null);
    }
}
