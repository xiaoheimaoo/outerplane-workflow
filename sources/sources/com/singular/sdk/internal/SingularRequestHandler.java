package com.singular.sdk.internal;

import com.google.common.net.HttpHeaders;
import com.singular.sdk.internal.Api;
import com.singular.sdk.internal.Constants;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SingularRequestHandler {
    private static final SingularLog logger = SingularLog.getLogger("SingularRequestHandler");
    static int counter = 0;
    private static final String[] POST_PAYLOAD_PARAMS_KEYS = {Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, Constants.GLOBAL_PROPERTIES_KEY, Constants.RequestBody.INSTALL_REFERRER_KEY};

    SingularRequestHandler() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean makeRequest(SingularInstance singularInstance, String str, Map<String, String> map, long j, Api.OnApiCallback onApiCallback) throws IOException {
        long currentTimeMillis = Utils.getCurrentTimeMillis();
        int i = counter + 1;
        counter = i;
        SingularLog singularLog = logger;
        singularLog.debug("---------------------------> /%d", Integer.valueOf(i));
        singularLog.debug("url = %s", str);
        singularLog.debug("params = %s", map);
        HttpURLConnection buildRequest = buildRequest(singularInstance, str, map, j);
        try {
            try {
                return sendRequest(singularInstance, onApiCallback, currentTimeMillis, i, buildRequest);
            } catch (IOException e) {
                throw e;
            }
        } finally {
            if (buildRequest != null) {
                buildRequest.disconnect();
            }
        }
    }

    static HttpURLConnection buildRequest(SingularInstance singularInstance, String str, Map<String, String> map, long j) throws IOException {
        HttpURLConnection httpConnection;
        Map<String, String> postPayloadParams = getPostPayloadParams(map);
        String str2 = str + "?" + appendHash(getQueryString(singularInstance, map, j), singularInstance.getSingularConfig().secret);
        URL url = new URL(str2);
        if (url.getProtocol().equalsIgnoreCase("https")) {
            httpConnection = getHttpsConnection(url);
        } else {
            httpConnection = getHttpConnection(url);
        }
        setDefaultConnectionProperties(httpConnection);
        setPayloadForRequest(httpConnection, postPayloadParams, singularInstance.getSingularConfig().secret);
        logger.debug("__API__ %s %s", httpConnection.getRequestMethod(), str2);
        return httpConnection;
    }

    static boolean sendRequest(SingularInstance singularInstance, Api.OnApiCallback onApiCallback, long j, int i, HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        String readResponse = readResponse(httpURLConnection);
        httpURLConnection.disconnect();
        long currentTimeMillis = Utils.getCurrentTimeMillis() - j;
        SingularLog singularLog = logger;
        singularLog.debug("%d %s", Integer.valueOf(responseCode), readResponse);
        singularLog.debug("<--------------------------- /%d - took %dms", Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        return onApiCallback.handle(singularInstance, responseCode, readResponse);
    }

    private static String readResponse(HttpURLConnection httpURLConnection) throws IOException {
        InputStreamReader inputStreamReader;
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = httpURLConnection.getInputStream();
        if (httpURLConnection.getContentEncoding() != null && httpURLConnection.getContentEncoding().equals("gzip")) {
            inputStreamReader = new InputStreamReader(new GZIPInputStream(inputStream));
        } else {
            inputStreamReader = new InputStreamReader(inputStream);
        }
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuffer.append(readLine);
            } else {
                return stringBuffer.toString();
            }
        }
    }

    private static Map<String, String> getPostPayloadParams(Map<String, String> map) {
        String[] strArr;
        HashMap hashMap = new HashMap();
        for (String str : POST_PAYLOAD_PARAMS_KEYS) {
            if (map.containsKey(str)) {
                hashMap.put(str, map.get(str));
                map.remove(str);
            }
        }
        return hashMap;
    }

    private static void setPayloadForRequest(HttpURLConnection httpURLConnection, Map<String, String> map, String str) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (map != null && map.size() > 0) {
                String jSONObject2 = new JSONObject(map).toString();
                String sha1Hash = Utils.sha1Hash(jSONObject2, str);
                jSONObject.put("payload", jSONObject2);
                jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, sha1Hash);
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), Constants.ENCODING);
            outputStreamWriter.write(jSONObject.toString());
            outputStreamWriter.close();
        } catch (IOException | JSONException e) {
            logger.error("Error in JSON parsing or I/O ", e);
        }
    }

    private static void setDefaultConnectionProperties(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, Constants.HTTP_USER_AGENT);
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
    }

    private static String getQueryString(SingularInstance singularInstance, Map<String, String> map, long j) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            map = new HashMap<>();
        }
        TreeMap treeMap = new TreeMap(map);
        treeMap.put("rt", "json");
        treeMap.put("lag", String.valueOf(Utils.lagSince(j)));
        treeMap.put("c", Utils.getConnectionType(singularInstance.getContext()));
        if ((!treeMap.containsKey(Constants.RequestParamsKeys.IDENTIFIER_UNIQUE_ID_KEY) || Utils.isEmptyOrNull((String) treeMap.get(Constants.RequestParamsKeys.IDENTIFIER_UNIQUE_ID_KEY))) && !Utils.isEmptyOrNull(singularInstance.getDeviceInfo().oaid)) {
            treeMap.put(Constants.RequestParamsKeys.IDENTIFIER_UNIQUE_ID_KEY, singularInstance.getDeviceInfo().oaid);
            treeMap.put(Constants.RequestParamsKeys.IDENTIFIER_KEYSPACE_KEY, Constants.DeviceIdentifierKeyspaceValues.OAID_KEYSPACE_VALUE);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String encode = URLEncoder.encode((String) entry.getKey(), Constants.ENCODING);
            String str = (String) entry.getValue();
            String encode2 = str != null ? URLEncoder.encode(str, Constants.ENCODING) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(encode);
            sb.append("=");
            sb.append(encode2);
        }
        return sb.toString();
    }

    private static String appendHash(String str, String str2) {
        if (str == null) {
            return "";
        }
        String sha1Hash = Utils.sha1Hash(String.format("?%s", str), str2);
        logger.debug("hash = %s", sha1Hash);
        return Utils.isEmptyOrNull(sha1Hash) ? str : str + "&h=" + sha1Hash;
    }

    public static HttpURLConnection getHttpConnection(URL url) throws IOException {
        if (url != null) {
            return (HttpURLConnection) url.openConnection();
        }
        return null;
    }

    public static HttpURLConnection getHttpsConnection(URL url) throws IOException {
        if (url == null) {
            return null;
        }
        return (HttpsURLConnection) url.openConnection();
    }
}
