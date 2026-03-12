package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzjw<T extends zzjy<T>> {
    private static final zzjw<?> zzb = new zzjw<>(true);
    final zzmj<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzng zzngVar, int i, Object obj) {
        int zzf = zzjn.zzf(i);
        if (zzngVar == zzng.zzj) {
            zzkj.zza((zzlm) obj);
            zzf <<= 1;
        }
        return zzf + zza(zzngVar, obj);
    }

    private static int zza(zzng zzngVar, Object obj) {
        switch (zzjz.zzb[zzngVar.ordinal()]) {
            case 1:
                return zzjn.zza(((Double) obj).doubleValue());
            case 2:
                return zzjn.zza(((Float) obj).floatValue());
            case 3:
                return zzjn.zzb(((Long) obj).longValue());
            case 4:
                return zzjn.zze(((Long) obj).longValue());
            case 5:
                return zzjn.zzc(((Integer) obj).intValue());
            case 6:
                return zzjn.zza(((Long) obj).longValue());
            case 7:
                return zzjn.zzb(((Integer) obj).intValue());
            case 8:
                return zzjn.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzjn.zza((zzlm) obj);
            case 10:
                if (obj instanceof zzkq) {
                    return zzjn.zza((zzkq) obj);
                }
                return zzjn.zzb((zzlm) obj);
            case 11:
                if (obj instanceof zziy) {
                    return zzjn.zza((zziy) obj);
                }
                return zzjn.zza((String) obj);
            case 12:
                if (obj instanceof zziy) {
                    return zzjn.zza((zziy) obj);
                }
                return zzjn.zza((byte[]) obj);
            case 13:
                return zzjn.zzg(((Integer) obj).intValue());
            case 14:
                return zzjn.zzd(((Integer) obj).intValue());
            case 15:
                return zzjn.zzc(((Long) obj).longValue());
            case 16:
                return zzjn.zze(((Integer) obj).intValue());
            case 17:
                return zzjn.zzd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzki) {
                    return zzjn.zza(((zzki) obj).zza());
                }
                return zzjn.zza(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzjy<?> zzjyVar, Object obj) {
        zzng zzb2 = zzjyVar.zzb();
        int zza = zzjyVar.zza();
        if (zzjyVar.zze()) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            if (!zzjyVar.zzd()) {
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
                    i3 += zza(zzb2, list.get(i));
                    i++;
                }
                return zzjn.zzf(zza) + i3 + zzjn.zzg(i3);
            }
        }
        return zza(zzb2, zza, obj);
    }

    public final int zza() {
        int zzb2 = this.zza.zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb2; i2++) {
            i += zza((Map.Entry) this.zza.zza(i2));
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            i += zza((Map.Entry) entry);
        }
        return i;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zznj.MESSAGE && !key.zze() && !key.zzd()) {
            if (value instanceof zzkq) {
                return zzjn.zza(entry.getKey().zza(), (zzkq) value);
            }
            return zzjn.zza(entry.getKey().zza(), (zzlm) value);
        }
        return zza((zzjy<?>) key, value);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static <T extends zzjy<T>> zzjw<T> zzb() {
        return (zzjw<T>) zzb;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzjw zzjwVar = new zzjw();
        int zzb2 = this.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            Map.Entry<T, Object> zza = this.zza.zza(i);
            zzjwVar.zzb(zza.getKey(), zza.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            zzjwVar.zzb(entry.getKey(), entry.getValue());
        }
        zzjwVar.zzd = this.zzd;
        return zzjwVar;
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzlv) {
            return ((zzlv) obj).zza();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (obj instanceof zzkq) {
            zzkq zzkqVar = (zzkq) obj;
            throw new NoSuchMethodError();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzks(this.zza.zzd().iterator());
        }
        return this.zza.zzd().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzks(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    private zzjw() {
        this.zza = new zzmi();
    }

    private zzjw(zzmj<T, Object> zzmjVar) {
        this.zza = zzmjVar;
        zze();
    }

    private zzjw(boolean z) {
        this(new zzmi());
        zze();
    }

    public final void zze() {
        if (this.zzc) {
            return;
        }
        int zzb2 = this.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            Object value = this.zza.zza(i).getValue();
            if (value instanceof zzkg) {
                ((zzkg) value).zzco();
            }
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            Object value2 = entry.getValue();
            if (value2 instanceof zzkg) {
                ((zzkg) value2).zzco();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zza(zzjw<T> zzjwVar) {
        int zzb2 = zzjwVar.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            zzb((Map.Entry) zzjwVar.zza.zza(i));
        }
        for (Map.Entry<T, Object> entry : zzjwVar.zza.zzc()) {
            zzb((Map.Entry) entry);
        }
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzlm zzaj;
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzkq;
        if (key.zze()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object zza = zza((zzjw<T>) key);
            List list = (List) value;
            int size = list.size();
            if (zza == null) {
                zza = new ArrayList(size);
            }
            List list2 = (List) zza;
            for (int i = 0; i < size; i++) {
                list2.add(zza(list.get(i)));
            }
            this.zza.zza((zzmj<T, Object>) key, (T) zza);
        } else if (key.zzc() == zznj.MESSAGE) {
            Object zza2 = zza((zzjw<T>) key);
            if (zza2 == null) {
                this.zza.zza((zzmj<T, Object>) key, (T) zza(value));
                if (z) {
                    this.zzd = true;
                }
            } else if (z) {
                zzkq zzkqVar = (zzkq) value;
                throw new NoSuchMethodError();
            } else {
                if (zza2 instanceof zzlv) {
                    zzaj = key.zza((zzlv) zza2, (zzlv) value);
                } else {
                    zzaj = key.zza(((zzlm) zza2).zzcn(), (zzlm) value).zzaj();
                }
                this.zza.zza((zzmj<T, Object>) key, (T) zzaj);
            }
        } else {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.zza((zzmj<T, Object>) key, (T) zza(value));
        }
    }

    private final void zzb(T t, Object obj) {
        if (t.zze()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzc(t, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            zzc(t, obj);
        }
        if (obj instanceof zzkq) {
            this.zzd = true;
        }
        this.zza.zza((zzmj<T, Object>) t, (T) obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
        if ((r6 instanceof com.google.android.gms.internal.measurement.zzki) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if ((r6 instanceof byte[]) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
        if ((r6 instanceof com.google.android.gms.internal.measurement.zzkq) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzc(T r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.measurement.zzng r0 = r5.zzb()
            com.google.android.gms.internal.measurement.zzkj.zza(r6)
            int[] r1 = com.google.android.gms.internal.measurement.zzjz.zza
            com.google.android.gms.internal.measurement.zznj r0 = r0.zzb()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L45;
                case 2: goto L42;
                case 3: goto L3f;
                case 4: goto L3c;
                case 5: goto L39;
                case 6: goto L36;
                case 7: goto L2c;
                case 8: goto L23;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r0 = r2
            goto L47
        L1a:
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzlm
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzkq
            if (r0 == 0) goto L18
            goto L34
        L23:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzki
            if (r0 == 0) goto L18
            goto L34
        L2c:
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zziy
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof byte[]
            if (r0 == 0) goto L18
        L34:
            r0 = r1
            goto L47
        L36:
            boolean r0 = r6 instanceof java.lang.String
            goto L47
        L39:
            boolean r0 = r6 instanceof java.lang.Boolean
            goto L47
        L3c:
            boolean r0 = r6 instanceof java.lang.Double
            goto L47
        L3f:
            boolean r0 = r6 instanceof java.lang.Float
            goto L47
        L42:
            boolean r0 = r6 instanceof java.lang.Long
            goto L47
        L45:
            boolean r0 = r6 instanceof java.lang.Integer
        L47:
            if (r0 == 0) goto L4a
            return
        L4a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r5.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r2] = r4
            com.google.android.gms.internal.measurement.zzng r5 = r5.zzb()
            com.google.android.gms.internal.measurement.zznj r5 = r5.zzb()
            r3[r1] = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r6 = 2
            r3[r6] = r5
            java.lang.String r5 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r5 = java.lang.String.format(r5, r3)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjw.zzc(com.google.android.gms.internal.measurement.zzjy, java.lang.Object):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzjn zzjnVar, zzng zzngVar, int i, Object obj) throws IOException {
        if (zzngVar == zzng.zzj) {
            zzlm zzlmVar = (zzlm) obj;
            zzkj.zza(zzlmVar);
            zzjnVar.zzj(i, 3);
            zzlmVar.zza(zzjnVar);
            zzjnVar.zzj(i, 4);
            return;
        }
        zzjnVar.zzj(i, zzngVar.zza());
        switch (zzjz.zzb[zzngVar.ordinal()]) {
            case 1:
                zzjnVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzjnVar.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzjnVar.zzh(((Long) obj).longValue());
                return;
            case 4:
                zzjnVar.zzh(((Long) obj).longValue());
                return;
            case 5:
                zzjnVar.zzi(((Integer) obj).intValue());
                return;
            case 6:
                zzjnVar.zzf(((Long) obj).longValue());
                return;
            case 7:
                zzjnVar.zzh(((Integer) obj).intValue());
                return;
            case 8:
                zzjnVar.zzb(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzlm) obj).zza(zzjnVar);
                return;
            case 10:
                zzjnVar.zzc((zzlm) obj);
                return;
            case 11:
                if (obj instanceof zziy) {
                    zzjnVar.zzb((zziy) obj);
                    return;
                } else {
                    zzjnVar.zzb((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zziy) {
                    zzjnVar.zzb((zziy) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzjnVar.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzjnVar.zzk(((Integer) obj).intValue());
                return;
            case 14:
                zzjnVar.zzh(((Integer) obj).intValue());
                return;
            case 15:
                zzjnVar.zzf(((Long) obj).longValue());
                return;
            case 16:
                zzjnVar.zzj(((Integer) obj).intValue());
                return;
            case 17:
                zzjnVar.zzg(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzki) {
                    zzjnVar.zzi(((zzki) obj).zza());
                    return;
                } else {
                    zzjnVar.zzi(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjw) {
            return this.zza.equals(((zzjw) obj).zza);
        }
        return false;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        int zzb2 = this.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            if (!zzc(this.zza.zza(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            if (!zzc(entry)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzjy<T>> boolean zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zznj.MESSAGE) {
            if (key.zze()) {
                List list = (List) entry.getValue();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (!zzb(list.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return zzb(entry.getValue());
        }
        return true;
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzlo) {
            return ((zzlo) obj).j_();
        }
        if (obj instanceof zzkq) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
