package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class AFd1jSDK<ResponseBody> {
    private final AFe1vSDK<ResponseBody> AFAdRevenueData;
    private final ExecutorService getCurrencyIso4217Code;
    private final AFd1fSDK getMediationNetwork;
    private final AtomicBoolean getMonetizationNetwork = new AtomicBoolean(false);
    public final AFd1dSDK getRevenue;

    public AFd1jSDK(AFd1dSDK aFd1dSDK, ExecutorService executorService, AFd1fSDK aFd1fSDK, AFe1vSDK<ResponseBody> aFe1vSDK) {
        this.getRevenue = aFd1dSDK;
        this.getCurrencyIso4217Code = executorService;
        this.getMediationNetwork = aFd1fSDK;
        this.AFAdRevenueData = aFe1vSDK;
    }

    public final AFe1xSDK<ResponseBody> AFAdRevenueData() throws IOException {
        if (!this.getMonetizationNetwork.getAndSet(true)) {
            AFe1xSDK<String> AFAdRevenueData = this.getMediationNetwork.AFAdRevenueData(this.getRevenue);
            try {
                return new AFe1xSDK<>(this.AFAdRevenueData.getMonetizationNetwork(AFAdRevenueData.getBody()), AFAdRevenueData.getMediationNetwork, AFAdRevenueData.getMonetizationNetwork, AFAdRevenueData.getCurrencyIso4217Code, AFAdRevenueData.AFAdRevenueData);
            } catch (JSONException e) {
                AFLogger.afErrorLogForExcManagerOnly("could not parse raw response - execute", e);
                throw new ParsingException(e.getMessage(), e, AFAdRevenueData);
            }
        }
        throw new IllegalStateException("Http call is already executed");
    }
}
