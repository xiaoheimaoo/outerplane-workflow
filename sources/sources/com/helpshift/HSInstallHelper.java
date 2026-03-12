package com.helpshift;

import android.app.Application;
import android.content.Context;
import com.helpshift.lifecycle.HSAppLifeCycleController;
import com.helpshift.lifecycle.HSAppLifeCycleEventsHandler;
import com.helpshift.notification.CoreNotificationManager;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.ConfigValues;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class HSInstallHelper {
    private HSInstallHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> sanitizeConfig(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, Object> defaultConfigMap = ConfigValues.getDefaultConfigMap();
        defaultConfigMap.putAll(map);
        return defaultConfigMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setNotificationConfigValues(Context context, CoreNotificationManager coreNotificationManager, Map<String, Object> map) {
        String packageName = context.getPackageName();
        Object obj = map.get(ConfigValues.NOTIFICATION_CHANNEL_ID);
        if (obj instanceof String) {
            coreNotificationManager.setNotificationChannelId((String) obj);
        }
        Object obj2 = map.get(ConfigValues.NOTIFICATION_SOUND_ID);
        if (obj2 instanceof Integer) {
            coreNotificationManager.setNotificationSoundId(((Integer) obj2).intValue());
        } else if (obj2 instanceof String) {
            coreNotificationManager.setNotificationSoundId(ApplicationUtil.getResourceIdFromName(context, (String) obj2, "raw", packageName));
        }
        Object obj3 = map.get(ConfigValues.NOTIFICATION_ICON);
        if (obj3 instanceof Integer) {
            coreNotificationManager.setNotificationIcon(((Integer) obj3).intValue());
        } else if (obj3 instanceof String) {
            coreNotificationManager.setNotificationIcon(ApplicationUtil.getResourceIdFromName(context, (String) obj3, "drawable", packageName));
        }
        Object obj4 = map.get(ConfigValues.NOTIFICATION_LARGE_ICON);
        if (obj4 instanceof Integer) {
            coreNotificationManager.setNotificationLargeIcon(((Integer) obj4).intValue());
        } else if (obj4 instanceof String) {
            coreNotificationManager.setNotificationLargeIcon(ApplicationUtil.getResourceIdFromName(context, (String) obj4, "drawable", packageName));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setupLifecycleListeners(Application application, Map<String, Object> map) {
        Object obj = map.get(ConfigValues.MANUAL_LIFECYCLE_TRACKING);
        HSAppLifeCycleController.getInstance().init(application, (obj instanceof Boolean) && ((Boolean) obj).booleanValue(), new HSAppLifeCycleEventsHandler());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setEnableInAppNotification(Map<String, Object> map, HSPersistentStorage hSPersistentStorage) {
        Object obj = map.get(ConfigValues.ENABLE_IN_APP_NOTIFICATION);
        hSPersistentStorage.setEnableInAppNotification(obj instanceof Boolean ? ((Boolean) obj).booleanValue() : true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setScreenOrientation(Map<String, Object> map, HSPersistentStorage hSPersistentStorage) {
        Object obj = map.get(ConfigValues.SCREEN_ORIENTATION);
        hSPersistentStorage.setRequestedScreenOrientation(obj instanceof Integer ? ((Integer) obj).intValue() : -1);
    }
}
