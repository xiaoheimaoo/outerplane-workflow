package com.google.android.gms.internal.consent_sdk;

import android.os.Build;
import com.google.firebase.firestore.BuildConfig;
/* compiled from: com.google.android.ump:user-messaging-platform@@2.2.0 */
/* loaded from: classes2.dex */
public final class zzct {
    public static boolean zza(boolean z) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Build.FINGERPRINT.contains("generic") || Build.FINGERPRINT.contains(BuildConfig.TARGET_BACKEND) || Build.HARDWARE.contains("ranchu");
        }
        return Build.DEVICE.startsWith("generic");
    }
}
