package com.appsflyer.internal;

import com.android.billingclient.BuildConfig;
import java.lang.reflect.Field;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFj1gSDK implements AFj1jSDK {
    @Override // com.appsflyer.internal.AFj1jSDK
    public final String getRevenue() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            AFj1gSDK aFj1gSDK = this;
            Field declaredField = BuildConfig.class.getDeclaredField("VERSION_NAME");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(null);
            Intrinsics.checkNotNull(obj2, "");
            obj = Result.m539constructorimpl((String) obj2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m539constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m545isFailureimpl(obj) ? "" : obj);
    }
}
