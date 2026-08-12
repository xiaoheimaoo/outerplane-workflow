package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
final class zzbr extends zzbn {
    private final zzbt zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbr(zzbt zzbtVar, int i) {
        super(zzbtVar.size(), i);
        this.zza = zzbtVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbn
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
