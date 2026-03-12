package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzjj {
    public static final zzjj zza = new zzjj(null, null, 100);
    private final EnumMap<zza, zzjm> zzb;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static boolean zza(int i, int i2) {
        return ((i == -20 && i2 == -30) || ((i == -30 && i2 == -20) || i == i2)) || i < i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char zza(zzjm zzjmVar) {
        if (zzjmVar != null) {
            int ordinal = zzjmVar.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    return ordinal != 3 ? '-' : '1';
                }
                return '0';
            }
            return '+';
        }
        return '-';
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
    /* loaded from: classes2.dex */
    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");
        
        public final String zze;

        zza(String str) {
            this.zze = str;
        }
    }

    public final int zza() {
        return this.zzc;
    }

    public final int hashCode() {
        int i = this.zzc * 17;
        for (zzjm zzjmVar : this.zzb.values()) {
            i = (i * 31) + zzjmVar.hashCode();
        }
        return i;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry<zza, zzjm> entry : this.zzb.entrySet()) {
            String zzb = zzb(entry.getValue());
            if (zzb != null) {
                bundle.putString(entry.getKey().zze, zzb);
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjm zza(String str) {
        if (str == null) {
            return zzjm.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzjm.GRANTED;
        }
        if (str.equals("denied")) {
            return zzjm.DENIED;
        }
        return zzjm.UNINITIALIZED;
    }

    public final zzjm zzc() {
        zzjm zzjmVar = this.zzb.get(zza.AD_STORAGE);
        return zzjmVar == null ? zzjm.UNINITIALIZED : zzjmVar;
    }

    public final zzjm zzd() {
        zzjm zzjmVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        return zzjmVar == null ? zzjm.UNINITIALIZED : zzjmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjm zza(char c) {
        if (c != '+') {
            if (c != '0') {
                if (c == '1') {
                    return zzjm.GRANTED;
                }
                return zzjm.UNINITIALIZED;
            }
            return zzjm.DENIED;
        }
        return zzjm.POLICY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjm zza(Boolean bool) {
        if (bool == null) {
            return zzjm.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzjm.GRANTED;
        }
        return zzjm.DENIED;
    }

    public static zzjj zza(Bundle bundle, int i) {
        zza[] zzaVarArr;
        if (bundle == null) {
            return new zzjj(null, null, i);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        zzaVarArr = zzjl.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            enumMap.put((EnumMap) zzaVar, (zza) zza(bundle.getString(zzaVar.zze)));
        }
        return new zzjj(enumMap, i);
    }

    public static zzjj zza(zzjm zzjmVar, zzjm zzjmVar2, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        enumMap.put((EnumMap) zza.AD_STORAGE, (zza) zzjmVar);
        enumMap.put((EnumMap) zza.ANALYTICS_STORAGE, (zza) zzjmVar2);
        return new zzjj(enumMap, -10);
    }

    public static zzjj zzb(String str) {
        return zza(str, 100);
    }

    public static zzjj zza(String str, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str == null) {
            str = "";
        }
        zza[] zza2 = zzjl.STORAGE.zza();
        for (int i2 = 0; i2 < zza2.length; i2++) {
            zza zzaVar = zza2[i2];
            int i3 = i2 + 2;
            if (i3 < str.length()) {
                enumMap.put((EnumMap) zzaVar, (zza) zza(str.charAt(i3)));
            } else {
                enumMap.put((EnumMap) zzaVar, (zza) zzjm.UNINITIALIZED);
            }
        }
        return new zzjj(enumMap, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0051 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzjj zza(com.google.android.gms.measurement.internal.zzjj r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.zzjj$zza> r1 = com.google.android.gms.measurement.internal.zzjj.zza.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzjl r1 = com.google.android.gms.measurement.internal.zzjl.STORAGE
            com.google.android.gms.measurement.internal.zzjj$zza[] r1 = com.google.android.gms.measurement.internal.zzjl.zza(r1)
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L54
            r4 = r1[r3]
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzjj$zza, com.google.android.gms.measurement.internal.zzjm> r5 = r8.zzb
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzjm r5 = (com.google.android.gms.measurement.internal.zzjm) r5
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzjj$zza, com.google.android.gms.measurement.internal.zzjm> r6 = r9.zzb
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.measurement.internal.zzjm r6 = (com.google.android.gms.measurement.internal.zzjm) r6
            if (r5 != 0) goto L26
            goto L37
        L26:
            if (r6 != 0) goto L29
            goto L4c
        L29:
            com.google.android.gms.measurement.internal.zzjm r7 = com.google.android.gms.measurement.internal.zzjm.UNINITIALIZED
            if (r5 != r7) goto L2e
            goto L37
        L2e:
            com.google.android.gms.measurement.internal.zzjm r7 = com.google.android.gms.measurement.internal.zzjm.UNINITIALIZED
            if (r6 != r7) goto L33
            goto L4c
        L33:
            com.google.android.gms.measurement.internal.zzjm r7 = com.google.android.gms.measurement.internal.zzjm.POLICY
            if (r5 != r7) goto L39
        L37:
            r5 = r6
            goto L4c
        L39:
            com.google.android.gms.measurement.internal.zzjm r7 = com.google.android.gms.measurement.internal.zzjm.POLICY
            if (r6 != r7) goto L3e
            goto L4c
        L3e:
            com.google.android.gms.measurement.internal.zzjm r7 = com.google.android.gms.measurement.internal.zzjm.DENIED
            if (r5 == r7) goto L4a
            com.google.android.gms.measurement.internal.zzjm r5 = com.google.android.gms.measurement.internal.zzjm.DENIED
            if (r6 != r5) goto L47
            goto L4a
        L47:
            com.google.android.gms.measurement.internal.zzjm r5 = com.google.android.gms.measurement.internal.zzjm.GRANTED
            goto L4c
        L4a:
            com.google.android.gms.measurement.internal.zzjm r5 = com.google.android.gms.measurement.internal.zzjm.DENIED
        L4c:
            if (r5 == 0) goto L51
            r0.put(r4, r5)
        L51:
            int r3 = r3 + 1
            goto Lf
        L54:
            com.google.android.gms.measurement.internal.zzjj r9 = new com.google.android.gms.measurement.internal.zzjj
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjj.zza(com.google.android.gms.measurement.internal.zzjj):com.google.android.gms.measurement.internal.zzjj");
    }

    public final zzjj zzb(zzjj zzjjVar) {
        zza[] zzaVarArr;
        EnumMap enumMap = new EnumMap(zza.class);
        zzaVarArr = zzjl.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            zzjm zzjmVar = this.zzb.get(zzaVar);
            if (zzjmVar == zzjm.UNINITIALIZED) {
                zzjmVar = zzjjVar.zzb.get(zzaVar);
            }
            if (zzjmVar != null) {
                enumMap.put((EnumMap) zzaVar, (zza) zzjmVar);
            }
        }
        return new zzjj(enumMap, this.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(zzjm zzjmVar) {
        int ordinal = zzjmVar.ordinal();
        if (ordinal != 2) {
            if (ordinal != 3) {
                return null;
            }
            return "granted";
        }
        return "denied";
    }

    public static String zza(Bundle bundle) {
        zza[] zzaVarArr;
        String string;
        zzaVarArr = zzjl.STORAGE.zzd;
        int length = zzaVarArr.length;
        int i = 0;
        while (true) {
            Boolean bool = null;
            if (i >= length) {
                return null;
            }
            zza zzaVar = zzaVarArr[i];
            if (bundle.containsKey(zzaVar.zze) && (string = bundle.getString(zzaVar.zze)) != null) {
                if (string != null) {
                    if (string.equals("granted")) {
                        bool = Boolean.TRUE;
                    } else if (string.equals("denied")) {
                        bool = Boolean.FALSE;
                    }
                }
                if (bool == null) {
                    return string;
                }
            }
            i++;
        }
    }

    public final String zze() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzjl.STORAGE.zza()) {
            zzjm zzjmVar = this.zzb.get(zzaVar);
            char c = '-';
            if (zzjmVar != null && (ordinal = zzjmVar.ordinal()) != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        c = '0';
                    } else if (ordinal != 3) {
                    }
                }
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final String zzf() {
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzjl.STORAGE.zza()) {
            sb.append(zza(this.zzb.get(zzaVar)));
        }
        return sb.toString();
    }

    public final String toString() {
        zza[] zzaVarArr;
        StringBuilder append = new StringBuilder("source=").append(zza(this.zzc));
        zzaVarArr = zzjl.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            append.append(",");
            append.append(zzaVar.zze);
            append.append("=");
            zzjm zzjmVar = this.zzb.get(zzaVar);
            if (zzjmVar == null) {
                zzjmVar = zzjm.UNINITIALIZED;
            }
            append.append(zzjmVar);
        }
        return append.toString();
    }

    private zzjj(EnumMap<zza, zzjm> enumMap, int i) {
        EnumMap<zza, zzjm> enumMap2 = new EnumMap<>(zza.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    public zzjj(Boolean bool, Boolean bool2, int i) {
        EnumMap<zza, zzjm> enumMap = new EnumMap<>(zza.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap<zza, zzjm>) zza.AD_STORAGE, (zza) zza((Boolean) null));
        enumMap.put((EnumMap<zza, zzjm>) zza.ANALYTICS_STORAGE, (zza) zza((Boolean) null));
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        zza[] zzaVarArr;
        if (obj instanceof zzjj) {
            zzjj zzjjVar = (zzjj) obj;
            zzaVarArr = zzjl.STORAGE.zzd;
            for (zza zzaVar : zzaVarArr) {
                if (this.zzb.get(zzaVar) != zzjjVar.zzb.get(zzaVar)) {
                    return false;
                }
            }
            return this.zzc == zzjjVar.zzc;
        }
        return false;
    }

    public final boolean zzg() {
        return zza(zza.AD_STORAGE);
    }

    public final boolean zza(zza zzaVar) {
        return this.zzb.get(zzaVar) != zzjm.DENIED;
    }

    public final boolean zzh() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    public final boolean zzi() {
        for (zzjm zzjmVar : this.zzb.values()) {
            if (zzjmVar != zzjm.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzc(zzjj zzjjVar) {
        zza[] zzaVarArr;
        for (zza zzaVar : (zza[]) this.zzb.keySet().toArray(new zza[0])) {
            zzjm zzjmVar = this.zzb.get(zzaVar);
            zzjm zzjmVar2 = zzjjVar.zzb.get(zzaVar);
            if (zzjmVar == zzjm.DENIED && zzjmVar2 != zzjm.DENIED) {
                return true;
            }
        }
        return false;
    }
}
