package com.google.android.gms.internal.p002firebaseauthapi;

import com.helpshift.user.UserConstants;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagi  reason: invalid package */
/* loaded from: classes2.dex */
public enum zzagi {
    REFRESH_TOKEN(UserConstants.REFRESH_TOKEN),
    AUTHORIZATION_CODE("authorization_code");
    
    private final String zzd;

    @Override // java.lang.Enum
    public final String toString() {
        return this.zzd;
    }

    zzagi(String str) {
        this.zzd = str;
    }
}
