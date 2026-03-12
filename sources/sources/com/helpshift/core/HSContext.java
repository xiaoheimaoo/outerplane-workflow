package com.helpshift.core;

import android.content.Context;
import android.util.Log;
import androidx.work.WorkRequest;
import com.helpshift.HSActivityEventHandler;
import com.helpshift.analytics.HSAnalyticsEventDM;
import com.helpshift.analytics.HSWebchatAnalyticsManager;
import com.helpshift.cache.ChatResourceEvictStrategy;
import com.helpshift.cache.HCResourceCacheEvictStrategy;
import com.helpshift.cache.HelpcenterCacheEvictionManager;
import com.helpshift.cache.HelpshiftResourceCacheManager;
import com.helpshift.cache.ResourceCacheEvictStrategy;
import com.helpshift.chat.HSEventProxy;
import com.helpshift.concurrency.HSThreadFactory;
import com.helpshift.concurrency.HSThreadingService;
import com.helpshift.concurrency.HSUIThreader;
import com.helpshift.concurrency.HSWorkerThreader;
import com.helpshift.config.HSConfigManager;
import com.helpshift.migrator.MigrationFailureLogProvider;
import com.helpshift.migrator.NativeToSdkxMigrator;
import com.helpshift.network.HSDownloaderNetwork;
import com.helpshift.network.HSHttpTransport;
import com.helpshift.network.HTTPTransport;
import com.helpshift.network.URLConnectionProvider;
import com.helpshift.notification.CoreNotificationManager;
import com.helpshift.notification.HSNotificationManager;
import com.helpshift.notification.HSPushTokenManager;
import com.helpshift.notification.RequestUnreadMessageCountHandler;
import com.helpshift.platform.Device;
import com.helpshift.poller.ConversationPoller;
import com.helpshift.poller.ExponentialBackoff;
import com.helpshift.poller.FetchNotificationUpdate;
import com.helpshift.poller.PollFunction;
import com.helpshift.poller.PollerController;
import com.helpshift.poller.SimplePoller;
import com.helpshift.storage.HSGenericDataManager;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.storage.SharedPreferencesStore;
import com.helpshift.user.UserManager;
import com.helpshift.util.SdkURLs;
import com.helpshift.util.Utils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class HSContext {
    public static final String CHAT_CACHE_SUBDIR = "webchat";
    public static final String CHAT_CACHE_URLS_CONFIG_FILE_NAME = "chat_cacheURLs";
    public static final String HC_CACHE_SUBDIR = "helpcenter";
    public static final String HC_CACHE_URLS_CONFIG_FILE_NAME = "helpcenter_cacheURLs";
    private static final String TAG = "HSContext";
    private static final HashMap<Integer, WeakReference<HSActivityEventHandler>> hsActivityEventHandlers = new HashMap<>();
    public static AtomicBoolean installCallSuccessful = new AtomicBoolean(false);
    private static HSContext instance;
    private HSAnalyticsEventDM analyticsEventDM;
    private HSWebchatAnalyticsManager analyticsManager;
    private HelpshiftResourceCacheManager chatResourceCacheManager;
    private HSConfigManager configManager;
    public final Context context;
    private ConversationPoller conversationPoller;
    private Device device;
    private HSGenericDataManager genericDataManager;
    private HelpcenterCacheEvictionManager helpcenterCacheEvictionManager;
    private HelpshiftResourceCacheManager helpcenterResourceCacheManager;
    private HSEventProxy hsEventProxy;
    private HSThreadingService hsThreadingService = new HSThreadingService(new HSWorkerThreader(Executors.newFixedThreadPool(2)), new HSWorkerThreader(Executors.newSingleThreadExecutor()), new HSUIThreader());
    private HTTPTransport httpTransport;
    private boolean isClosingHSActivities;
    private boolean isSDKLoggingEnabled;
    private boolean isSdkOpen;
    private boolean isWebchatOpen;
    private boolean isWebchatOpenedFromHelpcenter;
    private HSJSGenerator jsGenerator;
    private final NativeToSdkxMigrator nativeToSdkxMigrator;
    private CoreNotificationManager notificationManager;
    private HSPersistentStorage persistentStorage;
    private HSPushTokenManager pushTokenManager;
    private RequestUnreadMessageCountHandler requestUnreadMessageCountHandler;
    private UserManager userManager;

    public static synchronized void initInstance(Context context) {
        synchronized (HSContext.class) {
            if (instance == null) {
                instance = new HSContext(context);
            }
        }
    }

    public static HSContext getInstance() {
        return instance;
    }

    public HSContext(Context context) {
        this.context = context;
        this.persistentStorage = new HSPersistentStorage(new SharedPreferencesStore(context, HSPersistentStorage.FILE_NAME, 0));
        this.nativeToSdkxMigrator = new NativeToSdkxMigrator(context, this.persistentStorage);
    }

    public void initialiseComponents(Context context) {
        Utils.setScheduledExecutorService(Executors.newSingleThreadScheduledExecutor());
        this.device = new AndroidDevice(context, this.persistentStorage);
        this.notificationManager = new HSNotificationManager(context, this.device, this.persistentStorage, this.hsThreadingService);
        this.genericDataManager = new HSGenericDataManager(this.persistentStorage);
        this.httpTransport = new HSHttpTransport();
        this.analyticsManager = new HSWebchatAnalyticsManager(this.persistentStorage, this.device);
        this.hsEventProxy = new HSEventProxy(this.hsThreadingService);
        this.pushTokenManager = new HSPushTokenManager(this.device, this.persistentStorage, this.hsThreadingService, this.hsEventProxy, this.httpTransport, this.genericDataManager);
        this.userManager = new UserManager(this.persistentStorage, this.pushTokenManager, this.genericDataManager, this.hsThreadingService, this.notificationManager, this.httpTransport, this.device, this.hsEventProxy);
        this.configManager = new HSConfigManager(this.persistentStorage, this.analyticsManager, this.device, this.userManager);
        FetchNotificationUpdate fetchNotificationUpdate = new FetchNotificationUpdate(this.device, this.persistentStorage, this.genericDataManager, this.userManager, this.notificationManager, this.httpTransport, this.hsEventProxy);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new HSThreadFactory("notif_poller"));
        ConversationPoller conversationPoller = new ConversationPoller(new PollerController(fetchNotificationUpdate, this.userManager, new ExponentialBackoff(5000, 60000), scheduledThreadPoolExecutor), this.userManager);
        this.conversationPoller = conversationPoller;
        this.userManager.setConversationPoller(conversationPoller);
        this.userManager.setIdentityDataSyncPoller(new SimplePoller(new PollFunction() { // from class: com.helpshift.core.HSContext.1
            @Override // com.helpshift.poller.PollFunction
            public boolean execute() {
                return HSContext.this.userManager.scheduleAttributeDataSyncPoller();
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, "identityDataSyncPoller", new ScheduledThreadPoolExecutor(1, new HSThreadFactory("usrmngr_datasync_poller"))));
        this.userManager.setFetchNotificationUpdateFunction(fetchNotificationUpdate);
        this.analyticsEventDM = new HSAnalyticsEventDM(this.device, this.userManager, this.persistentStorage, this.analyticsManager, this.hsThreadingService, this.httpTransport);
        this.jsGenerator = new HSJSGenerator(this.configManager);
        this.requestUnreadMessageCountHandler = new RequestUnreadMessageCountHandler(this.persistentStorage, fetchNotificationUpdate, this.userManager, this.hsEventProxy, this.hsThreadingService);
    }

    public NativeToSdkxMigrator getNativeToSdkxMigrator() {
        return this.nativeToSdkxMigrator;
    }

    public RequestUnreadMessageCountHandler getRequestUnreadMessageCountHandler() {
        return this.requestUnreadMessageCountHandler;
    }

    public ConversationPoller getConversationPoller() {
        return this.conversationPoller;
    }

    public Device getDevice() {
        return this.device;
    }

    public UserManager getUserManager() {
        return this.userManager;
    }

    public HSThreadingService getHsThreadingService() {
        return this.hsThreadingService;
    }

    public HSEventProxy getHsEventProxy() {
        return this.hsEventProxy;
    }

    public HelpshiftResourceCacheManager getChatResourceCacheManager() {
        if (this.chatResourceCacheManager == null) {
            this.chatResourceCacheManager = getHelpshiftResourceCacheManager(new SharedPreferencesStore(this.context, HSPersistentStorage.CHAT_RESOURCE_CACHE_SHARED_PREF_NAME, 0), new ChatResourceEvictStrategy(), SdkURLs.AWS_CACHE_URLS_CONFIG, CHAT_CACHE_URLS_CONFIG_FILE_NAME, CHAT_CACHE_SUBDIR);
        }
        return this.chatResourceCacheManager;
    }

    public HelpshiftResourceCacheManager getHelpcenterResourceCacheManager() {
        if (this.helpcenterResourceCacheManager == null) {
            this.helpcenterResourceCacheManager = getHelpshiftResourceCacheManager(new SharedPreferencesStore(this.context, HSPersistentStorage.HC_RESOURCE_CACHE_SHARED_PREF_NAME, 0), new HCResourceCacheEvictStrategy(), SdkURLs.HC_CACHE_URLS_CONFIG, HC_CACHE_URLS_CONFIG_FILE_NAME, "helpcenter");
        }
        return this.helpcenterResourceCacheManager;
    }

    public HelpcenterCacheEvictionManager getHelpcenterCacheEvictionManager() {
        if (this.helpcenterCacheEvictionManager == null) {
            this.helpcenterCacheEvictionManager = new HelpcenterCacheEvictionManager(this.persistentStorage, this.context.getCacheDir().getAbsolutePath(), "helpcenter");
        }
        return this.helpcenterCacheEvictionManager;
    }

    private HelpshiftResourceCacheManager getHelpshiftResourceCacheManager(SharedPreferencesStore sharedPreferencesStore, ResourceCacheEvictStrategy resourceCacheEvictStrategy, String str, String str2, String str3) {
        return new HelpshiftResourceCacheManager(sharedPreferencesStore, new HSDownloaderNetwork(new URLConnectionProvider()), resourceCacheEvictStrategy, this.context.getCacheDir().getAbsolutePath(), str, str2, str3);
    }

    public void sendMigrationFailureLogs() {
        new MigrationFailureLogProvider(this.context, this.httpTransport, this.persistentStorage, this.device, this.hsThreadingService).sendMigrationFailureLogs();
    }

    public HSConfigManager getConfigManager() {
        return this.configManager;
    }

    public HSPushTokenManager getPushTokenManager() {
        return this.pushTokenManager;
    }

    public CoreNotificationManager getNotificationManager() {
        return this.notificationManager;
    }

    public HSWebchatAnalyticsManager getWebchatAnalyticsManager() {
        return this.analyticsManager;
    }

    public HSAnalyticsEventDM getAnalyticsEventDM() {
        return this.analyticsEventDM;
    }

    public HSGenericDataManager getGenericDataManager() {
        return this.genericDataManager;
    }

    public HSPersistentStorage getPersistentStorage() {
        return this.persistentStorage;
    }

    public HSJSGenerator getJsGenerator() {
        return this.jsGenerator;
    }

    public void setWebchatUIIsOpen(boolean z) {
        this.isWebchatOpen = z;
    }

    public boolean isWebchatUIOpen() {
        return this.isWebchatOpen;
    }

    public void setSdkIsOpen(boolean z) {
        this.isSdkOpen = z;
    }

    public boolean isSdkOpen() {
        return this.isSdkOpen;
    }

    public boolean isIsWebchatOpenedFromHelpcenter() {
        return this.isWebchatOpenedFromHelpcenter;
    }

    public void setIsWebchatOpenedFromHelpcenter(boolean z) {
        this.isWebchatOpenedFromHelpcenter = z;
    }

    public void setSDKLoggingEnabled(boolean z) {
        this.isSDKLoggingEnabled = z;
    }

    public boolean isSDKLoggingEnabled() {
        return this.isSDKLoggingEnabled;
    }

    public static boolean verifyInstall() {
        if (installCallSuccessful.get()) {
            return true;
        }
        Log.e(TAG, "Helpshift install() is not called or has failed. Not logging errors since the app is not in DEBUG build.");
        return false;
    }

    public void setHSActivityHandler(Integer num, HSActivityEventHandler hSActivityEventHandler) {
        HashMap<Integer, WeakReference<HSActivityEventHandler>> hashMap = hsActivityEventHandlers;
        if (hashMap.containsKey(num)) {
            return;
        }
        hashMap.put(num, new WeakReference<>(hSActivityEventHandler));
    }

    public void clearHSActivityHandler(Integer num) {
        if (this.isClosingHSActivities) {
            return;
        }
        hsActivityEventHandlers.remove(num);
    }

    public void closeHSActivities() {
        this.isClosingHSActivities = true;
        for (Map.Entry<Integer, WeakReference<HSActivityEventHandler>> entry : hsActivityEventHandlers.entrySet()) {
            HSActivityEventHandler hSActivityEventHandler = entry.getValue().get();
            if (hSActivityEventHandler != null) {
                hSActivityEventHandler.closeActivity();
            }
        }
        hsActivityEventHandlers.clear();
        this.isClosingHSActivities = false;
    }
}
