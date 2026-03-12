package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [KeyT, SerializationT] */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzng  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzng<KeyT, SerializationT> extends zznh<KeyT, SerializationT> {
    private final /* synthetic */ zznj zza;

    /* JADX WARN: Incorrect return type in method signature: (TKeyT;Lcom/google/android/gms/internal/firebase-auth-api/zzcm;)TSerializationT; */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zznh
    public final zzpq zza(zzbo zzboVar, @Nullable zzcm zzcmVar) throws GeneralSecurityException {
        return this.zza.zza(zzboVar, zzcmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzng(Class cls, Class cls2, zznj zznjVar) {
        super(cls, cls2);
        this.zza = zznjVar;
    }
}
