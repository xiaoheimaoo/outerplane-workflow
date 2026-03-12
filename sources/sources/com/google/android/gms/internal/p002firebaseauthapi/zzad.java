package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzad  reason: invalid package */
/* loaded from: classes2.dex */
abstract class zzad<E> extends zzaz<E> {
    private final int zza;
    private int zzb;

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    protected abstract E zza(int i);

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb;
        this.zzb = i + 1;
        return zza(i);
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb - 1;
        this.zzb = i;
        return zza(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzad(int i, int i2) {
        zzw.zzb(i2, i);
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzb > 0;
    }
}
