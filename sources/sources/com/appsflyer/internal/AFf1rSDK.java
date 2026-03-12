package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFj1qSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.helpshift.HelpshiftEvent;
import com.singular.sdk.internal.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFf1rSDK extends AFf1uSDK {
    private final AFf1lSDK AFInAppEventParameterName;
    private final AppsFlyerProperties AFInAppEventType;
    private final AFh1qSDK AFKeystoreWrapper;
    private final AFj1rSDK copydefault;
    private final AFh1tSDK equals;
    public Map<String, Object> hashCode;
    private final AFa1hSDK registerClient;
    private final AFc1oSDK toString;

    public AFf1rSDK(AFh1jSDK aFh1jSDK, AFc1bSDK aFc1bSDK) {
        super(aFh1jSDK, aFc1bSDK);
        this.copydefault = aFc1bSDK.AFLogger();
        this.toString = aFc1bSDK.component2();
        this.equals = aFc1bSDK.component3();
        this.AFInAppEventParameterName = aFc1bSDK.component1();
        this.AFInAppEventType = AppsFlyerProperties.getInstance();
        this.registerClient = aFc1bSDK.afErrorLogForExcManagerOnly();
        this.AFKeystoreWrapper = aFc1bSDK.afLogForce();
        this.getRevenue.add(AFe1mSDK.RESOLVE_ESP);
        this.getRevenue.add(AFe1mSDK.DLSDK);
    }

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final void getRevenue() {
        super.getRevenue();
        AFh1tSDK aFh1tSDK = this.equals;
        if (aFh1tSDK.getRevenue()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (aFh1tSDK.copydefault != 0) {
                aFh1tSDK.getMonetizationNetwork.put("net", Long.valueOf(currentTimeMillis - aFh1tSDK.copydefault));
                aFh1tSDK.getCurrencyIso4217Code.AFAdRevenueData("first_launch", new JSONObject(aFh1tSDK.getMonetizationNetwork).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: launch start ts is missing");
        }
    }

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final boolean AFAdRevenueData() {
        return super.AFAdRevenueData() || equals();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.appsflyer.internal.AFf1uSDK
    public final void getMediationNetwork(AFh1jSDK aFh1jSDK) {
        AFh1qSDK aFh1qSDK;
        AFj1qSDK[] aFj1qSDKArr;
        AFh1qSDK aFh1qSDK2;
        super.getMediationNetwork(aFh1jSDK);
        int i = aFh1jSDK.component1;
        AFh1tSDK aFh1tSDK = this.equals;
        if (aFh1tSDK.getRevenue()) {
            aFh1tSDK.copydefault = System.currentTimeMillis();
            if (aFh1tSDK.component3 != 0) {
                aFh1tSDK.getMonetizationNetwork.put("from_fg", Long.valueOf(aFh1tSDK.copydefault - aFh1tSDK.component3));
                aFh1tSDK.getCurrencyIso4217Code.AFAdRevenueData("first_launch", new JSONObject(aFh1tSDK.getMonetizationNetwork).toString());
            } else {
                AFLogger.afInfoLog("Metrics: fg ts is missing");
            }
        }
        Map map = (Map) aFh1jSDK.getCurrencyIso4217Code.get("meta");
        if (map == null) {
            map = new HashMap();
            aFh1jSDK.getCurrencyIso4217Code.put("meta", map);
        }
        if (!aFh1jSDK.getCurrencyIso4217Code.containsKey("af_deeplink")) {
            aFh1jSDK.getMonetizationNetwork(this.registerClient.getMonetizationNetwork());
        }
        AFi1vSDK revenue = this.AFInAppEventParameterName.getRevenue();
        if (revenue != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cdn_token", revenue.AFAdRevenueData);
            if (revenue.getMediationNetwork != null) {
                hashMap.put("c_ver", revenue.getMediationNetwork);
            }
            if (revenue.getMonetizationNetwork > 0) {
                hashMap.put("latency", Long.valueOf(revenue.getMonetizationNetwork));
            }
            if (revenue.getCurrencyIso4217Code > 0) {
                hashMap.put("delay", Long.valueOf(revenue.getCurrencyIso4217Code));
            }
            if (revenue.getRevenue > 0) {
                hashMap.put("res_code", Integer.valueOf(revenue.getRevenue));
            }
            if (revenue.areAllFieldsValid != null) {
                hashMap.put("error", new StringBuilder().append(revenue.areAllFieldsValid.getClass().getSimpleName()).append(": ").append(revenue.areAllFieldsValid.getMessage()).toString());
            }
            if (revenue.component1 != null) {
                hashMap.put("sig", revenue.component1.toString());
            }
            if (revenue.component3 != null) {
                hashMap.put("cdn_cache_status", revenue.component3);
            }
            map.put(Constants.RETRY_COUNT, hashMap);
        }
        this.copy.getMonetizationNetwork(aFh1jSDK.getCurrencyIso4217Code);
        if (i == 1) {
            if (this.AFInAppEventType.getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                aFh1jSDK.getCurrencyIso4217Code.put("wait_cid", Boolean.toString(true));
            }
            AFh1tSDK aFh1tSDK2 = this.equals;
            HashMap hashMap2 = new HashMap(aFh1tSDK2.getRevenue);
            aFh1tSDK2.getRevenue.clear();
            if (!hashMap2.isEmpty()) {
                map.put("ddl", hashMap2);
            }
            HashMap hashMap3 = new HashMap(this.equals.getMonetizationNetwork);
            if (!hashMap3.isEmpty()) {
                map.put("first_launch", hashMap3);
            }
            AFh1qSDK aFh1qSDK3 = this.AFKeystoreWrapper;
            if (aFh1qSDK3 != null) {
                aFh1qSDK3.AFAdRevenueData(aFh1jSDK);
            }
        } else if (i == 2) {
            AFh1tSDK aFh1tSDK3 = this.equals;
            aFh1tSDK3.getCurrencyIso4217Code.getCurrencyIso4217Code("first_launch");
            HashMap hashMap4 = new HashMap(aFh1tSDK3.getMonetizationNetwork);
            if (!hashMap4.isEmpty()) {
                map.put("first_launch", hashMap4);
            }
            if ((aFh1jSDK instanceof AFh1kSDK) && (aFh1qSDK2 = this.AFKeystoreWrapper) != null && !aFh1qSDK2.getMediationNetwork()) {
                this.AFKeystoreWrapper.getRevenue(aFh1jSDK);
            }
        }
        if (map.isEmpty()) {
            aFh1jSDK.getCurrencyIso4217Code.remove("meta");
        }
        if (i <= 2) {
            ArrayList arrayList = new ArrayList();
            for (AFj1qSDK aFj1qSDK : (AFj1qSDK[]) this.copydefault.getCurrencyIso4217Code.toArray(new AFj1qSDK[0])) {
                boolean z = aFj1qSDK instanceof AFi1bSDK;
                int i2 = AnonymousClass2.getMediationNetwork[aFj1qSDK.areAllFieldsValid.ordinal()];
                if (i2 == 1) {
                    if (z) {
                        aFh1jSDK.getMonetizationNetwork("rfr", ((AFi1bSDK) aFj1qSDK).getMediationNetwork);
                        this.toString.getCurrencyIso4217Code(AppsFlyerProperties.NEW_REFERRER_SENT, true);
                    }
                    arrayList.add(aFj1qSDK.AFAdRevenueData);
                } else if (i2 == 2 && i == 2 && !z) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("source", aFj1qSDK.getCurrencyIso4217Code);
                    hashMap5.put("response", "TIMEOUT");
                    hashMap5.put(HelpshiftEvent.DATA_MESSAGE_TYPE, aFj1qSDK.component4);
                    arrayList.add(hashMap5);
                }
            }
            if (!arrayList.isEmpty()) {
                aFh1jSDK.getMonetizationNetwork("referrers", arrayList);
            }
            Object obj = this.hashCode;
            if (obj != null) {
                aFh1jSDK.getMonetizationNetwork("fb_ddl", obj);
            }
        }
        if (aFh1jSDK.getCurrencyIso4217Code() == AFe1mSDK.LAUNCH && (aFh1qSDK = this.AFKeystoreWrapper) != null && aFh1qSDK.getMonetizationNetwork()) {
            this.AFKeystoreWrapper.getMediationNetwork(aFh1jSDK);
        }
        this.copy.getRevenue(aFh1jSDK);
    }

    /* renamed from: com.appsflyer.internal.AFf1rSDK$2  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] getMediationNetwork;

        static {
            int[] iArr = new int[AFj1qSDK.AFa1vSDK.values().length];
            getMediationNetwork = iArr;
            try {
                iArr[AFj1qSDK.AFa1vSDK.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getMediationNetwork[AFj1qSDK.AFa1vSDK.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private boolean equals() {
        ResponseNetwork responseNetwork = ((AFe1eSDK) this).component3;
        return (this.AFAdRevenueData == AFe1uSDK.FAILURE && responseNetwork != null && responseNetwork.getStatusCode() / 500 == 1) && (this.getCurrencyIso4217Code == AFe1mSDK.CONVERSION || this.getCurrencyIso4217Code == AFe1mSDK.ATTR);
    }
}
