package com.helpshift.network;

import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class HSResponse {
    private final Map<String, List<String>> headers;
    private final String responseString;
    private final int status;

    public HSResponse(int i, String str, Map<String, List<String>> map) {
        this.status = i;
        this.responseString = str;
        this.headers = map;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isNetworkCallSuccess() {
        int i = this.status;
        return i >= 200 && i < 300;
    }

    public String getResponseString() {
        return this.responseString;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }
}
