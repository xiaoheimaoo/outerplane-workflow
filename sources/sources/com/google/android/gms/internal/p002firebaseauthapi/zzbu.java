package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzwl;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbu */
/* loaded from: classes2.dex */
public final class zzbu {
    private final List<zzbt> zza = new ArrayList();
    private zznr zzb = zznr.zza;
    private boolean zzc = false;

    public final zzbu zza(zzbt zzbtVar) {
        zzbu zzbuVar;
        boolean z;
        zzbuVar = zzbtVar.zze;
        if (zzbuVar != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        z = zzbtVar.zza;
        if (z) {
            zzb();
        }
        zzbtVar.zze = this;
        this.zza.add(zzbtVar);
        return this;
    }

    public final zzbs zza() throws GeneralSecurityException {
        zzbq zzbqVar;
        zzbw zzbwVar;
        zzbw zzbwVar2;
        zzbw zzbwVar3;
        zzbw zzbwVar4;
        int zza;
        zzcg zzcgVar;
        zzcg zzcgVar2;
        zzbq zzbqVar2;
        boolean z;
        zzbq zzbqVar3;
        zzwl.zza zzb;
        boolean z2;
        zzbq zzbqVar4;
        zzbw zzbwVar5;
        zzbw zzbwVar6;
        zzbw zzbwVar7;
        zzbw zzbwVar8;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        this.zzc = true;
        zzwl.zzb zzc = zzwl.zzc();
        ArrayList arrayList = new ArrayList(this.zza.size());
        List<zzbt> list = this.zza;
        for (int i = 0; i < list.size() - 1; i++) {
            zzbwVar5 = list.get(i).zzd;
            zzbwVar6 = zzbw.zza;
            if (zzbwVar5 == zzbwVar6) {
                zzbwVar7 = list.get(i + 1).zzd;
                zzbwVar8 = zzbw.zza;
                if (zzbwVar7 != zzbwVar8) {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
        }
        HashSet hashSet = new HashSet();
        Integer num = null;
        for (zzbt zzbtVar : this.zza) {
            zzbqVar = zzbtVar.zzb;
            if (zzbqVar == null) {
                throw new GeneralSecurityException("Key Status not set.");
            }
            zzbwVar = zzbtVar.zzd;
            if (zzbwVar == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            zzbwVar2 = zzbtVar.zzd;
            zzbwVar3 = zzbw.zza;
            if (zzbwVar2 == zzbwVar3) {
                zza = 0;
                while (true) {
                    if (zza != 0 && !hashSet.contains(Integer.valueOf(zza))) {
                        break;
                    }
                    zza = zzpy.zza();
                }
            } else {
                zzbwVar4 = zzbtVar.zzd;
                zza = zzbw.zza(zzbwVar4);
            }
            if (hashSet.contains(Integer.valueOf(zza))) {
                throw new GeneralSecurityException("Id " + zza + " is used twice in the keyset");
            }
            hashSet.add(Integer.valueOf(zza));
            zzcgVar = zzbtVar.zzc;
            Integer valueOf = zzcgVar.zza() ? Integer.valueOf(zza) : null;
            zzoc zza2 = zzoc.zza();
            zzcgVar2 = zzbtVar.zzc;
            zzbo zza3 = zza2.zza(zzcgVar2, valueOf);
            zzbqVar2 = zzbtVar.zzb;
            z = zzbtVar.zza;
            zzbv zzbvVar = new zzbv(zza3, zzbqVar2, zza, z);
            zzbqVar3 = zzbtVar.zzb;
            zzb = zzbs.zzb(zza3, zzbqVar3, zza);
            zzc.zza(zzb);
            z2 = zzbtVar.zza;
            if (z2) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                num = Integer.valueOf(zza);
                zzbqVar4 = zzbtVar.zzb;
                if (zzbqVar4 != zzbq.zza) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
            }
            arrayList.add(zzbvVar);
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzc.zza(num.intValue());
        zzwl zzwlVar = (zzwl) ((zzakg) zzc.zze());
        zzbs.zzd(zzwlVar);
        return new zzbs(zzwlVar, arrayList, this.zzb);
    }

    public final void zzb() {
        for (zzbt zzbtVar : this.zza) {
            zzbtVar.zza = false;
        }
    }
}
