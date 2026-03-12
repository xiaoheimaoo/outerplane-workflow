package com.google.unity.ump;

import android.app.Activity;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import com.google.unity.ump.UnityConsentForm;
/* loaded from: classes3.dex */
public class UnityConsentForm {
    private final Activity activity;
    private final UnityConsentFormCallback callback;
    private final ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener = new AnonymousClass1();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.unity.ump.UnityConsentForm$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements ConsentForm.OnConsentFormDismissedListener {
        AnonymousClass1() {
        }

        @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
        public void onConsentFormDismissed(final FormError error) {
            new Thread(new Runnable() { // from class: com.google.unity.ump.UnityConsentForm$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UnityConsentForm.AnonymousClass1.this.m435x3b14d05a(error);
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onConsentFormDismissed$0$com-google-unity-ump-UnityConsentForm$1  reason: not valid java name */
        public /* synthetic */ void m435x3b14d05a(FormError formError) {
            if (UnityConsentForm.this.callback != null) {
                UnityConsentForm.this.callback.onConsentFormDismissed(formError);
            }
        }
    }

    public UnityConsentForm(Activity activity, UnityConsentFormCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    public void loadAndShowConsentFormIfRequired() {
        UserMessagingPlatform.loadAndShowConsentFormIfRequired(this.activity, this.onConsentFormDismissedListener);
    }

    public void show(ConsentForm consentForm) {
        consentForm.show(this.activity, this.onConsentFormDismissedListener);
    }

    public void showPrivacyOptionsForm() {
        UserMessagingPlatform.showPrivacyOptionsForm(this.activity, this.onConsentFormDismissedListener);
    }
}
