package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxr  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzxr extends zzakg<zzxr, zza> implements zzalp {
    private static final zzxr zzc;
    private static volatile zzalw<zzxr> zzd;
    private int zze;

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxr$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzxr, zza> implements zzalp {
        private zza() {
            super(zzxr.zzc);
        }
    }

    public final int zza() {
        return this.zze;
    }

    public static zzxr zzc() {
        return zzc;
    }

    public static zzxr zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzxr) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzxt.zza[i - 1]) {
            case 1:
                return new zzxr();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzxr> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzxr.class) {
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
        zzxr zzxrVar = new zzxr();
        zzc = zzxrVar;
        zzakg.zza(zzxr.class, zzxrVar);
    }

    private zzxr() {
    }
}
