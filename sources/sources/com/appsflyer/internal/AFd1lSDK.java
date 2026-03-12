package com.appsflyer.internal;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.browser.trusted.sharing.ShareTarget;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.common.ConnectionResult;
import com.singular.sdk.internal.Constants;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
/* loaded from: classes.dex */
public final class AFd1lSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static String AFAdRevenueData = null;
    private static boolean areAllFieldsValid = false;
    private static char[] component1 = null;
    private static int component3 = 0;
    private static int copy = 1;
    public static String getRevenue;
    private static int hashCode;
    private static boolean toString;
    private final AFj1eSDK component2;
    private final AFe1ySDK component4;
    private final AppsFlyerProperties getCurrencyIso4217Code;
    private final AFc1pSDK getMediationNetwork;
    private final AFd1kSDK getMonetizationNetwork;

    public static /* synthetic */ Object getRevenue(Object[] objArr, int i, int i2, int i3) {
        int i4 = ~i;
        int i5 = ~i2;
        int i6 = (~(i4 | i5)) | (~(i5 | i3));
        int i7 = ~i3;
        int i8 = i7 | i;
        int i9 = (i * 1773) + (i2 * (-885)) + ((i6 | (~(i8 | i2))) * 886) + ((i | (~(i2 | i7))) * (-1772)) + ((~i8) * 886);
        if (i9 != 1) {
            if (i9 != 2) {
                AFd1lSDK aFd1lSDK = (AFd1lSDK) objArr[0];
                String str = (String) objArr[1];
                String str2 = (String) objArr[2];
                UUID uuid = (UUID) objArr[3];
                String obj = uuid.toString();
                String obj2 = new StringBuilder().append(String.format(AFAdRevenueData, AppsFlyerLib.getInstance().getHostPrefix(), AFa1uSDK.getMonetizationNetwork().getHostName())).append("/").append(str).append("?id=").append(str2).toString();
                Map<String, Object> AFAdRevenueData2 = aFd1lSDK.AFAdRevenueData();
                String valueOf = String.valueOf(AFAdRevenueData2.get("build_number"));
                HashMap hashMap = new HashMap();
                hashMap.put("Af-UUID", uuid.toString());
                hashMap.put("Af-Meta-Sdk-Ver", valueOf);
                hashMap.put("Af-Meta-Counter", String.valueOf(AFAdRevenueData2.get("counter")));
                hashMap.put("Af-Meta-Model", String.valueOf(AFAdRevenueData2.get("model")));
                hashMap.put("Af-Meta-Platform", String.valueOf(AFAdRevenueData2.get("platformextension")));
                hashMap.put("Af-Meta-System-Version", String.valueOf(AFAdRevenueData2.get(Constants.RequestParamsKeys.SDK_VERSION_KEY)));
                Object[] objArr2 = new Object[1];
                a(null, "\u008c\u008b\u008a\u0089\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", null, 126 - MotionEvent.axisFromString(""), objArr2);
                hashMap.put(((String) objArr2[0]).intern(), getMediationNetwork((String) objArr[4], obj, ShareTarget.METHOD_GET, obj, str, str2, valueOf));
                AFd1jSDK aFd1jSDK = (AFd1jSDK) getRevenue(new Object[]{aFd1lSDK, new AFd1dSDK(obj2, null, ShareTarget.METHOD_GET, hashMap, false), new AFd1bSDK()}, 865808376, -865808374, System.identityHashCode(aFd1lSDK));
                int i10 = copy + 57;
                hashCode = i10 % 128;
                int i11 = i10 % 2;
                return aFd1jSDK;
            }
            return getCurrencyIso4217Code(objArr);
        }
        return getRevenue(objArr);
    }

    static {
        getMediationNetwork();
        getRevenue = "https://%sgcdsdk.%s/install_data/v5.0/";
        AFAdRevenueData = "https://%sonelink.%s/shortlink-sdk/v2";
        int i = hashCode + 95;
        copy = i % 128;
        int i2 = i % 2;
    }

    public AFd1lSDK(AFd1kSDK aFd1kSDK, AFc1pSDK aFc1pSDK, AppsFlyerProperties appsFlyerProperties, AFe1ySDK aFe1ySDK, AFj1eSDK aFj1eSDK) {
        this.getMonetizationNetwork = aFd1kSDK;
        this.getMediationNetwork = aFc1pSDK;
        this.getCurrencyIso4217Code = appsFlyerProperties;
        this.component4 = aFe1ySDK;
        this.component2 = aFj1eSDK;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0073, code lost:
        if (r0 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007d, code lost:
        if (r0 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
        if (r0.length() != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0087, code lost:
        r0 = '*';
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0089, code lost:
        r0 = 'Q';
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008b, code lost:
        if (r0 == '*') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008f, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (r0 != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0092, code lost:
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
        if (new kotlin.text.Regex("4.?(\\d+)?.?(\\d+)").matches(r13) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ac, code lost:
        if (new kotlin.text.Regex("3.?(\\d+)?.?(\\d+)").matches(r13) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00af, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
        if (r13 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
        r13 = r11.getMonetizationNetwork.getCurrencyIso4217Code("https://%sars.%s/api/v2/android/validate_subscription?app_id=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bd, code lost:
        r13 = r11.getMonetizationNetwork.getCurrencyIso4217Code("https://%sars.%s/api/v2/android/validate_subscription_v2?app_id=");
        r0 = com.appsflyer.internal.AFd1lSDK.hashCode + 37;
        com.appsflyer.internal.AFd1lSDK.copy = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0101, code lost:
        return (com.appsflyer.internal.AFd1jSDK) getRevenue(new java.lang.Object[]{r10, new com.appsflyer.internal.AFd1dSDK(com.appsflyer.internal.AFj1eSDK.getRevenue(r11, r11.getRevenue(r13)), r6, "POST", java.util.Collections.emptyMap(), true), new com.appsflyer.internal.AFd1cSDK()}, 865808376, -865808374, java.lang.System.identityHashCode(r10));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.appsflyer.internal.AFd1jSDK<java.lang.String> AFAdRevenueData(java.util.Map<java.lang.String, java.lang.Object> r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1lSDK.AFAdRevenueData(java.util.Map, java.lang.String, java.lang.String):com.appsflyer.internal.AFd1jSDK");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.appsflyer.internal.AFd1jSDK<java.lang.String> getRevenue(java.util.Map<java.lang.String, java.lang.Object> r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1lSDK.getRevenue(java.util.Map, java.lang.String, java.lang.String):com.appsflyer.internal.AFd1jSDK");
    }

    public final AFd1jSDK<String> getRevenue(Map<String, Object> map, String str) {
        try {
            Object[] objArr = {map, str};
            Object obj = AFa1jSDK.unregisterClient.get(203186425);
            if (obj == null) {
                obj = ((Class) AFa1jSDK.AFAdRevenueData((Process.myTid() >> 22) + 196, (char) (TextUtils.lastIndexOf("", '0', 0) + 29637), View.resolveSizeAndState(0, 0, 0) + 37)).getMethod("getRevenue", Map.class, String.class);
                AFa1jSDK.unregisterClient.put(203186425, obj);
            }
            byte[] bArr = (byte[]) ((Method) obj).invoke(null, objArr);
            int i = copy + 35;
            hashCode = i % 128;
            int i2 = i % 2;
            AFj1eSDK aFj1eSDK = this.component2;
            AFd1jSDK<String> aFd1jSDK = (AFd1jSDK) getRevenue(new Object[]{this, new AFd1dSDK(aFj1eSDK.getRevenue(aFj1eSDK.getMonetizationNetwork.getCurrencyIso4217Code("https://%svalidate-and-log.%s/api/v4.0/android/one_time_purchase/validateAndLog?app_id=")), bArr, "POST", Collections.emptyMap(), true), new AFd1cSDK()}, 865808376, -865808374, System.identityHashCode(this));
            int i3 = hashCode + 69;
            copy = i3 % 128;
            int i4 = i3 % 2;
            return aFd1jSDK;
        } catch (Throwable th) {
            try {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            } catch (Throwable th2) {
                AFLogger.INSTANCE.e(AFg1cSDK.PURCHASE_VALIDATION, "AFFinalizer: reflection init failed.", th2, false, false);
                return null;
            }
        }
    }

    public final AFd1jSDK<String> getCurrencyIso4217Code(Map<String, Object> map, String str) {
        int i = copy + 47;
        hashCode = i % 128;
        try {
            if (i % 2 != 0) {
                Object[] objArr = {map, str};
                Object obj = AFa1jSDK.unregisterClient.get(203186425);
                if (obj == null) {
                    obj = ((Class) AFa1jSDK.AFAdRevenueData(196 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (TextUtils.indexOf("", "", 0) + 29636), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 36)).getMethod("getRevenue", Map.class, String.class);
                    AFa1jSDK.unregisterClient.put(203186425, obj);
                }
                byte[] bArr = (byte[]) ((Method) obj).invoke(null, objArr);
                throw null;
            }
            Object[] objArr2 = {map, str};
            Object obj2 = AFa1jSDK.unregisterClient.get(203186425);
            if (obj2 == null) {
                obj2 = ((Class) AFa1jSDK.AFAdRevenueData(Color.rgb(0, 0, 0) + 16777412, (char) (29636 - TextUtils.getOffsetAfter("", 0)), 38 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))).getMethod("getRevenue", Map.class, String.class);
                AFa1jSDK.unregisterClient.put(203186425, obj2);
            }
            byte[] bArr2 = (byte[]) ((Method) obj2).invoke(null, objArr2);
            AFj1eSDK aFj1eSDK = this.component2;
            AFd1jSDK<String> aFd1jSDK = (AFd1jSDK) getRevenue(new Object[]{this, new AFd1dSDK(aFj1eSDK.getRevenue(aFj1eSDK.getMonetizationNetwork.getCurrencyIso4217Code("https://%svalidate-and-log.%s/api/v4.0/android/subscription/validateAndLog?app_id=")), bArr2, "POST", Collections.emptyMap(), true), new AFd1cSDK()}, 865808376, -865808374, System.identityHashCode(this));
            int i2 = hashCode + 25;
            copy = i2 % 128;
            if (i2 % 2 != 0) {
                return aFd1jSDK;
            }
            int i3 = 17 / 0;
            return aFd1jSDK;
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.PURCHASE_VALIDATION, "AFFinalizer: reflection init failed.", th, false, false);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r12 = r12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v13, types: [char[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r11, java.lang.String r12, int[] r13, int r14, java.lang.Object[] r15) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1lSDK.a(java.lang.String, java.lang.String, int[], int, java.lang.Object[]):void");
    }

    public final AFd1jSDK<AFi1wSDK> getMonetizationNetwork(boolean z, boolean z2, String str, int i) {
        String str2;
        String str3;
        int i2 = hashCode + 107;
        copy = i2 % 128;
        if (i2 % 2 != 0) {
            AFe1ySDK aFe1ySDK = this.component4;
            Intrinsics.checkNotNullParameter(str, "");
            String str4 = z ? AFe1ySDK.getMonetizationNetwork : AFe1ySDK.getRevenue;
            if (z2) {
                int i3 = hashCode + 93;
                copy = i3 % 128;
                int i4 = i3 % 2;
                str2 = "stg";
            } else {
                str2 = "";
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[4];
            if (AFe1ySDK.getRevenue()) {
                int i5 = hashCode + 53;
                copy = i5 % 128;
                int i6 = i5 % 2;
                str3 = (String) aFe1ySDK.getCurrencyIso4217Code.getValue();
            } else {
                str3 = "";
            }
            objArr[0] = str3;
            objArr[1] = str2;
            objArr[2] = aFe1ySDK.getCurrencyIso4217Code();
            objArr[3] = str;
            String format = String.format(str4, Arrays.copyOf(objArr, 4));
            Intrinsics.checkNotNullExpressionValue(format, "");
            AFd1dSDK aFd1dSDK = new AFd1dSDK(format, ShareTarget.METHOD_GET);
            aFd1dSDK.component3 = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            return (AFd1jSDK) getRevenue(new Object[]{this, aFd1dSDK, new AFd1eSDK()}, 865808376, -865808374, System.identityHashCode(this));
        }
        Intrinsics.checkNotNullParameter(str, "");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0120, code lost:
        if (r18.component1 < 5) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x012a, code lost:
        if ((r18.component1 < 2) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x012c, code lost:
        r3 = r4.getMonetizationNetwork.getCurrencyIso4217Code(com.appsflyer.internal.AFj1eSDK.getMediationNetwork);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0135, code lost:
        r3 = r4.getMonetizationNetwork.getCurrencyIso4217Code(com.appsflyer.internal.AFj1eSDK.component2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.appsflyer.internal.AFd1jSDK<java.lang.String> AFAdRevenueData(com.appsflyer.internal.AFh1jSDK r18, java.lang.String r19, com.appsflyer.internal.AFc1gSDK r20) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1lSDK.AFAdRevenueData(com.appsflyer.internal.AFh1jSDK, java.lang.String, com.appsflyer.internal.AFc1gSDK):com.appsflyer.internal.AFd1jSDK");
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        AFd1lSDK aFd1lSDK = (AFd1lSDK) objArr[0];
        AFd1jSDK aFd1jSDK = (AFd1jSDK) getRevenue(new Object[]{aFd1lSDK, AFd1hSDK.AFAdRevenueData(aFd1lSDK.getMediationNetwork.getRevenue.getRevenue.getPackageName(), AFb1jSDK.getRevenue(aFd1lSDK.getMediationNetwork.getMonetizationNetwork), (String) objArr[1], (String) objArr[2]), new AFd1iSDK()}, 865808376, -865808374, System.identityHashCode(aFd1lSDK));
        int i = hashCode + 85;
        copy = i % 128;
        if (!(i % 2 == 0)) {
            return aFd1jSDK;
        }
        int i2 = 21 / 0;
        return aFd1jSDK;
    }

    public final AFd1jSDK<String> getRevenue(AFh1gSDK aFh1gSDK) {
        AFd1jSDK<String> aFd1jSDK = (AFd1jSDK) getRevenue(new Object[]{this, new AFd1dSDK(aFh1gSDK.component3, aFh1gSDK.AFAdRevenueData(), "POST", Collections.emptyMap(), true), new AFd1cSDK()}, 865808376, -865808374, System.identityHashCode(this));
        int i = copy + 117;
        hashCode = i % 128;
        if ((i % 2 != 0 ? (char) 3 : 'U') != 3) {
            return aFd1jSDK;
        }
        int i2 = 59 / 0;
        return aFd1jSDK;
    }

    public final AFd1jSDK<String> getMediationNetwork(String str, Map<String, String> map, String str2, UUID uuid, String str3) {
        String obj = uuid.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("ttl", "-1");
        hashMap.put("uuid", obj);
        hashMap.put("data", map);
        hashMap.put("meta", AFAdRevenueData());
        Object obj2 = null;
        if (str2 != null) {
            int i = copy + 29;
            hashCode = i % 128;
            if ((i % 2 != 0 ? '\f' : 'b') != '\f') {
                hashMap.put("brand_domain", str2);
            } else {
                hashMap.put("brand_domain", str2);
                obj2.hashCode();
                throw null;
            }
        }
        String jSONObject = AFg1hSDK.getCurrencyIso4217Code(hashMap).toString();
        HashMap hashMap2 = new HashMap();
        Object[] objArr = new Object[1];
        a(null, "\u008c\u008b\u008a\u0089\u0088\u0087\u0086\u0085\u0084\u0083\u0082\u0081", null, 128 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr);
        hashMap2.put(((String) objArr[0]).intern(), getMediationNetwork(str3, obj, "POST", jSONObject));
        AFd1jSDK<String> mediationNetwork = getMediationNetwork(new AFd1dSDK(new StringBuilder().append(String.format(AFAdRevenueData, AppsFlyerLib.getInstance().getHostPrefix(), AFa1uSDK.getMonetizationNetwork().getHostName())).append("/").append(str).toString(), jSONObject.getBytes(Charset.defaultCharset()), "POST", hashMap2, false), (AFe1vSDK) new AFd1cSDK(), true);
        int i2 = copy + 95;
        hashCode = i2 % 128;
        int i3 = i2 % 2;
        return mediationNetwork;
    }

    public final AFd1jSDK<String> AFAdRevenueData(String str) {
        AFd1dSDK aFd1dSDK = new AFd1dSDK(str, null, ShareTarget.METHOD_GET, Collections.emptyMap(), false);
        aFd1dSDK.component3 = 10000;
        aFd1dSDK.getCurrencyIso4217Code = false;
        AFd1jSDK<String> aFd1jSDK = (AFd1jSDK) getRevenue(new Object[]{this, aFd1dSDK, new AFd1cSDK()}, 865808376, -865808374, System.identityHashCode(this));
        int i = hashCode + 125;
        copy = i % 128;
        int i2 = i % 2;
        return aFd1jSDK;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00cc, code lost:
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.appsflyer.internal.AFd1oSDK getMediationNetwork(java.util.Map<java.lang.String, java.lang.Object> r15, java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1lSDK.getMediationNetwork(java.util.Map, java.lang.String):com.appsflyer.internal.AFd1oSDK");
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        AFd1lSDK aFd1lSDK = (AFd1lSDK) objArr[0];
        int i = hashCode + 83;
        copy = i % 128;
        int i2 = i % 2;
        AFd1jSDK mediationNetwork = aFd1lSDK.getMediationNetwork((AFd1dSDK) objArr[1], (AFe1vSDK) objArr[2], aFd1lSDK.getMonetizationNetwork());
        int i3 = hashCode + 123;
        copy = i3 % 128;
        if ((i3 % 2 == 0 ? '4' : 'F') == 'F') {
            return mediationNetwork;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private Map<String, Object> AFAdRevenueData() {
        HashMap hashMap = new HashMap();
        hashMap.put("build_number", "6.17.3");
        hashMap.put("counter", Integer.valueOf(this.getMediationNetwork.getMonetizationNetwork.getMediationNetwork("appsFlyerCount", 0)));
        hashMap.put("model", Build.MODEL);
        Object[] objArr = new Object[1];
        a(null, "\u008e\u0087\u0088\u008b\u008d", null, 126 - ((byte) KeyEvent.getModifierMetaStateMask()), objArr);
        hashMap.put(((String) objArr[0]).intern(), Build.BRAND);
        hashMap.put(Constants.RequestParamsKeys.SDK_VERSION_KEY, Integer.toString(Build.VERSION.SDK_INT));
        hashMap.put("app_version_name", this.getMediationNetwork.n_().versionName);
        hashMap.put("app_id", this.getMediationNetwork.getRevenue.getRevenue.getPackageName());
        hashMap.put("platformextension", new AFa1ySDK().getMediationNetwork());
        int i = hashCode + 13;
        copy = i % 128;
        int i2 = i % 2;
        return hashMap;
    }

    private static String getMediationNetwork(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, "v2");
        String revenue = AFj1bSDK.getRevenue(TextUtils.join("\u2063", (String[]) arrayList.toArray(new String[0])), new StringBuilder().append(str).append(str2).append("v2").toString());
        int i = copy + 89;
        hashCode = i % 128;
        if (!(i % 2 != 0)) {
            return revenue;
        }
        int i2 = 72 / 0;
        return revenue;
    }

    private boolean getMonetizationNetwork() {
        int i = copy + 99;
        hashCode = i % 128;
        int i2 = i % 2;
        if ((!this.getCurrencyIso4217Code.getBoolean(AppsFlyerProperties.HTTP_CACHE, true) ? 'S' : (char) 7) != 7) {
            int i3 = copy + 29;
            hashCode = i3 % 128;
            int i4 = i3 % 2;
            return true;
        }
        return false;
    }

    public final AFd1jSDK<AFa1mSDK> getMonetizationNetwork(AFa1pSDK aFa1pSDK) {
        AFd1jSDK<AFa1mSDK> aFd1jSDK = (AFd1jSDK) getRevenue(new Object[]{this, new AFd1dSDK(aFa1pSDK.component3, AFg1hSDK.getCurrencyIso4217Code(aFa1pSDK.getCurrencyIso4217Code).toString().getBytes(Charset.defaultCharset()), "POST", Collections.emptyMap(), aFa1pSDK.getRevenue()), new AFa1qSDK()}, 865808376, -865808374, System.identityHashCode(this));
        int i = copy + 61;
        hashCode = i % 128;
        int i2 = i % 2;
        return aFd1jSDK;
    }

    private <T> AFd1jSDK<T> getMediationNetwork(AFd1dSDK aFd1dSDK, AFe1vSDK<T> aFe1vSDK, boolean z) {
        aFd1dSDK.getMediationNetwork = z;
        AFd1kSDK aFd1kSDK = this.getMonetizationNetwork;
        AFd1jSDK<T> aFd1jSDK = new AFd1jSDK<>(aFd1dSDK, aFd1kSDK.getMediationNetwork, aFd1kSDK.getRevenue, aFe1vSDK);
        int i = hashCode + 57;
        copy = i % 128;
        if ((i % 2 == 0 ? (char) 16 : '\r') != 16) {
            return aFd1jSDK;
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    static void getMediationNetwork() {
        component1 = new char[]{36301, 36326, 36281, 36307, 36325, 36327, 36350, 36333, 36336, 36337, 36338, 36321, 36322, 36320};
        component3 = 1912311180;
        areAllFieldsValid = true;
        toString = true;
    }

    private <T> AFd1jSDK<T> getCurrencyIso4217Code(AFd1dSDK aFd1dSDK, AFe1vSDK<T> aFe1vSDK) {
        return (AFd1jSDK) getRevenue(new Object[]{this, aFd1dSDK, aFe1vSDK}, 865808376, -865808374, System.identityHashCode(this));
    }

    public final AFd1jSDK<Map<String, String>> getMediationNetwork(String str, String str2, UUID uuid, String str3) {
        return (AFd1jSDK) getRevenue(new Object[]{this, str, str2, uuid, str3}, 1826287225, -1826287225, System.identityHashCode(this));
    }

    public final AFd1jSDK<Map<String, Object>> getMediationNetwork(String str, String str2) {
        return (AFd1jSDK) getRevenue(new Object[]{this, str, str2}, 2067226218, -2067226217, System.identityHashCode(this));
    }
}
