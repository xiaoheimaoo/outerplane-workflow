package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0002H\u0015¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001eR\u0014\u0010 \u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'"}, d2 = {"Lcom/appsflyer/internal/AFf1ySDK;", "Lcom/appsflyer/internal/AFe1eSDK;", "", "Lcom/appsflyer/internal/AFi1jSDK;", "p0", "Lcom/appsflyer/internal/AFc1pSDK;", "p1", "Lcom/appsflyer/internal/AFc1bSDK;", "p2", "Lcom/appsflyer/internal/AFg1rSDK;", "p3", "Lcom/appsflyer/internal/AFc1gSDK;", "p4", "Lcom/appsflyer/internal/AFh1iSDK;", "p5", "<init>", "(Lcom/appsflyer/internal/AFi1jSDK;Lcom/appsflyer/internal/AFc1pSDK;Lcom/appsflyer/internal/AFc1bSDK;Lcom/appsflyer/internal/AFg1rSDK;Lcom/appsflyer/internal/AFc1gSDK;Lcom/appsflyer/internal/AFh1iSDK;)V", "Lcom/appsflyer/internal/AFd1jSDK;", "getRevenue", "(Ljava/lang/String;)Lcom/appsflyer/internal/AFd1jSDK;", "", "getCurrencyIso4217Code", "()J", "Lcom/appsflyer/attribution/AppsFlyerRequestListener;", "areAllFieldsValid", "()Lcom/appsflyer/attribution/AppsFlyerRequestListener;", "", "copydefault", "()Z", "AFAdRevenueData", "Lcom/appsflyer/internal/AFc1gSDK;", "Lcom/appsflyer/internal/AFh1iSDK;", "getMonetizationNetwork", "hashCode", "Lcom/appsflyer/internal/AFg1rSDK;", "copy", "Lcom/appsflyer/internal/AFc1pSDK;", "getMediationNetwork", "equals", "Lcom/appsflyer/internal/AFi1jSDK;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AFf1ySDK extends AFe1eSDK<String> {
    public AFh1iSDK areAllFieldsValid;
    private final AFc1pSDK copy;
    private final AFc1gSDK copydefault;
    private final AFi1jSDK equals;
    private final AFg1rSDK hashCode;

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final AppsFlyerRequestListener areAllFieldsValid() {
        return null;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final boolean copydefault() {
        return false;
    }

    public /* synthetic */ AFf1ySDK(AFi1jSDK aFi1jSDK, AFc1pSDK aFc1pSDK, AFc1bSDK aFc1bSDK, AFg1rSDK aFg1rSDK, AFc1gSDK aFc1gSDK, AFh1iSDK aFh1iSDK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFi1jSDK, aFc1pSDK, aFc1bSDK, aFg1rSDK, aFc1gSDK, (i & 32) != 0 ? new AFh1iSDK() : aFh1iSDK);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private AFf1ySDK(AFi1jSDK aFi1jSDK, AFc1pSDK aFc1pSDK, AFc1bSDK aFc1bSDK, AFg1rSDK aFg1rSDK, AFc1gSDK aFc1gSDK, AFh1iSDK aFh1iSDK) {
        super(AFe1mSDK.PLAY_INTEGRITY_API, new AFe1mSDK[]{AFe1mSDK.CONVERSION}, aFc1bSDK, "PIA");
        Intrinsics.checkNotNullParameter(aFi1jSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1bSDK, "");
        Intrinsics.checkNotNullParameter(aFg1rSDK, "");
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
        Intrinsics.checkNotNullParameter(aFh1iSDK, "");
        this.equals = aFi1jSDK;
        this.copy = aFc1pSDK;
        this.hashCode = aFg1rSDK;
        this.copydefault = aFc1gSDK;
        this.areAllFieldsValid = aFh1iSDK;
        this.getMediationNetwork.add(AFe1mSDK.CONVERSION);
    }

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final long getCurrencyIso4217Code() {
        return TimeUnit.MINUTES.toMillis(1L);
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final AFd1jSDK<String> getRevenue(String str) {
        AFd1dSDK aFd1dSDK;
        String str2;
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(str, "");
        AFh1iSDK aFh1iSDK = this.areAllFieldsValid;
        Map<String, Object> map = aFh1iSDK.getCurrencyIso4217Code;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("app_id", this.copy.getRevenue.getRevenue.getPackageName());
        map.put("sdk_version", AFc1pSDK.getCurrencyIso4217Code());
        map.put("app_version_name", this.copy.n_().versionName);
        this.hashCode.getMediationNetwork(map);
        try {
            AFi1iSDK revenue = this.equals.getRevenue();
            if (revenue != null) {
                linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("pia_timestamp", Long.valueOf(revenue.getRevenue));
                linkedHashMap2.put("ttr_millis", Long.valueOf(revenue.getCurrencyIso4217Code));
                if (revenue.getMonetizationNetwork != null) {
                    linkedHashMap2.put("pia_token", revenue.getMonetizationNetwork);
                }
                if (revenue.getMediationNetwork != null) {
                    linkedHashMap2.put("error_code", revenue.getMediationNetwork);
                }
                linkedHashMap.put("pia", linkedHashMap2);
            } else {
                linkedHashMap = null;
            }
            if (linkedHashMap != null) {
                aFh1iSDK.getMonetizationNetwork(linkedHashMap);
            }
            if (!this.equals.getMediationNetwork()) {
                Map<String, Object> map2 = aFh1iSDK.getCurrencyIso4217Code;
                Intrinsics.checkNotNullExpressionValue(map2, "");
                AFj1aSDK.AFAdRevenueData(map2).put("pia_disabled", Boolean.TRUE);
            }
        } catch (Throwable th) {
            AFh1ySDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PLAY_INTEGRITY_API, "Error while adding PIA data to payload", th, true, false, false, false, 96, null);
        }
        AFd1jSDK<String> AFAdRevenueData = ((AFe1eSDK) this).component1.AFAdRevenueData(this.areAllFieldsValid, ((AFe1eSDK) this).component2.getMediationNetwork(), this.copydefault);
        Map<String, Object> map3 = this.areAllFieldsValid.getCurrencyIso4217Code;
        Intrinsics.checkNotNullExpressionValue(map3, "");
        if (AFAdRevenueData != null && (aFd1dSDK = AFAdRevenueData.getRevenue) != null && (str2 = aFd1dSDK.getRevenue) != null) {
            JSONObject jSONObject = new JSONObject(map3);
            if (jSONObject.has("pia")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("pia");
                if (jSONObject2.has("pia_token")) {
                    jSONObject2.put("pia_token", AFg1bSDK.getMonetizationNetwork(jSONObject2.getString("pia_token")));
                }
            }
            AFg1bSDK.getMediationNetwork(toString() + ": preparing data: ", jSONObject);
            AFd1mSDK aFd1mSDK = this.component4;
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "");
            aFd1mSDK.getMonetizationNetwork(str2, jSONObject3);
        }
        return AFAdRevenueData;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AFf1ySDK(AFi1jSDK aFi1jSDK, AFc1pSDK aFc1pSDK, AFc1bSDK aFc1bSDK, AFg1rSDK aFg1rSDK, AFc1gSDK aFc1gSDK) {
        this(aFi1jSDK, aFc1pSDK, aFc1bSDK, aFg1rSDK, aFc1gSDK, null, 32, null);
        Intrinsics.checkNotNullParameter(aFi1jSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1bSDK, "");
        Intrinsics.checkNotNullParameter(aFg1rSDK, "");
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
    }
}
