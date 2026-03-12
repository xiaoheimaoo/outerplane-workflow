package com.unity3d.scar.adapter.common;
/* loaded from: classes3.dex */
public interface IScarAdListenerWrapper {
    void onAdClosed();

    void onAdFailedToLoad(int i, String str);

    void onAdLoaded();

    void onAdOpened();

    void onAdSkipped();
}
