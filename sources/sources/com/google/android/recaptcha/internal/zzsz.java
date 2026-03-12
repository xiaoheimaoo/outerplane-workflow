package com.google.android.recaptcha.internal;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzsz extends zznd implements zzoj {
    private static final zzsz zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private zznk zzg = zzB();

    static {
        zzsz zzszVar = new zzsz();
        zzb = zzszVar;
        zznd.zzI(zzsz.class, zzszVar);
    }

    private zzsz() {
    }

    public static zzsy zzf() {
        return (zzsy) zzb.zzq();
    }

    public static /* synthetic */ void zzi(zzsz zzszVar, Iterable iterable) {
        zzszVar.zzl();
        zzko.zzc(iterable, zzszVar.zzg);
    }

    public static /* synthetic */ void zzj(zzsz zzszVar, zzsx zzsxVar) {
        zzsxVar.getClass();
        zzszVar.zzl();
        zzszVar.zzg.add(zzsxVar);
    }

    public static /* synthetic */ void zzk(zzsz zzszVar, String str) {
        str.getClass();
        zzszVar.zze |= 1;
        zzszVar.zzf = str;
    }

    private final void zzl() {
        zznk zznkVar = this.zzg;
        if (zznkVar.zzc()) {
            return;
        }
        this.zzg = zznd.zzC(zznkVar);
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
                                synchronized (zzsz.class) {
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
                    return new zzsy(null);
                }
                return new zzsz();
            }
            return zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000", new Object[]{"zze", "zzg", zzsx.class, "zzf"});
        }
        return (byte) 1;
    }
}
