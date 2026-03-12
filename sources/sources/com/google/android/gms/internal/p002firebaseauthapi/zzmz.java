package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmz  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class zzmz extends zzbf {
    public static zzmz zza(zzpc zzpcVar) {
        return new zzmy(zzpcVar);
    }

    public abstract Class<?> zza(Class<?> cls) throws GeneralSecurityException;

    public abstract <P> P zza(zzbo zzboVar, Class<P> cls) throws GeneralSecurityException;

    public abstract <B, P> P zza(zzpg<B> zzpgVar, Class<P> cls) throws GeneralSecurityException;
}
