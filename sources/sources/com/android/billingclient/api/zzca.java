package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
final class zzca implements ServiceConnection {
    final /* synthetic */ zzcc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzca(zzcc zzccVar, zzcb zzcbVar) {
        this.zza = zzccVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zze.zzk("BillingClientTesting", "Billing Override Service connected.");
        zzcc.zzay(this.zza, com.google.android.gms.internal.play_billing.zzau.zzc(iBinder));
        zzcc.zzaz(this.zza, 2);
        zzcc.zzaK(this.zza, 26);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClientTesting", "Billing Override Service disconnected.");
        zzcc.zzay(this.zza, null);
        zzcc.zzaz(this.zza, 0);
    }
}
