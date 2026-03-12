package com.helpshift.network;

import com.helpshift.network.HSRequest;
/* loaded from: classes3.dex */
public class POSTNetwork extends HSBaseNetwork {
    public POSTNetwork(HTTPTransport hTTPTransport, String str) {
        super(hTTPTransport, str);
    }

    @Override // com.helpshift.network.HSBaseNetwork
    HSRequest getRequest(HSRequestData hSRequestData) {
        return new HSRequest(HSRequest.Method.POST, getURL(), hSRequestData.headers, NetworkUtils.getBodyForPostMethod(NetworkUtils.cleanDataForNetworkBody(hSRequestData.body)), 5000);
    }
}
