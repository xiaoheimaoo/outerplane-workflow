package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zztn {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02bf A[Catch: NumberFormatException -> 0x02d0, TRY_LEAVE, TryCatch #3 {NumberFormatException -> 0x02d0, blocks: (B:144:0x0269, B:146:0x027b, B:157:0x0297, B:173:0x02bf), top: B:481:0x0269 }] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x06d0  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0781  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0794  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair zza(com.google.android.gms.internal.ads.zzam r19) {
        /*
            Method dump skipped, instructions count: 2488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztn.zza(com.google.android.gms.internal.ads.zzam):android.util.Pair");
    }

    public static zzsv zzb() throws zzth {
        List zze = zze("audio/raw", false, false);
        if (zze.isEmpty()) {
            return null;
        }
        return (zzsv) zze.get(0);
    }

    public static String zzc(zzam zzamVar) {
        Pair zza2;
        if ("audio/eac3-joc".equals(zzamVar.zzm)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(zzamVar.zzm) || (zza2 = zza(zzamVar)) == null) {
            return null;
        }
        int intValue = ((Integer) zza2.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return "video/hevc";
        }
        if (intValue == 512) {
            return "video/avc";
        }
        return null;
    }

    public static List zzd(zztb zztbVar, zzam zzamVar, boolean z, boolean z2) throws zzth {
        String zzc2 = zzc(zzamVar);
        if (zzc2 == null) {
            return zzgaa.zzl();
        }
        return zze(zzc2, z, z2);
    }

    public static synchronized List zze(String str, boolean z, boolean z2) throws zzth {
        synchronized (zztn.class) {
            zztf zztfVar = new zztf(str, z, z2);
            HashMap hashMap = zzc;
            List list = (List) hashMap.get(zztfVar);
            if (list != null) {
                return list;
            }
            int i = zzfy.zza;
            ArrayList zzh = zzh(zztfVar, new zztl(z, z2));
            if (z && zzh.isEmpty() && zzfy.zza <= 23) {
                zzh = zzh(zztfVar, new zztk(null));
                if (!zzh.isEmpty()) {
                    String str2 = ((zzsv) zzh.get(0)).zza;
                    zzff.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + str2);
                }
            }
            if ("audio/raw".equals(str)) {
                if (zzfy.zza < 26 && zzfy.zzb.equals("R9") && zzh.size() == 1 && ((zzsv) zzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    zzh.add(zzsv.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
                }
                zzi(zzh, new zztm() { // from class: com.google.android.gms.internal.ads.zztd
                    @Override // com.google.android.gms.internal.ads.zztm
                    public final int zza(Object obj) {
                        int i2 = zztn.zza;
                        String str3 = ((zzsv) obj).zza;
                        if (str3.startsWith("OMX.google") || str3.startsWith("c2.android")) {
                            return 1;
                        }
                        return (zzfy.zza >= 26 || !str3.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
                    }
                });
            }
            if (zzfy.zza < 32 && zzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzsv) zzh.get(0)).zza)) {
                zzh.add((zzsv) zzh.remove(0));
            }
            zzgaa zzj = zzgaa.zzj(zzh);
            hashMap.put(zztfVar, zzj);
            return zzj;
        }
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zzf(zztb zztbVar, zzam zzamVar, boolean z, boolean z2) throws zzth {
        List zze = zze(zzamVar.zzm, z, z2);
        List zzd = zzd(zztbVar, zzamVar, z, z2);
        zzfzx zzfzxVar = new zzfzx();
        zzfzxVar.zzh(zze);
        zzfzxVar.zzh(zzd);
        return zzfzxVar.zzi();
    }

    public static List zzg(List list, final zzam zzamVar) {
        ArrayList arrayList = new ArrayList(list);
        zzi(arrayList, new zztm() { // from class: com.google.android.gms.internal.ads.zzte
            @Override // com.google.android.gms.internal.ads.zztm
            public final int zza(Object obj) {
                int i = zztn.zza;
                return ((zzsv) obj).zzd(zzam.this) ? 1 : 0;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:64|65|(1:67)(2:128|(1:130)(1:131))|68|(1:70)(2:120|(1:127)(1:126))|(4:(2:114|115)|95|(8:98|99|100|101|102|103|104|106)|11)|74|75|76|78|11) */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01c6, code lost:
        if (r1.zzb == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01e4, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01e5, code lost:
        r1 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0192 A[Catch: Exception -> 0x0224, TryCatch #3 {Exception -> 0x0224, blocks: (B:80:0x0145, B:86:0x015c, B:92:0x0171, B:94:0x0177, B:99:0x0188, B:101:0x0192, B:111:0x01be, B:102:0x0197, B:104:0x01a7, B:106:0x01af, B:95:0x017d), top: B:156:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0197 A[Catch: Exception -> 0x0224, TryCatch #3 {Exception -> 0x0224, blocks: (B:80:0x0145, B:86:0x015c, B:92:0x0171, B:94:0x0177, B:99:0x0188, B:101:0x0192, B:111:0x01be, B:102:0x0197, B:104:0x01a7, B:106:0x01af, B:95:0x017d), top: B:156:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0233 A[Catch: Exception -> 0x0281, TRY_ENTER, TryCatch #5 {Exception -> 0x0281, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:10:0x0034, B:14:0x0042, B:16:0x0048, B:18:0x004e, B:20:0x0056, B:22:0x005e, B:24:0x0068, B:26:0x0072, B:28:0x007c, B:30:0x0086, B:32:0x0090, B:34:0x009a, B:36:0x00a4, B:38:0x00ae, B:40:0x00b8, B:42:0x00be, B:44:0x00c6, B:46:0x00ce, B:48:0x00d7, B:137:0x022b, B:140:0x0233, B:142:0x0239, B:143:0x0253, B:144:0x0274, B:51:0x00e0, B:52:0x00e3, B:54:0x00eb, B:57:0x00f6, B:59:0x00fe, B:62:0x0109, B:64:0x0111, B:67:0x011c, B:69:0x0124, B:72:0x012f, B:74:0x0137), top: B:160:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0253 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0177 A[Catch: Exception -> 0x0224, TryCatch #3 {Exception -> 0x0224, blocks: (B:80:0x0145, B:86:0x015c, B:92:0x0171, B:94:0x0177, B:99:0x0188, B:101:0x0192, B:111:0x01be, B:102:0x0197, B:104:0x01a7, B:106:0x01af, B:95:0x017d), top: B:156:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x017d A[Catch: Exception -> 0x0224, TryCatch #3 {Exception -> 0x0224, blocks: (B:80:0x0145, B:86:0x015c, B:92:0x0171, B:94:0x0177, B:99:0x0188, B:101:0x0192, B:111:0x01be, B:102:0x0197, B:104:0x01a7, B:106:0x01af, B:95:0x017d), top: B:156:0x0145 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList zzh(com.google.android.gms.internal.ads.zztf r23, com.google.android.gms.internal.ads.zzti r24) throws com.google.android.gms.internal.ads.zzth {
        /*
            Method dump skipped, instructions count: 649
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztn.zzh(com.google.android.gms.internal.ads.zztf, com.google.android.gms.internal.ads.zzti):java.util.ArrayList");
    }

    private static void zzi(List list, final zztm zztmVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zztc
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i = zztn.zza;
                zztm zztmVar2 = zztm.this;
                return zztmVar2.zza(obj2) - zztmVar2.zza(obj);
            }
        });
    }

    private static boolean zzj(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzfy.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzcb.zzg(str)) {
            return true;
        }
        String zza2 = zzfwk.zza(mediaCodecInfo.getName());
        if (zza2.startsWith("arc.")) {
            return false;
        }
        if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google.")) {
            return true;
        }
        return (zza2.startsWith("omx.") || zza2.startsWith("c2.")) ? false : true;
    }
}
