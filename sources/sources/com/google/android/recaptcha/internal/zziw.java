package com.google.android.recaptcha.internal;

import android.app.Application;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zziw extends Lambda implements Function0 {
    public static final zziw zza = new zziw();

    public zziw() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = zzav.zza;
        Object zzb = zzau.zza().zzb(Application.class.getName().hashCode());
        if (zzb == null) {
            throw new zzbd(zzbb.zzb, zzba.zzax, null);
        }
        return (Application) zzb;
    }
}
