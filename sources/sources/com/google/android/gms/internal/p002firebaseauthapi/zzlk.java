package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlk  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzlk {
    private static final byte[] zza = new byte[0];
    private final zzll zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private BigInteger zzf = BigInteger.ZERO;

    public static zzlk zza(byte[] bArr, zzlr zzlrVar, zzlo zzloVar, zzlp zzlpVar, zzll zzllVar, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2 = zzloVar.zza(bArr, zzlrVar);
        byte[] bArr3 = zzlu.zza;
        byte[] zza3 = zzlu.zza(zzloVar.zza(), zzlpVar.zzb(), zzllVar.zzc());
        byte[] bArr4 = zzlu.zzl;
        byte[] bArr5 = zza;
        byte[] zza4 = zzyc.zza(bArr3, zzlpVar.zza(bArr4, bArr5, "psk_id_hash", zza3), zzlpVar.zza(zzlu.zzl, bArr2, "info_hash", zza3));
        byte[] zza5 = zzlpVar.zza(zza2, bArr5, "secret", zza3);
        byte[] zza6 = zzlpVar.zza(zza5, zza4, "key", zza3, zzllVar.zza());
        byte[] zza7 = zzlpVar.zza(zza5, zza4, "base_nonce", zza3, zzllVar.zzb());
        zzllVar.zzb();
        return new zzlk(bArr, zza6, zza7, BigInteger.ONE.shiftLeft(96).subtract(BigInteger.ONE), zzllVar);
    }

    private zzlk(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zzll zzllVar) {
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzllVar;
    }

    private final synchronized byte[] zza() throws GeneralSecurityException {
        byte[] zza2;
        zza2 = zzyc.zza(this.zze, zzmo.zza(this.zzf, this.zzb.zzb()));
        if (this.zzf.compareTo(this.zzc) >= 0) {
            throw new GeneralSecurityException("message limit reached");
        }
        this.zzf = this.zzf.add(BigInteger.ONE);
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zza(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zza(this.zzd, zza(), bArr, i, bArr2);
    }
}
