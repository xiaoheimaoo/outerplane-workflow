package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzgvk extends zzgzu implements zzhbf {
    private static final zzgvk zzb;
    private String zzd = "";
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzgvk zzgvkVar = new zzgvk();
        zzb = zzgvkVar;
        zzgzu.zzaU(zzgvk.class, zzgvkVar);
    }

    private zzgvk() {
    }

    public static zzgvj zza() {
        return (zzgvj) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzgvk zzgvkVar, String str) {
        str.getClass();
        zzgvkVar.zzd = str;
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
                    return new zzgvj(null);
                }
                return new zzgvk();
            }
            return zzaR(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
