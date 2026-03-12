package com.helpshift.chat;
/* loaded from: classes3.dex */
public interface HSWebchatToUiCallback {
    void onUiConfigChange(String str);

    void onUserAuthenticationFailure();

    void onWebchatClosed();

    void onWebchatError(String str);

    void onWebchatLoaded();

    void requestConversationMetadata(String str);

    void setHelpcenterData();

    void webchatJsFileLoaded();
}
