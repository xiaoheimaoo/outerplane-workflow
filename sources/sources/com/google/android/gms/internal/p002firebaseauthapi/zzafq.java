package com.google.android.gms.internal.p002firebaseauthapi;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafq  reason: invalid package */
/* loaded from: classes2.dex */
final class zzafq extends zzahe {
    private final String zza;
    private final String zzb;

    public final int hashCode() {
        String str = this.zza;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.zzb;
        return hashCode ^ (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahe
    final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahe
    final String zzb() {
        return this.zza;
    }

    public final String toString() {
        String str = this.zza;
        return "RecaptchaEnforcementState{provider=" + str + ", enforcementState=" + this.zzb + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafq(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzahe) {
            zzahe zzaheVar = (zzahe) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzaheVar.zzb()) : zzaheVar.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzaheVar.zza()) : zzaheVar.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
