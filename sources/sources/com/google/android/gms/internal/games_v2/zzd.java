package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes2.dex */
final class zzd extends zze {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd() {
        super(null);
    }

    @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
    public final /* bridge */ /* synthetic */ List getImpliedScopes(Object obj) {
        com.google.android.gms.games.zzi zziVar = (com.google.android.gms.games.zzi) obj;
        return zzhd.zzj(new Scope(Scopes.GAMES));
    }
}
