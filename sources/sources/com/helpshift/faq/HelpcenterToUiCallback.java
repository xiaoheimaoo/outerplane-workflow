package com.helpshift.faq;
/* loaded from: classes3.dex */
public interface HelpcenterToUiCallback {
    void closeHelpcenter();

    void getWebchatData();

    void onHelpcenterError();

    void onHelpcenterLoaded();

    void openWebchat();

    void setNativeUiColors(String str);

    void showNotificationBadgeOnHCLoad();
}
