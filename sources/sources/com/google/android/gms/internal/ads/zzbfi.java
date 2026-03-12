package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzbfi extends zzgzu implements zzhbf {
    private static final zzbfi zzb;
    private int zzd;
    private int zze = 1000;
    private zzbew zzf;

    static {
        zzbfi zzbfiVar = new zzbfi();
        zzb = zzbfiVar;
        zzgzu.zzaU(zzbfi.class, zzbfiVar);
    }

    private zzbfi() {
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
                    return new zzbfh(null);
                }
                return new zzbfi();
            }
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", zzbdc.zza, "zzf"});
        }
        return (byte) 1;
    }
}
