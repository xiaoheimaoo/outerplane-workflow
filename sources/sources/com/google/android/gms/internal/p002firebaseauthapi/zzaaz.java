package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaz  reason: invalid package */
/* loaded from: classes2.dex */
final class zzaaz implements zzaew<zzafz> {
    private final /* synthetic */ zzadp zza;
    private final /* synthetic */ zzaaw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaaz(zzaaw zzaawVar, zzadp zzadpVar) {
        this.zza = zzadpVar;
        this.zzb = zzaawVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzafz zzafzVar) {
        zzafz zzafzVar2 = zzafzVar;
        this.zzb.zza.zza(new zzagw(zzafzVar2.zzb(), zzafzVar2.zza(), Long.valueOf(zzagy.zza(zzafzVar2.zza())), "Bearer"), null, null, false, null, this.zza, this);
    }
}
