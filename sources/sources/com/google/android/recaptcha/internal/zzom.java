package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
final class zzom implements zzow {
    private final zzoi zza;
    private final zzpl zzb;
    private final boolean zzc;
    private final zzmp zzd;

    private zzom(zzpl zzplVar, zzmp zzmpVar, zzoi zzoiVar) {
        this.zzb = zzplVar;
        this.zzc = zzoiVar instanceof zzna;
        this.zzd = zzmpVar;
        this.zza = zzoiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzom zzc(zzpl zzplVar, zzmp zzmpVar, zzoi zzoiVar) {
        return new zzom(zzplVar, zzmpVar, zzoiVar);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final int zza(Object obj) {
        int zzb = ((zznd) obj).zzc.zzb();
        return this.zzc ? zzb + ((zzna) obj).zzb.zzb() : zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final int zzb(Object obj) {
        int hashCode = ((zznd) obj).zzc.hashCode();
        return this.zzc ? (hashCode * 53) + ((zzna) obj).zzb.zza.hashCode() : hashCode;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final Object zze() {
        zzoi zzoiVar = this.zza;
        return zzoiVar instanceof zznd ? ((zznd) zzoiVar).zzv() : zzoiVar.zzad().zzl();
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzg(Object obj, Object obj2) {
        zzoy.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzoy.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzh(Object obj, zzov zzovVar, zzmo zzmoVar) throws IOException {
        boolean zzO;
        zzpl zzplVar = this.zzb;
        Object zza = zzplVar.zza(obj);
        ((zzna) obj).zzi();
        while (zzovVar.zzc() != Integer.MAX_VALUE) {
            try {
                int zzd = zzovVar.zzd();
                int i = 0;
                if (zzd != 11) {
                    if ((zzd & 7) == 2) {
                        zznc zza2 = zzmoVar.zza(this.zza, zzd >>> 3);
                        if (zza2 == null) {
                            zzO = zzplVar.zzk(zza, zzovVar, 0);
                        } else {
                            zznc zzncVar = zza2;
                            throw null;
                        }
                    } else {
                        zzO = zzovVar.zzO();
                    }
                    if (!zzO) {
                        break;
                    }
                } else {
                    zznc zzncVar2 = null;
                    zzle zzleVar = null;
                    while (zzovVar.zzc() != Integer.MAX_VALUE) {
                        int zzd2 = zzovVar.zzd();
                        if (zzd2 == 16) {
                            i = zzovVar.zzj();
                            zzncVar2 = zzmoVar.zza(this.zza, i);
                        } else if (zzd2 == 26) {
                            if (zzncVar2 == null) {
                                zzleVar = zzovVar.zzp();
                            } else {
                                zznc zzncVar3 = zzncVar2;
                                throw null;
                            }
                        } else if (!zzovVar.zzO()) {
                            break;
                        }
                    }
                    if (zzovVar.zzd() != 12) {
                        throw new zznn("Protocol message end-group tag did not match expected tag.");
                    }
                    if (zzleVar == null) {
                        continue;
                    } else if (zzncVar2 == null) {
                        zzplVar.zzg(zza, i, zzleVar);
                    } else {
                        zznc zzncVar4 = zzncVar2;
                        throw null;
                    }
                }
            } finally {
                zzplVar.zzj(obj, zza);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008a A[EDGE_INSN: B:56:0x008a->B:34:0x008a ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.lang.Object r10, byte[] r11, int r12, int r13, com.google.android.recaptcha.internal.zzkt r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.recaptcha.internal.zznd r0 = (com.google.android.recaptcha.internal.zznd) r0
            com.google.android.recaptcha.internal.zzpm r1 = r0.zzc
            com.google.android.recaptcha.internal.zzpm r2 = com.google.android.recaptcha.internal.zzpm.zzc()
            if (r1 != r2) goto L11
            com.google.android.recaptcha.internal.zzpm r1 = com.google.android.recaptcha.internal.zzpm.zzf()
            r0.zzc = r1
        L11:
            com.google.android.recaptcha.internal.zzna r10 = (com.google.android.recaptcha.internal.zzna) r10
            r10.zzi()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto L94
            int r4 = com.google.android.recaptcha.internal.zzku.zzi(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L49
            r12 = r2 & 7
            if (r12 != r3) goto L44
            com.google.android.recaptcha.internal.zzmo r12 = r14.zzd
            com.google.android.recaptcha.internal.zzoi r0 = r9.zza
            int r3 = r2 >>> 3
            com.google.android.recaptcha.internal.zznc r0 = r12.zza(r0, r3)
            r12 = r0
            com.google.android.recaptcha.internal.zznc r12 = (com.google.android.recaptcha.internal.zznc) r12
            if (r0 != 0) goto L41
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.recaptcha.internal.zzku.zzh(r2, r3, r4, r5, r6, r7)
            goto L18
        L41:
            int r11 = com.google.android.recaptcha.internal.zzos.zza
            throw r10
        L44:
            int r12 = com.google.android.recaptcha.internal.zzku.zzo(r2, r11, r4, r13, r14)
            goto L18
        L49:
            r12 = 0
            r2 = r10
        L4b:
            if (r4 >= r13) goto L8a
            int r4 = com.google.android.recaptcha.internal.zzku.zzi(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L6d
            r8 = 3
            if (r6 == r8) goto L5d
            goto L81
        L5d:
            if (r0 != 0) goto L6a
            if (r7 != r3) goto L81
            int r4 = com.google.android.recaptcha.internal.zzku.zza(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.recaptcha.internal.zzle r2 = (com.google.android.recaptcha.internal.zzle) r2
            goto L4b
        L6a:
            int r11 = com.google.android.recaptcha.internal.zzos.zza
            throw r10
        L6d:
            if (r7 != 0) goto L81
            int r4 = com.google.android.recaptcha.internal.zzku.zzi(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.recaptcha.internal.zzmo r0 = r14.zzd
            com.google.android.recaptcha.internal.zzoi r5 = r9.zza
            com.google.android.recaptcha.internal.zznc r0 = r0.zza(r5, r12)
            r5 = r0
            com.google.android.recaptcha.internal.zznc r5 = (com.google.android.recaptcha.internal.zznc) r5
            goto L4b
        L81:
            r6 = 12
            if (r5 == r6) goto L8a
            int r4 = com.google.android.recaptcha.internal.zzku.zzo(r5, r11, r4, r13, r14)
            goto L4b
        L8a:
            if (r2 == 0) goto L92
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzj(r12, r2)
        L92:
            r12 = r4
            goto L18
        L94:
            if (r12 != r13) goto L97
            return
        L97:
            com.google.android.recaptcha.internal.zznn r10 = new com.google.android.recaptcha.internal.zznn
            java.lang.String r11 = "Failed to parse the message."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzom.zzi(java.lang.Object, byte[], int, int, com.google.android.recaptcha.internal.zzkt):void");
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzj(Object obj, zzpy zzpyVar) throws IOException {
        Iterator zzf = ((zzna) obj).zzb.zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzms zzmsVar = (zzms) entry.getKey();
            if (zzmsVar.zze() != zzpx.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzmsVar.zzg();
            zzmsVar.zzf();
            if (entry instanceof zznp) {
                zzpyVar.zzw(zzmsVar.zza(), ((zznp) entry).zza().zzb());
            } else {
                zzpyVar.zzw(zzmsVar.zza(), entry.getValue());
            }
        }
        ((zznd) obj).zzc.zzk(zzpyVar);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzk(Object obj, Object obj2) {
        if (((zznd) obj).zzc.equals(((zznd) obj2).zzc)) {
            if (this.zzc) {
                return ((zzna) obj).zzb.equals(((zzna) obj2).zzb);
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzl(Object obj) {
        return ((zzna) obj).zzb.zzk();
    }
}
