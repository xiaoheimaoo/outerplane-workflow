package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzh  reason: invalid package */
/* loaded from: classes2.dex */
public final class zzzh extends ThreadLocal<Mac> {
    private final /* synthetic */ zzze zza;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.ThreadLocal
    /* renamed from: zza */
    public final Mac initialValue() {
        String str;
        Key key;
        try {
            zzym<zzyz, Mac> zzymVar = zzym.zzb;
            str = this.zza.zzc;
            Mac zza = zzymVar.zza(str);
            key = this.zza.zzd;
            zza.init(key);
            return zza;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzh(zzze zzzeVar) {
        this.zza = zzzeVar;
    }
}
