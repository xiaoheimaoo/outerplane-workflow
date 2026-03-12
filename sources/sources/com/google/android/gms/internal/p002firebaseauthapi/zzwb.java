package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
import kotlin.text.Typography;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwb  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzwb extends zzakg<zzwb, zzb> implements zzalp {
    private static final zzwb zzc;
    private static volatile zzalw<zzwb> zzd;
    private String zze = "";
    private zzaiw zzf = zzaiw.zza;
    private int zzg;

    public static zzb zza() {
        return zzc.zzm();
    }

    public final zza zzb() {
        zza zza2 = zza.zza(this.zzg);
        return zza2 == null ? zza.UNRECOGNIZED : zza2;
    }

    /* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwb$zzb */
    /* loaded from: classes2.dex */
    public static final class zzb extends zzakg.zzb<zzwb, zzb> implements zzalp {
        public final zzb zza(zza zzaVar) {
            zzg();
            zzwb.zza((zzwb) this.zza, zzaVar);
            return this;
        }

        public final zzb zza(String str) {
            zzg();
            zzwb.zza((zzwb) this.zza, str);
            return this;
        }

        public final zzb zza(zzaiw zzaiwVar) {
            zzg();
            zzwb.zza((zzwb) this.zza, zzaiwVar);
            return this;
        }

        private zzb() {
            super(zzwb.zzc);
        }
    }

    public static zzwb zzd() {
        return zzc;
    }

    public final zzaiw zze() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzwa.zza[i - 1]) {
            case 1:
                return new zzwb();
            case 2:
                return new zzb();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzwb> zzalwVar = zzd;
                if (zzalwVar == null) {
                    synchronized (zzwb.class) {
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
    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwb$zza */
    /* loaded from: classes2.dex */
    public enum zza implements zzakl {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private final int zzh;

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakl
        public final int zza() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.zzh;
        }

        public static zza zza(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return REMOTE;
                        }
                        return ASYMMETRIC_PUBLIC;
                    }
                    return ASYMMETRIC_PRIVATE;
                }
                return SYMMETRIC;
            }
            return UNKNOWN_KEYMATERIAL;
        }

        @Override // java.lang.Enum
        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=").append(zza());
            }
            return sb.append(" name=").append(name()).append(Typography.greater).toString();
        }

        zza(int i) {
            this.zzh = i;
        }
    }

    public final String zzf() {
        return this.zze;
    }

    static /* synthetic */ void zza(zzwb zzwbVar, zza zzaVar) {
        zzwbVar.zzg = zzaVar.zza();
    }

    static /* synthetic */ void zza(zzwb zzwbVar, String str) {
        str.getClass();
        zzwbVar.zze = str;
    }

    static /* synthetic */ void zza(zzwb zzwbVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzwbVar.zzf = zzaiwVar;
    }

    static {
        zzwb zzwbVar = new zzwb();
        zzc = zzwbVar;
        zzakg.zza(zzwb.class, zzwbVar);
    }

    private zzwb() {
    }
}
