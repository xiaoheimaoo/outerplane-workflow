package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.regex.Pattern;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzu  reason: invalid package */
/* loaded from: classes2.dex */
final class zzu implements zzs {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzs
    public final zzl zza(String str) {
        return new zzn(Pattern.compile(str));
    }

    private zzu() {
    }
}
