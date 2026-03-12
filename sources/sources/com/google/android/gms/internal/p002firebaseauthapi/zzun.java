package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzun  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzun extends zzakg<zzun, zza> implements zzalp {
    private static final zzun zzc;
    private static volatile zzalw<zzun> zzd;
    private int zze;
    private int zzf;
    private zzuq zzg;
    private zzaiw zzh = zzaiw.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzun$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzun, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzun.zza((zzun) this.zza, zzaiwVar);
            return this;
        }

        public final zza zza(zzuq zzuqVar) {
            zzg();
            zzun.zza((zzun) this.zza, zzuqVar);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzun) this.zza).zzf = 0;
            return this;
        }

        private zza() {
            super(zzun.zzc);
        }
    }

    public static zzun zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzun) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzuq zzd() {
        zzuq zzuqVar = this.zzg;
        return zzuqVar == null ? zzuq.zze() : zzuqVar;
    }

    public final zzaiw zze() {
        return this.zzh;
    }

    public static zzalw<zzun> zzf() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzup.zza[i - 1]) {
            case 1:
                return new zzun();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzun> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzun.class) {
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

    static /* synthetic */ void zza(zzun zzunVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzunVar.zzh = zzaiwVar;
    }

    static /* synthetic */ void zza(zzun zzunVar, zzuq zzuqVar) {
        zzuqVar.getClass();
        zzunVar.zzg = zzuqVar;
        zzunVar.zze |= 1;
    }

    static {
        zzun zzunVar = new zzun();
        zzc = zzunVar;
        zzakg.zza(zzun.class, zzunVar);
    }

    private zzun() {
    }
}
