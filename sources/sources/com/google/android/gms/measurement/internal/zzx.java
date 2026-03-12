package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzx extends zzot {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzz> zzc;
    private Long zzd;
    private Long zze;

    private final zzz zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzz zzzVar = new zzz(this, this.zza);
        this.zzc.put(num, zzzVar);
        return zzzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0633, code lost:
        r7 = zzj().zzr();
        r9 = com.google.android.gms.measurement.internal.zzgo.zza(r52.zza);
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0645, code lost:
        if (r8.zzi() == false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0647, code lost:
        r8 = java.lang.Integer.valueOf(r8.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0650, code lost:
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0651, code lost:
        r7.zza("Invalid property filter ID. appId, id", r9, java.lang.String.valueOf(r8));
        r8 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0301 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.internal.measurement.zzgf.zzd> zza(java.lang.String r53, java.util.List<com.google.android.gms.internal.measurement.zzgf.zzf> r54, java.util.List<com.google.android.gms.internal.measurement.zzgf.zzp> r55, java.lang.Long r56, java.lang.Long r57, boolean r58) {
        /*
            Method dump skipped, instructions count: 1808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long, boolean):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(zzou zzouVar) {
        super(zzouVar);
    }

    private final boolean zza(int i, int i2) {
        zzz zzzVar = this.zzc.get(Integer.valueOf(i));
        if (zzzVar == null) {
            return false;
        }
        return zzz.zza(zzzVar).get(i2);
    }
}
