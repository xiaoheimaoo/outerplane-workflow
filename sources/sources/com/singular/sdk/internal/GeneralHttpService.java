package com.singular.sdk.internal;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.singular.sdk.internal.GeneralHttpServiceBase;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GeneralHttpService extends GeneralHttpServiceBase {
    private static final String BASE_URL = "https://sdk-api-v1.singular.net/api/v1";
    private final SingularLog logger;

    public GeneralHttpService() {
        super("https://sdk-api-v1.singular.net/api/v1");
        this.logger = SingularLog.getLogger("GeneralHttpService");
    }

    private HttpURLConnection buildRequest(String str, Map<String, String> map) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, Constants.HTTP_USER_AGENT);
            httpsURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpsURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
            JSONObject jSONObject = map != null ? new JSONObject(map) : new JSONObject();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream(), Constants.ENCODING);
            outputStreamWriter.write(jSONObject.toString());
            outputStreamWriter.close();
            return httpsURLConnection;
        } catch (Throwable th) {
            this.logger.error(Utils.formatException(th));
            return null;
        }
    }

    @Override // com.singular.sdk.internal.GeneralHttpServiceBase
    public void sendRequest(final String str, final Map<String, String> map, final Map<String, String> map2, final GeneralHttpServiceBase.CompletionHandler completionHandler) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.GeneralHttpService.1
            @Override // java.lang.Runnable
            public void run() {
                GeneralHttpService.this.sendSynchronousRequest(str, map, map2, completionHandler);
            }
        });
    }

    public void sendSynchronousRequest(String str, Map<String, String> map, Map<String, String> map2, GeneralHttpServiceBase.CompletionHandler completionHandler) {
        HttpURLConnection httpURLConnection;
        InputStreamReader inputStreamReader;
        String str2 = "?a=" + SingularInstance.getInstance().getSingularConfig().apiKey;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                str2 = str2 + "&" + Uri.encode(entry.getKey()) + "=" + Uri.encode(entry.getValue());
            }
        }
        try {
            httpURLConnection = buildRequest(getBaseUrl() + str + (str2 + "&h=" + Utils.sha1Hash(str2, SingularInstance.getInstance().getSingularConfig().secret)), map2);
            try {
            } catch (Throwable th) {
                th = th;
                try {
                    completionHandler.onFailure("Error sending request: message - " + th.getMessage());
                    this.logger.error(Utils.formatException(th));
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        if (httpURLConnection == null) {
            completionHandler.onFailure("Error sending request: connection is null");
            this.logger.error("Error sending request: connection is null");
            if (httpURLConnection != null) {
                return;
            }
            return;
        }
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
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
            if (readLine == null) {
                break;
            }
            stringBuffer.append(readLine);
        }
        completionHandler.onSuccess(stringBuffer.toString(), responseCode);
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.disconnect();
    }
}
