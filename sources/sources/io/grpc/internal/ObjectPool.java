package io.grpc.internal;
/* loaded from: classes3.dex */
public interface ObjectPool<T> {
    T getObject();

    T returnObject(Object obj);
}
