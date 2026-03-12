package com.google.unity.ads.admanager;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.unity.ads.admanager.AdManagerInterstitialAdCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class AdManagerInterstitialAdCallback extends AdManagerInterstitialAdLoadCallback {
    private AdManagerInterstitialAd adManagerInterstitialAd;
    private UnityAdManagerInterstitialAdCallback callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdManagerInterstitialAdCallback(AdManagerInterstitialAd adManagerInterstitialAd, UnityAdManagerInterstitialAdCallback callback) {
        this.adManagerInterstitialAd = adManagerInterstitialAd;
        this.callback = callback;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public void onAdLoaded(AdManagerInterstitialAd ad) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.adManagerInterstitialAd = ad;
        ad.setOnPaidEventListener(new AnonymousClass1(this, newSingleThreadExecutor));
        this.adManagerInterstitialAd.setAppEventListener(new AnonymousClass2(this, newSingleThreadExecutor));
        this.adManagerInterstitialAd.setFullScreenContentCallback(new AnonymousClass3(this, newSingleThreadExecutor));
        newSingleThreadExecutor.execute(new Runnable() { // from class: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AdManagerInterstitialAdCallback.this.m400x3b968b52();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements OnPaidEventListener {
        final /* synthetic */ AdManagerInterstitialAdCallback this$0;
        final /* synthetic */ ExecutorService val$service;

        AnonymousClass1(final AdManagerInterstitialAdCallback this$0, final ExecutorService val$service) {
            this.val$service = val$service;
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.OnPaidEventListener
        public void onPaidEvent(final AdValue adValue) {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AdManagerInterstitialAdCallback.AnonymousClass1.this.m401x6f568ff1(adValue);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onPaidEvent$0$com-google-unity-ads-admanager-AdManagerInterstitialAdCallback$1  reason: not valid java name */
        public /* synthetic */ void m401x6f568ff1(AdValue adValue) {
            if (this.this$0.callback != null) {
                this.this$0.callback.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements AppEventListener {
        final /* synthetic */ AdManagerInterstitialAdCallback this$0;
        final /* synthetic */ ExecutorService val$service;

        AnonymousClass2(final AdManagerInterstitialAdCallback this$0, final ExecutorService val$service) {
            this.val$service = val$service;
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.admanager.AppEventListener
        public void onAppEvent(final String name, final String data) {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AdManagerInterstitialAdCallback.AnonymousClass2.this.m402xa90b66cf(name, data);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onAppEvent$0$com-google-unity-ads-admanager-AdManagerInterstitialAdCallback$2  reason: not valid java name */
        public /* synthetic */ void m402xa90b66cf(String str, String str2) {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAppEvent(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 extends FullScreenContentCallback {
        final /* synthetic */ AdManagerInterstitialAdCallback this$0;
        final /* synthetic */ ExecutorService val$service;

        AnonymousClass3(final AdManagerInterstitialAdCallback this$0, final ExecutorService val$service) {
            this.val$service = val$service;
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(final AdError error) {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$3$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AdManagerInterstitialAdCallback.AnonymousClass3.this.m405xc41c6e9b(error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onAdFailedToShowFullScreenContent$0$com-google-unity-ads-admanager-AdManagerInterstitialAdCallback$3  reason: not valid java name */
        public /* synthetic */ void m405xc41c6e9b(AdError adError) {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdFailedToShowFullScreenContent(adError);
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AdManagerInterstitialAdCallback.AnonymousClass3.this.m407xb10b5621();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onAdShowedFullScreenContent$1$com-google-unity-ads-admanager-AdManagerInterstitialAdCallback$3  reason: not valid java name */
        public /* synthetic */ void m407xb10b5621() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdShowedFullScreenContent();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AdManagerInterstitialAdCallback.AnonymousClass3.this.m404xb72ca8af();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onAdDismissedFullScreenContent$2$com-google-unity-ads-admanager-AdManagerInterstitialAdCallback$3  reason: not valid java name */
        public /* synthetic */ void m404xb72ca8af() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdDismissedFullScreenContent();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdImpression() {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$3$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AdManagerInterstitialAdCallback.AnonymousClass3.this.m406xdf7532ba();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onAdImpression$3$com-google-unity-ads-admanager-AdManagerInterstitialAdCallback$3  reason: not valid java name */
        public /* synthetic */ void m406xdf7532ba() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdImpression();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            this.val$service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.AdManagerInterstitialAdCallback$3$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    AdManagerInterstitialAdCallback.AnonymousClass3.this.m403xa8255959();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onAdClicked$4$com-google-unity-ads-admanager-AdManagerInterstitialAdCallback$3  reason: not valid java name */
        public /* synthetic */ void m403xa8255959() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdClicked();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onAdLoaded$0$com-google-unity-ads-admanager-AdManagerInterstitialAdCallback  reason: not valid java name */
    public /* synthetic */ void m400x3b968b52() {
        UnityAdManagerInterstitialAdCallback unityAdManagerInterstitialAdCallback = this.callback;
        if (unityAdManagerInterstitialAdCallback != null) {
            unityAdManagerInterstitialAdCallback.onInterstitialAdLoaded();
        }
    }
}
