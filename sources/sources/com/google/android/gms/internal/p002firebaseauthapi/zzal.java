package com.google.android.gms.internal.p002firebaseauthapi;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzal  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzal<E> extends zzad<E> {
    private final zzaj<E> zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzad
    protected final E zza(int i) {
        return this.zza.get(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(zzaj<E> zzajVar, int i) {
        super(zzajVar.size(), i);
        this.zza = zzajVar;
    }
}
