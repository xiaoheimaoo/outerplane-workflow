package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzga extends zzfx {
    private final zzfz zza;
    private final String zzb;

    public zzga(zzfz zzfzVar, String str, Object obj) {
        super(obj);
        this.zza = zzfzVar;
        this.zzb = str;
    }

    @Override // com.google.android.recaptcha.internal.zzfx
    public final boolean zza(Object obj, Method method, Object[] objArr) {
        List emptyList;
        if (Intrinsics.areEqual(method.getName(), this.zzb)) {
            zzfz zzfzVar = this.zza;
            if (objArr == null || (emptyList = ArraysKt.asList(objArr)) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            zzfzVar.zzb(emptyList);
            return true;
        }
        return false;
    }
}
