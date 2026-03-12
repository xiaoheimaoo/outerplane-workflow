package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmh  reason: invalid package */
/* loaded from: classes2.dex */
final class zzmh implements zzmd {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmd
    public final zzmc zza() throws GeneralSecurityException {
        byte[] zza = zzzl.zza();
        return new zzmc(zza, zzzl.zza(zza));
    }

    private zzmh() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmd
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzzl.zza(bArr, bArr2);
    }
}
