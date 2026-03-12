package com.google.unity.ads;

import android.app.Activity;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
/* loaded from: classes3.dex */
public final class UnityAdInspector {
    private UnityAdInspector() {
    }

    public static void openAdInspector(final Activity activity, final UnityAdInspectorListener adInspectorListener) {
        activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.UnityAdInspector.1
            @Override // java.lang.Runnable
            public void run() {
                MobileAds.openAdInspector(activity, new OnAdInspectorClosedListener() { // from class: com.google.unity.ads.UnityAdInspector.1.1
                    @Override // com.google.android.gms.ads.OnAdInspectorClosedListener
                    public void onAdInspectorClosed(AdInspectorError adInspectorError) {
                        if (adInspectorListener != null) {
                            adInspectorListener.onAdInspectorClosed(adInspectorError);
                        }
                    }
                });
            }
        });
    }
}
