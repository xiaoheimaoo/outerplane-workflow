package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzjd {
    private final zzjn zza;
    private final byte[] zzb;

    public final zziy zza() {
        this.zza.zzb();
        return new zzjf(this.zzb);
    }

    public final zzjn zzb() {
        return this.zza;
    }

    private zzjd(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzjn.zzb(bArr);
    }
}
