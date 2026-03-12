package com.appsflyer.internal;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFf1eSDK;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class AFf1cSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int copy = 0;
    private static int copydefault = 1;
    private long AFAdRevenueData;
    private volatile String areAllFieldsValid;
    private volatile String component1;
    Map<String, Object> getCurrencyIso4217Code;
    private final AFc1gSDK getMonetizationNetwork;
    private final AFf1eSDK getRevenue;
    private static char[] component4 = {6849, 65232, 53971, 46742, 35473, 28323, 16961, 9801, 14948, 7687, 61969, 54818};
    private static long component3 = -3612185266591219208L;
    private boolean getMediationNetwork = false;
    private volatile boolean component2 = false;

    public static /* synthetic */ Object getRevenue(Object[] objArr, int i, int i2, int i3) {
        int i4 = (i * (-1965)) + (i2 * 984);
        int i5 = ~i2;
        int i6 = ~i;
        int i7 = ~i3;
        int i8 = i4 + ((i | i5) * 983) + (((~(i5 | i7)) | i6) * (-983)) + (((~(i6 | i2)) | (~(i7 | i6))) * 983);
        return i8 != 1 ? i8 != 2 ? getMediationNetwork(objArr) : getMonetizationNetwork(objArr) : getRevenue(objArr);
    }

    public AFf1cSDK(AFc1gSDK aFc1gSDK, AFf1eSDK aFf1eSDK) {
        this.getMonetizationNetwork = aFc1gSDK;
        this.getRevenue = aFf1eSDK;
    }

    public final void getCurrencyIso4217Code(String str) {
        int i = copy + 67;
        copydefault = i % 128;
        int i2 = i % 2;
        this.areAllFieldsValid = str;
        int i3 = copy + 15;
        copydefault = i3 % 128;
        int i4 = i3 % 2;
    }

    public final String getMediationNetwork() {
        int i = copydefault + 65;
        copy = i % 128;
        int i2 = i % 2;
        String str = this.component1;
        int i3 = copydefault + 119;
        copy = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public final void getMonetizationNetwork(String str) {
        int i = copy + 77;
        copydefault = i % 128;
        if ((i % 2 == 0 ? '>' : '+') != '>') {
            this.component1 = str;
        } else {
            this.component1 = str;
            int i2 = 49 / 0;
        }
        int i3 = copydefault + 47;
        copy = i3 % 128;
        int i4 = i3 % 2;
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        int i = copy + 115;
        copydefault = i % 128;
        int i2 = i % 2;
        boolean z = ((AFf1cSDK) objArr[0]).component2;
        int i3 = copydefault + 75;
        copy = i3 % 128;
        if ((i3 % 2 != 0 ? '/' : 'V') == 'V') {
            return Boolean.valueOf(z);
        }
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        int i3;
        AFk1hSDK aFk1hSDK = new AFk1hSDK();
        long[] jArr = new long[i];
        aFk1hSDK.getCurrencyIso4217Code = 0;
        while (true) {
            if (aFk1hSDK.getCurrencyIso4217Code >= i) {
                break;
            }
            int i4 = $10 + 7;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            jArr[aFk1hSDK.getCurrencyIso4217Code] = (((char) (component4[aFk1hSDK.getCurrencyIso4217Code + i2] ^ 8195019394385815022L)) ^ (aFk1hSDK.getCurrencyIso4217Code * (8195019394385815022L ^ component3))) ^ c;
            aFk1hSDK.getCurrencyIso4217Code++;
        }
        char[] cArr = new char[i];
        aFk1hSDK.getCurrencyIso4217Code = 0;
        while (true) {
            if (!(aFk1hSDK.getCurrencyIso4217Code < i)) {
                objArr[0] = new String(cArr);
                return;
            }
            int i6 = $10 + 67;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
                cArr[aFk1hSDK.getCurrencyIso4217Code] = (char) jArr[aFk1hSDK.getCurrencyIso4217Code];
                i3 = aFk1hSDK.getCurrencyIso4217Code >>> 1;
            } else {
                cArr[aFk1hSDK.getCurrencyIso4217Code] = (char) jArr[aFk1hSDK.getCurrencyIso4217Code];
                i3 = aFk1hSDK.getCurrencyIso4217Code + 1;
            }
            aFk1hSDK.getCurrencyIso4217Code = i3;
        }
    }

    public final void getRevenue(boolean z) {
        int i = copydefault + 63;
        copy = i % 128;
        if (!(i % 2 != 0)) {
            this.component2 = z;
            int i2 = copy + 117;
            copydefault = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        this.component2 = z;
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    public final String getCurrencyIso4217Code() {
        int i = copy + 111;
        copydefault = i % 128;
        if ((i % 2 == 0 ? (char) 29 : '-') != 29) {
            return this.areAllFieldsValid;
        }
        throw null;
    }

    public final String getMediationNetwork(AFc1oSDK aFc1oSDK) {
        String str;
        int i = copydefault + 57;
        copy = i % 128;
        int i2 = i % 2;
        boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI, false);
        String monetizationNetwork = aFc1oSDK.getMonetizationNetwork("imeiCached", null);
        if ((z ? '9' : 'b') == '9' && AFk1xSDK.getRevenue(this.areAllFieldsValid)) {
            int i3 = copy + 75;
            copydefault = i3 % 128;
            int i4 = i3 % 2;
            Context context = this.getMonetizationNetwork.getRevenue;
            if (context != null) {
                if (getMediationNetwork(context)) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        str = (String) telephonyManager.getClass().getMethod("getDeviceId", new Class[0]).invoke(telephonyManager, new Object[0]);
                    } catch (InvocationTargetException e) {
                        if (monetizationNetwork != null) {
                            AFLogger.afDebugLog("use cached IMEI: ".concat(String.valueOf(monetizationNetwork)));
                        } else {
                            monetizationNetwork = null;
                        }
                        AFLogger.afErrorLog(new StringBuilder("WARNING: Can't collect IMEI because of missing permissions: ").append(e.getMessage()).toString(), e);
                    } catch (Exception e2) {
                        if (monetizationNetwork != null) {
                            AFLogger.afDebugLog("use cached IMEI: ".concat(String.valueOf(monetizationNetwork)));
                        } else {
                            monetizationNetwork = null;
                        }
                        AFLogger.afErrorLog(new StringBuilder("WARNING: Can't collect IMEI: other reason: ").append(e2.getMessage()).toString(), e2);
                    }
                    if (str == null) {
                        if (!(monetizationNetwork != null ? true : true)) {
                            AFLogger.afDebugLog("use cached IMEI: ".concat(String.valueOf(monetizationNetwork)));
                        } else {
                            monetizationNetwork = null;
                        }
                        str = monetizationNetwork;
                    }
                }
            }
            str = null;
        } else {
            if (!(this.areAllFieldsValid != null ? true : true)) {
                int i5 = copydefault + 5;
                copy = i5 % 128;
                int i6 = i5 % 2;
                str = this.areAllFieldsValid;
            }
            str = null;
        }
        if ((!AFk1xSDK.getRevenue(str) ? (char) 21 : '-') != 21) {
            AFLogger.afInfoLog("IMEI was not collected.");
            int i7 = copy + 47;
            copydefault = i7 % 128;
            if (i7 % 2 == 0) {
                int i8 = 91 / 0;
                return null;
            }
            return null;
        }
        int i9 = copy + 111;
        copydefault = i9 % 128;
        if ((i9 % 2 == 0 ? '8' : 'S') != '8') {
            aFc1oSDK.AFAdRevenueData("imeiCached", str);
            return str;
        }
        aFc1oSDK.AFAdRevenueData("imeiCached", str);
        throw null;
    }

    public final Map<String, Object> getMediationNetwork(Map<String, Object> map) {
        AFc1iSDK aFc1iSDK = new AFc1iSDK(map, this.getMonetizationNetwork.getRevenue);
        int i = copy + 83;
        copydefault = i % 128;
        if ((i % 2 == 0 ? 'T' : '6') != 'T') {
            return aFc1iSDK;
        }
        throw null;
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        try {
            Object[] objArr2 = {(Map) objArr[1], ((AFf1cSDK) objArr[0]).getMonetizationNetwork.getRevenue};
            Object obj = AFa1jSDK.unregisterClient.get(-1144864810);
            if (obj == null) {
                obj = ((Class) AFa1jSDK.AFAdRevenueData(125 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 36 - View.MeasureSpec.getSize(0))).getDeclaredConstructor(Map.class, Context.class);
                AFa1jSDK.unregisterClient.put(-1144864810, obj);
            }
            Object newInstance = ((Constructor) obj).newInstance(objArr2);
            int i = copy + 125;
            copydefault = i % 128;
            int i2 = i % 2;
            return newInstance;
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("AFCksmV3: reflection init failed", th);
            return new HashMap();
        }
    }

    public static void getCurrencyIso4217Code(AFh1jSDK aFh1jSDK) {
        try {
            new AFb1sSDK(aFh1jSDK).afInfoLog();
            int i = copydefault + 15;
            copy = i % 128;
            if ((i % 2 != 0 ? 'S' : 'T') != 'S') {
                return;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("native: reflection init failed", e);
        }
    }

    public static void getMonetizationNetwork(Map<String, Object> map, AFc1pSDK aFc1pSDK) {
        int i = copy + 75;
        copydefault = i % 128;
        int i2 = i % 2;
        if (AFk1xSDK.getRevenue(aFc1pSDK.getMediationNetwork)) {
            int i3 = copydefault + 59;
            copy = i3 % 128;
            int i4 = i3 % 2;
            String monetizationNetwork = aFc1pSDK.getMonetizationNetwork("com.appsflyer.security.uuid");
            if (!(!AFk1xSDK.getRevenue(monetizationNetwork))) {
                monetizationNetwork = AFc1pSDK.getMonetizationNetwork();
            }
            aFc1pSDK.getMediationNetwork = monetizationNetwork.substring(0, 8);
            int i5 = copydefault + 19;
            copy = i5 % 128;
            int i6 = i5 % 2;
        }
        String str = aFc1pSDK.getMediationNetwork;
        try {
            Object[] objArr = new Object[1];
            a((Process.myPid() >> 22) + 12, View.MeasureSpec.makeMeasureSpec(0, 0), (char) (48974 - TextUtils.indexOf("", "", 0, 0)), objArr);
            long parseLong = Long.parseLong(String.valueOf(map.get(((String) objArr[0]).intern())));
            char[] charArray = str.toCharArray();
            int i7 = ((int) (parseLong % 94)) + 33;
            int i8 = 0;
            while (true) {
                if (i8 < charArray.length) {
                    charArray[i8] = (char) (charArray[i8] ^ i7);
                    i8++;
                } else {
                    map.put("sbid", new String(charArray));
                    return;
                }
            }
        } catch (Exception e) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Exception occurred while generating sbid ", e);
        }
    }

    public final Map<String, Object> getRevenue() {
        HashMap hashMap = new HashMap();
        if ((component1() ? '\\' : (char) 22) == 22) {
            if (this.getMediationNetwork) {
                this.getCurrencyIso4217Code = new HashMap();
                component2();
                this.getCurrencyIso4217Code.put("error", "pending LVL response");
                hashMap.put("lvl", this.getCurrencyIso4217Code);
            }
        } else {
            int i = copy + 37;
            copydefault = i % 128;
            if ((i % 2 == 0 ? '[' : (char) 1) != 1) {
                hashMap.put("lvl", this.getCurrencyIso4217Code);
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            hashMap.put("lvl", this.getCurrencyIso4217Code);
        }
        int i2 = copy + 113;
        copydefault = i2 % 128;
        int i3 = i2 % 2;
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0018, code lost:
        if (r4.getCurrencyIso4217Code != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x001f, code lost:
        if (r4.getCurrencyIso4217Code != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0027, code lost:
        if (r4.getCurrencyIso4217Code.isEmpty() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0029, code lost:
        r0 = com.appsflyer.internal.AFf1cSDK.copy + 47;
        com.appsflyer.internal.AFf1cSDK.copydefault = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0033, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean component1() {
        /*
            r4 = this;
            int r0 = com.appsflyer.internal.AFf1cSDK.copy
            int r0 = r0 + 25
            int r1 = r0 % 128
            com.appsflyer.internal.AFf1cSDK.copydefault = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = r1
            goto L11
        L10:
            r0 = r2
        L11:
            if (r0 == 0) goto L1d
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.getCurrencyIso4217Code
            r3 = 16
            int r3 = r3 / r2
            if (r0 == 0) goto L34
            goto L21
        L1b:
            r0 = move-exception
            throw r0
        L1d:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.getCurrencyIso4217Code
            if (r0 == 0) goto L34
        L21:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.getCurrencyIso4217Code
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L34
            int r0 = com.appsflyer.internal.AFf1cSDK.copy
            int r0 = r0 + 47
            int r2 = r0 % 128
            com.appsflyer.internal.AFf1cSDK.copydefault = r2
            int r0 = r0 % 2
            return r1
        L34:
            int r0 = com.appsflyer.internal.AFf1cSDK.copydefault
            int r0 = r0 + 43
            int r3 = r0 % 128
            com.appsflyer.internal.AFf1cSDK.copy = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L42
            r0 = r2
            goto L43
        L42:
            r0 = r1
        L43:
            if (r0 != r1) goto L46
            return r2
        L46:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L4b
            throw r0     // Catch: java.lang.Throwable -> L4b
        L4b:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1cSDK.component1():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x001a, code lost:
        if ((r3.getMediationNetwork ? ';' : '[') != '[') goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0021, code lost:
        if (r3.getMediationNetwork != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0028, code lost:
        if (component1() != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x002a, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x002c, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x002d, code lost:
        if (r0 == true) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0030, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean AFAdRevenueData() {
        /*
            r3 = this;
            int r0 = com.appsflyer.internal.AFf1cSDK.copydefault
            int r0 = r0 + 57
            int r1 = r0 % 128
            com.appsflyer.internal.AFf1cSDK.copy = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1f
            boolean r0 = r3.getMediationNetwork
            r2 = 32
            int r2 = r2 / r1
            r2 = 91
            if (r0 == 0) goto L19
            r0 = 59
            goto L1a
        L19:
            r0 = r2
        L1a:
            if (r0 == r2) goto L31
            goto L23
        L1d:
            r0 = move-exception
            throw r0
        L1f:
            boolean r0 = r3.getMediationNetwork
            if (r0 == 0) goto L31
        L23:
            boolean r0 = r3.component1()
            r2 = 1
            if (r0 != 0) goto L2c
            r0 = r2
            goto L2d
        L2c:
            r0 = r1
        L2d:
            if (r0 == r2) goto L30
            goto L31
        L30:
            return r2
        L31:
            int r0 = com.appsflyer.internal.AFf1cSDK.copydefault
            int r0 = r0 + 109
            int r2 = r0 % 128
            com.appsflyer.internal.AFf1cSDK.copy = r2
            int r0 = r0 % 2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1cSDK.AFAdRevenueData():boolean");
    }

    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) {
        AFf1cSDK aFf1cSDK = (AFf1cSDK) objArr[0];
        aFf1cSDK.AFAdRevenueData = System.currentTimeMillis();
        aFf1cSDK.getMediationNetwork = aFf1cSDK.getRevenue.AFAdRevenueData(aFf1cSDK.getMonetizationNetwork((AFc1pSDK) objArr[1]), aFf1cSDK.getMonetizationNetwork.getRevenue, new AFf1eSDK.AFa1tSDK() { // from class: com.appsflyer.internal.AFf1cSDK.3
            {
                AFf1cSDK.this = aFf1cSDK;
            }

            @Override // com.appsflyer.internal.AFf1eSDK.AFa1tSDK
            public final void AFAdRevenueData(String str, String str2) {
                AFf1cSDK.this.getCurrencyIso4217Code = new ConcurrentHashMap();
                AFf1cSDK.this.getCurrencyIso4217Code.put("signedData", str);
                AFf1cSDK.this.getCurrencyIso4217Code.put(InAppPurchaseMetaData.KEY_SIGNATURE, str2);
                AFf1cSDK.this.component2();
                AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
            }

            @Override // com.appsflyer.internal.AFf1eSDK.AFa1tSDK
            public final void AFAdRevenueData(String str, Exception exc) {
                AFf1cSDK.this.getCurrencyIso4217Code = new ConcurrentHashMap();
                String message = exc.getMessage();
                if (message == null) {
                    message = "unknown";
                }
                AFf1cSDK.this.component2();
                AFf1cSDK.this.getCurrencyIso4217Code.put("error", message);
                AFLogger.afErrorLog(str, exc, true, true, false);
            }
        });
        int i = copy + 107;
        copydefault = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? ' ' : '_') == '_') {
            return null;
        }
        obj.hashCode();
        throw null;
    }

    private long getMonetizationNetwork(AFc1pSDK aFc1pSDK) {
        long monetizationNetwork = AFj1bSDK.getMonetizationNetwork(AFj1bSDK.getMonetizationNetwork(new StringBuilder().append(AFb1jSDK.getRevenue(aFc1pSDK.getMonetizationNetwork)).append(areAllFieldsValid()).toString()));
        int i = copydefault + 41;
        copy = i % 128;
        int i2 = i % 2;
        return monetizationNetwork;
    }

    private long areAllFieldsValid() {
        int i = copydefault + 25;
        copy = i % 128;
        if (!(i % 2 != 0)) {
            return this.AFAdRevenueData;
        }
        int i2 = 66 / 0;
        return this.AFAdRevenueData;
    }

    final void component2() {
        int i = copy + 75;
        copydefault = i % 128;
        int i2 = i % 2;
        this.getCurrencyIso4217Code.put("ttr", Long.valueOf(System.currentTimeMillis() - this.AFAdRevenueData));
        this.getCurrencyIso4217Code.put("lvl_timestamp", Long.valueOf(areAllFieldsValid()));
        int i3 = copy + 11;
        copydefault = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0018, code lost:
        if (com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0028, code lost:
        if ((!com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false)) != true) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x002b, code lost:
        r0 = com.appsflyer.internal.AFf1cSDK.copydefault + 87;
        com.appsflyer.internal.AFf1cSDK.copy = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x003f, code lost:
        if (com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0041, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0043, code lost:
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean getMediationNetwork(android.content.Context r4) {
        /*
            int r0 = com.appsflyer.internal.AFf1cSDK.copydefault
            int r0 = r0 + 83
            int r1 = r0 % 128
            com.appsflyer.internal.AFf1cSDK.copy = r1
            int r0 = r0 % 2
            java.lang.String r1 = "collectAndroidIdForceByUser"
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L1b
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r1, r3)
            if (r0 != 0) goto L41
            goto L2b
        L1b:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r1, r3)
            if (r0 != 0) goto L27
            r0 = r2
            goto L28
        L27:
            r0 = r3
        L28:
            if (r0 == r2) goto L2b
            goto L41
        L2b:
            int r0 = com.appsflyer.internal.AFf1cSDK.copydefault
            int r0 = r0 + 87
            int r1 = r0 % 128
            com.appsflyer.internal.AFf1cSDK.copy = r1
            int r0 = r0 % 2
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "collectIMEIForceByUser"
            boolean r0 = r0.getBoolean(r1, r3)
            if (r0 == 0) goto L43
        L41:
            r0 = r2
            goto L44
        L43:
            r0 = r3
        L44:
            if (r0 != 0) goto L6f
            int r0 = com.appsflyer.internal.AFf1cSDK.copy
            int r0 = r0 + 11
            int r1 = r0 % 128
            com.appsflyer.internal.AFf1cSDK.copydefault = r1
            int r0 = r0 % 2
            r1 = 92
            if (r0 != 0) goto L57
            r0 = 74
            goto L58
        L57:
            r0 = r1
        L58:
            if (r0 != r1) goto L65
            com.appsflyer.internal.AFa1uSDK.getMonetizationNetwork()
            boolean r4 = com.appsflyer.internal.AFa1uSDK.getRevenue(r4)
            if (r4 != 0) goto L64
            goto L6f
        L64:
            return r3
        L65:
            com.appsflyer.internal.AFa1uSDK.getMonetizationNetwork()
            com.appsflyer.internal.AFa1uSDK.getRevenue(r4)
            r4 = 0
            throw r4     // Catch: java.lang.Throwable -> L6d
        L6d:
            r4 = move-exception
            throw r4
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1cSDK.getMediationNetwork(android.content.Context):boolean");
    }

    public final void getRevenue(AFc1pSDK aFc1pSDK) {
        getRevenue(new Object[]{this, aFc1pSDK}, 826598914, -826598912, System.identityHashCode(this));
    }

    public final Map<String, Object> getMonetizationNetwork(Map<String, Object> map) {
        return (Map) getRevenue(new Object[]{this, map}, 855506449, -855506448, System.identityHashCode(this));
    }

    public final boolean getMonetizationNetwork() {
        return ((Boolean) getRevenue(new Object[]{this}, 680071429, -680071429, System.identityHashCode(this))).booleanValue();
    }
}
