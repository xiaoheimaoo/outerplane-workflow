package com.google.unity.ads;

import com.google.android.gms.ads.LoadAdError;
/* loaded from: classes3.dex */
public interface UnityAppOpenAdCallback extends UnityFullScreenContentCallback, UnityPaidEventListener {
    void onAppOpenAdFailedToLoad(LoadAdError error);

    void onAppOpenAdLoaded();
}
