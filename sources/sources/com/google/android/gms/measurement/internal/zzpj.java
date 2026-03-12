package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;
import com.helpshift.HelpshiftEvent;
import com.singular.sdk.internal.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.checkerframework.dataflow.qual.Pure;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzpj extends zzot {
    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzgf.zzk.zza zzaVar, String str) {
        if (zzaVar == null) {
            return -1;
        }
        for (int i = 0; i < zzaVar.zzd(); i++) {
            if (str.equals(zzaVar.zzk(i).zzg())) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return zza(str.getBytes(Charset.forName(Constants.ENCODING)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzs().zzv();
        MessageDigest zzr = zzpn.zzr();
        if (zzr == null) {
            zzj().zzg().zza("Failed to get MD5");
            return 0L;
        }
        return zzpn.zza(zzr.digest(bArr));
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle zza(List<zzgf.zzh> list) {
        Bundle bundle = new Bundle();
        for (zzgf.zzh zzhVar : list) {
            String zzg = zzhVar.zzg();
            if (zzhVar.zzj()) {
                bundle.putDouble(zzg, zzhVar.zza());
            } else if (zzhVar.zzk()) {
                bundle.putFloat(zzg, zzhVar.zzb());
            } else if (zzhVar.zzn()) {
                bundle.putString(zzg, zzhVar.zzh());
            } else if (zzhVar.zzl()) {
                bundle.putLong(zzg, zzhVar.zzd());
            }
        }
        return bundle;
    }

    private final Bundle zza(Map<String, Object> map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    arrayList2.add(zza((Map) obj2, false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T extends Parcelable> T zza(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException unused) {
            zzj().zzg().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbl zza(com.google.android.gms.internal.measurement.zzad zzadVar) {
        Object obj;
        Bundle zza = zza(zzadVar.zzc(), true);
        String obj2 = (!zza.containsKey("_o") || (obj = zza.get("_o")) == null) ? "app" : obj.toString();
        String zzb = zzjp.zzb(zzadVar.zzb());
        if (zzb == null) {
            zzb = zzadVar.zzb();
        }
        return new zzbl(zzb, new zzbg(zza), obj2, zzadVar.zza());
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

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zznp zzo() {
        return super.zzo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzog zza(String str, zzgf.zzk.zza zzaVar, zzgf.zzf.zza zzaVar2, String str2) {
        int indexOf;
        if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zze(str, zzbn.zzcp)) {
            long currentTimeMillis = zzb().currentTimeMillis();
            String[] split = zze().zzd(str, zzbn.zzbo).split(",");
            HashSet hashSet = new HashSet(split.length);
            for (String str3 : split) {
                if (!hashSet.add(Objects.requireNonNull(str3))) {
                    throw new IllegalArgumentException("duplicate element: " + ((Object) str3));
                }
            }
            Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
            zzos zzp = zzp();
            String zzf = zzp.zzm().zzf(str);
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(zzp.zze().zzd(str, zzbn.zzbh));
            if (!TextUtils.isEmpty(zzf)) {
                builder.authority(zzf + "." + zzp.zze().zzd(str, zzbn.zzbi));
            } else {
                builder.authority(zzp.zze().zzd(str, zzbn.zzbi));
            }
            builder.path(zzp.zze().zzd(str, zzbn.zzbj));
            zza(builder, "gmp_app_id", zzaVar.zzy(), unmodifiableSet);
            zza(builder, "gmp_version", "114010", unmodifiableSet);
            String zzv = zzaVar.zzv();
            if (zze().zze(str, zzbn.zzcs) && zzm().zzo(str)) {
                zzv = "";
            }
            zza(builder, "app_instance_id", zzv, unmodifiableSet);
            zza(builder, "rdid", zzaVar.zzaa(), unmodifiableSet);
            zza(builder, "bundle_id", zzaVar.zzu(), unmodifiableSet);
            String zze = zzaVar2.zze();
            String zza = zzjp.zza(zze);
            if (!TextUtils.isEmpty(zza)) {
                zze = zza;
            }
            zza(builder, "app_event_name", zze, unmodifiableSet);
            zza(builder, "app_version", String.valueOf(zzaVar.zzb()), unmodifiableSet);
            String zzz = zzaVar.zzz();
            if (zze().zze(str, zzbn.zzcs) && zzm().zzs(str) && !TextUtils.isEmpty(zzz) && (indexOf = zzz.indexOf(".")) != -1) {
                zzz = zzz.substring(0, indexOf);
            }
            zza(builder, "os_version", zzz, unmodifiableSet);
            zza(builder, "timestamp", String.valueOf(zzaVar2.zzc()), unmodifiableSet);
            if (zzaVar.zzae()) {
                zza(builder, "lat", "1", unmodifiableSet);
            }
            zza(builder, "privacy_sandbox_version", String.valueOf(zzaVar.zza()), unmodifiableSet);
            zza(builder, "trigger_uri_source", "1", unmodifiableSet);
            zza(builder, "trigger_uri_timestamp", String.valueOf(currentTimeMillis), unmodifiableSet);
            zza(builder, "request_uuid", str2, unmodifiableSet);
            List<zzgf.zzh> zzf2 = zzaVar2.zzf();
            Bundle bundle = new Bundle();
            for (zzgf.zzh zzhVar : zzf2) {
                String zzg = zzhVar.zzg();
                if (zzhVar.zzj()) {
                    bundle.putString(zzg, String.valueOf(zzhVar.zza()));
                } else if (zzhVar.zzk()) {
                    bundle.putString(zzg, String.valueOf(zzhVar.zzb()));
                } else if (zzhVar.zzn()) {
                    bundle.putString(zzg, zzhVar.zzh());
                } else if (zzhVar.zzl()) {
                    bundle.putString(zzg, String.valueOf(zzhVar.zzd()));
                }
            }
            zza(builder, zze().zzd(str, zzbn.zzbn).split("\\|"), bundle, unmodifiableSet);
            List<zzgf.zzp> zzac = zzaVar.zzac();
            Bundle bundle2 = new Bundle();
            for (zzgf.zzp zzpVar : zzac) {
                String zzg2 = zzpVar.zzg();
                if (zzpVar.zzi()) {
                    bundle2.putString(zzg2, String.valueOf(zzpVar.zza()));
                } else if (zzpVar.zzj()) {
                    bundle2.putString(zzg2, String.valueOf(zzpVar.zzb()));
                } else if (zzpVar.zzm()) {
                    bundle2.putString(zzg2, zzpVar.zzh());
                } else if (zzpVar.zzk()) {
                    bundle2.putString(zzg2, String.valueOf(zzpVar.zzc()));
                }
            }
            zza(builder, zze().zzd(str, zzbn.zzbm).split("\\|"), bundle2, unmodifiableSet);
            zza(builder, "dma", zzaVar.zzad() ? "1" : "0", unmodifiableSet);
            if (!zzaVar.zzx().isEmpty()) {
                zza(builder, "dma_cps", zzaVar.zzx(), unmodifiableSet);
            }
            if (zze().zza(zzbn.zzcu) && zzaVar.zzaf()) {
                zzgf.zza zzg3 = zzaVar.zzg();
                if (!zzg3.zzh().isEmpty()) {
                    zza(builder, "dl_gclid", zzg3.zzh(), unmodifiableSet);
                }
                if (!zzg3.zzg().isEmpty()) {
                    zza(builder, "dl_gbraid", zzg3.zzg(), unmodifiableSet);
                }
                if (!zzg3.zzf().isEmpty()) {
                    zza(builder, "dl_gs", zzg3.zzf(), unmodifiableSet);
                }
                if (zzg3.zza() > 0) {
                    zza(builder, "dl_ss_ts", String.valueOf(zzg3.zza()), unmodifiableSet);
                }
                if (!zzg3.zzk().isEmpty()) {
                    zza(builder, "mr_gclid", zzg3.zzk(), unmodifiableSet);
                }
                if (!zzg3.zzj().isEmpty()) {
                    zza(builder, "mr_gbraid", zzg3.zzj(), unmodifiableSet);
                }
                if (!zzg3.zzi().isEmpty()) {
                    zza(builder, "mr_gs", zzg3.zzi(), unmodifiableSet);
                }
                if (zzg3.zzb() > 0) {
                    zza(builder, "mr_click_ts", String.valueOf(zzg3.zzb()), unmodifiableSet);
                }
            }
            return new zzog(builder.build().toString(), currentTimeMillis, 1);
        }
        return null;
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
    public final zzgf.zzf zza(zzbe zzbeVar) {
        zzgf.zzf.zza zza = zzgf.zzf.zze().zza(zzbeVar.zze);
        Iterator<String> it = zzbeVar.zzf.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzgf.zzh.zza zza2 = zzgf.zzh.zze().zza(next);
            Object zzc = zzbeVar.zzf.zzc(next);
            Preconditions.checkNotNull(zzc);
            zza(zza2, zzc);
            zza.zza(zza2);
        }
        if (!TextUtils.isEmpty(zzbeVar.zzc) && zzbeVar.zzf.zzc("_o") == null) {
            zza.zza((zzgf.zzh) ((com.google.android.gms.internal.measurement.zzkg) zzgf.zzh.zze().zza("_o").zzb(zzbeVar.zzc).zzaj()));
        }
        return (zzgf.zzf) ((com.google.android.gms.internal.measurement.zzkg) zza.zzaj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgf.zzh zza(zzgf.zzf zzfVar, String str) {
        for (zzgf.zzh zzhVar : zzfVar.zzh()) {
            if (zzhVar.zzg().equals(str)) {
                return zzhVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <BuilderT extends com.google.android.gms.internal.measurement.zzlp> BuilderT zza(BuilderT buildert, byte[] bArr) throws com.google.android.gms.internal.measurement.zzkp {
        com.google.android.gms.internal.measurement.zzjt zza = com.google.android.gms.internal.measurement.zzjt.zza();
        if (zza != null) {
            return (BuilderT) buildert.zza(bArr, zza);
        }
        return (BuilderT) buildert.zza(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzb(zzgf.zzf zzfVar, String str) {
        zzgf.zzh zza = zza(zzfVar, str);
        if (zza != null) {
            if (zza.zzn()) {
                return zza.zzh();
            }
            if (zza.zzl()) {
                return Long.valueOf(zza.zzd());
            }
            if (zza.zzj()) {
                return Double.valueOf(zza.zza());
            }
            if (zza.zzc() > 0) {
                return zzb(zza.zzi());
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(zzgf.zzf zzfVar, String str, Object obj) {
        Object zzb = zzb(zzfVar, str);
        return zzb == null ? obj : zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zza(zzgf.zzj zzjVar) {
        zzgf.zzc zzw;
        if (zzjVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzjVar.zzh()) {
            zza(sb, 0, "upload_subdomain", zzjVar.zze());
        }
        if (zzjVar.zzg()) {
            zza(sb, 0, "sgtm_join_id", zzjVar.zzd());
        }
        for (zzgf.zzk zzkVar : zzjVar.zzf()) {
            if (zzkVar != null) {
                zza(sb, 1);
                sb.append("bundle {\n");
                if (zzkVar.zzbs()) {
                    zza(sb, 1, "protocol_version", Integer.valueOf(zzkVar.zzf()));
                }
                if (com.google.android.gms.internal.measurement.zzpf.zza() && zze().zze(zzkVar.zzab(), zzbn.zzcg) && zzkVar.zzbv()) {
                    zza(sb, 1, "session_stitching_token", zzkVar.zzaq());
                }
                zza(sb, 1, "platform", zzkVar.zzao());
                if (zzkVar.zzbn()) {
                    zza(sb, 1, "gmp_version", Long.valueOf(zzkVar.zzo()));
                }
                if (zzkVar.zzcb()) {
                    zza(sb, 1, "uploading_gmp_version", Long.valueOf(zzkVar.zzu()));
                }
                if (zzkVar.zzbl()) {
                    zza(sb, 1, "dynamite_version", Long.valueOf(zzkVar.zzm()));
                }
                if (zzkVar.zzbe()) {
                    zza(sb, 1, "config_version", Long.valueOf(zzkVar.zzk()));
                }
                zza(sb, 1, "gmp_app_id", zzkVar.i_());
                zza(sb, 1, "admob_app_id", zzkVar.zzaa());
                zza(sb, 1, "app_id", zzkVar.zzab());
                zza(sb, 1, "app_version", zzkVar.zzae());
                if (zzkVar.zzba()) {
                    zza(sb, 1, "app_version_major", Integer.valueOf(zzkVar.zzb()));
                }
                zza(sb, 1, "firebase_instance_id", zzkVar.zzak());
                if (zzkVar.zzbj()) {
                    zza(sb, 1, "dev_cert_hash", Long.valueOf(zzkVar.zzl()));
                }
                zza(sb, 1, "app_store", zzkVar.zzad());
                if (zzkVar.zzca()) {
                    zza(sb, 1, "upload_timestamp_millis", Long.valueOf(zzkVar.zzt()));
                }
                if (zzkVar.zzbx()) {
                    zza(sb, 1, "start_timestamp_millis", Long.valueOf(zzkVar.zzr()));
                }
                if (zzkVar.zzbm()) {
                    zza(sb, 1, "end_timestamp_millis", Long.valueOf(zzkVar.zzn()));
                }
                if (zzkVar.zzbr()) {
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzkVar.zzq()));
                }
                if (zzkVar.zzbq()) {
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzkVar.zzp()));
                }
                zza(sb, 1, "app_instance_id", zzkVar.zzac());
                zza(sb, 1, "resettable_device_id", zzkVar.zzap());
                zza(sb, 1, "ds_id", zzkVar.zzaj());
                if (zzkVar.zzbp()) {
                    zza(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzkVar.zzax()));
                }
                zza(sb, 1, "os_version", zzkVar.zzan());
                zza(sb, 1, "device_model", zzkVar.zzai());
                zza(sb, 1, "user_default_language", zzkVar.zzar());
                if (zzkVar.zzbz()) {
                    zza(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzkVar.zzh()));
                }
                if (zzkVar.zzbd()) {
                    zza(sb, 1, "bundle_sequential_index", Integer.valueOf(zzkVar.zzc()));
                }
                if (zzkVar.zzbi()) {
                    zza(sb, 1, "delivery_index", Integer.valueOf(zzkVar.zzd()));
                }
                if (zzkVar.zzbu()) {
                    zza(sb, 1, "service_upload", Boolean.valueOf(zzkVar.zzay()));
                }
                zza(sb, 1, "health_monitor", zzkVar.zzam());
                if (zzkVar.zzbt()) {
                    zza(sb, 1, "retry_counter", Integer.valueOf(zzkVar.zzg()));
                }
                if (zzkVar.zzbg()) {
                    zza(sb, 1, "consent_signals", zzkVar.zzag());
                }
                if (zzkVar.zzbo()) {
                    zza(sb, 1, "is_dma_region", Boolean.valueOf(zzkVar.zzaw()));
                }
                if (zzkVar.zzbh()) {
                    zza(sb, 1, "core_platform_services", zzkVar.zzah());
                }
                if (zzkVar.zzbf()) {
                    zza(sb, 1, "consent_diagnostics", zzkVar.zzaf());
                }
                if (zzkVar.zzby()) {
                    zza(sb, 1, "target_os_version", Long.valueOf(zzkVar.zzs()));
                }
                if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zze(zzkVar.zzab(), zzbn.zzcp)) {
                    zza(sb, 1, "ad_services_version", Integer.valueOf(zzkVar.zza()));
                    if (zzkVar.zzbb() && (zzw = zzkVar.zzw()) != null) {
                        zza(sb, 2);
                        sb.append("attribution_eligibility_status {\n");
                        zza(sb, 2, "eligible", Boolean.valueOf(zzw.zzf()));
                        zza(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzw.zzh()));
                        zza(sb, 2, "pre_r", Boolean.valueOf(zzw.zzi()));
                        zza(sb, 2, "r_extensions_too_old", Boolean.valueOf(zzw.zzj()));
                        zza(sb, 2, "adservices_extension_too_old", Boolean.valueOf(zzw.zze()));
                        zza(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(zzw.zzd()));
                        zza(sb, 2, "measurement_manager_disabled", Boolean.valueOf(zzw.zzg()));
                        zza(sb, 2);
                        sb.append("}\n");
                    }
                }
                if (zzkVar.zzaz()) {
                    zzgf.zza zzv = zzkVar.zzv();
                    zza(sb, 2);
                    sb.append("ad_campaign_info {\n");
                    if (zzv.zzn()) {
                        zza(sb, 2, "deep_link_gclid", zzv.zzh());
                    }
                    if (zzv.zzm()) {
                        zza(sb, 2, "deep_link_gbraid", zzv.zzg());
                    }
                    if (zzv.zzl()) {
                        zza(sb, 2, "deep_link_gad_source", zzv.zzf());
                    }
                    if (zzv.zzo()) {
                        zza(sb, 2, "deep_link_session_millis", Long.valueOf(zzv.zza()));
                    }
                    if (zzv.zzs()) {
                        zza(sb, 2, "market_referrer_gclid", zzv.zzk());
                    }
                    if (zzv.zzr()) {
                        zza(sb, 2, "market_referrer_gbraid", zzv.zzj());
                    }
                    if (zzv.zzq()) {
                        zza(sb, 2, "market_referrer_gad_source", zzv.zzi());
                    }
                    if (zzv.zzp()) {
                        zza(sb, 2, "market_referrer_click_millis", Long.valueOf(zzv.zzb()));
                    }
                    zza(sb, 2);
                    sb.append("}\n");
                }
                if (zzkVar.zzbc()) {
                    zza(sb, 1, "batching_timestamp_millis", Long.valueOf(zzkVar.zzj()));
                }
                if (zzkVar.zzbw()) {
                    zzgf.zzo zzz = zzkVar.zzz();
                    zza(sb, 2);
                    sb.append("sgtm_diagnostics {\n");
                    zza(sb, 2, "upload_type", zzz.zzd().name());
                    zza(sb, 2, "client_upload_eligibility", zzz.zzb().name());
                    zza(sb, 2, "service_upload_eligibility", zzz.zzc().name());
                    zza(sb, 2);
                    sb.append("}\n");
                }
                List<zzgf.zzp> zzau = zzkVar.zzau();
                if (zzau != null) {
                    for (zzgf.zzp zzpVar : zzau) {
                        if (zzpVar != null) {
                            zza(sb, 2);
                            sb.append("user_property {\n");
                            zza(sb, 2, "set_timestamp_millis", zzpVar.zzl() ? Long.valueOf(zzpVar.zzd()) : null);
                            zza(sb, 2, "name", zzi().zzc(zzpVar.zzg()));
                            zza(sb, 2, "string_value", zzpVar.zzh());
                            zza(sb, 2, "int_value", zzpVar.zzk() ? Long.valueOf(zzpVar.zzc()) : null);
                            zza(sb, 2, "double_value", zzpVar.zzi() ? Double.valueOf(zzpVar.zza()) : null);
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzgf.zzd> zzas = zzkVar.zzas();
                zzkVar.zzab();
                if (zzas != null) {
                    for (zzgf.zzd zzdVar : zzas) {
                        if (zzdVar != null) {
                            zza(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzdVar.zzg()) {
                                zza(sb, 2, "audience_id", Integer.valueOf(zzdVar.zza()));
                            }
                            if (zzdVar.zzh()) {
                                zza(sb, 2, "new_audience", Boolean.valueOf(zzdVar.zzf()));
                            }
                            zza(sb, 2, "current_data", zzdVar.zzd());
                            if (zzdVar.zzi()) {
                                zza(sb, 2, "previous_data", zzdVar.zze());
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzgf.zzf> zzat = zzkVar.zzat();
                if (zzat != null) {
                    for (zzgf.zzf zzfVar : zzat) {
                        if (zzfVar != null) {
                            zza(sb, 2);
                            sb.append("event {\n");
                            zza(sb, 2, "name", zzi().zza(zzfVar.zzg()));
                            if (zzfVar.zzk()) {
                                zza(sb, 2, "timestamp_millis", Long.valueOf(zzfVar.zzd()));
                            }
                            if (zzfVar.zzj()) {
                                zza(sb, 2, "previous_timestamp_millis", Long.valueOf(zzfVar.zzc()));
                            }
                            if (zzfVar.zzi()) {
                                zza(sb, 2, HelpshiftEvent.DATA_MESSAGE_COUNT, Integer.valueOf(zzfVar.zza()));
                            }
                            if (zzfVar.zzb() != 0) {
                                zza(sb, 2, zzfVar.zzh());
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zza(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("} // End-of-batch\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zza(zzfw.zzb zzbVar) {
        if (zzbVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzbVar.zzl()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zzbVar.zzb()));
        }
        zza(sb, 0, "event_name", zzi().zza(zzbVar.zzf()));
        String zza = zza(zzbVar.zzh(), zzbVar.zzi(), zzbVar.zzj());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", zza);
        }
        if (zzbVar.zzk()) {
            zza(sb, 1, "event_count_filter", zzbVar.zze());
        }
        if (zzbVar.zza() > 0) {
            sb.append("  filters {\n");
            for (zzfw.zzc zzcVar : zzbVar.zzg()) {
                zza(sb, 2, zzcVar);
            }
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    private static String zza(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zza(zzfw.zze zzeVar) {
        if (zzeVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzeVar.zzi()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zzeVar.zza()));
        }
        zza(sb, 0, "property_name", zzi().zzc(zzeVar.zze()));
        String zza = zza(zzeVar.zzf(), zzeVar.zzg(), zzeVar.zzh());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", zza);
        }
        zza(sb, 1, zzeVar.zzb());
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Long> zza(List<Long> list, List<Integer> list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                zzj().zzr().zza("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    zzj().zzr().zza("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Integer> zzr() {
        Map<String, String> zza = zzbn.zza(this.zzg.zza());
        if (zza == null || zza.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = zzbn.zzaz.zza(null).intValue();
        for (Map.Entry<String, String> entry : zza.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt(entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzj().zzr().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzj().zzr().zza("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 < bitSet.length()) {
                    if (bitSet.get(i3)) {
                        j |= 1 << i2;
                    }
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, Object> zza(Bundle bundle, boolean z) {
        Parcelable[] parcelableArr;
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z2 = obj instanceof Parcelable[];
            if (z2 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    if (z2) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(zza((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        int i = 0;
                        while (i < size) {
                            Object obj2 = arrayList2.get(i);
                            i++;
                            if (obj2 instanceof Bundle) {
                                arrayList.add(zza((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(zza((Bundle) obj, false));
                    }
                    hashMap.put(str, arrayList);
                }
            } else if (obj != null) {
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpj(zzou zzouVar) {
        super(zzouVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzgf.zzf.zza zzaVar, String str, Object obj) {
        List<zzgf.zzh> zzf = zzaVar.zzf();
        int i = 0;
        while (true) {
            if (i >= zzf.size()) {
                i = -1;
                break;
            } else if (str.equals(zzf.get(i).zzg())) {
                break;
            } else {
                i++;
            }
        }
        zzgf.zzh.zza zza = zzgf.zzh.zze().zza(str);
        if (obj instanceof Long) {
            zza.zza(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        }
        if (i >= 0) {
            zzaVar.zza(i, zza);
        } else {
            zzaVar.zza(zza);
        }
    }

    private static void zza(Uri.Builder builder, String[] strArr, Bundle bundle, Set<String> set) {
        for (String str : strArr) {
            String[] split = str.split(",");
            String str2 = split[0];
            String str3 = split[split.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                zza(builder, str3, string, set);
            }
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzgf.zzm zzmVar) {
        if (zzmVar == null) {
            return;
        }
        zza(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzmVar.zzb() != 0) {
            zza(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : zzmVar.zzi()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (zzmVar.zzd() != 0) {
            zza(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : zzmVar.zzk()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (zzmVar.zza() != 0) {
            zza(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (zzgf.zze zzeVar : zzmVar.zzh()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(zzeVar.zzf() ? Integer.valueOf(zzeVar.zza()) : null).append(":").append(zzeVar.zze() ? Long.valueOf(zzeVar.zzb()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (zzmVar.zzc() != 0) {
            zza(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (zzgf.zzn zznVar : zzmVar.zzj()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(zznVar.zzf() ? Integer.valueOf(zznVar.zzb()) : null).append(": [");
                int i10 = 0;
                for (Long l3 : zznVar.zze()) {
                    long longValue = l3.longValue();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i10 = i11;
                }
                sb.append("]");
                i8 = i9;
            }
            sb.append("}\n");
        }
        zza(sb, 3);
        sb.append("}\n");
    }

    private final void zza(StringBuilder sb, int i, List<zzgf.zzh> list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        for (zzgf.zzh zzhVar : list) {
            if (zzhVar != null) {
                zza(sb, i2);
                sb.append("param {\n");
                zza(sb, i2, "name", zzhVar.zzm() ? zzi().zzb(zzhVar.zzg()) : null);
                zza(sb, i2, "string_value", zzhVar.zzn() ? zzhVar.zzh() : null);
                zza(sb, i2, "int_value", zzhVar.zzl() ? Long.valueOf(zzhVar.zzd()) : null);
                zza(sb, i2, "double_value", zzhVar.zzj() ? Double.valueOf(zzhVar.zza()) : null);
                if (zzhVar.zzc() > 0) {
                    zza(sb, i2, zzhVar.zzi());
                }
                zza(sb, i2);
                sb.append("}\n");
            }
        }
    }

    private final void zza(StringBuilder sb, int i, zzfw.zzc zzcVar) {
        if (zzcVar == null) {
            return;
        }
        zza(sb, i);
        sb.append("filter {\n");
        if (zzcVar.zzg()) {
            zza(sb, i, "complement", Boolean.valueOf(zzcVar.zzf()));
        }
        if (zzcVar.zzi()) {
            zza(sb, i, "param_name", zzi().zzb(zzcVar.zze()));
        }
        if (zzcVar.zzj()) {
            int i2 = i + 1;
            zzfw.zzf zzd = zzcVar.zzd();
            if (zzd != null) {
                zza(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (zzd.zzj()) {
                    zza(sb, i2, "match_type", zzd.zzb().name());
                }
                if (zzd.zzi()) {
                    zza(sb, i2, "expression", zzd.zze());
                }
                if (zzd.zzh()) {
                    zza(sb, i2, "case_sensitive", Boolean.valueOf(zzd.zzg()));
                }
                if (zzd.zza() > 0) {
                    zza(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String str : zzd.zzf()) {
                        zza(sb, i2 + 2);
                        sb.append(str);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zza(sb, i2);
                sb.append("}\n");
            }
        }
        if (zzcVar.zzh()) {
            zza(sb, i + 1, "number_filter", zzcVar.zzc());
        }
        zza(sb, i);
        sb.append("}\n");
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzfw.zzd zzdVar) {
        if (zzdVar == null) {
            return;
        }
        zza(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (zzdVar.zzh()) {
            zza(sb, i, "comparison_type", zzdVar.zza().name());
        }
        if (zzdVar.zzj()) {
            zza(sb, i, "match_as_float", Boolean.valueOf(zzdVar.zzg()));
        }
        if (zzdVar.zzi()) {
            zza(sb, i, "comparison_value", zzdVar.zzd());
        }
        if (zzdVar.zzl()) {
            zza(sb, i, "min_comparison_value", zzdVar.zzf());
        }
        if (zzdVar.zzk()) {
            zza(sb, i, "max_comparison_value", zzdVar.zze());
        }
        zza(sb, i);
        sb.append("}\n");
    }

    private static void zza(Uri.Builder builder, String str, String str2, Set<String> set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zza(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzgf.zzh.zza zzaVar, Object obj) {
        Bundle[] bundleArr;
        Preconditions.checkNotNull(obj);
        zzaVar.zze().zzc().zzb().zzd();
        if (obj instanceof String) {
            zzaVar.zzb((String) obj);
        } else if (obj instanceof Long) {
            zzaVar.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    zzgf.zzh.zza zze = zzgf.zzh.zze();
                    for (String str : bundle.keySet()) {
                        zzgf.zzh.zza zza = zzgf.zzh.zze().zza(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            zza.zza(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zza.zzb((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zza.zza(((Double) obj2).doubleValue());
                        }
                        zze.zza(zza);
                    }
                    if (zze.zza() > 0) {
                        arrayList.add((zzgf.zzh) ((com.google.android.gms.internal.measurement.zzkg) zze.zzaj()));
                    }
                }
            }
            zzaVar.zza(arrayList);
        } else {
            zzj().zzg().zza("Ignoring invalid (type) event param value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzgf.zzp.zza zzaVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzaVar.zzc().zzb().zza();
        if (obj instanceof String) {
            zzaVar.zzb((String) obj);
        } else if (obj instanceof Long) {
            zzaVar.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
        } else {
            zzj().zzg().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(zzbl zzblVar, zzp zzpVar) {
        Preconditions.checkNotNull(zzblVar);
        Preconditions.checkNotNull(zzpVar);
        return (TextUtils.isEmpty(zzpVar.zzb) && TextUtils.isEmpty(zzpVar.zzp)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(List<Long> list, int i) {
        if (i < (list.size() << 6)) {
            return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzb().currentTimeMillis() - j) > j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzj().zzg().zza("Failed to gzip content", e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzc(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzj().zzg().zza("Failed to ungzip content", e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] zzb(List<zzgf.zzh> list) {
        ArrayList arrayList = new ArrayList();
        for (zzgf.zzh zzhVar : list) {
            if (zzhVar != null) {
                Bundle bundle = new Bundle();
                for (zzgf.zzh zzhVar2 : zzhVar.zzi()) {
                    if (zzhVar2.zzn()) {
                        bundle.putString(zzhVar2.zzg(), zzhVar2.zzh());
                    } else if (zzhVar2.zzl()) {
                        bundle.putLong(zzhVar2.zzg(), zzhVar2.zzd());
                    } else if (zzhVar2.zzj()) {
                        bundle.putDouble(zzhVar2.zzg(), zzhVar2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }
}
