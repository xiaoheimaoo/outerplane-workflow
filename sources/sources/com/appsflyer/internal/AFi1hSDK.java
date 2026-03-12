package com.appsflyer.internal;

import java.util.Map;
/* loaded from: classes.dex */
public class AFi1hSDK {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int $12 = 0;
    private static int $13 = 1;
    public static final Map AFLogger;
    private static long afDebugLog;
    private static int afErrorLog;
    private static byte afErrorLogForExcManagerOnly;
    private static long afInfoLog;
    public static final Map d;
    private static Object e;
    private static int force;
    private static Object i;
    private static byte[] unregisterClient;
    private static long v;
    private static byte[] w;

    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0049 -> B:11:0x0027). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String $$c(short r7, byte r8, short r9) {
        /*
            int r0 = com.appsflyer.internal.AFi1hSDK.$13
            int r0 = r0 + 123
            int r1 = r0 % 128
            com.appsflyer.internal.AFi1hSDK.$12 = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            if (r0 == r1) goto L29
            r0 = 83
            int r8 = r0 >>> r8
            int r7 = r7 + 38
            r0 = 1355(0x54b, float:1.899E-42)
            int r0 = r0 % r9
            byte[] r9 = com.appsflyer.internal.AFi1hSDK.$$a
            byte[] r3 = new byte[r8]
            int r8 = r8 + 19
            if (r9 != 0) goto L25
            goto L46
        L25:
            r5 = r2
            r4 = r3
        L27:
            r3 = r7
            goto L58
        L29:
            r0 = 49
            int r8 = 49 - r8
            int r7 = r7 + 33
            int r9 = 1152 - r9
            byte[] r3 = com.appsflyer.internal.AFi1hSDK.$$a
            byte[] r4 = new byte[r8]
            int r8 = r8 + (-1)
            if (r3 != 0) goto L3b
            r5 = r0
            goto L3d
        L3b:
            r5 = 81
        L3d:
            if (r5 == r0) goto L43
            r0 = r9
            r5 = r2
            r9 = r3
            goto L27
        L43:
            r0 = r9
            r9 = r3
            r3 = r4
        L46:
            r5 = r2
            r4 = r3
            r3 = r0
        L49:
            int r0 = r0 + r1
            int r3 = r3 + r7
            int r7 = r3 + (-3)
            int r3 = com.appsflyer.internal.AFi1hSDK.$13
            int r3 = r3 + 15
            int r6 = r3 % 128
            com.appsflyer.internal.AFi1hSDK.$12 = r6
            int r3 = r3 % 2
            goto L27
        L58:
            byte r7 = (byte) r3
            r4[r5] = r7
            if (r5 != r8) goto L63
            java.lang.String r7 = new java.lang.String
            r7.<init>(r4, r2)
            return r7
        L63:
            int r5 = r5 + 1
            r7 = r9[r0]
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFi1hSDK.$$c(short, byte, short):java.lang.String");
    }

    static void init$0() {
        int i2;
        int i3 = $11;
        int i4 = (i3 ^ 7) + ((i3 & 7) << 1);
        $10 = i4 % 128;
        if ((i4 % 2 != 0 ? 'R' : '_') != '_') {
            byte[] bArr = new byte[1166];
            System.arraycopy("@ÛÛ¡\u0010ù\u0011\u0000ýþÍ<\u000eò\u0012û\u0004ý\u0013¾\u0018/\u0000\u0006\u0006øþ\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b&Ë6òô\n\u000b\u0003\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u0016%\u0014ø\u0010ö\u000e\bÞ\u0017\röÿ\u0006\u0015\u0000\u0003ö\f\tÐ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u00162\u0003Ú(\u0006ö\u0002\u000e\n\u0001\u0012Ø(þ\u000eøû\u000eØ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002\u0001\u0012Õ&\u0006ü\u0011Ô(\f\u0001\u0012Ò/ø\u0004á!\u0005\b\u0000â(\f\u0001\u0012Ò!\u0005\b\u0000â(\f8\u0000\u0016ðÑ8\u0000\u0016ðÑú\u0018îÐ>\tÂ\u001b&\u0006üú\u0018îÐ>\tÂIü\u0006÷\b\fú\u0018îÐAø\u0010üÊ()ý\u0004ô\u000b\u0001\u0012ß%\u0000\u0004ø\u0010\u0005\b\u000fø\u0004ý\u0007\u0001\u0005\b\u0000\u0010ù\u0011\u0000ýþÍD\u0007¾\u00176÷\u0006ûÃ5ò\u0010\u0004ù\t\u0002ô\n\u0017í\b\t\u0001\u0010ì\u001eú\u000eôî\tí\u000bú\u0018îÐ>\tÂ\u001e\tù6î\u0005\u000e\u0007ø\t\u0002\u0015\u0000\u0003ö\f\tã\u0018\u0007ûë\u001f\u0006\u0003\u0000\rú\u0018îÐ>\tÂ\u001b&\u0006üí)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\f\u0006\u0007õî\u0006ð\u000b5\u0015\u0003õ\u0012\u0002¿7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ5\u0004\u0004\u0003Ó\u00022\u0003Ö\u00070Ï\u000bý\b.Í\u0001\u0012á\u0016\u0011ÿ\t\u0000ô\u0005ú\u0018îÐCú\u0012½*\u0000ý\u0001\u0012ß\u0014\u0016÷ú\u0018îÐ>\tÂ\u00176ô\u0003\u0002\u0010ö\u0002è(\u0005\b\u0002â$\u0001öÿ\u000fú\u0018îÐ>\tÂ\u001e(\u0005\b\u0002â$\u0001öÿ\u000fú\u0018îÐ>\tÂ\u0019 \u0016ðë(\u0005\b\u0002â$\u0001öÿ\u000föÿ\u0006å2ú\u0003\u0010ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÓ(\u0005\b\u0002â$\u0001öÿ\u000f\u0014\u0003ò\u001bí\u000f\u0004\f\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010¿>\b\tô\u0010ÿö\u000eÅ\u0016\b(ÉBæô\n\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010¿>\b\tô\u0010ÿö\u000eÅ\u0016\b&Ë6òô\n\u000b\u0003\u0001\u0012Ü\u001b\u0002\bû\u0016ø\t\u0002ã\u001a\u0012\u0006û\u0006üû\u0001\nöÿ\u0006õ\u0012á\u0016ÿ\u0006î\"\u0001\u0010î\u0007ï\u000bþú\u000eô\u0001\u0012Õ\u0001ú\u0018îÐ>\tÂ\u001b&\u0006üâ$\u0011ó\u0012ú\n\u0007þ\u0006\tøø\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0019$\u0016Ñ&\u0006ü\u0006õ\u0006ã$\u0016\u0001\u0012Ð$\u0014ÿ\u0000\f\u0002ôî\u0014\u0016÷\u0004\nü\u0012ô\u0001\u0012Ò,ø\u0015\u0003Ü&õ\u0006\u0004\u0010ú\u0018îÐJ\u0002ø\u0006ÅOò\nÁ/\u0012\nÜ(\u0005\b\u0002â$\u0001öÿ\u000f\u0001\u0012Ý\u001a\u0016ÿÔ,\t\u0001\nú\u0018îÐJ\u0002ø\u0006ÅOò\nÁ/\u0012\nØ,\t\u0001\n\u0001\u0012â\u0019\u0014îú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÙ)\u0002ÿ\b\u0002â$\u0001öÿ\u000fþÖ:þôß4\u0003ò\u001bú\u0018îÐ>\tÂ\u0018,\u0006\u0007õÿ\u0004\rü\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u001e(â\u001b\u000b\u0005\u0006\nÎ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010ú\u0018îÐCþ\tÂ\u0017:þôà6ô\u0003\u0002\u0010ú\u0018îÐAø\u0010üÊ\u0018,ø\u0015\u0003Ü&õ\u0006\u0004\u0010þò\u0012\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0017\"\u0015õâ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010ô\u0016÷ç \r\u0004ö\u0016ø\u0010òê ü\u0013ò\u0014\nÎ(\fö\u0001\u0014þ\u0006úÿ\u0011ö\u0016ø\u0010òê ü\u0013ò\u0014\nÚ\u0014\u0016÷à*ü\u000bû\f\t\u0002\u0001\u0012Ò/\u0001\u0006\u0002\u0002ú\f\tã(úøî\u000bë\u000b\u0006õ\u0006â,ø\u0015\u0003\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b&Ë:îô\nÜH5\u0015\u0003õ\u0012\u0002¿7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\b2Ó\u0003\u00072þ\u0004Ô\u0004\b\u0001\u00031Ñ\u00070Ìî\nì\u000bI\u0004´Iþ\u000e\u0003ù\u0002\u0005\u000b\u000b°Oü\u0004\u0011¸\u0001\u0012á\u0016\u0014ò\f\nó\bþ&ñ\u0016\u0014ò\f\nóâ \u0016ð".getBytes("ISO-8859-1"), 0, bArr, 0, 1166);
            $$a = bArr;
            i2 = 72;
        } else {
            byte[] bArr2 = new byte[1166];
            System.arraycopy("@ÛÛ¡\u0010ù\u0011\u0000ýþÍ<\u000eò\u0012û\u0004ý\u0013¾\u0018/\u0000\u0006\u0006øþ\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b&Ë6òô\n\u000b\u0003\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u0016%\u0014ø\u0010ö\u000e\bÞ\u0017\röÿ\u0006\u0015\u0000\u0003ö\f\tÐ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u00162\u0003Ú(\u0006ö\u0002\u000e\n\u0001\u0012Ø(þ\u000eøû\u000eØ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002\u0001\u0012Õ&\u0006ü\u0011Ô(\f\u0001\u0012Ò/ø\u0004á!\u0005\b\u0000â(\f\u0001\u0012Ò!\u0005\b\u0000â(\f8\u0000\u0016ðÑ8\u0000\u0016ðÑú\u0018îÐ>\tÂ\u001b&\u0006üú\u0018îÐ>\tÂIü\u0006÷\b\fú\u0018îÐAø\u0010üÊ()ý\u0004ô\u000b\u0001\u0012ß%\u0000\u0004ø\u0010\u0005\b\u000fø\u0004ý\u0007\u0001\u0005\b\u0000\u0010ù\u0011\u0000ýþÍD\u0007¾\u00176÷\u0006ûÃ5ò\u0010\u0004ù\t\u0002ô\n\u0017í\b\t\u0001\u0010ì\u001eú\u000eôî\tí\u000bú\u0018îÐ>\tÂ\u001e\tù6î\u0005\u000e\u0007ø\t\u0002\u0015\u0000\u0003ö\f\tã\u0018\u0007ûë\u001f\u0006\u0003\u0000\rú\u0018îÐ>\tÂ\u001b&\u0006üí)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\f\u0006\u0007õî\u0006ð\u000b5\u0015\u0003õ\u0012\u0002¿7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ5\u0004\u0004\u0003Ó\u00022\u0003Ö\u00070Ï\u000bý\b.Í\u0001\u0012á\u0016\u0011ÿ\t\u0000ô\u0005ú\u0018îÐCú\u0012½*\u0000ý\u0001\u0012ß\u0014\u0016÷ú\u0018îÐ>\tÂ\u00176ô\u0003\u0002\u0010ö\u0002è(\u0005\b\u0002â$\u0001öÿ\u000fú\u0018îÐ>\tÂ\u001e(\u0005\b\u0002â$\u0001öÿ\u000fú\u0018îÐ>\tÂ\u0019 \u0016ðë(\u0005\b\u0002â$\u0001öÿ\u000föÿ\u0006å2ú\u0003\u0010ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÓ(\u0005\b\u0002â$\u0001öÿ\u000f\u0014\u0003ò\u001bí\u000f\u0004\f\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010¿>\b\tô\u0010ÿö\u000eÅ\u0016\b(ÉBæô\n\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010¿>\b\tô\u0010ÿö\u000eÅ\u0016\b&Ë6òô\n\u000b\u0003\u0001\u0012Ü\u001b\u0002\bû\u0016ø\t\u0002ã\u001a\u0012\u0006û\u0006üû\u0001\nöÿ\u0006õ\u0012á\u0016ÿ\u0006î\"\u0001\u0010î\u0007ï\u000bþú\u000eô\u0001\u0012Õ\u0001ú\u0018îÐ>\tÂ\u001b&\u0006üâ$\u0011ó\u0012ú\n\u0007þ\u0006\tøø\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0019$\u0016Ñ&\u0006ü\u0006õ\u0006ã$\u0016\u0001\u0012Ð$\u0014ÿ\u0000\f\u0002ôî\u0014\u0016÷\u0004\nü\u0012ô\u0001\u0012Ò,ø\u0015\u0003Ü&õ\u0006\u0004\u0010ú\u0018îÐJ\u0002ø\u0006ÅOò\nÁ/\u0012\nÜ(\u0005\b\u0002â$\u0001öÿ\u000f\u0001\u0012Ý\u001a\u0016ÿÔ,\t\u0001\nú\u0018îÐJ\u0002ø\u0006ÅOò\nÁ/\u0012\nØ,\t\u0001\n\u0001\u0012â\u0019\u0014îú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÙ)\u0002ÿ\b\u0002â$\u0001öÿ\u000fþÖ:þôß4\u0003ò\u001bú\u0018îÐ>\tÂ\u0018,\u0006\u0007õÿ\u0004\rü\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u001e(â\u001b\u000b\u0005\u0006\nÎ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010ú\u0018îÐCþ\tÂ\u0017:þôà6ô\u0003\u0002\u0010ú\u0018îÐAø\u0010üÊ\u0018,ø\u0015\u0003Ü&õ\u0006\u0004\u0010þò\u0012\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0017\"\u0015õâ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010ô\u0016÷ç \r\u0004ö\u0016ø\u0010òê ü\u0013ò\u0014\nÎ(\fö\u0001\u0014þ\u0006úÿ\u0011ö\u0016ø\u0010òê ü\u0013ò\u0014\nÚ\u0014\u0016÷à*ü\u000bû\f\t\u0002\u0001\u0012Ò/\u0001\u0006\u0002\u0002ú\f\tã(úøî\u000bë\u000b\u0006õ\u0006â,ø\u0015\u0003\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b&Ë:îô\nÜH5\u0015\u0003õ\u0012\u0002¿7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\b2Ó\u0003\u00072þ\u0004Ô\u0004\b\u0001\u00031Ñ\u00070Ìî\nì\u000bI\u0004´Iþ\u000e\u0003ù\u0002\u0005\u000b\u000b°Oü\u0004\u0011¸\u0001\u0012á\u0016\u0014ò\f\nó\bþ&ñ\u0016\u0014ò\f\nóâ \u0016ð".getBytes("ISO-8859-1"), 0, bArr2, 0, 1166);
            $$a = bArr2;
            i2 = 66;
        }
        $$b = i2;
        int i5 = $10 + 37;
        $11 = i5 % 128;
        int i6 = i5 % 2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(35:17|(35:19|20|21|(0)(0)|(0)|943|(0)(0)|30|(0)|939|(0)(0)|36|(0)|(0)(0)|(0)|58|59|60|61|(0)(0)|64|(0)(0)|(0)|929|71|72|(0)(0)|75|76|(0)(0)|(0)(0)|81|82|83|(4:(0)(0)|86|(0)(0)|100))|947|(0)(0)|(0)|943|(0)(0)|30|(0)|939|(0)(0)|36|(0)|(0)(0)|(0)|58|59|60|61|(0)(0)|64|(0)(0)|(0)|929|71|72|(0)(0)|75|76|(0)(0)|(0)(0)|81|82|83|(4:(0)(0)|86|(0)(0)|100)) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x067c, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x01d6, code lost:
        if (r4 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:539:0x18b7, code lost:
        r2 = com.appsflyer.internal.AFi1hSDK.$$b;
        r5 = com.appsflyer.internal.AFi1hSDK.$$a;
        java.lang.Class.forName($$c(r5[216(0xd8, float:3.03E-43)], r5[205(0xcd, float:2.87E-43)], (short) 500)).getMethod($$c((byte) (r2 | 16), (byte) (-r5[395(0x18b, float:5.54E-43)]), (short) ((r2 ^ 413) | (r2 & 413))), new java.lang.Class[0]).invoke(r8.getMethod($$c((byte) (r2 + 4), r5[724(0x2d4, float:1.015E-42)], (short) androidx.constraintlayout.core.motion.utils.TypedValues.PositionType.TYPE_PERCENT_HEIGHT), new java.lang.Class[0]).invoke(r4, new java.lang.Object[0]), new java.lang.Object[0]);
        r8.getMethod($$c((byte) r2, r5[724(0x2d4, float:1.015E-42)], (short) 799), new java.lang.Class[0]).invoke(r4, new java.lang.Object[0]);
        r3 = r5[422(0x1a6, float:5.91E-43)];
        r7 = r5[205(0xcd, float:2.87E-43)];
        r4 = (int) java.lang.System.currentTimeMillis();
        r8 = (399 - (~(r7 * 399))) - 1;
        r10 = ~(((-2) ^ r7) | ((-2) & r7));
        r12 = ~r7;
        r11 = (r7 & 0) | (r12 & (-1));
        r13 = (r11 ^ 1) | (r11 & 1);
        r10 = r10 | ((r13 & 0) | ((~r13) & (-1)));
        r12 = (r12 & r4) | (r12 ^ r4);
        r12 = ((~r12) & (-1)) | (r12 & 0);
        r10 = ((r10 & r12) | (r10 ^ r12)) * 398;
        r12 = ((r8 | r10) << 1) - (r8 ^ r10);
        r8 = ((r7 ^ 1) | (r7 & 1)) * (-1194);
        r10 = (r12 & r8) + (r8 | r12);
        r4 = ~(((r4 | (-1)) & (~(r4 & (-1)))) | r11);
        r8 = ((-2) ^ r7) | ((-2) & r7);
        r8 = ((~r8) & (-1)) | (r8 & 0);
        r4 = (r4 & r8) | (r4 ^ r8);
        r7 = ((r7 | (-1)) & (~(r7 & (-1)))) | 1;
        r7 = ((~r7) & (-1)) | (r7 & 0);
        r4 = ((r4 & r7) | (r4 ^ r7)) * 398;
        r4 = (byte) ((r10 ^ r4) + ((r4 & r10) << 1));
        r3 = java.lang.Class.forName($$c(r3, r4, (short) ((r4 ^ 448) | (r4 & 448))));
        r4 = $$c((byte) ((r2 ^ 9) | (r2 & 9)), r5[426(0x1aa, float:5.97E-43)], (short) 456);
     */
    /* JADX WARN: Code restructure failed: missing block: B:541:0x19c6, code lost:
        r8 = new java.lang.Class[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:542:0x19c8, code lost:
        r8[0] = java.lang.String.class;
        r8[1] = java.lang.String.class;
        r8[2] = java.lang.Integer.TYPE;
        r3 = r3.getDeclaredMethod(r4, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:0x19dc, code lost:
        r7 = new java.lang.Object[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:546:0x19e0, code lost:
        r4 = java.lang.Class.forName($$c(r5[216(0xd8, float:3.03E-43)], r5[83], r14));
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x19f4, code lost:
        r8 = (int) java.lang.System.currentTimeMillis();
        r10 = (1208 - (~(-(-(r2 * androidx.constraintlayout.core.motion.utils.TypedValues.MotionType.TYPE_EASING))))) - 1;
        r11 = (r8 & 0) | ((~r8) & (-1));
        r12 = ((-5) ^ r11) | ((-5) & r11);
        r12 = -(-((((r12 & 0) | ((~r12) & (-1))) | r2) * (-602)));
        r13 = ((r10 | r12) << 1) - (r10 ^ r12);
        r10 = (-5) | ((~(r2 & (-1))) & (r2 | (-1)));
        r10 = (r10 | (-1)) & (~(r10 & (-1)));
        r12 = ((-5) ^ r8) | ((-5) & r8);
        r12 = (r12 & 0) | ((~r12) & (-1));
        r10 = (r10 ^ r12) | (r10 & r12);
        r11 = (r11 & 4) | (r11 ^ 4);
        r11 = (r11 & r2) | (r11 ^ r2);
        r11 = (r11 | (-1)) & (~(r11 & (-1)));
        r13 = (r13 - (~(-(-(((r10 & r11) | (r10 ^ r11)) * (-301)))))) - 1;
        r8 = ((r8 | (-1)) & (~(r8 & (-1)))) | r2;
        r8 = ((r8 | (-1)) & (~(r8 & (-1)))) * 301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x1a8f, code lost:
        r7[0] = r4.getMethod($$c((byte) (((r13 | r8) << 1) - (r8 ^ r13)), r5[637(0x27d, float:8.93E-43)], (short) ((r2 ^ 384) | (r2 & 384))), null).invoke(r6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:554:0x1ac1, code lost:
        r7[1] = java.lang.Class.forName($$c(r5[216(0xd8, float:3.03E-43)], r5[83], r14)).getMethod($$c((byte) ((r2 + 5) - 1), r5[637(0x27d, float:8.93E-43)], (short) ((r2 ^ 384) | (r2 & 384))), null).invoke(r1, null);
        r7[2] = 0;
        r3 = r3.invoke(null, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:555:0x1acf, code lost:
        r4 = com.appsflyer.internal.AFi1hSDK.$11;
        r7 = ((r4 | 89) << 1) - (r4 ^ 89);
        com.appsflyer.internal.AFi1hSDK.$10 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:556:0x1ae0, code lost:
        r10 = (short) 436;
        ((java.lang.Boolean) java.lang.Class.forName($$c(r5[216(0xd8, float:3.03E-43)], r5[83], r14)).getMethod($$c(r5[422(0x1a6, float:5.91E-43)], (byte) (-r5[156(0x9c, float:2.19E-43)]), r10), null).invoke(r6, null)).booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:558:0x1b12, code lost:
        ((java.lang.Boolean) java.lang.Class.forName($$c(r5[216(0xd8, float:3.03E-43)], r5[83], r14)).getMethod($$c(r5[422(0x1a6, float:5.91E-43)], (byte) (-r5[156(0x9c, float:2.19E-43)]), r10), null).invoke(r1, null)).booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:559:0x1b3f, code lost:
        r1 = com.appsflyer.internal.AFi1hSDK.$10 + 73;
        com.appsflyer.internal.AFi1hSDK.$11 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:560:0x1b49, code lost:
        if ((r1 % 2) == 0) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x1b4d, code lost:
        if (com.appsflyer.internal.AFi1hSDK.e != null) goto L555;
     */
    /* JADX WARN: Code restructure failed: missing block: B:563:0x1b4f, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:564:0x1b51, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:565:0x1b52, code lost:
        if (r1 == false) goto L552;
     */
    /* JADX WARN: Code restructure failed: missing block: B:568:0x1b57, code lost:
        r5 = (byte) (-r5[763(0x2fb, float:1.069E-42)]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x1b7a, code lost:
        com.appsflyer.internal.AFi1hSDK.e = java.lang.Class.class.getMethod($$c((byte) (((r2 | 4) << 1) - (r2 ^ 4)), r5, (short) ((r5 ^ 396) | (r5 & 396))), null).invoke(com.appsflyer.internal.AFi1hSDK.class, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:570:0x1b7c, code lost:
        r2 = r3;
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:657:0x1fd8, code lost:
        r8 = r47;
        r15 = r54;
        r1 = r46.getDeclaredConstructor(java.lang.Object.class, java.lang.Boolean.TYPE);
        r1.setAccessible(true);
        r5 = new java.lang.Object[2];
        r5[0] = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:658:0x1ff8, code lost:
        if (r42 != false) goto L300;
     */
    /* JADX WARN: Code restructure failed: missing block: B:659:0x1ffa, code lost:
        r2 = (com.appsflyer.internal.AFi1hSDK.$11 + 88) - 1;
        com.appsflyer.internal.AFi1hSDK.$10 = r2 % 128;
        r2 = r2 % 2;
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:660:0x2007, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:661:0x2008, code lost:
        r5[1] = java.lang.Boolean.valueOf(r2);
        com.appsflyer.internal.AFi1hSDK.i = r1.newInstance(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:662:0x2015, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:663:0x2018, code lost:
        r8 = r53;
        r1 = 216;
        r4 = 7;
        r7 = true;
        r29 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:664:0x2027, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:665:0x2028, code lost:
        r1 = r0;
        r8 = r53;
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:674:0x204c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:675:0x204d, code lost:
        r1 = r0;
        r16 = r47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:677:0x2063, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:698:0x20ab, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:699:0x20ac, code lost:
        r53 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:700:0x20b5, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:702:0x20c1, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:704:0x20ce, code lost:
        r2 = r0;
        r3 = r2.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:705:0x20d3, code lost:
        if (r3 != null) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:706:0x20d5, code lost:
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:707:0x20d6, code lost:
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:710:0x20dc, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:711:0x20dd, code lost:
        r53 = r14;
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:712:0x20ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:713:0x20eb, code lost:
        r53 = r14;
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:717:0x2106, code lost:
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:889:0x2470, code lost:
        r1 = new java.lang.StringBuilder();
        r3 = com.appsflyer.internal.AFi1hSDK.$$a;
        r7 = (short) 856;
     */
    /* JADX WARN: Code restructure failed: missing block: B:892:0x24d5, code lost:
        throw ((java.lang.Throwable) java.lang.Class.forName($$c(r3[216(0xd8, float:3.03E-43)], r3[288(0x120, float:4.04E-43)], r7)).getDeclaredConstructor(java.lang.String.class).newInstance(r1.append($$c(r3[348(0x15c, float:4.88E-43)], r3[724(0x2d4, float:1.015E-42)], (short) 860)).append(r10).append($$c(r3[41], r3[401(0x191, float:5.62E-43)], r7)).toString()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:927:0x259f, code lost:
        r1 = r15[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:929:0x25a6, code lost:
        throw null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:1085:0x1e59 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1107:0x0363 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:1130:0x2518 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1132:0x25aa A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1144:0x2515 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x068a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0b9f A[Catch: all -> 0x23df, TryCatch #95 {all -> 0x23df, blocks: (B:177:0x083e, B:180:0x084b, B:182:0x0857, B:184:0x08ba, B:186:0x08d0, B:183:0x08b5, B:185:0x08c1, B:187:0x08da, B:228:0x0a86, B:230:0x0a8d, B:231:0x0a8e, B:280:0x0bc7, B:289:0x0c42, B:271:0x0b8e, B:273:0x0b9f, B:274:0x0ba0, B:250:0x0b12, B:219:0x0a53, B:206:0x0959, B:215:0x09b4, B:190:0x08ec), top: B:1031:0x083e, inners: #82 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0ba0 A[Catch: all -> 0x23df, TryCatch #95 {all -> 0x23df, blocks: (B:177:0x083e, B:180:0x084b, B:182:0x0857, B:184:0x08ba, B:186:0x08d0, B:183:0x08b5, B:185:0x08c1, B:187:0x08da, B:228:0x0a86, B:230:0x0a8d, B:231:0x0a8e, B:280:0x0bc7, B:289:0x0c42, B:271:0x0b8e, B:273:0x0b9f, B:274:0x0ba0, B:250:0x0b12, B:219:0x0a53, B:206:0x0959, B:215:0x09b4, B:190:0x08ec), top: B:1031:0x083e, inners: #82 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:607:0x1e50  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x1e53  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0478 A[Catch: Exception -> 0x25c9, TRY_ENTER, TRY_LEAVE, TryCatch #47 {Exception -> 0x25c9, blocks: (B:8:0x0188, B:10:0x0196, B:50:0x040c, B:57:0x0472, B:67:0x053b, B:77:0x0595, B:78:0x0604, B:92:0x0655, B:96:0x065e, B:105:0x0679, B:118:0x069d, B:926:0x2583, B:908:0x2505, B:914:0x2518, B:924:0x2577, B:911:0x250b, B:927:0x259f, B:929:0x25a6, B:62:0x0478, B:916:0x2539, B:917:0x256c, B:69:0x054e, B:64:0x0511, B:63:0x048d, B:52:0x043b), top: B:971:0x0188 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0539 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:777:0x228c A[Catch: all -> 0x238e, TryCatch #52 {all -> 0x238e, blocks: (B:759:0x226a, B:764:0x2270, B:766:0x2277, B:767:0x2278, B:775:0x2285, B:777:0x228c, B:778:0x228d, B:791:0x22c2, B:793:0x22cf, B:794:0x22d0, B:802:0x22e7, B:804:0x22f4, B:805:0x22f5, B:813:0x230a, B:815:0x2317, B:816:0x2318, B:830:0x234e, B:832:0x235c, B:833:0x235d, B:301:0x0d3e, B:295:0x0ccd, B:293:0x0c90), top: B:977:0x0d3e }] */
    /* JADX WARN: Removed duplicated region for block: B:778:0x228d A[Catch: all -> 0x238e, TryCatch #52 {all -> 0x238e, blocks: (B:759:0x226a, B:764:0x2270, B:766:0x2277, B:767:0x2278, B:775:0x2285, B:777:0x228c, B:778:0x228d, B:791:0x22c2, B:793:0x22cf, B:794:0x22d0, B:802:0x22e7, B:804:0x22f4, B:805:0x22f5, B:813:0x230a, B:815:0x2317, B:816:0x2318, B:830:0x234e, B:832:0x235c, B:833:0x235d, B:301:0x0d3e, B:295:0x0ccd, B:293:0x0c90), top: B:977:0x0d3e }] */
    /* JADX WARN: Removed duplicated region for block: B:815:0x2317 A[Catch: all -> 0x238e, TryCatch #52 {all -> 0x238e, blocks: (B:759:0x226a, B:764:0x2270, B:766:0x2277, B:767:0x2278, B:775:0x2285, B:777:0x228c, B:778:0x228d, B:791:0x22c2, B:793:0x22cf, B:794:0x22d0, B:802:0x22e7, B:804:0x22f4, B:805:0x22f5, B:813:0x230a, B:815:0x2317, B:816:0x2318, B:830:0x234e, B:832:0x235c, B:833:0x235d, B:301:0x0d3e, B:295:0x0ccd, B:293:0x0c90), top: B:977:0x0d3e }] */
    /* JADX WARN: Removed duplicated region for block: B:816:0x2318 A[Catch: all -> 0x238e, TryCatch #52 {all -> 0x238e, blocks: (B:759:0x226a, B:764:0x2270, B:766:0x2277, B:767:0x2278, B:775:0x2285, B:777:0x228c, B:778:0x228d, B:791:0x22c2, B:793:0x22cf, B:794:0x22d0, B:802:0x22e7, B:804:0x22f4, B:805:0x22f5, B:813:0x230a, B:815:0x2317, B:816:0x2318, B:830:0x234e, B:832:0x235c, B:833:0x235d, B:301:0x0d3e, B:295:0x0ccd, B:293:0x0c90), top: B:977:0x0d3e }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:886:0x2457 A[Catch: all -> 0x24e0, TryCatch #98 {all -> 0x24e0, blocks: (B:857:0x23a9, B:862:0x23bc, B:864:0x23c7, B:865:0x23c8, B:889:0x2470, B:884:0x244c, B:886:0x2457, B:887:0x2458, B:852:0x23a0, B:282:0x0be0, B:891:0x24ac, B:892:0x24d5), top: B:1036:0x0be0 }] */
    /* JADX WARN: Removed duplicated region for block: B:887:0x2458 A[Catch: all -> 0x24e0, TryCatch #98 {all -> 0x24e0, blocks: (B:857:0x23a9, B:862:0x23bc, B:864:0x23c7, B:865:0x23c8, B:889:0x2470, B:884:0x244c, B:886:0x2457, B:887:0x2458, B:852:0x23a0, B:282:0x0be0, B:891:0x24ac, B:892:0x24d5), top: B:1036:0x0be0 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:908:0x2505 A[Catch: Exception -> 0x25c9, TRY_ENTER, TryCatch #47 {Exception -> 0x25c9, blocks: (B:8:0x0188, B:10:0x0196, B:50:0x040c, B:57:0x0472, B:67:0x053b, B:77:0x0595, B:78:0x0604, B:92:0x0655, B:96:0x065e, B:105:0x0679, B:118:0x069d, B:926:0x2583, B:908:0x2505, B:914:0x2518, B:924:0x2577, B:911:0x250b, B:927:0x259f, B:929:0x25a6, B:62:0x0478, B:916:0x2539, B:917:0x256c, B:69:0x054e, B:64:0x0511, B:63:0x048d, B:52:0x043b), top: B:971:0x0188 }] */
    /* JADX WARN: Removed duplicated region for block: B:924:0x2577 A[Catch: Exception -> 0x25c9, TryCatch #47 {Exception -> 0x25c9, blocks: (B:8:0x0188, B:10:0x0196, B:50:0x040c, B:57:0x0472, B:67:0x053b, B:77:0x0595, B:78:0x0604, B:92:0x0655, B:96:0x065e, B:105:0x0679, B:118:0x069d, B:926:0x2583, B:908:0x2505, B:914:0x2518, B:924:0x2577, B:911:0x250b, B:927:0x259f, B:929:0x25a6, B:62:0x0478, B:916:0x2539, B:917:0x256c, B:69:0x054e, B:64:0x0511, B:63:0x048d, B:52:0x043b), top: B:971:0x0188 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:976:0x1fd8 A[EDGE_INSN: B:976:0x1fd8->B:657:0x1fd8 ?: BREAK  , EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0664  */
    /* JADX WARN: Type inference failed for: r10v231, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r10v261, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v51 */
    /* JADX WARN: Type inference failed for: r16v56 */
    /* JADX WARN: Type inference failed for: r2v160, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r2v74, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v120, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v261, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v79, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r6v211, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r6v342, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r7v149, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r7v267, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r8v211, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r8v289 */
    /* JADX WARN: Type inference failed for: r8v291 */
    /* JADX WARN: Type inference failed for: r8v346 */
    /* JADX WARN: Type inference failed for: r8v512 */
    static {
        /*
            Method dump skipped, instructions count: 9691
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFi1hSDK.<clinit>():void");
    }

    public static int getCurrencyIso4217Code(int i2) {
        Object obj;
        int i3 = $11;
        int i4 = (i3 + 74) - 1;
        $10 = i4 % 128;
        if ((i4 % 2 != 0 ? 'E' : '\b') != 'E') {
            obj = i;
        } else {
            obj = i;
            int i5 = 67 / 0;
        }
        int i6 = (i3 + 96) - 1;
        $10 = i6 % 128;
        int i7 = i6 % 2;
        try {
            Object[] objArr = {Integer.valueOf(i2)};
            int i8 = $$b;
            byte[] bArr = $$a;
            int intValue = ((Integer) Class.forName($$c((byte) i8, bArr[4], (short) (i8 | 512)), true, (ClassLoader) e).getMethod($$c(bArr[487], bArr[637], bArr[7]), Integer.TYPE).invoke(obj, objArr)).intValue();
            int i9 = $10 + 25;
            $11 = i9 % 128;
            if (!(i9 % 2 == 0)) {
                return intValue;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static int getCurrencyIso4217Code(Object obj) {
        int currentTimeMillis = (int) System.currentTimeMillis();
        int i2 = 747647782 | currentTimeMillis;
        int i3 = ((~i2) & (-1)) | (i2 & 0);
        int i4 = 623479136 + (((i3 & 289751169) | (289751169 ^ i3)) * 104);
        int i5 = (currentTimeMillis & 0) | ((~currentTimeMillis) & (-1)) | 366306183;
        int i6 = (i5 & (-747647783)) | (i5 ^ (-747647783));
        int i7 = (((~i6) & (-1)) | (i6 & 0)) * (-104);
        int i8 = (i4 & i7) + (i7 | i4);
        int i9 = -(-(((currentTimeMillis & 366306183) | (366306183 ^ currentTimeMillis)) * 104));
        int i10 = (i8 & i9) + (i9 | i8);
        int currentTimeMillis2 = (int) System.currentTimeMillis();
        int i11 = (~(currentTimeMillis2 & (-1))) & (currentTimeMillis2 | (-1));
        int i12 = (i11 & 1554732311) | (1554732311 ^ i11);
        int i13 = ((~i12) & (-1)) | (i12 & 0);
        int i14 = ((-851128400) - (~(((i13 & 258502315) | (258502315 ^ i13)) * 226))) - 1;
        int i15 = ((-258502316) & currentTimeMillis2) | ((-258502316) ^ currentTimeMillis2);
        int i16 = (i15 | (-1)) & (~(i15 & (-1)));
        int i17 = (i16 & 203965443) | (203965443 ^ i16);
        int i18 = (currentTimeMillis2 & 0) | ((~currentTimeMillis2) & (-1));
        int i19 = (i18 & 1554732311) | (1554732311 ^ i18);
        int i20 = ~((258502315 & i19) | (i19 ^ 258502315));
        int i21 = ((i20 & i17) | (i17 ^ i20)) * (-113);
        int i22 = (currentTimeMillis2 & 1554732311) | (1554732311 ^ currentTimeMillis2);
        int i23 = (i14 ^ i21) + ((i21 & i14) << 1) + ((((~i22) & (-1)) | (i22 & 0)) * 113);
        Object obj2 = i;
        int i24 = ($10 + 66) - 1;
        $11 = i24 % 128;
        int i25 = i24 % 2;
        try {
            Object[] objArr = {obj};
            int i26 = $$b;
            byte[] bArr = $$a;
            int intValue = ((Integer) Class.forName($$c((byte) i26, bArr[4], (short) (i26 | 512)), true, (ClassLoader) e).getMethod($$c(bArr[487], bArr[637], bArr[7]), Object.class).invoke(obj2, objArr)).intValue();
            int i27 = ($10 + 56) - 1;
            $11 = i27 % 128;
            if (i27 % 2 == 0) {
                Object obj3 = null;
                obj3.hashCode();
                throw null;
            }
            return intValue;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static Object getCurrencyIso4217Code(char c, int i2, int i3) {
        int i4 = $10 + 107;
        int i5 = i4 % 128;
        $11 = i5;
        int i6 = i4 % 2;
        Object obj = i;
        int i7 = (i5 & 71) + (i5 | 71);
        int i8 = i7 % 128;
        $10 = i8;
        int i9 = i7 % 2;
        int i10 = i8 + 71;
        $11 = i10 % 128;
        int i11 = i10 % 2;
        try {
            Object[] objArr = {Character.valueOf(c), Integer.valueOf(i2), Integer.valueOf(i3)};
            int i12 = $$b;
            byte[] bArr = $$a;
            Object invoke = Class.forName($$c((byte) i12, bArr[4], (short) (i12 | 512)), true, (ClassLoader) e).getMethod($$c((byte) ((i12 + 5) - 1), (byte) (-bArr[815]), bArr[35]), Character.TYPE, Integer.TYPE, Integer.TYPE).invoke(obj, objArr);
            int i13 = $11 + 119;
            $10 = i13 % 128;
            if (i13 % 2 == 0) {
                return invoke;
            }
            throw null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private AFi1hSDK() {
    }

    private static void getMediationNetwork(int i2, int i3) {
        int i4 = $10 + 121;
        $11 = i4 % 128;
        int i5 = i4 % 2;
    }
}
