package com.google.unity.ads;

import com.google.android.gms.ads.LoadAdError;
/* loaded from: classes3.dex */
public interface UnityAdListener extends UnityPaidEventListener {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(LoadAdError error);

    void onAdImpression();

    void onAdLeftApplication();

    void onAdLoaded();

    void onAdOpened();
}
