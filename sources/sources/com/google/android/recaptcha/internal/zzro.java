package com.google.android.recaptcha.internal;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public final class zzro extends zznd implements zzoj {
    private static final zzro zzb;
    private static volatile zzoq zzd;
    private int zze;
    private zzqt zzg;
    private zzqk zzh;
    private zzqw zzi;
    private String zzf = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzro zzroVar = new zzro();
        zzb = zzroVar;
        zznd.zzI(zzro.class, zzroVar);
    }

    private zzro() {
    }

    public static zzrm zzf() {
        return (zzrm) zzb.zzq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzro zzroVar, zzqk zzqkVar) {
        zzqkVar.getClass();
        zzroVar.zzh = zzqkVar;
        zzroVar.zze |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzro zzroVar, String str) {
        str.getClass();
        zzroVar.zzk = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzro zzroVar, String str) {
        str.getClass();
        zzroVar.zzj = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(zzro zzroVar, String str) {
        str.getClass();
        zzroVar.zzf = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                                synchronized (zzro.class) {
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
                    return new zzrm(null);
                }
                return new zzro();
            }
            return zzF(zzb, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005Ȉ\u0006Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        return (byte) 1;
    }
}
