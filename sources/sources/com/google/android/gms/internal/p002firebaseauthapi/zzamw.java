package com.google.android.gms.internal.p002firebaseauthapi;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamw  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzamw extends RuntimeException {
    public final zzakm zza() {
        return new zzakm(getMessage());
    }

    public zzamw(zzaln zzalnVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
