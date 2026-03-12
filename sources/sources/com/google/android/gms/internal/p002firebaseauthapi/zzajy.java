package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaka;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajy  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzajy<T extends zzaka<T>> {
    private static final zzajy<?> zzb = new zzajy<>(true);
    final zzamh<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzanh zzanhVar, int i, Object obj) {
        int zzg = zzajo.zzg(i);
        if (zzanhVar == zzanh.zzj) {
            zzaki.zza((zzaln) obj);
            zzg <<= 1;
        }
        return zzg + zza(zzanhVar, obj);
    }

    private static int zza(zzanh zzanhVar, Object obj) {
        switch (zzakb.zzb[zzanhVar.ordinal()]) {
            case 1:
                return zzajo.zza(((Double) obj).doubleValue());
            case 2:
                return zzajo.zza(((Float) obj).floatValue());
            case 3:
                return zzajo.zzb(((Long) obj).longValue());
            case 4:
                return zzajo.zze(((Long) obj).longValue());
            case 5:
                return zzajo.zzc(((Integer) obj).intValue());
            case 6:
                return zzajo.zza(((Long) obj).longValue());
            case 7:
                return zzajo.zzb(((Integer) obj).intValue());
            case 8:
                return zzajo.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzajo.zza((zzaln) obj);
            case 10:
                if (obj instanceof zzakr) {
                    return zzajo.zza((zzakr) obj);
                }
                return zzajo.zzb((zzaln) obj);
            case 11:
                if (obj instanceof zzaiw) {
                    return zzajo.zza((zzaiw) obj);
                }
                return zzajo.zza((String) obj);
            case 12:
                if (obj instanceof zzaiw) {
                    return zzajo.zza((zzaiw) obj);
                }
                return zzajo.zza((byte[]) obj);
            case 13:
                return zzajo.zzh(((Integer) obj).intValue());
            case 14:
                return zzajo.zze(((Integer) obj).intValue());
            case 15:
                return zzajo.zzc(((Long) obj).longValue());
            case 16:
                return zzajo.zzf(((Integer) obj).intValue());
            case 17:
                return zzajo.zzd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzakl) {
                    return zzajo.zza(((zzakl) obj).zza());
                }
                return zzajo.zza(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzaka<?> zzakaVar, Object obj) {
        zzanh zzb2 = zzakaVar.zzb();
        int zza = zzakaVar.zza();
        if (zzakaVar.zze()) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            if (!zzakaVar.zzd()) {
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
                return zzajo.zzg(zza) + i3 + zzajo.zzh(i3);
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
        if (key.zzc() == zzank.MESSAGE && !key.zze() && !key.zzd()) {
            if (value instanceof zzakr) {
                return zzajo.zza(entry.getKey().zza(), (zzakr) value);
            }
            return zzajo.zza(entry.getKey().zza(), (zzaln) value);
        }
        return zza((zzaka<?>) key, value);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static <T extends zzaka<T>> zzajy<T> zzb() {
        return (zzajy<T>) zzb;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzajy zzajyVar = new zzajy();
        int zzb2 = this.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            Map.Entry<T, Object> zza = this.zza.zza(i);
            zzajyVar.zzb(zza.getKey(), zza.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            zzajyVar.zzb(entry.getKey(), entry.getValue());
        }
        zzajyVar.zzd = this.zzd;
        return zzajyVar;
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzals) {
            return ((zzals) obj).zza();
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
        if (obj instanceof zzakr) {
            zzakr zzakrVar = (zzakr) obj;
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
            return new zzakt(this.zza.zzd().iterator());
        }
        return this.zza.zzd().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzakt(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    private zzajy() {
        this.zza = new zzamg();
    }

    private zzajy(zzamh<T, Object> zzamhVar) {
        this.zza = zzamhVar;
        zze();
    }

    private zzajy(boolean z) {
        this(new zzamg());
        zze();
    }

    public final void zze() {
        if (this.zzc) {
            return;
        }
        int zzb2 = this.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            Object value = this.zza.zza(i).getValue();
            if (value instanceof zzakg) {
                ((zzakg) value).zzt();
            }
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            Object value2 = entry.getValue();
            if (value2 instanceof zzakg) {
                ((zzakg) value2).zzt();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zza(zzajy<T> zzajyVar) {
        int zzb2 = zzajyVar.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            zzb((Map.Entry) zzajyVar.zza.zza(i));
        }
        for (Map.Entry<T, Object> entry : zzajyVar.zza.zzc()) {
            zzb((Map.Entry) entry);
        }
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzaln zze;
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzakr;
        if (key.zze()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object zza = zza((zzajy<T>) key);
            List list = (List) value;
            int size = list.size();
            if (zza == null) {
                zza = new ArrayList(size);
            }
            List list2 = (List) zza;
            for (int i = 0; i < size; i++) {
                list2.add(zza(list.get(i)));
            }
            this.zza.zza((zzamh<T, Object>) key, (T) zza);
        } else if (key.zzc() == zzank.MESSAGE) {
            Object zza2 = zza((zzajy<T>) key);
            if (zza2 == null) {
                this.zza.zza((zzamh<T, Object>) key, (T) zza(value));
                if (z) {
                    this.zzd = true;
                }
            } else if (z) {
                zzakr zzakrVar = (zzakr) value;
                throw new NoSuchMethodError();
            } else {
                if (zza2 instanceof zzals) {
                    zze = key.zza((zzals) zza2, (zzals) value);
                } else {
                    zze = key.zza(((zzaln) zza2).zzr(), (zzaln) value).zze();
                }
                this.zza.zza((zzamh<T, Object>) key, (T) zze);
            }
        } else {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.zza((zzamh<T, Object>) key, (T) zza(value));
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
        if (obj instanceof zzakr) {
            this.zzd = true;
        }
        this.zza.zza((zzamh<T, Object>) t, (T) obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
        if ((r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzakl) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if ((r6 instanceof byte[]) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
        if ((r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzakr) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzc(T r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.firebase-auth-api.zzanh r0 = r5.zzb()
            com.google.android.gms.internal.p002firebaseauthapi.zzaki.zza(r6)
            int[] r1 = com.google.android.gms.internal.p002firebaseauthapi.zzakb.zza
            com.google.android.gms.internal.firebase-auth-api.zzank r0 = r0.zzb()
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
            boolean r0 = r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzaln
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzakr
            if (r0 == 0) goto L18
            goto L34
        L23:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzakl
            if (r0 == 0) goto L18
            goto L34
        L2c:
            boolean r0 = r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzaiw
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
            com.google.android.gms.internal.firebase-auth-api.zzanh r5 = r5.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzank r5 = r5.zzb()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzajy.zzc(com.google.android.gms.internal.firebase-auth-api.zzaka, java.lang.Object):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzajo zzajoVar, zzanh zzanhVar, int i, Object obj) throws IOException {
        if (zzanhVar == zzanh.zzj) {
            zzaln zzalnVar = (zzaln) obj;
            zzaki.zza(zzalnVar);
            zzajoVar.zzj(i, 3);
            zzalnVar.zza(zzajoVar);
            zzajoVar.zzj(i, 4);
            return;
        }
        zzajoVar.zzj(i, zzanhVar.zza());
        switch (zzakb.zzb[zzanhVar.ordinal()]) {
            case 1:
                zzajoVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzajoVar.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzajoVar.zzh(((Long) obj).longValue());
                return;
            case 4:
                zzajoVar.zzh(((Long) obj).longValue());
                return;
            case 5:
                zzajoVar.zzj(((Integer) obj).intValue());
                return;
            case 6:
                zzajoVar.zzf(((Long) obj).longValue());
                return;
            case 7:
                zzajoVar.zzi(((Integer) obj).intValue());
                return;
            case 8:
                zzajoVar.zzb(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzaln) obj).zza(zzajoVar);
                return;
            case 10:
                zzajoVar.zzc((zzaln) obj);
                return;
            case 11:
                if (obj instanceof zzaiw) {
                    zzajoVar.zzb((zzaiw) obj);
                    return;
                } else {
                    zzajoVar.zzb((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzaiw) {
                    zzajoVar.zzb((zzaiw) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzajoVar.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzajoVar.zzl(((Integer) obj).intValue());
                return;
            case 14:
                zzajoVar.zzi(((Integer) obj).intValue());
                return;
            case 15:
                zzajoVar.zzf(((Long) obj).longValue());
                return;
            case 16:
                zzajoVar.zzk(((Integer) obj).intValue());
                return;
            case 17:
                zzajoVar.zzg(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzakl) {
                    zzajoVar.zzj(((zzakl) obj).zza());
                    return;
                } else {
                    zzajoVar.zzj(((Integer) obj).intValue());
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
        if (obj instanceof zzajy) {
            return this.zza.equals(((zzajy) obj).zza);
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

    private static <T extends zzaka<T>> boolean zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzank.MESSAGE) {
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
        if (obj instanceof zzalp) {
            return ((zzalp) obj).zzv();
        }
        if (obj instanceof zzakr) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
