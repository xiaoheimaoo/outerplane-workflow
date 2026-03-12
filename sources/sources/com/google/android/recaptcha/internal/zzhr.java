package com.google.android.recaptcha.internal;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzhr implements zzgx {
    public static final zzhr zza = new zzhr();

    private zzhr() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        if (zzueVarArr.length == 2) {
            Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != (zza2 instanceof int[])) {
                zza2 = null;
            }
            int[] iArr = (int[]) zza2;
            if (iArr == null) {
                throw new zzce(4, 5, null);
            }
            Object zza3 = zzgdVar.zzc().zza(zzueVarArr[1]);
            if (true != (zza3 instanceof String)) {
                zza3 = null;
            }
            String str = (String) zza3;
            if (str != null) {
                zzge zzc = zzgdVar.zzc();
                StringBuilder sb = new StringBuilder();
                try {
                    for (int i2 : iArr) {
                        sb.append(str.charAt(i2));
                    }
                    zzc.zze(i, sb.toString());
                    return;
                } catch (Exception e) {
                    throw new zzce(4, 22, e);
                }
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 3, null);
    }
}
