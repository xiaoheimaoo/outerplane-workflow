package com.google.android.gms.internal.play_billing;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public class zzgi extends zzgh {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgi(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgk
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzgk) && zzd() == ((zzgk) obj).zzd()) {
            if (zzd() == 0) {
                return true;
            }
            if (obj instanceof zzgi) {
                zzgi zzgiVar = (zzgi) obj;
                int zzi = zzi();
                int zzi2 = zzgiVar.zzi();
                if (zzi == 0 || zzi2 == 0 || zzi == zzi2) {
                    int zzd = zzd();
                    if (zzd > zzgiVar.zzd()) {
                        throw new IllegalArgumentException("Length too large: " + zzd + zzd());
                    } else if (zzd <= zzgiVar.zzd()) {
                        if (zzgiVar instanceof zzgi) {
                            byte[] bArr = this.zza;
                            byte[] bArr2 = zzgiVar.zza;
                            zzgiVar.zzc();
                            int i = 0;
                            int i2 = 0;
                            while (i < zzd) {
                                if (bArr[i] != bArr2[i2]) {
                                    return false;
                                }
                                i++;
                                i2++;
                            }
                            return true;
                        }
                        return zzgiVar.zzf(0, zzd).equals(zzf(0, zzd));
                    } else {
                        throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzgiVar.zzd());
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgk
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzgk
    public byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgk
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgk
    protected final int zze(int i, int i2, int i3) {
        return zzhp.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgk
    public final zzgk zzf(int i, int i2) {
        int zzh = zzh(0, i2, zzd());
        return zzh == 0 ? zzgk.zzb : new zzgf(this.zza, 0, zzh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzgk
    public final void zzg(zzgc zzgcVar) throws IOException {
        ((zzgo) zzgcVar).zzc(this.zza, 0, zzd());
    }
}
