package com.appsflyer.internal;

import com.appsflyer.deeplink.DeepLink;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFa1qSDK implements AFe1vSDK<AFa1mSDK> {
    @Override // com.appsflyer.internal.AFe1vSDK
    public final /* synthetic */ AFa1mSDK getMonetizationNetwork(String str) {
        JSONObject optJSONObject;
        String str2 = str;
        DeepLink deepLink = null;
        if (!(str2 == null || str2.length() == 0)) {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("found", false);
            boolean optBoolean2 = jSONObject.optBoolean("is_second_ping", true);
            if (optBoolean && (optJSONObject = jSONObject.optJSONObject("click_event")) != null) {
                deepLink = DeepLink.getMonetizationNetwork(optJSONObject);
                deepLink.getCurrencyIso4217Code.put("is_deferred", true);
            }
            return new AFa1mSDK(optBoolean2, deepLink);
        }
        return new AFa1mSDK(false, null, 3, null);
    }
}
