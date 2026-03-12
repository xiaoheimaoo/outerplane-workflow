package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafh  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzafh extends BroadcastReceiver {
    private final String zza;
    private final /* synthetic */ zzafd zzb;

    public zzafh(zzafd zzafdVar, String str) {
        this.zzb = zzafdVar;
        this.zza = str;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        HashMap hashMap;
        Logger logger;
        Logger logger2;
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                hashMap = this.zzb.zzd;
                zzafk zzafkVar = (zzafk) hashMap.get(this.zza);
                if (zzafkVar == null) {
                    logger2 = zzafd.zza;
                    logger2.e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    zzafkVar.zze = zzafd.zza(str);
                    if (zzafkVar.zze == null) {
                        logger = zzafd.zza;
                        logger.e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzae.zzc(zzafkVar.zzd)) {
                        zzafd.zzb(this.zzb, this.zza);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
