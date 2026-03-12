package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzed;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement-api@@22.2.0 */
/* loaded from: classes3.dex */
final class zzd implements Callable<Long> {
    private final /* synthetic */ FirebaseAnalytics zza;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() throws Exception {
        zzed zzedVar;
        zzedVar = this.zza.zzb;
        return zzedVar.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }
}
