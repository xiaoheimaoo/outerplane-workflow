package com.helpshift.attachment;

import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.helpshift.concurrency.HSThreadingService;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class WebviewAttachmentCallbackProxy {
    private final WeakReference<WebviewAttachmentCallback> callbackRef;
    private final HSThreadingService threadingService;

    public WebviewAttachmentCallbackProxy(WebviewAttachmentCallback webviewAttachmentCallback, HSThreadingService hSThreadingService) {
        this.callbackRef = new WeakReference<>(webviewAttachmentCallback);
        this.threadingService = hSThreadingService;
    }

    public void addWebviewToCurrentUI(final WebView webView) {
        this.threadingService.runOnUIThread(new Runnable() { // from class: com.helpshift.attachment.WebviewAttachmentCallbackProxy.1
            @Override // java.lang.Runnable
            public void run() {
                WebviewAttachmentCallback webviewAttachmentCallback = (WebviewAttachmentCallback) WebviewAttachmentCallbackProxy.this.callbackRef.get();
                if (webviewAttachmentCallback != null) {
                    webviewAttachmentCallback.addWebviewToCurrentUI(webView);
                }
            }
        });
    }

    public void setAttachmentFilePathCallback(ValueCallback<Uri[]> valueCallback) {
        WebviewAttachmentCallback webviewAttachmentCallback = this.callbackRef.get();
        if (webviewAttachmentCallback != null) {
            webviewAttachmentCallback.setAttachmentFilePathCallback(valueCallback);
        }
    }

    public void openFileChooser(Intent intent, int i) {
        WebviewAttachmentCallback webviewAttachmentCallback = this.callbackRef.get();
        if (webviewAttachmentCallback != null) {
            webviewAttachmentCallback.openFileChooser(intent, i);
        }
    }

    public void sendIntentToSystemApp(Intent intent) {
        WebviewAttachmentCallback webviewAttachmentCallback = this.callbackRef.get();
        if (webviewAttachmentCallback != null) {
            webviewAttachmentCallback.sendIntentToSystemApp(intent);
        }
    }
}
