package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabf  reason: invalid package */
/* loaded from: classes2.dex */
final class zzabf implements zzaew<zzagm> {
    private final /* synthetic */ zzaew zza;
    private final /* synthetic */ zzadp zzb;
    private final /* synthetic */ zzagw zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabf(zzabc zzabcVar, zzaew zzaewVar, zzadp zzadpVar, zzagw zzagwVar) {
        this.zza = zzaewVar;
        this.zzb = zzadpVar;
        this.zzc = zzagwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzagm zzagmVar) {
        List<zzagl> zza = zzagmVar.zza();
        if (zza == null || zza.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzb.zza(this.zzc, zza.get(0));
        }
    }
}
