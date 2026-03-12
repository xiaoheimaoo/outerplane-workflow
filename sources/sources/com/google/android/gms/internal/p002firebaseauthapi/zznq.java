package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznq  reason: invalid package */
/* loaded from: classes2.dex */
public final class zznq {
    private HashMap<String, String> zza = new HashMap<>();

    public final zznr zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zznr zznrVar = new zznr(Collections.unmodifiableMap(this.zza));
        this.zza = null;
        return zznrVar;
    }
}
