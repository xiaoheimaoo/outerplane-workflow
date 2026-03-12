package com.appsflyer.internal;

import android.os.Build;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.singular.sdk.internal.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class AFe1gSDK extends AFe1eSDK<String> {
    private final AFe1mSDK areAllFieldsValid;
    private final Map<String, Object> copy;
    private final AFc1pSDK copydefault;
    private final AFc1oSDK equals;
    private final AFf1gSDK hashCode;
    private final AFg1rSDK toString;

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final AppsFlyerRequestListener areAllFieldsValid() {
        return null;
    }

    protected boolean component2() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final boolean copydefault() {
        return true;
    }

    public abstract AFd1jSDK<String> getMediationNetwork(Map<String, Object> map, String str, String str2);

    protected String getMediationNetwork(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return null;
    }

    protected String getMonetizationNetwork(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFe1gSDK(AFe1mSDK aFe1mSDK, AFe1mSDK[] aFe1mSDKArr, AFc1bSDK aFc1bSDK, String str, Map<String, ? extends Object> map) {
        super(aFe1mSDK, aFe1mSDKArr, aFc1bSDK, null);
        Intrinsics.checkNotNullParameter(aFe1mSDK, "");
        Intrinsics.checkNotNullParameter(aFe1mSDKArr, "");
        Intrinsics.checkNotNullParameter(aFc1bSDK, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.areAllFieldsValid = aFe1mSDK;
        this.copy = map;
        AFc1pSDK currencyIso4217Code = aFc1bSDK.getCurrencyIso4217Code();
        Intrinsics.checkNotNullExpressionValue(currencyIso4217Code, "");
        this.copydefault = currencyIso4217Code;
        AFc1oSDK component2 = aFc1bSDK.component2();
        Intrinsics.checkNotNullExpressionValue(component2, "");
        this.equals = component2;
        AFg1rSDK component4 = aFc1bSDK.component4();
        Intrinsics.checkNotNullExpressionValue(component4, "");
        this.toString = component4;
        AFf1gSDK force = aFc1bSDK.force();
        Intrinsics.checkNotNullExpressionValue(force, "");
        this.hashCode = force;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getMediationNetwork(Map<String, Object> map, String str) {
        Intrinsics.checkNotNullParameter(map, "");
        map.put("app_id", this.copydefault.getRevenue.getRevenue.getPackageName());
        String revenue = AFc1pSDK.getRevenue();
        if (revenue != null) {
            map.put("cuid", revenue);
        }
        map.put("app_version_name", this.copydefault.n_().versionName);
        if (component2()) {
            map.put("event_timestamp", Long.valueOf(this.toString.getCurrencyIso4217Code()));
        }
        if (str != null) {
            map.put("billing_lib_version", str);
        }
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final AFd1jSDK<String> getRevenue(String str) {
        AFd1dSDK aFd1dSDK;
        Intrinsics.checkNotNullParameter(str, "");
        Map<String, Object> mutableMap = MapsKt.toMutableMap(this.copy);
        String mediationNetwork = getMediationNetwork(mutableMap);
        String monetizationNetwork = getMonetizationNetwork(mutableMap);
        Map<String, Object> mutableMap2 = MapsKt.toMutableMap(mutableMap);
        getMediationNetwork(mutableMap2, mediationNetwork);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String component4 = this.copydefault.component4();
        String str2 = component4;
        boolean z = true;
        if (!(str2 == null || StringsKt.isBlank(str2))) {
            linkedHashMap.put(Constants.AMAZON_ADVERTISING_ID, component4);
        }
        AFb1mSDK currencyIso4217Code = AFb1kSDK.getCurrencyIso4217Code(this.copydefault.getRevenue.getRevenue);
        String str3 = null;
        String str4 = currencyIso4217Code != null ? currencyIso4217Code.getCurrencyIso4217Code : null;
        String str5 = str4;
        if (!(str5 == null || StringsKt.isBlank(str5))) {
            linkedHashMap.put(Constants.DeviceIdentifierKeyspaceKeys.OAID_KEYSPACE_KEY, str4);
        }
        AFb1mSDK l_ = AFb1kSDK.l_(this.copydefault.getRevenue.getRevenue.getContentResolver());
        String str6 = l_ != null ? l_.getCurrencyIso4217Code : null;
        String str7 = str6;
        if (!(str7 == null || StringsKt.isBlank(str7))) {
            linkedHashMap.put("amazon_aid", str6);
        }
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            String mediationNetwork2 = ((AFe1eSDK) this).component2.getMediationNetwork(this.equals);
            String str8 = mediationNetwork2;
            if (!(str8 == null || StringsKt.isBlank(str8))) {
                linkedHashMap.put(Constants.DeviceIdentifierKeyspaceKeys.IMEI_KEYSPACE_KEY, mediationNetwork2);
            }
        } else {
            mutableMap2.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
        }
        String revenue = AFb1jSDK.getRevenue(this.copydefault.getMonetizationNetwork);
        if (revenue == null) {
            revenue = "";
        }
        linkedHashMap.put("appsflyer_id", revenue);
        linkedHashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        linkedHashMap.put("sdk_version", "6.17.3");
        String str9 = monetizationNetwork;
        if (str9 != null && !StringsKt.isBlank(str9)) {
            z = false;
        }
        if (!z) {
            linkedHashMap.put("sdk_connector_version", monetizationNetwork);
        }
        this.toString.getMonetizationNetwork(linkedHashMap, this.areAllFieldsValid);
        mutableMap2.put("device_data", linkedHashMap);
        this.hashCode.getMediationNetwork(mutableMap2, this.areAllFieldsValid);
        AFd1jSDK<String> mediationNetwork3 = getMediationNetwork(mutableMap2, str, mediationNetwork);
        if (mediationNetwork3 != null && (aFd1dSDK = mediationNetwork3.getRevenue) != null) {
            str3 = aFd1dSDK.getRevenue;
        }
        if (str3 != null) {
            JSONObject jSONObject = new JSONObject(mutableMap2);
            AFg1bSDK.getMediationNetwork(toString() + ": preparing data: ", jSONObject);
            AFd1mSDK aFd1mSDK = this.component4;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "");
            aFd1mSDK.getMonetizationNetwork(str3, jSONObject2);
        }
        return mediationNetwork3;
    }
}
