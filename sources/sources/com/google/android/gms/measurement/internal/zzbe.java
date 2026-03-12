package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzbe {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final zzbg zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbe zza(zzic zzicVar, long j) {
        return new zzbe(zzicVar, this.zzc, this.zza, this.zzb, this.zzd, j, this.zzf);
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return "Event{appId='" + str + "', name='" + str2 + "', params=" + String.valueOf(this.zzf) + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbe(zzic zzicVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzbg zzbgVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzicVar.zzj().zzr().zza("Event created with reverse previous/current timestamps. appId", zzgo.zza(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzicVar.zzj().zzg().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzb = zzicVar.zzv().zzb(next, bundle2.get(next));
                    if (zzb == null) {
                        zzicVar.zzj().zzr().zza("Param value can't be null", zzicVar.zzk().zzb(next));
                        it.remove();
                    } else {
                        zzicVar.zzv().zza(bundle2, next, zzb);
                    }
                }
            }
            zzbgVar = new zzbg(bundle2);
        } else {
            zzbgVar = new zzbg(new Bundle());
        }
        this.zzf = zzbgVar;
    }

    private zzbe(zzic zzicVar, String str, String str2, String str3, long j, long j2, zzbg zzbgVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzbgVar);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzicVar.zzj().zzr().zza("Event created with reverse previous/current timestamps. appId, name", zzgo.zza(str2), zzgo.zza(str3));
        }
        this.zzf = zzbgVar;
    }
}
