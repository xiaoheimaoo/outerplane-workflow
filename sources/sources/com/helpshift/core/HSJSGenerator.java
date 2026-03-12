package com.helpshift.core;

import android.content.Context;
import com.helpshift.config.HSConfigManager;
import com.helpshift.util.AssetsUtil;
import com.helpshift.util.SdkURLs;
import com.helpshift.util.Utils;
/* loaded from: classes3.dex */
public class HSJSGenerator {
    public static String backBtnClickJs = "Helpcenter( JSON.stringify({ \"eventType\": \"backBtnClick\", \"config\": {} }));";
    public static String reloadIframeJS = "Helpcenter( JSON.stringify({ \"eventType\": \"reloadHelpcenter\", \"config\": %helpshiftConfig }));";
    public static String sendForegroundEvent = "Helpcenter( JSON.stringify({ \"eventType\": \"sdkxIsInForeground\", \"config\": %foreground }));";
    public static String sendWebchatData = "Helpcenter( JSON.stringify({ \"eventType\": \"setWebchatData\", \"config\": %data }));";
    public static String showNotificationBadgeJS = "Helpcenter(JSON.stringify({ \"eventType\": \"showNotifBadge\", \"config\": { \"notifCount\": %count } }));";
    public static String updateHelpCenterConfig = "Helpcenter( JSON.stringify({ \"eventType\": \"updateHelpshiftConfig\", \"config\": %helpshiftConfig }));";
    public static String updateWebChatConfig = "window.helpshiftConfig = JSON.parse(JSON.stringify(%config));Helpshift('updateHelpshiftConfig')";
    private HSConfigManager configManager;
    private String helpcenterEmbeddedCodeString;
    private String webchatEmbeddedCodeString;

    public HSJSGenerator(HSConfigManager hSConfigManager) {
        this.configManager = hSConfigManager;
    }

    public String getWebchatEmbeddedCodeString(Context context, String str) {
        if (Utils.isEmpty(this.webchatEmbeddedCodeString)) {
            String readAssetFileContents = AssetsUtil.readAssetFileContents(context, "helpshift/Webchat.js");
            if (Utils.isEmpty(readAssetFileContents)) {
                return "";
            }
            this.webchatEmbeddedCodeString = readAssetFileContents.replace("%cdn", SdkURLs.AWS_WEBCHAT_JS);
        }
        return this.webchatEmbeddedCodeString.replace("%config", this.configManager.getWebchatConfigJs(HSContext.getInstance().isIsWebchatOpenedFromHelpcenter(), str));
    }

    public String getHelpcenterEmbeddedCodeString(Context context, String str, String str2, boolean z, String str3) {
        if (Utils.isEmpty(this.helpcenterEmbeddedCodeString)) {
            String readAssetFileContents = AssetsUtil.readAssetFileContents(context, "helpshift/Helpcenter.js");
            if (Utils.isEmpty(readAssetFileContents)) {
                return "";
            }
            this.helpcenterEmbeddedCodeString = readAssetFileContents.replace("%cdn", SdkURLs.HELPCENTER_MIDDLEWARE_JS);
        }
        return this.helpcenterEmbeddedCodeString.replace("%config", this.configManager.getHelpcenterConfigJs(str, str2, z, str3));
    }
}
