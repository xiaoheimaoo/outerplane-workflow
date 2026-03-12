package com.appsflyer.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.appsflyer.AFLogger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class AFc1iSDK extends HashMap<String, Object> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int areAllFieldsValid = 1;
    private static int getMediationNetwork;
    private static long getMonetizationNetwork;
    private static int getRevenue;
    private final Map<String, Object> AFAdRevenueData;
    private final Context getCurrencyIso4217Code;

    public AFc1iSDK(Map<String, Object> map, Context context) {
        this.AFAdRevenueData = map;
        this.getCurrencyIso4217Code = context;
        put(getMediationNetwork(), getMonetizationNetwork());
    }

    private static StringBuilder getCurrencyIso4217Code(String... strArr) throws Exception {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (!(i < 3)) {
                break;
            }
            arrayList.add(Integer.valueOf(strArr[i].length()));
            i++;
        }
        Collections.sort(arrayList);
        int intValue = ((Integer) arrayList.get(0)).intValue();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            if ((i2 < intValue ? (char) 27 : '\t') == '\t') {
                return sb;
            }
            int length2 = strArr.length;
            Object obj = null;
            Integer num = null;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = areAllFieldsValid + 57;
                getRevenue = i4 % 128;
                int i5 = i4 % 2;
                int charAt = strArr[i3].charAt(i2);
                if (num != null) {
                    charAt ^= num.intValue();
                } else {
                    int i6 = areAllFieldsValid + 69;
                    getRevenue = i6 % 128;
                    if (i6 % 2 != 0) {
                        obj.hashCode();
                        throw null;
                    }
                }
                num = Integer.valueOf(charAt);
            }
            sb.append(Integer.toHexString(num.intValue()));
            i2++;
        }
    }

    private static void b(String str, int i, Object[] objArr) {
        char[] cArr;
        int i2 = $10;
        int i3 = i2 + 27;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        char c = str != null ? (char) 27 : 'W';
        char[] cArr2 = str;
        if (c != 'W') {
            int i5 = i2 + 97;
            $11 = i5 % 128;
            if (!(i5 % 2 == 0)) {
                cArr = str.toCharArray();
            } else {
                int i6 = 74 / 0;
                cArr = str.toCharArray();
            }
            int i7 = $10 + 9;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            cArr2 = cArr;
        }
        AFk1gSDK aFk1gSDK = new AFk1gSDK();
        char[] currencyIso4217Code = AFk1gSDK.getCurrencyIso4217Code(getMonetizationNetwork ^ 7975055078221964256L, cArr2, i);
        aFk1gSDK.getCurrencyIso4217Code = 4;
        while (true) {
            if ((aFk1gSDK.getCurrencyIso4217Code < currencyIso4217Code.length ? '8' : '\\') == '\\') {
                objArr[0] = new String(currencyIso4217Code, 4, currencyIso4217Code.length - 4);
                return;
            }
            int i9 = $10 + 23;
            $11 = i9 % 128;
            int i10 = i9 % 2;
            aFk1gSDK.getMediationNetwork = aFk1gSDK.getCurrencyIso4217Code - 4;
            currencyIso4217Code[aFk1gSDK.getCurrencyIso4217Code] = (char) ((currencyIso4217Code[aFk1gSDK.getCurrencyIso4217Code] ^ currencyIso4217Code[aFk1gSDK.getCurrencyIso4217Code % 4]) ^ (aFk1gSDK.getMediationNetwork * (getMonetizationNetwork ^ 7975055078221964256L)));
            aFk1gSDK.getCurrencyIso4217Code++;
        }
    }

    private String getMediationNetwork() {
        try {
            String num = Integer.toString(Build.VERSION.SDK_INT);
            Map<String, Object> map = this.AFAdRevenueData;
            Object[] objArr = new Object[1];
            a("\n\ufff7\u0003\u0006\ufff7￼\ufff5\n\uffff\u0003\ufffb\t", ExpandableListView.getPackedPositionGroup(0L) + 4, 11 - ExpandableListView.getPackedPositionChild(0L), TextUtils.getCapsMode("", 0, 0) + 172, false, objArr);
            String obj = map.get(((String) objArr[0]).intern()).toString();
            Map<String, Object> map2 = this.AFAdRevenueData;
            Object[] objArr2 = new Object[1];
            a("\ufffa\u000b\ufffb�\u0007", 3 - View.MeasureSpec.makeMeasureSpec(0, 0), 5 - Color.blue(0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 169, true, objArr2);
            String obj2 = map2.get(((String) objArr2[0]).intern()).toString();
            if (obj2 == null) {
                Object[] objArr3 = new Object[1];
                a("\u0003\u0002\ufff8\u0002\ufff5\u0006\ufff6\u0013", TextUtils.indexOf("", "") + 2, 8 - (ViewConfiguration.getTapTimeout() >> 16), 142 - Drawable.resolveOpacity(0, 0), true, objArr3);
                obj2 = ((String) objArr3[0]).intern();
            }
            StringBuilder sb = new StringBuilder(obj);
            sb.reverse();
            StringBuilder currencyIso4217Code = getCurrencyIso4217Code(num, obj2, sb.toString());
            int length = currencyIso4217Code.length();
            if ((length > 4 ? '!' : ')') != '!') {
                while (true) {
                    if (length >= 4) {
                        break;
                    }
                    int i = areAllFieldsValid + 89;
                    getRevenue = i % 128;
                    int i2 = i % 2;
                    length++;
                    currencyIso4217Code.append('1');
                }
            } else {
                int i3 = areAllFieldsValid + 97;
                getRevenue = i3 % 128;
                int i4 = i3 % 2;
                currencyIso4217Code.delete(4, length);
            }
            Object[] objArr4 = new Object[1];
            b("퍵ƅ哆鈷팞뛏㫾", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr4);
            currencyIso4217Code.insert(0, ((String) objArr4[0]).intern());
            return currencyIso4217Code.toString();
        } catch (Exception e) {
            Object[] objArr5 = new Object[1];
            b("쬇\udc3a\uf4e9ꃕ쬧歲髒蔬\u17ed俣뾸ꋹ爆경퍙羱嵚鄵\uf01e᭰맗\uf642ᗂ㣆蓎\uda93䪂햘\ue706㿃湈\uf100쉈ᰌ茍蹄⺌䅐ꂮꮘ৬ꖘ쑧䢔", -((byte) KeyEvent.getModifierMetaStateMask()), objArr5);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e);
            StringBuilder sb2 = new StringBuilder();
            Object[] objArr6 = new Object[1];
            b("╨鳵다턗┎⮻\udcd3\uf4f6鈴ེ吏팹鱵\uec3c镗\u0e60댽퇢똟檸埿뛊叁䤏檢騎ಅꑋॹ罂⡕肋ⰸ峎앆ￃ샰ƙ\ue6bf\uda0a\ue780\ue557艱㥐먊쩒", -((byte) KeyEvent.getModifierMetaStateMask()), objArr6);
            AFLogger.afRDLog(sb2.append(((String) objArr6[0]).intern()).append(e).toString());
            Object[] objArr7 = new Object[1];
            b("쁃w\uf497꜍쀨뜽骯芹᳆鎥뾴", Drawable.resolveOpacity(0, 0) + 1, objArr7);
            return ((String) objArr7[0]).intern();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x02f0 A[Catch: Exception -> 0x0325, TRY_LEAVE, TryCatch #2 {Exception -> 0x0325, blocks: (B:8:0x0164, B:12:0x01a8, B:13:0x01c0, B:15:0x01ca, B:22:0x01f8, B:28:0x02f0, B:31:0x0307, B:32:0x0311, B:33:0x0317), top: B:49:0x0164 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x03c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0317 A[EDGE_INSN: B:51:0x0317->B:33:0x0317 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getMonetizationNetwork() {
        /*
            Method dump skipped, instructions count: 968
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1iSDK.getMonetizationNetwork():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r10 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r10, int r11, int r12, int r13, boolean r14, java.lang.Object[] r15) {
        /*
            Method dump skipped, instructions count: 190
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1iSDK.a(java.lang.String, int, int, int, boolean, java.lang.Object[]):void");
    }

    /* loaded from: classes.dex */
    public static class AFa1zSDK {
        static byte[] getMonetizationNetwork(String str) throws Exception {
            return str.getBytes(Charset.defaultCharset());
        }

        static byte[] AFAdRevenueData(byte[] bArr) throws Exception {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (bArr[i] ^ ((i % 2) + 42));
            }
            return bArr;
        }
    }

    static void AFAdRevenueData() {
        getMediationNetwork = -33994396;
        getMonetizationNetwork = 8254201675162375375L;
    }

    static {
        AFAdRevenueData();
        PointF.length(0.0f, 0.0f);
        ExpandableListView.getPackedPositionChild(0L);
        ViewConfiguration.getZoomControlsTimeout();
        ViewConfiguration.getScrollDefaultDelay();
        View.MeasureSpec.makeMeasureSpec(0, 0);
        ImageFormat.getBitsPerPixel(0);
        ViewConfiguration.getFadingEdgeLength();
        SystemClock.currentThreadTimeMillis();
        KeyEvent.getModifierMetaStateMask();
        ViewConfiguration.getTouchSlop();
        ViewConfiguration.getScrollBarSize();
        TypedValue.complexToFraction(0, 0.0f, 0.0f);
        ViewConfiguration.getScrollFriction();
        Process.myPid();
        View.resolveSizeAndState(0, 0, 0);
        ExpandableListView.getPackedPositionChild(0L);
        ViewConfiguration.getFadingEdgeLength();
        ViewConfiguration.getTapTimeout();
        TextUtils.indexOf((CharSequence) "", '0', 0, 0);
        int i = areAllFieldsValid + 19;
        getRevenue = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }
}
