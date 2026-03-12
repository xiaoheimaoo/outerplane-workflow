package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmb  reason: invalid package */
/* loaded from: classes2.dex */
final class zzmb implements zzlo {
    private final zzyl zza;
    private final zzli zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmb zza(zzyl zzylVar) throws GeneralSecurityException {
        int i = zzma.zza[zzylVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new zzmb(new zzli("HmacSha512"), zzyl.NIST_P521);
                }
                throw new GeneralSecurityException("invalid curve type: " + String.valueOf(zzylVar));
            }
            return new zzmb(new zzli("HmacSha384"), zzyl.NIST_P384);
        }
        return new zzmb(new zzli("HmacSha256"), zzyl.NIST_P256);
    }

    private zzmb(zzli zzliVar, zzyl zzylVar) {
        this.zzb = zzliVar;
        this.zza = zzylVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlo
    public final byte[] zza(byte[] bArr, zzlr zzlrVar) throws GeneralSecurityException {
        byte[] zza = zzyi.zza(zzyi.zza(this.zza, zzlrVar.zza().zzb()), zzyi.zza(zzyi.zza(this.zza), zzyk.UNCOMPRESSED, bArr));
        byte[] zza2 = zzyc.zza(bArr, zzlrVar.zzb().zzb());
        byte[] zza3 = zzlu.zza(zza());
        zzli zzliVar = this.zzb;
        return zzliVar.zza(null, zza, "eae_prk", zza2, "shared_secret", zza3, zzliVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlo
    public final byte[] zza() throws GeneralSecurityException {
        int i = zzma.zza[this.zza.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return zzlu.zze;
                }
                throw new GeneralSecurityException("Could not determine HPKE KEM ID");
            }
            return zzlu.zzd;
        }
        return zzlu.zzc;
    }
}
