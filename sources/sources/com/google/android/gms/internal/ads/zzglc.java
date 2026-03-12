package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzglc {
    @Nullable
    private String zza;
    @Nullable
    private zzgld zzb;
    @Nullable
    private zzghi zzc;

    private zzglc() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzglc(zzglb zzglbVar) {
    }

    public final zzglc zza(zzghi zzghiVar) {
        this.zzc = zzghiVar;
        return this;
    }

    public final zzglc zzb(zzgld zzgldVar) {
        this.zzb = zzgldVar;
        return this;
    }

    public final zzglc zzc(String str) {
        this.zza = str;
        return this;
    }

    public final zzglf zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            zzgld zzgldVar = this.zzb;
            if (zzgldVar != null) {
                zzghi zzghiVar = this.zzc;
                if (zzghiVar != null) {
                    if (zzghiVar.zza()) {
                        throw new GeneralSecurityException("dekParametersForNewKeys must note have ID Requirements");
                    }
                    if ((!zzgldVar.equals(zzgld.zza) || !(zzghiVar instanceof zzgji)) && ((!zzgldVar.equals(zzgld.zzc) || !(zzghiVar instanceof zzgkg)) && ((!zzgldVar.equals(zzgld.zzb) || !(zzghiVar instanceof zzgly)) && ((!zzgldVar.equals(zzgld.zzd) || !(zzghiVar instanceof zzghz)) && ((!zzgldVar.equals(zzgld.zze) || !(zzghiVar instanceof zzgiq)) && (!zzgldVar.equals(zzgld.zzf) || !(zzghiVar instanceof zzgjv))))))) {
                        String zzgldVar2 = this.zzb.toString();
                        String valueOf = String.valueOf(this.zzc);
                        throw new GeneralSecurityException("Cannot use parsing strategy " + zzgldVar2 + " when new keys are picked according to " + valueOf + ".");
                    }
                    return new zzglf(this.zza, this.zzb, this.zzc, null);
                }
                throw new GeneralSecurityException("dekParametersForNewKeys must be set");
            }
            throw new GeneralSecurityException("dekParsingStrategy must be set");
        }
        throw new GeneralSecurityException("kekUri must be set");
    }
}
