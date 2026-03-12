package com.google.android.recaptcha.internal;

import java.util.List;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
final class zznv {
    public static final List zza(Object obj, long j) {
        zznk zznkVar = (zznk) zzps.zzf(obj, j);
        if (zznkVar.zzc()) {
            return zznkVar;
        }
        int size = zznkVar.size();
        zznk zzd = zznkVar.zzd(size == 0 ? 10 : size + size);
        zzps.zzs(obj, j, zzd);
        return zzd;
    }
}
