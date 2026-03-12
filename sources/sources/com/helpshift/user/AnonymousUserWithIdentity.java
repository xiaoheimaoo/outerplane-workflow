package com.helpshift.user;

import com.helpshift.storage.HSPersistentStorage;
import com.helpshift.util.JsonUtils;
import java.util.Map;
/* loaded from: classes3.dex */
public class AnonymousUserWithIdentity extends UserWithIdentity {
    public static final String ANONYMOUS_USER_WITH_IDENTITY_ID = "anon_uid";

    public AnonymousUserWithIdentity(HSPersistentStorage hSPersistentStorage) {
        super(hSPersistentStorage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.helpshift.user.UserWithIdentity, com.helpshift.user.BaseUser
    public boolean isUserSame(Map<String, Object> map) {
        return IdentityValidationUtil.isNewIdentityUserSame(map, JsonUtils.jsonStringToMap((String) getUserDataValue(UserConstants.USER_LOGIN_CONFIG, "")));
    }
}
