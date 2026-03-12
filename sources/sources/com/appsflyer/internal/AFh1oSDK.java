package com.appsflyer.internal;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.appsflyer.migration.internal.MigrationDataProvider;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFh1oSDK implements AFh1qSDK {
    private Long AFAdRevenueData;
    private boolean component2;
    private boolean component4;
    private final AFc1pSDK getCurrencyIso4217Code;
    private final AFj1rSDK getMediationNetwork;
    private JSONObject getMonetizationNetwork;
    private Long getRevenue;

    public AFh1oSDK(AFc1pSDK aFc1pSDK, AFj1rSDK aFj1rSDK) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFj1rSDK, "");
        this.getCurrencyIso4217Code = aFc1pSDK;
        this.getMediationNetwork = aFj1rSDK;
    }

    @Override // com.appsflyer.internal.AFh1qSDK
    public final void AFAdRevenueData(AFh1jSDK aFh1jSDK) {
        Intrinsics.checkNotNullParameter(aFh1jSDK, "");
        JSONObject attributionData = MigrationDataProvider.getAttributionData();
        if (attributionData != null) {
            getCurrencyIso4217Code("attr", aFh1jSDK, attributionData);
            this.component4 = true;
        }
        MigrationDataProvider.clear();
    }

    @Override // com.appsflyer.internal.AFh1qSDK
    public final void getRevenue(AFh1jSDK aFh1jSDK) {
        Intrinsics.checkNotNullParameter(aFh1jSDK, "");
        JSONObject jSONObject = this.getMonetizationNetwork;
        if (jSONObject != null) {
            Intrinsics.checkNotNull(jSONObject);
            getCurrencyIso4217Code("attr", aFh1jSDK, jSONObject);
        } else {
            JSONObject revenue = getRevenue();
            if (revenue != null) {
                getCurrencyIso4217Code("attr", aFh1jSDK, revenue);
            }
        }
        MigrationDataProvider.clear();
    }

    @Override // com.appsflyer.internal.AFh1qSDK
    public final void getMonetizationNetwork(AFf1rSDK aFf1rSDK, Function0<Unit> function0) {
        JSONObject revenue;
        Intrinsics.checkNotNullParameter(aFf1rSDK, "");
        Intrinsics.checkNotNullParameter(function0, "");
        if (this.getCurrencyIso4217Code.getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0) == 1 && aFf1rSDK.getCurrencyIso4217Code == AFe1mSDK.CONVERSION && this.getMediationNetwork.getRevenue() && !getMediationNetwork() && (revenue = getRevenue()) != null) {
            this.getMonetizationNetwork = revenue;
            function0.invoke();
        }
    }

    private final JSONObject getRevenue() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject waitForAttributionData = MigrationDataProvider.waitForAttributionData(3000L);
        if (waitForAttributionData != null) {
            this.AFAdRevenueData = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        }
        return waitForAttributionData;
    }

    private final void getCurrencyIso4217Code(String str, AFh1jSDK aFh1jSDK, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, jSONObject);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("branch", hashMap);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("external", hashMap2);
        aFh1jSDK.getMonetizationNetwork(hashMap3);
        Map<String, Object> map = aFh1jSDK.getCurrencyIso4217Code;
        Intrinsics.checkNotNullExpressionValue(map, "");
        AFe1mSDK currencyIso4217Code = aFh1jSDK.getCurrencyIso4217Code();
        Intrinsics.checkNotNullExpressionValue(currencyIso4217Code, "");
        getRevenue(map, currencyIso4217Code);
    }

    private final void getRevenue(Map<String, Object> map, AFe1mSDK aFe1mSDK) {
        Long l;
        int i = AFa1uSDK.getCurrencyIso4217Code[aFe1mSDK.ordinal()];
        if (i == 1) {
            l = this.getRevenue;
        } else {
            l = i != 2 ? null : this.AFAdRevenueData;
        }
        if (l != null) {
            long longValue = l.longValue();
            Map<String, Object> monetizationNetwork = com.appsflyer.internal.AFa1uSDK.getMonetizationNetwork(map);
            Intrinsics.checkNotNullExpressionValue(monetizationNetwork, "");
            monetizationNetwork.put("migration", MapsKt.mapOf(TuplesKt.to("delay", Long.valueOf(longValue))));
        }
    }

    @Override // com.appsflyer.internal.AFh1qSDK
    public final boolean getMediationNetwork() {
        return this.component4;
    }

    @Override // com.appsflyer.internal.AFh1qSDK
    public final boolean getMonetizationNetwork() {
        return this.component2;
    }

    @Override // com.appsflyer.internal.AFh1qSDK
    public final void getCurrencyIso4217Code() {
        this.component2 = false;
        MigrationDataProvider.clear();
    }

    @Override // com.appsflyer.internal.AFh1qSDK
    public final void u_(Intent intent, AFa1rSDK aFa1rSDK) {
        Intrinsics.checkNotNullParameter(intent, "");
        Intrinsics.checkNotNullParameter(aFa1rSDK, "");
        if (MigrationDataProvider.waitForDeepLinkingData(0L) != null) {
            this.component2 = true;
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            return;
        }
        try {
            Object[] objArr = {data, aFa1rSDK};
            Object obj = AFa1jSDK.unregisterClient.get(228484367);
            if (obj == null) {
                obj = ((Class) AFa1jSDK.AFAdRevenueData(ViewConfiguration.getJumpTapTimeout() >> 16, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)), 37 - (Process.myPid() >> 22))).getDeclaredConstructor(Uri.class, AFa1rSDK.class);
                AFa1jSDK.unregisterClient.put(228484367, obj);
            }
            Object newInstance = ((Constructor) obj).newInstance(objArr);
            Object obj2 = AFa1jSDK.unregisterClient.get(-891849335);
            if (obj2 == null) {
                obj2 = ((Class) AFa1jSDK.AFAdRevenueData((-1) - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 37 - Color.argb(0, 0, 0, 0))).getMethod("getRevenue", null);
                AFa1jSDK.unregisterClient.put(-891849335, obj2);
            }
            Object invoke = ((Method) obj2).invoke(newInstance, null);
            Object obj3 = AFa1jSDK.unregisterClient.get(-1788381861);
            if (obj3 == null) {
                obj3 = ((Class) AFa1jSDK.AFAdRevenueData((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 37, (char) (39041 - (Process.myTid() >> 22)), (ViewConfiguration.getTouchSlop() >> 8) + 51)).getMethod("getRevenue", null);
                AFa1jSDK.unregisterClient.put(-1788381861, obj3);
            }
            this.component2 = !((Boolean) ((Method) obj3).invoke(invoke, null)).booleanValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // com.appsflyer.internal.AFh1qSDK
    public final void getMediationNetwork(AFh1jSDK aFh1jSDK) {
        Intrinsics.checkNotNullParameter(aFh1jSDK, "");
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject waitForDeepLinkingData = MigrationDataProvider.waitForDeepLinkingData(3000L);
        if (waitForDeepLinkingData != null) {
            this.getRevenue = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            getCurrencyIso4217Code("dl", aFh1jSDK, waitForDeepLinkingData);
        }
        MigrationDataProvider.clear();
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class AFa1uSDK {
        public static final /* synthetic */ int[] getCurrencyIso4217Code;

        static {
            int[] iArr = new int[AFe1mSDK.values().length];
            try {
                iArr[AFe1mSDK.LAUNCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AFe1mSDK.ATTR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            getCurrencyIso4217Code = iArr;
        }
    }
}
