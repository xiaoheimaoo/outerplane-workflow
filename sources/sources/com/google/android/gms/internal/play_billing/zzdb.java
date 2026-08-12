package com.google.android.gms.internal.play_billing;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
public final class zzdb implements Runnable {
    zzde zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdb(zzde zzdeVar) {
        this.zza = zzdeVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        r2 = r1.zzd;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r11 = this;
            java.lang.String r0 = "Timed out (timeout delayed by "
            com.google.android.gms.internal.play_billing.zzde r1 = r11.zza
            if (r1 != 0) goto L8
            goto L7e
        L8:
            com.google.android.gms.internal.play_billing.zzcz r2 = com.google.android.gms.internal.play_billing.zzde.zzr(r1)
            if (r2 == 0) goto L7e
            r3 = 0
            r11.zza = r3
            boolean r4 = r2.isDone()
            if (r4 == 0) goto L1b
            r1.zzj(r2)
            return
        L1b:
            r4 = 1
            java.util.concurrent.ScheduledFuture r5 = com.google.android.gms.internal.play_billing.zzde.zzt(r1)     // Catch: java.lang.Throwable -> L79
            com.google.android.gms.internal.play_billing.zzde.zzu(r1, r3)     // Catch: java.lang.Throwable -> L79
            java.lang.String r6 = "Timed out"
            if (r5 == 0) goto L4c
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L4a
            long r7 = r5.getDelay(r7)     // Catch: java.lang.Throwable -> L4a
            long r7 = java.lang.Math.abs(r7)     // Catch: java.lang.Throwable -> L4a
            r9 = 10
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 <= 0) goto L4c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L4a
            r5.append(r7)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = " ms after scheduled time)"
            r5.append(r0)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L4a
            r6 = r0
            goto L4c
        L4a:
            r0 = move-exception
            goto L70
        L4c:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L4a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            r5.<init>()     // Catch: java.lang.Throwable -> L4a
            r5.append(r6)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r7 = ": "
            r5.append(r7)     // Catch: java.lang.Throwable -> L4a
            r5.append(r0)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L4a
            com.google.android.gms.internal.play_billing.zzdc r5 = new com.google.android.gms.internal.play_billing.zzdc     // Catch: java.lang.Throwable -> L79
            r5.<init>(r0, r3)     // Catch: java.lang.Throwable -> L79
            r1.zzi(r5)     // Catch: java.lang.Throwable -> L79
            r2.cancel(r4)
            return
        L70:
            com.google.android.gms.internal.play_billing.zzdc r5 = new com.google.android.gms.internal.play_billing.zzdc     // Catch: java.lang.Throwable -> L79
            r5.<init>(r6, r3)     // Catch: java.lang.Throwable -> L79
            r1.zzi(r5)     // Catch: java.lang.Throwable -> L79
            throw r0     // Catch: java.lang.Throwable -> L79
        L79:
            r0 = move-exception
            r2.cancel(r4)
            throw r0
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzdb.run():void");
    }
}
