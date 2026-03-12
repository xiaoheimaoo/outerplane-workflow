package com.google.android.recaptcha.internal;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzsx extends zznd implements zzoj {
    private static final zzsx zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzni zzh = zzy();
    private int zzi;
    private int zzj;

    static {
        zzsx zzsxVar = new zzsx();
        zzb = zzsxVar;
        zznd.zzI(zzsx.class, zzsxVar);
    }

    private zzsx() {
    }

    public static zzsv zzf() {
        return (zzsv) zzb.zzq();
    }

    public static /* synthetic */ void zzi(zzsx zzsxVar, String str) {
        str.getClass();
        zzsxVar.zze |= 2;
        zzsxVar.zzg = str;
    }

    public static /* synthetic */ void zzj(zzsx zzsxVar, String str) {
        str.getClass();
        zzsxVar.zze |= 1;
        zzsxVar.zzf = str;
    }

    public static /* synthetic */ void zzk(zzsx zzsxVar, int i) {
        zzsxVar.zzi = 2;
        zzsxVar.zze |= 4;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                return null;
                            }
                            zzoq zzoqVar = zzd;
                            if (zzoqVar == null) {
                                synchronized (zzsx.class) {
                                    zzoqVar = zzd;
                                    if (zzoqVar == null) {
                                        zzoqVar = new zzmy(zzb);
                                        zzd = zzoqVar;
                                    }
                                }
                            }
                            return zzoqVar;
                        }
                        return zzb;
                    }
                    return new zzsv(null);
                }
                return new zzsx();
            }
            return zzF(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003'\u0004᠌\u0002\u0005င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzsw.zza, "zzj"});
        }
        return (byte) 1;
    }
}
