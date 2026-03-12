package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzco  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzco {
    public static zzcg zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzwf zza = zzwf.zza(bArr, zzajv.zza());
            zzom zza2 = zzom.zza();
            zzpm zza3 = zzpm.zza(zza);
            if (!zza2.zzc(zza3)) {
                return new zznp(zza3);
            }
            return zza2.zza((zzom) zza3);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zza(zzcg zzcgVar) throws GeneralSecurityException {
        if (zzcgVar instanceof zznp) {
            return ((zznp) zzcgVar).zzb().zza().zzk();
        }
        return ((zzpm) zzom.zza().zza((zzom) zzcgVar, (Class<zzpq>) zzpm.class)).zza().zzk();
    }
}
