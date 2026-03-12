package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzib extends zzhx<Long> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    @Nullable
    /* renamed from: zzb */
    public final Long zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzb = super.zzb();
        Log.e("PhenotypeFlag", "Invalid long value for " + zzb + ": " + String.valueOf(obj));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzib(zzif zzifVar, String str, Long l, boolean z) {
        super(zzifVar, str, l);
    }
}
