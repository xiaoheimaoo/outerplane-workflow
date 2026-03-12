package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.AFd1aSDK;
import java.io.IOException;
/* loaded from: classes.dex */
public class HttpException extends IOException {
    private final AFd1aSDK getMediationNetwork;

    public HttpException(Throwable th, AFd1aSDK aFd1aSDK) {
        super(th.getMessage(), th);
        this.getMediationNetwork = aFd1aSDK;
    }

    public AFd1aSDK getMetrics() {
        return this.getMediationNetwork;
    }
}
