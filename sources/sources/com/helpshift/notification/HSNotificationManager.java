package com.helpshift.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.helpshift.activities.HSDebugActivity;
import com.helpshift.activities.HSMainActivity;
import com.helpshift.concurrency.HSThreadingService;
import com.helpshift.core.HSContext;
import com.helpshift.log.HSLogger;
import com.helpshift.platform.Device;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.Utils;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class HSNotificationManager implements CoreNotificationManager {
    private static final String TAG = "notifMngr";
    private Context context;
    private Device device;
    private WeakReference<NotificationReceivedCallback> notificationReceivedCallback;
    private HSPersistentStorage persistentStorage;
    private HSThreadingService threadingService;

    public HSNotificationManager(Context context, Device device, HSPersistentStorage hSPersistentStorage, HSThreadingService hSThreadingService) {
        this.context = context;
        this.device = device;
        this.persistentStorage = hSPersistentStorage;
        this.threadingService = hSThreadingService;
    }

    @Override // com.helpshift.notification.CoreNotificationManager
    public void setNotificationChannelId(String str) {
        this.persistentStorage.setNotificationChannelId(str);
    }

    @Override // com.helpshift.notification.CoreNotificationManager
    public void setNotificationSoundId(int i) {
        this.persistentStorage.setNotificationSoundId(i);
    }

    @Override // com.helpshift.notification.CoreNotificationManager
    public void setNotificationIcon(int i) {
        this.persistentStorage.setNotificationIcon(i);
    }

    @Override // com.helpshift.notification.CoreNotificationManager
    public void setNotificationLargeIcon(int i) {
        this.persistentStorage.setNotificationLargeIcon(i);
    }

    @Override // com.helpshift.notification.CoreNotificationManager
    public void setNotificationReceivedCallback(NotificationReceivedCallback notificationReceivedCallback) {
        this.notificationReceivedCallback = new WeakReference<>(notificationReceivedCallback);
    }

    @Override // com.helpshift.notification.CoreNotificationManager
    public void showNotification(final String str, boolean z) {
        HSContext hSContext = HSContext.getInstance();
        if (hSContext.isSdkOpen()) {
            this.threadingService.runOnUIThread(new Runnable() { // from class: com.helpshift.notification.HSNotificationManager.1
                @Override // java.lang.Runnable
                public void run() {
                    NotificationReceivedCallback notificationReceivedCallback;
                    if (HSNotificationManager.this.notificationReceivedCallback == null || (notificationReceivedCallback = (NotificationReceivedCallback) HSNotificationManager.this.notificationReceivedCallback.get()) == null) {
                        return;
                    }
                    notificationReceivedCallback.onNotificationReceived();
                }
            });
        } else if (hSContext.isWebchatUIOpen()) {
        } else {
            if (z || this.persistentStorage.getEnableInAppNotification()) {
                this.threadingService.runOnUIThread(new Runnable() { // from class: com.helpshift.notification.HSNotificationManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        HSNotificationManager.this.showNotificationInternal(str, HSMainActivity.class);
                    }
                });
            }
        }
    }

    @Override // com.helpshift.notification.CoreNotificationManager
    public void showDebugLogNotification() {
        Log.d(TAG, "Posting debug notification");
        this.threadingService.runOnUIThread(new Runnable() { // from class: com.helpshift.notification.HSNotificationManager.3
            @Override // java.lang.Runnable
            public void run() {
                HSNotificationManager.this.showNotificationInternal("Helpshift Debugger: Tap to share debug logs", HSDebugActivity.class);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotificationInternal(String str, Class<? extends Activity> cls) {
        NotificationCompat.Builder createNotification = HSNotification.createNotification(this.context, this.device, str, this.persistentStorage.getNotificationIcon(), this.persistentStorage.getNotificationLargeIcon(), this.persistentStorage.getNotificationSoundId(), cls);
        if (createNotification != null) {
            Notification attachChannelId = attachChannelId(createNotification.build(), this.context);
            HSLogger.d(TAG, "Notification built, trying to post now.");
            ApplicationUtil.showNotification(this.context, attachChannelId, cls);
        }
    }

    private Notification attachChannelId(Notification notification, Context context) {
        if (Build.VERSION.SDK_INT < 26 || ApplicationUtil.getTargetSDKVersion(context) < 26) {
            return notification;
        }
        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, notification);
        recoverBuilder.setChannelId(getActiveNotificationChannel(context));
        return recoverBuilder.build();
    }

    private String getActiveNotificationChannel(Context context) {
        String notificationChannelId = this.persistentStorage.getNotificationChannelId();
        if (Utils.isEmpty(notificationChannelId)) {
            ensureDefaultNotificationChannelCreated(context);
            return HSNotification.HELPSHIFT_DEFAULT_CHANNEL_ID;
        }
        deleteDefaultNotificationChannel(context);
        return notificationChannelId;
    }

    private void deleteDefaultNotificationChannel(Context context) {
        NotificationManager notificationManager = ApplicationUtil.getNotificationManager(context);
        if (notificationManager == null || notificationManager.getNotificationChannel(HSNotification.HELPSHIFT_DEFAULT_CHANNEL_ID) == null) {
            return;
        }
        notificationManager.deleteNotificationChannel(HSNotification.HELPSHIFT_DEFAULT_CHANNEL_ID);
    }

    private void ensureDefaultNotificationChannelCreated(Context context) {
        NotificationManager notificationManager = ApplicationUtil.getNotificationManager(context);
        if (notificationManager == null || notificationManager.getNotificationChannel(HSNotification.HELPSHIFT_DEFAULT_CHANNEL_ID) != null) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel(HSNotification.HELPSHIFT_DEFAULT_CHANNEL_ID, HSNotification.HELPSHIFT_DEFAULT_CHANNEL_ID, 3);
        notificationChannel.setDescription("");
        Uri notificationSoundUri = HSNotification.getNotificationSoundUri(context, this.persistentStorage.getNotificationSoundId());
        if (notificationSoundUri != null) {
            notificationChannel.setSound(notificationSoundUri, new AudioAttributes.Builder().build());
        }
        notificationManager.createNotificationChannel(notificationChannel);
    }

    @Override // com.helpshift.notification.CoreNotificationManager
    public void cancelNotifications() {
        ApplicationUtil.cancelNotification(this.context);
    }
}
