package com.unity3d.scar.adapter.common;
/* loaded from: classes3.dex */
public interface IScarInterstitialAdListenerWrapper extends IScarAdListenerWrapper {
    void onAdClicked();

    void onAdFailedToShow(int i, String str);

    void onAdImpression();

    void onAdLeftApplication();
}
