package com.helpshift.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public interface HSThreader {
    AtomicBoolean submit(Runnable runnable);
}
