package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzeau implements zzhhd {
    private final zzhhu zza;

    public zzeau(zzhhu zzhhuVar) {
        this.zza = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* renamed from: zza */
    public final String zzb() {
        String packageName = ((zzclm) this.zza).zza().getPackageName();
        zzhhl.zzb(packageName);
        return packageName;
    }
}
