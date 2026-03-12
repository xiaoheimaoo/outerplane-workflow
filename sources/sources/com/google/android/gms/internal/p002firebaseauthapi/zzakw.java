package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakw  reason: invalid package */
/* loaded from: classes2.dex */
final class zzakw implements zzakx {
    private static <E> zzakn<E> zzc(Object obj, long j) {
        return (zzakn) zzana.zze(obj, j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakx
    public final <L> List<L> zza(Object obj, long j) {
        zzakn zzc = zzc(obj, j);
        if (zzc.zzc()) {
            return zzc;
        }
        int size = zzc.size();
        zzakn zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzana.zza(obj, j, zza);
        return zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakx
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.firebase-auth-api.zzakn] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakx
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzakn<E> zzc = zzc(obj, j);
        zzakn<E> zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzakn<E> zzaknVar = zzc;
        zzaknVar = zzc;
        if (size > 0 && size2 > 0) {
            boolean zzc3 = zzc.zzc();
            zzakn<E> zzaknVar2 = zzc;
            if (!zzc3) {
                zzaknVar2 = zzc.zza(size2 + size);
            }
            zzaknVar2.addAll(zzc2);
            zzaknVar = zzaknVar2;
        }
        if (size > 0) {
            zzc2 = zzaknVar;
        }
        zzana.zza(obj, j, zzc2);
    }
}
