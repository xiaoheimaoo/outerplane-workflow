package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.messaging.Constants;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlin.Unit;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes2.dex */
public final class zzju extends zzf {
    final zzu zza;
    private zzlk zzb;
    private zzjq zzc;
    private final Set<zzjt> zzd;
    private boolean zze;
    private final AtomicReference<String> zzf;
    private final Object zzg;
    private boolean zzh;
    private int zzi;
    private zzbb zzj;
    private zzbb zzk;
    private PriorityQueue<zzog> zzl;
    private boolean zzm;
    private zzjj zzn;
    private final AtomicLong zzo;
    private long zzp;
    private boolean zzq;
    private zzbb zzr;
    private SharedPreferences.OnSharedPreferenceChangeListener zzs;
    private zzbb zzt;
    private final zzpp zzv;

    public static int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    public final zzap zzac() {
        zzv();
        return zzq().zzac();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgj zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzgl zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zza(zzju zzjuVar, Throwable th) {
        String message = th.getMessage();
        zzjuVar.zzm = false;
        if (message != null) {
            if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
                return (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) ? 2 : 3;
            }
            if (message.contains("Background")) {
                zzjuVar.zzm = true;
            }
            return 1;
        }
        return 2;
    }

    public final zzll zzad() {
        return this.zzb;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzju zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzlz zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzme zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zznx zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    public final Boolean zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().zza(atomicReference, 15000L, "boolean test flag value", new zzkg(this, atomicReference));
    }

    public final Double zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().zza(atomicReference, 15000L, "double test flag value", new zzle(this, atomicReference));
    }

    public final Integer zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().zza(atomicReference, 15000L, "int test flag value", new zzlf(this, atomicReference));
    }

    public final Long zzah() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().zza(atomicReference, 15000L, "long test flag value", new zzlc(this, atomicReference));
    }

    public final String zzai() {
        return this.zzf.get();
    }

    public final String zzaj() {
        zzlw zzac = this.zzu.zzs().zzac();
        if (zzac != null) {
            return zzac.zzb;
        }
        return null;
    }

    public final String zzak() {
        zzlw zzac = this.zzu.zzs().zzac();
        if (zzac != null) {
            return zzac.zza;
        }
        return null;
    }

    public final String zzal() {
        if (this.zzu.zzw() != null) {
            return this.zzu.zzw();
        }
        try {
            return new zzhw(zza(), this.zzu.zzz()).zza("google_app_id");
        } catch (IllegalStateException e) {
            this.zzu.zzj().zzg().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final String zzam() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().zza(atomicReference, 15000L, "String test flag value", new zzks(this, atomicReference));
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        if (zzl().zzm()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzaf.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzl().zza(atomicReference, 5000L, "get conditional user properties", new zzky(this, atomicReference, null, str, str2));
            List list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for get conditional user properties", null);
                return new ArrayList<>();
            }
            return zzpn.zzb((List<zzag>) list);
        }
    }

    public final List<zzpm> zza(boolean z) {
        zzw();
        zzj().zzq().zza("Getting user properties (FE)");
        if (zzl().zzm()) {
            zzj().zzg().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzaf.zza()) {
            zzj().zzg().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzkv(this, atomicReference, z));
            List<zzpm> list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyList();
            }
            return list;
        }
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        if (zzl().zzm()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzaf.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzlb(this, atomicReference, null, str, str2, z));
            List<zzpm> list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzpm zzpmVar : list) {
                Object zza = zzpmVar.zza();
                if (zza != null) {
                    arrayMap.put(zzpmVar.zza, zza);
                }
            }
            return arrayMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PriorityQueue<zzog> zzan() {
        if (this.zzl == null) {
            this.zzl = new PriorityQueue<>(Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zzjx
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Long valueOf;
                    valueOf = Long.valueOf(((zzog) obj).zzb);
                    return valueOf;
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zzjw
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int compare;
                    compare = Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                    return compare;
                }
            }));
        }
        return this.zzl;
    }

    public static /* synthetic */ void zza(zzju zzjuVar, AtomicReference atomicReference) {
        Bundle zza = zzjuVar.zzk().zzi.zza();
        zzme zzq = zzjuVar.zzq();
        if (zza == null) {
            zza = new Bundle();
        }
        zzq.zza(atomicReference, zza);
    }

    public static /* synthetic */ void zza(zzju zzjuVar, List list) {
        zzjuVar.zzv();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> zzm = zzjuVar.zzk().zzm();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzog zzogVar = (zzog) it.next();
                if (!zzm.contains(zzogVar.zzc) || zzm.get(zzogVar.zzc).longValue() < zzogVar.zzb) {
                    zzjuVar.zzan().add(zzogVar);
                }
            }
            zzjuVar.zzav();
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, Bundle bundle, long j) {
        if (TextUtils.isEmpty(zzjuVar.zzg().zzah())) {
            zzjuVar.zza(bundle, 0, j);
        } else {
            zzjuVar.zzj().zzw().zza("Using developer consent only; google app id found");
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, Bundle bundle) {
        Bundle bundle2;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            bundle2 = new Bundle(zzjuVar.zzk().zzt.zza());
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzjuVar.zzs();
                    if (zzpn.zza(obj)) {
                        zzjuVar.zzs();
                        zzpn.zza(zzjuVar.zzv, 27, (String) null, (String) null, 0);
                    }
                    zzjuVar.zzj().zzw().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzpn.zzf(str)) {
                    zzjuVar.zzj().zzw().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    bundle2.remove(str);
                } else if (zzjuVar.zzs().zza("param", str, zzjuVar.zze().zza((String) null, false), obj)) {
                    zzjuVar.zzs().zza(bundle2, str, obj);
                }
            }
            zzjuVar.zzs();
            if (zzpn.zza(bundle2, zzjuVar.zze().zzc())) {
                zzjuVar.zzs();
                zzpn.zza(zzjuVar.zzv, 26, (String) null, (String) null, 0);
                zzjuVar.zzj().zzw().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzjuVar.zzk().zzt.zza(bundle2);
        if (!bundle.isEmpty() || zzjuVar.zze().zza(zzbn.zzcy)) {
            zzjuVar.zzq().zza(bundle2);
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, AtomicReference atomicReference, zzon zzonVar, String str, int i, Throwable th, byte[] bArr, Map map) {
        int zza;
        zzjuVar.zzv();
        boolean z = (i == 200 || i == 204 || i == 304) && th == null;
        if (z) {
            zzjuVar.zzj().zzq().zza("[sgtm] Upload succeeded for row_id", Long.valueOf(zzonVar.zza));
        } else {
            zzjuVar.zzj().zzr().zza("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzonVar.zza), Integer.valueOf(i), th);
        }
        zzme zzq = zzjuVar.zzq();
        long j = zzonVar.zza;
        if (z) {
            zza = zzlv.SUCCESS.zza();
        } else {
            zza = zzlv.FAILURE.zza();
        }
        zzq.zza(new zzae(j, zza, zzonVar.zze));
        zzjuVar.zzj().zzq().zza("[sgtm] Updated status for row_id", Long.valueOf(zzonVar.zza), z ? "SUCCESS" : "FAILURE");
        synchronized (atomicReference) {
            atomicReference.set(Boolean.valueOf(z));
            atomicReference.notifyAll();
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, SharedPreferences sharedPreferences, String str) {
        if ("IABTCF_TCString".equals(str)) {
            zzjuVar.zzj().zzq().zza("IABTCF_TCString change picked up in listener.");
            ((zzbb) Preconditions.checkNotNull(zzjuVar.zzt)).zza(500L);
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, String str) {
        if (zzjuVar.zzg().zzb(str)) {
            zzjuVar.zzg().zzaj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(zzju zzjuVar, Bundle bundle) {
        zzjuVar.zzv();
        zzjuVar.zzw();
        Preconditions.checkNotNull(bundle);
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zzjuVar.zzu.zzae()) {
            zzjuVar.zzj().zzq().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzjuVar.zzq().zza(new zzag(bundle.getString("app_id"), "", new zzpm(checkNotEmpty, 0L, null, ""), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(zzju zzjuVar, Bundle bundle) {
        zzjuVar.zzv();
        zzjuVar.zzw();
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        if (!zzjuVar.zzu.zzae()) {
            zzjuVar.zzj().zzq().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzpm zzpmVar = new zzpm(string, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), string2);
        try {
            zzbl zza = zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), string2, 0L, true, true);
            zzjuVar.zzq().zza(new zzag(bundle.getString("app_id"), string2, zzpmVar, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), string2, 0L, true, true), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzju zzjuVar, zzjj zzjjVar, long j, boolean z, boolean z2) {
        zzjuVar.zzv();
        zzjuVar.zzw();
        zzjj zzp = zzjuVar.zzk().zzp();
        if (j <= zzjuVar.zzp && zzjj.zza(zzp.zza(), zzjjVar.zza())) {
            zzjuVar.zzj().zzp().zza("Dropped out-of-date consent setting, proposed settings", zzjjVar);
        } else if (zzjuVar.zzk().zza(zzjjVar)) {
            zzjuVar.zzj().zzq().zza("Setting storage consent(FE)", zzjjVar);
            zzjuVar.zzp = j;
            if (zzjuVar.zzq().zzao()) {
                zzjuVar.zzq().zzb(z);
            } else {
                zzjuVar.zzq().zza(z);
            }
            if (z2) {
                zzjuVar.zzq().zza(new AtomicReference<>());
            }
        } else {
            zzjuVar.zzj().zzp().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjjVar.zza()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(zzju zzjuVar, int i) {
        if (zzjuVar.zzj == null) {
            zzjuVar.zzj = new zzkn(zzjuVar, zzjuVar.zzu);
        }
        zzjuVar.zzj.zza(i * 1000);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzju(zzic zzicVar) {
        super(zzicVar);
        this.zzd = new CopyOnWriteArraySet();
        this.zzg = new Object();
        this.zzh = false;
        this.zzi = 1;
        this.zzq = true;
        this.zzv = new zzld(this);
        this.zzf = new AtomicReference<>();
        this.zzn = zzjj.zza;
        this.zzp = -1L;
        this.zzo = new AtomicLong(0L);
        this.zza = new zzu(zzicVar);
    }

    public final void zzao() {
        zzv();
        zzw();
        zzme zzq = zzq();
        zzq.zzv();
        zzq.zzw();
        boolean z = true;
        if (zzq.zzap() && zzq.zzs().zzg() < 242600) {
            z = false;
        }
        if (z) {
            zzq().zzae();
        }
    }

    public final void zzap() {
        zzv();
        zzw();
        if (this.zzu.zzah()) {
            Boolean zze = zze().zze("google_analytics_deferred_deep_link_enabled");
            if (zze != null && zze.booleanValue()) {
                zzj().zzc().zza("Deferred Deep Link feature enabled.");
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzke
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzju.this.zzat();
                    }
                });
            }
            zzq().zzaf();
            this.zzq = false;
            String zzx = zzk().zzx();
            if (TextUtils.isEmpty(zzx)) {
                return;
            }
            zzf().zzad();
            if (zzx.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", zzx);
            zzc(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaq() {
        zzv();
        zzbb zzbbVar = this.zzk;
        if (zzbbVar != null) {
            zzbbVar.zza();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    public final void zza(String str, String str2, Bundle bundle) {
        long currentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzl().zzb(new zzkz(this, bundle2));
    }

    public final void zzar() {
        if (!(zza().getApplicationContext() instanceof Application) || this.zzb == null) {
            return;
        }
        ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzas() {
        if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zza(zzbn.zzcq)) {
            if (zzl().zzm()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
            } else if (zzaf.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
            } else {
                zzw();
                zzj().zzq().zza("Getting trigger URIs (FE)");
                final AtomicReference atomicReference = new AtomicReference();
                zzl().zza(atomicReference, 10000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjy
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzju.zza(zzju.this, atomicReference);
                    }
                });
                final List list = (List) atomicReference.get();
                if (list == null) {
                    zzj().zzg().zza("Timed out waiting for get trigger URIs");
                } else {
                    zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkb
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzju.zza(zzju.this, list);
                        }
                    });
                }
            }
        }
    }

    public final void zzat() {
        zzv();
        if (zzk().zzo.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza = zzk().zzp.zza();
        zzk().zzp.zza(1 + zza);
        if (zza >= 5) {
            zzj().zzr().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().zzo.zza(true);
            return;
        }
        if (this.zzr == null) {
            this.zzr = new zzku(this, this.zzu);
        }
        this.zzr.zza(0L);
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar) throws RemoteException {
        zzl().zzb(new zzla(this, zzdqVar));
    }

    public final void zzau() {
        zzv();
        zzj().zzc().zza("Handle tcf update.");
        zzoe zza = zzoe.zza(zzk().zzc());
        zzj().zzq().zza("Tcf preferences read", zza);
        if (zzk().zza(zza)) {
            Bundle zza2 = zza.zza();
            zzj().zzq().zza("Consent generated from Tcf", zza2);
            if (zza2 != Bundle.EMPTY) {
                zza(zza2, -30, zzb().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", zza.zzb());
            zzc(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_tcf", bundle);
        }
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            zzp().zza(bundle2, j);
        } else {
            zzb(str3, str2, j, bundle2, z2, !z2 || this.zzc == null || zzpn.zzf(str2), z, null);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) {
        zzu();
        zzb(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(String str, String str2, Bundle bundle) {
        zzv();
        zza(str, str2, zzb().currentTimeMillis(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzv();
        zza(str, str2, j, bundle, true, this.zzc == null || zzpn.zzf(str2), true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        boolean zza;
        String str4;
        long j2;
        String str5;
        String str6;
        boolean z4;
        int length;
        Class<?> cls;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzv();
        zzw();
        if (!this.zzu.zzae()) {
            zzj().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> zzai = zzg().zzai();
        if (zzai != null && !zzai.contains(str2)) {
            zzj().zzc().zza("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        boolean z5 = true;
        if (!this.zze) {
            this.zze = true;
            try {
                if (!this.zzu.zzai()) {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zza().getClassLoader());
                } else {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                }
                try {
                    cls.getDeclaredMethod("initialize", Context.class).invoke(null, zza());
                } catch (Exception e) {
                    zzj().zzr().zza("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                zzj().zzp().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
            zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid", bundle.getString("gclid"), zzb().currentTimeMillis());
        }
        if (z && zzpn.zzh(str2)) {
            zzs().zza(bundle, zzk().zzt.zza());
        }
        if (!z3 && !"_iap".equals(str2)) {
            zzpn zzv = this.zzu.zzv();
            int i = 2;
            if (zzv.zzc(NotificationCompat.CATEGORY_EVENT, str2)) {
                if (!zzv.zza(NotificationCompat.CATEGORY_EVENT, zzjp.zza, zzjp.zzb, str2)) {
                    i = 13;
                } else if (zzv.zza(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                    i = 0;
                }
            }
            if (i != 0) {
                zzj().zzm().zza("Invalid public event name. Event will not be logged (FE)", zzi().zza(str2));
                this.zzu.zzv();
                String zza2 = zzpn.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzv();
                zzpn.zza(this.zzv, i, "_ev", zza2, length);
                return;
            }
        }
        zzlw zza3 = zzp().zza(false);
        if (zza3 != null && !bundle.containsKey("_sc")) {
            zza3.zzd = true;
        }
        zzpn.zza(zza3, bundle, z && !z3);
        boolean equals = "am".equals(str);
        boolean zzf = zzpn.zzf(str2);
        if (z && this.zzc != null && !zzf && !equals) {
            zzj().zzc().zza("Passing event to registered event handler (FE)", zzi().zza(str2), zzi().zza(bundle));
            Preconditions.checkNotNull(this.zzc);
            this.zzc.interceptEvent(str, str2, bundle, j);
        } else if (this.zzu.zzah()) {
            int zza4 = zzs().zza(str2);
            if (zza4 != 0) {
                zzj().zzm().zza("Invalid event name. Event will not be logged (FE)", zzi().zza(str2));
                zzs();
                String zza5 = zzpn.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzv();
                zzpn.zza(this.zzv, str3, zza4, "_ev", zza5, length);
                return;
            }
            Bundle zza6 = zzs().zza(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
            Preconditions.checkNotNull(zza6);
            if (zzp().zza(false) != null && "_ae".equals(str2)) {
                zzod zzodVar = zzr().zzb;
                long elapsedRealtime = zzodVar.zzb.zzb().elapsedRealtime();
                long j3 = elapsedRealtime - zzodVar.zza;
                zzodVar.zza = elapsedRealtime;
                if (j3 > 0) {
                    zzs().zza(zza6, j3);
                }
            }
            if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str) && "_ssr".equals(str2)) {
                zzpn zzs = zzs();
                String string = zza6.getString("_ffr");
                if (Strings.isEmptyOrWhitespace(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                if (Objects.equals(string, zzs.zzk().zzq.zza())) {
                    zzs.zzj().zzc().zza("Not logging duplicate session_start_with_rollout event");
                    z4 = false;
                } else {
                    zzs.zzk().zzq.zza(string);
                    z4 = true;
                }
                if (!z4) {
                    return;
                }
            } else if ("_ae".equals(str2)) {
                String zza7 = zzs().zzk().zzq.zza();
                if (!TextUtils.isEmpty(zza7)) {
                    zza6.putString("_ffr", zza7);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza6);
            if (zze().zza(zzbn.zzcv)) {
                zza = zzr().zzac();
            } else {
                zza = zzk().zzn.zza();
            }
            if (zzk().zzk.zza() > 0 && zzk().zza(j) && zza) {
                zzj().zzq().zza("Current session is expired, remove the session number, ID, and engagement time");
                j2 = 0;
                str4 = "_ae";
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", (Object) null, zzb().currentTimeMillis());
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sno", (Object) null, zzb().currentTimeMillis());
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_se", (Object) null, zzb().currentTimeMillis());
                zzk().zzl.zza(0L);
            } else {
                str4 = "_ae";
                j2 = 0;
            }
            if (zza6.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j2) == 1) {
                zzj().zzq().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.zzu.zzu().zza.zza(j, true);
            }
            ArrayList arrayList2 = new ArrayList(zza6.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                String str7 = (String) obj;
                if (str7 != null) {
                    zzs();
                    Bundle[] zzb = zzpn.zzb(zza6.get(str7));
                    if (zzb != null) {
                        zza6.putParcelableArray(str7, zzb);
                    }
                }
            }
            int i3 = 0;
            while (i3 < arrayList.size()) {
                Bundle bundle2 = (Bundle) arrayList.get(i3);
                if (i3 != 0 ? z5 : false) {
                    str6 = "_ep";
                    str5 = str;
                } else {
                    str5 = str;
                    str6 = str2;
                }
                bundle2.putString("_o", str5);
                if (z2) {
                    bundle2 = zzs().zza(bundle2, (String) null);
                }
                Bundle bundle3 = bundle2;
                zzq().zza(new zzbl(str6, new zzbg(bundle3), str, j), str3);
                if (!equals) {
                    for (zzjt zzjtVar : this.zzd) {
                        zzjtVar.onEvent(str, str2, new Bundle(bundle3), j);
                    }
                }
                i3++;
                z5 = true;
            }
            if (zzp().zza(false) == null || !str4.equals(str2)) {
                return;
            }
            zzr().zza(true, true, zzb().elapsedRealtime());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzav() {
        zzog poll;
        MeasurementManagerFutures zzp;
        zzv();
        this.zzm = false;
        if (zzan().isEmpty() || this.zzh || (poll = zzan().poll()) == null || (zzp = zzs().zzp()) == null) {
            return;
        }
        this.zzh = true;
        zzj().zzq().zza("Registering trigger URI", poll.zza);
        ListenableFuture<Unit> registerTriggerAsync = zzp.registerTriggerAsync(Uri.parse(poll.zza));
        if (registerTriggerAsync == null) {
            this.zzh = false;
            zzan().add(poll);
            return;
        }
        Futures.addCallback(registerTriggerAsync, new zzkk(this, poll), new zzkl(this));
    }

    public final void zza(zzjt zzjtVar) {
        zzw();
        Preconditions.checkNotNull(zzjtVar);
        if (this.zzd.add(zzjtVar)) {
            return;
        }
        zzj().zzr().zza("OnEventListener already registered");
    }

    public final void zzaw() {
        zzv();
        zzj().zzc().zza("Register tcfPrefChangeListener.");
        if (this.zzs == null) {
            this.zzt = new zzkr(this, this.zzu);
            this.zzs = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzkh
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    zzju.zza(zzju.this, sharedPreferences, str);
                }
            };
        }
        zzk().zzc().registerOnSharedPreferenceChangeListener(this.zzs);
    }

    public final void zza(long j) {
        zzb((String) null);
        zzl().zzb(new zzkx(this, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j) {
        zzv();
        zzw();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zznx zzr = zzr();
        zzr.zzv();
        zzr.zzb.zza();
        zzg().zzaj();
        boolean zzae = this.zzu.zzae();
        zzha zzk = zzk();
        zzk.zzc.zza(j);
        if (!TextUtils.isEmpty(zzk.zzk().zzq.zza())) {
            zzk.zzq.zza(null);
        }
        zzk.zzk.zza(0L);
        zzk.zzl.zza(0L);
        if (!zzk.zze().zzy()) {
            zzk.zzb(!zzae);
        }
        zzk.zzr.zza(null);
        zzk.zzs.zza(0L);
        zzk.zzt.zza(null);
        zzq().zzai();
        zzr().zza.zza();
        this.zzq = !zzae;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        if (zze().zza(zzbn.zzcl)) {
            zzw();
            if (zzl().zzm()) {
                zzj().zzg().zza("Cannot retrieve and upload batches from analytics worker thread");
            } else if (zzl().zzg()) {
                zzj().zzg().zza("Cannot retrieve and upload batches from analytics network thread");
            } else if (zzaf.zza()) {
                zzj().zzg().zza("Cannot retrieve and upload batches from main thread");
            } else {
                zzj().zzq().zza("[sgtm] Started client-side batch upload work.");
                boolean z = false;
                int i = 0;
                int i2 = 0;
                while (!z) {
                    zzj().zzq().zza("[sgtm] Getting upload batches from service (FE)");
                    final AtomicReference atomicReference = new AtomicReference();
                    zzl().zza(atomicReference, 10000L, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkd
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzju.this.zzq().zza(atomicReference, zzop.zza(zzlu.SGTM_CLIENT));
                        }
                    });
                    zzor zzorVar = (zzor) atomicReference.get();
                    if (zzorVar != null && !zzorVar.zza.isEmpty()) {
                        zzj().zzq().zza("[sgtm] Retrieved upload batches. count", Integer.valueOf(zzorVar.zza.size()));
                        i += zzorVar.zza.size();
                        Iterator<zzon> it = zzorVar.zza.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (!zza(it.next())) {
                                z = true;
                                break;
                            } else {
                                i2++;
                            }
                        }
                    } else {
                        break;
                    }
                }
                zzj().zzq().zza("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i), Integer.valueOf(i2));
                runnable.run();
            }
        }
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzl().zzb(new zzkq(this, str, str2, j, zzpn.zza(bundle), z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzl().zzb(new zzkt(this, str, str2, obj, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(long j) {
        zzv();
        if (this.zzk == null) {
            this.zzk = new zzkj(this, this.zzu);
        }
        this.zzk.zza(j);
    }

    public final void zzb(boolean z) {
        if (zza().getApplicationContext() instanceof Application) {
            Application application = (Application) zza().getApplicationContext();
            if (this.zzb == null) {
                this.zzb = new zzlk(this);
            }
            if (z) {
                application.unregisterActivityLifecycleCallbacks(this.zzb);
                application.registerActivityLifecycleCallbacks(this.zzb);
                zzj().zzq().zza("Registered activity lifecycle callback");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(String str) {
        this.zzf.set(str);
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzb().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().zzr().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjk.zza(bundle2, "app_id", String.class, null);
        zzjk.zza(bundle2, "origin", String.class, null);
        zzjk.zza(bundle2, "name", String.class, null);
        zzjk.zza(bundle2, "value", Object.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjk.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (zzs().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
        } else if (zzs().zza(string, obj) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
        } else {
            Object zzc = zzs().zzc(string, obj);
            if (zzc == null) {
                zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
                return;
            }
            zzjk.zza(bundle2, zzc);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) && (j2 > 15552000000L || j2 < 1)) {
                zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j2));
                return;
            }
            long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
            if (j3 > 15552000000L || j3 < 1) {
                zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j3));
            } else {
                zzl().zzb(new zzkw(this, bundle2));
            }
        }
    }

    public final void zzb(final Bundle bundle, final long j) {
        zzl().zzc(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkf
            @Override // java.lang.Runnable
            public final void run() {
                zzju.zza(zzju.this, bundle, j);
            }
        });
    }

    private final void zza(Bundle bundle, int i, long j) {
        zzw();
        String zza = zzjj.zza(bundle);
        if (zza != null) {
            zzj().zzw().zza("Ignoring invalid consent setting", zza);
            zzj().zzw().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zzm = zzl().zzm();
        zzjj zza2 = zzjj.zza(bundle, i);
        if (zza2.zzi()) {
            zza(zza2, zzm);
        }
        zzbd zza3 = zzbd.zza(bundle, i);
        if (zza3.zzg()) {
            zza(zza3, zzm);
        }
        Boolean zza4 = zzbd.zza(bundle);
        if (zza4 != null) {
            String str = i == -30 ? "tcf" : "app";
            if (zzm) {
                zza(str, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zza4.toString(), j);
            } else {
                zza(str, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) zza4.toString(), false, j);
            }
        }
    }

    public final void zzc(Bundle bundle, long j) {
        zza(bundle, -20, j);
    }

    public final void zzc(boolean z) {
        zzw();
        zzl().zzb(new zzkm(this, z));
    }

    public final void zzb(Bundle bundle) {
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzka
            @Override // java.lang.Runnable
            public final void run() {
                zzju.zza(zzju.this, bundle2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzbd zzbdVar, boolean z) {
        zzlg zzlgVar = new zzlg(this, zzbdVar);
        if (z) {
            zzv();
            zzlgVar.run();
            return;
        }
        zzl().zzb(zzlgVar);
    }

    public final void zza(zzjq zzjqVar) {
        zzjq zzjqVar2;
        zzv();
        zzw();
        if (zzjqVar != null && zzjqVar != (zzjqVar2 = this.zzc)) {
            Preconditions.checkState(zzjqVar2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzjqVar;
    }

    public final void zza(Boolean bool) {
        zzw();
        zzl().zzb(new zzlh(this, bool));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzjj zzjjVar) {
        zzv();
        boolean z = (zzjjVar.zzh() && zzjjVar.zzg()) || zzq().zzan();
        if (z != this.zzu.zzaf()) {
            this.zzu.zzb(z);
            Boolean zzr = zzk().zzr();
            if (!z || zzr == null || zzr.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Boolean bool, boolean z) {
        zzv();
        zzw();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z) {
            zzk().zzb(bool);
        }
        if (this.zzu.zzaf() || !(bool == null || bool.booleanValue())) {
            zzay();
        }
    }

    public final void zzd(long j) {
        zzl().zzb(new zzko(this, j));
    }

    public final void zza(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            zzj().zzp().zza("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals("1")) {
            zzj().zzp().zza("Preview Mode was not enabled.");
            zze().zzh(null);
            return;
        }
        String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        zzj().zzp().zza("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
        zze().zzh(queryParameter2);
    }

    public final void zza(zzjj zzjjVar, boolean z) {
        boolean z2;
        zzjj zzjjVar2;
        boolean z3;
        boolean z4;
        zzw();
        int zza = zzjjVar.zza();
        if (zza != -10 && zzjjVar.zzc() == zzjm.UNINITIALIZED && zzjjVar.zzd() == zzjm.UNINITIALIZED) {
            zzj().zzw().zza("Ignoring empty consent settings");
            return;
        }
        synchronized (this.zzg) {
            z2 = false;
            if (zzjj.zza(zza, this.zzn.zza())) {
                z3 = zzjjVar.zzc(this.zzn);
                if (zzjjVar.zzh() && !this.zzn.zzh()) {
                    z2 = true;
                }
                zzjj zzb = zzjjVar.zzb(this.zzn);
                this.zzn = zzb;
                zzjjVar2 = zzb;
                z4 = z2;
                z2 = true;
            } else {
                zzjjVar2 = zzjjVar;
                z3 = false;
                z4 = false;
            }
        }
        if (!z2) {
            zzj().zzp().zza("Ignoring lower-priority consent settings, proposed settings", zzjjVar2);
            return;
        }
        long andIncrement = this.zzo.getAndIncrement();
        if (z3) {
            zzb((String) null);
            zzlj zzljVar = new zzlj(this, zzjjVar2, andIncrement, z4);
            if (z) {
                zzv();
                zzljVar.run();
                return;
            }
            zzl().zzc(zzljVar);
            return;
        }
        zzli zzliVar = new zzli(this, zzjjVar2, andIncrement, z4);
        if (z) {
            zzv();
            zzliVar.run();
        } else if (zza == 30 || zza == -10) {
            zzl().zzc(zzliVar);
        } else {
            zzl().zzb(zzliVar);
        }
    }

    public final void zza(final String str, long j) {
        if (str != null && TextUtils.isEmpty(str)) {
            this.zzu.zzj().zzr().zza("User ID must be non-empty or null");
            return;
        }
        zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjz
            @Override // java.lang.Runnable
            public final void run() {
                zzju.zza(zzju.this, str);
            }
        });
        zza((String) null, "_id", (Object) str, true, j);
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        int i;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z) {
            i = zzs().zzb(str2);
        } else {
            zzpn zzs = zzs();
            if (zzs.zzc("user property", str2)) {
                if (!zzs.zza("user property", zzjr.zza, str2)) {
                    i = 15;
                } else if (zzs.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
            i = 6;
        }
        if (i != 0) {
            zzs();
            String zza = zzpn.zza(str2, 24, true);
            r7 = str2 != null ? str2.length() : 0;
            this.zzu.zzv();
            zzpn.zza(this.zzv, i, "_ev", zza, r7);
        } else if (obj != null) {
            int zza2 = zzs().zza(str2, obj);
            if (zza2 != 0) {
                zzs();
                String zza3 = zzpn.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    r7 = String.valueOf(obj).length();
                }
                this.zzu.zzv();
                zzpn.zza(this.zzv, zza2, "_ev", zza3, r7);
                return;
            }
            Object zzc = zzs().zzc(str2, obj);
            if (zzc != null) {
                zza(str3, str2, j, zzc);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzw();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    Long valueOf = Long.valueOf("false".equals(str3.toLowerCase(Locale.ENGLISH)) ? 1L : 0L);
                    zzk().zzh.zza(valueOf.longValue() == 1 ? "true" : "false");
                    obj = valueOf;
                    str2 = "_npa";
                    zzj().zzq().zza("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                }
            }
            if (obj == null) {
                zzk().zzh.zza("unset");
                str2 = "_npa";
            }
            zzj().zzq().zza("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        String str4 = str2;
        Object obj2 = obj;
        if (!this.zzu.zzae()) {
            zzj().zzq().zza("User property not set since app measurement is disabled");
        } else if (this.zzu.zzah()) {
            zzq().zza(new zzpm(str4, j, obj2, str));
        }
    }

    public final void zzb(zzjt zzjtVar) {
        zzw();
        Preconditions.checkNotNull(zzjtVar);
        if (this.zzd.remove(zzjtVar)) {
            return;
        }
        zzj().zzr().zza("OnEventListener had not been registered");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzay() {
        zzv();
        String zza = zzk().zzh.zza();
        if (zza != null) {
            if ("unset".equals(zza)) {
                zza("app", "_npa", (Object) null, zzb().currentTimeMillis());
            } else {
                zza("app", "_npa", Long.valueOf("true".equals(zza) ? 1L : 0L), zzb().currentTimeMillis());
            }
        }
        if (this.zzu.zzae() && this.zzq) {
            zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzap();
            zzr().zza.zza();
            zzl().zzb(new zzkp(this));
            return;
        }
        zzj().zzc().zza("Updating Scion state (FE)");
        zzq().zzak();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzax() {
        return this.zzm;
    }

    private final boolean zza(final zzon zzonVar) {
        try {
            URL url = new URI(zzonVar.zzc).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String zzag = zzg().zzag();
            zzj().zzq().zza("[sgtm] Uploading data from app. row_id, url, uncompressed size", Long.valueOf(zzonVar.zza), zzonVar.zzc, Integer.valueOf(zzonVar.zzb.length));
            if (!TextUtils.isEmpty(zzonVar.zzf)) {
                zzj().zzq().zza("[sgtm] Uploading data from app. row_id", Long.valueOf(zzonVar.zza), zzonVar.zzf);
            }
            HashMap hashMap = new HashMap();
            for (String str : zzonVar.zzd.keySet()) {
                String string = zzonVar.zzd.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str, string);
                }
            }
            zzlp zzn = zzn();
            byte[] bArr = zzonVar.zzb;
            zzlo zzloVar = new zzlo() { // from class: com.google.android.gms.measurement.internal.zzkc
                @Override // com.google.android.gms.measurement.internal.zzlo
                public final void zza(String str2, int i, Throwable th, byte[] bArr2, Map map) {
                    zzju.zza(zzju.this, atomicReference, zzonVar, str2, i, th, bArr2, map);
                }
            };
            zzn.zzad();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(zzloVar);
            zzn.zzl().zza(new zzlr(zzn, zzag, url, bArr, hashMap, zzloVar));
            try {
                zzpn zzs = zzs();
                long currentTimeMillis = zzs.zzb().currentTimeMillis();
                long j = currentTimeMillis + ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;
                synchronized (atomicReference) {
                    for (long j2 = ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS; atomicReference.get() == null && j2 > 0; j2 = j - zzs.zzb().currentTimeMillis()) {
                        atomicReference.wait(j2);
                    }
                }
            } catch (InterruptedException unused) {
                zzj().zzr().zza("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == Boolean.TRUE;
        } catch (MalformedURLException | URISyntaxException e) {
            zzj().zzg().zza("[sgtm] Bad upload url for row_id", zzonVar.zzc, Long.valueOf(zzonVar.zza), e);
            return false;
        }
    }
}
