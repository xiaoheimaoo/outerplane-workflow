package com.google.android.recaptcha.internal;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzmc extends zznd implements zzoj {
    private static final zzmc zzb;
    private static volatile zzoq zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private String zzh = "";
    private int zzi;

    static {
        zzmc zzmcVar = new zzmc();
        zzb = zzmcVar;
        zznd.zzI(zzmc.class, zzmcVar);
    }

    private zzmc() {
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 == 2) {
                zznh zznhVar = zzlp.zza;
                return new zzou(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004᠌\u0003", new Object[]{"zze", "zzf", zzlp.zza, "zzg", zznhVar, "zzh", "zzi", zznhVar});
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        if (i2 != 6) {
                            return null;
                        }
                        zzoq zzoqVar = zzd;
                        if (zzoqVar == null) {
                            synchronized (zzmc.class) {
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
                return new zzmb(null);
            } else {
                return new zzmc();
            }
        }
        return (byte) 1;
    }
}
