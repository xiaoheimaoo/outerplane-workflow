package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsa  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzsa extends zzakg<zzsa, zza> implements zzalp {
    private static final zzsa zzc;
    private static volatile zzalw<zzsa> zzd;
    private int zze;
    private int zzf;
    private zzaiw zzg = zzaiw.zza;
    private zzsg zzh;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsa$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzsa, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzsa.zza((zzsa) this.zza, zzaiwVar);
            return this;
        }

        public final zza zza(zzsg zzsgVar) {
            zzg();
            zzsa.zza((zzsa) this.zza, zzsgVar);
            return this;
        }

        private zza() {
            super(zzsa.zzc);
        }
    }

    public static zzsa zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzsa) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzsg zzd() {
        zzsg zzsgVar = this.zzh;
        return zzsgVar == null ? zzsg.zzd() : zzsgVar;
    }

    public final zzaiw zze() {
        return this.zzg;
    }

    public static zzalw<zzsa> zzf() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzrz.zza[i - 1]) {
            case 1:
                return new zzsa();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzsa> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzsa.class) {
                        zzalwVar = zzd;
                        if (zzalwVar == null) {
                            zzalwVar = new zzakg.zza<>(zzc);
                            zzd = zzalwVar;
                        }
                    }
                }
                return zzalwVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }

    static /* synthetic */ void zza(zzsa zzsaVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzsaVar.zzg = zzaiwVar;
    }

    static /* synthetic */ void zza(zzsa zzsaVar, zzsg zzsgVar) {
        zzsgVar.getClass();
        zzsaVar.zzh = zzsgVar;
        zzsaVar.zze |= 1;
    }

    static {
        zzsa zzsaVar = new zzsa();
        zzc = zzsaVar;
        zzakg.zza(zzsa.class, zzsaVar);
    }

    private zzsa() {
    }
}
