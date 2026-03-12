package com.appsflyer.unity;

import android.util.Log;
import com.appsflyer.api.InAppPurchaseEvent;
import com.appsflyer.api.PurchaseClient;
import com.appsflyer.api.SubscriptionPurchaseEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PurchaseRevenueBridge {
    private static final String TAG = "AppsFlyerUnity";
    private static UnityPurchaseRevenueBridge unityBridge;

    /* loaded from: classes.dex */
    public interface UnityPurchaseRevenueBridge {
        String getAdditionalParameters(String str, String str2);
    }

    public static void setUnityBridge(UnityPurchaseRevenueBridge unityPurchaseRevenueBridge) {
        unityBridge = unityPurchaseRevenueBridge;
    }

    public static PurchaseClient.Builder configurePurchaseClient(PurchaseClient.Builder builder) {
        return builder.setInAppPurchaseEventDataSource(new PurchaseClient.InAppPurchaseEventDataSource() { // from class: com.appsflyer.unity.PurchaseRevenueBridge$$ExternalSyntheticLambda0
            @Override // com.appsflyer.api.PurchaseClient.PurchaseEventDataSource
            public final Map onNewPurchases(List<? extends InAppPurchaseEvent> list) {
                return PurchaseRevenueBridge.lambda$configurePurchaseClient$0(list);
            }
        }).setSubscriptionPurchaseEventDataSource(new PurchaseClient.SubscriptionPurchaseEventDataSource() { // from class: com.appsflyer.unity.PurchaseRevenueBridge$$ExternalSyntheticLambda1
            @Override // com.appsflyer.api.PurchaseClient.PurchaseEventDataSource
            public final Map onNewPurchases(List<? extends SubscriptionPurchaseEvent> list) {
                return PurchaseRevenueBridge.lambda$configurePurchaseClient$1(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$configurePurchaseClient$0(List list) {
        try {
            String jSONObject = new JSONObject(Collections.singletonMap("events", list)).toString();
            UnityPurchaseRevenueBridge unityPurchaseRevenueBridge = unityBridge;
            String additionalParameters = unityPurchaseRevenueBridge != null ? unityPurchaseRevenueBridge.getAdditionalParameters(jSONObject, "") : null;
            if (additionalParameters != null) {
                JSONObject jSONObject2 = new JSONObject(additionalParameters);
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.get(next));
                }
                return hashMap;
            }
        } catch (JSONException e) {
            Log.e(TAG, "Failed to parse additional params from Unity", e);
        }
        return Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$configurePurchaseClient$1(List list) {
        try {
            String jSONObject = new JSONObject(Collections.singletonMap("events", list)).toString();
            UnityPurchaseRevenueBridge unityPurchaseRevenueBridge = unityBridge;
            String additionalParameters = unityPurchaseRevenueBridge != null ? unityPurchaseRevenueBridge.getAdditionalParameters("", jSONObject) : null;
            if (additionalParameters != null) {
                JSONObject jSONObject2 = new JSONObject(additionalParameters);
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.get(next));
                }
                return hashMap;
            }
        } catch (JSONException e) {
            Log.e(TAG, "Failed to parse additional params from Unity", e);
        }
        return Collections.emptyMap();
    }
}
