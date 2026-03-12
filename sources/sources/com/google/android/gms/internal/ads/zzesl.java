package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.singular.sdk.internal.Constants;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzesl implements zzexp {
    private final com.google.android.gms.ads.internal.client.zzw zza;
    private final zzcei zzb;
    private final boolean zzc;

    public zzesl(com.google.android.gms.ads.internal.client.zzw zzwVar, zzcei zzceiVar, boolean z) {
        this.zza = zzwVar;
        this.zzb = zzceiVar;
        this.zzc = z;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzb.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfh)).intValue()) {
            bundle.putString("app_open_version", "2");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfi)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzc);
        }
        com.google.android.gms.ads.internal.client.zzw zzwVar = this.zza;
        if (zzwVar != null) {
            int i = zzwVar.zza;
            if (i == 1) {
                bundle.putString("avo", Constants.RequestParamsKeys.PLATFORM_KEY);
            } else if (i == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
