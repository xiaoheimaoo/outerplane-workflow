package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwi  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzwi extends zzakg<zzwi, zza> implements zzalp {
    private static final zzwi zzc;
    private static volatile zzalw<zzwi> zzd;
    private int zzg;
    private boolean zzh;
    private String zze = "";
    private String zzf = "";
    private String zzi = "";

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwi$zza */
    /* loaded from: classes2.dex */
    public static final class zza extends zzakg.zzb<zzwi, zza> implements zzalp {
        private zza() {
            super(zzwi.zzc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzwh.zza[i - 1]) {
            case 1:
                return new zzwi();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzwi> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzwi.class) {
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
        zzwi zzwiVar = new zzwi();
        zzc = zzwiVar;
        zzakg.zza(zzwi.class, zzwiVar);
    }

    private zzwi() {
    }
}
