package com.singular.sdk.internal;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SLRemoteConfiguration implements SLJsonSerializable {
    private static final SingularLog logger = SingularLog.getLogger("SLRemoteConfiguration");
    private AdmonBatching admonBatching;
    private boolean isSetSdidEnabled;
    private Resolve resolve;

    /* loaded from: classes3.dex */
    interface Constants {
        public static final String ADMON_BATCHING_JSON_KEY = "admon_batching";
        public static final String AGGREGATE_ADMON_EVENTS_JSON_KEY = "AggregateAdmonEvents";
        public static final String DEBUG_JSON_KEY = "debug";
        public static final String RESOLVE_JSON_KEY = "resolve";
        public static final String SDID_JSON_KEY = "sdid";
        public static final String SET_SDID_ENABLED_JSON_KEY = "set_sdid_enabled";
    }

    public boolean isAggregateAdmonEvents() {
        AdmonBatching admonBatching = this.admonBatching;
        if (admonBatching == null) {
            return defaultConfig().isAggregateAdmonEvents();
        }
        return admonBatching.isAggregateAdmonEvents();
    }

    public boolean isAdmonEventsDebug() {
        AdmonBatching admonBatching = this.admonBatching;
        if (admonBatching == null) {
            return defaultConfig().isAdmonEventsDebug();
        }
        return admonBatching.isDebug();
    }

    public boolean isSetSdidEnabled() {
        return this.isSetSdidEnabled;
    }

    public String getSdid() {
        Resolve resolve = this.resolve;
        if (resolve == null) {
            return defaultConfig().getSdid();
        }
        return resolve.getSdid();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SLRemoteConfiguration(JSONObject jSONObject) {
        this.isSetSdidEnabled = false;
        try {
            if (jSONObject.has(Constants.ADMON_BATCHING_JSON_KEY)) {
                this.admonBatching = new AdmonBatching(jSONObject.getJSONObject(Constants.ADMON_BATCHING_JSON_KEY));
            } else {
                this.admonBatching = new AdmonBatching(new JSONObject());
            }
            if (jSONObject.has(Constants.SET_SDID_ENABLED_JSON_KEY)) {
                this.isSetSdidEnabled = jSONObject.getBoolean(Constants.SET_SDID_ENABLED_JSON_KEY);
            }
            if (jSONObject.has(Constants.RESOLVE_JSON_KEY)) {
                this.resolve = new Resolve(jSONObject.getJSONObject(Constants.RESOLVE_JSON_KEY));
            } else {
                this.resolve = new Resolve(new JSONObject());
            }
        } catch (Throwable th) {
            logger.error("failed parsing remote configuration json with error: " + Utils.formatException(th));
        }
    }

    public static SLRemoteConfiguration defaultConfig() {
        return new SLRemoteConfiguration(new JSONObject());
    }

    @Override // com.singular.sdk.internal.SLJsonSerializable
    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.SET_SDID_ENABLED_JSON_KEY, this.isSetSdidEnabled);
            AdmonBatching admonBatching = this.admonBatching;
            if (admonBatching != null) {
                jSONObject.put(Constants.ADMON_BATCHING_JSON_KEY, admonBatching.toJson());
            }
            Resolve resolve = this.resolve;
            if (resolve != null) {
                jSONObject.put(Constants.RESOLVE_JSON_KEY, resolve.toJson());
            }
            return jSONObject;
        } catch (Throwable th) {
            logger.error("failed to create json object with error: " + Utils.formatException(th));
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class AdmonBatching implements SLJsonSerializable {
        private boolean aggregateAdmonEvents;
        private boolean debug;

        AdmonBatching(JSONObject jSONObject) {
            this.aggregateAdmonEvents = false;
            this.debug = false;
            try {
                if (jSONObject.has(Constants.AGGREGATE_ADMON_EVENTS_JSON_KEY)) {
                    this.aggregateAdmonEvents = jSONObject.getBoolean(Constants.AGGREGATE_ADMON_EVENTS_JSON_KEY);
                }
                if (jSONObject.has(Constants.DEBUG_JSON_KEY)) {
                    this.debug = jSONObject.getBoolean(Constants.DEBUG_JSON_KEY);
                }
            } catch (Throwable th) {
                SLRemoteConfiguration.logger.error("failed parsing admon batching json with error: " + Utils.formatException(th));
            }
        }

        public boolean isAggregateAdmonEvents() {
            return this.aggregateAdmonEvents;
        }

        public boolean isDebug() {
            return this.debug;
        }

        @Override // com.singular.sdk.internal.SLJsonSerializable
        public JSONObject toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.AGGREGATE_ADMON_EVENTS_JSON_KEY, this.aggregateAdmonEvents);
                jSONObject.put(Constants.DEBUG_JSON_KEY, this.debug);
                return jSONObject;
            } catch (Throwable th) {
                SLRemoteConfiguration.logger.error("failed to create json object with error: " + Utils.formatException(th));
                return new JSONObject();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Resolve implements SLJsonSerializable {
        private String sdid;

        public Resolve(JSONObject jSONObject) {
            try {
                if (jSONObject.has("sdid")) {
                    this.sdid = jSONObject.getString("sdid");
                }
            } catch (Throwable th) {
                SLRemoteConfiguration.logger.error("failed parsing identifiers json with error: " + Utils.formatException(th));
            }
        }

        public String getSdid() {
            return this.sdid;
        }

        public void setSdid(String str) {
            if (Utils.isEmptyOrNull(str)) {
                return;
            }
            this.sdid = str;
        }

        @Override // com.singular.sdk.internal.SLJsonSerializable
        public JSONObject toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                if (!Utils.isEmptyOrNull(this.sdid)) {
                    jSONObject.put("sdid", this.sdid);
                }
                return jSONObject;
            } catch (Throwable th) {
                SLRemoteConfiguration.logger.error("failed to create json object with error: " + Utils.formatException(th));
                return new JSONObject();
            }
        }
    }
}
