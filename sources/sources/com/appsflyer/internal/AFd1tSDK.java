package com.appsflyer.internal;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
/* loaded from: classes.dex */
public final class AFd1tSDK {
    public static final JSONArray AFAdRevenueData(List<AFc1cSDK> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<AFc1cSDK> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (AFc1cSDK aFc1cSDK : list2) {
            arrayList.add(aFc1cSDK.AFAdRevenueData());
        }
        return new JSONArray((Collection) arrayList);
    }

    public static final boolean getMediationNetwork(HttpURLConnection httpURLConnection) {
        Intrinsics.checkNotNullParameter(httpURLConnection, "");
        return httpURLConnection.getResponseCode() / 100 == 2;
    }
}
