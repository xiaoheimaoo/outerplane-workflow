package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcm  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzcm {
    private static final zzcm zza = new zzcm();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcm zza() {
        return zza;
    }

    public static zzcm zza(@Nullable zzcm zzcmVar) throws GeneralSecurityException {
        if (zzcmVar != null) {
            return zzcmVar;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }

    private zzcm() {
    }
}
