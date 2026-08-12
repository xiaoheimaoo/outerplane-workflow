package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.games.GamesSignInClient;
import com.google.android.gms.games.gamessignin.AuthResponse;
import com.google.android.gms.games.gamessignin.AuthScope;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.0.0 */
/* loaded from: classes2.dex */
public final class zzdc implements GamesSignInClient {
    private final zzaw zza;
    private final zzaq zzb;

    public zzdc(zzaw zzawVar, zzaq zzaqVar) {
        this.zza = zzawVar;
        this.zzb = zzaqVar;
    }

    @Override // com.google.android.gms.games.GamesSignInClient
    public final Task<AuthenticationResult> isAuthenticated() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.games.GamesSignInClient
    public final Task<String> requestServerSideAccess(final String str, final boolean z) {
        return this.zzb.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzdb
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final boolean z2 = z;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzda
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzah) obj).zzW((TaskCompletionSource) obj2, str2, z2);
                    }
                }).setMethodKey(6699).build());
            }
        });
    }

    @Override // com.google.android.gms.games.GamesSignInClient
    public final Task<AuthenticationResult> signIn() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.games.GamesSignInClient
    public final Task<AuthResponse> requestServerSideAccess(final String str, final boolean z, List<AuthScope> list) {
        Objects.requireNonNull(str, "serverClientId must not be null.");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("serverClientId must not be empty.");
        }
        if (list != null && !list.contains(null)) {
            return this.zza.zzb(new zzau() { // from class: com.google.android.gms.internal.games_v2.zzcy
                @Override // com.google.android.gms.internal.games_v2.zzau
                public final /* synthetic */ Task zza(GoogleApi googleApi, final List list2) {
                    TaskApiCall.Builder builder = TaskApiCall.builder();
                    final String str2 = str;
                    final boolean z2 = z;
                    return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcz
                        @Override // com.google.android.gms.common.api.internal.RemoteCall
                        public final /* synthetic */ void accept(Object obj, Object obj2) {
                            TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                            com.google.android.gms.games.internal.zzah zzahVar = (com.google.android.gms.games.internal.zzah) obj;
                            AuthScope authScope = AuthScope.EMAIL;
                            List<AuthScope> list3 = list2;
                            Objects.requireNonNull(list3, "Input scopes list cannot be null");
                            LinkedHashSet linkedHashSet = new LinkedHashSet();
                            for (AuthScope authScope2 : list3) {
                                linkedHashSet.add(authScope2.getValue());
                            }
                            zzahVar.zzX(taskCompletionSource, str2, z2, zzgm.zzi(linkedHashSet));
                        }
                    }).setMethodKey(6748).build());
                }
            }, list);
        }
        throw new IllegalArgumentException("AuthScope array cannot contain null elements.");
    }
}
