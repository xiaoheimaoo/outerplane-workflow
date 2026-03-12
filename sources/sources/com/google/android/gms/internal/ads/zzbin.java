package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
import com.google.firebase.firestore.util.ExponentialBackoff;
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzbin {
    public static final zzbhm zza = zzbhm.zzb("gads:ad_loader:timeout_ms", ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
    public static final zzbhm zzb = zzbhm.zzb("gads:rendering:timeout_ms", ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
    public static final zzbhm zzc = zzbhm.zzb("gads:resolve_future:default_timeout_ms", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
}
