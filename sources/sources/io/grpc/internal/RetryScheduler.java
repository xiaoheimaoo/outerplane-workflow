package io.grpc.internal;
/* loaded from: classes3.dex */
public interface RetryScheduler {
    void reset();

    void schedule(Runnable runnable);
}
