package com.google.android.gms.internal.games_v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes2.dex */
public final class zzhh {
    private final List zza = new ArrayList();

    public final zzhh zza(zzhw zzhwVar) {
        if (!zzhwVar.zzb()) {
            this.zza.add(zzhwVar);
            return this;
        }
        throw new IllegalArgumentException(zzfv.zza("range must not be empty, but was %s", zzhwVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzhh zzb(zzhh zzhhVar) {
        for (zzhw zzhwVar : zzhhVar.zza) {
            zza(zzhwVar);
        }
        return this;
    }

    public final zzhi zzc() {
        zzhn zzhnVar;
        List list = this.zza;
        zzgz zzgzVar = new zzgz(list.size());
        int i = zzhw.zzc;
        Collections.sort(list, zzhv.zza);
        Iterator it = list.iterator();
        if (it instanceof zzhn) {
            zzhnVar = (zzhn) it;
        } else {
            zzhnVar = new zzhn(it);
        }
        while (zzhnVar.hasNext()) {
            zzhw zzhwVar = (zzhw) zzhnVar.next();
            while (zzhnVar.hasNext()) {
                zzhw zzhwVar2 = (zzhw) zzhnVar.zza();
                if (zzhwVar.zza.compareTo(zzhwVar2.zzb) <= 0 && zzhwVar2.zza.compareTo(zzhwVar.zzb) <= 0) {
                    zzfu.zza(zzhwVar.zzc(zzhwVar2).zzb(), "Overlapping ranges not permitted but found %s overlapping %s", zzhwVar, zzhwVar2);
                    zzhwVar = zzhwVar.zzd((zzhw) zzhnVar.next());
                }
                zzgzVar.zzd(zzhwVar);
            }
            zzgzVar.zzd(zzhwVar);
        }
        zzhd zze = zzgzVar.zze();
        if (zze.isEmpty()) {
            return zzhi.zza();
        }
        if (zze.size() == 1) {
            zzim listIterator = zze.listIterator(0);
            Object next = listIterator.next();
            if (!listIterator.hasNext()) {
                if (((zzhw) next).equals(zzhw.zza())) {
                    return zzhi.zzb();
                }
            } else {
                StringBuilder sb = new StringBuilder("expected one element but was: <");
                sb.append(next);
                for (int i2 = 0; i2 < 4 && listIterator.hasNext(); i2++) {
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
        return new zzhi(zze);
    }
}
