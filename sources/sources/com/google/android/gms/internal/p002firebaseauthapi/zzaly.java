package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaly  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzaly {
    private static final zzaly zza = new zzaly();
    private final ConcurrentMap<Class<?>, zzamc<?>> zzc = new ConcurrentHashMap();
    private final zzamf zzb = new zzalb();

    public static zzaly zza() {
        return zza;
    }

    public final <T> zzamc<T> zza(Class<T> cls) {
        zzaki.zza(cls, "messageType");
        zzamc<T> zzamcVar = (zzamc<T>) this.zzc.get(cls);
        if (zzamcVar == null) {
            zzamc<T> zza2 = this.zzb.zza(cls);
            zzaki.zza(cls, "messageType");
            zzaki.zza(zza2, "schema");
            zzamc<T> zzamcVar2 = (zzamc<T>) this.zzc.putIfAbsent(cls, zza2);
            return zzamcVar2 != null ? zzamcVar2 : zza2;
        }
        return zzamcVar;
    }

    public final <T> zzamc<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzaly() {
    }
}
