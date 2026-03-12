package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes2.dex */
final class zzml<K, V> implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private Iterator<Map.Entry<K, V>> zzb;
    private final /* synthetic */ zzmj zzc;

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Object[] objArr;
        if (zza().hasNext()) {
            return zza().next();
        }
        objArr = this.zzc.zza;
        int i = this.zza - 1;
        this.zza = i;
        return (zzmn) objArr[i];
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        Map map;
        if (this.zzb == null) {
            map = this.zzc.zzf;
            this.zzb = map.entrySet().iterator();
        }
        return this.zzb;
    }

    private zzml(zzmj zzmjVar) {
        int i;
        this.zzc = zzmjVar;
        i = zzmjVar.zzb;
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
