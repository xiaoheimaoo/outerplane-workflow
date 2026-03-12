package com.helpshift.activities;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.helpshift.HSActivityEventHandler;
import com.helpshift.HelpshiftEvent;
import com.helpshift.R;
import com.helpshift.chat.HSChatFragment;
import com.helpshift.config.HSConfigManager;
import com.helpshift.core.HSContext;
import com.helpshift.faq.HSHelpcenterFragment;
import com.helpshift.log.HSLogger;
import com.helpshift.util.ActivityUtil;
import com.helpshift.util.ConfigValues;
import com.helpshift.util.HSTimer;
import com.helpshift.util.Utils;
import com.helpshift.util.ViewUtil;
import java.util.List;
/* loaded from: classes3.dex */
public class HSMainActivity extends AppCompatActivity implements View.OnClickListener, FragmentTransactionListener, HSActivityEventHandler {
    private static final String TAG = "chatActvty";
    private HSConfigManager configManager;
    private ImageView errorImageView;
    private FragmentManager fragmentManager;
    private boolean isHelpcenterOpenedBefore;
    View parentView;
    private View retryView;
    View topBar;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            if (!HSContext.installCallSuccessful.get()) {
                bundle = null;
            }
            super.onCreate(bundle);
            if (!HSContext.installCallSuccessful.get()) {
                Log.e(TAG, "Install call not successful, falling back to launcher activity");
                ActivityUtil.startLauncherActivityAndFinish(this);
                return;
            }
            HSLogger.d(TAG, "HSMainActivity onCreate after install call check");
            setContentView(R.layout.hs__chat_activity_layout);
            this.parentView = findViewById(R.id.parent_view);
            View findViewById = findViewById(R.id.view_top_bar);
            this.topBar = findViewById;
            ViewUtil.handleEdgeToEdgeLayout(this.parentView, findViewById);
            try {
                setRequestedOrientation(HSContext.getInstance().getPersistentStorage().getRequestedScreenOrientation());
            } catch (Exception e) {
                HSLogger.e(TAG, "Error setting orientation.", e);
            }
            initViews();
            saveWebViewVersion();
            HSContext hSContext = HSContext.getInstance();
            HSContext.getInstance().getAnalyticsEventDM().sendAllAppLaunchEvents();
            this.fragmentManager = getSupportFragmentManager();
            this.configManager = hSContext.getConfigManager();
            initService(getIntent(), false);
            initStatusBarColorOnServiceChange();
            HSContext.getInstance().setHSActivityHandler(Integer.valueOf(hashCode()), this);
        } catch (Exception e2) {
            Log.e(TAG, "Caught exception in HSMainActivity.onCreate()", e2);
            if (HSContext.installCallSuccessful.get()) {
                return;
            }
            ActivityUtil.startLauncherActivityAndFinish(this);
        }
    }

    private void saveWebViewVersion() {
        PackageInfo currentWebViewPackage;
        if (Build.VERSION.SDK_INT < 26 || (currentWebViewPackage = WebView.getCurrentWebViewPackage()) == null || Utils.isEmpty(currentWebViewPackage.versionName)) {
            return;
        }
        HSContext.getInstance().getConfigManager().saveWebViewVersion(currentWebViewPackage.versionName);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        HSLogger.d(TAG, "HSMainActivity onStart");
        HSContext hSContext = HSContext.getInstance();
        hSContext.setSdkIsOpen(true);
        hSContext.getHsEventProxy().sendEvent(HelpshiftEvent.SDK_SESSION_STARTED, null);
        hSContext.getUserManager().stopIdentityDataSyncPoller("sdk_open");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        HSLogger.d(TAG, "HSMainActivity onStop");
        HSContext hSContext = HSContext.getInstance();
        hSContext.setSdkIsOpen(false);
        hSContext.getHsEventProxy().sendEvent(HelpshiftEvent.SDK_SESSION_ENDED, null);
        hSContext.getUserManager().startIdentityDataSyncPoller("sdk_close");
    }

    private void initViews() {
        this.retryView = findViewById(R.id.hs__retry_view);
        this.errorImageView = (ImageView) findViewById(R.id.hs__error_image);
        findViewById(R.id.hs__retry_button).setOnClickListener(this);
        findViewById(R.id.hs__retry_view_close_btn).setOnClickListener(this);
    }

    private void initService(Intent intent, boolean z) {
        if (!areConditionsValidToStartService(intent)) {
            showError();
            return;
        }
        Bundle extras = intent.getExtras();
        if (isWebchatServiceRequested(extras)) {
            startWebchatFlow(z, sourceRequestingWebchat(extras));
        } else {
            startHelpcenterFlow(intent, z);
        }
        hideError();
    }

    private void showError() {
        ViewUtil.setVisibility(this.retryView, true);
    }

    private void hideError() {
        ViewUtil.setVisibility(this.retryView, false);
    }

    private boolean isWebchatServiceRequested(Bundle bundle) {
        return ConfigValues.WEBCHAT_SERVICE.equalsIgnoreCase(bundle.getString(ConfigValues.SERVICE_MODE_KEY));
    }

    private String sourceRequestingWebchat(Bundle bundle) {
        return bundle.getString("source");
    }

    private boolean isHelpcenterServiceRequested(Bundle bundle) {
        return ConfigValues.HELP_CENTER_SERVICE.equalsIgnoreCase(bundle.getString(ConfigValues.SERVICE_MODE_KEY));
    }

    private boolean areConditionsValidToStartService(Intent intent) {
        if (intent.getExtras() == null) {
            return false;
        }
        if (HSContext.getInstance().getDevice().isOnline()) {
            return true;
        }
        this.errorImageView.setImageResource(R.drawable.hs__no_internet_icon);
        return false;
    }

    public boolean isWebchatFragmentInStack() {
        boolean z = getSupportFragmentManager().findFragmentByTag(HSChatFragment.TAG) != null;
        HSLogger.d(TAG, "isWebchatFragmentInStack: " + z);
        return z;
    }

    private void startWebchatFlow(boolean z, String str) {
        HSLogger.d(TAG, "Trying to start webchat flow");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentById = supportFragmentManager.findFragmentById(R.id.hs__container);
        List<Fragment> fragments = supportFragmentManager.getFragments();
        if (findFragmentById instanceof HSChatFragment) {
            HSLogger.d(TAG, "HSChatFragment is at top of stack, resuming");
            if (ConfigValues.SOURCE_PROACTIVE.equals(str)) {
                HSLogger.d(TAG, "Update config with proactive outbound config in same webchat session");
                ((HSChatFragment) findFragmentById).setWebchatSourceChanged(ConfigValues.SOURCE_PROACTIVE);
            }
            ((HSChatFragment) findFragmentById).setTransactionListener(this);
            return;
        }
        if ((findFragmentById instanceof HSHelpcenterFragment) && Utils.isNotEmpty(fragments)) {
            HSLogger.d(TAG, "HSHelpcenterFragment at top and HSChatFragment in stack, removing chat fragment");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(HSChatFragment.TAG);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            beginTransaction.commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        }
        HSLogger.d(TAG, "Creating new HSChatFragment: " + str + ", add to backstack: " + z);
        if (HSContext.getInstance().isIsWebchatOpenedFromHelpcenter()) {
            HSTimer.setStartTime("helpcenter");
        }
        if (ConfigValues.SOURCE_NOTIFICATION.equalsIgnoreCase(str)) {
            HSTimer.setStartTime(ConfigValues.SOURCE_NOTIFICATION);
        }
        Bundle bundle = new Bundle();
        bundle.putString("source", str.toLowerCase());
        HSChatFragment hSChatFragment = new HSChatFragment();
        hSChatFragment.setArguments(bundle);
        hSChatFragment.setTransactionListener(this);
        FragmentTransaction beginTransaction2 = supportFragmentManager.beginTransaction();
        if (z) {
            this.isHelpcenterOpenedBefore = true;
            beginTransaction2.setCustomAnimations(R.anim.hs__slide_up, R.anim.hs__slide_down, R.anim.hs__slide_up, R.anim.hs__slide_down);
        }
        beginTransaction2.add(R.id.hs__container, hSChatFragment, HSChatFragment.TAG);
        if (z) {
            beginTransaction2.addToBackStack(null);
        }
        beginTransaction2.commitAllowingStateLoss();
    }

    private void startHelpcenterFlow(Intent intent, boolean z) {
        HSHelpcenterFragment newInstance = HSHelpcenterFragment.newInstance(intent.getExtras());
        newInstance.setFragmentTransactionListener(this);
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.add(R.id.hs__container, newInstance, HSHelpcenterFragment.TAG);
        if (z) {
            beginTransaction.addToBackStack(null);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        HSLogger.d(TAG, "HSMainActivity onNewIntent");
        if (areConditionsValidToStartService(intent)) {
            Bundle extras = intent.getExtras();
            HSLogger.d(TAG, "HSMainActivity onNewIntent source: " + extras.getString("source"));
            HSHelpcenterFragment helpcenterFragment = getHelpcenterFragment();
            if (helpcenterFragment != null && isHelpcenterServiceRequested(extras)) {
                helpcenterFragment.reloadIframe(extras);
            } else {
                initService(intent, true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.hs__retry_view_close_btn) {
            finish();
        } else if (id == R.id.hs__retry_button) {
            initService(getIntent(), false);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        HSLogger.d(TAG, "HSMainActivity back press");
        List<Fragment> fragments = this.fragmentManager.getFragments();
        Fragment topFragment = getTopFragment();
        if (topFragment == null) {
            HSHelpcenterFragment hSHelpcenterFragment = (HSHelpcenterFragment) this.fragmentManager.findFragmentByTag(HSHelpcenterFragment.TAG);
            if (hSHelpcenterFragment != null && hSHelpcenterFragment.canHelpCenterNavigateBack()) {
                HSLogger.d(TAG, "HSMainActivity topFragment null, handle back from Helpcenter");
                hSHelpcenterFragment.helpcenterWebviewGoBack();
                return;
            }
            HSChatFragment hSChatFragment = (HSChatFragment) this.fragmentManager.findFragmentByTag(HSChatFragment.TAG);
            if (hSChatFragment != null) {
                HSLogger.d(TAG, "HSMainActivity topFragment null, handle back from Webchat");
                hSChatFragment.handleBackPress();
                return;
            }
            HSLogger.d(TAG, "HSMainActivity topFragment null, back press delegated to super");
        }
        if (topFragment instanceof HSHelpcenterFragment) {
            HSHelpcenterFragment hSHelpcenterFragment2 = (HSHelpcenterFragment) topFragment;
            if (hSHelpcenterFragment2.canHelpCenterNavigateBack()) {
                HSLogger.d(TAG, "HSMainActivity topFragment not null, handle back press with Helpcenter");
                hSHelpcenterFragment2.helpcenterWebviewGoBack();
                return;
            }
        }
        if (topFragment instanceof HSChatFragment) {
            HSLogger.d(TAG, "HSMainActivity topFragment not null, handle back press from Webchat");
            ((HSChatFragment) topFragment).handleBackPress();
        } else if (this.fragmentManager.getBackStackEntryCount() == 1 && Utils.isNotEmpty(fragments) && fragments.size() == 1) {
            HSLogger.d(TAG, "HSMainActivity only one fragment left, finishing activity");
            finish();
        } else if (this.fragmentManager.getBackStackEntryCount() > 0) {
            HSLogger.d(TAG, "HSMainActivity all check failed, popping backstack");
            this.fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.helpshift.activities.FragmentTransactionListener
    public void handleBackPress(boolean z) {
        if (z) {
            return;
        }
        if (getTopFragment() == null) {
            HSLogger.d(TAG, "HSMainActivity handleBackPress, back press delegated to super");
            super.onBackPressed();
        } else if (this.fragmentManager.getBackStackEntryCount() > 0) {
            HSLogger.d(TAG, "HSMainActivity handleBackPress, popping backstack");
            this.fragmentManager.popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Fragment getTopFragment() {
        if (this.fragmentManager.getBackStackEntryCount() == 0) {
            return null;
        }
        return this.fragmentManager.findFragmentById(R.id.hs__container);
    }

    private HSHelpcenterFragment getHelpcenterFragment() {
        Fragment topFragment = getTopFragment();
        if (topFragment == null) {
            return (HSHelpcenterFragment) this.fragmentManager.findFragmentByTag(HSHelpcenterFragment.TAG);
        }
        if (topFragment instanceof HSHelpcenterFragment) {
            return (HSHelpcenterFragment) topFragment;
        }
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        HSLogger.d(TAG, "HSMainActivity onDestroy");
        if (HSContext.installCallSuccessful.get()) {
            HSContext.getInstance().clearHSActivityHandler(Integer.valueOf(hashCode()));
            HSContext.getInstance().getAnalyticsEventDM().sendQuitEvent();
        }
    }

    @Override // com.helpshift.activities.FragmentTransactionListener
    public void openWebchat() {
        startWebchatFlow(true, "helpcenter");
    }

    @Override // com.helpshift.activities.FragmentTransactionListener
    public void closeWebchat() {
        onBackPressed();
    }

    @Override // com.helpshift.activities.FragmentTransactionListener
    public void closeHelpcenter() {
        onBackPressed();
    }

    private void initStatusBarColorOnServiceChange() {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.helpshift.activities.HSMainActivity.1
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public void onBackStackChanged() {
                Fragment topFragment = HSMainActivity.this.getTopFragment();
                if (topFragment == null) {
                    HSMainActivity.this.updateStatusBarColor(false, true);
                } else if (topFragment instanceof HSChatFragment) {
                    HSMainActivity.this.updateStatusBarColor(false, false);
                } else if (topFragment instanceof HSHelpcenterFragment) {
                    HSMainActivity.this.updateStatusBarColor(true, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStatusBarColor(boolean z, boolean z2) {
        changeStatusBarColor(((z2 && this.isHelpcenterOpenedBefore) || z) ? this.configManager.getUiConfigDataOfHelpcenter() : this.configManager.getUiConfigDataOfWebchat());
    }

    @Override // com.helpshift.activities.FragmentTransactionListener
    public void changeStatusBarColor(String str) {
        ViewUtil.setStatusBarColor(this, str, this.topBar);
    }

    @Override // com.helpshift.HSActivityEventHandler
    public void closeActivity() {
        finish();
    }
}
