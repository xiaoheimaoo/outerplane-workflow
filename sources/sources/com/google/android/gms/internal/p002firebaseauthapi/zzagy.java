package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.singular.sdk.internal.Constants;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagy  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzagy {
    public static long zza(String str) {
        zzagx zzb = zzb(str);
        return zzb.zza().longValue() - zzb.zzb().longValue();
    }

    private static zzagx zzb(String str) {
        Preconditions.checkNotEmpty(str);
        List<String> zza = zzv.zza('.').zza((CharSequence) str);
        if (zza.size() < 2) {
            throw new RuntimeException("Invalid idToken " + str);
        }
        try {
            return zzagx.zza(new String(Base64Utils.decodeUrlSafeNoPadding(zza.get(1)), Constants.ENCODING));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to decode token", e);
        }
    }
}
