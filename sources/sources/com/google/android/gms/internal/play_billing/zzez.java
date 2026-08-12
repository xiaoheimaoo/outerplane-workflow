package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
final class zzez {
    private static final zzez zzb = new zzez(true);
    final zzhd zza = new zzgy();
    private boolean zzc;
    private boolean zzd;

    private zzez() {
    }

    static int zza(zzhs zzhsVar, int i, Object obj) {
        int zzC = zzep.zzC(i << 3);
        if (zzhsVar == zzhs.GROUP) {
            zzfo.zzd((zzgl) obj);
            zzC += zzC;
        }
        return zzC + zzb(zzhsVar, obj);
    }

    static int zzb(zzhs zzhsVar, Object obj) {
        int zzd;
        int zzC;
        zzhs zzhsVar2 = zzhs.DOUBLE;
        zzht zzhtVar = zzht.INT;
        switch (zzhsVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i = zzep.zzb;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i2 = zzep.zzb;
                return 4;
            case 2:
                return zzep.zzD(((Long) obj).longValue());
            case 3:
                return zzep.zzD(((Long) obj).longValue());
            case 4:
                return zzep.zzD(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i3 = zzep.zzb;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i4 = zzep.zzb;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i5 = zzep.zzb;
                return 1;
            case 8:
                if (obj instanceof zzei) {
                    int i6 = zzep.zzb;
                    zzd = ((zzei) obj).zzd();
                    zzC = zzep.zzC(zzd);
                    break;
                } else {
                    return zzep.zzB((String) obj);
                }
            case 9:
                return ((zzgl) obj).zzj();
            case 10:
                if (obj instanceof zzfv) {
                    int i7 = zzep.zzb;
                    zzd = ((zzfv) obj).zza();
                    zzC = zzep.zzC(zzd);
                    break;
                } else {
                    return zzep.zzz((zzgl) obj);
                }
            case 11:
                if (obj instanceof zzei) {
                    int i8 = zzep.zzb;
                    zzd = ((zzei) obj).zzd();
                    zzC = zzep.zzC(zzd);
                    break;
                } else {
                    int i9 = zzep.zzb;
                    zzd = ((byte[]) obj).length;
                    zzC = zzep.zzC(zzd);
                    break;
                }
            case 12:
                return zzep.zzC(((Integer) obj).intValue());
            case 13:
                if (obj instanceof zzfk) {
                    return zzep.zzD(((zzfk) obj).zza());
                }
                return zzep.zzD(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i10 = zzep.zzb;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i11 = zzep.zzb;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return zzep.zzC((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return zzep.zzD((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzC + zzd;
    }

    public static int zzc(zzey zzeyVar, Object obj) {
        zzhs zzb2 = zzeyVar.zzb();
        int zza = zzeyVar.zza();
        if (zzeyVar.zze()) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            if (!zzeyVar.zzd()) {
                int i2 = 0;
                while (i < size) {
                    i2 += zza(zzb2, zza, list.get(i));
                    i++;
                }
                return i2;
            } else if (list.isEmpty()) {
                return 0;
            } else {
                int i3 = 0;
                while (i < size) {
                    i3 += zzb(zzb2, list.get(i));
                    i++;
                }
                return zzep.zzC(zza << 3) + i3 + zzep.zzC(i3);
            }
        }
        return zza(zzb2, zza, obj);
    }

    public static zzez zze() {
        return zzb;
    }

    private static boolean zzj(Map.Entry entry) {
        zzey zzeyVar = (zzey) entry.getKey();
        if (zzeyVar.zzc() == zzht.MESSAGE) {
            if (zzeyVar.zze()) {
                List list = (List) entry.getValue();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (!zzk(list.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return zzk(entry.getValue());
        }
        return true;
    }

    private static boolean zzk(Object obj) {
        if (obj instanceof zzgm) {
            return ((zzgm) obj).zzk();
        }
        if (obj instanceof zzfv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzl(Map.Entry entry) {
        int i;
        int zzC;
        int zzC2;
        zzey zzeyVar = (zzey) entry.getKey();
        Object value = entry.getValue();
        if (zzeyVar.zzc() != zzht.MESSAGE || zzeyVar.zze() || zzeyVar.zzd()) {
            return zzc(zzeyVar, value);
        }
        if (value instanceof zzfv) {
            int zza = ((zzey) entry.getKey()).zza();
            int zzC3 = zzep.zzC(8);
            i = zzC3 + zzC3;
            zzC = zzep.zzC(16) + zzep.zzC(zza);
            int zzC4 = zzep.zzC(24);
            int zza2 = ((zzfv) value).zza();
            zzC2 = zzC4 + zzep.zzC(zza2) + zza2;
        } else {
            int zza3 = ((zzey) entry.getKey()).zza();
            int zzC5 = zzep.zzC(8);
            i = zzC5 + zzC5;
            zzC = zzep.zzC(16) + zzep.zzC(zza3);
            zzC2 = zzep.zzC(24) + zzep.zzz((zzgl) value);
        }
        return i + zzC + zzC2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzm(com.google.android.gms.internal.play_billing.zzey r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.play_billing.zzhs r0 = r4.zzb()
            byte[] r1 = com.google.android.gms.internal.play_billing.zzfo.zzb
            r5.getClass()
            com.google.android.gms.internal.play_billing.zzhs r1 = com.google.android.gms.internal.play_billing.zzhs.DOUBLE
            com.google.android.gms.internal.play_billing.zzht r1 = com.google.android.gms.internal.play_billing.zzht.INT
            com.google.android.gms.internal.play_billing.zzht r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzgl
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzfv
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzfk
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.play_billing.zzei
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L48
            goto L47
        L34:
            boolean r0 = r5 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r5 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r5 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r5 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r5 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
        L47:
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int r2 = r4.zza()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 0
            r1[r3] = r2
            com.google.android.gms.internal.play_billing.zzhs r4 = r4.zzb()
            com.google.android.gms.internal.play_billing.zzht r4 = r4.zza()
            r2 = 1
            r1[r2] = r4
            java.lang.Class r4 = r5.getClass()
            java.lang.String r4 = r4.getName()
            r5 = 2
            r1[r5] = r4
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzez.zzm(com.google.android.gms.internal.play_billing.zzey, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzez zzezVar = new zzez();
        zzhd zzhdVar = this.zza;
        int zzc = zzhdVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Map.Entry zzg = zzhdVar.zzg(i);
            zzezVar.zzh((zzey) ((zzgz) zzg).zza(), zzg.getValue());
        }
        for (Map.Entry entry : zzhdVar.zzd()) {
            zzezVar.zzh((zzey) entry.getKey(), entry.getValue());
        }
        zzezVar.zzd = this.zzd;
        return zzezVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzez) {
            return this.zza.equals(((zzez) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        zzhd zzhdVar = this.zza;
        int zzc = zzhdVar.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc; i2++) {
            i += zzl(zzhdVar.zzg(i2));
        }
        for (Map.Entry entry : zzhdVar.zzd()) {
            i += zzl(entry);
        }
        return i;
    }

    public final Iterator zzf() {
        zzhd zzhdVar = this.zza;
        if (zzhdVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzft(zzhdVar.entrySet().iterator());
        }
        return zzhdVar.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        zzhd zzhdVar = this.zza;
        int zzc = zzhdVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Object value = zzhdVar.zzg(i).getValue();
            if (value instanceof zzfi) {
                ((zzfi) value).zzu();
            }
        }
        for (Map.Entry entry : zzhdVar.zzd()) {
            Object value2 = entry.getValue();
            if (value2 instanceof zzfi) {
                ((zzfi) value2).zzu();
            }
        }
        zzhdVar.zza();
        this.zzc = true;
    }

    public final void zzh(zzey zzeyVar, Object obj) {
        if (zzeyVar.zze()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzm(zzeyVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            zzm(zzeyVar, obj);
        }
        if (obj instanceof zzfv) {
            this.zzd = true;
        }
        this.zza.put(zzeyVar, obj);
    }

    public final boolean zzi() {
        zzhd zzhdVar = this.zza;
        int zzc = zzhdVar.zzc();
        for (int i = 0; i < zzc; i++) {
            if (!zzj(zzhdVar.zzg(i))) {
                return false;
            }
        }
        for (Map.Entry entry : zzhdVar.zzd()) {
            if (!zzj(entry)) {
                return false;
            }
        }
        return true;
    }

    private zzez(boolean z) {
        zzg();
        zzg();
    }
}
