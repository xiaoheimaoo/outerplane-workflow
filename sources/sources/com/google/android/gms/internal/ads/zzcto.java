package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.singular.sdk.internal.Constants;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzcto {
    private final zzflw zza;
    private final zzdwf zzb;
    private final zzfgy zzc;

    public zzcto(zzdwf zzdwfVar, zzfgy zzfgyVar, zzflw zzflwVar) {
        this.zza = zzflwVar;
        this.zzb = zzdwfVar;
        this.zzc = zzfgyVar;
    }

    private static String zzb(int i) {
        int i2 = i - 1;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? Constants.RequestParamsKeys.IDENTIFIER_UNIQUE_ID_KEY : "ac" : "cb" : "cc" : "bb" : "h";
    }

    public final void zza(long j, int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
            zzflw zzflwVar = this.zza;
            zzfgy zzfgyVar = this.zzc;
            zzflv zzb = zzflv.zzb("ad_closed");
            zzb.zzg(zzfgyVar.zzb.zzb);
            zzb.zza("show_time", String.valueOf(j));
            zzb.zza(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
            zzb.zza("acr", zzb(i));
            zzflwVar.zzb(zzb);
            return;
        }
        zzdwf zzdwfVar = this.zzb;
        zzfgy zzfgyVar2 = this.zzc;
        zzdwe zza = zzdwfVar.zza();
        zza.zze(zzfgyVar2.zzb.zzb);
        zza.zzb("action", "ad_closed");
        zza.zzb("show_time", String.valueOf(j));
        zza.zzb(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
        zza.zzb("acr", zzb(i));
        zza.zzg();
    }
}
