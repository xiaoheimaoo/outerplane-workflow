package com.google.android.recaptcha.internal;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzhj implements zzgx {
    public static final zzhj zza = new zzhj();

    private zzhj() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        int length = zzueVarArr.length;
        if (length != 0) {
            Constructor<?> zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 == null) {
                throw new zzce(4, 5, null);
            }
            Constructor<?> constructor = zza2 instanceof Constructor ? zza2 : zza2.getClass().getConstructor(new Class[0]);
            Object[] zzg = zzgdVar.zzc().zzg(ArraysKt.toList(zzueVarArr).subList(1, length));
            try {
                zzgdVar.zzc().zze(i, constructor.newInstance(Arrays.copyOf(zzg, zzg.length)));
                return;
            } catch (Exception e) {
                throw new zzce(6, 14, e);
            }
        }
        throw new zzce(4, 3, null);
    }
}
