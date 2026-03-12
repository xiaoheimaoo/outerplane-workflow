package com.google.android.gms.internal.games_v2;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes2.dex */
public final class zzig extends zzhl {
    static final zzig zzc;
    final transient zzhd zzd;

    static {
        int i = zzhd.zzd;
        zzc = new zzig(zzhz.zza, zzhr.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzig(zzhd zzhdVar, Comparator comparator) {
        super(comparator);
        this.zzd = zzhdVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        zzhd zzhdVar = this.zzd;
        int zzs = zzs(obj, true);
        if (zzs == zzhdVar.size()) {
            return null;
        }
        return zzhdVar.get(zzs);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.zzd, obj, this.zza) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzhq) {
            collection = ((zzhq) collection).zza();
        }
        Comparator comparator = ((zzhl) this).zza;
        if (!zzik.zza(comparator, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        zzim listIterator = this.zzd.listIterator(0);
        Iterator it = collection.iterator();
        if (!listIterator.hasNext()) {
            return false;
        }
        Object next = it.next();
        E next2 = listIterator.next();
        while (true) {
            try {
                int compare = comparator.compare(next2, next);
                if (compare >= 0) {
                    if (compare != 0) {
                        break;
                    } else if (!it.hasNext()) {
                        return true;
                    } else {
                        next = it.next();
                    }
                } else if (!listIterator.hasNext()) {
                    return false;
                } else {
                    next2 = listIterator.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036 A[Catch: ClassCastException | NoSuchElementException -> 0x004a, TryCatch #0 {ClassCastException | NoSuchElementException -> 0x004a, blocks: (B:17:0x002c, B:18:0x0030, B:20:0x0036, B:22:0x0040), top: B:29:0x002c }] */
    @Override // com.google.android.gms.internal.games_v2.zzhk, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof java.util.Set
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            java.util.Set r7 = (java.util.Set) r7
            com.google.android.gms.internal.games_v2.zzhd r1 = r6.zzd
            int r3 = r1.size()
            int r4 = r7.size()
            if (r3 == r4) goto L19
            return r2
        L19:
            boolean r3 = r6.isEmpty()
            if (r3 == 0) goto L20
            return r0
        L20:
            java.util.Comparator r3 = r6.zza
            boolean r3 = com.google.android.gms.internal.games_v2.zzik.zza(r3, r7)
            if (r3 == 0) goto L4b
            java.util.Iterator r7 = r7.iterator()
            com.google.android.gms.internal.games_v2.zzim r1 = r1.listIterator(r2)     // Catch: java.lang.Throwable -> L4a
        L30:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L49
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r4 = r7.next()     // Catch: java.lang.Throwable -> L4a
            if (r4 == 0) goto L48
            java.util.Comparator r5 = r6.zza     // Catch: java.lang.Throwable -> L4a
            int r3 = r5.compare(r3, r4)     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L30
        L48:
            return r2
        L49:
            return r0
        L4a:
            return r2
        L4b:
            boolean r7 = r6.containsAll(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.games_v2.zzig.equals(java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.zzd.get(0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object floor(Object obj) {
        int zzr = zzr(obj, true) - 1;
        if (zzr == -1) {
            return null;
        }
        return this.zzd.get(zzr);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object higher(Object obj) {
        zzhd zzhdVar = this.zzd;
        int zzs = zzs(obj, false);
        if (zzs == zzhdVar.size()) {
            return null;
        }
        return zzhdVar.get(zzs);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.SortedSet
    public final Object last() {
        if (!isEmpty()) {
            zzhd zzhdVar = this.zzd;
            return zzhdVar.get(zzhdVar.size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    public final Object lower(Object obj) {
        int zzr = zzr(obj, false) - 1;
        if (zzr == -1) {
            return null;
        }
        return this.zzd.get(zzr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd.size();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy
    public final zzil zza() {
        return this.zzd.listIterator(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final Object[] zzb() {
        return this.zzd.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zzc() {
        return this.zzd.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zzd() {
        return this.zzd.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zze(Object[] objArr, int i) {
        return this.zzd.zze(objArr, 0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    final zzhl zzm(Object obj, boolean z) {
        return zzt(0, zzr(obj, z));
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    final zzhl zzn(Object obj, boolean z, Object obj2, boolean z2) {
        return zzo(obj, z).zzm(obj2, z2);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    final zzhl zzo(Object obj, boolean z) {
        return zzt(zzs(obj, z), this.zzd.size());
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl
    final zzhl zzp() {
        Comparator reverseOrder = Collections.reverseOrder(this.zza);
        if (isEmpty()) {
            return zzk(reverseOrder);
        }
        return new zzig(this.zzd.zzf(), reverseOrder);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhl, java.util.NavigableSet
    /* renamed from: zzq */
    public final zzil descendingIterator() {
        return this.zzd.zzf().listIterator(0);
    }

    final zzig zzt(int i, int i2) {
        if (i == 0) {
            if (i2 == this.zzd.size()) {
                return this;
            }
            i = 0;
        }
        if (i < i2) {
            zzhd zzhdVar = this.zzd;
            return new zzig(zzhdVar.subList(i, i2), this.zza);
        }
        return zzk(this.zza);
    }

    final int zzr(Object obj, boolean z) {
        obj.getClass();
        int binarySearch = Collections.binarySearch(this.zzd, obj, ((zzhl) this).zza);
        return binarySearch >= 0 ? z ? binarySearch + 1 : binarySearch : ~binarySearch;
    }

    final int zzs(Object obj, boolean z) {
        obj.getClass();
        int binarySearch = Collections.binarySearch(this.zzd, obj, ((zzhl) this).zza);
        return binarySearch >= 0 ? z ? binarySearch : binarySearch + 1 : ~binarySearch;
    }
}
