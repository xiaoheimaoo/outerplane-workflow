package com.google.android.gms.internal.games_v2;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
public final class zzgn extends zzgk {
    public zzgn() {
        super(4);
    }

    public final zzgq zzc() {
        this.zzc = true;
        return zzgq.zzj(this.zza, this.zzb);
    }

    public final zzgn zzb(Object obj) {
        obj.getClass();
        int length = this.zza.length;
        int zza = zzgk.zza(length, this.zzb + 1);
        if (zza > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, zza);
            this.zzc = false;
        }
        Object[] objArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr[i] = obj;
        return this;
    }
}
