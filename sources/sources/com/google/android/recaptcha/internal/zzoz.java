package com.google.android.recaptcha.internal;

import java.util.Map;
/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* loaded from: classes2.dex */
final class zzoz extends zzpe {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoz() {
        super(null);
    }

    @Override // com.google.android.recaptcha.internal.zzpe
    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzc(); i++) {
                ((zzms) ((zzpa) zzg(i)).zza()).zzg();
            }
            for (Map.Entry entry : zzd()) {
                ((zzms) entry.getKey()).zzg();
            }
        }
        super.zza();
    }
}
