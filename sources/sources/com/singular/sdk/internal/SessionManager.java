package com.singular.sdk.internal;

import android.app.Application;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.singular.sdk.internal.BroadcastReceivers;
import com.unity.androidnotifications.UnityNotificationManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SessionManager {
    private static final SingularLog logger = SingularLog.getLogger("Session");
    private final BroadcastReceivers.NetworkChange networkChangeReceiver;
    private final SingularInstance singular;
    private boolean usingForegroundTracking = false;
    private long sessionId = -1;
    private long lastSessionPauseTime = -1;
    private long sequence = 0;
    private boolean inForeground = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionManager(SingularInstance singularInstance) {
        this.singular = singularInstance;
        this.networkChangeReceiver = new BroadcastReceivers.NetworkChange(singularInstance);
        load();
        startNewSessionIfNeeded(Utils.getCurrentTimeMillis());
        enableForegroundTracking((Application) singularInstance.getContext());
        registerNetworkChangeReceiver();
    }

    private void enableForegroundTracking(Application application) {
        if (this.usingForegroundTracking) {
            return;
        }
        if (Utils.getWrapperName() == null || !Utils.getWrapperName().equalsIgnoreCase("mParticle")) {
            new SingularLifecycleCallbacks(this).registerSelf(application);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void useForegroundTracking() {
        this.usingForegroundTracking = true;
    }

    private void load() {
        SharedPreferences sharedPreferences = this.singular.getContext().getSharedPreferences(Constants.PREF_SESSION, 0);
        this.sessionId = sharedPreferences.getLong(UnityNotificationManager.KEY_ID, -1L);
        long j = sharedPreferences.getLong("lastSessionPauseTime", -1L);
        this.lastSessionPauseTime = j;
        if (j < 0) {
            this.lastSessionPauseTime = sharedPreferences.getLong("lastEvent", -1L);
        }
        this.sequence = sharedPreferences.getLong("seq", 0L);
        logger.debug("load() <= %s", toString());
    }

    private void persist() {
        try {
            SharedPreferences.Editor edit = this.singular.getContext().getSharedPreferences(Constants.PREF_SESSION, 0).edit();
            edit.putLong(UnityNotificationManager.KEY_ID, this.sessionId);
            edit.putLong("lastSessionPauseTime", this.lastSessionPauseTime);
            edit.putLong("seq", this.sequence);
            edit.commit();
        } catch (Throwable th) {
            logger.error(Utils.formatException(th));
        }
    }

    private boolean inSession() {
        return this.sessionId > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getSessionId() {
        return this.sessionId;
    }

    private long getSessionLengthInMs() {
        return System.currentTimeMillis() - this.sessionId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNextSequenceNumber() {
        long j = this.sequence + 1;
        this.sequence = j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastSessionPauseTime(long j) {
        this.lastSessionPauseTime = j;
        persist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startNewSessionIfNeeded(long j) {
        SingularInstance singularInstance = this.singular;
        if (singularInstance != null && singularInstance.getSingularConfig().singularLink != null) {
            startNewSession(j);
            return true;
        } else if (DeviceIDManager.getInstance().isCurrentSdidNewComparedToPrevious(this.singular.getContext())) {
            logger.debug("starting new session because current sdid is fresh");
            startNewSession(j);
            return true;
        } else if (inSession() && isWithinMinTimeBetweenSessions(j)) {
            return false;
        } else {
            startNewSession(j);
            return true;
        }
    }

    public void startNewSession(long j) {
        logger.debug("startNewSession() At %d", Long.valueOf(j));
        setSessionId(j);
        resetSequence();
        sendSessionStartEvent();
    }

    private boolean isWithinMinTimeBetweenSessions(long j) {
        return j - this.lastSessionPauseTime < this.singular.getSingularConfig().sessionTimeoutSec * 1000;
    }

    private void setSessionId(long j) {
        this.sessionId = j;
    }

    private void resetSequence() {
        this.sequence = 0L;
    }

    private void sendSessionStartEvent() {
        if (inSession()) {
            this.singular.logSessionStart(this.sessionId);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onExitForeground(final long j) {
        logger.debug("onExitForeground() At %d", Long.valueOf(j));
        this.singular.runOnWorker(new Runnable() { // from class: com.singular.sdk.internal.SessionManager.1
            @Override // java.lang.Runnable
            public void run() {
                SessionManager.this.setLastSessionPauseTime(j);
                SessionManager.this.inForeground = false;
                SessionManager.this.unregisterNetworkChangeReceiver();
                Utils.appMovedToBackground();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onEnterForeground(final long j) {
        if (Utils.isOpenedWithDeeplink()) {
            return;
        }
        logger.debug("onEnterForeground() At %d", Long.valueOf(j));
        this.singular.runOnWorker(new Runnable() { // from class: com.singular.sdk.internal.SessionManager.2
            @Override // java.lang.Runnable
            public void run() {
                SessionManager.this.inForeground = true;
                SessionManager.this.startNewSessionIfNeeded(j);
                SessionManager.this.registerNetworkChangeReceiver();
            }
        });
    }

    void registerNetworkChangeReceiver() {
        if (this.inForeground || !this.usingForegroundTracking) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.singular.getContext().registerReceiver(this.networkChangeReceiver, intentFilter);
            logger.debug("registerNetworkChangeReceiver()");
        }
    }

    void unregisterNetworkChangeReceiver() {
        if (this.networkChangeReceiver != null) {
            try {
                this.singular.getContext().unregisterReceiver(this.networkChangeReceiver);
                logger.debug("unregisterNetworkChangeReceiver()");
            } catch (Throwable unused) {
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{id=");
        sb.append(this.sessionId);
        sb.append(", lastSessionPauseTime=").append(this.lastSessionPauseTime);
        sb.append(", seq=").append(this.sequence);
        sb.append('}');
        return sb.toString();
    }
}
