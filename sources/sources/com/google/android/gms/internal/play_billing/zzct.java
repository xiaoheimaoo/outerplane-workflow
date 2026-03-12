package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Set;
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzct extends zzbi implements Serializable {
    private static final zzct zza;
    private static final zzct zzb;
    private final transient zzco zzc;

    static {
        int i = zzco.zzd;
        zza = new zzct(zzdk.zza);
        zzb = new zzct(zzco.zzm(zzdh.zza()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzct(zzco zzcoVar) {
        this.zzc = zzcoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzct zza() {
        return zzb;
    }

    public static zzct zzb() {
        return zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdj
    public final /* bridge */ /* synthetic */ Set zzc() {
        if (this.zzc.isEmpty()) {
            return zzdq.zza;
        }
        return new zzdr(this.zzc, zzdg.zza);
    }
}
