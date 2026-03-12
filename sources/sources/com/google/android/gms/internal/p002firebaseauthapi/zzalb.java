package com.google.android.gms.internal.p002firebaseauthapi;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalb  reason: invalid package */
/* loaded from: classes2.dex */
final class zzalb implements zzamf {
    private static final zzalk zza = new zzala();
    private final zzalk zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final <T> zzamc<T> zza(Class<T> cls) {
        zzame.zza((Class<?>) cls);
        zzall zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            return zzalt.zza(zzame.zza(), zzajz.zza(), zza2.zza());
        }
        return zzalr.zza(cls, zza2, zzalx.zza(), zzakz.zza(), zzame.zza(), zzald.zza[zza2.zzb().ordinal()] != 1 ? zzajz.zza() : null, zzali.zza());
    }

    public zzalb() {
        this(new zzalc(zzakh.zza(), zza));
    }

    private zzalb(zzalk zzalkVar) {
        this.zzb = (zzalk) zzaki.zza(zzalkVar, "messageInfoFactory");
    }
}
