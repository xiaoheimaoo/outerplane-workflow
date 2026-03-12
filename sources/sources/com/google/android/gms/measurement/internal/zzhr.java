package com.google.android.gms.measurement.internal;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
final class zzhr implements com.google.android.gms.internal.measurement.zzv {
    private final /* synthetic */ zzhm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhr(zzhm zzhmVar) {
        this.zza = zzhmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, List<String> list, boolean z, boolean z2) {
        zzgq zzc;
        int i = zzht.zza[zzsVar.ordinal()];
        if (i == 1) {
            zzc = this.zza.zzj().zzc();
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    zzc = this.zza.zzj().zzq();
                } else {
                    zzc = this.zza.zzj().zzp();
                }
            } else if (z) {
                zzc = this.zza.zzj().zzx();
            } else if (!z2) {
                zzc = this.zza.zzj().zzw();
            } else {
                zzc = this.zza.zzj().zzr();
            }
        } else if (z) {
            zzc = this.zza.zzj().zzo();
        } else if (!z2) {
            zzc = this.zza.zzj().zzm();
        } else {
            zzc = this.zza.zzj().zzg();
        }
        int size = list.size();
        if (size == 1) {
            zzc.zza(str, list.get(0));
        } else if (size == 2) {
            zzc.zza(str, list.get(0), list.get(1));
        } else if (size == 3) {
            zzc.zza(str, list.get(0), list.get(1), list.get(2));
        } else {
            zzc.zza(str);
        }
    }
}
