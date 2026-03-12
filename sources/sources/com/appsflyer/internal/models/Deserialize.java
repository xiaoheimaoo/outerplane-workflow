package com.appsflyer.internal.models;

import com.google.android.gms.ads.RequestConfiguration;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/appsflyer/internal/models/Deserialize;", RequestConfiguration.MAX_AD_CONTENT_RATING_T, "", "Lorg/json/JSONObject;", "p0", "fromJson", "(Lorg/json/JSONObject;)Ljava/lang/Object;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Deserialize<T> {
    T fromJson(JSONObject jSONObject);
}
