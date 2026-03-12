package com.helpshift.faq;

import com.helpshift.cache.HelpshiftResourceCacheManager;
import com.helpshift.concurrency.HSThreadingService;
import com.helpshift.config.HSConfigManager;
import com.helpshift.log.HSLogger;
import com.helpshift.user.UserManager;
import com.helpshift.user.UserWithIdentity;
import com.helpshift.util.Utils;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HSHelpcenterEventsHandler {
    private static final String ACTION_AUTH_TOKEN_UPDATE = "authTokenUpdate";
    private static final String ACTION_CLEAR_USER_TRAIL = "clearUserTrail";
    private static final String ACTION_REFRESH_TOKEN_EXPIRED = "refreshTokenExpired";
    private static final String ACTION_TYPE = "actionType";
    private static final String TAG = "HSHelpcenterEventsHandler";
    private final HSConfigManager configManager;
    private final HelpshiftResourceCacheManager resourceCacheManager;
    private final HSThreadingService threadingService;
    private WeakReference<HelpcenterToUiCallback> uiCallback;
    private final UserManager userManager;

    public HSHelpcenterEventsHandler(UserManager userManager, HSConfigManager hSConfigManager, HSThreadingService hSThreadingService, HelpshiftResourceCacheManager helpshiftResourceCacheManager) {
        this.configManager = hSConfigManager;
        this.threadingService = hSThreadingService;
        this.resourceCacheManager = helpshiftResourceCacheManager;
        this.userManager = userManager;
    }

    public void setHelpcenterUiCallback(HelpcenterToUiCallback helpcenterToUiCallback) {
        this.uiCallback = new WeakReference<>(helpcenterToUiCallback);
    }

    public void onSetAdditionalHelpcenterData(final String str) {
        this.threadingService.runSerial(new Runnable() { // from class: com.helpshift.faq.HSHelpcenterEventsHandler.1
            @Override // java.lang.Runnable
            public void run() {
                HSHelpcenterEventsHandler.this.configManager.setAdditionalHelpcenterData(str);
            }
        });
    }

    public void onRemoveAdditionalHelpcenterData(final String str) {
        this.threadingService.runSerial(new Runnable() { // from class: com.helpshift.faq.HSHelpcenterEventsHandler.2
            @Override // java.lang.Runnable
            public void run() {
                HSHelpcenterEventsHandler.this.configManager.removeAdditionalHelpcenterData(str);
            }
        });
    }

    public void closeHelpcenter() {
        this.threadingService.runOnUIThread(new Runnable() { // from class: com.helpshift.faq.HSHelpcenterEventsHandler.3
            @Override // java.lang.Runnable
            public void run() {
                HelpcenterToUiCallback helpcenterToUiCallback = (HelpcenterToUiCallback) HSHelpcenterEventsHandler.this.uiCallback.get();
                if (helpcenterToUiCallback != null) {
                    helpcenterToUiCallback.closeHelpcenter();
                }
            }
        });
    }

    public void openWebchat() {
        this.threadingService.runOnUIThread(new Runnable() { // from class: com.helpshift.faq.HSHelpcenterEventsHandler.4
            @Override // java.lang.Runnable
            public void run() {
                HelpcenterToUiCallback helpcenterToUiCallback = (HelpcenterToUiCallback) HSHelpcenterEventsHandler.this.uiCallback.get();
                if (helpcenterToUiCallback != null) {
                    helpcenterToUiCallback.openWebchat();
                }
            }
        });
    }

    public void onHelpcenterLoaded(final String str) {
        this.threadingService.runOnUIThread(new Runnable() { // from class: com.helpshift.faq.HSHelpcenterEventsHandler.5
            @Override // java.lang.Runnable
            public void run() {
                HelpcenterToUiCallback helpcenterToUiCallback = (HelpcenterToUiCallback) HSHelpcenterEventsHandler.this.uiCallback.get();
                if (helpcenterToUiCallback != null) {
                    helpcenterToUiCallback.onHelpcenterLoaded();
                    helpcenterToUiCallback.setNativeUiColors(str);
                    helpcenterToUiCallback.showNotificationBadgeOnHCLoad();
                }
            }
        });
        this.threadingService.runSerial(new Runnable() { // from class: com.helpshift.faq.HSHelpcenterEventsHandler.6
            @Override // java.lang.Runnable
            public void run() {
                HSHelpcenterEventsHandler.this.configManager.saveUiConfigDataOfHelpcenter(str);
            }
        });
    }

    public void onHelpcenterError() {
        deleteAllCachedFilesOfHelpcenter();
        this.threadingService.runOnUIThread(new Runnable() { // from class: com.helpshift.faq.HSHelpcenterEventsHandler.7
            @Override // java.lang.Runnable
            public void run() {
                HelpcenterToUiCallback helpcenterToUiCallback = (HelpcenterToUiCallback) HSHelpcenterEventsHandler.this.uiCallback.get();
                if (helpcenterToUiCallback != null) {
                    helpcenterToUiCallback.onHelpcenterError();
                }
            }
        });
    }

    private void deleteAllCachedFilesOfHelpcenter() {
        this.threadingService.runSerial(new Runnable() { // from class: com.helpshift.faq.HSHelpcenterEventsHandler.8
            @Override // java.lang.Runnable
            public void run() {
                HSHelpcenterEventsHandler.this.resourceCacheManager.deleteAllCachedFiles();
            }
        });
    }

    public void getWebchatData() {
        this.threadingService.runSerial(new Runnable() { // from class: com.helpshift.faq.HSHelpcenterEventsHandler.9
            @Override // java.lang.Runnable
            public void run() {
                HelpcenterToUiCallback helpcenterToUiCallback = (HelpcenterToUiCallback) HSHelpcenterEventsHandler.this.uiCallback.get();
                if (helpcenterToUiCallback != null) {
                    helpcenterToUiCallback.getWebchatData();
                }
            }
        });
    }

    public void hcActionSync(final String str) {
        this.threadingService.runSerial(new Runnable() { // from class: com.helpshift.faq.HSHelpcenterEventsHandler.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String string = jSONObject.getString("actionType");
                        HSLogger.d(HSHelpcenterEventsHandler.TAG, "Received action type " + string);
                        if (HSHelpcenterEventsHandler.ACTION_CLEAR_USER_TRAIL.equalsIgnoreCase(string)) {
                            HSHelpcenterEventsHandler.this.configManager.clearUserTrail();
                        } else if (HSHelpcenterEventsHandler.ACTION_AUTH_TOKEN_UPDATE.equalsIgnoreCase(string)) {
                            HSHelpcenterEventsHandler.this.storeAuthTokens(jSONObject);
                        } else if (HSHelpcenterEventsHandler.ACTION_REFRESH_TOKEN_EXPIRED.equalsIgnoreCase(string)) {
                            HSHelpcenterEventsHandler.this.userManager.sessionExpiryLogoutWhenSDKIsOpen();
                        }
                    }
                } catch (Exception e) {
                    HSLogger.e(HSHelpcenterEventsHandler.TAG, "Error in executing action updates from Helpcenter.", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeAuthTokens(JSONObject jSONObject) {
        if (this.userManager.getCurrentUser() instanceof UserWithIdentity) {
            UserWithIdentity userWithIdentity = (UserWithIdentity) this.userManager.getCurrentUser();
            String optString = jSONObject.optString("accessToken", "");
            String optString2 = jSONObject.optString("refreshToken", "");
            long optLong = jSONObject.optLong("refreshTokenExpiry", 0L);
            userWithIdentity.setAccessToken(optString);
            userWithIdentity.setRefreshToken(optString2);
            userWithIdentity.setRefreshTokenExpiry(optLong);
            HSLogger.d(TAG, "Stored new tokens for user from HC: " + Utils.isEmpty(optString) + Utils.isEmpty(optString2));
            return;
        }
        HSLogger.e(TAG, "Received tokens for non-identity user");
    }
}
