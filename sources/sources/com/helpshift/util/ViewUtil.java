package com.helpshift.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Insets;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.helpshift.log.HSLogger;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ViewUtil {
    private static final String TAG = "ViewUtil";

    private ViewUtil() {
    }

    public static void setVisibility(View view, boolean z) {
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static void setStatusBarColor(Activity activity, String str, View view) {
        if (activity != null) {
            if (Utils.isNotEmpty(str) && JsonUtils.isValidJsonString(str)) {
                try {
                    String optString = new JSONObject(str).optString("primaryColor", ConfigValues.DEFAULT_STATUSBAR_COLOR);
                    activity.getWindow().setStatusBarColor(Color.parseColor(optString));
                    if (Build.VERSION.SDK_INT < 35 || view == null) {
                        return;
                    }
                    view.setBackgroundColor(Color.parseColor(optString));
                    return;
                } catch (JSONException e) {
                    HSLogger.e(TAG, "Error setting status bar color", e);
                    return;
                }
            }
            activity.getWindow().setStatusBarColor(Color.parseColor(ConfigValues.DEFAULT_STATUSBAR_COLOR));
        }
    }

    public static void callJavascriptCode(WebView webView, String str, ValueCallback<String> valueCallback) {
        webView.evaluateJavascript(str, valueCallback);
    }

    public static Uri[] parseResultForFileFromWebView(Intent intent, int i) {
        if (intent == null) {
            return null;
        }
        if (intent.getClipData() == null) {
            return WebChromeClient.FileChooserParams.parseResult(i, intent);
        }
        return getUrisForMultipleFilesFromIntent(intent);
    }

    private static Uri[] getUrisForMultipleFilesFromIntent(Intent intent) {
        ClipData clipData = intent != null ? intent.getClipData() : null;
        if (clipData == null) {
            return new Uri[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < clipData.getItemCount(); i++) {
            Uri uri = clipData.getItemAt(i).getUri();
            if (uri != null) {
                arrayList.add(uri);
            }
        }
        return (Uri[]) arrayList.toArray(new Uri[0]);
    }

    public static void handleEdgeToEdgeLayout(View view, View view2) {
        try {
            if (Build.VERSION.SDK_INT < 35) {
                view2.setVisibility(8);
                return;
            }
            view2.setVisibility(0);
            view2.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.helpshift.util.ViewUtil$$ExternalSyntheticLambda0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view3, WindowInsets windowInsets) {
                    return ViewUtil.lambda$handleEdgeToEdgeLayout$0(view3, windowInsets);
                }
            });
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.helpshift.util.ViewUtil$$ExternalSyntheticLambda1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view3, WindowInsets windowInsets) {
                    return ViewUtil.lambda$handleEdgeToEdgeLayout$1(view3, windowInsets);
                }
            });
        } catch (Exception e) {
            HSLogger.e(TAG, "error in handling edge to edge layout", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WindowInsets lambda$handleEdgeToEdgeLayout$0(View view, WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.statusBars());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = insets.top;
        view.setLayoutParams(layoutParams);
        return windowInsets.consumeSystemWindowInsets();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WindowInsets lambda$handleEdgeToEdgeLayout$1(View view, WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout() | WindowInsets.Type.ime());
        view.setPadding(insets.left, 0, insets.right, insets.bottom);
        return windowInsets;
    }
}
