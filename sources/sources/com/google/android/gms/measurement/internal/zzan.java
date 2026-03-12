package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzjj;
import java.util.EnumMap;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
final class zzan {
    private final EnumMap<zzjj.zza, zzam> zza;

    public final zzam zza(zzjj.zza zzaVar) {
        zzam zzamVar = this.zza.get(zzaVar);
        return zzamVar == null ? zzam.UNSET : zzamVar;
    }

    public static zzan zza(String str) {
        EnumMap enumMap = new EnumMap(zzjj.zza.class);
        if (str.length() >= zzjj.zza.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                zzjj.zza[] values = zzjj.zza.values();
                int length = values.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put((EnumMap) values[i], (zzjj.zza) zzam.zza(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new zzan(enumMap);
            }
        }
        return new zzan();
    }

    public final String toString() {
        char c;
        StringBuilder sb = new StringBuilder("1");
        for (zzjj.zza zzaVar : zzjj.zza.values()) {
            zzam zzamVar = this.zza.get(zzaVar);
            if (zzamVar == null) {
                zzamVar = zzam.UNSET;
            }
            c = zzamVar.zzl;
            sb.append(c);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan() {
        this.zza = new EnumMap<>(zzjj.zza.class);
    }

    private zzan(EnumMap<zzjj.zza, zzam> enumMap) {
        EnumMap<zzjj.zza, zzam> enumMap2 = new EnumMap<>(zzjj.zza.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public final void zza(zzjj.zza zzaVar, int i) {
        zzam zzamVar = zzam.UNSET;
        if (i == -30) {
            zzamVar = zzam.TCF;
        } else {
            if (i != -20) {
                if (i == -10) {
                    zzamVar = zzam.MANIFEST;
                } else if (i != 0) {
                    if (i == 30) {
                        zzamVar = zzam.INITIALIZATION;
                    }
                }
            }
            zzamVar = zzam.API;
        }
        this.zza.put((EnumMap<zzjj.zza, zzam>) zzaVar, (zzjj.zza) zzamVar);
    }

    public final void zza(zzjj.zza zzaVar, zzam zzamVar) {
        this.zza.put((EnumMap<zzjj.zza, zzam>) zzaVar, (zzjj.zza) zzamVar);
    }
}
