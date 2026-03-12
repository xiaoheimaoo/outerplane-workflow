package com.google.unity.ads;

import com.google.android.gms.ads.LoadAdError;
/* loaded from: classes3.dex */
public interface UnityInterstitialAdCallback extends UnityPaidEventListener, UnityFullScreenContentCallback {
    void onInterstitialAdFailedToLoad(LoadAdError error);

    void onInterstitialAdLoaded();
}
