package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzwo extends zzakg<zzwo, zzb> implements zzalp {
    private static final zzwo zzc;
    private static volatile zzalw<zzwo> zzd;
    private int zze;
    private zzakn<zza> zzf = zzp();

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg<zza, C0008zza> implements zzalp {
        private static final zza zzc;
        private static volatile zzalw<zza> zzd;
        private String zze = "";
        private int zzf;
        private int zzg;
        private int zzh;

        public static C0008zza zza() {
            return zzc.zzm();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzwn.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0008zza();
                case 3:
                    return zza(zzc, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzalw<zza> zzalwVar = zzd;
                    if (zzalwVar == null) {
                        synchronized (zza.class) {
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

        /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
        /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0008zza extends zzakg.zzb<zza, C0008zza> implements zzalp {
            public final C0008zza zza(int i) {
                zzg();
                ((zza) this.zza).zzg = i;
                return this;
            }

            public final C0008zza zza(zzxd zzxdVar) {
                zzg();
                zza.zza((zza) this.zza, zzxdVar);
                return this;
            }

            public final C0008zza zza(zzwc zzwcVar) {
                zzg();
                zza.zza((zza) this.zza, zzwcVar);
                return this;
            }

            public final C0008zza zza(String str) {
                zzg();
                zza.zza((zza) this.zza, str);
                return this;
            }

            private C0008zza() {
                super(zza.zzc);
            }
        }

        static /* synthetic */ void zza(zza zzaVar, zzxd zzxdVar) {
            zzaVar.zzh = zzxdVar.zza();
        }

        static /* synthetic */ void zza(zza zzaVar, zzwc zzwcVar) {
            zzaVar.zzf = zzwcVar.zza();
        }

        static /* synthetic */ void zza(zza zzaVar, String str) {
            str.getClass();
            zzaVar.zze = str;
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzakg.zza(zza.class, zzaVar);
        }

        private zza() {
        }
    }

    public static zzb zza() {
        return zzc.zzm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzwn.zza[i - 1]) {
            case 1:
                return new zzwo();
            case 2:
                return new zzb();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zza.class});
            case 4:
                return zzc;
            case 5:
                zzalw<zzwo> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzwo.class) {
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

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo$zzb */
    /* loaded from: classes2.dex */
    public static final class zzb extends zzakg.zzb<zzwo, zzb> implements zzalp {
        public final zzb zza(zza zzaVar) {
            zzg();
            zzwo.zza((zzwo) this.zza, zzaVar);
            return this;
        }

        public final zzb zza(int i) {
            zzg();
            ((zzwo) this.zza).zze = i;
            return this;
        }

        private zzb() {
            super(zzwo.zzc);
        }
    }

    static /* synthetic */ void zza(zzwo zzwoVar, zza zzaVar) {
        zzaVar.getClass();
        zzakn<zza> zzaknVar = zzwoVar.zzf;
        if (!zzaknVar.zzc()) {
            zzwoVar.zzf = zzakg.zza(zzaknVar);
        }
        zzwoVar.zzf.add(zzaVar);
    }

    static {
        zzwo zzwoVar = new zzwo();
        zzc = zzwoVar;
        zzakg.zza(zzwo.class, zzwoVar);
    }

    private zzwo() {
    }
}
