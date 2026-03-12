package com.unity3d.player;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class L implements InvocationHandler {
    private Runnable a;
    private UnityPlayer b;
    private long c;
    final /* synthetic */ long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(UnityPlayer unityPlayer, long j) {
        long j2;
        this.d = j;
        j2 = ReflectionHelper.b;
        this.a = new O(j2, j);
        this.b = unityPlayer;
        this.c = j2;
    }

    private static Object a(Object obj, Method method, Object[] objArr, N n) {
        long j;
        long j2;
        if (objArr == null) {
            try {
                try {
                    objArr = new Object[0];
                } catch (NoClassDefFoundError unused) {
                    AbstractC0121z.Log(6, String.format("Java interface default methods are only supported since Android Oreo", new Object[0]));
                    j2 = n.a;
                    ReflectionHelper.nativeProxyLogJNIInvokeException(j2);
                    n.a = 0L;
                    return null;
                }
            } finally {
                j = n.a;
                if (j != 0) {
                    ReflectionHelper.nativeProxyJNIFreeGCHandle(j);
                }
            }
        }
        Class<?> declaringClass = method.getDeclaringClass();
        Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
        declaredConstructor.setAccessible(true);
        return ((MethodHandles.Lookup) declaredConstructor.newInstance(declaringClass, 2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
    }

    protected void finalize() {
        this.b.queueGLThreadEvent(this.a);
        super.finalize();
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object nativeProxyInvoke;
        boolean z;
        long j;
        if (!ReflectionHelper.beginProxyCall(this.c)) {
            AbstractC0121z.Log(6, "Scripting proxy object was destroyed, because Unity player was unloaded.");
            return null;
        }
        try {
            nativeProxyInvoke = ReflectionHelper.nativeProxyInvoke(this.d, method.getName(), objArr);
            if (nativeProxyInvoke instanceof N) {
                N n = (N) nativeProxyInvoke;
                z = n.b;
                if (z && (method.getModifiers() & 1024) == 0) {
                    return a(obj, method, objArr, n);
                }
                j = n.a;
                ReflectionHelper.nativeProxyLogJNIInvokeException(j);
                return null;
            }
            return nativeProxyInvoke;
        } finally {
            ReflectionHelper.endProxyCall();
        }
    }
}
