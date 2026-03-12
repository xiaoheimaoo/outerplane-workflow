package com.helpshift.user;

import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.util.Utils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class BaseUser {
    protected final HSPersistentStorage persistentStorage;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cleanupUser();

    protected abstract JSONObject getUserData();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Map<String, String> getUserLoginInfo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isUserDataNeededForNetworkCall();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isUserDataValidForNetworkCall();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isUserSame(Map<String, Object> map);

    protected abstract void setUserData(JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseUser(HSPersistentStorage hSPersistentStorage) {
        this.persistentStorage = hSPersistentStorage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, String> getUserDataForNetworkCall(Map<String, String> map) {
        if (Utils.isEmpty(map)) {
            return null;
        }
        Map<String, String> userLoginInfo = getUserLoginInfo();
        if (Utils.isEmpty(userLoginInfo)) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        for (String str : userLoginInfo.keySet()) {
            String str2 = map.get(str);
            if (Utils.isNotEmpty(str2)) {
                hashMap.put(str2, userLoginInfo.get(str));
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, String> getDataForTokenRotation() {
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> void setUserDataValues(String str, T t) {
        JSONObject userData = getUserData();
        userData.put(str, t);
        setUserData(userData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T getUserDataValue(String str, T t) {
        Object obj;
        try {
            obj = getUserData().opt(str);
        } catch (Exception unused) {
            obj = t;
        }
        return obj == null ? t : (T) obj;
    }
}
