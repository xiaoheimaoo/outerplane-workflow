package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzwb;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzej  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzej implements zzbe {
    private static final byte[] zza = new byte[0];
    private static final Set<String> zzb;
    private final String zzc;
    private final zzcg zzd;
    private final zzbe zze;

    public static zzbe zza(zzcr zzcrVar, zzbe zzbeVar) throws GeneralSecurityException {
        try {
            return new zzej(zzwf.zza(zzco.zza(zzcrVar), zzajv.zza()), zzbeVar);
        } catch (zzakm e) {
            throw new GeneralSecurityException(e);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    private zzej(zzwf zzwfVar, zzbe zzbeVar) throws GeneralSecurityException {
        if (!zzb.contains(zzwfVar.zzf())) {
            throw new IllegalArgumentException("Unsupported DEK key type: " + zzwfVar.zzf() + ". Only Tink AEAD key types are supported.");
        }
        this.zzc = zzwfVar.zzf();
        this.zzd = zzco.zza(((zzwf) ((zzakg) zzwf.zza(zzwfVar).zza(zzxd.RAW).zze())).zzk());
        this.zze = zzbeVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i <= 0 || i > 4096 || i > bArr.length - 4) {
                throw new GeneralSecurityException("length of encrypted DEK too large");
            }
            byte[] bArr3 = new byte[i];
            wrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            return ((zzbe) zzon.zza().zza((zzon) zzom.zza().zza((zzom) zzpn.zza(this.zzc, zzaiw.zza(this.zze.zza(bArr3, zza)), zzwb.zza.SYMMETRIC, zzxd.RAW, null), zzbl.zza()), (Class<Object>) zzbe.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzbo zza2 = zzoc.zza().zza(this.zzd, (Integer) null);
        byte[] zzb2 = this.zze.zzb(((zzpn) zzom.zza().zza(zza2, zzpn.class, zzbl.zza())).zzd().zzd(), zza);
        if (zzb2.length > 4096) {
            throw new GeneralSecurityException("length of encrypted DEK too large");
        }
        byte[] zzb3 = ((zzbe) zzon.zza().zza((zzon) zza2, (Class<Object>) zzbe.class)).zzb(bArr, bArr2);
        return ByteBuffer.allocate(zzb2.length + 4 + zzb3.length).putInt(zzb2.length).put(zzb2).put(zzb3).array();
    }
}
