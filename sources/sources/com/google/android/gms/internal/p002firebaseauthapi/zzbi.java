package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzwl;
import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbi  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzbi {
    public static final byte[] zza = new byte[0];

    public static byte[] zza(zzwl.zza zzaVar) throws GeneralSecurityException {
        int i = zzbh.zza[zzaVar.zzf().ordinal()];
        if (i == 1 || i == 2) {
            return zzor.zza(zzaVar.zza()).zzb();
        }
        if (i != 3) {
            if (i == 4) {
                return zza;
            }
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return zzor.zzb(zzaVar.zza()).zzb();
    }
}
