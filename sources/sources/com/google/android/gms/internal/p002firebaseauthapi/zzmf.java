package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmf  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzmf implements zzmd {
    private static final byte[] zza = {48, 46, 2, 1, 0, 48, 5, 6, 3, 43, 101, 110, 4, 34, 4, 32};
    private static final byte[] zzb = {48, 42, 48, 5, 6, 3, 43, 101, 110, 3, 33, 0};
    private final Provider zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmd
    public final zzmc zza() throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("XDH", this.zzc);
        keyPairGenerator.initialize(255);
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        byte[] encoded = generateKeyPair.getPrivate().getEncoded();
        int length = encoded.length;
        byte[] bArr = zza;
        if (length != bArr.length + 32) {
            throw new GeneralSecurityException("Invalid encoded private key length");
        }
        if (!zzpy.zza(bArr, encoded)) {
            throw new GeneralSecurityException("Invalid encoded private key prefix");
        }
        byte[] copyOfRange = Arrays.copyOfRange(encoded, bArr.length, encoded.length);
        byte[] encoded2 = generateKeyPair.getPublic().getEncoded();
        int length2 = encoded2.length;
        byte[] bArr2 = zzb;
        if (length2 != bArr2.length + 32) {
            throw new GeneralSecurityException("Invalid encoded public key length");
        }
        if (!zzpy.zza(bArr2, encoded2)) {
            throw new GeneralSecurityException("Invalid encoded public key prefix");
        }
        return new zzmc(copyOfRange, Arrays.copyOfRange(encoded2, bArr2.length, encoded2.length));
    }

    public static zzmd zzb() throws GeneralSecurityException {
        Provider zza2 = zzmr.zza();
        if (zza2 == null) {
            throw new GeneralSecurityException("Conscrypt is not available.");
        }
        KeyFactory.getInstance("XDH", zza2);
        KeyAgreement.getInstance("XDH", zza2);
        zzmf zzmfVar = new zzmf(zza2);
        zzmfVar.zza();
        return zzmfVar;
    }

    private zzmf(Provider provider) {
        this.zzc = provider;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmd
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        KeyFactory keyFactory = KeyFactory.getInstance("XDH", this.zzc);
        if (bArr.length != 32) {
            throw new InvalidKeyException("Invalid X25519 private key");
        }
        PrivateKey generatePrivate = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(zzyc.zza(zza, bArr)));
        if (bArr2.length != 32) {
            throw new InvalidKeyException("Invalid X25519 public key");
        }
        PublicKey generatePublic = keyFactory.generatePublic(new X509EncodedKeySpec(zzyc.zza(zzb, bArr2)));
        KeyAgreement keyAgreement = KeyAgreement.getInstance("XDH", this.zzc);
        keyAgreement.init(generatePrivate);
        keyAgreement.doPhase(generatePublic, true);
        return keyAgreement.generateSecret();
    }
}
