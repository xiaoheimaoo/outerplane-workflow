package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaek  reason: invalid package */
/* loaded from: classes2.dex */
final class zzaek implements zzaen {
    private final /* synthetic */ String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaek(zzaei zzaeiVar, String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaen
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeSent(this.zza, PhoneAuthProvider.ForceResendingToken.zza());
    }
}
