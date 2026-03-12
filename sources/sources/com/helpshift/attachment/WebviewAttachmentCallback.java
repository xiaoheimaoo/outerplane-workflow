package com.helpshift.attachment;

import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebView;
/* loaded from: classes3.dex */
public interface WebviewAttachmentCallback {
    void addWebviewToCurrentUI(WebView webView);

    void openFileChooser(Intent intent, int i);

    void sendIntentToSystemApp(Intent intent);

    void setAttachmentFilePathCallback(ValueCallback<Uri[]> valueCallback);
}
