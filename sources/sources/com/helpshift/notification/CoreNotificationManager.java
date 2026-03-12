package com.helpshift.notification;
/* loaded from: classes3.dex */
public interface CoreNotificationManager {
    void cancelNotifications();

    void setNotificationChannelId(String str);

    void setNotificationIcon(int i);

    void setNotificationLargeIcon(int i);

    void setNotificationReceivedCallback(NotificationReceivedCallback notificationReceivedCallback);

    void setNotificationSoundId(int i);

    void showDebugLogNotification();

    void showNotification(String str, boolean z);
}
