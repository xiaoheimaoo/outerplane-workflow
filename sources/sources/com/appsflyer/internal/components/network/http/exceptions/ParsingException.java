package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.AFe1xSDK;
import java.io.IOException;
/* loaded from: classes.dex */
public class ParsingException extends IOException {
    private final AFe1xSDK<String> getCurrencyIso4217Code;

    public ParsingException(String str, Throwable th, AFe1xSDK<String> aFe1xSDK) {
        super(str, th);
        this.getCurrencyIso4217Code = aFe1xSDK;
    }

    public AFe1xSDK<String> getRawResponse() {
        return this.getCurrencyIso4217Code;
    }
}
