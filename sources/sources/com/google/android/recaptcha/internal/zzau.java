package com.google.android.recaptcha.internal;

import java.util.Map;
import kotlin.jvm.functions.Function0;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzau {
    public static final zzav zza() {
        zzav zzavVar;
        Function0 function0;
        Map map;
        zzavVar = zzav.zzb;
        if (zzavVar == null) {
            function0 = zzav.zzd;
            zzav zzavVar2 = new zzav((Map) function0.invoke(), null);
            map = zzav.zzc;
            map.clear();
            zzav.zzb = zzavVar2;
            return zzavVar2;
        }
        return zzavVar;
    }
}
