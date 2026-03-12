package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxl  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzxl extends zzakg<zzxl, zza> implements zzalp {
    private static final zzxl zzc;
    private static volatile zzalw<zzxl> zzd;
    private int zze;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxl$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzxl, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zzxl) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzxl.zzc);
        }
    }

    public static zzxl zzd() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzxn.zza[i - 1]) {
            case 1:
                return new zzxl();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzxl> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzxl.class) {
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
        zzxl zzxlVar = new zzxl();
        zzc = zzxlVar;
        zzakg.zza(zzxl.class, zzxlVar);
    }

    private zzxl() {
    }
}
