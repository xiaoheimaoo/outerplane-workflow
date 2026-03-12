package com.appsflyer.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B+\b\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\n\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\rR\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/appsflyer/internal/AFa1gSDK;", "", "", "", "p0", "Lcom/appsflyer/internal/AFa1hSDK;", "p1", "<init>", "(Ljava/util/Map;Lcom/appsflyer/internal/AFa1hSDK;)V", "", "getCurrencyIso4217Code", "(Ljava/lang/String;)Z", "", "(Ljava/lang/String;Ljava/lang/Object;)V", "AFAdRevenueData", "Ljava/util/Map;", "getMediationNetwork", "Lcom/appsflyer/internal/AFa1hSDK;", "getMonetizationNetwork", "AFa1vSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AFa1gSDK {
    public static final AFa1vSDK AFa1vSDK = new AFa1vSDK(null);
    final Map<String, Object> AFAdRevenueData;
    final AFa1hSDK getMediationNetwork;

    private AFa1gSDK(Map<String, Object> map, AFa1hSDK aFa1hSDK) {
        this.AFAdRevenueData = map;
        this.getMediationNetwork = aFa1hSDK;
    }

    /* synthetic */ AFa1gSDK(Map map, AFa1hSDK aFa1hSDK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i & 2) != 0 ? null : aFa1hSDK);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/appsflyer/internal/AFa1gSDK$AFa1vSDK;", "", "<init>", "()V", "Lcom/appsflyer/internal/AFh1jSDK;", "p0", "Lcom/appsflyer/internal/AFa1gSDK;", "getMediationNetwork", "(Lcom/appsflyer/internal/AFh1jSDK;)Lcom/appsflyer/internal/AFa1gSDK;", "Lcom/appsflyer/internal/AFa1hSDK;", "AFAdRevenueData", "(Lcom/appsflyer/internal/AFa1hSDK;)Lcom/appsflyer/internal/AFa1gSDK;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AFa1vSDK {
        private AFa1vSDK() {
        }

        @JvmStatic
        public static AFa1gSDK getMediationNetwork(AFh1jSDK aFh1jSDK) {
            Intrinsics.checkNotNullParameter(aFh1jSDK, "");
            Map<String, Object> map = aFh1jSDK.getCurrencyIso4217Code;
            Intrinsics.checkNotNullExpressionValue(map, "");
            return new AFa1gSDK(map, null, 2, null);
        }

        @JvmStatic
        public static AFa1gSDK AFAdRevenueData(AFa1hSDK aFa1hSDK) {
            Intrinsics.checkNotNullParameter(aFa1hSDK, "");
            return new AFa1gSDK(new LinkedHashMap(), aFa1hSDK, null);
        }

        public /* synthetic */ AFa1vSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void getCurrencyIso4217Code(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "");
        this.AFAdRevenueData.put(str, obj);
        AFa1hSDK aFa1hSDK = this.getMediationNetwork;
        if (aFa1hSDK != null) {
            aFa1hSDK.getMonetizationNetwork(this.AFAdRevenueData);
        }
    }

    public final boolean getCurrencyIso4217Code(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return this.AFAdRevenueData.containsKey(str);
    }

    public /* synthetic */ AFa1gSDK(Map map, AFa1hSDK aFa1hSDK, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, aFa1hSDK);
    }

    @JvmStatic
    public static final AFa1gSDK getMonetizationNetwork(AFa1hSDK aFa1hSDK) {
        return AFa1vSDK.AFAdRevenueData(aFa1hSDK);
    }

    @JvmStatic
    public static final AFa1gSDK AFAdRevenueData(AFh1jSDK aFh1jSDK) {
        return AFa1vSDK.getMediationNetwork(aFh1jSDK);
    }
}
