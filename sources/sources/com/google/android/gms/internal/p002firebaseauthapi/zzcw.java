package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcw  reason: invalid package */
/* loaded from: classes2.dex */
final class zzcw implements zzbe {
    private final zzpg<zzbe> zza;
    private final zznv zzb;
    private final zznv zzc;

    private zzcw(zzpg<zzbe> zzpgVar) {
        this.zza = zzpgVar;
        if (zzpgVar.zzf()) {
            zzns zza = zzoj.zzb().zza();
            zznu zza2 = zzny.zza(zzpgVar);
            this.zzb = zza.zza(zza2, "aead", "encrypt");
            this.zzc = zza.zza(zza2, "aead", "decrypt");
            return;
        }
        this.zzb = zzny.zza;
        this.zzc = zzny.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            for (zzpi<zzbe> zzpiVar : this.zza.zza(Arrays.copyOf(bArr, 5))) {
                try {
                    byte[] zza = zzpiVar.zzd().zza(bArr, bArr2);
                    this.zzc.zza(zzpiVar.zza(), bArr.length);
                    return zza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzpi<zzbe> zzpiVar2 : this.zza.zza(zzbi.zza)) {
            try {
                byte[] zza2 = zzpiVar2.zzd().zza(bArr, bArr2);
                this.zzc.zza(zzpiVar2.zza(), bArr.length);
                return zza2;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzc.zza();
        throw new GeneralSecurityException("decryption failed");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            byte[] zzb = this.zza.zzb().zzd().zzb(bArr, bArr2);
            this.zzb.zza(this.zza.zzb().zza(), bArr.length);
            return zzb;
        } catch (GeneralSecurityException e) {
            this.zzb.zza();
            throw e;
        }
    }
}
