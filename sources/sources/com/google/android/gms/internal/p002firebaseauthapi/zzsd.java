package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsd  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzsd extends zzakg<zzsd, zza> implements zzalp {
    private static final zzsd zzc;
    private static volatile zzalw<zzsd> zzd;
    private int zze;
    private int zzf;
    private zzsg zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsd$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzsd, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zzsd) this.zza).zzf = i;
            return this;
        }

        public final zza zza(zzsg zzsgVar) {
            zzg();
            zzsd.zza((zzsd) this.zza, zzsgVar);
            return this;
        }

        private zza() {
            super(zzsd.zzc);
        }
    }

    public static zzsd zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzsd) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzsg zzd() {
        zzsg zzsgVar = this.zzg;
        return zzsgVar == null ? zzsg.zzd() : zzsgVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsc.zza[i - 1]) {
            case 1:
                return new zzsd();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzsd> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzsd.class) {
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

    static /* synthetic */ void zza(zzsd zzsdVar, zzsg zzsgVar) {
        zzsgVar.getClass();
        zzsdVar.zzg = zzsgVar;
        zzsdVar.zze |= 1;
    }

    static {
        zzsd zzsdVar = new zzsd();
        zzc = zzsdVar;
        zzakg.zza(zzsd.class, zzsdVar);
    }

    private zzsd() {
    }
}
