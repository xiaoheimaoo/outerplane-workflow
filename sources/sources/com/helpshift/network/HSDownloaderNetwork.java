package com.helpshift.network;

import com.google.common.net.HttpHeaders;
import com.helpshift.log.HSLogger;
import com.helpshift.util.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HSDownloaderNetwork {
    private static final String TAG = "dwnldrNet";
    private final URLConnectionProvider urlConnectionProvider;

    private boolean isSuccessful(int i) {
        return i >= 200 && i <= 300;
    }

    public HSDownloaderNetwork(URLConnectionProvider uRLConnectionProvider) {
        this.urlConnectionProvider = uRLConnectionProvider;
    }

    public HSDownloaderResponse downloadResource(String str, Map<String, String> map, File file) {
        InputStream inputStream;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        FileOutputStream fileOutputStream;
        String str6 = "";
        String str7 = "utf-8";
        JSONObject jSONObject = new JSONObject();
        boolean z2 = false;
        int i = 404;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) this.urlConnectionProvider.getURL(str).openConnection();
                    map.put(HttpHeaders.ACCEPT_ENCODING, "gzip");
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    i = httpsURLConnection.getResponseCode();
                    str7 = httpsURLConnection.getContentEncoding();
                    String contentType = httpsURLConnection.getContentType();
                    try {
                        Map<String, List<String>> headerFields = httpsURLConnection.getHeaderFields();
                        processResponseHeaders(headerFields, jSONObject);
                        str6 = extractETag(headerFields);
                        if (isSuccessful(i)) {
                            inputStream = createInputStream(httpsURLConnection, str7);
                            try {
                                fileOutputStream = new FileOutputStream(file);
                            } catch (UnknownHostException e) {
                                e = e;
                                str2 = str6;
                                str6 = contentType;
                                HSLogger.e(TAG, "Error downloading resource: " + str + " \n " + e.getMessage());
                                Utils.closeQuietly(fileOutputStream2);
                                Utils.closeQuietly(inputStream);
                                str3 = str2;
                                str4 = str6;
                                str5 = str7;
                                z = false;
                                return new HSDownloaderResponse(i, jSONObject, str3, str4, str5, z);
                            } catch (Exception e2) {
                                e = e2;
                                str2 = str6;
                                str6 = contentType;
                                HSLogger.e(TAG, "Error downloading resource: " + str, e);
                                Utils.closeQuietly(fileOutputStream2);
                                Utils.closeQuietly(inputStream);
                                str3 = str2;
                                str4 = str6;
                                str5 = str7;
                                z = false;
                                return new HSDownloaderResponse(i, jSONObject, str3, str4, str5, z);
                            }
                            try {
                                saveResourceToFile(inputStream, fileOutputStream);
                                fileOutputStream2 = fileOutputStream;
                            } catch (UnknownHostException e3) {
                                e = e3;
                                str2 = str6;
                                str6 = contentType;
                                fileOutputStream2 = fileOutputStream;
                                HSLogger.e(TAG, "Error downloading resource: " + str + " \n " + e.getMessage());
                                Utils.closeQuietly(fileOutputStream2);
                                Utils.closeQuietly(inputStream);
                                str3 = str2;
                                str4 = str6;
                                str5 = str7;
                                z = false;
                                return new HSDownloaderResponse(i, jSONObject, str3, str4, str5, z);
                            } catch (Exception e4) {
                                e = e4;
                                str2 = str6;
                                str6 = contentType;
                                fileOutputStream2 = fileOutputStream;
                                HSLogger.e(TAG, "Error downloading resource: " + str, e);
                                Utils.closeQuietly(fileOutputStream2);
                                Utils.closeQuietly(inputStream);
                                str3 = str2;
                                str4 = str6;
                                str5 = str7;
                                z = false;
                                return new HSDownloaderResponse(i, jSONObject, str3, str4, str5, z);
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream2 = fileOutputStream;
                                Utils.closeQuietly(fileOutputStream2);
                                Utils.closeQuietly(inputStream);
                                throw th;
                            }
                        } else {
                            inputStream = null;
                        }
                        if (isSuccessful(i) || i == 304) {
                            HSLogger.d(TAG, "Successfully downloaded the resource with Url: " + str + " headers: " + map);
                            z2 = true;
                        }
                        Utils.closeQuietly(fileOutputStream2);
                        Utils.closeQuietly(inputStream);
                        str3 = str6;
                        z = z2;
                        str4 = contentType;
                        str5 = str7;
                    } catch (UnknownHostException e5) {
                        e = e5;
                        str2 = str6;
                        inputStream = null;
                    } catch (Exception e6) {
                        e = e6;
                        str2 = str6;
                        inputStream = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                }
            } catch (UnknownHostException e7) {
                e = e7;
                str2 = "";
                inputStream = null;
            } catch (Exception e8) {
                e = e8;
                str2 = "";
                inputStream = null;
            }
            return new HSDownloaderResponse(i, jSONObject, str3, str4, str5, z);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void processResponseHeaders(Map<String, List<String>> map, JSONObject jSONObject) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null || entry.getValue() != null) {
                String key = entry.getKey() == null ? "" : entry.getKey();
                jSONObject.put(key, generateHeaderValue(entry.getValue()));
                if (HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN.equalsIgnoreCase(key)) {
                    jSONObject.put(key, "*");
                }
            }
        }
    }

    private String extractETag(Map<String, List<String>> map) {
        List<String> list = map.get("etag");
        return Utils.isNotEmpty(list) ? list.get(0) : "";
    }

    private InputStream createInputStream(HttpsURLConnection httpsURLConnection, String str) throws IOException {
        InputStream inputStream = httpsURLConnection.getInputStream();
        return (inputStream != null && Utils.isNotEmpty(str) && str.contains("gzip")) ? new GZIPInputStream(inputStream) : inputStream;
    }

    private void saveResourceToFile(InputStream inputStream, FileOutputStream fileOutputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                HSLogger.e(TAG, "Error saving resource to file: ", e);
                return;
            }
        }
    }

    private static String generateHeaderValue(List<String> list) {
        if (Utils.isEmpty(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(";").append(list.get(i));
        }
        return sb.toString();
    }
}
