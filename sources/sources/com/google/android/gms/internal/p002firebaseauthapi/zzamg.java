package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* JADX INFO: Add missing generic type declarations: [FieldDescriptorT] */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamg  reason: invalid package */
/* loaded from: classes2.dex */
final class zzamg<FieldDescriptorT> extends zzamh<FieldDescriptorT, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamg() {
        super();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamh
    public final void zza() {
        if (!zze()) {
            for (int i = 0; i < zzb(); i++) {
                Map.Entry<FieldDescriptorT, Object> zza = zza(i);
                if (((zzaka) zza.getKey()).zze()) {
                    zza.setValue(Collections.unmodifiableList((List) zza.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorT, Object> entry : zzc()) {
                if (((zzaka) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
