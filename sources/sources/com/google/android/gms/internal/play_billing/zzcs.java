package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzcs {
    private final List zza = new ArrayList();

    public final zzcs zza(zzdh zzdhVar) {
        if (!(!zzdhVar.zzd())) {
            throw new IllegalArgumentException(zzbf.zza("range must not be empty, but was %s", zzdhVar));
        }
        this.zza.add(zzdhVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcs zzb(zzcs zzcsVar) {
        for (zzdh zzdhVar : zzcsVar.zza) {
            zza(zzdhVar);
        }
        return this;
    }

    public final zzct zzc() {
        zzcy zzcyVar;
        zzck zzckVar = new zzck(this.zza.size());
        Collections.sort(this.zza, zzdg.zza);
        Iterator it = this.zza.iterator();
        if (it instanceof zzcy) {
            zzcyVar = (zzcy) it;
        } else {
            zzcyVar = new zzcy(it);
        }
        while (zzcyVar.hasNext()) {
            zzdh zzdhVar = (zzdh) zzcyVar.next();
            while (zzcyVar.hasNext()) {
                zzdh zzdhVar2 = (zzdh) zzcyVar.zza();
                if (zzdhVar.zza.compareTo(zzdhVar2.zzb) <= 0 && zzdhVar2.zza.compareTo(zzdhVar.zzb) <= 0) {
                    zzbe.zzd(zzdhVar.zzb(zzdhVar2).zzd(), "Overlapping ranges not permitted but found %s overlapping %s", zzdhVar, zzdhVar2);
                    zzdhVar = zzdhVar.zzc((zzdh) zzcyVar.next());
                }
                zzckVar.zzd(zzdhVar);
            }
            zzckVar.zzd(zzdhVar);
        }
        zzco zze = zzckVar.zze();
        if (zze.isEmpty()) {
            return zzct.zzb();
        }
        if (zze.size() == 1) {
            zzdx listIterator = zze.listIterator(0);
            Object next = listIterator.next();
            if (!listIterator.hasNext()) {
                if (((zzdh) next).equals(zzdh.zza())) {
                    return zzct.zza();
                }
            } else {
                StringBuilder sb = new StringBuilder("expected one element but was: <");
                sb.append(next);
                for (int i = 0; i < 4 && listIterator.hasNext(); i++) {
                    sb.append(", ");
                    sb.append(listIterator.next());
                }
                if (listIterator.hasNext()) {
                    sb.append(", ...");
                }
                sb.append(Typography.greater);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return new zzct(zze);
    }
}
