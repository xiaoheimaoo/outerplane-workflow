package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzme  reason: invalid package */
/* loaded from: classes2.dex */
final class zzme implements zzlo {
    private final zzli zza;
    private final zzmd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzme(zzli zzliVar) {
        zzmd zzmhVar;
        this.zza = zzliVar;
        try {
            zzmhVar = zzmf.zzb();
        } catch (GeneralSecurityException unused) {
            zzmhVar = new zzmh();
        }
        this.zzb = zzmhVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlo
    public final byte[] zza(byte[] bArr, zzlr zzlrVar) throws GeneralSecurityException {
        byte[] zza = this.zzb.zza(zzlrVar.zza().zzb(), bArr);
        byte[] zza2 = zzyc.zza(bArr, zzlrVar.zzb().zzb());
        byte[] zza3 = zzlu.zza(zzlu.zzb);
        zzli zzliVar = this.zza;
        return zzliVar.zza(null, zza, "eae_prk", zza2, "shared_secret", zza3, zzliVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlo
    public final byte[] zza() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzb(), zzlu.zzf)) {
            return zzlu.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
