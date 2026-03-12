package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamj  reason: invalid package */
/* loaded from: classes2.dex */
final class zzamj<K, V> implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private Iterator<Map.Entry<K, V>> zzb;
    private final /* synthetic */ zzamh zzc;

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Object[] objArr;
        if (zza().hasNext()) {
            return zza().next();
        }
        objArr = this.zzc.zza;
        int i = this.zza - 1;
        this.zza = i;
        return (zzaml) objArr[i];
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        Map map;
        if (this.zzb == null) {
            map = this.zzc.zzf;
            this.zzb = map.entrySet().iterator();
        }
        return this.zzb;
    }

    private zzamj(zzamh zzamhVar) {
        int i;
        this.zzc = zzamhVar;
        i = zzamhVar.zzb;
        this.zza = i;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i2 = this.zza;
        if (i2 > 0) {
            i = this.zzc.zzb;
            if (i2 <= i) {
                return true;
            }
        }
        return zza().hasNext();
    }
}
