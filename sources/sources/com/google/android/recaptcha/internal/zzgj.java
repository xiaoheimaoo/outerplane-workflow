package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzgj implements zzgx {
    public static final zzgj zza = new zzgj();

    private zzgj() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        if (zzueVarArr.length == 3) {
            Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != (zza2 instanceof Integer)) {
                zza2 = null;
            }
            Integer num = (Integer) zza2;
            if (num != null) {
                int intValue = num.intValue();
                if (intValue == 0) {
                    throw new zzce(4, 6, null);
                }
                Object zza3 = zzgdVar.zzc().zza(zzueVarArr[1]);
                if (true != (zza3 instanceof Object)) {
                    zza3 = null;
                }
                if (zza3 == null) {
                    throw new zzce(4, 5, null);
                }
                Object zza4 = zzgdVar.zzc().zza(zzueVarArr[2]);
                if (true != (zza4 instanceof Object)) {
                    zza4 = null;
                }
                if (zza4 == null) {
                    throw new zzce(4, 5, null);
                }
                if (Intrinsics.areEqual(zza3, zza4)) {
                    zzgdVar.zzg(zzgdVar.zza() + intValue);
                    return;
                }
                return;
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 3, null);
    }
}
