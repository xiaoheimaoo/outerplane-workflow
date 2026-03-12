package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.regex.Matcher;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzq  reason: invalid package */
/* loaded from: classes2.dex */
final class zzq extends zzm {
    private final Matcher zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final int zza() {
        return this.zza.end();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final int zzb() {
        return this.zza.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(Matcher matcher) {
        this.zza = (Matcher) zzw.zza(matcher);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final boolean zza(int i) {
        return this.zza.find(i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final boolean zzc() {
        return this.zza.matches();
    }
}
