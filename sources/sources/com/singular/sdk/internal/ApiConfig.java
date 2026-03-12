package com.singular.sdk.internal;

import com.singular.sdk.SingularConfig;
import com.singular.sdk.internal.Api;
import com.singular.sdk.internal.Constants;
import com.singular.sdk.internal.DeviceIDManager;
import java.io.IOException;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ApiConfig extends BaseApi {
    private static final SingularLog logger = SingularLog.getLogger("ApiConfig");
    static final String path = "/config";

    /* loaded from: classes3.dex */
    public interface ApiConfigCompletionHandler {
        void onFailure(String str);

        void onSuccess(SLRemoteConfiguration sLRemoteConfiguration, SingularInstance singularInstance);
    }

    @Override // com.singular.sdk.internal.Api
    public String getPath() {
        return path;
    }

    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ long getTimestamp() {
        return super.getTimestamp();
    }

    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ String getType() {
        return super.getType();
    }

    @Override // com.singular.sdk.internal.BaseApi
    public /* bridge */ /* synthetic */ String getUrl() {
        return super.getUrl();
    }

    @Override // com.singular.sdk.internal.BaseApi
    public /* bridge */ /* synthetic */ boolean isAdmonEvent() {
        return super.isAdmonEvent();
    }

    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ boolean makeRequest(SingularInstance singularInstance) throws IOException {
        return super.makeRequest(singularInstance);
    }

    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ String toJsonAsString() {
        return super.toJsonAsString();
    }

    public ApiConfig(long j) {
        super(Constants.API_TYPE_CONFIG, j);
    }

    @Override // com.singular.sdk.internal.Api
    public Api.OnApiCallback getOnApiCallback() {
        return new OnConfigCallback();
    }

    /* loaded from: classes3.dex */
    public class OnConfigCallback implements Api.OnApiCallback {
        public OnConfigCallback() {
        }

        @Override // com.singular.sdk.internal.Api.OnApiCallback
        public boolean handle(SingularInstance singularInstance, int i, String str) {
            if (i != 200 || Utils.isEmptyOrNull(str)) {
                ConfigManager.getInstance().onFailure("invalid remote config response");
                return false;
            }
            try {
                ConfigManager.getInstance().onSuccess(new SLRemoteConfiguration(new JSONObject(str)), singularInstance);
                ApiConfig.this.invokeSdidAccessorHandlersAsyncly(singularInstance);
                return true;
            } catch (JSONException e) {
                ApiConfig.logger.error(Utils.formatException(e));
                ConfigManager.getInstance().onFailure(Utils.formatException(e));
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeSdidAccessorHandlersAsyncly(final SingularInstance singularInstance) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.ApiConfig.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SingularInstance singularInstance2 = singularInstance;
                    if (singularInstance2 == null) {
                        ApiConfig.logger.debug("can't invoke sdid handlers - singular instance is null");
                        return;
                    }
                    SingularConfig singularConfig = singularInstance2.getSingularConfig();
                    if (singularConfig == null) {
                        ApiConfig.logger.debug("can't invoke sdid handlers - singular config is null");
                    } else if (singularConfig.sdidAccessorHandler == null) {
                        ApiConfig.logger.debug("can't invoke sdid handlers - SDID accessor handler is null");
                    } else {
                        DeviceIDManager.SdidModel actualSdid = DeviceIDManager.getInstance().getActualSdid(ConfigManager.getInstance(), singularInstance.getContext());
                        if (actualSdid == null) {
                            ApiConfig.logger.debug("can't invoke sdid handlers - SDID model is null");
                        } else if (actualSdid.getSource() == DeviceIDManager.SdidModel.SdidSource.custom) {
                            ApiConfig.logger.debug("invoking did set SDID handler");
                            singularConfig.sdidAccessorHandler.didSetSdid(actualSdid.getValue());
                        } else if (actualSdid.getSource() == DeviceIDManager.SdidModel.SdidSource.resolved) {
                            ApiConfig.logger.debug("invoking SDID received handler");
                            singularConfig.sdidAccessorHandler.sdidReceived(actualSdid.getValue());
                        }
                    }
                } catch (Throwable th) {
                    ApiConfig.logger.debug("invoking sdid accessor handlers handlers failed with error: " + Utils.formatException(th));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Params extends SingularParamsBase {
        private Params() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Params build(SingularInstance singularInstance) {
            return new Params().withUtils(singularInstance).withDeviceInfo(singularInstance).withSingularConfig(singularInstance.getSingularConfig());
        }

        private Params withSingularConfig(SingularConfig singularConfig) {
            put("a", singularConfig.apiKey);
            return this;
        }

        private Params withUtils(SingularInstance singularInstance) {
            put(Constants.RequestParamsKeys.SDK_VERSION_KEY, Utils.getSdkVersion(singularInstance));
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.singular.sdk.internal.SingularParamsBase
        public Params withDeviceInfo(SingularInstance singularInstance) {
            super.withDeviceInfo(singularInstance);
            return this;
        }
    }
}
