package com.helpshift.analytics;

import com.helpshift.concurrency.HSThreadingService;
import com.helpshift.log.HSLogger;
import com.helpshift.network.HSRequestData;
import com.helpshift.network.HTTPTransport;
import com.helpshift.network.NetworkUtils;
import com.helpshift.network.POSTNetwork;
import com.helpshift.network.RetryNetworkWithNewToken;
import com.helpshift.network.exception.HSRootApiException;
import com.helpshift.network.exception.NetworkException;
import com.helpshift.platform.Device;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.user.UserManager;
import com.helpshift.user.UserWithIdentity;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import com.singular.sdk.internal.Constants;
import com.unity.androidnotifications.UnityNotificationManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HSAnalyticsEventDM {
    private static final int MAX_EVENT_COUNT = 1000;
    private static final int SYNC_INTERVAL_IN_MILLISECONDS = 86400000;
    private static final String TAG = "analyticsMngr";
    private final HSWebchatAnalyticsManager analyticsManager;
    private final Device device;
    private final HSThreadingService hsServices;
    private final HTTPTransport httpTransport;
    private final HSPersistentStorage persistentStorage;
    private final UserManager userManager;

    public HSAnalyticsEventDM(Device device, UserManager userManager, HSPersistentStorage hSPersistentStorage, HSWebchatAnalyticsManager hSWebchatAnalyticsManager, HSThreadingService hSThreadingService, HTTPTransport hTTPTransport) {
        this.device = device;
        this.userManager = userManager;
        this.persistentStorage = hSPersistentStorage;
        this.analyticsManager = hSWebchatAnalyticsManager;
        this.hsServices = hSThreadingService;
        this.httpTransport = hTTPTransport;
    }

    public synchronized void sendAppLaunchEvent() {
        long lastSuccessfulAppLaunchEventSyncTime = this.persistentStorage.getLastSuccessfulAppLaunchEventSyncTime();
        long currentTimeMillis = System.currentTimeMillis();
        addAppLaunchEventToStorage(currentTimeMillis);
        if (currentTimeMillis > Utils.TIME_24HRS_MILLIS + lastSuccessfulAppLaunchEventSyncTime && !Utils.isToday(lastSuccessfulAppLaunchEventSyncTime)) {
            sendAppLaunchEventToServer(currentTimeMillis);
        }
    }

    public synchronized void sendAllAppLaunchEvents() {
        sendAppLaunchEventToServer(System.currentTimeMillis());
    }

    private void sendAppLaunchEventToServer(final long j) {
        final JSONArray consumeStoredAppLaunchEventsJson = consumeStoredAppLaunchEventsJson();
        if (JsonUtils.isEmpty(consumeStoredAppLaunchEventsJson)) {
            return;
        }
        this.hsServices.getNetworkService().submit(new Runnable() { // from class: com.helpshift.analytics.HSAnalyticsEventDM.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int sendEventsToServer = HSAnalyticsEventDM.this.sendEventsToServer(consumeStoredAppLaunchEventsJson, false);
                    if (sendEventsToServer < 200 || sendEventsToServer >= 300) {
                        return;
                    }
                    HSAnalyticsEventDM.this.persistentStorage.setLastAppLaunchEventSyncTime(j);
                } catch (HSRootApiException e) {
                    HSLogger.e(HSAnalyticsEventDM.TAG, "Failed to send the app launch events", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sendEventsToServer(JSONArray jSONArray, boolean z) throws HSRootApiException {
        if (JsonUtils.isEmpty(jSONArray)) {
            return 200;
        }
        try {
            HSLogger.d(TAG, z ? "Syncing failed analytics events" : "Syncing analytics events");
            Map<String, String> buildEventRequestMap = buildEventRequestMap();
            buildEventRequestMap.put(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, jSONArray.toString());
            HSRequestData hSRequestData = new HSRequestData(NetworkUtils.buildHeaderMap(this.device, this.persistentStorage.getPlatformId()), buildEventRequestMap);
            UserManager userManager = this.userManager;
            int status = new RetryNetworkWithNewToken(new POSTNetwork(this.httpTransport, NetworkUtils.getAnalyticsAPIRoute(this.persistentStorage)), userManager, this.httpTransport, this.userManager.getCurrentUser() instanceof UserWithIdentity, userManager.getTokenDataForRotation()).makeRequest(hSRequestData).getStatus();
            if ((status < 200 || status >= 300) && !z) {
                updateFailedEventsStore(jSONArray);
            }
            return status;
        } catch (HSRootApiException e) {
            HSLogger.e(TAG, "Failed to send the events", e);
            if (e.exceptionType == NetworkException.SESSION_EXPIRED || e.exceptionType == NetworkException.IDENTITY_FEATURE_NOT_ENABLED) {
                this.userManager.logoutUserForNetworkException(e.exceptionType);
            }
            if (!z) {
                updateFailedEventsStore(jSONArray);
            }
            throw e;
        }
    }

    public void sendQuitEvent() {
        final JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put("t", "q");
        jSONArray.put(jSONObject);
        this.hsServices.getNetworkService().submit(new Runnable() { // from class: com.helpshift.analytics.HSAnalyticsEventDM.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HSAnalyticsEventDM.this.sendEventsToServer(jSONArray, false);
                } catch (HSRootApiException e) {
                    HSLogger.e(HSAnalyticsEventDM.TAG, "Failed to send quit event", e);
                }
            }
        });
    }

    public void sendFailedEvents() {
        final JSONArray failedAnalyticsEvents = this.persistentStorage.getFailedAnalyticsEvents();
        if (JsonUtils.isEmpty(failedAnalyticsEvents)) {
            return;
        }
        this.hsServices.getNetworkService().submit(new Runnable() { // from class: com.helpshift.analytics.HSAnalyticsEventDM.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int sendEventsToServer = HSAnalyticsEventDM.this.sendEventsToServer(failedAnalyticsEvents, true);
                    if (sendEventsToServer < 200 || sendEventsToServer >= 300) {
                        return;
                    }
                    HSAnalyticsEventDM.this.persistentStorage.setFailedAnalyticsEvents(new JSONArray());
                } catch (HSRootApiException e) {
                    HSLogger.e(HSAnalyticsEventDM.TAG, "Error trying to sync failed events", e);
                }
            }
        });
    }

    private void updateFailedEventsStore(JSONArray jSONArray) {
        if (JsonUtils.isEmpty(jSONArray)) {
            return;
        }
        JSONArray failedAnalyticsEvents = this.persistentStorage.getFailedAnalyticsEvents();
        if (failedAnalyticsEvents.length() > 1000) {
            JSONArray jSONArray2 = new JSONArray();
            for (int length = jSONArray.length(); length < 1000; length++) {
                jSONArray2.put(failedAnalyticsEvents.get(length));
            }
            failedAnalyticsEvents = jSONArray2;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            failedAnalyticsEvents.put(jSONArray.get(i));
        }
        this.persistentStorage.setFailedAnalyticsEvents(failedAnalyticsEvents);
    }

    private void addAppLaunchEventToStorage(long j) {
        JSONArray consumeStoredAppLaunchEventsJson = consumeStoredAppLaunchEventsJson();
        if (consumeStoredAppLaunchEventsJson.length() >= 1000) {
            this.persistentStorage.storeAppLaunchEvents(consumeStoredAppLaunchEventsJson.toString());
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ts", j);
        jSONObject.put("t", "a");
        consumeStoredAppLaunchEventsJson.put(jSONObject);
        this.persistentStorage.storeAppLaunchEvents(consumeStoredAppLaunchEventsJson.toString());
    }

    private synchronized JSONArray consumeStoredAppLaunchEventsJson() {
        JSONArray jSONArray;
        jSONArray = new JSONArray();
        String appLaunchEvents = this.persistentStorage.getAppLaunchEvents();
        if (JsonUtils.isValidJsonString(appLaunchEvents)) {
            jSONArray = new JSONArray(appLaunchEvents);
            this.persistentStorage.clearAppLaunchEvents();
        }
        return jSONArray;
    }

    private Map<String, String> buildEventRequestMap() {
        HashMap hashMap = new HashMap();
        String deviceId = this.device.getDeviceId();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("userId", "uid");
        hashMap2.put("userEmail", "email");
        Map<String, String> activeUserDataForNetworkCall = this.userManager.getActiveUserDataForNetworkCall(hashMap2);
        Utils.removeEmptyKeyValues(activeUserDataForNetworkCall);
        hashMap.putAll(activeUserDataForNetworkCall);
        String legacyAnalyticsEventId = getLegacyAnalyticsEventId(activeUserDataForNetworkCall.get("uid"));
        hashMap.put("did", deviceId);
        if (!Utils.isEmpty(legacyAnalyticsEventId)) {
            deviceId = legacyAnalyticsEventId;
        }
        hashMap.put(UnityNotificationManager.KEY_ID, deviceId);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        hashMap.putAll(this.analyticsManager.getCommonAnalyticsMap());
        hashMap.put("platform-id", this.persistentStorage.getPlatformId());
        return hashMap;
    }

    private String getLegacyAnalyticsEventId(String str) {
        String string = this.persistentStorage.getString(HSPersistentStorage.LEGACY_ANALYTICS_EVENTS_IDS);
        return (Utils.isEmpty(string) || !JsonUtils.isValidJsonString(string)) ? "" : new JSONObject(string).getString(str);
    }
}
