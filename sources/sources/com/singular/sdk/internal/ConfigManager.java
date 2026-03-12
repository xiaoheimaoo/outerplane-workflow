package com.singular.sdk.internal;

import android.content.SharedPreferences;
import com.singular.sdk.internal.ApiConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ConfigManager implements ApiConfig.ApiConfigCompletionHandler {
    private static ConfigManager instance;
    private static final SingularLog logger = SingularLog.getLogger("ConfigManager");
    private SLRemoteConfiguration currentConfig;

    private ConfigManager() {
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public synchronized void setup() {
        this.currentConfig = loadConfig();
        if (isConfigEnqueued() < 0) {
            enqueueConfigRequest();
            setConfigEnqueued(Utils.getCurrentTimeMillis());
        }
    }

    private void enqueueConfigRequest() {
        try {
            logger.debug("enqueueing config request");
            ApiConfig apiConfig = new ApiConfig(Utils.getCurrentTimeMillis());
            apiConfig.addParams(ApiConfig.Params.build(SingularInstance.getInstance()));
            SingularInstance.getInstance().getApiManager().enqueue(apiConfig);
        } catch (Throwable th) {
            logger.error("could not send and update local config from remote: " + Utils.formatException(th));
        }
    }

    private long isConfigEnqueued() {
        try {
            return SingularInstance.getInstance().getContext().getSharedPreferences(Constants.PREF_CONFIG_MANAGER, 0).getLong(Constants.CONFIG_MANAGER_CONFIG_REQUEST_LAST_ENQUEUED, -1L);
        } catch (Throwable th) {
            logger.debug("failed to verify is config enqueued " + Utils.formatException(th));
            return -1L;
        }
    }

    private void setConfigEnqueued(long j) {
        try {
            SharedPreferences.Editor edit = SingularInstance.getInstance().getContext().getSharedPreferences(Constants.PREF_CONFIG_MANAGER, 0).edit();
            edit.putLong(Constants.CONFIG_MANAGER_CONFIG_REQUEST_LAST_ENQUEUED, j);
            edit.commit();
        } catch (Throwable th) {
            logger.debug("failed to persist is config enqueued " + Utils.formatException(th));
        }
    }

    private void resetIsConfigEnqueued() {
        setConfigEnqueued(-1L);
    }

    private void saveConfig(SLRemoteConfiguration sLRemoteConfiguration, SingularInstance singularInstance) {
        try {
            SharedPreferences.Editor edit = singularInstance.getContext().getSharedPreferences(Constants.PREF_CONFIG_MANAGER, 0).edit();
            edit.putString(Constants.CONFIG_MANAGER_CONFIG_KEY, sLRemoteConfiguration.toJson().toString());
            edit.commit();
        } catch (Throwable th) {
            logger.error("could not save config locally: " + Utils.formatException(th));
        }
    }

    private SLRemoteConfiguration loadConfig() {
        try {
            String string = SingularInstance.getInstance().getContext().getSharedPreferences(Constants.PREF_CONFIG_MANAGER, 0).getString(Constants.CONFIG_MANAGER_CONFIG_KEY, null);
            if (Utils.isEmptyOrNull(string)) {
                logger.error("local config is empty or null. returning default config");
                return SLRemoteConfiguration.defaultConfig();
            }
            return new SLRemoteConfiguration(new JSONObject(string));
        } catch (Throwable th) {
            logger.error("failed loading config from shared pref with error: " + Utils.formatException(th));
            return SLRemoteConfiguration.defaultConfig();
        }
    }

    public String getResolvedSdid() {
        SLRemoteConfiguration sLRemoteConfiguration = this.currentConfig;
        if (sLRemoteConfiguration == null || Utils.isEmptyOrNull(sLRemoteConfiguration.getSdid())) {
            return null;
        }
        return this.currentConfig.getSdid();
    }

    public boolean isAdmonEventsDebug() {
        SLRemoteConfiguration sLRemoteConfiguration = this.currentConfig;
        if (sLRemoteConfiguration != null) {
            return sLRemoteConfiguration.isAdmonEventsDebug();
        }
        return SLRemoteConfiguration.defaultConfig().isAdmonEventsDebug();
    }

    public boolean isAggregateAdmonEvents() {
        SLRemoteConfiguration sLRemoteConfiguration = this.currentConfig;
        if (sLRemoteConfiguration != null) {
            return sLRemoteConfiguration.isAggregateAdmonEvents();
        }
        return SLRemoteConfiguration.defaultConfig().isAggregateAdmonEvents();
    }

    public boolean isSetSdidEnabled() {
        SLRemoteConfiguration sLRemoteConfiguration = this.currentConfig;
        if (sLRemoteConfiguration != null) {
            return sLRemoteConfiguration.isSetSdidEnabled();
        }
        return SLRemoteConfiguration.defaultConfig().isSetSdidEnabled();
    }

    @Override // com.singular.sdk.internal.ApiConfig.ApiConfigCompletionHandler
    public void onSuccess(SLRemoteConfiguration sLRemoteConfiguration, SingularInstance singularInstance) {
        if (sLRemoteConfiguration != null) {
            try {
                this.currentConfig = sLRemoteConfiguration;
                saveConfig(sLRemoteConfiguration, singularInstance);
                resetIsConfigEnqueued();
            } catch (Throwable th) {
                logger.error("failed to handle config on success: " + Utils.formatException(th));
            }
        }
    }

    @Override // com.singular.sdk.internal.ApiConfig.ApiConfigCompletionHandler
    public void onFailure(String str) {
        logger.error(str);
    }
}
