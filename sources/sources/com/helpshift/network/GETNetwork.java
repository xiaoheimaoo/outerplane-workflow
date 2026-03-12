package com.helpshift.network;

import com.helpshift.network.HSRequest;
import com.helpshift.network.exception.HSRootApiException;
import com.helpshift.network.exception.NetworkException;
import com.helpshift.util.Utils;
import com.singular.sdk.internal.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class GETNetwork extends HSBaseNetwork implements HSNetwork {
    public GETNetwork(HTTPTransport hTTPTransport, String str) {
        super(hTTPTransport, str);
    }

    @Override // com.helpshift.network.HSBaseNetwork
    HSRequest getRequest(HSRequestData hSRequestData) {
        return new HSRequest(HSRequest.Method.GET, getURL() + "?" + getQuery(hSRequestData.body), hSRequestData.headers, "", 5000);
    }

    private String getQuery(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                arrayList.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), Constants.ENCODING));
            } catch (UnsupportedEncodingException e) {
                throw HSRootApiException.wrap(e, NetworkException.UNSUPPORTED_ENCODING_EXCEPTION);
            }
        }
        return Utils.join("&", arrayList);
    }
}
