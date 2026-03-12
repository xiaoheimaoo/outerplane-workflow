package com.google.android.recaptcha.internal;

import kotlin.LazyKt;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzgc {
    public static final Class zza(Object obj) {
        Class cls;
        if (obj instanceof Class) {
            return (Class) obj;
        }
        if (obj instanceof Integer) {
            int intValue = ((Number) obj).intValue();
            if (intValue == 1) {
                cls = Integer.TYPE;
            } else if (intValue == 2) {
                cls = Short.TYPE;
            } else {
                cls = intValue == 3 ? Byte.TYPE : intValue == 4 ? Long.TYPE : intValue == 5 ? Character.TYPE : intValue == 6 ? Float.TYPE : intValue == 7 ? Double.TYPE : intValue == 8 ? Boolean.TYPE : null;
            }
            if (cls != null) {
                return cls;
            }
            throw new zzce(4, 6, null);
        } else if (obj instanceof String) {
            try {
                String str = (String) obj;
                Class<?> cls2 = Class.forName(str);
                int i = zzav.zza;
                if (((zzfu) LazyKt.lazy(zzgb.zza).getValue()).zzb(str)) {
                    return cls2;
                }
                throw new zzce(6, 47, null);
            } catch (Exception e) {
                throw new zzce(6, 8, e);
            }
        } else {
            throw new zzce(4, 5, null);
        }
    }
}
