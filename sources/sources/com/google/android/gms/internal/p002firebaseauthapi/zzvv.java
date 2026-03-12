package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvv  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzvv extends zzakg<zzvv, zza> implements zzalp {
    private static final zzvv zzc;
    private static volatile zzalw<zzvv> zzd;
    private int zze;
    private int zzf;
    private zzvy zzg;
    private zzaiw zzh = zzaiw.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvv$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzvv, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzvv.zza((zzvv) this.zza, zzaiwVar);
            return this;
        }

        public final zza zza(zzvy zzvyVar) {
            zzg();
            zzvv.zza((zzvv) this.zza, zzvyVar);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzvv) this.zza).zzf = 0;
            return this;
        }

        private zza() {
            super(zzvv.zzc);
        }
    }

    public static zzvv zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzvv) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzvy zzd() {
        zzvy zzvyVar = this.zzg;
        return zzvyVar == null ? zzvy.zze() : zzvyVar;
    }

    public final zzaiw zze() {
        return this.zzh;
    }

    public static zzalw<zzvv> zzf() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvu.zza[i - 1]) {
            case 1:
                return new zzvv();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzvv> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzvv.class) {
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

    static /* synthetic */ void zza(zzvv zzvvVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzvvVar.zzh = zzaiwVar;
    }

    static /* synthetic */ void zza(zzvv zzvvVar, zzvy zzvyVar) {
        zzvyVar.getClass();
        zzvvVar.zzg = zzvyVar;
        zzvvVar.zze |= 1;
    }

    static {
        zzvv zzvvVar = new zzvv();
        zzc = zzvvVar;
        zzakg.zza(zzvv.class, zzvvVar);
    }

    private zzvv() {
    }
}
