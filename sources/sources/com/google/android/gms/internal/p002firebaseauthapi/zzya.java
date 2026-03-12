package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzij;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzya  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzya implements zzbk {
    private static final zzij.zza zza = zzij.zza.zza;
    private static final Collection<Integer> zzb = Arrays.asList(64);
    private static final byte[] zzc = new byte[16];
    private static final ThreadLocal<Cipher> zzd = new zzyd();
    private final zzzc zze;
    private final byte[] zzf;
    private final byte[] zzg;

    public static zzbk zza(zzio zzioVar) throws GeneralSecurityException {
        return new zzya(zzioVar.zze().zza(zzbl.zza()), zzioVar.zzd());
    }

    private zzya(byte[] bArr, zzzn zzznVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (!zzb.contains(Integer.valueOf(bArr.length))) {
            throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
        this.zzf = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
        this.zze = new zzzc(copyOfRange);
        this.zzg = zzznVar.zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbk
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2;
        int length = bArr.length;
        byte[] bArr3 = this.zzg;
        if (length < bArr3.length + 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        if (!zzpy.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        Cipher cipher = zzd.get();
        byte[] bArr4 = this.zzg;
        byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr4.length, bArr4.length + 16);
        byte[] bArr5 = (byte[]) copyOfRange.clone();
        bArr5[8] = (byte) (bArr5[8] & Byte.MAX_VALUE);
        bArr5[12] = (byte) (bArr5[12] & Byte.MAX_VALUE);
        cipher.init(2, new SecretKeySpec(this.zzf, "AES"), new IvParameterSpec(bArr5));
        int length2 = this.zzg.length + 16;
        int length3 = bArr.length - length2;
        byte[] doFinal = cipher.doFinal(bArr, length2, length3);
        if (length3 == 0 && doFinal == null && zzzj.zza()) {
            doFinal = new byte[0];
        }
        byte[][] bArr6 = {bArr2, doFinal};
        byte[] zza3 = this.zze.zza(zzc, 16);
        for (int i = 0; i <= 0; i++) {
            byte[] bArr7 = bArr6[i];
            if (bArr7 == null) {
                bArr7 = new byte[0];
            }
            zza3 = zzyc.zza(zzrn.zzb(zza3), this.zze.zza(bArr7, 16));
        }
        byte[] bArr8 = bArr6[1];
        if (bArr8.length >= 16) {
            if (bArr8.length < zza3.length) {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            int length4 = bArr8.length - zza3.length;
            zza2 = Arrays.copyOf(bArr8, bArr8.length);
            for (int i2 = 0; i2 < zza3.length; i2++) {
                int i3 = length4 + i2;
                zza2[i3] = (byte) (zza2[i3] ^ zza3[i2]);
            }
        } else {
            zza2 = zzyc.zza(zzrn.zza(bArr8), zzrn.zzb(zza3));
        }
        if (MessageDigest.isEqual(copyOfRange, this.zze.zza(zza2, 16))) {
            return doFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }
}
