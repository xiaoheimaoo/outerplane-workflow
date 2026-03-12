package com.appsflyer.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFc1hSDK<T> {
    public final Function0<T> getRevenue;

    /* JADX WARN: Multi-variable type inference failed */
    public AFc1hSDK(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.getRevenue = function0;
    }
}
