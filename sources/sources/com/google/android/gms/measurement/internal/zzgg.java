package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzpq;
import com.google.android.gms.measurement.internal.zzjj;
import com.helpshift.util.Utils;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;
import org.checkerframework.dataflow.qual.Pure;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzgg extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzac() {
        zzw();
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzad() {
        zzw();
        return this.zzc;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzp zza(String str) {
        long min;
        long j;
        long j2;
        boolean z;
        String str2;
        int i;
        List<String> list;
        int i2;
        zzv();
        String zzaf = zzaf();
        String zzah = zzah();
        zzw();
        String str3 = this.zzb;
        long zzad = zzad();
        zzw();
        Preconditions.checkNotNull(this.zzd);
        String str4 = this.zzd;
        zzw();
        zzv();
        if (this.zzf == 0) {
            this.zzf = this.zzu.zzv().zza(zza(), zza().getPackageName());
        }
        long j3 = this.zzf;
        boolean zzae = this.zzu.zzae();
        boolean z2 = !zzk().zzm;
        zzv();
        String zzak = !this.zzu.zzae() ? null : zzak();
        zzic zzicVar = this.zzu;
        long zza = zzicVar.zzn().zzc.zza();
        if (zza == 0) {
            min = zzicVar.zza;
        } else {
            min = Math.min(zzicVar.zza, zza);
        }
        long j4 = min;
        int zzac = zzac();
        boolean zzw = zze().zzw();
        zzha zzk = zzk();
        zzk.zzv();
        boolean z3 = zzk.zzg().getBoolean("deferred_analytics_collection", false);
        String zzae2 = zzae();
        Boolean valueOf = Boolean.valueOf(zze().zzc("google_analytics_default_allow_ad_personalization_signals", true) != zzjm.GRANTED);
        long j5 = this.zzg;
        List<String> list2 = this.zzh;
        String zzf = zzk().zzp().zzf();
        if (this.zzi == null) {
            this.zzi = zzs().zzq();
        }
        String str5 = this.zzi;
        if (zzk().zzp().zza(zzjj.zza.ANALYTICS_STORAGE)) {
            zzv();
            j = j5;
            j2 = 0;
            if (this.zzn != 0) {
                z = zzae;
                long currentTimeMillis = zzb().currentTimeMillis() - this.zzn;
                if (this.zzm != null && currentTimeMillis > Utils.TIME_24HRS_MILLIS && this.zzo == null) {
                    zzaj();
                }
            } else {
                z = zzae;
            }
            if (this.zzm == null) {
                zzaj();
            }
            str2 = this.zzm;
        } else {
            j = j5;
            str2 = null;
            j2 = 0;
            z = zzae;
        }
        boolean zzab = zze().zzab();
        long zzc = zzs().zzc(zzaf());
        int zza2 = zzk().zzp().zza();
        String zzf2 = zzk().zzo().zzf();
        if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zza(zzbn.zzcq)) {
            zzs();
            i = zzpn.zzc();
        } else {
            i = 0;
        }
        long zzm = (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zza(zzbn.zzcq)) ? zzs().zzm() : j2;
        String zzr = zze().zzr();
        String zzb = new zzd(zze().zzc("google_analytics_default_allow_ad_personalization_signals", true)).zzb();
        long j6 = this.zzu.zza;
        if (zze().zza(zzbn.zzcl)) {
            i2 = zzo().zzac().zza();
            list = list2;
        } else {
            list = list2;
            i2 = 0;
        }
        return new zzp(zzaf, zzah, str3, zzad, str4, 114010L, j3, str, z, z2, zzak, j4, zzac, zzw, z3, zzae2, valueOf, j, list, (String) null, zzf, str5, str2, zzab, zzc, zza2, zzf2, i, zzm, zzr, zzb, j6, i2);
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

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgj zzh() {
        return super.zzh();
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

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzju zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzlz zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzme zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zznx zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzae() {
        zzw();
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzaf() {
        zzw();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzag() {
        zzw();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    private final String zzak() {
        if (zzpq.zza() && zze().zza(zzbn.zzcb)) {
            zzj().zzq().zza("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> loadClass = zza().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zza());
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    zzj().zzw().zza("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzj().zzx().zza("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzah() {
        zzv();
        zzw();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> zzai() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgg(zzic zzicVar, long j) {
        super(zzicVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:1|(1:3)(6:67|68|(1:70)(2:85|(1:87))|71|72|(21:74|(1:76)(1:83)|78|79|5|(1:66)(1:9)|10|11|(1:14)(1:56)|15|(1:17)|18|19|(1:21)(1:53)|22|(1:24)|(3:26|(1:28)(1:31)|29)|32|(3:34|(1:36)(3:38|(3:41|(1:43)|39)|44)|37)|(1:46)|(2:48|49)(2:51|52)))|4|5|(1:7)|66|10|11|(0)(0)|15|(0)|18|19|(0)(0)|22|(0)|(0)|32|(0)|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01cb, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01cc, code lost:
        zzj().zzg().zza("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzgo.zza(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0195 A[Catch: IllegalStateException -> 0x01cb, TryCatch #3 {IllegalStateException -> 0x01cb, blocks: (B:50:0x0170, B:54:0x018d, B:56:0x0195, B:58:0x01ae, B:60:0x01c2, B:62:0x01c7, B:61:0x01c5), top: B:91:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ae A[Catch: IllegalStateException -> 0x01cb, TryCatch #3 {IllegalStateException -> 0x01cb, blocks: (B:50:0x0170, B:54:0x018d, B:56:0x0195, B:58:0x01ae, B:60:0x01c2, B:62:0x01c7, B:61:0x01c5), top: B:91:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x022f  */
    @Override // com.google.android.gms.measurement.internal.zzf
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzz() {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgg.zzz():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaj() {
        String format;
        zzv();
        if (!zzk().zzp().zza(zzjj.zza.ANALYTICS_STORAGE)) {
            zzj().zzc().zza("Analytics Storage consent is not granted");
            format = null;
        } else {
            byte[] bArr = new byte[16];
            zzs().zzw().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzgq zzc = zzj().zzc();
        Object[] objArr = new Object[1];
        objArr[0] = format == null ? "null" : "not null";
        zzc.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = format;
        this.zzn = zzb().currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb(String str) {
        String str2 = this.zzo;
        boolean z = (str2 == null || str2.equals(str)) ? false : true;
        this.zzo = str;
        return z;
    }
}
