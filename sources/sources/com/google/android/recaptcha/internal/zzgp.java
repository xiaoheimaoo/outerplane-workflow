package com.google.android.recaptcha.internal;

import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzgp implements zzgx {
    public static final zzgp zza = new zzgp();

    private zzgp() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        String joinToString$default;
        String str;
        if (zzueVarArr.length == 1) {
            Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 == null) {
                throw new zzce(4, 5, null);
            }
            if (zza2 instanceof int[]) {
                joinToString$default = ArraysKt.joinToString$default((int[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            } else {
                if (zza2 instanceof byte[]) {
                    str = new String((byte[]) zza2, Charsets.UTF_8);
                } else if (zza2 instanceof long[]) {
                    joinToString$default = ArraysKt.joinToString$default((long[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                } else if (zza2 instanceof short[]) {
                    joinToString$default = ArraysKt.joinToString$default((short[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                } else if (zza2 instanceof float[]) {
                    joinToString$default = ArraysKt.joinToString$default((float[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                } else if (zza2 instanceof double[]) {
                    joinToString$default = ArraysKt.joinToString$default((double[]) zza2, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                } else if (zza2 instanceof char[]) {
                    str = new String((char[]) zza2);
                } else if (zza2 instanceof Object[]) {
                    joinToString$default = ArraysKt.joinToString$default((Object[]) zza2, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                } else if (!(zza2 instanceof Collection)) {
                    throw new zzce(4, 5, null);
                } else {
                    joinToString$default = CollectionsKt.joinToString$default((Iterable) zza2, ",", "[", "]", 0, null, null, 56, null);
                }
                joinToString$default = str;
            }
            zzgdVar.zzc().zze(i, joinToString$default);
            return;
        }
        throw new zzce(4, 3, null);
    }
}
