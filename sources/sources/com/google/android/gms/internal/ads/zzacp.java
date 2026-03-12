package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes2.dex */
public final class zzacp implements zzadb {
    private static final int[] zza = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20};
    private static final zzaco zzc = new zzaco(new zzacn() { // from class: com.google.android.gms.internal.ads.zzacl
        @Override // com.google.android.gms.internal.ads.zzacn
        public final Constructor zza() {
            if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzacu.class).getConstructor(Integer.TYPE);
            }
            return null;
        }
    });
    private static final zzaco zzd = new zzaco(new zzacn() { // from class: com.google.android.gms.internal.ads.zzacm
        @Override // com.google.android.gms.internal.ads.zzacn
        public final Constructor zza() {
            return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(zzacu.class).getConstructor(new Class[0]);
        }
    });
    private zzgaa zze;
    private final zzakp zzf = new zzakk();

    /* JADX WARN: Removed duplicated region for block: B:131:0x01e0 A[Catch: all -> 0x03bf, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0017, B:9:0x001e, B:131:0x01e0, B:132:0x01e3, B:246:0x0391, B:247:0x0394, B:249:0x0399, B:252:0x039f, B:253:0x03a2, B:254:0x03a5, B:255:0x03ac, B:257:0x03b2, B:135:0x01ec, B:137:0x01f4, B:140:0x01fe, B:143:0x020a, B:145:0x0212, B:148:0x021c, B:151:0x0227, B:154:0x0232, B:157:0x023d, B:159:0x0245, B:161:0x024d, B:164:0x0257, B:166:0x0265, B:169:0x026f, B:172:0x027a, B:174:0x0282, B:176:0x0290, B:178:0x029e, B:181:0x02ae, B:183:0x02bc, B:186:0x02c6, B:188:0x02ce, B:190:0x02d6, B:192:0x02de, B:195:0x02e8, B:197:0x02f0, B:200:0x0300, B:202:0x0308, B:205:0x0312, B:207:0x031a, B:210:0x0323, B:212:0x032b, B:215:0x0334, B:218:0x033f, B:221:0x034a, B:224:0x0355, B:226:0x035d, B:229:0x0366, B:14:0x0048, B:15:0x0050, B:108:0x01a9, B:17:0x0055, B:20:0x0061, B:23:0x006c, B:26:0x0078, B:29:0x0084, B:32:0x008f, B:35:0x009b, B:38:0x00a6, B:41:0x00b1, B:44:0x00bd, B:47:0x00c8, B:50:0x00d4, B:53:0x00df, B:56:0x00ea, B:59:0x00f5, B:62:0x0101, B:65:0x010c, B:68:0x0118, B:71:0x0124, B:74:0x0130, B:77:0x013c, B:80:0x0148, B:83:0x0153, B:86:0x015e, B:89:0x0169, B:92:0x0174, B:95:0x017f, B:98:0x0189, B:101:0x0194, B:104:0x019e), top: B:264:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ec A[Catch: all -> 0x03bf, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0017, B:9:0x001e, B:131:0x01e0, B:132:0x01e3, B:246:0x0391, B:247:0x0394, B:249:0x0399, B:252:0x039f, B:253:0x03a2, B:254:0x03a5, B:255:0x03ac, B:257:0x03b2, B:135:0x01ec, B:137:0x01f4, B:140:0x01fe, B:143:0x020a, B:145:0x0212, B:148:0x021c, B:151:0x0227, B:154:0x0232, B:157:0x023d, B:159:0x0245, B:161:0x024d, B:164:0x0257, B:166:0x0265, B:169:0x026f, B:172:0x027a, B:174:0x0282, B:176:0x0290, B:178:0x029e, B:181:0x02ae, B:183:0x02bc, B:186:0x02c6, B:188:0x02ce, B:190:0x02d6, B:192:0x02de, B:195:0x02e8, B:197:0x02f0, B:200:0x0300, B:202:0x0308, B:205:0x0312, B:207:0x031a, B:210:0x0323, B:212:0x032b, B:215:0x0334, B:218:0x033f, B:221:0x034a, B:224:0x0355, B:226:0x035d, B:229:0x0366, B:14:0x0048, B:15:0x0050, B:108:0x01a9, B:17:0x0055, B:20:0x0061, B:23:0x006c, B:26:0x0078, B:29:0x0084, B:32:0x008f, B:35:0x009b, B:38:0x00a6, B:41:0x00b1, B:44:0x00bd, B:47:0x00c8, B:50:0x00d4, B:53:0x00df, B:56:0x00ea, B:59:0x00f5, B:62:0x0101, B:65:0x010c, B:68:0x0118, B:71:0x0124, B:74:0x0130, B:77:0x013c, B:80:0x0148, B:83:0x0153, B:86:0x015e, B:89:0x0169, B:92:0x0174, B:95:0x017f, B:98:0x0189, B:101:0x0194, B:104:0x019e), top: B:264:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[Catch: all -> 0x03bf, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0017, B:9:0x001e, B:131:0x01e0, B:132:0x01e3, B:246:0x0391, B:247:0x0394, B:249:0x0399, B:252:0x039f, B:253:0x03a2, B:254:0x03a5, B:255:0x03ac, B:257:0x03b2, B:135:0x01ec, B:137:0x01f4, B:140:0x01fe, B:143:0x020a, B:145:0x0212, B:148:0x021c, B:151:0x0227, B:154:0x0232, B:157:0x023d, B:159:0x0245, B:161:0x024d, B:164:0x0257, B:166:0x0265, B:169:0x026f, B:172:0x027a, B:174:0x0282, B:176:0x0290, B:178:0x029e, B:181:0x02ae, B:183:0x02bc, B:186:0x02c6, B:188:0x02ce, B:190:0x02d6, B:192:0x02de, B:195:0x02e8, B:197:0x02f0, B:200:0x0300, B:202:0x0308, B:205:0x0312, B:207:0x031a, B:210:0x0323, B:212:0x032b, B:215:0x0334, B:218:0x033f, B:221:0x034a, B:224:0x0355, B:226:0x035d, B:229:0x0366, B:14:0x0048, B:15:0x0050, B:108:0x01a9, B:17:0x0055, B:20:0x0061, B:23:0x006c, B:26:0x0078, B:29:0x0084, B:32:0x008f, B:35:0x009b, B:38:0x00a6, B:41:0x00b1, B:44:0x00bd, B:47:0x00c8, B:50:0x00d4, B:53:0x00df, B:56:0x00ea, B:59:0x00f5, B:62:0x0101, B:65:0x010c, B:68:0x0118, B:71:0x0124, B:74:0x0130, B:77:0x013c, B:80:0x0148, B:83:0x0153, B:86:0x015e, B:89:0x0169, B:92:0x0174, B:95:0x017f, B:98:0x0189, B:101:0x0194, B:104:0x019e), top: B:264:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x038f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0399 A[Catch: all -> 0x03bf, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0017, B:9:0x001e, B:131:0x01e0, B:132:0x01e3, B:246:0x0391, B:247:0x0394, B:249:0x0399, B:252:0x039f, B:253:0x03a2, B:254:0x03a5, B:255:0x03ac, B:257:0x03b2, B:135:0x01ec, B:137:0x01f4, B:140:0x01fe, B:143:0x020a, B:145:0x0212, B:148:0x021c, B:151:0x0227, B:154:0x0232, B:157:0x023d, B:159:0x0245, B:161:0x024d, B:164:0x0257, B:166:0x0265, B:169:0x026f, B:172:0x027a, B:174:0x0282, B:176:0x0290, B:178:0x029e, B:181:0x02ae, B:183:0x02bc, B:186:0x02c6, B:188:0x02ce, B:190:0x02d6, B:192:0x02de, B:195:0x02e8, B:197:0x02f0, B:200:0x0300, B:202:0x0308, B:205:0x0312, B:207:0x031a, B:210:0x0323, B:212:0x032b, B:215:0x0334, B:218:0x033f, B:221:0x034a, B:224:0x0355, B:226:0x035d, B:229:0x0366, B:14:0x0048, B:15:0x0050, B:108:0x01a9, B:17:0x0055, B:20:0x0061, B:23:0x006c, B:26:0x0078, B:29:0x0084, B:32:0x008f, B:35:0x009b, B:38:0x00a6, B:41:0x00b1, B:44:0x00bd, B:47:0x00c8, B:50:0x00d4, B:53:0x00df, B:56:0x00ea, B:59:0x00f5, B:62:0x0101, B:65:0x010c, B:68:0x0118, B:71:0x0124, B:74:0x0130, B:77:0x013c, B:80:0x0148, B:83:0x0153, B:86:0x015e, B:89:0x0169, B:92:0x0174, B:95:0x017f, B:98:0x0189, B:101:0x0194, B:104:0x019e), top: B:264:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03b2 A[Catch: all -> 0x03bf, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0017, B:9:0x001e, B:131:0x01e0, B:132:0x01e3, B:246:0x0391, B:247:0x0394, B:249:0x0399, B:252:0x039f, B:253:0x03a2, B:254:0x03a5, B:255:0x03ac, B:257:0x03b2, B:135:0x01ec, B:137:0x01f4, B:140:0x01fe, B:143:0x020a, B:145:0x0212, B:148:0x021c, B:151:0x0227, B:154:0x0232, B:157:0x023d, B:159:0x0245, B:161:0x024d, B:164:0x0257, B:166:0x0265, B:169:0x026f, B:172:0x027a, B:174:0x0282, B:176:0x0290, B:178:0x029e, B:181:0x02ae, B:183:0x02bc, B:186:0x02c6, B:188:0x02ce, B:190:0x02d6, B:192:0x02de, B:195:0x02e8, B:197:0x02f0, B:200:0x0300, B:202:0x0308, B:205:0x0312, B:207:0x031a, B:210:0x0323, B:212:0x032b, B:215:0x0334, B:218:0x033f, B:221:0x034a, B:224:0x0355, B:226:0x035d, B:229:0x0366, B:14:0x0048, B:15:0x0050, B:108:0x01a9, B:17:0x0055, B:20:0x0061, B:23:0x006c, B:26:0x0078, B:29:0x0084, B:32:0x008f, B:35:0x009b, B:38:0x00a6, B:41:0x00b1, B:44:0x00bd, B:47:0x00c8, B:50:0x00d4, B:53:0x00df, B:56:0x00ea, B:59:0x00f5, B:62:0x0101, B:65:0x010c, B:68:0x0118, B:71:0x0124, B:74:0x0130, B:77:0x013c, B:80:0x0148, B:83:0x0153, B:86:0x015e, B:89:0x0169, B:92:0x0174, B:95:0x017f, B:98:0x0189, B:101:0x0194, B:104:0x019e), top: B:264:0x0003 }] */
    @Override // com.google.android.gms.internal.ads.zzadb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.google.android.gms.internal.ads.zzacu[] zza(android.net.Uri r25, java.util.Map r26) {
        /*
            Method dump skipped, instructions count: 1148
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacp.zza(android.net.Uri, java.util.Map):com.google.android.gms.internal.ads.zzacu[]");
    }

    private final void zzb(int i, List list) {
        switch (i) {
            case 0:
                list.add(new zzamn());
                return;
            case 1:
                list.add(new zzamq());
                return;
            case 2:
                list.add(new zzamt(0));
                return;
            case 3:
                list.add(new zzaei(0));
                return;
            case 4:
                zzacu zza2 = zzc.zza(0);
                if (zza2 != null) {
                    list.add(zza2);
                    return;
                } else {
                    list.add(new zzafa(0));
                    return;
                }
            case 5:
                list.add(new zzafd());
                return;
            case 6:
                list.add(new zzahy(0));
                return;
            case 7:
                list.add(new zzaig(0));
                return;
            case 8:
                list.add(new zzajc(this.zzf, 32, null, null, zzgaa.zzl(), null));
                list.add(new zzajh(this.zzf, 16));
                return;
            case 9:
                list.add(new zzajw());
                return;
            case 10:
                list.add(new zzanw());
                return;
            case 11:
                if (this.zze == null) {
                    this.zze = zzgaa.zzl();
                }
                list.add(new zzaog(1, 1, this.zzf, new zzfw(0L), new zzamv(0, this.zze), 112800));
                return;
            case 12:
                list.add(new zzaos());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new zzafj(0));
                return;
            case 15:
                zzacu zza3 = zzd.zza(new Object[0]);
                if (zza3 != null) {
                    list.add(zza3);
                    return;
                }
                return;
            case 16:
                list.add(new zzaen());
                return;
            case 17:
                list.add(new zzakh());
                return;
            case 18:
                list.add(new zzaox());
                return;
            case 19:
                list.add(new zzaeu());
                return;
            case 20:
                list.add(new zzafi());
                return;
        }
    }
}
