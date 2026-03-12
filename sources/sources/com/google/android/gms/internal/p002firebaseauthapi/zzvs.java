package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvs  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzvs extends zzakg<zzvs, zza> implements zzalp {
    private static final zzvs zzc;
    private static volatile zzalw<zzvs> zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final zzvk zza() {
        zzvk zza2 = zzvk.zza(this.zzg);
        return zza2 == null ? zzvk.UNRECOGNIZED : zza2;
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvs$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzvs, zza> implements zzalp {
        public final zza zza(zzvk zzvkVar) {
            zzg();
            zzvs.zza((zzvs) this.zza, zzvkVar);
            return this;
        }

        public final zza zza(zzvn zzvnVar) {
            zzg();
            zzvs.zza((zzvs) this.zza, zzvnVar);
            return this;
        }

        public final zza zza(zzvm zzvmVar) {
            zzg();
            zzvs.zza((zzvs) this.zza, zzvmVar);
            return this;
        }

        private zza() {
            super(zzvs.zzc);
        }
    }

    public final zzvn zzb() {
        zzvn zza2 = zzvn.zza(this.zzf);
        return zza2 == null ? zzvn.UNRECOGNIZED : zza2;
    }

    public final zzvm zzc() {
        zzvm zza2 = zzvm.zza(this.zze);
        return zza2 == null ? zzvm.UNRECOGNIZED : zza2;
    }

    public static zza zzd() {
        return zzc.zzm();
    }

    public static zzvs zzf() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvr.zza[i - 1]) {
            case 1:
                return new zzvs();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzvs> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzvs.class) {
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

    static /* synthetic */ void zza(zzvs zzvsVar, zzvk zzvkVar) {
        zzvsVar.zzg = zzvkVar.zza();
    }

    static /* synthetic */ void zza(zzvs zzvsVar, zzvn zzvnVar) {
        zzvsVar.zzf = zzvnVar.zza();
    }

    static /* synthetic */ void zza(zzvs zzvsVar, zzvm zzvmVar) {
        zzvsVar.zze = zzvmVar.zza();
    }

    static {
        zzvs zzvsVar = new zzvs();
        zzc = zzvsVar;
        zzakg.zza(zzvs.class, zzvsVar);
    }

    private zzvs() {
    }
}
