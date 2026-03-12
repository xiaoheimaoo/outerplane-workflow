package com.google.android.gms.internal.play_billing;
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzjz extends zzhk implements zzin {
    private static final zzjz zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private zzki zzh;

    static {
        zzjz zzjzVar = new zzjz();
        zzb = zzjzVar;
        zzhk.zzx(zzjz.class, zzjzVar);
    }

    private zzjz() {
    }

    public static zzjz zzC(byte[] bArr, zzgw zzgwVar) throws zzhr {
        return (zzjz) zzhk.zzq(zzb, bArr, zzgwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzD(zzjz zzjzVar, zzki zzkiVar) {
        zzkiVar.getClass();
        zzjzVar.zzh = zzkiVar;
        zzjzVar.zzd |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzE(zzjz zzjzVar, zzlb zzlbVar) {
        zzlbVar.getClass();
        zzjzVar.zzf = zzlbVar;
        zzjzVar.zze = 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzF(zzjz zzjzVar, int i) {
        zzjzVar.zzg = i - 1;
        zzjzVar.zzd |= 1;
    }

    public static zzjx zzc() {
        return (zzjx) zzb.zzm();
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
                    return new zzjx(null);
                }
                return new zzjz();
            }
            return zzu(zzb, "\u0004\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzka.zza, "zzh", zzlb.class});
        }
        return (byte) 1;
    }
}
