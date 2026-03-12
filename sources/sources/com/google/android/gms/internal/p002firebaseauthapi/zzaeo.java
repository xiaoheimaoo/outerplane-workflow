package com.google.android.gms.internal.p002firebaseauthapi;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeo  reason: invalid package */
/* loaded from: classes2.dex */
final class zzaeo implements Runnable {
    private final /* synthetic */ zzaen zza;
    private final /* synthetic */ zzaei zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaeo(zzaei zzaeiVar, zzaen zzaenVar) {
        this.zza = zzaenVar;
        this.zzb = zzaeiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            if (!this.zzb.zza.zzh.isEmpty()) {
                this.zza.zza(this.zzb.zza.zzh.get(0), new Object[0]);
            }
        }
    }
}
