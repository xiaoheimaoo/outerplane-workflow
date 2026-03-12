package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.time.DurationKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzar extends zzot {
    private final zzaz zzm;
    private final zzoh zzn;
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    static final String[] zza = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzj = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzk = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzl = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    private final int zzr(String str) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        try {
            int zzb2 = zze().zzb(str, zzbn.zzv);
            if (zzb2 <= 0) {
                return 0;
            }
            return f_().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(zzb2)});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit queued batches. appId", zzgo.zza(str), e);
            return 0;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        try {
            return f_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting conditional property", zzgo.zza(str), zzi().zzc(str2), e);
            return 0;
        }
    }

    public final long zza(String str) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        try {
            return f_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min((int) DurationKt.NANOS_IN_MILLIS, zze().zzb(str, zzbn.zzp))))});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzgo.zza(str), e);
            return 0L;
        }
    }

    public final long c_() {
        Cursor cursor = null;
        try {
            try {
                cursor = f_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1L;
                }
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying raw events", e);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long zza(zzgf.zzk zzkVar) throws IOException {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzkVar);
        Preconditions.checkNotEmpty(zzkVar.zzab());
        byte[] zzce = zzkVar.zzce();
        long zza2 = h_().zza(zzce);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkVar.zzab());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza2));
        contentValues.put("metadata", zzce);
        try {
            f_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return zza2;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzgo.zza(zzkVar.zzab()), e);
            throw e;
        }
    }

    public final long zza(String str, zzgf.zzj zzjVar, String str2, Map<String, String> map, zzlu zzluVar, Long l) {
        int delete;
        zzv();
        zzam();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(str);
        if (zze().zza(zzbn.zzch)) {
            zzv();
            zzam();
            if (zzab()) {
                long zza2 = zzo().zzb.zza();
                long elapsedRealtime = zzb().elapsedRealtime();
                if (Math.abs(elapsedRealtime - zza2) > zzai.zzo()) {
                    zzo().zzb.zza(elapsedRealtime);
                    zzv();
                    zzam();
                    if (zzab() && (delete = f_().delete("upload_queue", zzap(), new String[0])) > 0) {
                        zzj().zzq().zza("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                    }
                    if (zze().zza(zzbn.zzcj)) {
                        zzr(str);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(entry.getKey() + "=" + entry.getValue());
            }
            byte[] zzce = zzjVar.zzce();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("measurement_batch", zzce);
            contentValues.put("upload_uri", str2);
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            if (size > 0) {
                sb.append((CharSequence) arrayList.get(0));
                int i = 1;
                while (i < size) {
                    sb.append((CharSequence) "\r\n");
                    Object obj = arrayList.get(i);
                    i++;
                    sb.append((CharSequence) obj);
                }
            }
            contentValues.put("upload_headers", sb.toString());
            contentValues.put("upload_type", Integer.valueOf(zzluVar.zza()));
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzb().currentTimeMillis()));
            contentValues.put("retry_count", (Integer) 0);
            if (l != null) {
                contentValues.put("associated_row_id", l);
            }
            try {
                long insert = f_().insert("upload_queue", null, contentValues);
                if (insert == -1) {
                    zzj().zzg().zza("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
                }
                return insert;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing MeasurementBatch to upload_queue. appId", str, e);
                return -1L;
            }
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzb(String str, String str2) {
        long zza2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        SQLiteDatabase f_ = f_();
        f_.beginTransaction();
        long j = 0;
        try {
            try {
                zza2 = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                if (zza2 == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (f_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzj().zzg().zza("Failed to insert column (got -1). appId", zzgo.zza(str), str2);
                        return -1L;
                    }
                    zza2 = 0;
                }
            } catch (SQLiteException e) {
                e = e;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + zza2));
                if (f_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                    zzj().zzg().zza("Failed to update column (got 0). appId", zzgo.zza(str), str2);
                    return -1L;
                }
                f_.setTransactionSuccessful();
                return zza2;
            } catch (SQLiteException e2) {
                e = e2;
                j = zza2;
                zzj().zzg().zza("Error inserting column. appId", zzgo.zza(str), str2, e);
                f_.endTransaction();
                return j;
            }
        } finally {
            f_.endTransaction();
        }
    }

    public final long d_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    public final long e_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = f_().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = f_().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SQLiteDatabase f_() {
        zzv();
        try {
            return this.zzm.getWritableDatabase();
        } catch (SQLiteException e) {
            zzj().zzr().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0089: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0089 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle zzc(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzv()
            r5.zzam()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.f_()     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L73
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r2 != 0) goto L30
            com.google.android.gms.measurement.internal.zzgo r6 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzq()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            java.lang.String r2 = "Default event parameters not found"
            r6.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r1 == 0) goto L2f
            r1.close()
        L2f:
            return r0
        L30:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzgf$zzf$zza r3 = com.google.android.gms.internal.measurement.zzgf.zzf.zze()     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzlp r2 = com.google.android.gms.measurement.internal.zzpj.zza(r3, r2)     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzgf$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzgf.zzf.zza) r2     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzlm r2 = r2.zzaj()     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzkg r2 = (com.google.android.gms.internal.measurement.zzkg) r2     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.internal.measurement.zzgf$zzf r2 = (com.google.android.gms.internal.measurement.zzgf.zzf) r2     // Catch: java.io.IOException -> L57 android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            r5.h_()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            java.util.List r6 = r2.zzh()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zzpj.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r1 == 0) goto L56
            r1.close()
        L56:
            return r6
        L57:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgo r3 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgo.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            r3.zza(r4, r6, r2)     // Catch: android.database.sqlite.SQLiteException -> L6f java.lang.Throwable -> L88
            if (r1 == 0) goto L6e
            r1.close()
        L6e:
            return r0
        L6f:
            r6 = move-exception
            goto L75
        L71:
            r6 = move-exception
            goto L8a
        L73:
            r6 = move-exception
            r1 = r0
        L75:
            com.google.android.gms.measurement.internal.zzgo r2 = r5.zzj()     // Catch: java.lang.Throwable -> L88
            com.google.android.gms.measurement.internal.zzgq r2 = r2.zzg()     // Catch: java.lang.Throwable -> L88
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r6)     // Catch: java.lang.Throwable -> L88
            if (r1 == 0) goto L87
            r1.close()
        L87:
            return r0
        L88:
            r6 = move-exception
            r0 = r1
        L8a:
            if (r0 == 0) goto L8f
            r0.close()
        L8f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzc(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0091: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0091 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzgf.zzf, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzv()
            r7.zzam()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.f_()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r2 != 0) goto L37
            com.google.android.gms.measurement.internal.zzgo r8 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzgq r8 = r8.zzq()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzgf$zzf$zza r4 = com.google.android.gms.internal.measurement.zzgf.zzf.zze()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzlp r2 = com.google.android.gms.measurement.internal.zzpj.zza(r4, r2)     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzgf$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzgf.zzf.zza) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzlm r2 = r2.zzaj()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzkg r2 = (com.google.android.gms.internal.measurement.zzkg) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzgf$zzf r2 = (com.google.android.gms.internal.measurement.zzgf.zzf) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            return r8
        L5f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgo r3 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgo.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L76
            r1.close()
        L76:
            return r0
        L77:
            r8 = move-exception
            goto L7d
        L79:
            r8 = move-exception
            goto L92
        L7b:
            r8 = move-exception
            r1 = r0
        L7d:
            com.google.android.gms.measurement.internal.zzgo r9 = r7.zzj()     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzgq r9 = r9.zzg()     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8f
            r1.close()
        L8f:
            return r0
        L90:
            r8 = move-exception
            r0 = r1
        L92:
            if (r0 == 0) goto L97
            r0.close()
        L97:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0323: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:100:0x0323 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015b A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01b0 A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01bf A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01df A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01f0 A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0226 A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x024c A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0262 A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x028e A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02a3 A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02b6 A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02d6 A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02ee A[Catch: SQLiteException -> 0x0305, all -> 0x0322, TRY_LEAVE, TryCatch #0 {all -> 0x0322, blocks: (B:4:0x0081, B:9:0x008d, B:11:0x00a6, B:12:0x00ad, B:14:0x00c2, B:15:0x00ca, B:17:0x010c, B:22:0x0116, B:26:0x0160, B:28:0x018f, B:33:0x0199, B:37:0x01b4, B:39:0x01bf, B:40:0x01d1, B:42:0x01df, B:43:0x01e8, B:45:0x01f0, B:49:0x01f9, B:51:0x0226, B:53:0x0232, B:54:0x0244, B:56:0x024c, B:60:0x0255, B:68:0x026e, B:72:0x0298, B:74:0x02a3, B:75:0x02ae, B:77:0x02b6, B:78:0x02c1, B:80:0x02d6, B:82:0x02de, B:83:0x02e5, B:85:0x02ee, B:71:0x028e, B:63:0x0262, B:67:0x026a, B:36:0x01b0, B:25:0x015b, B:95:0x030b), top: B:104:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0301  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzh zzd(java.lang.String r52) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzd(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzag zzc(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzag");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008a: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:31:0x008a */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzat zze(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzv()
            r11.zzam()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.f_()     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L70
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L70
            java.lang.String r4 = "app_id=?"
            r9 = 1
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L70
            r10 = 0
            r5[r10] = r12     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L70
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L70
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            if (r2 != 0) goto L35
            if (r1 == 0) goto L34
            r1.close()
        L34:
            return r0
        L35:
            byte[] r2 = r1.getBlob(r10)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            java.lang.String r3 = r1.getString(r9)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            r4 = 2
            java.lang.String r4 = r1.getString(r4)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            boolean r5 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            if (r5 == 0) goto L59
            com.google.android.gms.measurement.internal.zzgo r5 = r11.zzj()     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzg()     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgo.zza(r12)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            r5.zza(r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
        L59:
            if (r2 != 0) goto L61
            if (r1 == 0) goto L60
            r1.close()
        L60:
            return r0
        L61:
            com.google.android.gms.measurement.internal.zzat r5 = new com.google.android.gms.measurement.internal.zzat     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            r5.<init>(r2, r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L89
            if (r1 == 0) goto L6b
            r1.close()
        L6b:
            return r5
        L6c:
            r2 = move-exception
            goto L72
        L6e:
            r12 = move-exception
            goto L8b
        L70:
            r2 = move-exception
            r1 = r0
        L72:
            com.google.android.gms.measurement.internal.zzgo r3 = r11.zzj()     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> L89
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzgo.zza(r12)     // Catch: java.lang.Throwable -> L89
            r3.zza(r4, r12, r2)     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L88
            r1.close()
        L88:
            return r0
        L89:
            r12 = move-exception
            r0 = r1
        L8b:
            if (r0 == 0) goto L90
            r0.close()
        L90:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zze(java.lang.String):com.google.android.gms.measurement.internal.zzat");
    }

    public final zzas zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return zza(j, str, 1L, false, false, z3, false, z5, z6, z7);
    }

    public final zzas zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        String[] strArr = {str};
        zzas zzasVar = new zzas();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase f_ = f_();
                Cursor query = f_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    zzj().zzr().zza("Not updating daily counts, app is not known. appId", zzgo.zza(str));
                    if (query != null) {
                        query.close();
                    }
                    return zzasVar;
                }
                if (query.getLong(0) == j) {
                    zzasVar.zzb = query.getLong(1);
                    zzasVar.zza = query.getLong(2);
                    zzasVar.zzc = query.getLong(3);
                    zzasVar.zzd = query.getLong(4);
                    zzasVar.zze = query.getLong(5);
                    zzasVar.zzf = query.getLong(6);
                    zzasVar.zzg = query.getLong(7);
                }
                if (z) {
                    zzasVar.zzb += j2;
                }
                if (z2) {
                    zzasVar.zza += j2;
                }
                if (z3) {
                    zzasVar.zzc += j2;
                }
                if (z4) {
                    zzasVar.zzd += j2;
                }
                if (z5) {
                    zzasVar.zze += j2;
                }
                if (z6) {
                    zzasVar.zzf += j2;
                }
                if (z7) {
                    zzasVar.zzg += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(zzasVar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzasVar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzasVar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzasVar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzasVar.zze));
                contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzasVar.zzf));
                contentValues.put("daily_registered_triggers_count", Long.valueOf(zzasVar.zzg));
                f_.update("apps", contentValues, "app_id=?", strArr);
                if (query != null) {
                    query.close();
                }
                return zzasVar;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error updating daily counts. appId", zzgo.zza(str), e);
                if (0 != 0) {
                    cursor.close();
                }
                return zzasVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzbd zzf(String str) {
        Preconditions.checkNotNull(str);
        zzv();
        zzam();
        return zzbd.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzbh zzd(String str, String str2) {
        return zzc("events", str, str2);
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x014c: MOVE  (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:66:0x014c */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.measurement.internal.zzbh zzc(java.lang.String r26, java.lang.String r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzc(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzbh");
    }

    public final zzjj zzg(String str) {
        Preconditions.checkNotNull(str);
        zzv();
        zzam();
        return zzjj.zzb(zza("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzjj zzh(String str) {
        Preconditions.checkNotNull(str);
        zzv();
        zzam();
        zzjj zzjjVar = (zzjj) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzaw() { // from class: com.google.android.gms.measurement.internal.zzaq
            @Override // com.google.android.gms.measurement.internal.zzaw
            public final Object zza(Cursor cursor) {
                zzjj zza2;
                zza2 = zzjj.zza(cursor.getString(0), cursor.getInt(1));
                return zza2;
            }
        });
        return zzjjVar == null ? zzjj.zza : zzjjVar;
    }

    private final zzpi zza(String str, long j, byte[] bArr, String str2, String str3, int i, int i2, long j2, long j3) {
        zzlu zzluVar;
        if (TextUtils.isEmpty(str2)) {
            zzj().zzc().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            zzgf.zzj.zzb zzbVar = (zzgf.zzj.zzb) zzpj.zza(zzgf.zzj.zzb(), bArr);
            zzlu[] values = zzlu.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    zzluVar = values[i3];
                    if (zzluVar.zza() == i) {
                        break;
                    }
                    i3++;
                } else {
                    zzluVar = zzlu.UNKNOWN;
                    break;
                }
            }
            if (zzluVar != zzlu.GOOGLE_SIGNAL && zzluVar != zzlu.GOOGLE_SIGNAL_PENDING && i2 > 0) {
                ArrayList arrayList = new ArrayList();
                for (zzgf.zzk zzkVar : zzbVar.zzd()) {
                    zzgf.zzk.zza zzch = zzkVar.zzch();
                    zzgf.zzk.zza zzaVar = zzch;
                    zzgf.zzk.zza zzaVar2 = zzch;
                    zzaVar2.zzi(i2);
                    arrayList.add((zzgf.zzk) ((com.google.android.gms.internal.measurement.zzkg) zzaVar2.zzaj()));
                }
                zzbVar.zzb();
                zzbVar.zza(arrayList);
            }
            HashMap hashMap = new HashMap();
            if (str3 != null) {
                String[] split = str3.split("\r\n");
                int length2 = split.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        break;
                    }
                    String str4 = split[i4];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] split2 = str4.split("=", 2);
                    if (split2.length != 2) {
                        zzj().zzg().zza("Invalid upload header: ", str4);
                        break;
                    }
                    hashMap.put(split2[0], split2[1]);
                    i4++;
                }
            }
            return new zzph().zzc(j).zza((zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzbVar.zzaj())).zza(str2).zza(hashMap).zza(zzluVar).zzb(j2).zza(j3).zza();
        } catch (IOException e) {
            zzj().zzg().zza("Failed to queued MeasurementBatch from upload_queue. appId", str, e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzpi zzi(java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzi(java.lang.String):com.google.android.gms.measurement.internal.zzpi");
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00ac: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:27:0x00ac */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzpi zza(long r17) {
        /*
            r16 = this;
            com.google.android.gms.measurement.internal.zzai r0 = r16.zze()
            com.google.android.gms.measurement.internal.zzfx<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzbn.zzcj
            boolean r0 = r0.zza(r1)
            r1 = 0
            if (r0 != 0) goto Le
            return r1
        Le:
            r16.zzv()
            r16.zzam()
            android.database.sqlite.SQLiteDatabase r2 = r16.f_()     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            java.lang.String r3 = "upload_queue"
            java.lang.String r4 = "rowId"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "measurement_batch"
            java.lang.String r7 = "upload_uri"
            java.lang.String r8 = "upload_headers"
            java.lang.String r9 = "upload_type"
            java.lang.String r10 = "retry_count"
            java.lang.String r11 = "creation_timestamp"
            java.lang.String r12 = "associated_row_id"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12}     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            java.lang.String r5 = "rowId=?"
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            java.lang.String r7 = java.lang.String.valueOf(r17)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            r8 = 0
            r6[r8] = r7     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "1"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L92
            boolean r3 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            if (r3 != 0) goto L51
            if (r2 == 0) goto L50
            r2.close()
        L50:
            return r1
        L51:
            java.lang.String r0 = r2.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            r0 = 2
            byte[] r7 = r2.getBlob(r0)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            r0 = 3
            java.lang.String r8 = r2.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            r0 = 4
            java.lang.String r9 = r2.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            r0 = 5
            int r10 = r2.getInt(r0)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            r0 = 6
            int r11 = r2.getInt(r0)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            r0 = 7
            long r12 = r2.getLong(r0)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            r0 = 8
            long r14 = r2.getLong(r0)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            r3 = r16
            r5 = r17
            com.google.android.gms.measurement.internal.zzpi r0 = r3.zza(r4, r5, r7, r8, r9, r10, r11, r12, r14)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lab
            if (r2 == 0) goto L8d
            r2.close()
        L8d:
            return r0
        L8e:
            r0 = move-exception
            goto L94
        L90:
            r0 = move-exception
            goto Lad
        L92:
            r0 = move-exception
            r2 = r1
        L94:
            com.google.android.gms.measurement.internal.zzgo r3 = r16.zzj()     // Catch: java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r4 = "Error to querying MeasurementBatch from upload_queue. rowId"
            java.lang.Long r5 = java.lang.Long.valueOf(r17)     // Catch: java.lang.Throwable -> Lab
            r3.zza(r4, r5, r0)     // Catch: java.lang.Throwable -> Lab
            if (r2 == 0) goto Laa
            r2.close()
        Laa:
            return r1
        Lab:
            r0 = move-exception
            r1 = r2
        Lad:
            if (r1 == 0) goto Lb2
            r1.close()
        Lb2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(long):com.google.android.gms.measurement.internal.zzpi");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzpo zze(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzv()
            r18.zzam()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.f_()     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            r1 = 0
            r14[r1] = r19     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            r2 = 1
            r14[r2] = r8     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            if (r3 != 0) goto L3f
            if (r10 == 0) goto L3e
            r10.close()
        L3e:
            return r9
        L3f:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            if (r7 != 0) goto L51
            if (r10 == 0) goto L50
            r10.close()
        L50:
            return r9
        L51:
            java.lang.String r3 = r10.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            com.google.android.gms.measurement.internal.zzpo r0 = new com.google.android.gms.measurement.internal.zzpo     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            if (r1 == 0) goto L76
            com.google.android.gms.measurement.internal.zzgo r1 = r18.zzj()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza(r19)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lad
        L76:
            if (r10 == 0) goto L7b
            r10.close()
        L7b:
            return r0
        L7c:
            r0 = move-exception
            goto L8e
        L7e:
            r0 = move-exception
            r11 = r18
            goto Lae
        L82:
            r0 = move-exception
            r11 = r18
            goto L8e
        L86:
            r0 = move-exception
            r11 = r18
            goto Laf
        L8a:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L8e:
            com.google.android.gms.measurement.internal.zzgo r1 = r18.zzj()     // Catch: java.lang.Throwable -> Lad
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgo.zza(r19)     // Catch: java.lang.Throwable -> Lad
            com.google.android.gms.measurement.internal.zzgl r4 = r18.zzi()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r4 = r4.zzc(r8)     // Catch: java.lang.Throwable -> Lad
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> Lad
            if (r10 == 0) goto Lac
            r10.close()
        Lac:
            return r9
        Lad:
            r0 = move-exception
        Lae:
            r9 = r10
        Laf:
            if (r9 == 0) goto Lb4
            r9.close()
        Lb4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzpo");
    }

    private final zzgf.zzk zzb(String str, long j) {
        zzgf.zzk zzkVar;
        Cursor cursor = null;
        try {
            try {
                Cursor query = f_().query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str, Long.toString(j)}, null, null, "rowid", "2");
                try {
                    try {
                        if (!query.moveToFirst()) {
                            zzj().zzg().zza("Raw event metadata record is missing. appId", zzgo.zza(str));
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        }
                        try {
                            zzgf.zzk zzkVar2 = (zzgf.zzk) ((com.google.android.gms.internal.measurement.zzkg) ((zzgf.zzk.zza) zzpj.zza(zzgf.zzk.zzx(), query.getBlob(0))).zzaj());
                            try {
                                if (query.moveToNext()) {
                                    zzj().zzr().zza("Get multiple raw event metadata records, expected one. appId", zzgo.zza(str));
                                }
                                query.close();
                                if (query != null) {
                                    query.close();
                                    return zzkVar2;
                                }
                                return zzkVar2;
                            } catch (SQLiteException e) {
                                cursor = query;
                                zzkVar = zzkVar2;
                                e = e;
                                zzj().zzg().zza("Data loss. Error selecting raw event. appId", zzgo.zza(str), e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return zzkVar;
                            }
                        } catch (IOException e2) {
                            zzj().zzg().zza("Data loss. Failed to merge raw event metadata. appId", zzgo.zza(str), e2);
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        cursor = query;
                        zzkVar = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                zzkVar = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        } else if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type == 4) {
                        zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
                        return null;
                    }
                    zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                    return null;
                }
                return cursor.getString(i);
            }
            return Double.valueOf(cursor.getDouble(i));
        } else {
            return Long.valueOf(cursor.getLong(i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final <T> T zza(java.lang.String r3, java.lang.String[] r4, com.google.android.gms.measurement.internal.zzaw<T> r5) {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.f_()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30
            boolean r4 = r3.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r4 != 0) goto L22
            com.google.android.gms.measurement.internal.zzgo r4 = r2.zzj()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            com.google.android.gms.measurement.internal.zzgq r4 = r4.zzq()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            java.lang.String r5 = "No data found"
            r4.zza(r5)     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r3 == 0) goto L21
            r3.close()
        L21:
            return r0
        L22:
            java.lang.Object r4 = r5.zza(r3)     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r3 == 0) goto L2b
            r3.close()
        L2b:
            return r4
        L2c:
            r4 = move-exception
            goto L32
        L2e:
            r4 = move-exception
            goto L47
        L30:
            r4 = move-exception
            r3 = r0
        L32:
            com.google.android.gms.measurement.internal.zzgo r5 = r2.zzj()     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.measurement.internal.zzgq r5 = r5.zzg()     // Catch: java.lang.Throwable -> L45
            java.lang.String r1 = "Error querying database."
            r5.zza(r1, r4)     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L44
            r3.close()
        L44:
            return r0
        L45:
            r4 = move-exception
            r0 = r3
        L47:
            if (r0 == 0) goto L4c
            r0.close()
        L4c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(java.lang.String, java.lang.String[], com.google.android.gms.measurement.internal.zzaw):java.lang.Object");
    }

    private final String zzap() {
        long currentTimeMillis = zzb().currentTimeMillis();
        return "(" + String.format(Locale.US, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", Integer.valueOf(zzlu.GOOGLE_SIGNAL.zza()), Long.valueOf(currentTimeMillis), Long.valueOf(zzbn.zzan.zza(null).longValue())) + " OR " + String.format(Locale.US, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", Integer.valueOf(zzlu.GOOGLE_SIGNAL.zza()), Long.valueOf(currentTimeMillis), Long.valueOf(zzai.zzm())) + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zzb(long r5) {
        /*
            r4 = this;
            r4.zzv()
            r4.zzam()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.f_()     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r1 != 0) goto L34
            com.google.android.gms.measurement.internal.zzgo r6 = r4.zzj()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzgq r6 = r6.zzq()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L33
            r5.close()
        L33:
            return r0
        L34:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L3d
            r5.close()
        L3d:
            return r6
        L3e:
            r6 = move-exception
            goto L44
        L40:
            r6 = move-exception
            goto L59
        L42:
            r6 = move-exception
            r5 = r0
        L44:
            com.google.android.gms.measurement.internal.zzgo r1 = r4.zzj()     // Catch: java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzgq r1 = r1.zzg()     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L56
            r5.close()
        L56:
            return r0
        L57:
            r6 = move-exception
            r0 = r5
        L59:
            if (r0 == 0) goto L5e
            r0.close()
        L5e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzb(long):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String g_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.f_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L24 android.database.sqlite.SQLiteException -> L29
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r2 == 0) goto L1c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            return r1
        L1c:
            if (r0 == 0) goto L21
            r0.close()
        L21:
            return r1
        L22:
            r2 = move-exception
            goto L2b
        L24:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3f
        L29:
            r2 = move-exception
            r0 = r1
        L2b:
            com.google.android.gms.measurement.internal.zzgo r3 = r6.zzj()     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.zzgq r3 = r3.zzg()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return r1
        L3e:
            r1 = move-exception
        L3f:
            if (r0 == 0) goto L44
            r0.close()
        L44:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.g_():java.lang.String");
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            try {
                cursor = f_().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getString(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return str2;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static String zzb(List<Integer> list) {
        return list.isEmpty() ? "" : String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x0171 A[EDGE_INSN: B:88:0x0171->B:69:0x0171 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.zzgf.zzk, java.lang.Long>> zza(java.lang.String r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(java.lang.String, int, int):java.util.List");
    }

    public final List<zzag> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0052, code lost:
        zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzag> zza(java.lang.String r25, java.lang.String[] r26) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final List<zzog> zzj(String str) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = f_().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new zzog(string, cursor.getLong(1), cursor.getInt(2)));
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying trigger uris. appId", zzgo.zza(str), e);
                List<zzog> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzpi> zza(String str, zzop zzopVar, int i) {
        int i2;
        Cursor query;
        if (!zze().zza(zzbn.zzcj)) {
            return Collections.emptyList();
        }
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        Cursor cursor = null;
        try {
            try {
                i2 = 0;
                query = f_().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id"}, "app_id=?" + zzb(zzopVar.zza) + " AND NOT " + zzap(), new String[]{str}, null, null, "creation_timestamp ASC", i > 0 ? String.valueOf(i) : null);
            } catch (SQLiteException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                ArrayList arrayList2 = arrayList;
                zzpi zza2 = zza(str, query.getLong(i2), query.getBlob(2), query.getString(3), query.getString(4), query.getInt(5), query.getInt(6), query.getLong(7), query.getLong(8));
                if (zza2 != null) {
                    arrayList2.add(zza2);
                }
                arrayList = arrayList2;
                i2 = 0;
            }
            ArrayList arrayList3 = arrayList;
            if (query != null) {
                query.close();
            }
            return arrayList3;
        } catch (SQLiteException e2) {
            e = e2;
            cursor = query;
            zzj().zzg().zza("Error to querying MeasurementBatch from upload_queue. appId", str, e);
            List<zzpi> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzpo> zzk(String str) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = f_().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j = cursor.getLong(2);
                    Object zza2 = zza(cursor, 3);
                    if (zza2 == null) {
                        zzj().zzg().zza("Read invalid user property value, ignoring it. appId", zzgo.zza(str));
                    } else {
                        arrayList.add(new zzpo(str, str2, string, j, zza2));
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying user properties. appId", zzgo.zza(str), e);
                List<zzpo> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009b, code lost:
        zzj().zzg().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzpo> zzb(java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, zzgf.zzm> zzl(String str) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = f_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, zzgf.zzm> emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i = query.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i), (zzgf.zzm) ((com.google.android.gms.internal.measurement.zzkg) ((zzgf.zzm.zza) zzpj.zza(zzgf.zzm.zze(), query.getBlob(1))).zzaj()));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzgo.zza(str), Integer.valueOf(i), e);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filter results. appId", zzgo.zza(str), e2);
                Map<Integer, zzgf.zzm> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<zzfw.zzb>> zzm(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor query = f_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzfw.zzb>> emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzfw.zzb zzbVar = (zzfw.zzb) ((com.google.android.gms.internal.measurement.zzkg) ((zzfw.zzb.zza) zzpj.zza(zzfw.zzb.zzc(), query.getBlob(1))).zzaj());
                        if (zzbVar.zzk()) {
                            int i = query.getInt(0);
                            List list = (List) arrayMap.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), list);
                            }
                            list.add(zzbVar);
                        }
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgo.zza(str), e);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e2);
            Map<Integer, List<zzfw.zzb>> emptyMap2 = Collections.emptyMap();
            if (0 != 0) {
                cursor.close();
            }
            return emptyMap2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<zzfw.zzb>> zzf(String str, String str2) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor query = f_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzfw.zzb>> emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzfw.zzb zzbVar = (zzfw.zzb) ((com.google.android.gms.internal.measurement.zzkg) ((zzfw.zzb.zza) zzpj.zza(zzfw.zzb.zzc(), query.getBlob(1))).zzaj());
                        int i = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzbVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgo.zza(str), e);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e2);
                Map<Integer, List<zzfw.zzb>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<zzfw.zze>> zzg(String str, String str2) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor query = f_().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzfw.zze>> emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzfw.zze zzeVar = (zzfw.zze) ((com.google.android.gms.internal.measurement.zzkg) ((zzfw.zze.zza) zzpj.zza(zzfw.zze.zzc(), query.getBlob(1))).zzaj());
                        int i = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzeVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter", zzgo.zza(str), e);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e2);
                Map<Integer, List<zzfw.zze>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<Integer>> zzn(String str) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = f_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!rawQuery.moveToFirst()) {
                    Map<Integer, List<Integer>> emptyMap = Collections.emptyMap();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return emptyMap;
                }
                do {
                    int i = rawQuery.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), list);
                    }
                    list.add(Integer.valueOf(rawQuery.getInt(1)));
                } while (rawQuery.moveToNext());
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error querying scoped filters. appId", zzgo.zza(str), e);
                Map<Integer, List<Integer>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(zzou zzouVar) {
        super(zzouVar);
        this.zzn = new zzoh(zzb());
        this.zzm = new zzaz(this, zza(), "google_app_measurement.db");
    }

    public final void zza(String str, Long l, String str2, Bundle bundle) {
        zzax zzaxVar;
        boolean z;
        String str3 = str;
        Preconditions.checkNotNull(bundle);
        zzv();
        zzam();
        if (zze().zza(zzbn.zzcz) && l != null) {
            zzaxVar = new zzax(this, str3, l.longValue());
        } else {
            zzaxVar = new zzax(this, str3);
        }
        zzax zzaxVar2 = zzaxVar;
        List<zzav> zza2 = zzaxVar2.zza();
        while (!zza2.isEmpty()) {
            for (zzav zzavVar : zza2) {
                if (!TextUtils.isEmpty(str2)) {
                    zzgf.zzk zzb2 = zzb(str3, zzavVar.zzb);
                    if (zzb2 != null) {
                        for (zzgf.zzp zzpVar : zzb2.zzau()) {
                            if (zzpVar.zzg().equals(str2)) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
                zzpj h_ = h_();
                zzgf.zzf zzfVar = zzavVar.zzd;
                Bundle bundle2 = new Bundle();
                for (zzgf.zzh zzhVar : zzfVar.zzh()) {
                    if (zzhVar.zzj()) {
                        bundle2.putDouble(zzhVar.zzg(), zzhVar.zza());
                    } else if (zzhVar.zzk()) {
                        bundle2.putFloat(zzhVar.zzg(), zzhVar.zzb());
                    } else if (zzhVar.zzl()) {
                        bundle2.putLong(zzhVar.zzg(), zzhVar.zzd());
                    } else if (zzhVar.zzn()) {
                        bundle2.putString(zzhVar.zzg(), zzhVar.zzh());
                    } else if (!zzhVar.zzi().isEmpty()) {
                        bundle2.putParcelableArray(zzhVar.zzg(), zzpj.zzb(zzhVar.zzi()));
                    } else {
                        h_.zzj().zzg().zza("Unexpected parameter type for parameter", zzhVar);
                    }
                }
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                String zzg = zzfVar.zzg();
                if (string == null) {
                    string = "";
                }
                zzgs zzgsVar = new zzgs(zzg, string, bundle2, zzfVar.zzd());
                zzs().zza(zzgsVar.zzc, bundle);
                zza(zzavVar.zza, new zzbe(this.zzu, zzgsVar.zzb, str, zzavVar.zzd.zzg(), zzavVar.zzd.zzd(), zzavVar.zzd.zzc(), zzgsVar.zzc), zzavVar.zzb, zzavVar.zzc);
                str3 = str;
            }
            zza2 = zzaxVar2.zza();
            str3 = str;
        }
    }

    public final void zzq() {
        zzam();
        f_().beginTransaction();
    }

    private final void zzj(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        try {
            f_().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting snapshot. appId", zzgo.zza(str2), e);
        }
    }

    public final void zzo(String str) {
        zzbh zzd2;
        zzj("events_snapshot", str);
        Cursor cursor = null;
        try {
            try {
                cursor = f_().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                do {
                    String string = cursor.getString(0);
                    if (string != null && (zzd2 = zzd(str, string)) != null) {
                        zza("events_snapshot", zzd2);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error creating snapshot. appId", zzgo.zza(str), e);
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zza(Long l) {
        zzv();
        zzam();
        Preconditions.checkNotNull(l);
        if (zze().zza(zzbn.zzch)) {
            try {
                if (f_().delete("upload_queue", "rowid=?", new String[]{String.valueOf(l)}) != 1) {
                    zzj().zzr().zza("Deleted fewer rows from upload_queue than expected");
                }
            } catch (SQLiteException e) {
                zzj().zzg().zza("Failed to delete a MeasurementBatch in a upload_queue table", e);
                throw e;
            }
        }
    }

    public final void zzr() {
        zzam();
        f_().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(List<Long> list) {
        zzv();
        zzam();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzab()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzr().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                f_().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(Long l) {
        zzv();
        zzam();
        Preconditions.checkNotNull(l);
        if (zze().zza(zzbn.zzch) && zzab()) {
            if (zzb("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzr().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                f_().execSQL("UPDATE upload_queue SET retry_count = retry_count + 1 WHERE rowid = " + l + " AND retry_count < 2147483647");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw() {
        int delete;
        zzv();
        zzam();
        if (zzab()) {
            long zza2 = zzo().zza.zza();
            long elapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza2) > zzai.zzo()) {
                zzo().zza.zza(elapsedRealtime);
                zzv();
                zzam();
                if (!zzab() || (delete = f_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzai.zzm())})) <= 0) {
                    return;
                }
                zzj().zzq().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        try {
            f_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting user property. appId", zzgo.zza(str), zzi().zzc(str2), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzp(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzar.zzp(java.lang.String):void");
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, List<zzfw.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzfw.zza.C0009zza zzch = list.get(i).zzch();
            if (zzch.zza() != 0) {
                for (int i2 = 0; i2 < zzch.zza(); i2++) {
                    zzfw.zzb.zza zzch2 = zzch.zza(i2).zzch();
                    zzfw.zzb.zza zzaVar = (zzfw.zzb.zza) ((zzkg.zza) zzch2.clone());
                    String zzb2 = zzjp.zzb(zzch2.zzb());
                    if (zzb2 != null) {
                        zzaVar.zza(zzb2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zzch2.zza(); i3++) {
                        zzfw.zzc zza2 = zzch2.zza(i3);
                        String zza3 = zzjo.zza(zza2.zze());
                        if (zza3 != null) {
                            zzaVar.zza(i3, (zzfw.zzc) ((com.google.android.gms.internal.measurement.zzkg) zza2.zzch().zza(zza3).zzaj()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zzch = zzch.zza(i2, zzaVar);
                        list.set(i, (zzfw.zza) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj()));
                    }
                }
            }
            if (zzch.zzb() != 0) {
                for (int i4 = 0; i4 < zzch.zzb(); i4++) {
                    zzfw.zze zzb3 = zzch.zzb(i4);
                    String zza4 = zzjr.zza(zzb3.zze());
                    if (zza4 != null) {
                        zzch = zzch.zza(i4, zzb3.zzch().zza(zza4));
                        list.set(i, (zzfw.zza) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj()));
                    }
                }
            }
        }
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase f_ = f_();
        f_.beginTransaction();
        try {
            zzam();
            zzv();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase f_2 = f_();
            f_2.delete("property_filters", "app_id=?", new String[]{str});
            f_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzfw.zza zzaVar2 : list) {
                zzam();
                zzv();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (!zzaVar2.zzg()) {
                    zzj().zzr().zza("Audience with no ID. appId", zzgo.zza(str));
                } else {
                    int zza5 = zzaVar2.zza();
                    Iterator<zzfw.zzb> it = zzaVar2.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zzl()) {
                                zzj().zzr().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgo.zza(str), Integer.valueOf(zza5));
                                break;
                            }
                        } else {
                            Iterator<zzfw.zze> it2 = zzaVar2.zzf().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zzi()) {
                                        zzj().zzr().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzgo.zza(str), Integer.valueOf(zza5));
                                        break;
                                    }
                                } else {
                                    Iterator<zzfw.zzb> it3 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, zza5, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzfw.zze> it4 = zzaVar2.zzf().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str, zza5, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzam();
                                        zzv();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase f_3 = f_();
                                        f_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zza5)});
                                        f_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zza5)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzfw.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zzg() ? Integer.valueOf(zzaVar3.zza()) : null);
            }
            zzb(str, arrayList);
            f_.setTransactionSuccessful();
        } finally {
            f_.endTransaction();
        }
    }

    public final void zzx() {
        zzam();
        f_().setTransactionSuccessful();
    }

    public final void zza(zzh zzhVar, boolean z, boolean z2) {
        Preconditions.checkNotNull(zzhVar);
        zzv();
        zzam();
        String zzac = zzhVar.zzac();
        Preconditions.checkNotNull(zzac);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzac);
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.zzb(zzac).zza(zzjj.zza.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzhVar.zzad());
        }
        contentValues.put("gmp_app_id", zzhVar.zzah());
        if (this.zzg.zzb(zzac).zza(zzjj.zza.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzhVar.zzaj());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzt()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzu()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzs()));
        contentValues.put("app_version", zzhVar.zzaf());
        contentValues.put("app_store", zzhVar.zzae());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzq()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzn()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzar()));
        contentValues.put("day", Long.valueOf(zzhVar.zzm()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzk()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzj()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzh()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzg()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzp()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zze()));
        contentValues.put("firebase_instance_id", zzhVar.zzag());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzi()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzl()));
        contentValues.put("health_monitor_sample", zzhVar.zzai());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzaq()));
        contentValues.put("admob_app_id", zzhVar.zzaa());
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzo()));
        if (this.zzg.zzb(zzac).zza(zzjj.zza.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzhVar.zzal());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.zzat()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.zzw()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.zzv()));
        if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zze(zzac, zzbn.zzcp)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.zza()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.zzf()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.zzau()));
        contentValues.put("npa_metadata_value", zzhVar.zzx());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.zzr()));
        contentValues.put("sgtm_preview_key", zzhVar.zzam());
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.zzd()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.zzc()));
        contentValues.put("serialized_npa_metadata", zzhVar.zzak());
        if (zze().zze(zzac, zzbn.zzcj)) {
            contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.zzb()));
        }
        List<String> zzan = zzhVar.zzan();
        if (zzan != null) {
            if (zzan.isEmpty()) {
                zzj().zzr().zza("Safelisted events should not be an empty list. appId", zzac);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzan));
            }
        }
        if (com.google.android.gms.internal.measurement.zzog.zza() && zze().zza(zzbn.zzce) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzhVar.zzy());
        contentValues.put("unmatched_uwa", zzhVar.zzz());
        contentValues.put("ad_campaign_info", zzhVar.zzav());
        try {
            SQLiteDatabase f_ = f_();
            if (f_.update("apps", contentValues, "app_id = ?", new String[]{zzac}) == 0 && f_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update app (got -1). appId", zzgo.zza(zzac));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing app. appId", zzgo.zza(zzac), e);
        }
    }

    public final void zza(String str, zzbd zzbdVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzbdVar);
        zzv();
        zzam();
        if (zzh(str) == zzjj.zza) {
            zzb(str, zzjj.zza);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzbdVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zza(zzbh zzbhVar) {
        zza("events", zzbhVar);
    }

    private final void zza(String str, zzbh zzbhVar) {
        Preconditions.checkNotNull(zzbhVar);
        zzv();
        zzam();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbhVar.zza);
        contentValues.put("name", zzbhVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbhVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbhVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbhVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbhVar.zzg));
        contentValues.put("last_bundled_day", zzbhVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbhVar.zzi);
        contentValues.put("last_sampling_rate", zzbhVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbhVar.zze));
        contentValues.put("last_exempt_from_sampling", (zzbhVar.zzk == null || !zzbhVar.zzk.booleanValue()) ? null : 1L);
        try {
            if (f_().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzgo.zza(zzbhVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzgo.zza(zzbhVar.zza), e);
        }
    }

    private final void zza(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase f_ = f_();
            String asString = contentValues.getAsString(str2);
            if (asString == null) {
                zzj().zzm().zza("Value of the primary key is not set.", zzgo.zza(str2));
            } else if (f_.update(str, contentValues, str2 + " = ?", new String[]{asString}) == 0 && f_.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzgo.zza(str), zzgo.zza(str2));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing into table. key", zzgo.zza(str), zzgo.zza(str2), e);
        }
    }

    public final void zza(String str, zzjj zzjjVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjjVar);
        zzv();
        zzam();
        zzb(str, zzh(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjjVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zzb(String str, zzjj zzjjVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjjVar);
        zzv();
        zzam();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjjVar.zzf());
        contentValues.put("consent_source", Integer.valueOf(zzjjVar.zza()));
        zza("consent_settings", "app_id", contentValues);
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzam();
        zzv();
        SQLiteDatabase f_ = f_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min((int) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, zze().zzb(str, zzbn.zzap)));
            if (zzb2 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            return f_.delete("audience_filter_values", new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(new StringBuilder("(").append(TextUtils.join(",", arrayList)).append(")").toString()).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e);
            return false;
        }
    }

    public final boolean zzq(String str) {
        if (zze().zza(zzbn.zzch)) {
            if (!zze().zza(zzbn.zzcj)) {
                return zzb(new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT ").append(zzap()).toString(), new String[]{str}) != 0;
            }
            zzlu[] zzluVarArr = {zzlu.GOOGLE_SIGNAL};
            ArrayList arrayList = new ArrayList(1);
            for (int i = 0; i <= 0; i++) {
                arrayList.add(Integer.valueOf(zzluVarArr[0].zza()));
            }
            return zzb(new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?").append(zzb(arrayList)).append(" AND NOT ").append(zzap()).toString(), new String[]{str}) != 0;
        }
        return false;
    }

    public final boolean zzi(String str, String str2) {
        return zzb("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzaa() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final boolean zza(zzgf.zzk zzkVar, boolean z) {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzkVar);
        Preconditions.checkNotEmpty(zzkVar.zzab());
        Preconditions.checkState(zzkVar.zzbm());
        zzw();
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzkVar.zzn() < currentTimeMillis - zzai.zzm() || zzkVar.zzn() > zzai.zzm() + currentTimeMillis) {
            zzj().zzr().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgo.zza(zzkVar.zzab()), Long.valueOf(currentTimeMillis), Long.valueOf(zzkVar.zzn()));
        }
        try {
            byte[] zzb2 = h_().zzb(zzkVar.zzce());
            zzj().zzq().zza("Saving bundle, size", Integer.valueOf(zzb2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkVar.zzab());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzkVar.zzn()));
            contentValues.put("data", zzb2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzkVar.zzbt()) {
                contentValues.put("retry_count", Integer.valueOf(zzkVar.zzg()));
            }
            try {
                if (f_().insert("queue", null, contentValues) == -1) {
                    zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzgo.zza(zzkVar.zzab()));
                    return false;
                }
                return true;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing bundle. appId", zzgo.zza(zzkVar.zzab()), e);
                return false;
            }
        } catch (IOException e2) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzgo.zza(zzkVar.zzab()), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzfw.zzb zzbVar) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (zzbVar.zzf().isEmpty()) {
            zzj().zzr().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzgo.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] zzce = zzbVar.zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzf());
        contentValues.put("session_scoped", zzbVar.zzm() ? Boolean.valueOf(zzbVar.zzj()) : null);
        contentValues.put("data", zzce);
        try {
            if (f_().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzgo.zza(str));
                return true;
            }
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event filter. appId", zzgo.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzfw.zze zzeVar) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (zzeVar.zze().isEmpty()) {
            zzj().zzr().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzgo.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null));
            return false;
        }
        byte[] zzce = zzeVar.zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
        contentValues.put("property_name", zzeVar.zze());
        contentValues.put("session_scoped", zzeVar.zzj() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", zzce);
        try {
            if (f_().insertWithOnConflict("property_filters", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzgo.zza(str));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing property filter. appId", zzgo.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzbe zzbeVar, long j, boolean z) {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzbeVar);
        Preconditions.checkNotEmpty(zzbeVar.zza);
        byte[] zzce = h_().zza(zzbeVar).zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbeVar.zza);
        contentValues.put("name", zzbeVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzbeVar.zzd));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzce);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (f_().insert("raw_events", null, contentValues) == -1) {
                zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzgo.zza(zzbeVar.zza));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event. appId", zzgo.zza(zzbeVar.zza), e);
            return false;
        }
    }

    public final boolean zza(String str, zzog zzogVar) {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzogVar);
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzogVar.zzb < currentTimeMillis - zzbn.zzbp.zza(null).longValue() || zzogVar.zzb > zzbn.zzbp.zza(null).longValue() + currentTimeMillis) {
            zzj().zzr().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgo.zza(str), Long.valueOf(currentTimeMillis), Long.valueOf(zzogVar.zzb));
        }
        zzj().zzq().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzogVar.zza);
        contentValues.put("source", Integer.valueOf(zzogVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzogVar.zzb));
        try {
            if (f_().insert("trigger_uris", null, contentValues) == -1) {
                zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzgo.zza(str));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzgo.zza(str), e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzab() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zza(String str, Long l, long j, zzgf.zzf zzfVar) {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzfVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzce = zzfVar.zzce();
        zzj().zzq().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(zzce.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzce);
        try {
            if (f_().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzgo.zza(str));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing complex main event. appId", zzgo.zza(str), e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str, long j) {
        if (zze().zza(zzbn.zzcz) || zzb().currentTimeMillis() <= 15000 + j) {
            try {
                if (zza("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0) {
                    return false;
                }
                return zza("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error checking backfill conditions", e);
                return false;
            }
        }
        return false;
    }

    public final boolean zza(zzag zzagVar) {
        Preconditions.checkNotNull(zzagVar);
        zzv();
        zzam();
        String str = zzagVar.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzagVar.zzc.zza) != null || zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) < 1000) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("origin", zzagVar.zzb);
            contentValues.put("name", zzagVar.zzc.zza);
            zza(contentValues, "value", Preconditions.checkNotNull(zzagVar.zzc.zza()));
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzagVar.zze));
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzagVar.zzf);
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzagVar.zzh));
            zzs();
            contentValues.put("timed_out_event", zzpn.zza((Parcelable) zzagVar.zzg));
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzagVar.zzd));
            zzs();
            contentValues.put("triggered_event", zzpn.zza((Parcelable) zzagVar.zzi));
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzagVar.zzc.zzb));
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzagVar.zzj));
            zzs();
            contentValues.put("expired_event", zzpn.zza((Parcelable) zzagVar.zzk));
            try {
                if (f_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                    zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzgo.zza(str));
                }
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing conditional user property", zzgo.zza(str), e);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str, Bundle bundle) {
        zzv();
        zzam();
        byte[] zzce = h_().zza(new zzbe(this.zzu, "", str, "dep", 0L, 0L, bundle)).zzce();
        zzj().zzq().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(zzce.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzce);
        try {
            if (f_().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzgo.zza(str));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzgo.zza(str), e);
            return false;
        }
    }

    private final boolean zza(long j, zzbe zzbeVar, long j2, boolean z) {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzbeVar);
        Preconditions.checkNotEmpty(zzbeVar.zza);
        byte[] zzce = h_().zza(zzbeVar).zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbeVar.zza);
        contentValues.put("name", zzbeVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzbeVar.zzd));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put("data", zzce);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            long update = f_().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
            if (update != 1) {
                zzj().zzg().zza("Failed to update raw event. appId, updatedRows", zzgo.zza(zzbeVar.zza), Long.valueOf(update));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error updating raw event. appId", zzgo.zza(zzbeVar.zza), e);
            return false;
        }
    }

    public final boolean zza(zzpo zzpoVar) {
        Preconditions.checkNotNull(zzpoVar);
        zzv();
        zzam();
        if (zze(zzpoVar.zza, zzpoVar.zzc) == null) {
            if (zzpn.zzg(zzpoVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzpoVar.zza}) >= zze().zza(zzpoVar.zza, zzbn.zzaq, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zzpoVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzpoVar.zza, zzpoVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzpoVar.zza);
        contentValues.put("origin", zzpoVar.zzb);
        contentValues.put("name", zzpoVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzpoVar.zzd));
        zza(contentValues, "value", zzpoVar.zze);
        try {
            if (f_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzgo.zza(zzpoVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing user property. appId", zzgo.zza(zzpoVar.zza), e);
        }
        return true;
    }
}
