package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzhf implements zzgx {
    public static final zzhf zza = new zzhf();

    private zzhf() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        int length = zzueVarArr.length;
        if (length >= 2) {
            Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != (zza2 instanceof Method)) {
                zza2 = null;
            }
            Method method = (Method) zza2;
            if (method == null) {
                throw new zzce(4, 5, null);
            }
            Object zza3 = zzgdVar.zzc().zza(zzueVarArr[1]);
            Object[] zzg = zzgdVar.zzc().zzg(ArraysKt.toList(zzueVarArr).subList(2, length));
            try {
                zzgdVar.zzc().zze(i, method.invoke(zza3, Arrays.copyOf(zzg, zzg.length)));
                return;
            } catch (Exception e) {
                throw new zzce(6, 15, e);
            }
        }
        throw new zzce(4, 3, null);
    }
}
