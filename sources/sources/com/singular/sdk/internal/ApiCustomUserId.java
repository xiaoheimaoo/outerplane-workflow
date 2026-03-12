package com.singular.sdk.internal;

import androidx.core.app.NotificationCompat;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.internal.Api;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ApiCustomUserId extends BaseApi {
    private static final SingularLog logger = SingularLog.getLogger("ApiCustomUserId");
    static final String path = "/set_device_for_custom_id";

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

    public ApiCustomUserId(long j) {
        super(Constants.API_TYPE_CUSTOM_USER_ID, j);
    }

    @Override // com.singular.sdk.internal.Api
    public Api.OnApiCallback getOnApiCallback() {
        return new OnSetCustomUserIdCallback();
    }

    /* loaded from: classes3.dex */
    public class OnSetCustomUserIdCallback implements Api.OnApiCallback {
        public OnSetCustomUserIdCallback() {
        }

        @Override // com.singular.sdk.internal.Api.OnApiCallback
        public boolean handle(SingularInstance singularInstance, int i, String str) {
            if (i != 200) {
                return false;
            }
            try {
                return new JSONObject(str).optString(NotificationCompat.CATEGORY_STATUS, "").equalsIgnoreCase("ok");
            } catch (JSONException e) {
                ApiCustomUserId.logger.error("error in handle()", e);
                return false;
            }
        }
    }

    /* loaded from: classes3.dex */
    static class Params extends SingularParamsBase {
        private Params() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Params build(SingularInstance singularInstance) {
            return new Params().withSingularConfig(singularInstance.getSingularConfig()).withDeviceInfo(singularInstance);
        }

        private Params withSingularConfig(SingularConfig singularConfig) {
            put("a", singularConfig.apiKey);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
            if (r4.isLimitedTrackingEnabled != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0026, code lost:
            if (r4.isLimitedTrackingEnabled != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
            r1 = "0";
         */
        @Override // com.singular.sdk.internal.SingularParamsBase
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.singular.sdk.internal.ApiCustomUserId.Params withDeviceInfo(com.singular.sdk.internal.SingularInstance r4) {
            /*
                r3 = this;
                super.withDeviceInfo(r4)
                com.singular.sdk.internal.DeviceInfo r4 = r4.getDeviceInfo()
                java.lang.String r0 = "sdk"
                java.lang.String r1 = r4.sdkVersion
                r3.put(r0, r1)
                java.lang.String r0 = "av"
                java.lang.String r1 = r4.appVersion
                r3.put(r0, r1)
                java.lang.String r0 = "n"
                java.lang.String r1 = r4.appName
                r3.put(r0, r1)
                boolean r0 = r4.isGooglePlayServicesAvailable
                java.lang.String r1 = "1"
                java.lang.String r2 = "0"
                if (r0 == 0) goto L2b
                boolean r0 = r4.isLimitedTrackingEnabled
                if (r0 == 0) goto L29
                goto L36
            L29:
                r1 = r2
                goto L36
            L2b:
                boolean r0 = r4.isAmazonAvailable
                if (r0 == 0) goto L34
                boolean r0 = r4.isLimitedTrackingEnabled
                if (r0 == 0) goto L29
                goto L36
            L34:
                java.lang.String r1 = "-1"
            L36:
                java.lang.String r0 = "dnt"
                r3.put(r0, r1)
                java.lang.String r0 = "custom_user_id"
                java.lang.String r4 = r4.customUserId
                r3.put(r0, r4)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.singular.sdk.internal.ApiCustomUserId.Params.withDeviceInfo(com.singular.sdk.internal.SingularInstance):com.singular.sdk.internal.ApiCustomUserId$Params");
        }
    }
}
