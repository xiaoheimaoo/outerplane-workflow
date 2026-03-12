package com.helpshift.faq;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.browser.trusted.sharing.ShareTarget;
import com.helpshift.cache.HelpshiftResourceCacheManager;
import com.helpshift.core.HSContext;
import com.helpshift.log.HSLogger;
import com.helpshift.util.ResourceCacheUtil;
/* loaded from: classes3.dex */
public class HSHelpcenterWebViewClient extends WebViewClient {
    private static final String TAG = "HelpcntrWebClient";
    private final HSHelpcenterEventsHandler eventsHandler;
    private HelpshiftResourceCacheManager helpcenterResourceCacheManager;
    private boolean resourceCacheManagerInitialized;

    public HSHelpcenterWebViewClient(HelpshiftResourceCacheManager helpshiftResourceCacheManager, HSHelpcenterEventsHandler hSHelpcenterEventsHandler) {
        this.helpcenterResourceCacheManager = helpshiftResourceCacheManager;
        this.eventsHandler = hSHelpcenterEventsHandler;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("https://") || str.startsWith("http://")) {
            webView.loadUrl(str);
            return false;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (!ShareTarget.METHOD_GET.equalsIgnoreCase(webResourceRequest.getMethod())) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        initResourceCacheManager();
        if (!this.helpcenterResourceCacheManager.shouldCacheUrl(webResourceRequest.getUrl().getPath())) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        WebResourceResponse webResourceResponse = ResourceCacheUtil.getWebResourceResponse(this.helpcenterResourceCacheManager, webResourceRequest);
        if (webResourceResponse != null) {
            return webResourceResponse;
        }
        WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
        if (shouldInterceptRequest != null) {
            HSLogger.d(TAG, "Webview response received for request-" + webResourceRequest.toString() + " status:" + shouldInterceptRequest.getStatusCode() + " MimeType:" + shouldInterceptRequest.getMimeType());
        } else {
            HSLogger.e(TAG, "Webview response error for request-" + webResourceRequest.getUrl());
        }
        return shouldInterceptRequest;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        HSLogger.e(TAG, "HelpCenter load failed.Failed Status " + webResourceError.getErrorCode());
        if (HSContext.getInstance().getDevice().isOnline()) {
            return;
        }
        HSLogger.e(TAG, "No Internet Connection.Showing Retry UI");
        this.eventsHandler.onHelpcenterError();
    }

    private void initResourceCacheManager() {
        if (this.resourceCacheManagerInitialized) {
            return;
        }
        this.helpcenterResourceCacheManager.ensureCacheURLsListAvailable();
        this.resourceCacheManagerInitialized = true;
    }
}
