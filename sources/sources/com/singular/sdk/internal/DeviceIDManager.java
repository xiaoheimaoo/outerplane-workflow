package com.singular.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class DeviceIDManager {
    private static DeviceIDManager instance;
    private static final SingularLog logger = SingularLog.getLogger("DeviceIDManager");
    private SdidModel candidateCustomSdid = null;
    private SdidModel currentSdid;
    private SdidModel previousSdid;

    public static DeviceIDManager getInstance() {
        if (instance == null) {
            instance = new DeviceIDManager();
        }
        return instance;
    }

    public void setup(SingularInstance singularInstance) {
        loadPreviousSdidForComparison(singularInstance.getContext());
        getInstance().setCandidateCustomSdid(singularInstance);
    }

    private void setCandidateCustomSdid(SingularInstance singularInstance) {
        if (getActualSdid(ConfigManager.getInstance(), singularInstance.getContext()) != null) {
            logger.debug("ignoring set candidate custom sdid because one exists.");
            return;
        }
        String str = singularInstance.getSingularConfig().customSdid;
        if (Utils.isEmptyOrNull(str)) {
            this.candidateCustomSdid = null;
            logger.debug("setting candidate custom sdid to null");
            return;
        }
        this.candidateCustomSdid = new SdidModel(str, SdidModel.SdidSource.custom);
        logger.debug("setting candidate custom sdid: " + str);
    }

    private void loadPreviousSdidForComparison(Context context) {
        this.previousSdid = getActualSdid(ConfigManager.getInstance(), context);
        logger.debug("loaded previous sdid for comparison");
    }

    public SdidModel getActualSdid(ConfigManager configManager, Context context) {
        if (this.currentSdid == null) {
            logger.debug("current sdid is null, trying to pick actual sdid model");
            this.currentSdid = pickActualSdidModel(configManager, context);
        }
        return this.currentSdid;
    }

    private SdidModel pickActualSdidModel(ConfigManager configManager, Context context) {
        try {
            if (context == null) {
                logger.debug("failed to pick actual sdid model because context is null");
                return null;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_SESSION, 0);
            String string = sharedPreferences.getString(Constants.CUSTOM_SDID_KEY, null);
            if (!Utils.isEmptyOrNull(string)) {
                logger.debug("returning persisted custom sdid from prefs");
                return new SdidModel(string, SdidModel.SdidSource.custom);
            }
            String string2 = sharedPreferences.getString(Constants.PREF_SINGULAR_DEVICE_ID_KEY, null);
            if (!Utils.isEmptyOrNull(string2)) {
                logger.debug("returning persisted resolved sdid from prefs");
                return new SdidModel(string2, SdidModel.SdidSource.resolved);
            }
            boolean wasCustomSdidProvided = wasCustomSdidProvided();
            boolean isSetSdidEnabled = configManager.isSetSdidEnabled();
            if (wasCustomSdidProvided && isSetSdidEnabled) {
                SingularLog singularLog = logger;
                singularLog.debug("persisting custom set sdid to prefs");
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(Constants.CUSTOM_SDID_KEY, this.candidateCustomSdid.getValue());
                edit.commit();
                singularLog.debug("returning custom set sdid");
                return this.candidateCustomSdid;
            }
            String resolvedSdid = configManager.getResolvedSdid();
            if (!Utils.isEmptyOrNull(resolvedSdid)) {
                SingularLog singularLog2 = logger;
                singularLog2.debug("persisting resolved sdid to prefs");
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString(Constants.PREF_SINGULAR_DEVICE_ID_KEY, resolvedSdid);
                edit2.commit();
                singularLog2.debug("returning resolved sdid from config");
                return new SdidModel(resolvedSdid, SdidModel.SdidSource.resolved);
            }
            logger.debug("returning null - can't pick an actual valid SDID.");
            return null;
        } catch (Throwable th) {
            logger.error("caught throwable during pick actual sdid model. returning null: " + Utils.formatException(th));
            return null;
        }
    }

    public boolean isCurrentSdidNewComparedToPrevious(Context context) {
        SdidModel actualSdid = getActualSdid(ConfigManager.getInstance(), context);
        boolean z = this.previousSdid == null && actualSdid != null;
        this.previousSdid = actualSdid;
        logger.debug("is fresh sdid = ".concat(z ? "true" : "false"));
        return z;
    }

    public boolean wasCustomSdidProvided() {
        return this.candidateCustomSdid != null;
    }

    /* loaded from: classes3.dex */
    public static class SdidModel {
        private final SdidSource source;
        private final String value;

        /* loaded from: classes3.dex */
        public enum SdidSource {
            custom,
            resolved
        }

        SdidModel(String str, SdidSource sdidSource) {
            this.value = str;
            this.source = sdidSource;
        }

        public String getValue() {
            return this.value;
        }

        public SdidSource getSource() {
            return this.source;
        }
    }
}
