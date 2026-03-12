package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzao  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzao<E> extends zzaj<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzaj zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    final int zza() {
        return this.zzc.zzb() + this.zza + this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final boolean zze() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final int zzb() {
        return this.zzc.zzb() + this.zza;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaj
    public final zzaj<E> zza(int i, int i2) {
        zzw.zza(i, i2, this.zzb);
        zzaj zzajVar = this.zzc;
        int i3 = this.zza;
        return (zzaj) zzajVar.subList(i + i3, i2 + i3);
    }

    @Override // java.util.List
    public final E get(int i) {
        zzw.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaj, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(zzaj zzajVar, int i, int i2) {
        this.zzc = zzajVar;
        this.zza = i;
        this.zzb = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final Object[] zzf() {
        return this.zzc.zzf();
    }
}
