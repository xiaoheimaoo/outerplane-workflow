package com.google.firebase.auth.internal;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* loaded from: classes3.dex */
final class zzn extends zzj {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public final int hashCode() {
        String str = this.zza;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.zzb;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.zzc;
        return hashCode2 ^ (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.firebase.auth.internal.zzj
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.internal.zzj
    public final String zzc() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.internal.zzj
    public final String zzd() {
        return this.zza;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return "AttestationResult{recaptchaV2Token=" + str + ", playIntegrityToken=" + str2 + ", recaptchaEnterpriseToken=" + this.zzc + "}";
    }

    private zzn(String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzj) {
            zzj zzjVar = (zzj) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzjVar.zzd()) : zzjVar.zzd() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzjVar.zzb()) : zzjVar.zzb() == null) {
                    String str3 = this.zzc;
                    if (str3 != null ? str3.equals(zzjVar.zzc()) : zzjVar.zzc() == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
