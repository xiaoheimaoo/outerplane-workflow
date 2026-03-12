package com.google.android.gms.internal.play_billing;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzcl extends zzbh {
    private final zzco zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcl(zzco zzcoVar, int i) {
        super(zzcoVar.size(), i);
        this.zza = zzcoVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbh
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
