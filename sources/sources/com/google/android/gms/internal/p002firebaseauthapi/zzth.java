package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzth  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzth extends zzakg<zzth, zza> implements zzalp {
    private static final zzth zzc;
    private static volatile zzalw<zzth> zzd;
    private int zze;
    private zzaiw zzf = zzaiw.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzth$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzth, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzth.zza((zzth) this.zza, zzaiwVar);
            return this;
        }

        private zza() {
            super(zzth.zzc);
        }
    }

    public static zzth zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzth) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzaiw zzd() {
        return this.zzf;
    }

    public static zzalw<zzth> zze() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztg.zza[i - 1]) {
            case 1:
                return new zzth();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzth> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzth.class) {
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

    static /* synthetic */ void zza(zzth zzthVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzthVar.zzf = zzaiwVar;
    }

    static {
        zzth zzthVar = new zzth();
        zzc = zzthVar;
        zzakg.zza(zzth.class, zzthVar);
    }

    private zzth() {
    }
}
