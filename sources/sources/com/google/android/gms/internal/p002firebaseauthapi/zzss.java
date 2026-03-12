package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzss  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzss extends zzakg<zzss, zza> implements zzalp {
    private static final zzss zzc;
    private static volatile zzalw<zzss> zzd;
    private int zze;
    private zzsv zzf;
    private int zzg;

    public final int zza() {
        return this.zzg;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzss$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzss, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zzss) this.zza).zzg = i;
            return this;
        }

        public final zza zza(zzsv zzsvVar) {
            zzg();
            zzss.zza((zzss) this.zza, zzsvVar);
            return this;
        }

        private zza() {
            super(zzss.zzc);
        }
    }

    public static zzss zzd() {
        return zzc;
    }

    public final zzsv zze() {
        zzsv zzsvVar = this.zzf;
        return zzsvVar == null ? zzsv.zzd() : zzsvVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsr.zza[i - 1]) {
            case 1:
                return new zzss();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzss> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzss.class) {
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

    static /* synthetic */ void zza(zzss zzssVar, zzsv zzsvVar) {
        zzsvVar.getClass();
        zzssVar.zzf = zzsvVar;
        zzssVar.zze |= 1;
    }

    static {
        zzss zzssVar = new zzss();
        zzc = zzssVar;
        zzakg.zza(zzss.class, zzssVar);
    }

    private zzss() {
    }
}
