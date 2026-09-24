package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.games_v2.zzfy;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
final class zzu extends com.google.android.gms.internal.games_v2.zzab {
    final /* synthetic */ zzai zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzu(zzai zzaiVar) {
        super(zzaiVar.getContext().getMainLooper(), 1000);
        Objects.requireNonNull(zzaiVar);
        this.zza = zzaiVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzab
    protected final void zza(String str, int i) {
        try {
            zzai zzaiVar = this.zza;
            if (zzaiVar.isConnected()) {
                ((zzao) zzaiVar.getService()).zzJ(str, i);
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30 + String.valueOf(i).length() + 48);
            sb.append("Unable to increment event ");
            sb.append(str);
            sb.append(" by ");
            sb.append(i);
            sb.append(" because the games client is no longer connected");
            zzfy.zzg("GamesGmsClientImpl", sb.toString());
        } catch (RemoteException e) {
            zzai.zzac(e);
        } catch (SecurityException e2) {
            zzai.zzad(e2);
        }
    }
}
