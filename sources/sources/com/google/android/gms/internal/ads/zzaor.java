package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
final class zzaor implements zzaoq {
    private final zzacx zza;
    private final zzaea zzb;
    private final zzaot zzc;
    private final zzam zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaor(zzacx zzacxVar, zzaea zzaeaVar, zzaot zzaotVar, String str, int i) throws zzcc {
        this.zza = zzacxVar;
        this.zzb = zzaeaVar;
        this.zzc = zzaotVar;
        int i2 = zzaotVar.zzb * zzaotVar.zze;
        int i3 = zzaotVar.zzd;
        int i4 = i2 / 8;
        if (i3 != i4) {
            throw zzcc.zza("Expected block size: " + i4 + "; got: " + i3, null);
        }
        int i5 = zzaotVar.zzc * i4;
        int i6 = i5 * 8;
        int max = Math.max(i4, i5 / 10);
        this.zze = max;
        zzak zzakVar = new zzak();
        zzakVar.zzW(str);
        zzakVar.zzx(i6);
        zzakVar.zzR(i6);
        zzakVar.zzO(max);
        zzakVar.zzy(zzaotVar.zzb);
        zzakVar.zzX(zzaotVar.zzc);
        zzakVar.zzQ(i);
        this.zzd = zzakVar.zzac();
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final void zza(int i, long j) {
        this.zza.zzO(new zzaow(this.zzc, 1, i, j));
        this.zzb.zzl(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final boolean zzc(zzacv zzacvVar, long j) throws IOException {
        int i;
        int i2;
        int i3;
        long j2 = j;
        while (true) {
            i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i <= 0 || (i2 = this.zzg) >= (i3 = this.zze)) {
                break;
            }
            int zza = zzady.zza(this.zzb, zzacvVar, (int) Math.min(i3 - i2, j2), true);
            if (zza == -1) {
                j2 = 0;
            } else {
                this.zzg += zza;
                j2 -= zza;
            }
        }
        zzaot zzaotVar = this.zzc;
        int i4 = this.zzg;
        int i5 = zzaotVar.zzd;
        int i6 = i4 / i5;
        if (i6 > 0) {
            int i7 = i6 * i5;
            int i8 = this.zzg - i7;
            this.zzb.zzt(this.zzf + zzfy.zzs(this.zzh, 1000000L, zzaotVar.zzc, RoundingMode.FLOOR), 1, i7, i8, null);
            this.zzh += i6;
            this.zzg = i8;
        }
        return i <= 0;
    }
}
