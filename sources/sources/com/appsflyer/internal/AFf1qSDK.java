package com.appsflyer.internal;

import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public final class AFf1qSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int AFAdRevenueData = 0;
    private static int areAllFieldsValid = 0;
    private static int component1 = 1;
    private static int getCurrencyIso4217Code;
    private static byte[] getMediationNetwork;
    private static short[] getMonetizationNetwork;
    private static int getRevenue;

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
        if (r8 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.appsflyer.internal.AFi1rSDK getRevenue(com.appsflyer.internal.AFi1wSDK r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            int r0 = com.appsflyer.internal.AFf1qSDK.areAllFieldsValid
            int r0 = r0 + 67
            int r1 = r0 % 128
            com.appsflyer.internal.AFf1qSDK.component1 = r1
            int r0 = r0 % 2
            r0 = 0
            r2 = 1
            if (r5 == 0) goto L10
            r3 = r0
            goto L11
        L10:
            r3 = r2
        L11:
            if (r3 == 0) goto L14
            goto L34
        L14:
            if (r7 == 0) goto L18
            r3 = r0
            goto L19
        L18:
            r3 = r2
        L19:
            if (r3 == r2) goto L34
            int r1 = r1 + 61
            int r3 = r1 % 128
            com.appsflyer.internal.AFf1qSDK.areAllFieldsValid = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L27
            r1 = r0
            goto L28
        L27:
            r1 = r2
        L28:
            if (r1 == 0) goto L2d
            if (r8 == 0) goto L34
            goto L35
        L2d:
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L32
            throw r5     // Catch: java.lang.Throwable -> L32
        L32:
            r5 = move-exception
            throw r5
        L34:
            r2 = r0
        L35:
            if (r2 != 0) goto L49
            com.appsflyer.internal.AFi1rSDK r5 = new com.appsflyer.internal.AFi1rSDK
            com.appsflyer.internal.AFi1uSDK r6 = com.appsflyer.internal.AFi1uSDK.INTERNAL_ERROR
            r5.<init>(r0, r6)
            int r6 = com.appsflyer.internal.AFf1qSDK.component1
            int r6 = r6 + 59
            int r7 = r6 % 128
            com.appsflyer.internal.AFf1qSDK.areAllFieldsValid = r7
            int r6 = r6 % 2
            return r5
        L49:
            com.appsflyer.internal.AFi1rSDK r5 = getCurrencyIso4217Code(r5, r6, r7, r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1qSDK.getRevenue(com.appsflyer.internal.AFi1wSDK, java.lang.String, java.lang.String, java.lang.String):com.appsflyer.internal.AFi1rSDK");
    }

    private static AFi1rSDK getCurrencyIso4217Code(AFi1wSDK aFi1wSDK, String str, String str2, String str3) {
        if (str == null) {
            return new AFi1rSDK(aFi1wSDK.getMediationNetwork == AFh1cSDK.DEFAULT, AFi1uSDK.NA);
        }
        String str4 = "";
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getKeyRepeatDelay() >> 16) + 1522762699, (byte) (-(ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), (short) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 107), (-82) - ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.indexOf((CharSequence) "", '0', 0, 0) - 1963671201, objArr);
        String intern = ((String) objArr[0]).intern();
        if (aFi1wSDK.getMediationNetwork == AFh1cSDK.CUSTOM) {
            str4 = new StringBuilder(str2).reverse().toString();
        } else {
            str3 = intern;
        }
        boolean equals = getMediationNetwork(new StringBuilder(str3).reverse().toString(), aFi1wSDK.getRevenue, "android", "v1", str4).equals(str);
        return new AFi1rSDK(equals, equals ? AFi1uSDK.SUCCESS : AFi1uSDK.FAILURE);
    }

    private static String getMediationNetwork(String str, String str2, String str3, String str4, String str5) {
        int i = areAllFieldsValid + 17;
        component1 = i % 128;
        int i2 = i % 2;
        String revenue = AFj1bSDK.getRevenue(TextUtils.join("\u2063", new String[]{str2, str3, str4, str5, ""}), str);
        if ((revenue.length() < 12 ? '$' : (char) 24) != '$') {
            return revenue.substring(0, 12);
        }
        int i3 = areAllFieldsValid + 109;
        component1 = i3 % 128;
        int i4 = i3 % 2;
        return revenue;
    }

    private static void a(int i, byte b, short s, int i2, int i3, Object[] objArr) {
        int i4;
        int i5;
        int i6;
        int length;
        byte[] bArr;
        int i7;
        AFk1kSDK aFk1kSDK = new AFk1kSDK();
        StringBuilder sb = new StringBuilder();
        int i8 = i2 + ((int) (AFAdRevenueData ^ 6918351348135370604L));
        boolean z = i8 == -1;
        if (z) {
            byte[] bArr2 = getMediationNetwork;
            if ((bArr2 != null ? '$' : Typography.amp) == '$') {
                int length2 = bArr2.length;
                byte[] bArr3 = new byte[length2];
                for (int i9 = 0; i9 < length2; i9++) {
                    int i10 = $11 + 69;
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                    bArr3[i9] = (byte) (bArr2[i9] ^ 6918351348135370604L);
                }
                bArr2 = bArr3;
            }
            if (bArr2 != null) {
                i8 = (byte) (((byte) (getMediationNetwork[((int) (getCurrencyIso4217Code ^ 6918351348135370604L)) + i] ^ 6918351348135370604L)) + ((int) (AFAdRevenueData ^ 6918351348135370604L)));
                int i12 = $11 + 91;
                $10 = i12 % 128;
                int i13 = i12 % 2;
            } else {
                i8 = (short) (((short) (getMonetizationNetwork[((int) (getCurrencyIso4217Code ^ 6918351348135370604L)) + i] ^ 6918351348135370604L)) + ((int) (AFAdRevenueData ^ 6918351348135370604L)));
            }
        }
        if (i8 > 0) {
            int i14 = ((i + i8) - 2) + ((int) (getCurrencyIso4217Code ^ 6918351348135370604L));
            if ((z ? 'Y' : 'R') != 'Y') {
                int i15 = $11 + 107;
                $10 = i15 % 128;
                int i16 = i15 % 2;
                i4 = 0;
            } else {
                i4 = 1;
            }
            aFk1kSDK.getCurrencyIso4217Code = i14 + i4;
            aFk1kSDK.getRevenue = (char) (i3 + ((int) (getRevenue ^ 6918351348135370604L)));
            sb.append(aFk1kSDK.getRevenue);
            aFk1kSDK.getMediationNetwork = aFk1kSDK.getRevenue;
            byte[] bArr4 = getMediationNetwork;
            if (bArr4 != null) {
                int i17 = $10 + 97;
                $11 = i17 % 128;
                if (i17 % 2 == 0) {
                    length = bArr4.length;
                    bArr = new byte[length];
                    i7 = 1;
                } else {
                    length = bArr4.length;
                    bArr = new byte[length];
                    i7 = 0;
                }
                while (true) {
                    if (i7 >= length) {
                        break;
                    }
                    bArr[i7] = (byte) (bArr4[i7] ^ 6918351348135370604L);
                    i7++;
                }
                bArr4 = bArr;
            }
            boolean z2 = !(bArr4 == null);
            aFk1kSDK.AFAdRevenueData = 1;
            while (aFk1kSDK.AFAdRevenueData < i8) {
                if (!(!z2)) {
                    byte[] bArr5 = getMediationNetwork;
                    aFk1kSDK.getCurrencyIso4217Code = aFk1kSDK.getCurrencyIso4217Code - 1;
                    aFk1kSDK.getRevenue = (char) (aFk1kSDK.getMediationNetwork + (((byte) (((byte) (bArr5[i6] ^ 6918351348135370604L)) + s)) ^ b));
                } else {
                    short[] sArr = getMonetizationNetwork;
                    aFk1kSDK.getCurrencyIso4217Code = aFk1kSDK.getCurrencyIso4217Code - 1;
                    aFk1kSDK.getRevenue = (char) (aFk1kSDK.getMediationNetwork + (((short) (((short) (sArr[i5] ^ 6918351348135370604L)) + s)) ^ b));
                }
                sb.append(aFk1kSDK.getRevenue);
                aFk1kSDK.getMediationNetwork = aFk1kSDK.getRevenue;
                aFk1kSDK.AFAdRevenueData++;
                int i18 = $11 + 31;
                $10 = i18 % 128;
                int i19 = i18 % 2;
            }
        }
        objArr[0] = sb.toString();
    }

    static void getRevenue() {
        getCurrencyIso4217Code = -842505383;
        AFAdRevenueData = 1760829245;
        getRevenue = 503259577;
        getMediationNetwork = new byte[]{-125, -23, -7, -7, -7, -3, -49, -26, -30, -7, -11, -8, -8, -4, -7, -5, -3, -1, -2, -10, -14, -28, -56, -23, -7, -2, -52, -27, -2, -7, -7, -8, -29, -12, -2, -5, -50, -24, -4, -12, -12, -4, -11, -31, -5, -1, -6, -4, -8, -6, -8, -2, -9, -2, -6, -30, -5, -7, -1, -3, -8, -12, -4, -8};
    }

    static {
        getRevenue();
        ViewConfiguration.getMaximumDrawingCacheSize();
        TypedValue.complexToFloat(0);
        ExpandableListView.getPackedPositionForChild(0, 0);
        AndroidCharacter.getMirror('0');
        AndroidCharacter.getMirror('0');
        int i = areAllFieldsValid + 71;
        component1 = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }
}
