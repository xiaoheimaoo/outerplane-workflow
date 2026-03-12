package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzm  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzzm {
    private final BigInteger zza;

    public static zzzm zza(BigInteger bigInteger, zzcm zzcmVar) {
        if (zzcmVar == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return new zzzm(bigInteger);
    }

    public final BigInteger zza(zzcm zzcmVar) {
        if (zzcmVar == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return this.zza;
    }

    private zzzm(BigInteger bigInteger) {
        this.zza = bigInteger;
    }
}
