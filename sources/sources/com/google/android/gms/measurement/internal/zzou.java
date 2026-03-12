package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjj;
import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.DebugKt;
/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes2.dex */
public class zzou implements zzjh {
    private static volatile zzou zza;
    private List<Long> zzaa;
    private long zzab;
    private final Map<String, zzjj> zzac;
    private final Map<String, zzbd> zzad;
    private final Map<String, zzc> zzae;
    private final Map<String, zzb> zzaf;
    private zzlw zzag;
    private String zzah;
    private zzbb zzai;
    private long zzaj;
    private final zzpp zzak;
    private zzhm zzb;
    private zzgv zzc;
    private zzar zzd;
    private zzgy zze;
    private zzoi zzf;
    private zzx zzg;
    private final zzpj zzh;
    private zzlt zzi;
    private zznp zzj;
    private final zzos zzk;
    private zzhj zzl;
    private final zzic zzm;
    private boolean zzn;
    private boolean zzo;
    private long zzp;
    private List<Runnable> zzq;
    private final Deque<String> zzr;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List<Long> zzz;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    /* loaded from: classes2.dex */
    public class zza implements zzau {
        zzgf.zzk zza;
        List<Long> zzb;
        List<zzgf.zzf> zzc;
        private long zzd;

        private static long zza(zzgf.zzf zzfVar) {
            return ((zzfVar.zzd() / 1000) / 60) / 60;
        }

        private zza() {
        }

        @Override // com.google.android.gms.measurement.internal.zzau
        public final void zza(zzgf.zzk zzkVar) {
            Preconditions.checkNotNull(zzkVar);
            this.zza = zzkVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzau
        public final boolean zza(long j, zzgf.zzf zzfVar) {
            Preconditions.checkNotNull(zzfVar);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.isEmpty() || zza(this.zzc.get(0)) == zza(zzfVar)) {
                long zzcf = this.zzd + zzfVar.zzcf();
                zzou.this.zze();
                if (zzcf >= Math.max(0, zzbn.zzi.zza(null).intValue())) {
                    return false;
                }
                this.zzd = zzcf;
                this.zzc.add(zzfVar);
                this.zzb.add(Long.valueOf(j));
                int size = this.zzc.size();
                zzou.this.zze();
                return size < Math.max(1, zzbn.zzj.zza(null).intValue());
            }
            return false;
        }
    }

    private final int zza(String str, zzan zzanVar) {
        zzjm zza2;
        if (this.zzb.zzb(str) == null) {
            zzanVar.zza(zzjj.zza.AD_PERSONALIZATION, zzam.FAILSAFE);
            return 1;
        }
        zzh zzd = zzf().zzd(str);
        if (zzd != null && zzd.zza(zzd.zzak()).zza() == zzjm.POLICY && (zza2 = this.zzb.zza(str, zzjj.zza.AD_PERSONALIZATION)) != zzjm.UNINITIALIZED) {
            zzanVar.zza(zzjj.zza.AD_PERSONALIZATION, zzam.REMOTE_ENFORCED_DEFAULT);
            return zza2 == zzjm.GRANTED ? 0 : 1;
        }
        zzanVar.zza(zzjj.zza.AD_PERSONALIZATION, zzam.REMOTE_DEFAULT);
        return this.zzb.zzc(str, zzjj.zza.AD_PERSONALIZATION) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    /* loaded from: classes2.dex */
    public class zzc {
        final String zza;
        long zzb;

        private zzc(zzou zzouVar) {
            this(zzouVar, zzouVar.zzq().zzq());
        }

        private zzc(zzou zzouVar, String str) {
            this.zza = str;
            this.zzb = zzouVar.zzb().elapsedRealtime();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    /* loaded from: classes2.dex */
    public static class zzb {
        private final zzou zza;
        private int zzb = 1;
        private long zzc = zzc();

        private final long zzc() {
            Preconditions.checkNotNull(this.zza);
            long longValue = zzbn.zzt.zza(null).longValue();
            long longValue2 = zzbn.zzu.zza(null).longValue();
            for (int i = 1; i < this.zzb; i++) {
                longValue <<= 1;
                if (longValue >= longValue2) {
                    break;
                }
            }
            return this.zza.zzb().currentTimeMillis() + Math.min(longValue, longValue2);
        }

        public zzb(zzou zzouVar) {
            this.zza = zzouVar;
        }

        public final void zza() {
            this.zzb++;
            this.zzc = zzc();
        }

        public final boolean zzb() {
            return this.zza.zzb().currentTimeMillis() >= this.zzc;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzl().zzv();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzj().zzg().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read == 4) {
                allocate.flip();
                return allocate.getInt();
            }
            if (read != -1) {
                zzj().zzr().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
            }
            return 0;
        } catch (IOException e) {
            zzj().zzg().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final long zzy() {
        long currentTimeMillis = zzb().currentTimeMillis();
        zznp zznpVar = this.zzj;
        zznpVar.zzam();
        zznpVar.zzv();
        long zza2 = zznpVar.zzf.zza();
        if (zza2 == 0) {
            zza2 = zznpVar.zzs().zzw().nextInt(86400000) + 1;
            zznpVar.zzf.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public final Context zza() {
        return this.zzm.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zza(String str) {
        boolean z;
        zzl().zzv();
        zzt();
        if (zzi().zzb(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjj zzb2 = zzb(str);
        bundle.putAll(zzb2.zzb());
        bundle.putAll(zza(str, zzd(str), zzb2, new zzan()).zzb());
        zzpo zze = zzf().zze(str, "_npa");
        if (zze != null) {
            z = zze.zze.equals(1L);
        } else {
            z = zza(str, new zzan());
        }
        bundle.putString("ad_personalization", z == 1 ? "denied" : "granted");
        return bundle;
    }

    private final Bundle zza(String str, zzbl zzblVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzblVar.zzb.zzb("_sid").longValue());
        zzpo zze = zzf().zze(str, "_sno");
        if (zze != null && (zze.zze instanceof Long)) {
            bundle.putLong("_sno", ((Long) zze.zze).longValue());
        }
        return bundle;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public final Clock zzb() {
        return ((zzic) Preconditions.checkNotNull(this.zzm)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzh zza(com.google.android.gms.measurement.internal.zzp r14) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzou.zza(com.google.android.gms.measurement.internal.zzp):com.google.android.gms.measurement.internal.zzh");
    }

    private final zzp zzc(String str) {
        zzh zzd = zzf().zzd(str);
        if (zzd == null || TextUtils.isEmpty(zzd.zzaf())) {
            zzj().zzc().zza("No app data available; dropping", str);
            return null;
        }
        Boolean zza2 = zza(zzd);
        if (zza2 != null && !zza2.booleanValue()) {
            zzj().zzg().zza("App version does not match; dropping. appId", zzgo.zza(str));
            return null;
        }
        return new zzp(str, zzd.zzah(), zzd.zzaf(), zzd.zze(), zzd.zzae(), zzd.zzq(), zzd.zzn(), (String) null, zzd.zzar(), false, zzd.zzag(), 0L, 0, zzd.zzaq(), false, zzd.zzaa(), zzd.zzx(), zzd.zzo(), zzd.zzan(), (String) null, zzb(str).zzf(), "", (String) null, zzd.zzat(), zzd.zzw(), zzb(str).zza(), zzd(str).zzf(), zzd.zza(), zzd.zzf(), zzd.zzam(), zzd.zzak(), 0L, zzd.zzb());
    }

    public final zzx zzc() {
        return (zzx) zza(this.zzg);
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public final zzaf zzd() {
        return this.zzm.zzd();
    }

    public final zzai zze() {
        return ((zzic) Preconditions.checkNotNull(this.zzm)).zzf();
    }

    public final zzar zzf() {
        return (zzar) zza(this.zzd);
    }

    private final zzbb zzz() {
        if (this.zzai == null) {
            this.zzai = new zzpb(this, this.zzm);
        }
        return this.zzai;
    }

    private final zzbd zza(String str, zzbd zzbdVar, zzjj zzjjVar, zzan zzanVar) {
        zzjm zzjmVar;
        int i = 90;
        boolean z = true;
        if (zzi().zzb(str) == null) {
            if (zzbdVar.zzc() == zzjm.DENIED) {
                i = zzbdVar.zza();
                zzanVar.zza(zzjj.zza.AD_USER_DATA, i);
            } else {
                zzanVar.zza(zzjj.zza.AD_USER_DATA, zzam.FAILSAFE);
            }
            return new zzbd((Boolean) false, i, (Boolean) true, "-");
        }
        zzjm zzc2 = zzbdVar.zzc();
        if (zzc2 == zzjm.GRANTED || zzc2 == zzjm.DENIED) {
            i = zzbdVar.zza();
            zzanVar.zza(zzjj.zza.AD_USER_DATA, i);
        } else {
            if (zzc2 == zzjm.POLICY && (zzjmVar = this.zzb.zza(str, zzjj.zza.AD_USER_DATA)) != zzjm.UNINITIALIZED) {
                zzanVar.zza(zzjj.zza.AD_USER_DATA, zzam.REMOTE_ENFORCED_DEFAULT);
            } else {
                zzjj.zza zzb2 = this.zzb.zzb(str, zzjj.zza.AD_USER_DATA);
                zzjm zzc3 = zzjjVar.zzc();
                if (zzc3 != zzjm.GRANTED && zzc3 != zzjm.DENIED) {
                    z = false;
                }
                if (zzb2 == zzjj.zza.AD_STORAGE && z) {
                    zzanVar.zza(zzjj.zza.AD_USER_DATA, zzam.REMOTE_DELEGATION);
                    zzc2 = zzc3;
                } else {
                    zzanVar.zza(zzjj.zza.AD_USER_DATA, zzam.REMOTE_DEFAULT);
                    if (this.zzb.zzc(str, zzjj.zza.AD_USER_DATA)) {
                        zzjmVar = zzjm.GRANTED;
                    } else {
                        zzjmVar = zzjm.DENIED;
                    }
                }
            }
            zzc2 = zzjmVar;
        }
        boolean zzm = this.zzb.zzm(str);
        SortedSet<String> zzh = zzi().zzh(str);
        if (zzc2 == zzjm.DENIED || zzh.isEmpty()) {
            return new zzbd((Boolean) false, i, Boolean.valueOf(zzm), "-");
        }
        return new zzbd((Boolean) true, i, Boolean.valueOf(zzm), zzm ? TextUtils.join("", zzh) : "");
    }

    private final zzbd zzd(String str) {
        zzl().zzv();
        zzt();
        zzbd zzbdVar = this.zzad.get(str);
        if (zzbdVar == null) {
            zzbd zzf = zzf().zzf(str);
            this.zzad.put(str, zzf);
            return zzf;
        }
        return zzbdVar;
    }

    public final zzgl zzg() {
        return this.zzm.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public final zzgo zzj() {
        return ((zzic) Preconditions.checkNotNull(this.zzm)).zzj();
    }

    public final zzgv zzh() {
        return (zzgv) zza(this.zzc);
    }

    private final zzgy zzaa() {
        zzgy zzgyVar = this.zze;
        if (zzgyVar != null) {
            return zzgyVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzhm zzi() {
        return (zzhm) zza(this.zzb);
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public final zzhv zzl() {
        return ((zzic) Preconditions.checkNotNull(this.zzm)).zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzic zzk() {
        return this.zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjj zzb(String str) {
        zzl().zzv();
        zzt();
        zzjj zzjjVar = this.zzac.get(str);
        if (zzjjVar == null) {
            zzjjVar = zzf().zzh(str);
            if (zzjjVar == null) {
                zzjjVar = zzjj.zza;
            }
            zza(str, zzjjVar);
        }
        return zzjjVar;
    }

    public final zzlt zzm() {
        return (zzlt) zza(this.zzi);
    }

    public final zznp zzn() {
        return this.zzj;
    }

    private final zzoi zzab() {
        return (zzoi) zza(this.zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzor zza(String str, zzop zzopVar) {
        if (!zze().zza(zzbn.zzcj)) {
            return new zzor(Collections.emptyList());
        }
        zzl().zzv();
        zzt();
        List<zzpi> zza2 = zzf().zza(str, zzopVar, zzbn.zzw.zza(null).intValue());
        ArrayList arrayList = new ArrayList();
        for (zzpi zzpiVar : zza2) {
            if (zzf(zzpiVar.zze())) {
                zzon zzb2 = zzpiVar.zzb();
                try {
                    zzgf.zzj.zzb zzbVar = (zzgf.zzj.zzb) zzpj.zza(zzgf.zzj.zzb(), zzb2.zzb);
                    for (int i = 0; i < zzbVar.zza(); i++) {
                        zzgf.zzk.zza zzch = zzbVar.zza(i).zzch();
                        zzgf.zzk.zza zzaVar = zzch;
                        zzbVar.zza(i, zzch.zzl(zzb().currentTimeMillis()));
                    }
                    zzb2.zzb = ((zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzbVar.zzaj())).zzce();
                    if (zzj().zza(2)) {
                        zzb2.zzf = zzp().zza((zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzbVar.zzaj()));
                    }
                    arrayList.add(zzb2);
                } catch (com.google.android.gms.internal.measurement.zzkp unused) {
                    zzj().zzr().zza("Failed to parse queued batch. appId", str);
                }
            }
        }
        return new zzor(arrayList);
    }

    private static zzot zza(zzot zzotVar) {
        if (zzotVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzotVar.zzao()) {
            return zzotVar;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(zzotVar.getClass()));
    }

    public final zzos zzo() {
        return this.zzk;
    }

    public static zzou zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzou.class) {
                if (zza == null) {
                    zza = new zzou((zzpf) Preconditions.checkNotNull(new zzpf(context)));
                }
            }
        }
        return zza;
    }

    public final zzpj zzp() {
        return (zzpj) zza(this.zzh);
    }

    public final zzpn zzq() {
        return ((zzic) Preconditions.checkNotNull(this.zzm)).zzv();
    }

    private final Boolean zza(zzh zzhVar) {
        try {
            if (zzhVar.zze() != -2147483648L) {
                if (zzhVar.zze() == Wrappers.packageManager(this.zzm.zza()).getPackageInfo(zzhVar.zzac(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzm.zza()).getPackageInfo(zzhVar.zzac(), 0).versionName;
                String zzaf = zzhVar.zzaf();
                if (zzaf != null && zzaf.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static Boolean zzh(zzp zzpVar) {
        Boolean bool = zzpVar.zzq;
        if (TextUtils.isEmpty(zzpVar.zzad)) {
            return bool;
        }
        int i = zzpe.zza[zzd.zza(zzpVar.zzad).zza().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return false;
            }
            if (i == 3) {
                return true;
            }
            if (i != 4) {
                return bool;
            }
        }
        return null;
    }

    private final String zza(zzjj zzjjVar) {
        if (zzjjVar.zzh()) {
            byte[] bArr = new byte[16];
            zzq().zzw().nextBytes(bArr);
            return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb(zzp zzpVar) {
        try {
            return (String) zzl().zza(new zzpa(this, zzpVar)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzj().zzg().zza("Failed to get app instance id. appId", zzgo.zza(zzpVar.zza), e);
            return null;
        }
    }

    private static String zza(Map<String, List<String>> map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (str.equalsIgnoreCase(entry.getKey())) {
                if (entry.getValue().isEmpty()) {
                    return null;
                }
                return entry.getValue().get(0);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<zzog> zza(zzp zzpVar, Bundle bundle) {
        zzl().zzv();
        if (!com.google.android.gms.internal.measurement.zzoy.zza() || !zze().zze(zzpVar.zza, zzbn.zzcp) || zzpVar.zza == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zzj().zzg().zza("Uri sources and timestamps do not match");
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        zzar zzf = zzf();
                        String str = zzpVar.zza;
                        int i2 = intArray[i];
                        long j = longArray[i];
                        Preconditions.checkNotEmpty(str);
                        zzf.zzv();
                        zzf.zzam();
                        try {
                            zzf.zzj().zzq().zza("Pruned " + zzf.f_().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)}) + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            zzf.zzj().zzg().zza("Error pruning trigger URIs. appId", zzgo.zza(str), e);
                        }
                    }
                }
            }
        }
        return zzf().zzj(zzpVar.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzou zzouVar, zzpf zzpfVar) {
        zzouVar.zzl().zzv();
        zzouVar.zzl = new zzhj(zzouVar);
        zzar zzarVar = new zzar(zzouVar);
        zzarVar.zzan();
        zzouVar.zzd = zzarVar;
        zzouVar.zze().zza((zzak) Preconditions.checkNotNull(zzouVar.zzb));
        zznp zznpVar = new zznp(zzouVar);
        zznpVar.zzan();
        zzouVar.zzj = zznpVar;
        zzx zzxVar = new zzx(zzouVar);
        zzxVar.zzan();
        zzouVar.zzg = zzxVar;
        zzlt zzltVar = new zzlt(zzouVar);
        zzltVar.zzan();
        zzouVar.zzi = zzltVar;
        zzoi zzoiVar = new zzoi(zzouVar);
        zzoiVar.zzan();
        zzouVar.zzf = zzoiVar;
        zzouVar.zze = new zzgy(zzouVar);
        if (zzouVar.zzs != zzouVar.zzt) {
            zzouVar.zzj().zzg().zza("Not all upload components initialized", Integer.valueOf(zzouVar.zzs), Integer.valueOf(zzouVar.zzt));
        }
        zzouVar.zzn = true;
    }

    private zzou(zzpf zzpfVar) {
        this(zzpfVar, null);
    }

    private zzou(zzpf zzpfVar, zzic zzicVar) {
        this.zzn = false;
        this.zzr = new LinkedList();
        this.zzaf = new HashMap();
        this.zzak = new zzpd(this);
        Preconditions.checkNotNull(zzpfVar);
        this.zzm = zzic.zza(zzpfVar.zza, null, null);
        this.zzab = -1L;
        this.zzk = new zzos(this);
        zzpj zzpjVar = new zzpj(this);
        zzpjVar.zzan();
        this.zzh = zzpjVar;
        zzgv zzgvVar = new zzgv(this);
        zzgvVar.zzan();
        this.zzc = zzgvVar;
        zzhm zzhmVar = new zzhm(this);
        zzhmVar.zzan();
        this.zzb = zzhmVar;
        this.zzac = new HashMap();
        this.zzad = new HashMap();
        this.zzae = new HashMap();
        zzl().zzb(new zzow(this, zzpfVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzl().zzv();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    public final void zzr() {
        zzl().zzv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzs() {
        zzl().zzv();
        zzt();
        if (this.zzo) {
            return;
        }
        this.zzo = true;
        if (zzah()) {
            int zza2 = zza(this.zzy);
            int zzad = this.zzm.zzh().zzad();
            zzl().zzv();
            if (zza2 > zzad) {
                zzj().zzg().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzad));
            } else if (zza2 < zzad) {
                if (zza(zzad, this.zzy)) {
                    zzj().zzq().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzad));
                } else {
                    zzj().zzg().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzad));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt() {
        if (!this.zzn) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private final void zzac() {
        zzl().zzv();
        if (this.zzu || this.zzv || this.zzw) {
            zzj().zzq().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzj().zzq().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list == null) {
            return;
        }
        for (Runnable runnable : list) {
            runnable.run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, zzgf.zzk.zza zzaVar) {
        int zza2;
        int indexOf;
        Set<String> zzg = zzi().zzg(str);
        if (zzg != null) {
            zzaVar.zzd(zzg);
        }
        if (zzi().zzp(str)) {
            zzaVar.zzj();
        }
        if (zzi().zzs(str)) {
            String zzz = zzaVar.zzz();
            if (!TextUtils.isEmpty(zzz) && (indexOf = zzz.indexOf(".")) != -1) {
                zzaVar.zzo(zzz.substring(0, indexOf));
            }
        }
        if (zzi().zzt(str) && (zza2 = zzpj.zza(zzaVar, "_id")) != -1) {
            zzaVar.zzc(zza2);
        }
        if (zzi().zzr(str)) {
            zzaVar.zzk();
        }
        if (zzi().zzo(str)) {
            zzaVar.zzh();
            if (zzb(str).zzh()) {
                zzc zzcVar = this.zzae.get(str);
                if (zzcVar == null || zzcVar.zzb + zze().zzc(str, zzbn.zzbe) < zzb().elapsedRealtime()) {
                    zzcVar = new zzc();
                    this.zzae.put(str, zzcVar);
                }
                zzaVar.zzk(zzcVar.zza);
            }
        }
        if (zzi().zzq(str)) {
            zzaVar.zzr();
        }
    }

    private final void zzb(zzh zzhVar) {
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        zzl().zzv();
        if (TextUtils.isEmpty(zzhVar.zzah()) && TextUtils.isEmpty(zzhVar.zzaa())) {
            zza((String) Preconditions.checkNotNull(zzhVar.zzac()), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzhVar.zzac());
        zzj().zzq().zza("Fetching remote configuration", str);
        zzgc.zzd zzc2 = zzi().zzc(str);
        String zze = zzi().zze(str);
        if (zzc2 != null) {
            if (TextUtils.isEmpty(zze)) {
                arrayMap2 = null;
            } else {
                arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, zze);
            }
            String zzd = zzi().zzd(str);
            if (!TextUtils.isEmpty(zzd)) {
                if (arrayMap2 == null) {
                    arrayMap2 = new ArrayMap();
                }
                arrayMap2.put(HttpHeaders.IF_NONE_MATCH, zzd);
            }
            arrayMap = arrayMap2;
        } else {
            arrayMap = null;
        }
        this.zzu = true;
        zzgv zzh = zzh();
        zzgu zzguVar = new zzgu() { // from class: com.google.android.gms.measurement.internal.zzox
            @Override // com.google.android.gms.measurement.internal.zzgu
            public final void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                zzou.this.zza(str2, i, th, bArr, map);
            }
        };
        zzh.zzv();
        zzh.zzam();
        Preconditions.checkNotNull(zzhVar);
        Preconditions.checkNotNull(zzguVar);
        Uri.Builder builder = new Uri.Builder();
        String zzah = zzhVar.zzah();
        if (TextUtils.isEmpty(zzah)) {
            zzah = zzhVar.zzaa();
        }
        builder.scheme(zzbn.zze.zza(null)).encodedAuthority(zzbn.zzf.zza(null)).path("config/app/" + zzah).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "114010").appendQueryParameter("runtime_version", "0");
        String uri = builder.build().toString();
        try {
            zzh.zzl().zza(new zzgw(zzh, zzhVar.zzac(), new URI(uri).toURL(), null, arrayMap, zzguVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            zzh.zzj().zzg().zza("Failed to parse config URL. Not fetching. appId", zzgo.zza(zzhVar.zzac()), uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzh zzhVar, zzgf.zzk.zza zzaVar) {
        zzgf.zzp zzpVar;
        zzl().zzv();
        zzt();
        zzan zza2 = zzan.zza(zzaVar.zzw());
        String zzac = zzhVar.zzac();
        zzl().zzv();
        zzt();
        zzjj zzb2 = zzb(zzac);
        int i = zzpe.zza[zzb2.zzc().ordinal()];
        if (i == 1) {
            zza2.zza(zzjj.zza.AD_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (i == 2 || i == 3) {
            zza2.zza(zzjj.zza.AD_STORAGE, zzb2.zza());
        } else {
            zza2.zza(zzjj.zza.AD_STORAGE, zzam.FAILSAFE);
        }
        int i2 = zzpe.zza[zzb2.zzd().ordinal()];
        if (i2 == 1) {
            zza2.zza(zzjj.zza.ANALYTICS_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (i2 == 2 || i2 == 3) {
            zza2.zza(zzjj.zza.ANALYTICS_STORAGE, zzb2.zza());
        } else {
            zza2.zza(zzjj.zza.ANALYTICS_STORAGE, zzam.FAILSAFE);
        }
        String zzac2 = zzhVar.zzac();
        zzl().zzv();
        zzt();
        zzbd zza3 = zza(zzac2, zzd(zzac2), zzb(zzac2), zza2);
        zzaVar.zzb(((Boolean) Preconditions.checkNotNull(zza3.zzd())).booleanValue());
        if (!TextUtils.isEmpty(zza3.zze())) {
            zzaVar.zzh(zza3.zze());
        }
        zzl().zzv();
        zzt();
        Iterator<zzgf.zzp> it = zzaVar.zzac().iterator();
        while (true) {
            if (!it.hasNext()) {
                zzpVar = null;
                break;
            }
            zzpVar = it.next();
            if ("_npa".equals(zzpVar.zzg())) {
                break;
            }
        }
        if (zzpVar != null) {
            if (zza2.zza(zzjj.zza.AD_PERSONALIZATION) == zzam.UNSET) {
                zzpo zze = zzf().zze(zzhVar.zzac(), "_npa");
                if (zze != null) {
                    if ("tcf".equals(zze.zzb)) {
                        zza2.zza(zzjj.zza.AD_PERSONALIZATION, zzam.TCF);
                    } else if ("app".equals(zze.zzb)) {
                        zza2.zza(zzjj.zza.AD_PERSONALIZATION, zzam.API);
                    } else {
                        zza2.zza(zzjj.zza.AD_PERSONALIZATION, zzam.MANIFEST);
                    }
                } else {
                    Boolean zzx = zzhVar.zzx();
                    if (zzx == null || ((zzx == Boolean.TRUE && zzpVar.zzc() != 1) || (zzx == Boolean.FALSE && zzpVar.zzc() != 0))) {
                        zza2.zza(zzjj.zza.AD_PERSONALIZATION, zzam.API);
                    } else {
                        zza2.zza(zzjj.zza.AD_PERSONALIZATION, zzam.MANIFEST);
                    }
                }
            }
        } else {
            int zza4 = zza(zzhVar.zzac(), zza2);
            zzaVar.zza((zzgf.zzp) ((com.google.android.gms.internal.measurement.zzkg) zzgf.zzp.zze().zza("_npa").zzb(zzb().currentTimeMillis()).zza(zza4).zzaj()));
            zzj().zzq().zza("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(zza4));
        }
        zzaVar.zzf(zza2.toString());
        boolean zzm = this.zzb.zzm(zzhVar.zzac());
        List<zzgf.zzf> zzab = zzaVar.zzab();
        int i3 = 0;
        for (int i4 = 0; i4 < zzab.size(); i4++) {
            if ("_tcf".equals(zzab.get(i4).zzg())) {
                zzgf.zzf.zza zzch = zzab.get(i4).zzch();
                List<zzgf.zzh> zzf = zzch.zzf();
                while (true) {
                    if (i3 >= zzf.size()) {
                        break;
                    } else if ("_tcfd".equals(zzf.get(i3).zzg())) {
                        zzch.zza(i3, zzgf.zzh.zze().zza("_tcfd").zzb(zzoe.zza(zzf.get(i3).zzh(), zzm)));
                        break;
                    } else {
                        i3++;
                    }
                }
                zzaVar.zza(i4, zzch);
                return;
            }
        }
    }

    private static void zza(zzgf.zzf.zza zzaVar, int i, String str) {
        List<zzgf.zzh> zzf = zzaVar.zzf();
        for (int i2 = 0; i2 < zzf.size(); i2++) {
            if ("_err".equals(zzf.get(i2).zzg())) {
                return;
            }
        }
        zzaVar.zza((zzgf.zzh) ((com.google.android.gms.internal.measurement.zzkg) zzgf.zzh.zze().zza("_err").zza(Long.valueOf(i).longValue()).zzaj())).zza((zzgf.zzh) ((com.google.android.gms.internal.measurement.zzkg) zzgf.zzh.zze().zza("_ev").zzb(str).zzaj()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzbl zzblVar, zzp zzpVar) {
        long j;
        zzbl zzblVar2;
        List<zzag> zza2;
        List<zzag> zza3;
        List<zzag> zza4;
        long j2;
        String str;
        Preconditions.checkNotNull(zzpVar);
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzl().zzv();
        zzt();
        String str2 = zzpVar.zza;
        long j3 = zzblVar.zzd;
        zzgs zza5 = zzgs.zza(zzblVar);
        zzl().zzv();
        int i = 0;
        zzpn.zza((this.zzag == null || (str = this.zzah) == null || !str.equals(str2)) ? null : this.zzag, zza5.zzc, false);
        zzbl zza6 = zza5.zza();
        zzp();
        if (zzpj.zza(zza6, zzpVar)) {
            if (!zzpVar.zzh) {
                zza(zzpVar);
                return;
            }
            if (zzpVar.zzs == null) {
                j = j3;
                zzblVar2 = zza6;
            } else if (zzpVar.zzs.contains(zza6.zza)) {
                Bundle zzb2 = zza6.zzb.zzb();
                zzb2.putLong("ga_safelisted", 1L);
                j = j3;
                zzblVar2 = new zzbl(zza6.zza, new zzbg(zzb2), zza6.zzc, zza6.zzd);
            } else {
                zzj().zzc().zza("Dropping non-safelisted event. appId, event name, origin", str2, zza6.zza, zza6.zzc);
                return;
            }
            zzf().zzq();
            try {
                if (com.google.android.gms.internal.measurement.zzpe.zza() && zze().zza(zzbn.zzde) && "_s".equals(zzblVar2.zza) && !zzf().zzi(str2, "_s") && zzblVar2.zzb.zzb("_sid").longValue() != 0) {
                    if (!zzf().zzi(str2, "_f") && !zzf().zzi(str2, "_v")) {
                        zzf().zza(str2, Long.valueOf(zzb().currentTimeMillis() - 15000), "_sid", zza(zzpVar.zza, zzblVar2));
                    }
                    zzf().zza(str2, (Long) null, "_sid", zza(zzpVar.zza, zzblVar2));
                }
                zzar zzf = zzf();
                Preconditions.checkNotEmpty(str2);
                zzf.zzv();
                zzf.zzam();
                int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i2 < 0) {
                    zzf.zzj().zzr().zza("Invalid time querying timed out conditional properties", zzgo.zza(str2), Long.valueOf(j));
                    zza2 = Collections.emptyList();
                } else {
                    zza2 = zzf.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzag zzagVar : zza2) {
                    if (zzagVar != null) {
                        zzj().zzq().zza("User property timed out", zzagVar.zza, this.zzm.zzk().zzc(zzagVar.zzc.zza), zzagVar.zzc.zza());
                        if (zzagVar.zzg != null) {
                            j2 = j;
                            zzc(new zzbl(zzagVar.zzg, j2), zzpVar);
                        } else {
                            j2 = j;
                        }
                        zzf().zza(str2, zzagVar.zzc.zza);
                        j = j2;
                    }
                }
                long j4 = j;
                zzar zzf2 = zzf();
                Preconditions.checkNotEmpty(str2);
                zzf2.zzv();
                zzf2.zzam();
                if (i2 < 0) {
                    zzf2.zzj().zzr().zza("Invalid time querying expired conditional properties", zzgo.zza(str2), Long.valueOf(j4));
                    zza3 = Collections.emptyList();
                } else {
                    zza3 = zzf2.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j4)});
                }
                ArrayList arrayList = new ArrayList(zza3.size());
                for (zzag zzagVar2 : zza3) {
                    if (zzagVar2 != null) {
                        zzj().zzq().zza("User property expired", zzagVar2.zza, this.zzm.zzk().zzc(zzagVar2.zzc.zza), zzagVar2.zzc.zza());
                        zzf().zzh(str2, zzagVar2.zzc.zza);
                        if (zzagVar2.zzk != null) {
                            arrayList.add(zzagVar2.zzk);
                        }
                        zzf().zza(str2, zzagVar2.zzc.zza);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    zzc(new zzbl((zzbl) obj, j4), zzpVar);
                }
                zzar zzf3 = zzf();
                String str3 = zzblVar2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzf3.zzv();
                zzf3.zzam();
                if (i2 < 0) {
                    zzf3.zzj().zzr().zza("Invalid time querying triggered conditional properties", zzgo.zza(str2), zzf3.zzi().zza(str3), Long.valueOf(j4));
                    zza4 = Collections.emptyList();
                } else {
                    zza4 = zzf3.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j4)});
                }
                ArrayList arrayList3 = new ArrayList(zza4.size());
                for (zzag zzagVar3 : zza4) {
                    if (zzagVar3 != null) {
                        zzpm zzpmVar = zzagVar3.zzc;
                        long j5 = j4;
                        zzpo zzpoVar = new zzpo((String) Preconditions.checkNotNull(zzagVar3.zza), zzagVar3.zzb, zzpmVar.zza, j4, Preconditions.checkNotNull(zzpmVar.zza()));
                        if (zzf().zza(zzpoVar)) {
                            zzj().zzq().zza("User property triggered", zzagVar3.zza, this.zzm.zzk().zzc(zzpoVar.zzc), zzpoVar.zze);
                        } else {
                            zzj().zzg().zza("Too many active user properties, ignoring", zzgo.zza(zzagVar3.zza), this.zzm.zzk().zzc(zzpoVar.zzc), zzpoVar.zze);
                        }
                        if (zzagVar3.zzi != null) {
                            arrayList3.add(zzagVar3.zzi);
                        }
                        zzagVar3.zzc = new zzpm(zzpoVar);
                        zzagVar3.zze = true;
                        zzf().zza(zzagVar3);
                        j4 = j5;
                    }
                }
                long j6 = j4;
                zzc(zzblVar2, zzpVar);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList3.size();
                while (i < size2) {
                    Object obj2 = arrayList3.get(i);
                    i++;
                    long j7 = j6;
                    zzc(new zzbl((zzbl) obj2, j7), zzpVar);
                    j6 = j7;
                }
                zzf().zzx();
            } finally {
                zzf().zzr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzbl zzblVar, String str) {
        zzh zzd = zzf().zzd(str);
        if (zzd == null || TextUtils.isEmpty(zzd.zzaf())) {
            zzj().zzc().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zza2 = zza(zzd);
        if (zza2 == null) {
            if (!"_ui".equals(zzblVar.zza)) {
                zzj().zzr().zza("Could not find package. appId", zzgo.zza(str));
            }
        } else if (!zza2.booleanValue()) {
            zzj().zzg().zza("App version does not match; dropping event. appId", zzgo.zza(str));
            return;
        }
        zzb(zzblVar, new zzp(str, zzd.zzah(), zzd.zzaf(), zzd.zze(), zzd.zzae(), zzd.zzq(), zzd.zzn(), (String) null, zzd.zzar(), false, zzd.zzag(), 0L, 0, zzd.zzaq(), false, zzd.zzaa(), zzd.zzx(), zzd.zzo(), zzd.zzan(), (String) null, zzb(str).zzf(), "", (String) null, zzd.zzat(), zzd.zzw(), zzb(str).zza(), zzd(str).zzf(), zzd.zza(), zzd.zzf(), zzd.zzam(), zzd.zzak(), 0L, zzd.zzb()));
    }

    private final void zzb(zzbl zzblVar, zzp zzpVar) {
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzgs zza2 = zzgs.zza(zzblVar);
        zzq().zza(zza2.zzc, zzf().zzc(zzpVar.zza));
        zzq().zza(zza2, zze().zzb(zzpVar.zza));
        zzbl zza3 = zza2.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zza3.zza) && "referrer API v2".equals(zza3.zzb.zzd("_cis"))) {
            String zzd = zza3.zzb.zzd("gclid");
            if (!TextUtils.isEmpty(zzd)) {
                zza(new zzpm("_lgclid", zza3.zzd, zzd, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzpVar);
            }
        }
        zza(zza3, zzpVar);
    }

    private final void zza(zzgf.zzk.zza zzaVar, long j, boolean z) {
        zzpo zzpoVar;
        boolean z2;
        String str = z ? "_se" : "_lte";
        zzpo zze = zzf().zze(zzaVar.zzu(), str);
        if (zze == null || zze.zze == null) {
            zzpoVar = new zzpo(zzaVar.zzu(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzb().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzpoVar = new zzpo(zzaVar.zzu(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzb().currentTimeMillis(), Long.valueOf(((Long) zze.zze).longValue() + j));
        }
        zzgf.zzp zzpVar = (zzgf.zzp) ((com.google.android.gms.internal.measurement.zzkg) zzgf.zzp.zze().zza(str).zzb(zzb().currentTimeMillis()).zza(((Long) zzpoVar.zze).longValue()).zzaj());
        int zza2 = zzpj.zza(zzaVar, str);
        if (zza2 >= 0) {
            zzaVar.zza(zza2, zzpVar);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            zzaVar.zza(zzpVar);
        }
        if (j > 0) {
            zzf().zza(zzpoVar);
            zzj().zzq().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzpoVar.zze);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu() {
        this.zzt++;
    }

    private final void zzad() {
        zzl().zzv();
        if (zzbn.zzbv.zza(null).intValue() > 0) {
            zzae();
            return;
        }
        for (String str : this.zzr) {
            if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zze(str, zzbn.zzcp)) {
                zzj().zzc().zza("Notifying app that trigger URIs are available. App ID", str);
                Intent intent = new Intent();
                intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                intent.setPackage(str);
                this.zzm.zza().sendBroadcast(intent);
            }
        }
        this.zzr.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a6, code lost:
        r6.zzj.zzc.zza(zzb().currentTimeMillis());
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0118 A[Catch: all -> 0x0193, TryCatch #1 {all -> 0x019c, blocks: (B:4:0x0010, B:5:0x0012, B:63:0x0186, B:35:0x00d5, B:42:0x00f7, B:6:0x002b, B:15:0x0047, B:62:0x017f, B:20:0x0061, B:27:0x00a6, B:28:0x00b5, B:29:0x00ba, B:33:0x00cb, B:45:0x0104, B:47:0x0118, B:49:0x013c, B:51:0x0146, B:53:0x014c, B:54:0x0150, B:56:0x015c, B:58:0x0166, B:60:0x0174, B:61:0x017c, B:48:0x0126, B:38:0x00e2, B:40:0x00ec), top: B:72:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0126 A[Catch: all -> 0x0193, TryCatch #1 {all -> 0x019c, blocks: (B:4:0x0010, B:5:0x0012, B:63:0x0186, B:35:0x00d5, B:42:0x00f7, B:6:0x002b, B:15:0x0047, B:62:0x017f, B:20:0x0061, B:27:0x00a6, B:28:0x00b5, B:29:0x00ba, B:33:0x00cb, B:45:0x0104, B:47:0x0118, B:49:0x013c, B:51:0x0146, B:53:0x014c, B:54:0x0150, B:56:0x015c, B:58:0x0166, B:60:0x0174, B:61:0x017c, B:48:0x0126, B:38:0x00e2, B:40:0x00ec), top: B:72:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzou.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzaf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0075, code lost:
        r21.zzj.zzc.zza(zzb().currentTimeMillis());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(boolean r22, int r23, java.lang.Throwable r24, byte[] r25, java.lang.String r26, java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.zzgf.zzj, com.google.android.gms.measurement.internal.zzov>> r27) {
        /*
            Method dump skipped, instructions count: 731
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzou.zza(boolean, int, java.lang.Throwable, byte[], java.lang.String, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, int i, Throwable th, byte[] bArr, zzpi zzpiVar) {
        zzl().zzv();
        zzt();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzac();
                throw th2;
            }
        }
        if ((i == 200 || i == 204) && th == null) {
            if (zzpiVar != null) {
                zzf().zza(Long.valueOf(zzpiVar.zza()));
            }
            zzj().zzq().zza("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
            if (zze().zza(zzbn.zzch) && zzh().zzr() && zzf().zzq(str)) {
                zze(str);
            } else {
                zzaf();
            }
        } else {
            String str2 = new String(bArr, StandardCharsets.UTF_8);
            String substring = str2.substring(0, Math.min(32, str2.length()));
            zzgq zzw = zzj().zzw();
            Integer valueOf = Integer.valueOf(i);
            if (th == null) {
                th = substring;
            }
            zzw.zza("Network upload failed. Will retry later. appId, status, error", str, valueOf, th);
            if (zzpiVar != null) {
                zzf().zzb(Long.valueOf(zzpiVar.zza()));
            }
            zzaf();
        }
        this.zzv = false;
        zzac();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzh zzhVar, zzgf.zzk.zza zzaVar) {
        zzl().zzv();
        zzt();
        zzgf.zza.C0014zza zzc2 = zzgf.zza.zzc();
        byte[] zzav = zzhVar.zzav();
        if (zzav != null) {
            try {
                zzc2 = (zzgf.zza.C0014zza) zzpj.zza(zzc2, zzav);
            } catch (com.google.android.gms.internal.measurement.zzkp unused) {
                zzj().zzr().zza("Failed to parse locally stored ad campaign info. appId", zzgo.zza(zzhVar.zzac()));
            }
        }
        Iterator<zzgf.zzf> it = zzaVar.zzab().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzgf.zzf next = it.next();
            if (next.zzg().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzpj.zza(next, "gclid", "");
                String str2 = (String) zzpj.zza(next, "gbraid", "");
                String str3 = (String) zzpj.zza(next, "gad_source", "");
                if (!str.isEmpty() || !str2.isEmpty()) {
                    long longValue = ((Long) zzpj.zza(next, "click_timestamp", (Object) 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = next.zzd();
                    }
                    if ("referrer API v2".equals(zzpj.zzb(next, "_cis"))) {
                        if (longValue > zzc2.zzb()) {
                            if (str.isEmpty()) {
                                zzc2.zzh();
                            } else {
                                zzc2.zzf(str);
                            }
                            if (str2.isEmpty()) {
                                zzc2.zzg();
                            } else {
                                zzc2.zze(str2);
                            }
                            if (str3.isEmpty()) {
                                zzc2.zzf();
                            } else {
                                zzc2.zzd(str3);
                            }
                            zzc2.zzb(longValue);
                        }
                    } else {
                        if (longValue > zzc2.zza()) {
                            if (str.isEmpty()) {
                                zzc2.zze();
                            } else {
                                zzc2.zzc(str);
                            }
                            if (str2.isEmpty()) {
                                zzc2.zzd();
                            } else {
                                zzc2.zzb(str2);
                            }
                            if (str3.isEmpty()) {
                                zzc2.zzc();
                            } else {
                                zzc2.zza(str3);
                            }
                            zzc2.zza(longValue);
                        }
                    }
                }
            }
        }
        if (!((zzgf.zza) ((com.google.android.gms.internal.measurement.zzkg) zzc2.zzaj())).equals(zzgf.zza.zze())) {
            zzaVar.zza((zzgf.zza) ((com.google.android.gms.internal.measurement.zzkg) zzc2.zzaj()));
        }
        zzhVar.zza(((zzgf.zza) ((com.google.android.gms.internal.measurement.zzkg) zzc2.zzaj())).zzce());
        if (zzhVar.zzas()) {
            zzf().zza(zzhVar, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(zzp zzpVar) {
        zzl().zzv();
        zzt();
        Preconditions.checkNotNull(zzpVar);
        Preconditions.checkNotEmpty(zzpVar.zza);
        int i = 0;
        if (zze().zza(zzbn.zzbt)) {
            long currentTimeMillis = zzb().currentTimeMillis();
            int zzb2 = zze().zzb((String) null, zzbn.zzbc);
            zze();
            long zzg = currentTimeMillis - zzai.zzg();
            while (i < zzb2 && zzb((String) null, zzg)) {
                i++;
            }
        } else {
            zze();
            long zzh = zzai.zzh();
            while (i < zzh && zzb(zzpVar.zza, 0L)) {
                i++;
            }
        }
        if (zze().zza(zzbn.zzbu)) {
            zzad();
        }
        if (zze().zza(zzbn.zzck) && this.zzk.zza(zzpVar.zza, zzgf.zzo.zza.zza(zzpVar.zzaf))) {
            zza(zzpVar.zza, zzb().currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cd, code lost:
        if (r11.booleanValue() == false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00cf, code lost:
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d2, code lost:
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d4, code lost:
        r11 = 1;
        r0 = new com.google.android.gms.measurement.internal.zzpm("_npa", r21, java.lang.Long.valueOf(r14), kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e1, code lost:
        if (r10 == null) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00eb, code lost:
        if (r10.zze.equals(r0.zzc) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ed, code lost:
        zza(r0, r24);
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03ae A[Catch: all -> 0x0535, TryCatch #0 {all -> 0x0535, blocks: (B:24:0x00a4, B:26:0x00b6, B:43:0x00f7, B:45:0x0109, B:47:0x011e, B:48:0x0144, B:50:0x01a3, B:53:0x01b6, B:56:0x01ca, B:58:0x01d5, B:62:0x01e2, B:65:0x01f3, B:69:0x01fe, B:71:0x0201, B:72:0x0221, B:74:0x0226, B:79:0x0245, B:82:0x0259, B:84:0x0280, B:87:0x0288, B:89:0x0297, B:117:0x0380, B:119:0x03ae, B:120:0x03b1, B:122:0x03d9, B:159:0x049e, B:160:0x04a1, B:170:0x0526, B:124:0x03ee, B:129:0x0413, B:131:0x041b, B:133:0x0423, B:137:0x0435, B:141:0x0443, B:145:0x044e, B:138:0x043b, B:146:0x045d, B:149:0x046e, B:151:0x0482, B:153:0x0488, B:154:0x048d, B:156:0x0493, B:127:0x03ff, B:90:0x02a8, B:92:0x02d3, B:93:0x02e4, B:95:0x02eb, B:97:0x02f1, B:99:0x02fb, B:101:0x0305, B:103:0x030b, B:105:0x0311, B:106:0x0316, B:110:0x0338, B:113:0x033d, B:114:0x0351, B:115:0x0361, B:116:0x0371, B:163:0x04bc, B:165:0x04ed, B:166:0x04f0, B:167:0x0507, B:169:0x050b, B:76:0x0235, B:31:0x00c5, B:35:0x00d4, B:37:0x00e3, B:39:0x00ed, B:42:0x00f4), top: B:176:0x00a4, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03d9 A[Catch: all -> 0x0535, TRY_LEAVE, TryCatch #0 {all -> 0x0535, blocks: (B:24:0x00a4, B:26:0x00b6, B:43:0x00f7, B:45:0x0109, B:47:0x011e, B:48:0x0144, B:50:0x01a3, B:53:0x01b6, B:56:0x01ca, B:58:0x01d5, B:62:0x01e2, B:65:0x01f3, B:69:0x01fe, B:71:0x0201, B:72:0x0221, B:74:0x0226, B:79:0x0245, B:82:0x0259, B:84:0x0280, B:87:0x0288, B:89:0x0297, B:117:0x0380, B:119:0x03ae, B:120:0x03b1, B:122:0x03d9, B:159:0x049e, B:160:0x04a1, B:170:0x0526, B:124:0x03ee, B:129:0x0413, B:131:0x041b, B:133:0x0423, B:137:0x0435, B:141:0x0443, B:145:0x044e, B:138:0x043b, B:146:0x045d, B:149:0x046e, B:151:0x0482, B:153:0x0488, B:154:0x048d, B:156:0x0493, B:127:0x03ff, B:90:0x02a8, B:92:0x02d3, B:93:0x02e4, B:95:0x02eb, B:97:0x02f1, B:99:0x02fb, B:101:0x0305, B:103:0x030b, B:105:0x0311, B:106:0x0316, B:110:0x0338, B:113:0x033d, B:114:0x0351, B:115:0x0361, B:116:0x0371, B:163:0x04bc, B:165:0x04ed, B:166:0x04f0, B:167:0x0507, B:169:0x050b, B:76:0x0235, B:31:0x00c5, B:35:0x00d4, B:37:0x00e3, B:39:0x00ed, B:42:0x00f4), top: B:176:0x00a4, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x049e A[Catch: all -> 0x0535, TryCatch #0 {all -> 0x0535, blocks: (B:24:0x00a4, B:26:0x00b6, B:43:0x00f7, B:45:0x0109, B:47:0x011e, B:48:0x0144, B:50:0x01a3, B:53:0x01b6, B:56:0x01ca, B:58:0x01d5, B:62:0x01e2, B:65:0x01f3, B:69:0x01fe, B:71:0x0201, B:72:0x0221, B:74:0x0226, B:79:0x0245, B:82:0x0259, B:84:0x0280, B:87:0x0288, B:89:0x0297, B:117:0x0380, B:119:0x03ae, B:120:0x03b1, B:122:0x03d9, B:159:0x049e, B:160:0x04a1, B:170:0x0526, B:124:0x03ee, B:129:0x0413, B:131:0x041b, B:133:0x0423, B:137:0x0435, B:141:0x0443, B:145:0x044e, B:138:0x043b, B:146:0x045d, B:149:0x046e, B:151:0x0482, B:153:0x0488, B:154:0x048d, B:156:0x0493, B:127:0x03ff, B:90:0x02a8, B:92:0x02d3, B:93:0x02e4, B:95:0x02eb, B:97:0x02f1, B:99:0x02fb, B:101:0x0305, B:103:0x030b, B:105:0x0311, B:106:0x0316, B:110:0x0338, B:113:0x033d, B:114:0x0351, B:115:0x0361, B:116:0x0371, B:163:0x04bc, B:165:0x04ed, B:166:0x04f0, B:167:0x0507, B:169:0x050b, B:76:0x0235, B:31:0x00c5, B:35:0x00d4, B:37:0x00e3, B:39:0x00ed, B:42:0x00f4), top: B:176:0x00a4, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0507 A[Catch: all -> 0x0535, TryCatch #0 {all -> 0x0535, blocks: (B:24:0x00a4, B:26:0x00b6, B:43:0x00f7, B:45:0x0109, B:47:0x011e, B:48:0x0144, B:50:0x01a3, B:53:0x01b6, B:56:0x01ca, B:58:0x01d5, B:62:0x01e2, B:65:0x01f3, B:69:0x01fe, B:71:0x0201, B:72:0x0221, B:74:0x0226, B:79:0x0245, B:82:0x0259, B:84:0x0280, B:87:0x0288, B:89:0x0297, B:117:0x0380, B:119:0x03ae, B:120:0x03b1, B:122:0x03d9, B:159:0x049e, B:160:0x04a1, B:170:0x0526, B:124:0x03ee, B:129:0x0413, B:131:0x041b, B:133:0x0423, B:137:0x0435, B:141:0x0443, B:145:0x044e, B:138:0x043b, B:146:0x045d, B:149:0x046e, B:151:0x0482, B:153:0x0488, B:154:0x048d, B:156:0x0493, B:127:0x03ff, B:90:0x02a8, B:92:0x02d3, B:93:0x02e4, B:95:0x02eb, B:97:0x02f1, B:99:0x02fb, B:101:0x0305, B:103:0x030b, B:105:0x0311, B:106:0x0316, B:110:0x0338, B:113:0x033d, B:114:0x0351, B:115:0x0361, B:116:0x0371, B:163:0x04bc, B:165:0x04ed, B:166:0x04f0, B:167:0x0507, B:169:0x050b, B:76:0x0235, B:31:0x00c5, B:35:0x00d4, B:37:0x00e3, B:39:0x00ed, B:42:0x00f4), top: B:176:0x00a4, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0109 A[Catch: all -> 0x0535, TryCatch #0 {all -> 0x0535, blocks: (B:24:0x00a4, B:26:0x00b6, B:43:0x00f7, B:45:0x0109, B:47:0x011e, B:48:0x0144, B:50:0x01a3, B:53:0x01b6, B:56:0x01ca, B:58:0x01d5, B:62:0x01e2, B:65:0x01f3, B:69:0x01fe, B:71:0x0201, B:72:0x0221, B:74:0x0226, B:79:0x0245, B:82:0x0259, B:84:0x0280, B:87:0x0288, B:89:0x0297, B:117:0x0380, B:119:0x03ae, B:120:0x03b1, B:122:0x03d9, B:159:0x049e, B:160:0x04a1, B:170:0x0526, B:124:0x03ee, B:129:0x0413, B:131:0x041b, B:133:0x0423, B:137:0x0435, B:141:0x0443, B:145:0x044e, B:138:0x043b, B:146:0x045d, B:149:0x046e, B:151:0x0482, B:153:0x0488, B:154:0x048d, B:156:0x0493, B:127:0x03ff, B:90:0x02a8, B:92:0x02d3, B:93:0x02e4, B:95:0x02eb, B:97:0x02f1, B:99:0x02fb, B:101:0x0305, B:103:0x030b, B:105:0x0311, B:106:0x0316, B:110:0x0338, B:113:0x033d, B:114:0x0351, B:115:0x0361, B:116:0x0371, B:163:0x04bc, B:165:0x04ed, B:166:0x04f0, B:167:0x0507, B:169:0x050b, B:76:0x0235, B:31:0x00c5, B:35:0x00d4, B:37:0x00e3, B:39:0x00ed, B:42:0x00f4), top: B:176:0x00a4, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ca A[Catch: all -> 0x0535, TryCatch #0 {all -> 0x0535, blocks: (B:24:0x00a4, B:26:0x00b6, B:43:0x00f7, B:45:0x0109, B:47:0x011e, B:48:0x0144, B:50:0x01a3, B:53:0x01b6, B:56:0x01ca, B:58:0x01d5, B:62:0x01e2, B:65:0x01f3, B:69:0x01fe, B:71:0x0201, B:72:0x0221, B:74:0x0226, B:79:0x0245, B:82:0x0259, B:84:0x0280, B:87:0x0288, B:89:0x0297, B:117:0x0380, B:119:0x03ae, B:120:0x03b1, B:122:0x03d9, B:159:0x049e, B:160:0x04a1, B:170:0x0526, B:124:0x03ee, B:129:0x0413, B:131:0x041b, B:133:0x0423, B:137:0x0435, B:141:0x0443, B:145:0x044e, B:138:0x043b, B:146:0x045d, B:149:0x046e, B:151:0x0482, B:153:0x0488, B:154:0x048d, B:156:0x0493, B:127:0x03ff, B:90:0x02a8, B:92:0x02d3, B:93:0x02e4, B:95:0x02eb, B:97:0x02f1, B:99:0x02fb, B:101:0x0305, B:103:0x030b, B:105:0x0311, B:106:0x0316, B:110:0x0338, B:113:0x033d, B:114:0x0351, B:115:0x0361, B:116:0x0371, B:163:0x04bc, B:165:0x04ed, B:166:0x04f0, B:167:0x0507, B:169:0x050b, B:76:0x0235, B:31:0x00c5, B:35:0x00d4, B:37:0x00e3, B:39:0x00ed, B:42:0x00f4), top: B:176:0x00a4, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0226 A[Catch: all -> 0x0535, TryCatch #0 {all -> 0x0535, blocks: (B:24:0x00a4, B:26:0x00b6, B:43:0x00f7, B:45:0x0109, B:47:0x011e, B:48:0x0144, B:50:0x01a3, B:53:0x01b6, B:56:0x01ca, B:58:0x01d5, B:62:0x01e2, B:65:0x01f3, B:69:0x01fe, B:71:0x0201, B:72:0x0221, B:74:0x0226, B:79:0x0245, B:82:0x0259, B:84:0x0280, B:87:0x0288, B:89:0x0297, B:117:0x0380, B:119:0x03ae, B:120:0x03b1, B:122:0x03d9, B:159:0x049e, B:160:0x04a1, B:170:0x0526, B:124:0x03ee, B:129:0x0413, B:131:0x041b, B:133:0x0423, B:137:0x0435, B:141:0x0443, B:145:0x044e, B:138:0x043b, B:146:0x045d, B:149:0x046e, B:151:0x0482, B:153:0x0488, B:154:0x048d, B:156:0x0493, B:127:0x03ff, B:90:0x02a8, B:92:0x02d3, B:93:0x02e4, B:95:0x02eb, B:97:0x02f1, B:99:0x02fb, B:101:0x0305, B:103:0x030b, B:105:0x0311, B:106:0x0316, B:110:0x0338, B:113:0x033d, B:114:0x0351, B:115:0x0361, B:116:0x0371, B:163:0x04bc, B:165:0x04ed, B:166:0x04f0, B:167:0x0507, B:169:0x050b, B:76:0x0235, B:31:0x00c5, B:35:0x00d4, B:37:0x00e3, B:39:0x00ed, B:42:0x00f4), top: B:176:0x00a4, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0245 A[Catch: all -> 0x0535, TRY_LEAVE, TryCatch #0 {all -> 0x0535, blocks: (B:24:0x00a4, B:26:0x00b6, B:43:0x00f7, B:45:0x0109, B:47:0x011e, B:48:0x0144, B:50:0x01a3, B:53:0x01b6, B:56:0x01ca, B:58:0x01d5, B:62:0x01e2, B:65:0x01f3, B:69:0x01fe, B:71:0x0201, B:72:0x0221, B:74:0x0226, B:79:0x0245, B:82:0x0259, B:84:0x0280, B:87:0x0288, B:89:0x0297, B:117:0x0380, B:119:0x03ae, B:120:0x03b1, B:122:0x03d9, B:159:0x049e, B:160:0x04a1, B:170:0x0526, B:124:0x03ee, B:129:0x0413, B:131:0x041b, B:133:0x0423, B:137:0x0435, B:141:0x0443, B:145:0x044e, B:138:0x043b, B:146:0x045d, B:149:0x046e, B:151:0x0482, B:153:0x0488, B:154:0x048d, B:156:0x0493, B:127:0x03ff, B:90:0x02a8, B:92:0x02d3, B:93:0x02e4, B:95:0x02eb, B:97:0x02f1, B:99:0x02fb, B:101:0x0305, B:103:0x030b, B:105:0x0311, B:106:0x0316, B:110:0x0338, B:113:0x033d, B:114:0x0351, B:115:0x0361, B:116:0x0371, B:163:0x04bc, B:165:0x04ed, B:166:0x04f0, B:167:0x0507, B:169:0x050b, B:76:0x0235, B:31:0x00c5, B:35:0x00d4, B:37:0x00e3, B:39:0x00ed, B:42:0x00f4), top: B:176:0x00a4, inners: #1, #2, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(com.google.android.gms.measurement.internal.zzp r24) {
        /*
            Method dump skipped, instructions count: 1342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzou.zzd(com.google.android.gms.measurement.internal.zzp):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzv() {
        this.zzs++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzag zzagVar) {
        zzp zzc2 = zzc((String) Preconditions.checkNotNull(zzagVar.zza));
        if (zzc2 != null) {
            zza(zzagVar, zzc2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzag zzagVar, zzp zzpVar) {
        Preconditions.checkNotNull(zzagVar);
        Preconditions.checkNotEmpty(zzagVar.zza);
        Preconditions.checkNotNull(zzagVar.zzc);
        Preconditions.checkNotEmpty(zzagVar.zzc.zza);
        zzl().zzv();
        zzt();
        if (zzi(zzpVar)) {
            if (!zzpVar.zzh) {
                zza(zzpVar);
                return;
            }
            zzf().zzq();
            try {
                zza(zzpVar);
                String str = (String) Preconditions.checkNotNull(zzagVar.zza);
                zzag zzc2 = zzf().zzc(str, zzagVar.zzc.zza);
                if (zzc2 != null) {
                    zzj().zzc().zza("Removing conditional user property", zzagVar.zza, this.zzm.zzk().zzc(zzagVar.zzc.zza));
                    zzf().zza(str, zzagVar.zzc.zza);
                    if (zzc2.zze) {
                        zzf().zzh(str, zzagVar.zzc.zza);
                    }
                    if (zzagVar.zzk != null) {
                        zzc((zzbl) Preconditions.checkNotNull(zzq().zza(str, ((zzbl) Preconditions.checkNotNull(zzagVar.zzk)).zza, zzagVar.zzk.zzb != null ? zzagVar.zzk.zzb.zzb() : null, zzc2.zzb, zzagVar.zzk.zzd, true, true)), zzpVar);
                    }
                } else {
                    zzj().zzr().zza("Conditional user property doesn't exist", zzgo.zza(zzagVar.zza), this.zzm.zzk().zzc(zzagVar.zzc.zza));
                }
                zzf().zzx();
            } finally {
                zzf().zzr();
            }
        }
    }

    private static void zza(zzgf.zzf.zza zzaVar, String str) {
        List<zzgf.zzh> zzf = zzaVar.zzf();
        for (int i = 0; i < zzf.size(); i++) {
            if (str.equals(zzf.get(i).zzg())) {
                zzaVar.zza(i);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, zzp zzpVar) {
        zzl().zzv();
        zzt();
        if (zzi(zzpVar)) {
            if (!zzpVar.zzh) {
                zza(zzpVar);
                return;
            }
            Boolean zzh = zzh(zzpVar);
            if ("_npa".equals(str) && zzh != null) {
                zzj().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzpm("_npa", zzb().currentTimeMillis(), Long.valueOf(zzh.booleanValue() ? 1L : 0L), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzpVar);
                return;
            }
            zzj().zzc().zza("Removing user property", this.zzm.zzk().zzc(str));
            zzf().zzq();
            try {
                zza(zzpVar);
                if ("_id".equals(str)) {
                    zzf().zzh((String) Preconditions.checkNotNull(zzpVar.zza), "_lair");
                }
                zzf().zzh((String) Preconditions.checkNotNull(zzpVar.zza), str);
                zzf().zzx();
                zzj().zzc().zza("User property removed", this.zzm.zzk().zzc(str));
            } finally {
                zzf().zzr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(zzp zzpVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzaa = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzar zzf = zzf();
        String str = (String) Preconditions.checkNotNull(zzpVar.zza);
        Preconditions.checkNotEmpty(str);
        zzf.zzv();
        zzf.zzam();
        try {
            SQLiteDatabase f_ = zzf.f_();
            String[] strArr = {str};
            int delete = f_.delete("apps", "app_id=?", strArr) + 0 + f_.delete("events", "app_id=?", strArr) + f_.delete("events_snapshot", "app_id=?", strArr) + f_.delete("user_attributes", "app_id=?", strArr) + f_.delete("conditional_properties", "app_id=?", strArr) + f_.delete("raw_events", "app_id=?", strArr) + f_.delete("raw_events_metadata", "app_id=?", strArr) + f_.delete("queue", "app_id=?", strArr) + f_.delete("audience_filter_values", "app_id=?", strArr) + f_.delete("main_event_params", "app_id=?", strArr) + f_.delete("default_event_params", "app_id=?", strArr) + f_.delete("trigger_uris", "app_id=?", strArr) + f_.delete("upload_queue", "app_id=?", strArr);
            if (delete > 0) {
                zzf.zzj().zzq().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzf.zzj().zzg().zza("Error resetting analytics data. appId, error", zzgo.zza(str), e);
        }
        if (zzpVar.zzh) {
            zzd(zzpVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzae() {
        zzl().zzv();
        if (this.zzr.isEmpty() || zzz().zzc()) {
            return;
        }
        long max = Math.max(0L, zzbn.zzbv.zza(null).intValue() - (zzb().elapsedRealtime() - this.zzaj));
        zzj().zzq().zza("Scheduling notify next app runnable, delay in ms", Long.valueOf(max));
        zzz().zza(max);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(zzp zzpVar) {
        zzl().zzv();
        zzt();
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzbd zza2 = zzbd.zza(zzpVar.zzz);
        zzj().zzq().zza("Setting DMA consent for package", zzpVar.zza, zza2);
        String str = zzpVar.zza;
        zzl().zzv();
        zzt();
        zzjm zzc2 = zzbd.zza(zza(str), 100).zzc();
        this.zzad.put(str, zza2);
        zzf().zza(str, zza2);
        zzjm zzc3 = zzbd.zza(zza(str), 100).zzc();
        zzl().zzv();
        zzt();
        boolean z = true;
        boolean z2 = zzc2 == zzjm.DENIED && zzc3 == zzjm.GRANTED;
        if (zzc2 != zzjm.GRANTED || zzc3 != zzjm.DENIED) {
            z = false;
        }
        if (z2 || z) {
            zzj().zzq().zza("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzf().zza(zzy(), str, false, false, false, false, false, false, false).zzf < zze().zzb(str, zzbn.zzbg)) {
                bundle.putLong("_r", 1L);
                zzj().zzq().zza("_dcu realtime event count", str, Long.valueOf(zzf().zza(zzy(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzak.zza(str, "_dcu", bundle);
        }
    }

    public final void zza(String str, zzlw zzlwVar) {
        zzl().zzv();
        String str2 = this.zzah;
        if (str2 == null || str2.equals(str) || zzlwVar != null) {
            this.zzah = str;
            this.zzag = zzlwVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzg(zzp zzpVar) {
        zzl().zzv();
        zzt();
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzjj zza2 = zzjj.zza(zzpVar.zzt, zzpVar.zzy);
        zzb(zzpVar.zza);
        zzj().zzq().zza("Setting storage consent for package", zzpVar.zza, zza2);
        zza(zzpVar.zza, zza2);
    }

    private final void zza(List<Long> list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzj().zzg().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzw() {
        int delete;
        zzl().zzv();
        zzf().zzw();
        zzar zzf = zzf();
        zzf.zzv();
        zzf.zzam();
        if (zzf.zzab() && zzbn.zzbp.zza(null).longValue() != 0 && (delete = zzf.f_().delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzf.zzb().currentTimeMillis()), String.valueOf(zzbn.zzbp.zza(null))})) > 0) {
            zzf.zzj().zzq().zza("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
        }
        if (this.zzj.zzd.zza() == 0) {
            this.zzj.zzd.zza(zzb().currentTimeMillis());
        }
        zzaf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzag zzagVar) {
        zzp zzc2 = zzc((String) Preconditions.checkNotNull(zzagVar.zza));
        if (zzc2 != null) {
            zzb(zzagVar, zzc2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzag zzagVar, zzp zzpVar) {
        Preconditions.checkNotNull(zzagVar);
        Preconditions.checkNotEmpty(zzagVar.zza);
        Preconditions.checkNotNull(zzagVar.zzb);
        Preconditions.checkNotNull(zzagVar.zzc);
        Preconditions.checkNotEmpty(zzagVar.zzc.zza);
        zzl().zzv();
        zzt();
        if (zzi(zzpVar)) {
            if (!zzpVar.zzh) {
                zza(zzpVar);
                return;
            }
            zzag zzagVar2 = new zzag(zzagVar);
            boolean z = false;
            zzagVar2.zze = false;
            zzf().zzq();
            try {
                zzag zzc2 = zzf().zzc((String) Preconditions.checkNotNull(zzagVar2.zza), zzagVar2.zzc.zza);
                if (zzc2 != null && !zzc2.zzb.equals(zzagVar2.zzb)) {
                    zzj().zzr().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzm.zzk().zzc(zzagVar2.zzc.zza), zzagVar2.zzb, zzc2.zzb);
                }
                if (zzc2 != null && zzc2.zze) {
                    zzagVar2.zzb = zzc2.zzb;
                    zzagVar2.zzd = zzc2.zzd;
                    zzagVar2.zzh = zzc2.zzh;
                    zzagVar2.zzf = zzc2.zzf;
                    zzagVar2.zzi = zzc2.zzi;
                    zzagVar2.zze = zzc2.zze;
                    zzagVar2.zzc = new zzpm(zzagVar2.zzc.zza, zzc2.zzc.zzb, zzagVar2.zzc.zza(), zzc2.zzc.zze);
                } else if (TextUtils.isEmpty(zzagVar2.zzf)) {
                    zzagVar2.zzc = new zzpm(zzagVar2.zzc.zza, zzagVar2.zzd, zzagVar2.zzc.zza(), zzagVar2.zzc.zze);
                    z = true;
                    zzagVar2.zze = true;
                }
                if (zzagVar2.zze) {
                    zzpm zzpmVar = zzagVar2.zzc;
                    zzpo zzpoVar = new zzpo((String) Preconditions.checkNotNull(zzagVar2.zza), zzagVar2.zzb, zzpmVar.zza, zzpmVar.zzb, Preconditions.checkNotNull(zzpmVar.zza()));
                    if (zzf().zza(zzpoVar)) {
                        zzj().zzc().zza("User property updated immediately", zzagVar2.zza, this.zzm.zzk().zzc(zzpoVar.zzc), zzpoVar.zze);
                    } else {
                        zzj().zzg().zza("(2)Too many active user properties, ignoring", zzgo.zza(zzagVar2.zza), this.zzm.zzk().zzc(zzpoVar.zzc), zzpoVar.zze);
                    }
                    if (z && zzagVar2.zzi != null) {
                        zzc(new zzbl(zzagVar2.zzi, zzagVar2.zzd), zzpVar);
                    }
                }
                if (zzf().zza(zzagVar2)) {
                    zzj().zzc().zza("Conditional property added", zzagVar2.zza, this.zzm.zzk().zzc(zzagVar2.zzc.zza), zzagVar2.zzc.zza());
                } else {
                    zzj().zzg().zza("Too many conditional properties, ignoring", zzgo.zza(zzagVar2.zza), this.zzm.zzk().zzc(zzagVar2.zzc.zza), zzagVar2.zzc.zza());
                }
                zzf().zzx();
            } finally {
                zzf().zzr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, zzae zzaeVar) {
        if (zze().zza(zzbn.zzcj)) {
            zzl().zzv();
            zzt();
            zzpi zza2 = zzf().zza(zzaeVar.zza);
            if (zza2 == null) {
                zzj().zzr().zza("Queued batch doesn't exist. appId, rowId", str, Long.valueOf(zzaeVar.zza));
                return;
            }
            String zze = zza2.zze();
            if (zzaeVar.zzb == zzlv.SUCCESS.zza()) {
                if (this.zzaf.containsKey(zze)) {
                    this.zzaf.remove(zze);
                }
                zzf().zza(Long.valueOf(zzaeVar.zza));
                if (zzaeVar.zzc > 0) {
                    zzar zzf = zzf();
                    long j = zzaeVar.zzc;
                    if (zzf.zze().zza(zzbn.zzcj)) {
                        zzf.zzv();
                        zzf.zzam();
                        Preconditions.checkNotNull(Long.valueOf(j));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("upload_type", Integer.valueOf(zzlu.GOOGLE_SIGNAL.zza()));
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzf.zzb().currentTimeMillis()));
                        try {
                            if (zzf.f_().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j), str, String.valueOf(zzlu.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                                zzf.zzj().zzr().zza("Google Signal pending batch not updated. appId, rowId", str, Long.valueOf(j));
                                return;
                            }
                            return;
                        } catch (SQLiteException e) {
                            zzf.zzj().zzg().zza("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j), e);
                            throw e;
                        }
                    }
                    return;
                }
                return;
            }
            zzb zzbVar = this.zzaf.get(zze);
            if (zzbVar == null) {
                this.zzaf.put(zze, new zzb(this));
            } else {
                zzbVar.zza();
            }
            zzf().zzb(Long.valueOf(zzaeVar.zza));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzaf() {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzou.zzaf():void");
    }

    private final void zza(String str, zzjj zzjjVar) {
        zzl().zzv();
        zzt();
        this.zzac.put(str, zzjjVar);
        zzf().zzb(str, zzjjVar);
    }

    private final void zza(String str, boolean z, Long l, Long l2) {
        zzh zzd = zzf().zzd(str);
        if (zzd != null) {
            zzd.zzd(z);
            zzd.zza(l);
            zzd.zzb(l2);
            if (zzd.zzas()) {
                zzf().zza(zzd, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzpm zzpmVar, zzp zzpVar) {
        zzpo zze;
        long j;
        zzl().zzv();
        zzt();
        if (zzi(zzpVar)) {
            if (!zzpVar.zzh) {
                zza(zzpVar);
                return;
            }
            int zzb2 = zzq().zzb(zzpmVar.zza);
            int i = 0;
            if (zzb2 != 0) {
                zzq();
                String str = zzpmVar.zza;
                zze();
                String zza2 = zzpn.zza(str, 24, true);
                int length = zzpmVar.zza != null ? zzpmVar.zza.length() : 0;
                zzq();
                zzpn.zza(this.zzak, zzpVar.zza, zzb2, "_ev", zza2, length);
                return;
            }
            int zza3 = zzq().zza(zzpmVar.zza, zzpmVar.zza());
            if (zza3 != 0) {
                zzq();
                String str2 = zzpmVar.zza;
                zze();
                String zza4 = zzpn.zza(str2, 24, true);
                Object zza5 = zzpmVar.zza();
                if (zza5 != null && ((zza5 instanceof String) || (zza5 instanceof CharSequence))) {
                    i = String.valueOf(zza5).length();
                }
                zzq();
                zzpn.zza(this.zzak, zzpVar.zza, zza3, "_ev", zza4, i);
                return;
            }
            Object zzc2 = zzq().zzc(zzpmVar.zza, zzpmVar.zza());
            if (zzc2 == null) {
                return;
            }
            if ("_sid".equals(zzpmVar.zza)) {
                long j2 = zzpmVar.zzb;
                String str3 = zzpmVar.zze;
                String str4 = (String) Preconditions.checkNotNull(zzpVar.zza);
                zzpo zze2 = zzf().zze(str4, "_sno");
                if (zze2 != null && (zze2.zze instanceof Long)) {
                    j = ((Long) zze2.zze).longValue();
                } else {
                    if (zze2 != null) {
                        zzj().zzr().zza("Retrieved last session number from database does not contain a valid (long) value", zze2.zze);
                    }
                    zzbh zzd = zzf().zzd(str4, "_s");
                    if (zzd != null) {
                        j = zzd.zzc;
                        zzj().zzq().zza("Backfill the session number. Last used session number", Long.valueOf(j));
                    } else {
                        j = 0;
                    }
                }
                zza(new zzpm("_sno", j2, Long.valueOf(j + 1), str3), zzpVar);
            }
            zzpo zzpoVar = new zzpo((String) Preconditions.checkNotNull(zzpVar.zza), (String) Preconditions.checkNotNull(zzpmVar.zze), zzpmVar.zza, zzpmVar.zzb, zzc2);
            zzj().zzq().zza("Setting user property", this.zzm.zzk().zzc(zzpoVar.zzc), zzc2);
            zzf().zzq();
            try {
                if ("_id".equals(zzpoVar.zzc) && (zze = zzf().zze(zzpVar.zza, "_id")) != null && !zzpoVar.zze.equals(zze.zze)) {
                    zzf().zzh(zzpVar.zza, "_lair");
                }
                zza(zzpVar);
                boolean zza6 = zzf().zza(zzpoVar);
                if ("_sid".equals(zzpmVar.zza)) {
                    long zza7 = zzp().zza(zzpVar.zzv);
                    zzh zzd2 = zzf().zzd(zzpVar.zza);
                    if (zzd2 != null) {
                        zzd2.zzs(zza7);
                        if (zzd2.zzas()) {
                            zzf().zza(zzd2, false, false);
                        }
                    }
                }
                zzf().zzx();
                if (!zza6) {
                    zzj().zzg().zza("Too many unique user properties are set. Ignoring user property", this.zzm.zzk().zzc(zzpoVar.zzc), zzpoVar.zze);
                    zzq();
                    zzpn.zza(this.zzak, zzpVar.zza, 9, (String) null, (String) null, 0);
                }
            } finally {
                zzf().zzr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzx() {
        zzh zzd;
        zzl().zzv();
        zzt();
        boolean z = true;
        this.zzw = true;
        try {
            Boolean zzad = this.zzm.zzt().zzad();
            if (zzad == null) {
                zzj().zzr().zza("Upload data called on the client side before use of service was decided");
            } else if (zzad.booleanValue()) {
                zzj().zzg().zza("Upload called in the client side when service should be used");
            } else if (this.zzp > 0) {
                zzaf();
            } else {
                zzl().zzv();
                if (this.zzz == null) {
                    z = false;
                }
                if (z) {
                    zzj().zzq().zza("Uploading requested multiple times");
                } else if (!zzh().zzr()) {
                    zzj().zzq().zza("Network not connected, ignoring upload request");
                    zzaf();
                } else {
                    long currentTimeMillis = zzb().currentTimeMillis();
                    int zzb2 = zze().zzb((String) null, zzbn.zzbc);
                    zze();
                    long zzg = currentTimeMillis - zzai.zzg();
                    for (int i = 0; i < zzb2 && zzb((String) null, zzg); i++) {
                    }
                    if (com.google.android.gms.internal.measurement.zzoy.zza()) {
                        zzad();
                    }
                    long zza2 = this.zzj.zzd.zza();
                    if (zza2 != 0) {
                        zzj().zzc().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza2)));
                    }
                    String g_ = zzf().g_();
                    if (!TextUtils.isEmpty(g_)) {
                        if (this.zzab == -1) {
                            this.zzab = zzf().c_();
                        }
                        zza(g_, currentTimeMillis);
                    } else {
                        this.zzab = -1L;
                        zzar zzf = zzf();
                        zze();
                        String zzb3 = zzf.zzb(currentTimeMillis - zzai.zzg());
                        if (!TextUtils.isEmpty(zzb3) && (zzd = zzf().zzd(zzb3)) != null) {
                            zzb(zzd);
                        }
                    }
                }
            }
        } finally {
            this.zzw = false;
            zzac();
        }
    }

    private final void zza(String str, long j) {
        boolean z;
        String str2;
        zzov zzovVar;
        Uri parse;
        List<Pair<zzgf.zzk, Long>> list;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        zzgf.zzo zzb2;
        String str3;
        List<Pair<zzgf.zzk, Long>> zza2 = zzf().zza(str, zze().zzb(str, zzbn.zzg), Math.max(0, zze().zzb(str, zzbn.zzh)));
        if (zza2.isEmpty()) {
            return;
        }
        if (zzb(str).zzg()) {
            Iterator<Pair<zzgf.zzk, Long>> it = zza2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str3 = null;
                    break;
                }
                zzgf.zzk zzkVar = (zzgf.zzk) it.next().first;
                if (!zzkVar.zzap().isEmpty()) {
                    str3 = zzkVar.zzap();
                    break;
                }
            }
            if (str3 != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= zza2.size()) {
                        break;
                    }
                    zzgf.zzk zzkVar2 = (zzgf.zzk) zza2.get(i2).first;
                    if (!zzkVar2.zzap().isEmpty() && !zzkVar2.zzap().equals(str3)) {
                        zza2 = zza2.subList(0, i2);
                        break;
                    }
                    i2++;
                }
            }
        }
        zzgf.zzj.zzb zzb3 = zzgf.zzj.zzb();
        int size = zza2.size();
        List<Long> arrayList = new ArrayList<>(zza2.size());
        boolean z5 = zze().zzj(str) && zzb(str).zzg();
        boolean zzg = zzb(str).zzg();
        boolean zzh = zzb(str).zzh();
        boolean z6 = com.google.android.gms.internal.measurement.zzpf.zza() && zze().zze(str, zzbn.zzcg);
        zzov zza3 = this.zzk.zza(str);
        int i3 = 0;
        while (i3 < size) {
            zzgf.zzk.zza zzch = ((zzgf.zzk) zza2.get(i3).first).zzch();
            arrayList.add((Long) zza2.get(i3).second);
            zze();
            int i4 = i3;
            zzch.zzm(114010L).zzl(j).zzd(false);
            if (!z5) {
                zzch.zzk();
            }
            if (!zzg) {
                zzch.zzq();
                zzch.zzn();
            }
            if (!zzh) {
                zzch.zzh();
            }
            zza(str, zzch);
            if (!z6) {
                zzch.zzr();
            }
            if (!zzh) {
                zzch.zzi();
            }
            String zzaa = zzch.zzaa();
            if (TextUtils.isEmpty(zzaa) || zzaa.equals("00000000-0000-0000-0000-000000000000")) {
                ArrayList arrayList2 = new ArrayList(zzch.zzab());
                Iterator it2 = arrayList2.iterator();
                list = zza2;
                i = size;
                Long l = null;
                Long l2 = null;
                boolean z7 = false;
                boolean z8 = false;
                while (it2.hasNext()) {
                    boolean z9 = z5;
                    zzgf.zzf zzfVar = (zzgf.zzf) it2.next();
                    boolean z10 = zzg;
                    boolean z11 = zzh;
                    if ("_fx".equals(zzfVar.zzg())) {
                        it2.remove();
                        zzg = z10;
                        z5 = z9;
                        zzh = z11;
                        z7 = true;
                        z8 = true;
                    } else {
                        if ("_f".equals(zzfVar.zzg())) {
                            zzp();
                            zzgf.zzh zza4 = zzpj.zza(zzfVar, "_pfo");
                            if (zza4 != null) {
                                l = Long.valueOf(zza4.zzd());
                            }
                            zzp();
                            zzgf.zzh zza5 = zzpj.zza(zzfVar, "_uwa");
                            if (zza5 != null) {
                                l2 = Long.valueOf(zza5.zzd());
                            }
                            z8 = true;
                        }
                        zzg = z10;
                        z5 = z9;
                        zzh = z11;
                    }
                }
                z2 = z5;
                z3 = zzg;
                z4 = zzh;
                if (z7) {
                    zzch.zzl();
                    zzch.zzb(arrayList2);
                }
                if (z8) {
                    zza(zzch.zzu(), true, l, l2);
                }
            } else {
                list = zza2;
                i = size;
                z2 = z5;
                z3 = zzg;
                z4 = zzh;
            }
            if (zzch.zzc() != 0) {
                if (zze().zze(str, zzbn.zzbw)) {
                    zzch.zzb(zzp().zza(((zzgf.zzk) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj())).zzce()));
                }
                if (zze().zza(zzbn.zzcj) && (zzb2 = zza3.zzb()) != null) {
                    zzch.zza(zzb2);
                }
                zzb3.zza(zzch);
            }
            i3 = i4 + 1;
            zza2 = list;
            size = i;
            zzg = z3;
            z5 = z2;
            zzh = z4;
        }
        if (zzb3.zza() == 0) {
            zza(arrayList);
            zza(false, 204, (Throwable) null, (byte[]) null, str, Collections.emptyList());
            return;
        }
        zzgf.zzj zzjVar = (zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzb3.zzaj());
        List<Pair<zzgf.zzj, zzov>> arrayList3 = new ArrayList<>();
        boolean z12 = zze().zza(zzbn.zzcj) && zza3.zza() == zzlu.SGTM_CLIENT;
        if (zza3.zza() == zzlu.SGTM || z12) {
            Iterator<zzgf.zzk> it3 = ((zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzb3.zzaj())).zzf().iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (it3.next().zzbk()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            String uuid = z ? UUID.randomUUID().toString() : null;
            zzgf.zzj zzjVar2 = (zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzb3.zzaj());
            zzl().zzv();
            zzt();
            zzgf.zzj.zzb zza6 = zzgf.zzj.zza(zzjVar2);
            if (!TextUtils.isEmpty(uuid)) {
                zza6.zza(uuid);
            }
            String zzf = zzi().zzf(str);
            if (!TextUtils.isEmpty(zzf)) {
                zza6.zzb(zzf);
            }
            ArrayList arrayList4 = new ArrayList();
            for (zzgf.zzk zzkVar3 : zzjVar2.zzf()) {
                zzgf.zzk.zza zza7 = zzgf.zzk.zza(zzkVar3);
                zza7.zzk();
                arrayList4.add((zzgf.zzk) ((com.google.android.gms.internal.measurement.zzkg) zza7.zzaj()));
            }
            zza6.zzb();
            zza6.zza(arrayList4);
            if (zze().zza(zzbn.zzci)) {
                zzj().zzq().zza("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", TextUtils.isEmpty(uuid) ? "null" : zza6.zzc());
            } else {
                zzj().zzq().zza("[sgtm] Processed MeasurementBatch for sGTM.");
            }
            zzgf.zzj zzjVar3 = (zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zza6.zzaj());
            if (TextUtils.isEmpty(uuid) || !zze().zza(zzbn.zzci)) {
                str2 = null;
            } else {
                zzl().zzv();
                zzt();
                zzgf.zzj.zzb zzb4 = zzgf.zzj.zzb();
                zzj().zzq().zza("Processing Google Signal, sgtmJoinId:", uuid);
                zzb4.zza(uuid);
                for (zzgf.zzk zzkVar4 : ((zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzb3.zzaj())).zzf()) {
                    zzb4.zza(zzgf.zzk.zzx().zzj(zzkVar4.zzaj()).zzg(zzkVar4.zzd()));
                }
                zzgf.zzj zzjVar4 = (zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzb4.zzaj());
                String zzf2 = this.zzk.zzm().zzf(str);
                if (!TextUtils.isEmpty(zzf2)) {
                    Uri.Builder buildUpon = Uri.parse(zzbn.zzr.zza(null)).buildUpon();
                    buildUpon.authority(zzf2 + "." + parse.getAuthority());
                    zzovVar = new zzov(buildUpon.build().toString(), z12 ? zzlu.GOOGLE_SIGNAL_PENDING : zzlu.GOOGLE_SIGNAL);
                    str2 = null;
                } else {
                    str2 = null;
                    zzovVar = new zzov(zzbn.zzr.zza(null), z12 ? zzlu.GOOGLE_SIGNAL_PENDING : zzlu.GOOGLE_SIGNAL);
                }
                arrayList3.add(Pair.create(zzjVar4, zzovVar));
            }
            if (z12) {
                zzgf.zzj.zzb zzch2 = zzjVar3.zzch();
                for (int i5 = 0; i5 < zzjVar3.zza(); i5++) {
                    zzch2.zza(i5, zzjVar3.zza(i5).zzch().zzt().zza(j));
                }
                arrayList3.add(Pair.create((zzgf.zzj) ((com.google.android.gms.internal.measurement.zzkg) zzch2.zzaj()), zza3));
                zza(arrayList);
                zza(false, 204, (Throwable) null, (byte[]) null, str, arrayList3);
                if (zzf(zza3.zzc())) {
                    zzj().zzq().zza("[sgtm] Sending sgtm batches available notification to app", str);
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                    intent.setPackage(str);
                    this.zzm.zza().sendBroadcast(intent);
                    return;
                }
                return;
            }
            zzjVar = zzjVar3;
        } else {
            str2 = null;
        }
        Object zza8 = zzj().zza(2) ? zzp().zza(zzjVar) : str2;
        zzp();
        byte[] zzce = zzjVar.zzce();
        zza(arrayList);
        this.zzj.zze.zza(j);
        zzj().zzq().zza("Uploading data. app, uncompressed size, data", str, Integer.valueOf(zzce.length), zza8);
        this.zzv = true;
        zzh().zza(str, zza3, zzjVar, new zzoz(this, str, arrayList3));
    }

    private final void zze(String str) {
        zzl().zzv();
        zzt();
        this.zzw = true;
        try {
            Boolean zzad = this.zzm.zzt().zzad();
            if (zzad == null) {
                zzj().zzr().zza("Upload data called on the client side before use of service was decided");
            } else if (zzad.booleanValue()) {
                zzj().zzg().zza("Upload called in the client side when service should be used");
            } else if (this.zzp > 0) {
                zzaf();
            } else if (!zzh().zzr()) {
                zzj().zzq().zza("Network not connected, ignoring upload request");
                zzaf();
            } else if (!zzf().zzq(str)) {
                zzj().zzq().zza("Upload queue has no batches for appId", str);
            } else {
                zzpi zzi = zzf().zzi(str);
                if (zzi == null) {
                    return;
                }
                zzgf.zzj zzd = zzi.zzd();
                if (zzd == null) {
                    return;
                }
                byte[] zzce = zzd.zzce();
                if (zzj().zza(2)) {
                    zzj().zzq().zza("Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(zzce.length), zzp().zza(zzd));
                }
                this.zzv = true;
                zzh().zza(str, zzi.zzc(), zzd, new zzoy(this, str, zzi));
            }
        } finally {
            this.zzw = false;
            zzac();
        }
    }

    private final void zza(String str, zzgf.zzh.zza zzaVar, Bundle bundle, String str2) {
        int zzb2;
        List listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        if (zzpn.zzf(zzaVar.zzf()) || zzpn.zzf(str)) {
            zzb2 = zze().zzb(str2, true);
        } else {
            zzb2 = zze().zza(str2, true);
        }
        long j = zzb2;
        long codePointCount = zzaVar.zzg().codePointCount(0, zzaVar.zzg().length());
        zzq();
        String zzf = zzaVar.zzf();
        zze();
        String zza2 = zzpn.zza(zzf, 40, true);
        if (codePointCount <= j || listOf.contains(zzaVar.zzf())) {
            return;
        }
        if ("_ev".equals(zzaVar.zzf())) {
            zzq();
            bundle.putString("_ev", zzpn.zza(zzaVar.zzg(), zze().zzb(str2, true), true));
            return;
        }
        zzj().zzw().zza("Param value is too long; discarded. Name, value length", zza2, Long.valueOf(codePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", zza2);
                bundle.putLong("_el", codePointCount);
            }
        }
        bundle.remove(zzaVar.zzf());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:79|(5:84|85|(1:87)|88|(0))|324|325|326|327|328|329|330|85|(0)|88|(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(56:(2:102|(5:104|(1:106)|107|108|109))(1:323)|(2:111|(5:113|(1:115)|116|117|118))|119|120|(1:122)|123|(1:129)|130|(2:140|141)|144|(1:146)|147|(2:149|(1:155)(3:152|153|154))(1:322)|156|(1:158)|159|(1:161)|162|(1:164)|165|(1:167)|168|(1:170)|171|(1:173)|174|(1:178)|179|(2:183|(32:185|(1:189)|190|(1:192)(1:320)|193|(15:195|(1:197)(1:223)|198|(1:200)(1:222)|201|(1:203)(1:221)|204|(1:206)(1:220)|207|(1:209)(1:219)|210|(1:212)(1:218)|213|(1:215)(1:217)|216)|224|(1:226)|227|(1:229)|230|(4:240|(1:242)|243|(5:251|(1:253)|254|(1:256)|257))|258|(2:260|(1:262))|263|(3:265|(1:267)|268)(1:319)|269|(1:273)|274|(1:276)|277|(4:280|(2:286|287)|288|278)|292|293|294|(2:296|(2:297|(2:299|(1:301))(3:309|310|(1:314))))|315|303|(1:305)|306|307|308))|321|224|(0)|227|(0)|230|(8:232|234|236|238|240|(0)|243|(8:245|247|249|251|(0)|254|(0)|257))|258|(0)|263|(0)(0)|269|(2:271|273)|274|(0)|277|(1:278)|292|293|294|(0)|315|303|(0)|306|307|308) */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x098d, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x09d9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x09da, code lost:
        zzj().zzg().zza("Data loss. Failed to insert raw event metadata. appId", com.google.android.gms.measurement.internal.zzgo.zza(r4.zzu()), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02ad, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02af, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02b0, code lost:
        r27 = "_fx";
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02b4, code lost:
        r11.zzj().zzg().zza("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzgo.zza(r8), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0320 A[Catch: all -> 0x0a21, TRY_LEAVE, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0387 A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x072d A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0741 A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0787 A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x07cb A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x07de A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x083a A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0853 A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x08b7  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x08df A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x08fd A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0975 A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x09d4 A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0197 A[Catch: all -> 0x0a21, TRY_ENTER, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02e7 A[Catch: all -> 0x0a21, TryCatch #1 {all -> 0x0a21, blocks: (B:40:0x015e, B:43:0x016d, B:45:0x0177, B:50:0x0183, B:58:0x0197, B:60:0x01a1, B:62:0x01b8, B:68:0x01d4, B:73:0x020c, B:75:0x0212, B:77:0x0220, B:79:0x0239, B:82:0x0240, B:95:0x02dd, B:97:0x02e7, B:101:0x0320, B:105:0x0337, B:107:0x0387, B:109:0x038d, B:110:0x03a4, B:114:0x03b5, B:116:0x03cd, B:118:0x03d5, B:119:0x03ec, B:124:0x040e, B:128:0x0434, B:129:0x044b, B:132:0x045a, B:135:0x0479, B:136:0x0493, B:138:0x049d, B:140:0x04ab, B:142:0x04b1, B:143:0x04ba, B:145:0x04c6, B:147:0x04d0, B:149:0x04da, B:151:0x04e0, B:153:0x04e4, B:154:0x04f0, B:156:0x04fc, B:157:0x0511, B:159:0x0534, B:162:0x054b, B:165:0x058a, B:167:0x05b4, B:169:0x05f2, B:170:0x05f7, B:172:0x05ff, B:173:0x0604, B:175:0x060c, B:176:0x0611, B:178:0x0619, B:179:0x061e, B:181:0x0627, B:182:0x062d, B:184:0x063a, B:185:0x063f, B:187:0x0666, B:189:0x066e, B:190:0x0673, B:192:0x0679, B:194:0x0687, B:196:0x0692, B:200:0x06a7, B:205:0x06b6, B:207:0x06bd, B:211:0x06ca, B:215:0x06d7, B:219:0x06e4, B:223:0x06f1, B:227:0x06fe, B:231:0x0709, B:235:0x0716, B:237:0x0727, B:239:0x072d, B:240:0x0732, B:242:0x0741, B:243:0x0744, B:245:0x0760, B:247:0x0764, B:249:0x076e, B:251:0x0778, B:253:0x077c, B:255:0x0787, B:256:0x0792, B:258:0x079c, B:260:0x07a8, B:262:0x07b4, B:264:0x07ba, B:266:0x07cb, B:267:0x07d8, B:269:0x07de, B:270:0x07e7, B:271:0x07f3, B:273:0x083a, B:275:0x0844, B:276:0x0847, B:278:0x0853, B:280:0x0873, B:281:0x0880, B:283:0x08b8, B:285:0x08be, B:287:0x08c8, B:288:0x08d5, B:290:0x08df, B:291:0x08ec, B:292:0x08f7, B:294:0x08fd, B:296:0x093b, B:298:0x0945, B:300:0x0957, B:302:0x095d, B:303:0x096d, B:305:0x0975, B:306:0x097b, B:308:0x0981, B:317:0x09ce, B:319:0x09d4, B:322:0x09f0, B:311:0x098f, B:313:0x09bb, B:321:0x09da, B:166:0x05a6, B:83:0x0271, B:84:0x028f, B:86:0x029b, B:94:0x02c5, B:93:0x02b4, B:71:0x01e2, B:72:0x0202), top: B:331:0x015e, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzc(com.google.android.gms.measurement.internal.zzbl r40, com.google.android.gms.measurement.internal.zzp r41) {
        /*
            Method dump skipped, instructions count: 2603
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzou.zzc(com.google.android.gms.measurement.internal.zzbl, com.google.android.gms.measurement.internal.zzp):void");
    }

    private static boolean zzi(zzp zzpVar) {
        return (TextUtils.isEmpty(zzpVar.zzb) && TextUtils.isEmpty(zzpVar.zzp)) ? false : true;
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x1262: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:628:0x1261 */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0268 A[Catch: all -> 0x1269, TRY_ENTER, TryCatch #4 {all -> 0x1269, blocks: (B:3:0x000f, B:18:0x0077, B:111:0x026b, B:113:0x026f, B:119:0x027d, B:120:0x0294, B:123:0x02ae, B:126:0x02d8, B:128:0x030d, B:134:0x0323, B:136:0x032d, B:336:0x0924, B:138:0x035b, B:140:0x0361, B:142:0x036d, B:145:0x037b, B:147:0x0381, B:153:0x038f, B:155:0x039b, B:157:0x03a7, B:159:0x03ad, B:164:0x03ba, B:166:0x03bf, B:165:0x03bd, B:168:0x03d2, B:170:0x03e0, B:173:0x03fc, B:175:0x0402, B:177:0x0412, B:179:0x0420, B:181:0x0430, B:182:0x043d, B:183:0x0440, B:185:0x0454, B:201:0x048e, B:204:0x0498, B:206:0x04a6, B:210:0x04f7, B:207:0x04c8, B:209:0x04d8, B:214:0x0504, B:216:0x0532, B:217:0x055e, B:219:0x0593, B:221:0x0599, B:243:0x066a, B:244:0x0676, B:246:0x067c, B:252:0x06a3, B:249:0x0690, B:255:0x06a9, B:257:0x06b5, B:259:0x06c1, B:275:0x0710, B:278:0x072d, B:280:0x0737, B:283:0x074a, B:285:0x075d, B:287:0x076b, B:303:0x07da, B:305:0x07e0, B:306:0x07ec, B:308:0x07f2, B:310:0x0802, B:312:0x080c, B:313:0x081f, B:315:0x0825, B:316:0x0840, B:318:0x0846, B:319:0x0868, B:320:0x0873, B:324:0x089d, B:321:0x0879, B:323:0x0887, B:325:0x08a9, B:326:0x08c3, B:328:0x08c9, B:330:0x08dd, B:331:0x08ec, B:333:0x08f6, B:335:0x0908, B:291:0x0780, B:293:0x078e, B:296:0x07a3, B:298:0x07b6, B:300:0x07c4, B:263:0x06e2, B:267:0x06f6, B:269:0x06fc, B:272:0x0707, B:224:0x05a5, B:226:0x05dc, B:227:0x05f7, B:229:0x05fd, B:231:0x060b, B:235:0x0622, B:232:0x0617, B:238:0x0629, B:240:0x0630, B:241:0x064f, B:188:0x046a, B:339:0x0938, B:341:0x0946, B:343:0x094f, B:354:0x097f, B:344:0x0957, B:346:0x0960, B:348:0x0966, B:351:0x0972, B:353:0x097a, B:355:0x0982, B:356:0x098e, B:358:0x0994, B:364:0x09ad, B:365:0x09b8, B:370:0x09c5, B:374:0x09ea, B:376:0x0a04, B:378:0x0a19, B:380:0x0a33, B:382:0x0a48, B:383:0x0a57, B:385:0x0a5d, B:387:0x0a6d, B:388:0x0a74, B:390:0x0a80, B:391:0x0a87, B:392:0x0a8a, B:394:0x0ac6, B:396:0x0acc, B:402:0x0af3, B:404:0x0af9, B:405:0x0b02, B:407:0x0b08, B:408:0x0b0e, B:410:0x0b14, B:412:0x0b26, B:414:0x0b35, B:416:0x0b45, B:419:0x0b4e, B:421:0x0b54, B:422:0x0b69, B:424:0x0b6f, B:429:0x0b84, B:431:0x0b9c, B:433:0x0bae, B:435:0x0bd5, B:436:0x0bf2, B:438:0x0c04, B:440:0x0c27, B:442:0x0c52, B:444:0x0c82, B:445:0x0c8f, B:447:0x0ca1, B:449:0x0cc4, B:451:0x0cef, B:453:0x0d1f, B:454:0x0d2a, B:455:0x0d35, B:456:0x0d39, B:460:0x0d66, B:462:0x0d7d, B:463:0x0d90, B:465:0x0d96, B:468:0x0db1, B:470:0x0dcc, B:472:0x0de2, B:474:0x0de7, B:476:0x0deb, B:478:0x0def, B:480:0x0dfb, B:481:0x0e03, B:483:0x0e07, B:485:0x0e0f, B:486:0x0e1d, B:487:0x0e28, B:561:0x1079, B:489:0x0e34, B:493:0x0e66, B:494:0x0e6e, B:496:0x0e74, B:498:0x0e86, B:500:0x0e8a, B:514:0x0ec0, B:517:0x0ed6, B:518:0x0efb, B:520:0x0f07, B:522:0x0f1d, B:524:0x0f5c, B:528:0x0f74, B:530:0x0f7b, B:532:0x0f8c, B:534:0x0f90, B:536:0x0f94, B:538:0x0f98, B:539:0x0fa4, B:540:0x0fa9, B:542:0x0faf, B:544:0x0fce, B:545:0x0fd7, B:560:0x1076, B:546:0x0fef, B:548:0x0ff6, B:552:0x1016, B:554:0x1040, B:555:0x104e, B:556:0x105e, B:558:0x1066, B:549:0x1001, B:502:0x0e98, B:504:0x0e9c, B:506:0x0ea6, B:508:0x0eaa, B:562:0x1086, B:564:0x1092, B:565:0x1099, B:566:0x10a1, B:568:0x10a7, B:571:0x10bf, B:573:0x10cf, B:593:0x1150, B:595:0x1156, B:597:0x1166, B:600:0x116d, B:605:0x119e, B:601:0x1175, B:603:0x1181, B:604:0x1187, B:606:0x11af, B:607:0x11c6, B:610:0x11ce, B:611:0x11d3, B:612:0x11e3, B:614:0x11fd, B:615:0x1216, B:616:0x121e, B:621:0x1240, B:620:0x122f, B:574:0x10e7, B:576:0x10ed, B:578:0x10f7, B:580:0x10fe, B:586:0x110e, B:588:0x1115, B:590:0x1141, B:592:0x1148, B:591:0x1145, B:587:0x1112, B:579:0x10fb, B:397:0x0ada, B:399:0x0ae0, B:401:0x0ae6, B:381:0x0a45, B:377:0x0a16, B:371:0x09ca, B:373:0x09d0, B:624:0x1250, B:50:0x011d, B:69:0x01ba, B:78:0x01f4, B:86:0x0214, B:630:0x1265, B:631:0x1268, B:110:0x0268, B:96:0x0238, B:42:0x00d2, B:53:0x0125), top: B:639:0x000f, inners: #11, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x026f A[Catch: all -> 0x1269, TryCatch #4 {all -> 0x1269, blocks: (B:3:0x000f, B:18:0x0077, B:111:0x026b, B:113:0x026f, B:119:0x027d, B:120:0x0294, B:123:0x02ae, B:126:0x02d8, B:128:0x030d, B:134:0x0323, B:136:0x032d, B:336:0x0924, B:138:0x035b, B:140:0x0361, B:142:0x036d, B:145:0x037b, B:147:0x0381, B:153:0x038f, B:155:0x039b, B:157:0x03a7, B:159:0x03ad, B:164:0x03ba, B:166:0x03bf, B:165:0x03bd, B:168:0x03d2, B:170:0x03e0, B:173:0x03fc, B:175:0x0402, B:177:0x0412, B:179:0x0420, B:181:0x0430, B:182:0x043d, B:183:0x0440, B:185:0x0454, B:201:0x048e, B:204:0x0498, B:206:0x04a6, B:210:0x04f7, B:207:0x04c8, B:209:0x04d8, B:214:0x0504, B:216:0x0532, B:217:0x055e, B:219:0x0593, B:221:0x0599, B:243:0x066a, B:244:0x0676, B:246:0x067c, B:252:0x06a3, B:249:0x0690, B:255:0x06a9, B:257:0x06b5, B:259:0x06c1, B:275:0x0710, B:278:0x072d, B:280:0x0737, B:283:0x074a, B:285:0x075d, B:287:0x076b, B:303:0x07da, B:305:0x07e0, B:306:0x07ec, B:308:0x07f2, B:310:0x0802, B:312:0x080c, B:313:0x081f, B:315:0x0825, B:316:0x0840, B:318:0x0846, B:319:0x0868, B:320:0x0873, B:324:0x089d, B:321:0x0879, B:323:0x0887, B:325:0x08a9, B:326:0x08c3, B:328:0x08c9, B:330:0x08dd, B:331:0x08ec, B:333:0x08f6, B:335:0x0908, B:291:0x0780, B:293:0x078e, B:296:0x07a3, B:298:0x07b6, B:300:0x07c4, B:263:0x06e2, B:267:0x06f6, B:269:0x06fc, B:272:0x0707, B:224:0x05a5, B:226:0x05dc, B:227:0x05f7, B:229:0x05fd, B:231:0x060b, B:235:0x0622, B:232:0x0617, B:238:0x0629, B:240:0x0630, B:241:0x064f, B:188:0x046a, B:339:0x0938, B:341:0x0946, B:343:0x094f, B:354:0x097f, B:344:0x0957, B:346:0x0960, B:348:0x0966, B:351:0x0972, B:353:0x097a, B:355:0x0982, B:356:0x098e, B:358:0x0994, B:364:0x09ad, B:365:0x09b8, B:370:0x09c5, B:374:0x09ea, B:376:0x0a04, B:378:0x0a19, B:380:0x0a33, B:382:0x0a48, B:383:0x0a57, B:385:0x0a5d, B:387:0x0a6d, B:388:0x0a74, B:390:0x0a80, B:391:0x0a87, B:392:0x0a8a, B:394:0x0ac6, B:396:0x0acc, B:402:0x0af3, B:404:0x0af9, B:405:0x0b02, B:407:0x0b08, B:408:0x0b0e, B:410:0x0b14, B:412:0x0b26, B:414:0x0b35, B:416:0x0b45, B:419:0x0b4e, B:421:0x0b54, B:422:0x0b69, B:424:0x0b6f, B:429:0x0b84, B:431:0x0b9c, B:433:0x0bae, B:435:0x0bd5, B:436:0x0bf2, B:438:0x0c04, B:440:0x0c27, B:442:0x0c52, B:444:0x0c82, B:445:0x0c8f, B:447:0x0ca1, B:449:0x0cc4, B:451:0x0cef, B:453:0x0d1f, B:454:0x0d2a, B:455:0x0d35, B:456:0x0d39, B:460:0x0d66, B:462:0x0d7d, B:463:0x0d90, B:465:0x0d96, B:468:0x0db1, B:470:0x0dcc, B:472:0x0de2, B:474:0x0de7, B:476:0x0deb, B:478:0x0def, B:480:0x0dfb, B:481:0x0e03, B:483:0x0e07, B:485:0x0e0f, B:486:0x0e1d, B:487:0x0e28, B:561:0x1079, B:489:0x0e34, B:493:0x0e66, B:494:0x0e6e, B:496:0x0e74, B:498:0x0e86, B:500:0x0e8a, B:514:0x0ec0, B:517:0x0ed6, B:518:0x0efb, B:520:0x0f07, B:522:0x0f1d, B:524:0x0f5c, B:528:0x0f74, B:530:0x0f7b, B:532:0x0f8c, B:534:0x0f90, B:536:0x0f94, B:538:0x0f98, B:539:0x0fa4, B:540:0x0fa9, B:542:0x0faf, B:544:0x0fce, B:545:0x0fd7, B:560:0x1076, B:546:0x0fef, B:548:0x0ff6, B:552:0x1016, B:554:0x1040, B:555:0x104e, B:556:0x105e, B:558:0x1066, B:549:0x1001, B:502:0x0e98, B:504:0x0e9c, B:506:0x0ea6, B:508:0x0eaa, B:562:0x1086, B:564:0x1092, B:565:0x1099, B:566:0x10a1, B:568:0x10a7, B:571:0x10bf, B:573:0x10cf, B:593:0x1150, B:595:0x1156, B:597:0x1166, B:600:0x116d, B:605:0x119e, B:601:0x1175, B:603:0x1181, B:604:0x1187, B:606:0x11af, B:607:0x11c6, B:610:0x11ce, B:611:0x11d3, B:612:0x11e3, B:614:0x11fd, B:615:0x1216, B:616:0x121e, B:621:0x1240, B:620:0x122f, B:574:0x10e7, B:576:0x10ed, B:578:0x10f7, B:580:0x10fe, B:586:0x110e, B:588:0x1115, B:590:0x1141, B:592:0x1148, B:591:0x1145, B:587:0x1112, B:579:0x10fb, B:397:0x0ada, B:399:0x0ae0, B:401:0x0ae6, B:381:0x0a45, B:377:0x0a16, B:371:0x09ca, B:373:0x09d0, B:624:0x1250, B:50:0x011d, B:69:0x01ba, B:78:0x01f4, B:86:0x0214, B:630:0x1265, B:631:0x1268, B:110:0x0268, B:96:0x0238, B:42:0x00d2, B:53:0x0125), top: B:639:0x000f, inners: #11, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x027d A[Catch: all -> 0x1269, TryCatch #4 {all -> 0x1269, blocks: (B:3:0x000f, B:18:0x0077, B:111:0x026b, B:113:0x026f, B:119:0x027d, B:120:0x0294, B:123:0x02ae, B:126:0x02d8, B:128:0x030d, B:134:0x0323, B:136:0x032d, B:336:0x0924, B:138:0x035b, B:140:0x0361, B:142:0x036d, B:145:0x037b, B:147:0x0381, B:153:0x038f, B:155:0x039b, B:157:0x03a7, B:159:0x03ad, B:164:0x03ba, B:166:0x03bf, B:165:0x03bd, B:168:0x03d2, B:170:0x03e0, B:173:0x03fc, B:175:0x0402, B:177:0x0412, B:179:0x0420, B:181:0x0430, B:182:0x043d, B:183:0x0440, B:185:0x0454, B:201:0x048e, B:204:0x0498, B:206:0x04a6, B:210:0x04f7, B:207:0x04c8, B:209:0x04d8, B:214:0x0504, B:216:0x0532, B:217:0x055e, B:219:0x0593, B:221:0x0599, B:243:0x066a, B:244:0x0676, B:246:0x067c, B:252:0x06a3, B:249:0x0690, B:255:0x06a9, B:257:0x06b5, B:259:0x06c1, B:275:0x0710, B:278:0x072d, B:280:0x0737, B:283:0x074a, B:285:0x075d, B:287:0x076b, B:303:0x07da, B:305:0x07e0, B:306:0x07ec, B:308:0x07f2, B:310:0x0802, B:312:0x080c, B:313:0x081f, B:315:0x0825, B:316:0x0840, B:318:0x0846, B:319:0x0868, B:320:0x0873, B:324:0x089d, B:321:0x0879, B:323:0x0887, B:325:0x08a9, B:326:0x08c3, B:328:0x08c9, B:330:0x08dd, B:331:0x08ec, B:333:0x08f6, B:335:0x0908, B:291:0x0780, B:293:0x078e, B:296:0x07a3, B:298:0x07b6, B:300:0x07c4, B:263:0x06e2, B:267:0x06f6, B:269:0x06fc, B:272:0x0707, B:224:0x05a5, B:226:0x05dc, B:227:0x05f7, B:229:0x05fd, B:231:0x060b, B:235:0x0622, B:232:0x0617, B:238:0x0629, B:240:0x0630, B:241:0x064f, B:188:0x046a, B:339:0x0938, B:341:0x0946, B:343:0x094f, B:354:0x097f, B:344:0x0957, B:346:0x0960, B:348:0x0966, B:351:0x0972, B:353:0x097a, B:355:0x0982, B:356:0x098e, B:358:0x0994, B:364:0x09ad, B:365:0x09b8, B:370:0x09c5, B:374:0x09ea, B:376:0x0a04, B:378:0x0a19, B:380:0x0a33, B:382:0x0a48, B:383:0x0a57, B:385:0x0a5d, B:387:0x0a6d, B:388:0x0a74, B:390:0x0a80, B:391:0x0a87, B:392:0x0a8a, B:394:0x0ac6, B:396:0x0acc, B:402:0x0af3, B:404:0x0af9, B:405:0x0b02, B:407:0x0b08, B:408:0x0b0e, B:410:0x0b14, B:412:0x0b26, B:414:0x0b35, B:416:0x0b45, B:419:0x0b4e, B:421:0x0b54, B:422:0x0b69, B:424:0x0b6f, B:429:0x0b84, B:431:0x0b9c, B:433:0x0bae, B:435:0x0bd5, B:436:0x0bf2, B:438:0x0c04, B:440:0x0c27, B:442:0x0c52, B:444:0x0c82, B:445:0x0c8f, B:447:0x0ca1, B:449:0x0cc4, B:451:0x0cef, B:453:0x0d1f, B:454:0x0d2a, B:455:0x0d35, B:456:0x0d39, B:460:0x0d66, B:462:0x0d7d, B:463:0x0d90, B:465:0x0d96, B:468:0x0db1, B:470:0x0dcc, B:472:0x0de2, B:474:0x0de7, B:476:0x0deb, B:478:0x0def, B:480:0x0dfb, B:481:0x0e03, B:483:0x0e07, B:485:0x0e0f, B:486:0x0e1d, B:487:0x0e28, B:561:0x1079, B:489:0x0e34, B:493:0x0e66, B:494:0x0e6e, B:496:0x0e74, B:498:0x0e86, B:500:0x0e8a, B:514:0x0ec0, B:517:0x0ed6, B:518:0x0efb, B:520:0x0f07, B:522:0x0f1d, B:524:0x0f5c, B:528:0x0f74, B:530:0x0f7b, B:532:0x0f8c, B:534:0x0f90, B:536:0x0f94, B:538:0x0f98, B:539:0x0fa4, B:540:0x0fa9, B:542:0x0faf, B:544:0x0fce, B:545:0x0fd7, B:560:0x1076, B:546:0x0fef, B:548:0x0ff6, B:552:0x1016, B:554:0x1040, B:555:0x104e, B:556:0x105e, B:558:0x1066, B:549:0x1001, B:502:0x0e98, B:504:0x0e9c, B:506:0x0ea6, B:508:0x0eaa, B:562:0x1086, B:564:0x1092, B:565:0x1099, B:566:0x10a1, B:568:0x10a7, B:571:0x10bf, B:573:0x10cf, B:593:0x1150, B:595:0x1156, B:597:0x1166, B:600:0x116d, B:605:0x119e, B:601:0x1175, B:603:0x1181, B:604:0x1187, B:606:0x11af, B:607:0x11c6, B:610:0x11ce, B:611:0x11d3, B:612:0x11e3, B:614:0x11fd, B:615:0x1216, B:616:0x121e, B:621:0x1240, B:620:0x122f, B:574:0x10e7, B:576:0x10ed, B:578:0x10f7, B:580:0x10fe, B:586:0x110e, B:588:0x1115, B:590:0x1141, B:592:0x1148, B:591:0x1145, B:587:0x1112, B:579:0x10fb, B:397:0x0ada, B:399:0x0ae0, B:401:0x0ae6, B:381:0x0a45, B:377:0x0a16, B:371:0x09ca, B:373:0x09d0, B:624:0x1250, B:50:0x011d, B:69:0x01ba, B:78:0x01f4, B:86:0x0214, B:630:0x1265, B:631:0x1268, B:110:0x0268, B:96:0x0238, B:42:0x00d2, B:53:0x0125), top: B:639:0x000f, inners: #11, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x038f A[Catch: all -> 0x1269, TryCatch #4 {all -> 0x1269, blocks: (B:3:0x000f, B:18:0x0077, B:111:0x026b, B:113:0x026f, B:119:0x027d, B:120:0x0294, B:123:0x02ae, B:126:0x02d8, B:128:0x030d, B:134:0x0323, B:136:0x032d, B:336:0x0924, B:138:0x035b, B:140:0x0361, B:142:0x036d, B:145:0x037b, B:147:0x0381, B:153:0x038f, B:155:0x039b, B:157:0x03a7, B:159:0x03ad, B:164:0x03ba, B:166:0x03bf, B:165:0x03bd, B:168:0x03d2, B:170:0x03e0, B:173:0x03fc, B:175:0x0402, B:177:0x0412, B:179:0x0420, B:181:0x0430, B:182:0x043d, B:183:0x0440, B:185:0x0454, B:201:0x048e, B:204:0x0498, B:206:0x04a6, B:210:0x04f7, B:207:0x04c8, B:209:0x04d8, B:214:0x0504, B:216:0x0532, B:217:0x055e, B:219:0x0593, B:221:0x0599, B:243:0x066a, B:244:0x0676, B:246:0x067c, B:252:0x06a3, B:249:0x0690, B:255:0x06a9, B:257:0x06b5, B:259:0x06c1, B:275:0x0710, B:278:0x072d, B:280:0x0737, B:283:0x074a, B:285:0x075d, B:287:0x076b, B:303:0x07da, B:305:0x07e0, B:306:0x07ec, B:308:0x07f2, B:310:0x0802, B:312:0x080c, B:313:0x081f, B:315:0x0825, B:316:0x0840, B:318:0x0846, B:319:0x0868, B:320:0x0873, B:324:0x089d, B:321:0x0879, B:323:0x0887, B:325:0x08a9, B:326:0x08c3, B:328:0x08c9, B:330:0x08dd, B:331:0x08ec, B:333:0x08f6, B:335:0x0908, B:291:0x0780, B:293:0x078e, B:296:0x07a3, B:298:0x07b6, B:300:0x07c4, B:263:0x06e2, B:267:0x06f6, B:269:0x06fc, B:272:0x0707, B:224:0x05a5, B:226:0x05dc, B:227:0x05f7, B:229:0x05fd, B:231:0x060b, B:235:0x0622, B:232:0x0617, B:238:0x0629, B:240:0x0630, B:241:0x064f, B:188:0x046a, B:339:0x0938, B:341:0x0946, B:343:0x094f, B:354:0x097f, B:344:0x0957, B:346:0x0960, B:348:0x0966, B:351:0x0972, B:353:0x097a, B:355:0x0982, B:356:0x098e, B:358:0x0994, B:364:0x09ad, B:365:0x09b8, B:370:0x09c5, B:374:0x09ea, B:376:0x0a04, B:378:0x0a19, B:380:0x0a33, B:382:0x0a48, B:383:0x0a57, B:385:0x0a5d, B:387:0x0a6d, B:388:0x0a74, B:390:0x0a80, B:391:0x0a87, B:392:0x0a8a, B:394:0x0ac6, B:396:0x0acc, B:402:0x0af3, B:404:0x0af9, B:405:0x0b02, B:407:0x0b08, B:408:0x0b0e, B:410:0x0b14, B:412:0x0b26, B:414:0x0b35, B:416:0x0b45, B:419:0x0b4e, B:421:0x0b54, B:422:0x0b69, B:424:0x0b6f, B:429:0x0b84, B:431:0x0b9c, B:433:0x0bae, B:435:0x0bd5, B:436:0x0bf2, B:438:0x0c04, B:440:0x0c27, B:442:0x0c52, B:444:0x0c82, B:445:0x0c8f, B:447:0x0ca1, B:449:0x0cc4, B:451:0x0cef, B:453:0x0d1f, B:454:0x0d2a, B:455:0x0d35, B:456:0x0d39, B:460:0x0d66, B:462:0x0d7d, B:463:0x0d90, B:465:0x0d96, B:468:0x0db1, B:470:0x0dcc, B:472:0x0de2, B:474:0x0de7, B:476:0x0deb, B:478:0x0def, B:480:0x0dfb, B:481:0x0e03, B:483:0x0e07, B:485:0x0e0f, B:486:0x0e1d, B:487:0x0e28, B:561:0x1079, B:489:0x0e34, B:493:0x0e66, B:494:0x0e6e, B:496:0x0e74, B:498:0x0e86, B:500:0x0e8a, B:514:0x0ec0, B:517:0x0ed6, B:518:0x0efb, B:520:0x0f07, B:522:0x0f1d, B:524:0x0f5c, B:528:0x0f74, B:530:0x0f7b, B:532:0x0f8c, B:534:0x0f90, B:536:0x0f94, B:538:0x0f98, B:539:0x0fa4, B:540:0x0fa9, B:542:0x0faf, B:544:0x0fce, B:545:0x0fd7, B:560:0x1076, B:546:0x0fef, B:548:0x0ff6, B:552:0x1016, B:554:0x1040, B:555:0x104e, B:556:0x105e, B:558:0x1066, B:549:0x1001, B:502:0x0e98, B:504:0x0e9c, B:506:0x0ea6, B:508:0x0eaa, B:562:0x1086, B:564:0x1092, B:565:0x1099, B:566:0x10a1, B:568:0x10a7, B:571:0x10bf, B:573:0x10cf, B:593:0x1150, B:595:0x1156, B:597:0x1166, B:600:0x116d, B:605:0x119e, B:601:0x1175, B:603:0x1181, B:604:0x1187, B:606:0x11af, B:607:0x11c6, B:610:0x11ce, B:611:0x11d3, B:612:0x11e3, B:614:0x11fd, B:615:0x1216, B:616:0x121e, B:621:0x1240, B:620:0x122f, B:574:0x10e7, B:576:0x10ed, B:578:0x10f7, B:580:0x10fe, B:586:0x110e, B:588:0x1115, B:590:0x1141, B:592:0x1148, B:591:0x1145, B:587:0x1112, B:579:0x10fb, B:397:0x0ada, B:399:0x0ae0, B:401:0x0ae6, B:381:0x0a45, B:377:0x0a16, B:371:0x09ca, B:373:0x09d0, B:624:0x1250, B:50:0x011d, B:69:0x01ba, B:78:0x01f4, B:86:0x0214, B:630:0x1265, B:631:0x1268, B:110:0x0268, B:96:0x0238, B:42:0x00d2, B:53:0x0125), top: B:639:0x000f, inners: #11, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x066a A[Catch: all -> 0x1269, TryCatch #4 {all -> 0x1269, blocks: (B:3:0x000f, B:18:0x0077, B:111:0x026b, B:113:0x026f, B:119:0x027d, B:120:0x0294, B:123:0x02ae, B:126:0x02d8, B:128:0x030d, B:134:0x0323, B:136:0x032d, B:336:0x0924, B:138:0x035b, B:140:0x0361, B:142:0x036d, B:145:0x037b, B:147:0x0381, B:153:0x038f, B:155:0x039b, B:157:0x03a7, B:159:0x03ad, B:164:0x03ba, B:166:0x03bf, B:165:0x03bd, B:168:0x03d2, B:170:0x03e0, B:173:0x03fc, B:175:0x0402, B:177:0x0412, B:179:0x0420, B:181:0x0430, B:182:0x043d, B:183:0x0440, B:185:0x0454, B:201:0x048e, B:204:0x0498, B:206:0x04a6, B:210:0x04f7, B:207:0x04c8, B:209:0x04d8, B:214:0x0504, B:216:0x0532, B:217:0x055e, B:219:0x0593, B:221:0x0599, B:243:0x066a, B:244:0x0676, B:246:0x067c, B:252:0x06a3, B:249:0x0690, B:255:0x06a9, B:257:0x06b5, B:259:0x06c1, B:275:0x0710, B:278:0x072d, B:280:0x0737, B:283:0x074a, B:285:0x075d, B:287:0x076b, B:303:0x07da, B:305:0x07e0, B:306:0x07ec, B:308:0x07f2, B:310:0x0802, B:312:0x080c, B:313:0x081f, B:315:0x0825, B:316:0x0840, B:318:0x0846, B:319:0x0868, B:320:0x0873, B:324:0x089d, B:321:0x0879, B:323:0x0887, B:325:0x08a9, B:326:0x08c3, B:328:0x08c9, B:330:0x08dd, B:331:0x08ec, B:333:0x08f6, B:335:0x0908, B:291:0x0780, B:293:0x078e, B:296:0x07a3, B:298:0x07b6, B:300:0x07c4, B:263:0x06e2, B:267:0x06f6, B:269:0x06fc, B:272:0x0707, B:224:0x05a5, B:226:0x05dc, B:227:0x05f7, B:229:0x05fd, B:231:0x060b, B:235:0x0622, B:232:0x0617, B:238:0x0629, B:240:0x0630, B:241:0x064f, B:188:0x046a, B:339:0x0938, B:341:0x0946, B:343:0x094f, B:354:0x097f, B:344:0x0957, B:346:0x0960, B:348:0x0966, B:351:0x0972, B:353:0x097a, B:355:0x0982, B:356:0x098e, B:358:0x0994, B:364:0x09ad, B:365:0x09b8, B:370:0x09c5, B:374:0x09ea, B:376:0x0a04, B:378:0x0a19, B:380:0x0a33, B:382:0x0a48, B:383:0x0a57, B:385:0x0a5d, B:387:0x0a6d, B:388:0x0a74, B:390:0x0a80, B:391:0x0a87, B:392:0x0a8a, B:394:0x0ac6, B:396:0x0acc, B:402:0x0af3, B:404:0x0af9, B:405:0x0b02, B:407:0x0b08, B:408:0x0b0e, B:410:0x0b14, B:412:0x0b26, B:414:0x0b35, B:416:0x0b45, B:419:0x0b4e, B:421:0x0b54, B:422:0x0b69, B:424:0x0b6f, B:429:0x0b84, B:431:0x0b9c, B:433:0x0bae, B:435:0x0bd5, B:436:0x0bf2, B:438:0x0c04, B:440:0x0c27, B:442:0x0c52, B:444:0x0c82, B:445:0x0c8f, B:447:0x0ca1, B:449:0x0cc4, B:451:0x0cef, B:453:0x0d1f, B:454:0x0d2a, B:455:0x0d35, B:456:0x0d39, B:460:0x0d66, B:462:0x0d7d, B:463:0x0d90, B:465:0x0d96, B:468:0x0db1, B:470:0x0dcc, B:472:0x0de2, B:474:0x0de7, B:476:0x0deb, B:478:0x0def, B:480:0x0dfb, B:481:0x0e03, B:483:0x0e07, B:485:0x0e0f, B:486:0x0e1d, B:487:0x0e28, B:561:0x1079, B:489:0x0e34, B:493:0x0e66, B:494:0x0e6e, B:496:0x0e74, B:498:0x0e86, B:500:0x0e8a, B:514:0x0ec0, B:517:0x0ed6, B:518:0x0efb, B:520:0x0f07, B:522:0x0f1d, B:524:0x0f5c, B:528:0x0f74, B:530:0x0f7b, B:532:0x0f8c, B:534:0x0f90, B:536:0x0f94, B:538:0x0f98, B:539:0x0fa4, B:540:0x0fa9, B:542:0x0faf, B:544:0x0fce, B:545:0x0fd7, B:560:0x1076, B:546:0x0fef, B:548:0x0ff6, B:552:0x1016, B:554:0x1040, B:555:0x104e, B:556:0x105e, B:558:0x1066, B:549:0x1001, B:502:0x0e98, B:504:0x0e9c, B:506:0x0ea6, B:508:0x0eaa, B:562:0x1086, B:564:0x1092, B:565:0x1099, B:566:0x10a1, B:568:0x10a7, B:571:0x10bf, B:573:0x10cf, B:593:0x1150, B:595:0x1156, B:597:0x1166, B:600:0x116d, B:605:0x119e, B:601:0x1175, B:603:0x1181, B:604:0x1187, B:606:0x11af, B:607:0x11c6, B:610:0x11ce, B:611:0x11d3, B:612:0x11e3, B:614:0x11fd, B:615:0x1216, B:616:0x121e, B:621:0x1240, B:620:0x122f, B:574:0x10e7, B:576:0x10ed, B:578:0x10f7, B:580:0x10fe, B:586:0x110e, B:588:0x1115, B:590:0x1141, B:592:0x1148, B:591:0x1145, B:587:0x1112, B:579:0x10fb, B:397:0x0ada, B:399:0x0ae0, B:401:0x0ae6, B:381:0x0a45, B:377:0x0a16, B:371:0x09ca, B:373:0x09d0, B:624:0x1250, B:50:0x011d, B:69:0x01ba, B:78:0x01f4, B:86:0x0214, B:630:0x1265, B:631:0x1268, B:110:0x0268, B:96:0x0238, B:42:0x00d2, B:53:0x0125), top: B:639:0x000f, inners: #11, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0737 A[Catch: all -> 0x1269, TryCatch #4 {all -> 0x1269, blocks: (B:3:0x000f, B:18:0x0077, B:111:0x026b, B:113:0x026f, B:119:0x027d, B:120:0x0294, B:123:0x02ae, B:126:0x02d8, B:128:0x030d, B:134:0x0323, B:136:0x032d, B:336:0x0924, B:138:0x035b, B:140:0x0361, B:142:0x036d, B:145:0x037b, B:147:0x0381, B:153:0x038f, B:155:0x039b, B:157:0x03a7, B:159:0x03ad, B:164:0x03ba, B:166:0x03bf, B:165:0x03bd, B:168:0x03d2, B:170:0x03e0, B:173:0x03fc, B:175:0x0402, B:177:0x0412, B:179:0x0420, B:181:0x0430, B:182:0x043d, B:183:0x0440, B:185:0x0454, B:201:0x048e, B:204:0x0498, B:206:0x04a6, B:210:0x04f7, B:207:0x04c8, B:209:0x04d8, B:214:0x0504, B:216:0x0532, B:217:0x055e, B:219:0x0593, B:221:0x0599, B:243:0x066a, B:244:0x0676, B:246:0x067c, B:252:0x06a3, B:249:0x0690, B:255:0x06a9, B:257:0x06b5, B:259:0x06c1, B:275:0x0710, B:278:0x072d, B:280:0x0737, B:283:0x074a, B:285:0x075d, B:287:0x076b, B:303:0x07da, B:305:0x07e0, B:306:0x07ec, B:308:0x07f2, B:310:0x0802, B:312:0x080c, B:313:0x081f, B:315:0x0825, B:316:0x0840, B:318:0x0846, B:319:0x0868, B:320:0x0873, B:324:0x089d, B:321:0x0879, B:323:0x0887, B:325:0x08a9, B:326:0x08c3, B:328:0x08c9, B:330:0x08dd, B:331:0x08ec, B:333:0x08f6, B:335:0x0908, B:291:0x0780, B:293:0x078e, B:296:0x07a3, B:298:0x07b6, B:300:0x07c4, B:263:0x06e2, B:267:0x06f6, B:269:0x06fc, B:272:0x0707, B:224:0x05a5, B:226:0x05dc, B:227:0x05f7, B:229:0x05fd, B:231:0x060b, B:235:0x0622, B:232:0x0617, B:238:0x0629, B:240:0x0630, B:241:0x064f, B:188:0x046a, B:339:0x0938, B:341:0x0946, B:343:0x094f, B:354:0x097f, B:344:0x0957, B:346:0x0960, B:348:0x0966, B:351:0x0972, B:353:0x097a, B:355:0x0982, B:356:0x098e, B:358:0x0994, B:364:0x09ad, B:365:0x09b8, B:370:0x09c5, B:374:0x09ea, B:376:0x0a04, B:378:0x0a19, B:380:0x0a33, B:382:0x0a48, B:383:0x0a57, B:385:0x0a5d, B:387:0x0a6d, B:388:0x0a74, B:390:0x0a80, B:391:0x0a87, B:392:0x0a8a, B:394:0x0ac6, B:396:0x0acc, B:402:0x0af3, B:404:0x0af9, B:405:0x0b02, B:407:0x0b08, B:408:0x0b0e, B:410:0x0b14, B:412:0x0b26, B:414:0x0b35, B:416:0x0b45, B:419:0x0b4e, B:421:0x0b54, B:422:0x0b69, B:424:0x0b6f, B:429:0x0b84, B:431:0x0b9c, B:433:0x0bae, B:435:0x0bd5, B:436:0x0bf2, B:438:0x0c04, B:440:0x0c27, B:442:0x0c52, B:444:0x0c82, B:445:0x0c8f, B:447:0x0ca1, B:449:0x0cc4, B:451:0x0cef, B:453:0x0d1f, B:454:0x0d2a, B:455:0x0d35, B:456:0x0d39, B:460:0x0d66, B:462:0x0d7d, B:463:0x0d90, B:465:0x0d96, B:468:0x0db1, B:470:0x0dcc, B:472:0x0de2, B:474:0x0de7, B:476:0x0deb, B:478:0x0def, B:480:0x0dfb, B:481:0x0e03, B:483:0x0e07, B:485:0x0e0f, B:486:0x0e1d, B:487:0x0e28, B:561:0x1079, B:489:0x0e34, B:493:0x0e66, B:494:0x0e6e, B:496:0x0e74, B:498:0x0e86, B:500:0x0e8a, B:514:0x0ec0, B:517:0x0ed6, B:518:0x0efb, B:520:0x0f07, B:522:0x0f1d, B:524:0x0f5c, B:528:0x0f74, B:530:0x0f7b, B:532:0x0f8c, B:534:0x0f90, B:536:0x0f94, B:538:0x0f98, B:539:0x0fa4, B:540:0x0fa9, B:542:0x0faf, B:544:0x0fce, B:545:0x0fd7, B:560:0x1076, B:546:0x0fef, B:548:0x0ff6, B:552:0x1016, B:554:0x1040, B:555:0x104e, B:556:0x105e, B:558:0x1066, B:549:0x1001, B:502:0x0e98, B:504:0x0e9c, B:506:0x0ea6, B:508:0x0eaa, B:562:0x1086, B:564:0x1092, B:565:0x1099, B:566:0x10a1, B:568:0x10a7, B:571:0x10bf, B:573:0x10cf, B:593:0x1150, B:595:0x1156, B:597:0x1166, B:600:0x116d, B:605:0x119e, B:601:0x1175, B:603:0x1181, B:604:0x1187, B:606:0x11af, B:607:0x11c6, B:610:0x11ce, B:611:0x11d3, B:612:0x11e3, B:614:0x11fd, B:615:0x1216, B:616:0x121e, B:621:0x1240, B:620:0x122f, B:574:0x10e7, B:576:0x10ed, B:578:0x10f7, B:580:0x10fe, B:586:0x110e, B:588:0x1115, B:590:0x1141, B:592:0x1148, B:591:0x1145, B:587:0x1112, B:579:0x10fb, B:397:0x0ada, B:399:0x0ae0, B:401:0x0ae6, B:381:0x0a45, B:377:0x0a16, B:371:0x09ca, B:373:0x09d0, B:624:0x1250, B:50:0x011d, B:69:0x01ba, B:78:0x01f4, B:86:0x0214, B:630:0x1265, B:631:0x1268, B:110:0x0268, B:96:0x0238, B:42:0x00d2, B:53:0x0125), top: B:639:0x000f, inners: #11, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0780 A[Catch: all -> 0x1269, TryCatch #4 {all -> 0x1269, blocks: (B:3:0x000f, B:18:0x0077, B:111:0x026b, B:113:0x026f, B:119:0x027d, B:120:0x0294, B:123:0x02ae, B:126:0x02d8, B:128:0x030d, B:134:0x0323, B:136:0x032d, B:336:0x0924, B:138:0x035b, B:140:0x0361, B:142:0x036d, B:145:0x037b, B:147:0x0381, B:153:0x038f, B:155:0x039b, B:157:0x03a7, B:159:0x03ad, B:164:0x03ba, B:166:0x03bf, B:165:0x03bd, B:168:0x03d2, B:170:0x03e0, B:173:0x03fc, B:175:0x0402, B:177:0x0412, B:179:0x0420, B:181:0x0430, B:182:0x043d, B:183:0x0440, B:185:0x0454, B:201:0x048e, B:204:0x0498, B:206:0x04a6, B:210:0x04f7, B:207:0x04c8, B:209:0x04d8, B:214:0x0504, B:216:0x0532, B:217:0x055e, B:219:0x0593, B:221:0x0599, B:243:0x066a, B:244:0x0676, B:246:0x067c, B:252:0x06a3, B:249:0x0690, B:255:0x06a9, B:257:0x06b5, B:259:0x06c1, B:275:0x0710, B:278:0x072d, B:280:0x0737, B:283:0x074a, B:285:0x075d, B:287:0x076b, B:303:0x07da, B:305:0x07e0, B:306:0x07ec, B:308:0x07f2, B:310:0x0802, B:312:0x080c, B:313:0x081f, B:315:0x0825, B:316:0x0840, B:318:0x0846, B:319:0x0868, B:320:0x0873, B:324:0x089d, B:321:0x0879, B:323:0x0887, B:325:0x08a9, B:326:0x08c3, B:328:0x08c9, B:330:0x08dd, B:331:0x08ec, B:333:0x08f6, B:335:0x0908, B:291:0x0780, B:293:0x078e, B:296:0x07a3, B:298:0x07b6, B:300:0x07c4, B:263:0x06e2, B:267:0x06f6, B:269:0x06fc, B:272:0x0707, B:224:0x05a5, B:226:0x05dc, B:227:0x05f7, B:229:0x05fd, B:231:0x060b, B:235:0x0622, B:232:0x0617, B:238:0x0629, B:240:0x0630, B:241:0x064f, B:188:0x046a, B:339:0x0938, B:341:0x0946, B:343:0x094f, B:354:0x097f, B:344:0x0957, B:346:0x0960, B:348:0x0966, B:351:0x0972, B:353:0x097a, B:355:0x0982, B:356:0x098e, B:358:0x0994, B:364:0x09ad, B:365:0x09b8, B:370:0x09c5, B:374:0x09ea, B:376:0x0a04, B:378:0x0a19, B:380:0x0a33, B:382:0x0a48, B:383:0x0a57, B:385:0x0a5d, B:387:0x0a6d, B:388:0x0a74, B:390:0x0a80, B:391:0x0a87, B:392:0x0a8a, B:394:0x0ac6, B:396:0x0acc, B:402:0x0af3, B:404:0x0af9, B:405:0x0b02, B:407:0x0b08, B:408:0x0b0e, B:410:0x0b14, B:412:0x0b26, B:414:0x0b35, B:416:0x0b45, B:419:0x0b4e, B:421:0x0b54, B:422:0x0b69, B:424:0x0b6f, B:429:0x0b84, B:431:0x0b9c, B:433:0x0bae, B:435:0x0bd5, B:436:0x0bf2, B:438:0x0c04, B:440:0x0c27, B:442:0x0c52, B:444:0x0c82, B:445:0x0c8f, B:447:0x0ca1, B:449:0x0cc4, B:451:0x0cef, B:453:0x0d1f, B:454:0x0d2a, B:455:0x0d35, B:456:0x0d39, B:460:0x0d66, B:462:0x0d7d, B:463:0x0d90, B:465:0x0d96, B:468:0x0db1, B:470:0x0dcc, B:472:0x0de2, B:474:0x0de7, B:476:0x0deb, B:478:0x0def, B:480:0x0dfb, B:481:0x0e03, B:483:0x0e07, B:485:0x0e0f, B:486:0x0e1d, B:487:0x0e28, B:561:0x1079, B:489:0x0e34, B:493:0x0e66, B:494:0x0e6e, B:496:0x0e74, B:498:0x0e86, B:500:0x0e8a, B:514:0x0ec0, B:517:0x0ed6, B:518:0x0efb, B:520:0x0f07, B:522:0x0f1d, B:524:0x0f5c, B:528:0x0f74, B:530:0x0f7b, B:532:0x0f8c, B:534:0x0f90, B:536:0x0f94, B:538:0x0f98, B:539:0x0fa4, B:540:0x0fa9, B:542:0x0faf, B:544:0x0fce, B:545:0x0fd7, B:560:0x1076, B:546:0x0fef, B:548:0x0ff6, B:552:0x1016, B:554:0x1040, B:555:0x104e, B:556:0x105e, B:558:0x1066, B:549:0x1001, B:502:0x0e98, B:504:0x0e9c, B:506:0x0ea6, B:508:0x0eaa, B:562:0x1086, B:564:0x1092, B:565:0x1099, B:566:0x10a1, B:568:0x10a7, B:571:0x10bf, B:573:0x10cf, B:593:0x1150, B:595:0x1156, B:597:0x1166, B:600:0x116d, B:605:0x119e, B:601:0x1175, B:603:0x1181, B:604:0x1187, B:606:0x11af, B:607:0x11c6, B:610:0x11ce, B:611:0x11d3, B:612:0x11e3, B:614:0x11fd, B:615:0x1216, B:616:0x121e, B:621:0x1240, B:620:0x122f, B:574:0x10e7, B:576:0x10ed, B:578:0x10f7, B:580:0x10fe, B:586:0x110e, B:588:0x1115, B:590:0x1141, B:592:0x1148, B:591:0x1145, B:587:0x1112, B:579:0x10fb, B:397:0x0ada, B:399:0x0ae0, B:401:0x0ae6, B:381:0x0a45, B:377:0x0a16, B:371:0x09ca, B:373:0x09d0, B:624:0x1250, B:50:0x011d, B:69:0x01ba, B:78:0x01f4, B:86:0x0214, B:630:0x1265, B:631:0x1268, B:110:0x0268, B:96:0x0238, B:42:0x00d2, B:53:0x0125), top: B:639:0x000f, inners: #11, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x07e0 A[Catch: all -> 0x1269, TryCatch #4 {all -> 0x1269, blocks: (B:3:0x000f, B:18:0x0077, B:111:0x026b, B:113:0x026f, B:119:0x027d, B:120:0x0294, B:123:0x02ae, B:126:0x02d8, B:128:0x030d, B:134:0x0323, B:136:0x032d, B:336:0x0924, B:138:0x035b, B:140:0x0361, B:142:0x036d, B:145:0x037b, B:147:0x0381, B:153:0x038f, B:155:0x039b, B:157:0x03a7, B:159:0x03ad, B:164:0x03ba, B:166:0x03bf, B:165:0x03bd, B:168:0x03d2, B:170:0x03e0, B:173:0x03fc, B:175:0x0402, B:177:0x0412, B:179:0x0420, B:181:0x0430, B:182:0x043d, B:183:0x0440, B:185:0x0454, B:201:0x048e, B:204:0x0498, B:206:0x04a6, B:210:0x04f7, B:207:0x04c8, B:209:0x04d8, B:214:0x0504, B:216:0x0532, B:217:0x055e, B:219:0x0593, B:221:0x0599, B:243:0x066a, B:244:0x0676, B:246:0x067c, B:252:0x06a3, B:249:0x0690, B:255:0x06a9, B:257:0x06b5, B:259:0x06c1, B:275:0x0710, B:278:0x072d, B:280:0x0737, B:283:0x074a, B:285:0x075d, B:287:0x076b, B:303:0x07da, B:305:0x07e0, B:306:0x07ec, B:308:0x07f2, B:310:0x0802, B:312:0x080c, B:313:0x081f, B:315:0x0825, B:316:0x0840, B:318:0x0846, B:319:0x0868, B:320:0x0873, B:324:0x089d, B:321:0x0879, B:323:0x0887, B:325:0x08a9, B:326:0x08c3, B:328:0x08c9, B:330:0x08dd, B:331:0x08ec, B:333:0x08f6, B:335:0x0908, B:291:0x0780, B:293:0x078e, B:296:0x07a3, B:298:0x07b6, B:300:0x07c4, B:263:0x06e2, B:267:0x06f6, B:269:0x06fc, B:272:0x0707, B:224:0x05a5, B:226:0x05dc, B:227:0x05f7, B:229:0x05fd, B:231:0x060b, B:235:0x0622, B:232:0x0617, B:238:0x0629, B:240:0x0630, B:241:0x064f, B:188:0x046a, B:339:0x0938, B:341:0x0946, B:343:0x094f, B:354:0x097f, B:344:0x0957, B:346:0x0960, B:348:0x0966, B:351:0x0972, B:353:0x097a, B:355:0x0982, B:356:0x098e, B:358:0x0994, B:364:0x09ad, B:365:0x09b8, B:370:0x09c5, B:374:0x09ea, B:376:0x0a04, B:378:0x0a19, B:380:0x0a33, B:382:0x0a48, B:383:0x0a57, B:385:0x0a5d, B:387:0x0a6d, B:388:0x0a74, B:390:0x0a80, B:391:0x0a87, B:392:0x0a8a, B:394:0x0ac6, B:396:0x0acc, B:402:0x0af3, B:404:0x0af9, B:405:0x0b02, B:407:0x0b08, B:408:0x0b0e, B:410:0x0b14, B:412:0x0b26, B:414:0x0b35, B:416:0x0b45, B:419:0x0b4e, B:421:0x0b54, B:422:0x0b69, B:424:0x0b6f, B:429:0x0b84, B:431:0x0b9c, B:433:0x0bae, B:435:0x0bd5, B:436:0x0bf2, B:438:0x0c04, B:440:0x0c27, B:442:0x0c52, B:444:0x0c82, B:445:0x0c8f, B:447:0x0ca1, B:449:0x0cc4, B:451:0x0cef, B:453:0x0d1f, B:454:0x0d2a, B:455:0x0d35, B:456:0x0d39, B:460:0x0d66, B:462:0x0d7d, B:463:0x0d90, B:465:0x0d96, B:468:0x0db1, B:470:0x0dcc, B:472:0x0de2, B:474:0x0de7, B:476:0x0deb, B:478:0x0def, B:480:0x0dfb, B:481:0x0e03, B:483:0x0e07, B:485:0x0e0f, B:486:0x0e1d, B:487:0x0e28, B:561:0x1079, B:489:0x0e34, B:493:0x0e66, B:494:0x0e6e, B:496:0x0e74, B:498:0x0e86, B:500:0x0e8a, B:514:0x0ec0, B:517:0x0ed6, B:518:0x0efb, B:520:0x0f07, B:522:0x0f1d, B:524:0x0f5c, B:528:0x0f74, B:530:0x0f7b, B:532:0x0f8c, B:534:0x0f90, B:536:0x0f94, B:538:0x0f98, B:539:0x0fa4, B:540:0x0fa9, B:542:0x0faf, B:544:0x0fce, B:545:0x0fd7, B:560:0x1076, B:546:0x0fef, B:548:0x0ff6, B:552:0x1016, B:554:0x1040, B:555:0x104e, B:556:0x105e, B:558:0x1066, B:549:0x1001, B:502:0x0e98, B:504:0x0e9c, B:506:0x0ea6, B:508:0x0eaa, B:562:0x1086, B:564:0x1092, B:565:0x1099, B:566:0x10a1, B:568:0x10a7, B:571:0x10bf, B:573:0x10cf, B:593:0x1150, B:595:0x1156, B:597:0x1166, B:600:0x116d, B:605:0x119e, B:601:0x1175, B:603:0x1181, B:604:0x1187, B:606:0x11af, B:607:0x11c6, B:610:0x11ce, B:611:0x11d3, B:612:0x11e3, B:614:0x11fd, B:615:0x1216, B:616:0x121e, B:621:0x1240, B:620:0x122f, B:574:0x10e7, B:576:0x10ed, B:578:0x10f7, B:580:0x10fe, B:586:0x110e, B:588:0x1115, B:590:0x1141, B:592:0x1148, B:591:0x1145, B:587:0x1112, B:579:0x10fb, B:397:0x0ada, B:399:0x0ae0, B:401:0x0ae6, B:381:0x0a45, B:377:0x0a16, B:371:0x09ca, B:373:0x09d0, B:624:0x1250, B:50:0x011d, B:69:0x01ba, B:78:0x01f4, B:86:0x0214, B:630:0x1265, B:631:0x1268, B:110:0x0268, B:96:0x0238, B:42:0x00d2, B:53:0x0125), top: B:639:0x000f, inners: #11, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010a A[Catch: SQLiteException -> 0x023f, all -> 0x1260, TRY_LEAVE, TryCatch #1 {all -> 0x1260, blocks: (B:15:0x006f, B:20:0x007b, B:21:0x007f, B:46:0x00e2, B:48:0x010a, B:52:0x0121, B:53:0x0125, B:54:0x0137, B:56:0x013d, B:58:0x0149, B:60:0x0153, B:62:0x015f, B:64:0x0185, B:108:0x0255, B:63:0x0176, B:94:0x0225, B:39:0x00ca, B:44:0x00d9), top: B:637:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:624:0x1250 A[Catch: all -> 0x1269, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x1269, blocks: (B:3:0x000f, B:18:0x0077, B:111:0x026b, B:113:0x026f, B:119:0x027d, B:120:0x0294, B:123:0x02ae, B:126:0x02d8, B:128:0x030d, B:134:0x0323, B:136:0x032d, B:336:0x0924, B:138:0x035b, B:140:0x0361, B:142:0x036d, B:145:0x037b, B:147:0x0381, B:153:0x038f, B:155:0x039b, B:157:0x03a7, B:159:0x03ad, B:164:0x03ba, B:166:0x03bf, B:165:0x03bd, B:168:0x03d2, B:170:0x03e0, B:173:0x03fc, B:175:0x0402, B:177:0x0412, B:179:0x0420, B:181:0x0430, B:182:0x043d, B:183:0x0440, B:185:0x0454, B:201:0x048e, B:204:0x0498, B:206:0x04a6, B:210:0x04f7, B:207:0x04c8, B:209:0x04d8, B:214:0x0504, B:216:0x0532, B:217:0x055e, B:219:0x0593, B:221:0x0599, B:243:0x066a, B:244:0x0676, B:246:0x067c, B:252:0x06a3, B:249:0x0690, B:255:0x06a9, B:257:0x06b5, B:259:0x06c1, B:275:0x0710, B:278:0x072d, B:280:0x0737, B:283:0x074a, B:285:0x075d, B:287:0x076b, B:303:0x07da, B:305:0x07e0, B:306:0x07ec, B:308:0x07f2, B:310:0x0802, B:312:0x080c, B:313:0x081f, B:315:0x0825, B:316:0x0840, B:318:0x0846, B:319:0x0868, B:320:0x0873, B:324:0x089d, B:321:0x0879, B:323:0x0887, B:325:0x08a9, B:326:0x08c3, B:328:0x08c9, B:330:0x08dd, B:331:0x08ec, B:333:0x08f6, B:335:0x0908, B:291:0x0780, B:293:0x078e, B:296:0x07a3, B:298:0x07b6, B:300:0x07c4, B:263:0x06e2, B:267:0x06f6, B:269:0x06fc, B:272:0x0707, B:224:0x05a5, B:226:0x05dc, B:227:0x05f7, B:229:0x05fd, B:231:0x060b, B:235:0x0622, B:232:0x0617, B:238:0x0629, B:240:0x0630, B:241:0x064f, B:188:0x046a, B:339:0x0938, B:341:0x0946, B:343:0x094f, B:354:0x097f, B:344:0x0957, B:346:0x0960, B:348:0x0966, B:351:0x0972, B:353:0x097a, B:355:0x0982, B:356:0x098e, B:358:0x0994, B:364:0x09ad, B:365:0x09b8, B:370:0x09c5, B:374:0x09ea, B:376:0x0a04, B:378:0x0a19, B:380:0x0a33, B:382:0x0a48, B:383:0x0a57, B:385:0x0a5d, B:387:0x0a6d, B:388:0x0a74, B:390:0x0a80, B:391:0x0a87, B:392:0x0a8a, B:394:0x0ac6, B:396:0x0acc, B:402:0x0af3, B:404:0x0af9, B:405:0x0b02, B:407:0x0b08, B:408:0x0b0e, B:410:0x0b14, B:412:0x0b26, B:414:0x0b35, B:416:0x0b45, B:419:0x0b4e, B:421:0x0b54, B:422:0x0b69, B:424:0x0b6f, B:429:0x0b84, B:431:0x0b9c, B:433:0x0bae, B:435:0x0bd5, B:436:0x0bf2, B:438:0x0c04, B:440:0x0c27, B:442:0x0c52, B:444:0x0c82, B:445:0x0c8f, B:447:0x0ca1, B:449:0x0cc4, B:451:0x0cef, B:453:0x0d1f, B:454:0x0d2a, B:455:0x0d35, B:456:0x0d39, B:460:0x0d66, B:462:0x0d7d, B:463:0x0d90, B:465:0x0d96, B:468:0x0db1, B:470:0x0dcc, B:472:0x0de2, B:474:0x0de7, B:476:0x0deb, B:478:0x0def, B:480:0x0dfb, B:481:0x0e03, B:483:0x0e07, B:485:0x0e0f, B:486:0x0e1d, B:487:0x0e28, B:561:0x1079, B:489:0x0e34, B:493:0x0e66, B:494:0x0e6e, B:496:0x0e74, B:498:0x0e86, B:500:0x0e8a, B:514:0x0ec0, B:517:0x0ed6, B:518:0x0efb, B:520:0x0f07, B:522:0x0f1d, B:524:0x0f5c, B:528:0x0f74, B:530:0x0f7b, B:532:0x0f8c, B:534:0x0f90, B:536:0x0f94, B:538:0x0f98, B:539:0x0fa4, B:540:0x0fa9, B:542:0x0faf, B:544:0x0fce, B:545:0x0fd7, B:560:0x1076, B:546:0x0fef, B:548:0x0ff6, B:552:0x1016, B:554:0x1040, B:555:0x104e, B:556:0x105e, B:558:0x1066, B:549:0x1001, B:502:0x0e98, B:504:0x0e9c, B:506:0x0ea6, B:508:0x0eaa, B:562:0x1086, B:564:0x1092, B:565:0x1099, B:566:0x10a1, B:568:0x10a7, B:571:0x10bf, B:573:0x10cf, B:593:0x1150, B:595:0x1156, B:597:0x1166, B:600:0x116d, B:605:0x119e, B:601:0x1175, B:603:0x1181, B:604:0x1187, B:606:0x11af, B:607:0x11c6, B:610:0x11ce, B:611:0x11d3, B:612:0x11e3, B:614:0x11fd, B:615:0x1216, B:616:0x121e, B:621:0x1240, B:620:0x122f, B:574:0x10e7, B:576:0x10ed, B:578:0x10f7, B:580:0x10fe, B:586:0x110e, B:588:0x1115, B:590:0x1141, B:592:0x1148, B:591:0x1145, B:587:0x1112, B:579:0x10fb, B:397:0x0ada, B:399:0x0ae0, B:401:0x0ae6, B:381:0x0a45, B:377:0x0a16, B:371:0x09ca, B:373:0x09d0, B:624:0x1250, B:50:0x011d, B:69:0x01ba, B:78:0x01f4, B:86:0x0214, B:630:0x1265, B:631:0x1268, B:110:0x0268, B:96:0x0238, B:42:0x00d2, B:53:0x0125), top: B:639:0x000f, inners: #11, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:642:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzb(java.lang.String r43, long r44) {
        /*
            Method dump skipped, instructions count: 4723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzou.zzb(java.lang.String, long):boolean");
    }

    private final boolean zzag() {
        zzl().zzv();
        zzt();
        return zzf().zzy() || !TextUtils.isEmpty(zzf().g_());
    }

    private final boolean zza(String str, String str2) {
        zzbh zzd = zzf().zzd(str, str2);
        return zzd == null || zzd.zzc < 1;
    }

    private final boolean zzf(String str) {
        zzb zzbVar = this.zzaf.get(str);
        if (zzbVar == null) {
            return true;
        }
        return zzbVar.zzb();
    }

    private final boolean zzah() {
        zzl().zzv();
        FileLock fileLock = this.zzx;
        if (fileLock != null && fileLock.isValid()) {
            zzj().zzq().zza("Storage concurrent access okay");
            return true;
        }
        try {
            FileChannel channel = new RandomAccessFile(new File(com.google.android.gms.internal.measurement.zzcf.zza().zza(this.zzm.zza().getFilesDir(), "google_app_measurement.db")), "rw").getChannel();
            this.zzy = channel;
            FileLock tryLock = channel.tryLock();
            this.zzx = tryLock;
            if (tryLock != null) {
                zzj().zzq().zza("Storage concurrent access okay");
                return true;
            }
            zzj().zzg().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzj().zzg().zza("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzj().zzg().zza("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            zzj().zzr().zza("Storage lock already acquired", e3);
            return false;
        }
    }

    private final boolean zza(zzgf.zzf.zza zzaVar, zzgf.zzf.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.zze()));
        zzp();
        zzgf.zzh zza2 = zzpj.zza((zzgf.zzf) ((com.google.android.gms.internal.measurement.zzkg) zzaVar.zzaj()), "_sc");
        String zzh = zza2 == null ? null : zza2.zzh();
        zzp();
        zzgf.zzh zza3 = zzpj.zza((zzgf.zzf) ((com.google.android.gms.internal.measurement.zzkg) zzaVar2.zzaj()), "_pc");
        String zzh2 = zza3 != null ? zza3.zzh() : null;
        if (zzh2 == null || !zzh2.equals(zzh)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzaVar.zze()));
        zzp();
        zzgf.zzh zza4 = zzpj.zza((zzgf.zzf) ((com.google.android.gms.internal.measurement.zzkg) zzaVar.zzaj()), "_et");
        if (zza4 == null || !zza4.zzl() || zza4.zzd() <= 0) {
            return true;
        }
        long zzd = zza4.zzd();
        zzp();
        zzgf.zzh zza5 = zzpj.zza((zzgf.zzf) ((com.google.android.gms.internal.measurement.zzkg) zzaVar2.zzaj()), "_et");
        if (zza5 != null && zza5.zzd() > 0) {
            zzd += zza5.zzd();
        }
        zzp();
        zzpj.zza(zzaVar2, "_et", Long.valueOf(zzd));
        zzp();
        zzpj.zza(zzaVar, "_fr", (Object) 1L);
        return true;
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzl().zzv();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzj().zzg().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                zzj().zzg().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            zzj().zzg().zza("Failed to write to channel", e);
            return false;
        }
    }
}
