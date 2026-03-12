package com.helpshift.user;

import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.util.JsonUtils;
import com.helpshift.util.Utils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class OldLoginUser extends BaseUser {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public boolean isUserDataNeededForNetworkCall() {
        return true;
    }

    public OldLoginUser(HSPersistentStorage hSPersistentStorage) {
        super(hSPersistentStorage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public boolean isUserSame(Map<String, Object> map) {
        Map<String, String> userLoginInfo = getUserLoginInfo();
        return Utils.isNotEmpty(userLoginInfo) && userLoginInfo.equals(map);
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.BaseUser
    public boolean isUserDataValidForNetworkCall() {
        Map<String, String> userLoginInfo = getUserLoginInfo();
        return Utils.validateUserIdEmailForLogin(userLoginInfo.get("userId"), userLoginInfo.get("userEmail"));
    }
}
