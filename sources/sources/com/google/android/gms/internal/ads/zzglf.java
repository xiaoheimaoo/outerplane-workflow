package com.google.android.gms.internal.ads;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzglf extends zzghi {
    private final String zza;
    private final zzgld zzb;
    private final zzghi zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzglf(String str, zzgld zzgldVar, zzghi zzghiVar, zzgle zzgleVar) {
        this.zza = str;
        this.zzb = zzgldVar;
        this.zzc = zzghiVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzglf) {
            zzglf zzglfVar = (zzglf) obj;
            return zzglfVar.zzb.equals(this.zzb) && zzglfVar.zzc.equals(this.zzc) && zzglfVar.zza.equals(this.zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzglf.class, this.zza, this.zzb, this.zzc);
    }

    public final String toString() {
        zzghi zzghiVar = this.zzc;
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(zzghiVar);
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.zza + ", dekParsingStrategy: " + valueOf + ", dekParametersForNewKeys: " + valueOf2 + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzggq
    public final boolean zza() {
        return false;
    }

    public final zzghi zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }
}
