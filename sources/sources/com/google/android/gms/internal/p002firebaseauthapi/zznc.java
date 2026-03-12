package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [SerializationT] */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznc  reason: invalid package */
/* loaded from: classes2.dex */
public final class zznc<SerializationT> extends zznd<SerializationT> {
    private final /* synthetic */ zznf zza;

    /* JADX WARN: Incorrect types in method signature: (TSerializationT;Lcom/google/android/gms/internal/firebase-auth-api/zzcm;)Lcom/google/android/gms/internal/firebase-auth-api/zzbo; */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zznd
    public final zzbo zza(zzpq zzpqVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        return this.zza.zza(zzpqVar, zzcmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zznc(zzzn zzznVar, Class cls, zznf zznfVar) {
        super(zzznVar, cls);
        this.zza = zznfVar;
    }
}
