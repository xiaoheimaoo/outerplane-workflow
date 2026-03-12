package com.helpshift.notification;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.helpshift.HSPluginEventBridge;
import com.helpshift.log.HSLogger;
import com.helpshift.platform.Device;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.AssetsUtil;
import com.helpshift.util.ConfigValues;
import com.helpshift.util.Utils;
/* loaded from: classes3.dex */
class HSNotification {
    public static final String HELPSHIFT_DEFAULT_CHANNEL_DESCRIPTION = "";
    public static final String HELPSHIFT_DEFAULT_CHANNEL_ID = "In-app Support";
    private static final int REQUEST_CODE = 50;
    private static final String TAG = "SDKXNotif";

    private HSNotification() {
    }

    public static NotificationCompat.Builder createNotification(Context context, Device device, String str, int i, int i2, int i3, Class<? extends Activity> cls) {
        String appName = device.getAppName();
        if (!Utils.isNotEmpty(str)) {
            str = "";
        }
        HSLogger.d(TAG, "Creating Support notification :\n Title : " + appName);
        int logoResourceValue = ApplicationUtil.getLogoResourceValue(context);
        if (!AssetsUtil.resourceExists(context, i)) {
            i = logoResourceValue;
        }
        Bitmap decodeResource = AssetsUtil.resourceExists(context, i2) ? BitmapFactory.decodeResource(context.getResources(), i2) : null;
        Intent intent = new Intent(context, cls);
        intent.putExtra(ConfigValues.SERVICE_MODE_KEY, ConfigValues.WEBCHAT_SERVICE);
        intent.putExtra("source", ConfigValues.SOURCE_NOTIFICATION);
        intent.setFlags(268435456);
        PendingIntent pendingIntentForNotification = HSPluginEventBridge.getPendingIntentForNotification(context, PendingIntent.getActivity(context, 50, intent, 268435456 | 67108864));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(i);
        builder.setContentTitle(appName);
        builder.setContentText(str);
        builder.setContentIntent(pendingIntentForNotification);
        builder.setAutoCancel(true);
        if (decodeResource != null) {
            builder.setLargeIcon(decodeResource);
        }
        Uri notificationSoundUri = getNotificationSoundUri(context, i3);
        if (notificationSoundUri == null) {
            if (ApplicationUtil.isPermissionGranted(context, "android.permission.VIBRATE")) {
                builder.setDefaults(-1);
            } else {
                builder.setDefaults(5);
            }
        } else {
            builder.setSound(notificationSoundUri);
            if (ApplicationUtil.isPermissionGranted(context, "android.permission.VIBRATE")) {
                builder.setDefaults(6);
            } else {
                builder.setDefaults(4);
            }
        }
        return builder;
    }

    public static Uri getNotificationSoundUri(Context context, int i) {
        if (i != 0) {
            return Uri.parse("android.resource://" + context.getPackageName() + "/" + i);
        }
        return null;
    }
}
