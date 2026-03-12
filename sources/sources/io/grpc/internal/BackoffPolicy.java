package io.grpc.internal;
/* loaded from: classes3.dex */
public interface BackoffPolicy {

    /* loaded from: classes3.dex */
    public interface Provider {
        BackoffPolicy get();
    }

    long nextBackoffNanos();
}
