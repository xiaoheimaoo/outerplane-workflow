package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.zzc;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaad  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzaad implements zzaew<zzagm> {
    private final /* synthetic */ zzaet zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ zzc zze;
    private final /* synthetic */ zzadp zzf;
    private final /* synthetic */ zzagw zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaad(zzzv zzzvVar, zzaet zzaetVar, String str, String str2, Boolean bool, zzc zzcVar, zzadp zzadpVar, zzagw zzagwVar) {
        this.zza = zzaetVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zzcVar;
        this.zzf = zzadpVar;
        this.zzg = zzagwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzagm zzagmVar) {
        List<zzagl> zza = zzagmVar.zza();
        if (zza == null || zza.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzagl zzaglVar = zza.get(0);
        zzahb zzf = zzaglVar.zzf();
        List<zzahc> zza2 = zzf != null ? zzf.zza() : null;
        if (zza2 != null && !zza2.isEmpty()) {
            if (TextUtils.isEmpty(this.zzb)) {
                zza2.get(0).zza(this.zzc);
            } else {
                int i = 0;
                while (true) {
                    if (i >= zza2.size()) {
                        break;
                    } else if (zza2.get(i).zzf().equals(this.zzb)) {
                        zza2.get(i).zza(this.zzc);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            zzaglVar.zza(bool.booleanValue());
        } else {
            zzaglVar.zza(zzaglVar.zzb() - zzaglVar.zza() < 1000);
        }
        zzaglVar.zza(this.zze);
        this.zzf.zza(this.zzg, zzaglVar);
    }
}
