package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* loaded from: classes3.dex */
public final class zzca implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ zzcb zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzca(zzcb zzcbVar) {
        this.zza = zzcbVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        boolean zzb;
        zzaq zzaqVar;
        if (z) {
            this.zza.zzc = true;
            this.zza.zza();
            return;
        }
        this.zza.zzc = false;
        zzb = this.zza.zzb();
        if (zzb) {
            zzaqVar = this.zza.zzb;
            zzaqVar.zzc();
        }
    }
}
