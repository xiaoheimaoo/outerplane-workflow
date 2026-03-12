package com.google.android.gms.internal.p002firebaseauthapi;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzac  reason: invalid package */
/* loaded from: classes2.dex */
abstract class zzac extends zzd<String> {
    final CharSequence zza;
    private final zzf zzb;
    private final boolean zzc;
    private int zzd = 0;
    private int zze;

    abstract int zza(int i);

    abstract int zzb(int i);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzd
    protected final /* synthetic */ String zza() {
        int i = this.zzd;
        while (true) {
            int i2 = this.zzd;
            if (i2 != -1) {
                int zzb = zzb(i2);
                if (zzb == -1) {
                    zzb = this.zza.length();
                    this.zzd = -1;
                } else {
                    this.zzd = zza(zzb);
                }
                int i3 = this.zzd;
                if (i3 == i) {
                    int i4 = i3 + 1;
                    this.zzd = i4;
                    if (i4 > this.zza.length()) {
                        this.zzd = -1;
                    }
                } else {
                    while (i < zzb && this.zzb.zza(this.zza.charAt(i))) {
                        i++;
                    }
                    while (zzb > i && this.zzb.zza(this.zza.charAt(zzb - 1))) {
                        zzb--;
                    }
                    int i5 = this.zze;
                    if (i5 == 1) {
                        zzb = this.zza.length();
                        this.zzd = -1;
                        while (zzb > i && this.zzb.zza(this.zza.charAt(zzb - 1))) {
                            zzb--;
                        }
                    } else {
                        this.zze = i5 - 1;
                    }
                    return this.zza.subSequence(i, zzb).toString();
                }
            } else {
                zzb();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzac(zzv zzvVar, CharSequence charSequence) {
        zzf zzfVar;
        int i;
        zzfVar = zzvVar.zza;
        this.zzb = zzfVar;
        this.zzc = false;
        i = zzvVar.zzc;
        this.zze = i;
        this.zza = charSequence;
    }
}
