package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.RemoteException;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzhc implements zzhe {
    @Override // com.google.android.gms.internal.measurement.zzhe
    public final String zza(ContentResolver contentResolver, String str) throws zzhd {
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(zzgw.zza);
        try {
            if (acquireUnstableContentProviderClient == null) {
                throw new zzhd("Unable to acquire ContentProviderClient");
            }
            try {
                Cursor query = acquireUnstableContentProviderClient.query(zzgw.zza, null, null, new String[]{str}, null);
                try {
                    if (query == null) {
                        throw new zzhd("ContentProvider query returned null cursor");
                    }
                    if (query.moveToFirst()) {
                        String string = query.getString(1);
                        if (query != null) {
                            query.close();
                        }
                        return string;
                    }
                    if (query != null) {
                        query.close();
                    }
                    acquireUnstableContentProviderClient.release();
                    return null;
                } catch (Throwable th) {
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (RemoteException e) {
                throw new zzhd("ContentProvider query failed", e);
            }
        } finally {
            acquireUnstableContentProviderClient.release();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhe
    public final <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zzhb<T> zzhbVar) throws zzhd {
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(zzgw.zzb);
        try {
            if (acquireUnstableContentProviderClient == null) {
                throw new zzhd("Unable to acquire ContentProviderClient");
            }
            try {
                Cursor query = acquireUnstableContentProviderClient.query(zzgw.zzb, null, null, strArr, null);
                try {
                    if (query == null) {
                        throw new zzhd("ContentProvider query returned null cursor");
                    }
                    T zza = zzhbVar.zza(query.getCount());
                    while (query.moveToNext()) {
                        zza.put(query.getString(0), query.getString(1));
                    }
                    if (query.isAfterLast()) {
                        if (query != null) {
                            query.close();
                        }
                        return zza;
                    }
                    throw new zzhd("Cursor read incomplete (ContentProvider dead?)");
                } catch (Throwable th) {
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (RemoteException e) {
                throw new zzhd("ContentProvider query failed", e);
            }
        } finally {
            acquireUnstableContentProviderClient.release();
        }
    }
}
