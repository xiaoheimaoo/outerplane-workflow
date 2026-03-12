package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsg  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzsg extends zzakg<zzsg, zza> implements zzalp {
    private static final zzsg zzc;
    private static volatile zzalw<zzsg> zzd;
    private int zze;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsg$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzsg, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zzsg) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzsg.zzc);
        }
    }

    public static zzsg zzd() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsf.zza[i - 1]) {
            case 1:
                return new zzsg();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzsg> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzsg.class) {
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
        zzsg zzsgVar = new zzsg();
        zzc = zzsgVar;
        zzakg.zza(zzsg.class, zzsgVar);
    }

    private zzsg() {
    }
}
