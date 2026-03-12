package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajh  reason: invalid package */
/* loaded from: classes2.dex */
public class zzajh extends zzaje {
    protected final byte[] zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public byte zza(int i) {
        return this.zzb[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zze() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    protected final int zzb(int i, int i2, int i3) {
        return zzaki.zza(i, this.zzb, zze(), i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public final zzaiw zza(int i, int i2) {
        int zza = zza(0, i2, zzb());
        if (zza == 0) {
            return zzaiw.zza;
        }
        return new zzaja(this.zzb, zze(), zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public final zzaji zzc() {
        return zzaji.zza(this.zzb, zze(), zzb(), true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajh(byte[] bArr) {
        super();
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    protected void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public final void zza(zzaix zzaixVar) throws IOException {
        zzaixVar.zza(this.zzb, zze(), zzb());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaiw
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzaiw) && zzb() == ((zzaiw) obj).zzb()) {
            if (zzb() == 0) {
                return true;
            }
            if (obj instanceof zzajh) {
                zzajh zzajhVar = (zzajh) obj;
                int zza = zza();
                int zza2 = zzajhVar.zza();
                if (zza == 0 || zza2 == 0 || zza == zza2) {
                    return zza(zzajhVar, 0, zzb());
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaje
    final boolean zza(zzaiw zzaiwVar, int i, int i2) {
        if (i2 > zzaiwVar.zzb()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzb());
        } else if (i2 > zzaiwVar.zzb()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzaiwVar.zzb());
        } else if (zzaiwVar instanceof zzajh) {
            zzajh zzajhVar = (zzajh) zzaiwVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzajhVar.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzajhVar.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        } else {
            return zzaiwVar.zza(0, i2).equals(zza(0, i2));
        }
    }
}
