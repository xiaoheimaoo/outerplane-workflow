package com.google.android.gms.internal.play_billing;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzg {
    static final zzg zza;
    static final zzg zzb;
    final Throwable zzc;

    static {
        if (zzq.zza) {
            zzb = null;
            zza = null;
            return;
        }
        zzb = new zzg(false, null);
        zza = new zzg(true, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(boolean z, Throwable th) {
        this.zzc = th;
    }
}
