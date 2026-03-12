package com.helpshift.user;

import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AnonymousUser extends BaseUser {
    private static final String ANON_USER_DATA = "anon_user_data";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public void cleanupUser() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public boolean isUserDataNeededForNetworkCall() {
        return true;
    }

    public AnonymousUser(HSPersistentStorage hSPersistentStorage) {
        super(hSPersistentStorage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public boolean isUserSame(Map<String, Object> map) {
        Map<String, String> jsonStringToStringMap = JsonUtils.jsonStringToStringMap(this.persistentStorage.getAnonymousUserIdMap());
        return Utils.isNotEmpty(jsonStringToStringMap) && jsonStringToStringMap.equals(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public Map<String, String> getUserLoginInfo() {
        return JsonUtils.jsonStringToStringMap(this.persistentStorage.getAnonymousUserIdMap());
    }

    @Override // com.helpshift.user.BaseUser
    protected JSONObject getUserData() {
        String string = this.persistentStorage.getString("anon_user_data");
        return new JSONObject((Utils.isEmpty(string) || !JsonUtils.isValidJsonString(string)) ? "{}" : "{}");
    }

    @Override // com.helpshift.user.BaseUser
    protected void setUserData(JSONObject jSONObject) {
        this.persistentStorage.putString("anon_user_data", jSONObject.toString());
    }

    public void removeAnonymousUser() {
        this.persistentStorage.removeAnonymousUserIdMap();
        this.persistentStorage.putString("anon_user_data", "{}");
        this.persistentStorage.setFailedAnalyticsEvents(new JSONArray());
    }

    public boolean userDataExists() {
        return Utils.isNotEmpty(getUserLoginInfo());
    }

    public void saveAnonUserData(JSONObject jSONObject) {
        this.persistentStorage.storeAnonymousUserIdMap(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public boolean isUserDataValidForNetworkCall() {
        return Utils.validateUserIdEmailForLogin(getUserLoginInfo().get("userId"), "");
    }
}
