package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzgoa {
    private static final zzgoa zza = new zzgoa();
    private final Map zzb = new HashMap();

    zzgoa() {
    }

    public static zzgoa zzb() {
        return zza;
    }

    public final synchronized zzggq zza(String str) throws GeneralSecurityException {
        if (this.zzb.containsKey("AES128_GCM")) {
        } else {
            throw new GeneralSecurityException("Name AES128_GCM does not exist");
        }
        return (zzggq) this.zzb.get("AES128_GCM");
    }

    public final synchronized void zzc(String str, zzggq zzggqVar) throws GeneralSecurityException {
        if (this.zzb.containsKey(str)) {
            if (((zzggq) this.zzb.get(str)).equals(zzggqVar)) {
                return;
            }
            String valueOf = String.valueOf(this.zzb.get(str));
            String valueOf2 = String.valueOf(zzggqVar);
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + valueOf + "), cannot insert " + valueOf2);
        }
        this.zzb.put(str, zzggqVar);
    }

    public final synchronized void zzd(Map map) throws GeneralSecurityException {
        for (Map.Entry entry : map.entrySet()) {
            zzc((String) entry.getKey(), (zzggq) entry.getValue());
        }
    }
}
