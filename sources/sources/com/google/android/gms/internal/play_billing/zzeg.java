package com.google.android.gms.internal.play_billing;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
public class zzeg extends zzef {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeg(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzei) && zzd() == ((zzei) obj).zzd()) {
            if (zzd() == 0) {
                return true;
            }
            if (obj instanceof zzeg) {
                zzeg zzegVar = (zzeg) obj;
                int zzi = zzi();
                int zzi2 = zzegVar.zzi();
                if (zzi == 0 || zzi2 == 0 || zzi == zzi2) {
                    int zzd = zzd();
                    if (zzd > zzegVar.zzd()) {
                        throw new IllegalArgumentException("Length too large: " + zzd + zzd());
                    } else if (zzd <= zzegVar.zzd()) {
                        if (zzegVar instanceof zzeg) {
                            byte[] bArr = this.zza;
                            byte[] bArr2 = zzegVar.zza;
                            zzegVar.zzc();
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
                        return zzegVar.zzf(0, zzd).equals(zzf(0, zzd));
                    } else {
                        throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzegVar.zzd());
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzei
    public byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    protected final int zze(int i, int i2, int i3) {
        return zzfo.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public final zzei zzf(int i, int i2) {
        int zzh = zzh(0, i2, zzd());
        return zzh == 0 ? zzei.zzb : new zzec(this.zza, 0, zzh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzei
    public final void zzg(zzdz zzdzVar) throws IOException {
        ((zzem) zzdzVar).zzc(this.zza, 0, zzd());
    }
}
