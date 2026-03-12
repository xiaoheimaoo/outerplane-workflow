package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.appsflyer.internal.components.queue.exceptions.CreateHttpCallException;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class AFe1eSDK<Result> extends AFe1lSDK<AFe1xSDK<Result>> {
    private AFc1uSDK areAllFieldsValid;
    protected final AFd1lSDK component1;
    public final AFf1cSDK component2;
    public AFe1xSDK<Result> component3;
    protected final AFd1mSDK component4;
    private String hashCode;

    protected boolean a_() {
        return true;
    }

    protected abstract AppsFlyerRequestListener areAllFieldsValid();

    protected abstract boolean copydefault();

    @Override // com.appsflyer.internal.AFe1lSDK
    public long getCurrencyIso4217Code() {
        return ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;
    }

    protected abstract AFd1jSDK<Result> getRevenue(String str);

    private AFe1eSDK(AFe1mSDK aFe1mSDK, AFe1mSDK[] aFe1mSDKArr, AFd1lSDK aFd1lSDK, AFf1cSDK aFf1cSDK, AFd1mSDK aFd1mSDK, AFc1uSDK aFc1uSDK, String str) {
        super(aFe1mSDK, aFe1mSDKArr, str);
        this.component1 = aFd1lSDK;
        this.component2 = aFf1cSDK;
        this.component4 = aFd1mSDK;
        this.areAllFieldsValid = aFc1uSDK;
    }

    public AFe1eSDK(AFe1mSDK aFe1mSDK, AFe1mSDK[] aFe1mSDKArr, AFc1bSDK aFc1bSDK, String str) {
        this(aFe1mSDK, aFe1mSDKArr, aFc1bSDK.getRevenue(), aFc1bSDK.AFKeystoreWrapper(), aFc1bSDK.equals(), aFc1bSDK.AFInAppEventType(), str);
    }

    public AFe1eSDK(AFe1mSDK aFe1mSDK, AFe1mSDK[] aFe1mSDKArr, AFc1bSDK aFc1bSDK, String str, String str2) {
        this(aFe1mSDK, aFe1mSDKArr, aFc1bSDK.getRevenue(), aFc1bSDK.AFKeystoreWrapper(), aFc1bSDK.equals(), aFc1bSDK.AFInAppEventType(), str);
        this.hashCode = str2;
    }

    @Override // com.appsflyer.internal.AFe1lSDK
    public final void getMonetizationNetwork() {
        String mediationNetwork;
        super.getMonetizationNetwork();
        if (!copydefault() || (mediationNetwork = this.component2.getMediationNetwork()) == null || mediationNetwork.trim().isEmpty()) {
            return;
        }
        AFd1jSDK<Result> revenue = getRevenue(mediationNetwork);
        if (revenue != null) {
            getMonetizationNetwork(revenue.getRevenue);
        } else {
            AFLogger.INSTANCE.e(AFg1cSDK.HTTP_CLIENT, "Failed to create a cached HTTP call", new CreateHttpCallException("createHttpCall returned null"), false, false);
        }
    }

    @Override // com.appsflyer.internal.AFe1lSDK
    public AFe1uSDK getMediationNetwork() throws Exception {
        if (!a_() || !this.component2.getMonetizationNetwork()) {
            String mediationNetwork = this.component2.getMediationNetwork();
            if (mediationNetwork != null && !mediationNetwork.trim().isEmpty()) {
                AFd1jSDK<Result> revenue = getRevenue(mediationNetwork);
                if (revenue == null) {
                    AFLogger.INSTANCE.e(AFg1cSDK.HTTP_CLIENT, "Failed to create a cached HTTP call", new CreateHttpCallException("createHttpCall returned null"), false, false);
                    return AFe1uSDK.FAILURE;
                }
                if (copydefault()) {
                    getMonetizationNetwork(revenue.getRevenue);
                }
                AFe1xSDK<Result> AFAdRevenueData = revenue.AFAdRevenueData();
                this.component3 = AFAdRevenueData;
                this.component4.getMonetizationNetwork(revenue.getRevenue.getRevenue, AFAdRevenueData.getStatusCode(), AFAdRevenueData.getBody().toString());
                AppsFlyerRequestListener areAllFieldsValid = areAllFieldsValid();
                if (areAllFieldsValid != null) {
                    if (AFAdRevenueData.isSuccessful()) {
                        areAllFieldsValid.onSuccess();
                    } else {
                        areAllFieldsValid.onError(50, new StringBuilder("Status code failure ").append(AFAdRevenueData.getStatusCode()).toString());
                    }
                }
                if (AFAdRevenueData.isSuccessful()) {
                    return AFe1uSDK.SUCCESS;
                }
                return AFe1uSDK.FAILURE;
            }
            AppsFlyerRequestListener areAllFieldsValid2 = areAllFieldsValid();
            if (areAllFieldsValid2 != null) {
                areAllFieldsValid2.onError(41, "No dev key");
            }
            throw new AFe1pSDK();
        }
        AppsFlyerRequestListener areAllFieldsValid3 = areAllFieldsValid();
        if (areAllFieldsValid3 != null) {
            areAllFieldsValid3.onError(11, "Skipping event because 'isStopped' is true");
        }
        throw new AFe1iSDK();
    }

    @Override // com.appsflyer.internal.AFe1lSDK
    public boolean AFAdRevenueData() {
        if (component1() instanceof AFe1iSDK) {
            return false;
        }
        if (this.AFAdRevenueData == AFe1uSDK.TIMEOUT) {
            return true;
        }
        Throwable component1 = component1();
        return (component1 instanceof IOException) && !(component1 instanceof ParsingException);
    }

    @Override // com.appsflyer.internal.AFe1lSDK
    public final void getMediationNetwork(Throwable th) {
        boolean z = !(th instanceof HttpException);
        if (th instanceof AFe1iSDK) {
            AFLogger.INSTANCE.e(AFg1cSDK.HTTP_CLIENT, "AppsFlyer SDK is stopped: the request was not sent to the server", th, true, false);
        } else {
            AFLogger.INSTANCE.e(AFg1cSDK.HTTP_CLIENT, "Error while sending request to server: ".concat(String.valueOf(th)), th, false, false, z);
            AFLogger.INSTANCE.w(AFg1cSDK.HTTP_CLIENT, "Error while sending request to server: ".concat(String.valueOf(th)));
        }
        AppsFlyerRequestListener areAllFieldsValid = areAllFieldsValid();
        if (areAllFieldsValid != null) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            areAllFieldsValid.onError(40, message);
        }
    }

    private void getMonetizationNetwork(AFd1dSDK aFd1dSDK) {
        String str = this.hashCode;
        this.hashCode = this.areAllFieldsValid.getMonetizationNetwork(new AFc1tSDK(aFd1dSDK.getRevenue, aFd1dSDK.getMediationNetwork(), "6.17.3", this.getCurrencyIso4217Code));
        if (str != null) {
            this.areAllFieldsValid.getCurrencyIso4217Code(str);
        }
    }

    @Override // com.appsflyer.internal.AFe1lSDK
    public void getRevenue() {
        String str;
        if (this.AFAdRevenueData != AFe1uSDK.SUCCESS) {
            if (AFAdRevenueData() || (str = this.hashCode) == null) {
                return;
            }
            this.areAllFieldsValid.getCurrencyIso4217Code(str);
            return;
        }
        String str2 = this.hashCode;
        if (str2 != null) {
            this.areAllFieldsValid.getCurrencyIso4217Code(str2);
        }
    }
}
