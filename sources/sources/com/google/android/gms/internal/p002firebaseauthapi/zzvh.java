package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzvh extends zzakg<zzvh, zza> implements zzalp {
    private static final zzvh zzc;
    private static volatile zzalw<zzvh> zzd;
    private int zze;
    private int zzf;

    public final int zza() {
        return this.zzf;
    }

    public final zzvc zzb() {
        zzvc zza2 = zzvc.zza(this.zze);
        return zza2 == null ? zzvc.UNRECOGNIZED : zza2;
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzvh, zza> implements zzalp {
        public final zza zza(zzvc zzvcVar) {
            zzg();
            zzvh.zza((zzvh) this.zza, zzvcVar);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzvh) this.zza).zzf = i;
            return this;
        }

        private zza() {
            super(zzvh.zzc);
        }
    }

    public static zza zzc() {
        return zzc.zzm();
    }

    public static zzvh zze() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvj.zza[i - 1]) {
            case 1:
                return new zzvh();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzvh> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzvh.class) {
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

    static /* synthetic */ void zza(zzvh zzvhVar, zzvc zzvcVar) {
        zzvhVar.zze = zzvcVar.zza();
    }

    static {
        zzvh zzvhVar = new zzvh();
        zzc = zzvhVar;
        zzakg.zza(zzvh.class, zzvhVar);
    }

    private zzvh() {
    }
}
