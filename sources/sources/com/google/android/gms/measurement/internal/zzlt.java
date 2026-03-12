package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgf;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzlt extends zzot {
    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    public zzlt(zzou zzouVar) {
        super(zzouVar);
    }

    public final byte[] zza(zzbl zzblVar, String str) {
        zzpo zzpoVar;
        zzgf.zzk.zza zzaVar;
        Bundle bundle;
        zzh zzhVar;
        zzgf.zzj.zzb zzbVar;
        byte[] bArr;
        long j;
        zzbh zza;
        zzv();
        this.zzu.zzaa();
        Preconditions.checkNotNull(zzblVar);
        Preconditions.checkNotEmpty(str);
        if (!"_iap".equals(zzblVar.zza) && !"_iapx".equals(zzblVar.zza)) {
            zzj().zzc().zza("Generating a payload for this event is not available. package_name, event_name", str, zzblVar.zza);
            return null;
        }
        zzgf.zzj.zzb zzb = zzgf.zzj.zzb();
        zzh().zzq();
        try {
            zzh zzd = zzh().zzd(str);
            if (zzd == null) {
                zzj().zzc().zza("Log and bundle not available. package_name", str);
                return new byte[0];
            } else if (!zzd.zzar()) {
                zzj().zzc().zza("Log and bundle disabled. package_name", str);
                return new byte[0];
            } else {
                zzgf.zzk.zza zzp = zzgf.zzk.zzx().zzh(1).zzp("android");
                if (!TextUtils.isEmpty(zzd.zzac())) {
                    zzp.zzb(zzd.zzac());
                }
                if (!TextUtils.isEmpty(zzd.zzae())) {
                    zzp.zzd((String) Preconditions.checkNotNull(zzd.zzae()));
                }
                if (!TextUtils.isEmpty(zzd.zzaf())) {
                    zzp.zze((String) Preconditions.checkNotNull(zzd.zzaf()));
                }
                if (zzd.zze() != -2147483648L) {
                    zzp.zze((int) zzd.zze());
                }
                zzp.zzg(zzd.zzq()).zze(zzd.zzo());
                String zzah = zzd.zzah();
                String zzaa = zzd.zzaa();
                if (!TextUtils.isEmpty(zzah)) {
                    zzp.zzm(zzah);
                } else if (!TextUtils.isEmpty(zzaa)) {
                    zzp.zza(zzaa);
                }
                zzp.zzk(zzd.zzw());
                zzjj zzb2 = this.zzg.zzb(str);
                zzp.zzd(zzd.zzn());
                if (this.zzu.zzae() && zze().zzj(zzp.zzu()) && zzb2.zzg() && !TextUtils.isEmpty(null)) {
                    zzp.zzj((String) null);
                }
                zzp.zzg(zzb2.zze());
                if (zzb2.zzg() && zzd.zzaq()) {
                    Pair<String, Boolean> zza2 = zzo().zza(zzd.zzac(), zzb2);
                    if (zzd.zzaq() && zza2 != null && !TextUtils.isEmpty((CharSequence) zza2.first)) {
                        zzp.zzq(zza((String) zza2.first, Long.toString(zzblVar.zzd)));
                        if (zza2.second != null) {
                            zzp.zzc(((Boolean) zza2.second).booleanValue());
                        }
                    }
                }
                zzf().zzad();
                zzgf.zzk.zza zzi = zzp.zzi(Build.MODEL);
                zzf().zzad();
                zzi.zzo(Build.VERSION.RELEASE).zzj((int) zzf().zzc()).zzs(zzf().zzg());
                if (zzb2.zzh() && zzd.zzad() != null) {
                    zzp.zzc(zza((String) Preconditions.checkNotNull(zzd.zzad()), Long.toString(zzblVar.zzd)));
                }
                if (!TextUtils.isEmpty(zzd.zzag())) {
                    zzp.zzl((String) Preconditions.checkNotNull(zzd.zzag()));
                }
                String zzac = zzd.zzac();
                List<zzpo> zzk = zzh().zzk(zzac);
                Iterator<zzpo> it = zzk.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        zzpoVar = null;
                        break;
                    }
                    zzpoVar = it.next();
                    if ("_lte".equals(zzpoVar.zzc)) {
                        break;
                    }
                }
                if (zzpoVar == null || zzpoVar.zze == null) {
                    zzpo zzpoVar2 = new zzpo(zzac, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzb().currentTimeMillis(), 0L);
                    zzk.add(zzpoVar2);
                    zzh().zza(zzpoVar2);
                }
                zzgf.zzp[] zzpVarArr = new zzgf.zzp[zzk.size()];
                for (int i = 0; i < zzk.size(); i++) {
                    zzgf.zzp.zza zzb3 = zzgf.zzp.zze().zza(zzk.get(i).zzc).zzb(zzk.get(i).zzd);
                    h_().zza(zzb3, zzk.get(i).zze);
                    zzpVarArr[i] = (zzgf.zzp) ((com.google.android.gms.internal.measurement.zzkg) zzb3.zzaj());
                }
                zzp.zze(Arrays.asList(zzpVarArr));
                this.zzg.zza(zzd, zzp);
                this.zzg.zzb(zzd, zzp);
                zzgs zza3 = zzgs.zza(zzblVar);
                zzs().zza(zza3.zzc, zzh().zzc(str));
                zzs().zza(zza3, zze().zzb(str));
                Bundle bundle2 = zza3.zzc;
                bundle2.putLong("_c", 1L);
                zzj().zzc().zza("Marking in-app purchase as real-time");
                bundle2.putLong("_r", 1L);
                bundle2.putString("_o", zzblVar.zzc);
                if (zzs().zzd(zzp.zzu(), zzd.zzam())) {
                    zzs().zza(bundle2, "_dbg", (Object) 1L);
                    zzs().zza(bundle2, "_r", (Object) 1L);
                }
                zzbh zzd2 = zzh().zzd(str, zzblVar.zza);
                if (zzd2 == null) {
                    zzaVar = zzp;
                    bundle = bundle2;
                    zzhVar = zzd;
                    zzbVar = zzb;
                    bArr = null;
                    zza = new zzbh(str, zzblVar.zza, 0L, 0L, zzblVar.zzd, 0L, null, null, null, null);
                    j = 0;
                } else {
                    zzaVar = zzp;
                    bundle = bundle2;
                    zzhVar = zzd;
                    zzbVar = zzb;
                    bArr = null;
                    j = zzd2.zzf;
                    zza = zzd2.zza(zzblVar.zzd);
                }
                zzh().zza(zza);
                zzbe zzbeVar = new zzbe(this.zzu, zzblVar.zzc, str, zzblVar.zza, zzblVar.zzd, j, bundle);
                zzgf.zzf.zza zza4 = zzgf.zzf.zze().zzb(zzbeVar.zzd).zza(zzbeVar.zzb).zza(zzbeVar.zze);
                Iterator<String> it2 = zzbeVar.zzf.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    zzgf.zzh.zza zza5 = zzgf.zzh.zze().zza(next);
                    Object zzc = zzbeVar.zzf.zzc(next);
                    if (zzc != null) {
                        h_().zza(zza5, zzc);
                        zza4.zza(zza5);
                    }
                }
                zzgf.zzk.zza zzaVar2 = zzaVar;
                zzaVar2.zza(zza4).zza(zzgf.zzl.zza().zza(zzgf.zzg.zza().zza(zza.zzc).zza(zzblVar.zza)));
                zzaVar2.zza(zzg().zza(zzhVar.zzac(), Collections.emptyList(), zzaVar2.zzac(), Long.valueOf(zza4.zzc()), Long.valueOf(zza4.zzc()), false));
                if (zza4.zzg()) {
                    zzaVar2.zzj(zza4.zzc()).zzf(zza4.zzc());
                }
                long zzs = zzhVar.zzs();
                int i2 = (zzs > 0L ? 1 : (zzs == 0L ? 0 : -1));
                if (i2 != 0) {
                    zzaVar2.zzh(zzs);
                }
                long zzu = zzhVar.zzu();
                if (zzu != 0) {
                    zzaVar2.zzi(zzu);
                } else if (i2 != 0) {
                    zzaVar2.zzi(zzs);
                }
                String zzal = zzhVar.zzal();
                if (com.google.android.gms.internal.measurement.zzpf.zza() && zze().zze(str, zzbn.zzcg) && zzal != null) {
                    zzaVar2.zzr(zzal);
                }
                zzhVar.zzap();
                zzaVar2.zzf((int) zzhVar.zzt()).zzm(114010L).zzl(zzb().currentTimeMillis()).zzd(Boolean.TRUE.booleanValue());
                this.zzg.zza(zzaVar2.zzu(), zzaVar2);
                zzgf.zzj.zzb zzbVar2 = zzbVar;
                zzbVar2.zza(zzaVar2);
                zzh zzhVar2 = zzhVar;
                zzhVar2.zzr(zzaVar2.zzf());
                zzhVar2.zzp(zzaVar2.zze());
                zzh().zza(zzhVar2, false, false);
                zzh().zzx();
                try {
                    return h_().zzb(((zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzbVar2.zzaj())).zzce());
                } catch (IOException e) {
                    zzj().zzg().zza("Data loss. Failed to bundle and serialize. appId", zzgo.zza(str), e);
                    return bArr;
                }
            }
        } catch (SecurityException e2) {
            zzj().zzc().zza("Resettable device id encryption failed", e2.getMessage());
            return new byte[0];
        } catch (SecurityException e3) {
            zzj().zzc().zza("app instance id encryption failed", e3.getMessage());
            return new byte[0];
        } finally {
            zzh().zzr();
        }
    }
}
