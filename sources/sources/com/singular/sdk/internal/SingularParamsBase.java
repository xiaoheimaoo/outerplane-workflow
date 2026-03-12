package com.singular.sdk.internal;

import com.singular.sdk.internal.Constants;
import com.singular.sdk.internal.DeviceIDManager;
/* loaded from: classes3.dex */
public class SingularParamsBase extends SingularMap {
    /* JADX INFO: Access modifiers changed from: protected */
    public SingularParamsBase withDeviceInfo(SingularInstance singularInstance) {
        DeviceInfo deviceInfo = singularInstance.getDeviceInfo();
        put(Constants.RequestParamsKeys.PACKAGE_NAME_KEY, deviceInfo.packageName);
        put(Constants.RequestParamsKeys.PLATFORM_KEY, deviceInfo.platform);
        DeviceIDManager.SdidModel actualSdid = DeviceIDManager.getInstance().getActualSdid(ConfigManager.getInstance(), singularInstance.getContext());
        if (DeviceIDManager.getInstance().wasCustomSdidProvided() && !ConfigManager.getInstance().isSetSdidEnabled()) {
            put(Constants.DID_SET_CUSTOM_SDID_KEY, "0");
        }
        if (actualSdid != null && !Utils.isEmptyOrNull(actualSdid.getValue())) {
            if (DeviceIDManager.getInstance().wasCustomSdidProvided() && actualSdid.getSource() == DeviceIDManager.SdidModel.SdidSource.custom) {
                put(Constants.DID_SET_CUSTOM_SDID_KEY, "1");
            }
            put(Constants.RequestParamsKeys.IDENTIFIER_KEYSPACE_KEY, Constants.UPPERCASE_SDID_KEY);
            put(Constants.RequestParamsKeys.IDENTIFIER_UNIQUE_ID_KEY, actualSdid.getValue());
            putAsidOrAifaIfNotNull(deviceInfo);
        } else if (!Utils.isEmptyOrNull(deviceInfo.amid)) {
            put(Constants.DeviceIdentifierKeyspaceKeys.AMID_KEYSPACE_KEY, deviceInfo.amid);
            put(Constants.RequestParamsKeys.IDENTIFIER_KEYSPACE_KEY, Constants.DeviceIdentifierKeyspaceValues.AMID_KEYSPACE_VALUE);
            put(Constants.RequestParamsKeys.IDENTIFIER_UNIQUE_ID_KEY, deviceInfo.amid);
            putAsidOrAifaIfNotNull(deviceInfo);
        } else if (!Utils.isEmptyOrNull(deviceInfo.aifa)) {
            put(Constants.DeviceIdentifierKeyspaceKeys.AIFA_KEYSPACE_KEY, deviceInfo.aifa);
            put(Constants.RequestParamsKeys.IDENTIFIER_KEYSPACE_KEY, Constants.DeviceIdentifierKeyspaceValues.AIFA_KEYSPACE_VALUE);
            put(Constants.RequestParamsKeys.IDENTIFIER_UNIQUE_ID_KEY, deviceInfo.aifa);
        } else if (!Utils.isEmptyOrNull(deviceInfo.oaid)) {
            put(Constants.RequestParamsKeys.IDENTIFIER_KEYSPACE_KEY, Constants.DeviceIdentifierKeyspaceValues.OAID_KEYSPACE_VALUE);
            put(Constants.RequestParamsKeys.IDENTIFIER_UNIQUE_ID_KEY, deviceInfo.oaid);
            put(Constants.DeviceIdentifierKeyspaceKeys.OAID_KEYSPACE_KEY, deviceInfo.oaid);
            if (!Utils.isEmptyOrNull(deviceInfo.asid)) {
                put(Constants.DeviceIdentifierKeyspaceKeys.ASID_KEYSPACE_KEY, deviceInfo.asid);
            }
        } else if (!Utils.isEmptyOrNull(deviceInfo.imei)) {
            put(Constants.DeviceIdentifierKeyspaceKeys.IMEI_KEYSPACE_KEY, deviceInfo.imei);
            put(Constants.RequestParamsKeys.IDENTIFIER_KEYSPACE_KEY, Constants.DeviceIdentifierKeyspaceValues.IMEI_KEYSPACE_VALUE);
            put(Constants.RequestParamsKeys.IDENTIFIER_UNIQUE_ID_KEY, deviceInfo.imei);
        } else if (!Utils.isEmptyOrNull(deviceInfo.asid)) {
            put(Constants.RequestParamsKeys.IDENTIFIER_KEYSPACE_KEY, Constants.DeviceIdentifierKeyspaceValues.ASID_KEYSPACE_VALUE);
            put(Constants.RequestParamsKeys.IDENTIFIER_UNIQUE_ID_KEY, deviceInfo.asid);
            put(Constants.DeviceIdentifierKeyspaceKeys.ASID_KEYSPACE_KEY, deviceInfo.asid);
        } else if (!Utils.isEmptyOrNull(deviceInfo.andi)) {
            put(Constants.RequestParamsKeys.IDENTIFIER_KEYSPACE_KEY, Constants.DeviceIdentifierKeyspaceValues.ANDI_KEYSPACE_VALUE);
            put(Constants.RequestParamsKeys.IDENTIFIER_UNIQUE_ID_KEY, deviceInfo.andi);
            put(Constants.DeviceIdentifierKeyspaceKeys.ANDI_KEYSPACE_KEY, deviceInfo.andi);
        }
        return this;
    }

    private void putAsidOrAifaIfNotNull(DeviceInfo deviceInfo) {
        if (!Utils.isEmptyOrNull(deviceInfo.aifa)) {
            put(Constants.DeviceIdentifierKeyspaceKeys.AIFA_KEYSPACE_KEY, deviceInfo.aifa);
        } else if (Utils.isEmptyOrNull(deviceInfo.asid)) {
        } else {
            put(Constants.DeviceIdentifierKeyspaceKeys.ASID_KEYSPACE_KEY, deviceInfo.asid);
        }
    }
}
