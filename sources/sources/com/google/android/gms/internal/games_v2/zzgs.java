package com.google.android.gms.internal.games_v2;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
public final class zzgs {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzgr zzc;

    public final zzgs zza(Object obj, Object obj2) {
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzgl.zza(length, i2));
        }
        zzgi.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i3 = this.zzb;
        int i4 = i3 + i3;
        objArr2[i4] = obj;
        objArr2[i4 + 1] = obj2;
        this.zzb = i3 + 1;
        return this;
    }

    public final zzgt zzb() {
        zzgr zzgrVar = this.zzc;
        if (zzgrVar != null) {
            throw zzgrVar.zza();
        }
        zzhb zzd = zzhb.zzd(this.zzb, this.zza, this);
        zzgr zzgrVar2 = this.zzc;
        if (zzgrVar2 == null) {
            return zzd;
        }
        throw zzgrVar2.zza();
    }
}
