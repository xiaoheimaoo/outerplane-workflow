package com.helpshift.chat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.helpshift.HelpshiftEvent;
import com.helpshift.R;
import com.helpshift.activities.FragmentTransactionListener;
import com.helpshift.attachment.CommonWebChromeClient;
import com.helpshift.attachment.WebviewAttachmentCallback;
import com.helpshift.attachment.WebviewAttachmentCallbackProxy;
import com.helpshift.config.HSConfigManager;
import com.helpshift.core.HSContext;
import com.helpshift.core.HSJSGenerator;
import com.helpshift.log.HSLogger;
import com.helpshift.user_lifecyle.UserLifecycleListener;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.ConsumeOnceListener;
import com.helpshift.util.HSTimer;
import com.helpshift.util.Utils;
import com.helpshift.util.ViewUtil;
import com.helpshift.util.network.connectivity.HSConnectivityManager;
import com.helpshift.util.network.connectivity.HSNetworkConnectivityCallback;
import com.helpshift.views.HSWebView;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HSChatFragment extends Fragment implements HSWebchatToUiCallback, UserLifecycleListener, View.OnClickListener, HSNetworkConnectivityCallback, WebviewAttachmentCallback {
    public static final String LOCAL_HOST_URL = "https://localhost/";
    public static final String TAG = "HSChatFragment";
    private CommonWebChromeClient chromeClient;
    private TextView errorMessageTextView;
    private HSChatEventsHandler eventsHandler;
    private ValueCallback<Uri[]> filePathCallback;
    private boolean isWebchatSourceChanged;
    private View loadingView;
    private View retryView;
    private FragmentTransactionListener transactionListener;
    private HSWebView webView;
    private String webchatJsFileLoadingTime;
    private String webchatSource;
    private LinearLayout webviewLayout;
    private boolean shouldSendPollerEvent = true;
    private boolean isKeyboardVisible = false;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.helpshift.chat.HSChatFragment.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (HSChatFragment.this.webView == null) {
                return;
            }
            Rect rect = new Rect();
            HSChatFragment.this.webView.getWindowVisibleDisplayFrame(rect);
            int height = HSChatFragment.this.webView.getRootView().getHeight();
            boolean z = ((double) (height - rect.bottom)) > ((double) height) * 0.15d;
            if (z != HSChatFragment.this.isKeyboardVisible) {
                HSChatFragment.this.sendKeyboardToggleEvent(z);
            }
            HSChatFragment.this.isKeyboardVisible = z;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        HSLogger.d(TAG, "onCreateView() - " + hashCode());
        View inflate = layoutInflater.inflate(R.layout.hs__webchat_fragment_layout, viewGroup, false);
        if (getArguments() != null) {
            this.webchatSource = getArguments().getString("source");
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        HSLogger.d(TAG, "onViewCreated() - " + hashCode());
        HSContext.getInstance().getUserManager().addUserLifecycleListener(TAG, this);
        initViews(view);
        startChatView();
    }

    private void initViews(View view) {
        this.loadingView = view.findViewById(R.id.hs__loading_view);
        this.retryView = view.findViewById(R.id.hs__retry_view);
        this.errorMessageTextView = (TextView) view.findViewById(R.id.hs__error_message);
        this.webviewLayout = (LinearLayout) view.findViewById(R.id.hs__webview_layout);
        this.webView = (HSWebView) view.findViewById(R.id.hs__webchat_webview);
        view.findViewById(R.id.hs__retry_view_close_btn).setOnClickListener(this);
        view.findViewById(R.id.hs__loading_view_close_btn).setOnClickListener(this);
        view.findViewById(R.id.hs__retry_button).setOnClickListener(this);
    }

    private void startChatView() {
        HSContext hSContext = HSContext.getInstance();
        final String webchatEmbeddedCodeString = hSContext.getJsGenerator().getWebchatEmbeddedCodeString(getContext(), this.webchatSource);
        if (Utils.isEmpty(webchatEmbeddedCodeString)) {
            HSLogger.e(TAG, "Error in reading the source code from assets folder");
            onWebchatError("");
            return;
        }
        showLoadingView();
        hSContext.getUserManager().delayForDataSync(new WeakReference<>(new ConsumeOnceListener<Boolean>(hSContext.getHsThreadingService()) { // from class: com.helpshift.chat.HSChatFragment.2
            @Override // com.helpshift.util.ConsumeOnceListener
            public void consume(Boolean bool) {
                HSChatFragment.this.initWebviewWithWebchat(webchatEmbeddedCodeString);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWebviewWithWebchat(String str) {
        HSLogger.d(TAG, "Webview is launched");
        HSContext hSContext = HSContext.getInstance();
        HSChatEventsHandler hSChatEventsHandler = new HSChatEventsHandler(hSContext.getUserManager(), hSContext.getHsThreadingService(), hSContext.getConfigManager(), hSContext.getChatResourceCacheManager(), hSContext.getGenericDataManager(), hSContext.getNativeToSdkxMigrator());
        this.eventsHandler = hSChatEventsHandler;
        hSChatEventsHandler.setUiEventsListener(this);
        WebviewAttachmentCallbackProxy webviewAttachmentCallbackProxy = new WebviewAttachmentCallbackProxy(this, hSContext.getHsThreadingService());
        CommonWebChromeClient commonWebChromeClient = new CommonWebChromeClient("chatWVClient", webviewAttachmentCallbackProxy);
        this.chromeClient = commonWebChromeClient;
        commonWebChromeClient.setFilePathCallback(this.filePathCallback);
        this.webView.setWebChromeClient(this.chromeClient);
        this.webView.setWebViewClient(new HSChatWebViewClient(hSContext.getChatResourceCacheManager(), webviewAttachmentCallbackProxy));
        this.webView.addJavascriptInterface(new HSChatToNativeBridge(hSContext.getHsEventProxy(), this.eventsHandler), "HSInterface");
        this.webView.loadDataWithBaseURL(LOCAL_HOST_URL, str, "text/html", "utf-8", null);
    }

    public void setTransactionListener(FragmentTransactionListener fragmentTransactionListener) {
        this.transactionListener = fragmentTransactionListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        HSLogger.d(TAG, "onStop() - " + hashCode());
        if (this.shouldSendPollerEvent) {
            sendLifecycleEventToWebchat(false);
        }
        HSContext.getInstance().setWebchatUIIsOpen(false);
        this.webView.getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        HSLogger.d(TAG, "onStart() -" + hashCode());
        sendLifecycleEventToWebchat(true);
        HSContext.getInstance().setWebchatUIIsOpen(true);
        this.webView.getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        HSLogger.d(TAG, "onPause() -" + hashCode());
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isChangingConfigurations()) {
            HSContext.getInstance().getConversationPoller().startPoller();
        }
        HSConnectivityManager.getInstance(getContext()).unregisterNetworkConnectivityListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        HSLogger.d(TAG, "onResume() -" + hashCode());
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isChangingConfigurations()) {
            HSContext.getInstance().getConversationPoller().stopPoller();
        }
        HSConnectivityManager.getInstance(getContext()).registerNetworkConnectivityListener(this);
        HSContext hSContext = HSContext.getInstance();
        if (hSContext.isWebchatUIOpen() && this.isWebchatSourceChanged) {
            HSLogger.d(TAG, "Updating config with latest config in same webchat session");
            try {
                callWebchatApi("window.helpshiftConfig = JSON.parse(JSON.stringify(" + hSContext.getConfigManager().getWebchatConfigJs(hSContext.isIsWebchatOpenedFromHelpcenter(), this.webchatSource) + "));Helpshift('updateClientConfigWithoutReload');", null);
            } catch (Exception e) {
                HSLogger.e(TAG, "Failed to update webchat config with latest config ", e);
            }
        }
    }

    @Override // com.helpshift.attachment.WebviewAttachmentCallback
    public void sendIntentToSystemApp(Intent intent) {
        try {
            startActivity(intent);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in opening a link in system app", e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        HSLogger.d(TAG, "onDestroy() -" + hashCode());
        HSContext hSContext = HSContext.getInstance();
        hSContext.getUserManager().removeUserLifeCycleListener(TAG);
        HSChatEventsHandler hSChatEventsHandler = this.eventsHandler;
        if (hSChatEventsHandler != null) {
            hSChatEventsHandler.setUiEventsListener(null);
        }
        this.webviewLayout.removeView(this.webView);
        this.webView.destroyCustomWebview();
        this.webView = null;
        hSContext.getPersistentStorage().setLastRequestUnreadCountApiAccess(0L);
        hSContext.getUserManager().markAllPushMessagesAsRead();
    }

    @Override // com.helpshift.chat.HSWebchatToUiCallback
    public void onWebchatClosed() {
        HSLogger.d(TAG, "onWebchatClosed");
        FragmentTransactionListener fragmentTransactionListener = this.transactionListener;
        if (fragmentTransactionListener != null) {
            fragmentTransactionListener.closeWebchat();
        }
    }

    @Override // com.helpshift.chat.HSWebchatToUiCallback
    public void onWebchatLoaded() {
        HSLogger.d(TAG, "onWebchatLoaded");
        showWebchatView();
        clearNotifications();
        HSContext.getInstance().getUserManager().markAllMessagesAsRead();
        HSContext.getInstance().getUserManager().markAllPushMessagesAsRead();
        String migrationErrorLogs = HSContext.getInstance().getNativeToSdkxMigrator().getMigrationErrorLogs();
        if (Utils.isNotEmpty(migrationErrorLogs)) {
            callWebchatApi("Helpshift('sdkxMigrationLog', '" + migrationErrorLogs + "' ) ", null);
        }
        sendKeyboardToggleEvent(this.isKeyboardVisible);
        sendOrientationChangeEventToWebchat(getResources().getConfiguration().orientation);
        sendNetworkConfigurationChangeEvent(HSContext.getInstance().getDevice().isOnline() ? CustomTabsCallback.ONLINE_EXTRAS_KEY : "offline");
        if (Utils.isNotEmpty(this.webchatJsFileLoadingTime)) {
            sendTimeToLoadWebchatEvent(this.webchatJsFileLoadingTime);
        }
    }

    private void clearNotifications() {
        Context context = getContext();
        if (context != null) {
            ApplicationUtil.cancelNotification(context);
        }
    }

    @Override // com.helpshift.chat.HSWebchatToUiCallback
    public void onWebchatError(String str) {
        HSLogger.e(TAG, "Received onWebchatError event with error message: " + str);
        showErrorView(str);
    }

    @Override // com.helpshift.attachment.WebviewAttachmentCallback
    public void addWebviewToCurrentUI(WebView webView) {
        this.webviewLayout.addView(webView);
    }

    @Override // com.helpshift.chat.HSWebchatToUiCallback
    public void onUiConfigChange(String str) {
        FragmentTransactionListener fragmentTransactionListener = this.transactionListener;
        if (fragmentTransactionListener != null) {
            fragmentTransactionListener.changeStatusBarColor(str);
        }
    }

    @Override // com.helpshift.chat.HSWebchatToUiCallback
    public void onUserAuthenticationFailure() {
        HSLogger.e(TAG, "Received onUserAuthenticationFailure event");
        showErrorView("");
    }

    @Override // com.helpshift.chat.HSWebchatToUiCallback
    public void webchatJsFileLoaded() {
        long endTimer = HSTimer.endTimer(this.webchatSource);
        if (endTimer > 0) {
            this.webchatJsFileLoadingTime = getWebchatJsFileLoadingTime(Long.valueOf(endTimer));
        }
        HSLogger.d(TAG, "Webchat.js Loaded, Stopping loading timer");
    }

    private String getWebchatJsFileLoadingTime(Long l) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source", this.webchatSource);
            jSONObject.put("time", l.toString());
            return jSONObject.toString();
        } catch (Exception e) {
            HSLogger.e(TAG, "Failed to calculate webchat.js loading time", e);
            return "";
        }
    }

    @Override // com.helpshift.chat.HSWebchatToUiCallback
    public void requestConversationMetadata(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("bclConfig");
            int i2 = jSONObject.getInt("dbglConfig");
            HSLogger.d(TAG, "Log limits: breadcrumb: " + i + ", debug logs: " + i2);
            HSConfigManager configManager = HSContext.getInstance().getConfigManager();
            JSONArray breadCrumbs = configManager.getBreadCrumbs(i);
            JSONArray debugLogs = configManager.getDebugLogs(i2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("bcl", breadCrumbs);
            jSONObject2.put("dbgl", debugLogs);
            String jSONObject3 = jSONObject2.toString();
            HSLogger.d(TAG, "Sending log/crumb data to webchat: " + jSONObject3);
            callWebchatApi("Helpshift('syncConversationMetadata',JSON.stringify(" + jSONObject3 + "));", null);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error with request conversation meta call", e);
        }
    }

    @Override // com.helpshift.chat.HSWebchatToUiCallback
    public void setHelpcenterData() {
        try {
            String additionalInfo = HSContext.getInstance().getConfigManager().getAdditionalInfo();
            if (Utils.isEmpty(additionalInfo)) {
                additionalInfo = "{}";
            }
            callWebchatApi("Helpshift('setHelpcenterData',JSON.stringify(" + additionalInfo + "));", null);
            HSLogger.d(TAG, "Called setHelpcenterData function on webchat");
        } catch (Exception e) {
            HSLogger.e(TAG, "Error with setHelpcenterData call", e);
        }
    }

    @Override // com.helpshift.user_lifecyle.UserLifecycleListener
    public void onUserDidLogout() {
        HSLogger.d(TAG, "user logged out. Updating Webchat config");
        updateWebchatConfig();
    }

    @Override // com.helpshift.user_lifecyle.UserLifecycleListener
    public void onUserDidLogin() {
        HSLogger.d(TAG, "user logged in. Updating Webchat config");
        updateWebchatConfig();
    }

    public void setWebchatSourceChanged(String str) {
        this.isWebchatSourceChanged = true;
        HSLogger.d(TAG, "Webchat source changed to " + str + " from " + this.webchatSource);
        this.webchatSource = str;
    }

    public void updateWebchatConfig() {
        HSLogger.d(TAG, "Sending update helpshift config event to webchat");
        callWebchatApi(HSJSGenerator.updateWebChatConfig.replace("%config", HSContext.getInstance().getConfigManager().getWebchatConfigJs(false, this.webchatSource)), null);
    }

    @Override // com.helpshift.attachment.WebviewAttachmentCallback
    public void setAttachmentFilePathCallback(ValueCallback<Uri[]> valueCallback) {
        this.filePathCallback = valueCallback;
    }

    @Override // com.helpshift.attachment.WebviewAttachmentCallback
    public void openFileChooser(Intent intent, int i) {
        this.shouldSendPollerEvent = false;
        startActivityForResult(intent, i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        this.shouldSendPollerEvent = true;
        HSLogger.d(TAG, "onActivityResult, request code: " + i + " , resultCode: " + i2);
        if (i == 0) {
            this.filePathCallback.onReceiveValue(null);
        } else if (i == 1001) {
            if (this.filePathCallback == null) {
                HSLogger.d(TAG, "filePathCallback is null, return");
                return;
            }
            if (intent == null) {
                HSLogger.d(TAG, "intent is null");
            }
            this.filePathCallback.onReceiveValue(ViewUtil.parseResultForFileFromWebView(intent, i2));
            this.filePathCallback = null;
            this.chromeClient.setFilePathCallback(null);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.hs__loading_view_close_btn || id == R.id.hs__retry_view_close_btn) {
            onWebchatClosed();
        } else if (id == R.id.hs__retry_button) {
            startChatView();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        sendOrientationChangeEventToWebchat(configuration.orientation);
    }

    @Override // com.helpshift.util.network.connectivity.HSNetworkConnectivityCallback
    public void onNetworkAvailable() {
        sendNetworkConfigurationChangeEvent(CustomTabsCallback.ONLINE_EXTRAS_KEY);
    }

    @Override // com.helpshift.util.network.connectivity.HSNetworkConnectivityCallback
    public void onNetworkUnavailable() {
        sendNetworkConfigurationChangeEvent("offline");
    }

    private void showErrorView(String str) {
        setErrorMessage(str);
        hideKeyboard();
        ViewUtil.setVisibility(this.retryView, true);
        ViewUtil.setVisibility(this.loadingView, false);
    }

    private void hideKeyboard() {
        View view = getView();
        Context context = getContext();
        if (view == null || context == null) {
            return;
        }
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void setErrorMessage(String str) {
        this.errorMessageTextView.setText(str);
        ViewUtil.setVisibility(this.errorMessageTextView, !str.trim().isEmpty());
    }

    private void showWebchatView() {
        ViewUtil.setVisibility(this.loadingView, false);
        ViewUtil.setVisibility(this.retryView, false);
        ViewUtil.setVisibility(this.errorMessageTextView, false);
    }

    private void showLoadingView() {
        ViewUtil.setVisibility(this.loadingView, true);
        ViewUtil.setVisibility(this.retryView, false);
    }

    private void callWebchatApi(final String str, final ValueCallback<String> valueCallback) {
        HSContext.getInstance().getHsThreadingService().runOnUIThread(new Runnable() { // from class: com.helpshift.chat.HSChatFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (HSChatFragment.this.webView == null) {
                    HSLogger.d(HSChatFragment.TAG, "error callWebchatApi, webview is null");
                    return;
                }
                HSLogger.d(HSChatFragment.TAG, "Executing command: " + str);
                ViewUtil.callJavascriptCode(HSChatFragment.this.webView, str, valueCallback);
            }
        });
    }

    public void sendLifecycleEventToWebchat(boolean z) {
        callWebchatApi("Helpshift('sdkxIsInForeground'," + z + ");", null);
    }

    public void sendOrientationChangeEventToWebchat(int i) {
        callWebchatApi("Helpshift('onOrientationChange','" + (i == 1 ? "portrait" : "landscape") + "');", null);
    }

    public void sendKeyboardToggleEvent(boolean z) {
        callWebchatApi("Helpshift('onKeyboardToggle','" + (!z ? "close" : HelpshiftEvent.DATA_IS_ISSUE_OPEN) + "');", null);
    }

    public void sendTimeToLoadWebchatEvent(String str) {
        callWebchatApi("Helpshift('nativeLoadTime','" + str + "');", null);
    }

    public void sendNetworkConfigurationChangeEvent(String str) {
        callWebchatApi("Helpshift('onNetworkStatusChange','" + str + "');", null);
    }

    public void handleBackPress() {
        callWebchatApi("Helpshift('backBtnPress');", new ValueCallback<String>() { // from class: com.helpshift.chat.HSChatFragment.4
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                HSLogger.d(HSChatFragment.TAG, "Back press handle from webchat" + str);
                if (HSChatFragment.this.transactionListener != null) {
                    HSChatFragment.this.transactionListener.handleBackPress(Boolean.parseBoolean(str));
                }
            }
        });
    }
}
