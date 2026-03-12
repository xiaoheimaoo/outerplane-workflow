package com.appsflyer.internal;

import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.appsflyer.share.LinkGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public final class AFe1kSDK extends AFe1eSDK<String> {
    private final String areAllFieldsValid;
    private final Map<String, String> copy;
    private final UUID copydefault;
    private final String equals;
    private final LinkGenerator.ResponseListener hashCode;
    private final LinkGenerator toString;

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final boolean a_() {
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

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final long getCurrencyIso4217Code() {
        return 3000L;
    }

    public AFe1kSDK(AFc1bSDK aFc1bSDK, UUID uuid, String str, Map<String, String> map, String str2, LinkGenerator.ResponseListener responseListener, LinkGenerator linkGenerator) {
        super(AFe1mSDK.ONELINK, new AFe1mSDK[]{AFe1mSDK.RC_CDN}, aFc1bSDK, uuid.toString());
        this.copydefault = uuid;
        this.areAllFieldsValid = str;
        this.copy = new HashMap(map);
        this.hashCode = responseListener;
        this.equals = str2;
        this.toString = linkGenerator;
    }

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final void getRevenue() {
        super.getRevenue();
        LinkGenerator.ResponseListener responseListener = this.hashCode;
        if (responseListener != null) {
            if (this.AFAdRevenueData == AFe1uSDK.SUCCESS && ((AFe1eSDK) this).component3 != null) {
                responseListener.onResponse((String) ((AFe1eSDK) this).component3.getBody());
                return;
            }
            Throwable component1 = component1();
            if (component1 instanceof ParsingException) {
                if (((ParsingException) component1).getRawResponse().isSuccessful()) {
                    responseListener.onResponseError("Can't parse one link data");
                    return;
                } else {
                    responseListener.onResponse(this.toString.generateLink());
                    return;
                }
            }
            responseListener.onResponse(this.toString.generateLink());
        }
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final AFd1jSDK<String> getRevenue(String str) {
        return ((AFe1eSDK) this).component1.getMediationNetwork(this.areAllFieldsValid, this.copy, this.equals, this.copydefault, str);
    }
}
