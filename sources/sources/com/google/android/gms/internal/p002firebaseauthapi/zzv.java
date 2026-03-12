package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzv  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzv {
    private final zzf zza;
    private final zzab zzb;
    private final int zzc;

    public static zzv zza(char c) {
        zzh zzhVar = new zzh(c);
        zzw.zza(zzhVar);
        return new zzv(new zzy(zzhVar));
    }

    public static zzv zza(String str) {
        zzl zza = zzr.zza(str);
        if (!(!zza.zza("").zzc())) {
            throw new IllegalArgumentException(zzae.zza("The pattern may not match the empty string: %s", zza));
        }
        return new zzv(new zzaa(zza));
    }

    public final List<String> zza(CharSequence charSequence) {
        zzw.zza(charSequence);
        Iterator<String> zza = this.zzb.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza.hasNext()) {
            arrayList.add(zza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private zzv(zzab zzabVar) {
        this(zzabVar, false, zzj.zza, Integer.MAX_VALUE);
    }

    private zzv(zzab zzabVar, boolean z, zzf zzfVar, int i) {
        this.zzb = zzabVar;
        this.zza = zzfVar;
        this.zzc = Integer.MAX_VALUE;
    }
}
