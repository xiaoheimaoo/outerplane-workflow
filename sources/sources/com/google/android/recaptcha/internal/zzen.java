package com.google.android.recaptcha.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import kotlin.LazyKt;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzen {
    private static zzqk zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final zzeo zzf;
    private final Context zzg;
    private final Integer zzh;
    private final String zzi = zzqb.zzc(zzqb.zzb(System.currentTimeMillis()));
    private final long zzj = System.currentTimeMillis();
    private final int zzk;
    private final int zzl;

    public zzen(int i, String str, int i2, String str2, String str3, String str4, String str5, zzeo zzeoVar, zzcc zzccVar, Context context, Integer num) {
        this.zzk = i;
        this.zzb = str;
        this.zzl = i2;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = zzeoVar;
        this.zzg = context;
        this.zzh = num;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0109 -> B:45:0x0109). Please submit an issue!!! */
    private final void zzc(int i, zzqq zzqqVar) {
        zzbl zzblVar;
        String str;
        String str2;
        String str3 = "";
        String str4 = "unknown";
        zzra zzi = zzrc.zzi();
        zzi.zzy(this.zzk);
        zzi.zzq(this.zzc);
        zzi.zzt(this.zzd);
        zzi.zzz(this.zzl);
        String str5 = this.zze;
        if (str5 != null) {
            zzi.zzx(str5);
        }
        Integer num = this.zzh;
        if (num != null) {
            zzi.zzv(num.intValue());
        }
        if (zzqqVar != null) {
            zzi.zzs(zzqqVar);
        }
        zzi.zzA(i);
        zzi.zzw(this.zzi);
        zzi.zzr(System.currentTimeMillis() - this.zzj);
        int i2 = zzav.zza;
        for (zzax zzaxVar : ((zzaz) LazyKt.lazy(zzel.zza).getValue()).zza()) {
            zzi.zzf(0);
        }
        int i3 = zzbk.zza;
        int i4 = this.zzk;
        long zze = zzi.zze() * 1000;
        int i5 = i4 - 2;
        if (i5 == 4) {
            zzblVar = zzbl.zzb;
        } else if (i5 == 5) {
            zzblVar = zzbl.zzc;
        } else if (i5 == 6) {
            zzblVar = zzbl.zzd;
        } else if (i5 != 7) {
            zzblVar = i5 != 14 ? zzbl.zza : zzbl.zzf;
        } else {
            zzblVar = zzbl.zze;
        }
        zzbk.zza(zzblVar.zza(), zze);
        zzbe zzbeVar = (zzbe) LazyKt.lazy(zzem.zza).getValue();
        Context context = this.zzg;
        Set zza2 = zzbe.zza(context);
        zzqk zzqkVar = zza;
        if (zzqkVar == null) {
            zzqh zzf = zzqk.zzf();
            zzf.zzf(Build.VERSION.SDK_INT);
            if (Build.VERSION.SDK_INT >= 33) {
                int i6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L)).metaData.getInt("com.google.android.gms.version", -1);
                str2 = i6 == -1 ? "unknown" : String.valueOf(i6);
            } else {
                int i7 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt("com.google.android.gms.version", -1);
                if (i7 != -1) {
                    str2 = String.valueOf(i7);
                }
            }
            zzf.zzs(str2);
            zzf.zzu("18.6.1");
            zzf.zzr(Build.MODEL);
            zzf.zzt(Build.MANUFACTURER);
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    str4 = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L)).getLongVersionCode());
                } else if (Build.VERSION.SDK_INT >= 28) {
                    str4 = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).getLongVersionCode());
                } else {
                    str4 = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            zzf.zzq(str4);
            zzqkVar = (zzqk) zzf.zzk();
        }
        zza = zzqkVar;
        zzqh zzqhVar = (zzqh) zzqkVar.zzr();
        zzqhVar.zze(zza2);
        zzqk zzqkVar2 = (zzqk) zzqhVar.zzk();
        try {
            str = Locale.getDefault().getISO3Language();
        } catch (MissingResourceException unused2) {
            str = "";
        }
        try {
            str3 = Locale.getDefault().getISO3Country();
        } catch (MissingResourceException unused3) {
        }
        String str6 = this.zzb;
        zzrm zzf2 = zzro.zzf();
        zzf2.zzr(str6);
        zzf2.zze(zzqkVar2);
        zzf2.zzq(str);
        zzf2.zzf(str3);
        zzi.zzu((zzro) zzf2.zzk());
        zztw zzi2 = zztx.zzi();
        zzi2.zze(zzi);
        this.zzf.zza((zztx) zzi2.zzk());
    }

    public final void zza() {
        zzc(3, null);
    }

    public final void zzb(zzbd zzbdVar) {
        zzqo zzg = zzqq.zzg();
        zzg.zzr(String.valueOf(zzbdVar.zzb().zza()));
        zzg.zze(zzbdVar.zza().zza());
        zzg.zzq(zzbdVar.zzc().getErrorCode().getErrorCode());
        String zzd = zzbdVar.zzd();
        if (zzd != null) {
            zzg.zzf(zzd);
        }
        zzc(4, (zzqq) zzg.zzk());
    }
}
