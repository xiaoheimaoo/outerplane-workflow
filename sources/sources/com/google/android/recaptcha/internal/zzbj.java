package com.google.android.recaptcha.internal;

import kotlin.comparisons.ComparisonsKt;
import kotlin.text.StringsKt;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzbj implements Comparable {
    private int zza;
    private long zzb;
    private long zzc;

    public final String toString() {
        String padEnd$default = StringsKt.padEnd$default(String.valueOf(this.zzb / this.zza), 10, (char) 0, 2, (Object) null);
        String padEnd$default2 = StringsKt.padEnd$default(String.valueOf(this.zzc), 10, (char) 0, 2, (Object) null);
        String padEnd$default3 = StringsKt.padEnd$default(String.valueOf(this.zzb), 10, (char) 0, 2, (Object) null);
        String padEnd$default4 = StringsKt.padEnd$default(String.valueOf(this.zza), 5, (char) 0, 2, (Object) null);
        return "avgExecutionTime: " + padEnd$default + " us| maxExecutionTime: " + padEnd$default2 + " us| totalTime: " + padEnd$default3 + " us| #Usages: " + padEnd$default4;
    }

    @Override // java.lang.Comparable
    /* renamed from: zza */
    public final int compareTo(zzbj zzbjVar) {
        return ComparisonsKt.compareValues(Long.valueOf(this.zzb), Long.valueOf(zzbjVar.zzb));
    }

    public final int zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzb;
    }

    public final void zze(long j) {
        this.zzc = j;
    }

    public final void zzf(long j) {
        this.zzb = j;
    }

    public final void zzg(int i) {
        this.zza = i;
    }
}
