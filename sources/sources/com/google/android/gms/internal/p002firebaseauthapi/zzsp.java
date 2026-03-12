package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsp  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzsp extends zzakg<zzsp, zza> implements zzalp {
    private static final zzsp zzc;
    private static volatile zzalw<zzsp> zzd;
    private int zze;
    private int zzf;
    private zzsv zzg;
    private zzaiw zzh = zzaiw.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsp$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzsp, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzsp.zza((zzsp) this.zza, zzaiwVar);
            return this;
        }

        public final zza zza(zzsv zzsvVar) {
            zzg();
            zzsp.zza((zzsp) this.zza, zzsvVar);
            return this;
        }

        private zza() {
            super(zzsp.zzc);
        }
    }

    public static zzsp zzd() {
        return zzc;
    }

    public final zzsv zze() {
        zzsv zzsvVar = this.zzg;
        return zzsvVar == null ? zzsv.zzd() : zzsvVar;
    }

    public final zzaiw zzf() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzso.zza[i - 1]) {
            case 1:
                return new zzsp();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzsp> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzsp.class) {
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

    static /* synthetic */ void zza(zzsp zzspVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzspVar.zzh = zzaiwVar;
    }

    static /* synthetic */ void zza(zzsp zzspVar, zzsv zzsvVar) {
        zzsvVar.getClass();
        zzspVar.zzg = zzsvVar;
        zzspVar.zze |= 1;
    }

    static {
        zzsp zzspVar = new zzsp();
        zzc = zzspVar;
        zzakg.zza(zzsp.class, zzspVar);
    }

    private zzsp() {
    }
}
