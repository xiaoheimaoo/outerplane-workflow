package com.helpshift.network;
/* loaded from: classes3.dex */
public abstract class HSBaseNetwork implements HSNetwork {
    private final HTTPTransport httpTransport;
    private final String url;

    abstract HSRequest getRequest(HSRequestData hSRequestData);

    /* JADX INFO: Access modifiers changed from: protected */
    public HSBaseNetwork(HTTPTransport hTTPTransport, String str) {
        this.httpTransport = hTTPTransport;
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getURL() {
        return this.url;
    }

    @Override // com.helpshift.network.HSNetwork
    public HSResponse makeRequest(HSRequestData hSRequestData) {
        return this.httpTransport.makeRequest(getRequest(hSRequestData));
    }
}
