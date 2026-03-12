package com.helpshift.user;

import com.helpshift.log.HSLogger;
import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UserWithIdentity extends BaseUser {
    private static final String APP_ATTRIBUTES = "app_attributes";
    public static final String IDENTITIES_HASH_LIST = "identities_hash_list";
    public static final String IDENTITIES_SIGNATURE = "identitiesSignature";
    public static final String IDENTITY_TOKEN = "identity_token";
    private static final String TAG = "UserWithId";
    public static final String UNSYNC_APP_ATTRIBUTES = "unsync_app_attributes";
    public static final String UNSYNC_IDENTITIES = "unsync_identities";
    public static final String UNSYNC_MASTER_ATTRIBUTES = "unsync_master_attributes";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public boolean isUserDataNeededForNetworkCall() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.helpshift.user.BaseUser
    public boolean isUserDataValidForNetworkCall() {
        return true;
    }

    public UserWithIdentity(HSPersistentStorage hSPersistentStorage) {
        super(hSPersistentStorage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public boolean isUserSame(Map<String, Object> map) {
        Map<String, Object> jsonStringToMap = JsonUtils.jsonStringToMap(this.persistentStorage.getActiveUser());
        jsonStringToMap.put(UserConstants.FULL_PRIVACY_ENABLED, Boolean.valueOf(((Boolean) Utils.getOrDefault(JsonUtils.jsonStringToMap((String) getUserDataValue(UserConstants.USER_LOGIN_CONFIG, "")), UserConstants.FULL_PRIVACY_ENABLED, false)).booleanValue()));
        return IdentityValidationUtil.isNewIdentityUserSame(map, jsonStringToMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public Map<String, String> getUserLoginInfo() {
        return JsonUtils.jsonStringToStringMap(this.persistentStorage.getActiveUser());
    }

    @Override // com.helpshift.user.BaseUser
    protected JSONObject getUserData() {
        String string = this.persistentStorage.getString(UserConstants.ACTIVE_USER_DATA);
        return new JSONObject((Utils.isEmpty(string) || !JsonUtils.isValidJsonString(string)) ? "{}" : "{}");
    }

    @Override // com.helpshift.user.BaseUser
    protected void setUserData(JSONObject jSONObject) {
        this.persistentStorage.putString(UserConstants.ACTIVE_USER_DATA, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public void cleanupUser() {
        this.persistentStorage.removeActiveUser();
        this.persistentStorage.putString(UserConstants.ACTIVE_USER_DATA, "{}");
        this.persistentStorage.setFailedAnalyticsEvents(new JSONArray());
        clearUnSyncAttributesAndIdentities();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public Map<String, String> getUserDataForNetworkCall(Map<String, String> map) {
        return new HashMap();
    }

    @Override // com.helpshift.user.BaseUser
    public Map<String, String> getDataForTokenRotation() {
        HashMap hashMap = new HashMap();
        hashMap.put(UserConstants.ACCESS_TOKEN, getAccessToken());
        hashMap.put(UserConstants.REFRESH_TOKEN, getRefreshToken());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeExistingAppAttributes(Map<String, Object> map, List<String> list) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(getExistingAppAttributes());
        hashMap.putAll(getUnsyncAppAttributes());
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            Object obj = map.get(next);
            if (hashMap.containsKey(next) && list.contains(next) && hashMap.get(next).equals(obj)) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addUnSyncIdentities(String str) {
        List<String> unSyncIdentitiesList = getUnSyncIdentitiesList();
        if (unSyncIdentitiesList.contains(str)) {
            return;
        }
        unSyncIdentitiesList.add(str);
        this.persistentStorage.putString(UNSYNC_IDENTITIES, new JSONArray((Collection) unSyncIdentitiesList).toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<String> getUnSyncIdentitiesList() {
        return JsonUtils.listFromJsonArrayString(getUnSyncIdentitiesString());
    }

    protected String getUnSyncIdentitiesString() {
        return this.persistentStorage.getString(UNSYNC_IDENTITIES);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> getUnsyncAppAttributes() {
        return JsonUtils.jsonStringToMap(this.persistentStorage.getString(UNSYNC_APP_ATTRIBUTES));
    }

    private List<String> mergeListAttributes(Object obj, Object obj2) {
        try {
            if ((obj instanceof List) && (obj2 instanceof List)) {
                List list = (List) obj2;
                list.addAll((List) obj);
                return new ArrayList(new LinkedHashSet(list));
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Unsynced attribute type changed in merge", e);
        }
        return new ArrayList();
    }

    private Map<String, Object> mergeMapAttributes(Object obj, Object obj2) {
        try {
            if ((obj instanceof Map) && (obj2 instanceof Map)) {
                Map<String, Object> map = (Map) obj2;
                map.putAll((Map) obj);
                return map;
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Unsynced attribute type changed in merge", e);
        }
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addUnsyncedMasterAttributes(Map<String, Object> map) {
        Map<String, Object> unsyncedMasterAttributes = getUnsyncedMasterAttributes();
        mergeUnsyncedAttributes(map, unsyncedMasterAttributes);
        this.persistentStorage.putString(UNSYNC_MASTER_ATTRIBUTES, JsonUtils.mapToJsonString(new HashMap(unsyncedMasterAttributes)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> getUnsyncedMasterAttributes() {
        return JsonUtils.jsonStringToMap(this.persistentStorage.getString(UNSYNC_MASTER_ATTRIBUTES));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addUnsyncedAppAttributes(Map<String, Object> map) {
        Map<String, Object> unsyncAppAttributes = getUnsyncAppAttributes();
        mergeUnsyncedAttributes(map, unsyncAppAttributes);
        this.persistentStorage.putString(UNSYNC_APP_ATTRIBUTES, JsonUtils.mapToJsonString(new HashMap(unsyncAppAttributes)));
    }

    private void mergeUnsyncedAttributes(Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (map2.containsKey(key)) {
                Object obj2 = map2.get(key);
                if (value instanceof List) {
                    List<String> mergeListAttributes = mergeListAttributes(value, obj2);
                    boolean isNotEmpty = Utils.isNotEmpty(mergeListAttributes);
                    obj = mergeListAttributes;
                    if (!isNotEmpty) {
                    }
                    value = obj;
                } else if (value instanceof Map) {
                    Map<String, Object> mergeMapAttributes = mergeMapAttributes(value, obj2);
                    boolean isNotEmpty2 = Utils.isNotEmpty(mergeMapAttributes);
                    obj = mergeMapAttributes;
                    if (!isNotEmpty2) {
                    }
                    value = obj;
                }
            }
            map2.put(key, value);
        }
    }

    private Map<String, String> getExistingAppAttributes() {
        return JsonUtils.jsonStringToStringMap((String) getUserDataValue("app_attributes", "{}"));
    }

    public void clearUnSyncAttributesAndIdentities() {
        clearUnsyncIdentities();
        clearUnyncMasterAttributes();
        clearUnsyncAppAttributes();
    }

    public void clearUnyncMasterAttributes() {
        this.persistentStorage.putString(UNSYNC_MASTER_ATTRIBUTES, "");
    }

    public void clearUnsyncAppAttributes() {
        this.persistentStorage.putString(UNSYNC_APP_ATTRIBUTES, "");
    }

    public void clearUnsyncIdentities() {
        this.persistentStorage.putString(UNSYNC_IDENTITIES, "");
    }

    public void updateSyncedAppAttributes(String str, List<String> list) {
        Map<String, Object> jsonStringToMap = JsonUtils.jsonStringToMap((String) getUserDataValue("app_attributes", ""));
        Map<String, Object> jsonStringToMap2 = JsonUtils.jsonStringToMap(str);
        HashMap hashMap = new HashMap();
        for (String str2 : list) {
            if (jsonStringToMap2.containsKey(str2)) {
                hashMap.put(str2, jsonStringToMap2.get(str2));
            }
        }
        mergeUnsyncedAttributes(hashMap, jsonStringToMap);
        setUserDataValues("app_attributes", JsonUtils.mapToJsonString(jsonStringToMap));
    }

    public String getSignature() {
        return getUserLoginInfo().get(IDENTITIES_SIGNATURE);
    }

    public String getAccessToken() {
        return (String) getUserDataValue(UserConstants.ACCESS_TOKEN, "");
    }

    public String getRefreshToken() {
        return (String) getUserDataValue(UserConstants.REFRESH_TOKEN, "");
    }

    public void setAccessToken(String str) {
        setUserDataValues(UserConstants.ACCESS_TOKEN, str);
    }

    public void setRefreshToken(String str) {
        setUserDataValues(UserConstants.REFRESH_TOKEN, str);
    }

    public void setRefreshTokenExpiry(long j) {
        if (j != 0) {
            setUserDataValues(UserConstants.REFRESH_TOKEN_TTL, Long.valueOf(j));
        }
    }
}
