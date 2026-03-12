package com.google.android.recaptcha.internal;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzgl implements zzgx {
    public static final zzgl zza = new zzgl();

    private zzgl() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        if (zzueVarArr.length == 2) {
            Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != (zza2 instanceof String)) {
                zza2 = null;
            }
            String str = (String) zza2;
            if (str == null) {
                throw new zzce(4, 5, null);
            }
            Object zza3 = zzgdVar.zzc().zza(zzueVarArr[1]);
            if (zza3 == null) {
                throw new zzce(4, 4, null);
            }
            if ((zza3 instanceof Integer) || (zza3 instanceof Short) || (zza3 instanceof Byte) || (zza3 instanceof Long) || (zza3 instanceof Double) || (zza3 instanceof Float) || (zza3 instanceof Boolean) || (zza3 instanceof Character) || (zza3 instanceof String)) {
                zzgdVar.zzi().zzb(str, zza3.toString());
                return;
            }
            throw new zzce(4, 7, null);
        }
        throw new zzce(4, 3, null);
    }
}
