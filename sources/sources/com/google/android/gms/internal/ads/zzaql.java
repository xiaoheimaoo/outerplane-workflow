package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzaql {
    public static final boolean zza = zzaqm.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    protected final void finalize() throws Throwable {
        if (this.zzc) {
            return;
        }
        zzb("Request on the loose");
        zzaqm.zzb("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }

    public final synchronized void zza(String str, long j) {
        if (this.zzc) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.zzb.add(new zzaqk(str, j, SystemClock.elapsedRealtime()));
    }

    public final synchronized void zzb(String str) {
        List list;
        this.zzc = true;
        long j = this.zzb.size() == 0 ? 0L : ((zzaqk) this.zzb.get(list.size() - 1)).zzc - ((zzaqk) this.zzb.get(0)).zzc;
        if (j > 0) {
            long j2 = ((zzaqk) this.zzb.get(0)).zzc;
            zzaqm.zza("(%-4d ms) %s", Long.valueOf(j), str);
            for (zzaqk zzaqkVar : this.zzb) {
                long j3 = zzaqkVar.zzc;
                zzaqm.zza("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(zzaqkVar.zzb), zzaqkVar.zza);
                j2 = j3;
            }
        }
    }
}
