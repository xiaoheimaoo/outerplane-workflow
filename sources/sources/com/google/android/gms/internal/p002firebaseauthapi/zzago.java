package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzago  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzago {
    private List<zzagl> zza;

    public final List<zzagl> zza() {
        return this.zza;
    }

    public zzago() {
        this.zza = new ArrayList();
    }

    public zzago(List<zzagl> list) {
        this.zza = Collections.unmodifiableList(list);
    }
}
