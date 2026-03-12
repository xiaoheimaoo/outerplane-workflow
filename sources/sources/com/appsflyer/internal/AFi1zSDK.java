package com.appsflyer.internal;

import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class AFi1zSDK {
    public final AFi1xSDK AFAdRevenueData;
    public final AFh1aSDK getCurrencyIso4217Code;
    public AFi1ySDK getMediationNetwork;

    public AFi1zSDK(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        this.getMediationNetwork = getCurrencyIso4217Code(jSONObject);
        this.getCurrencyIso4217Code = getRevenue(jSONObject);
        this.AFAdRevenueData = getMediationNetwork(jSONObject);
    }

    private static AFi1xSDK getMediationNetwork(JSONObject jSONObject) {
        Object m539constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject AFAdRevenueData = AFAdRevenueData(jSONObject, "meta_data");
            m539constructorimpl = Result.m539constructorimpl(AFAdRevenueData != null ? new AFi1xSDK(AFAdRevenueData.optDouble("send_rate", 1.0d)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m539constructorimpl = Result.m539constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m545isFailureimpl(m539constructorimpl) ? null : m539constructorimpl;
    }

    private static AFh1aSDK getRevenue(JSONObject jSONObject) {
        Object m539constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject AFAdRevenueData = AFAdRevenueData(jSONObject, "exc_mngr");
            m539constructorimpl = Result.m539constructorimpl(AFAdRevenueData != null ? new AFh1aSDK(AFAdRevenueData.getString("sdk_ver"), AFAdRevenueData.optInt("min", -1), AFAdRevenueData.optInt("expire", -1), AFAdRevenueData.optLong("ttl", -1L)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m539constructorimpl = Result.m539constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m545isFailureimpl(m539constructorimpl) ? null : m539constructorimpl;
    }

    private static AFi1ySDK getCurrencyIso4217Code(JSONObject jSONObject) {
        Object m539constructorimpl;
        AFi1ySDK aFi1ySDK;
        ArrayList emptyList;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject AFAdRevenueData = AFAdRevenueData(jSONObject, "r_debugger");
            if (AFAdRevenueData != null) {
                long j = AFAdRevenueData.getLong("ttl");
                int i = AFAdRevenueData.getInt("counter");
                String optString = AFAdRevenueData.optString("app_ver", "");
                String optString2 = AFAdRevenueData.optString("sdk_ver", "");
                float optDouble = (float) AFAdRevenueData.optDouble("ratio", 1.0d);
                JSONArray optJSONArray = AFAdRevenueData.optJSONArray("tags");
                if (optJSONArray == null) {
                    emptyList = CollectionsKt.emptyList();
                } else {
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "");
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        String string = optJSONArray.getString(i2);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        arrayList.add(string);
                    }
                    emptyList = arrayList;
                }
                Intrinsics.checkNotNullExpressionValue(optString, "");
                Intrinsics.checkNotNullExpressionValue(optString2, "");
                aFi1ySDK = new AFi1ySDK(j, optDouble, emptyList, i, optString, optString2);
            } else {
                aFi1ySDK = null;
            }
            m539constructorimpl = Result.m539constructorimpl(aFi1ySDK);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m539constructorimpl = Result.m539constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m545isFailureimpl(m539constructorimpl) ? null : m539constructorimpl;
    }

    private static JSONObject AFAdRevenueData(JSONObject jSONObject, String str) throws JSONException, NullPointerException {
        JSONObject optJSONObject;
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.getJSONArray(str).optJSONObject(0).optJSONObject("data")) == null) {
            return null;
        }
        return optJSONObject.optJSONObject("v1");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj, "");
            AFi1zSDK aFi1zSDK = (AFi1zSDK) obj;
            return Intrinsics.areEqual(this.getCurrencyIso4217Code, aFi1zSDK.getCurrencyIso4217Code) && Intrinsics.areEqual(this.AFAdRevenueData, aFi1zSDK.AFAdRevenueData) && Intrinsics.areEqual(this.getMediationNetwork, aFi1zSDK.getMediationNetwork);
        }
        return false;
    }

    public final int hashCode() {
        AFh1aSDK aFh1aSDK = this.getCurrencyIso4217Code;
        int hashCode = (aFh1aSDK != null ? aFh1aSDK.hashCode() : 0) * 31;
        AFi1xSDK aFi1xSDK = this.AFAdRevenueData;
        int hashCode2 = (hashCode + (aFi1xSDK != null ? aFi1xSDK.hashCode() : 0)) * 31;
        AFi1ySDK aFi1ySDK = this.getMediationNetwork;
        return hashCode2 + (aFi1ySDK != null ? aFi1ySDK.hashCode() : 0);
    }
}
