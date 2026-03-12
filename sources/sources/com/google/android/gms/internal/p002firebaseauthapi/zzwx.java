package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwx  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzwx extends zzakg<zzwx, zza> implements zzalp {
    private static final zzwx zzc;
    private static volatile zzalw<zzwx> zzd;
    private int zze;
    private int zzf;
    private zzxa zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwx$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzwx, zza> implements zzalp {
        public final zza zza(zzxa zzxaVar) {
            zzg();
            zzwx.zza((zzwx) this.zza, zzxaVar);
            return this;
        }

        private zza() {
            super(zzwx.zzc);
        }
    }

    public static zzwx zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzwx) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzxa zzd() {
        zzxa zzxaVar = this.zzg;
        return zzxaVar == null ? zzxa.zzd() : zzxaVar;
    }

    public static zzalw<zzwx> zze() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzww.zza[i - 1]) {
            case 1:
                return new zzwx();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzwx> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzwx.class) {
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

    static /* synthetic */ void zza(zzwx zzwxVar, zzxa zzxaVar) {
        zzxaVar.getClass();
        zzwxVar.zzg = zzxaVar;
        zzwxVar.zze |= 1;
    }

    static {
        zzwx zzwxVar = new zzwx();
        zzc = zzwxVar;
        zzakg.zza(zzwx.class, zzwxVar);
    }

    private zzwx() {
    }
}
