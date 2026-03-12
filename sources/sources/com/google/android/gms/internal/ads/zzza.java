package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzza implements zzyw, zzhy {
    public static final zzgaa zza = zzgaa.zzp(4300000L, 3200000L, 2400000L, 1700000L, 860000L);
    public static final zzgaa zzb = zzgaa.zzp(1500000L, 980000L, 750000L, 520000L, 290000L);
    public static final zzgaa zzc = zzgaa.zzp(2000000L, 1300000L, 1000000L, 860000L, 610000L);
    public static final zzgaa zzd = zzgaa.zzp(2500000L, 1700000L, 1200000L, 970000L, 680000L);
    public static final zzgaa zze = zzgaa.zzp(4700000L, 2800000L, 2100000L, 1700000L, 980000L);
    public static final zzgaa zzf = zzgaa.zzp(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);
    private static zzza zzg;
    private final zzgad zzh;
    private final zzel zzj;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private long zzr;
    private int zzs;
    private final zzyu zzi = new zzyu();
    private final zzzp zzk = new zzzp(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);

    /* synthetic */ zzza(Context context, Map map, int i, zzel zzelVar, boolean z, zzyz zzyzVar) {
        this.zzh = zzgad.zzc(map);
        this.zzj = zzelVar;
        if (context != null) {
            zzfn zzb2 = zzfn.zzb(context);
            int zza2 = zzb2.zza();
            this.zzs = zza2;
            this.zzq = zzi(zza2);
            zzb2.zzd(new zzyy(this));
            return;
        }
        this.zzs = 0;
        this.zzq = zzi(0);
    }

    private final long zzi(int i) {
        Long l = (Long) this.zzh.get(Integer.valueOf(i));
        if (l == null) {
            l = (Long) this.zzh.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    private final void zzj(int i, long j, long j2) {
        int i2;
        long j3;
        if (i == 0) {
            if (j != 0) {
                j3 = j;
            } else if (j2 == this.zzr) {
                return;
            } else {
                j3 = 0;
            }
            i2 = 0;
        } else {
            i2 = i;
            j3 = j;
        }
        this.zzr = j2;
        this.zzi.zzb(i2, j3, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzk(int i) {
        if (this.zzs != i) {
            this.zzs = i;
            if (i != 1 && i != 0 && i != 8) {
                this.zzq = zzi(i);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                zzj(this.zzl > 0 ? (int) (elapsedRealtime - this.zzm) : 0, this.zzn, this.zzq);
                this.zzm = elapsedRealtime;
                this.zzn = 0L;
                this.zzp = 0L;
                this.zzo = 0L;
                this.zzk.zzc();
            }
        }
    }

    private static boolean zzl(zzhb zzhbVar, boolean z) {
        return z && !zzhbVar.zza(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0145, code lost:
        if (r3.equals("YE") != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x015d, code lost:
        if (r3.equals("WS") != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0167, code lost:
        if (r3.equals("WF") != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0171, code lost:
        if (r3.equals("VU") != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01a5, code lost:
        if (r3.equals("VE") != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01af, code lost:
        if (r3.equals("VC") != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01b9, code lost:
        if (r3.equals("VA") != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x01fb, code lost:
        if (r3.equals("UA") != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0221, code lost:
        if (r3.equals("TV") != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0239, code lost:
        if (r3.equals("TR") != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x025f, code lost:
        if (r3.equals("TM") != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0269, code lost:
        if (r3.equals("TL") != false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0273, code lost:
        if (r3.equals("TJ") != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x027d, code lost:
        if (r3.equals("TH") != false) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0295, code lost:
        if (r3.equals("TD") != false) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x02ad, code lost:
        if (r3.equals("SZ") != false) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x02b7, code lost:
        if (r3.equals("SY") != false) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x02c1, code lost:
        if (r3.equals("SX") != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02e7, code lost:
        if (r3.equals("SS") != false) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x031b, code lost:
        if (r3.equals("SM") != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0325, code lost:
        if (r3.equals("SL") != false) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x033d, code lost:
        if (r3.equals("SJ") != false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0347, code lost:
        if (r3.equals("SI") != false) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0351, code lost:
        if (r3.equals("SH") != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0369, code lost:
        if (r3.equals("SE") != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0373, code lost:
        if (r3.equals("SD") != false) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x037d, code lost:
        if (r3.equals("SC") != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
        if (r3.equals("CI") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0387, code lost:
        if (r3.equals("SB") != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x038e, code lost:
        return new int[]{4, 2, 4, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x03f7, code lost:
        if (r3.equals("PY") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x040f, code lost:
        if (r3.equals("PT") != false) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x0435, code lost:
        if (r3.equals("PM") != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x0469, code lost:
        if (r3.equals(com.google.android.gms.ads.RequestConfiguration.MAX_AD_CONTENT_RATING_PG) != false) goto L346;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0057, code lost:
        if (r3.equals("CG") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x048f, code lost:
        if (r3.equals("PA") != false) goto L358;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x04b5, code lost:
        if (r3.equals("NU") != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x04bf, code lost:
        if (r3.equals("NR") != false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x04f3, code lost:
        if (r3.equals("NI") != false) goto L386;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x050b, code lost:
        if (r3.equals("NF") != false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0515, code lost:
        if (r3.equals("NE") != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x051f, code lost:
        if (r3.equals("NC") != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0526, code lost:
        return new int[]{2, 3, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x053b, code lost:
        if (r3.equals("MZ") != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0542, code lost:
        return new int[]{3, 1, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x058f, code lost:
        if (r3.equals("MT") != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x0599, code lost:
        if (r3.equals("MS") != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x05a3, code lost:
        if (r3.equals("MR") != false) goto L430;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x05bb, code lost:
        if (r3.equals("MP") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x05c2, code lost:
        return new int[]{1, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x05e5, code lost:
        if (r3.equals("MM") != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x05ef, code lost:
        if (r3.equals("ML") != false) goto L452;
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x0607, code lost:
        if (r3.equals("MH") != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x060e, code lost:
        return new int[]{4, 2, 2, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x0615, code lost:
        if (r3.equals("MG") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x0649, code lost:
        if (r3.equals("MC") != false) goto L476;
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x0661, code lost:
        if (r3.equals("LY") != false) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x066b, code lost:
        if (r3.equals("LV") != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x0691, code lost:
        if (r3.equals("LS") != false) goto L346;
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x0698, code lost:
        return new int[]{4, 3, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:500:0x069f, code lost:
        if (r3.equals("LR") != false) goto L498;
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:0x06a9, code lost:
        if (r3.equals("LK") != false) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x06b0, code lost:
        return new int[]{3, 2, 3, 3, 4, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:0x06b7, code lost:
        if (r3.equals("LI") != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:526:0x06f9, code lost:
        if (r3.equals("KY") != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x0703, code lost:
        if (r3.equals("KW") != false) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0099, code lost:
        if (r3.equals("BQ") != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:536:0x071b, code lost:
        if (r3.equals("KN") != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:539:0x0725, code lost:
        if (r3.equals("KM") != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:541:0x072c, code lost:
        return new int[]{4, 3, 3, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:543:0x0733, code lost:
        if (r3.equals("KI") != false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x0775, code lost:
        if (r3.equals("JO") != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x078d, code lost:
        if (r3.equals("JE") != false) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:576:0x07a5, code lost:
        if (r3.equals("IS") != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:595:0x07e7, code lost:
        if (r3.equals("IM") != false) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x081b, code lost:
        if (r3.equals("HU") != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:613:0x0825, code lost:
        if (r3.equals("HT") != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:616:0x082f, code lost:
        if (r3.equals("HR") != false) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:618:0x0836, code lost:
        return new int[]{1, 0, 0, 0, 0, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:644:0x0891, code lost:
        if (r3.equals("GQ") != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:655:0x08b7, code lost:
        if (r3.equals("GM") != false) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:657:0x08be, code lost:
        return new int[]{4, 3, 2, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:659:0x08c5, code lost:
        if (r3.equals("GL") != false) goto L476;
     */
    /* JADX WARN: Code restructure failed: missing block: B:661:0x08cc, code lost:
        return new int[]{1, 2, 2, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:663:0x08d3, code lost:
        if (r3.equals("GI") != false) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:665:0x08da, code lost:
        return new int[]{0, 2, 0, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00cd, code lost:
        if (r3.equals("BL") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:707:0x096d, code lost:
        if (r3.equals("FK") != false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:709:0x0974, code lost:
        return new int[]{3, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:727:0x09b3, code lost:
        if (r3.equals("ER") != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:729:0x09ba, code lost:
        return new int[]{4, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:731:0x09c1, code lost:
        if (r3.equals("EG") != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:733:0x09c8, code lost:
        return new int[]{3, 4, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:735:0x09cf, code lost:
        if (r3.equals("EE") != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:737:0x09d6, code lost:
        return new int[]{0, 0, 0, 0, 0, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:743:0x09eb, code lost:
        if (r3.equals("DZ") != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:745:0x09f2, code lost:
        return new int[]{3, 3, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:747:0x09f9, code lost:
        if (r3.equals("DO") != false) goto L498;
     */
    /* JADX WARN: Code restructure failed: missing block: B:749:0x0a00, code lost:
        return new int[]{3, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e5, code lost:
        if (r3.equals("AT") != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:751:0x0a07, code lost:
        if (r3.equals("DM") != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:758:0x0a1f, code lost:
        if (r3.equals("DJ") != false) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:773:0x0a53, code lost:
        if (r3.equals("CX") != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:776:0x0a5d, code lost:
        if (r3.equals("CW") != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:783:0x0a75, code lost:
        if (r3.equals("CU") != false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:785:0x0a7c, code lost:
        return new int[]{4, 2, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:787:0x0a83, code lost:
        if (r3.equals("CR") != false) goto L386;
     */
    /* JADX WARN: Code restructure failed: missing block: B:789:0x0a8a, code lost:
        return new int[]{2, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:799:0x0aad, code lost:
        if (r3.equals("CM") != false) goto L430;
     */
    /* JADX WARN: Code restructure failed: missing block: B:801:0x0ab4, code lost:
        return new int[]{4, 3, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:803:0x0abb, code lost:
        if (r3.equals("CL") != false) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:805:0x0ac2, code lost:
        return new int[]{0, 1, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:807:0x0ac9, code lost:
        if (r3.equals("CK") != false) goto L762;
     */
    /* JADX WARN: Code restructure failed: missing block: B:810:0x0ad3, code lost:
        if (r3.equals("CD") != false) goto L452;
     */
    /* JADX WARN: Code restructure failed: missing block: B:812:0x0ada, code lost:
        return new int[]{3, 3, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:814:0x0ae1, code lost:
        if (r3.equals("CA") != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:816:0x0ae8, code lost:
        return new int[]{0, 2, 1, 2, 3, 3};
     */
    /* JADX WARN: Code restructure failed: missing block: B:826:0x0b0b, code lost:
        if (r3.equals("BI") != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:828:0x0b12, code lost:
        return new int[]{4, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:834:0x0b27, code lost:
        if (r3.equals("BG") != false) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:836:0x0b2e, code lost:
        return new int[]{0, 0, 0, 0, 1, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:838:0x0b35, code lost:
        if (r3.equals("BF") != false) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:840:0x0b3c, code lost:
        return new int[]{4, 3, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:850:0x0b5f, code lost:
        if (r3.equals("AZ") != false) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:852:0x0b66, code lost:
        return new int[]{4, 2, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:858:0x0b7b, code lost:
        if (r3.equals("AI") != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x010b, code lost:
        if (r3.equals("AQ") != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:861:0x0b84, code lost:
        if (r3.equals("AG") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:863:0x0b8b, code lost:
        return new int[]{2, 4, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:865:0x0b92, code lost:
        if (r3.equals("AF") != false) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:867:0x0b99, code lost:
        return new int[]{4, 4, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:873:0x0bae, code lost:
        if (r3.equals("AD") != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:876:0x0bb7, code lost:
        if (r3.equals("BZ") != false) goto L762;
     */
    /* JADX WARN: Code restructure failed: missing block: B:878:0x0bbe, code lost:
        return new int[]{2, 2, 2, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:884:0x0bd3, code lost:
        if (r3.equals("BB") != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:886:0x0bda, code lost:
        return new int[]{1, 2, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:888:0x0be1, code lost:
        if (r3.equals("BA") != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0115, code lost:
        if (r3.equals("ZW") != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:890:0x0be8, code lost:
        return new int[]{1, 1, 1, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:892:0x0bef, code lost:
        if (r3.equals("AX") != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:894:0x0bf6, code lost:
        return new int[]{0, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:900:0x0c0b, code lost:
        if (r3.equals("AM") != false) goto L358;
     */
    /* JADX WARN: Code restructure failed: missing block: B:902:0x0c12, code lost:
        return new int[]{2, 3, 2, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x013b, code lost:
        if (r3.equals("YT") != false) goto L108;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int[] zzm(java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 6672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzza.zzm(java.lang.String):int[]");
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final synchronized void zza(zzgw zzgwVar, zzhb zzhbVar, boolean z, int i) {
        if (zzl(zzhbVar, z)) {
            this.zzn += i;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final synchronized void zzb(zzgw zzgwVar, zzhb zzhbVar, boolean z) {
        if (zzl(zzhbVar, z)) {
            zzek.zzf(this.zzl > 0);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = (int) (elapsedRealtime - this.zzm);
            this.zzo += i;
            long j = this.zzp;
            long j2 = this.zzn;
            this.zzp = j + j2;
            if (i > 0) {
                this.zzk.zzb((int) Math.sqrt(j2), (((float) j2) * 8000.0f) / i);
                if (this.zzo >= 2000 || this.zzp >= 524288) {
                    this.zzq = this.zzk.zza(0.5f);
                }
                zzj(i, this.zzn, this.zzq);
                this.zzm = elapsedRealtime;
                this.zzn = 0L;
            }
            this.zzl--;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzc(zzgw zzgwVar, zzhb zzhbVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final synchronized void zzd(zzgw zzgwVar, zzhb zzhbVar, boolean z) {
        if (zzl(zzhbVar, z)) {
            if (this.zzl == 0) {
                this.zzm = SystemClock.elapsedRealtime();
            }
            this.zzl++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyw
    public final void zzf(zzyv zzyvVar) {
        this.zzi.zzc(zzyvVar);
    }

    public static synchronized zzza zzg(Context context) {
        zzza zzzaVar;
        String zzb2;
        TelephonyManager telephonyManager;
        synchronized (zzza.class) {
            if (zzg == null) {
                Context applicationContext = context == null ? null : context.getApplicationContext();
                int i = zzfy.zza;
                if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    String networkCountryIso = telephonyManager.getNetworkCountryIso();
                    if (!TextUtils.isEmpty(networkCountryIso)) {
                        zzb2 = zzfwk.zzb(networkCountryIso);
                        int[] zzm = zzm(zzb2);
                        HashMap hashMap = new HashMap(8);
                        hashMap.put(0, 1000000L);
                        zzgaa zzgaaVar = zza;
                        hashMap.put(2, (Long) zzgaaVar.get(zzm[0]));
                        hashMap.put(3, (Long) zzb.get(zzm[1]));
                        hashMap.put(4, (Long) zzc.get(zzm[2]));
                        hashMap.put(5, (Long) zzd.get(zzm[3]));
                        hashMap.put(10, (Long) zze.get(zzm[4]));
                        hashMap.put(9, (Long) zzf.get(zzm[5]));
                        hashMap.put(7, (Long) zzgaaVar.get(zzm[0]));
                        zzg = new zzza(applicationContext, hashMap, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, zzel.zza, true, null);
                    }
                }
                zzb2 = zzfwk.zzb(Locale.getDefault().getCountry());
                int[] zzm2 = zzm(zzb2);
                HashMap hashMap2 = new HashMap(8);
                hashMap2.put(0, 1000000L);
                zzgaa zzgaaVar2 = zza;
                hashMap2.put(2, (Long) zzgaaVar2.get(zzm2[0]));
                hashMap2.put(3, (Long) zzb.get(zzm2[1]));
                hashMap2.put(4, (Long) zzc.get(zzm2[2]));
                hashMap2.put(5, (Long) zzd.get(zzm2[3]));
                hashMap2.put(10, (Long) zze.get(zzm2[4]));
                hashMap2.put(9, (Long) zzf.get(zzm2[5]));
                hashMap2.put(7, (Long) zzgaaVar2.get(zzm2[0]));
                zzg = new zzza(applicationContext, hashMap2, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, zzel.zza, true, null);
            }
            zzzaVar = zzg;
        }
        return zzzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyw
    public final void zze(Handler handler, zzyv zzyvVar) {
        zzyvVar.getClass();
        this.zzi.zza(handler, zzyvVar);
    }
}
