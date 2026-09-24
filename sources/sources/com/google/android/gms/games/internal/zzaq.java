package com.google.android.gms.games.internal;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public final class zzaq {
    private static final zzaq zza = new zzaq();
    private volatile boolean zzb = false;

    zzaq() {
    }

    public static zzaq zza() {
        return zza;
    }

    public final boolean zzb() {
        return this.zzb;
    }

    public final void zzc() {
        this.zzb = true;
    }
}
