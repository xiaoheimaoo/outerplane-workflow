package com.appsflyer.internal;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Map;
/* loaded from: classes.dex */
public class AFa1jSDK {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10 = 0;
    private static int $11 = 1;
    private static int $12 = 0;
    private static int $13 = 1;
    public static final Map AFInAppEventType;
    private static long afDebugLog;
    private static int afErrorLog;
    private static byte[] afErrorLogForExcManagerOnly;
    private static int afInfoLog;
    private static int afRDLog;
    private static int afWarnLog;
    private static byte[] d;
    private static byte[] e;
    private static long force;
    private static Object i;
    public static final Map unregisterClient;
    private static long v;
    private static Object w;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        if ((r0 == null) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        if ((r0 == null ? 'b' : 'A') != 'A') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        r5 = 0;
        r4 = r3;
        r3 = r0;
        r0 = r10;
        r10 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0056 -> B:20:0x0040). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String $$c(short r8, short r9, int r10) {
        /*
            int r0 = com.appsflyer.internal.AFa1jSDK.$13
            int r0 = r0 + 57
            int r1 = r0 % 128
            com.appsflyer.internal.AFa1jSDK.$12 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = r1
            goto L11
        L10:
            r0 = r2
        L11:
            if (r0 == r2) goto L27
            int r8 = 13 - r8
            int r10 = r10 + 4
            int r9 = r9 + 68
            byte[] r0 = com.appsflyer.internal.AFa1jSDK.$$a
            byte[] r3 = new byte[r9]
            if (r0 != 0) goto L21
            r4 = r2
            goto L22
        L21:
            r4 = r1
        L22:
            if (r4 == 0) goto L25
            goto L3a
        L25:
            r4 = r1
            goto L40
        L27:
            int r8 = 119 - r8
            int r10 = r10 + 4
            int r9 = r9 + r2
            byte[] r0 = com.appsflyer.internal.AFa1jSDK.$$a
            byte[] r3 = new byte[r9]
            r4 = 65
            if (r0 != 0) goto L37
            r5 = 98
            goto L38
        L37:
            r5 = r4
        L38:
            if (r5 == r4) goto L25
        L3a:
            r5 = r1
            r4 = r3
            r3 = r0
            r0 = r10
            r10 = r9
            goto L56
        L40:
            int r5 = r4 + 1
            byte r6 = (byte) r8
            r3[r4] = r6
            int r10 = r10 + r2
            if (r5 != r9) goto L4e
            java.lang.String r8 = new java.lang.String
            r8.<init>(r3, r1)
            return r8
        L4e:
            r4 = r0[r10]
            r7 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r0
            r0 = r7
        L56:
            int r8 = r8 + r9
            int r8 = r8 + (-3)
            int r9 = com.appsflyer.internal.AFa1jSDK.$12
            int r9 = r9 + 47
            int r6 = r9 % 128
            com.appsflyer.internal.AFa1jSDK.$13 = r6
            int r9 = r9 % 2
            r9 = r10
            r10 = r0
            r0 = r3
            r3 = r4
            r4 = r5
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1jSDK.$$c(short, short, int):java.lang.String");
    }

    static void init$0() {
        int i2 = ($10 + 86) - 1;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        byte[] bArr = new byte[1171];
        System.arraycopy("\bâ\u001cã\u0010ù\u0011\u0000ýþÍ<\u000eò\u0012û\u0004ý\u0013¾\u0018/\u0000\u0006\u0006ö\u0002\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001eÓ5óô\n\u000b\u0003\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u0016%\u0014ø\u0010ö\u000e\bÞ\u0017\röÿ\u0006\u0015\u0000\u0003ö\f\tÐ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002\u0010ù\u0011\u0000ýþÍ6\u0012\u0003Á\u00162\u0003Ú(\u0006ö\u0002\u000e\n\u0001\u0012Ø(þ\u000eøû\u000eØ2\u0003ÿ\u0000ý\u0001\u0016ø\t\u0002\u0001\u0012Õ&\u0006ü\u0011Ô(\f\u0001\u0012Ò/ø\u0004á!\u0005\b\u0000â(\f\u0001\u0012Ò!\u0005\b\u0000â(\f8\u0000\u0016ðÑ8\u0000\u0016ðÑú\u0018îÐ>\tÂ\u001b&\u0006üú\u0018îÐ>\tÂIü\u0006÷\b\fú\u0018îÐAø\u0010üÊ()ý\u0004ô\u000b\u0001\u0012ß%\u0000\u0004ø\u0010\u0005\b\u000fø\u0004ý\u0007\u0001\u0005\b\u0000\u0010ù\u0011\u0000ýþÍD\u0007¾\u00176÷\u0006ûÃ5ò\u0010\u0004ù\t\u0002ô\n\u0017í\b\t\u0001\u0010ì\u001eú\u000eôî\tí\u000bú\u0018îÐ>\tÂ\u001e\tù6î\u0005\u000e\u0007ø\t\u0002\u0015\u0000\u0003ö\f\tã\u0018\u0007ûë\u001f\u0006\u0003\u0000\rú\u0018îÐ>\tÂ\u001b&\u0006üí)\u0002ÿ\b\u0002â$\u0001öÿ\u000f\f\u0006\u0007õî\u0006ð\u000b5\u0015\u0003õ\u0012\u0002¿7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u00057\u0004Ñ5Î\u00025Ú+\u0006\u0005\u0001\u0000\u0006Ø+Ï\u0001\u0012á\u0016\u0011ÿ\t\u0000ô\u0005ú\u0018îÐCú\u0012½*\u0000ý\u0001\u0012ß\u0014\u0016÷ú\u0018îÐ>\tÂ\u00176ô\u0003\u0002\u0010ö\u0002è(\u0005\b\u0002â$\u0001öÿ\u000fú\u0018îÐ>\tÂ\u001e(\u0005\b\u0002â$\u0001öÿ\u000fú\u0018îÐ>\tÂ\u0019 \u0016ðë(\u0005\b\u0002â$\u0001öÿ\u000föÿ\u0006å2ú\u0003\u0010ú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÓ(\u0005\b\u0002â$\u0001öÿ\u000f\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010¿>\b\tô\u0010ÿö\u000eÅ\u0016\b(É?éô\n\u000f\u0001Ä6\u0012\u0003\u0006ö\t\u0010ï\u0010¿>\b\tô\u0010ÿö\u000eÅ\u0016\b\u001eÓ5óô\n\u000b\u0003\u0001\u0012Ü\u001b\u0002\bû\u0016ø\t\u0002ã\u001a\u0012\u0006û\u0006üû\u0001\nöÿ\u0006õ\u0012á\u0016ÿ\u0006î\"\u0001\u0010î\u0007ï\u000bþú\u000eô\u0001\u0012Õ\u0001ú\u0018îÐ>\tÂ\u001b&\u0006üâ$\u0011ó\u0012ú\n\u0007þ\u0006\tøø\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0019$\u0016Ñ&\u0006ü\u0006õ\u0006ã$\u0016\u0001\u0012Ð$\u0014ÿ\u0000\f\u0002ôî\u0014\u0016÷\u0004\nü\u0012ô\u0001\u0012Ò,ø\u0015\u0003Ü&õ\u0006\u0004\u0010ú\u0018îÐJ\u0002ø\u0006ÅOò\nÁ/\u0012\nÜ(\u0005\b\u0002â$\u0001öÿ\u000f\u0001\u0012Ý\u001a\u0016ÿÔ,\t\u0001\nú\u0018îÐJ\u0002ø\u0006ÅOò\nÁ/\u0012\nØ,\t\u0001\n\u0001\u0012â\u0019\u0014îú\u0018îÐ>\tÂ\u0017:þôß4\u0003ò\u001bÙ)\u0002ÿ\b\u0002â$\u0001öÿ\u000fþÖ:þôß4\u0003ò\u001bú\u0018îÐ>\tÂ\u0018,\u0006\u0007õÿ\u0004\rü\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u001e(â\u001b\u000b\u0005\u0006\nÎ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010ú\u0018îÐCþ\tÂ\u0017:þôà6ô\u0003\u0002\u0010ú\u0018îÐAø\u0010üÊ\u0018,ø\u0015\u0003Ü&õ\u0006\u0004\u0010þò\u0012\u0000\u000e\rö\u0005ÆH\tý\u0004ô\u000bÄ\u0017\"\u0015õâ$\u0016Î,ø\u0015\u0003Ü&õ\u0006\u0004\u0010ô\u0016÷ç \r\u0004ö\u0016ø\u0010òê ü\u0013ò\u0014\nÎ(\fö\u0001\u0014þ\u0006úÿ\u0011ö\u0016ø\u0010òê ü\u0013ò\u0014\nÚ\u0014\u0016÷à*ü\u000bû\f\t\u0002\u0001\u0012Ò/\u0001\u0006\u0002\u0002ú\f\tã(úøî\u000bë\u000b\u0006õ\u0006â,ø\u0015\u0003\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\u0015\b\u001eÓ<ìô\nÜH5\u0015\u0003õ\u0012\u0002¿7\u000f\u0001Å5\u0012\u0003\u0006ö\t\u0010ï\u0010À=\b\tô\u0010ÿö\u000eÆ\f\u00001\u0002\u0005\u0001Øý7Ð\u0005\u00007×-Ô1Îî\nì\u000bI\u0004´Iþ\u000e\u0003ù\u0002\u0005\u000b\u000b°Oü\u0004\u0011¸\u0001\u0012Ò5\u0000\u0003ö\fø\u0019Ó-ÿÈ\u0001\u0002\t\u000f/ø\u0004\bþ&ñ\u0016\u0014ò\f\nóâ \u0016ð".getBytes("ISO-8859-1"), 0, bArr, 0, 1171);
        $$a = bArr;
        $$b = 34;
        int i4 = $10 + 115;
        $11 = i4 % 128;
        if ((i4 % 2 == 0 ? 'I' : (char) 6) == 6) {
            return;
        }
        throw null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:638:0x1cba
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    static {
        /*
            Method dump skipped, instructions count: 9043
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1jSDK.<clinit>():void");
    }

    public static int getMediationNetwork(int i2) {
        int i3 = $11;
        int i4 = (i3 & 117) + (i3 | 117);
        int i5 = i4 % 128;
        $10 = i5;
        Object obj = null;
        if (!(i4 % 2 == 0)) {
            obj.hashCode();
            throw null;
        }
        Object obj2 = w;
        int i6 = i5 + 101;
        $11 = i6 % 128;
        int i7 = i6 % 2;
        try {
            Object[] objArr = {Integer.valueOf(i2)};
            byte[] bArr = $$a;
            byte b = bArr[488];
            Class<?> cls = Class.forName($$c(bArr[84], b, (short) ((b ^ Ascii.DC2) | (b & Ascii.DC2))), true, (ClassLoader) i);
            byte b2 = bArr[14];
            int intValue = ((Integer) cls.getMethod($$c(bArr[4], b2, (short) (b2 | SignedBytes.MAX_POWER_OF_TWO)), Integer.TYPE).invoke(obj2, objArr)).intValue();
            int i8 = ($10 + 78) - 1;
            $11 = i8 % 128;
            if (i8 % 2 != 0) {
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

    public static int getMonetizationNetwork(Object obj) {
        byte[] bArr;
        int i2 = $11;
        int i3 = (i2 & 7) + (i2 | 7);
        int i4 = i3 % 128;
        $10 = i4;
        if ((i3 % 2 != 0 ? '%' : '\'') == '%') {
            throw null;
        }
        Object obj2 = w;
        int i5 = (i4 & 71) + (i4 | 71);
        $11 = i5 % 128;
        int i6 = i5 % 2;
        try {
            Object[] objArr = {obj};
            byte b = $$a[488];
            int intValue = ((Integer) Class.forName($$c(bArr[84], b, (short) (b | Ascii.DC2)), true, (ClassLoader) i).getMethod($$c(bArr[62], bArr[12], (short) 1152), Object.class).invoke(obj2, objArr)).intValue();
            int currentTimeMillis = (int) System.currentTimeMillis();
            int i7 = (~(currentTimeMillis & (-1))) & (currentTimeMillis | (-1));
            int i8 = (i7 & (-1521606923)) | ((-1521606923) ^ i7);
            int i9 = ((~i8) & (-1)) | (i8 & 0);
            int i10 = ((~currentTimeMillis) & (-1)) | (currentTimeMillis & 0);
            int i11 = (i10 & (-864216280)) | ((-864216280) ^ i10);
            int i12 = 1550969792 + (((i9 & (-864216280)) | ((-864216280) ^ i9)) * (-933)) + ((((i11 | (-1)) & (~(i11 & (-1)))) | 553780437) * 933);
            int i13 = ((i12 | 693843616) << 1) - (693843616 ^ i12);
            int currentTimeMillis2 = (int) System.currentTimeMillis();
            int i14 = (~(((-214422119) & currentTimeMillis2) | ((-214422119) ^ currentTimeMillis2))) | 134664224;
            int i15 = ~currentTimeMillis2;
            int i16 = (i15 ^ 689370536) | (i15 & 689370536);
            int i17 = i16 | 214422118;
            int i18 = ((~i17) & (-1)) | (i17 & 0);
            int i19 = 1698234858 + (((i14 & i18) | (i14 ^ i18)) * 886);
            int i20 = (i15 & 214422118) | (i15 ^ 214422118);
            int i21 = (i20 | (-1)) & (~(i20 & (-1)));
            int i22 = ((i21 & 689370536) | (689370536 ^ i21)) * (-1772);
            int i23 = ((i19 | i22) << 1) - (i22 ^ i19);
            int i24 = -(-(((i16 & 0) | ((~i16) & (-1))) * 886));
            if (i13 > (i23 & i24) + (i24 | i23)) {
                int i25 = 0 / 0;
                return intValue;
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

    public static Object AFAdRevenueData(int i2, char c, int i3) {
        byte[] bArr;
        int i4 = $10;
        int i5 = (i4 & 115) + (i4 | 115);
        int i6 = i5 % 128;
        $11 = i6;
        if ((i5 % 2 == 0 ? '\f' : (char) 2) != 2) {
            throw null;
        }
        Object obj = w;
        int i7 = ((i6 | 113) << 1) - (i6 ^ 113);
        $10 = i7 % 128;
        int i8 = i7 % 2;
        try {
            Object[] objArr = {Integer.valueOf(i2), Character.valueOf(c), Integer.valueOf(i3)};
            byte b = $$a[488];
            Class<?> cls = Class.forName($$c(bArr[84], b, (short) ((b ^ Ascii.DC2) | (b & Ascii.DC2))), true, (ClassLoader) i);
            int i9 = $$b;
            Object invoke = cls.getMethod($$c(bArr[4], bArr[49], (short) ((i9 & 1097) | (i9 ^ 1097))), Integer.TYPE, Character.TYPE, Integer.TYPE).invoke(obj, objArr);
            int i10 = $11;
            int i11 = ((i10 | 81) << 1) - (i10 ^ 81);
            $10 = i11 % 128;
            int i12 = i11 % 2;
            return invoke;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private AFa1jSDK() {
    }

    private static void getMonetizationNetwork(int i2, int i3) {
        int i4 = $10;
        int i5 = (i4 & 55) + (i4 | 55);
        $11 = i5 % 128;
        if ((i5 % 2 == 0 ? 'E' : '^') == '^') {
            return;
        }
        throw null;
    }
}
