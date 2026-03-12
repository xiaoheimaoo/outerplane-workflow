package com.google.android.recaptcha.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public abstract class zzfx implements InvocationHandler {
    private final Object zza;

    public zzfx(Object obj) {
        this.zza = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2;
        if (!Intrinsics.areEqual(method.getName(), "toString") || method.getParameterTypes().length != 0) {
            if (!Intrinsics.areEqual(method.getName(), "hashCode") || method.getParameterTypes().length != 0) {
                if (!Intrinsics.areEqual(method.getName(), "equals") || method.getParameterTypes().length == 0) {
                    if (zza(obj, method, objArr)) {
                        if ((this.zza == null && Intrinsics.areEqual(method.getReturnType(), Void.TYPE)) || ((obj2 = this.zza) != null && Intrinsics.areEqual(zzkm.zza(obj2.getClass()), zzkm.zza(method.getReturnType())))) {
                            Object obj3 = this.zza;
                            return obj3 == null ? Unit.INSTANCE : obj3;
                        }
                        Object obj4 = this.zza;
                        Class<?> returnType = method.getReturnType();
                        throw new IllegalArgumentException(obj4 + " cannot be returned from method with return type " + returnType);
                    }
                    return Unit.INSTANCE;
                }
                boolean z = false;
                if (objArr != null && objArr.length != 0) {
                    Object obj5 = objArr[0];
                    if ((obj5 != null ? obj5.hashCode() : 0) == obj.hashCode()) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
            return Integer.valueOf(System.identityHashCode(obj));
        }
        return "Proxy@".concat(String.valueOf(Integer.toHexString(obj.hashCode())));
    }

    public abstract boolean zza(Object obj, Method method, Object[] objArr);
}
