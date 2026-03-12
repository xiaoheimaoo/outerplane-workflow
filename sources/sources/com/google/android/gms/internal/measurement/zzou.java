package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzou implements zzor {
    private static final zzhx<Boolean> zza;

    static {
        zzif zza2 = new zzif(zzhu.zza("com.google.android.gms.measurement")).zzb().zza();
        zza2.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zza2.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zza = zza2.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zza2.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final boolean zza() {
        return zza.zza().booleanValue();
    }
}
