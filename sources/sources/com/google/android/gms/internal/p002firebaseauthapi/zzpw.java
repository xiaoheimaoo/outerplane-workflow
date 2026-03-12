package com.google.android.gms.internal.p002firebaseauthapi;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpw  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzpw extends RuntimeException {
    public static <T> T zza(zzpz<T> zzpzVar) {
        try {
            return zzpzVar.zza();
        } catch (Exception e) {
            throw new zzpw(e);
        }
    }

    public zzpw(String str) {
        super(str);
    }

    private zzpw(Throwable th) {
        super(th);
    }

    public zzpw(String str, Throwable th) {
        super(str, th);
    }
}
