package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzarp extends zzhgm {
    private Date zza;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk;
    private float zzl;
    private zzhgw zzm;
    private long zzn;

    public zzarp() {
        super("mvhd");
        this.zzk = 1.0d;
        this.zzl = 1.0f;
        this.zzm = zzhgw.zza;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zza + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzd() {
        return this.zzj;
    }

    public final long zze() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzhgk
    public final void zzf(ByteBuffer byteBuffer) {
        zzi(byteBuffer);
        if (zzh() == 1) {
            this.zza = zzhgr.zza(zzarl.zzf(byteBuffer));
            this.zzh = zzhgr.zza(zzarl.zzf(byteBuffer));
            this.zzi = zzarl.zze(byteBuffer);
            this.zzj = zzarl.zzf(byteBuffer);
        } else {
            this.zza = zzhgr.zza(zzarl.zze(byteBuffer));
            this.zzh = zzhgr.zza(zzarl.zze(byteBuffer));
            this.zzi = zzarl.zze(byteBuffer);
            this.zzj = zzarl.zze(byteBuffer);
        }
        this.zzk = zzarl.zzb(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzl = ((short) ((bArr[1] & 255) | ((short) (65280 & (bArr[0] << 8))))) / 256.0f;
        zzarl.zzd(byteBuffer);
        zzarl.zze(byteBuffer);
        zzarl.zze(byteBuffer);
        double zzb = zzarl.zzb(byteBuffer);
        double zzb2 = zzarl.zzb(byteBuffer);
        double zza = zzarl.zza(byteBuffer);
        this.zzm = new zzhgw(zzb, zzb2, zzarl.zzb(byteBuffer), zzarl.zzb(byteBuffer), zza, zzarl.zza(byteBuffer), zzarl.zza(byteBuffer), zzarl.zzb(byteBuffer), zzarl.zzb(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzarl.zze(byteBuffer);
    }
}
