package com.unity3d.services.core.configuration;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import com.unity3d.services.core.device.reader.DeviceInfoReaderBuilder;
import com.unity3d.services.core.device.reader.DeviceInfoReaderCompressor;
import com.unity3d.services.core.device.reader.DeviceInfoReaderCompressorWithMetrics;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.WebRequest;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ConfigurationRequestFactory {
    private final Configuration _configuration;
    private final DeviceInfoReaderBuilder _deviceInfoReaderBuilder;

    public ConfigurationRequestFactory(Configuration configuration, DeviceInfoReaderBuilder deviceInfoReaderBuilder) {
        this._configuration = configuration;
        this._deviceInfoReaderBuilder = deviceInfoReaderBuilder;
    }

    public Configuration getConfiguration() {
        return this._configuration;
    }

    public WebRequest getWebRequest() throws MalformedURLException {
        WebRequest webRequest;
        String configUrl = this._configuration.getConfigUrl();
        if (configUrl == null) {
            throw new MalformedURLException("Base URL is null");
        }
        StringBuilder sb = new StringBuilder(configUrl);
        IExperiments experiments = this._configuration.getExperiments();
        if (experiments != null && experiments.isTwoStageInitializationEnabled()) {
            HashMap hashMap = new HashMap();
            hashMap.put(HttpHeaders.CONTENT_ENCODING, Collections.singletonList("gzip"));
            webRequest = new WebRequest(sb.toString(), "POST", hashMap);
            webRequest.setBody(new DeviceInfoReaderCompressorWithMetrics(new DeviceInfoReaderCompressor(this._deviceInfoReaderBuilder.build())).getDeviceData());
        } else {
            sb.append("?ts=").append(System.currentTimeMillis());
            sb.append("&sdkVersion=").append(SdkProperties.getVersionCode());
            sb.append("&sdkVersionName=").append(SdkProperties.getVersionName());
            sb.append("&gameId=").append(ClientProperties.getGameId());
            webRequest = new WebRequest(sb.toString(), ShareTarget.METHOD_GET);
        }
        DeviceLog.debug("Requesting configuration with: " + ((Object) sb));
        return webRequest;
    }
}
