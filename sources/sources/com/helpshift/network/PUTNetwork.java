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
public class PUTNetwork extends HSBaseNetwork {
    public PUTNetwork(HTTPTransport hTTPTransport, String str) {
        super(hTTPTransport, str);
    }

    @Override // com.helpshift.network.HSBaseNetwork
    HSRequest getRequest(HSRequestData hSRequestData) {
        return new HSRequest(HSRequest.Method.PUT, getURL(), hSRequestData.headers, getBody(hSRequestData.body), 5000);
    }

    private String getBody(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : NetworkUtils.cleanDataForNetworkBody(map).entrySet()) {
            try {
                arrayList.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), Constants.ENCODING));
            } catch (UnsupportedEncodingException e) {
                throw HSRootApiException.wrap(e, NetworkException.UNSUPPORTED_ENCODING_EXCEPTION);
            }
        }
        return Utils.join("&", arrayList);
    }
}
