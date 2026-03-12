package com.helpshift.attachment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.helpshift.log.HSLogger;
import com.helpshift.log.WebviewConsoleLogger;
import com.helpshift.util.Utils;
/* loaded from: classes3.dex */
public class CommonWebChromeClient extends WebChromeClient {
    private final String TAG;
    private final WebviewAttachmentCallbackProxy attachmentCallbackProxy;
    private ValueCallback<Uri[]> filePathCallback;

    public void setFilePathCallback(ValueCallback<Uri[]> valueCallback) {
        this.filePathCallback = valueCallback;
    }

    public CommonWebChromeClient(String str, WebviewAttachmentCallbackProxy webviewAttachmentCallbackProxy) {
        this.TAG = str;
        this.attachmentCallbackProxy = webviewAttachmentCallbackProxy;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        WebviewConsoleLogger.log(consoleMessage.messageLevel(), this.TAG, consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        if (z2) {
            WebView.HitTestResult hitTestResult = webView.getHitTestResult();
            String createUriForSystemAppLaunch = createUriForSystemAppLaunch(hitTestResult.getType(), hitTestResult.getExtra());
            if (Utils.isNotEmpty(createUriForSystemAppLaunch)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(createUriForSystemAppLaunch));
                this.attachmentCallbackProxy.sendIntentToSystemApp(intent);
                return true;
            }
            WebView webView2 = new WebView(webView.getContext());
            this.attachmentCallbackProxy.addWebviewToCurrentUI(webView2);
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }
        return false;
    }

    private String createUriForSystemAppLaunch(int i, String str) {
        if (i != 2) {
            return i != 7 ? "" : str;
        }
        return "tel:" + str;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (this.filePathCallback != null) {
            HSLogger.d(this.TAG, "filePathCallback is not null, returning false.");
            this.filePathCallback.onReceiveValue(null);
            this.filePathCallback = null;
            return false;
        }
        this.filePathCallback = valueCallback;
        this.attachmentCallbackProxy.setAttachmentFilePathCallback(valueCallback);
        try {
            Intent createIntent = fileChooserParams.createIntent();
            createIntent.setType("*/*");
            String[] acceptTypes = fileChooserParams.getAcceptTypes();
            if (acceptTypes.length != 0) {
                createIntent.putExtra("android.intent.extra.MIME_TYPES", acceptTypes);
            }
            createIntent.setAction("android.intent.action.OPEN_DOCUMENT");
            createIntent.addCategory("android.intent.category.OPENABLE");
            HSLogger.d(this.TAG, "Starting open file chooser request.");
            this.attachmentCallbackProxy.openFileChooser(createIntent, 1001);
            HSLogger.d(this.TAG, "onShowFileChooser success, returning true");
            return true;
        } catch (ActivityNotFoundException e) {
            HSLogger.e(this.TAG, "ActivityNotFoundException error in opening the attachment file chooser.", e);
            this.filePathCallback = null;
            return true;
        } catch (Exception e2) {
            HSLogger.e(this.TAG, "error in opening the attachment in browser window, returning false", e2);
            this.filePathCallback = null;
            return false;
        }
    }
}
