package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztq  reason: invalid package */
/* loaded from: classes2.dex */
public final class zztq extends zzakg<zztq, zza> implements zzalp {
    private static final zztq zzc;
    private static volatile zzalw<zztq> zzd;
    private int zze;
    private int zzf;

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztq$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zztq, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zztq) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zztq.zzc);
        }
    }

    public static zza zzc() {
        return zzc.zzm();
    }

    public static zztq zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zztq) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztp.zza[i - 1]) {
            case 1:
                return new zztq();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzf", "zze"});
            case 4:
                return zzc;
            case 5:
                zzalw<zztq> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zztq.class) {
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

    static {
        zztq zztqVar = new zztq();
        zzc = zztqVar;
        zzakg.zza(zztq.class, zztqVar);
    }

    private zztq() {
    }
}
