package com.helpshift.analytics;

import com.helpshift.platform.Device;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.util.Utils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class HSWebchatAnalyticsManager {
    private static final String PLUGIN_VERSION = "pluginVersion";
    private static final String RUNTIME_VERSION = "runtimeVersion";
    private static final String SDK_TYPE = "sdkType";
    private final Map<String, String> analyticsData = new HashMap();
    private final Map<String, String> commonAnalyticsMap = new HashMap();
    private final Device device;
    private final HSPersistentStorage persistentStorage;

    public HSWebchatAnalyticsManager(HSPersistentStorage hSPersistentStorage, Device device) {
        this.persistentStorage = hSPersistentStorage;
        this.device = device;
    }

    public void setAnalyticsEventsData(Map<String, Object> map) {
        setCommonAnalyticsMap(map);
        this.analyticsData.putAll(this.commonAnalyticsMap);
        this.analyticsData.put("rs", this.device.getRom());
        String countryCode = this.device.getCountryCode();
        if (Utils.isNotEmpty(countryCode)) {
            this.analyticsData.put("cc", countryCode);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setCommonAnalyticsMap(java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            r3 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.commonAnalyticsMap
            com.helpshift.platform.Device r1 = r3.device
            java.lang.String r1 = r1.getSDKVersion()
            java.lang.String r2 = "v"
            r0.put(r2, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.commonAnalyticsMap
            com.helpshift.platform.Device r1 = r3.device
            java.lang.String r1 = r1.getDeviceModel()
            java.lang.String r2 = "dm"
            r0.put(r2, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.commonAnalyticsMap
            com.helpshift.platform.Device r1 = r3.device
            java.lang.String r1 = r1.getAppVersion()
            java.lang.String r2 = "av"
            r0.put(r2, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.commonAnalyticsMap
            com.helpshift.platform.Device r1 = r3.device
            java.lang.String r1 = r1.getOSVersion()
            java.lang.String r2 = "os"
            r0.put(r2, r1)
            java.lang.String r0 = "sdkType"
            java.lang.Object r0 = r4.get(r0)
            boolean r1 = r0 instanceof java.lang.String
            java.lang.String r2 = "s"
            if (r1 == 0) goto L4e
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = com.helpshift.util.Utils.isNotEmpty(r0)
            if (r1 == 0) goto L4e
            java.util.Map<java.lang.String, java.lang.String> r1 = r3.commonAnalyticsMap
            r1.put(r2, r0)
            goto L55
        L4e:
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.commonAnalyticsMap
            java.lang.String r1 = "androidx"
            r0.put(r2, r1)
        L55:
            java.lang.String r0 = "pluginVersion"
            java.lang.Object r0 = r4.get(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L6e
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = com.helpshift.util.Utils.isNotEmpty(r0)
            if (r1 == 0) goto L6e
            java.util.Map<java.lang.String, java.lang.String> r1 = r3.commonAnalyticsMap
            java.lang.String r2 = "pv"
            r1.put(r2, r0)
        L6e:
            java.lang.String r0 = "runtimeVersion"
            java.lang.Object r4 = r4.get(r0)
            boolean r0 = r4 instanceof java.lang.String
            if (r0 == 0) goto L87
            java.lang.String r4 = (java.lang.String) r4
            boolean r0 = com.helpshift.util.Utils.isNotEmpty(r4)
            if (r0 == 0) goto L87
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.commonAnalyticsMap
            java.lang.String r1 = "rv"
            r0.put(r1, r4)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.analytics.HSWebchatAnalyticsManager.setCommonAnalyticsMap(java.util.Map):void");
    }

    public Map<String, String> getAnalyticsDataMap() {
        setLanguageInMap(this.analyticsData);
        return this.analyticsData;
    }

    public Map<String, String> getCommonAnalyticsMap() {
        setLanguageInMap(this.commonAnalyticsMap);
        return this.commonAnalyticsMap;
    }

    private void setLanguageInMap(Map<String, String> map) {
        map.put("ln", this.device.getLanguage());
        String language = this.persistentStorage.getLanguage();
        if (Utils.isNotEmpty(language)) {
            map.put("dln", language);
        }
    }
}
