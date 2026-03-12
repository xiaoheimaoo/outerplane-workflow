package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzkd extends zzhk implements zzin {
    private static final zzkd zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        zzkd zzkdVar = new zzkd();
        zzb = zzkdVar;
        zzhk.zzx(zzkd.class, zzkdVar);
    }

    private zzkd() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzC(zzkd zzkdVar, zzlb zzlbVar) {
        zzlbVar.getClass();
        zzkdVar.zzf = zzlbVar;
        zzkdVar.zze = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzD(zzkd zzkdVar, zzlx zzlxVar) {
        zzlxVar.getClass();
        zzkdVar.zzf = zzlxVar;
        zzkdVar.zze = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzE(zzkd zzkdVar, int i) {
        zzkdVar.zzg = i - 1;
        zzkdVar.zzd |= 1;
    }

    public static zzkb zzc() {
        return (zzkb) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    protected final Object zzd(int i, Object obj, Object obj2) {
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
                    return new zzkb(null);
                }
                return new zzkd();
            }
            return zzu(zzb, "\u0004\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzka.zza, zzlb.class, zzlx.class, zzlh.class});
        }
        return (byte) 1;
    }
}
