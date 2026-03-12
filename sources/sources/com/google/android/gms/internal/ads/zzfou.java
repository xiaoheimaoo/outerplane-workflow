package com.google.android.gms.internal.ads;

import android.view.View;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzfou extends zzfox {
    private static final zzfou zzb = new zzfou();

    private zzfou() {
    }

    public static zzfou zza() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfox
    public final void zzb(boolean z) {
        for (zzfoh zzfohVar : zzfov.zza().zzc()) {
            zzfpi zzg = zzfohVar.zzg();
            if (zzg.zzl()) {
                zzfpb.zza().zzb(zzg.zza(), "setState", true != z ? "backgrounded" : "foregrounded");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfox
    public final boolean zzc() {
        for (zzfoh zzfohVar : zzfov.zza().zzb()) {
            View zzf = zzfohVar.zzf();
            if (zzf != null && zzf.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
