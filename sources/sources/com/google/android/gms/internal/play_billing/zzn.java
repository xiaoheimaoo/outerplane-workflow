package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzn extends zzf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzf
    public final void zza(zzo zzoVar, zzo zzoVar2) {
        zzoVar.zzc = zzoVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzf
    public final void zzb(zzo zzoVar, Thread thread) {
        zzoVar.zzb = thread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzf
    public final boolean zzc(zzq zzqVar, zzj zzjVar, zzj zzjVar2) {
        synchronized (zzqVar) {
            if (zzqVar.zzd == zzjVar) {
                zzqVar.zzd = zzjVar2;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzf
    public final boolean zzd(zzq zzqVar, Object obj, Object obj2) {
        synchronized (zzqVar) {
            if (zzqVar.zzc == obj) {
                zzqVar.zzc = obj2;
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzf
    public final boolean zze(zzq zzqVar, zzo zzoVar, zzo zzoVar2) {
        synchronized (zzqVar) {
            if (zzqVar.zze == zzoVar) {
                zzqVar.zze = zzoVar2;
                return true;
            }
            return false;
        }
    }
}
