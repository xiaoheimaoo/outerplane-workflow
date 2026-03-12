package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzgul extends zzgzu implements zzhbf {
    private static final zzgul zzb;
    private int zzd;
    private zzguo zze;
    private int zzf;
    private int zzg;

    static {
        zzgul zzgulVar = new zzgul();
        zzb = zzgulVar;
        zzgzu.zzaU(zzgul.class, zzgulVar);
    }

    private zzgul() {
    }

    public static zzguk zzd() {
        return (zzguk) zzb.zzaA();
    }

    public static zzgul zzf() {
        return zzb;
    }

    public static zzgul zzg(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgul) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public static /* synthetic */ void zzi(zzgul zzgulVar, zzguo zzguoVar) {
        zzguoVar.getClass();
        zzgulVar.zze = zzguoVar;
        zzgulVar.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return zzb;
                    }
                    return new zzguk(null);
                }
                return new zzgul();
            }
            return zzaR(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }

    public final int zzc() {
        return this.zzg;
    }

    public final zzguo zzh() {
        zzguo zzguoVar = this.zze;
        return zzguoVar == null ? zzguo.zzf() : zzguoVar;
    }
}
