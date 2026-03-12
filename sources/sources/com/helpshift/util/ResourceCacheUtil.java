package com.helpshift.util;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.helpshift.cache.HelpshiftResourceCacheManager;
import com.helpshift.log.HSLogger;
import java.io.InputStream;
import java.util.Map;
/* loaded from: classes3.dex */
public class ResourceCacheUtil {
    private static final String TAG = "ResCacheUtil";

    private ResourceCacheUtil() {
    }

    public static WebResourceResponse getWebResourceResponse(HelpshiftResourceCacheManager helpshiftResourceCacheManager, WebResourceRequest webResourceRequest) {
        Uri url = webResourceRequest.getUrl();
        String path = url.getPath();
        String query = url.getQuery();
        InputStream fetchCachedResource = helpshiftResourceCacheManager.fetchCachedResource(webResourceRequest.getUrl().toString(), path, query, webResourceRequest.getRequestHeaders());
        if (fetchCachedResource == null) {
            HSLogger.e(TAG, "Error in receiving response for intercepted request to be cached- " + url + " \n Path: " + path + "\n Query: " + query);
            return null;
        }
        String resourceMimeType = helpshiftResourceCacheManager.getResourceMimeType(path, query);
        Map<String, String> cachedResponseHeadersForResource = helpshiftResourceCacheManager.getCachedResponseHeadersForResource(path, query);
        HSLogger.d(TAG, "Response received for intercepted request to be cached- " + url.toString() + " MimeType:" + resourceMimeType);
        return new WebResourceResponse(resourceMimeType, "utf-8", 200, "OK", cachedResponseHeadersForResource, fetchCachedResource);
    }
}
