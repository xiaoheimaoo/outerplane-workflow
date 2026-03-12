package com.helpshift.unityproxy.utils;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.helpshift.unityproxy.HelpshiftUnityAPI;
import com.helpshift.unityproxy.storage.HelpshiftUnityStorage;
/* loaded from: classes3.dex */
public class InstallUtils {
    private static final String TAG = "HelpshiftInstallUtil";
    private static boolean isHelpshiftInitSuccessful;

    private InstallUtils() {
    }

    public static boolean installWithCachedValues(Context context) {
        if (isHelpshiftInitSuccessful) {
            return true;
        }
        try {
            HelpshiftUnityStorage helpshiftUnityStorage = HelpshiftUnityStorage.getInstance(context);
            String string = helpshiftUnityStorage.getString(HelpshiftUnityStorage.DOMAIN_NAME);
            HelpshiftUnityAPI.installWithCachedValues((Application) context.getApplicationContext(), helpshiftUnityStorage.getString(HelpshiftUnityStorage.PLATFORM_ID), string, helpshiftUnityStorage.getMap(HelpshiftUnityStorage.INSTALL_CONFIG));
            isHelpshiftInitSuccessful = true;
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error initializing Helpshift : ", e);
            return false;
        }
    }
}
