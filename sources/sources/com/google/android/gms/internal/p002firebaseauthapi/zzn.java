package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.regex.Pattern;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzn  reason: invalid package */
/* loaded from: classes2.dex */
final class zzn extends zzl implements Serializable {
    private final Pattern zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzl
    public final zzm zza(CharSequence charSequence) {
        return new zzq(this.zza.matcher(charSequence));
    }

    public final String toString() {
        return this.zza.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(Pattern pattern) {
        this.zza = (Pattern) zzw.zza(pattern);
    }
}
