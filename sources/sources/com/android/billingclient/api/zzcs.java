package com.android.billingclient.api;

import com.android.billingclient.api.ProductDetails;
import com.helpshift.HelpshiftEvent;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class zzcs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcs(JSONObject jSONObject) throws JSONException {
        jSONObject.getString(HelpshiftEvent.DATA_MESSAGE_TYPE);
        JSONArray optJSONArray = jSONObject.optJSONArray("balanceThresholds");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(Integer.valueOf(optJSONArray.getInt(i)));
            }
        }
        new ProductDetails.PricingPhases(jSONObject.getJSONArray("pricingPhases"));
    }
}
