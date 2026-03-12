package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjq;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzye  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzye implements zzbj {
    private final ECPrivateKey zza;
    private final zzyg zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzyk zze;
    private final zzla zzf;
    private final byte[] zzg;

    public static zzbj zza(zzjt zzjtVar) throws GeneralSecurityException {
        ECPrivateKey zza = zzyi.zza(zzyh.zza.zza((zzmv<zzyl, zzjq.zza>) zzjtVar.zzc().zzd()), zzmo.zza(zzjtVar.zze().zza(zzbl.zza())));
        byte[] bArr = new byte[0];
        if (zzjtVar.zzc().zzh() != null) {
            bArr = zzjtVar.zzc().zzh().zzb();
        }
        return new zzye(zza, bArr, zzyh.zza(zzjtVar.zzc().zze()), zzyh.zzb.zza((zzmv<zzyk, zzjq.zzc>) zzjtVar.zzc().zzf()), zzkw.zza(zzjtVar.zzc()), zzjtVar.zzg().zzb());
    }

    private zzye(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzyk zzykVar, zzla zzlaVar, byte[] bArr2) {
        this.zza = eCPrivateKey;
        this.zzb = new zzyg(eCPrivateKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zze = zzykVar;
        this.zzf = zzlaVar;
        this.zzg = bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] zza(byte[] r11, byte[] r12) throws java.security.GeneralSecurityException {
        /*
            r10 = this;
            byte[] r0 = r10.zzg
            boolean r0 = com.google.android.gms.internal.p002firebaseauthapi.zzpy.zza(r0, r11)
            if (r0 == 0) goto L5d
            byte[] r0 = r10.zzg
            int r0 = r0.length
            java.security.interfaces.ECPrivateKey r1 = r10.zza
            java.security.spec.ECParameterSpec r1 = r1.getParams()
            java.security.spec.EllipticCurve r1 = r1.getCurve()
            com.google.android.gms.internal.firebase-auth-api.zzyk r2 = r10.zze
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzyi.zza(r1)
            int r2 = r2.ordinal()
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L31
            if (r2 == r4) goto L32
            if (r2 != r3) goto L29
            int r1 = r1 * r3
            goto L33
        L29:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "unknown EC point format"
            r11.<init>(r12)
            throw r11
        L31:
            int r1 = r1 * r3
        L32:
            int r1 = r1 + r4
        L33:
            int r2 = r11.length
            int r1 = r1 + r0
            if (r2 < r1) goto L55
            byte[] r4 = java.util.Arrays.copyOfRange(r11, r0, r1)
            com.google.android.gms.internal.firebase-auth-api.zzyg r3 = r10.zzb
            java.lang.String r5 = r10.zzc
            byte[] r6 = r10.zzd
            com.google.android.gms.internal.firebase-auth-api.zzla r0 = r10.zzf
            int r8 = r0.zza()
            com.google.android.gms.internal.firebase-auth-api.zzyk r9 = r10.zze
            r7 = r12
            byte[] r12 = r3.zza(r4, r5, r6, r7, r8, r9)
            com.google.android.gms.internal.firebase-auth-api.zzla r0 = r10.zzf
            byte[] r11 = r0.zza(r12, r11, r1)
            return r11
        L55:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "ciphertext too short"
            r11.<init>(r12)
            throw r11
        L5d:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r12 = "Invalid ciphertext (output prefix mismatch)"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzye.zza(byte[], byte[]):byte[]");
    }
}
