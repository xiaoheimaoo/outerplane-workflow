package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgf;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzy {
    private zzgf.zzf zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgf.zzf zza(String str, zzgf.zzf zzfVar) {
        String zzg = zzfVar.zzg();
        List<zzgf.zzh> zzh = zzfVar.zzh();
        this.zzd.h_();
        Long l = (Long) zzpj.zzb(zzfVar, "_eid");
        boolean z = l != null;
        if (z && zzg.equals("_ep")) {
            Preconditions.checkNotNull(l);
            this.zzd.h_();
            zzg = (String) zzpj.zzb(zzfVar, "_en");
            if (TextUtils.isEmpty(zzg)) {
                this.zzd.zzj().zzo().zza("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<zzgf.zzf, Long> zza = this.zzd.zzh().zza(str, l);
                if (zza == null || zza.first == null) {
                    this.zzd.zzj().zzo().zza("Extra parameter without existing main event. eventName, eventId", zzg, l);
                    return null;
                }
                this.zza = (zzgf.zzf) zza.first;
                this.zzc = ((Long) zza.second).longValue();
                this.zzd.h_();
                this.zzb = (Long) zzpj.zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzar zzh2 = this.zzd.zzh();
                zzh2.zzv();
                zzh2.zzj().zzq().zza("Clearing complex main event info. appId", str);
                try {
                    zzh2.f_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzh2.zzj().zzg().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzh().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzgf.zzh zzhVar : this.zza.zzh()) {
                this.zzd.h_();
                if (zzpj.zza(zzfVar, zzhVar.zzg()) == null) {
                    arrayList.add(zzhVar);
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.addAll(zzh);
                zzh = arrayList;
            } else {
                this.zzd.zzj().zzo().zza("No unique parameters in main event. eventName", zzg);
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzfVar;
            this.zzd.h_();
            long longValue = ((Long) zzpj.zza(zzfVar, "_epc", (Object) 0L)).longValue();
            this.zzc = longValue;
            if (longValue <= 0) {
                this.zzd.zzj().zzo().zza("Complex event with zero extra param count. eventName", zzg);
            } else {
                this.zzd.zzh().zza(str, (Long) Preconditions.checkNotNull(l), this.zzc, zzfVar);
            }
        }
        return (zzgf.zzf) ((com.google.android.gms.internal.measurement.zzkg) zzfVar.zzch().zza(zzg).zzd().zza(zzh).zzaj());
    }

    private zzy(zzx zzxVar) {
        this.zzd = zzxVar;
    }
}
