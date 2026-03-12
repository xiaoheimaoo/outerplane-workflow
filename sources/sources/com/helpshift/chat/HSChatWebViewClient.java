package com.helpshift.chat;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.browser.trusted.sharing.ShareTarget;
import com.helpshift.attachment.WebviewAttachmentCallbackProxy;
import com.helpshift.cache.HelpshiftResourceCacheManager;
import com.helpshift.log.HSLogger;
import com.helpshift.util.ResourceCacheUtil;
/* loaded from: classes3.dex */
public class HSChatWebViewClient extends WebViewClient {
    private static final String TAG = "ChatWebClient";
    private final WebviewAttachmentCallbackProxy attachmentCallbackProxy;
    private final HelpshiftResourceCacheManager chatResourceCacheManager;
    private boolean resourceCacheManagerInitialized;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HSChatWebViewClient(HelpshiftResourceCacheManager helpshiftResourceCacheManager, WebviewAttachmentCallbackProxy webviewAttachmentCallbackProxy) {
        this.chatResourceCacheManager = helpshiftResourceCacheManager;
        this.attachmentCallbackProxy = webviewAttachmentCallbackProxy;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.attachmentCallbackProxy.sendIntentToSystemApp(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (!ShareTarget.METHOD_GET.equalsIgnoreCase(webResourceRequest.getMethod())) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        initResourceCacheManager();
        if (!this.chatResourceCacheManager.shouldCacheUrl(webResourceRequest.getUrl().getPath())) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        WebResourceResponse webResourceResponse = ResourceCacheUtil.getWebResourceResponse(this.chatResourceCacheManager, webResourceRequest);
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

    private void initResourceCacheManager() {
        if (this.resourceCacheManagerInitialized) {
            return;
        }
        this.chatResourceCacheManager.ensureCacheURLsListAvailable();
        this.resourceCacheManagerInitialized = true;
    }
}
