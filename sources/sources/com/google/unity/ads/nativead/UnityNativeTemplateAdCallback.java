package com.google.unity.ads.nativead;

import com.google.android.gms.ads.LoadAdError;
import com.google.unity.ads.UnityFullScreenContentCallback;
import com.google.unity.ads.UnityPaidEventListener;
/* loaded from: classes3.dex */
public interface UnityNativeTemplateAdCallback extends UnityPaidEventListener, UnityFullScreenContentCallback {
    void onNativeAdFailedToLoad(LoadAdError error);

    void onNativeAdLoaded();
}
