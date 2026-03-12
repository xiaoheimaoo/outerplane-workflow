package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.measurement.internal.zzjj;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import org.checkerframework.dataflow.qual.Pure;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzhm extends zzot implements zzak {
    final LruCache<String, com.google.android.gms.internal.measurement.zzb> zza;
    private final Map<String, Map<String, String>> zzb;
    private final Map<String, Set<String>> zzc;
    private final Map<String, Map<String, Boolean>> zzd;
    private final Map<String, Map<String, Boolean>> zze;
    private final Map<String, zzgc.zzd> zzf;
    private final Map<String, Map<String, Integer>> zzh;
    private final com.google.android.gms.internal.measurement.zzv zzi;
    private final Map<String, String> zzj;
    private final Map<String, String> zzk;
    private final Map<String, String> zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(String str, String str2) {
        Integer num;
        zzv();
        zzu(str);
        Map<String, Integer> map = this.zzh.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0L;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e) {
            zzj().zzr().zza("Unable to parse timezone offset. appId", zzgo.zza(str), e);
            return 0L;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.android.gms.internal.measurement.zzb zza(zzhm zzhmVar, String str) {
        zzhmVar.zzam();
        Preconditions.checkNotEmpty(str);
        if (zzhmVar.zzk(str)) {
            if (zzhmVar.zzf.containsKey(str) && zzhmVar.zzf.get(str) != null) {
                zzhmVar.zza(str, zzhmVar.zzf.get(str));
            } else {
                zzhmVar.zzu(str);
            }
            return zzhmVar.zza.snapshot().get(str);
        }
        return null;
    }

    public static /* synthetic */ com.google.android.gms.internal.measurement.zzal zza(zzhm zzhmVar) {
        return new com.google.android.gms.internal.measurement.zzr(zzhmVar.zzi);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzx zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzar zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzgl zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzhm zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjm zza(String str, zzjj.zza zzaVar) {
        zzv();
        zzu(str);
        zzgc.zza zzb = zzb(str);
        if (zzb == null) {
            return zzjm.UNINITIALIZED;
        }
        for (zzgc.zza.zzb zzbVar : zzb.zzf()) {
            if (zza(zzbVar.zzc()) == zzaVar) {
                int i = zzht.zzc[zzbVar.zzb().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        return zzjm.GRANTED;
                    }
                    return zzjm.UNINITIALIZED;
                }
                return zzjm.DENIED;
            }
        }
        return zzjm.UNINITIALIZED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjj.zza zzb(String str, zzjj.zza zzaVar) {
        zzv();
        zzu(str);
        zzgc.zza zzb = zzb(str);
        if (zzb == null) {
            return null;
        }
        for (zzgc.zza.zzc zzcVar : zzb.zze()) {
            if (zzaVar == zza(zzcVar.zzc())) {
                return zza(zzcVar.zzb());
            }
        }
        return null;
    }

    private static zzjj.zza zza(zzgc.zza.zze zzeVar) {
        int i = zzht.zzb[zzeVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return zzjj.zza.AD_PERSONALIZATION;
                }
                return zzjj.zza.AD_USER_DATA;
            }
            return zzjj.zza.ANALYTICS_STORAGE;
        }
        return zzjj.zza.AD_STORAGE;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zznp zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzos zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzpj h_() {
        return super.h_();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgc.zza zzb(String str) {
        zzv();
        zzu(str);
        zzgc.zzd zzc = zzc(str);
        if (zzc == null || !zzc.zzo()) {
            return null;
        }
        return zzc.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzgc.zzd zzc(String str) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        zzu(str);
        return this.zzf.get(str);
    }

    private final zzgc.zzd zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzgc.zzd.zzg();
        }
        try {
            zzgc.zzd zzdVar = (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) ((zzgc.zzd.zza) zzpj.zza(zzgc.zzd.zze(), bArr)).zzaj());
            zzj().zzq().zza("Parsed config. version, gmp_app_id", zzdVar.zzr() ? Long.valueOf(zzdVar.zzc()) : null, zzdVar.zzp() ? zzdVar.zzi() : null);
            return zzdVar;
        } catch (com.google.android.gms.internal.measurement.zzkp e) {
            zzj().zzr().zza("Unable to merge remote config. appId", zzgo.zza(str), e);
            return zzgc.zzd.zzg();
        } catch (RuntimeException e2) {
            zzj().zzr().zza("Unable to merge remote config. appId", zzgo.zza(str), e2);
            return zzgc.zzd.zzg();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzak
    public final String zza(String str, String str2) {
        zzv();
        zzu(str);
        Map<String, String> map = this.zzb.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzd(String str) {
        zzv();
        return this.zzl.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zze(String str) {
        zzv();
        return this.zzk.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzf(String str) {
        zzv();
        zzu(str);
        return this.zzj.get(str);
    }

    private static Map<String, String> zza(zzgc.zzd zzdVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzdVar != null) {
            for (zzgc.zzh zzhVar : zzdVar.zzn()) {
                arrayMap.put(zzhVar.zzb(), zzhVar.zzc());
            }
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<String> zzg(String str) {
        zzv();
        zzu(str);
        return this.zzc.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SortedSet<String> zzh(String str) {
        zzv();
        zzu(str);
        TreeSet treeSet = new TreeSet();
        zzgc.zza zzb = zzb(str);
        if (zzb == null) {
            return treeSet;
        }
        for (zzgc.zza.zzf zzfVar : zzb.zzc()) {
            treeSet.add(zzfVar.zzb());
        }
        return treeSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhm(zzou zzouVar) {
        super(zzouVar);
        this.zzb = new ArrayMap();
        this.zzc = new ArrayMap();
        this.zzd = new ArrayMap();
        this.zze = new ArrayMap();
        this.zzf = new ArrayMap();
        this.zzj = new ArrayMap();
        this.zzk = new ArrayMap();
        this.zzl = new ArrayMap();
        this.zzh = new ArrayMap();
        this.zza = new zzhs(this, 20);
        this.zzi = new zzhr(this);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzi(String str) {
        zzv();
        this.zzk.put(str, null);
    }

    private final void zza(String str, zzgc.zzd.zza zzaVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzaVar != null) {
            for (zzgc.zzb zzbVar : zzaVar.zze()) {
                hashSet.add(zzbVar.zzb());
            }
            for (int i = 0; i < zzaVar.zza(); i++) {
                zzgc.zzc.zza zzch = zzaVar.zza(i).zzch();
                if (zzch.zzb().isEmpty()) {
                    zzj().zzr().zza("EventConfig contained null event name");
                } else {
                    String zzb = zzch.zzb();
                    String zzb2 = zzjp.zzb(zzch.zzb());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zzch = zzch.zza(zzb2);
                        zzaVar.zza(i, zzch);
                    }
                    if (zzch.zze() && zzch.zzc()) {
                        arrayMap.put(zzb, true);
                    }
                    if (zzch.zzf() && zzch.zzd()) {
                        arrayMap2.put(zzch.zzb(), true);
                    }
                    if (zzch.zzg()) {
                        if (zzch.zza() < 2 || zzch.zza() > 65535) {
                            zzj().zzr().zza("Invalid sampling rate. Event name, sample rate", zzch.zzb(), Integer.valueOf(zzch.zza()));
                        } else {
                            arrayMap3.put(zzch.zzb(), Integer.valueOf(zzch.zza()));
                        }
                    }
                }
            }
        }
        this.zzc.put(str, hashSet);
        this.zzd.put(str, arrayMap);
        this.zze.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    private final void zzu(String str) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        if (this.zzf.get(str) == null) {
            zzat zze = zzh().zze(str);
            if (zze == null) {
                this.zzb.put(str, null);
                this.zzd.put(str, null);
                this.zzc.put(str, null);
                this.zze.put(str, null);
                this.zzf.put(str, null);
                this.zzj.put(str, null);
                this.zzk.put(str, null);
                this.zzl.put(str, null);
                this.zzh.put(str, null);
                return;
            }
            zzgc.zzd.zza zzch = zza(str, zze.zza).zzch();
            zza(str, zzch);
            this.zzb.put(str, zza((zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj())));
            this.zzf.put(str, (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj()));
            zza(str, (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj()));
            this.zzj.put(str, zzch.zzc());
            this.zzk.put(str, zze.zzb);
            this.zzl.put(str, zze.zzc);
        }
    }

    private final void zza(final String str, zzgc.zzd zzdVar) {
        if (zzdVar.zza() == 0) {
            this.zza.remove(str);
            return;
        }
        zzj().zzq().zza("EES programs found", Integer.valueOf(zzdVar.zza()));
        zzgr.zzc zzcVar = zzdVar.zzm().get(0);
        try {
            com.google.android.gms.internal.measurement.zzb zzbVar = new com.google.android.gms.internal.measurement.zzb();
            zzbVar.zza("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzho
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzm("internal.remoteConfig", new zzhu(zzhm.this, str));
                }
            });
            zzbVar.zza("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhn
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final zzhm zzhmVar = zzhm.this;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzx("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhp
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            zzhm zzhmVar2 = zzhm.this;
                            String str3 = str2;
                            zzh zzd = zzhmVar2.zzh().zzd(str3);
                            HashMap hashMap = new HashMap();
                            hashMap.put("platform", "android");
                            hashMap.put("package_name", str3);
                            hashMap.put("gmp_version", 114010L);
                            if (zzd != null) {
                                String zzaf = zzd.zzaf();
                                if (zzaf != null) {
                                    hashMap.put("app_version", zzaf);
                                }
                                hashMap.put("app_version_int", Long.valueOf(zzd.zze()));
                                hashMap.put("dynamite_version", Long.valueOf(zzd.zzo()));
                            }
                            return hashMap;
                        }
                    });
                }
            });
            zzbVar.zza("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhq
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzhm.zza(zzhm.this);
                }
            });
            zzbVar.zza(zzcVar);
            this.zza.put(str, zzbVar);
            zzj().zzq().zza("EES program loaded for appId, activities", str, Integer.valueOf(zzcVar.zza().zza()));
            for (zzgr.zzb zzbVar2 : zzcVar.zza().zzd()) {
                zzj().zzq().zza("EES program activity", zzbVar2.zzb());
            }
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            zzj().zzg().zza("Failed to load EES program. appId", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(String str) {
        zzv();
        this.zzf.remove(str);
    }

    public final boolean zzk(String str) {
        zzgc.zzd zzdVar;
        return (TextUtils.isEmpty(str) || (zzdVar = this.zzf.get(str)) == null || zzdVar.zza() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzl(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(String str, zzjj.zza zzaVar) {
        zzv();
        zzu(str);
        zzgc.zza zzb = zzb(str);
        if (zzb == null) {
            return false;
        }
        Iterator<zzgc.zza.zzb> it = zzb.zzd().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzgc.zza.zzb next = it.next();
            if (zzaVar == zza(next.zzc())) {
                if (next.zzb() == zzgc.zza.zzd.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzm(String str) {
        zzv();
        zzu(str);
        zzgc.zza zzb = zzb(str);
        return zzb == null || !zzb.zzh() || zzb.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(String str, String str2) {
        Boolean bool;
        zzv();
        zzu(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(String str, String str2) {
        Boolean bool;
        zzv();
        zzu(str);
        if (zzl(str) && zzpn.zzf(str2)) {
            return true;
        }
        if (zzn(str) && zzpn.zzg(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzd.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzn(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zza(String str, byte[] bArr, String str2, String str3) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        zzgc.zzd.zza zzch = zza(str, bArr).zzch();
        if (zzch == null) {
            return false;
        }
        zza(str, zzch);
        zza(str, (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj()));
        this.zzf.put(str, (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj()));
        this.zzj.put(str, zzch.zzc());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzb.put(str, zza((zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj())));
        zzh().zza(str, new ArrayList(zzch.zzd()));
        try {
            zzch.zzb();
            bArr = ((zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj())).zzce();
        } catch (RuntimeException e) {
            zzj().zzr().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzgo.zza(str), e);
        }
        zzar zzh = zzh();
        Preconditions.checkNotEmpty(str);
        zzh.zzv();
        zzh.zzam();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (zzh.f_().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzh.zzj().zzg().zza("Failed to update remote config (got 0). appId", zzgo.zza(str));
            }
        } catch (SQLiteException e2) {
            zzh.zzj().zzg().zza("Error storing remote config. appId", zzgo.zza(str), e2);
        }
        this.zzf.put(str, (zzgc.zzd) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzo(String str) {
        zzv();
        zzu(str);
        return this.zzc.get(str) != null && this.zzc.get(str).contains("app_instance_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzp(String str) {
        zzv();
        zzu(str);
        if (this.zzc.get(str) != null) {
            return this.zzc.get(str).contains("device_model") || this.zzc.get(str).contains("device_info");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzq(String str) {
        zzv();
        zzu(str);
        return this.zzc.get(str) != null && this.zzc.get(str).contains("enhanced_user_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzr(String str) {
        zzv();
        zzu(str);
        return this.zzc.get(str) != null && this.zzc.get(str).contains("google_signals");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzs(String str) {
        zzv();
        zzu(str);
        if (this.zzc.get(str) != null) {
            return this.zzc.get(str).contains("os_version") || this.zzc.get(str).contains("device_info");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzt(String str) {
        zzv();
        zzu(str);
        return this.zzc.get(str) != null && this.zzc.get(str).contains("user_id");
    }
}
