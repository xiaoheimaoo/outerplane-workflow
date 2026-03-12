package com.helpshift.notification;

import com.helpshift.HelpshiftEvent;
import com.helpshift.chat.HSEventProxy;
import com.helpshift.concurrency.HSThreadingService;
import com.helpshift.log.HSLogger;
import com.helpshift.poller.FetchNotificationUpdate;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.user.UserManager;
import com.helpshift.util.Utils;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class RequestUnreadMessageCountHandler {
    private static final String TAG = "rqUnrdCntHdlr";
    private final HSEventProxy eventProxy;
    private final FetchNotificationUpdate fetchNotificationUpdate;
    private final HSPersistentStorage persistentStorage;
    private final HSThreadingService threadingService;
    private final UserManager userManager;
    private final int MAX_FALLBACK_INTERVAL = 21600000;
    private final int MIN_ACTIVE_FALLBACK_INTERVAL = 60000;
    private final int MIN_PASSIVE_FALLBACK_INTERVAL = Utils.FALLBACK_PASSIVE_REMOTE_FETCH_INTERVAL;
    private final ConcurrentHashMap<String, AtomicBoolean> userCallsInProgress = new ConcurrentHashMap<>();

    public RequestUnreadMessageCountHandler(HSPersistentStorage hSPersistentStorage, FetchNotificationUpdate fetchNotificationUpdate, UserManager userManager, HSEventProxy hSEventProxy, HSThreadingService hSThreadingService) {
        this.persistentStorage = hSPersistentStorage;
        this.fetchNotificationUpdate = fetchNotificationUpdate;
        this.userManager = userManager;
        this.eventProxy = hSEventProxy;
        this.threadingService = hSThreadingService;
    }

    public void handleLocalCacheRequest() {
        HSLogger.d(TAG, "Serving count from local cache.");
        HashMap hashMap = new HashMap();
        hashMap.put(HelpshiftEvent.DATA_MESSAGE_COUNT, Integer.valueOf(Math.max(this.userManager.getUnreadNotificationCount(), this.userManager.getPushUnreadNotificationCount())));
        hashMap.put(HelpshiftEvent.DATA_MESSAGE_COUNT_FROM_CACHE, true);
        this.eventProxy.sendEvent(HelpshiftEvent.RECEIVED_UNREAD_MESSAGE_COUNT, hashMap);
    }

    public synchronized void handleRemoteRequest(final String str) {
        int passiveRemoteFetchInterval;
        if (this.userCallsInProgress.containsKey(str) && this.userCallsInProgress.get(str).get()) {
            HSLogger.d(TAG, "Call already in progress for user " + Utils.getMaskedString(str));
        } else if (!this.userManager.isRequestUnreadMessageCountAllowed(str).booleanValue()) {
            HSLogger.d(TAG, "requestUnreadMessageCount call not allowed for the user " + Utils.getMaskedString(str));
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long lastRequestUnreadCountApiAccess = this.persistentStorage.getLastRequestUnreadCountApiAccess();
            boolean shouldPoll = this.userManager.shouldPoll();
            if (shouldPoll) {
                passiveRemoteFetchInterval = this.userManager.getActiveRemoteFetchInterval();
            } else {
                passiveRemoteFetchInterval = this.userManager.getPassiveRemoteFetchInterval();
            }
            int min = Math.min(passiveRemoteFetchInterval, 21600000);
            if (min <= 0) {
                min = shouldPoll ? 60000 : Utils.FALLBACK_PASSIVE_REMOTE_FETCH_INTERVAL;
            }
            if (lastRequestUnreadCountApiAccess != 0 && currentTimeMillis - lastRequestUnreadCountApiAccess < min) {
                handleLocalCacheRequest();
                return;
            }
            this.persistentStorage.setLastRequestUnreadCountApiAccess(currentTimeMillis);
            HSLogger.d(TAG, "Fetching unread count from remote.");
            this.threadingService.getNetworkService().submit(new Runnable() { // from class: com.helpshift.notification.RequestUnreadMessageCountHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (!RequestUnreadMessageCountHandler.this.userCallsInProgress.containsKey(str)) {
                                RequestUnreadMessageCountHandler.this.userCallsInProgress.put(str, new AtomicBoolean(false));
                            }
                            boolean z = true;
                            ((AtomicBoolean) RequestUnreadMessageCountHandler.this.userCallsInProgress.get(str)).compareAndSet(false, true);
                            int execute = RequestUnreadMessageCountHandler.this.fetchNotificationUpdate.execute(Utils.ORIGIN_REQUEST_UNREAD_COUNT, str);
                            boolean z2 = execute >= 200 && execute < 300;
                            HashMap hashMap = new HashMap();
                            hashMap.put(HelpshiftEvent.DATA_MESSAGE_COUNT, Integer.valueOf(RequestUnreadMessageCountHandler.this.userManager.getUnreadNotificationCount()));
                            if (z2) {
                                z = false;
                            }
                            hashMap.put(HelpshiftEvent.DATA_MESSAGE_COUNT_FROM_CACHE, Boolean.valueOf(z));
                            RequestUnreadMessageCountHandler.this.eventProxy.sendEvent(HelpshiftEvent.RECEIVED_UNREAD_MESSAGE_COUNT, hashMap);
                        } catch (Exception e) {
                            HSLogger.e(RequestUnreadMessageCountHandler.TAG, "Error in fetching unread count from remote", e);
                        }
                    } finally {
                        ((AtomicBoolean) RequestUnreadMessageCountHandler.this.userCallsInProgress.get(str)).set(false);
                    }
                }
            });
        }
    }
}
