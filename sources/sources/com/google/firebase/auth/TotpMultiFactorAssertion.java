package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* loaded from: classes3.dex */
public class TotpMultiFactorAssertion extends MultiFactorAssertion {
    private final String zza;
    private final TotpSecret zzb;
    private final String zzc;

    @Override // com.google.firebase.auth.MultiFactorAssertion
    public String getFactorId() {
        return TotpMultiFactorGenerator.FACTOR_ID;
    }

    public final TotpSecret zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }

    public TotpMultiFactorAssertion(String str, TotpSecret totpSecret, String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = totpSecret;
        this.zzc = str2;
    }
}
