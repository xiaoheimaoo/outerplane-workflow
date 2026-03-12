package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuh  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzuh extends zzakg<zzuh, zza> implements zzalp {
    private static final zzuh zzc;
    private static volatile zzalw<zzuh> zzd;
    private int zze;
    private zzuk zzf;

    public static zza zza() {
        return zzc.zzm();
    }

    public static zzuh zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzuh) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuh$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzuh, zza> implements zzalp {
        public final zza zza(zzuk zzukVar) {
            zzg();
            zzuh.zza((zzuh) this.zza, zzukVar);
            return this;
        }

        private zza() {
            super(zzuh.zzc);
        }
    }

    public final zzuk zzc() {
        zzuk zzukVar = this.zzf;
        return zzukVar == null ? zzuk.zze() : zzukVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuj.zza[i - 1]) {
            case 1:
                return new zzuh();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzuh> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzuh.class) {
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

    static /* synthetic */ void zza(zzuh zzuhVar, zzuk zzukVar) {
        zzukVar.getClass();
        zzuhVar.zzf = zzukVar;
        zzuhVar.zze |= 1;
    }

    static {
        zzuh zzuhVar = new zzuh();
        zzc = zzuhVar;
        zzakg.zza(zzuh.class, zzuhVar);
    }

    private zzuh() {
    }
}
