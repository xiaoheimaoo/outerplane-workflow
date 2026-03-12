package com.helpshift.user;

import com.helpshift.util.ValueListener;
/* loaded from: classes3.dex */
public class UpdatePushSyncStatus implements ValueListener<Boolean> {
    private final UserManager userManager;

    public UpdatePushSyncStatus(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override // com.helpshift.util.ValueListener
    public void update(Boolean bool) {
        this.userManager.setPushTokenSynced(bool.booleanValue());
    }
}
