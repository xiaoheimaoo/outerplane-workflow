package com.helpshift.unityproxy;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.helpshift.Helpshift;
import com.helpshift.UnsupportedOSVersionException;
import com.helpshift.proactive.HelpshiftProactiveAPIConfigCollector;
import com.helpshift.unityproxy.utils.InstallUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class HelpshiftUnity {
    private static final String TAG = "HelpshiftUnity";
    private static final String UNITY_PLUGIN_VERSION = "10.4.0";

    private HelpshiftUnity() {
    }

    public static void install(Application application, String str, String str2, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("sdkType", "unityx");
        map.put("pluginVersion", "10.4.0");
        try {
            Helpshift.install(application, str, str2, map);
        } catch (UnsupportedOSVersionException unused) {
            Log.e(TAG, "install() called on the OS version: " + Build.VERSION.SDK_INT + " is not supported");
        }
    }

    public static void handlePush(Context context, Map<String, String> map) {
        InstallUtils.installWithCachedValues(context);
        Helpshift.handlePush(map);
    }

    public static void handleProactiveLink(Context context, String str) {
        InstallUtils.installWithCachedValues(context);
        Helpshift.handleProactiveLink(str);
    }

    public static void setHelpshiftProactiveConfigCollector(Context context, HelpshiftProactiveAPIConfigCollector helpshiftProactiveAPIConfigCollector) {
        InstallUtils.installWithCachedValues(context);
        Helpshift.setHelpshiftProactiveConfigCollector(helpshiftProactiveAPIConfigCollector);
    }

    public static void registerPushToken(String str) {
        Helpshift.registerPushToken(str);
    }

    public static void closeSession() {
        Helpshift.closeSession();
    }
}
