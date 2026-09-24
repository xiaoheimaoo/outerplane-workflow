package com.google.android.gms.internal.games_v2;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
class zze extends Api.AbstractClientBuilder {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zze(byte[] bArr) {
    }

    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* bridge */ /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        com.google.android.gms.games.zzi zziVar = (com.google.android.gms.games.zzi) obj;
        if (zziVar == null) {
            zziVar = com.google.android.gms.games.zzi.zza().zzd();
        }
        com.google.android.gms.games.internal.zzai zzaiVar = new com.google.android.gms.games.internal.zzai(context, looper, clientSettings, zziVar, connectionCallbacks, onConnectionFailedListener, com.google.android.gms.games.internal.zzaq.zza());
        if (zziVar.zzn.zza()) {
            int i = com.google.android.gms.games.internal.zzf.zza;
            zzaiVar.zzq(com.google.android.gms.games.internal.zzf.zza((Application) context.getApplicationContext()));
        }
        return zzaiVar;
    }

    @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
    public final int getPriority() {
        return 1;
    }
}
