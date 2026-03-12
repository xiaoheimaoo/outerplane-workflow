package com.google.android.recaptcha.internal;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
public class zzlc extends zzlb {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlc(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzle) && zzd() == ((zzle) obj).zzd()) {
            if (zzd() == 0) {
                return true;
            }
            if (obj instanceof zzlc) {
                zzlc zzlcVar = (zzlc) obj;
                int zzj = zzj();
                int zzj2 = zzlcVar.zzj();
                if (zzj == 0 || zzj2 == 0 || zzj == zzj2) {
                    int zzd = zzd();
                    if (zzd > zzlcVar.zzd()) {
                        throw new IllegalArgumentException("Length too large: " + zzd + zzd());
                    } else if (zzd <= zzlcVar.zzd()) {
                        if (zzlcVar instanceof zzlc) {
                            byte[] bArr = this.zza;
                            byte[] bArr2 = zzlcVar.zza;
                            zzlcVar.zzc();
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
                        return zzlcVar.zzg(0, zzd).equals(zzg(0, zzd));
                    } else {
                        throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzlcVar.zzd());
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzle
    public byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.recaptcha.internal.zzle
    protected void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    protected final int zzf(int i, int i2, int i3) {
        return zznl.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.recaptcha.internal.zzle
    public final zzle zzg(int i, int i2) {
        int zzi = zzi(0, i2, zzd());
        return zzi == 0 ? zzle.zzb : new zzkz(this.zza, 0, zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzle
    public final void zzh(zzkw zzkwVar) throws IOException {
        ((zzlk) zzkwVar).zzc(this.zza, 0, zzd());
    }
}
