package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.OnFailureListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaff  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzaff implements OnFailureListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaff(zzafd zzafdVar) {
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Logger logger;
        logger = zzafd.zza;
        logger.e("SmsRetrieverClient failed to start: " + exc.getMessage(), new Object[0]);
    }
}
