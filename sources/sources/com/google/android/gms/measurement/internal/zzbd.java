package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzjj;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzbd {
    private static final zzbd zza = new zzbd(null, 100);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap<zzjj.zza, zzjm> zzf;

    public final int zza() {
        return this.zzb;
    }

    public final int hashCode() {
        int i;
        Boolean bool = this.zzd;
        if (bool == null) {
            i = 3;
        } else {
            i = bool == Boolean.TRUE ? 7 : 13;
        }
        String str = this.zze;
        return this.zzc.hashCode() + (i * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry<zzjj.zza, zzjm> entry : this.zzf.entrySet()) {
            String zzb = zzjj.zzb(entry.getValue());
            if (zzb != null) {
                bundle.putString(entry.getKey().zze, zzb);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public static zzbd zza(Bundle bundle, int i) {
        zzjj.zza[] zza2;
        if (bundle == null) {
            return new zzbd(null, i);
        }
        EnumMap enumMap = new EnumMap(zzjj.zza.class);
        for (zzjj.zza zzaVar : zzjl.DMA.zza()) {
            enumMap.put((EnumMap) zzaVar, (zzjj.zza) zzjj.zza(bundle.getString(zzaVar.zze)));
        }
        return new zzbd(enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbd zza(zzjm zzjmVar, int i) {
        EnumMap enumMap = new EnumMap(zzjj.zza.class);
        enumMap.put((EnumMap) zzjj.zza.AD_USER_DATA, (zzjj.zza) zzjmVar);
        return new zzbd(enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzbd zza(String str) {
        if (str == null || str.length() <= 0) {
            return zza;
        }
        String[] split = str.split(":");
        int parseInt = Integer.parseInt(split[0]);
        EnumMap enumMap = new EnumMap(zzjj.zza.class);
        zzjj.zza[] zza2 = zzjl.DMA.zza();
        int length = zza2.length;
        int i = 1;
        int i2 = 0;
        while (i2 < length) {
            enumMap.put((EnumMap) zza2[i2], (zzjj.zza) zzjj.zza(split[i].charAt(0)));
            i2++;
            i++;
        }
        return new zzbd(enumMap, parseInt, (Boolean) null, (String) null);
    }

    public final zzjm zzc() {
        zzjm zzjmVar = this.zzf.get(zzjj.zza.AD_USER_DATA);
        return zzjmVar == null ? zzjm.UNINITIALIZED : zzjmVar;
    }

    public static Boolean zza(Bundle bundle) {
        zzjm zza2;
        if (bundle == null || (zza2 = zzjj.zza(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int i = zzbc.zza[zza2.ordinal()];
        if (i != 3) {
            return i != 4 ? null : true;
        }
        return false;
    }

    public final Boolean zzd() {
        return this.zzd;
    }

    private final String zzh() {
        zzjj.zza[] zza2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzjj.zza zzaVar : zzjl.DMA.zza()) {
            sb.append(":");
            sb.append(zzjj.zza(this.zzf.get(zzaVar)));
        }
        return sb.toString();
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final String toString() {
        zzjj.zza[] zza2;
        StringBuilder append = new StringBuilder("source=").append(zzjj.zza(this.zzb));
        for (zzjj.zza zzaVar : zzjl.DMA.zza()) {
            append.append(",");
            append.append(zzaVar.zze);
            append.append("=");
            zzjm zzjmVar = this.zzf.get(zzaVar);
            if (zzjmVar == null) {
                append.append("uninitialized");
            } else {
                int i = zzbc.zza[zzjmVar.ordinal()];
                if (i == 1) {
                    append.append("uninitialized");
                } else if (i == 2) {
                    append.append("eu_consent_policy");
                } else if (i == 3) {
                    append.append("denied");
                } else if (i == 4) {
                    append.append("granted");
                }
            }
        }
        if (this.zzd != null) {
            append.append(",isDmaRegion=").append(this.zzd);
        }
        if (this.zze != null) {
            append.append(",cpsDisplayStr=").append(this.zze);
        }
        return append.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbd(Boolean bool, int i) {
        this((Boolean) null, i, (Boolean) null, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbd(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap<zzjj.zza, zzjm> enumMap = new EnumMap<>(zzjj.zza.class);
        this.zzf = enumMap;
        enumMap.put((EnumMap<zzjj.zza, zzjm>) zzjj.zza.AD_USER_DATA, (zzjj.zza) zzjj.zza(bool));
        this.zzb = i;
        this.zzc = zzh();
        this.zzd = bool2;
        this.zze = str;
    }

    private zzbd(EnumMap<zzjj.zza, zzjm> enumMap, int i, Boolean bool, String str) {
        EnumMap<zzjj.zza, zzjm> enumMap2 = new EnumMap<>(zzjj.zza.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i;
        this.zzc = zzh();
        this.zzd = bool;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbd) {
            zzbd zzbdVar = (zzbd) obj;
            if (this.zzc.equalsIgnoreCase(zzbdVar.zzc) && Objects.equals(this.zzd, zzbdVar.zzd)) {
                return Objects.equals(this.zze, zzbdVar.zze);
            }
            return false;
        }
        return false;
    }

    public final boolean zzg() {
        for (zzjm zzjmVar : this.zzf.values()) {
            if (zzjmVar != zzjm.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }
}
