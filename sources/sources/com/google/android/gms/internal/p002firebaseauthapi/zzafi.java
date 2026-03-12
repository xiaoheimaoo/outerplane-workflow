package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafi  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzafi extends zzadp {
    private final String zza;
    private final /* synthetic */ zzafd zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzafi(zzafd zzafdVar, zzadp zzadpVar, String str) {
        super(zzadpVar);
        this.zzb = zzafdVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadp
    public final void zzb(String str) {
        Logger logger;
        HashMap hashMap;
        logger = zzafd.zza;
        logger.d("onCodeSent", new Object[0]);
        hashMap = this.zzb.zzd;
        zzafk zzafkVar = (zzafk) hashMap.get(this.zza);
        if (zzafkVar == null) {
            return;
        }
        for (zzadp zzadpVar : zzafkVar.zzb) {
            zzadpVar.zzb(str);
        }
        zzafkVar.zzg = true;
        zzafkVar.zzd = str;
        if (zzafkVar.zza <= 0) {
            this.zzb.zze(this.zza);
        } else if (!zzafkVar.zzc) {
            this.zzb.zzd(this.zza);
        } else if (!zzae.zzc(zzafkVar.zze)) {
            zzafd.zzb(this.zzb, this.zza);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadp
    public final void zza(Status status) {
        Logger logger;
        HashMap hashMap;
        logger = zzafd.zza;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(status.getStatusCode());
        logger.e("SMS verification code request failed: " + statusCodeString + " " + status.getStatusMessage(), new Object[0]);
        hashMap = this.zzb.zzd;
        zzafk zzafkVar = (zzafk) hashMap.get(this.zza);
        if (zzafkVar == null) {
            return;
        }
        for (zzadp zzadpVar : zzafkVar.zzb) {
            zzadpVar.zza(status);
        }
        this.zzb.zzb(this.zza);
    }
}
