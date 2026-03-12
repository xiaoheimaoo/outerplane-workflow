package com.helpshift.faq;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.helpshift.R;
import com.helpshift.activities.FragmentTransactionListener;
import com.helpshift.activities.HSMainActivity;
import com.helpshift.attachment.CommonWebChromeClient;
import com.helpshift.attachment.WebviewAttachmentCallback;
import com.helpshift.attachment.WebviewAttachmentCallbackProxy;
import com.helpshift.cache.HelpshiftResourceCacheManager;
import com.helpshift.core.HSContext;
import com.helpshift.core.HSJSGenerator;
import com.helpshift.log.HSLogger;
import com.helpshift.notification.NotificationReceivedCallback;
import com.helpshift.user.UserManager;
import com.helpshift.user_lifecyle.UserLifecycleListener;
import com.helpshift.util.ConfigValues;
import com.helpshift.util.ConsumeOnceListener;
import com.helpshift.util.Utils;
import com.helpshift.util.ValuePair;
import com.helpshift.util.ViewUtil;
import com.helpshift.views.HSWebView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class HSHelpcenterFragment extends Fragment implements HelpcenterToUiCallback, NotificationReceivedCallback, View.OnClickListener, WebviewAttachmentCallback, UserLifecycleListener {
    public static final String TAG = "HelpCenter";
    private CommonWebChromeClient chromeClient;
    private ImageView errorImageView;
    private HSHelpcenterEventsHandler eventsHandler;
    private ValueCallback<Uri[]> filePathCallback;
    private HSWebView helpCenterWebview;
    private LinearLayout helpcenterLayout;
    private View loadingView;
    private View retryView;
    private FragmentTransactionListener transactionListener;

    public static HSHelpcenterFragment newInstance(Bundle bundle) {
        HSHelpcenterFragment hSHelpcenterFragment = new HSHelpcenterFragment();
        hSHelpcenterFragment.setArguments(bundle);
        return hSHelpcenterFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        HSLogger.d(TAG, "onCreateView - " + hashCode());
        return layoutInflater.inflate(R.layout.hs__helpcenter_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        HSLogger.d(TAG, "onViewCreated - " + hashCode());
        Bundle arguments = getArguments();
        HSContext.getInstance().getUserManager().addUserLifecycleListener(TAG, this);
        initViews(view);
        startHelpcenter(arguments);
    }

    private void initViews(View view) {
        this.helpCenterWebview = (HSWebView) view.findViewById(R.id.hs__helpcenter_view);
        this.loadingView = view.findViewById(R.id.hs__loading_view);
        this.errorImageView = (ImageView) view.findViewById(R.id.hs__error_image);
        ((ImageView) view.findViewById(R.id.hs__chat_image)).setVisibility(8);
        this.retryView = view.findViewById(R.id.hs__retry_view);
        this.helpcenterLayout = (LinearLayout) view.findViewById(R.id.hs__helpcenter_layout);
        view.findViewById(R.id.hs__retry_view_close_btn).setOnClickListener(this);
        view.findViewById(R.id.hs__loading_view_close_btn).setOnClickListener(this);
        view.findViewById(R.id.hs__retry_button).setOnClickListener(this);
    }

    private void startHelpcenter(Bundle bundle) {
        if (bundle == null) {
            HSLogger.e(TAG, "Bundle received in Helpcenter fragment is null.");
            onHelpcenterError();
            return;
        }
        final String sourceCode = getSourceCode(bundle);
        if (Utils.isEmpty(sourceCode)) {
            HSLogger.e(TAG, "Error in reading the source code from assets folder.");
            onHelpcenterError();
            return;
        }
        showLoading();
        HSContext hSContext = HSContext.getInstance();
        hSContext.getUserManager().delayForDataSync(new WeakReference<>(new ConsumeOnceListener<Boolean>(hSContext.getHsThreadingService()) { // from class: com.helpshift.faq.HSHelpcenterFragment.1
            @Override // com.helpshift.util.ConsumeOnceListener
            public void consume(Boolean bool) {
                HSHelpcenterFragment.this.initWebviewWithHelpcenter(sourceCode);
            }
        }));
    }

    private String getSourceCode(Bundle bundle) {
        ValuePair<String, String> helpcenterModes = getHelpcenterModes(bundle);
        return HSContext.getInstance().getJsGenerator().getHelpcenterEmbeddedCodeString(getContext(), helpcenterModes.first, helpcenterModes.second, isWebchatInStackAlready(), bundle.getString("source"));
    }

    private ValuePair<String, String> getHelpcenterModes(Bundle bundle) {
        String string;
        String string2 = bundle.getString(ConfigValues.HELPCENTER_MODE_KEY);
        string2.hashCode();
        String str = "";
        if (string2.equals(ConfigValues.HELPCENTER_MODE_FAQ_SECTION)) {
            string = bundle.getString(ConfigValues.FAQ_SECTION_ID_KEY);
        } else if (string2.equals(ConfigValues.HELPCENTER_MODE_SINGLE_FAQ)) {
            str = bundle.getString(ConfigValues.SINGLE_FAQ_PUBLISH_ID_KEY);
            string = "";
        } else {
            string = "";
        }
        return new ValuePair<>(str, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWebviewWithHelpcenter(String str) {
        HSLogger.d(TAG, "Webview is launched");
        HSContext hSContext = HSContext.getInstance();
        HelpshiftResourceCacheManager helpcenterResourceCacheManager = hSContext.getHelpcenterResourceCacheManager();
        HSHelpcenterEventsHandler hSHelpcenterEventsHandler = new HSHelpcenterEventsHandler(hSContext.getUserManager(), hSContext.getConfigManager(), hSContext.getHsThreadingService(), helpcenterResourceCacheManager);
        this.eventsHandler = hSHelpcenterEventsHandler;
        hSHelpcenterEventsHandler.setHelpcenterUiCallback(this);
        CommonWebChromeClient commonWebChromeClient = new CommonWebChromeClient("HCWVClient", new WebviewAttachmentCallbackProxy(this, hSContext.getHsThreadingService()));
        this.chromeClient = commonWebChromeClient;
        commonWebChromeClient.setFilePathCallback(this.filePathCallback);
        this.helpCenterWebview.setWebChromeClient(this.chromeClient);
        this.helpCenterWebview.setWebViewClient(new HSHelpcenterWebViewClient(helpcenterResourceCacheManager, this.eventsHandler));
        this.helpCenterWebview.addJavascriptInterface(new HelpcenterToNativeBridge(this.eventsHandler), "HCInterface");
        this.helpCenterWebview.loadDataWithBaseURL("https://localhost", str, "text/html", "utf-8", null);
    }

    public boolean canHelpCenterNavigateBack() {
        if (this.retryView.getVisibility() == 0 || this.loadingView.getVisibility() == 0) {
            return false;
        }
        return canHelpcenterWebviewGoBack();
    }

    public boolean canHelpcenterWebviewGoBack() {
        return this.helpCenterWebview.canGoBack();
    }

    public void helpcenterWebviewGoBack() {
        callHelpcenterApi(HSJSGenerator.backBtnClickJs);
        this.helpCenterWebview.goBack();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        HSLogger.d(TAG, "onStart - " + hashCode());
        HSContext.getInstance().getNotificationManager().setNotificationReceivedCallback(this);
        sendLifecycleEventToHelpCenter(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        sendLifecycleEventToHelpCenter(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        HSLogger.d(TAG, "onDestroy - " + hashCode());
        HSContext hSContext = HSContext.getInstance();
        hSContext.getNotificationManager().setNotificationReceivedCallback(null);
        hSContext.getUserManager().removeUserLifeCycleListener(TAG);
        HSHelpcenterEventsHandler hSHelpcenterEventsHandler = this.eventsHandler;
        if (hSHelpcenterEventsHandler != null) {
            hSHelpcenterEventsHandler.setHelpcenterUiCallback(null);
        }
        hSContext.setIsWebchatOpenedFromHelpcenter(false);
        this.helpcenterLayout.removeView(this.helpCenterWebview);
        this.helpCenterWebview.destroyCustomWebview();
        this.helpCenterWebview = null;
    }

    @Override // com.helpshift.faq.HelpcenterToUiCallback
    public void closeHelpcenter() {
        FragmentTransactionListener fragmentTransactionListener = this.transactionListener;
        if (fragmentTransactionListener != null) {
            fragmentTransactionListener.closeHelpcenter();
        }
    }

    @Override // com.helpshift.faq.HelpcenterToUiCallback
    public void openWebchat() {
        if (this.transactionListener != null) {
            HSContext.getInstance().setIsWebchatOpenedFromHelpcenter(true);
            this.transactionListener.openWebchat();
        }
    }

    @Override // com.helpshift.faq.HelpcenterToUiCallback
    public void onHelpcenterLoaded() {
        showHelpcenter();
    }

    @Override // com.helpshift.faq.HelpcenterToUiCallback
    public void setNativeUiColors(String str) {
        FragmentTransactionListener fragmentTransactionListener = this.transactionListener;
        if (fragmentTransactionListener != null) {
            fragmentTransactionListener.changeStatusBarColor(str);
        }
    }

    @Override // com.helpshift.attachment.WebviewAttachmentCallback
    public void addWebviewToCurrentUI(WebView webView) {
        this.helpcenterLayout.addView(webView);
    }

    @Override // com.helpshift.attachment.WebviewAttachmentCallback
    public void sendIntentToSystemApp(Intent intent) {
        try {
            startActivity(intent);
        } catch (Exception e) {
            HSLogger.e(TAG, "Unable to resolve the activity for this intent", e);
        }
    }

    @Override // com.helpshift.faq.HelpcenterToUiCallback
    public void showNotificationBadgeOnHCLoad() {
        onNotificationReceived();
    }

    @Override // com.helpshift.faq.HelpcenterToUiCallback
    public void getWebchatData() {
        setWebChatLocalStorageData();
    }

    @Override // com.helpshift.attachment.WebviewAttachmentCallback
    public void setAttachmentFilePathCallback(ValueCallback<Uri[]> valueCallback) {
        this.filePathCallback = valueCallback;
    }

    @Override // com.helpshift.attachment.WebviewAttachmentCallback
    public void openFileChooser(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
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
            closeHelpcenter();
        } else if (id == R.id.hs__retry_button) {
            showLoading();
            this.helpCenterWebview.reload();
        }
    }

    public void sendLifecycleEventToHelpCenter(boolean z) {
        if (this.loadingView.getVisibility() != 0) {
            callHelpcenterApi(HSJSGenerator.sendForegroundEvent.replace("%foreground", "" + z));
        }
    }

    private void showLoading() {
        ViewUtil.setVisibility(this.loadingView, true);
        ViewUtil.setVisibility(this.retryView, false);
    }

    private void showHelpcenter() {
        ViewUtil.setVisibility(this.loadingView, false);
        ViewUtil.setVisibility(this.retryView, false);
    }

    private void showError() {
        if (HSContext.getInstance().getDevice().isOnline()) {
            this.errorImageView.setImageResource(R.drawable.hs__error_icon);
        } else {
            this.errorImageView.setImageResource(R.drawable.hs__no_internet_icon);
        }
        ViewUtil.setVisibility(this.retryView, true);
        ViewUtil.setVisibility(this.loadingView, false);
    }

    @Override // com.helpshift.faq.HelpcenterToUiCallback
    public void onHelpcenterError() {
        showError();
    }

    public void setFragmentTransactionListener(FragmentTransactionListener fragmentTransactionListener) {
        this.transactionListener = fragmentTransactionListener;
    }

    @Override // com.helpshift.notification.NotificationReceivedCallback
    public void onNotificationReceived() {
        UserManager userManager = HSContext.getInstance().getUserManager();
        int unreadNotificationCount = userManager.getUnreadNotificationCount();
        int pushUnreadNotificationCount = userManager.getPushUnreadNotificationCount();
        if (unreadNotificationCount > 0 || pushUnreadNotificationCount > 0) {
            callHelpcenterApi(HSJSGenerator.showNotificationBadgeJS.replace("%count", String.valueOf(Math.max(unreadNotificationCount, pushUnreadNotificationCount))));
        }
    }

    public void setWebChatLocalStorageData() {
        callHelpcenterApi(HSJSGenerator.sendWebchatData.replace("%data", HSContext.getInstance().getConfigManager().getLocalStorageData()));
    }

    public void reloadIframe(Bundle bundle) {
        ValuePair<String, String> helpcenterModes = getHelpcenterModes(bundle);
        callHelpcenterApi(HSJSGenerator.reloadIframeJS.replace("%helpshiftConfig", HSContext.getInstance().getConfigManager().getHelpcenterConfigJs(helpcenterModes.first, helpcenterModes.second, isWebchatInStackAlready(), bundle.getString("source"))));
    }

    public void callHelpcenterApi(final String str) {
        HSContext.getInstance().getHsThreadingService().runOnUIThread(new Runnable() { // from class: com.helpshift.faq.HSHelpcenterFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (HSHelpcenterFragment.this.helpCenterWebview == null) {
                    HSLogger.d(HSHelpcenterFragment.TAG, "error callHelpcenterApi, webview is null");
                    return;
                }
                HSLogger.d(HSHelpcenterFragment.TAG, "Executing command: " + str);
                ViewUtil.callJavascriptCode(HSHelpcenterFragment.this.helpCenterWebview, str, null);
            }
        });
    }

    private boolean isWebchatInStackAlready() {
        FragmentActivity activity = getActivity();
        if (activity instanceof HSMainActivity) {
            return ((HSMainActivity) activity).isWebchatFragmentInStack();
        }
        return false;
    }

    @Override // com.helpshift.user_lifecyle.UserLifecycleListener
    public void onUserDidLogout() {
        HSLogger.d(TAG, "user logged out. Updating HC config");
        updateHelpcenterConfig();
    }

    @Override // com.helpshift.user_lifecyle.UserLifecycleListener
    public void onUserDidLogin() {
        HSLogger.d(TAG, "user logged in. Updating HC config");
        updateHelpcenterConfig();
    }

    private void updateHelpcenterConfig() {
        HSLogger.d(TAG, "Sending update helpshift config event to helpcenter");
        Bundle arguments = getArguments();
        callHelpcenterApi(HSJSGenerator.updateHelpCenterConfig.replace("%helpshiftConfig", HSContext.getInstance().getConfigManager().getHelpcenterConfigJs("", "", isWebchatInStackAlready(), arguments != null ? arguments.getString("source", "") : ConfigValues.SOURCE_API)));
    }
}
