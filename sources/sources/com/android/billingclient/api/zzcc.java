package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;
/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes.dex */
final class zzcc implements ServiceConnection {
    final /* synthetic */ zzce zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcc(zzce zzceVar, zzcd zzcdVar) {
        Objects.requireNonNull(zzceVar);
        this.zza = zzceVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClientTesting", "Billing Override Service connected.");
        zzce zzceVar = this.zza;
        zzce.zzaq(zzceVar, com.google.android.gms.internal.play_billing.zzat.zzc(iBinder));
        zzce.zzar(zzceVar, 2);
        zzce.zzax(zzceVar, 26);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClientTesting", "Billing Override Service disconnected.");
        zzce zzceVar = this.zza;
        zzce.zzaq(zzceVar, null);
        zzce.zzar(zzceVar, 0);
    }
}
