package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzhi implements zzhl {
    private static final Map<Uri, zzhi> zza = new ArrayMap();
    private static final String[] zzb = {"key", "value"};
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private final ContentObserver zzf;
    private final Object zzg;
    private volatile Map<String, String> zzh;
    private final List<zzhj> zzi;

    public static zzhi zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzhi zzhiVar;
        synchronized (zzhi.class) {
            Map<Uri, zzhi> map = zza;
            zzhiVar = map.get(uri);
            if (zzhiVar == null) {
                try {
                    zzhi zzhiVar2 = new zzhi(contentResolver, uri, runnable);
                    try {
                        map.put(uri, zzhiVar2);
                    } catch (SecurityException unused) {
                    }
                    zzhiVar = zzhiVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzhiVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzhl
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }

    public final Map<String, String> zza() {
        Map<String, String> map = this.zzh;
        if (map == null) {
            synchronized (this.zzg) {
                map = this.zzh;
                if (map == null) {
                    map = zze();
                    this.zzh = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Map zzd() {
        Map hashMap;
        ContentProviderClient acquireUnstableContentProviderClient = this.zzc.acquireUnstableContentProviderClient(this.zzd);
        try {
            if (acquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.emptyMap();
            }
            Cursor query = acquireUnstableContentProviderClient.query(this.zzd, zzb, null, null, null);
            try {
                if (query == null) {
                    Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                    Map emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                int count = query.getCount();
                if (count == 0) {
                    Map emptyMap2 = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap2;
                }
                if (count <= 256) {
                    hashMap = new ArrayMap(count);
                } else {
                    hashMap = new HashMap(count, 1.0f);
                }
                while (query.moveToNext()) {
                    hashMap.put(query.getString(0), query.getString(1));
                }
                if (query.isAfterLast()) {
                    if (query != null) {
                        query.close();
                    }
                    return hashMap;
                }
                Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                Map emptyMap3 = Collections.emptyMap();
                if (query != null) {
                    query.close();
                }
                return emptyMap3;
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
            Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e);
            return Collections.emptyMap();
        } finally {
            acquireUnstableContentProviderClient.release();
        }
    }

    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzho.zza(new zzhn() { // from class: com.google.android.gms.internal.measurement.zzhh
                    @Override // com.google.android.gms.internal.measurement.zzhn
                    public final Object zza() {
                        Map zzd;
                        zzd = zzhi.this.zzd();
                        return zzd;
                    }
                });
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (SQLiteException | IllegalStateException | SecurityException e) {
            Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e);
            return Collections.emptyMap();
        }
    }

    private zzhi(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzhk zzhkVar = new zzhk(this, null);
        this.zzf = zzhkVar;
        this.zzg = new Object();
        this.zzi = new ArrayList();
        Preconditions.checkNotNull(contentResolver);
        Preconditions.checkNotNull(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
        contentResolver.registerContentObserver(uri, false, zzhkVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzb() {
        synchronized (zzhi.class) {
            for (zzhi zzhiVar : zza.values()) {
                zzhiVar.zzc.unregisterContentObserver(zzhiVar.zzf);
            }
            zza.clear();
        }
    }

    public final void zzc() {
        synchronized (this.zzg) {
            this.zzh = null;
            this.zze.run();
        }
        synchronized (this) {
            for (zzhj zzhjVar : this.zzi) {
                zzhjVar.zza();
            }
        }
    }
}
