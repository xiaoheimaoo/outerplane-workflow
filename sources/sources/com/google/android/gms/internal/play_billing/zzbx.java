package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzbx extends zzca {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbx() {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzca
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzca
    public final zzca zzb(Comparable comparable, Comparable comparable2) {
        zzca zzcaVar;
        zzca zzcaVar2;
        zzca zzcaVar3;
        int compareTo = comparable.compareTo(comparable2);
        if (compareTo < 0) {
            zzcaVar3 = zzca.zzb;
            return zzcaVar3;
        } else if (compareTo > 0) {
            zzcaVar2 = zzca.zzc;
            return zzcaVar2;
        } else {
            zzcaVar = zzca.zza;
            return zzcaVar;
        }
    }
}
