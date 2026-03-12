package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzax {
    private final String zza;
    private long zzb;
    private final /* synthetic */ zzar zzc;

    public final List<zzav> zza() {
        Cursor query;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                query = this.zzc.f_().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{this.zza, String.valueOf(this.zzb)}, null, null, "rowid", "1000");
            } catch (SQLiteException e) {
                this.zzc.zzj().zzg().zza("Data loss. Error querying raw events batch. appId", zzgo.zza(this.zza), e);
                if (0 != 0) {
                    cursor.close();
                }
            }
            if (!query.moveToFirst()) {
                List<zzav> emptyList = Collections.emptyList();
                if (query != null) {
                    query.close();
                }
                return emptyList;
            }
            do {
                long j = query.getLong(0);
                long j2 = query.getLong(3);
                boolean z = query.getLong(5) == 1;
                byte[] blob = query.getBlob(4);
                if (j > this.zzb) {
                    this.zzb = j;
                }
                try {
                    zzgf.zzf.zza zzaVar = (zzgf.zzf.zza) zzpj.zza(zzgf.zzf.zze(), blob);
                    String string = query.getString(1);
                    if (string == null) {
                        string = "";
                    }
                    zzaVar.zza(string).zzb(query.getLong(2));
                    arrayList.add(new zzav(j, j2, z, (zzgf.zzf) ((com.google.android.gms.internal.measurement.zzkg) zzaVar.zzaj())));
                } catch (IOException e2) {
                    this.zzc.zzj().zzg().zza("Data loss. Failed to merge raw event. appId", zzgo.zza(this.zza), e2);
                }
            } while (query.moveToNext());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public zzax(zzar zzarVar, String str) {
        this.zzc = zzarVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = -1L;
    }

    public zzax(zzar zzarVar, String str, long j) {
        long zza;
        this.zzc = zzarVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        zza = zzarVar.zza("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j)}, -1L);
        this.zzb = zza;
    }
}
