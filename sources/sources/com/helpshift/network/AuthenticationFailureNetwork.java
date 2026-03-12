package com.helpshift.network;

import com.helpshift.network.exception.HSRootApiException;
import com.helpshift.network.exception.NetworkException;
import com.helpshift.util.Utils;
/* loaded from: classes3.dex */
public class AuthenticationFailureNetwork implements HSNetwork {
    public static final String REASON_AUTH_TOKEN_NOT_PROVIDED = "missing user auth token";
    public static final String REASON_INVALID_AUTH_TOKEN = "invalid user auth token";
    private final HSNetwork network;

    public AuthenticationFailureNetwork(HSNetwork hSNetwork) {
        this.network = hSNetwork;
    }

    @Override // com.helpshift.network.HSNetwork
    public HSResponse makeRequest(HSRequestData hSRequestData) {
        HSResponse makeRequest = this.network.makeRequest(hSRequestData);
        if (makeRequest.getStatus() == 401 && !Utils.isEmpty(makeRequest.getResponseString())) {
            if (REASON_AUTH_TOKEN_NOT_PROVIDED.equalsIgnoreCase(makeRequest.getResponseString())) {
                NetworkException networkException = NetworkException.AUTH_TOKEN_NOT_PROVIDED;
                networkException.serverStatusCode = NetworkResponseCodes.AUTH_TOKEN_NOT_PROVIDED;
                throw HSRootApiException.wrap(null, networkException);
            } else if (REASON_INVALID_AUTH_TOKEN.equalsIgnoreCase(makeRequest.getResponseString())) {
                NetworkException networkException2 = NetworkException.INVALID_AUTH_TOKEN;
                networkException2.serverStatusCode = 443;
                throw HSRootApiException.wrap(null, networkException2);
            }
        }
        return makeRequest;
    }
}
