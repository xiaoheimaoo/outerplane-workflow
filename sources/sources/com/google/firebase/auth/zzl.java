package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzabq;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* loaded from: classes3.dex */
public final class zzl implements OnCompleteListener<com.google.firebase.auth.internal.zzj> {
    private final /* synthetic */ PhoneAuthOptions zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ FirebaseAuth zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zza = phoneAuthOptions;
        this.zzb = str;
        this.zzc = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<com.google.firebase.auth.internal.zzj> task) {
        String zzd;
        String zzb;
        String zzc;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zza;
        zzabq zzabqVar;
        String str;
        zzabq zzabqVar2;
        String str2;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            Log.e("FirebaseAuth", exception != null ? "Error while validating application identity: " + exception.getMessage() : "Error while validating application identity: ");
            if (exception != null && com.google.firebase.auth.internal.zzb.zza(exception)) {
                FirebaseAuth.zza((FirebaseException) exception, this.zza, this.zzb);
                return;
            }
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            zzc = null;
            zzd = null;
            zzb = null;
        } else {
            zzd = task.getResult().zzd();
            zzb = task.getResult().zzb();
            zzc = task.getResult().zzc();
        }
        long longValue = this.zza.zzg().longValue();
        zza = this.zzc.zza(this.zza.zzh(), this.zza.zze());
        if (TextUtils.isEmpty(zzd)) {
            zza = this.zzc.zza(this.zza, zza, task.getResult());
        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = zza;
        com.google.firebase.auth.internal.zzam zzamVar = (com.google.firebase.auth.internal.zzam) Preconditions.checkNotNull(this.zza.zzc());
        if (com.google.android.gms.internal.p002firebaseauthapi.zzae.zzc(zzc) && this.zzc.zzb() != null && this.zzc.zzb().zza("PHONE_PROVIDER")) {
            zzc = "NO_RECAPTCHA";
        }
        String str3 = zzc;
        if (zzamVar.zzd()) {
            zzabqVar2 = this.zzc.zze;
            String str4 = (String) Preconditions.checkNotNull(this.zza.zzh());
            str2 = this.zzc.zzi;
            zzabqVar2.zza(zzamVar, str4, str2, longValue, this.zza.zzd() != null, this.zza.zzk(), zzd, zzb, str3, this.zzc.zzi(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
            return;
        }
        zzabqVar = this.zzc.zze;
        PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(this.zza.zzf());
        str = this.zzc.zzi;
        zzabqVar.zza(zzamVar, phoneMultiFactorInfo, str, longValue, this.zza.zzd() != null, this.zza.zzk(), zzd, zzb, str3, this.zzc.zzi(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
    }
}
