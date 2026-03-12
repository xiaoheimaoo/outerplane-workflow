package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzad extends zzaa {
    private zzfw.zze zzg;
    private final /* synthetic */ zzx zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final int zza() {
        return this.zzg.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzaa
    public final boolean zzc() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzad(zzx zzxVar, String str, int i, zzfw.zze zzeVar) {
        super(str, i);
        this.zzh = zzxVar;
        this.zzg = zzeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(Long l, Long l2, zzgf.zzp zzpVar, boolean z) {
        Object[] objArr = (com.google.android.gms.internal.measurement.zzoh.zza() && this.zzh.zze().zzf(this.zza, zzbn.zzbx)) ? 1 : null;
        boolean zzf = this.zzg.zzf();
        boolean zzg = this.zzg.zzg();
        boolean zzh = this.zzg.zzh();
        Object[] objArr2 = (zzf || zzg || zzh) ? 1 : null;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z && objArr2 == null) {
            this.zzh.zzj().zzq().zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzb), this.zzg.zzi() ? Integer.valueOf(this.zzg.zza()) : null);
            return true;
        }
        zzfw.zzc zzb = this.zzg.zzb();
        boolean zzf2 = zzb.zzf();
        if (zzpVar.zzk()) {
            if (!zzb.zzh()) {
                this.zzh.zzj().zzr().zza("No number filter for long property. property", this.zzh.zzi().zzc(zzpVar.zzg()));
            } else {
                bool = zza(zza(zzpVar.zzc(), zzb.zzc()), zzf2);
            }
        } else if (zzpVar.zzi()) {
            if (!zzb.zzh()) {
                this.zzh.zzj().zzr().zza("No number filter for double property. property", this.zzh.zzi().zzc(zzpVar.zzg()));
            } else {
                bool = zza(zza(zzpVar.zza(), zzb.zzc()), zzf2);
            }
        } else if (zzpVar.zzm()) {
            if (!zzb.zzj()) {
                if (!zzb.zzh()) {
                    this.zzh.zzj().zzr().zza("No string or number filter defined. property", this.zzh.zzi().zzc(zzpVar.zzg()));
                } else if (zzpj.zzb(zzpVar.zzh())) {
                    bool = zza(zza(zzpVar.zzh(), zzb.zzc()), zzf2);
                } else {
                    this.zzh.zzj().zzr().zza("Invalid user property value for Numeric number filter. property, value", this.zzh.zzi().zzc(zzpVar.zzg()), zzpVar.zzh());
                }
            } else {
                bool = zza(zza(zzpVar.zzh(), zzb.zzd(), this.zzh.zzj()), zzf2);
            }
        } else {
            this.zzh.zzj().zzr().zza("User property has no value, property", this.zzh.zzi().zzc(zzpVar.zzg()));
        }
        this.zzh.zzj().zzq().zza("Property filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        this.zzc = true;
        if (!zzh || bool.booleanValue()) {
            if (!z || this.zzg.zzf()) {
                this.zzd = bool;
            }
            if (bool.booleanValue() && objArr2 != null && zzpVar.zzl()) {
                long zzd = zzpVar.zzd();
                if (l != null) {
                    zzd = l.longValue();
                }
                if (objArr != null && this.zzg.zzf() && !this.zzg.zzg() && l2 != null) {
                    zzd = l2.longValue();
                }
                if (this.zzg.zzg()) {
                    this.zzf = Long.valueOf(zzd);
                } else {
                    this.zze = Long.valueOf(zzd);
                }
            }
            return true;
        }
        return true;
    }
}
