package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvb  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzvb extends zzakg<zzvb, zza> implements zzalp {
    private static final zzvb zzc;
    private static volatile zzalw<zzvb> zzd;
    private int zze;
    private int zzf;
    private zzvh zzg;
    private zzaiw zzh = zzaiw.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvb$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzvb, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzvb.zza((zzvb) this.zza, zzaiwVar);
            return this;
        }

        public final zza zza(zzvh zzvhVar) {
            zzg();
            zzvb.zza((zzvb) this.zza, zzvhVar);
            return this;
        }

        private zza() {
            super(zzvb.zzc);
        }
    }

    public static zzvb zzd() {
        return zzc;
    }

    public static zzvb zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzvb) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzvh zze() {
        zzvh zzvhVar = this.zzg;
        return zzvhVar == null ? zzvh.zze() : zzvhVar;
    }

    public final zzaiw zzf() {
        return this.zzh;
    }

    public static zzalw<zzvb> zzg() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvd.zza[i - 1]) {
            case 1:
                return new zzvb();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzvb> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzvb.class) {
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

    static /* synthetic */ void zza(zzvb zzvbVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzvbVar.zzh = zzaiwVar;
    }

    static /* synthetic */ void zza(zzvb zzvbVar, zzvh zzvhVar) {
        zzvhVar.getClass();
        zzvbVar.zzg = zzvhVar;
        zzvbVar.zze |= 1;
    }

    static {
        zzvb zzvbVar = new zzvb();
        zzc = zzvbVar;
        zzakg.zza(zzvb.class, zzvbVar);
    }

    private zzvb() {
    }
}
