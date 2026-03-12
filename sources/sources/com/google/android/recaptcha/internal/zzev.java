package com.google.android.recaptcha.internal;

import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzev {
    public static final zzrl zza(zzbn zzbnVar, zzbn zzbnVar2) {
        zzrj zzf = zzrl.zzf();
        zzf.zzq(zzqb.zzb(zzbnVar.zzb()));
        zzf.zzr(zzpz.zza(zzbnVar.zza(TimeUnit.NANOSECONDS)));
        zzf.zze(zzqb.zzb(zzbnVar2.zzb()));
        zzf.zzf(zzpz.zza(zzbnVar2.zza(TimeUnit.NANOSECONDS)));
        return (zzrl) zzf.zzk();
    }
}
