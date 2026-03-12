package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
final class zzls<T> implements zzme<T> {
    private final zzlm zza;
    private final zzmu<?, ?> zzb;
    private final boolean zzc;
    private final zzjv<?> zzd;

    @Override // com.google.android.gms.internal.measurement.zzme
    public final int zza(T t) {
        zzmu<?, ?> zzmuVar = this.zzb;
        int zzb = zzmuVar.zzb(zzmuVar.zzd(t)) + 0;
        return this.zzc ? zzb + this.zzd.zza(t).zza() : zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final int zzb(T t) {
        int hashCode = this.zzb.zzd(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza(t).hashCode() : hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzls<T> zza(zzmu<?, ?> zzmuVar, zzjv<?> zzjvVar, zzlm zzlmVar) {
        return new zzls<>(zzmuVar, zzjvVar, zzlmVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final T zza() {
        zzlm zzlmVar = this.zza;
        if (zzlmVar instanceof zzkg) {
            return (T) ((zzkg) zzlmVar).zzci();
        }
        return (T) zzlmVar.zzcm().zzak();
    }

    private zzls(zzmu<?, ?> zzmuVar, zzjv<?> zzjvVar, zzlm zzlmVar) {
        this.zzb = zzmuVar;
        this.zzc = zzjvVar.zza(zzlmVar);
        this.zzd = zzjvVar;
        this.zza = zzlmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zzd(T t) {
        this.zzb.zzf(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t, T t2) {
        zzmg.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzmg.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t, zzmf zzmfVar, zzjt zzjtVar) throws IOException {
        boolean z;
        zzmu<?, ?> zzmuVar = this.zzb;
        zzjv<?> zzjvVar = this.zzd;
        Object zzc = zzmuVar.zzc(t);
        zzjw<?> zzb = zzjvVar.zzb(t);
        do {
            try {
                if (zzmfVar.zzc() == Integer.MAX_VALUE) {
                    return;
                }
                int zzd = zzmfVar.zzd();
                int i = 0;
                if (zzd == 11) {
                    Object obj = null;
                    zziy zziyVar = null;
                    while (zzmfVar.zzc() != Integer.MAX_VALUE) {
                        int zzd2 = zzmfVar.zzd();
                        if (zzd2 != 16) {
                            if (zzd2 != 26) {
                                if (zzd2 == 12 || !zzmfVar.zzt()) {
                                    break;
                                }
                            } else if (obj != null) {
                                zzjvVar.zza(zzmfVar, obj, zzjtVar, zzb);
                            } else {
                                zziyVar = zzmfVar.zzp();
                            }
                        } else {
                            i = zzmfVar.zzj();
                            obj = zzjvVar.zza(zzjtVar, this.zza, i);
                        }
                    }
                    if (zzmfVar.zzd() != 12) {
                        throw zzkp.zzb();
                    } else if (zziyVar != null) {
                        if (obj != null) {
                            zzjvVar.zza(zziyVar, obj, zzjtVar, zzb);
                        } else {
                            zzmuVar.zza((zzmu<?, ?>) zzc, i, zziyVar);
                        }
                    }
                } else if ((zzd & 7) == 2) {
                    Object zza = zzjvVar.zza(zzjtVar, this.zza, zzd >>> 3);
                    if (zza != null) {
                        zzjvVar.zza(zzmfVar, zza, zzjtVar, zzb);
                    } else {
                        z = zzmuVar.zza((zzmu<?, ?>) zzc, zzmfVar, 0);
                        continue;
                    }
                } else {
                    z = zzmfVar.zzt();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzmuVar.zzb((Object) t, (T) zzc);
            }
        } while (z);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099 A[EDGE_INSN: B:57:0x0099->B:34:0x0099 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzit r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzkg r0 = (com.google.android.gms.internal.measurement.zzkg) r0
            com.google.android.gms.internal.measurement.zzmx r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzmx r2 = com.google.android.gms.internal.measurement.zzmx.zzc()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.measurement.zzmx r1 = com.google.android.gms.internal.measurement.zzmx.zzd()
            r0.zzb = r1
        L11:
            com.google.android.gms.internal.measurement.zzkg$zzb r10 = (com.google.android.gms.internal.measurement.zzkg.zzb) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = com.google.android.gms.internal.measurement.zziu.zzc(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            com.google.android.gms.internal.measurement.zzjv<?> r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzjt r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzlm r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzkg$zzd r0 = (com.google.android.gms.internal.measurement.zzkg.zzd) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zziu.zza(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.measurement.zzma.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = com.google.android.gms.internal.measurement.zziu.zza(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = com.google.android.gms.internal.measurement.zziu.zzc(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = com.google.android.gms.internal.measurement.zziu.zza(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.measurement.zziy r2 = (com.google.android.gms.internal.measurement.zziy) r2
            goto L53
        L72:
            com.google.android.gms.internal.measurement.zzma.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = com.google.android.gms.internal.measurement.zziu.zzc(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.measurement.zzjv<?> r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzjt r5 = r14.zzd
            com.google.android.gms.internal.measurement.zzlm r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzkg$zzd r0 = (com.google.android.gms.internal.measurement.zzkg.zzd) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = com.google.android.gms.internal.measurement.zziu.zza(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            com.google.android.gms.internal.measurement.zzkp r10 = com.google.android.gms.internal.measurement.zzkp.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzls.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzit):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final void zza(T t, zznl zznlVar) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd = this.zzd.zza(t).zzd();
        while (zzd.hasNext()) {
            Map.Entry<?, Object> next = zzd.next();
            zzjy zzjyVar = (zzjy) next.getKey();
            if (zzjyVar.zzc() != zznj.MESSAGE || zzjyVar.zze() || zzjyVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof zzkt) {
                zznlVar.zza(zzjyVar.zza(), (Object) ((zzkt) next).zza().zzb());
            } else {
                zznlVar.zza(zzjyVar.zza(), next.getValue());
            }
        }
        zzmu<?, ?> zzmuVar = this.zzb;
        zzmuVar.zza((zzmu<?, ?>) zzmuVar.zzd(t), zznlVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final boolean zzb(T t, T t2) {
        if (this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
            if (this.zzc) {
                return this.zzd.zza(t).equals(this.zzd.zza(t2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final boolean zze(T t) {
        return this.zzd.zza(t).zzg();
    }
}
