package com.appsflyer.internal;

import android.content.Intent;
import android.os.Parcelable;
import com.appsflyer.AFLogger;
import java.util.ConcurrentModificationException;
import kotlin.Result;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
/* loaded from: classes.dex */
public final class AFj1kSDK {
    final Intent getCurrencyIso4217Code;

    public AFj1kSDK(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        this.getCurrencyIso4217Code = intent;
    }

    public final <T extends Parcelable> T H_(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return (T) AFAdRevenueData(new Function0<T>() { // from class: com.appsflyer.internal.AFj1kSDK.4
            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: J_ */
            public final Parcelable invoke() {
                return AFj1kSDK.this.getCurrencyIso4217Code.getParcelableExtra(str);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }
        }, "Error while trying to read " + str + " extra from intent", null, true);
    }

    public final String getCurrencyIso4217Code(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return (String) AFAdRevenueData(new Function0<String>() { // from class: com.appsflyer.internal.AFj1kSDK.3
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: getMediationNetwork */
            public final String invoke() {
                return AFj1kSDK.this.getCurrencyIso4217Code.getStringExtra(str);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }
        }, "Error while trying to read " + str + " extra from intent", null, true);
    }

    public final boolean getRevenue(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Boolean bool = (Boolean) AFAdRevenueData(new Function0<Boolean>() { // from class: com.appsflyer.internal.AFj1kSDK.1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: getMonetizationNetwork */
            public final Boolean invoke() {
                return Boolean.valueOf(AFj1kSDK.this.getCurrencyIso4217Code.hasExtra(str));
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }
        }, "Error while trying to check presence of " + str + " extra from intent", Boolean.TRUE, true);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final Intent I_(final String str, final long j) {
        Intrinsics.checkNotNullParameter(str, "");
        return (Intent) AFAdRevenueData(new Function0<Intent>() { // from class: com.appsflyer.internal.AFj1kSDK.2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: K_ */
            public final Intent invoke() {
                return AFj1kSDK.this.getCurrencyIso4217Code.putExtra(str, j);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }
        }, "Error while trying to write " + str + " extra to intent", null, true);
    }

    private final <T> T AFAdRevenueData(Function0<? extends T> function0, String str, T t, boolean z) {
        Object obj;
        synchronized (this.getCurrencyIso4217Code) {
            try {
                Result.Companion companion = Result.Companion;
                AFj1kSDK aFj1kSDK = this;
                Object m539constructorimpl = Result.m539constructorimpl(function0.invoke());
                KClass[] kClassArr = {Reflection.getOrCreateKotlinClass(ConcurrentModificationException.class), Reflection.getOrCreateKotlinClass(ArrayIndexOutOfBoundsException.class)};
                Throwable m542exceptionOrNullimpl = Result.m542exceptionOrNullimpl(m539constructorimpl);
                if (m542exceptionOrNullimpl != null) {
                    Result.Companion companion2 = Result.Companion;
                    if (ArraysKt.contains(kClassArr, Reflection.getOrCreateKotlinClass(m542exceptionOrNullimpl.getClass()))) {
                        if (z) {
                            obj = AFAdRevenueData(function0, str, t, false);
                        } else {
                            AFLogger.afErrorLog(str, m542exceptionOrNullimpl, false, false);
                            obj = t;
                        }
                        m539constructorimpl = Result.m539constructorimpl(obj);
                    } else {
                        throw m542exceptionOrNullimpl;
                    }
                }
                Throwable m542exceptionOrNullimpl2 = Result.m542exceptionOrNullimpl(m539constructorimpl);
                if (m542exceptionOrNullimpl2 == null) {
                    t = m539constructorimpl;
                } else {
                    AFLogger.afErrorLog(str, m542exceptionOrNullimpl2, false, false);
                }
            }
        }
        return t;
    }
}
