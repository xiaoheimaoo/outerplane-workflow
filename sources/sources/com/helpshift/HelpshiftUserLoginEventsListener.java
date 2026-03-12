package com.helpshift;

import java.util.Map;
/* loaded from: classes3.dex */
public interface HelpshiftUserLoginEventsListener {
    void onLoginFailure(String str, Map<String, String> map);

    void onLoginSuccess();
}
