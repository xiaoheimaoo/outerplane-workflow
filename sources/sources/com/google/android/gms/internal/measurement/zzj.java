package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzj {
    public static zzaq zza(zzgr.zzd zzdVar) {
        if (zzdVar == null) {
            return zzaq.zzc;
        }
        int i = zzi.zza[zzdVar.zzb().ordinal()];
        if (i == 1) {
            if (zzdVar.zzj()) {
                return new zzas(zzdVar.zze());
            }
            return zzaq.zzj;
        } else if (i == 2) {
            if (zzdVar.zzi()) {
                return new zzai(Double.valueOf(zzdVar.zza()));
            }
            return new zzai(null);
        } else if (i == 3) {
            if (zzdVar.zzh()) {
                return new zzag(Boolean.valueOf(zzdVar.zzg()));
            }
            return new zzag(null);
        } else if (i == 4) {
            List<zzgr.zzd> zzf = zzdVar.zzf();
            ArrayList arrayList = new ArrayList();
            for (zzgr.zzd zzdVar2 : zzf) {
                arrayList.add(zza(zzdVar2));
            }
            return new zzat(zzdVar.zzd(), arrayList);
        } else {
            if (i == 5) {
                throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
            }
            throw new IllegalStateException("Invalid entity: " + String.valueOf(zzdVar));
        }
    }

    public static zzaq zza(Object obj) {
        if (obj == null) {
            return zzaq.zzd;
        }
        if (obj instanceof String) {
            return new zzas((String) obj);
        }
        if (obj instanceof Double) {
            return new zzai((Double) obj);
        }
        if (obj instanceof Long) {
            return new zzai(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzai(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new zzag((Boolean) obj);
        }
        if (obj instanceof Map) {
            zzap zzapVar = new zzap();
            Map map = (Map) obj;
            for (Object obj2 : map.keySet()) {
                zzaq zza = zza(map.get(obj2));
                if (obj2 != null) {
                    if (!(obj2 instanceof String)) {
                        obj2 = obj2.toString();
                    }
                    zzapVar.zza((String) obj2, zza);
                }
            }
            return zzapVar;
        } else if (obj instanceof List) {
            zzaf zzafVar = new zzaf();
            for (Object obj3 : (List) obj) {
                zzafVar.zza(zza(obj3));
            }
            return zzafVar;
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }
}
